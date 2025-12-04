package com.urbanairship;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.net.MailTo;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.urbanairship.util.UAStringUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class UrlAllowList {
    private static final Pattern HOST_PATTERN = Pattern.compile("((\\*)|(\\*\\.[^/\\*]+)|([^/\\*]+))", 2);
    private static final Pattern PATH_OR_SCHEME_PATTERN = Pattern.compile("([^\\s]*)", 2);
    public static final int SCOPE_ALL = 3;
    public static final int SCOPE_JAVASCRIPT_INTERFACE = 1;
    public static final int SCOPE_OPEN_URL = 2;
    private final List entries = new ArrayList();
    private OnUrlAllowListCallback urlAllowListCallback;

    public interface OnUrlAllowListCallback {
        boolean allowUrl(@NonNull String str, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scope {
    }

    public boolean addEntry(@NonNull String str) {
        return addEntry(str, 3);
    }

    public boolean addEntry(@NonNull String str, int i) {
        Pattern patternCompile;
        Pattern patternCompile2 = null;
        if (str.equals("*")) {
            addEntry(new UriPattern(null, null, null), i);
            return true;
        }
        Uri uri = Uri.parse(str);
        if (uri == null) {
            UALog.e("Invalid URL allow list pattern %s", str);
            return false;
        }
        String scheme = uri.getScheme();
        if (!UAStringUtil.isEmpty(scheme)) {
            Pattern pattern = PATH_OR_SCHEME_PATTERN;
            if (pattern.matcher(scheme).matches()) {
                String strNullIfEmpty = UAStringUtil.nullIfEmpty(uri.getEncodedAuthority());
                if (strNullIfEmpty != null && !HOST_PATTERN.matcher(strNullIfEmpty).matches()) {
                    UALog.e("Invalid host %s in URL allow list pattern %s", strNullIfEmpty, str);
                    return false;
                }
                String schemeSpecificPart = uri.isOpaque() ? uri.getSchemeSpecificPart() : uri.getPath();
                if (schemeSpecificPart != null && !pattern.matcher(schemeSpecificPart).matches()) {
                    UALog.e("Invalid path %s in URL allow list pattern %s", schemeSpecificPart, str);
                    return false;
                }
                Pattern patternCompile3 = (UAStringUtil.isEmpty(scheme) || scheme.equals("*")) ? null : Pattern.compile(escapeRegEx(scheme, false));
                if (UAStringUtil.isEmpty(strNullIfEmpty) || strNullIfEmpty.equals("*")) {
                    patternCompile = null;
                } else if (strNullIfEmpty.startsWith("*.")) {
                    patternCompile = Pattern.compile("(.*\\.)?" + escapeRegEx(strNullIfEmpty.substring(2), true));
                } else {
                    patternCompile = Pattern.compile(escapeRegEx(strNullIfEmpty, true));
                }
                if (!UAStringUtil.isEmpty(schemeSpecificPart) && !schemeSpecificPart.equals("/*")) {
                    patternCompile2 = Pattern.compile(escapeRegEx(schemeSpecificPart, false));
                }
                addEntry(new UriPattern(patternCompile3, patternCompile, patternCompile2), i);
                return true;
            }
        }
        UALog.e("Invalid scheme %s in URL allow list pattern %s", scheme, str);
        return false;
    }

    private void addEntry(UriPattern uriPattern, int i) {
        synchronized (this.entries) {
            this.entries.add(new Entry(uriPattern, i));
        }
    }

    public boolean isAllowed(@Nullable String str) {
        return isAllowed(str, 3);
    }

    public boolean isAllowed(@Nullable String str, int i) {
        int i2;
        OnUrlAllowListCallback onUrlAllowListCallback;
        if (str == null) {
            return false;
        }
        Uri uri = Uri.parse(str);
        synchronized (this.entries) {
            try {
                i2 = 0;
                for (Entry entry : this.entries) {
                    if (entry.pattern.matches(uri)) {
                        i2 |= entry.scope;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z = (i2 & i) == i;
        return (!z || (onUrlAllowListCallback = this.urlAllowListCallback) == null) ? z : onUrlAllowListCallback.allowUrl(str, i);
    }

    private String escapeRegEx(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            String strValueOf = String.valueOf(c);
            if (!z && strValueOf.equals("*")) {
                sb.append(InstructionFileId.DOT);
            } else if ("\\.[]{}()^$?+|*".contains(strValueOf)) {
                sb.append("\\");
            }
            sb.append(strValueOf);
        }
        return sb.toString();
    }

    @NonNull
    public static UrlAllowList createDefaultUrlAllowList(@NonNull AirshipConfigOptions airshipConfigOptions) {
        UrlAllowList urlAllowList = new UrlAllowList();
        urlAllowList.addEntry("https://*.urbanairship.com");
        urlAllowList.addEntry("https://*.asnapieu.com");
        urlAllowList.addEntry("sms:", 2);
        urlAllowList.addEntry(MailTo.MAILTO_SCHEME, 2);
        urlAllowList.addEntry("tel:", 2);
        if (!airshipConfigOptions.isAllowListSet && !airshipConfigOptions.isAllowListScopeOpenSet) {
            UALog.e("The Airship config options is missing URL allow list rules for SCOPE_OPEN that controls what external URLs are able to be opened externally or loaded in a web view by Airship. By default, all URLs will be allowed. To suppress this error, specify the config urlAllowListScopeOpenUrl = [*] to keep the defaults, or by providing a list of rules that your app expects. See https://docs.airship.com/platform/mobile/setup/sdk/android/#url-allow-list for more information.", new Object[0]);
            urlAllowList.addEntry("*", 2);
        }
        Iterator<String> it = airshipConfigOptions.urlAllowList.iterator();
        while (it.hasNext()) {
            urlAllowList.addEntry(it.next(), 3);
        }
        Iterator<String> it2 = airshipConfigOptions.urlAllowListScopeJavaScriptInterface.iterator();
        while (it2.hasNext()) {
            urlAllowList.addEntry(it2.next(), 1);
        }
        Iterator<String> it3 = airshipConfigOptions.urlAllowListScopeOpenUrl.iterator();
        while (it3.hasNext()) {
            urlAllowList.addEntry(it3.next(), 2);
        }
        return urlAllowList;
    }

    public void setUrlAllowListCallback(@Nullable OnUrlAllowListCallback onUrlAllowListCallback) {
        this.urlAllowListCallback = onUrlAllowListCallback;
    }

    private static class UriPattern {
        private final Pattern host;
        private final Pattern path;
        private final Pattern scheme;

        UriPattern(Pattern pattern, Pattern pattern2, Pattern pattern3) {
            this.scheme = pattern;
            this.host = pattern2;
            this.path = pattern3;
        }

        boolean matches(Uri uri) {
            if (this.scheme != null && (uri.getScheme() == null || !this.scheme.matcher(uri.getScheme()).matches())) {
                return false;
            }
            if (this.host != null && (uri.getHost() == null || !this.host.matcher(uri.getHost()).matches())) {
                return false;
            }
            String schemeSpecificPart = uri.isOpaque() ? uri.getSchemeSpecificPart() : uri.getPath();
            Pattern pattern = this.path;
            return pattern == null || (schemeSpecificPart != null && pattern.matcher(schemeSpecificPart).matches());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UriPattern uriPattern = (UriPattern) obj;
            Pattern pattern = this.scheme;
            if (pattern == null ? uriPattern.scheme != null : !pattern.equals(uriPattern.scheme)) {
                return false;
            }
            Pattern pattern2 = this.host;
            if (pattern2 == null ? uriPattern.host != null : !pattern2.equals(uriPattern.host)) {
                return false;
            }
            Pattern pattern3 = this.path;
            return pattern3 != null ? pattern3.equals(uriPattern.path) : uriPattern.path == null;
        }

        public int hashCode() {
            Pattern pattern = this.scheme;
            int iHashCode = (pattern != null ? pattern.hashCode() : 0) * 31;
            Pattern pattern2 = this.host;
            int iHashCode2 = (iHashCode + (pattern2 != null ? pattern2.hashCode() : 0)) * 31;
            Pattern pattern3 = this.path;
            return iHashCode2 + (pattern3 != null ? pattern3.hashCode() : 0);
        }
    }

    private static class Entry {
        private final UriPattern pattern;
        private final int scope;

        private Entry(UriPattern uriPattern, int i) {
            this.scope = i;
            this.pattern = uriPattern;
        }
    }
}
