package com.urbanairship.android.layout.info;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/layout/info/AccessibilityActionType;", "", "(Ljava/lang/String;I)V", "DEFAULT", "ESCAPE", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccessibilityActionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AccessibilityActionType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final AccessibilityActionType DEFAULT = new AccessibilityActionType("DEFAULT", 0);
    public static final AccessibilityActionType ESCAPE = new AccessibilityActionType("ESCAPE", 1);

    private static final /* synthetic */ AccessibilityActionType[] $values() {
        return new AccessibilityActionType[]{DEFAULT, ESCAPE};
    }

    @NotNull
    public static EnumEntries<AccessibilityActionType> getEntries() {
        return $ENTRIES;
    }

    public static AccessibilityActionType valueOf(String str) {
        return (AccessibilityActionType) Enum.valueOf(AccessibilityActionType.class, str);
    }

    public static AccessibilityActionType[] values() {
        return (AccessibilityActionType[]) $VALUES.clone();
    }

    private AccessibilityActionType(String str, int i) {
    }

    static {
        AccessibilityActionType[] accessibilityActionTypeArr$values = $values();
        $VALUES = accessibilityActionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(accessibilityActionTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/AccessibilityActionType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/info/AccessibilityActionType;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final AccessibilityActionType from(@Nullable String value) {
            String lowerCase;
            if (value != null) {
                lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            } else {
                lowerCase = null;
            }
            if (Intrinsics.areEqual(lowerCase, "default")) {
                return AccessibilityActionType.DEFAULT;
            }
            if (Intrinsics.areEqual(lowerCase, "escape")) {
                return AccessibilityActionType.ESCAPE;
            }
            return null;
        }
    }
}
