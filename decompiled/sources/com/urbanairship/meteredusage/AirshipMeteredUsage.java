package com.urbanairship.meteredusage;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import ch.qos.logback.core.net.SyslogConstants;
import com.urbanairship.AirshipComponent;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.contacts.Contact;
import com.urbanairship.http.RequestResult;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.remoteconfig.MeteredUsageConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0017\u0018\u0000 %2\u00020\u0001:\u0001%BM\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0097@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0012J\b\u0010$\u001a\u00020\u0017H\u0012R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0092\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/urbanairship/meteredusage/AirshipMeteredUsage;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "store", "Lcom/urbanairship/meteredusage/EventsDao;", "client", "Lcom/urbanairship/meteredusage/MeteredUsageApiClient;", "contact", "Lcom/urbanairship/contacts/Contact;", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/meteredusage/EventsDao;Lcom/urbanairship/meteredusage/MeteredUsageApiClient;Lcom/urbanairship/contacts/Contact;Lcom/urbanairship/job/JobDispatcher;)V", "usageConfig", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/urbanairship/remoteconfig/MeteredUsageConfig;", "addEvent", "", "event", "Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;", "(Lcom/urbanairship/meteredusage/MeteredUsageEventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPerformJob", "Lcom/urbanairship/job/JobResult;", "airship", "Lcom/urbanairship/UAirship;", "jobInfo", "Lcom/urbanairship/job/JobInfo;", "scheduleUpload", "delay", "", "updateConfig", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@OpenForTesting
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nAirshipMeteredUsage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipMeteredUsage.kt\ncom/urbanairship/meteredusage/AirshipMeteredUsage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1549#2:154\n1620#2,3:155\n*S KotlinDebug\n*F\n+ 1 AirshipMeteredUsage.kt\ncom/urbanairship/meteredusage/AirshipMeteredUsage\n*L\n122#1:154\n122#1:155,3\n*E\n"})
/* loaded from: classes5.dex */
public class AirshipMeteredUsage extends AirshipComponent {
    private final MeteredUsageApiClient client;
    private final AirshipRuntimeConfig config;
    private final Contact contact;
    private final JobDispatcher jobDispatcher;
    private final PrivacyManager privacyManager;
    private final EventsDao store;
    private final AtomicReference usageConfig;

