package com.company;

import org.annolab.tt4j.TokenHandler;
import org.annolab.tt4j.TreeTaggerException;
import org.annolab.tt4j.TreeTaggerWrapper;
import org.jsoup.HttpStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {


    public static void main(String[] args) {
        String [] list = new String [] {"http://www.onenote.com/"};
        try {
            ListLinks.listLinks(list);
        }
        catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
    }
}
