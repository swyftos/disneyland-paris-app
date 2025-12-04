package com.urbanairship.remotedata;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
import com.facebook.imageutils.JfifUtil;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.PushProviders;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.ApplicationListener;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.app.SimpleApplicationListener;
import com.urbanairship.base.Supplier;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.contacts.Contact;
import com.urbanairship.contacts.ContactIdUpdate;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.locale.LocaleChangedListener;
import com.urbanairship.locale.LocaleManager;
import com.urbanairship.push.PushListener;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import com.urbanairship.remotedata.RemoteDataProvider;
import com.urbanairship.util.Clock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0093\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u00012\b\u0007\u0018\u0000 r2\u00020\u0001:\u0003rstB]\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\u0010\u0016B{\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\u000e\u0010A\u001a\u00020BH\u0082@¢\u0006\u0002\u0010CJ\b\u0010D\u001a\u00020BH\u0002J\r\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0002\bFJ\u000e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ\u0016\u0010K\u001a\u00020B2\u0006\u0010I\u001a\u00020JH\u0086@¢\u0006\u0002\u0010LJ\u0018\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0017J\u001a\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00140T2\u0006\u0010V\u001a\u00020%J \u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00140T2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020%0\u0014J\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u00142\u0006\u0010V\u001a\u00020%H\u0086@¢\u0006\u0002\u0010YJ\"\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u00142\f\u0010W\u001a\b\u0012\u0004\u0012\u00020%0\u0014H\u0086@¢\u0006\u0002\u0010ZJ\u000e\u0010[\u001a\u00020HH\u0086@¢\u0006\u0002\u0010CJ\u0016\u0010[\u001a\u00020H2\u0006\u0010\\\u001a\u00020<H\u0086@¢\u0006\u0002\u0010]J\u001c\u0010[\u001a\u00020H2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020<0\u0014H\u0086@¢\u0006\u0002\u0010ZJ\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020>0`2\u0006\u0010\\\u001a\u00020<J\u0015\u0010a\u001a\u00020B2\u0006\u0010b\u001a\u00020HH\u0000¢\u0006\u0002\bcJ\u000e\u0010d\u001a\u00020e2\u0006\u0010\\\u001a\u00020<J\u0016\u0010f\u001a\n\u0012\u0004\u0012\u00020e\u0018\u00010`2\u0006\u0010\\\u001a\u00020<J\b\u0010g\u001a\u00020BH\u0016J\b\u0010h\u001a\u00020BH\u0002J\"\u0010i\u001a\u00020B2\u0006\u0010\\\u001a\u00020<2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010kJD\u0010i\u001a\u00020B2\u0006\u0010\\\u001a\u00020<2\b\u0010j\u001a\u0004\u0018\u00010\u00182\"\u0010l\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020>\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0n\u0012\u0006\u0012\u0004\u0018\u00010o0mH\u0082@¢\u0006\u0002\u0010pJ\"\u0010q\u001a\u00020B2\u0006\u0010\\\u001a\u00020<2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0018H\u0086@¢\u0006\u0002\u0010kR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010:\u001a\u0014\u0012\u0004\u0012\u00020<\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0=0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/urbanairship/remotedata/RemoteData;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "localeManager", "Lcom/urbanairship/locale/LocaleManager;", "pushManager", "Lcom/urbanairship/push/PushManager;", "pushProviders", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/PushProviders;", "contact", "Lcom/urbanairship/contacts/Contact;", "providers", "", "Lcom/urbanairship/remotedata/RemoteDataProvider;", "(Landroid/content/Context;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/push/PushManager;Lcom/urbanairship/base/Supplier;Lcom/urbanairship/contacts/Contact;Ljava/util/List;)V", "appVersion", "", "refreshManager", "Lcom/urbanairship/remotedata/RemoteDataRefreshManager;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "clock", "Lcom/urbanairship/util/Clock;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/push/PushManager;Lcom/urbanairship/contacts/Contact;Ljava/util/List;JLcom/urbanairship/remotedata/RemoteDataRefreshManager;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "applicationListener", "Lcom/urbanairship/app/ApplicationListener;", "changeToken", "", "getChangeToken", "()Ljava/lang/String;", "changeTokenLock", "Ljava/util/concurrent/locks/Lock;", "configListener", "Lcom/urbanairship/config/AirshipRuntimeConfig$ConfigChangeListener;", "isAnyFeatureEnabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lastForegroundDispatchTime", "localeChangedListener", "Lcom/urbanairship/locale/LocaleChangedListener;", "privacyListener", "com/urbanairship/remotedata/RemoteData$privacyListener$1", "Lcom/urbanairship/remotedata/RemoteData$privacyListener$1;", "pushListener", "Lcom/urbanairship/push/PushListener;", "randomValue", "", "getRandomValue", "()I", "refreshStatusFlowMap", "", "Lcom/urbanairship/remotedata/RemoteDataSource;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/remotedata/RemoteData$RefreshStatus;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "dispatchRefreshJob", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRefreshJobAsync", "getRefreshInterval", "getRefreshInterval$urbanairship_core_release", "isCurrent", "", "remoteDataInfo", "Lcom/urbanairship/remotedata/RemoteDataInfo;", "notifyOutdated", "(Lcom/urbanairship/remotedata/RemoteDataInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPerformJob", "Lcom/urbanairship/job/JobResult;", "airship", "Lcom/urbanairship/UAirship;", "jobInfo", "Lcom/urbanairship/job/JobInfo;", "payloadFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/remotedata/RemoteDataPayload;", "type", "types", "payloads", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "source", "(Lcom/urbanairship/remotedata/RemoteDataSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sources", "refreshStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "setContactSourceEnabled", "enabled", "setContactSourceEnabled$urbanairship_core_release", "status", "Lcom/urbanairship/remotedata/RemoteData$Status;", "statusFlow", "tearDown", "updateChangeToken", "waitForRefresh", "maxTimeMillis", "(Lcom/urbanairship/remotedata/RemoteDataSource;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/urbanairship/remotedata/RemoteDataSource;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForRefreshAttempt", "Companion", "RefreshStatus", "Status", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRemoteData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,446:1\n1179#2,2:447\n1253#2,4:449\n288#2,2:453\n1855#2,2:455\n288#2,2:457\n1360#2:459\n1446#2,5:460\n1045#2:465\n1549#2:466\n1620#2,3:467\n1549#2:470\n1620#2,3:471\n288#2,2:499\n288#2,2:501\n21#3:474\n23#3:478\n21#3:479\n23#3:483\n53#3:484\n55#3:488\n21#3:489\n23#3:493\n53#3:494\n55#3:498\n50#4:475\n55#4:477\n50#4:480\n55#4:482\n50#4:485\n55#4:487\n50#4:490\n55#4:492\n50#4:495\n55#4:497\n106#5:476\n106#5:481\n106#5:486\n106#5:491\n106#5:496\n*S KotlinDebug\n*F\n+ 1 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData\n*L\n83#1:447,2\n83#1:449,4\n88#1:453,2\n244#1:455,2\n249#1:457,2\n260#1:459\n260#1:460,5\n260#1:465\n270#1:466\n270#1:467,3\n278#1:470\n278#1:471,3\n335#1:499,2\n345#1:501,2\n284#1:474\n284#1:478\n289#1:479\n289#1:483\n290#1:484\n290#1:488\n307#1:489\n307#1:493\n308#1:494\n308#1:498\n284#1:475\n284#1:477\n289#1:480\n289#1:482\n290#1:485\n290#1:487\n307#1:490\n307#1:492\n308#1:495\n308#1:497\n284#1:476\n289#1:481\n290#1:486\n307#1:491\n308#1:496\n*E\n"})
/* loaded from: classes5.dex */
public final class RemoteData extends AirshipComponent {

