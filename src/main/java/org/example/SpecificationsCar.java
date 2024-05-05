package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    public List<SpecificationGroup> getSpecificationGroupListOrEmpty() {
        if (getSpecificationGroupList().isEmpty()) {
            return new LinkedList<>();
        } else {
            return getSpecificationGroupList();
        }
    }
        public void setSpecificationGroupList (List < SpecificationGroup > specificationGroupList) {
            this.specificationGroupList = specificationGroupList;
        }

}
