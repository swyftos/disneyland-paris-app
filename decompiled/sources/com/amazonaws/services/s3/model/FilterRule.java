package com.amazonaws.services.s3.model;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class FilterRule implements Serializable {
    private String name;
    private String value;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("FilterRule Name is a required argument");
        }
        this.name = str;
    }

    public FilterRule withName(String str) {
        setName(str);
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public FilterRule withValue(String str) {
        setValue(str);
        return this;
    }
}
