package com.urbanairship.liveupdate;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipComponent;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UAirship;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.AirshipChannelListener;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.json.JsonMap;
import com.urbanairship.liveupdate.data.LiveUpdateDatabase;
import com.urbanairship.liveupdate.notification.LiveUpdatePayload;
import com.urbanairship.push.PushListener;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00013B7\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eBK\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0006\u0010\u001c\u001a\u00020\u0018J7\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0087@¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020)H\u0017J\b\u0010*\u001a\u00020\u0018H\u0017J\u0016\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.J;\u0010/\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u00100J3\u00101\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0007¢\u0006\u0002\u0010#J\b\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateManager;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/channel/AirshipChannel;", "pushManager", "Lcom/urbanairship/push/PushManager;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/push/PushManager;)V", "db", "Lcom/urbanairship/liveupdate/data/LiveUpdateDatabase;", "registrar", "Lcom/urbanairship/liveupdate/LiveUpdateRegistrar;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/push/PushManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/liveupdate/data/LiveUpdateDatabase;Lcom/urbanairship/liveupdate/LiveUpdateRegistrar;)V", "isFeatureEnabled", "", "()Z", "cancel", "", "name", "", "cancel$urbanairship_live_update_release", "clearAll", ViewProps.END, "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", "dismissTimestamp", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;)V", "getAllActiveUpdates", "", "Lcom/urbanairship/liveupdate/LiveUpdate;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComponentGroup", "", "init", "register", "type", "handler", "Lcom/urbanairship/liveupdate/LiveUpdateHandler;", ViewProps.START, "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;JLjava/lang/Long;)V", "update", "updateLiveActivityEnablement", "Companion", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateManager.kt\ncom/urbanairship/liveupdate/LiveUpdateManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,194:1\n1#2:195\n*E\n"})
/* loaded from: classes5.dex */
public final class LiveUpdateManager extends AirshipComponent {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final AirshipChannel channel;
    private final PrivacyManager privacyManager;
    private final PushManager pushManager;
    private final LiveUpdateRegistrar registrar;

    @JvmStatic
    @NotNull
    public static final LiveUpdateManager shared() {
        return INSTANCE.shared();
    }

    @JvmOverloads
    public final void end(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        end$default(this, name, null, 0L, null, 14, null);
    }

    @JvmOverloads
    public final void end(@NotNull String name, @Nullable JsonMap jsonMap) {
        Intrinsics.checkNotNullParameter(name, "name");
        end$default(this, name, jsonMap, 0L, null, 12, null);
    }

    @JvmOverloads
    public final void end(@NotNull String name, @Nullable JsonMap jsonMap, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        end$default(this, name, jsonMap, j, null, 8, null);
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 11;
    }

    @JvmOverloads
    public final void start(@NotNull String name, @NotNull String type, @NotNull JsonMap content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        start$default(this, name, type, content, 0L, null, 24, null);
    }

    @JvmOverloads
    public final void start(@NotNull String name, @NotNull String type, @NotNull JsonMap content, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        start$default(this, name, type, content, j, null, 16, null);
    }

