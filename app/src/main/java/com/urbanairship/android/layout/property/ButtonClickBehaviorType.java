package com.urbanairship.android.layout.property;

import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FORM_SUBMIT", "FORM_VALIDATE", "PAGER_NEXT", "PAGER_PREVIOUS", "PAGER_NEXT_OR_DISMISS", "PAGER_NEXT_OR_FIRST", "PAGER_PAUSE", "PAGER_RESUME", "DISMISS", "CANCEL", "Companion", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum ButtonClickBehaviorType {
    FORM_SUBMIT("form_submit"),
    FORM_VALIDATE("form_validate"),
    PAGER_NEXT("pager_next"),
    PAGER_PREVIOUS("pager_previous"),
    PAGER_NEXT_OR_DISMISS("pager_next_or_dismiss"),
    PAGER_NEXT_OR_FIRST("pager_next_or_first"),
    PAGER_PAUSE("pager_pause"),
    PAGER_RESUME("pager_resume"),
    DISMISS("dismiss"),
    CANCEL("cancel");

    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<ButtonClickBehaviorType> getEntries() {
        return $ENTRIES;
    }

    ButtonClickBehaviorType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m1836d2 = {"Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "value", "", "fromList", "", "json", "Lcom/urbanairship/json/JsonList;", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nButtonClickBehaviorType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ButtonClickBehaviorType.kt\ncom/urbanairship/android/layout/property/ButtonClickBehaviorType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1549#2:98\n1620#2,3:99\n*S KotlinDebug\n*F\n+ 1 ButtonClickBehaviorType.kt\ncom/urbanairship/android/layout/property/ButtonClickBehaviorType$Companion\n*L\n43#1:98\n43#1:99,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ButtonClickBehaviorType from(@NotNull String value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (ButtonClickBehaviorType buttonClickBehaviorType : ButtonClickBehaviorType.values()) {
                String str = buttonClickBehaviorType.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return buttonClickBehaviorType;
                }
            }
            throw new JsonException("Unknown ButtonClickBehaviorType value: " + value);
        }

        @NotNull
        public final List<ButtonClickBehaviorType> fromList(@NotNull JsonList json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            if (json.isEmpty()) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(json, 10));
            for (JsonValue jsonValue : json) {
                Companion companion = ButtonClickBehaviorType.INSTANCE;
                String strOptString = jsonValue.optString();
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                arrayList.add(companion.from(strOptString));
            }
            return CollectionsKt.sorted(arrayList);
        }
    }
}
