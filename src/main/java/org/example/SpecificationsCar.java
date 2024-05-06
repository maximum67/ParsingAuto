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
        if (specificationGroupList == null) {
          return new LinkedList<>();
        } else {
            return specificationGroupList;
        }
    }

    public void setSpecificationGroupList(List<SpecificationGroup> specificationGroupList) {
        this.specificationGroupList = specificationGroupList;
    }

    @Override
    public String toString() {
        return "SpecificationsCar{" +
                "repairCode='" + repairCode + '\'' + "\n"+
                ", specificationGroupList=" + specificationGroupList +"\n"+
                '}';
    }
}
