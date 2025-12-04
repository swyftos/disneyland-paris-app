package androidx.test.internal.events.client;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.Description;

/* loaded from: classes2.dex */
abstract class JUnitDescriptionParser {
    public static List getAllTestCaseDescriptions(Description description) {
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(description);
        while (!arrayDeque.isEmpty()) {
            Description description2 = (Description) arrayDeque.pop();
            arrayDeque.addAll(description2.getChildren());
            if (description2.isTest()) {
                arrayList.add(description2);
            }
        }
        return arrayList;
    }
}
