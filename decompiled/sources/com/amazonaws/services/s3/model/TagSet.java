package com.amazonaws.services.s3.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TagSet {
    private Map tags;

    public TagSet() {
        this.tags = new HashMap(1);
    }

    public TagSet(Map<String, String> map) {
        HashMap map2 = new HashMap(1);
        this.tags = map2;
        map2.putAll(map);
    }

    public String getTag(String str) {
        return (String) this.tags.get(str);
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public Map<String, String> getAllTags() {
        return this.tags;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("Tags: " + getAllTags());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
