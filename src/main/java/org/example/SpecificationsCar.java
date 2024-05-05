package org.example;

import java.util.List;

public class SpecificationsCar {

    private String repairCode;

    private List<SpecificationGroup> specificationGroupList;

    public String getRepairCode() {
        return repairCode;
    }

    public void setRepairCode(String repairCode) {
        this.repairCode = repairCode;
    }

    public List<SpecificationGroup> getSpecificationGroupList() {
        return specificationGroupList;
    }

    public void setSpecificationGroupList(List<SpecificationGroup> specificationGroupList) {
        this.specificationGroupList = specificationGroupList;
    }
    public Integer getSpecificationGroupListSize(){
        return this.specificationGroupList.size();
    }
}
