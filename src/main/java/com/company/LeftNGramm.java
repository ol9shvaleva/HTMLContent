package com.company;

/**
 * Created by User on 12.05.2016.
 *
 */
public class LeftNGramm {
    public static String getLeftNGramm (String substring, String keyWord) {
        StringBuilder sb = new StringBuilder();
        String [] params;
        if (substring != null) {
            params = substring.split(" ");
            if (params.length >= 4) {
                sb.append(" ").append(params[params.length - 4]).append(" ").append(params[params.length - 3]).append(" ").append(params[params.length - 2]).append(" ").append(params[params.length - 1]);
            }
            else if (params.length == 3) {
                sb.append(" ").append(params[params.length - 3]).append(" ").append(params[params.length - 2]).append(" ").append(params[params.length - 1]);

            }
            else if (params.length == 2) {
                sb.append(" ").append(params[params.length - 2]).append(" ").append(params[params.length - 1]);

            }
            else if (params.length == 1) {
                sb.append(" ").append(params[params.length - 1]);

            }
            sb.append(" ").append(keyWord);
            return sb.toString();
        }
        else return null;
    }
}
