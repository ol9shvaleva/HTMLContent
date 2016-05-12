package com.company;

/**
 * Created by Maria on 12.05.2016.
 *
 */
public class RightNGramm {
    public static String getRightNGramm (String substring, String keyWord) {
        StringBuilder sb = new StringBuilder(keyWord);
        String [] params;
        if (substring != null) {
            params = substring.split(" ");
            if (params.length >= 4) sb.append(" ").append(params[0]).append(" ").append(params[1]).append(" ").append(params[2]).append(" ").append(params[3]);
            else if (params.length == 3) sb.append(" ").append(params[0]).append(" ").append(params[1]).append(" ").append(params[2]);
            if (params.length == 2) sb.append(" ").append(params[0]).append(" ").append(params[1]);
            else if (params.length == 1) sb.append(" ").append(params[0]);
            sb.append(" ").append(keyWord);
            return sb.toString();
        }
        else return null;
    }
}
