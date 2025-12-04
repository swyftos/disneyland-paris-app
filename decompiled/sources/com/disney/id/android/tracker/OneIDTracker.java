package com.disney.id.android.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Base64;
import androidx.camera.video.AudioStats;
import com.amazonaws.util.DateUtils;
import com.disney.id.android.Config;
import com.disney.id.android.ConfigHandler;
import com.disney.id.android.Connectivity;
import com.disney.id.android.Guest;
import com.disney.id.android.GuestHandler;
import com.disney.id.android.MigrationHandler;
import com.disney.id.android.MigrationInfo;
import com.disney.id.android.OneID;
import com.disney.id.android.OptionalConfigs;
import com.disney.id.android.SCALPConfigHandler;
import com.disney.id.android.SWID;
import com.disney.id.android.Token;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.lightbox.LightboxActivity;
import com.disney.id.android.logging.Logger;
import com.disney.id.android.tracker.Tracker;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020IH\u0002J!\u0010Q\u001a\u00020O2\u0006\u0010R\u001a\u00020I2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010TH\u0000¢\u0006\u0002\bUJ \u0010V\u001a\u0004\u0018\u00010*2\b\u0010W\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010*H\u0002J\b\u0010Y\u001a\u00020OH\u0002J\u001a\u0010Z\u001a\u00020O2\u0006\u0010P\u001a\u00020I2\b\b\u0002\u0010[\u001a\u00020\\H\u0002J>\u0010]\u001a\u00020O2\u0006\u0010^\u001a\u00020H2\u0006\u0010_\u001a\u00020\\2\b\u0010`\u001a\u0004\u0018\u00010*2\b\u0010a\u001a\u0004\u0018\u00010*2\b\u0010b\u001a\u0004\u0018\u00010*2\u0006\u0010[\u001a\u00020\\H\u0016J\u0012\u0010c\u001a\u0004\u0018\u00010*2\u0006\u0010d\u001a\u00020TH\u0002J\u0015\u0010e\u001a\u00020*2\u0006\u0010S\u001a\u00020TH\u0000¢\u0006\u0002\bfJ\u0014\u0010g\u001a\u0004\u0018\u00010I2\b\u0010^\u001a\u0004\u0018\u00010HH\u0016J\u001a\u0010h\u001a\u0004\u0018\u00010H2\u0006\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020*H\u0016J\u0012\u0010k\u001a\u0004\u0018\u00010H2\u0006\u0010j\u001a\u00020*H\u0016J\u0010\u0010l\u001a\u00020O2\u0006\u0010P\u001a\u00020IH\u0002J\u0012\u0010m\u001a\u00020O2\b\u0010W\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010n\u001a\u00020O2\u0006\u0010P\u001a\u00020IH\u0002J\r\u0010o\u001a\u00020OH\u0000¢\u0006\u0002\bpJ\u0012\u0010q\u001a\u00020O2\b\u0010r\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010s\u001a\u00020O2\b\u0010t\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010u\u001a\u00020O2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J6\u0010v\u001a\u00020H2\b\u0010i\u001a\u0004\u0018\u00010*2\u0006\u0010w\u001a\u00020x2\u0006\u0010@\u001a\u00020*2\b\u0010b\u001a\u0004\u0018\u00010*2\b\u0010d\u001a\u0004\u0018\u00010TH\u0016J6\u0010y\u001a\u00020H2\b\u0010i\u001a\u0004\u0018\u00010*2\u0006\u0010w\u001a\u00020x2\u0006\u0010@\u001a\u00020*2\b\u0010b\u001a\u0004\u0018\u00010*2\b\u0010d\u001a\u0004\u0018\u00010TH\u0016JZ\u0010z\u001a\u00020O2\b\u0010i\u001a\u0004\u0018\u00010*2\u0006\u0010{\u001a\u00020\\2\u0006\u0010w\u001a\u00020x2\u0006\u0010@\u001a\u00020*2\b\u0010a\u001a\u0004\u0018\u00010*2\b\u0010`\u001a\u0004\u0018\u00010*2\b\u0010b\u001a\u0004\u0018\u00010*2\b\u0010d\u001a\u0004\u0018\u00010T2\u0006\u0010_\u001a\u00020\\H\u0016J\u001e\u0010|\u001a\u00020O2\u0014\u0010}\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010\u007f0~H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u0010\u00104\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010.\"\u0004\b7\u00100R\u001e\u00108\u001a\u0002098\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020A8\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER&\u0010F\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0GX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006\u0081\u0001"}, d2 = {"Lcom/disney/id/android/tracker/OneIDTracker;", "Lcom/disney/id/android/tracker/Tracker;", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "configHandler", "Lcom/disney/id/android/ConfigHandler;", "getConfigHandler$OneID_release", "()Lcom/disney/id/android/ConfigHandler;", "setConfigHandler$OneID_release", "(Lcom/disney/id/android/ConfigHandler;)V", "conn", "Lcom/disney/id/android/Connectivity;", "getConn$OneID_release", "()Lcom/disney/id/android/Connectivity;", "setConn$OneID_release", "(Lcom/disney/id/android/Connectivity;)V", "eventQueue", "Lcom/disney/id/android/tracker/EventQueue;", "getEventQueue$OneID_release", "()Lcom/disney/id/android/tracker/EventQueue;", "setEventQueue$OneID_release", "(Lcom/disney/id/android/tracker/EventQueue;)V", "guestHandler", "Lcom/disney/id/android/GuestHandler;", "getGuestHandler$OneID_release", "()Lcom/disney/id/android/GuestHandler;", "setGuestHandler$OneID_release", "(Lcom/disney/id/android/GuestHandler;)V", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "migrationHandler", "Lcom/disney/id/android/MigrationHandler;", "getMigrationHandler$OneID_release", "()Lcom/disney/id/android/MigrationHandler;", "setMigrationHandler$OneID_release", "(Lcom/disney/id/android/MigrationHandler;)V", "mobileInstallId", "", "mobileLaunchID", "reportingContext", "getReportingContext$OneID_release", "()Ljava/lang/String;", "setReportingContext$OneID_release", "(Ljava/lang/String;)V", "reportingSource", "getReportingSource$OneID_release", "setReportingSource$OneID_release", "reportingValueBase64", "reportingValueString", "getReportingValueString$OneID_release", "setReportingValueString$OneID_release", "scalpConfigHandler", "Lcom/disney/id/android/SCALPConfigHandler;", "getScalpConfigHandler$OneID_release", "()Lcom/disney/id/android/SCALPConfigHandler;", "setScalpConfigHandler$OneID_release", "(Lcom/disney/id/android/SCALPConfigHandler;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "swid", "Lcom/disney/id/android/SWID;", "getSwid$OneID_release", "()Lcom/disney/id/android/SWID;", "setSwid$OneID_release", "(Lcom/disney/id/android/SWID;)V", "trackerEventMap", "", "Lcom/disney/id/android/tracker/TrackerEventKey;", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "getTrackerEventMap$OneID_release", "()Ljava/util/Map;", "setTrackerEventMap$OneID_release", "(Ljava/util/Map;)V", "addInitialEventData", "", "event", "addReportingEventData", "trackerEvent", "optionalConfig", "Lcom/disney/id/android/OptionalConfigs;", "addReportingEventData$OneID_release", "buildLaunchTrackerInfoColumn", LightboxActivity.UI_VERSION_EXTRA, "externalRefreshToken", "checkIfFirstInstallAndTrack", "finalizeEventAndSend", "disableThrottling", "", "finishEvent", "trackerEventKey", OneIDTrackerEvent.EVENT_PARAM_PROBLEM, "codes", "category", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "generateBase64ReportingValues", "config", "generateReportingValueString", "generateReportingValueString$OneID_release", "getEvent", "getEventFromConversationIdAndEventType", "conversationId", LightboxActivity.ACTION_NAME_EXTRA, "getEventFromEventType", "lastChanceDataChecks", "launchCheck", "removeProcessedTrackerEvent", "removeStaleTrackerEvents", "removeStaleTrackerEvents$OneID_release", "setBrowser", OneIDTrackerEvent.EVENT_PARAM_BROWSER, "setLightboxVersion", "version", "setOptionalConfigData", "startConversationEvent", "action", "Lcom/disney/id/android/tracker/EventAction;", "startTransactionEvent", "trackInstantEvent", "addTransactionId", "trackWebEvent", "webEvent", "", "", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOneIDTracker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OneIDTracker.kt\ncom/disney/id/android/tracker/OneIDTracker\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,609:1\n1#2:610\n215#3,2:611\n215#3,2:627\n494#4,7:613\n494#4,7:620\n*S KotlinDebug\n*F\n+ 1 OneIDTracker.kt\ncom/disney/id/android/tracker/OneIDTracker\n*L\n415#1:611,2\n597#1:627,2\n465#1:613,7\n469#1:620,7\n*E\n"})
/* loaded from: classes3.dex */
public final class OneIDTracker implements Tracker {
    public static final int CONTEXT_TIMEOUT_MILLI_SEC = 60000;

