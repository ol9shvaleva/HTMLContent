package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Оленька on 08.05.2016.
 *
 */
class ParseContent {
    static List<String> parseHtmlPage (String link) throws IOException {
        List<String> listNoun = new ArrayList<String>();
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
            //System.out.println(h3 + "\n" + h2 + "\n" + h1 + "\n" + h4 + "\n" + h5 + "\n" + h6 + "\n" + p);
            listNoun = Tagger.tag(h3 + h2 + h1 + h4 + h5 + h6 + p);
        }
        catch (IOException e) {
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return listNoun;
    }


}
