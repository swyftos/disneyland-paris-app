package expo.modules.blur.enums;

import androidx.core.view.ViewCompat;
import expo.modules.kotlin.types.Enumerable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006#"}, m1836d2 = {"Lexpo/modules/blur/enums/TintStyle;", "Lexpo/modules/kotlin/types/Enumerable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "EXTRA_LIGHT", "LIGHT", "DARK", "REGULAR", "PROMINENT", "SYSTEM_ULTRA_THIN_MATERIAL", "SYSTEM_THIN_MATERIAL", "SYSTEM_MATERIAL", "SYSTEM_THICK_MATERIAL", "SYSTEM_CHROME_MATERIAL", "SYSTEM_ULTRA_THIN_MATERIAL_LIGHT", "SYSTEM_THICK_MATERIAL_LIGHT", "SYSTEM_THIN_MATERIAL_LIGHT", "SYSTEM_MATERIAL_LIGHT", "SYSTEM_CHROME_MATERIAL_LIGHT", "SYSTEM_ULTRA_THIN_MATERIAL_DARK", "SYSTEM_THIN_MATERIAL_DARK", "SYSTEM_MATERIAL_DARK", "SYSTEM_THICK_MATERIAL_DARK", "SYSTEM_CHROME_MATERIAL_DARK", "toBlurEffect", "", "blurRadius", "", "toColorInt", "expo-blur_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum TintStyle implements Enumerable {
    DEFAULT("default"),
    EXTRA_LIGHT("extraLight"),
    LIGHT("light"),
    DARK("dark"),
    REGULAR("regular"),
    PROMINENT("prominent"),
    SYSTEM_ULTRA_THIN_MATERIAL("systemUltraThinMaterial"),
    SYSTEM_THIN_MATERIAL("systemThinMaterial"),
    SYSTEM_MATERIAL("systemMaterial"),
    SYSTEM_THICK_MATERIAL("systemThickMaterial"),
    SYSTEM_CHROME_MATERIAL("systemChromeMaterial"),
    SYSTEM_ULTRA_THIN_MATERIAL_LIGHT("systemUltraThinMaterialLight"),
    SYSTEM_THICK_MATERIAL_LIGHT("systemThickMaterialLight"),
    SYSTEM_THIN_MATERIAL_LIGHT("systemThinMaterialLight"),
    SYSTEM_MATERIAL_LIGHT("systemMaterialLight"),
    SYSTEM_CHROME_MATERIAL_LIGHT("systemChromeMaterialLight"),
    SYSTEM_ULTRA_THIN_MATERIAL_DARK("systemUltraThinMaterialDark"),
    SYSTEM_THIN_MATERIAL_DARK("systemThinMaterialDark"),
    SYSTEM_MATERIAL_DARK("systemMaterialDark"),
    SYSTEM_THICK_MATERIAL_DARK("systemThickMaterialDark"),
    SYSTEM_CHROME_MATERIAL_DARK("systemChromeMaterialDark");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    @NotNull
    private final String value;

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TintStyle.values().length];
            try {
                iArr[TintStyle.EXTRA_LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TintStyle.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TintStyle.SYSTEM_MATERIAL_LIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TintStyle.SYSTEM_ULTRA_THIN_MATERIAL_LIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TintStyle.SYSTEM_THICK_MATERIAL_LIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TintStyle.PROMINENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TintStyle.DEFAULT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TintStyle.SYSTEM_MATERIAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TintStyle.DARK.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[TintStyle.SYSTEM_MATERIAL_DARK.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[TintStyle.REGULAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[TintStyle.SYSTEM_ULTRA_THIN_MATERIAL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[TintStyle.SYSTEM_THICK_MATERIAL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[TintStyle.SYSTEM_CHROME_MATERIAL.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[TintStyle.SYSTEM_CHROME_MATERIAL_LIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[TintStyle.SYSTEM_THICK_MATERIAL_DARK.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[TintStyle.SYSTEM_THIN_MATERIAL_LIGHT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[TintStyle.SYSTEM_THIN_MATERIAL_DARK.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[TintStyle.SYSTEM_ULTRA_THIN_MATERIAL_DARK.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[TintStyle.SYSTEM_CHROME_MATERIAL_DARK.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[TintStyle.SYSTEM_THIN_MATERIAL.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static EnumEntries<TintStyle> getEntries() {
        return $ENTRIES;
    }

    TintStyle(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public final int toBlurEffect(float blurRadius) {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return LIGHT.toColorInt(blurRadius);
            case 6:
            case 7:
            case 8:
                return DEFAULT.toColorInt(blurRadius);
            case 9:
            case 10:
                return DARK.toColorInt(blurRadius);
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return toColorInt(blurRadius);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final int toColorInt(float blurRadius) {
        int i;
        int i2;
        double d;
        double d2;
        double d3;
        double d4;
        float f = blurRadius / 100;
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 2) {
            i = ((int) (((double) (255 * f)) * 0.78d)) << 24;
            i2 = 16382457;
        } else if (i3 != 9) {
            switch (i3) {
                case 11:
                    i = ((int) (((double) (255 * f)) * 0.82d)) << 24;
                    i2 = 11776947;
                    break;
                case 12:
                    i = ((int) (((double) (255 * f)) * 0.44d)) << 24;
                    i2 = 12566463;
                    break;
                case 13:
                    i = ((int) (((double) (255 * f)) * 0.97d)) << 24;
                    i2 = 10066329;
                    break;
                case 14:
                    d = ((double) (255 * f)) * 0.75d;
                    return (((int) d) << 24) + ViewCompat.MEASURED_SIZE_MASK;
                case 15:
                    d = ((double) (255 * f)) * 0.97d;
                    return (((int) d) << 24) + ViewCompat.MEASURED_SIZE_MASK;
                case 16:
                    d2 = 255 * f;
                    d3 = 0.9d;
                    return (((int) (d2 * d3)) << 24) + 2434341;
                case 17:
                    d4 = ((double) (255 * f)) * 0.78d;
                    return (((int) d4) << 24) + 13092807;
                case 18:
                    d2 = 255 * f;
                    d3 = 0.7d;
                    return (((int) (d2 * d3)) << 24) + 2434341;
                case 19:
                    d2 = 255 * f;
                    d3 = 0.55d;
                    return (((int) (d2 * d3)) << 24) + 2434341;
                case 20:
                    return ((int) (((double) (255 * f)) * 0.75d)) << 24;
                case 21:
                    d4 = ((double) (255 * f)) * 0.97d;
                    return (((int) d4) << 24) + 13092807;
                default:
                    d = ((double) (255 * f)) * 0.44d;
                    return (((int) d) << 24) + ViewCompat.MEASURED_SIZE_MASK;
            }
        } else {
            i = ((int) (((double) (255 * f)) * 0.69d)) << 24;
            i2 = 1644825;
        }
        return i + i2;
    }
}