    @JvmOverloads
    public final void update(@NotNull String name, @NotNull JsonMap content) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        update$default(this, name, content, 0L, null, 12, null);
    }

    @JvmOverloads
    public final void update(@NotNull String name, @NotNull JsonMap content, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        update$default(this, name, content, j, null, 8, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LiveUpdateManager(Context context, PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig airshipRuntimeConfig, PrivacyManager privacyManager, PushManager pushManager, AirshipChannel airshipChannel, LiveUpdateDatabase liveUpdateDatabase, LiveUpdateRegistrar liveUpdateRegistrar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        LiveUpdateDatabase liveUpdateDatabaseCreateDatabase = (i & 64) != 0 ? LiveUpdateDatabase.INSTANCE.createDatabase(context, airshipRuntimeConfig) : liveUpdateDatabase;
        this(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, pushManager, airshipChannel, liveUpdateDatabaseCreateDatabase, (i & 128) != 0 ? new LiveUpdateRegistrar(context, airshipChannel, liveUpdateDatabaseCreateDatabase.liveUpdateDao(), null, null, null, null, SyslogConstants.LOG_CLOCK, null) : liveUpdateRegistrar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public LiveUpdateManager(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull PushManager pushManager, @NotNull AirshipChannel channel, @NotNull LiveUpdateDatabase db, @NotNull LiveUpdateRegistrar registrar) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(registrar, "registrar");
        this.privacyManager = privacyManager;
        this.pushManager = pushManager;
        this.channel = channel;
        this.registrar = registrar;
    }

    private final boolean isFeatureEnabled() {
        return this.privacyManager.isEnabled(PrivacyManager.Feature.PUSH);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveUpdateManager(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel channel, @NotNull PushManager pushManager) {
        this(context, dataStore, config, privacyManager, pushManager, channel, null, null, 192, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
    }

    public final void register(@NotNull String type, @NotNull LiveUpdateHandler handler) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.registrar.register(type, handler);
    }

    public static /* synthetic */ void start$default(LiveUpdateManager liveUpdateManager, String str, String str2, JsonMap jsonMap, long j, Long l, int i, Object obj) {
        if ((i & 8) != 0) {
            j = System.currentTimeMillis();
        }
        long j2 = j;
        if ((i & 16) != 0) {
            l = null;
        }
        liveUpdateManager.start(str, str2, jsonMap, j2, l);
    }

    @JvmOverloads
    public final void start(@NotNull String name, @NotNull String type, @NotNull JsonMap content, long timestamp, @Nullable Long dismissTimestamp) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        if (isFeatureEnabled()) {
            this.registrar.start(name, type, content, timestamp, dismissTimestamp, (32 & 32) != 0 ? null : null);
        }
    }

    public static /* synthetic */ void update$default(LiveUpdateManager liveUpdateManager, String str, JsonMap jsonMap, long j, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        long j2 = j;
        if ((i & 8) != 0) {
            l = null;
        }
        liveUpdateManager.update(str, jsonMap, j2, l);
    }

    @JvmOverloads
    public final void update(@NotNull String name, @NotNull JsonMap content, long timestamp, @Nullable Long dismissTimestamp) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        if (isFeatureEnabled()) {
            LiveUpdateRegistrar.update$default(this.registrar, name, content, timestamp, dismissTimestamp, null, 16, null);
        }
    }

    public static /* synthetic */ void end$default(LiveUpdateManager liveUpdateManager, String str, JsonMap jsonMap, long j, Long l, int i, Object obj) {
        JsonMap jsonMap2 = (i & 2) != 0 ? null : jsonMap;
        if ((i & 4) != 0) {
            j = System.currentTimeMillis();
        }
        liveUpdateManager.end(str, jsonMap2, j, (i & 8) != 0 ? null : l);
    }

    @JvmOverloads
    public final void end(@NotNull String name, @Nullable JsonMap content, long timestamp, @Nullable Long dismissTimestamp) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (isFeatureEnabled()) {
            LiveUpdateRegistrar.stop$default(this.registrar, name, content, timestamp, dismissTimestamp, null, 16, null);
        }
    }

    public final void clearAll() {
        if (isFeatureEnabled()) {
            LiveUpdateRegistrar.clearAll$default(this.registrar, 0L, 1, null);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final Object getAllActiveUpdates(@NotNull Continuation<? super List<LiveUpdate>> continuation) {
        return this.registrar.getAllActiveUpdates(continuation);
    }

    public final void cancel$urbanairship_live_update_release(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        LiveUpdateRegistrar.cancel$default(this.registrar, name, 0L, 2, null);
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void init() {
        super.init();
        this.channel.addChannelListener(new AirshipChannelListener() { // from class: com.urbanairship.liveupdate.LiveUpdateManager$$ExternalSyntheticLambda0
            @Override // com.urbanairship.channel.AirshipChannelListener
            public final void onChannelCreated(String str) {
                LiveUpdateManager.init$lambda$0(this.f$0, str);
            }
        });
        this.privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.liveupdate.LiveUpdateManager.init.2
            @Override // com.urbanairship.PrivacyManager.Listener
            public void onEnabledFeaturesChanged() {
                LiveUpdateManager.this.updateLiveActivityEnablement();
            }
        });
        this.pushManager.addPushListener(new PushListener() { // from class: com.urbanairship.liveupdate.LiveUpdateManager$$ExternalSyntheticLambda1
            @Override // com.urbanairship.push.PushListener
            public final void onPushReceived(PushMessage pushMessage, boolean z) {
                LiveUpdateManager.init$lambda$3(this.f$0, pushMessage, z);
            }
        });
        updateLiveActivityEnablement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(LiveUpdateManager this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.updateLiveActivityEnablement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3(LiveUpdateManager this$0, PushMessage message, boolean z) {
        LiveUpdatePayload liveUpdatePayloadFromJson$urbanairship_live_update_release;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        String liveUpdatePayload = message.getLiveUpdatePayload();
        if (liveUpdatePayload == null || (liveUpdatePayloadFromJson$urbanairship_live_update_release = LiveUpdatePayload.INSTANCE.fromJson$urbanairship_live_update_release(liveUpdatePayload)) == null) {
            return;
        }
        this$0.registrar.onLiveUpdatePushReceived(message, liveUpdatePayloadFromJson$urbanairship_live_update_release);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLiveActivityEnablement() {
        if (isFeatureEnabled()) {
            this.registrar.stopLiveUpdatesForClearedNotifications();
        } else {
            LiveUpdateRegistrar.clearAll$default(this.registrar, 0L, 1, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/liveupdate/LiveUpdateManager$Companion;", "", "()V", "shared", "Lcom/urbanairship/liveupdate/LiveUpdateManager;", "urbanairship-live-update_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final LiveUpdateManager shared() {
            AirshipComponent airshipComponentRequireComponent = UAirship.shared().requireComponent(LiveUpdateManager.class);
            Intrinsics.checkNotNullExpressionValue(airshipComponentRequireComponent, "requireComponent(...)");
            return (LiveUpdateManager) airshipComponentRequireComponent;
        }
    }
}
