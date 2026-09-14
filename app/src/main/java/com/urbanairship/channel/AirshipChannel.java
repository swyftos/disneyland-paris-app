package com.urbanairship.channel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.app.SimpleApplicationListener;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.AuthTokenProvider;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import com.urbanairship.locale.LocaleChangedListener;
import com.urbanairship.locale.LocaleManager;
import com.urbanairship.permission.PermissionsManager;
import com.urbanairship.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@OpenForTesting
@Metadata(m1835d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 u2\u00020\u0001:\u0002uvBG\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bw\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020$H\u0016J\u0010\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u000201H\u0017J\u000e\u0010P\u001a\u00020QH\u0097@¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0012J\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020LH\u0016J\"\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0A0@H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010RJ\u0014\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0A0bH\u0016J\b\u0010c\u001a\u00020UH\u0017J\u0010\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020fH\u0014J\u0018\u0010g\u001a\u00020h2\u0006\u0010e\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0017J\u0010\u0010k\u001a\u00020L2\u0006\u0010M\u001a\u00020$H\u0016J\u0010\u0010l\u001a\u00020L2\u0006\u0010O\u001a\u000201H\u0017J\u0010\u0010m\u001a\u00020L2\u0006\u0010n\u001a\u00020oH\u0017J\b\u0010p\u001a\u00020LH\u0017J\u001a\u0010q\u001a\u00020r*\u0002012\u0006\u0010s\u001a\u00020rH\u0096@¢\u0006\u0002\u0010tR\u000e\u0010 \u001a\u00020!X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0092\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u00020&8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0*X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\u0013\u001a\u00020\u0014X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010#X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u0010\u001b\u001a\u00020\u001cX\u0092\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00104R\u0014\u0010;\u001a\u00020!8RX\u0092\u0004¢\u0006\u0006\u001a\u0004\b;\u00104R\u000e\u0010\u0019\u001a\u00020\u001aX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0092\u0004¢\u0006\u0002\n\u0000R&\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0A0@0?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u000e\u0010\u0015\u001a\u00020\u0016X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0092\u0004¢\u0006\u0002\n\u0000R0\u0010F\u001a\b\u0012\u0004\u0012\u00020+0A2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020+0A8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006w"}, m1836d2 = {"Lcom/urbanairship/channel/AirshipChannel;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "permissionsManager", "Lcom/urbanairship/permission/PermissionsManager;", "localeManager", "Lcom/urbanairship/locale/LocaleManager;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "channelRegistrar", "Lcom/urbanairship/channel/ChannelRegistrar;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/permission/PermissionsManager;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/channel/ChannelRegistrar;)V", "channelManager", "Lcom/urbanairship/channel/ChannelBatchUpdateManager;", "subscriptionsProvider", "Lcom/urbanairship/channel/SubscriptionsProvider;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "clock", "Lcom/urbanairship/util/Clock;", "updateDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/permission/PermissionsManager;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/channel/ChannelBatchUpdateManager;Lcom/urbanairship/channel/ChannelRegistrar;Lcom/urbanairship/channel/SubscriptionsProvider;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/job/JobDispatcher;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_isChannelCreationDelayEnabled", "", "airshipChannelListeners", "", "Lcom/urbanairship/channel/AirshipChannelListener;", "authTokenProvider", "Lcom/urbanairship/http/AuthTokenProvider;", "getAuthTokenProvider", "()Lcom/urbanairship/http/AuthTokenProvider;", "channelIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "getChannelIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "setChannelIdFlow", "(Lkotlinx/coroutines/flow/StateFlow;)V", "channelRegistrationPayloadExtenders", "Lcom/urbanairship/channel/AirshipChannel$Extender;", "channelTagRegistrationEnabled", "getChannelTagRegistrationEnabled", "()Z", "setChannelTagRegistrationEnabled", "(Z)V", "id", "getId", "()Ljava/lang/String;", "isChannelCreationDelayEnabled", "isRegistrationAllowed", "scope", "Lkotlinx/coroutines/CoroutineScope;", "subscriptions", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "", "getSubscriptions", "()Lkotlinx/coroutines/flow/Flow;", "tagLock", "Ljava/util/concurrent/locks/ReentrantLock;", FetchDeviceInfoAction.TAGS_KEY, "getTags", "()Ljava/util/Set;", "setTags", "(Ljava/util/Set;)V", "addChannelListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addChannelRegistrationPayloadExtender", "extender", "buildCraPayload", "Lcom/urbanairship/channel/ChannelRegistrationPayload;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchUpdateJob", "conflictStrategy", "", "editAttributes", "Lcom/urbanairship/channel/AttributeEditor;", "editSubscriptionLists", "Lcom/urbanairship/channel/SubscriptionListEditor;", "editTagGroups", "Lcom/urbanairship/channel/TagGroupsEditor;", "editTags", "Lcom/urbanairship/channel/TagEditor;", "enableChannelCreation", "fetchSubscriptionLists", "fetchSubscriptionLists-IoAF18A", "fetchSubscriptionListsPendingResult", "Lcom/urbanairship/PendingResult;", "getComponentGroup", "onAirshipReady", "airship", "Lcom/urbanairship/UAirship;", "onPerformJob", "Lcom/urbanairship/job/JobResult;", "jobInfo", "Lcom/urbanairship/job/JobInfo;", "removeChannelListener", "removeChannelRegistrationPayloadExtender", "trackLiveUpdateMutation", "mutation", "Lcom/urbanairship/channel/LiveUpdateMutation;", "updateRegistration", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;", "builder", "(Lcom/urbanairship/channel/AirshipChannel$Extender;Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Extender", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAirshipChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,634:1\n60#2:635\n63#2:639\n60#2:640\n63#2:644\n50#3:636\n55#3:638\n50#3:641\n55#3:643\n106#4:637\n106#4:642\n1603#5,9:645\n1855#5:654\n1856#5:656\n1612#5:657\n1855#5,2:658\n1#6:655\n1#6:660\n*S KotlinDebug\n*F\n+ 1 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n*L\n102#1:635\n102#1:639\n103#1:640\n103#1:644\n102#1:636\n102#1:638\n103#1:641\n103#1:643\n102#1:637\n103#1:642\n395#1:645,9\n395#1:654\n395#1:656\n395#1:657\n568#1:658,2\n395#1:655\n*E\n"})
public class AirshipChannel extends AirshipComponent {

    @NotNull
    public static final String ACTION_CHANNEL_CREATED = "com.urbanairship.CHANNEL_CREATED";
    private boolean _isChannelCreationDelayEnabled;
    private final ActivityMonitor activityMonitor;
    private final List airshipChannelListeners;
    private final AuthTokenProvider authTokenProvider;
    private StateFlow channelIdFlow;
    private final ChannelBatchUpdateManager channelManager;
    private final ChannelRegistrar channelRegistrar;
    private final List channelRegistrationPayloadExtenders;
    private boolean channelTagRegistrationEnabled;
    private final Clock clock;
    private final JobDispatcher jobDispatcher;
    private final LocaleManager localeManager;
    private final PermissionsManager permissionsManager;
    private final PrivacyManager privacyManager;
    private final AirshipRuntimeConfig runtimeConfig;
    private final CoroutineScope scope;
    private final Flow subscriptions;
    private final SubscriptionsProvider subscriptionsProvider;
    private final ReentrantLock tagLock;

    @Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/channel/AirshipChannel$Extender;", "", "Blocking", "Suspending", "Lcom/urbanairship/channel/AirshipChannel$Extender$Blocking;", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface Extender {

        @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/channel/AirshipChannel$Extender$Blocking;", "Lcom/urbanairship/channel/AirshipChannel$Extender;", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;", "builder", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public interface Blocking extends Extender {
            @NotNull
            ChannelRegistrationPayload.Builder extend(@NotNull ChannelRegistrationPayload.Builder builder);
        }

        @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "Lcom/urbanairship/channel/AirshipChannel$Extender;", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;", "builder", "(Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public interface Suspending extends Extender {
            @Nullable
            Object extend(@NotNull ChannelRegistrationPayload.Builder builder, @NotNull Continuation<? super ChannelRegistrationPayload.Builder> continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$buildCraPayload$1 */
    static final class C51731 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C51731(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AirshipChannel.buildCraPayload$suspendImpl(AirshipChannel.this, this);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public Object buildCraPayload(@NotNull Continuation<? super ChannelRegistrationPayload> continuation) {
        return buildCraPayload$suspendImpl(this, continuation);
    }

    @Nullable
    public Object extend(@NotNull Extender extender, @NotNull ChannelRegistrationPayload.Builder builder, @NotNull Continuation<? super ChannelRegistrationPayload.Builder> continuation) {
        return extend$suspendImpl(this, extender, builder, continuation);
    }

    /* JADX INFO: renamed from: fetchSubscriptionLists-IoAF18A, reason: not valid java name */
    public /* synthetic */ Object m5071fetchSubscriptionListsIoAF18A(Continuation continuation) {
        return m5070fetchSubscriptionListsIoAF18A$suspendImpl(this, continuation);
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AirshipChannel(Context context, PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig airshipRuntimeConfig, PrivacyManager privacyManager, PermissionsManager permissionsManager, LocaleManager localeManager, ChannelBatchUpdateManager channelBatchUpdateManager, ChannelRegistrar channelRegistrar, SubscriptionsProvider subscriptionsProvider, ActivityMonitor activityMonitor, JobDispatcher jobDispatcher, Clock clock, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        JobDispatcher jobDispatcher2;
        Clock clock2;
        ActivityMonitor activityMonitorShared = (i & 512) != 0 ? GlobalActivityMonitor.INSTANCE.shared(context) : activityMonitor;
        if ((i & 1024) != 0) {
            JobDispatcher jobDispatcherShared = JobDispatcher.shared(context);
            Intrinsics.checkNotNullExpressionValue(jobDispatcherShared, "shared(...)");
            jobDispatcher2 = jobDispatcherShared;
        } else {
            jobDispatcher2 = jobDispatcher;
        }
        if ((i & 2048) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, permissionsManager, localeManager, channelBatchUpdateManager, channelRegistrar, subscriptionsProvider, activityMonitorShared, jobDispatcher2, clock2, (i & 4096) != 0 ? AirshipDispatchers.INSTANCE.getIO() : coroutineDispatcher);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AirshipChannel(@NotNull Context context, @NotNull final PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager, @NotNull PermissionsManager permissionsManager, @NotNull LocaleManager localeManager, @NotNull ChannelBatchUpdateManager channelManager, @NotNull ChannelRegistrar channelRegistrar, @NotNull SubscriptionsProvider subscriptionsProvider, @NotNull ActivityMonitor activityMonitor, @NotNull JobDispatcher jobDispatcher, @NotNull Clock clock, @NotNull CoroutineDispatcher updateDispatcher) {
        super(context, dataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(permissionsManager, "permissionsManager");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(channelManager, "channelManager");
        Intrinsics.checkNotNullParameter(channelRegistrar, "channelRegistrar");
        Intrinsics.checkNotNullParameter(subscriptionsProvider, "subscriptionsProvider");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(jobDispatcher, "jobDispatcher");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(updateDispatcher, "updateDispatcher");
        this.runtimeConfig = runtimeConfig;
        this.privacyManager = privacyManager;
        this.permissionsManager = permissionsManager;
        this.localeManager = localeManager;
        this.channelManager = channelManager;
        this.channelRegistrar = channelRegistrar;
        this.subscriptionsProvider = subscriptionsProvider;
        this.activityMonitor = activityMonitor;
        this.jobDispatcher = jobDispatcher;
        this.clock = clock;
        this.airshipChannelListeners = new CopyOnWriteArrayList();
        this.tagLock = new ReentrantLock();
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(updateDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.scope = CoroutineScope;
        this.channelRegistrationPayloadExtenders = new CopyOnWriteArrayList();
        runtimeConfig.addConfigListener(new AirshipRuntimeConfig.ConfigChangeListener() { // from class: com.urbanairship.channel.AirshipChannel$$ExternalSyntheticLambda0
            @Override // com.urbanairship.config.AirshipRuntimeConfig.ConfigChangeListener
            public final void onConfigUpdated() {
                AirshipChannel._init_$lambda$2(this.f$0);
            }
        });
        this.authTokenProvider = new ChannelAuthTokenProvider(runtimeConfig, new Function0() { // from class: com.urbanairship.channel.AirshipChannel$authTokenProvider$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getId();
            }
        });
        this.channelTagRegistrationEnabled = true;
        this.channelIdFlow = channelRegistrar.getChannelIdFlow();
        this.subscriptions = subscriptionsProvider.getUpdates();
        String channelId$urbanairship_core_release = channelRegistrar.getChannelId$urbanairship_core_release();
        if (channelId$urbanairship_core_release != null && UALog.getLogLevel() < 7 && channelId$urbanairship_core_release.length() > 0) {
            Log.d(UAirship.getAppName() + " Channel ID", channelId$urbanairship_core_release);
        }
        channelRegistrar.setPayloadBuilder(new C51716(null));
        this._isChannelCreationDelayEnabled = channelRegistrar.getChannelId$urbanairship_core_release() == null && runtimeConfig.getConfigOptions().channelCreationDelayEnabled;
        privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.channel.AirshipChannel$$ExternalSyntheticLambda1
            @Override // com.urbanairship.PrivacyManager.Listener
            public final void onEnabledFeaturesChanged() {
                AirshipChannel._init_$lambda$5(this.f$0, dataStore);
            }
        });
        activityMonitor.addApplicationListener(new SimpleApplicationListener() { // from class: com.urbanairship.channel.AirshipChannel.8
            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onForeground(long time) {
                AirshipChannel.this.updateRegistration();
            }
        });
        localeManager.addListener(new LocaleChangedListener() { // from class: com.urbanairship.channel.AirshipChannel$$ExternalSyntheticLambda2
            @Override // com.urbanairship.locale.LocaleChangedListener
            public final void onLocaleChanged(Locale locale) {
                AirshipChannel._init_$lambda$6(this.f$0, locale);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C516710(channelRegistrar.getChannelId$urbanairship_core_release(), context, null), 3, null);
    }

    public AirshipChannel(@NotNull Context context, @NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull PrivacyManager privacyManager, @NotNull PermissionsManager permissionsManager, @NotNull LocaleManager localeManager, @NotNull AudienceOverridesProvider audienceOverridesProvider, @NotNull ChannelRegistrar channelRegistrar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(permissionsManager, "permissionsManager");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
        Intrinsics.checkNotNullParameter(channelRegistrar, "channelRegistrar");
        ChannelBatchUpdateManager channelBatchUpdateManager = new ChannelBatchUpdateManager(dataStore, runtimeConfig, audienceOverridesProvider);
        final StateFlow<String> channelIdFlow = channelRegistrar.getChannelIdFlow();
        Flow<String> flow = new Flow<String>() { // from class: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = channelIdFlow.collect(new C51812(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n*L\n1#1,222:1\n61#2:223\n62#2:225\n102#3:224\n*E\n"})
            public static final class C51812<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2", m1845f = "AirshipChannel.kt", m1846i = {}, m1847l = {JfifUtil.MARKER_APP1}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
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
                        return C51812.this.emit(null, this);
                    }
                }

                public C51812(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        String str = (String) obj;
                        if (str != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(str, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        final StateFlow<String> channelIdFlow2 = channelRegistrar.getChannelIdFlow();
        this(context, dataStore, runtimeConfig, privacyManager, permissionsManager, localeManager, channelBatchUpdateManager, channelRegistrar, new SubscriptionsProvider(runtimeConfig, privacyManager, flow, FlowKt.combine(new Flow<String>() { // from class: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = channelIdFlow2.collect(new C51822(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n*L\n1#1,222:1\n61#2:223\n62#2:225\n103#3:224\n*E\n"})
            public static final class C51822<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2", m1845f = "AirshipChannel.kt", m1846i = {}, m1847l = {JfifUtil.MARKER_APP1}, m1848m = "emit", m1849n = {}, m1850s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
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
                        return C51822.this.emit(null, this);
                    }
                }

                public C51822(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public final Object emit(Object obj, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    } else {
                        anonymousClass1 = new AnonymousClass1(continuation);
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        String str = (String) obj;
                        if (str != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(str, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }
        }, audienceOverridesProvider.getUpdates$urbanairship_core_release(), new C51703(audienceOverridesProvider, null))), null, null, null, null, 7680, null);
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$3 */
    static final class C51703 extends SuspendLambda implements Function3 {
        final /* synthetic */ AudienceOverridesProvider $audienceOverridesProvider;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51703(AudienceOverridesProvider audienceOverridesProvider, Continuation continuation) {
            super(3, continuation);
            this.$audienceOverridesProvider = audienceOverridesProvider;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m5072invokeOsBMiQA((String) obj, ((UInt) obj2).getData(), (Continuation) obj3);
        }

        /* JADX INFO: renamed from: invoke-OsBMiQA, reason: not valid java name */
        public final Object m5072invokeOsBMiQA(String str, int i, Continuation continuation) {
            C51703 c51703 = new C51703(this.$audienceOverridesProvider, continuation);
            c51703.L$0 = str;
            return c51703.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                AudienceOverridesProvider audienceOverridesProvider = this.$audienceOverridesProvider;
                this.label = 1;
                obj = AudienceOverridesProvider.channelOverrides$urbanairship_core_release$default(audienceOverridesProvider, str, null, this, 2, null);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(AirshipChannel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateRegistration();
    }

    @NotNull
    public AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public boolean getChannelTagRegistrationEnabled() {
        return this.channelTagRegistrationEnabled;
    }

    public void setChannelTagRegistrationEnabled(boolean z) {
        this.channelTagRegistrationEnabled = z;
    }

    /* JADX INFO: renamed from: isChannelCreationDelayEnabled, reason: from getter */
    public boolean get_isChannelCreationDelayEnabled() {
        return this._isChannelCreationDelayEnabled;
    }

    @NotNull
    public StateFlow<String> getChannelIdFlow() {
        return this.channelIdFlow;
    }

    public void setChannelIdFlow(@NotNull StateFlow<String> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.channelIdFlow = stateFlow;
    }

    @NotNull
    public Flow<Result<Set<String>>> getSubscriptions() {
        return this.subscriptions;
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$6 */
    static final class C51716 extends SuspendLambda implements Function1 {
        int label;

        C51716(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipChannel.this.new C51716(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C51716) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipChannel airshipChannel = AirshipChannel.this;
                this.label = 1;
                obj = airshipChannel.buildCraPayload(this);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(AirshipChannel this$0, PreferenceDataStore dataStore) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dataStore, "$dataStore");
        if (!this$0.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES)) {
            ReentrantLock reentrantLock = this$0.tagLock;
            reentrantLock.lock();
            try {
                dataStore.remove("com.urbanairship.push.TAGS");
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                this$0.channelManager.clearPending$urbanairship_core_release();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        this$0.updateRegistration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$6(AirshipChannel this$0, Locale it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.updateRegistration();
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$10 */
    static final class C516710 extends SuspendLambda implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $startedId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C516710(String str, Context context, Continuation continuation) {
            super(2, continuation);
            this.$startedId = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipChannel.this.new C516710(this.$startedId, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C516710) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final StateFlow<String> channelIdFlow = AirshipChannel.this.channelRegistrar.getChannelIdFlow();
                final Flow<String> flow = new Flow<String>() { // from class: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1
                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = channelIdFlow.collect(new C51692(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2 */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel$10\n*L\n1#1,222:1\n61#2:223\n62#2:225\n179#3:224\n*E\n"})
                    public static final class C51692<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2", m1845f = "AirshipChannel.kt", m1846i = {}, m1847l = {JfifUtil.MARKER_APP1}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
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
                                return C51692.this.emit(null, this);
                            }
                        }

                        public C51692(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                String str = (String) obj;
                                if (str != null) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(str, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                };
                final String str = this.$startedId;
                Flow<String> flow2 = new Flow<String>() { // from class: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1
                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new C51682(flowCollector, str), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2 */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel$10\n*L\n1#1,222:1\n22#2:223\n23#2:225\n180#3:224\n*E\n"})
                    public static final class C51682<T> implements FlowCollector {
                        final /* synthetic */ String $startedId$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2", m1845f = "AirshipChannel.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
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
                                return C51682.this.emit(null, this);
                            }
                        }

                        public C51682(FlowCollector flowCollector, String str) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$startedId$inlined = str;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public final Object emit(Object obj, @NotNull Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            if (continuation instanceof AnonymousClass1) {
                                anonymousClass1 = (AnonymousClass1) continuation;
                                int i = anonymousClass1.label;
                                if ((i & Integer.MIN_VALUE) != 0) {
                                    anonymousClass1.label = i - Integer.MIN_VALUE;
                                } else {
                                    anonymousClass1 = new AnonymousClass1(continuation);
                                }
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i2 = anonymousClass1.label;
                            if (i2 == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (!Intrinsics.areEqual((String) obj, this.$startedId$inlined)) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                };
                final AirshipChannel airshipChannel = AirshipChannel.this;
                final Context context = this.$context;
                FlowCollector<? super String> flowCollector = new FlowCollector() { // from class: com.urbanairship.channel.AirshipChannel.10.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(String str2, Continuation continuation) {
                        if (airshipChannel.runtimeConfig.getConfigOptions().extendedBroadcastsEnabled) {
                            Intent intentPutExtra = new Intent(AirshipChannel.ACTION_CHANNEL_CREATED).setPackage(UAirship.getPackageName()).addCategory(UAirship.getPackageName()).putExtra("channel_id", str2);
                            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
                            try {
                                context.sendBroadcast(intentPutExtra);
                            } catch (Exception e) {
                                UALog.m1747e(e, new Function0() { // from class: com.urbanairship.channel.AirshipChannel.10.3.1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Failed to send channel create intent";
                                    }
                                });
                            }
                        }
                        Iterator it = airshipChannel.airshipChannelListeners.iterator();
                        while (it.hasNext()) {
                            ((AirshipChannelListener) it.next()).onChannelCreated(str2);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow2.collect(flowCollector, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.AirshipComponent
    protected void onAirshipReady(@NotNull UAirship airship) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        super.onAirshipReady(airship);
        updateRegistration();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addChannelRegistrationPayloadExtender(@NotNull Extender extender) {
        Intrinsics.checkNotNullParameter(extender, "extender");
        this.channelRegistrationPayloadExtenders.add(extender);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void removeChannelRegistrationPayloadExtender(@NotNull Extender extender) {
        Intrinsics.checkNotNullParameter(extender, "extender");
        this.channelRegistrationPayloadExtenders.remove(extender);
    }

    private boolean isRegistrationAllowed() {
        if (getId() != null) {
            return true;
        }
        return !get_isChannelCreationDelayEnabled() && this.privacyManager.isAnyFeatureEnabled();
    }

    @Override // com.urbanairship.AirshipComponent
    @WorkerThread
    @NotNull
    public JobResult onPerformJob(@NotNull UAirship airship, @NotNull JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        if (isRegistrationAllowed()) {
            return (JobResult) BuildersKt__BuildersKt.runBlocking$default(null, new C51802(null), 1, null);
        }
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel.onPerformJob.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Channel registration is currently disabled.";
            }
        }, 1, null);
        return JobResult.SUCCESS;
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$onPerformJob$2 */
    static final class C51802 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C51802(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipChannel.this.new C51802(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C51802) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0067  */
        /* JADX WARN: Code duplicated, block: B:29:0x006a  */
        /* JADX WARN: Code duplicated, block: B:33:0x007a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            RegistrationResult registrationResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    registrationResult = (RegistrationResult) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    return JobResult.FAILURE;
                }
                if (registrationResult != RegistrationResult.NEEDS_UPDATE || AirshipChannel.this.channelManager.getHasPending$urbanairship_core_release()) {
                    AirshipChannel.this.dispatchUpdateJob(0);
                }
                return JobResult.SUCCESS;
            }
            ResultKt.throwOnFailure(obj);
            ChannelRegistrar channelRegistrar = AirshipChannel.this.channelRegistrar;
            this.label = 1;
            obj = channelRegistrar.updateRegistration$urbanairship_core_release(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            RegistrationResult registrationResult2 = (RegistrationResult) obj;
            if (registrationResult2 != RegistrationResult.FAILED) {
                String channelId$urbanairship_core_release = AirshipChannel.this.channelRegistrar.getChannelId$urbanairship_core_release();
                if (channelId$urbanairship_core_release == null) {
                    return JobResult.SUCCESS;
                }
                ChannelBatchUpdateManager channelBatchUpdateManager = AirshipChannel.this.channelManager;
                this.L$0 = registrationResult2;
                this.label = 2;
                Object objUploadPending$urbanairship_core_release = channelBatchUpdateManager.uploadPending$urbanairship_core_release(channelId$urbanairship_core_release, this);
                if (objUploadPending$urbanairship_core_release == coroutine_suspended) {
                    return coroutine_suspended;
                }
                registrationResult = registrationResult2;
                obj = objUploadPending$urbanairship_core_release;
                if (!((Boolean) obj).booleanValue()) {
                    return JobResult.FAILURE;
                }
                if (registrationResult != RegistrationResult.NEEDS_UPDATE) {
                    AirshipChannel.this.dispatchUpdateJob(0);
                } else {
                    AirshipChannel.this.dispatchUpdateJob(0);
                }
                return JobResult.SUCCESS;
            }
            return JobResult.FAILURE;
        }
    }

    @Nullable
    public String getId() {
        return this.channelRegistrar.getChannelId$urbanairship_core_release();
    }

    public void addChannelListener(@NotNull AirshipChannelListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.airshipChannelListeners.add(listener);
    }

    public void removeChannelListener(@NotNull AirshipChannelListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.airshipChannelListeners.remove(listener);
    }

    @NotNull
    public TagEditor editTags() {
        return new TagEditor() { // from class: com.urbanairship.channel.AirshipChannel.editTags.1
            @Override // com.urbanairship.channel.TagEditor
            protected void onApply(boolean clear, @NotNull Set<String> tagsToAdd, @NotNull Set<String> tagsToRemove) {
                Intrinsics.checkNotNullParameter(tagsToAdd, "tagsToAdd");
                Intrinsics.checkNotNullParameter(tagsToRemove, "tagsToRemove");
                ReentrantLock reentrantLock = AirshipChannel.this.tagLock;
                AirshipChannel airshipChannel = AirshipChannel.this;
                reentrantLock.lock();
                try {
                    if (!airshipChannel.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES)) {
                        UALog.w$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel$editTags$1$onApply$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "AirshipChannel - Unable to apply tag group edits when opted out of tags and attributes.";
                            }
                        }, 1, null);
                        return;
                    }
                    Set<String> linkedHashSet = clear ? new LinkedHashSet<>() : CollectionsKt.toMutableSet(airshipChannel.getTags());
                    linkedHashSet.addAll(tagsToAdd);
                    linkedHashSet.removeAll(tagsToRemove);
                    airshipChannel.setTags(linkedHashSet);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    reentrantLock.unlock();
                }
            }
        };
    }

    @NotNull
    public TagGroupsEditor editTagGroups() {
        return new TagGroupsEditor() { // from class: com.urbanairship.channel.AirshipChannel.editTagGroups.1
            @Override // com.urbanairship.channel.TagGroupsEditor
            protected boolean allowTagGroupChange(@NotNull final String tagGroup) {
                Intrinsics.checkNotNullParameter(tagGroup, "tagGroup");
                if (!AirshipChannel.this.getChannelTagRegistrationEnabled() || !Intrinsics.areEqual("device", tagGroup)) {
                    return true;
                }
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel$editTagGroups$1$allowTagGroupChange$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Unable to add tags to " + tagGroup + " tag group when `channelTagRegistrationEnabled` is true.";
                    }
                }, 1, null);
                return false;
            }

            @Override // com.urbanairship.channel.TagGroupsEditor
            protected void onApply(@NotNull List<? extends TagGroupsMutation> collapsedMutations) {
                Intrinsics.checkNotNullParameter(collapsedMutations, "collapsedMutations");
                if (!AirshipChannel.this.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES)) {
                    UALog.w$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel$editTagGroups$1$onApply$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Unable to apply channel tag edits when opted out of tags and attributes.";
                        }
                    }, 1, null);
                } else {
                    if (collapsedMutations.isEmpty()) {
                        return;
                    }
                    ChannelBatchUpdateManager.addUpdate$urbanairship_core_release$default(AirshipChannel.this.channelManager, collapsedMutations, null, null, null, 14, null);
                    AirshipChannel.this.updateRegistration();
                }
            }
        };
    }

    @NotNull
    public AttributeEditor editAttributes() {
        return new AttributeEditor(this.clock) { // from class: com.urbanairship.channel.AirshipChannel.editAttributes.1
            @Override // com.urbanairship.channel.AttributeEditor
            protected void onApply(@NotNull List<? extends AttributeMutation> mutations) {
                Intrinsics.checkNotNullParameter(mutations, "mutations");
                if (!AirshipChannel.this.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES)) {
                    UALog.w$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel$editAttributes$1$onApply$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "AirshipChannel - Unable to apply attribute edits when opted out of tags and attributes.";
                        }
                    }, 1, null);
                } else {
                    if (mutations.isEmpty()) {
                        return;
                    }
                    ChannelBatchUpdateManager.addUpdate$urbanairship_core_release$default(AirshipChannel.this.channelManager, null, mutations, null, null, 13, null);
                    AirshipChannel.this.updateRegistration();
                }
            }
        };
    }

    @NotNull
    public Set<String> getTags() {
        ReentrantLock reentrantLock = this.tagLock;
        reentrantLock.lock();
        try {
            if (!this.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES)) {
                Set<String> setEmptySet = SetsKt.emptySet();
                reentrantLock.unlock();
                return setEmptySet;
            }
            JsonList jsonListOptList = getDataStore().getJsonValue("com.urbanairship.push.TAGS").optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = jsonListOptList.iterator();
            while (it.hasNext()) {
                String string = it.next().getString();
                if (string != null) {
                    arrayList.add(string);
                }
            }
            Set set = CollectionsKt.toSet(arrayList);
            Set<String> setNormalizeTags = TagUtils.normalizeTags(set);
            Intrinsics.checkNotNullExpressionValue(setNormalizeTags, "normalizeTags(...)");
            if (set.size() != setNormalizeTags.size()) {
                setTags(setNormalizeTags);
            }
            reentrantLock.unlock();
            return setNormalizeTags;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void setTags(@NotNull Set<String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        ReentrantLock reentrantLock = this.tagLock;
        reentrantLock.lock();
        try {
            if (!this.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES)) {
                UALog.w$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel$tags$2$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "AirshipChannel - Unable to apply attribute edits when opted out of tags and attributes.";
                    }
                }, 1, null);
                reentrantLock.unlock();
                return;
            }
            Set setNormalizeTags = TagUtils.normalizeTags(tags);
            Intrinsics.checkNotNullExpressionValue(setNormalizeTags, "normalizeTags(...)");
            getDataStore().put("com.urbanairship.push.TAGS", JsonValue.wrapOpt(setNormalizeTags));
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            updateRegistration();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.channel.AirshipChannel$fetchSubscriptionListsPendingResult$1 */
    static final class C51781 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        Object L$0;
        int label;
        final /* synthetic */ AirshipChannel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C51781(PendingResult pendingResult, AirshipChannel airshipChannel, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = airshipChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C51781(this.$pendingResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C51781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            PendingResult pendingResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PendingResult pendingResult2 = this.$pendingResult;
                AirshipChannel airshipChannel = this.this$0;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object objM5071fetchSubscriptionListsIoAF18A = airshipChannel.m5071fetchSubscriptionListsIoAF18A(this);
                if (objM5071fetchSubscriptionListsIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM5071fetchSubscriptionListsIoAF18A;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            if (Result.m5282isFailureimpl(value)) {
                value = null;
            }
            pendingResult.setResult(value);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public PendingResult<Set<String>> fetchSubscriptionListsPendingResult() {
        PendingResult<Set<String>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C51781(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: fetchSubscriptionLists-IoAF18A$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m5070fetchSubscriptionListsIoAF18A$suspendImpl(AirshipChannel airshipChannel, Continuation continuation) {
        AirshipChannel$fetchSubscriptionLists$1 airshipChannel$fetchSubscriptionLists$1;
        if (continuation instanceof AirshipChannel$fetchSubscriptionLists$1) {
            airshipChannel$fetchSubscriptionLists$1 = (AirshipChannel$fetchSubscriptionLists$1) continuation;
            int i = airshipChannel$fetchSubscriptionLists$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                airshipChannel$fetchSubscriptionLists$1.label = i - Integer.MIN_VALUE;
            } else {
                airshipChannel$fetchSubscriptionLists$1 = new AirshipChannel$fetchSubscriptionLists$1(airshipChannel, continuation);
            }
        } else {
            airshipChannel$fetchSubscriptionLists$1 = new AirshipChannel$fetchSubscriptionLists$1(airshipChannel, continuation);
        }
        Object objFirst = airshipChannel$fetchSubscriptionLists$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = airshipChannel$fetchSubscriptionLists$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            SharedFlow<Result<Set<? extends String>>> updates = airshipChannel.subscriptionsProvider.getUpdates();
            airshipChannel$fetchSubscriptionLists$1.label = 1;
            objFirst = FlowKt.first(updates, airshipChannel$fetchSubscriptionLists$1);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFirst);
        }
        return ((Result) objFirst).getValue();
    }

    @NotNull
    public SubscriptionListEditor editSubscriptionLists() {
        return new SubscriptionListEditor(this.clock) { // from class: com.urbanairship.channel.AirshipChannel.editSubscriptionLists.1
            @Override // com.urbanairship.channel.SubscriptionListEditor
            protected void onApply(@NotNull List<? extends SubscriptionListMutation> collapsedMutations) {
                Intrinsics.checkNotNullParameter(collapsedMutations, "collapsedMutations");
                if (!AirshipChannel.this.privacyManager.isEnabled(PrivacyManager.Feature.TAGS_AND_ATTRIBUTES)) {
                    UALog.w$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel$editSubscriptionLists$1$onApply$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "AirshipChannel - Unable to apply subscription list edits when opted out of tags and attributes.";
                        }
                    }, 1, null);
                } else {
                    if (collapsedMutations.isEmpty()) {
                        return;
                    }
                    ChannelBatchUpdateManager.addUpdate$urbanairship_core_release$default(AirshipChannel.this.channelManager, null, null, collapsedMutations, null, 11, null);
                    AirshipChannel.this.updateRegistration();
                }
            }
        };
    }

    public void enableChannelCreation() {
        if (get_isChannelCreationDelayEnabled()) {
            this._isChannelCreationDelayEnabled = false;
            updateRegistration();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void trackLiveUpdateMutation(@NotNull LiveUpdateMutation mutation) {
        Intrinsics.checkNotNullParameter(mutation, "mutation");
        ChannelBatchUpdateManager.addUpdate$urbanairship_core_release$default(this.channelManager, null, null, null, CollectionsKt.listOf(mutation), 7, null);
        updateRegistration();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void updateRegistration() {
        dispatchUpdateJob(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchUpdateJob(int conflictStrategy) {
        if (isRegistrationAllowed() && this.runtimeConfig.isDeviceUrlAvailable()) {
            JobInfo jobInfoBuild = JobInfo.newBuilder().setAction("ACTION_UPDATE_CHANNEL").setNetworkAccessRequired(true).setAirshipComponent(AirshipChannel.class).setConflictStrategy(conflictStrategy).build();
            Intrinsics.checkNotNullExpressionValue(jobInfoBuild, "build(...)");
            this.jobDispatcher.dispatch(jobInfoBuild);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:44:0x010f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.urbanairship.channel.ChannelRegistrationPayload$Builder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ea -> B:39:0x00ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00fc -> B:43:0x0109). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    static /* synthetic */ java.lang.Object buildCraPayload$suspendImpl(com.urbanairship.channel.AirshipChannel r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instruction units count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.AirshipChannel.buildCraPayload$suspendImpl(com.urbanairship.channel.AirshipChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object extend$suspendImpl(AirshipChannel airshipChannel, Extender extender, ChannelRegistrationPayload.Builder builder, Continuation continuation) {
        if (extender instanceof Extender.Suspending) {
            return ((Extender.Suspending) extender).extend(builder, continuation);
        }
        if (extender instanceof Extender.Blocking) {
            return ((Extender.Blocking) extender).extend(builder);
        }
        throw new NoWhenBranchMatchedException();
    }
}
