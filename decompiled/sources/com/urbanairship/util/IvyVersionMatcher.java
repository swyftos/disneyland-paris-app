package com.urbanairship.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.Predicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class IvyVersionMatcher implements Predicate<String>, JsonSerializable {
    private static final String END_PATTERN;
    private static final Pattern EXACT_VERSION;
    private static final String EXACT_VERSION_PATTERN;
    private static final String START_PATTERN;
    private static final Pattern SUB_VERSION;
    private static final Pattern VERSION_PATTERN;
    private static final Pattern VERSION_RANGE;
    private static final String VERSION_RANGE_PATTERN;
    private final String constraint;
    private final Predicate predicate;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseSubVersionConstraint$0(String str) {
        return true;
    }

    static {
        Locale locale = Locale.US;
        String str = String.format(locale, "([\\%s\\%s\\%s])", "[", "]", "(");
        START_PATTERN = str;
        String str2 = String.format(locale, "([\\%s\\%s\\%s])", "]", "[", ")");
        END_PATTERN = str2;
        Pattern patternCompile = Pattern.compile("([0-9]+)(\\.([0-9]+)((\\.([0-9]+))?(.*)))?");
        VERSION_PATTERN = patternCompile;
        String str3 = String.format(locale, "^%s(.*)?%s(.*)?%s$", str, ",", str2);
        VERSION_RANGE_PATTERN = str3;
        String str4 = "^" + patternCompile + "$";
        EXACT_VERSION_PATTERN = str4;
        VERSION_RANGE = Pattern.compile(str3);
        EXACT_VERSION = Pattern.compile(str4);
        SUB_VERSION = Pattern.compile("^(.*)\\+$");
    }

    private IvyVersionMatcher(Predicate predicate, String str) {
        this.predicate = predicate;
        this.constraint = str;
    }

    @NonNull
    public static IvyVersionMatcher newMatcher(@NonNull String str) {
        String strReplaceAll = str.replaceAll("\\s", "");
        Predicate subVersionConstraint = parseSubVersionConstraint(strReplaceAll);
        if (subVersionConstraint != null) {
            return new IvyVersionMatcher(subVersionConstraint, strReplaceAll);
        }
        Predicate exactVersionConstraint = parseExactVersionConstraint(strReplaceAll);
        if (exactVersionConstraint != null) {
            return new IvyVersionMatcher(exactVersionConstraint, strReplaceAll);
        }
        Predicate versionRangeConstraint = parseVersionRangeConstraint(strReplaceAll);
        if (versionRangeConstraint != null) {
            return new IvyVersionMatcher(versionRangeConstraint, strReplaceAll);
        }
        throw new IllegalArgumentException("Invalid constraint: " + strReplaceAll);
    }

    @Override // com.urbanairship.Predicate
    public boolean apply(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return this.predicate.apply(normalizeVersion(str));
    }

    private static Predicate parseSubVersionConstraint(String str) {
        Matcher matcher = SUB_VERSION.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        if (Marker.ANY_NON_NULL_MARKER.equals(str)) {
            return new Predicate() { // from class: com.urbanairship.util.IvyVersionMatcher$$ExternalSyntheticLambda2
                @Override // com.urbanairship.Predicate
                public final boolean apply(Object obj) {
                    return IvyVersionMatcher.lambda$parseSubVersionConstraint$0((String) obj);
                }
            };
        }
        final String strNormalizeVersion = normalizeVersion(matcher.groupCount() >= 1 ? matcher.group(1) : null);
        return new Predicate() { // from class: com.urbanairship.util.IvyVersionMatcher$$ExternalSyntheticLambda3
            @Override // com.urbanairship.Predicate
            public final boolean apply(Object obj) {
                return IvyVersionMatcher.lambda$parseSubVersionConstraint$1(strNormalizeVersion, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseSubVersionConstraint$1(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str2.startsWith(str);
    }

    static String normalizeVersion(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        int iIndexOf = strTrim.indexOf(45);
        if (iIndexOf <= 0) {
            return strTrim;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strTrim.substring(0, iIndexOf));
        String str2 = Marker.ANY_NON_NULL_MARKER;
        if (!strTrim.endsWith(Marker.ANY_NON_NULL_MARKER)) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    private static Predicate parseVersionRangeConstraint(String str) {
        Matcher matcher = VERSION_RANGE.matcher(str);
        if (!matcher.matches() || matcher.groupCount() != 4) {
            return null;
        }
        final String strGroup = matcher.group(1);
        String strNormalizeVersion = normalizeVersion(matcher.group(2));
        String strNormalizeVersion2 = normalizeVersion(matcher.group(3));
        final String strGroup2 = matcher.group(4);
        if (!UAStringUtil.isEmpty(strNormalizeVersion) && !VERSION_PATTERN.matcher(strNormalizeVersion).matches()) {
            return null;
        }
        if (!UAStringUtil.isEmpty(strNormalizeVersion2) && !VERSION_PATTERN.matcher(strNormalizeVersion2).matches()) {
            return null;
        }
        final Version version = UAStringUtil.isEmpty(strNormalizeVersion) ? null : new Version(strNormalizeVersion);
        final Version version2 = UAStringUtil.isEmpty(strNormalizeVersion2) ? null : new Version(strNormalizeVersion2);
        if (")".equals(strGroup2) && version2 != null) {
            return null;
        }
        if (!"(".equals(strGroup) || version == null) {
            return new Predicate() { // from class: com.urbanairship.util.IvyVersionMatcher$$ExternalSyntheticLambda0
                @Override // com.urbanairship.Predicate
                public final boolean apply(Object obj) {
                    return IvyVersionMatcher.lambda$parseVersionRangeConstraint$2(strGroup2, version2, strGroup, version, (String) obj);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseVersionRangeConstraint$2(String str, Version version, String str2, Version version2, String str3) {
        try {
            Version version3 = new Version(str3);
            if (str != null && version != null) {
                if (!str.equals("[")) {
                    if (str.equals("]") && version3.compareTo(version) > 0) {
                        return false;
                    }
                } else if (version3.compareTo(version) >= 0) {
                    return false;
                }
            }
            if (str2 == null || version2 == null) {
                return true;
            }
            return !str2.equals("[") ? !str2.equals("]") || version3.compareTo(version2) > 0 : version3.compareTo(version2) >= 0;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static Predicate parseExactVersionConstraint(String str) {
        final String strNormalizeVersion = normalizeVersion(str);
        if (EXACT_VERSION.matcher(strNormalizeVersion).matches()) {
            return new Predicate() { // from class: com.urbanairship.util.IvyVersionMatcher$$ExternalSyntheticLambda1
                @Override // com.urbanairship.Predicate
                public final boolean apply(Object obj) {
                    return IvyVersionMatcher.lambda$parseExactVersionConstraint$3(strNormalizeVersion, (String) obj);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseExactVersionConstraint$3(String str, String str2) {
        return str.equals(normalizeVersion(str2));
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NonNull
    public JsonValue toJsonValue() {
        return JsonValue.wrap(this.constraint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Version implements Comparable {
        final String version;
        final int[] versionComponent = {0, 0, 0};

        public Version(String str) {
            String strNormalizeVersion = IvyVersionMatcher.normalizeVersion(str);
            this.version = strNormalizeVersion;
            String[] strArrSplit = strNormalizeVersion.split("\\.");
            for (int i = 0; i < 3 && strArrSplit.length > i; i++) {
                this.versionComponent[i] = Integer.parseInt(strArrSplit[i]);
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Version version) {
            for (int i = 0; i < 3; i++) {
                int i2 = this.versionComponent[i] - version.versionComponent[i];
                if (i2 != 0) {
                    return i2 > 0 ? 1 : -1;
                }
            }
            return 0;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.constraint, ((IvyVersionMatcher) obj).constraint);
    }

    public int hashCode() {
        return Objects.hashCode(this.constraint);
    }
}
