package com.amazonaws.internal;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public class ListWithAutoConstructFlag<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1;
    private boolean autoConstruct;

    public ListWithAutoConstructFlag() {
    }

    public ListWithAutoConstructFlag(Collection<? extends T> collection) {
        super(collection);
    }

    public ListWithAutoConstructFlag(int i) {
        super(i);
    }

    public void setAutoConstruct(boolean z) {
        this.autoConstruct = z;
    }

    public boolean isAutoConstruct() {
        return this.autoConstruct;
    }
}
