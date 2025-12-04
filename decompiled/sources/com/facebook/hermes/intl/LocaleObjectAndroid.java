package com.facebook.hermes.intl;

import android.text.TextUtils;
import com.facebook.hermes.intl.ParsedLocaleIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class LocaleObjectAndroid implements ILocaleObject<Locale> {
    private boolean mIsDirty;
    private Locale mLocale;
    private ParsedLocaleIdentifier mParsedLocaleIdentifier;

    private LocaleObjectAndroid(Locale locale) {
        this.mParsedLocaleIdentifier = null;
        this.mIsDirty = false;
        this.mLocale = locale;
    }

    private LocaleObjectAndroid(String str) throws JSRangeErrorException {
        this.mLocale = null;
        this.mParsedLocaleIdentifier = null;
        this.mIsDirty = false;
        this.mParsedLocaleIdentifier = LocaleIdentifier.parseLocaleId(str);
        reInitFromParsedLocaleIdentifier();
    }

    private LocaleObjectAndroid(ParsedLocaleIdentifier parsedLocaleIdentifier) throws JSRangeErrorException {
        this.mLocale = null;
        this.mIsDirty = false;
        this.mParsedLocaleIdentifier = parsedLocaleIdentifier;
        reInitFromParsedLocaleIdentifier();
    }

    private void ensureParsedLocaleIdentifier() {
        if (this.mParsedLocaleIdentifier == null) {
            this.mParsedLocaleIdentifier = LocaleIdentifier.parseLocaleId(this.mLocale.toLanguageTag());
        }
    }

    private void reInitFromParsedLocaleIdentifier() throws JSRangeErrorException {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        String str = this.mParsedLocaleIdentifier.languageIdentifier.languageSubtag;
        if (str != null && !str.isEmpty()) {
            stringBuffer2.append(this.mParsedLocaleIdentifier.languageIdentifier.languageSubtag);
        }
        String str2 = this.mParsedLocaleIdentifier.languageIdentifier.scriptSubtag;
        if (str2 != null && !str2.isEmpty()) {
            stringBuffer3.append(this.mParsedLocaleIdentifier.languageIdentifier.scriptSubtag);
        }
        String str3 = this.mParsedLocaleIdentifier.languageIdentifier.regionSubtag;
        if (str3 != null && !str3.isEmpty()) {
            stringBuffer4.append(this.mParsedLocaleIdentifier.languageIdentifier.regionSubtag);
        }
        LocaleIdentifier.replaceLanguageSubtagIfNeeded(stringBuffer2, stringBuffer3, stringBuffer4);
        if (stringBuffer2.length() > 0) {
            stringBuffer.append(stringBuffer2.toString());
        }
        if (stringBuffer3.length() > 0) {
            stringBuffer.append("-");
            stringBuffer.append(stringBuffer3.toString());
        }
        if (stringBuffer4.length() > 0) {
            stringBuffer.append("-");
            stringBuffer.append(LocaleIdentifier.replaceRegionSubtagIfNeeded(stringBuffer4));
        }
        ArrayList arrayList = this.mParsedLocaleIdentifier.languageIdentifier.variantSubtagList;
        if (arrayList != null && !arrayList.isEmpty()) {
            stringBuffer.append("-");
            stringBuffer.append(TextUtils.join("-", this.mParsedLocaleIdentifier.languageIdentifier.variantSubtagList));
        }
        TreeMap treeMap = this.mParsedLocaleIdentifier.otherExtensionsMap;
        if (treeMap != null) {
            for (Map.Entry entry : treeMap.entrySet()) {
                stringBuffer.append("-");
                stringBuffer.append(entry.getKey());
                stringBuffer.append("-");
                stringBuffer.append(TextUtils.join("-", (Iterable) entry.getValue()));
            }
        }
        ParsedLocaleIdentifier parsedLocaleIdentifier = this.mParsedLocaleIdentifier;
        if (parsedLocaleIdentifier.transformedLanguageIdentifier != null || parsedLocaleIdentifier.transformedExtensionFields != null) {
            stringBuffer.append("-");
            stringBuffer.append('t');
            stringBuffer.append("-");
            StringBuffer stringBuffer5 = new StringBuffer();
            ParsedLocaleIdentifier.ParsedLanguageIdentifier parsedLanguageIdentifier = this.mParsedLocaleIdentifier.transformedLanguageIdentifier;
            if (parsedLanguageIdentifier != null) {
                stringBuffer5.append(parsedLanguageIdentifier.languageSubtag);
                if (this.mParsedLocaleIdentifier.transformedLanguageIdentifier.scriptSubtag != null) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(this.mParsedLocaleIdentifier.transformedLanguageIdentifier.scriptSubtag);
                }
                if (this.mParsedLocaleIdentifier.transformedLanguageIdentifier.regionSubtag != null) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(this.mParsedLocaleIdentifier.transformedLanguageIdentifier.regionSubtag);
                }
                ArrayList arrayList2 = this.mParsedLocaleIdentifier.transformedLanguageIdentifier.variantSubtagList;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    stringBuffer5.append("-");
                    stringBuffer5.append(TextUtils.join("-", this.mParsedLocaleIdentifier.transformedLanguageIdentifier.variantSubtagList));
                }
            }
            TreeMap treeMap2 = this.mParsedLocaleIdentifier.transformedExtensionFields;
            if (treeMap2 != null) {
                for (Map.Entry entry2 : treeMap2.entrySet()) {
                    String str4 = (String) entry2.getKey();
                    ArrayList arrayList3 = (ArrayList) entry2.getValue();
                    stringBuffer5.append("-" + str4);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        stringBuffer5.append("-" + ((String) it.next()));
                    }
                }
                if (stringBuffer5.length() > 0 && stringBuffer5.charAt(0) == '-') {
                    stringBuffer5.deleteCharAt(0);
                }
            }
            stringBuffer.append(stringBuffer5.toString());
        }
        ParsedLocaleIdentifier parsedLocaleIdentifier2 = this.mParsedLocaleIdentifier;
        if (parsedLocaleIdentifier2.unicodeExtensionAttributes != null || parsedLocaleIdentifier2.unicodeExtensionKeywords != null) {
            stringBuffer.append("-");
            stringBuffer.append('u');
            stringBuffer.append("-");
            StringBuffer stringBuffer6 = new StringBuffer();
            ArrayList arrayList4 = this.mParsedLocaleIdentifier.unicodeExtensionAttributes;
            if (arrayList4 != null) {
                stringBuffer6.append(TextUtils.join("-", arrayList4));
            }
            TreeMap treeMap3 = this.mParsedLocaleIdentifier.unicodeExtensionKeywords;
            if (treeMap3 != null) {
                for (Map.Entry entry3 : treeMap3.entrySet()) {
                    String str5 = (String) entry3.getKey();
                    ArrayList arrayList5 = (ArrayList) entry3.getValue();
                    stringBuffer6.append("-" + str5);
                    Iterator it2 = arrayList5.iterator();
                    while (it2.hasNext()) {
                        stringBuffer6.append("-" + ((String) it2.next()));
                    }
                }
            }
            if (stringBuffer6.length() > 0 && stringBuffer6.charAt(0) == '-') {
                stringBuffer6.deleteCharAt(0);
            }
            stringBuffer.append(stringBuffer6.toString());
        }
        if (this.mParsedLocaleIdentifier.puExtensions != null) {
            stringBuffer.append("-");
            stringBuffer.append('x');
            stringBuffer.append("-");
            stringBuffer.append(TextUtils.join("-", this.mParsedLocaleIdentifier.puExtensions));
        }
        try {
            this.mLocale = Locale.forLanguageTag(stringBuffer.toString());
            this.mIsDirty = false;
        } catch (RuntimeException e) {
            throw new JSRangeErrorException(e.getMessage());
        }
    }

    private void ensureNotDirty() throws JSRangeErrorException {
        if (this.mIsDirty) {
            try {
                reInitFromParsedLocaleIdentifier();
                this.mIsDirty = false;
            } catch (RuntimeException e) {
                throw new JSRangeErrorException(e.getMessage());
            }
        }
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public ArrayList<String> getUnicodeExtensions(String str) throws JSRangeErrorException {
        ArrayList<String> arrayList;
        ensureNotDirty();
        ensureParsedLocaleIdentifier();
        TreeMap treeMap = this.mParsedLocaleIdentifier.unicodeExtensionKeywords;
        return (treeMap == null || (arrayList = (ArrayList) treeMap.get(str)) == null) ? new ArrayList<>() : arrayList;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public HashMap<String, String> getUnicodeExtensions() throws JSRangeErrorException {
        HashMap<String, String> map = new HashMap<>();
        TreeMap treeMap = this.mParsedLocaleIdentifier.unicodeExtensionKeywords;
        if (treeMap != null) {
            for (String str : treeMap.keySet()) {
                map.put(str, TextUtils.join("-", (ArrayList) this.mParsedLocaleIdentifier.unicodeExtensionKeywords.get(str)));
            }
        }
        return map;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public void setUnicodeExtensions(String str, ArrayList<String> arrayList) throws JSRangeErrorException {
        ensureNotDirty();
        ensureParsedLocaleIdentifier();
        ParsedLocaleIdentifier parsedLocaleIdentifier = this.mParsedLocaleIdentifier;
        if (parsedLocaleIdentifier.unicodeExtensionKeywords == null) {
            parsedLocaleIdentifier.unicodeExtensionKeywords = new TreeMap();
        }
        if (!this.mParsedLocaleIdentifier.unicodeExtensionKeywords.containsKey(str)) {
            this.mParsedLocaleIdentifier.unicodeExtensionKeywords.put(str, new ArrayList());
        }
        ((ArrayList) this.mParsedLocaleIdentifier.unicodeExtensionKeywords.get(str)).clear();
        ((ArrayList) this.mParsedLocaleIdentifier.unicodeExtensionKeywords.get(str)).addAll(arrayList);
        this.mIsDirty = true;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public Locale getLocale() throws JSRangeErrorException {
        ensureNotDirty();
        return this.mLocale;
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public Locale getLocaleWithoutExtensions() throws JSRangeErrorException {
        ensureNotDirty();
        ensureParsedLocaleIdentifier();
        ParsedLocaleIdentifier parsedLocaleIdentifier = new ParsedLocaleIdentifier();
        parsedLocaleIdentifier.languageIdentifier = this.mParsedLocaleIdentifier.languageIdentifier;
        return new LocaleObjectAndroid(parsedLocaleIdentifier).getLocale();
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public String toCanonicalTag() throws JSRangeErrorException {
        return getLocale().toLanguageTag();
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public String toCanonicalTagWithoutExtensions() throws JSRangeErrorException {
        return getLocaleWithoutExtensions().toLanguageTag();
    }

    public static ILocaleObject<Locale> createFromLocaleId(String str) throws JSRangeErrorException {
        return new LocaleObjectAndroid(str);
    }

    public static ILocaleObject<Locale> createFromLocale(Locale locale) {
        return new LocaleObjectAndroid(locale);
    }

    public static ILocaleObject<Locale> createDefault() {
        return new LocaleObjectAndroid(Locale.getDefault());
    }

    @Override // com.facebook.hermes.intl.ILocaleObject
    public ILocaleObject<Locale> cloneObject() throws JSRangeErrorException {
        ensureNotDirty();
        return new LocaleObjectAndroid(this.mLocale);
    }
}
