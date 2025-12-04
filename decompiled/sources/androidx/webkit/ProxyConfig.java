package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class ProxyConfig {
    public static final String MATCH_ALL_SCHEMES = "*";
    public static final String MATCH_HTTP = "http";
    public static final String MATCH_HTTPS = "https";
    private List mBypassRules;
    private List mProxyRules;
    private boolean mReverseBypass;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ProxyScheme {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ProxyConfig(@NonNull List<ProxyRule> list, @NonNull List<String> list2, boolean z) {
        this.mProxyRules = list;
        this.mBypassRules = list2;
        this.mReverseBypass = z;
    }

    @NonNull
    public List<ProxyRule> getProxyRules() {
        return Collections.unmodifiableList(this.mProxyRules);
    }

    @NonNull
    public List<String> getBypassRules() {
        return Collections.unmodifiableList(this.mBypassRules);
    }

    public boolean isReverseBypassEnabled() {
        return this.mReverseBypass;
    }

    public static final class ProxyRule {
        private String mSchemeFilter;
        private String mUrl;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str, @NonNull String str2) {
            this.mSchemeFilter = str;
            this.mUrl = str2;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProxyRule(@NonNull String str) {
            this("*", str);
        }

        @NonNull
        public String getSchemeFilter() {
            return this.mSchemeFilter;
        }

        @NonNull
        public String getUrl() {
            return this.mUrl;
        }
    }

    public static final class Builder {
        private List mBypassRules;
        private List mProxyRules;
        private boolean mReverseBypass;

        public Builder() {
            this.mReverseBypass = false;
            this.mProxyRules = new ArrayList();
            this.mBypassRules = new ArrayList();
        }

        public Builder(@NonNull ProxyConfig proxyConfig) {
            this.mReverseBypass = false;
            this.mProxyRules = proxyConfig.getProxyRules();
            this.mBypassRules = proxyConfig.getBypassRules();
            this.mReverseBypass = proxyConfig.isReverseBypassEnabled();
        }

        @NonNull
        public ProxyConfig build() {
            return new ProxyConfig(proxyRules(), bypassRules(), reverseBypass());
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str) {
            this.mProxyRules.add(new ProxyRule(str));
            return this;
        }

        @NonNull
        public Builder addProxyRule(@NonNull String str, @NonNull String str2) {
            this.mProxyRules.add(new ProxyRule(str2, str));
            return this;
        }

        @NonNull
        public Builder addBypassRule(@NonNull String str) {
            this.mBypassRules.add(str);
            return this;
        }

        @NonNull
        public Builder addDirect(@NonNull String str) {
            this.mProxyRules.add(new ProxyRule(str, "direct://"));
            return this;
        }

        @NonNull
        public Builder addDirect() {
            return addDirect("*");
        }

        @NonNull
        public Builder bypassSimpleHostnames() {
            return addBypassRule("<local>");
        }

        @NonNull
        public Builder removeImplicitRules() {
            return addBypassRule("<-loopback>");
        }

        @NonNull
        public Builder setReverseBypassEnabled(boolean z) {
            this.mReverseBypass = z;
            return this;
        }

        private List proxyRules() {
            return this.mProxyRules;
        }

        private List bypassRules() {
            return this.mBypassRules;
        }

        private boolean reverseBypass() {
            return this.mReverseBypass;
        }
    }
}
