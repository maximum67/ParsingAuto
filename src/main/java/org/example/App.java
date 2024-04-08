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

        ParsingFile parsingFile = new ParsingFile();
        Map<Integer, List<String>> map = parsingFile.read("test.xlsx");
        List<String> resultList = new LinkedList<>();
        map.entrySet().forEach(m-> resultList.add(m.getValue().get(1)));
        Parser.parsingString(resultList);
    }

}
