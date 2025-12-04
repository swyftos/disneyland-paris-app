package com.zoontek.rnlocalize;

import android.app.Activity;
import android.content.Intent;
import android.icu.number.NumberFormatter;
import android.icu.util.MeasureUnit;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.core.os.LocaleListCompat;
import androidx.core.text.util.LocalePreferences;
import com.contentsquare.android.api.Currencies;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.urbanairship.AirshipConfigOptions;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u001f\u0010\u0011\u001a\n \u000f*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b!\u0010 J\u0015\u0010#\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b%\u0010\u001dJ\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b&\u0010\u001aJ\u0015\u0010(\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b*\u0010)J\u0015\u0010+\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b,\u0010)J\u001d\u00100\u001a\u00020/2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105¨\u00067"}, d2 = {"Lcom/zoontek/rnlocalize/RNLocalizeModuleImpl;", "", "<init>", "()V", "", "languageCode", "scriptCode", "countryCode", "createLanguageTag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Locale;", Constants.LOCALE, "getCountryCodeForLocale", "(Ljava/util/Locale;)Ljava/lang/String;", "getCurrencyCodeForLocale", "kotlin.jvm.PlatformType", "getLanguageCodeForLocale", "getScriptCodeForLocale", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactContext", "getSystemLocale", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/Locale;", "", "getSystemLocales", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/util/List;", "getMiuiRegionCode", "()Ljava/lang/String;", "getCalendar", "getCountry", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Ljava/lang/String;", "Lcom/facebook/react/bridge/WritableArray;", "getCurrencies", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Lcom/facebook/react/bridge/WritableArray;", "getLocales", "Lcom/facebook/react/bridge/WritableMap;", "getNumberFormatSettings", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Lcom/facebook/react/bridge/WritableMap;", "getTemperatureUnit", "getTimeZone", "", "uses24HourClock", "(Lcom/facebook/react/bridge/ReactApplicationContext;)Z", "usesMetricSystem", "usesAutoDateAndTime", "usesAutoTimeZone", "Lcom/facebook/react/bridge/Promise;", BaseJavaModule.METHOD_TYPE_PROMISE, "", "openAppLanguageSettings", "(Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/bridge/Promise;)V", "NAME", "Ljava/lang/String;", "USES_FAHRENHEIT", "Ljava/util/List;", "USES_IMPERIAL", "react-native-localize_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRNLocalizeModuleImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RNLocalizeModuleImpl.kt\ncom/zoontek/rnlocalize/RNLocalizeModuleImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,248:1\n1#2:249\n1863#3,2:250\n*S KotlinDebug\n*F\n+ 1 RNLocalizeModuleImpl.kt\ncom/zoontek/rnlocalize/RNLocalizeModuleImpl\n*L\n134#1:250,2\n*E\n"})
/* loaded from: classes5.dex */
public final class RNLocalizeModuleImpl {

    @NotNull
    public static final String NAME = "RNLocalize";

    @NotNull
    public static final RNLocalizeModuleImpl INSTANCE = new RNLocalizeModuleImpl();
    private static final List USES_FAHRENHEIT = CollectionsKt.listOf((Object[]) new String[]{"BS", "BZ", "KY", "PR", "PW", AirshipConfigOptions.SITE_US});
    private static final List USES_IMPERIAL = CollectionsKt.listOf((Object[]) new String[]{"LR", "MM", AirshipConfigOptions.SITE_US});

    private RNLocalizeModuleImpl() {
    }

    private final String createLanguageTag(String languageCode, String scriptCode, String countryCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(languageCode);
        if (scriptCode.length() > 0) {
            sb.append("-" + scriptCode);
        }
        sb.append("-" + countryCode);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String getCountryCodeForLocale(Locale locale) {
        try {
            String country = locale.getCountry();
            if (Intrinsics.areEqual(country, "419")) {
                return "UN";
            }
            Intrinsics.checkNotNull(country);
            if (country.length() <= 0) {
                return "";
            }
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String upperCase = country.toUpperCase(locale2);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        } catch (Exception unused) {
            return "";
        }
    }

    private final String getCurrencyCodeForLocale(Locale locale) {
        try {
            Currency currency = Currency.getInstance(locale);
            if (currency == null) {
                return "";
            }
            String currencyCode = currency.getCurrencyCode();
            return currencyCode == null ? "" : currencyCode;
        } catch (Exception unused) {
            return "";
        }
    }

    private final String getLanguageCodeForLocale(Locale locale) {
        String language = locale.getLanguage();
        if (language == null) {
            return language;
        }
        int iHashCode = language.hashCode();
        return iHashCode != 3365 ? iHashCode != 3374 ? (iHashCode == 3391 && language.equals("ji")) ? "yi" : language : !language.equals("iw") ? language : "he" : !language.equals("in") ? language : "id";
    }

    private final String getScriptCodeForLocale(Locale locale) {
        String script = locale.getScript();
        return script.length() == 0 ? "" : script;
    }

    private final Locale getSystemLocale(ReactApplicationContext reactContext) {
        Locale locale = reactContext.getResources().getConfiguration().getLocales().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "get(...)");
        return locale;
    }

