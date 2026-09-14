package com.disney.p026id.android.scalp;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.disney.p026id.android.OneIDSCALPController;
import com.disney.p026id.android.SWID;
import com.disney.p026id.android.dagger.OneIDDagger;
import com.disney.p026id.android.lightbox.LightboxActivity;
import com.disney.p026id.android.logging.Logger;
import com.disney.p026id.android.services.BundlerService;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.disney.p026id.android.tracker.Tracker;
import com.disney.p026id.android.tracker.TrackerEventKey;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 52\u00020\u0001:\u000256BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ#\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100H\u0000¢\u0006\u0002\b1J0\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u00104\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m1836d2 = {"Lcom/disney/id/android/scalp/SiteConfigAndL10nProvider;", "", "clientId", "", "environment", "languageCode", "ageBand", "countryCode", LightboxActivity.UI_VERSION_EXTRA, "context", "Landroid/content/Context;", "protocol", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;)V", "bundlerService", "Lcom/disney/id/android/services/BundlerService;", "getBundlerService$OneID_release", "()Lcom/disney/id/android/services/BundlerService;", "setBundlerService$OneID_release", "(Lcom/disney/id/android/services/BundlerService;)V", "getContext", "()Landroid/content/Context;", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "getProtocol", "()Ljava/lang/String;", "setProtocol", "(Ljava/lang/String;)V", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "getConfig", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/scalp/SiteConfigAndL10nProvider$Listener;", "transactionEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "getConfig$OneID_release", "getSiteConfigURL", "loadLangPref", "loadAgeBand", "Companion", "Listener", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@VisibleForTesting
@SourceDebugExtension({"SMAP\nSiteConfigAndL10nProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SiteConfigAndL10nProvider.kt\ncom/disney/id/android/scalp/SiteConfigAndL10nProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,182:1\n1#2:183\n*E\n"})
public final class SiteConfigAndL10nProvider {
    private static final String TAG = SiteConfigAndL10nProvider.class.getSimpleName();
    private final String ageBand;

    @Inject
    public BundlerService bundlerService;
    private final String clientId;
    private final Context context;
    private final String countryCode;
    private final String environment;
    private final String languageCode;

    @Inject
    public Logger logger;
    private String protocol;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    private final String uiVersion;

    @Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m1836d2 = {"Lcom/disney/id/android/scalp/SiteConfigAndL10nProvider$Listener;", "", "onConfigLoadFailure", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "onConfigLoadSuccess", "config", "Lorg/json/JSONObject;", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public interface Listener {
        void onConfigLoadFailure(@NotNull String error);

        void onConfigLoadSuccess(@NotNull JSONObject config);
    }

    public SiteConfigAndL10nProvider(@NotNull String clientId, @NotNull String environment, @NotNull String languageCode, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Context context, @NotNull String protocol) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.clientId = clientId;
        this.environment = environment;
        this.languageCode = languageCode;
        this.ageBand = str;
        this.countryCode = str2;
        this.uiVersion = str3;
        this.context = context;
        this.protocol = protocol;
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public /* synthetic */ SiteConfigAndL10nProvider(String str, String str2, String str3, String str4, String str5, String str6, Context context, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, context, (i & 128) != 0 ? "https://" : str7);
    }

