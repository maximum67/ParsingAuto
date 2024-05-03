package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TechnikalData {

    public static void readTechnikalData(String fileName) throws FileNotFoundException {

        File dir = new File(fileName);
        String PATTERN_1 = "\\{\"[S]{1}\",\"\"},";
        String PATTERN_2 = "\\d{1,2}\\.\\d{1,2}";
        Pattern pattern1 = Pattern.compile(PATTERN_1);
        Pattern pattern2 = Pattern.compile(PATTERN_2);
        Matcher matcher;
        if (dir.isDirectory()) {
            for (File item : Objects.requireNonNull(dir.listFiles())) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \t folder");
                } else {
                    System.out.println(item.getName().replaceAll(".txt", ""));
                    Scanner sc = new Scanner(item);
                    while (sc.hasNext()) {
                        String string1 =sc.nextLine();
                        matcher = pattern1.matcher(string1);
                        if (matcher.find()) {
                            System.out.println(string1);
//                            if(sc.hasNext()) sc.nextLine();
                        }
//                        matcher = pattern2.matcher(sc.nextLine());
//                        if (matcher.find()) {
////                            System.out.println(matcher.group());
//                            if(sc.hasNext()) sc.nextLine();
//                        }
                    }
                }
            }
        }
    }
}