    @NotNull
    public static final String ACTION_REFRESH = "ACTION_REFRESH";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final long DEFAULT_FOREGROUND_REFRESH_INTERVAL_MS = 10000;
    private final ActivityMonitor activityMonitor;
    private final long appVersion;
    private final ApplicationListener applicationListener;
    private final Lock changeTokenLock;
    private final Clock clock;
    private final AirshipRuntimeConfig config;
    private final AirshipRuntimeConfig.ConfigChangeListener configListener;
    private final Contact contact;
    private AtomicBoolean isAnyFeatureEnabled;
    private long lastForegroundDispatchTime;
    private final LocaleChangedListener localeChangedListener;
    private final LocaleManager localeManager;
    private final PreferenceDataStore preferenceDataStore;
    private final RemoteData$privacyListener$1 privacyListener;
    private final PrivacyManager privacyManager;
    private final List providers;
    private final PushListener pushListener;
    private final PushManager pushManager;
    private final RemoteDataRefreshManager refreshManager;
    private final Map refreshStatusFlowMap;
    private final CoroutineScope scope;

    /* renamed from: com.urbanairship.remotedata.RemoteData$dispatchRefreshJob$1, reason: invalid class name and case insensitive filesystem */
    static final class C13811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C13811(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteData.this.dispatchRefreshJob(this);
        }
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$payloads$1, reason: invalid class name and case insensitive filesystem */
    static final class C13841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C13841(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteData.this.payloads((List<String>) null, this);
        }
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$waitForRefresh$4, reason: invalid class name */
    static final class AnonymousClass4 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass4(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteData.this.waitForRefresh(null, null, null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RemoteData(@NotNull Context context, @NotNull AirshipRuntimeConfig config, @NotNull PreferenceDataStore preferenceDataStore, @NotNull PrivacyManager privacyManager, @NotNull LocaleManager localeManager, @NotNull PushManager pushManager, @NotNull Supplier<PushProviders> pushProviders, @NotNull Contact contact) {
        this(context, config, preferenceDataStore, privacyManager, localeManager, pushManager, pushProviders, contact, null, 256, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(pushProviders, "pushProviders");
        Intrinsics.checkNotNullParameter(contact, "contact");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RemoteData(Context context, AirshipRuntimeConfig airshipRuntimeConfig, PreferenceDataStore preferenceDataStore, PrivacyManager privacyManager, LocaleManager localeManager, PushManager pushManager, Contact contact, List list, long j, RemoteDataRefreshManager remoteDataRefreshManager, ActivityMonitor activityMonitor, Clock clock, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        ActivityMonitor activityMonitorShared = (i & 1024) != 0 ? GlobalActivityMonitor.INSTANCE.shared(context) : activityMonitor;
        if ((i & 2048) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(context, airshipRuntimeConfig, preferenceDataStore, privacyManager, localeManager, pushManager, contact, list, j, remoteDataRefreshManager, activityMonitorShared, clock2, (i & 4096) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.urbanairship.PrivacyManager$Listener, com.urbanairship.remotedata.RemoteData$privacyListener$1] */
    @VisibleForTesting
    public RemoteData(@NotNull Context context, @NotNull AirshipRuntimeConfig config, @NotNull PreferenceDataStore preferenceDataStore, @NotNull PrivacyManager privacyManager, @NotNull LocaleManager localeManager, @NotNull PushManager pushManager, @NotNull Contact contact, @NotNull List<? extends RemoteDataProvider> providers, long j, @NotNull RemoteDataRefreshManager refreshManager, @NotNull ActivityMonitor activityMonitor, @NotNull Clock clock, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(context, preferenceDataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(providers, "providers");
        Intrinsics.checkNotNullParameter(refreshManager, "refreshManager");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.config = config;
        this.preferenceDataStore = preferenceDataStore;
        this.privacyManager = privacyManager;
        this.localeManager = localeManager;
        this.pushManager = pushManager;
        this.contact = contact;
        this.providers = providers;
        this.appVersion = j;
        this.refreshManager = refreshManager;
        this.activityMonitor = activityMonitor;
        this.clock = clock;
        this.scope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.changeTokenLock = new ReentrantLock();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(providers, 10)), 16));
        Iterator<T> it = providers.iterator();
        while (it.hasNext()) {
            Pair pair = TuplesKt.to(((RemoteDataProvider) it.next()).getSource(), StateFlowKt.MutableStateFlow(RefreshStatus.NONE));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.refreshStatusFlowMap = linkedHashMap;
        SimpleApplicationListener simpleApplicationListener = new SimpleApplicationListener() { // from class: com.urbanairship.remotedata.RemoteData$applicationListener$1
            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onForeground(long time) {
                long jCurrentTimeMillis = this.this$0.clock.currentTimeMillis();
                if (jCurrentTimeMillis >= this.this$0.lastForegroundDispatchTime + this.this$0.getRefreshInterval$urbanairship_core_release()) {
                    this.this$0.updateChangeToken();
                    this.this$0.dispatchRefreshJobAsync();
                    this.this$0.lastForegroundDispatchTime = jCurrentTimeMillis;
                }
            }
        };
        this.applicationListener = simpleApplicationListener;
        LocaleChangedListener localeChangedListener = new LocaleChangedListener() { // from class: com.urbanairship.remotedata.RemoteData$$ExternalSyntheticLambda0
            @Override // com.urbanairship.locale.LocaleChangedListener
            public final void onLocaleChanged(Locale locale) {
                RemoteData.localeChangedListener$lambda$2(this.f$0, locale);
            }
        };
        this.localeChangedListener = localeChangedListener;
        PushListener pushListener = new PushListener() { // from class: com.urbanairship.remotedata.RemoteData$$ExternalSyntheticLambda1
            @Override // com.urbanairship.push.PushListener
            public final void onPushReceived(PushMessage pushMessage, boolean z) {
                RemoteData.pushListener$lambda$3(this.f$0, pushMessage, z);
            }
        };
        this.pushListener = pushListener;
        AirshipRuntimeConfig.ConfigChangeListener configChangeListener = new AirshipRuntimeConfig.ConfigChangeListener() { // from class: com.urbanairship.remotedata.RemoteData$$ExternalSyntheticLambda2
            @Override // com.urbanairship.config.AirshipRuntimeConfig.ConfigChangeListener
            public final void onConfigUpdated() {
                RemoteData.configListener$lambda$4(this.f$0);
            }
        };
        this.configListener = configChangeListener;
        this.isAnyFeatureEnabled = new AtomicBoolean(this.privacyManager.isAnyFeatureEnabled());
        ?? r6 = new PrivacyManager.Listener() { // from class: com.urbanairship.remotedata.RemoteData$privacyListener$1
            @Override // com.urbanairship.PrivacyManager.Listener
            public void onEnabledFeaturesChanged() {
                boolean zIsAnyFeatureEnabled = this.this$0.privacyManager.isAnyFeatureEnabled();
                if (this.this$0.isAnyFeatureEnabled.getAndSet(zIsAnyFeatureEnabled) || !zIsAnyFeatureEnabled) {
                    return;
                }
                this.this$0.dispatchRefreshJobAsync();
            }
        };
        this.privacyListener = r6;
        this.activityMonitor.addApplicationListener(simpleApplicationListener);
        this.pushManager.addInternalPushListener(pushListener);
        this.localeManager.addListener(localeChangedListener);
        this.privacyManager.addListener(r6);
        this.config.addConfigListener(configChangeListener);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
        this.refreshManager.dispatchRefreshJob();
        if (this.activityMonitor.getIsAppForegrounded()) {
            simpleApplicationListener.onForeground(this.clock.currentTimeMillis());
        }
    }

    public final void setContactSourceEnabled$urbanairship_core_release(boolean enabled) {
        Object next;
        Iterator it = this.providers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((RemoteDataProvider) next).getSource() == RemoteDataSource.CONTACT) {
                    break;
                }
            }
        }
        RemoteDataProvider remoteDataProvider = (RemoteDataProvider) next;
        if (remoteDataProvider == null || remoteDataProvider.isEnabled() == enabled) {
            return;
        }
        remoteDataProvider.setEnabled(enabled);
    }

    public final long getRefreshInterval$urbanairship_core_release() {
        Long remoteDataRefreshInterval = this.config.getRemoteConfig().getRemoteDataRefreshInterval();
        if (remoteDataRefreshInterval != null) {
            return remoteDataRefreshInterval.longValue();
        }
        return 10000L;
    }

    public /* synthetic */ RemoteData(Context context, AirshipRuntimeConfig airshipRuntimeConfig, PreferenceDataStore preferenceDataStore, PrivacyManager privacyManager, LocaleManager localeManager, PushManager pushManager, Supplier supplier, Contact contact, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, airshipRuntimeConfig, preferenceDataStore, privacyManager, localeManager, pushManager, supplier, contact, (i & 256) != 0 ? INSTANCE.createProviders(context, preferenceDataStore, airshipRuntimeConfig, supplier, contact) : list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    public RemoteData(@NotNull Context context, @NotNull AirshipRuntimeConfig config, @NotNull PreferenceDataStore preferenceDataStore, @NotNull PrivacyManager privacyManager, @NotNull LocaleManager localeManager, @NotNull PushManager pushManager, @NotNull Supplier<PushProviders> pushProviders, @NotNull Contact contact, @NotNull List<? extends RemoteDataProvider> providers) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(pushProviders, "pushProviders");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(providers, "providers");
        long appVersion = UAirship.getAppVersion();
        JobDispatcher jobDispatcherShared = JobDispatcher.shared(context);
        Intrinsics.checkNotNullExpressionValue(jobDispatcherShared, "shared(...)");
        this(context, config, preferenceDataStore, privacyManager, localeManager, pushManager, contact, providers, appVersion, new RemoteDataRefreshManager(jobDispatcherShared, privacyManager, providers), null, null, null, 7168, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void localeChangedListener$lambda$2(RemoteData this$0, Locale it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.dispatchRefreshJobAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pushListener$lambda$3(RemoteData this$0, PushMessage message, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.isRemoteDataUpdate()) {
            this$0.updateChangeToken();
            this$0.dispatchRefreshJobAsync();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void configListener$lambda$4(RemoteData this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean fetchContactRemoteData = this$0.config.getRemoteConfig().getFetchContactRemoteData();
        this$0.setContactSourceEnabled$urbanairship_core_release(fetchContactRemoteData != null ? fetchContactRemoteData.booleanValue() : false);
        this$0.updateChangeToken();
        this$0.dispatchRefreshJobAsync();
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RemoteData.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow<ContactIdUpdate> contactIdUpdateFlow$urbanairship_core_release = RemoteData.this.contact.getContactIdUpdateFlow$urbanairship_core_release();
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<String>() { // from class: com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1
                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = contactIdUpdateFlow$urbanairship_core_release.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData$1\n*L\n1#1,222:1\n61#2:223\n62#2:225\n179#3:224\n*E\n"})
                    /* renamed from: com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "RemoteData.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                        /* renamed from: com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L4b
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                com.urbanairship.contacts.ContactIdUpdate r5 = (com.urbanairship.contacts.ContactIdUpdate) r5
                                if (r5 == 0) goto L3f
                                java.lang.String r5 = r5.getContactId()
                                goto L40
                            L3f:
                                r5 = 0
                            L40:
                                if (r5 == 0) goto L4b
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L4b
                                return r1
                            L4b:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }
                });
                final RemoteData remoteData = RemoteData.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.remotedata.RemoteData.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(String str, Continuation continuation) {
                        Object objDispatchRefreshJob = remoteData.dispatchRefreshJob(continuation);
                        return objDispatchRefreshJob == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDispatchRefreshJob : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowDistinctUntilChanged.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RemoteData.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<Pair<RemoteDataSource, RemoteDataProvider.RefreshResult>> refreshFlow = RemoteData.this.refreshManager.getRefreshFlow();
                final RemoteData remoteData = RemoteData.this;
                FlowCollector<? super Pair<RemoteDataSource, RemoteDataProvider.RefreshResult>> flowCollector = new FlowCollector() { // from class: com.urbanairship.remotedata.RemoteData.2.1

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    /* renamed from: com.urbanairship.remotedata.RemoteData$2$1$WhenMappings */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[RemoteDataProvider.RefreshResult.values().length];
                            try {
                                iArr[RemoteDataProvider.RefreshResult.SKIPPED.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[RemoteDataProvider.RefreshResult.NEW_DATA.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[RemoteDataProvider.RefreshResult.FAILED.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Pair pair, Continuation continuation) {
                        RefreshStatus refreshStatus;
                        int i2 = WhenMappings.$EnumSwitchMapping$0[((RemoteDataProvider.RefreshResult) pair.getSecond()).ordinal()];
                        if (i2 == 1 || i2 == 2) {
                            refreshStatus = RefreshStatus.SUCCESS;
                        } else {
                            if (i2 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            refreshStatus = RefreshStatus.FAILED;
                        }
                        MutableStateFlow mutableStateFlow = (MutableStateFlow) remoteData.refreshStatusFlowMap.get(pair.getFirst());
                        if (mutableStateFlow == null) {
                            return Unit.INSTANCE;
                        }
                        Object objEmit = mutableStateFlow.emit(refreshStatus, continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (refreshFlow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // com.urbanairship.AirshipComponent
    public void tearDown() {
        this.pushManager.removePushListener(this.pushListener);
        this.activityMonitor.removeApplicationListener(this.applicationListener);
        this.localeManager.removeListener(this.localeChangedListener);
        this.privacyManager.removeListener(this.privacyListener);
        this.config.removeRemoteConfigListener(this.configListener);
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$onPerformJob$1, reason: invalid class name and case insensitive filesystem */
    static final class C13831 extends SuspendLambda implements Function2 {
        int label;

        C13831(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RemoteData.this.new C13831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C13831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RemoteDataRefreshManager remoteDataRefreshManager = RemoteData.this.refreshManager;
                String changeToken = RemoteData.this.getChangeToken();
                Locale locale = RemoteData.this.localeManager.getLocale();
                Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
                int randomValue = RemoteData.this.getRandomValue();
                this.label = 1;
                obj = remoteDataRefreshManager.performRefresh(changeToken, locale, randomValue, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    @NotNull
    public JobResult onPerformJob(@NotNull UAirship airship, @NotNull JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        if (Intrinsics.areEqual(ACTION_REFRESH, jobInfo.getAction())) {
            return (JobResult) BuildersKt__BuildersKt.runBlocking$default(null, new C13831(null), 1, null);
        }
        return JobResult.SUCCESS;
    }

    public final int getRandomValue() {
        int i = this.preferenceDataStore.getInt("com.urbanairship.remotedata.RANDOM_VALUE", -1);
        if (i != -1) {
            return i;
        }
        int iNextInt = new SecureRandom().nextInt(10000);
        this.preferenceDataStore.put("com.urbanairship.remotedata.RANDOM_VALUE", iNextInt);
        return iNextInt;
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$dispatchRefreshJobAsync$1, reason: invalid class name and case insensitive filesystem */
    static final class C13821 extends SuspendLambda implements Function2 {
        int label;

        C13821(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RemoteData.this.new C13821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C13821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RemoteData remoteData = RemoteData.this;
                this.label = 1;
                if (remoteData.dispatchRefreshJob(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchRefreshJobAsync() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C13821(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object dispatchRefreshJob(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.urbanairship.remotedata.RemoteData.C13811
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.remotedata.RemoteData$dispatchRefreshJob$1 r0 = (com.urbanairship.remotedata.RemoteData.C13811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.remotedata.RemoteData$dispatchRefreshJob$1 r0 = new com.urbanairship.remotedata.RemoteData$dispatchRefreshJob$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.L$0
            com.urbanairship.remotedata.RemoteData r2 = (com.urbanairship.remotedata.RemoteData) r2
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r2
            goto L4a
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.Map r7 = r6.refreshStatusFlowMap
            java.util.Collection r7 = r7.values()
            java.util.Iterator r7 = r7.iterator()
            r5 = r7
            r7 = r6
            r6 = r5
        L4a:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L65
            java.lang.Object r2 = r6.next()
            kotlinx.coroutines.flow.MutableStateFlow r2 = (kotlinx.coroutines.flow.MutableStateFlow) r2
            com.urbanairship.remotedata.RemoteData$RefreshStatus r4 = com.urbanairship.remotedata.RemoteData.RefreshStatus.NONE
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r2 = r2.emit(r4, r0)
            if (r2 != r1) goto L4a
            return r1
        L65:
            com.urbanairship.remotedata.RemoteDataRefreshManager r6 = r7.refreshManager
            r6.dispatchRefreshJob()
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData.dispatchRefreshJob(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object notifyOutdated(@NotNull RemoteDataInfo remoteDataInfo, @NotNull Continuation<? super Unit> continuation) {
        Object next;
        Iterator it = this.providers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((RemoteDataProvider) next).getSource() == remoteDataInfo.getSource()) {
                break;
            }
        }
        RemoteDataProvider remoteDataProvider = (RemoteDataProvider) next;
        if (remoteDataProvider != null && remoteDataProvider.notifyOutdated(remoteDataInfo)) {
            Object objDispatchRefreshJob = dispatchRefreshJob(continuation);
            return objDispatchRefreshJob == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDispatchRefreshJob : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0074 -> B:25:0x0077). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object payloads(@org.jetbrains.annotations.NotNull java.util.List<java.lang.String> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.remotedata.RemoteDataPayload>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.remotedata.RemoteData.C13841
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.remotedata.RemoteData$payloads$1 r0 = (com.urbanairship.remotedata.RemoteData.C13841) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.remotedata.RemoteData$payloads$1 r0 = new com.urbanairship.remotedata.RemoteData$payloads$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$2
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.L$1
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L77
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L4b
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            return r5
        L4b:
            java.util.List r5 = r5.providers
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r5 = r5.iterator()
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L7e
            java.lang.Object r2 = r5.next()
            com.urbanairship.remotedata.RemoteDataProvider r2 = (com.urbanairship.remotedata.RemoteDataProvider) r2
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r2 = r2.payloads(r7, r0)
            if (r2 != r1) goto L74
            return r1
        L74:
            r4 = r2
            r2 = r7
            r7 = r4
        L77:
            java.util.Set r7 = (java.util.Set) r7
            kotlin.collections.CollectionsKt.addAll(r6, r7)
            r7 = r2
            goto L59
        L7e:
            java.util.List r6 = (java.util.List) r6
            com.urbanairship.remotedata.RemoteData$payloads$$inlined$sortedBy$1 r5 = new com.urbanairship.remotedata.RemoteData$payloads$$inlined$sortedBy$1
            r5.<init>()
            java.util.List r5 = kotlin.collections.CollectionsKt.sortedWith(r6, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData.payloads(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object payloads(@NotNull String str, @NotNull Continuation<? super List<RemoteDataPayload>> continuation) {
        return payloads(CollectionsKt.listOf(str), continuation);
    }

    @Nullable
    public final Object refresh(@NotNull Continuation<? super Boolean> continuation) {
        List list = this.providers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RemoteDataProvider) it.next()).getSource());
        }
        return refresh(arrayList, continuation);
    }

    @Nullable
    public final Object refresh(@NotNull RemoteDataSource remoteDataSource, @NotNull Continuation<? super Boolean> continuation) {
        return refresh(CollectionsKt.listOf(remoteDataSource), continuation);
    }

    @Nullable
    public final Object refresh(@NotNull List<? extends RemoteDataSource> list, @NotNull Continuation<? super Boolean> continuation) {
        List list2 = this.providers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((RemoteDataProvider) it.next()).getSource());
        }
        final Set setIntersect = CollectionsKt.intersect(list, CollectionsKt.toSet(arrayList));
        if (setIntersect.isEmpty()) {
            return Boxing.boxBoolean(false);
        }
        final SharedFlow<Pair<RemoteDataSource, RemoteDataProvider.RefreshResult>> refreshFlow = this.refreshManager.getRefreshFlow();
        final Flow flowRunningFold = FlowKt.runningFold(new Flow<Pair<? extends RemoteDataSource, ? extends RemoteDataProvider.RefreshResult>>() { // from class: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Pair<? extends RemoteDataSource, ? extends RemoteDataProvider.RefreshResult>> flowCollector, @NotNull Continuation continuation2) {
                Object objCollect = refreshFlow.collect(new AnonymousClass2(flowCollector, setIntersect), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData\n*L\n1#1,222:1\n22#2:223\n23#2:225\n284#3:224\n*E\n"})
            /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Set $providerSources$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1$2", f = "RemoteData.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Set set) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$providerSources$inlined = set;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1$2$1 r0 = (com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1$2$1 r0 = new com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4e
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r5
                        kotlin.Pair r2 = (kotlin.Pair) r2
                        java.util.Set r4 = r4.$providerSources$inlined
                        java.lang.Object r2 = r2.getFirst()
                        boolean r4 = r4.contains(r2)
                        if (r4 == 0) goto L4e
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r5, r0)
                        if (r4 != r1) goto L4e
                        return r1
                    L4e:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new ArrayList(), new AnonymousClass6(null));
        final Flow<List<RemoteDataProvider.RefreshResult>> flow = new Flow<List<RemoteDataProvider.RefreshResult>>() { // from class: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<RemoteDataProvider.RefreshResult>> flowCollector, @NotNull Continuation continuation2) {
                Object objCollect = flowRunningFold.collect(new AnonymousClass2(flowCollector, setIntersect), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData\n*L\n1#1,222:1\n22#2:223\n23#2:225\n289#3:224\n*E\n"})
            /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Set $providerSources$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2$2", f = "RemoteData.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, Set set) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$providerSources$inlined = set;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2$2$1 r0 = (com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2$2$1 r0 = new com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4e
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r5
                        java.util.List r2 = (java.util.List) r2
                        int r2 = r2.size()
                        java.util.Set r4 = r4.$providerSources$inlined
                        int r4 = r4.size()
                        if (r2 != r4) goto L4e
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r5, r0)
                        if (r4 != r1) goto L4e
                        return r1
                    L4e:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData$refresh$$inlined$filter$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        return FlowKt.first(FlowKt.onStart(new Flow<Boolean>() { // from class: com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Boolean> flowCollector, @NotNull Continuation continuation2) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData\n*L\n1#1,222:1\n54#2:223\n290#3:224\n*E\n"})
            /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1$2", f = "RemoteData.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1$2$1 r0 = (com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1$2$1 r0 = new com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4c
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        com.urbanairship.remotedata.RemoteDataProvider$RefreshResult r6 = com.urbanairship.remotedata.RemoteDataProvider.RefreshResult.FAILED
                        boolean r5 = r5.contains(r6)
                        r5 = r5 ^ r3
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L4c
                        return r1
                    L4c:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData$refresh$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new AnonymousClass9(null)), continuation);
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function3 {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass6(Continuation continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(List list, Pair pair, Continuation continuation) {
            AnonymousClass6 anonymousClass6 = new AnonymousClass6(continuation);
            anonymousClass6.L$0 = list;
            anonymousClass6.L$1 = pair;
            return anonymousClass6.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            list.add(((Pair) this.L$1).getSecond());
            return list;
        }
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$refresh$9, reason: invalid class name */
    static final class AnonymousClass9 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass9(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return RemoteData.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((AnonymousClass9) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RemoteData remoteData = RemoteData.this;
                this.label = 1;
                if (remoteData.dispatchRefreshJob(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public final StateFlow<RefreshStatus> refreshStatusFlow(@NotNull RemoteDataSource source) {
        StateFlow<RefreshStatus> stateFlowAsStateFlow;
        Intrinsics.checkNotNullParameter(source, "source");
        MutableStateFlow mutableStateFlow = (MutableStateFlow) this.refreshStatusFlowMap.get(source);
        return (mutableStateFlow == null || (stateFlowAsStateFlow = FlowKt.asStateFlow(mutableStateFlow)) == null) ? FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(RefreshStatus.NONE)) : stateFlowAsStateFlow;
    }

    @NotNull
    public final Flow<List<RemoteDataPayload>> payloadFlow(@NotNull String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return payloadFlow(CollectionsKt.listOf(type));
    }

    @NotNull
    public final Flow<List<RemoteDataPayload>> payloadFlow(@NotNull final List<String> types) {
        Intrinsics.checkNotNullParameter(types, "types");
        final SharedFlow<Pair<RemoteDataSource, RemoteDataProvider.RefreshResult>> refreshFlow = this.refreshManager.getRefreshFlow();
        final Flow<Pair<? extends RemoteDataSource, ? extends RemoteDataProvider.RefreshResult>> flow = new Flow<Pair<? extends RemoteDataSource, ? extends RemoteDataProvider.RefreshResult>>() { // from class: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Pair<? extends RemoteDataSource, ? extends RemoteDataProvider.RefreshResult>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = refreshFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData\n*L\n1#1,222:1\n22#2:223\n23#2:225\n307#3:224\n*E\n"})
            /* renamed from: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1$2", f = "RemoteData.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1$2$1 r0 = (com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1$2$1 r0 = new com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4a
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        r6 = r5
                        kotlin.Pair r6 = (kotlin.Pair) r6
                        java.lang.Object r6 = r6.getSecond()
                        com.urbanairship.remotedata.RemoteDataProvider$RefreshResult r2 = com.urbanairship.remotedata.RemoteDataProvider.RefreshResult.NEW_DATA
                        if (r6 != r2) goto L4a
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L4a
                        return r1
                    L4a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        return FlowKt.onStart(new Flow<List<? extends RemoteDataPayload>>() { // from class: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super List<? extends RemoteDataPayload>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, this, types), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 RemoteData.kt\ncom/urbanairship/remotedata/RemoteData\n*L\n1#1,222:1\n54#2:223\n309#3:224\n*E\n"})
            /* renamed from: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ List $types$inlined;
                final /* synthetic */ RemoteData this$0;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1$2", f = "RemoteData.kt", i = {}, l = {224, 223}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, RemoteData remoteData, List list) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = remoteData;
                    this.$types$inlined = list;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1$2$1 r0 = (com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1$2$1 r0 = new com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L61
                    L2c:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L34:
                        java.lang.Object r6 = r0.L$0
                        kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L55
                    L3c:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        kotlin.Pair r7 = (kotlin.Pair) r7
                        com.urbanairship.remotedata.RemoteData r7 = r6.this$0
                        java.util.List r6 = r6.$types$inlined
                        r0.L$0 = r8
                        r0.label = r4
                        java.lang.Object r6 = r7.payloads(r6, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        r5 = r8
                        r8 = r6
                        r6 = r5
                    L55:
                        r7 = 0
                        r0.L$0 = r7
                        r0.label = r3
                        java.lang.Object r6 = r6.emit(r8, r0)
                        if (r6 != r1) goto L61
                        return r1
                    L61:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData$payloadFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new AnonymousClass3(types, null));
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$payloadFlow$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $types;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List list, Continuation continuation) {
            super(2, continuation);
            this.$types = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = RemoteData.this.new AnonymousClass3(this.$types, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((AnonymousClass3) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                RemoteData remoteData = RemoteData.this;
                List<String> list = this.$types;
                this.L$0 = flowCollector;
                this.label = 1;
                obj = remoteData.payloads(list, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateChangeToken() {
        Lock lock = this.changeTokenLock;
        lock.lock();
        try {
            getDataStore().put("com.urbanairship.remotedata.CHANGE_TOKEN", UUID.randomUUID().toString());
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChangeToken() {
        String string = "";
        Lock lock = this.changeTokenLock;
        lock.lock();
        try {
            String string2 = getDataStore().getString("com.urbanairship.remotedata.CHANGE_TOKEN", "");
            if (string2 != null) {
                string = string2;
            }
            if (string.length() == 0) {
                string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                getDataStore().put("com.urbanairship.remotedata.CHANGE_TOKEN", string);
            }
            Intrinsics.checkNotNullExpressionValue(string, "ifEmpty(...)");
            String str = string + ':' + this.appVersion;
            lock.unlock();
            return str;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final boolean isCurrent(@NotNull RemoteDataInfo remoteDataInfo) {
        Object next;
        Intrinsics.checkNotNullParameter(remoteDataInfo, "remoteDataInfo");
        Iterator it = this.providers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((RemoteDataProvider) next).getSource() == remoteDataInfo.getSource()) {
                break;
            }
        }
        RemoteDataProvider remoteDataProvider = (RemoteDataProvider) next;
        if (remoteDataProvider == null) {
            return false;
        }
        Locale locale = this.localeManager.getLocale();
        Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
        return remoteDataProvider.isCurrent(locale, getRandomValue());
    }

    @NotNull
    public final Status status(@NotNull RemoteDataSource source) {
        Status value;
        Intrinsics.checkNotNullParameter(source, "source");
        StateFlow<Status> stateFlowStatusFlow = statusFlow(source);
        return (stateFlowStatusFlow == null || (value = stateFlowStatusFlow.getValue()) == null) ? Status.OUT_OF_DATE : value;
    }

    @Nullable
    public final StateFlow<Status> statusFlow(@NotNull RemoteDataSource source) {
        Object next;
        Intrinsics.checkNotNullParameter(source, "source");
        Iterator it = this.providers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((RemoteDataProvider) next).getSource() == source) {
                break;
            }
        }
        RemoteDataProvider remoteDataProvider = (RemoteDataProvider) next;
        if (remoteDataProvider == null) {
            return null;
        }
        String changeToken = getChangeToken();
        Locale locale = this.localeManager.getLocale();
        Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
        remoteDataProvider.status(changeToken, locale, getRandomValue());
        return remoteDataProvider.getStatusUpdates();
    }

    public static /* synthetic */ Object waitForRefresh$default(RemoteData remoteData, RemoteDataSource remoteDataSource, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return remoteData.waitForRefresh(remoteDataSource, l, continuation);
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$waitForRefresh$3, reason: invalid class name and case insensitive filesystem */
    static final class C13863 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C13863(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C13863 c13863 = new C13863(continuation);
            c13863.L$0 = obj;
            return c13863;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(RefreshStatus refreshStatus, Continuation continuation) {
            return ((C13863) create(refreshStatus, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((RefreshStatus) this.L$0) == RefreshStatus.SUCCESS);
        }
    }

    @Nullable
    public final Object waitForRefresh(@NotNull final RemoteDataSource remoteDataSource, @Nullable Long l, @NotNull Continuation<? super Unit> continuation) {
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.remotedata.RemoteData.waitForRefresh.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Waiting for remote data to refresh successfully " + remoteDataSource;
            }
        }, 1, null);
        Object objWaitForRefresh = waitForRefresh(remoteDataSource, l, new C13863(null), continuation);
        return objWaitForRefresh == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWaitForRefresh : Unit.INSTANCE;
    }

    public static /* synthetic */ Object waitForRefreshAttempt$default(RemoteData remoteData, RemoteDataSource remoteDataSource, Long l, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return remoteData.waitForRefreshAttempt(remoteDataSource, l, continuation);
    }

    /* renamed from: com.urbanairship.remotedata.RemoteData$waitForRefreshAttempt$3, reason: invalid class name and case insensitive filesystem */
    static final class C13883 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C13883(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C13883 c13883 = new C13883(continuation);
            c13883.L$0 = obj;
            return c13883;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(RefreshStatus refreshStatus, Continuation continuation) {
            return ((C13883) create(refreshStatus, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((RefreshStatus) this.L$0) != RefreshStatus.NONE);
        }
    }

    @Nullable
    public final Object waitForRefreshAttempt(@NotNull final RemoteDataSource remoteDataSource, @Nullable Long l, @NotNull Continuation<? super Unit> continuation) {
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.remotedata.RemoteData.waitForRefreshAttempt.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Waiting for remote data to refresh " + remoteDataSource;
            }
        }, 1, null);
        Object objWaitForRefresh = waitForRefresh(remoteDataSource, l, new C13883(null), continuation);
        return objWaitForRefresh == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWaitForRefresh : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForRefresh(final com.urbanairship.remotedata.RemoteDataSource r7, java.lang.Long r8, kotlin.jvm.functions.Function2 r9, kotlin.coroutines.Continuation r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof com.urbanairship.remotedata.RemoteData.AnonymousClass4
            if (r0 == 0) goto L13
            r0 = r10
            com.urbanairship.remotedata.RemoteData$waitForRefresh$4 r0 = (com.urbanairship.remotedata.RemoteData.AnonymousClass4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.remotedata.RemoteData$waitForRefresh$4 r0 = new com.urbanairship.remotedata.RemoteData$waitForRefresh$4
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.flow.StateFlow r6 = (kotlinx.coroutines.flow.StateFlow) r6
            java.lang.Object r7 = r0.L$0
            com.urbanairship.remotedata.RemoteDataSource r7 = (com.urbanairship.remotedata.RemoteDataSource) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L78
        L35:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3d:
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.flow.StateFlow r6 = (kotlinx.coroutines.flow.StateFlow) r6
            java.lang.Object r7 = r0.L$0
            com.urbanairship.remotedata.RemoteDataSource r7 = (com.urbanairship.remotedata.RemoteDataSource) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L68
        L49:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.StateFlow r6 = r6.refreshStatusFlow(r7)
            if (r8 == 0) goto L6b
            long r2 = r8.longValue()
            com.urbanairship.remotedata.RemoteData$waitForRefresh$refreshStatus$1 r8 = new com.urbanairship.remotedata.RemoteData$waitForRefresh$refreshStatus$1
            r8.<init>(r6, r9, r4)
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r2, r8, r0)
            if (r10 != r1) goto L68
            return r1
        L68:
            com.urbanairship.remotedata.RemoteData$RefreshStatus r10 = (com.urbanairship.remotedata.RemoteData.RefreshStatus) r10
            goto L7a
        L6b:
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r6, r9, r0)
            if (r10 != r1) goto L78
            return r1
        L78:
            com.urbanairship.remotedata.RemoteData$RefreshStatus r10 = (com.urbanairship.remotedata.RemoteData.RefreshStatus) r10
        L7a:
            if (r10 != 0) goto L83
            java.lang.Object r6 = r6.getValue()
            r10 = r6
            com.urbanairship.remotedata.RemoteData$RefreshStatus r10 = (com.urbanairship.remotedata.RemoteData.RefreshStatus) r10
        L83:
            com.urbanairship.remotedata.RemoteData$waitForRefresh$5 r6 = new com.urbanairship.remotedata.RemoteData$waitForRefresh$5
            r6.<init>()
            com.urbanairship.UALog.v$default(r4, r6, r5, r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remotedata.RemoteData.waitForRefresh(com.urbanairship.remotedata.RemoteDataSource, java.lang.Long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/remotedata/RemoteData$Companion;", "", "()V", RemoteData.ACTION_REFRESH, "", "getACTION_REFRESH$urbanairship_core_release$annotations", "CHANGE_TOKEN_KEY", "DEFAULT_FOREGROUND_REFRESH_INTERVAL_MS", "", "MAX_RANDOM_VALUE", "", "RANDOM_VALUE_KEY", "createProviders", "", "Lcom/urbanairship/remotedata/RemoteDataProvider;", "context", "Landroid/content/Context;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", "config", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "pushProviders", "Lcom/urbanairship/base/Supplier;", "Lcom/urbanairship/PushProviders;", "contact", "Lcom/urbanairship/contacts/Contact;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getACTION_REFRESH$urbanairship_core_release$annotations() {
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List createProviders(Context context, PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig config, Supplier pushProviders, Contact contact) {
            RemoteDataApiClient remoteDataApiClient = new RemoteDataApiClient(config, null, 2, 0 == true ? 1 : 0);
            RemoteDataUrlFactory remoteDataUrlFactory = new RemoteDataUrlFactory(config, pushProviders);
            return CollectionsKt.listOf((Object[]) new RemoteDataProvider[]{new AppRemoteDataProvider(context, preferenceDataStore, config, remoteDataApiClient, remoteDataUrlFactory), new ContactRemoteDataProvider(context, preferenceDataStore, config, contact, remoteDataApiClient, remoteDataUrlFactory)});
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/remotedata/RemoteData$Status;", "", "(Ljava/lang/String;I)V", "UP_TO_DATE", "STALE", "OUT_OF_DATE", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        public static final Status UP_TO_DATE = new Status("UP_TO_DATE", 0);
        public static final Status STALE = new Status("STALE", 1);
        public static final Status OUT_OF_DATE = new Status("OUT_OF_DATE", 2);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{UP_TO_DATE, STALE, OUT_OF_DATE};
        }

        @NotNull
        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        private Status(String str, int i) {
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/remotedata/RemoteData$RefreshStatus;", "", "(Ljava/lang/String;I)V", "NONE", "FAILED", "SUCCESS", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RefreshStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RefreshStatus[] $VALUES;
        public static final RefreshStatus NONE = new RefreshStatus("NONE", 0);
        public static final RefreshStatus FAILED = new RefreshStatus("FAILED", 1);
        public static final RefreshStatus SUCCESS = new RefreshStatus("SUCCESS", 2);

        private static final /* synthetic */ RefreshStatus[] $values() {
            return new RefreshStatus[]{NONE, FAILED, SUCCESS};
        }

        @NotNull
        public static EnumEntries<RefreshStatus> getEntries() {
            return $ENTRIES;
        }

        public static RefreshStatus valueOf(String str) {
            return (RefreshStatus) Enum.valueOf(RefreshStatus.class, str);
        }

        public static RefreshStatus[] values() {
            return (RefreshStatus[]) $VALUES.clone();
        }

        private RefreshStatus(String str, int i) {
        }

        static {
            RefreshStatus[] refreshStatusArr$values = $values();
            $VALUES = refreshStatusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(refreshStatusArr$values);
        }
    }
}
