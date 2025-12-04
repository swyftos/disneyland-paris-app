package com.appdynamics.eumagent.runtime;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.p000private.m;
import java.util.Set;

@DontObfuscate
/* loaded from: classes2.dex */
public class AgentConfiguration {
    public final String appKey;
    public final String applicationName;
    public final boolean autoInstrument;
    public final CollectorChannelFactory collectorChannelFactory;
    public final String collectorURL;
    public final boolean compileTimeInstrumentationCheck;
    public final Context context;
    public final CrashReportCallback crashCallback;
    public final boolean crashReportingEnabled;
    public final Set<String> excludedUrlPatterns;
    public final int interactionCaptureMode;
    public final boolean jsAgentAjaxEnabled;
    public final boolean jsAgentInjectionEnabled;
    public final int loggingLevel;
    public final NetworkRequestCallback networkRequestCallback;
    public final String screenshotURL;
    public final boolean screenshotsEnabled;
    public final boolean traceparentHeaderEnabled;

    @DontObfuscate
    public static class Builder {
        private static final String DEFAULT_COLLECTOR_HOST = "https://mobile.eum-appdynamics.com";
        private static final String DEFAULT_SCREENSHOT_HOST = "https://image.eum-appdynamics.com";
        private String appKey;
        private String applicationName;
        private boolean autoInstrument;
        private CollectorChannelFactory collectorChannelFactory;
        private String collectorURL;
        private boolean compileTimeInstrumentationCheck;
        private Context context;
        private CrashReportCallback crashCallback;
        private boolean crashReportingEnabled;
        private Set<String> excludedUrlPatterns;
        private int interactionCaptureMode;
        private boolean jsAgentAjaxEnabled;
        private boolean jsAgentInjectionEnabled;
        private int loggingLevel;
        private NetworkRequestCallback networkRequestCallback;
        private String screenshotURL;
        private boolean screenshotsEnabled;
        private boolean traceparentHeaderEnabled;

        private Builder() {
            this.compileTimeInstrumentationCheck = true;
            this.autoInstrument = true;
            this.crashCallback = null;
            this.networkRequestCallback = null;
            this.screenshotsEnabled = true;
            this.jsAgentInjectionEnabled = true;
            this.jsAgentAjaxEnabled = false;
            this.crashReportingEnabled = true;
            this.traceparentHeaderEnabled = false;
            this.loggingLevel = 4;
        }

        public Builder withAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder withContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder withCollectorURL(String str) {
            this.collectorURL = str;
            return this;
        }

        public Builder withScreenshotURL(String str) {
            this.screenshotURL = str;
            return this;
        }

        public Builder withApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        public Builder withExcludedUrlPatterns(Set<String> set) {
            this.excludedUrlPatterns = set;
            return this;
        }

        public Builder withLoggingEnabled(boolean z) {
            return withLoggingLevel(z ? 2 : 4);
        }

        public Builder withLoggingLevel(int i) {
            if (i != 1 && i != 2 && i != 4) {
                throw new IllegalArgumentException("Invalid Logging Level: ".concat(String.valueOf(i)));
            }
            this.loggingLevel = i;
            return this;
        }

        public Builder withCompileTimeInstrumentationCheck(boolean z) {
            this.compileTimeInstrumentationCheck = z;
            return this;
        }

        public Builder withAutoInstrument(boolean z) {
            this.autoInstrument = z;
            return this;
        }

        public Builder withInteractionCaptureMode(int i) {
            this.interactionCaptureMode = i;
            return this;
        }

        public Builder withCollectorChannelFactory(CollectorChannelFactory collectorChannelFactory) {
            this.collectorChannelFactory = collectorChannelFactory;
            return this;
        }

        public Builder withCrashCallback(CrashReportCallback crashReportCallback) {
            this.crashCallback = crashReportCallback;
            return this;
        }

        public Builder withNetworkRequestCallback(NetworkRequestCallback networkRequestCallback) {
            this.networkRequestCallback = networkRequestCallback;
            return this;
        }

        public Builder withScreenshotsEnabled(boolean z) {
            this.screenshotsEnabled = z;
            return this;
        }

        public Builder withJSAgentInjectionEnabled(boolean z) {
            this.jsAgentInjectionEnabled = z;
            return this;
        }

        public Builder withJSAgentAjaxEnabled(boolean z) {
            this.jsAgentAjaxEnabled = z;
            return this;
        }

        public Builder withCrashReportingEnabled(boolean z) {
            this.crashReportingEnabled = z;
            return this;
        }

