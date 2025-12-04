package androidx.test.uiautomator;

import java.util.List;

/* loaded from: classes2.dex */
interface Searchable {
    UiObject2 findObject(BySelector bySelector);

    List findObjects(BySelector bySelector);

    boolean hasObject(BySelector bySelector);
}
