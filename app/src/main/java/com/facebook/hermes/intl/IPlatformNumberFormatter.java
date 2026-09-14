package com.facebook.hermes.intl;

import android.icu.text.MeasureFormat;
import androidx.annotation.RequiresApi;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.text.AttributedCharacterIterator;

/* JADX INFO: loaded from: classes3.dex */
public interface IPlatformNumberFormatter {

    public enum RoundingType {
        SIGNIFICANT_DIGITS,
        FRACTION_DIGITS,
        COMPACT_ROUNDING
    }

    IPlatformNumberFormatter configure(ILocaleObject<?> iLocaleObject, String str, Style style, CurrencySign currencySign, Notation notation, CompactDisplay compactDisplay) throws JSRangeErrorException;

    String fieldToString(AttributedCharacterIterator.Attribute attribute, double d);

    String format(double d) throws JSRangeErrorException;

    AttributedCharacterIterator formatToParts(double d) throws JSRangeErrorException;

    String[] getAvailableLocales();

    String getDefaultNumberingSystem(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    IPlatformNumberFormatter setCurrency(String str, CurrencyDisplay currencyDisplay) throws JSRangeErrorException;

    IPlatformNumberFormatter setFractionDigits(RoundingType roundingType, int i, int i2);

    IPlatformNumberFormatter setGrouping(boolean z);

    IPlatformNumberFormatter setMinIntergerDigits(int i);

    IPlatformNumberFormatter setSignDisplay(SignDisplay signDisplay);

    IPlatformNumberFormatter setSignificantDigits(RoundingType roundingType, int i, int i2) throws JSRangeErrorException;

    IPlatformNumberFormatter setUnits(String str, UnitDisplay unitDisplay) throws JSRangeErrorException;

    public enum Style {
        DECIMAL,
        PERCENT,
        CURRENCY,
        UNIT;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30631.f3375x5b95aa76[ordinal()];
            if (i == 1) {
                return "decimal";
            }
            if (i == 2) {
                return "percent";
            }
            if (i == 3) {
                return TCEventPropertiesNames.TCE_CURRENCY;
            }
            if (i == 4) {
                return "unit";
            }
            throw new IllegalArgumentException();
        }

        public int getInitialNumberFormatStyle(Notation notation, CurrencySign currencySign) throws JSRangeErrorException {
            int i = C30631.f3375x5b95aa76[ordinal()];
            if (i == 2) {
                return 2;
            }
            if (i != 3) {
                return (notation == Notation.SCIENTIFIC || notation == Notation.ENGINEERING) ? 3 : 0;
            }
            if (currencySign == CurrencySign.ACCOUNTING) {
                return 7;
            }
            if (currencySign == CurrencySign.STANDARD) {
                return 1;
            }
            throw new JSRangeErrorException("Unrecognized formatting style requested.");
        }
    }

    public enum Notation {
        STANDARD,
        SCIENTIFIC,
        ENGINEERING,
        COMPACT;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30631.f3373xb4c7dd1d[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_STANDARD;
            }
            if (i == 2) {
                return "scientific";
            }
            if (i == 3) {
                return "engineering";
            }
            if (i == 4) {
                return "compact";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum CompactDisplay {
        SHORT,
        LONG;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30631.f3370xca0e38fa[ordinal()];
            if (i == 1) {
                return "short";
            }
            if (i == 2) {
                return LongTypedProperty.TYPE;
            }
            throw new IllegalArgumentException();
        }
    }

    public enum SignDisplay {
        AUTO,
        ALWAYS,
        NEVER,
        EXCEPTZERO;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30631.f3374xa920794a[ordinal()];
            if (i == 1) {
                return "auto";
            }
            if (i == 2) {
                return "always";
            }
            if (i == 3) {
                return "never";
            }
            if (i == 4) {
                return "exceptZero";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum UnitDisplay {
        SHORT,
        NARROW,
        LONG;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30631.f3376x3028ffa3[ordinal()];
            if (i == 1) {
                return "short";
            }
            if (i == 2) {
                return "narrow";
            }
            if (i == 3) {
                return LongTypedProperty.TYPE;
            }
            throw new IllegalArgumentException();
        }

        @RequiresApi(api = 24)
        public MeasureFormat.FormatWidth getFormatWidth() {
            int i = C30631.f3376x3028ffa3[ordinal()];
            if (i == 2) {
                return MeasureFormat.FormatWidth.NARROW;
            }
            if (i == 3) {
                return MeasureFormat.FormatWidth.WIDE;
            }
            return MeasureFormat.FormatWidth.SHORT;
        }
    }

