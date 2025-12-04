package com.urbanairship.android.layout.property;

import com.contentsquare.android.api.Currencies;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.uimanager.ViewProps;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Languages;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/urbanairship/android/layout/property/GestureLocation;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", Currencies.AlphabeticCode.TOP_STR, "BOTTOM", "START", "END", "LEFT", "RIGHT", ThreadConfined.ANY, "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GestureLocation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GestureLocation[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String value;
    public static final GestureLocation TOP = new GestureLocation(Currencies.AlphabeticCode.TOP_STR, 0, ViewProps.TOP);
    public static final GestureLocation BOTTOM = new GestureLocation("BOTTOM", 1, ViewProps.BOTTOM);
    public static final GestureLocation START = new GestureLocation("START", 2, ViewProps.START);
    public static final GestureLocation END = new GestureLocation("END", 3, ViewProps.END);
    public static final GestureLocation LEFT = new GestureLocation("LEFT", 4, ViewProps.LEFT);
    public static final GestureLocation RIGHT = new GestureLocation("RIGHT", 5, ViewProps.RIGHT);
    public static final GestureLocation ANY = new GestureLocation(ThreadConfined.ANY, 6, Languages.ANY);

    private static final /* synthetic */ GestureLocation[] $values() {
        return new GestureLocation[]{TOP, BOTTOM, START, END, LEFT, RIGHT, ANY};
    }

    @NotNull
    public static EnumEntries<GestureLocation> getEntries() {
        return $ENTRIES;
    }

    public static GestureLocation valueOf(String str) {
        return (GestureLocation) Enum.valueOf(GestureLocation.class, str);
    }

    public static GestureLocation[] values() {
        return (GestureLocation[]) $VALUES.clone();
    }

    private GestureLocation(String str, int i, String str2) {
        this.value = str2;
    }

    static {
        GestureLocation[] gestureLocationArr$values = $values();
        $VALUES = gestureLocationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(gestureLocationArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/GestureLocation$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/GestureLocation;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final GestureLocation from(@NotNull String value) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(value, "value");
            for (GestureLocation gestureLocation : GestureLocation.values()) {
                String str = gestureLocation.value;
                String lowerCase = value.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return gestureLocation;
                }
            }
            throw new IllegalArgumentException("Unknown GestureLocation value: " + value);
        }
    }
}