    /* renamed from: com.urbanairship.meteredusage.AirshipMeteredUsage$addEvent$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AirshipMeteredUsage.addEvent$suspendImpl(AirshipMeteredUsage.this, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipMeteredUsage(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull Contact contact) {
        this(context, dataStore, config, privacyManager, null, null, contact, null, SyslogConstants.LOG_LOCAL6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(contact, "contact");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipMeteredUsage(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull EventsDao store, @NotNull Contact contact) {
        this(context, dataStore, config, privacyManager, store, null, contact, null, 160, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(contact, "contact");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipMeteredUsage(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull EventsDao store, @NotNull MeteredUsageApiClient client, @NotNull Contact contact) {
        this(context, dataStore, config, privacyManager, store, client, contact, null, 128, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(contact, "contact");
    }

    @WorkerThread
    @Nullable
    public Object addEvent(@NotNull MeteredUsageEventEntity meteredUsageEventEntity, @NotNull Continuation<? super Unit> continuation) {
        return addEvent$suspendImpl(this, meteredUsageEventEntity, continuation);
    }

    public /* synthetic */ AirshipMeteredUsage(Context context, PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig airshipRuntimeConfig, PrivacyManager privacyManager, EventsDao eventsDao, MeteredUsageApiClient meteredUsageApiClient, Contact contact, JobDispatcher jobDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        MeteredUsageApiClient meteredUsageApiClient2;
        JobDispatcher jobDispatcher2;
        EventsDao eventsDao2 = (i & 16) != 0 ? EventsDatabase.INSTANCE.persistent(context).eventsDao() : eventsDao;
        if ((i & 32) != 0) {
            meteredUsageApiClient2 = new MeteredUsageApiClient(airshipRuntimeConfig, null, 2, 0 == true ? 1 : 0);
        } else {
            meteredUsageApiClient2 = meteredUsageApiClient;
        }
        if ((i & 128) != 0) {
            JobDispatcher jobDispatcherShared = JobDispatcher.shared(context);
            Intrinsics.checkNotNullExpressionValue(jobDispatcherShared, "shared(...)");
            jobDispatcher2 = jobDispatcherShared;
        } else {
            jobDispatcher2 = jobDispatcher;
        }
        this(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, eventsDao2, meteredUsageApiClient2, contact, jobDispatcher2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipMeteredUsage(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull EventsDao store, @NotNull MeteredUsageApiClient client, @NotNull Contact contact, @NotNull JobDispatcher jobDispatcher) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(jobDispatcher, "jobDispatcher");
        this.config = config;
        this.privacyManager = privacyManager;
        this.store = store;
        this.client = client;
        this.contact = contact;
        this.jobDispatcher = jobDispatcher;
        MeteredUsageConfig.Companion companion = MeteredUsageConfig.INSTANCE;
        this.usageConfig = new AtomicReference(companion.getDEFAULT());
        jobDispatcher.setRateLimit("MeteredUsage.rateLimit", 1, companion.getDEFAULT().getIntervalMs(), TimeUnit.MILLISECONDS);
        config.addConfigListener(new AirshipRuntimeConfig.ConfigChangeListener() { // from class: com.urbanairship.meteredusage.AirshipMeteredUsage$$ExternalSyntheticLambda0
            @Override // com.urbanairship.config.AirshipRuntimeConfig.ConfigChangeListener
            public final void onConfigUpdated() {
                AirshipMeteredUsage._init_$lambda$0(this.f$0);
            }
        });
        updateConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(AirshipMeteredUsage this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateConfig();
    }

    private void updateConfig() {
        MeteredUsageConfig meteredUsageConfig = this.config.getRemoteConfig().getMeteredUsageConfig();
        if (meteredUsageConfig == null) {
            meteredUsageConfig = MeteredUsageConfig.INSTANCE.getDEFAULT();
        }
        MeteredUsageConfig meteredUsageConfig2 = (MeteredUsageConfig) this.usageConfig.getAndSet(meteredUsageConfig);
        if (Intrinsics.areEqual(meteredUsageConfig2, meteredUsageConfig)) {
            return;
        }
        this.jobDispatcher.setRateLimit("MeteredUsage.rateLimit", 1, meteredUsageConfig.getIntervalMs(), TimeUnit.MILLISECONDS);
        if (meteredUsageConfig2.isEnabled() || !meteredUsageConfig.isEnabled()) {
            return;
        }
        scheduleUpload(meteredUsageConfig.getInitialDelayMs());
    }

    private void scheduleUpload(long delay) {
        if (((MeteredUsageConfig) this.usageConfig.get()).isEnabled()) {
            this.jobDispatcher.dispatch(JobInfo.newBuilder().setAirshipComponent(AirshipMeteredUsage.class).setAction("MeteredUsage.upload").setConflictStrategy(2).setNetworkAccessRequired(true).setMinDelay(delay, TimeUnit.MILLISECONDS).build());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object addEvent$suspendImpl(com.urbanairship.meteredusage.AirshipMeteredUsage r4, com.urbanairship.meteredusage.MeteredUsageEventEntity r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof com.urbanairship.meteredusage.AirshipMeteredUsage.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.meteredusage.AirshipMeteredUsage$addEvent$1 r0 = (com.urbanairship.meteredusage.AirshipMeteredUsage.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.meteredusage.AirshipMeteredUsage$addEvent$1 r0 = new com.urbanairship.meteredusage.AirshipMeteredUsage$addEvent$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.urbanairship.meteredusage.MeteredUsageEventEntity r5 = (com.urbanairship.meteredusage.MeteredUsageEventEntity) r5
            java.lang.Object r4 = r0.L$0
            com.urbanairship.meteredusage.AirshipMeteredUsage r4 = (com.urbanairship.meteredusage.AirshipMeteredUsage) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L71
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.concurrent.atomic.AtomicReference r6 = r4.usageConfig
            java.lang.Object r6 = r6.get()
            com.urbanairship.remoteconfig.MeteredUsageConfig r6 = (com.urbanairship.remoteconfig.MeteredUsageConfig) r6
            boolean r6 = r6.isEnabled()
            if (r6 != 0) goto L4e
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L4e:
            com.urbanairship.PrivacyManager r6 = r4.privacyManager
            com.urbanairship.PrivacyManager$Feature r2 = com.urbanairship.PrivacyManager.Feature.ANALYTICS
            com.urbanairship.PrivacyManager$Feature[] r2 = new com.urbanairship.PrivacyManager.Feature[]{r2}
            boolean r6 = r6.isEnabled(r2)
            if (r6 == 0) goto L7c
            java.lang.String r6 = r5.getContactId()
            if (r6 != 0) goto L80
            com.urbanairship.contacts.Contact r6 = r4.contact
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.stableContactInfo$urbanairship_core_release(r0)
            if (r6 != r1) goto L71
            return r1
        L71:
            com.urbanairship.contacts.StableContactInfo r6 = (com.urbanairship.contacts.StableContactInfo) r6
            java.lang.String r6 = r6.getContactId()
            com.urbanairship.meteredusage.MeteredUsageEventEntity r5 = r5.copyWithContactId$urbanairship_core_release(r6)
            goto L80
        L7c:
            com.urbanairship.meteredusage.MeteredUsageEventEntity r5 = r5.withAnalyticsDisabled$urbanairship_core_release()
        L80:
            com.urbanairship.meteredusage.EventsDao r6 = r4.store
            r6.addEvent(r5)
            r5 = 0
            r4.scheduleUpload(r5)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.meteredusage.AirshipMeteredUsage.addEvent$suspendImpl(com.urbanairship.meteredusage.AirshipMeteredUsage, com.urbanairship.meteredusage.MeteredUsageEventEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.util.ArrayList, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.String] */
    @Override // com.urbanairship.AirshipComponent
    @NotNull
    public JobResult onPerformJob(@NotNull UAirship airship, @NotNull JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        if (!((MeteredUsageConfig) this.usageConfig.get()).isEnabled()) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.meteredusage.AirshipMeteredUsage.onPerformJob.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Config disabled, skipping upload.";
                }
            }, 1, null);
            return JobResult.SUCCESS;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? allEvents = this.store.getAllEvents();
        objectRef.element = allEvents;
        if (((List) allEvents).isEmpty()) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.meteredusage.AirshipMeteredUsage.onPerformJob.2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No events, skipping upload.";
                }
            }, 1, null);
            return JobResult.SUCCESS;
        }
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = airship.getChannel().getId();
        if (!this.privacyManager.isEnabled(PrivacyManager.Feature.ANALYTICS)) {
            objectRef2.element = null;
            Iterable iterable = (Iterable) objectRef.element;
            ?? arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(((MeteredUsageEventEntity) it.next()).withAnalyticsDisabled$urbanairship_core_release());
            }
            objectRef.element = arrayList;
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.meteredusage.AirshipMeteredUsage.onPerformJob.4
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Uploading events";
            }
        }, 1, null);
        if (!((RequestResult) BuildersKt__BuildersKt.runBlocking$default(null, new AirshipMeteredUsage$onPerformJob$result$1(this, objectRef, objectRef2, null), 1, null)).isSuccessful()) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.meteredusage.AirshipMeteredUsage.onPerformJob.5
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Uploading failed";
                }
            }, 1, null);
            return JobResult.FAILURE;
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.meteredusage.AirshipMeteredUsage.onPerformJob.6
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Uploading success";
            }
        }, 1, null);
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass7(objectRef, null), 1, null);
        return JobResult.SUCCESS;
    }

    /* renamed from: com.urbanairship.meteredusage.AirshipMeteredUsage$onPerformJob$7, reason: invalid class name */
    static final class AnonymousClass7 extends SuspendLambda implements Function2 {
        final /* synthetic */ Ref.ObjectRef $events;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Ref.ObjectRef objectRef, Continuation continuation) {
            super(2, continuation);
            this.$events = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipMeteredUsage.this.new AnonymousClass7(this.$events, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    EventsDao eventsDao = AirshipMeteredUsage.this.store;
                    Iterable iterable = (Iterable) this.$events.element;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((MeteredUsageEventEntity) it.next()).getEventId());
                    }
                    List<String> list = CollectionsKt.toList(arrayList);
                    this.label = 1;
                    if (eventsDao.deleteAll(list, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                UALog.e(e, new Function0() { // from class: com.urbanairship.meteredusage.AirshipMeteredUsage.onPerformJob.7.2
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to delete events";
                    }
                });
            }
            return Unit.INSTANCE;
        }
    }
}
