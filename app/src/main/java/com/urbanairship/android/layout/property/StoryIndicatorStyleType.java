package com.urbanairship.android.layout.property;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006¨\u0006\b"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "LINEAR_PROGRESS", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum StoryIndicatorStyleType {
    LINEAR_PROGRESS("linear_progress");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<StoryIndicatorStyleType> getEntries() {
        return $ENTRIES;
    }

    StoryIndicatorStyleType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.value;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/StoryIndicatorStyleType;", "value", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
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
