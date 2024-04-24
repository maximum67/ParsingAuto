package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParsingFolder {

    public void parsingFolder(String fileName) throws FileNotFoundException {

    File file = new File(fileName);
    Scanner sc = new Scanner(file);

    while(sc.hasNext()){ }
    }
}
