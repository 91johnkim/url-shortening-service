package com.musinsa.assignment.urlshortener.application;

import com.musinsa.assignment.urlshortener.common.Base62;
import com.musinsa.assignment.urlshortener.domain.Url;
import com.musinsa.assignment.urlshortener.domain.UrlRepository;
import com.musinsa.assignment.urlshortener.exception.NotValidException;
import com.musinsa.assignment.urlshortener.presentation.dto.UrlRequestDto;
import com.musinsa.assignment.urlshortener.presentation.dto.UrlResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlResponseDto findById(Long id){
        Url url =  urlRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당하는 값이 없습니다 id="+id));
        return new UrlResponseDto(url);
    }

    public List<UrlResponseDto> findAll(){
        return urlRepository.findAll().stream().map(obj-> new UrlResponseDto(obj)).toList();
    }

    public UrlResponseDto findByRedirectPath(String redirectPath){
        Base62 base62 = new Base62();
        if(!base62.isBase62Encoding(redirectPath)){
            throw new NotValidException("유효하지 않은 리다이렉트 path 입니다");
        }
        return findById(base62.decode(redirectPath));
    }

    @Transactional
    public UrlResponseDto convertShortenPath(UrlRequestDto urlRequestDto) {

        Url url = urlRequestDto.toEntity();
        if(!url.isValidPath()){
            throw new NotValidException("url이 유효하지 않습니다");
        }

        url = urlRepository.findByPathAndSslYn(url.getPath(), url.getSslYn()).orElse(urlRequestDto.toEntity());
        if(url.getId() != null){
            url.increaseCount();
        }

        Long id = urlRepository.save(url).getId();
        return findById(id);
    }

}
