package com.urbanairship.android.layout.property;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/GestureType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "TAP", "SWIPE", "HOLD", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GestureType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GestureType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final GestureType TAP = new GestureType("TAP", 0, "tap");
    public static final GestureType SWIPE = new GestureType("SWIPE", 1, "swipe");
    public static final GestureType HOLD = new GestureType("HOLD", 2, "hold");

    private static final /* synthetic */ GestureType[] $values() {
        return new GestureType[]{TAP, SWIPE, HOLD};
    }

    @NotNull
    public static EnumEntries<GestureType> getEntries() {
        return $ENTRIES;
    }

    public static GestureType valueOf(String str) {
        return (GestureType) Enum.valueOf(GestureType.class, str);
    }

    public static GestureType[] values() {
        return (GestureType[]) $VALUES.clone();
    }

    private GestureType(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        GestureType[] gestureTypeArr$values = $values();
        $VALUES = gestureTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(gestureTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/GestureType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/GestureType;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final GestureType from(@NotNull String value) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (GestureType gestureType : GestureType.values()) {
                String str = gestureType.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return gestureType;
                }
            }
            throw new IllegalArgumentException("Unknown GestureType value: " + value);
        }
    }
}
