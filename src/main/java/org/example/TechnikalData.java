package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TechnikalData {

    public static List<SpecificationsGroupName> readeGroup(String fileName) throws FileNotFoundException {
        File dir = new File(fileName);
        List<SpecificationsGroupName> specificationsGroupNameList = new ArrayList<>();
        if (dir.isDirectory()) {
            for (File item : Objects.requireNonNull(dir.listFiles())) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \t folder");
                } else {
//                    System.out.println(item.getName() + "  \t file");
                    Scanner sc = new Scanner(item, "UTF-8");
                    while (sc.hasNextLine()) {
                        String string = sc.nextLine();
//                        System.out.println(string);
                        if (specificationsGroupNameList.isEmpty() || specificationsGroupNameList.stream().noneMatch(s -> s.getName().equals(string))) {
                            SpecificationsGroupName specificationsGroupName = new SpecificationsGroupName();
                            specificationsGroupName.setName(string.trim());
                            specificationsGroupNameList.add(specificationsGroupName);
                        }
                    }
                }

           }
        }
        return specificationsGroupNameList;
    }

    public static void readTechnikalData(String fileName, List<SpecificationsGroupName> specificationsGroupNameList) throws FileNotFoundException {

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
//                    System.out.println(item.getName().replaceAll(".txt", ""));
                    Scanner sc = new Scanner(item,"UTF-8");
                    int i = 1;
                    List<String> listResult = new LinkedList<>();
                    StringBuilder stringBuilder = new StringBuilder();
                    SpecificationsCar specificationsCar = new SpecificationsCar();
                    specificationsCar.setRepairCode(item.getName().replaceAll(".txt", ""));

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
                                stringBuilder.append("*;");
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
                    List<String> groupNameList = specificationsGroupNameList.stream().map(SpecificationsGroupName::getName).collect(Collectors.toList());

                    for (String s : listResult) {
                        System.out.println(s);
                        if (s.equals("Головка блока цилиндров;*;*;") || s.equals("Другие моменты затяжки (двигатель);*;*;")){
                            s = s.replaceAll("\\*"," ");
                        }
                        if (s.contains(";*;*;")) {
                            s = s.replaceAll(";\\*;\\*;","");
                        }
                        String[] strings = s.split(";");
                        if (groupNameList.contains(s)) {
                            String finalS = s;
                            SpecificationsGroupName specificationsGroupName = specificationsGroupNameList.stream().filter(sGName -> sGName.getName().equals(finalS)).findFirst().get();
                            SpecificationGroup specificationGroup = new SpecificationGroup();
//                            if (specificationsCar.getSpecificationGroupList().stream()
//                                    .map(SpecificationGroup::getSpecificationsGroupName)
//                                    .map(SpecificationsGroupName::getName).collect(Collectors.toList()).contains(s)){
//                              specificationGroup = specificationsCar.getSpecificationGroupList().stream()
//                                    .filter(sg -> sg.getSpecificationsGroupName().getName().equals(finalS)).findFirst().get();
//                            }
                            if (specificationsCar.getSpecificationGroupList().isEmpty()) {
                                List<SpecificationGroup> specificationGroupList = new ArrayList<>();
                                specificationGroup.setSpecificationsGroupName(specificationsGroupName);
                                specificationGroupList.add(specificationGroup);
                                specificationsCar.setSpecificationGroupList(specificationGroupList);
                            } else if (!specificationsCar.getSpecificationGroupList().stream()
                                    .map(SpecificationGroup::getSpecificationsGroupName)
                                    .map(SpecificationsGroupName::getName).collect(Collectors.toList()).contains(s)) {
                                specificationGroup.setSpecificationsGroupName(specificationsGroupName);
                                specificationsCar.getSpecificationGroupList().add(specificationGroup);
                            }
//                            else {
//                                specificationGroup = specificationsCar.getSpecificationGroupList().stream()
//                                        .filter(sg -> sg.getSpecificationsGroupName().getName().equals(finalS)).findFirst().get();
//                            }
                        } else if (strings.length == 3) {
                            SpecificationRow specificationRow = new SpecificationRow();
                            specificationRow.setSpecificationName(strings[0].replaceAll("\\*", " ").trim());
                            specificationRow.setSpecificationUnit(strings[1].replaceAll("\\*", " ").trim());
                            specificationRow.setSpecificationValue(strings[2].replaceAll("\\*", " ").trim());

                            if (specificationsCar.getSpecificationGroupList().isEmpty()) {
                                List<SpecificationRow> specificationRowList = new ArrayList<>();
                                specificationRowList.add(specificationRow);
                                SpecificationGroup specificationGroup = new SpecificationGroup();
                                specificationGroup.setSpecificationRowList(specificationRowList);
                                List<SpecificationGroup> specificationGroupList = new ArrayList<>();
                                specificationGroupList.add(specificationGroup);
                                specificationsCar.setSpecificationGroupList(specificationGroupList);
                            } else {
                                List<SpecificationGroup> specificationGroupList = specificationsCar.getSpecificationGroupList();
                                SpecificationGroup specificationGroup1 = specificationsCar.getSpecificationGroupList().get(specificationGroupList.size() - 1);
                                if (specificationGroup1.getSpecificationRowList() == null) {
                                    List<SpecificationRow> specificationRowList = new ArrayList<>();
                                    specificationRowList.add(specificationRow);
                                    specificationsCar.getSpecificationGroupList().get(specificationGroupList.size() - 1).setSpecificationRowList(specificationRowList);
                                } else {
//                                    System.out.println(specificationsCar.getSpecificationGroupList().get(specificationGroupList.size() - 1).getHeaderGroup());
                                    specificationsCar.getSpecificationGroupList().get(specificationGroupList.size() - 1).getSpecificationRowList().add(specificationRow);
                                    SpecificationRow sr1 = specificationsCar.getSpecificationGroupList()
                                            .get(specificationGroupList.size() - 1)
                                            .getSpecificationRowList().get(specificationsCar.getSpecificationGroupList()
                                                    .get(specificationGroupList.size() - 1).getSpecificationRowList().size() - 1);
//                                    System.out.println(sr1.getSpecificationName() + " "
//                                            + sr1.getSpecificationUnit() + " "
//                                            + sr1.getSpecificationValue());
                                }
                            }
                        }
                    }
//                    System.out.println(specificationsCar);
//                    System.out.println(specificationsCar.getRepairCode());
                    List<SpecificationGroup> specificationGroupList = specificationsCar.getSpecificationGroupList();
                    for (SpecificationGroup sg : specificationGroupList) {
                        System.out.println(sg.getSpecificationsGroupName().getName()+"___________________Группа");
                        List<SpecificationRow> specificationRowList = sg.getSpecificationRowList();
                        for (SpecificationRow sr : specificationRowList) {
                            System.out.println(sr.getSpecificationName() + "  "
                                    + sr.getSpecificationUnit() + "  "
                                    + sr.getSpecificationValue());
                        }
                    }
                }
            }
        }
    }
}
