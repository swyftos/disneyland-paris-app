package com.urbanairship.android.layout.info;

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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/layout/info/FormValidationMode;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "ON_DEMAND", "IMMEDIATE", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FormValidationMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FormValidationMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final FormValidationMode ON_DEMAND = new FormValidationMode("ON_DEMAND", 0, "on_demand");
    public static final FormValidationMode IMMEDIATE = new FormValidationMode("IMMEDIATE", 1, "immediate");

    private static final /* synthetic */ FormValidationMode[] $values() {
        return new FormValidationMode[]{ON_DEMAND, IMMEDIATE};
    }

    @NotNull
    public static EnumEntries<FormValidationMode> getEntries() {
        return $ENTRIES;
    }

    public static FormValidationMode valueOf(String str) {
        return (FormValidationMode) Enum.valueOf(FormValidationMode.class, str);
    }

    public static FormValidationMode[] values() {
        return (FormValidationMode[]) $VALUES.clone();
    }

    private FormValidationMode(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        FormValidationMode[] formValidationModeArr$values = $values();
        $VALUES = formValidationModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(formValidationModeArr$values);
        INSTANCE = new Companion(null);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/info/FormValidationMode$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/info/FormValidationMode;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final FormValidationMode from(@NotNull String value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (FormValidationMode formValidationMode : FormValidationMode.getEntries()) {
                String str = formValidationMode.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return formValidationMode;
                }
            }
            throw new JsonException("Unknown form validation mode value: " + value);
        }
    }
}