    public enum CurrencyDisplay {
        SYMBOL,
        NARROWSYMBOL,
        CODE,
        NAME;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30631.f3371x4080d5f6[ordinal()];
            if (i == 1) {
                return "symbol";
            }
            if (i == 2) {
                return "narrowSymbol";
            }
            if (i == 3) {
                return "code";
            }
            if (i == 4) {
                return "name";
            }
            throw new IllegalArgumentException();
        }

        public int getNameStyle() {
            return C30631.f3371x4080d5f6[ordinal()] != 4 ? 0 : 1;
        }
    }

    /* JADX INFO: renamed from: com.facebook.hermes.intl.IPlatformNumberFormatter$1 */
    static /* synthetic */ class C30631 {

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$CompactDisplay */
        static final /* synthetic */ int[] f3370xca0e38fa;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$CurrencyDisplay */
        static final /* synthetic */ int[] f3371x4080d5f6;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$CurrencySign */
        static final /* synthetic */ int[] f3372x1c724d09;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$Notation */
        static final /* synthetic */ int[] f3373xb4c7dd1d;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$SignDisplay */
        static final /* synthetic */ int[] f3374xa920794a;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$Style */
        static final /* synthetic */ int[] f3375x5b95aa76;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformNumberFormatter$UnitDisplay */
        static final /* synthetic */ int[] f3376x3028ffa3;

        static {
            int[] iArr = new int[CurrencySign.values().length];
            f3372x1c724d09 = iArr;
            try {
                iArr[CurrencySign.ACCOUNTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3372x1c724d09[CurrencySign.STANDARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CurrencyDisplay.values().length];
            f3371x4080d5f6 = iArr2;
            try {
                iArr2[CurrencyDisplay.SYMBOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3371x4080d5f6[CurrencyDisplay.NARROWSYMBOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3371x4080d5f6[CurrencyDisplay.CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3371x4080d5f6[CurrencyDisplay.NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[UnitDisplay.values().length];
            f3376x3028ffa3 = iArr3;
            try {
                iArr3[UnitDisplay.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3376x3028ffa3[UnitDisplay.NARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3376x3028ffa3[UnitDisplay.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[SignDisplay.values().length];
            f3374xa920794a = iArr4;
            try {
                iArr4[SignDisplay.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3374xa920794a[SignDisplay.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3374xa920794a[SignDisplay.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3374xa920794a[SignDisplay.EXCEPTZERO.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            int[] iArr5 = new int[CompactDisplay.values().length];
            f3370xca0e38fa = iArr5;
            try {
                iArr5[CompactDisplay.SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3370xca0e38fa[CompactDisplay.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr6 = new int[Notation.values().length];
            f3373xb4c7dd1d = iArr6;
            try {
                iArr6[Notation.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3373xb4c7dd1d[Notation.SCIENTIFIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f3373xb4c7dd1d[Notation.ENGINEERING.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f3373xb4c7dd1d[Notation.COMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            int[] iArr7 = new int[Style.values().length];
            f3375x5b95aa76 = iArr7;
            try {
                iArr7[Style.DECIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f3375x5b95aa76[Style.PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f3375x5b95aa76[Style.CURRENCY.ordinal()] = 3;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f3375x5b95aa76[Style.UNIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    public enum CurrencySign {
        STANDARD,
        ACCOUNTING;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30631.f3372x1c724d09[ordinal()];
            if (i == 1) {
                return "accounting";
            }
            if (i == 2) {
                return Constants.COLLATION_STANDARD;
            }
            throw new IllegalArgumentException();
        }
    }
}
