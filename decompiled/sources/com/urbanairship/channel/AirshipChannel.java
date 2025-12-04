package com.urbanairship.channel;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
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
import com.urbanairship.channel.ChannelRegistrationPayload;
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
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 u2\u00020\u0001:\u0002uvBG\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bw\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020$H\u0016J\u0010\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u000201H\u0017J\u000e\u0010P\u001a\u00020QH\u0097@¢\u0006\u0002\u0010RJ\u0010\u0010S\u001a\u00020L2\u0006\u0010T\u001a\u00020UH\u0012J\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020LH\u0016J\"\u0010_\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0A0@H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010RJ\u0014\u0010a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0A0bH\u0016J\b\u0010c\u001a\u00020UH\u0017J\u0010\u0010d\u001a\u00020L2\u0006\u0010e\u001a\u00020fH\u0014J\u0018\u0010g\u001a\u00020h2\u0006\u0010e\u001a\u00020f2\u0006\u0010i\u001a\u00020jH\u0017J\u0010\u0010k\u001a\u00020L2\u0006\u0010M\u001a\u00020$H\u0016J\u0010\u0010l\u001a\u00020L2\u0006\u0010O\u001a\u000201H\u0017J\u0010\u0010m\u001a\u00020L2\u0006\u0010n\u001a\u00020oH\u0017J\b\u0010p\u001a\u00020LH\u0017J\u001a\u0010q\u001a\u00020r*\u0002012\u0006\u0010s\u001a\u00020rH\u0096@¢\u0006\u0002\u0010tR\u000e\u0010 \u001a\u00020!X\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0092\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\u00020&8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\"\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0*X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\u0013\u001a\u00020\u0014X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010#X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u0010\u001b\u001a\u00020\u001cX\u0092\u0004¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010:\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00104R\u0014\u0010;\u001a\u00020!8RX\u0092\u0004¢\u0006\u0006\u001a\u0004\b;\u00104R\u000e\u0010\u0019\u001a\u00020\u001aX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0092\u0004¢\u0006\u0002\n\u0000R&\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0A0@0?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u000e\u0010\u0015\u001a\u00020\u0016X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0092\u0004¢\u0006\u0002\n\u0000R0\u0010F\u001a\b\u0012\u0004\u0012\u00020+0A2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020+0A8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006w"}, d2 = {"Lcom/urbanairship/channel/AirshipChannel;", "Lcom/urbanairship/AirshipComponent;", "context", "Landroid/content/Context;", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "privacyManager", "Lcom/urbanairship/PrivacyManager;", "permissionsManager", "Lcom/urbanairship/permission/PermissionsManager;", "localeManager", "Lcom/urbanairship/locale/LocaleManager;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "channelRegistrar", "Lcom/urbanairship/channel/ChannelRegistrar;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/permission/PermissionsManager;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/channel/ChannelRegistrar;)V", "channelManager", "Lcom/urbanairship/channel/ChannelBatchUpdateManager;", "subscriptionsProvider", "Lcom/urbanairship/channel/SubscriptionsProvider;", "activityMonitor", "Lcom/urbanairship/app/ActivityMonitor;", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "clock", "Lcom/urbanairship/util/Clock;", "updateDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/permission/PermissionsManager;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/channel/ChannelBatchUpdateManager;Lcom/urbanairship/channel/ChannelRegistrar;Lcom/urbanairship/channel/SubscriptionsProvider;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/job/JobDispatcher;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_isChannelCreationDelayEnabled", "", "airshipChannelListeners", "", "Lcom/urbanairship/channel/AirshipChannelListener;", "authTokenProvider", "Lcom/urbanairship/http/AuthTokenProvider;", "getAuthTokenProvider", "()Lcom/urbanairship/http/AuthTokenProvider;", "channelIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "getChannelIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "setChannelIdFlow", "(Lkotlinx/coroutines/flow/StateFlow;)V", "channelRegistrationPayloadExtenders", "Lcom/urbanairship/channel/AirshipChannel$Extender;", "channelTagRegistrationEnabled", "getChannelTagRegistrationEnabled", "()Z", "setChannelTagRegistrationEnabled", "(Z)V", "id", "getId", "()Ljava/lang/String;", "isChannelCreationDelayEnabled", "isRegistrationAllowed", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "subscriptions", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "", "getSubscriptions", "()Lkotlinx/coroutines/flow/Flow;", "tagLock", "Ljava/util/concurrent/locks/ReentrantLock;", FetchDeviceInfoAction.TAGS_KEY, "getTags", "()Ljava/util/Set;", "setTags", "(Ljava/util/Set;)V", "addChannelListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addChannelRegistrationPayloadExtender", "extender", "buildCraPayload", "Lcom/urbanairship/channel/ChannelRegistrationPayload;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchUpdateJob", "conflictStrategy", "", "editAttributes", "Lcom/urbanairship/channel/AttributeEditor;", "editSubscriptionLists", "Lcom/urbanairship/channel/SubscriptionListEditor;", "editTagGroups", "Lcom/urbanairship/channel/TagGroupsEditor;", "editTags", "Lcom/urbanairship/channel/TagEditor;", "enableChannelCreation", "fetchSubscriptionLists", "fetchSubscriptionLists-IoAF18A", "fetchSubscriptionListsPendingResult", "Lcom/urbanairship/PendingResult;", "getComponentGroup", "onAirshipReady", "airship", "Lcom/urbanairship/UAirship;", "onPerformJob", "Lcom/urbanairship/job/JobResult;", "jobInfo", "Lcom/urbanairship/job/JobInfo;", "removeChannelListener", "removeChannelRegistrationPayloadExtender", "trackLiveUpdateMutation", "mutation", "Lcom/urbanairship/channel/LiveUpdateMutation;", "updateRegistration", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;", "builder", "(Lcom/urbanairship/channel/AirshipChannel$Extender;Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Extender", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAirshipChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,634:1\n60#2:635\n63#2:639\n60#2:640\n63#2:644\n50#3:636\n55#3:638\n50#3:641\n55#3:643\n106#4:637\n106#4:642\n1603#5,9:645\n1855#5:654\n1856#5:656\n1612#5:657\n1855#5,2:658\n1#6:655\n1#6:660\n*S KotlinDebug\n*F\n+ 1 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n*L\n102#1:635\n102#1:639\n103#1:640\n103#1:644\n102#1:636\n102#1:638\n103#1:641\n103#1:643\n102#1:637\n103#1:642\n395#1:645,9\n395#1:654\n395#1:656\n395#1:657\n568#1:658,2\n395#1:655\n*E\n"})
/* loaded from: classes5.dex */
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/channel/AirshipChannel$Extender;", "", "Blocking", "Suspending", "Lcom/urbanairship/channel/AirshipChannel$Extender$Blocking;", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface Extender {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/urbanairship/channel/AirshipChannel$Extender$Blocking;", "Lcom/urbanairship/channel/AirshipChannel$Extender;", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;", "builder", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public interface Blocking extends Extender {
            @NotNull
            ChannelRegistrationPayload.Builder extend(@NotNull ChannelRegistrationPayload.Builder builder);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "Lcom/urbanairship/channel/AirshipChannel$Extender;", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_EXTEND, "Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;", "builder", "(Lcom/urbanairship/channel/ChannelRegistrationPayload$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public interface Suspending extends Extender {
            @Nullable
            Object extend(@NotNull ChannelRegistrationPayload.Builder builder, @NotNull Continuation<? super ChannelRegistrationPayload.Builder> continuation);
        }
    }

    /* renamed from: com.urbanairship.channel.AirshipChannel$buildCraPayload$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
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

    /* renamed from: fetchSubscriptionLists-IoAF18A, reason: not valid java name */
    public /* synthetic */ Object m2829fetchSubscriptionListsIoAF18A(Continuation continuation) {
        return m2828fetchSubscriptionListsIoAF18A$suspendImpl(this, continuation);
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
        channelRegistrar.setPayloadBuilder(new AnonymousClass6(null));
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass10(channelRegistrar.getChannelId$urbanairship_core_release(), context, null), 3, null);
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
                Object objCollect = channelIdFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n*L\n1#1,222:1\n61#2:223\n62#2:225\n102#3:224\n*E\n"})
            /* renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2", f = "AirshipChannel.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        java.lang.String r5 = (java.lang.String) r5
                        if (r5 == 0) goto L43
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        final StateFlow<String> channelIdFlow2 = channelRegistrar.getChannelIdFlow();
        this(context, dataStore, runtimeConfig, privacyManager, permissionsManager, localeManager, channelBatchUpdateManager, channelRegistrar, new SubscriptionsProvider(runtimeConfig, privacyManager, flow, FlowKt.combine(new Flow<String>() { // from class: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = channelIdFlow2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel\n*L\n1#1,222:1\n61#2:223\n62#2:225\n103#3:224\n*E\n"})
            /* renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2", f = "AirshipChannel.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2$1 r0 = (com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2$1 r0 = new com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L43
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        java.lang.String r5 = (java.lang.String) r5
                        if (r5 == 0) goto L43
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.AirshipChannel$special$$inlined$mapNotNull$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, audienceOverridesProvider.getUpdates$urbanairship_core_release(), new AnonymousClass3(audienceOverridesProvider, null))), null, null, null, null, 7680, null);
    }

    /* renamed from: com.urbanairship.channel.AirshipChannel$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function3 {
        final /* synthetic */ AudienceOverridesProvider $audienceOverridesProvider;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AudienceOverridesProvider audienceOverridesProvider, Continuation continuation) {
            super(3, continuation);
            this.$audienceOverridesProvider = audienceOverridesProvider;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m2830invokeOsBMiQA((String) obj, ((UInt) obj2).getData(), (Continuation) obj3);
        }

        /* renamed from: invoke-OsBMiQA, reason: not valid java name */
        public final Object m2830invokeOsBMiQA(String str, int i, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$audienceOverridesProvider, continuation);
            anonymousClass3.L$0 = str;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
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

    /* renamed from: isChannelCreationDelayEnabled, reason: from getter */
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

    /* renamed from: com.urbanairship.channel.AirshipChannel$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function1 {
        int label;

        AnonymousClass6(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipChannel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* renamed from: com.urbanairship.channel.AirshipChannel$10, reason: invalid class name */
    static final class AnonymousClass10 extends SuspendLambda implements Function2 {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $startedId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(String str, Context context, Continuation continuation) {
            super(2, continuation);
            this.$startedId = str;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipChannel.this.new AnonymousClass10(this.$startedId, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        Object objCollect = channelIdFlow.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel$10\n*L\n1#1,222:1\n61#2:223\n62#2:225\n179#3:224\n*E\n"})
                    /* renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2", f = "AirshipChannel.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                        /* renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L43
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                java.lang.String r5 = (java.lang.String) r5
                                if (r5 == 0) goto L43
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L43
                                return r1
                            L43:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }
                };
                final String str = this.$startedId;
                Flow<String> flow2 = new Flow<String>() { // from class: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1
                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flow.collect(new AnonymousClass2(flowCollector, str), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipChannel.kt\ncom/urbanairship/channel/AirshipChannel$10\n*L\n1#1,222:1\n22#2:223\n23#2:225\n180#3:224\n*E\n"})
                    /* renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ String $startedId$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2", f = "AirshipChannel.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                        /* renamed from: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, String str) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$startedId$inlined = str;
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
                                boolean r0 = r6 instanceof com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1$2$1
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
                                kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                                r2 = r5
                                java.lang.String r2 = (java.lang.String) r2
                                java.lang.String r4 = r4.$startedId$inlined
                                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r4)
                                if (r4 != 0) goto L4a
                                r0.label = r3
                                java.lang.Object r4 = r6.emit(r5, r0)
                                if (r4 != r1) goto L4a
                                return r1
                            L4a:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.AirshipChannel$10$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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
                                UALog.e(e, new Function0() { // from class: com.urbanairship.channel.AirshipChannel.10.3.1
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
            return (JobResult) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass2(null), 1, null);
        }
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.channel.AirshipChannel.onPerformJob.1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Channel registration is currently disabled.";
            }
        }, 1, null);
        return JobResult.SUCCESS;
    }

    /* renamed from: com.urbanairship.channel.AirshipChannel$onPerformJob$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipChannel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r4.L$0
                com.urbanairship.channel.RegistrationResult r0 = (com.urbanairship.channel.RegistrationResult) r0
                kotlin.ResultKt.throwOnFailure(r5)
                goto L5f
            L16:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L34
            L22:
                kotlin.ResultKt.throwOnFailure(r5)
                com.urbanairship.channel.AirshipChannel r5 = com.urbanairship.channel.AirshipChannel.this
                com.urbanairship.channel.ChannelRegistrar r5 = com.urbanairship.channel.AirshipChannel.access$getChannelRegistrar$p(r5)
                r4.label = r3
                java.lang.Object r5 = r5.updateRegistration$urbanairship_core_release(r4)
                if (r5 != r0) goto L34
                return r0
            L34:
                com.urbanairship.channel.RegistrationResult r5 = (com.urbanairship.channel.RegistrationResult) r5
                com.urbanairship.channel.RegistrationResult r1 = com.urbanairship.channel.RegistrationResult.FAILED
                if (r5 != r1) goto L3d
                com.urbanairship.job.JobResult r4 = com.urbanairship.job.JobResult.FAILURE
                return r4
            L3d:
                com.urbanairship.channel.AirshipChannel r1 = com.urbanairship.channel.AirshipChannel.this
                com.urbanairship.channel.ChannelRegistrar r1 = com.urbanairship.channel.AirshipChannel.access$getChannelRegistrar$p(r1)
                java.lang.String r1 = r1.getChannelId$urbanairship_core_release()
                if (r1 != 0) goto L4c
                com.urbanairship.job.JobResult r4 = com.urbanairship.job.JobResult.SUCCESS
                return r4
            L4c:
                com.urbanairship.channel.AirshipChannel r3 = com.urbanairship.channel.AirshipChannel.this
                com.urbanairship.channel.ChannelBatchUpdateManager r3 = com.urbanairship.channel.AirshipChannel.access$getChannelManager$p(r3)
                r4.L$0 = r5
                r4.label = r2
                java.lang.Object r1 = r3.uploadPending$urbanairship_core_release(r1, r4)
                if (r1 != r0) goto L5d
                return r0
            L5d:
                r0 = r5
                r5 = r1
            L5f:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 != 0) goto L6a
                com.urbanairship.job.JobResult r4 = com.urbanairship.job.JobResult.FAILURE
                return r4
            L6a:
                com.urbanairship.channel.RegistrationResult r5 = com.urbanairship.channel.RegistrationResult.NEEDS_UPDATE
                if (r0 == r5) goto L7a
                com.urbanairship.channel.AirshipChannel r5 = com.urbanairship.channel.AirshipChannel.this
                com.urbanairship.channel.ChannelBatchUpdateManager r5 = com.urbanairship.channel.AirshipChannel.access$getChannelManager$p(r5)
                boolean r5 = r5.getHasPending$urbanairship_core_release()
                if (r5 == 0) goto L80
            L7a:
                com.urbanairship.channel.AirshipChannel r4 = com.urbanairship.channel.AirshipChannel.this
                r5 = 0
                com.urbanairship.channel.AirshipChannel.access$dispatchUpdateJob(r4, r5)
            L80:
                com.urbanairship.job.JobResult r4 = com.urbanairship.job.JobResult.SUCCESS
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.AirshipChannel.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
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
                return SetsKt.emptySet();
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
            return setNormalizeTags;
        } finally {
            reentrantLock.unlock();
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
                return;
            }
            Set setNormalizeTags = TagUtils.normalizeTags(tags);
            Intrinsics.checkNotNullExpressionValue(setNormalizeTags, "normalizeTags(...)");
            getDataStore().put("com.urbanairship.push.TAGS", JsonValue.wrapOpt(setNormalizeTags));
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            updateRegistration();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: com.urbanairship.channel.AirshipChannel$fetchSubscriptionListsPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C10701 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        Object L$0;
        int label;
        final /* synthetic */ AirshipChannel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10701(PendingResult pendingResult, AirshipChannel airshipChannel, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = airshipChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C10701(this.$pendingResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object objM2829fetchSubscriptionListsIoAF18A = airshipChannel.m2829fetchSubscriptionListsIoAF18A(this);
                if (objM2829fetchSubscriptionListsIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM2829fetchSubscriptionListsIoAF18A;
                pendingResult = pendingResult2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pendingResult = (PendingResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                value = ((Result) obj).getValue();
            }
            if (Result.m2973isFailureimpl(value)) {
                value = null;
            }
            pendingResult.setResult(value);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public PendingResult<Set<String>> fetchSubscriptionListsPendingResult() {
        PendingResult<Set<String>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C10701(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: fetchSubscriptionLists-IoAF18A$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m2828fetchSubscriptionListsIoAF18A$suspendImpl(com.urbanairship.channel.AirshipChannel r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof com.urbanairship.channel.AirshipChannel$fetchSubscriptionLists$1
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.channel.AirshipChannel$fetchSubscriptionLists$1 r0 = (com.urbanairship.channel.AirshipChannel$fetchSubscriptionLists$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.channel.AirshipChannel$fetchSubscriptionLists$1 r0 = new com.urbanairship.channel.AirshipChannel$fetchSubscriptionLists$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.urbanairship.channel.SubscriptionsProvider r4 = r4.subscriptionsProvider
            kotlinx.coroutines.flow.SharedFlow r4 = r4.getUpdates()
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.first(r4, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r4 = r5.getValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.AirshipChannel.m2828fetchSubscriptionListsIoAF18A$suspendImpl(com.urbanairship.channel.AirshipChannel, kotlin.coroutines.Continuation):java.lang.Object");
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.urbanairship.channel.ChannelRegistrationPayload$Builder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00ea -> B:39:0x00ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00fc -> B:43:0x0109). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object buildCraPayload$suspendImpl(com.urbanairship.channel.AirshipChannel r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 533
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
