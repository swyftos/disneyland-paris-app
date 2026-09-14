package org.apache.commons.lang3.time;

import java.time.ZoneId;
import java.util.TimeZone;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemProperties;
import org.apache.commons.lang3.SystemUtils;

/* JADX INFO: loaded from: classes6.dex */
public class TimeZones {
    public static final String GMT_ID = "GMT";
    public static final TimeZone GMT = getTimeZone(GMT_ID);
    private static final boolean JAVA_25 = SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_25);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$mapShortIDs$0() {
        return true;
    }

    public static TimeZone getTimeZone(String str) {
        if (JAVA_25 && mapShortIDs()) {
            str = (String) ZoneId.SHORT_IDS.getOrDefault(str, str);
        }
        return TimeZone.getTimeZone(str);
    }

    private static boolean mapShortIDs() {
        return SystemProperties.getBoolean(TimeZones.class, "mapShortIDs", new BooleanSupplier() { // from class: org.apache.commons.lang3.time.TimeZones$$ExternalSyntheticLambda1
            @Override // java.util.function.BooleanSupplier
            public final boolean getAsBoolean() {
                return TimeZones.lambda$mapShortIDs$0();
            }
        });
    }

    public static TimeZone toTimeZone(TimeZone timeZone) {
        return (TimeZone) ObjectUtils.getIfNull(timeZone, (Supplier<TimeZone>) new Supplier() { // from class: org.apache.commons.lang3.time.TimeZones$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return TimeZone.getDefault();
            }
        });
    }
}
