package com.amazonaws.services.s3.model.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class InventoryConfiguration implements Serializable {
    private InventoryDestination destination;
    private String id;
    private String includedObjectVersions;
    private InventoryFilter inventoryFilter;
    private Boolean isEnabled;
    private List optionalFields;
    private InventorySchedule schedule;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public InventoryConfiguration withId(String str) {
        setId(str);
        return this;
    }

    public InventoryDestination getDestination() {
        return this.destination;
    }

    public void setDestination(InventoryDestination inventoryDestination) {
        this.destination = inventoryDestination;
    }

    public InventoryConfiguration withDestination(InventoryDestination inventoryDestination) {
        setDestination(inventoryDestination);
        return this;
    }

    public Boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(Boolean bool) {
        this.isEnabled = bool;
    }

    public InventoryConfiguration withEnabled(Boolean bool) {
        setEnabled(bool);
        return this;
    }

    public InventoryFilter getInventoryFilter() {
        return this.inventoryFilter;
    }

    public void setInventoryFilter(InventoryFilter inventoryFilter) {
        this.inventoryFilter = inventoryFilter;
    }

    public InventoryConfiguration withFilter(InventoryFilter inventoryFilter) {
        setInventoryFilter(inventoryFilter);
        return this;
    }

    public String getIncludedObjectVersions() {
        return this.includedObjectVersions;
    }

    public void setIncludedObjectVersions(String str) {
        this.includedObjectVersions = str;
    }

    public InventoryConfiguration withIncludedObjectVersions(String str) {
        setIncludedObjectVersions(str);
        return this;
    }

    public void setIncludedObjectVersions(InventoryIncludedObjectVersions inventoryIncludedObjectVersions) {
        setIncludedObjectVersions(inventoryIncludedObjectVersions == null ? null : inventoryIncludedObjectVersions.toString());
    }

    public InventoryConfiguration withIncludedObjectVersions(InventoryIncludedObjectVersions inventoryIncludedObjectVersions) {
        setIncludedObjectVersions(inventoryIncludedObjectVersions);
        return this;
    }

    public List<String> getOptionalFields() {
        return this.optionalFields;
    }

    public void setOptionalFields(List<String> list) {
        this.optionalFields = list;
    }

    public InventoryConfiguration withOptionalFields(List<String> list) {
        setOptionalFields(list);
        return this;
    }

    public void addOptionalField(String str) {
        if (str == null) {
            return;
        }
        if (this.optionalFields == null) {
            this.optionalFields = new ArrayList();
        }
        this.optionalFields.add(str);
    }

    public void addOptionalField(InventoryOptionalField inventoryOptionalField) {
        addOptionalField(inventoryOptionalField == null ? null : inventoryOptionalField.toString());
    }

    public InventorySchedule getSchedule() {
        return this.schedule;
    }

    public void setSchedule(InventorySchedule inventorySchedule) {
        this.schedule = inventorySchedule;
    }

    public InventoryConfiguration withSchedule(InventorySchedule inventorySchedule) {
        setSchedule(inventorySchedule);
        return this;
    }
}
