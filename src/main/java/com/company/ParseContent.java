package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class ParseContent {
    static HashSet<String> set = new HashSet<String>();

    static String parseHtmlPage (String link) throws IOException {
        String str = "";
        try {
            Document doc = Jsoup.connect(link).get();
            //String [] textValues = new String [] {};
            String h3 = doc.select("h3").text();
            String h2 = doc.select("h2").text();
            String h1 = doc.select("h1").text();
            String h4 = doc.select("h4").text();
            String h5 = doc.select("h5").text();
            String h6 = doc.select("h6").text();
            String p = doc.select("p[class]").text();
            str = h1 + h2 + h3 + h4 + h5 + h6 + p;
            str = str.replaceAll("[^A-Za-z]", " ");
            str = str.toLowerCase();
            set.add(str);
        }
        catch (IOException e) {
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return str;
    }


}
