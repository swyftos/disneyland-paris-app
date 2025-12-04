package com.mrousavy.camera.core.types;

import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0015"}, d2 = {"Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "", "unionValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "OFF", "STANDARD", "CINEMATIC", "CINEMATIC_EXTENDED", FirebaseAnalytics.Param.SCORE, "", "getScore", "()I", "isAtLeast", "", "mode", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VideoStabilizationMode implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoStabilizationMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final VideoStabilizationMode OFF = new VideoStabilizationMode("OFF", 0, "off");
    public static final VideoStabilizationMode STANDARD = new VideoStabilizationMode("STANDARD", 1, Constants.COLLATION_STANDARD);
    public static final VideoStabilizationMode CINEMATIC = new VideoStabilizationMode("CINEMATIC", 2, "cinematic");
    public static final VideoStabilizationMode CINEMATIC_EXTENDED = new VideoStabilizationMode("CINEMATIC_EXTENDED", 3, "cinematic-extended");

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoStabilizationMode.values().length];
            try {
                iArr[VideoStabilizationMode.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoStabilizationMode.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VideoStabilizationMode.CINEMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VideoStabilizationMode.CINEMATIC_EXTENDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ VideoStabilizationMode[] $values() {
        return new VideoStabilizationMode[]{OFF, STANDARD, CINEMATIC, CINEMATIC_EXTENDED};
    }

    @NotNull
    public static EnumEntries<VideoStabilizationMode> getEntries() {
        return $ENTRIES;
    }

    private VideoStabilizationMode(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    @NotNull
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        VideoStabilizationMode[] videoStabilizationModeArr$values = $values();
        $VALUES = videoStabilizationModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(videoStabilizationModeArr$values);
        INSTANCE = new Companion(null);
    }

    private final int getScore() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isAtLeast(@NotNull VideoStabilizationMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        return getScore() >= mode.getScore();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/types/VideoStabilizationMode$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/VideoStabilizationMode;", "<init>", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<VideoStabilizationMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        @NotNull
        public VideoStabilizationMode fromUnionValue(@Nullable String unionValue) throws InvalidTypeScriptUnionError {
            if (unionValue != null) {
                switch (unionValue.hashCode()) {
                    case -1348796151:
                        if (unionValue.equals("cinematic-extended")) {
                            return VideoStabilizationMode.CINEMATIC_EXTENDED;
                        }
                        break;
                    case 109935:
                        if (unionValue.equals("off")) {
                            return VideoStabilizationMode.OFF;
                        }
                        break;
                    case 3005871:
                        if (unionValue.equals("auto")) {
                            return VideoStabilizationMode.OFF;
                        }
                        break;
                    case 1312628413:
                        if (unionValue.equals(Constants.COLLATION_STANDARD)) {
                            return VideoStabilizationMode.STANDARD;
                        }
                        break;
                    case 1598495741:
                        if (unionValue.equals("cinematic")) {
                            return VideoStabilizationMode.CINEMATIC;
                        }
                        break;
                }
            }
            throw new InvalidTypeScriptUnionError("videoStabilizationMode", unionValue);
        }
    }

    public static VideoStabilizationMode valueOf(String str) {
        return (VideoStabilizationMode) Enum.valueOf(VideoStabilizationMode.class, str);
    }

    public static VideoStabilizationMode[] values() {
        return (VideoStabilizationMode[]) $VALUES.clone();
    }
}
