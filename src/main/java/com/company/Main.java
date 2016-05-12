package com.company;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Main {
    private static List<String> oneNoteKeyWords = Arrays.asList("office","note","microsoft","Ms","device","document","word","web","notebook","account","lens","user","email");
    private static List <String> everNoteKeyWords = Arrays.asList("premium", "account", "note", "business", "company");
    public static void main(String[] args) {
        String [] list = new String [] {"https://onenote.com/"};

        try {
            ListLinks.listLinks(list);
            NGramm oneNote = new NGramm(oneNoteKeyWords);
            oneNote.printAllNGramms();
            NGramm everNote = new NGramm(everNoteKeyWords);
            //everNote.printAllNGramms();
        }
        catch (IOException e) {
            e.getMessage();
        }
    }
}
