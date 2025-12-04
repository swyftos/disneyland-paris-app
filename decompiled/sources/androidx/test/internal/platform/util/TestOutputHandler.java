package androidx.test.internal.platform.util;

import java.io.Serializable;
import java.util.Map;

/* loaded from: classes2.dex */
public interface TestOutputHandler {
    boolean addOutputProperties(Map<String, Serializable> map);

    boolean captureWindowHierarchy(String str);

    void dumpThreadStates(String str);

    boolean takeScreenshot(String str);
}
