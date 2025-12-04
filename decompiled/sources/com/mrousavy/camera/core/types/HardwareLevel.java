package com.mrousavy.camera.core.types;

import com.disney.id.android.Guest;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \n2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/mrousavy/camera/core/types/HardwareLevel;", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "", "", "unionValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getUnionValue", "()Ljava/lang/String;", "Companion", "LEGACY", "LIMITED", "EXTERNAL", "FULL", "LEVEL_3", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HardwareLevel implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HardwareLevel[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final HardwareLevel LEGACY = new HardwareLevel("LEGACY", 0, "legacy");
    public static final HardwareLevel LIMITED = new HardwareLevel("LIMITED", 1, "limited");
    public static final HardwareLevel EXTERNAL = new HardwareLevel("EXTERNAL", 2, "limited");
    public static final HardwareLevel FULL = new HardwareLevel("FULL", 3, Guest.PAYLOAD_FULL);
    public static final HardwareLevel LEVEL_3 = new HardwareLevel("LEVEL_3", 4, Guest.PAYLOAD_FULL);

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HardwareLevel.values().length];
            try {
                iArr[HardwareLevel.LEGACY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HardwareLevel.LIMITED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HardwareLevel.EXTERNAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HardwareLevel.FULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HardwareLevel.LEVEL_3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ HardwareLevel[] $values() {
        return new HardwareLevel[]{LEGACY, LIMITED, EXTERNAL, FULL, LEVEL_3};
    }

    @NotNull
    public static EnumEntries<HardwareLevel> getEntries() {
        return $ENTRIES;
    }

    private HardwareLevel(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    @NotNull
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        HardwareLevel[] hardwareLevelArr$values = $values();
        $VALUES = hardwareLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(hardwareLevelArr$values);
        INSTANCE = new Companion(null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/types/HardwareLevel$Companion;", "", "<init>", "()V", "fromCameraHardwareLevel", "Lcom/mrousavy/camera/core/types/HardwareLevel;", "hardwareLevel", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final HardwareLevel fromCameraHardwareLevel(int hardwareLevel) {
            if (hardwareLevel == 0) {
                return HardwareLevel.LIMITED;
            }
            if (hardwareLevel == 1) {
                return HardwareLevel.FULL;
            }
            if (hardwareLevel == 2) {
                return HardwareLevel.LEGACY;
            }
            if (hardwareLevel == 3) {
                return HardwareLevel.LEVEL_3;
            }
            if (hardwareLevel == 4) {
                return HardwareLevel.EXTERNAL;
            }
            return HardwareLevel.LEGACY;
        }
    }

    public static HardwareLevel valueOf(String str) {
        return (HardwareLevel) Enum.valueOf(HardwareLevel.class, str);
    }

    public static HardwareLevel[] values() {
        return (HardwareLevel[]) $VALUES.clone();
    }
}
