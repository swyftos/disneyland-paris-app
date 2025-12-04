package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class ObjectTagging implements Serializable {
    private List tagSet;

    public ObjectTagging(List<Tag> list) {
        this.tagSet = list;
    }

    public List<Tag> getTagSet() {
        return this.tagSet;
    }

    public void setTagSet(List<Tag> list) {
        this.tagSet = list;
    }
}