    @NotNull
    public static final String INIT_EVENT_LAST_FIRED_TIME_KEY = "init_event_last_fired_time_key";

    @NotNull
    public static final String INSTALL_ID_KEY = "install_id_key";

    @NotNull
    public static final String ONE_ID_STORAGE_KEY = "OneIDTracker";

    @Inject
    public ConfigHandler configHandler;

    @Inject
    public Connectivity conn;

    @Inject
    public EventQueue eventQueue;

    @Inject
    public GuestHandler guestHandler;

    @Inject
    public Logger logger;

    @Inject
    public MigrationHandler migrationHandler;
    private String mobileInstallId;
    private String mobileLaunchID;
    private String reportingContext;
    private String reportingSource;
    private String reportingValueBase64;
    private String reportingValueString;

    @Inject
    public SCALPConfigHandler scalpConfigHandler;
    private SharedPreferences sharedPrefs;

    @Inject
    public SWID swid;
    private Map trackerEventMap;
    private static final String TAG = OneIDTracker.class.getSimpleName();

    public OneIDTracker(@NotNull Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.trackerEventMap = new ConcurrentHashMap();
        OneIDDagger.getComponent().inject(this);
        SharedPreferences sharedPreferences = appContext.getSharedPreferences(ONE_ID_STORAGE_KEY, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPrefs = sharedPreferences;
        MigrationInfo migrationInfoMigrate = getMigrationHandler$OneID_release().migrate();
        this.mobileLaunchID = UUID.randomUUID().toString();
        checkIfFirstInstallAndTrack();
        String info = migrationInfoMigrate.getInfo();
        if (info != null) {
            Tracker.DefaultImpls.trackInstantEvent$default(this, null, false, EventAction.LOG_MIGRATE, getSwid$OneID_release().get(), migrationInfoMigrate.getCategory(), migrationInfoMigrate.getCodes(), info, null, migrationInfoMigrate.getProblem(), 131, null);
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
    public final EventQueue getEventQueue$OneID_release() {
        EventQueue eventQueue = this.eventQueue;
        if (eventQueue != null) {
            return eventQueue;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventQueue");
        return null;
    }

    public final void setEventQueue$OneID_release(@NotNull EventQueue eventQueue) {
        Intrinsics.checkNotNullParameter(eventQueue, "<set-?>");
        this.eventQueue = eventQueue;
    }

    @NotNull
    public final MigrationHandler getMigrationHandler$OneID_release() {
        MigrationHandler migrationHandler = this.migrationHandler;
        if (migrationHandler != null) {
            return migrationHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("migrationHandler");
        return null;
    }

    public final void setMigrationHandler$OneID_release(@NotNull MigrationHandler migrationHandler) {
        Intrinsics.checkNotNullParameter(migrationHandler, "<set-?>");
        this.migrationHandler = migrationHandler;
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

    @NotNull
    public final Connectivity getConn$OneID_release() {
        Connectivity connectivity = this.conn;
        if (connectivity != null) {
            return connectivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("conn");
        return null;
    }

    public final void setConn$OneID_release(@NotNull Connectivity connectivity) {
        Intrinsics.checkNotNullParameter(connectivity, "<set-?>");
        this.conn = connectivity;
    }

    @NotNull
    public final Map<TrackerEventKey, OneIDTrackerEvent> getTrackerEventMap$OneID_release() {
        return this.trackerEventMap;
    }

    public final void setTrackerEventMap$OneID_release(@NotNull Map<TrackerEventKey, OneIDTrackerEvent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.trackerEventMap = map;
    }

    @Nullable
    /* renamed from: getReportingValueString$OneID_release, reason: from getter */
    public final String getReportingValueString() {
        return this.reportingValueString;
    }

    public final void setReportingValueString$OneID_release(@Nullable String str) {
        this.reportingValueString = str;
    }

    @Nullable
    /* renamed from: getReportingSource$OneID_release, reason: from getter */
    public final String getReportingSource() {
        return this.reportingSource;
    }

    public final void setReportingSource$OneID_release(@Nullable String str) {
        this.reportingSource = str;
    }

    @Nullable
    /* renamed from: getReportingContext$OneID_release, reason: from getter */
    public final String getReportingContext() {
        return this.reportingContext;
    }

    public final void setReportingContext$OneID_release(@Nullable String str) {
        this.reportingContext = str;
    }

    private final void checkIfFirstInstallAndTrack() {
        String str = null;
        String string = this.sharedPrefs.getString(INSTALL_ID_KEY, null);
        if (string != null) {
            this.mobileInstallId = string;
            return;
        }
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        this.mobileInstallId = string2;
        SharedPreferences.Editor editorEdit = this.sharedPrefs.edit();
        String str2 = this.mobileInstallId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileInstallId");
        } else {
            str = str2;
        }
        editorEdit.putString(INSTALL_ID_KEY, str);
        editorEdit.apply();
        Tracker.DefaultImpls.trackInstantEvent$default(this, null, false, EventAction.LOG_INSTALL, getSwid$OneID_release().get(), null, null, null, null, false, 499, null);
    }

    @Override // com.disney.id.android.tracker.Tracker
    public void launchCheck(@Nullable String uiVersion) {
        long j = this.sharedPrefs.getLong(INIT_EVENT_LAST_FIRED_TIME_KEY, -1L);
        String externalRefreshToken = getGuestHandler$OneID_release().getExternalRefreshToken();
        if (j < 0 || 86400000 < System.currentTimeMillis() - j || externalRefreshToken != null) {
            Tracker.DefaultImpls.trackInstantEvent$default(this, null, false, EventAction.API_INIT, getSwid$OneID_release().get(), null, null, buildLaunchTrackerInfoColumn(uiVersion, externalRefreshToken), null, false, 435, null);
            this.sharedPrefs.edit().putLong(INIT_EVENT_LAST_FIRED_TIME_KEY, System.currentTimeMillis()).apply();
        }
    }

    private final String buildLaunchTrackerInfoColumn(String uiVersion, String externalRefreshToken) {
        String str;
        if (uiVersion != null) {
            str = "forced(" + uiVersion + ")";
        } else {
            str = null;
        }
        return (externalRefreshToken == null || str != null) ? str : "externalsession(true)";
    }

    @Override // com.disney.id.android.tracker.Tracker
    public void setLightboxVersion(@Nullable String version) {
        if (version != null) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = version.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                EventQueue eventQueue$OneID_release = getEventQueue$OneID_release();
                if (StringsKt.startsWith$default((CharSequence) lowerCase, 'v', false, 2, (Object) null)) {
                    lowerCase = StringsKt.drop(lowerCase, 1);
                }
                eventQueue$OneID_release.addToBaseParameters(OneIDTrackerEvent.EVENT_PARAM_LIGHTBOX_VERSION, lowerCase);
            }
        }
    }

    @Override // com.disney.id.android.tracker.Tracker
    public void setBrowser(@Nullable String browser) {
        if (browser != null) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.i$default(logger$OneID_release, TAG2, "WebView User Agent: " + browser, null, 4, null);
            getEventQueue$OneID_release().addToBaseParameters(OneIDTrackerEvent.EVENT_PARAM_BROWSER, browser);
        }
    }

    private final void addInitialEventData(OneIDTrackerEvent event) {
        String upperCase;
        long jCurrentTimeMillis = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - event.getInitialElapsedTimeInMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (!event.getCurrentStateParam$OneID_release().containsKey("timestamp")) {
            String str = simpleDateFormat.format(new Date(jCurrentTimeMillis));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            event.setParameter$OneID_release("timestamp", str);
        }
        if (!event.getCurrentStateParam$OneID_release().containsKey(OneIDTrackerEvent.EVENT_PARAM_DEVICE_TIMESTAMP)) {
            event.setParameter$OneID_release(OneIDTrackerEvent.EVENT_PARAM_DEVICE_TIMESTAMP, String.valueOf(jCurrentTimeMillis));
        }
        if (!event.getCurrentStateParam$OneID_release().containsKey(OneIDTrackerEvent.EVENT_PARAM_CONNECTION_TYPE)) {
            event.setParameter$OneID_release(OneIDTrackerEvent.EVENT_PARAM_CONNECTION_TYPE, getConn$OneID_release().networkType());
        }
        Config config = getConfigHandler$OneID_release().get();
        if (OneID.Environment.STG == config.getEnvironment()) {
            upperCase = "STAGE";
        } else {
            String string = config.getEnvironment().toString();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            upperCase = string.toUpperCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        }
        String detectedCountry = getScalpConfigHandler$OneID_release().getDetectedCountry();
        if (detectedCountry != null) {
            event.setParameter$OneID_release(OneIDTrackerEvent.EVENT_PARAM_DETECTED_COUNTRY, detectedCountry);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("%s-%s", Arrays.copyOf(new Object[]{config.getClientId(), upperCase}, 2));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        event.setParameter$OneID_release(OneIDTrackerEvent.EVENT_PARAM_CLIENT_ID, str2);
        String str3 = this.mobileInstallId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileInstallId");
            str3 = null;
        }
        event.setParameter$OneID_release(OneIDTrackerEvent.EVENT_PARAM_SDK_INSTALL_UUID, str3);
        String str4 = this.mobileLaunchID;
        if (str4 != null) {
            event.setParameter$OneID_release(OneIDTrackerEvent.EVENT_PARAM_MOBILE_LAUNCH_ID, str4);
        }
    }

    @Override // com.disney.id.android.tracker.Tracker
    public void trackInstantEvent(@Nullable String conversationId, boolean addTransactionId, @NotNull EventAction action, @NotNull String swid, @Nullable String category, @Nullable String codes, @Nullable String info, @Nullable OptionalConfigs config, boolean problem) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(swid, "swid");
        OneIDTrackerEvent oneIDTrackerEvent = new OneIDTrackerEvent(conversationId, addTransactionId, action, swid, info, problem);
        addInitialEventData(oneIDTrackerEvent);
        addReportingEventData$OneID_release(oneIDTrackerEvent, config);
        OneIDTrackerEvent.appendCodes$OneID_release$default(oneIDTrackerEvent, codes, category, null, 4, null);
        finalizeEventAndSend$default(this, oneIDTrackerEvent, false, 2, null);
    }

    @Override // com.disney.id.android.tracker.Tracker
    @NotNull
    public TrackerEventKey startConversationEvent(@Nullable String conversationId, @NotNull EventAction action, @NotNull String swid, @Nullable String info, @Nullable OptionalConfigs config) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(swid, "swid");
        OneIDTrackerEvent oneIDTrackerEvent = new OneIDTrackerEvent(conversationId, false, action, swid, info, false, 32, null);
        addInitialEventData(oneIDTrackerEvent);
        addReportingEventData$OneID_release(oneIDTrackerEvent, config);
        TrackerEventKey key$OneID_release = oneIDTrackerEvent.getKey$OneID_release();
        this.trackerEventMap.put(key$OneID_release, oneIDTrackerEvent);
        return key$OneID_release;
    }

    @Override // com.disney.id.android.tracker.Tracker
    @NotNull
    public TrackerEventKey startTransactionEvent(@Nullable String conversationId, @NotNull EventAction action, @NotNull String swid, @Nullable String info, @Nullable OptionalConfigs config) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(swid, "swid");
        OneIDTrackerEvent oneIDTrackerEvent = new OneIDTrackerEvent(conversationId, true, action, swid, info, false, 32, null);
        addInitialEventData(oneIDTrackerEvent);
        addReportingEventData$OneID_release(oneIDTrackerEvent, config);
        TrackerEventKey key$OneID_release = oneIDTrackerEvent.getKey$OneID_release();
        this.trackerEventMap.put(key$OneID_release, oneIDTrackerEvent);
        return key$OneID_release;
    }

