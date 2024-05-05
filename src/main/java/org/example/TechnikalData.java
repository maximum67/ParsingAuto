package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TechnikalData {

    public static void readTechnikalData(String fileName) throws FileNotFoundException {

        File dir = new File(fileName);
        String PATTERN_1 = "\\{\"[S]{1}\",\"";
        String PATTERN_2 = "\"},\\d*}*,*";
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
                    int i = 1;
                    List<String> listResult = new LinkedList<>();
                    StringBuilder stringBuilder = new StringBuilder();
                    SpecificationsCar specificationsCar = new SpecificationsCar();
                    specificationsCar.setRepairCode(item.getName().replaceAll(".txt", ""));
                    specificationsCar.setSpecificationGroupList(new LinkedList<>());
                    while (sc.hasNext()) {
                        String string1 = sc.nextLine();
                        String string2 = ";";
                        matcher = pattern1.matcher(string1);
                        if (matcher.find()) {
//                            System.out.println(string1);
                            String string = string1.replaceAll(String.valueOf(pattern1), "")
                                    .replaceAll(String.valueOf(pattern2), "") + ";";
                            if (string.equals(string2)) {
//                                System.out.print("$");
                                stringBuilder.append("$;");
                            } else {
//                                System.out.print(string);
                                stringBuilder.append(string);
                            }
                            if (i % 3 == 0) {
//                                System.out.println();
                                stringBuilder.append("\n");
                            }
                            i++;
                        }
//                        matcher = pattern2.matcher(sc.nextLine());
//                        if (matcher.find()) {
////                            System.out.println(matcher.group());
//                            if(sc.hasNext()) sc.nextLine();
//                        }
                    }
                    listResult = Arrays.asList(stringBuilder.toString().split("\n"));

                    for (String s : listResult) {
//                        System.out.println(s);
                        if (s.contains(";$;$;")) {
                            SpecificationGroup specificationGroup = new SpecificationGroup();
                            specificationGroup.setHeaderGroup(s.replaceAll(";$;$;", ""));
                            specificationsCar.getSpecificationGroupList().add(specificationGroup);
                        } else {
                            String[] strings = s.split(";");
                            if (specificationsCar.getSpecificationGroupList().isEmpty()) {
                                SpecificationRow specificationRow = new SpecificationRow();
                                specificationRow.setSpecificationName(strings[0]);
                                specificationRow.setSpecificationUnit(strings[1]);
                                specificationRow.setSpecificationValue(strings[2]);
                                SpecificationGroup specificationGroup = new SpecificationGroup();
                                specificationGroup.getSpecificationRowList().add(specificationRow);
                                specificationsCar.getSpecificationGroupList().add(specificationGroup);
                            } else {
                                SpecificationGroup specificationGroup = specificationsCar
                                        .getSpecificationGroupList().get(specificationsCar.getSpecificationGroupListSize() - 1);
                                if (specificationGroup.getSpecificationRowList().isEmpty()) {
                                    SpecificationRow specificationRow = new SpecificationRow();
                                    specificationRow.setSpecificationName(strings[0]);
                                    specificationRow.setSpecificationUnit(strings[1]);
                                    specificationRow.setSpecificationValue(strings[2]);
                                    specificationGroup.getSpecificationRowList().add(specificationRow);
                                    specificationsCar.getSpecificationGroupList().add(specificationGroup);
                                } else {
                                    SpecificationRow specificationRow = specificationGroup.getSpecificationRowList()
                                            .get(specificationGroup.getSpecificationRowListSize() - 1);
                                    specificationRow.setSpecificationName(strings[0]);
                                    specificationRow.setSpecificationUnit(strings[1]);
                                    specificationRow.setSpecificationValue(strings[2]);
                                    specificationGroup.getSpecificationRowList().add(specificationRow);
                                    specificationsCar.getSpecificationGroupList().add(specificationGroup);
                                }
                            }
                        }
                    }
                    System.out.println(specificationsCar.getRepairCode());
                    for (SpecificationGroup sg : specificationsCar.getSpecificationGroupList()) {
                        System.out.println(sg.getHeaderGroup());
                        for (SpecificationRow sr : sg.getSpecificationRowList()) {
                            System.out.println(sr.getSpecificationName() + " "
                                    + sr.getSpecificationUnit() + " "
                                    + sr.getSpecificationValue());
                        }
                    }
                }
            }
        }
    }
}
