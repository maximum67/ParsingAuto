package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SpecificationGroup {

    private SpecificationsGroupName specificationsGroupName;

    private List<SpecificationRow> specificationRowList;

    public List<SpecificationRow> getSpecificationRowList() {
        return specificationRowList;
    }

    public SpecificationsGroupName getSpecificationsGroupName() {
        return specificationsGroupName;
    }

    public void setSpecificationsGroupName(SpecificationsGroupName specificationsGroupName) {
        this.specificationsGroupName = specificationsGroupName;
    }

    public void setSpecificationRowList(List<SpecificationRow> specificationRowList) {
        this.specificationRowList = specificationRowList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecificationGroup that = (SpecificationGroup) o;
        return Objects.equals(specificationsGroupName, that.specificationsGroupName) && Objects.equals(specificationRowList, that.specificationRowList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specificationsGroupName, specificationRowList);
    }
}