        public Builder withTraceparentHeaderEnabled(boolean z) {
            this.traceparentHeaderEnabled = z;
            return this;
        }

        public AgentConfiguration build() {
            String str;
            if (!this.autoInstrument) {
                this.interactionCaptureMode = 0;
            }
            if (this.screenshotURL == null && (str = this.collectorURL) != null) {
                this.screenshotURL = str;
            }
            if (this.screenshotURL == null) {
                this.screenshotURL = DEFAULT_SCREENSHOT_HOST;
            }
            if (this.collectorURL == null) {
                this.collectorURL = DEFAULT_COLLECTOR_HOST;
            }
            if (this.collectorChannelFactory == null) {
                this.collectorChannelFactory = new CollectorChannelFactory() { // from class: com.appdynamics.eumagent.runtime.AgentConfiguration.Builder.1
                    @Override // com.appdynamics.eumagent.runtime.CollectorChannelFactory
                    public final CollectorChannel newCollectorChannel() {
                        return new m();
                    }
                };
            }
            return new AgentConfiguration(this.appKey, this.context, this.collectorURL, this.screenshotURL, this.loggingLevel, this.collectorChannelFactory, this.applicationName, this.excludedUrlPatterns, this.compileTimeInstrumentationCheck, this.autoInstrument, this.crashCallback, this.networkRequestCallback, this.interactionCaptureMode, this.screenshotsEnabled, this.jsAgentInjectionEnabled, this.jsAgentAjaxEnabled, this.crashReportingEnabled, this.traceparentHeaderEnabled);
        }
    }

    AgentConfiguration(String str, Context context, String str2, String str3, int i, CollectorChannelFactory collectorChannelFactory, String str4, Set<String> set, boolean z, boolean z2, CrashReportCallback crashReportCallback, NetworkRequestCallback networkRequestCallback, int i2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.appKey = str;
        this.context = context;
        this.collectorURL = str2;
        this.screenshotURL = str3;
        this.loggingLevel = i;
        this.collectorChannelFactory = collectorChannelFactory;
        this.applicationName = str4;
        this.excludedUrlPatterns = set;
        this.compileTimeInstrumentationCheck = z;
        this.autoInstrument = z2;
        this.crashCallback = crashReportCallback;
        this.networkRequestCallback = networkRequestCallback;
        this.interactionCaptureMode = i2;
        this.screenshotsEnabled = z3;
        this.jsAgentInjectionEnabled = z4;
        this.jsAgentAjaxEnabled = z5;
        this.crashReportingEnabled = z6;
        this.traceparentHeaderEnabled = z7;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AgentConfiguration{appKey='");
        sb.append(this.appKey);
        sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
        sb.append(", context=");
        sb.append(this.context);
        sb.append(", collectorURL='");
        sb.append(this.collectorURL);
        sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
        sb.append(", loggingLevel=");
        sb.append(this.loggingLevel);
        sb.append(", collectorChannelFactory=");
        sb.append(this.collectorChannelFactory);
        sb.append(", applicationName='");
        sb.append(this.applicationName);
        sb.append(CoreConstants.SINGLE_QUOTE_CHAR);
        sb.append(", urlFilterPatterns=");
        if (this.excludedUrlPatterns == null) {
            str = null;
        } else {
            str = "[" + this.excludedUrlPatterns.toString() + "]";
        }
        sb.append(str);
        sb.append(", compileTimeInstrumentationCheck=");
        sb.append(this.compileTimeInstrumentationCheck);
        sb.append(", autoInstrument=");
        sb.append(this.autoInstrument);
        sb.append(", crashCallback=");
        sb.append(this.crashCallback);
        sb.append(", networkRequestCallback=");
        sb.append(this.networkRequestCallback);
        sb.append(", interactionCaptureMode=");
        sb.append(this.interactionCaptureMode);
        sb.append(", screenshotsEnabled=");
        sb.append(this.screenshotsEnabled);
        sb.append(", jsAgentEnabled=");
        sb.append(this.jsAgentInjectionEnabled);
        sb.append(", jsAgentAjaxEnabled=");
        sb.append(this.jsAgentAjaxEnabled);
        sb.append(", crashReportingEnabled=");
        sb.append(this.crashReportingEnabled);
        sb.append(", traceparentHeaderEnabled=");
        sb.append(this.traceparentHeaderEnabled);
        sb.append('}');
        return sb.toString();
    }

    public static Builder builder() {
        return new Builder();
    }
}
