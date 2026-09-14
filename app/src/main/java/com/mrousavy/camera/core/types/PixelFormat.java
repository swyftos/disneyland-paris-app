package com.mrousavy.camera.core.types;

import android.util.Log;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.PixelFormatNotSupportedError;
import com.mrousavy.camera.core.utils.ImageFormatUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, m1836d2 = {"Lcom/mrousavy/camera/core/types/PixelFormat;", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "", "unionValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "YUV", "RGB", "UNKNOWN", "toImageAnalysisFormat", "", "Companion", "react-native-vision-camera_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum PixelFormat implements JSUnionValue {
    YUV("yuv"),
    RGB("rgb"),
    UNKNOWN("unknown");

    private final String unionValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PixelFormat.values().length];
            try {
                iArr[PixelFormat.YUV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PixelFormat.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static EnumEntries<PixelFormat> getEntries() {
        return $ENTRIES;
    }

    PixelFormat(String str) {
        this.unionValue = str;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    @NotNull
    public String getUnionValue() {
        return this.unionValue;
    }

    public final int toImageAnalysisFormat() throws PixelFormatNotSupportedError {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                throw new PixelFormatNotSupportedError(getUnionValue());
            }
        }
        return i2;
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1836d2 = {"Lcom/mrousavy/camera/core/types/PixelFormat$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/PixelFormat;", "<init>", "()V", "TAG", "", "fromImageFormat", "imageFormat", "", "fromUnionValue", "unionValue", "react-native-vision-camera_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion implements JSUnionValue.Companion<PixelFormat> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PixelFormat fromImageFormat(int imageFormat) {
            if (imageFormat == 1) {
                return PixelFormat.RGB;
            }
            if (imageFormat == 35) {
                return PixelFormat.YUV;
            }
            Log.w("PixelFormat", "Unknown PixelFormat! " + ImageFormatUtils.INSTANCE.imageFormatToString(imageFormat));
            return PixelFormat.UNKNOWN;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        @NotNull
        public PixelFormat fromUnionValue(@Nullable String unionValue) throws InvalidTypeScriptUnionError {
            if (unionValue != null) {
                int iHashCode = unionValue.hashCode();
                if (iHashCode != -284840886) {
                    if (iHashCode != 112845) {
                        if (iHashCode == 120026 && unionValue.equals("yuv")) {
                            return PixelFormat.YUV;
                        }
                    } else if (unionValue.equals("rgb")) {
                        return PixelFormat.RGB;
                    }
                } else if (unionValue.equals("unknown")) {
                    return PixelFormat.UNKNOWN;
                }
            }
            throw new InvalidTypeScriptUnionError("pixelFormat", unionValue);
        }
    }
}
