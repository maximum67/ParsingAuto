package org.example;

import java.util.LinkedList;
import java.util.List;

public class SpecificationGroup {

    private String headerGroup="";

    private List<SpecificationRow> specificationRowList;

    public String getHeaderGroup() {
        return headerGroup;
    }

    public void setHeaderGroup(String headerGroup) {
        this.headerGroup = headerGroup;
    }

    public List<SpecificationRow> getSpecificationRowList() {
        if (specificationRowList == null) {
            return new LinkedList<>();
        } else {
            return specificationRowList;
        }
    }

    public void setSpecificationRowList(List<SpecificationRow> specificationRowList) {
        this.specificationRowList = specificationRowList;
    }
    public Integer getSpecificationRowListSize(){
        return this.getSpecificationRowList().size();
    }

    @Override
    public String toString() {
        return "SpecificationGroup{" +
                "headerGroup='" + headerGroup + '\'' +"\n"+
                ", specificationRowList=" + specificationRowList +"\n"+
                '}';
    }
}
