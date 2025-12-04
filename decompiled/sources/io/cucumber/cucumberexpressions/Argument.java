package io.cucumber.cucumberexpressions;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class Argument<T> {
    private final Group group;
    private final ParameterType parameterType;

    static List build(TreeRegexp treeRegexp, List list, String str) {
        Group groupMatch = treeRegexp.match(str);
        if (groupMatch == null) {
            return null;
        }
        List<Group> children = groupMatch.getChildren();
        if (children.size() != list.size()) {
            throw new CucumberExpressionException(String.format("Expression /%s/ has %s capture groups (%s), but there were %s parameter types (%s)", treeRegexp.pattern().pattern(), Integer.valueOf(children.size()), getGroupValues(children), Integer.valueOf(list.size()), getParameterTypeNames(list)));
        }
        ArrayList arrayList = new ArrayList(children.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new Argument(children.get(i), (ParameterType) list.get(i)));
        }
        return arrayList;
    }

    private static List getParameterTypeNames(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ParameterType) it.next()).getName());
        }
        return arrayList;
    }

    private static List getGroupValues(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Group) it.next()).getValue());
        }
        return arrayList;
    }

    public Argument(Group group, ParameterType<T> parameterType) {
        this.group = group;
        this.parameterType = parameterType;
    }

    public Group getGroup() {
        return this.group;
    }

    public T getValue() {
        return (T) this.parameterType.transform(this.group.getValues());
    }

    public Type getType() {
        return this.parameterType.getType();
    }
}
