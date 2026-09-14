package expo.modules.kotlin.jni;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0002"}, m1836d2 = {"nextValue", "", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class JavaScriptTypedArrayKt {
    private static int nextValue = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nextValue() {
        int i = nextValue;
        nextValue = i + 1;
        return i;
    }
}
