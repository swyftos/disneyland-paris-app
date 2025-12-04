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

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FORM_SUBMIT", "FORM_VALIDATE", "PAGER_NEXT", "PAGER_PREVIOUS", "PAGER_NEXT_OR_DISMISS", "PAGER_NEXT_OR_FIRST", "PAGER_PAUSE", "PAGER_RESUME", "DISMISS", "CANCEL", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ButtonClickBehaviorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ButtonClickBehaviorType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final ButtonClickBehaviorType FORM_SUBMIT = new ButtonClickBehaviorType("FORM_SUBMIT", 0, "form_submit");
    public static final ButtonClickBehaviorType FORM_VALIDATE = new ButtonClickBehaviorType("FORM_VALIDATE", 1, "form_validate");
    public static final ButtonClickBehaviorType PAGER_NEXT = new ButtonClickBehaviorType("PAGER_NEXT", 2, "pager_next");
    public static final ButtonClickBehaviorType PAGER_PREVIOUS = new ButtonClickBehaviorType("PAGER_PREVIOUS", 3, "pager_previous");
    public static final ButtonClickBehaviorType PAGER_NEXT_OR_DISMISS = new ButtonClickBehaviorType("PAGER_NEXT_OR_DISMISS", 4, "pager_next_or_dismiss");
    public static final ButtonClickBehaviorType PAGER_NEXT_OR_FIRST = new ButtonClickBehaviorType("PAGER_NEXT_OR_FIRST", 5, "pager_next_or_first");
    public static final ButtonClickBehaviorType PAGER_PAUSE = new ButtonClickBehaviorType("PAGER_PAUSE", 6, "pager_pause");
    public static final ButtonClickBehaviorType PAGER_RESUME = new ButtonClickBehaviorType("PAGER_RESUME", 7, "pager_resume");
    public static final ButtonClickBehaviorType DISMISS = new ButtonClickBehaviorType("DISMISS", 8, "dismiss");
    public static final ButtonClickBehaviorType CANCEL = new ButtonClickBehaviorType("CANCEL", 9, "cancel");

    private static final /* synthetic */ ButtonClickBehaviorType[] $values() {
        return new ButtonClickBehaviorType[]{FORM_SUBMIT, FORM_VALIDATE, PAGER_NEXT, PAGER_PREVIOUS, PAGER_NEXT_OR_DISMISS, PAGER_NEXT_OR_FIRST, PAGER_PAUSE, PAGER_RESUME, DISMISS, CANCEL};
    }

    @NotNull
    public static EnumEntries<ButtonClickBehaviorType> getEntries() {
        return $ENTRIES;
    }

    public static ButtonClickBehaviorType valueOf(String str) {
        return (ButtonClickBehaviorType) Enum.valueOf(ButtonClickBehaviorType.class, str);
    }

    public static ButtonClickBehaviorType[] values() {
        return (ButtonClickBehaviorType[]) $VALUES.clone();
    }

    private ButtonClickBehaviorType(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        ButtonClickBehaviorType[] buttonClickBehaviorTypeArr$values = $values();
        $VALUES = buttonClickBehaviorTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(buttonClickBehaviorTypeArr$values);
        INSTANCE = new Companion(null);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        String lowerCase = name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "value", "", "fromList", "", "json", "Lcom/urbanairship/json/JsonList;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
