package com.facebook.hermes.intl;

import androidx.core.text.util.LocalePreferences;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.disney.p026id.android.Guest;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import java.text.AttributedCharacterIterator;

/* JADX INFO: loaded from: classes3.dex */
public interface IPlatformDateTimeFormatter {
    void configure(ILocaleObject<?> iLocaleObject, String str, String str2, FormatMatcher formatMatcher, WeekDay weekDay, Era era, Year year, Month month, Day day, Hour hour, Minute minute, Second second, TimeZoneName timeZoneName, HourCycle hourCycle, Object obj, DateStyle dateStyle, TimeStyle timeStyle, Object obj2) throws JSRangeErrorException;

    String fieldToString(AttributedCharacterIterator.Attribute attribute, String str);

    String format(double d) throws JSRangeErrorException;

    AttributedCharacterIterator formatToParts(double d) throws JSRangeErrorException;

    String[] getAvailableLocales();

    String getDefaultCalendarName(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    HourCycle getDefaultHourCycle(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    String getDefaultNumberingSystem(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    String getDefaultTimeZone(ILocaleObject<?> iLocaleObject) throws JSRangeErrorException;

    public enum FormatMatcher {
        BESTFIT,
        BASIC;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3360xe3b8aa6e[ordinal()];
            if (i == 1) {
                return Constants.LOCALEMATCHER_BESTFIT;
            }
            if (i == 2) {
                return "basic";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum HourCycle {
        H11,
        H12,
        H23,
        H24,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3362xa1956815[ordinal()];
            if (i == 1) {
                return LocalePreferences.HourCycle.H11;
            }
            if (i == 2) {
                return LocalePreferences.HourCycle.H12;
            }
            if (i == 3) {
                return LocalePreferences.HourCycle.H23;
            }
            if (i == 4) {
                return LocalePreferences.HourCycle.H24;
            }
            if (i == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum WeekDay {
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3368x64abae7b[ordinal()];
            if (i == 1) {
                return LongTypedProperty.TYPE;
            }
            if (i == 2) {
                return "short";
            }
            if (i == 3) {
                return "narrow";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = C30621.f3368x64abae7b[ordinal()];
            if (i == 1) {
                return "EEEE";
            }
            if (i == 2) {
                return "EEE";
            }
            if (i == 3) {
                return "EEEEE";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Era {
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3359x7c20f247[ordinal()];
            if (i == 1) {
                return LongTypedProperty.TYPE;
            }
            if (i == 2) {
                return "short";
            }
            if (i == 3) {
                return "narrow";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = C30621.f3359x7c20f247[ordinal()];
            if (i == 1) {
                return "GGGG";
            }
            if (i == 2) {
                return "GGG";
            }
            if (i == 3) {
                return "G5";
            }
            if (i == 4) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Year {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3369x8063daa[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = C30621.f3369x8063daa[ordinal()];
            if (i == 1) {
                return "yyyy";
            }
            if (i == 2) {
                return "yy";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Month {
        NUMERIC,
        DIGIT2,
        LONG,
        SHORT,
        NARROW,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            switch (C30621.f3364xf81d1ab3[ordinal()]) {
                case 1:
                    return Constants.COLLATION_OPTION_NUMERIC;
                case 2:
                    return "2-digit";
                case 3:
                    return LongTypedProperty.TYPE;
                case 4:
                    return "short";
                case 5:
                    return "narrow";
                case 6:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }

        public String getSkeleonSymbol() {
            switch (C30621.f3364xf81d1ab3[ordinal()]) {
                case 1:
                    return "M";
                case 2:
                    return "MM";
                case 3:
                    return "MMMM";
                case 4:
                    return "MMM";
                case 5:
                    return "MMMMM";
                case 6:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public enum Day {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3358x7c20ec8f[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = C30621.f3358x7c20ec8f[ordinal()];
            if (i == 1) {
                return "d";
            }
            if (i == 2) {
                return "dd";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Hour {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3361x7feab51[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol12() {
            int i = C30621.f3361x7feab51[ordinal()];
            if (i == 1) {
                return "h";
            }
            if (i == 2) {
                return "hh";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol24() {
            int i = C30621.f3361x7feab51[ordinal()];
            if (i == 1) {
                return "k";
            }
            if (i == 2) {
                return "kk";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Minute {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3363xb31b441[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = C30621.f3363xb31b441[ordinal()];
            if (i == 1) {
                return "m";
            }
            if (i == 2) {
                return "mm";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Second {
        NUMERIC,
        DIGIT2,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3365x153152a1[ordinal()];
            if (i == 1) {
                return Constants.COLLATION_OPTION_NUMERIC;
            }
            if (i == 2) {
                return "2-digit";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }

        public String getSkeleonSymbol() {
            int i = C30621.f3365x153152a1[ordinal()];
            if (i == 1) {
                return CmcdData.Factory.STREAMING_FORMAT_SS;
            }
            if (i == 2) {
                return "ss";
            }
            if (i == 3) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    public enum TimeZoneName {
        LONG,
        LONGOFFSET,
        LONGGENERIC,
        SHORT,
        SHORTOFFSET,
        SHORTGENERIC,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            switch (C30621.f3367xb563eeb1[ordinal()]) {
                case 1:
                    return LongTypedProperty.TYPE;
                case 2:
                    return "longOffset";
                case 3:
                    return "longGeneric";
                case 4:
                    return "short";
                case 5:
                    return "shortOffset";
                case 6:
                    return "shortGeneric";
                case 7:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }

        public String getSkeleonSymbol() {
            switch (C30621.f3367xb563eeb1[ordinal()]) {
                case 1:
                    return "zzzz";
                case 2:
                    return "OOOO";
                case 3:
                    return "vvvv";
                case 4:
                    return "z";
                case 5:
                    return "O";
                case 6:
                    return "v";
                case 7:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public enum DateStyle {
        FULL,
        LONG,
        MEDIUM,
        SHORT,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3357x57fd8156[ordinal()];
            if (i == 1) {
                return Guest.PAYLOAD_FULL;
            }
            if (i == 2) {
                return LongTypedProperty.TYPE;
            }
            if (i == 3) {
                return "medium";
            }
            if (i == 4) {
                return "short";
            }
            if (i == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: com.facebook.hermes.intl.IPlatformDateTimeFormatter$1 */
    static /* synthetic */ class C30621 {

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$DateStyle */
        static final /* synthetic */ int[] f3357x57fd8156;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Day */
        static final /* synthetic */ int[] f3358x7c20ec8f;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Era */
        static final /* synthetic */ int[] f3359x7c20f247;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$FormatMatcher */
        static final /* synthetic */ int[] f3360xe3b8aa6e;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Hour */
        static final /* synthetic */ int[] f3361x7feab51;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$HourCycle */
        static final /* synthetic */ int[] f3362xa1956815;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Minute */
        static final /* synthetic */ int[] f3363xb31b441;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Month */
        static final /* synthetic */ int[] f3364xf81d1ab3;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Second */
        static final /* synthetic */ int[] f3365x153152a1;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeStyle */
        static final /* synthetic */ int[] f3366x69023997;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$TimeZoneName */
        static final /* synthetic */ int[] f3367xb563eeb1;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$WeekDay */
        static final /* synthetic */ int[] f3368x64abae7b;

        /* JADX INFO: renamed from: $SwitchMap$com$facebook$hermes$intl$IPlatformDateTimeFormatter$Year */
        static final /* synthetic */ int[] f3369x8063daa;

        static {
            int[] iArr = new int[TimeStyle.values().length];
            f3366x69023997 = iArr;
            try {
                iArr[TimeStyle.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3366x69023997[TimeStyle.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3366x69023997[TimeStyle.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3366x69023997[TimeStyle.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3366x69023997[TimeStyle.UNDEFINED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[DateStyle.values().length];
            f3357x57fd8156 = iArr2;
            try {
                iArr2[DateStyle.FULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3357x57fd8156[DateStyle.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3357x57fd8156[DateStyle.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3357x57fd8156[DateStyle.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3357x57fd8156[DateStyle.UNDEFINED.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr3 = new int[TimeZoneName.values().length];
            f3367xb563eeb1 = iArr3;
            try {
                iArr3[TimeZoneName.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3367xb563eeb1[TimeZoneName.LONGOFFSET.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3367xb563eeb1[TimeZoneName.LONGGENERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3367xb563eeb1[TimeZoneName.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3367xb563eeb1[TimeZoneName.SHORTOFFSET.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3367xb563eeb1[TimeZoneName.SHORTGENERIC.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3367xb563eeb1[TimeZoneName.UNDEFINED.ordinal()] = 7;
            } catch (NoSuchFieldError unused17) {
            }
            int[] iArr4 = new int[Second.values().length];
            f3365x153152a1 = iArr4;
            try {
                iArr4[Second.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f3365x153152a1[Second.DIGIT2.ordinal()] = 2;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f3365x153152a1[Second.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr5 = new int[Minute.values().length];
            f3363xb31b441 = iArr5;
            try {
                iArr5[Minute.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f3363xb31b441[Minute.DIGIT2.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f3363xb31b441[Minute.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            int[] iArr6 = new int[Hour.values().length];
            f3361x7feab51 = iArr6;
            try {
                iArr6[Hour.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f3361x7feab51[Hour.DIGIT2.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f3361x7feab51[Hour.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused26) {
            }
            int[] iArr7 = new int[Day.values().length];
            f3358x7c20ec8f = iArr7;
            try {
                iArr7[Day.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f3358x7c20ec8f[Day.DIGIT2.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f3358x7c20ec8f[Day.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            int[] iArr8 = new int[Month.values().length];
            f3364xf81d1ab3 = iArr8;
            try {
                iArr8[Month.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f3364xf81d1ab3[Month.DIGIT2.ordinal()] = 2;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f3364xf81d1ab3[Month.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f3364xf81d1ab3[Month.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f3364xf81d1ab3[Month.NARROW.ordinal()] = 5;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f3364xf81d1ab3[Month.UNDEFINED.ordinal()] = 6;
            } catch (NoSuchFieldError unused35) {
            }
            int[] iArr9 = new int[Year.values().length];
            f3369x8063daa = iArr9;
            try {
                iArr9[Year.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f3369x8063daa[Year.DIGIT2.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f3369x8063daa[Year.UNDEFINED.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr10 = new int[Era.values().length];
            f3359x7c20f247 = iArr10;
            try {
                iArr10[Era.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f3359x7c20f247[Era.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f3359x7c20f247[Era.NARROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                f3359x7c20f247[Era.UNDEFINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused42) {
            }
            int[] iArr11 = new int[WeekDay.values().length];
            f3368x64abae7b = iArr11;
            try {
                iArr11[WeekDay.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f3368x64abae7b[WeekDay.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f3368x64abae7b[WeekDay.NARROW.ordinal()] = 3;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f3368x64abae7b[WeekDay.UNDEFINED.ordinal()] = 4;
            } catch (NoSuchFieldError unused46) {
            }
            int[] iArr12 = new int[HourCycle.values().length];
            f3362xa1956815 = iArr12;
            try {
                iArr12[HourCycle.H11.ordinal()] = 1;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f3362xa1956815[HourCycle.H12.ordinal()] = 2;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f3362xa1956815[HourCycle.H23.ordinal()] = 3;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f3362xa1956815[HourCycle.H24.ordinal()] = 4;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f3362xa1956815[HourCycle.UNDEFINED.ordinal()] = 5;
            } catch (NoSuchFieldError unused51) {
            }
            int[] iArr13 = new int[FormatMatcher.values().length];
            f3360xe3b8aa6e = iArr13;
            try {
                iArr13[FormatMatcher.BESTFIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f3360xe3b8aa6e[FormatMatcher.BASIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused53) {
            }
        }
    }

    public enum TimeStyle {
        FULL,
        LONG,
        MEDIUM,
        SHORT,
        UNDEFINED;

        @Override // java.lang.Enum
        public String toString() {
            int i = C30621.f3366x69023997[ordinal()];
            if (i == 1) {
                return Guest.PAYLOAD_FULL;
            }
            if (i == 2) {
                return LongTypedProperty.TYPE;
            }
            if (i == 3) {
                return "medium";
            }
            if (i == 4) {
                return "short";
            }
            if (i == 5) {
                return "";
            }
            throw new IllegalArgumentException();
        }
    }
}
