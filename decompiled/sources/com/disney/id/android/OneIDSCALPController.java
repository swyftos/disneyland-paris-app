package com.disney.id.android;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.VisibleForTesting;
import com.disney.id.android.SCALPController;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.extensions.JSONExtensionsKt;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.scalp.SiteConfigAndL10nProvider;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.urbanairship.util.Attributes;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u0081\u00012\u00020\u0001:\u0004\u0081\u0001\u0082\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040R2\u0006\u0010S\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010T\u001a\u00020-2\u0006\u0010(\u001a\u00020\u001dH\u0002J\b\u0010U\u001a\u00020VH\u0016J(\u0010W\u001a\"\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u001d\u0018\u00010Xj\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u001d\u0018\u0001`ZH\u0016J\b\u0010[\u001a\u00020\u0004H\u0016J\b\u0010\\\u001a\u00020\u0004H\u0016J\n\u0010]\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010a\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010b\u001a\u0004\u0018\u00010_H\u0016J\n\u0010c\u001a\u0004\u0018\u00010_H\u0016J\u0010\u0010d\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\u0004H\u0016J\u0012\u0010f\u001a\u0004\u0018\u00010_2\u0006\u0010g\u001a\u00020\u0004H\u0016J\n\u0010h\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010i\u001a\u0004\u0018\u00010\u001dH\u0016J\u001e\u0010j\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010N\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010k\u001a\u00020V2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010l\u001a\u00020\u0004H\u0016J\b\u0010m\u001a\u00020VH\u0016J\b\u0010n\u001a\u00020VH\u0016J\u0010\u0010o\u001a\u00020V2\u0006\u0010p\u001a\u00020qH\u0016J,\u0010r\u001a\u00020-2\b\u0010s\u001a\u0004\u0018\u00010\u00042\u0006\u0010t\u001a\u00020u2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010v\u001a\u00020wH\u0017J\u001a\u0010x\u001a\u00020-2\u0006\u0010S\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u001d\u0010y\u001a\u00020-2\u0006\u0010t\u001a\u00020u2\u0006\u0010z\u001a\u00020\u0004H\u0000¢\u0006\u0002\b{J\u0010\u0010|\u001a\u00020-2\u0006\u0010}\u001a\u00020\u001dH\u0002J \u0010~\u001a\u0004\u0018\u00010\u007f2\u0006\u0010t\u001a\u00020u2\u0006\u0010z\u001a\u00020\u0004H\u0000¢\u0006\u0003\b\u0080\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R/\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u001dX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R2\u0010+\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u0002038\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u00020:8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R\u001e\u0010B\u001a\u00020C8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u00020I8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\b¨\u0006\u0083\u0001"}, d2 = {"Lcom/disney/id/android/OneIDSCALPController;", "Lcom/disney/id/android/SCALPController;", "()V", "ageBand", "", "getAgeBand", "()Ljava/lang/String;", "setAgeBand", "(Ljava/lang/String;)V", "assertedCountry", "getAssertedCountry", "setAssertedCountry", "configCallback", "Lcom/disney/id/android/OneIDSCALPController$SCALPListener;", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler$OneID_release", "()Lcom/disney/id/android/ConfigHandler;", "setConfigHandler$OneID_release", "(Lcom/disney/id/android/ConfigHandler;)V", "<set-?>", "Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;", "isLoaded", "()Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;", "setLoaded", "(Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;)V", "isLoaded$delegate", "Lkotlin/properties/ReadWriteProperty;", "localizedStrings", "Lorg/json/JSONObject;", "getLocalizedStrings$OneID_release", "()Lorg/json/JSONObject;", "setLocalizedStrings$OneID_release", "(Lorg/json/JSONObject;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "mobileConfig", "getMobileConfig$OneID_release", "setMobileConfig$OneID_release", "onLoadedChanged", "Lkotlin/Function2;", "", "getOnLoadedChanged", "()Lkotlin/jvm/functions/Function2;", "setOnLoadedChanged", "(Lkotlin/jvm/functions/Function2;)V", "oneIDStorage", "Lcom/disney/id/android/localdata/ExposedStorage;", "getOneIDStorage$OneID_release", "()Lcom/disney/id/android/localdata/ExposedStorage;", "setOneIDStorage$OneID_release", "(Lcom/disney/id/android/localdata/ExposedStorage;)V", "previouslyUsedLanguageCode", "scalpConfigHandler", "Lcom/disney/id/android/SCALPConfigHandler;", "getScalpConfigHandler$OneID_release", "()Lcom/disney/id/android/SCALPConfigHandler;", "setScalpConfigHandler$OneID_release", "(Lcom/disney/id/android/SCALPConfigHandler;)V", "siteConfig", "getSiteConfig$OneID_release", "setSiteConfig$OneID_release", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", LightboxActivity.UI_VERSION_EXTRA, "getUiVersion", "setUiVersion", "buildCacheKey", "Lkotlin/Pair;", "version", "cacheMobileConfig", "canAutogenerateUsername", "", "getAgeBands", "Ljava/util/HashMap;", "Lcom/disney/id/android/AgeBand;", "Lkotlin/collections/HashMap;", "getBundleVersion", "getBundlerURL", "getCompliance", "getCountries", "Lorg/json/JSONArray;", "getCountryCode", "getDetectedCountry", "getLegalDisclosures", "getMarketingEntities", "getMessage", "textId", "getNewslettersForCampaignId", Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, "getRegisterFields", "getSiteConfig", "hasCachedMobileConfig", "hasPromotionId", "promotionID", "isBiometricEnabled", "isExpiredNotificationEnabled", "isHeadlessAllowed", "eventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "load", "conversationId", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/SCALPController$LoadListener;", "loadFromCache", "loadL10NFromLocalFile", "languagePref", "loadL10NFromLocalFile$OneID_release", "populateController", "config", "resourceStreamForLanguagePref", "Ljava/io/InputStream;", "resourceStreamForLanguagePref$OneID_release", "Companion", "SCALPListener", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneIDSCALPController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDSCALPController.kt\ncom/disney/id/android/OneIDSCALPController\n+ 2 Delegates.kt\nkotlin/properties/Delegates\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,589:1\n33#2,3:590\n1#3:593\n*S KotlinDebug\n*F\n+ 1 OneIDSCALPController.kt\ncom/disney/id/android/OneIDSCALPController\n*L\n35#1:590,3\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDSCALPController implements SCALPController {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OneIDSCALPController.class, "isLoaded", "isLoaded()Lcom/disney/id/android/SCALPController$SiteConfigDownloadStatus;", 0))};
    private static final String TAG = OneIDSCALPController.class.getSimpleName();

    @NotNull
    public static final String USE_VERSION_2 = "v2";

    @NotNull
    public static final String USE_VERSION_4 = "v4";

    @NotNull
    public static final String USE_VERSION_DEFAULT = "default";
    private String ageBand;
    private String assertedCountry;
    private SCALPListener configCallback;

    @Inject
    public ConfigHandler configHandler;

    /* renamed from: isLoaded$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty isLoaded;
    public JSONObject localizedStrings;

    @Inject
    public Logger logger;
    private JSONObject mobileConfig;
    private Function2 onLoadedChanged;

    @Inject
    public ExposedStorage oneIDStorage;
    private String previouslyUsedLanguageCode;

    @Inject
    public SCALPConfigHandler scalpConfigHandler;
    private JSONObject siteConfig;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    private String uiVersion;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SCALPController.SiteConfigDownloadStatus.values().length];
            try {
                iArr[SCALPController.SiteConfigDownloadStatus.FailedToDownload.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SCALPController.SiteConfigDownloadStatus.Downloaded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OneIDSCALPController() {
        Delegates delegates = Delegates.INSTANCE;
        final Object obj = null;
        this.isLoaded = new ObservableProperty<SCALPController.SiteConfigDownloadStatus>(obj) { // from class: com.disney.id.android.OneIDSCALPController$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(@NotNull KProperty<?> property, SCALPController.SiteConfigDownloadStatus oldValue, SCALPController.SiteConfigDownloadStatus newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatus = newValue;
                SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatus2 = oldValue;
                Function2<SCALPController.SiteConfigDownloadStatus, SCALPController.SiteConfigDownloadStatus, Unit> onLoadedChanged = this.getOnLoadedChanged();
                if (onLoadedChanged != null) {
                    onLoadedChanged.invoke(siteConfigDownloadStatus2, siteConfigDownloadStatus);
                }
            }
        };
        OneIDDagger.getComponent().inject(this);
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public SCALPController.SiteConfigDownloadStatus isLoaded() {
        return (SCALPController.SiteConfigDownloadStatus) this.isLoaded.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.disney.id.android.SCALPController
    public void setLoaded(@Nullable SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatus) {
        this.isLoaded.setValue(this, $$delegatedProperties[0], siteConfigDownloadStatus);
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public Function2<SCALPController.SiteConfigDownloadStatus, SCALPController.SiteConfigDownloadStatus, Unit> getOnLoadedChanged() {
        return this.onLoadedChanged;
    }

    @Override // com.disney.id.android.SCALPController
    public void setOnLoadedChanged(@Nullable Function2<? super SCALPController.SiteConfigDownloadStatus, ? super SCALPController.SiteConfigDownloadStatus, Unit> function2) {
        this.onLoadedChanged = function2;
    }

    @NotNull
    public final ExposedStorage getOneIDStorage$OneID_release() {
        ExposedStorage exposedStorage = this.oneIDStorage;
        if (exposedStorage != null) {
            return exposedStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oneIDStorage");
        return null;
    }

    public final void setOneIDStorage$OneID_release(@NotNull ExposedStorage exposedStorage) {
        Intrinsics.checkNotNullParameter(exposedStorage, "<set-?>");
        this.oneIDStorage = exposedStorage;
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

    @NotNull
    public final ConfigHandler getConfigHandler$OneID_release() {
        ConfigHandler configHandler = this.configHandler;
        if (configHandler != null) {
            return configHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configHandler");
        return null;
    }

    public final void setConfigHandler$OneID_release(@NotNull ConfigHandler configHandler) {
        Intrinsics.checkNotNullParameter(configHandler, "<set-?>");
        this.configHandler = configHandler;
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
    public final SCALPConfigHandler getScalpConfigHandler$OneID_release() {
        SCALPConfigHandler sCALPConfigHandler = this.scalpConfigHandler;
        if (sCALPConfigHandler != null) {
            return sCALPConfigHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scalpConfigHandler");
        return null;
    }

    public final void setScalpConfigHandler$OneID_release(@NotNull SCALPConfigHandler sCALPConfigHandler) {
        Intrinsics.checkNotNullParameter(sCALPConfigHandler, "<set-?>");
        this.scalpConfigHandler = sCALPConfigHandler;
    }

    @Nullable
    /* renamed from: getMobileConfig$OneID_release, reason: from getter */
    public final JSONObject getMobileConfig() {
        return this.mobileConfig;
    }

    public final void setMobileConfig$OneID_release(@Nullable JSONObject jSONObject) {
        this.mobileConfig = jSONObject;
    }

    @Nullable
    public final JSONObject getSiteConfig$OneID_release() {
        return this.siteConfig;
    }

    public final void setSiteConfig$OneID_release(@Nullable JSONObject jSONObject) {
        this.siteConfig = jSONObject;
    }

    @NotNull
    public final JSONObject getLocalizedStrings$OneID_release() {
        JSONObject jSONObject = this.localizedStrings;
        if (jSONObject != null) {
            return jSONObject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localizedStrings");
        return null;
    }

    public final void setLocalizedStrings$OneID_release(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<set-?>");
        this.localizedStrings = jSONObject;
    }

    @Nullable
    public final String getAgeBand() {
        return this.ageBand;
    }

    public final void setAgeBand(@Nullable String str) {
        this.ageBand = str;
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public String getAssertedCountry() {
        return this.assertedCountry;
    }

    @Override // com.disney.id.android.SCALPController
    public void setAssertedCountry(@Nullable String str) {
        this.assertedCountry = str;
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public String getUiVersion() {
        return this.uiVersion;
    }

    @Override // com.disney.id.android.SCALPController
    public void setUiVersion(@Nullable String str) {
        this.uiVersion = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class SCALPListener implements SiteConfigAndL10nProvider.Listener {
        private final OneIDSCALPController controller;
        private final SCALPController.LoadListener listener;
        private final TrackerEventKey transactionEventKey;

        public SCALPListener(OneIDSCALPController controller, TrackerEventKey transactionEventKey, SCALPController.LoadListener listener) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            Intrinsics.checkNotNullParameter(transactionEventKey, "transactionEventKey");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.controller = controller;
            this.transactionEventKey = transactionEventKey;
            this.listener = listener;
        }

        public final OneIDSCALPController getController() {
            return this.controller;
        }

        @Override // com.disney.id.android.scalp.SiteConfigAndL10nProvider.Listener
        public void onConfigLoadSuccess(JSONObject config) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.controller.populateController(config);
            this.controller.cacheMobileConfig(config);
            Tracker.DefaultImpls.finishEvent$default(this.controller.getTracker$OneID_release(), this.transactionEventKey, false, null, null, null, false, 62, null);
            this.listener.configLoadComplete(this.controller.getBundleVersion(), this.controller.getBundlerURL());
        }

        @Override // com.disney.id.android.scalp.SiteConfigAndL10nProvider.Listener
        public void onConfigLoadFailure(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            Logger logger$OneID_release = this.controller.getLogger$OneID_release();
            String str = OneIDSCALPController.TAG;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            Logger.DefaultImpls.e$default(logger$OneID_release, str, error, null, 4, null);
            OneIDTrackerEvent event = this.controller.getTracker$OneID_release().getEvent(this.transactionEventKey);
            if (event != null) {
                event.appendCodes$OneID_release(null, null, "error(" + error + ")");
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new OneIDSCALPController$SCALPListener$onConfigLoadFailure$1(this, null), 3, null);
            this.listener.configLoadError(this.transactionEventKey, error);
        }
    }

    private final Pair buildCacheKey(String version, String ageBand) {
        Config config = getConfigHandler$OneID_release().get();
        if (ageBand == null) {
            ageBand = "";
        }
        String assertedCountry = getAssertedCountry();
        String str = assertedCountry != null ? assertedCountry : "";
        String str2 = "mobileConfig:" + version + ":" + config.getClientId() + ":" + config.getEnvironment().name() + ":" + config.getLanguage() + ":" + ageBand + ":" + str;
        return new Pair(str2, str2 + ":ts");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheMobileConfig(JSONObject mobileConfig) {
        String string = getOneIDStorage$OneID_release().getString(LightboxActivity.UI_VERSION_EXTRA, null);
        if (string == null) {
            string = "default";
        }
        Pair pairBuildCacheKey = buildCacheKey(string, this.ageBand);
        String str = (String) pairBuildCacheKey.component1();
        getOneIDStorage$OneID_release().putLong((String) pairBuildCacheKey.component2(), new Date().getTime());
        ExposedStorage oneIDStorage$OneID_release = getOneIDStorage$OneID_release();
        String string2 = mobileConfig.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        oneIDStorage$OneID_release.putString(str, string2);
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public String hasCachedMobileConfig(@Nullable String ageBand, @Nullable String uiVersion) {
        if (uiVersion == null || uiVersion.length() == 0) {
            uiVersion = "default";
        }
        if (getOneIDStorage$OneID_release().contains((String) buildCacheKey(uiVersion, ageBand).component1())) {
            return uiVersion;
        }
        return null;
    }

    @Override // com.disney.id.android.SCALPController
    public void loadFromCache(@NotNull String version, @Nullable String ageBand) {
        Intrinsics.checkNotNullParameter(version, "version");
        String string$default = ExposedStorage.DefaultImpls.getString$default(getOneIDStorage$OneID_release(), (String) buildCacheKey(version, ageBand).component1(), null, 2, null);
        if (string$default != null) {
            populateController(new JSONObject(string$default));
            this.ageBand = ageBand;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void populateController(JSONObject config) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        this.mobileConfig = config;
        this.siteConfig = config.optJSONObject("siteConfig");
        getScalpConfigHandler$OneID_release().setDetectedCountry(getDetectedCountry());
        JSONObject jSONObjectOptJSONObject3 = config.optJSONObject("l10n");
        if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("mobile")) != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("message")) != null) {
            setLocalizedStrings$OneID_release(jSONObjectOptJSONObject2);
        }
        getTracker$OneID_release().setLightboxVersion(getBundleVersion());
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass2(null), 3, null);
    }

    /* renamed from: com.disney.id.android.OneIDSCALPController$populateController$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return OneIDSCALPController.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            OneIDSCALPController.this.setLoaded(SCALPController.SiteConfigDownloadStatus.Downloaded);
            return Unit.INSTANCE;
        }
    }

    @Override // com.disney.id.android.SCALPController
    @VisibleForTesting
    public void load(@Nullable String conversationId, @NotNull Context context, @Nullable String ageBand, @NotNull SCALPController.LoadListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.ageBand = ageBand;
        Config config = getConfigHandler$OneID_release().get();
        String language = config.getLanguage();
        String str = this.previouslyUsedLanguageCode;
        if (str == null || !Intrinsics.areEqual(str, language)) {
            loadL10NFromLocalFile$OneID_release(context, language);
            this.previouslyUsedLanguageCode = language;
        }
        SiteConfigAndL10nProvider siteConfigAndL10nProvider = new SiteConfigAndL10nProvider(config.getClientId(), config.getEnvironment().toString(), language, ageBand, getAssertedCountry(), getUiVersion(), context, null, 128, null);
        TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(getTracker$OneID_release(), conversationId, EventAction.SERVICE_DOWNLOAD_CONFIG, getSwid$OneID_release().get(), null, null, 24, null);
        SCALPListener sCALPListener = new SCALPListener(this, trackerEventKeyStartTransactionEvent$default, listener);
        this.configCallback = sCALPListener;
        siteConfigAndL10nProvider.getConfig$OneID_release(sCALPListener, trackerEventKeyStartTransactionEvent$default);
    }

    @Override // com.disney.id.android.SCALPController
    @NotNull
    public String getBundleVersion() {
        String stringSafely;
        JSONObject jSONObject = this.mobileConfig;
        return (jSONObject == null || (stringSafely = JSONExtensionsKt.getStringSafely(jSONObject, "useVersion")) == null) ? "v2" : stringSafely;
    }

    @Override // com.disney.id.android.SCALPController
    @NotNull
    public String getBundlerURL() {
        String str = EnvironmentConfiguration.INSTANCE.configurationFor(getConfigHandler$OneID_release().get().getEnvironment()).getBundlerURL() + "/v2";
        JSONObject jSONObject = this.mobileConfig;
        String strOptString = jSONObject != null ? jSONObject.optString("bundlerURL", str) : null;
        return strOptString == null ? str : strOptString;
    }

    @Override // com.disney.id.android.SCALPController
    @NotNull
    public String getMessage(@NotNull String textId) {
        Intrinsics.checkNotNullParameter(textId, "textId");
        String strOptString = getLocalizedStrings$OneID_release().optString(textId, textId);
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        return strOptString;
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public JSONArray getLegalDisclosures() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObject = this.siteConfig;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("legal")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ADULT")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject2.optJSONArray("disclosures");
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public JSONArray getMarketingEntities() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObject = this.siteConfig;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("marketing")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ADULT")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject2.optJSONArray("entities");
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public JSONObject getCompliance() {
        JSONObject jSONObject = this.siteConfig;
        if (jSONObject != null) {
            return jSONObject.optJSONObject("compliance");
        }
        return null;
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public JSONArray getCountries() {
        JSONObject compliance = getCompliance();
        if (compliance != null) {
            return compliance.optJSONArray("countries");
        }
        return null;
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public String getDetectedCountry() {
        HashMap<AgeBand, JSONObject> ageBands = getAgeBands();
        if (ageBands == null) {
            return null;
        }
        JSONObject jSONObject = ageBands.get(AgeBand.ADULT);
        if (jSONObject != null) {
            Intrinsics.checkNotNull(jSONObject);
            String stringSafely = JSONExtensionsKt.getStringSafely(jSONObject, Attributes.COUNTRY);
            if (stringSafely != null) {
                return stringSafely;
            }
        }
        JSONObject jSONObject2 = ageBands.get(AgeBand.TEEN);
        if (jSONObject2 != null) {
            Intrinsics.checkNotNull(jSONObject2);
            String stringSafely2 = JSONExtensionsKt.getStringSafely(jSONObject2, Attributes.COUNTRY);
            if (stringSafely2 != null) {
                return stringSafely2;
            }
        }
        JSONObject jSONObject3 = ageBands.get(AgeBand.CHILD);
        if (jSONObject3 == null) {
            return null;
        }
        Intrinsics.checkNotNull(jSONObject3);
        String stringSafely3 = JSONExtensionsKt.getStringSafely(jSONObject3, Attributes.COUNTRY);
        if (stringSafely3 != null) {
            return stringSafely3;
        }
        return null;
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public JSONArray getNewslettersForCampaignId(@NotNull String campaignId) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        JSONObject jSONObject = this.siteConfig;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("newsletters")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("ADULT")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject2.optJSONArray(campaignId);
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public String getCountryCode() {
        return getDetectedCountry();
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public JSONObject getRegisterFields() {
        JSONObject jSONObject;
        HashMap<AgeBand, JSONObject> ageBands = getAgeBands();
        if (ageBands == null || (jSONObject = ageBands.get(AgeBand.ADULT)) == null) {
            return null;
        }
        return jSONObject.optJSONObject("CREATE");
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public JSONObject getSiteConfig() {
        return this.siteConfig;
    }

    @Override // com.disney.id.android.SCALPController
    public boolean canAutogenerateUsername() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.siteConfig;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("uiConfig")) == null) {
            return false;
        }
        return jSONObjectOptJSONObject.optBoolean("autoGenerateUsername");
    }

    @Override // com.disney.id.android.SCALPController
    @Nullable
    public HashMap<AgeBand, JSONObject> getAgeBands() {
        JSONObject jSONObjectOptJSONObject;
        HashMap<AgeBand, JSONObject> map = new HashMap<>();
        JSONObject compliance = getCompliance();
        if (compliance != null && (jSONObjectOptJSONObject = compliance.optJSONObject("ageBands")) != null) {
            AgeBand ageBand = AgeBand.ADULT;
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(ageBand.getValue());
            if (jSONObjectOptJSONObject2 != null) {
                Intrinsics.checkNotNull(jSONObjectOptJSONObject2);
                map.put(ageBand, jSONObjectOptJSONObject2);
            }
            AgeBand ageBand2 = AgeBand.TEEN;
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(ageBand2.getValue());
            if (jSONObjectOptJSONObject3 != null) {
                Intrinsics.checkNotNull(jSONObjectOptJSONObject3);
                map.put(ageBand2, jSONObjectOptJSONObject3);
            }
            AgeBand ageBand3 = AgeBand.CHILD;
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject(ageBand3.getValue());
            if (jSONObjectOptJSONObject4 != null) {
                Intrinsics.checkNotNull(jSONObjectOptJSONObject4);
                map.put(ageBand3, jSONObjectOptJSONObject4);
            }
        }
        if (map.size() > 0) {
            return map;
        }
        return null;
    }

    @Nullable
    public final InputStream resourceStreamForLanguagePref$OneID_release(@NotNull Context context, @NotNull String languagePref) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(languagePref, "languagePref");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "did_%s", Arrays.copyOf(new Object[]{languagePref}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String strReplace$default = StringsKt.replace$default(str, '-', '_', false, 4, (Object) null);
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = strReplace$default.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        try {
            return context.getResources().openRawResource(context.getResources().getIdentifier(lowerCase, "raw", context.getPackageName()));
        } catch (Resources.NotFoundException e) {
            Logger logger$OneID_release = this.getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.e(TAG2, "Unable to find resource stream for language: " + languagePref, e);
            return null;
        } catch (Exception e2) {
            Logger logger$OneID_release2 = this.getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            logger$OneID_release2.e(TAG3, "Error opening stream for language: " + languagePref, e2);
            return null;
        }
    }

    public final void loadL10NFromLocalFile$OneID_release(@NotNull Context context, @NotNull String languagePref) {
        JSONObject jSONObjectOptJSONObject;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(languagePref, "languagePref");
        InputStream inputStreamResourceStreamForLanguagePref$OneID_release = resourceStreamForLanguagePref$OneID_release(context, languagePref);
        if (inputStreamResourceStreamForLanguagePref$OneID_release == null) {
            inputStreamResourceStreamForLanguagePref$OneID_release = resourceStreamForLanguagePref$OneID_release(context, Config.LANGUAGE_DEFAULT);
        }
        if (inputStreamResourceStreamForLanguagePref$OneID_release != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamResourceStreamForLanguagePref$OneID_release, Charsets.UTF_8), 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                if (text.length() > 0) {
                    try {
                        JSONObject jSONObjectOptJSONObject2 = new JSONObject(text).optJSONObject("mobile");
                        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("message")) == null) {
                            return;
                        }
                        Intrinsics.checkNotNull(jSONObjectOptJSONObject);
                        setLocalizedStrings$OneID_release(jSONObjectOptJSONObject);
                    } catch (JSONException e) {
                        Logger logger$OneID_release = getLogger$OneID_release();
                        String TAG2 = TAG;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        logger$OneID_release.e(TAG2, "Unable to serialize locally stored text file to JSON", e);
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        }
    }

    @Override // com.disney.id.android.SCALPController
    public boolean isHeadlessAllowed(@NotNull TrackerEventKey eventKey) {
        OneIDTrackerEvent event;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        SCALPController.SiteConfigDownloadStatus siteConfigDownloadStatusIsLoaded = isLoaded();
        int i = siteConfigDownloadStatusIsLoaded == null ? -1 : WhenMappings.$EnumSwitchMapping$0[siteConfigDownloadStatusIsLoaded.ordinal()];
        boolean zOptBoolean = false;
        if (i == -1) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "SiteConfig data is not downloaded yet", null, 4, null);
        } else if (i == 1) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "SiteConfig data failed to download", null, 4, null);
        } else if (i == 2) {
            JSONObject jSONObject = this.siteConfig;
            if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("uiConfig")) != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("headless")) != null) {
                zOptBoolean = jSONObjectOptJSONObject2.optBoolean("enabled");
            }
            if (!zOptBoolean && (event = getTracker$OneID_release().getEvent(eventKey)) != null) {
                OneIDTrackerEvent.appendCodes$OneID_release$default(event, "HEADLESS_DISALLOWED", OneIDTrackerEvent.ERROR_CATEGORY_FAILURE_BY_DESIGN, null, 4, null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return zOptBoolean;
    }

    @Override // com.disney.id.android.SCALPController
    public boolean isBiometricEnabled() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObject = this.siteConfig;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("uiConfig")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("touchId")) == null) {
            return false;
        }
        return jSONObjectOptJSONObject2.optBoolean("enabled");
    }

    @Override // com.disney.id.android.SCALPController
    public boolean hasPromotionId(@Nullable String ageBand, @NotNull String promotionID) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        Intrinsics.checkNotNullParameter(promotionID, "promotionID");
        JSONObject jSONObject = this.siteConfig;
        String strOptString = (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("newsletters")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(ageBand)) == null) ? null : jSONObjectOptJSONObject2.optString(promotionID);
        return (strOptString == null || StringsKt.isBlank(strOptString) || Intrinsics.areEqual(strOptString, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) ? false : true;
    }

    @Override // com.disney.id.android.SCALPController
    public boolean isExpiredNotificationEnabled() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (getOneIDStorage$OneID_release().getBoolean("notificationExpiredEnabled", false)) {
            return true;
        }
        JSONObject jSONObject = this.siteConfig;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.allegion.accesssdk.BuildConfig.SESSION_KEY_REFERENCE)) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("expiredNotification")) == null) {
            return false;
        }
        return jSONObjectOptJSONObject2.optBoolean("enabled");
    }
}
