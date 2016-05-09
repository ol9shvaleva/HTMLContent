package com.company;

import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Tagger {
    public static Map<String, Integer> tag(String str) {
        final List<String> tagLemme = new ArrayList<String>();
        str = str.replaceAll("[^A-Za-z]", " ").toLowerCase();
        String[] tokens = str.split(" ");
        final Map<String, Integer> mapNoun = new HashMap();

        TreeTaggerWrapper tt = new TreeTaggerWrapper();
        System.setProperty("treetagger.home", "C:/TreeTagger");
        try {
            tt.setModel("/english-utf8.par");

            tt.setHandler(new TokenHandler() {
                public void token(Object token, String pos, String lemma) {
                    //System.out.println(token + "\t" + pos + "\t" + lemma);
                    if (pos.charAt(0) == 'N') {
                        //System.out.print(lemma);
                        //System.out.println(pos);
                        if (mapNoun.get(lemma) == null) {
                            mapNoun.put(lemma, 1);
                        }
                        else {
                            int value = mapNoun.get(lemma);
                            mapNoun.put(lemma, value + 1);
                        }
                    }
                }
            });
            tt.process(asList(tokens)); // words = list of words

        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        } catch (TreeTaggerException e) {
            e.printStackTrace();
        } finally {
            tt.destroy();
        }
        System.out.println(mapNoun);
        return mapNoun;
    }
}
