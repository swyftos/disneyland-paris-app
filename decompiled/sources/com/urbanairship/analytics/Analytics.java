package com.urbanairship.analytics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.utils.UriBuilder;
import com.disney.id.android.OneIDRecoveryContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipExecutors;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.AirshipEventFeed;
import com.urbanairship.analytics.AssociatedIdentifiers;
import com.urbanairship.analytics.data.EventManager;
import com.urbanairship.analytics.location.RegionEvent;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.AirshipChannelListener;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.locale.LocaleManager;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionStatus;
import com.urbanairship.permission.PermissionsManager;
import com.urbanairship.util.Clock;
import com.urbanairship.util.UAStringUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 {2\u00020\u0001:\u0002z{BG\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bi\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\u0010\u0010Z\u001a\u00020A2\u0006\u0010[\u001a\u00020\\H\u0007J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020?H\u0007J\b\u0010`\u001a\u00020^H\u0002J\u0006\u0010a\u001a\u00020bJ\b\u0010c\u001a\u00020dH\u0017J\u0010\u0010e\u001a\u00020^2\u0006\u0010f\u001a\u00020SH\u0002J\u0010\u0010g\u001a\u00020^2\u0006\u0010f\u001a\u00020SH\u0002J\u0018\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020mH\u0017J\u000e\u0010n\u001a\u00020^2\u0006\u0010[\u001a\u00020oJ\u000e\u0010p\u001a\u00020^2\u0006\u0010[\u001a\u00020qJ\u0016\u0010r\u001a\u00020^2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u001fJ\b\u0010v\u001a\u00020^H\u0014J\u0012\u0010w\u001a\u00020^2\b\u0010x\u001a\u0004\u0018\u00010\u001fH\u0007J\u0006\u0010y\u001a\u00020^R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u001f0&8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u00100\u001a\u0004\u0018\u00010\u001f2\b\u0010/\u001a\u0004\u0018\u00010\u001f8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00106\u001a\u0004\u0018\u00010\u001f2\b\u00105\u001a\u0004\u0018\u00010\u001f@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\"0:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010@\u001a\u00020A8F¢\u0006\u0006\u001a\u0004\b@\u0010BR(\u0010D\u001a\u0004\u0018\u00010\u001f2\b\u0010C\u001a\u0004\u0018\u00010\u001f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u00102\"\u0004\bF\u00104R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u00102R\u0016\u0010K\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u00102R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$0O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0O¢\u0006\b\n\u0000\u001a\u0004\bU\u0010QR\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020\u001f0>X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010X\u001a\u00020\u001f2\u0006\u0010W\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u00102¨\u0006|"}, d2 = {"Lcom/urbanairship/analytics/Analytics;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/channel/AirshipChannel;", "localeManager", "Lcom/urbanairship/locale/LocaleManager;", "permissionsManager", "Lcom/urbanairship/permission/PermissionsManager;", "eventFeed", "Lcom/urbanairship/analytics/AirshipEventFeed;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/permission/PermissionsManager;Lcom/urbanairship/analytics/AirshipEventFeed;)V", "airshipChannel", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "executor", "Ljava/util/concurrent/Executor;", "eventManager", "Lcom/urbanairship/analytics/data/EventManager;", "clock", "Lcom/urbanairship/util/Clock;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/locale/LocaleManager;Ljava/util/concurrent/Executor;Lcom/urbanairship/analytics/data/EventManager;Lcom/urbanairship/permission/PermissionsManager;Lcom/urbanairship/analytics/AirshipEventFeed;Lcom/urbanairship/util/Clock;)V", "_currentScreen", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/analytics/AirshipEventData;", "_regions", "", "analyticHeaders", "", "getAnalyticHeaders", "()Ljava/util/Map;", "associatedIdentifiers", "Lcom/urbanairship/analytics/AssociatedIdentifiers;", "getAssociatedIdentifiers", "()Lcom/urbanairship/analytics/AssociatedIdentifiers;", "associatedIdentifiersLock", "", "metadata", "conversionMetadata", "getConversionMetadata", "()Ljava/lang/String;", "setConversionMetadata", "(Ljava/lang/String;)V", "sendId", "conversionSendId", "getConversionSendId", "setConversionSendId", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Lkotlinx/coroutines/flow/SharedFlow;", "getEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "headerDelegates", "", "Lcom/urbanairship/analytics/Analytics$AnalyticsHeaderDelegate;", "isEnabled", "", "()Z", "value", "lastReceivedMetadata", "getLastReceivedMetadata", "setLastReceivedMetadata", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/app/ApplicationListener;", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "getPackageName", "packageVersion", "getPackageVersion", "previousScreen", "regionState", "Lkotlinx/coroutines/flow/StateFlow;", "getRegionState", "()Lkotlinx/coroutines/flow/StateFlow;", "screenStartTime", "", "screenState", "getScreenState", "sdkExtensions", "<set-?>", OneIDRecoveryContext.SESSION_ID, "getSessionId", "addEvent", "event", "Lcom/urbanairship/analytics/Event;", "addHeaderDelegate", "", "headerDelegate", "clearPendingEvents", "editAssociatedIdentifiers", "Lcom/urbanairship/analytics/AssociatedIdentifiers$Editor;", "getComponentGroup", "", "onBackground", "timeMS", "onForeground", "onPerformJob", "Lcom/urbanairship/job/JobResult;", "airship", "Lcom/urbanairship/UAirship;", "jobInfo", "Lcom/urbanairship/job/JobInfo;", "recordCustomEvent", "Lcom/urbanairship/analytics/CustomEvent;", "recordRegionEvent", "Lcom/urbanairship/analytics/location/RegionEvent;", "registerSDKExtension", "extension", "Lcom/urbanairship/analytics/Extension;", "version", "tearDown", "trackScreen", TCEventPropertiesNames.TCD_SCREEN, "uploadEvents", "AnalyticsHeaderDelegate", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnalytics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Analytics.kt\ncom/urbanairship/analytics/Analytics\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,624:1\n230#2,3:625\n233#2,2:629\n230#2,5:631\n1#3:628\n*S KotlinDebug\n*F\n+ 1 Analytics.kt\ncom/urbanairship/analytics/Analytics\n*L\n297#1:625,3\n297#1:629,2\n303#1:631,5\n*E\n"})
/* loaded from: classes4.dex */
public final class Analytics extends AirshipComponent {
    private MutableStateFlow _currentScreen;
    private final MutableSharedFlow _events;
    private MutableStateFlow _regions;
    private final ActivityMonitor activityMonitor;
    private final AirshipChannel airshipChannel;
    private final Object associatedIdentifiersLock;
    private final Clock clock;
    private String conversionMetadata;
    private String conversionSendId;
    private final AirshipEventFeed eventFeed;
    private final EventManager eventManager;
    private final SharedFlow events;
    private final Executor executor;
    private final List headerDelegates;
    private final ApplicationListener listener;
    private final LocaleManager localeManager;
    private final PermissionsManager permissionsManager;
    private String previousScreen;
    private final PrivacyManager privacyManager;
    private final StateFlow regionState;
    private final AirshipRuntimeConfig runtimeConfig;
    private long screenStartTime;
    private final StateFlow screenState;
    private final List sdkExtensions;
    private String sessionId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/urbanairship/analytics/Analytics$AnalyticsHeaderDelegate;", "", "onCreateAnalyticsHeaders", "", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface AnalyticsHeaderDelegate {
        @NotNull
        Map<String, String> onCreateAnalyticsHeaders();
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Analytics(Context context, PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig airshipRuntimeConfig, PrivacyManager privacyManager, AirshipChannel airshipChannel, ActivityMonitor activityMonitor, LocaleManager localeManager, Executor executor, EventManager eventManager, PermissionsManager permissionsManager, AirshipEventFeed airshipEventFeed, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        if ((i & 2048) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, airshipChannel, activityMonitor, localeManager, executor, eventManager, permissionsManager, airshipEventFeed, clock2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public Analytics(@NotNull Context context, @NotNull final PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel airshipChannel, @NotNull ActivityMonitor activityMonitor, @NotNull LocaleManager localeManager, @NotNull Executor executor, @NotNull EventManager eventManager, @NotNull PermissionsManager permissionsManager, @NotNull AirshipEventFeed eventFeed, @NotNull Clock clock) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(eventManager, "eventManager");
        Intrinsics.checkNotNullParameter(permissionsManager, "permissionsManager");
        Intrinsics.checkNotNullParameter(eventFeed, "eventFeed");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.runtimeConfig = runtimeConfig;
        this.privacyManager = privacyManager;
        this.airshipChannel = airshipChannel;
        this.activityMonitor = activityMonitor;
        this.localeManager = localeManager;
        this.executor = executor;
        this.eventManager = eventManager;
        this.permissionsManager = permissionsManager;
        this.eventFeed = eventFeed;
        this.clock = clock;
        MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        this._events = mutableSharedFlowMutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        ApplicationListener applicationListener = new ApplicationListener() { // from class: com.urbanairship.analytics.Analytics$listener$1
            @Override // com.urbanairship.app.ApplicationListener
            public void onForeground(long time) {
                this.this$0.onForeground(time);
            }

            @Override // com.urbanairship.app.ApplicationListener
            public void onBackground(long time) {
                this.this$0.onBackground(time);
            }
        };
        this.listener = applicationListener;
        this.headerDelegates = new CopyOnWriteArrayList();
        this.associatedIdentifiersLock = new Object();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.sessionId = string;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._currentScreen = MutableStateFlow;
        this.screenState = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(SetsKt.emptySet());
        this._regions = MutableStateFlow2;
        this.regionState = FlowKt.asStateFlow(MutableStateFlow2);
        this.sdkExtensions = new ArrayList();
        activityMonitor.addApplicationListener(applicationListener);
        if (activityMonitor.getIsAppForegrounded()) {
            onForeground(clock.currentTimeMillis());
        }
        airshipChannel.addChannelListener(new AirshipChannelListener() { // from class: com.urbanairship.analytics.Analytics$$ExternalSyntheticLambda2
            @Override // com.urbanairship.channel.AirshipChannelListener
            public final void onChannelCreated(String str) {
                Analytics._init_$lambda$0(this.f$0, str);
            }
        });
        privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.analytics.Analytics.2
            @Override // com.urbanairship.PrivacyManager.Listener
            public void onEnabledFeaturesChanged() {
                if (Analytics.this.privacyManager.isEnabled(PrivacyManager.Feature.ANALYTICS)) {
                    return;
                }
                Analytics.this.clearPendingEvents();
                Object obj = Analytics.this.associatedIdentifiersLock;
                PreferenceDataStore preferenceDataStore = dataStore;
                synchronized (obj) {
                    preferenceDataStore.remove("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS");
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    @NotNull
    public final SharedFlow<AirshipEventData> getEvents() {
        return this.events;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    @Nullable
    public final String getConversionSendId() {
        return this.conversionSendId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setConversionSendId(@Nullable final String str) {
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics$conversionSendId$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Setting conversion send ID: " + str;
            }
        }, 1, null);
        this.conversionSendId = str;
    }

    @Nullable
    public final String getConversionMetadata() {
        return this.conversionMetadata;
    }

    public final void setConversionMetadata(@Nullable final String str) {
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics$conversionMetadata$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Setting conversion metadata: " + str;
            }
        }, 1, null);
        this.conversionMetadata = str;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public final String getLastReceivedMetadata() {
        return getDataStore().getString("com.urbanairship.push.LAST_RECEIVED_METADATA", null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setLastReceivedMetadata(@Nullable String str) {
        getDataStore().put("com.urbanairship.push.LAST_RECEIVED_METADATA", str);
    }

    @NotNull
    public final StateFlow<String> getScreenState() {
        return this.screenState;
    }

    @NotNull
    public final StateFlow<Set<String>> getRegionState() {
        return this.regionState;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Analytics(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel channel, @NotNull LocaleManager localeManager, @NotNull PermissionsManager permissionsManager, @NotNull AirshipEventFeed eventFeed) {
        this(context, dataStore, runtimeConfig, privacyManager, channel, GlobalActivityMonitor.INSTANCE.shared(context), localeManager, AirshipExecutors.newSerialExecutor(), new EventManager(context, dataStore, runtimeConfig), permissionsManager, eventFeed, null, 2048, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(permissionsManager, "permissionsManager");
        Intrinsics.checkNotNullParameter(eventFeed, "eventFeed");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void addHeaderDelegate(@NotNull AnalyticsHeaderDelegate headerDelegate) {
        Intrinsics.checkNotNullParameter(headerDelegate, "headerDelegate");
        this.headerDelegates.add(headerDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Analytics this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.uploadEvents();
    }

    @Override // com.urbanairship.AirshipComponent
    protected void tearDown() {
        this.activityMonitor.removeApplicationListener(this.listener);
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public JobResult onPerformJob(@NotNull UAirship airship, @NotNull JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        if (Intrinsics.areEqual(EventManager.ACTION_SEND, jobInfo.getAction())) {
            if (!isEnabled()) {
                return JobResult.SUCCESS;
            }
            String id = this.airshipChannel.getId();
            if (id == null) {
                UALog.d$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics.onPerformJob.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "No channel ID, skipping analytics send.";
                    }
                }, 1, null);
                return JobResult.SUCCESS;
            }
            if (!this.eventManager.uploadEvents(id, getAnalyticHeaders())) {
                return JobResult.RETRY;
            }
            return JobResult.SUCCESS;
        }
        return JobResult.SUCCESS;
    }

    public final void recordCustomEvent(@NotNull CustomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (addEvent(event)) {
            AirshipEventFeed airshipEventFeed = this.eventFeed;
            EventType type = event.getType();
            JsonValue jsonValue = event.getJsonValue();
            BigDecimal eventValue = event.getEventValue();
            airshipEventFeed.emit$urbanairship_core_release(new AirshipEventFeed.Event.Analytics(type, jsonValue, eventValue != null ? Double.valueOf(eventValue.doubleValue()) : null));
        }
    }

    public final void recordRegionEvent(@NotNull RegionEvent event) {
        Object value;
        Set mutableSet;
        Object value2;
        Set mutableSet2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (addEvent(event)) {
            int boundaryEvent = event.getBoundaryEvent();
            if (boundaryEvent != 1) {
                if (boundaryEvent != 2) {
                    return;
                }
                MutableStateFlow mutableStateFlow = this._regions;
                do {
                    value2 = mutableStateFlow.getValue();
                    mutableSet2 = CollectionsKt.toMutableSet((Set) value2);
                    mutableSet2.remove(event.getRegionId());
                } while (!mutableStateFlow.compareAndSet(value2, CollectionsKt.toSet(mutableSet2)));
                return;
            }
            MutableStateFlow mutableStateFlow2 = this._regions;
            do {
                value = mutableStateFlow2.getValue();
                mutableSet = CollectionsKt.toMutableSet((Set) value);
                String regionId = event.getRegionId();
                Intrinsics.checkNotNullExpressionValue(regionId, "getRegionId(...)");
                mutableSet.add(regionId);
            } while (!mutableStateFlow2.compareAndSet(value, CollectionsKt.toSet(mutableSet)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean addEvent(@NotNull final Event event) {
        AirshipEventFeed.Event.Analytics analytics;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!event.isValid()) {
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics.addEvent.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Analytics - Invalid event: " + event;
                }
            }, 1, null);
            return false;
        }
        if (!isEnabled()) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics.addEvent.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Disabled ignoring event: " + event.getType();
                }
            }, 1, null);
            return false;
        }
        ConversionData conversionData = new ConversionData(this.conversionSendId, this.conversionMetadata, getLastReceivedMetadata());
        String eventId = event.getEventId();
        Intrinsics.checkNotNullExpressionValue(eventId, "getEventId(...)");
        String str = this.sessionId;
        JsonValue jsonValue = event.getEventData(conversionData).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        EventType type = event.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        final AirshipEventData airshipEventData = new AirshipEventData(eventId, str, jsonValue, type, event.timeMilliseconds);
        if (event instanceof CustomEvent) {
            CustomEvent customEvent = (CustomEvent) event;
            EventType type2 = customEvent.getType();
            JsonValue jsonValue2 = customEvent.getJsonValue();
            BigDecimal eventValue = customEvent.getEventValue();
            analytics = new AirshipEventFeed.Event.Analytics(type2, jsonValue2, eventValue != null ? Double.valueOf(eventValue.doubleValue()) : null);
        } else {
            EventType type3 = event.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "getType(...)");
            analytics = new AirshipEventFeed.Event.Analytics(type3, airshipEventData.getBody(), null, 4, null);
        }
        this.eventFeed.emit$urbanairship_core_release(analytics);
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics.addEvent.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Adding event: " + event.getType();
            }
        }, 1, null);
        this.executor.execute(new Runnable() { // from class: com.urbanairship.analytics.Analytics$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Analytics.addEvent$lambda$5(this.f$0, airshipEventData, event);
            }
        });
        this._events.tryEmit(airshipEventData);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEvent$lambda$5(Analytics this$0, AirshipEventData eventData, Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eventData, "$eventData");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.eventManager.addEvent(eventData, event.getPriority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onForeground(long timeMS) {
        String str;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.sessionId = string;
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics.onForeground.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "New session: " + Analytics.this.getSessionId();
            }
        }, 1, null);
        if (this.screenState.getValue() == null && (str = this.previousScreen) != null) {
            trackScreen(str);
        }
        addEvent(new AppForegroundEvent(timeMS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackground(long timeMS) {
        trackScreen(null);
        addEvent(new AppBackgroundEvent(timeMS));
        setConversionSendId(null);
        setConversionMetadata(null);
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.ANALYTICS)) {
            this.eventManager.scheduleEventUpload(0L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPendingEvents() {
        this.executor.execute(new Runnable() { // from class: com.urbanairship.analytics.Analytics$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Analytics.clearPendingEvents$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearPendingEvents$lambda$6(Analytics this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UALog.i$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics$clearPendingEvents$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Deleting all analytic events.";
            }
        }, 1, null);
        this$0.eventManager.deleteEvents();
    }

    public final boolean isEnabled() {
        return this.runtimeConfig.getConfigOptions().analyticsEnabled && this.privacyManager.isEnabled(PrivacyManager.Feature.ANALYTICS);
    }

    @NotNull
    public final AssociatedIdentifiers.Editor editAssociatedIdentifiers() {
        return new AssociatedIdentifiers.Editor() { // from class: com.urbanairship.analytics.Analytics.editAssociatedIdentifiers.1
            @Override // com.urbanairship.analytics.AssociatedIdentifiers.Editor
            public void onApply(boolean clear, @NotNull Map<String, String> idsToAdd, @NotNull List<String> idsToRemove) {
                Intrinsics.checkNotNullParameter(idsToAdd, "idsToAdd");
                Intrinsics.checkNotNullParameter(idsToRemove, "idsToRemove");
                Object obj = Analytics.this.associatedIdentifiersLock;
                Analytics analytics = Analytics.this;
                synchronized (obj) {
                    if (!analytics.isEnabled()) {
                        UALog.w$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics$editAssociatedIdentifiers$1$onApply$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Analytics - Unable to track associated identifiers when analytics is disabled.";
                            }
                        }, 1, null);
                        return;
                    }
                    HashMap map = new HashMap();
                    AssociatedIdentifiers associatedIdentifiers = analytics.getAssociatedIdentifiers();
                    if (!clear) {
                        Map<String, String> ids = associatedIdentifiers.getIds();
                        Intrinsics.checkNotNullExpressionValue(ids, "getIds(...)");
                        map.putAll(ids);
                    }
                    map.putAll(idsToAdd);
                    Iterator<String> it = idsToRemove.iterator();
                    while (it.hasNext()) {
                        map.remove(it.next());
                    }
                    AssociatedIdentifiers associatedIdentifiers2 = new AssociatedIdentifiers(map);
                    if (!Intrinsics.areEqual(associatedIdentifiers.getIds(), associatedIdentifiers2.getIds())) {
                        analytics.getDataStore().put("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS", associatedIdentifiers2);
                        analytics.addEvent(new AssociateIdentifiersEvent(associatedIdentifiers2));
                    } else {
                        UALog.i$default(null, new Function0() { // from class: com.urbanairship.analytics.Analytics$editAssociatedIdentifiers$1$onApply$1$2
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Skipping analytics event addition for duplicate associated identifiers.";
                            }
                        }, 1, null);
                    }
                }
            }
        };
    }

    @NotNull
    public final AssociatedIdentifiers getAssociatedIdentifiers() {
        synchronized (this.associatedIdentifiersLock) {
            try {
                JsonValue jsonValue = getDataStore().getJsonValue("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS");
                Intrinsics.checkNotNullExpressionValue(jsonValue, "getJsonValue(...)");
                if (!jsonValue.isNull()) {
                    AssociatedIdentifiers associatedIdentifiersFromJson = AssociatedIdentifiers.fromJson(jsonValue);
                    Intrinsics.checkNotNullExpressionValue(associatedIdentifiersFromJson, "fromJson(...)");
                    return associatedIdentifiersFromJson;
                }
            } catch (JsonException e) {
                UALog.e(e, new Function0() { // from class: com.urbanairship.analytics.Analytics$associatedIdentifiers$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to parse associated identifiers.";
                    }
                });
                getDataStore().remove("com.urbanairship.analytics.ASSOCIATED_IDENTIFIERS");
            }
            return new AssociatedIdentifiers();
        }
    }

    @MainThread
    public final void trackScreen(@Nullable String screen) {
        String str = (String) this.screenState.getValue();
        if (Intrinsics.areEqual(str, screen)) {
            return;
        }
        if (str != null) {
            ScreenTrackingEvent screenTrackingEvent = new ScreenTrackingEvent(str, this.previousScreen, this.screenStartTime, this.clock.currentTimeMillis());
            this.previousScreen = str;
            addEvent(screenTrackingEvent);
        }
        this._currentScreen.setValue(screen);
        this.screenStartTime = this.clock.currentTimeMillis();
        if (screen != null) {
            this.eventFeed.emit$urbanairship_core_release(new AirshipEventFeed.Event.Screen(screen));
        }
    }

    public final void uploadEvents() {
        if (this.privacyManager.isEnabled(PrivacyManager.Feature.ANALYTICS)) {
            this.eventManager.scheduleEventUpload(10L, TimeUnit.SECONDS);
        }
    }

    private final Map getAnalyticHeaders() {
        HashMap map = new HashMap();
        Iterator it = this.headerDelegates.iterator();
        while (it.hasNext()) {
            map.putAll(((AnalyticsHeaderDelegate) it.next()).onCreateAnalyticsHeaders());
        }
        for (final Permission permission : this.permissionsManager.getConfiguredPermissions()) {
            try {
                PermissionStatus permissionStatus = this.permissionsManager.checkPermissionStatus(permission).get();
                if (permissionStatus != null) {
                    map.put("X-UA-Permission-" + permission.getValue(), permissionStatus.getValue());
                }
            } catch (Exception e) {
                UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.analytics.Analytics$analyticHeaders$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to get status for permission " + permission;
                    }
                });
            }
        }
        map.put("X-UA-Package-Name", getPackageName());
        map.put("X-UA-Package-Version", getPackageVersion());
        map.put("X-UA-Android-Version-Code", String.valueOf(Build.VERSION.SDK_INT));
        map.put("X-UA-Device-Family", this.runtimeConfig.getPlatform() == 1 ? "amazon" : "android");
        map.put("X-UA-Lib-Version", UAirship.getVersion());
        map.put("X-UA-App-Key", this.runtimeConfig.getConfigOptions().appKey);
        map.put("X-UA-In-Production", String.valueOf(this.runtimeConfig.getConfigOptions().inProduction));
        map.put("X-UA-Channel-ID", this.airshipChannel.getId());
        map.put("X-UA-Push-Address", this.airshipChannel.getId());
        if (!this.sdkExtensions.isEmpty()) {
            map.put("X-UA-Frameworks", UAStringUtil.join(this.sdkExtensions, ","));
        }
        map.put("X-UA-Device-Model", Build.MODEL);
        map.put("X-UA-Timezone", TimeZone.getDefault().getID());
        Locale locale = this.localeManager.getLocale();
        Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
        if (!UAStringUtil.isEmpty(locale.getLanguage())) {
            map.put("X-UA-Locale-Language", locale.getLanguage());
            if (!UAStringUtil.isEmpty(locale.getCountry())) {
                map.put("X-UA-Locale-Country", locale.getCountry());
            }
            if (!UAStringUtil.isEmpty(locale.getVariant())) {
                map.put("X-UA-Locale-Variant", locale.getVariant());
            }
        }
        return map;
    }

    private final String getPackageName() {
        try {
            return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final String getPackageVersion() {
        try {
            return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final void registerSDKExtension(@NotNull Extension extension, @NotNull String version) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(version, "version");
        String strReplace$default = StringsKt.replace$default(version, ",", "", false, 4, (Object) null);
        this.sdkExtensions.add(extension.getExtensionName() + ':' + strReplace$default);
    }
}
