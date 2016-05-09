package com.company;

import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;

import java.io.IOException;
import java.util.*;

import static java.util.Arrays.asList;

public class Tagger {
    public static Map<String, Integer> tag(String str) {
        final List<String> tagLemme = new ArrayList<String>();
        str = str.replaceAll("[^A-Za-z]", " ").toLowerCase();
        String[] tokens = str.split(" ");
        final Map<String, Integer> mapNoun = new HashMap();
        Map<String, Integer> mapNounSort = new HashMap();

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
        mapNounSort = sortByValue(mapNoun);
        System.out.println(mapNounSort);
        return mapNounSort;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map )
    {
        List<Map.Entry<K, V>> list =
                new LinkedList(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2)
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
