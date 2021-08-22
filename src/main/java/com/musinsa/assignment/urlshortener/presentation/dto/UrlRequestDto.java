package com.musinsa.assignment.urlshortener.presentation.dto;

import com.musinsa.assignment.urlshortener.domain.Url;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UrlRequestDto {
    private String path;

    public Url toEntity(){
        return Url.builder()
                .path(path)
                .build();
    }

}
