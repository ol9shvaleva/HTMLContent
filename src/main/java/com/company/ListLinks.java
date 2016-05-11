package com.company;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListLinks {
    static List<String> result = new ArrayList<String>();
    static List<String> listNoun = new ArrayList<String>();
    static Map<String, Integer> mapNounSort = new HashMap();
    static Map<String, Integer> mapNoun = new HashMap();
    static Map<String, Integer> mapKey = new HashMap();

    static Map<String, Integer> listLinks (String[] args) throws IOException {
        Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = args[0];
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            String str = link.attr("abs:href") + trim(link.text(), 35);
            try {
                ParseContent.parseHtmlPage(str);
            } catch (Exception e) {}

        }

        for (String s : ParseContent.set) {
            try {
                //System.out.println(s);
                listNoun = Tagger.tag(s);
            }
            catch (Exception e) {}
            if (!listNoun.isEmpty()) {
                result.addAll(listNoun);
            }
        }
        //System.out.println(result);

        mapNoun = MapNoun.mapNoun(result);

        for(Map.Entry<String, Integer> entry : mapNoun.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 2 && !key.equals("com") && !key.equals("twitter") && !key.equals("http") &&
                !key.equals("url") && !key.equals("https") && key.length() > 2) {
                mapKey.put(key, value);
            }
        }
        mapNounSort = MapNoun.sortByValue(mapKey);
        System.out.println(mapNounSort);
        return mapKey;

    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}

