package org.apache.commons.lang3.time;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.apache.commons.lang3.LocaleUtils;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractFormatCache {
    private static final ConcurrentMap dateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap instanceCache = new ConcurrentHashMap(7);

    protected abstract Format createInstance(String str, TimeZone timeZone, Locale locale);

    AbstractFormatCache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ArrayKey {
        private final int hashCode;
        private final Object[] keys;

        ArrayKey(Object... objArr) {
            this.keys = objArr;
            this.hashCode = Objects.hash(objArr);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ArrayKey.class == obj.getClass()) {
                return Arrays.deepEquals(this.keys, ((ArrayKey) obj).keys);
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    static String getPatternForStyle(final Integer num, final Integer num2, Locale locale) {
        final Locale locale2 = LocaleUtils.toLocale(locale);
        return (String) dateTimeInstanceCache.computeIfAbsent(new ArrayKey(num, num2, locale2), new Function() { // from class: org.apache.commons.lang3.time.AbstractFormatCache$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return AbstractFormatCache.lambda$getPatternForStyle$0(num, num2, locale2, (AbstractFormatCache.ArrayKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getPatternForStyle$0(Integer num, Integer num2, Locale locale, ArrayKey arrayKey) {
        DateFormat dateTimeInstance;
        try {
            if (num == null) {
                dateTimeInstance = DateFormat.getTimeInstance(num2.intValue(), locale);
            } else if (num2 == null) {
                dateTimeInstance = DateFormat.getDateInstance(num.intValue(), locale);
            } else {
                dateTimeInstance = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
            }
            return ((SimpleDateFormat) dateTimeInstance).toPattern();
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("No date time pattern for locale: " + locale);
        }
    }

    Format getDateInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), (Integer) null, timeZone, locale);
    }

    Format getDateTimeInstance(int i, int i2, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i), Integer.valueOf(i2), timeZone, locale);
    }

    private Format getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        Locale locale2 = LocaleUtils.toLocale(locale);
        return getInstance(getPatternForStyle(num, num2, locale2), timeZone, locale2);
    }

    public Format getInstance() {
        return getDateTimeInstance(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public Format getInstance(final String str, TimeZone timeZone, Locale locale) {
        Objects.requireNonNull(str, "pattern");
        final TimeZone timeZone2 = TimeZones.toTimeZone(timeZone);
        final Locale locale2 = LocaleUtils.toLocale(locale);
        return (Format) this.instanceCache.computeIfAbsent(new ArrayKey(str, timeZone2, locale2), new Function() { // from class: org.apache.commons.lang3.time.AbstractFormatCache$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$getInstance$0(str, timeZone2, locale2, (AbstractFormatCache.ArrayKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Format lambda$getInstance$0(String str, TimeZone timeZone, Locale locale, ArrayKey arrayKey) {
        return createInstance(str, timeZone, locale);
    }

    Format getTimeInstance(int i, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i), timeZone, locale);
    }
}
