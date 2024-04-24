package org.example;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsingFile {

    public static void readFile(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        String PATTERN_1 = "([A-z]*[А-Я]*[а-я*\\/*\\(?а-я*\\)?\\-?а-я*]*\\,*\\s)+(\\s*\\(?[A-z\\-*\\+*]\\d*\\s*\\)?\\-*\\/?)*([А-Я]?[\\d*а-я*\\(?а-я*\\/*\\)?\\-?а-я*]*\\.*\\,*\\s*)*(\\s*\\(?[A-z\\-*\\+*]\\s*\\)?\\-*\\/?)*";
        String PATTERN_2 = "(\\(?((ABS)|(ESP)|(T)|[А-Я])+\\d*\\.?\\)?\\,*\\/?\\s*)+";
        String PATTERN_3 = "[A-Z]{1}\\d{1,2}\\.\\d{4}";
        int i = 0;
        Pattern pattern1 = Pattern.compile(PATTERN_1);
        Pattern pattern2 = Pattern.compile(PATTERN_2);
        Pattern pattern3 = Pattern.compile(PATTERN_3);
        Matcher matcher;
        while (i<=6082) {
             matcher = pattern1.matcher(sc.nextLine());
            if (matcher.find()) {
//                System.out.println(matcher.group());  // Выводит: подстрокой
            }
            matcher = pattern2.matcher(sc.nextLine());
            if (matcher.find()) {
//                System.out.println(matcher.group());  // Выводит: подстрокой
            }
            matcher = pattern3.matcher(sc.nextLine());
            if (matcher.find()) {
//                System.out.println(matcher.group());  // Выводит: подстрокой
            }
            i++;
        }
    }

    public static void readFileGroup(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        String PATTERN = "(\\(?((ABS)|(ESP)|(T)|[А-Я])+\\d*\\.?\\)?\\,*\\/?\\s*)+";
        int i = 0;
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher;
        while (i<=182) {
            matcher = pattern.matcher(sc.nextLine().replaceAll("Услуга","услуга"));
            if (matcher.find()) {
                System.out.println(matcher.group());  // Выводит: подстрокой
            }
            matcher = pattern.matcher(sc.nextLine().replaceAll("Услуга","услуга"));
            if (matcher.find()) {
                System.out.println(matcher.group());  // Выводит: подстрокой
            }
            i++;
        }
    }
}