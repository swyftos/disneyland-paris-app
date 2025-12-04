package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class WebViewMediaIntegrityApiStatusConfig {
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_DISABLED = 0;
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_ENABLED = 2;
    public static final int WEBVIEW_MEDIA_INTEGRITY_API_ENABLED_WITHOUT_APP_IDENTITY = 1;
    private int mDefaultStatus;
    private Map mOverrideRules;

    public WebViewMediaIntegrityApiStatusConfig(@NonNull Builder builder) {
        this.mDefaultStatus = builder.mDefaultStatus;
        this.mOverrideRules = builder.mOverrideRules;
    }

    public static final class Builder {
        private int mDefaultStatus;
        private Map mOverrideRules = new HashMap();

        public Builder(int i) {
            this.mDefaultStatus = i;
        }

        @NonNull
        public Builder addOverrideRule(@NonNull String str, int i) {
            this.mOverrideRules.put(str, Integer.valueOf(i));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setOverrideRules(@NonNull Map<String, Integer> map) {
            this.mOverrideRules = map;
            return this;
        }

        @NonNull
        public WebViewMediaIntegrityApiStatusConfig build() {
            return new WebViewMediaIntegrityApiStatusConfig(this);
        }
    }

    public int getDefaultStatus() {
        return this.mDefaultStatus;
    }

    @NonNull
    public Map<String, Integer> getOverrideRules() {
        return this.mOverrideRules;
    }
}