    @Override // com.disney.id.android.tracker.Tracker
    public void finishEvent(@NotNull TrackerEventKey trackerEventKey, boolean problem, @Nullable String codes, @Nullable String category, @Nullable String info, boolean disableThrottling) {
        Token token$OneID_release;
        Intrinsics.checkNotNullParameter(trackerEventKey, "trackerEventKey");
        OneIDTrackerEvent oneIDTrackerEvent = (OneIDTrackerEvent) this.trackerEventMap.get(trackerEventKey);
        if (oneIDTrackerEvent == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - oneIDTrackerEvent.getInitialElapsedTimeInMillis();
        oneIDTrackerEvent.appendCodes$OneID_release(codes, category, info);
        Guest guest = getGuestHandler$OneID_release().get();
        oneIDTrackerEvent.setIdToken$OneID_release((guest == null || (token$OneID_release = guest.getToken$OneID_release()) == null) ? null : token$OneID_release.getIdToken());
        oneIDTrackerEvent.getCurrentStateParam$OneID_release().put(OneIDTrackerEvent.EVENT_PARAM_PROBLEM, String.valueOf(problem));
        oneIDTrackerEvent.getCurrentStateParam$OneID_release().put(OneIDTrackerEvent.EVENT_PARAM_PROCESS_TIME, String.valueOf(jElapsedRealtime));
        if (disableThrottling || problem) {
            oneIDTrackerEvent.setThrottleLevel$OneID_release("overridden (was " + oneIDTrackerEvent.getThrottleLevel$OneID_release() + ")");
        }
        finalizeEventAndSend(oneIDTrackerEvent, disableThrottling);
    }

    @Override // com.disney.id.android.tracker.Tracker
    public void trackWebEvent(@NotNull Map<String, ? extends Object> webEvent) {
        String string;
        Intrinsics.checkNotNullParameter(webEvent, "webEvent");
        if (webEvent.isEmpty()) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, "Dropping empty log event from web", null, 4, null);
            return;
        }
        Object obj = webEvent.get(OneIDTrackerEvent.EVENT_PARAM_ACTION_NAME);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        if (StringsKt.isBlank(str)) {
            Logger logger$OneID_release2 = getLogger$OneID_release();
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Logger.DefaultImpls.wtf$default(logger$OneID_release2, TAG3, "Dropping log event from web with no action name", null, 4, null);
            return;
        }
        String str2 = (String) webEvent.get(OneIDTrackerEvent.EVENT_PARAM_CONVERSATION_ID);
        String str3 = str2 != null ? str2 : "";
        if (!StringsKt.isBlank(str3)) {
            OneIDTrackerEvent oneIDTrackerEvent = (OneIDTrackerEvent) this.trackerEventMap.get(new TrackerEventKey(str3, str));
            if (oneIDTrackerEvent != null) {
                oneIDTrackerEvent.appendCodes$OneID_release((String) webEvent.get(OneIDTrackerEvent.EVENT_PARAM_ERROR_CODES), (String) webEvent.get(OneIDTrackerEvent.EVENT_PARAM_ERROR_CATEGORY), (String) webEvent.get(OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO));
                Object obj2 = webEvent.get(OneIDTrackerEvent.EVENT_PARAM_PROCESS_TIME);
                double d = (obj2 == null || (string = obj2.toString()) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : Double.parseDouble(string);
                String str4 = oneIDTrackerEvent.getCurrentStateParam$OneID_release().get(OneIDTrackerEvent.EVENT_PARAM_PROCESS_TIME);
                oneIDTrackerEvent.getCurrentStateParam$OneID_release().put(OneIDTrackerEvent.EVENT_PARAM_PROCESS_TIME, String.valueOf((str4 != null ? Long.parseLong(str4) : 0L) + ((long) d)));
                if (webEvent.containsKey("success")) {
                    oneIDTrackerEvent.getCurrentStateParam$OneID_release().put("success", String.valueOf(Boolean.parseBoolean(String.valueOf(webEvent.get("success")))));
                }
                for (Map.Entry<String, ? extends Object> entry : webEvent.entrySet()) {
                    if (!Intrinsics.areEqual("transaction_id", entry.getKey())) {
                        Map<String, String> currentStateParam$OneID_release = oneIDTrackerEvent.getCurrentStateParam$OneID_release();
                        if (!currentStateParam$OneID_release.containsKey(entry.getKey()) || Intrinsics.areEqual(entry.getKey(), OneIDTrackerEvent.EVENT_PARAM_DEVICE_TIMESTAMP)) {
                            Object value = entry.getValue();
                            if (value != null) {
                                String string2 = value.toString();
                                if (!StringsKt.isBlank(string2)) {
                                    currentStateParam$OneID_release.put(entry.getKey(), string2);
                                }
                            }
                        }
                    }
                }
            } else {
                oneIDTrackerEvent = new OneIDTrackerEvent(webEvent);
                addInitialEventData(oneIDTrackerEvent);
                String str5 = oneIDTrackerEvent.getCurrentStateParam$OneID_release().get(OneIDTrackerEvent.EVENT_PARAM_ANON);
                if (str5 != null ? Boolean.parseBoolean(str5) : false) {
                    oneIDTrackerEvent.getCurrentStateParam$OneID_release().put("swid", getSwid$OneID_release().get());
                }
            }
            finalizeEventAndSend$default(this, oneIDTrackerEvent, false, 2, null);
            return;
        }
        Logger logger$OneID_release3 = getLogger$OneID_release();
        String TAG4 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
        Logger.DefaultImpls.wtf$default(logger$OneID_release3, TAG4, "Dropping log event from web with no event ID's", null, 4, null);
    }

