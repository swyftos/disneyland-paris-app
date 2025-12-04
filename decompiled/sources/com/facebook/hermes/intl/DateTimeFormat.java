package com.facebook.hermes.intl;

import androidx.core.text.util.LocalePreferences;
import com.disney.id.android.Guest;
import com.facebook.hermes.intl.IPlatformDateTimeFormatter;
import com.facebook.hermes.intl.OptionHelpers;
import com.facebook.proguard.annotations.DoNotStrip;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import com.reactcommunity.rndatetimepicker.RNConstants;
import com.urbanairship.AirshipConfigOptions;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.codec.language.bm.Languages;

@DoNotStrip
/* loaded from: classes3.dex */
public class DateTimeFormat {
    private String mCalendar;
    private IPlatformDateTimeFormatter.DateStyle mDateStyle;
    private IPlatformDateTimeFormatter.Day mDay;
    private IPlatformDateTimeFormatter.Era mEra;
    private IPlatformDateTimeFormatter.FormatMatcher mFormatMatcher;
    private IPlatformDateTimeFormatter.Hour mHour;
    private Object mHour12;
    private IPlatformDateTimeFormatter.HourCycle mHourCycle;
    private IPlatformDateTimeFormatter.Minute mMinute;
    private IPlatformDateTimeFormatter.Month mMonth;
    private String mNumberingSystem;
    private IPlatformDateTimeFormatter.Second mSecond;
    private IPlatformDateTimeFormatter.TimeStyle mTimeStyle;
    private IPlatformDateTimeFormatter.TimeZoneName mTimeZoneName;
    private IPlatformDateTimeFormatter.WeekDay mWeekDay;
    private IPlatformDateTimeFormatter.Year mYear;
    private boolean useDefaultCalendar;
    private boolean useDefaultNumberSystem;
    private ILocaleObject mResolvedLocaleObject = null;
    private ILocaleObject mResolvedLocaleObjectForResolvedOptions = null;
    private Object mTimeZone = null;
    IPlatformDateTimeFormatter mPlatformDateTimeFormatter = new PlatformDateTimeFormatterICU();

    private boolean isLocaleIdType(String str) {
        return IntlTextUtils.isUnicodeExtensionKeyTypeItem(str, 0, str.length() - 1);
    }

    private Object ToDateTimeOptions(Object obj, String str, String str2) throws JSRangeErrorException {
        if (!JSObjects.isObject(obj)) {
            throw new JSRangeErrorException("Invalid options object !");
        }
        boolean z = true;
        if (str.equals("date") || str.equals(Languages.ANY)) {
            String[] strArr = {"weekday", "year", "month", "day"};
            for (int i = 0; i < 4; i++) {
                if (!JSObjects.isUndefined(JSObjects.Get(obj, strArr[i]))) {
                    z = false;
                }
            }
        }
        if (str.equals("time") || str.equals(Languages.ANY)) {
            String[] strArr2 = {"hour", "minute", "second"};
            for (int i2 = 0; i2 < 3; i2++) {
                if (!JSObjects.isUndefined(JSObjects.Get(obj, strArr2[i2]))) {
                    z = false;
                }
            }
        }
        if (!JSObjects.isUndefined(JSObjects.Get(obj, "dateStyle")) || !JSObjects.isUndefined(JSObjects.Get(obj, "timeStyle"))) {
            z = false;
        }
        if (z && (str2.equals("date") || str2.equals(AirshipConfigOptions.FEATURE_ALL))) {
            String[] strArr3 = {"year", "month", "day"};
            for (int i3 = 0; i3 < 3; i3++) {
                JSObjects.Put(obj, strArr3[i3], Constants.COLLATION_OPTION_NUMERIC);
            }
        }
        if (z && (str2.equals("time") || str2.equals(AirshipConfigOptions.FEATURE_ALL))) {
            String[] strArr4 = {"hour", "minute", "second"};
            for (int i4 = 0; i4 < 3; i4++) {
                JSObjects.Put(obj, strArr4[i4], Constants.COLLATION_OPTION_NUMERIC);
            }
        }
        return obj;
    }