    @NotNull
    public final String getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.protocol = str;
    }

    @NotNull
    public final BundlerService getBundlerService$OneID_release() {
        BundlerService bundlerService = this.bundlerService;
        if (bundlerService != null) {
            return bundlerService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bundlerService");
        return null;
    }

    public final void setBundlerService$OneID_release(@NotNull BundlerService bundlerService) {
        Intrinsics.checkNotNullParameter(bundlerService, "<set-?>");
        this.bundlerService = bundlerService;
    }

    @NotNull
    public final Tracker getTracker$OneID_release() {
        Tracker tracker = this.tracker;
        if (tracker != null) {
            return tracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public final void setTracker$OneID_release(@NotNull Tracker tracker) {
        Intrinsics.checkNotNullParameter(tracker, "<set-?>");
        this.tracker = tracker;
    }

    @NotNull
    public final SWID getSwid$OneID_release() {
        SWID swid = this.swid;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swid");
        return null;
    }

    public final void setSwid$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swid = swid;
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    public static /* synthetic */ void getConfig$OneID_release$default(SiteConfigAndL10nProvider siteConfigAndL10nProvider, Listener listener, TrackerEventKey trackerEventKey, int i, Object obj) {
        if ((i & 2) != 0) {
            trackerEventKey = null;
        }
        siteConfigAndL10nProvider.getConfig$OneID_release(listener, trackerEventKey);
    }

    public final void getConfig$OneID_release(@Nullable final Listener listener, @Nullable final TrackerEventKey transactionEventKey) {
        String siteConfigURL = getSiteConfigURL(this.languageCode, this.ageBand, this.countryCode, this.uiVersion);
        OneIDTrackerEvent event = getTracker$OneID_release().getEvent(transactionEventKey);
        getBundlerService$OneID_release().getSiteConfig(siteConfigURL, event != null ? event.getTransactionId$OneID_release() : null).enqueue(new Callback<ResponseBody>() { // from class: com.disney.id.android.scalp.SiteConfigAndL10nProvider$getConfig$1
            @Override // retrofit2.Callback
            public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
                OneIDTrackerEvent event2;
                OneIDTrackerEvent event3;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                TrackerEventKey trackerEventKey = transactionEventKey;
                if (trackerEventKey != null && (event3 = this.getTracker$OneID_release().getEvent(trackerEventKey)) != null) {
                    OneIDTrackerEvent.appendCodes$OneID_release$default(event3, null, null, "httpstatus(" + response.code() + ")", 3, null);
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody != null) {
                    SiteConfigAndL10nProvider.Listener listener2 = listener;
                    if (listener2 != null) {
                        listener2.onConfigLoadSuccess(new JSONObject(responseBodyBody.string()));
                        return;
                    }
                    return;
                }
                if (transactionEventKey != null && (event2 = this.getTracker$OneID_release().getEvent(transactionEventKey)) != null) {
                    event2.appendCodes$OneID_release(null, null, "Site Config Returning Null");
                }
                SiteConfigAndL10nProvider.Listener listener3 = listener;
                if (listener3 != null) {
                    listener3.onConfigLoadFailure("Site Config Returning Null");
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
                OneIDTrackerEvent event2;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (transactionEventKey != null && (event2 = this.getTracker$OneID_release().getEvent(transactionEventKey)) != null) {
                    event2.appendCodes$OneID_release(null, null, "throwable(" + t.getMessage() + ")");
                }
                Logger logger$OneID_release = this.getLogger$OneID_release();
                String str = SiteConfigAndL10nProvider.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Logger.DefaultImpls.e$default(logger$OneID_release, str, "This is throwable message: " + t.getLocalizedMessage(), null, 4, null);
                if (t instanceof IOException) {
                    Logger logger$OneID_release2 = this.getLogger$OneID_release();
                    String str2 = SiteConfigAndL10nProvider.TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.e$default(logger$OneID_release2, str2, "A connection error occurred", null, 4, null);
                } else {
                    Logger logger$OneID_release3 = this.getLogger$OneID_release();
                    String str3 = SiteConfigAndL10nProvider.TAG;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.e$default(logger$OneID_release3, str3, "Call Failed", null, 4, null);
                }
                SiteConfigAndL10nProvider.Listener listener2 = listener;
                if (listener2 != null) {
                    String localizedMessage = t.getLocalizedMessage();
                    if (localizedMessage != null) {
                        t = localizedMessage;
                    }
                    listener2.onConfigLoadFailure(String.valueOf(t));
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x005c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    @VisibleForTesting
    @NotNull
    public final String getSiteConfigURL(@Nullable String loadLangPref, @Nullable String loadAgeBand, @Nullable String countryCode, @Nullable String uiVersion) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.protocol);
        String str = this.environment;
        Locale ROOT = Locale.ROOT;
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase) {
            case "qa":
            case "dev":
                sb.append("uiv4-qa");
                break;
            case "stg":
                sb.append("stg.cdn");
                break;
            case "val":
                sb.append("uiv4-val");
                break;
            case "edna":
                sb.append("edna.cdn");
                break;
            default:
                sb.append("cdn");
                break;
        }
        sb.append(".registerdisney.go.com/v4/config/mobile/");
        sb.append(this.clientId);
        sb.append('-');
        if (StringsKt.equals(this.environment, "stg", true)) {
            sb.append("STAGE");
        } else if (StringsKt.equals(this.environment, "edna", true)) {
            sb.append("QA");
        } else {
            String str2 = this.environment;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String upperCase = str2.toUpperCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            sb.append(upperCase);
        }
        sb.append('/');
        sb.append(loadLangPref);
        HashMap map = new HashMap();
        if (loadAgeBand != null) {
            map.put("ageBand", loadAgeBand);
        }
        if (countryCode != null) {
            map.put("countryCode", countryCode);
        }
        if (uiVersion != null && !Intrinsics.areEqual(uiVersion, "default")) {
            map.put(LightboxActivity.UI_VERSION_EXTRA, uiVersion);
        }
        map.put("version", OneIDSCALPController.USE_VERSION_4);
        if (!map.isEmpty()) {
            sb.append('?');
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                sb.append(str3);
                sb.append('=');
                sb.append(str4);
                sb.append(Typography.amp);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