    private final List getSystemLocales(ReactApplicationContext reactContext) {
        reactContext.getResources().getConfiguration();
        LocaleListCompat localeListCompat = LocaleListCompat.getDefault();
        Intrinsics.checkNotNullExpressionValue(localeListCompat, "getDefault(...)");
        int size = localeListCompat.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Locale locale = localeListCompat.get(i);
            Intrinsics.checkNotNull(locale);
            arrayList.add(locale);
        }
        return arrayList;
    }

    private final String getMiuiRegionCode() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class).invoke(cls, "ro.miui.region");
            Objects.requireNonNull(objInvoke);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (Exception unused) {
            return "";
        }
    }

    @NotNull
    public final String getCalendar() {
        return LocalePreferences.CalendarType.GREGORIAN;
    }

    @NotNull
    public final String getCountry(@NotNull ReactApplicationContext reactContext) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        String miuiRegionCode = getMiuiRegionCode();
        String countryCodeForLocale = getCountryCodeForLocale(getSystemLocale(reactContext));
        return miuiRegionCode.length() > 0 ? miuiRegionCode : countryCodeForLocale.length() == 0 ? AirshipConfigOptions.SITE_US : countryCodeForLocale;
    }

    @NotNull
    public final WritableArray getCurrencies(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List systemLocales = getSystemLocales(reactContext);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator it = systemLocales.iterator();
        while (it.hasNext()) {
            String currencyCodeForLocale = INSTANCE.getCurrencyCodeForLocale((Locale) it.next());
            if (currencyCodeForLocale.length() > 0 && linkedHashSet.add(currencyCodeForLocale)) {
                writableArrayCreateArray.pushString(currencyCodeForLocale);
            }
        }
        if (writableArrayCreateArray.size() == 0) {
            writableArrayCreateArray.pushString(Currencies.AlphabeticCode.USD_STR);
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    @NotNull
    public final WritableArray getLocales(@NotNull ReactApplicationContext reactContext) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        List<Locale> systemLocales = getSystemLocales(reactContext);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        WritableArray writableArrayCreateArray = Arguments.createArray();
        String country = getCountry(reactContext);
        for (Locale locale : systemLocales) {
            String languageCodeForLocale = getLanguageCodeForLocale(locale);
            String scriptCodeForLocale = getScriptCodeForLocale(locale);
            String countryCodeForLocale = getCountryCodeForLocale(locale);
            if (countryCodeForLocale.length() == 0) {
                countryCodeForLocale = country;
            }
            Intrinsics.checkNotNull(languageCodeForLocale);
            Intrinsics.checkNotNull(scriptCodeForLocale);
            String strCreateLanguageTag = createLanguageTag(languageCodeForLocale, scriptCodeForLocale, countryCodeForLocale);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("languageCode", languageCodeForLocale);
            writableMapCreateMap.putString("countryCode", countryCodeForLocale);
            writableMapCreateMap.putString("languageTag", strCreateLanguageTag);
            writableMapCreateMap.putBoolean("isRTL", TextUtils.getLayoutDirectionFromLocale(locale) == 1);
            if (scriptCodeForLocale.length() > 0) {
                writableMapCreateMap.putString("scriptCode", scriptCodeForLocale);
            }
            if (linkedHashSet.add(strCreateLanguageTag)) {
                writableArrayCreateArray.pushMap(writableMapCreateMap);
            }
        }
        Intrinsics.checkNotNull(writableArrayCreateArray);
        return writableArrayCreateArray;
    }

    @NotNull
    public final WritableMap getNumberFormatSettings(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(getSystemLocale(reactContext));
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("decimalSeparator", String.valueOf(decimalFormatSymbols.getDecimalSeparator()));
        writableMapCreateMap.putString("groupingSeparator", String.valueOf(decimalFormatSymbols.getGroupingSeparator()));
        Intrinsics.checkNotNullExpressionValue(writableMapCreateMap, "apply(...)");
        return writableMapCreateMap;
    }

    @NotNull
    public final String getTemperatureUnit(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        if (Build.VERSION.SDK_INT >= 33) {
            String identifier = RNLocalizeModuleImpl$$ExternalSyntheticApiModelOutline2.m(RNLocalizeModuleImpl$$ExternalSyntheticApiModelOutline2.m(NumberFormatter.with().usage("weather")).unit(MeasureUnit.CELSIUS)).locale(getSystemLocale(reactContext)).format(1L).getOutputUnit().getIdentifier();
            Intrinsics.checkNotNull(identifier);
            if (!StringsKt.startsWith$default(identifier, LocalePreferences.TemperatureUnit.FAHRENHEIT, false, 2, (Object) null)) {
                return LocalePreferences.TemperatureUnit.CELSIUS;
            }
        } else if (!USES_FAHRENHEIT.contains(getCountry(reactContext))) {
            return LocalePreferences.TemperatureUnit.CELSIUS;
        }
        return "fahrenheit";
    }

    @NotNull
    public final String getTimeZone() {
        String id = TimeZone.getDefault().getID();
        Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
        return id;
    }

    public final boolean uses24HourClock(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return DateFormat.is24HourFormat(reactContext);
    }

    public final boolean usesMetricSystem(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return !USES_IMPERIAL.contains(getCountry(reactContext));
    }

    public final boolean usesAutoDateAndTime(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return Settings.Global.getInt(reactContext.getContentResolver(), "auto_time", 0) != 0;
    }

    public final boolean usesAutoTimeZone(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return Settings.Global.getInt(reactContext.getContentResolver(), "auto_time_zone", 0) != 0;
    }

    public final void openAppLanguageSettings(@NotNull ReactApplicationContext reactContext, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (Build.VERSION.SDK_INT < 33) {
            promise.reject("unsupported", "openAppLanguageSettings is supported only on Android 13+");
            return;
        }
        try {
            String packageName = reactContext.getPackageName();
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_LOCALE_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, null));
            Activity currentActivity = reactContext.getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(intent);
            }
            promise.resolve(Boolean.TRUE);
        } catch (Exception e) {
            promise.reject("E_INVALID_ACTIVITY", e);
        }
    }
}
