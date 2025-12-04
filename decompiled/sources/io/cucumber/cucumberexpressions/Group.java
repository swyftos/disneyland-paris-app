package io.cucumber.cucumberexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class Group {
    private final List children;
    private final int end;
    private final int start;
    private final String value;

    public Group(String str, int i, int i2, List<Group> list) {
        this.value = str;
        this.start = i;
        this.end = i2;
        this.children = list;
    }

    public String getValue() {
        return this.value;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public List<Group> getChildren() {
        return this.children;
    }

    public List<String> getValues() {
        ArrayList arrayList = new ArrayList();
        Iterator<Group> it = (getChildren().isEmpty() ? Collections.singletonList(this) : getChildren()).iterator();
        while (it.hasNext()) {
            String value = it.next().getValue();
            if (value != null) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }
}
