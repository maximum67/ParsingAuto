package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){

        String[] strings = new String[5];
        strings[0]  = "AUDI / A3/A3 SPORTBACK (8PA/8P1)  (03-13) / 1,2 TSI / CBZB 77 kW (105 л.с.) 5000 об/мин R-Cat 2010-2013";
        strings[1]  = "AUDI / A6 QUATTRO (4GC/4GD)  (14-18) / 2,0 TFSI / CYNB 185 kW (252 л.с.) 4900 об/мин R-Cat 2014-2018";
        strings[2]  = "AUDI / S3/S3 SPORTBACK (8VK/8VF)  (16-20) / 2,0 TFSI / DJHA 228 kW (310 л.с.) 5500 об/мин R-Cat 2016-2018";
        strings[3]  = "BMW / 3 SERIES (E90/91/92/93)  (05-14) / 2,0D 316d / N47 D20A/U0 85 kW (116 л.с.) 4000 об/мин 2009-2012";
        strings[4]  = "FORD / C-MAX ('11) / 1,6D TDCi / UBJA 66 kW (90 л.с.) 3600 об/мин 2011-2015";
        Parser.parsingString(strings);
    }
}
