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
//        String PATTERN_1 = "^([A-Z]{1}\\d{1}\\.\\d{4})";
        String PATTERN_1 = "[^([\\w{1}\\d{1}.{4}])]";
        int i = 0;
        String string = "";
        String vendor = "";
        while (i<=38) {
            String str = sc.nextLine();
            System.out.println(str.replaceAll(PATTERN_1,""));
            vendor = string.replaceAll(PATTERN_1,"");
       //     System.out.println(vendor);
            string = "";
            i++;
        }
    }
}