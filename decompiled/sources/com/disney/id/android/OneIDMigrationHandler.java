package com.disney.id.android;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.localdata.EncryptedSharedPreferences;
import com.disney.id.android.localdata.LocalStorage;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.OneIDTracker;
import com.disney.id.android.utils.GsonUtils;
import com.disney.id.android.version.LibraryVersion;
import com.disney.id.android.version.SemanticVersion;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 @2\u00020\u0001:\u0001@B\u0005¢\u0006\u0002\u0010\u0002J2\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u0018\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(H\u0002J\b\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020(H\u0002J\u001a\u00106\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u0010*\u001a\u00020(H\u0002J\b\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0002J\u0018\u0010;\u001a\u0002082\u0006\u0010*\u001a\u00020(2\u0006\u0010:\u001a\u000208H\u0002J\u0018\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006A"}, d2 = {"Lcom/disney/id/android/OneIDMigrationHandler;", "Lcom/disney/id/android/MigrationHandler;", "()V", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler$OneID_release", "()Lcom/disney/id/android/ConfigHandler;", "setConfigHandler$OneID_release", "(Lcom/disney/id/android/ConfigHandler;)V", "context", "Landroid/content/Context;", "getContext$OneID_release", "()Landroid/content/Context;", "setContext$OneID_release", "(Landroid/content/Context;)V", "guestMigrationAttempted", "", "guestMigrationFailed", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "shouldNotifyOfLogout", "getShouldNotifyOfLogout", "()Z", "storage", "Lcom/disney/id/android/localdata/LocalStorage;", "getStorage$OneID_release", "()Lcom/disney/id/android/localdata/LocalStorage;", "setStorage$OneID_release", "(Lcom/disney/id/android/localdata/LocalStorage;)V", "swidController", "Lcom/disney/id/android/SWID;", "getSwidController$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwidController$OneID_release", "(Lcom/disney/id/android/SWID;)V", "buildBundleFileCachePath", "", "clientId", "useVersion", "env", "lang", "cssOverideUrl", "Ljava/net/URL;", "buildBundleFileCachePathAsOf461", "clearState", "", "getLatestBundleCache", "Ljava/io/File;", "config", "Lcom/disney/id/android/Config;", "getPreviousCachedBundle", "migrate", "Lcom/disney/id/android/MigrationInfo;", "migrateBundler", "migrationInfo", "migrateBundlerByVersion", "migrateToVersionFour", "from", "Lcom/disney/id/android/version/LibraryVersion;", TypedValues.TransitionType.S_TO, "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMigrationHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MigrationHandler.kt\ncom/disney/id/android/OneIDMigrationHandler\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,292:1\n215#2,2:293\n215#2,2:295\n1855#3,2:297\n*S KotlinDebug\n*F\n+ 1 MigrationHandler.kt\ncom/disney/id/android/OneIDMigrationHandler\n*L\n120#1:293,2\n193#1:295,2\n267#1:297,2\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDMigrationHandler implements MigrationHandler {
    private static final String TAG = OneIDMigrationHandler.class.getSimpleName();

    @Inject
    public ConfigHandler configHandler;

    @Inject
    public Context context;
    private boolean guestMigrationAttempted;
    private boolean guestMigrationFailed;

    @Inject
    public Logger logger;

    @Inject
    public LocalStorage storage;

    @Inject
    public SWID swidController;

    public OneIDMigrationHandler() {
        OneIDDagger.getComponent().inject(this);
    }

    @NotNull
    public final LocalStorage getStorage$OneID_release() {
        LocalStorage localStorage = this.storage;
        if (localStorage != null) {
            return localStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        return null;
    }

    public final void setStorage$OneID_release(@NotNull LocalStorage localStorage) {
        Intrinsics.checkNotNullParameter(localStorage, "<set-?>");
        this.storage = localStorage;
    }

    @NotNull
    public final Context getContext$OneID_release() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext$OneID_release(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    @NotNull
    public final SWID getSwidController$OneID_release() {
        SWID swid = this.swidController;
        if (swid != null) {
            return swid;
        }
        Intrinsics.throwUninitializedPropertyAccessException("swidController");
        return null;
    }

    public final void setSwidController$OneID_release(@NotNull SWID swid) {
        Intrinsics.checkNotNullParameter(swid, "<set-?>");
        this.swidController = swid;
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

    @Override // com.disney.id.android.MigrationHandler
    public boolean getShouldNotifyOfLogout() {
        return this.guestMigrationAttempted && this.guestMigrationFailed;
    }

    @Override // com.disney.id.android.MigrationHandler
    public void clearState() {
        this.guestMigrationAttempted = false;
        this.guestMigrationFailed = false;
    }

    @Override // com.disney.id.android.MigrationHandler
    @NotNull
    public MigrationInfo migrate() throws IOException {
        MigrationInfo migrationInfo = new MigrationInfo();
        String str = getStorage$OneID_release().get("lastUpdatedVersion");
        if (str == null || str.length() == 0) {
            Map<String, ?> all = getContext$OneID_release().getSharedPreferences("did_local_data_enc", 0).getAll();
            Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
            if (!all.isEmpty()) {
                str = "3.x";
            }
        }
        LibraryVersion.Companion companion = LibraryVersion.INSTANCE;
        LibraryVersion libraryVersionVersionFromString = companion.versionFromString(str == null ? "" : str);
        LibraryVersion libraryVersionVersionFromString2 = companion.versionFromString("4.12.5");
        if (libraryVersionVersionFromString == null || libraryVersionVersionFromString2 == null) {
            getStorage$OneID_release().put("lastUpdatedVersion", "4.12.5");
            return migrationInfo;
        }
        if (libraryVersionVersionFromString.compareTo((SemanticVersion) libraryVersionVersionFromString2) >= 0) {
            getStorage$OneID_release().put("lastUpdatedVersion", "4.12.5");
            return migrationInfo;
        }
        if (Integer.compareUnsigned(libraryVersionVersionFromString.mo1846getMajorpVg5ArA(), 4) < 0 && libraryVersionVersionFromString2.mo1846getMajorpVg5ArA() == 4) {
            migrationInfo = migrateToVersionFour(libraryVersionVersionFromString, libraryVersionVersionFromString2);
        } else if (libraryVersionVersionFromString.mo1846getMajorpVg5ArA() == 4 && libraryVersionVersionFromString2.mo1846getMajorpVg5ArA() == 4) {
            migrationInfo = migrateBundler(migrationInfo);
            if (str != null && StringsKt.startsWith$default(str, "4.9.", false, 2, (Object) null)) {
                for (Map.Entry<String, ?> entry : getStorage$OneID_release().getAll().entrySet()) {
                    if (StringsKt.endsWith$default(entry.getKey(), OneIDSession.lastDateRetrievedKey, false, 2, (Object) null)) {
                        getStorage$OneID_release().remove(entry.getKey());
                    }
                }
            }
        }
        getStorage$OneID_release().put("lastUpdatedVersion", libraryVersionVersionFromString2.getDescription());
        return migrationInfo;
    }

    private final MigrationInfo migrateToVersionFour(LibraryVersion from, LibraryVersion to) {
        JsonObject asJsonObject;
        JsonObject asJsonObject2;
        JsonElement jsonElement;
        MigrationInfo migrationInfo = new MigrationInfo();
        SharedPreferences sharedPreferences = getContext$OneID_release().getSharedPreferences(OneIDTracker.ONE_ID_STORAGE_KEY, 0);
        migrationInfo.setInfo("from(" + from.getDescription() + "),to(" + to.getDescription() + ")");
        SharedPreferences sharedPreferences2 = getContext$OneID_release().getSharedPreferences("DisneyID", 0);
        String string = sharedPreferences2.getString("did.anonSwid", null);
        if (string == null) {
            string = null;
        }
        String string2 = sharedPreferences2.getString("did.newrelic.uuid", null);
        if (string2 != null) {
            sharedPreferences.edit().putString(OneIDTracker.INSTALL_ID_KEY, string2).apply();
        }
        SharedPreferences sharedPreferences3 = EncryptedSharedPreferences.INSTANCE.getSharedPreferences(getContext$OneID_release(), "did_local_data");
        String str = "did.session." + getConfigHandler$OneID_release().get().getClientId() + ".guest";
        String string3 = sharedPreferences3.getString(str, null);
        if (string3 != null) {
            try {
                this.guestMigrationAttempted = true;
                this.guestMigrationFailed = true;
                JsonElement jsonElement2 = (JsonElement) GsonUtils.Companion.createStandardGson$default(GsonUtils.INSTANCE, false, false, false, 7, null).fromJson(string3, JsonElement.class);
                String asString = (jsonElement2 == null || (asJsonObject = jsonElement2.getAsJsonObject()) == null || (asJsonObject2 = asJsonObject.getAsJsonObject("token")) == null || (jsonElement = asJsonObject2.get("swid")) == null) ? null : jsonElement.getAsString();
                if (asString != null) {
                    string = asString;
                }
            } catch (Exception e) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "Error reading v3 guest object", e);
                migrationInfo.setCategory("UNKNOWN_ERROR");
                migrationInfo.setCodes("INVALID_JSON");
                migrationInfo.setInfo(migrationInfo.getInfo() + "migrateSharedPrefsParseGuest(failure)");
            }
        }
        Map<String, ?> all = sharedPreferences3.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Intrinsics.checkNotNull(key);
            if (StringsKt.startsWith$default(key, "did.session.", false, 2, (Object) null)) {
                getStorage$OneID_release().put(StringsKt.substringAfter$default(key, "did.session.", (String) null, 2, (Object) null), String.valueOf(value));
            } else {
                getStorage$OneID_release().put(key, String.valueOf(value));
            }
            if (this.guestMigrationAttempted && Intrinsics.areEqual(key, str)) {
                this.guestMigrationFailed = false;
            }
        }
        if (string != null) {
            getSwidController$OneID_release().set(string);
            if (!StringsKt.startsWith$default(string, "{", false, 2, (Object) null)) {
                getSwidController$OneID_release().forceStore();
            }
        }
        sharedPreferences2.edit().clear().apply();
        sharedPreferences3.edit().clear().apply();
        return migrationInfo;
    }

    private final MigrationInfo migrateBundler(MigrationInfo migrationInfo) {
        return migrateBundlerByVersion(OneIDSCALPController.USE_VERSION_4, migrateBundlerByVersion("v2", migrationInfo));
    }

    private final MigrationInfo migrateBundlerByVersion(String useVersion, MigrationInfo migrationInfo) {
        File latestBundleCache = getLatestBundleCache(getConfigHandler$OneID_release().get(), useVersion);
        if (latestBundleCache.exists()) {
            String info = migrationInfo.getInfo();
            migrationInfo.setInfo((info != null ? info : "") + "bundlerCacheMigration(latest)");
            return migrationInfo;
        }
        File previousCachedBundle = getPreviousCachedBundle(getConfigHandler$OneID_release().get(), useVersion);
        if (previousCachedBundle != null) {
            String info2 = migrationInfo.getInfo();
            if (info2 == null) {
                info2 = "";
            }
            migrationInfo.setInfo(info2 + "bundlerCache(from(" + previousCachedBundle.getPath() + "),(to" + latestBundleCache.getPath() + "))");
            try {
                previousCachedBundle.renameTo(latestBundleCache);
            } catch (Exception e) {
                Logger logger$OneID_release = getLogger$OneID_release();
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                logger$OneID_release.e(TAG2, "Error copying bundler cache", e);
                migrationInfo.setCategory("UNKNOWN_ERROR");
                migrationInfo.setCodes("INVALID_JSON");
                String info3 = migrationInfo.getInfo();
                migrationInfo.setInfo((info3 != null ? info3 : "") + "bundlerCacheMigration(failure)");
                Unit unit = Unit.INSTANCE;
            }
        }
        return migrationInfo;
    }

    private final File getLatestBundleCache(Config config, String useVersion) {
        return new File(buildBundleFileCachePath(config.getClientId(), useVersion, config.getEnvironment().getEnv(), config.getLanguage(), config.getCssOverrideUrl()));
    }

    private final File getPreviousCachedBundle(Config config, String useVersion) {
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{buildBundleFileCachePath(config.getClientId(), useVersion, config.getEnvironment().getEnv(), config.getLanguage(), null), buildBundleFileCachePathAsOf461(config.getClientId(), useVersion)}).iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private final String buildBundleFileCachePath(String clientId, String useVersion, String env, String lang, URL cssOverideUrl) {
        String path;
        String str = getContext$OneID_release().getFilesDir().getPath() + "/Bundle." + env + InstructionFileId.DOT + clientId + InstructionFileId.DOT + useVersion + InstructionFileId.DOT + lang;
        if (cssOverideUrl == null || (path = cssOverideUrl.getPath()) == null) {
            return str;
        }
        return ((Object) str) + InstructionFileId.DOT + path.hashCode();
    }

    private final String buildBundleFileCachePathAsOf461(String clientId, String useVersion) {
        return getContext$OneID_release().getFilesDir().getPath() + "/Bundle" + clientId + useVersion;
    }
}