    @Override // com.disney.id.android.tracker.Tracker
    @Nullable
    public OneIDTrackerEvent getEvent(@Nullable TrackerEventKey trackerEventKey) {
        if (trackerEventKey != null) {
            return (OneIDTrackerEvent) this.trackerEventMap.get(trackerEventKey);
        }
        return null;
    }

    @Override // com.disney.id.android.tracker.Tracker
    @Nullable
    public TrackerEventKey getEventFromConversationIdAndEventType(@NotNull String conversationId, @NotNull String actionName) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Map map = this.trackerEventMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            OneIDTrackerEvent oneIDTrackerEvent = (OneIDTrackerEvent) entry.getValue();
            if (Intrinsics.areEqual(oneIDTrackerEvent.getConversationId$OneID_release(), conversationId) && StringsKt.contains$default((CharSequence) oneIDTrackerEvent.getKey$OneID_release().getActionName(), (CharSequence) actionName, false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return (TrackerEventKey) CollectionsKt.firstOrNull(linkedHashMap.keySet());
    }

    @Override // com.disney.id.android.tracker.Tracker
    @Nullable
    public TrackerEventKey getEventFromEventType(@NotNull String actionName) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Map map = this.trackerEventMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (StringsKt.startsWith$default(((OneIDTrackerEvent) entry.getValue()).getKey$OneID_release().getActionName(), actionName, false, 2, (Object) null)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return (TrackerEventKey) CollectionsKt.firstOrNull(linkedHashMap.keySet());
    }

    private final void lastChanceDataChecks(OneIDTrackerEvent event) {
        Token token$OneID_release;
        String detectedCountry;
        if (event.getDetectedCountry$OneID_release() == null && (detectedCountry = getScalpConfigHandler$OneID_release().getDetectedCountry()) != null) {
            event.setParameter$OneID_release(OneIDTrackerEvent.EVENT_PARAM_DETECTED_COUNTRY, detectedCountry);
        }
        if (event.getIdToken$OneID_release() == null) {
            Guest guest = getGuestHandler$OneID_release().get();
            event.setIdToken$OneID_release((guest == null || (token$OneID_release = guest.getToken$OneID_release()) == null) ? null : token$OneID_release.getIdToken());
        }
    }

    static /* synthetic */ void finalizeEventAndSend$default(OneIDTracker oneIDTracker, OneIDTrackerEvent oneIDTrackerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        oneIDTracker.finalizeEventAndSend(oneIDTrackerEvent, z);
    }

    private final void finalizeEventAndSend(OneIDTrackerEvent event, boolean disableThrottling) {
        lastChanceDataChecks(event);
        if (event.getProblem$OneID_release() || event.getThrottle().getShouldNotThrottle() || disableThrottling) {
            getEventQueue$OneID_release().enqueue(event);
            removeProcessedTrackerEvent(event);
            removeStaleTrackerEvents$OneID_release();
            return;
        }
        Logger logger$OneID_release = getLogger$OneID_release();
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Logger.DefaultImpls.i$default(logger$OneID_release, TAG2, "**THROTTLED** " + ((Object) event.getCurrentStateParam$OneID_release().get(OneIDTrackerEvent.EVENT_PARAM_ACTION_NAME)), null, 4, null);
        removeProcessedTrackerEvent(event);
    }

    private final void removeProcessedTrackerEvent(OneIDTrackerEvent event) {
        this.trackerEventMap.remove(event.getKey$OneID_release());
    }

    public final void removeStaleTrackerEvents$OneID_release() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.trackerEventMap.entrySet().iterator();
        while (it.hasNext()) {
            OneIDTrackerEvent oneIDTrackerEvent = (OneIDTrackerEvent) ((Map.Entry) it.next()).getValue();
            long initialElapsedTimeInMillis = jElapsedRealtime - oneIDTrackerEvent.getInitialElapsedTimeInMillis();
            if (initialElapsedTimeInMillis > 60000) {
                oneIDTrackerEvent.getCurrentStateParam$OneID_release().put(OneIDTrackerEvent.EVENT_PARAM_PROCESS_TIME, String.valueOf(initialElapsedTimeInMillis));
                OneIDTrackerEvent.appendCodes$OneID_release$default(oneIDTrackerEvent, OneIDTrackerEvent.ERROR_CODE_LOGGING_CONTEXT_FAILURE, "TIMED_OUT", null, 4, null);
                getEventQueue$OneID_release().enqueue(oneIDTrackerEvent);
                it.remove();
            }
        }
    }

