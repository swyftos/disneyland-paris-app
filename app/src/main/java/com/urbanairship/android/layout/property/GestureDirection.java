package com.urbanairship.android.layout.property;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/GestureDirection;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "UP", "DOWN", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum GestureDirection {
    UP("up"),
    DOWN("down");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<GestureDirection> getEntries() {
        return $ENTRIES;
    }

    GestureDirection(String str) {
        this.value = str;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/GestureDirection$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/GestureDirection;", "value", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final GestureDirection from(@NotNull String value) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (GestureDirection gestureDirection : GestureDirection.values()) {
                String str = gestureDirection.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return gestureDirection;
                }
            }
            throw new IllegalArgumentException("Unknown GestureDirection value: " + value);
        }
    }
}
