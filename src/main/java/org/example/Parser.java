package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parser {

    public static void parsingString(String[] strings){


        List<String> listMark = new LinkedList<>();
        List<String> listModel = new LinkedList<>();
        List<String> listEngineType = new LinkedList<>();
        List<String> listModification = new LinkedList<>();

        for (String string : strings) {
            List<String> list = new LinkedList<>();
            string = string.replaceAll(" / ", "*");
            list.addAll(Arrays.asList(string.split("\\*")));
            listMark.add(list.get(0));
            listModel.add(list.get(1));
            listEngineType.add(list.get(2));
            listModification.add(list.get(3));
        }
        listMark.forEach(System.out::println);
        System.out.println();
        listModel.forEach(System.out::println);
        System.out.println();
        listEngineType.forEach(System.out::println);
        System.out.println();
        listModification.forEach(System.out::println);
        System.out.println();
    }
}