    @Override // com.disney.id.android.tracker.Tracker
    public void setOptionalConfigData(@Nullable OptionalConfigs optionalConfig) {
        if (optionalConfig == null) {
            this.reportingValueBase64 = null;
            this.reportingValueString = null;
            this.reportingSource = null;
            this.reportingContext = null;
            return;
        }
        this.reportingValueBase64 = generateBase64ReportingValues(optionalConfig);
        this.reportingValueString = generateReportingValueString$OneID_release(optionalConfig);
        this.reportingSource = optionalConfig.getReportingSource();
        this.reportingContext = optionalConfig.getReportingContext();
    }

    public static /* synthetic */ void addReportingEventData$OneID_release$default(OneIDTracker oneIDTracker, OneIDTrackerEvent oneIDTrackerEvent, OptionalConfigs optionalConfigs, int i, Object obj) {
        if ((i & 2) != 0) {
            optionalConfigs = null;
        }
        oneIDTracker.addReportingEventData$OneID_release(oneIDTrackerEvent, optionalConfigs);
    }

    public final void addReportingEventData$OneID_release(@NotNull OneIDTrackerEvent trackerEvent, @Nullable OptionalConfigs optionalConfig) {
        Intrinsics.checkNotNullParameter(trackerEvent, "trackerEvent");
        if (optionalConfig != null) {
            trackerEvent.setReportBase64$OneID_release(generateBase64ReportingValues(optionalConfig));
            trackerEvent.setReportingData$OneID_release(generateReportingValueString$OneID_release(optionalConfig));
            trackerEvent.setReportingSource$OneID_release(optionalConfig.getReportingSource());
            trackerEvent.setReportingContext$OneID_release(optionalConfig.getReportingContext());
            return;
        }
        trackerEvent.setReportBase64$OneID_release(this.reportingValueBase64);
        trackerEvent.setReportingData$OneID_release(this.reportingValueString);
        trackerEvent.setReportingSource$OneID_release(this.reportingSource);
        trackerEvent.setReportingContext$OneID_release(this.reportingContext);
    }

    private final String generateBase64ReportingValues(OptionalConfigs config) throws JSONException {
        JSONObject reportingValuesJson$OneID_release = config.getReportingValuesJson$OneID_release();
        if (reportingValuesJson$OneID_release.length() <= 0) {
            return null;
        }
        String string = reportingValuesJson$OneID_release.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return Base64.encodeToString(bytes, 2);
    }

    @NotNull
    public final String generateReportingValueString$OneID_release(@NotNull OptionalConfigs optionalConfig) {
        Intrinsics.checkNotNullParameter(optionalConfig, "optionalConfig");
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : optionalConfig.getReportingValues().entrySet()) {
            String key = entry.getKey();
            if (!Intrinsics.areEqual(key, "source") && !Intrinsics.areEqual(key, "context")) {
                sb.append(entry.getKey());
                sb.append("(");
                sb.append(entry.getValue());
                sb.append("),");
            }
        }
        return StringsKt.removeSuffix(sb, ",").toString();
    }
}
