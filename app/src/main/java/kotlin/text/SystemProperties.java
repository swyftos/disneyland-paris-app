package kotlin.text;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
final class SystemProperties {
    public static final SystemProperties INSTANCE = new SystemProperties();
    public static final String LINE_SEPARATOR;

    private SystemProperties() {
    }

    static {
        String property = System.getProperty(org.apache.commons.lang3.SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNull(property);
        LINE_SEPARATOR = property;
    }
}
