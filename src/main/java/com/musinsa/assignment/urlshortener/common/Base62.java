package com.musinsa.assignment.urlshortener.common;

public class Base62 {

    final int RADIX = 62;
    final String CODEC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public String encode(long input) {
        StringBuffer sb = new StringBuffer();
        while(input > 0) {
            sb.append(CODEC.charAt((int) (input % RADIX)));
            input /= RADIX;
        }
        return sb.toString();
    }

    public Long decode(String input){
        long result = 0;
        long power = 1;
        for (int i = 0; i < input.length(); i++) {
            result += CODEC.indexOf(input.charAt(i)) * power;
            power *= RADIX;
        }
        return result;
    }

    public boolean isBase62Encoding(String charter) {
        byte[] bytes = charter.getBytes();
        if (bytes == null) {
            return false;
        }
        for (final byte e : bytes) {
            if ('0' > e || '9' < e) {
                if ('a' > e || 'z' < e) {
                    if ('A' > e || 'Z' < e) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
