package org.apache.commons.lang3.builder;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes6.dex */
public class DiffResult<T> implements Iterable<Diff<?>> {
    public static final String OBJECTS_SAME_STRING = "";
    private final List diffList;
    private final Object lhs;
    private final Object rhs;
    private final ToStringStyle style;
    private final String toStringFormat;

    DiffResult(Object obj, Object obj2, List list, ToStringStyle toStringStyle, String str) {
        Objects.requireNonNull(list, "diffList");
        this.diffList = list;
        Objects.requireNonNull(obj, "lhs");
        this.lhs = obj;
        Objects.requireNonNull(obj2, "rhs");
        this.rhs = obj2;
        Objects.requireNonNull(toStringStyle, "style");
        this.style = toStringStyle;
        Objects.requireNonNull(str, "toStringFormat");
        this.toStringFormat = str;
    }

    public List<Diff<?>> getDiffs() {
        return Collections.unmodifiableList(this.diffList);
    }

    public T getLeft() {
        return (T) this.lhs;
    }

    public int getNumberOfDiffs() {
        return this.diffList.size();
    }

    public T getRight() {
        return (T) this.rhs;
    }

    public ToStringStyle getToStringStyle() {
        return this.style;
    }

    @Override // java.lang.Iterable
    public Iterator<Diff<?>> iterator() {
        return this.diffList.iterator();
    }

    public String toString() {
        return toString(this.style);
    }

    public String toString(ToStringStyle toStringStyle) {
        if (this.diffList.isEmpty()) {
            return "";
        }
        final ToStringBuilder toStringBuilder = new ToStringBuilder(this.lhs, toStringStyle);
        final ToStringBuilder toStringBuilder2 = new ToStringBuilder(this.rhs, toStringStyle);
        this.diffList.forEach(new Consumer() { // from class: org.apache.commons.lang3.builder.DiffResult$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DiffResult.lambda$toString$0(toStringBuilder, toStringBuilder2, (Diff) obj);
            }
        });
        return String.format(this.toStringFormat, toStringBuilder.build(), toStringBuilder2.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toString$0(ToStringBuilder toStringBuilder, ToStringBuilder toStringBuilder2, Diff diff) {
        toStringBuilder.append(diff.getFieldName(), diff.getLeft());
        toStringBuilder2.append(diff.getFieldName(), diff.getRight());
    }
}
