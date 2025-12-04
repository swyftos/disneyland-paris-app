package com.facebook.hermes.intl;

import com.facebook.hermes.intl.IPlatformCollator;
import com.facebook.hermes.intl.OptionHelpers;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@DoNotStrip
/* loaded from: classes3.dex */
public class Collator {
    private IPlatformCollator.CaseFirst mResolvedCaseFirst;
    private boolean mResolvedIgnorePunctuation;
    private ILocaleObject mResolvedLocaleObject;
    private ILocaleObject mResolvedLocaleObjectForResolvedOptions;
    private boolean mResolvedNumeric;
    private IPlatformCollator.Sensitivity mResolvedSensitivity;
    private IPlatformCollator.Usage mResolvedUsage;
    private String mResolvedCollation = "default";
    private IPlatformCollator mPlatformCollatorObject = new PlatformCollatorICU();

    private void initializeCollator(List list, Map map) throws JSRangeErrorException {
        OptionHelpers.OptionType optionType = OptionHelpers.OptionType.STRING;
        this.mResolvedUsage = (IPlatformCollator.Usage) OptionHelpers.searchEnum(IPlatformCollator.Usage.class, JSObjects.getJavaString(OptionHelpers.GetOption(map, Constants.COLLATION_OPTION_USAGE, optionType, Constants.COLLATOR_USAGE_POSSIBLE_VALUES, Constants.SORT)));
        Object objNewObject = JSObjects.newObject();
        JSObjects.Put(objNewObject, Constants.LOCALEMATCHER, OptionHelpers.GetOption(map, Constants.LOCALEMATCHER, optionType, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT));
        Object objGetOption = OptionHelpers.GetOption(map, Constants.COLLATION_OPTION_NUMERIC, OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption)) {
            objGetOption = JSObjects.newString(String.valueOf(JSObjects.getJavaBoolean(objGetOption)));
        }
        JSObjects.Put(objNewObject, Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT, objGetOption);
        JSObjects.Put(objNewObject, Constants.COLLATION_EXTENSION_PARAM_CASEFIRST_SHORT, OptionHelpers.GetOption(map, Constants.COLLATION_OPTION_CASEFIRST, optionType, Constants.CASEFIRST_POSSIBLE_VALUES, JSObjects.Undefined()));
        HashMap<String, Object> mapResolveLocale = LocaleResolver.resolveLocale(list, objNewObject, Arrays.asList(Constants.COLLATION_EXTENSION_KEY_SHORT, Constants.COLLATION_EXTENSION_PARAM_CASEFIRST_SHORT, Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT));
        ILocaleObject iLocaleObject = (ILocaleObject) JSObjects.getJavaMap(mapResolveLocale).get(Constants.LOCALE);
        this.mResolvedLocaleObject = iLocaleObject;
        this.mResolvedLocaleObjectForResolvedOptions = iLocaleObject.cloneObject();
        Object objGet = JSObjects.Get(mapResolveLocale, Constants.COLLATION_EXTENSION_KEY_SHORT);
        if (JSObjects.isNull(objGet)) {
            objGet = JSObjects.newString("default");
        }
        this.mResolvedCollation = JSObjects.getJavaString(objGet);
        Object objGet2 = JSObjects.Get(mapResolveLocale, Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT);
        if (JSObjects.isNull(objGet2)) {
            this.mResolvedNumeric = false;
        } else {
            this.mResolvedNumeric = Boolean.parseBoolean(JSObjects.getJavaString(objGet2));
        }
        Object objGet3 = JSObjects.Get(mapResolveLocale, Constants.COLLATION_EXTENSION_PARAM_CASEFIRST_SHORT);
        if (JSObjects.isNull(objGet3)) {
            objGet3 = JSObjects.newString("false");
        }
        this.mResolvedCaseFirst = (IPlatformCollator.CaseFirst) OptionHelpers.searchEnum(IPlatformCollator.CaseFirst.class, JSObjects.getJavaString(objGet3));
        if (this.mResolvedUsage == IPlatformCollator.Usage.SEARCH) {
            ArrayList<String> unicodeExtensions = this.mResolvedLocaleObject.getUnicodeExtensions("collation");
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it = unicodeExtensions.iterator();
            while (it.hasNext()) {
                arrayList.add(UnicodeExtensionKeys.resolveCollationAlias(it.next()));
            }
            arrayList.add(UnicodeExtensionKeys.resolveCollationAlias("search"));
            this.mResolvedLocaleObject.setUnicodeExtensions(Constants.COLLATION_EXTENSION_KEY_SHORT, arrayList);
        }
        Object objGetOption2 = OptionHelpers.GetOption(map, Constants.COLLATION_OPTION_SENSITIVITY, OptionHelpers.OptionType.STRING, Constants.SENSITIVITY_POSSIBLE_VALUES, JSObjects.Undefined());
        if (!JSObjects.isUndefined(objGetOption2)) {
            this.mResolvedSensitivity = (IPlatformCollator.Sensitivity) OptionHelpers.searchEnum(IPlatformCollator.Sensitivity.class, JSObjects.getJavaString(objGetOption2));
        } else if (this.mResolvedUsage == IPlatformCollator.Usage.SORT) {
            this.mResolvedSensitivity = IPlatformCollator.Sensitivity.VARIANT;
        } else {
            this.mResolvedSensitivity = IPlatformCollator.Sensitivity.LOCALE;
        }
        this.mResolvedIgnorePunctuation = JSObjects.getJavaBoolean(OptionHelpers.GetOption(map, Constants.COLLATION_OPTION_IGNOREPUNCTUATION, OptionHelpers.OptionType.BOOLEAN, JSObjects.Undefined(), Boolean.FALSE));
    }

    @DoNotStrip
    public Collator(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        initializeCollator(list, map);
        this.mPlatformCollatorObject.configure(this.mResolvedLocaleObject).setNumericAttribute(this.mResolvedNumeric).setCaseFirstAttribute(this.mResolvedCaseFirst).setSensitivity(this.mResolvedSensitivity).setIgnorePunctuation(this.mResolvedIgnorePunctuation);
    }

    @DoNotStrip
    public static List<String> supportedLocalesOf(List<String> list, Map<String, Object> map) throws JSRangeErrorException {
        if (JSObjects.getJavaString(OptionHelpers.GetOption(map, Constants.LOCALEMATCHER, OptionHelpers.OptionType.STRING, Constants.LOCALEMATCHER_POSSIBLE_VALUES, Constants.LOCALEMATCHER_BESTFIT)).equals(Constants.LOCALEMATCHER_BESTFIT)) {
            return Arrays.asList(LocaleMatcher.bestFitSupportedLocales((String[]) list.toArray(new String[list.size()])));
        }
        return Arrays.asList(LocaleMatcher.lookupSupportedLocales((String[]) list.toArray(new String[list.size()])));
    }

    @DoNotStrip
    public Map<String, Object> resolvedOptions() throws JSRangeErrorException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Constants.LOCALE, this.mResolvedLocaleObjectForResolvedOptions.toCanonicalTag().replace("-kn-true", "-kn"));
        linkedHashMap.put(Constants.COLLATION_OPTION_USAGE, this.mResolvedUsage.toString());
        IPlatformCollator.Sensitivity sensitivity = this.mResolvedSensitivity;
        if (sensitivity == IPlatformCollator.Sensitivity.LOCALE) {
            linkedHashMap.put(Constants.COLLATION_OPTION_SENSITIVITY, this.mPlatformCollatorObject.getSensitivity().toString());
        } else {
            linkedHashMap.put(Constants.COLLATION_OPTION_SENSITIVITY, sensitivity.toString());
        }
        linkedHashMap.put(Constants.COLLATION_OPTION_IGNOREPUNCTUATION, Boolean.valueOf(this.mResolvedIgnorePunctuation));
        linkedHashMap.put("collation", this.mResolvedCollation);
        linkedHashMap.put(Constants.COLLATION_OPTION_NUMERIC, Boolean.valueOf(this.mResolvedNumeric));
        linkedHashMap.put(Constants.COLLATION_OPTION_CASEFIRST, this.mResolvedCaseFirst.toString());
        return linkedHashMap;
    }

    @DoNotStrip
    public double compare(String str, String str2) {
        return this.mPlatformCollatorObject.compare(str, str2);
    }
}
