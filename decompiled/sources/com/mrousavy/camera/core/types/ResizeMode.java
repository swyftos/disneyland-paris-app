package com.mrousavy.camera.core.types;

import androidx.camera.view.PreviewView;
import com.facebook.react.uimanager.ViewProps;
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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/mrousavy/camera/core/types/ResizeMode;", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "", "unionValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "COVER", "CONTAIN", "toScaleType", "Landroidx/camera/view/PreviewView$ScaleType;", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ResizeMode implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResizeMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final ResizeMode COVER = new ResizeMode("COVER", 0, "cover");
    public static final ResizeMode CONTAIN = new ResizeMode("CONTAIN", 1, "contain");

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResizeMode.values().length];
            try {
                iArr[ResizeMode.COVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResizeMode.CONTAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ResizeMode[] $values() {
        return new ResizeMode[]{COVER, CONTAIN};
    }

    @NotNull
    public static EnumEntries<ResizeMode> getEntries() {
        return $ENTRIES;
    }

    private ResizeMode(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    @NotNull
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        ResizeMode[] resizeModeArr$values = $values();
        $VALUES = resizeModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(resizeModeArr$values);
        INSTANCE = new Companion(null);
    }

    @NotNull
    public final PreviewView.ScaleType toScaleType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return PreviewView.ScaleType.FILL_CENTER;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return PreviewView.ScaleType.FIT_CENTER;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/types/ResizeMode$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/ResizeMode;", "<init>", "()V", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<ResizeMode> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        @NotNull
        public ResizeMode fromUnionValue(@Nullable String unionValue) throws InvalidTypeScriptUnionError {
            if (Intrinsics.areEqual(unionValue, "cover")) {
                return ResizeMode.COVER;
            }
            if (Intrinsics.areEqual(unionValue, "contain")) {
                return ResizeMode.CONTAIN;
            }
            throw new InvalidTypeScriptUnionError(ViewProps.RESIZE_MODE, unionValue);
        }
    }

    public static ResizeMode valueOf(String str) {
        return (ResizeMode) Enum.valueOf(ResizeMode.class, str);
    }

    public static ResizeMode[] values() {
        return (ResizeMode[]) $VALUES.clone();
    }
}
