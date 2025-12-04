package com.amazonaws.services.s3.internal;

import gherkin.GherkinLanguageConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* loaded from: classes2.dex */
public final class S3HttpUtils {
    private static final Pattern ENCODED_CHARACTERS_PATTERN = Pattern.compile(Pattern.quote(Marker.ANY_NON_NULL_MARKER) + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("*") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%7E") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%2F") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%3A") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%27") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%28") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%29") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%21") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%5B") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%5D") + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + Pattern.quote("%24"));

    public static String urlEncode(String str, boolean z) throws UnsupportedEncodingException {
        if (str == null) {
            return "";
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(strEncode);
            StringBuffer stringBuffer = new StringBuffer(strEncode.length());
            while (matcher.find()) {
                String strGroup = matcher.group(0);
                if (Marker.ANY_NON_NULL_MARKER.equals(strGroup)) {
                    strGroup = " ";
                } else if ("*".equals(strGroup)) {
                    strGroup = "%2A";
                } else if ("%7E".equals(strGroup)) {
                    strGroup = "~";
                } else if (z && "%2F".equals(strGroup)) {
                    strGroup = "/";
                } else if (z && "%3A".equals(strGroup)) {
                    strGroup = ":";
                } else if (z && "%27".equals(strGroup)) {
                    strGroup = "'";
                } else if (z && "%28".equals(strGroup)) {
                    strGroup = "(";
                } else if (z && "%29".equals(strGroup)) {
                    strGroup = ")";
                } else if (z && "%21".equals(strGroup)) {
                    strGroup = "!";
                } else if (z && "%5B".equals(strGroup)) {
                    strGroup = "[";
                } else if (z && "%5D".equals(strGroup)) {
                    strGroup = "]";
                }
                matcher.appendReplacement(stringBuffer, strGroup);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String urlDecode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
