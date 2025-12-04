package io.cucumber.cucumberexpressions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

/* loaded from: classes5.dex */
class GroupBuilder {
    private String source;
    private List groupBuilders = new ArrayList();
    private boolean capturing = true;

    GroupBuilder() {
    }

    void add(GroupBuilder groupBuilder) {
        this.groupBuilders.add(groupBuilder);
    }

    Group build(Matcher matcher, Iterator it) {
        int iIntValue = ((Integer) it.next()).intValue();
        ArrayList arrayList = new ArrayList(this.groupBuilders.size());
        Iterator it2 = this.groupBuilders.iterator();
        while (it2.hasNext()) {
            arrayList.add(((GroupBuilder) it2.next()).build(matcher, it));
        }
        return new Group(matcher.group(iIntValue), matcher.start(iIntValue), matcher.end(iIntValue), arrayList);
    }

    void setNonCapturing() {
        this.capturing = false;
    }

    boolean isCapturing() {
        return this.capturing;
    }

    public void moveChildrenTo(GroupBuilder groupBuilder) {
        Iterator it = this.groupBuilders.iterator();
        while (it.hasNext()) {
            groupBuilder.add((GroupBuilder) it.next());
        }
    }

    public List getChildren() {
        return this.groupBuilders;
    }

    public String getSource() {
        return this.source;
    }

    void setSource(String str) {
        this.source = str;
    }
}
