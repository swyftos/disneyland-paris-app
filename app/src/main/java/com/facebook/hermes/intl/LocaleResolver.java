package com.facebook.hermes.intl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LocaleResolver {
    public static HashMap<String, Object> resolveLocale(List<String> list, Object obj, List<String> list2) throws JSRangeErrorException {
        LocaleMatcher.LocaleMatchResult localeMatchResultBestFitMatch;
        Object obj2;
        Object objNewBoolean;
        Object objNewString;
        HashMap<String, Object> map = new HashMap<>();
        if (JSObjects.getJavaString(JSObjects.Get(obj, Constants.LOCALEMATCHER)).equals(Constants.LOCALEMATCHER_LOOKUP)) {
            localeMatchResultBestFitMatch = LocaleMatcher.lookupMatch((String[]) list.toArray(new String[list.size()]));
        } else {
            localeMatchResultBestFitMatch = LocaleMatcher.bestFitMatch((String[]) list.toArray(new String[list.size()]));
        }
        HashSet<String> hashSet = new HashSet();
        for (String str : list2) {
            Object objNull = JSObjects.Null();
            if (!localeMatchResultBestFitMatch.extensions.isEmpty() && localeMatchResultBestFitMatch.extensions.containsKey(str)) {
                String str2 = localeMatchResultBestFitMatch.extensions.get(str);
                if (str2.isEmpty()) {
                    obj2 = objNull;
                    obj2 = objNull;
                    objNewString = str2;
                    objNewString = JSObjects.newString("true");
                }
                obj2 = objNull;
                obj2 = objNull;
                objNewString = str2;
                hashSet.add(str);
                obj2 = objNewString;
            }
            obj2 = objNull;
            obj2 = objNull;
            obj2 = objNull;
            Object obj3 = obj2;
            if (JSObjects.getJavaMap(obj).containsKey(str)) {
                Object objGet = JSObjects.Get(obj, str);
                if (JSObjects.isString(objGet) && JSObjects.getJavaString(objGet).isEmpty()) {
                    objNewBoolean = objGet;
                    objNewBoolean = objGet;
                    objNewBoolean = JSObjects.newBoolean(true);
                }
                objNewBoolean = objGet;
                objNewBoolean = objGet;
                objNewBoolean = objGet;
                obj3 = obj2;
                if (!JSObjects.isUndefined(objNewBoolean) && !objNewBoolean.equals(obj2)) {
                    obj3 = obj2;
                    hashSet.remove(str);
                    obj3 = objNewBoolean;
                }
            }
            obj3 = obj2;
            boolean zIsNull = JSObjects.isNull(obj3);
            Object objResolveKnownAliases = obj3;
            if (!zIsNull) {
                objResolveKnownAliases = UnicodeExtensionKeys.resolveKnownAliases(str, obj3);
            }
            if (JSObjects.isString(objResolveKnownAliases) && !UnicodeExtensionKeys.isValidKeyword(str, JSObjects.getJavaString(objResolveKnownAliases), localeMatchResultBestFitMatch.matchedLocale)) {
                map.put(str, JSObjects.Null());
            } else {
                map.put(str, objResolveKnownAliases);
            }
        }
        for (String str3 : hashSet) {
            ArrayList<String> arrayList = new ArrayList<>();
            String javaString = JSObjects.getJavaString(UnicodeExtensionKeys.resolveKnownAliases(str3, JSObjects.newString(localeMatchResultBestFitMatch.extensions.get(str3))));
            if (!JSObjects.isString(javaString) || UnicodeExtensionKeys.isValidKeyword(str3, JSObjects.getJavaString(javaString), localeMatchResultBestFitMatch.matchedLocale)) {
                arrayList.add(javaString);
                localeMatchResultBestFitMatch.matchedLocale.setUnicodeExtensions(str3, arrayList);
            }
        }
        map.put(Constants.LOCALE, localeMatchResultBestFitMatch.matchedLocale);
        return map;
    }
}
