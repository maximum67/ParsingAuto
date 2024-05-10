package org.example;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
//        ParsingFile.readFile("6_ЭлементыРемонтныхРабот.txt");
        List<SpecificationsGroupName> specificationsGroupNameList = TechnikalData.readeGroup("Группы технических данных");
//        specificationsGroupNameList.forEach(s->System.out.println(s.getName()));
        TechnikalData.readTechnikalData("ReparDatas",specificationsGroupNameList );
    }
}
