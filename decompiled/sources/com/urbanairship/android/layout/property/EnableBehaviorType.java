package com.urbanairship.android.layout.property;

import com.urbanairship.json.JsonException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FORM_VALIDATION", "PAGER_NEXT", "PAGER_PREVIOUS", "FORM_SUBMISSION", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnableBehaviorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EnableBehaviorType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final EnableBehaviorType FORM_VALIDATION = new EnableBehaviorType("FORM_VALIDATION", 0, "form_validation");
    public static final EnableBehaviorType PAGER_NEXT = new EnableBehaviorType("PAGER_NEXT", 1, "pager_next");
    public static final EnableBehaviorType PAGER_PREVIOUS = new EnableBehaviorType("PAGER_PREVIOUS", 2, "pager_previous");
    public static final EnableBehaviorType FORM_SUBMISSION = new EnableBehaviorType("FORM_SUBMISSION", 3, "form_submission");

    private static final /* synthetic */ EnableBehaviorType[] $values() {
        return new EnableBehaviorType[]{FORM_VALIDATION, PAGER_NEXT, PAGER_PREVIOUS, FORM_SUBMISSION};
    }

    @NotNull
    public static EnumEntries<EnableBehaviorType> getEntries() {
        return $ENTRIES;
    }

    public static EnableBehaviorType valueOf(String str) {
        return (EnableBehaviorType) Enum.valueOf(EnableBehaviorType.class, str);
    }

    public static EnableBehaviorType[] values() {
        return (EnableBehaviorType[]) $VALUES.clone();
    }

    private EnableBehaviorType(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        EnableBehaviorType[] enableBehaviorTypeArr$values = $values();
        $VALUES = enableBehaviorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(enableBehaviorTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/EnableBehaviorType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final EnableBehaviorType from(@NotNull String value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (EnableBehaviorType enableBehaviorType : EnableBehaviorType.getEntries()) {
                String str = enableBehaviorType.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return enableBehaviorType;
                }
            }
            throw new JsonException("Unknown EnableBehaviorType value: " + value);
        }
    }
}
