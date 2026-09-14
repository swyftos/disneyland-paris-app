package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, m1836d2 = {"isAndroid", "", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class OSLogHandlerKt {
    private static final boolean isAndroid = Intrinsics.areEqual("The Android Project", System.getProperty(SystemProperties.JAVA_SPECIFICATION_VENDOR));
}
