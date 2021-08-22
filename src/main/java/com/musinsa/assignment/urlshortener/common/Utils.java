package com.musinsa.assignment.urlshortener.common;

import java.util.regex.Pattern;

public class Utils {

    public static boolean isValidPath(String path){
        /* http:// , https:// , 없는경우  3가지 경우의 수 체크 */
        String regex = "^(?:https?:\\/\\/)?(?:www\\.)?[a-zA-Z0-9./]+$";
        return Pattern.compile(regex)
                .matcher(path)
                .matches();
    }

    public static boolean isSslPath(String path){
        String regex = "^(https:\\/\\/)[a-zA-Z0-9./]+$";
        return Pattern.compile(regex)
                .matcher(path)
                .matches();
    }

}
