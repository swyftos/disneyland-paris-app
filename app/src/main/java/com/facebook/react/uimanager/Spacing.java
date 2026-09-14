package com.facebook.react.uimanager;

import com.contentsquare.android.api.Currencies;
import com.facebook.yoga.YogaConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.channel.AttributeMutation;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0011\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0086\u0002J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1836d2 = {"Lcom/facebook/react/uimanager/Spacing;", "", "defaultValue", "", "spacing", "", "<init>", "(F[F)V", "()V", "(F)V", "original", "(Lcom/facebook/react/uimanager/Spacing;)V", "valueFlags", "", "hasAliasesSet", "", AttributeMutation.ATTRIBUTE_ACTION_SET, "spacingType", "value", "get", "getRaw", "reset", "", "getWithFallback", "fallbackType", "Companion", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class Spacing {
    public static final int ALL = 8;
    public static final int BLOCK = 9;
    public static final int BLOCK_END = 10;
    public static final int BLOCK_START = 11;
    public static final int BOTTOM = 3;
    public static final int END = 5;
    public static final int HORIZONTAL = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 2;
    public static final int START = 4;
    public static final int TOP = 1;
    public static final int VERTICAL = 7;
    private final float defaultValue;
    private boolean hasAliasesSet;

    @NotNull
    private final float[] spacing;
    private int valueFlags;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final int[] flagsMap = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};

    public Spacing(float f, @NotNull float[] spacing) {
        Intrinsics.checkNotNullParameter(spacing, "spacing");
        this.defaultValue = f;
        this.spacing = spacing;
    }

    public Spacing() {
        this(BitmapDescriptorFactory.HUE_RED, INSTANCE.newFullSpacingArray());
    }

    public Spacing(float f) {
        this(f, INSTANCE.newFullSpacingArray());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Spacing(@NotNull Spacing original) {
        Intrinsics.checkNotNullParameter(original, "original");
        float f = original.defaultValue;
        float[] fArr = original.spacing;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(fArrCopyOf, "copyOf(...)");
        this(f, fArrCopyOf);
        this.valueFlags = original.valueFlags;
        this.hasAliasesSet = original.hasAliasesSet;
    }

    public final boolean set(int spacingType, float value) {
        int i;
        if (FloatUtil.floatsEqual(this.spacing[spacingType], value)) {
            return false;
        }
        this.spacing[spacingType] = value;
        if (YogaConstants.isUndefined(value)) {
            i = (~flagsMap[spacingType]) & this.valueFlags;
        } else {
            i = flagsMap[spacingType] | this.valueFlags;
        }
        this.valueFlags = i;
        int[] iArr = flagsMap;
        this.hasAliasesSet = ((iArr[8] & i) == 0 && (iArr[7] & i) == 0 && (iArr[6] & i) == 0 && (i & iArr[9]) == 0) ? false : true;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000c  */
    public final float get(int spacingType) {
        float f;
        if (spacingType != 4 && spacingType != 5) {
            switch (spacingType) {
                case 9:
                case 10:
                case 11:
                    f = Float.NaN;
                    break;
                default:
                    f = this.defaultValue;
                    break;
            }
        } else {
            f = Float.NaN;
        }
        int i = this.valueFlags;
        if (i == 0) {
            return f;
        }
        int[] iArr = flagsMap;
        if ((iArr[spacingType] & i) != 0) {
            return this.spacing[spacingType];
        }
        if (this.hasAliasesSet) {
            char c = (spacingType == 1 || spacingType == 3) ? (char) 7 : (char) 6;
            if ((iArr[c] & i) != 0) {
                return this.spacing[c];
            }
            if ((i & iArr[8]) != 0) {
                return this.spacing[8];
            }
        }
        return f;
    }

    public final float getRaw(int spacingType) {
        return this.spacing[spacingType];
    }

    public final void reset() {
        ArraysKt.fill$default(this.spacing, Float.NaN, 0, 0, 6, (Object) null);
        this.hasAliasesSet = false;
        this.valueFlags = 0;
    }

    public final float getWithFallback(int spacingType, int fallbackType) {
        if ((this.valueFlags & flagsMap[spacingType]) != 0) {
            return this.spacing[spacingType];
        }
        return get(fallbackType);
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1836d2 = {"Lcom/facebook/react/uimanager/Spacing$Companion;", "", "<init>", "()V", "LEFT", "", Currencies.AlphabeticCode.TOP_STR, "RIGHT", "BOTTOM", "START", "END", "HORIZONTAL", "VERTICAL", "ALL", "BLOCK", "BLOCK_END", "BLOCK_START", "flagsMap", "", "newFullSpacingArray", "", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float[] newFullSpacingArray() {
            return new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
        }
    }
}
