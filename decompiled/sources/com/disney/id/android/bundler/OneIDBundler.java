package com.disney.id.android.bundler;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.AtomicFile;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.disney.id.android.Config;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.Guest;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.OneID;
import com.disney.id.android.Profile;
import com.disney.id.android.SWID;
import com.disney.id.android.bundler.Bundler;
import com.disney.id.android.bundler.BundlerCallbackData;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.localdata.ExposedStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.services.BundlerService;
import com.disney.id.android.tracker.EventAction;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.disney.id.android.tracker.Tracker;
import com.disney.id.android.tracker.TrackerEventKey;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 b2\u00020\u0001:\u0002abB\u0007\b\u0000¢\u0006\u0002\u0010\u0002J2\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\b\u0010J\u001a\u00020\nH\u0002J\u001a\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\n2\u0006\u0010N\u001a\u00020OH\u0002J \u0010P\u001a\u00020L2\b\u0010Q\u001a\u0004\u0018\u00010R2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TH\u0016J\b\u0010V\u001a\u00020\nH\u0016J\n\u0010W\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010X\u001a\u00020*H\u0016J,\u0010Y\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\n\u0010[\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020,8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002058\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020;X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u00020=8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u000e\u0010B\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/disney/id/android/bundler/OneIDBundler;", "Lcom/disney/id/android/bundler/Bundler;", "()V", "appContext", "Landroid/content/Context;", "getAppContext$OneID_release", "()Landroid/content/Context;", "setAppContext$OneID_release", "(Landroid/content/Context;)V", "baseURL", "", "bundleFile", "Ljava/io/File;", "bundleGuardian", "Ljava/util/concurrent/Semaphore;", "bundleState", "Lcom/disney/id/android/bundler/OneIDBundler$BundleState;", "bundlerService", "Lcom/disney/id/android/services/BundlerService;", "getBundlerService$OneID_release", "()Lcom/disney/id/android/services/BundlerService;", "setBundlerService$OneID_release", "(Lcom/disney/id/android/services/BundlerService;)V", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler$OneID_release", "()Lcom/disney/id/android/ConfigHandler;", "setConfigHandler$OneID_release", "(Lcom/disney/id/android/ConfigHandler;)V", "exposedStorage", "Lcom/disney/id/android/localdata/ExposedStorage;", "getExposedStorage$OneID_release", "()Lcom/disney/id/android/localdata/ExposedStorage;", "setExposedStorage$OneID_release", "(Lcom/disney/id/android/localdata/ExposedStorage;)V", "guestHandler", "Lcom/disney/id/android/GuestHandler;", "getGuestHandler$OneID_release", "()Lcom/disney/id/android/GuestHandler;", "setGuestHandler$OneID_release", "(Lcom/disney/id/android/GuestHandler;)V", "isBundleLoaded", "", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "storedETagKey", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "timeoutInSeconds", "", "tracker", "Lcom/disney/id/android/tracker/Tracker;", "getTracker$OneID_release", "()Lcom/disney/id/android/tracker/Tracker;", "setTracker$OneID_release", "(Lcom/disney/id/android/tracker/Tracker;)V", "version", "buildBundleFilePath", "clientId", "bundleVersion", "env", "lang", "cssOverideUrl", "Ljava/net/URL;", "compileURL", "downloadBundle", "", "conversationId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/bundler/Bundler$Listener;", "getBundle", "conversationEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "callback", "Lcom/disney/id/android/bundler/BundlerCallback;", "Lcom/disney/id/android/bundler/BundlerCallbackData;", "getBundleVersion", "getIfNoneMatchHeader", "hasBundle", "initialize", "baseBundlerURL", "readBundle", "writeBundle", "bundleInputStream", "Ljava/io/InputStream;", "event", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "BundleState", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDBundler implements Bundler {
    private static final String TAG = OneIDBundler.class.getSimpleName();

    @NotNull
    public static final String responseETagKey = "ETag";

    @Inject
    public Context appContext;
    private String baseURL;
    private File bundleFile;

    @Inject
    public BundlerService bundlerService;

    @Inject
    public ConfigHandler configHandler;

    @Inject
    public ExposedStorage exposedStorage;

    @Inject
    public GuestHandler guestHandler;
    private boolean isBundleLoaded;

    @Inject
    public Logger logger;
    private SharedPreferences sharedPreferences;
    private String storedETagKey;

    @Inject
    public SWID swid;

    @Inject
    public Tracker tracker;
    private String version;
    private final Semaphore bundleGuardian = new Semaphore(1, true);
    private final long timeoutInSeconds = 5;
    private BundleState bundleState = BundleState.Uninitialized;

    public OneIDBundler() {
        OneIDDagger.getComponent().inject(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getAppContext$OneID_release());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.sharedPreferences = defaultSharedPreferences;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/disney/id/android/bundler/OneIDBundler$BundleState;", "", "(Ljava/lang/String;I)V", "Uninitialized", "Initializing", "Downloading", "FailedDownload", "ReadyNew", "ReadyCached", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BundleState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BundleState[] $VALUES;
        public static final BundleState Uninitialized = new BundleState("Uninitialized", 0);
        public static final BundleState Initializing = new BundleState("Initializing", 1);
        public static final BundleState Downloading = new BundleState("Downloading", 2);
        public static final BundleState FailedDownload = new BundleState("FailedDownload", 3);
        public static final BundleState ReadyNew = new BundleState("ReadyNew", 4);
        public static final BundleState ReadyCached = new BundleState("ReadyCached", 5);

        private static final /* synthetic */ BundleState[] $values() {
            return new BundleState[]{Uninitialized, Initializing, Downloading, FailedDownload, ReadyNew, ReadyCached};
        }

        @NotNull
        public static EnumEntries<BundleState> getEntries() {
            return $ENTRIES;
        }

        public static BundleState valueOf(String str) {
            return (BundleState) Enum.valueOf(BundleState.class, str);
        }

        public static BundleState[] values() {
            return (BundleState[]) $VALUES.clone();
        }

        private BundleState(String str, int i) {
        }

        static {
            BundleState[] bundleStateArr$values = $values();
            $VALUES = bundleStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(bundleStateArr$values);
        }
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
    public final GuestHandler getGuestHandler$OneID_release() {
        GuestHandler guestHandler = this.guestHandler;
        if (guestHandler != null) {
            return guestHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guestHandler");
        return null;
    }

    public final void setGuestHandler$OneID_release(@NotNull GuestHandler guestHandler) {
        Intrinsics.checkNotNullParameter(guestHandler, "<set-?>");
        this.guestHandler = guestHandler;
    }

    @NotNull
    public final Context getAppContext$OneID_release() {
        Context context = this.appContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        return null;
    }

    public final void setAppContext$OneID_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.appContext = context;
    }

    @NotNull
    public final ExposedStorage getExposedStorage$OneID_release() {
        ExposedStorage exposedStorage = this.exposedStorage;
        if (exposedStorage != null) {
            return exposedStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("exposedStorage");
        return null;
    }

    public final void setExposedStorage$OneID_release(@NotNull ExposedStorage exposedStorage) {
        Intrinsics.checkNotNullParameter(exposedStorage, "<set-?>");
        this.exposedStorage = exposedStorage;
    }

    private final String buildBundleFilePath(String clientId, String bundleVersion, String env, String lang, URL cssOverideUrl) {
        String path;
        String str = getAppContext$OneID_release().getFilesDir().getPath() + "/Bundle." + env + InstructionFileId.DOT + clientId + InstructionFileId.DOT + bundleVersion + InstructionFileId.DOT + lang;
        if (cssOverideUrl != null && (path = cssOverideUrl.getPath()) != null) {
            str = ((Object) str) + InstructionFileId.DOT + path.hashCode();
        }
        String string = getExposedStorage$OneID_release().getString(LightboxActivity.UI_VERSION_EXTRA, null);
        if (string == null || string.length() == 0) {
            return str;
        }
        return ((Object) str) + InstructionFileId.DOT + StringsKt.replace$default(string, InstructionFileId.DOT, "_", false, 4, (Object) null);
    }

    @Override // com.disney.id.android.bundler.Bundler
    public void initialize(@Nullable String conversationId, @NotNull String bundleVersion, @NotNull String baseBundlerURL, @Nullable Bundler.Listener listener) throws TimeoutException {
        BundleState bundleState;
        Intrinsics.checkNotNullParameter(bundleVersion, "bundleVersion");
        Intrinsics.checkNotNullParameter(baseBundlerURL, "baseBundlerURL");
        Config config = getConfigHandler$OneID_release().get();
        this.version = bundleVersion;
        this.baseURL = baseBundlerURL;
        this.bundleFile = new File(buildBundleFilePath(config.getClientId(), bundleVersion, config.getEnvironment().name(), config.getLanguage(), config.getCssOverrideUrl()));
        this.storedETagKey = "storedETagKey" + bundleVersion;
        this.bundleState = BundleState.Initializing;
        if (listener != null) {
            downloadBundle(conversationId, listener);
            return;
        }
        if (hasBundle()) {
            bundleState = BundleState.ReadyCached;
        } else {
            bundleState = BundleState.FailedDownload;
        }
        this.bundleState = bundleState;
    }

    private final String compileURL() {
        Profile profile;
        Config config = getConfigHandler$OneID_release().get();
        String string = config.getEnvironment().toString();
        String str = OneID.Environment.STG == config.getEnvironment() ? "STAGE" : string;
        String str2 = this.baseURL;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseURL");
            str2 = null;
        }
        Uri.Builder builderBuildUpon = Uri.parse(str2).buildUpon();
        Intrinsics.checkNotNullExpressionValue(builderBuildUpon, "buildUpon(...)");
        builderBuildUpon.appendPath(config.getClientId() + "-" + str).appendPath(config.getLanguage());
        String str3 = this.version;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("version");
            str3 = null;
        }
        if (Intrinsics.areEqual(str3, "v2")) {
            builderBuildUpon.appendQueryParameter("client", "android").appendQueryParameter("include", "l10n,config,html,js").appendQueryParameter("config", string).appendQueryParameter("content", string).appendQueryParameter("l10n", string).appendQueryParameter("ui", "mobile");
        }
        builderBuildUpon.appendQueryParameter("version", "4.12.5");
        String string2 = getExposedStorage$OneID_release().getString(LightboxActivity.UI_VERSION_EXTRA, null);
        if (string2 != null) {
            builderBuildUpon.appendQueryParameter(LightboxActivity.UI_VERSION_EXTRA, string2);
        }
        URL cssOverrideUrl = config.getCssOverrideUrl();
        if (cssOverrideUrl != null) {
            builderBuildUpon.appendQueryParameter("cssOverride", cssOverrideUrl.toString());
        }
        Guest guest = getGuestHandler$OneID_release().get();
        if (guest != null && (profile = guest.getProfile()) != null) {
            builderBuildUpon.appendQueryParameter("ageBand", profile.getAgeBand());
            String countryCodeDetected = profile.getCountryCodeDetected();
            if (countryCodeDetected != null) {
                builderBuildUpon.appendQueryParameter("countryCode", countryCodeDetected);
            }
        }
        String string3 = builderBuildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        return string3;
    }

    @Override // com.disney.id.android.bundler.Bundler
    public boolean hasBundle() {
        File file = this.bundleFile;
        if (file != null) {
            return file.exists();
        }
        return false;
    }

    @Override // com.disney.id.android.bundler.Bundler
    @NotNull
    public String getBundleVersion() {
        String str = this.version;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("version");
        return null;
    }

    @Override // com.disney.id.android.bundler.Bundler
    public void getBundle(@Nullable TrackerEventKey conversationEventKey, @NotNull BundlerCallback<BundlerCallbackData> callback) {
        File file;
        String bundle;
        File file2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            try {
            } catch (Exception e) {
                if (e instanceof TimeoutException) {
                    Logger logger$OneID_release = getLogger$OneID_release();
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "A timeout occurred while waiting to get access to the cached Bundle", null, 4, null);
                    if (conversationEventKey != null) {
                        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), conversationEventKey, false, OneIDTrackerEvent.ERROR_CODE_BUNDLE_READ_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "timeoutexception(" + e.getMessage() + ")", false, 32, null);
                    }
                    callback.onFailure(new BundlerCallbackData(null, null, BundlerCallbackData.ErrorType.RuntimeError, false, e, 3, null));
                } else {
                    Logger logger$OneID_release2 = getLogger$OneID_release();
                    String TAG3 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "A non-timeout error occurred before trying to read the cached Bundle", null, 4, null);
                    if (conversationEventKey != null) {
                        Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), conversationEventKey, true, OneIDTrackerEvent.ERROR_CODE_BUNDLE_READ_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "exception(" + e.getMessage() + ")", false, 32, null);
                    }
                    callback.onFailure(new BundlerCallbackData(null, null, BundlerCallbackData.ErrorType.RuntimeError, false, e, 3, null));
                }
            }
            if (!this.bundleGuardian.tryAcquire(this.timeoutInSeconds, TimeUnit.SECONDS)) {
                throw new TimeoutException();
            }
            BundleState bundleState = this.bundleState;
            if (bundleState != BundleState.ReadyNew && bundleState != BundleState.ReadyCached) {
                Logger logger$OneID_release3 = getLogger$OneID_release();
                String TAG4 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                Logger.DefaultImpls.e$default(logger$OneID_release3, TAG4, "getBundle was called but the bundlerState was not set to a ready state", null, 4, null);
                if (conversationEventKey != null) {
                    Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), conversationEventKey, true, OneIDTrackerEvent.ERROR_CODE_BUNDLE_READ_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "bundlestate(" + this.bundleState + ")", false, 32, null);
                }
                callback.onFailure(new BundlerCallbackData(null, null, BundlerCallbackData.ErrorType.RuntimeError, false, null, 19, null));
                this.bundleGuardian.release();
                return;
            }
            try {
                bundle = readBundle();
            } catch (IOException e2) {
                if (hasBundle() && (file = this.bundleFile) != null) {
                    file.delete();
                }
                Logger logger$OneID_release4 = getLogger$OneID_release();
                String TAG5 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                logger$OneID_release4.e(TAG5, "An IOException occurred while trying to read the cached bundle", e2);
                if (conversationEventKey != null) {
                    Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), conversationEventKey, false, OneIDTrackerEvent.ERROR_CODE_BUNDLE_READ_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "ioexception(" + e2.getMessage() + ")", false, 32, null);
                }
                callback.onFailure(new BundlerCallbackData(null, null, BundlerCallbackData.ErrorType.ReadError, false, e2, 3, null));
            }
            if (bundle == null) {
                File file3 = this.bundleFile;
                throw new IOException("Bundle file not read or empty // " + (file3 != null ? file3.getName() : null));
            }
            this.isBundleLoaded = true;
            Logger logger$OneID_release5 = getLogger$OneID_release();
            String TAG6 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
            Logger.DefaultImpls.i$default(logger$OneID_release5, TAG6, "About to return a cached version of the Bundle", null, 4, null);
            try {
                callback.onSuccess(new BundlerCallbackData(bundle, compileURL(), null, true, null, 20, null));
            } catch (UninitializedPropertyAccessException e3) {
                if (hasBundle() && (file2 = this.bundleFile) != null) {
                    file2.delete();
                }
                Logger logger$OneID_release6 = getLogger$OneID_release();
                String TAG7 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                logger$OneID_release6.e(TAG7, "OneIDBundler not properly initialized.  Bundle cache deleted.", e3);
                if (conversationEventKey != null) {
                    Tracker.DefaultImpls.finishEvent$default(getTracker$OneID_release(), conversationEventKey, false, OneIDTrackerEvent.ERROR_CODE_BUNDLE_READ_ERROR, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "ioexception(" + e3.getMessage() + ")", false, 32, null);
                }
                callback.onFailure(new BundlerCallbackData(null, null, BundlerCallbackData.ErrorType.ReadError, false, e3, 3, null));
            }
            this.bundleGuardian.release();
        } catch (Throwable th) {
            this.bundleGuardian.release();
            throw th;
        }
    }

    private final String readBundle() throws FileNotFoundException {
        FileInputStream fileInputStreamOpenRead = new AtomicFile(this.bundleFile).openRead();
        if (fileInputStreamOpenRead == null) {
            return null;
        }
        try {
            String text = TextStreamsKt.readText(new InputStreamReader(fileInputStreamOpenRead, Charsets.UTF_8));
            CloseableKt.closeFinally(fileInputStreamOpenRead, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStreamOpenRead, th);
                throw th2;
            }
        }
    }

    private final void downloadBundle(String conversationId, final Bundler.Listener listener) throws TimeoutException {
        try {
            if (!this.bundleGuardian.tryAcquire(this.timeoutInSeconds, TimeUnit.SECONDS)) {
                throw new TimeoutException();
            }
            final String strCompileURL = compileURL();
            Tracker tracker$OneID_release = getTracker$OneID_release();
            EventAction eventAction = EventAction.SERVICE_DOWNLOAD_BUNDLE;
            String str = getSwid$OneID_release().get();
            String str2 = this.version;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("version");
                str2 = null;
            }
            final TrackerEventKey trackerEventKeyStartTransactionEvent$default = Tracker.DefaultImpls.startTransactionEvent$default(tracker$OneID_release, conversationId, eventAction, str, "bundle(" + str2 + ")", null, 16, null);
            final OneIDTrackerEvent event = getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
            Call<ResponseBody> callRequestBundle = getBundlerService$OneID_release().requestBundle(strCompileURL, event != null ? event.getTransactionId$OneID_release() : null, getIfNoneMatchHeader());
            this.bundleState = BundleState.Downloading;
            callRequestBundle.enqueue(new Callback<ResponseBody>() { // from class: com.disney.id.android.bundler.OneIDBundler.downloadBundle.1
                @Override // retrofit2.Callback
                public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
                    Bundler.Listener listener2;
                    BundleState bundleState;
                    BundleState bundleState2;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    try {
                        try {
                            OneIDTrackerEvent event2 = OneIDBundler.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                            if (event2 != null) {
                                OneIDTrackerEvent.appendCodes$OneID_release$default(event2, null, null, "httpstatus(" + response.code() + ")", 3, null);
                            }
                            int iCode = response.code();
                            if (response.isSuccessful()) {
                                SharedPreferences sharedPreferences = OneIDBundler.this.sharedPreferences;
                                String str3 = OneIDBundler.this.storedETagKey;
                                if (str3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("storedETagKey");
                                    str3 = null;
                                }
                                String string = sharedPreferences.getString(str3, null);
                                boolean zHasBundle = OneIDBundler.this.hasBundle();
                                if (string != null && zHasBundle && LightboxActivity.INSTANCE.isPresenting$OneID_release().get()) {
                                    Tracker.DefaultImpls.finishEvent$default(OneIDBundler.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
                                    Logger logger$OneID_release = OneIDBundler.this.getLogger$OneID_release();
                                    String str4 = OneIDBundler.TAG;
                                    Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                                    Logger.DefaultImpls.d$default(logger$OneID_release, str4, "The lightbox is presenting. The Bundle is current (200 code)", null, 4, null);
                                    OneIDBundler oneIDBundler = OneIDBundler.this;
                                    BundleState bundleState3 = BundleState.ReadyCached;
                                    oneIDBundler.bundleState = bundleState3;
                                    OneIDBundler.this.bundleGuardian.release();
                                    OneIDBundler.this.bundleGuardian.release();
                                    BundleState bundleState4 = OneIDBundler.this.bundleState;
                                    BundleState bundleState5 = BundleState.ReadyNew;
                                    if (bundleState4 == bundleState5 || OneIDBundler.this.bundleState == bundleState3) {
                                        listener.onComplete(OneIDBundler.this.bundleState == bundleState5);
                                        return;
                                    }
                                    return;
                                }
                                try {
                                    BuildersKt.runBlocking(Dispatchers.getDefault(), new OneIDBundler$downloadBundle$1$onResponse$1(response, OneIDBundler.this, event, trackerEventKeyStartTransactionEvent$default, null));
                                } catch (IOException e) {
                                    Logger logger$OneID_release2 = OneIDBundler.this.getLogger$OneID_release();
                                    String str5 = OneIDBundler.TAG;
                                    Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                                    logger$OneID_release2.e(str5, "An IOException occurred writing out the Bundle", e);
                                    Tracker.DefaultImpls.finishEvent$default(OneIDBundler.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, "UNKNOWN_ERROR", OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "error(" + e.getMessage() + ")", false, 32, null);
                                }
                            } else if (iCode == 304) {
                                Tracker.DefaultImpls.finishEvent$default(OneIDBundler.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, null, null, null, false, 62, null);
                                Logger logger$OneID_release3 = OneIDBundler.this.getLogger$OneID_release();
                                String str6 = OneIDBundler.TAG;
                                Intrinsics.checkNotNullExpressionValue(str6, "access$getTAG$cp(...)");
                                Logger.DefaultImpls.d$default(logger$OneID_release3, str6, "The Bundle is current (304 code)", null, 4, null);
                                OneIDBundler.this.bundleState = BundleState.ReadyCached;
                            } else if (iCode == 400) {
                                Tracker.DefaultImpls.finishEvent$default(OneIDBundler.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, false, OneIDTrackerEvent.ERROR_CODE_UNEXPECTED_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "url(" + strCompileURL + ")", false, 34, null);
                                OneIDBundler.this.bundleState = BundleState.FailedDownload;
                                Logger logger$OneID_release4 = OneIDBundler.this.getLogger$OneID_release();
                                String str7 = OneIDBundler.TAG;
                                Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
                                Logger.DefaultImpls.e$default(logger$OneID_release4, str7, "Something was not configured properly in the bundle request. URL: " + strCompileURL, null, 4, null);
                            } else {
                                OneIDBundler.this.getTracker$OneID_release().finishEvent(trackerEventKeyStartTransactionEvent$default, false, OneIDTrackerEvent.ERROR_CODE_UNEXPECTED_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_SERVICE_INTERACTION_ERROR, "url(" + strCompileURL + ")", true);
                                OneIDBundler.this.bundleState = BundleState.FailedDownload;
                                Logger logger$OneID_release5 = OneIDBundler.this.getLogger$OneID_release();
                                String str8 = OneIDBundler.TAG;
                                Intrinsics.checkNotNullExpressionValue(str8, "access$getTAG$cp(...)");
                                Logger.DefaultImpls.e$default(logger$OneID_release5, str8, "Service returned error " + response.code() + ". URL: " + strCompileURL, null, 4, null);
                            }
                            OneIDBundler.this.bundleGuardian.release();
                            bundleState = OneIDBundler.this.bundleState;
                            bundleState2 = BundleState.ReadyNew;
                        } catch (Exception e2) {
                            Tracker.DefaultImpls.finishEvent$default(OneIDBundler.this.getTracker$OneID_release(), trackerEventKeyStartTransactionEvent$default, true, OneIDTrackerEvent.ERROR_CODE_INVALID_RESPONSE, OneIDTrackerEvent.ERROR_CATEGORY_CLIENT_FAILURE, "throwable(" + e2.getMessage() + ")", false, 32, null);
                            Logger logger$OneID_release6 = OneIDBundler.this.getLogger$OneID_release();
                            String str9 = OneIDBundler.TAG;
                            Intrinsics.checkNotNullExpressionValue(str9, "access$getTAG$cp(...)");
                            logger$OneID_release6.e(str9, "An unknown Exception occurred in the download bundle response", e2);
                            OneIDBundler.this.bundleGuardian.release();
                            BundleState bundleState6 = OneIDBundler.this.bundleState;
                            BundleState bundleState7 = BundleState.ReadyNew;
                            if (bundleState6 != bundleState7 && OneIDBundler.this.bundleState != BundleState.ReadyCached) {
                                return;
                            }
                            listener2 = listener;
                            if (OneIDBundler.this.bundleState == bundleState7) {
                            }
                        }
                        if (bundleState == bundleState2 || OneIDBundler.this.bundleState == BundleState.ReadyCached) {
                            listener2 = listener;
                            if (OneIDBundler.this.bundleState == bundleState2) {
                                z = true;
                            }
                            listener2.onComplete(z);
                        }
                    } catch (Throwable th) {
                        OneIDBundler.this.bundleGuardian.release();
                        BundleState bundleState8 = OneIDBundler.this.bundleState;
                        BundleState bundleState9 = BundleState.ReadyNew;
                        if (bundleState8 == bundleState9 || OneIDBundler.this.bundleState == BundleState.ReadyCached) {
                            listener.onComplete(OneIDBundler.this.bundleState == bundleState9);
                        }
                        throw th;
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    OneIDTrackerEvent event2 = OneIDBundler.this.getTracker$OneID_release().getEvent(trackerEventKeyStartTransactionEvent$default);
                    if (event2 != null) {
                        event2.appendCodes$OneID_release(null, null, "throwable(" + t.getMessage() + ")");
                    }
                    Logger logger$OneID_release = OneIDBundler.this.getLogger$OneID_release();
                    String str3 = OneIDBundler.TAG;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                    Logger.DefaultImpls.e$default(logger$OneID_release, str3, "This is throwable message: " + t.getLocalizedMessage(), null, 4, null);
                    if (t instanceof IOException) {
                        OneIDBundler.this.bundleState = BundleState.FailedDownload;
                        Logger logger$OneID_release2 = OneIDBundler.this.getLogger$OneID_release();
                        String str4 = OneIDBundler.TAG;
                        Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.e$default(logger$OneID_release2, str4, "A connection error occurred", null, 4, null);
                    } else {
                        OneIDBundler.this.bundleState = BundleState.FailedDownload;
                        Logger logger$OneID_release3 = OneIDBundler.this.getLogger$OneID_release();
                        String str5 = OneIDBundler.TAG;
                        Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                        Logger.DefaultImpls.e$default(logger$OneID_release3, str5, "Call Failed", null, 4, null);
                    }
                    listener.onFailure(trackerEventKeyStartTransactionEvent$default);
                    OneIDBundler.this.bundleGuardian.release();
                }
            });
        } catch (Exception e) {
            if (e instanceof TimeoutException) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                Logger.DefaultImpls.e$default(logger$OneID_release, TAG2, "A timeout occurred while waiting to get access to the cached Bundle", null, 4, null);
                return;
            }
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.e$default(logger$OneID_release2, TAG3, "An unknown Exception occurred trying to download the bundle", null, 4, null);
            this.bundleGuardian.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void writeBundle(InputStream bundleInputStream, OneIDTrackerEvent event) throws IOException {
        File file = this.bundleFile;
        Unit unit = null;
        if (file != null) {
            AtomicFile atomicFile = new AtomicFile(file);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            try {
                try {
                    writeBundle$lambda$14$attemptWrite(objectRef, atomicFile, bundleInputStream);
                } catch (IOException unused) {
                    if (objectRef.element != 0) {
                        atomicFile.failWrite((FileOutputStream) objectRef.element);
                        if (event != null) {
                            event.appendCodes$OneID_release(null, null, "bundleRemoved(" + this.bundleFile + ")");
                        }
                    }
                    try {
                        writeBundle$lambda$14$attemptWrite(objectRef, atomicFile, bundleInputStream);
                    } catch (Exception e) {
                        if (objectRef.element != 0) {
                            atomicFile.failWrite((FileOutputStream) objectRef.element);
                        }
                        throw new IOException("Failed to write the bundle file", e);
                    }
                } catch (Exception e2) {
                    throw new IOException("Failed to write the bundle file", e2);
                }
                unit = Unit.INSTANCE;
            } finally {
                bundleInputStream.close();
            }
        }
        if (unit == null) {
            throw new IOException("The bundle file was not initialized");
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.io.FileOutputStream] */
    private static final void writeBundle$lambda$14$attemptWrite(Ref.ObjectRef objectRef, AtomicFile atomicFile, InputStream inputStream) throws IOException {
        ?? StartWrite = atomicFile.startWrite();
        objectRef.element = StartWrite;
        Closeable closeable = (Closeable) StartWrite;
        try {
            FileOutputStream fileOutputStream = (FileOutputStream) closeable;
            if (fileOutputStream != null) {
                ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, null);
                fileOutputStream.flush();
            }
            atomicFile.finishWrite(fileOutputStream);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(closeable, null);
        } finally {
        }
    }

    private final String getIfNoneMatchHeader() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        String str = this.storedETagKey;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storedETagKey");
            str = null;
        }
        String string = sharedPreferences.getString(str, null);
        boolean zHasBundle = hasBundle();
        if (string != null && zHasBundle) {
            return string;
        }
        if (zHasBundle) {
            return null;
        }
        return "0xDEADBEEF";
    }
}