    public String normalizeTimeZoneName(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                sb.append((char) (cCharAt + ' '));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public String normalizeTimeZone(String str) throws JSRangeErrorException {
        for (String str2 : TimeZone.getAvailableIDs()) {
            if (normalizeTimeZoneName(str2).equals(normalizeTimeZoneName(str))) {
                return str2;
            }
        }
        throw new JSRangeErrorException("Invalid timezone name!");
    }

    private Object DefaultTimeZone() {
        return this.mPlatformDateTimeFormatter.getDefaultTimeZone(this.mResolvedLocaleObject);
    }

    private void initializeDateTimeFormat(List list, Map map) throws JSRangeErrorException {
        Object objNormalizeTimeZone;
        List listAsList = Arrays.asList("ca", "nu", "hc");
        Object objToDateTimeOptions = ToDateTimeOptions(map, Languages.ANY, "date");
        Object objNewObject = JSObjects.newObject();
        OptionHelpers.OptionType optionType = OptionHelpers.OptionType.STRING;
        JSObjects.Put(objNewObject, Constants.LOCALEMATCHER, OptionHelpers.GetOption(objToDateTimeOptions, Constants.LOCALEMATCHER, optionType, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        Object objGetOption = OptionHelpers.GetOption(objToDateTimeOptions, "calendar", optionType, JSObjects.Undefined(), JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption) && !isLocaleIdType(JSObjects.getJavaString(objGetOption))) {
            throw new JSRangeErrorException("Invalid calendar option !");
        }
        JSObjects.Put(objNewObject, "ca", objGetOption);
        Object objGetOption2 = OptionHelpers.GetOption(objToDateTimeOptions, "numberingSystem", optionType, JSObjects.Undefined(), JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption2) && !isLocaleIdType(JSObjects.getJavaString(objGetOption2))) {
            throw new JSRangeErrorException("Invalid numbering system !");
        }
        JSObjects.Put(objNewObject, "nu", objGetOption2);
        Object objGetOption3 = OptionHelpers.GetOption(objToDateTimeOptions, "hour12", OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), JSObjects.Undefined());
        Object objGetOption4 = OptionHelpers.GetOption(objToDateTimeOptions, "hourCycle", optionType, new String[]{LocalePreferences.HourCycle.H11, LocalePreferences.HourCycle.H12, LocalePreferences.HourCycle.H23, LocalePreferences.HourCycle.H24}, JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption3)) {
            objGetOption4 = JSObjects.Null();
        }
        JSObjects.Put(objNewObject, "hc", objGetOption4);
        HashMap<String, Object> mapResolveLocale = LocaleResolver.resolveLocale(list, objNewObject, listAsList);
        ILocaleObject iLocaleObject = (ILocaleObject) JSObjects.getJavaMap(mapResolveLocale).get(Constants.LOCALE);
        this.mResolvedLocaleObject = iLocaleObject;
        this.mResolvedLocaleObjectForResolvedOptions = iLocaleObject.cloneObject();
        Object objGet = JSObjects.Get(mapResolveLocale, "ca");
        if (!JSObjects.isNull(objGet)) {
            this.useDefaultCalendar = false;
            this.mCalendar = JSObjects.getJavaString(objGet);
        } else {
            this.useDefaultCalendar = true;
            this.mCalendar = this.mPlatformDateTimeFormatter.getDefaultCalendarName(this.mResolvedLocaleObject);
        }
        Object objGet2 = JSObjects.Get(mapResolveLocale, "nu");
        if (!JSObjects.isNull(objGet2)) {
            this.useDefaultNumberSystem = false;
            this.mNumberingSystem = JSObjects.getJavaString(objGet2);
        } else {
            this.useDefaultNumberSystem = true;
            this.mNumberingSystem = this.mPlatformDateTimeFormatter.getDefaultNumberingSystem(this.mResolvedLocaleObject);
        }
        Object objGet3 = JSObjects.Get(mapResolveLocale, "hc");
        Object objGet4 = JSObjects.Get(objToDateTimeOptions, "timeZone");
        if (JSObjects.isUndefined(objGet4)) {
            objNormalizeTimeZone = DefaultTimeZone();
        } else {
            objNormalizeTimeZone = normalizeTimeZone(objGet4.toString());
        }
        this.mTimeZone = objNormalizeTimeZone;
        this.mFormatMatcher = (IPlatformDateTimeFormatter.FormatMatcher) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.FormatMatcher.class, JSObjects.getJavaString(OptionHelpers.GetOption(objToDateTimeOptions, "formatMatcher", optionType, new String[]{"basic", Constants.LOCALEMATCHER_BESTFIT}, Constants.LOCALEMATCHER_BESTFIT)));
        this.mWeekDay = (IPlatformDateTimeFormatter.WeekDay) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.WeekDay.class, OptionHelpers.GetOption(objToDateTimeOptions, "weekday", optionType, new String[]{LongTypedProperty.TYPE, "short", "narrow"}, JSObjects.Undefined()));
        this.mEra = (IPlatformDateTimeFormatter.Era) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Era.class, OptionHelpers.GetOption(objToDateTimeOptions, "era", optionType, new String[]{LongTypedProperty.TYPE, "short", "narrow"}, JSObjects.Undefined()));
        this.mYear = (IPlatformDateTimeFormatter.Year) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Year.class, OptionHelpers.GetOption(objToDateTimeOptions, "year", optionType, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
        this.mMonth = (IPlatformDateTimeFormatter.Month) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Month.class, OptionHelpers.GetOption(objToDateTimeOptions, "month", optionType, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit", LongTypedProperty.TYPE, "short", "narrow"}, JSObjects.Undefined()));
        this.mDay = (IPlatformDateTimeFormatter.Day) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Day.class, OptionHelpers.GetOption(objToDateTimeOptions, "day", optionType, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
        Object objGetOption5 = OptionHelpers.GetOption(objToDateTimeOptions, "hour", optionType, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined());
        this.mHour = (IPlatformDateTimeFormatter.Hour) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Hour.class, objGetOption5);
        this.mMinute = (IPlatformDateTimeFormatter.Minute) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Minute.class, OptionHelpers.GetOption(objToDateTimeOptions, "minute", optionType, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
        this.mSecond = (IPlatformDateTimeFormatter.Second) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.Second.class, OptionHelpers.GetOption(objToDateTimeOptions, "second", optionType, new String[]{Constants.COLLATION_OPTION_NUMERIC, "2-digit"}, JSObjects.Undefined()));
        this.mTimeZoneName = (IPlatformDateTimeFormatter.TimeZoneName) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.TimeZoneName.class, OptionHelpers.GetOption(objToDateTimeOptions, RNConstants.ARG_TZ_NAME, optionType, new String[]{LongTypedProperty.TYPE, "longOffset", "longGeneric", "short", "shortOffset", "shortGeneric"}, JSObjects.Undefined()));
        this.mDateStyle = (IPlatformDateTimeFormatter.DateStyle) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.DateStyle.class, OptionHelpers.GetOption(objToDateTimeOptions, "dateStyle", optionType, new String[]{Guest.PAYLOAD_FULL, LongTypedProperty.TYPE, "medium", "short"}, JSObjects.Undefined()));
        Object objGetOption6 = OptionHelpers.GetOption(objToDateTimeOptions, "timeStyle", optionType, new String[]{Guest.PAYLOAD_FULL, LongTypedProperty.TYPE, "medium", "short"}, JSObjects.Undefined());
        this.mTimeStyle = (IPlatformDateTimeFormatter.TimeStyle) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.TimeStyle.class, objGetOption6);
        if (JSObjects.isUndefined(objGetOption5) && JSObjects.isUndefined(objGetOption6)) {
            this.mHourCycle = IPlatformDateTimeFormatter.HourCycle.UNDEFINED;
        } else {
            IPlatformDateTimeFormatter.HourCycle defaultHourCycle = this.mPlatformDateTimeFormatter.getDefaultHourCycle(this.mResolvedLocaleObject);
            IPlatformDateTimeFormatter.HourCycle hourCycle = JSObjects.isNull(objGet3) ? defaultHourCycle : (IPlatformDateTimeFormatter.HourCycle) OptionHelpers.searchEnum(IPlatformDateTimeFormatter.HourCycle.class, objGet3);
            if (!JSObjects.isUndefined(objGetOption3)) {
                if (JSObjects.getJavaBoolean(objGetOption3)) {
                    hourCycle = IPlatformDateTimeFormatter.HourCycle.H11;
                    if (defaultHourCycle != hourCycle && defaultHourCycle != IPlatformDateTimeFormatter.HourCycle.H23) {
                        hourCycle = IPlatformDateTimeFormatter.HourCycle.H12;
                    }
                } else {
                    hourCycle = (defaultHourCycle == IPlatformDateTimeFormatter.HourCycle.H11 || defaultHourCycle == IPlatformDateTimeFormatter.HourCycle.H23) ? IPlatformDateTimeFormatter.HourCycle.H23 : IPlatformDateTimeFormatter.HourCycle.H24;
                }
            }
            this.mHourCycle = hourCycle;
        }
        this.mHour12 = objGetOption3;
    }

    @DoNotStrip
    public DateTimeFormat(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        initializeDateTimeFormat(list, map);
        this.mPlatformDateTimeFormatter.configure(this.mResolvedLocaleObject, this.useDefaultCalendar ? "" : this.mCalendar, this.useDefaultNumberSystem ? "" : this.mNumberingSystem, this.mFormatMatcher, this.mWeekDay, this.mEra, this.mYear, this.mMonth, this.mDay, this.mHour, this.mMinute, this.mSecond, this.mTimeZoneName, this.mHourCycle, this.mTimeZone, this.mDateStyle, this.mTimeStyle, this.mHour12);
    }

    @DoNotStrip
    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        String javaString = JSObjects.getJavaString(OptionHelpers.GetOption(map, Constants.LOCALEMATCHER, OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        String[] strArr = new String[list.size()];
        if (javaString.equals(Constants.LOCALEMATCHER_BESTFIT)) {
            return Arrays.asList(LocaleMatcher.bestFitSupportedLocales((String[]) list.toArray(strArr)));
        }
        return Arrays.asList(LocaleMatcher.lookupSupportedLocales((String[]) list.toArray(strArr)));
    }

    @DoNotStrip
    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Constants.LOCALE, this.mResolvedLocaleObjectForResolvedOptions.toCanonicalTag());
        linkedHashMap.put("numberingSystem", this.mNumberingSystem);
        linkedHashMap.put("calendar", this.mCalendar);
        linkedHashMap.put("timeZone", this.mTimeZone);
        IPlatformDateTimeFormatter.HourCycle hourCycle = this.mHourCycle;
        if (hourCycle != IPlatformDateTimeFormatter.HourCycle.UNDEFINED) {
            linkedHashMap.put("hourCycle", hourCycle.toString());
            IPlatformDateTimeFormatter.HourCycle hourCycle2 = this.mHourCycle;
            if (hourCycle2 == IPlatformDateTimeFormatter.HourCycle.H11 || hourCycle2 == IPlatformDateTimeFormatter.HourCycle.H12) {
                linkedHashMap.put("hour12", Boolean.TRUE);
            } else {
                linkedHashMap.put("hour12", Boolean.FALSE);
            }
        }
        IPlatformDateTimeFormatter.WeekDay weekDay = this.mWeekDay;
        if (weekDay != IPlatformDateTimeFormatter.WeekDay.UNDEFINED) {
            linkedHashMap.put("weekday", weekDay.toString());
        }
        IPlatformDateTimeFormatter.Era era = this.mEra;
        if (era != IPlatformDateTimeFormatter.Era.UNDEFINED) {
            linkedHashMap.put("era", era.toString());
        }
        IPlatformDateTimeFormatter.Year year = this.mYear;
        if (year != IPlatformDateTimeFormatter.Year.UNDEFINED) {
            linkedHashMap.put("year", year.toString());
        }
        IPlatformDateTimeFormatter.Month month = this.mMonth;
        if (month != IPlatformDateTimeFormatter.Month.UNDEFINED) {
            linkedHashMap.put("month", month.toString());
        }
        IPlatformDateTimeFormatter.Day day = this.mDay;
        if (day != IPlatformDateTimeFormatter.Day.UNDEFINED) {
            linkedHashMap.put("day", day.toString());
        }
        IPlatformDateTimeFormatter.Hour hour = this.mHour;
        if (hour != IPlatformDateTimeFormatter.Hour.UNDEFINED) {
            linkedHashMap.put("hour", hour.toString());
        }
        IPlatformDateTimeFormatter.Minute minute = this.mMinute;
        if (minute != IPlatformDateTimeFormatter.Minute.UNDEFINED) {
            linkedHashMap.put("minute", minute.toString());
        }
        IPlatformDateTimeFormatter.Second second = this.mSecond;
        if (second != IPlatformDateTimeFormatter.Second.UNDEFINED) {
            linkedHashMap.put("second", second.toString());
        }
        IPlatformDateTimeFormatter.TimeZoneName timeZoneName = this.mTimeZoneName;
        if (timeZoneName != IPlatformDateTimeFormatter.TimeZoneName.UNDEFINED) {
            linkedHashMap.put(RNConstants.ARG_TZ_NAME, timeZoneName.toString());
        }
        IPlatformDateTimeFormatter.DateStyle dateStyle = this.mDateStyle;
        if (dateStyle != IPlatformDateTimeFormatter.DateStyle.UNDEFINED) {
            linkedHashMap.put("dateStyle", dateStyle.toString());
        }
        IPlatformDateTimeFormatter.TimeStyle timeStyle = this.mTimeStyle;
        if (timeStyle != IPlatformDateTimeFormatter.TimeStyle.UNDEFINED) {
            linkedHashMap.put("timeStyle", timeStyle.toString());
        }
        return linkedHashMap;
    }

    @DoNotStrip
    public String format(double d) throws JSRangeErrorException {
        return this.mPlatformDateTimeFormatter.format(d);
    }

    @DoNotStrip
    public List<Map<String, String>> formatToParts(double d) throws JSRangeErrorException {
        String strFieldToString;
        ArrayList arrayList = new ArrayList();
        AttributedCharacterIterator toParts = this.mPlatformDateTimeFormatter.formatToParts(d);
        StringBuilder sb = new StringBuilder();
        for (char cFirst = toParts.first(); cFirst != 65535; cFirst = toParts.next()) {
            sb.append(cFirst);
            if (toParts.getIndex() + 1 == toParts.getRunLimit()) {
                Iterator<AttributedCharacterIterator.Attribute> it = toParts.getAttributes().keySet().iterator();
                if (it.hasNext()) {
                    strFieldToString = this.mPlatformDateTimeFormatter.fieldToString(it.next(), sb.toString());
                } else {
                    strFieldToString = "literal";
                }
                String string = sb.toString();
                sb.setLength(0);
                HashMap map = new HashMap();
                map.put("type", strFieldToString);
                map.put("value", string);
                arrayList.add(map);
            }
        }
        return arrayList;
    }
}
