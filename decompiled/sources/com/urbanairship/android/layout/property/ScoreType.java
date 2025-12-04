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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "NUMBER_RANGE", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScoreType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScoreType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final ScoreType NUMBER_RANGE = new ScoreType("NUMBER_RANGE", 0, "number_range");
    private final String value;

    private static final /* synthetic */ ScoreType[] $values() {
        return new ScoreType[]{NUMBER_RANGE};
    }

    @NotNull
    public static EnumEntries<ScoreType> getEntries() {
        return $ENTRIES;
    }

    public static ScoreType valueOf(String str) {
        return (ScoreType) Enum.valueOf(ScoreType.class, str);
    }

    public static ScoreType[] values() {
        return (ScoreType[]) $VALUES.clone();
    }

    private ScoreType(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        ScoreType[] scoreTypeArr$values = $values();
        $VALUES = scoreTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(scoreTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/ScoreType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/ScoreType;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ScoreType from(@NotNull String value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (ScoreType scoreType : ScoreType.getEntries()) {
                String str = scoreType.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return scoreType;
                }
            }
            throw new JsonException("Unknown ScoreType value: " + value);
        }
    }
}
