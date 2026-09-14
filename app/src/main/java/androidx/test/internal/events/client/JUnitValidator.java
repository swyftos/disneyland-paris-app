package androidx.test.internal.events.client;

import org.junit.runner.Description;

/* JADX INFO: loaded from: classes2.dex */
abstract class JUnitValidator {
    static boolean validateDescription(Description description) {
        return !"initializationError".equals(description.getMethodName());
    }
}
