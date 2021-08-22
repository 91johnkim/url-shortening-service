package com.musinsa.assignment.urlshortener.presentation;

import com.musinsa.assignment.urlshortener.application.UrlService;
import com.musinsa.assignment.urlshortener.presentation.dto.UrlRequestDto;
import com.musinsa.assignment.urlshortener.presentation.dto.UrlResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/url-shortener")
public class UrlShortenerApiController {

    private final UrlService urlService;

    @GetMapping("/list")
    public List<UrlResponseDto> list(){
        return urlService.findAll();
    }

    @PostMapping()
    public UrlResponseDto convertShortenPath(@RequestBody UrlRequestDto urlRequestDto){
        return urlService.convertShortenPath(urlRequestDto);
    }
}
