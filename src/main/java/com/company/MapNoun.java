package com.company;

import java.util.*;

public class MapNoun {

    final static Map<String, Integer> mapNoun = new HashMap();
    static Map<String, Integer> mapNounSort = new HashMap();

    public static Map<String, Integer> mapNoun(List<String> listNoun) {

        for (String noun : listNoun) {
            if (mapNoun.get(noun) == null) {
                mapNoun.put(noun, 1);
            }
            else {
                int value = mapNoun.get(noun);
                mapNoun.put(noun, value + 1);
            }
        }

        mapNounSort = sortByValue(mapNoun);
        //System.out.println(mapNounSort);
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
