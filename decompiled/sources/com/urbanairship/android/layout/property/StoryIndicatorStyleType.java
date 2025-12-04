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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "LINEAR_PROGRESS", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StoryIndicatorStyleType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StoryIndicatorStyleType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final StoryIndicatorStyleType LINEAR_PROGRESS = new StoryIndicatorStyleType("LINEAR_PROGRESS", 0, "linear_progress");
    private final String value;

    private static final /* synthetic */ StoryIndicatorStyleType[] $values() {
        return new StoryIndicatorStyleType[]{LINEAR_PROGRESS};
    }

    @NotNull
    public static EnumEntries<StoryIndicatorStyleType> getEntries() {
        return $ENTRIES;
    }

    public static StoryIndicatorStyleType valueOf(String str) {
        return (StoryIndicatorStyleType) Enum.valueOf(StoryIndicatorStyleType.class, str);
    }

    public static StoryIndicatorStyleType[] values() {
        return (StoryIndicatorStyleType[]) $VALUES.clone();
    }

    private StoryIndicatorStyleType(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        StoryIndicatorStyleType[] storyIndicatorStyleTypeArr$values = $values();
        $VALUES = storyIndicatorStyleTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(storyIndicatorStyleTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final StoryIndicatorStyleType from(@NotNull String value) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (StoryIndicatorStyleType storyIndicatorStyleType : StoryIndicatorStyleType.values()) {
                String str = storyIndicatorStyleType.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return storyIndicatorStyleType;
                }
            }
            throw new IllegalArgumentException("Unknown StoryIndicatorStyleType value: " + value);
        }
    }
}
