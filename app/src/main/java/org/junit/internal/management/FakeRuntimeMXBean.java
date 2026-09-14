package org.junit.internal.management;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class FakeRuntimeMXBean implements RuntimeMXBean {
    FakeRuntimeMXBean() {
    }

    @Override // org.junit.internal.management.RuntimeMXBean
    public List getInputArguments() {
        return Collections.emptyList();
    }
}
