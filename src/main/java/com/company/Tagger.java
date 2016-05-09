package com.company;

import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;

import java.io.IOException;
import java.util.*;

import static java.util.Arrays.asList;

public class Tagger {
    public static List<String> tag(String str) {
        final List<String> tagLemme = new ArrayList<String>();
        str = str.replaceAll("[^A-Za-z]", " ").toLowerCase();
        String[] tokens = str.split(" ");
        final List<String> listNoute = new ArrayList<String>();

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
                        listNoute.add(lemma);

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

        return listNoute;
    }


}
