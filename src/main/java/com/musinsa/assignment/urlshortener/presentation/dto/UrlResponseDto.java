package com.musinsa.assignment.urlshortener.presentation.dto;

import com.musinsa.assignment.urlshortener.domain.Url;
import lombok.Getter;

@Getter
public class UrlResponseDto {
    private String path;
    private String shorten;
    private Boolean sslYn;
    private int count;

    public UrlResponseDto(Url entity){
        this.path = entity.getPath();
        this.shorten = entity.getShorten();
        this.sslYn = entity.getSslYn();
        this.count = entity.getCount();
    }

    public String getRedirectPath(){
        if(this.sslYn){
            return "https://"+this.path;
        }
        return "http://"+this.path;
    }
}
