package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Maria on 12.05.2016.
 *
 */
public class NGramm {
    private List<String> keyWords;

    private Map <String, Integer> allNGramms = new HashMap<String, Integer>();

    public NGramm (List<String> keyWords) {
        this.keyWords = keyWords;
        getAllNGramms(keyWords);
    }

    public void getAllNGramms (List<String> keyWords) {
        for (String keyWord: keyWords) {
            for (String string : ParseContent.set) {
                String str = string.toLowerCase();
                while (str.contains(keyWord)) {
                    int start = str.indexOf(keyWord);
                    int end = start + keyWord.length();
                    addToNGrammMap(LeftNGramm.getLeftNGramm(str.substring(0, start), keyWord));
                    addToNGrammMap(RightNGramm.getRightNGramm(str.substring(end), keyWord));
                    str = str.substring(end);
                }
            }
        }
    }

    private void addToNGrammMap (String nGramm) {
        if (nGramm != null && !nGramm.contains("http") && !nGramm.contains("twitter")) {
            if (allNGramms.get(nGramm) == null) {
                allNGramms.put(nGramm, 1);
            } else {
                int value = allNGramms.get(nGramm);
                allNGramms.put(nGramm, value + 1);
            }
        }
    }

    public void printAllNGramms () {
        System.out.println(allNGramms);
    }


}
