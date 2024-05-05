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
        return specificationRowList;
    }

    public List<SpecificationRow> getSpecificationRowListOrEmpty(){
        if (getSpecificationRowList().isEmpty()){
           return getSpecificationRowList();
        }else{
            return new LinkedList<>();
        }
    }

    public void setSpecificationRowList(List<SpecificationRow> specificationRowList) {
        this.specificationRowList = specificationRowList;
    }
    public Integer getSpecificationRowListSize(){
        return this.getSpecificationRowList().size();
    }
}
