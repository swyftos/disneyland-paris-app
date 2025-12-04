package com.facebook.hermes.intl;

import java.util.ArrayList;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class ParsedLocaleIdentifier {
    ParsedLanguageIdentifier languageIdentifier;
    TreeMap otherExtensionsMap;
    ArrayList puExtensions;
    TreeMap transformedExtensionFields;
    ParsedLanguageIdentifier transformedLanguageIdentifier;
    ArrayList unicodeExtensionAttributes;
    TreeMap unicodeExtensionKeywords;

    public static class ParsedLanguageIdentifier {
        String languageSubtag;
        String regionSubtag;
        String scriptSubtag;
        ArrayList variantSubtagList;
    }
}
