package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0011"}, d2 = {"Lcom/mrousavy/camera/core/types/Orientation;", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "", "unionValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "PORTRAIT", "LANDSCAPE_RIGHT", "PORTRAIT_UPSIDE_DOWN", "LANDSCAPE_LEFT", "toSurfaceRotation", "", "reversed", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Orientation implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Orientation[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final Orientation PORTRAIT = new Orientation("PORTRAIT", 0, "portrait");
    public static final Orientation LANDSCAPE_RIGHT = new Orientation("LANDSCAPE_RIGHT", 1, "landscape-right");
    public static final Orientation PORTRAIT_UPSIDE_DOWN = new Orientation("PORTRAIT_UPSIDE_DOWN", 2, "portrait-upside-down");
    public static final Orientation LANDSCAPE_LEFT = new Orientation("LANDSCAPE_LEFT", 3, "landscape-left");

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.LANDSCAPE_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Orientation.PORTRAIT_UPSIDE_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Orientation.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ Orientation[] $values() {
        return new Orientation[]{PORTRAIT, LANDSCAPE_RIGHT, PORTRAIT_UPSIDE_DOWN, LANDSCAPE_LEFT};
    }

    @NotNull
    public static EnumEntries<Orientation> getEntries() {
        return $ENTRIES;
    }

    private Orientation(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    @NotNull
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        Orientation[] orientationArr$values = $values();
        $VALUES = orientationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(orientationArr$values);
        INSTANCE = new Companion(null);
    }

    public final int toSurfaceRotation() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Orientation reversed() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return PORTRAIT;
        }
        if (i == 2) {
            return LANDSCAPE_RIGHT;
        }
        if (i == 3) {
            return PORTRAIT_UPSIDE_DOWN;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return LANDSCAPE_LEFT;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/core/types/Orientation$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/Orientation;", "<init>", "()V", "fromUnionValue", "unionValue", "", "fromRotationDegrees", "rotationDegrees", "", "fromSurfaceRotation", "rotation", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<Orientation> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        @NotNull
        public Orientation fromUnionValue(@Nullable String unionValue) {
            if (unionValue != null) {
                switch (unionValue.hashCode()) {
                    case -1510435861:
                        if (unionValue.equals("portrait-upside-down")) {
                            return Orientation.PORTRAIT_UPSIDE_DOWN;
                        }
                        break;
                    case 687313034:
                        if (unionValue.equals("landscape-right")) {
                            return Orientation.LANDSCAPE_RIGHT;
                        }
                        break;
                    case 729267099:
                        if (unionValue.equals("portrait")) {
                            return Orientation.PORTRAIT;
                        }
                        break;
                    case 1684556761:
                        if (unionValue.equals("landscape-left")) {
                            return Orientation.LANDSCAPE_LEFT;
                        }
                        break;
                }
            }
            return Orientation.PORTRAIT;
        }

        @NotNull
        public final Orientation fromRotationDegrees(int rotationDegrees) {
            if (45 <= rotationDegrees && rotationDegrees < 136) {
                return Orientation.LANDSCAPE_LEFT;
            }
            if (135 <= rotationDegrees && rotationDegrees < 226) {
                return Orientation.PORTRAIT_UPSIDE_DOWN;
            }
            if (225 <= rotationDegrees && rotationDegrees < 316) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            return Orientation.PORTRAIT;
        }

        @NotNull
        public final Orientation fromSurfaceRotation(int rotation) {
            if (rotation == 0) {
                return Orientation.PORTRAIT;
            }
            if (rotation == 1) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            if (rotation == 2) {
                return Orientation.PORTRAIT_UPSIDE_DOWN;
            }
            if (rotation == 3) {
                return Orientation.LANDSCAPE_LEFT;
            }
            return Orientation.PORTRAIT;
        }
    }

    public static Orientation valueOf(String str) {
        return (Orientation) Enum.valueOf(Orientation.class, str);
    }

    public static Orientation[] values() {
        return (Orientation[]) $VALUES.clone();
    }
}
