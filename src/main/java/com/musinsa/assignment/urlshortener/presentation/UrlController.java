package com.musinsa.assignment.urlshortener.presentation;

import com.musinsa.assignment.urlshortener.application.UrlService;
import com.musinsa.assignment.urlshortener.common.Base62;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/{redirect-path}")
    public RedirectView redirectView(@PathVariable("redirect-path") String redirectPath){
       return new RedirectView(urlService.findByRedirectPath(redirectPath).getRedirectPath());
    }
}
