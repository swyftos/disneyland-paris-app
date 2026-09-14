package com.urbanairship.contacts;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imageutils.JfifUtil;
import com.urbanairship.AirshipComponent;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PendingResult;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.PrivacyManager;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.app.ActivityMonitor;
import com.urbanairship.app.GlobalActivityMonitor;
import com.urbanairship.app.SimpleApplicationListener;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.AirshipChannelListener;
import com.urbanairship.channel.AttributeEditor;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.SmsValidationHandler;
import com.urbanairship.channel.TagGroupsEditor;
import com.urbanairship.channel.TagGroupsMutation;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.AuthTokenProvider;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.job.JobResult;
import com.urbanairship.json.JsonValue;
import com.urbanairship.locale.LocaleManager;
import com.urbanairship.push.PushListener;
import com.urbanairship.push.PushManager;
import com.urbanairship.push.PushMessage;
import com.urbanairship.remoteconfig.ContactConfig;
import com.urbanairship.util.Clock;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
@Metadata(m1835d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0014\b\u0017\u0018\u0000 ®\u00012\u00020\u0001:\u0002®\u0001B\u007f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fBQ\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\"J\u0010\u0010$\u001a\u00020#H\u0092@¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0012¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020&H\u0012¢\u0006\u0004\b)\u0010(J\u0010\u0010,\u001a\u00020*H\u0090@¢\u0006\u0004\b+\u0010%J\u000f\u0010.\u001a\u00020-H\u0017¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020&2\b\b\u0001\u00100\u001a\u00020#H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020&H\u0016¢\u0006\u0004\b3\u0010(J\u000f\u00104\u001a\u00020&H\u0016¢\u0006\u0004\b4\u0010(J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u001f\u0010;\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u00020&2\u0006\u0010=\u001a\u00020#2\u0006\u0010:\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010B\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010:\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u001f\u0010G\u001a\u00020&2\u0006\u0010D\u001a\u00020#2\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bG\u0010HJ!\u0010M\u001a\u00020&2\u0006\u0010J\u001a\u00020I2\b\b\u0002\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020&2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bO\u0010PJ \u0010R\u001a\u00020K2\u0006\u0010=\u001a\u00020#2\u0006\u0010Q\u001a\u00020#H\u0096@¢\u0006\u0004\bR\u0010SJ\u0019\u0010V\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b\\\u0010]J\u001f\u0010c\u001a\u00020b2\u0006\u0010_\u001a\u00020^2\u0006\u0010a\u001a\u00020`H\u0017¢\u0006\u0004\bc\u0010dJ.\u0010j\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0f0eH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bi\u0010%J)\u0010l\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g\u0018\u00010f0kH\u0016¢\u0006\u0004\bl\u0010mJ)\u0010n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g\u0018\u00010f0kH\u0017¢\u0006\u0004\bn\u0010mR\u0014\u0010\u0005\u001a\u00020\u00048\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010oR\u0014\u0010\u0007\u001a\u00020\u00068\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010pR\u0014\u0010\t\u001a\u00020\b8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\t\u0010qR\u0014\u0010\u000b\u001a\u00020\n8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010rR\u0014\u0010\r\u001a\u00020\f8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\r\u0010sR\u0014\u0010\u0011\u001a\u00020\u00108\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010tR\u0014\u0010\u0013\u001a\u00020\u00128\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010uR\u0014\u0010\u0015\u001a\u00020\u00148\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010vR\u0014\u0010\u0019\u001a\u00020\u00188\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010wR\u0014\u0010\u001b\u001a\u00020\u001a8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010xR\u001a\u0010z\u001a\u00020y8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u0015\u0010\u007f\u001a\u00020~8\u0012X\u0092\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0082\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010#0\u0081\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R)\u0010\u0088\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0087\u00010\u0086\u00018\u0010X\u0090\u0004¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R,\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0012X\u0092\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R3\u0010\u0097\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020I0\u0096\u00010e0\u0086\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0089\u0001\u001a\u0006\b\u0098\u0001\u0010\u008b\u0001R>\u0010\u0099\u0001\u001a!\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0f0e0\u0086\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u0089\u0001\u001a\u0006\b\u009a\u0001\u0010\u008b\u0001R,\u0010¡\u0001\u001a\u00030\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u009b\u00018R@RX\u0092\u000e¢\u0006\u0010\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010£\u0001\u001a\u00030\u009b\u00018RX\u0092\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u009e\u0001R\u0018\u0010¥\u0001\u001a\u00030\u009b\u00018RX\u0092\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010\u009e\u0001R\u0019\u0010¨\u0001\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010«\u0001\u001a\u0005\u0018\u00010\u0087\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010\u00ad\u0001\u001a\u0004\u0018\u00010#8WX\u0096\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010§\u0001\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006¯\u0001"}, m1836d2 = {"Lcom/urbanairship/contacts/Contact;", "Lcom/urbanairship/AirshipComponent;", "Landroid/content/Context;", "context", "Lcom/urbanairship/PreferenceDataStore;", "preferenceDataStore", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "config", "Lcom/urbanairship/PrivacyManager;", "privacyManager", "Lcom/urbanairship/channel/AirshipChannel;", "airshipChannel", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "audienceOverridesProvider", "Lcom/urbanairship/app/ActivityMonitor;", "activityMonitor", "Lcom/urbanairship/util/Clock;", "clock", "Lcom/urbanairship/contacts/ContactManager;", "contactManager", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "smsValidator", "Lcom/urbanairship/push/PushManager;", "pushManager", "Lcom/urbanairship/contacts/SubscriptionsProvider;", "subscriptionsProvider", "Lcom/urbanairship/contacts/ContactChannelsProvider;", "contactChannelsProvider", "Lkotlinx/coroutines/CoroutineDispatcher;", "subscriptionListDispatcher", "<init>", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/util/Clock;Lcom/urbanairship/contacts/ContactManager;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;Lcom/urbanairship/push/PushManager;Lcom/urbanairship/contacts/SubscriptionsProvider;Lcom/urbanairship/contacts/ContactChannelsProvider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lcom/urbanairship/locale/LocaleManager;", "localeManager", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/push/PushManager;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;)V", "", "stableVerifiedContactId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "checkPrivacyManager", "()V", "migrateNamedUser", "Lcom/urbanairship/contacts/StableContactInfo;", "stableContactInfo$urbanairship_core_release", "stableContactInfo", "", "getComponentGroup", "()I", "externalId", "identify", "(Ljava/lang/String;)V", "notifyRemoteLogin", "reset", "Lcom/urbanairship/channel/TagGroupsEditor;", "editTagGroups", "()Lcom/urbanairship/channel/TagGroupsEditor;", "address", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", "options", "registerEmail", "(Ljava/lang/String;Lcom/urbanairship/contacts/EmailRegistrationOptions;)V", "msisdn", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "registerSms", "(Ljava/lang/String;Lcom/urbanairship/contacts/SmsRegistrationOptions;)V", "Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;", "registerOpenChannel", "(Ljava/lang/String;Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;)V", "channelId", "Lcom/urbanairship/contacts/ChannelType;", "channelType", "associateChannel", "(Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;)V", "Lcom/urbanairship/contacts/ContactChannel;", "contactChannel", "", "optOut", "disassociateChannel", "(Lcom/urbanairship/contacts/ContactChannel;Z)V", "resendDoubleOptIn", "(Lcom/urbanairship/contacts/ContactChannel;)V", "sender", "validateSms", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbanairship/channel/SmsValidationHandler;", "handler", "setSmsValidationHandler", "(Lcom/urbanairship/channel/SmsValidationHandler;)V", "Lcom/urbanairship/channel/AttributeEditor;", "editAttributes", "()Lcom/urbanairship/channel/AttributeEditor;", "Lcom/urbanairship/contacts/ScopedSubscriptionListEditor;", "editSubscriptionLists", "()Lcom/urbanairship/contacts/ScopedSubscriptionListEditor;", "Lcom/urbanairship/UAirship;", "airship", "Lcom/urbanairship/job/JobInfo;", "jobInfo", "Lcom/urbanairship/job/JobResult;", "onPerformJob", "(Lcom/urbanairship/UAirship;Lcom/urbanairship/job/JobInfo;)Lcom/urbanairship/job/JobResult;", "Lkotlin/Result;", "", "", "Lcom/urbanairship/contacts/Scope;", "fetchSubscriptionLists-IoAF18A", "fetchSubscriptionLists", "Lcom/urbanairship/PendingResult;", "fetchSubscriptionListsPendingResult", "()Lcom/urbanairship/PendingResult;", "getSubscriptionLists", "Lcom/urbanairship/PreferenceDataStore;", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "Lcom/urbanairship/PrivacyManager;", "Lcom/urbanairship/channel/AirshipChannel;", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "Lcom/urbanairship/util/Clock;", "Lcom/urbanairship/contacts/ContactManager;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "Lcom/urbanairship/contacts/SubscriptionsProvider;", "Lcom/urbanairship/contacts/ContactChannelsProvider;", "Lcom/urbanairship/http/AuthTokenProvider;", "authTokenProvider", "Lcom/urbanairship/http/AuthTokenProvider;", "getAuthTokenProvider", "()Lcom/urbanairship/http/AuthTokenProvider;", "Lkotlinx/coroutines/CoroutineScope;", "subscriptionsScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/StateFlow;", "namedUserIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getNamedUserIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/contacts/ContactIdUpdate;", "contactIdUpdateFlow", "Lkotlinx/coroutines/flow/Flow;", "getContactIdUpdateFlow$urbanairship_core_release", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/contacts/ContactConflictListener;", "contactConflictListener", "Lcom/urbanairship/contacts/ContactConflictListener;", "getContactConflictListener", "()Lcom/urbanairship/contacts/ContactConflictListener;", "setContactConflictListener", "(Lcom/urbanairship/contacts/ContactConflictListener;)V", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "channelExtender", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "", "channelContacts", "getChannelContacts", "subscriptions", "getSubscriptions", "", "newValue", "getLastResolvedDate", "()J", "setLastResolvedDate", "(J)V", "lastResolvedDate", "getForegroundResolveInterval", "foregroundResolveInterval", "getChannelRegistrationMaxResolveAge", "channelRegistrationMaxResolveAge", "getNamedUserId", "()Ljava/lang/String;", "namedUserId", "getCurrentContactIdUpdate$urbanairship_core_release", "()Lcom/urbanairship/contacts/ContactIdUpdate;", "currentContactIdUpdate", "getLastContactId", "lastContactId", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public class Contact extends AirshipComponent {
    private static final String CONTACT_UPDATE_PUSH_KEY;
    private static final long CRA_MAX_AGE;
    private static final long FOREGROUND_INTERVAL;
    private final AirshipChannel airshipChannel;
    private final AudienceOverridesProvider audienceOverridesProvider;
    private final AuthTokenProvider authTokenProvider;
    private final Flow channelContacts;
    private final AirshipChannel.Extender.Suspending channelExtender;
    private final Clock clock;
    private final AirshipRuntimeConfig config;
    private final ContactChannelsProvider contactChannelsProvider;
    private ContactConflictListener contactConflictListener;
    private final Flow contactIdUpdateFlow;
    private final ContactManager contactManager;
    private final /* synthetic */ StateFlow namedUserIdFlow;
    private final PreferenceDataStore preferenceDataStore;
    private final PrivacyManager privacyManager;
    private final AirshipInputValidation.Validator smsValidator;
    private final Flow subscriptions;
    private final SubscriptionsProvider subscriptionsProvider;
    private final CoroutineScope subscriptionsScope;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String LEGACY_NAMED_USER_ID_KEY = "com.urbanairship.nameduser.NAMED_USER_ID_KEY";
    private static final String LEGACY_ATTRIBUTE_MUTATION_STORE_KEY = "com.urbanairship.nameduser.ATTRIBUTE_MUTATION_STORE_KEY";
    private static final String LEGACY_TAG_GROUP_MUTATIONS_KEY = "com.urbanairship.nameduser.PENDING_TAG_GROUP_MUTATIONS_KEY";
    private static final String ACTION_UPDATE_CONTACT = "ACTION_UPDATE_CONTACT";

    /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$stableVerifiedContactId$1 */
    static final class C52201 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C52201(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Contact.this.stableVerifiedContactId(this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$validateSms$1 */
    static final class C52211 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C52211(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Contact.validateSms$suspendImpl(Contact.this, null, null, this);
        }
    }

    /* JADX INFO: renamed from: fetchSubscriptionLists-IoAF18A, reason: not valid java name */
    public /* synthetic */ Object m5082fetchSubscriptionListsIoAF18A(Continuation continuation) {
        return m5081fetchSubscriptionListsIoAF18A$suspendImpl(this, continuation);
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getComponentGroup() {
        return 9;
    }

    @Nullable
    public Object stableContactInfo$urbanairship_core_release(@NotNull Continuation<? super StableContactInfo> continuation) {
        return stableContactInfo$suspendImpl(this, continuation);
    }

    @Nullable
    public Object validateSms(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Boolean> continuation) {
        return validateSms$suspendImpl(this, str, str2, continuation);
    }

    public /* synthetic */ Contact(Context context, PreferenceDataStore preferenceDataStore, AirshipRuntimeConfig airshipRuntimeConfig, PrivacyManager privacyManager, AirshipChannel airshipChannel, AudienceOverridesProvider audienceOverridesProvider, ActivityMonitor activityMonitor, Clock clock, ContactManager contactManager, AirshipInputValidation.Validator validator, PushManager pushManager, SubscriptionsProvider subscriptionsProvider, ContactChannelsProvider contactChannelsProvider, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, preferenceDataStore, airshipRuntimeConfig, privacyManager, airshipChannel, audienceOverridesProvider, activityMonitor, clock, contactManager, validator, pushManager, (i & 2048) != 0 ? new SubscriptionsProvider(airshipRuntimeConfig, privacyManager, ContactKt.getStableContactIdUpdates(contactManager), ContactKt.contactUpdates(audienceOverridesProvider, ContactKt.getStableContactIdUpdates(contactManager))) : subscriptionsProvider, (i & 4096) != 0 ? new ContactChannelsProvider(airshipRuntimeConfig, privacyManager, ContactKt.getStableContactIdUpdates(contactManager), ContactKt.contactUpdates(audienceOverridesProvider, ContactKt.getStableContactIdUpdates(contactManager))) : contactChannelsProvider, (i & 8192) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Contact(@NotNull Context context, @NotNull PreferenceDataStore preferenceDataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel airshipChannel, @NotNull AudienceOverridesProvider audienceOverridesProvider, @NotNull ActivityMonitor activityMonitor, @NotNull Clock clock, @NotNull ContactManager contactManager, @NotNull AirshipInputValidation.Validator smsValidator, @NotNull PushManager pushManager, @NotNull SubscriptionsProvider subscriptionsProvider, @NotNull ContactChannelsProvider contactChannelsProvider, @NotNull CoroutineDispatcher subscriptionListDispatcher) {
        super(context, preferenceDataStore);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
        Intrinsics.checkNotNullParameter(activityMonitor, "activityMonitor");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(contactManager, "contactManager");
        Intrinsics.checkNotNullParameter(smsValidator, "smsValidator");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(subscriptionsProvider, "subscriptionsProvider");
        Intrinsics.checkNotNullParameter(contactChannelsProvider, "contactChannelsProvider");
        Intrinsics.checkNotNullParameter(subscriptionListDispatcher, "subscriptionListDispatcher");
        this.preferenceDataStore = preferenceDataStore;
        this.config = config;
        this.privacyManager = privacyManager;
        this.airshipChannel = airshipChannel;
        this.audienceOverridesProvider = audienceOverridesProvider;
        this.clock = clock;
        this.contactManager = contactManager;
        this.smsValidator = smsValidator;
        this.subscriptionsProvider = subscriptionsProvider;
        this.contactChannelsProvider = contactChannelsProvider;
        this.authTokenProvider = contactManager;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(subscriptionListDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.subscriptionsScope = CoroutineScope;
        this.namedUserIdFlow = contactManager.getCurrentNamedUserIdUpdates();
        this.contactIdUpdateFlow = contactManager.getContactIdUpdates();
        Contact$channelExtender$1 contact$channelExtender$1 = new Contact$channelExtender$1(this);
        this.channelExtender = contact$channelExtender$1;
        migrateNamedUser();
        activityMonitor.addApplicationListener(new SimpleApplicationListener() { // from class: com.urbanairship.contacts.Contact.1
            @Override // com.urbanairship.app.SimpleApplicationListener, com.urbanairship.app.ApplicationListener
            public void onForeground(long time) {
                if (Contact.this.clock.currentTimeMillis() >= Contact.this.getLastResolvedDate() + Contact.this.getForegroundResolveInterval()) {
                    if (ContactKt.isContactsEnabled(Contact.this.privacyManager)) {
                        Contact.this.contactManager.addOperation$urbanairship_core_release(ContactOperation.Resolve.INSTANCE);
                    }
                    Contact contact = Contact.this;
                    contact.setLastResolvedDate(contact.clock.currentTimeMillis());
                }
                Contact.this.contactChannelsProvider.refresh();
            }
        });
        pushManager.addInternalPushListener(new PushListener() { // from class: com.urbanairship.contacts.Contact$$ExternalSyntheticLambda0
            @Override // com.urbanairship.push.PushListener
            public final void onPushReceived(PushMessage pushMessage, boolean z) {
                Contact._init_$lambda$0(this.f$0, pushMessage, z);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C52033(null), 3, null);
        airshipChannel.addChannelListener(new AirshipChannelListener() { // from class: com.urbanairship.contacts.Contact$$ExternalSyntheticLambda1
            @Override // com.urbanairship.channel.AirshipChannelListener
            public final void onChannelCreated(String str) {
                Contact._init_$lambda$1(this.f$0, str);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new C52045(null), 3, null);
        airshipChannel.addChannelRegistrationPayloadExtender(contact$channelExtender$1);
        privacyManager.addListener(new PrivacyManager.Listener() { // from class: com.urbanairship.contacts.Contact$$ExternalSyntheticLambda2
            @Override // com.urbanairship.PrivacyManager.Listener
            public final void onEnabledFeaturesChanged() {
                Contact._init_$lambda$2(this.f$0);
            }
        });
        checkPrivacyManager();
        contactManager.setEnabled$urbanairship_core_release(true);
        this.channelContacts = contactChannelsProvider.getUpdates();
        this.subscriptions = subscriptionsProvider.getUpdates();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Contact(@NotNull Context context, @NotNull PreferenceDataStore preferenceDataStore, @NotNull AirshipRuntimeConfig config, @NotNull PrivacyManager privacyManager, @NotNull AirshipChannel airshipChannel, @NotNull LocaleManager localeManager, @NotNull AudienceOverridesProvider audienceOverridesProvider, @NotNull PushManager pushManager, @NotNull AirshipInputValidation.Validator smsValidator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(privacyManager, "privacyManager");
        Intrinsics.checkNotNullParameter(airshipChannel, "airshipChannel");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
        Intrinsics.checkNotNullParameter(pushManager, "pushManager");
        Intrinsics.checkNotNullParameter(smsValidator, "smsValidator");
        GlobalActivityMonitor globalActivityMonitorShared = GlobalActivityMonitor.INSTANCE.shared(context);
        Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        JobDispatcher jobDispatcherShared = JobDispatcher.shared(context);
        Intrinsics.checkNotNullExpressionValue(jobDispatcherShared, "shared(...)");
        CoroutineDispatcher coroutineDispatcher = null;
        byte b = 0 == true ? 1 : 0;
        SubscriptionsProvider subscriptionsProvider = null;
        ContactChannelsProvider contactChannelsProvider = null;
        CoroutineDispatcher coroutineDispatcher2 = null;
        this(context, preferenceDataStore, config, privacyManager, airshipChannel, audienceOverridesProvider, globalActivityMonitorShared, DEFAULT_CLOCK, new ContactManager(preferenceDataStore, airshipChannel, jobDispatcherShared, new ContactApiClient(config, null, null, 6, null), localeManager, audienceOverridesProvider, b, coroutineDispatcher, 192, null), smsValidator, pushManager, subscriptionsProvider, contactChannelsProvider, coroutineDispatcher2, 14336, null);
    }

    @NotNull
    public AuthTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    @NotNull
    public StateFlow<String> getNamedUserIdFlow() {
        return this.namedUserIdFlow;
    }

    @NotNull
    public Flow<ContactIdUpdate> getContactIdUpdateFlow$urbanairship_core_release() {
        return this.contactIdUpdateFlow;
    }

    @Nullable
    public ContactConflictListener getContactConflictListener() {
        return this.contactConflictListener;
    }

    public void setContactConflictListener(@Nullable ContactConflictListener contactConflictListener) {
        this.contactConflictListener = contactConflictListener;
    }

    @Nullable
    public String getNamedUserId() {
        return this.contactManager.getNamedUserId$urbanairship_core_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLastResolvedDate() {
        return this.preferenceDataStore.getLong("com.urbanairship.contacts.LAST_RESOLVED_DATE_KEY", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastResolvedDate(long j) {
        this.preferenceDataStore.put("com.urbanairship.contacts.LAST_RESOLVED_DATE_KEY", j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getForegroundResolveInterval() {
        Long foregroundIntervalMs;
        ContactConfig contactConfig = this.config.getRemoteConfig().getContactConfig();
        return (contactConfig == null || (foregroundIntervalMs = contactConfig.getForegroundIntervalMs()) == null) ? FOREGROUND_INTERVAL : foregroundIntervalMs.longValue();
    }

    private long getChannelRegistrationMaxResolveAge() {
        Long channelRegistrationMaxResolveAgeMs;
        ContactConfig contactConfig = this.config.getRemoteConfig().getContactConfig();
        return (contactConfig == null || (channelRegistrationMaxResolveAgeMs = contactConfig.getChannelRegistrationMaxResolveAgeMs()) == null) ? CRA_MAX_AGE : channelRegistrationMaxResolveAgeMs.longValue();
    }

    @Nullable
    public ContactIdUpdate getCurrentContactIdUpdate$urbanairship_core_release() {
        return this.contactManager.getCurrentContactIdUpdate$urbanairship_core_release();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Nullable
    public String getLastContactId() {
        return this.contactManager.getLastContactId();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    static /* synthetic */ Object stableContactInfo$suspendImpl(Contact contact, Continuation continuation) {
        Contact$stableContactInfo$1 contact$stableContactInfo$1;
        if (continuation instanceof Contact$stableContactInfo$1) {
            contact$stableContactInfo$1 = (Contact$stableContactInfo$1) continuation;
            int i = contact$stableContactInfo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contact$stableContactInfo$1.label = i - Integer.MIN_VALUE;
            } else {
                contact$stableContactInfo$1 = new Contact$stableContactInfo$1(contact, continuation);
            }
        } else {
            contact$stableContactInfo$1 = new Contact$stableContactInfo$1(contact, continuation);
        }
        Contact$stableContactInfo$1 contact$stableContactInfo$2 = contact$stableContactInfo$1;
        Object objStableContactIdUpdate$urbanairship_core_release$default = contact$stableContactInfo$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contact$stableContactInfo$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objStableContactIdUpdate$urbanairship_core_release$default);
            ContactManager contactManager = contact.contactManager;
            contact$stableContactInfo$2.label = 1;
            objStableContactIdUpdate$urbanairship_core_release$default = ContactManager.stableContactIdUpdate$urbanairship_core_release$default(contactManager, 0L, contact$stableContactInfo$2, 1, null);
            if (objStableContactIdUpdate$urbanairship_core_release$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objStableContactIdUpdate$urbanairship_core_release$default);
        }
        return ((ContactIdUpdate) objStableContactIdUpdate$urbanairship_core_release$default).toContactInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object stableVerifiedContactId(Continuation continuation) {
        C52201 c52201;
        if (continuation instanceof C52201) {
            c52201 = (C52201) continuation;
            int i = c52201.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52201.label = i - Integer.MIN_VALUE;
            } else {
                c52201 = new C52201(continuation);
            }
        } else {
            c52201 = new C52201(continuation);
        }
        Object objStableContactIdUpdate$urbanairship_core_release$default = c52201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52201.label;
        if (i2 != 0) {
            if (i2 == 1) {
                this = (Contact) c52201.L$0;
                ResultKt.throwOnFailure(objStableContactIdUpdate$urbanairship_core_release$default);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objStableContactIdUpdate$urbanairship_core_release$default);
            }
            return ((ContactIdUpdate) objStableContactIdUpdate$urbanairship_core_release$default).getContactId();
        }
        ResultKt.throwOnFailure(objStableContactIdUpdate$urbanairship_core_release$default);
        ContactManager contactManager = this.contactManager;
        c52201.L$0 = this;
        c52201.label = 1;
        objStableContactIdUpdate$urbanairship_core_release$default = ContactManager.stableContactIdUpdate$urbanairship_core_release$default(contactManager, 0L, c52201, 1, null);
        if (objStableContactIdUpdate$urbanairship_core_release$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        ContactIdUpdate contactIdUpdate = (ContactIdUpdate) objStableContactIdUpdate$urbanairship_core_release$default;
        if (this.clock.currentTimeMillis() - contactIdUpdate.getResolveDateMs() <= this.getChannelRegistrationMaxResolveAge()) {
            return contactIdUpdate.getContactId();
        }
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Verify(jCurrentTimeMillis, false, 2, null));
        ContactManager contactManager2 = this.contactManager;
        c52201.L$0 = null;
        c52201.label = 2;
        objStableContactIdUpdate$urbanairship_core_release$default = contactManager2.stableContactIdUpdate$urbanairship_core_release(jCurrentTimeMillis, c52201);
        if (objStableContactIdUpdate$urbanairship_core_release$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        return ((ContactIdUpdate) objStableContactIdUpdate$urbanairship_core_release$default).getContactId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Contact this$0, PushMessage message, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.containsKey(CONTACT_UPDATE_PUSH_KEY)) {
            this$0.contactChannelsProvider.refresh();
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$3 */
    static final class C52033 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C52033(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Contact.this.new C52033(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52033) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0037 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:14:0x0040  */
        /* JADX WARN: Code duplicated, block: B:16:0x004e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:12:0x0038). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:14:0x0040
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r1 = r4.L$0
                kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
                kotlin.ResultKt.throwOnFailure(r5)
                goto L38
            L13:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                com.urbanairship.contacts.Contact r5 = com.urbanairship.contacts.Contact.this
                com.urbanairship.contacts.ContactManager r5 = com.urbanairship.contacts.Contact.access$getContactManager$p(r5)
                kotlinx.coroutines.channels.Channel r5 = r5.getConflictEvents()
                kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
                r1 = r5
            L2d:
                r4.L$0 = r1
                r4.label = r2
                java.lang.Object r5 = r1.hasNext(r4)
                if (r5 != r0) goto L38
                return r0
            L38:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L52
                java.lang.Object r5 = r1.next()
                com.urbanairship.contacts.ConflictEvent r5 = (com.urbanairship.contacts.ConflictEvent) r5
                com.urbanairship.contacts.Contact r3 = com.urbanairship.contacts.Contact.this
                com.urbanairship.contacts.ContactConflictListener r3 = r3.getContactConflictListener()
                if (r3 == 0) goto L2d
                r3.onConflict(r5)
                goto L2d
            L52:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact.C52033.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(Contact this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ContactKt.isContactsEnabled(this$0.privacyManager)) {
            this$0.contactManager.addOperation$urbanairship_core_release(ContactOperation.Resolve.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$5 */
    static final class C52045 extends SuspendLambda implements Function2 {
        int label;

        C52045(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Contact.this.new C52045(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52045) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flowDrop = FlowKt.drop(Contact.this.contactManager.getContactIdUpdates(), 1);
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<String>() { // from class: com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1
                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flowDrop.collect(new C52052(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2 */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Contact.kt\ncom/urbanairship/contacts/Contact$5\n*L\n1#1,222:1\n61#2:223\n62#2:225\n233#3:224\n*E\n"})
                    public static final class C52052<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2", m1845f = "Contact.kt", m1846i = {}, m1847l = {JfifUtil.MARKER_APP1}, m1848m = "emit", m1849n = {}, m1850s = {})
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
                                return C52052.this.emit(null, this);
                            }
                        }

                        public C52052(FlowCollector flowCollector) {
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
                                ContactIdUpdate contactIdUpdate = (ContactIdUpdate) obj;
                                String contactId = contactIdUpdate != null ? contactIdUpdate.getContactId() : null;
                                if (contactId != null) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(contactId, anonymousClass1) == coroutine_suspended) {
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
                });
                final Contact contact = Contact.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.contacts.Contact.5.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(String str, Continuation continuation) {
                        contact.airshipChannel.updateRegistration();
                        return Unit.INSTANCE;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(Contact this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.checkPrivacyManager();
    }

    private void checkPrivacyManager() {
        if (this.privacyManager.isAnyFeatureEnabled()) {
            this.contactManager.generateDefaultContactIdIfNotSet$urbanairship_core_release();
        }
        if (ContactKt.isContactsEnabled(this.privacyManager)) {
            return;
        }
        this.contactManager.resetIfNeeded$urbanairship_core_release();
    }

    private void migrateNamedUser() {
        if (ContactKt.isContactsEnabled(this.privacyManager)) {
            String string = this.preferenceDataStore.getString(LEGACY_NAMED_USER_ID_KEY, null);
            if (string == null) {
                this.contactManager.generateDefaultContactIdIfNotSet$urbanairship_core_release();
            } else {
                identify(string);
                if (ContactKt.isContactsAudienceEnabled(this.privacyManager)) {
                    JsonValue jsonValue = this.preferenceDataStore.getJsonValue(LEGACY_ATTRIBUTE_MUTATION_STORE_KEY);
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "getJsonValue(...)");
                    List<AttributeMutation> listFromJsonList = AttributeMutation.fromJsonList(jsonValue.optList());
                    Intrinsics.checkNotNullExpressionValue(listFromJsonList, "fromJsonList(...)");
                    List<AttributeMutation> listCollapseMutations = AttributeMutation.collapseMutations(listFromJsonList);
                    Intrinsics.checkNotNullExpressionValue(listCollapseMutations, "collapseMutations(...)");
                    JsonValue jsonValue2 = this.preferenceDataStore.getJsonValue(LEGACY_TAG_GROUP_MUTATIONS_KEY);
                    Intrinsics.checkNotNullExpressionValue(jsonValue2, "getJsonValue(...)");
                    List<TagGroupsMutation> listFromJsonList2 = TagGroupsMutation.fromJsonList(jsonValue2.optList());
                    Intrinsics.checkNotNullExpressionValue(listFromJsonList2, "fromJsonList(...)");
                    List<TagGroupsMutation> listCollapseMutations2 = TagGroupsMutation.collapseMutations(listFromJsonList2);
                    Intrinsics.checkNotNullExpressionValue(listCollapseMutations2, "collapseMutations(...)");
                    if (!listCollapseMutations.isEmpty() || !listCollapseMutations2.isEmpty()) {
                        this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Update(listCollapseMutations2, listCollapseMutations, null, 4, null));
                    }
                }
            }
        }
        this.preferenceDataStore.remove(LEGACY_TAG_GROUP_MUTATIONS_KEY);
        this.preferenceDataStore.remove(LEGACY_ATTRIBUTE_MUTATION_STORE_KEY);
        this.preferenceDataStore.remove(LEGACY_NAMED_USER_ID_KEY);
    }

    public void identify(@Size(max = 128, min = 1) @NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, "externalId");
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.identify.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Contacts is disabled, ignoring contact identifying.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Identify(externalId));
        }
    }

    public void notifyRemoteLogin() {
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.notifyRemoteLogin.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Contacts is disabled, ignoring contact remote-login request.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Verify(this.clock.currentTimeMillis(), true));
        }
    }

    public void reset() {
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.reset.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Contacts is disabled, ignoring contact reset.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(ContactOperation.Reset.INSTANCE);
        }
    }

    @NotNull
    public TagGroupsEditor editTagGroups() {
        return new TagGroupsEditor() { // from class: com.urbanairship.contacts.Contact.editTagGroups.1
            @Override // com.urbanairship.channel.TagGroupsEditor
            protected void onApply(@NotNull List<? extends TagGroupsMutation> collapsedMutations) {
                Intrinsics.checkNotNullParameter(collapsedMutations, "collapsedMutations");
                super.onApply(collapsedMutations);
                if (!ContactKt.isContactsAudienceEnabled(Contact.this.privacyManager)) {
                    UALog.w$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact$editTagGroups$1$onApply$1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Ignoring contact tag edits while contacts and/or tags and attributes are disabled.";
                        }
                    }, 1, null);
                } else {
                    if (collapsedMutations.isEmpty()) {
                        return;
                    }
                    Contact.this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Update(collapsedMutations, null, null, 6, null));
                    Contact.this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
                }
            }
        };
    }

    public void registerEmail(@NotNull String address, @NotNull EmailRegistrationOptions options) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.registerEmail.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Ignoring Email registration while contacts are disabled.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.RegisterEmail(address, options));
            this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
        }
    }

    public void registerSms(@NotNull String msisdn, @NotNull SmsRegistrationOptions options) {
        Intrinsics.checkNotNullParameter(msisdn, "msisdn");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.registerSms.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Ignoring SMS registration while contacts are disabled.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.RegisterSms(msisdn, options));
            this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
        }
    }

    public void registerOpenChannel(@NotNull String address, @NotNull OpenChannelRegistrationOptions options) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.registerOpenChannel.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Ignoring open channel registration while contacts are disabled.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.RegisterOpen(address, options));
            this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
        }
    }

    public void associateChannel(@NotNull String channelId, @NotNull ChannelType channelType) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(channelType, "channelType");
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.associateChannel.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Ignoring associate channel request while contacts are disabled.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.AssociateChannel(channelId, channelType));
            this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
        }
    }

    public static /* synthetic */ void disassociateChannel$default(Contact contact, ContactChannel contactChannel, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disassociateChannel");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        contact.disassociateChannel(contactChannel, z);
    }

    public void disassociateChannel(@NotNull ContactChannel contactChannel, boolean optOut) {
        Intrinsics.checkNotNullParameter(contactChannel, "contactChannel");
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.disassociateChannel.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Ignoring disassociate channel request while contacts are disabled.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.DisassociateChannel(contactChannel, optOut));
            this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
        }
    }

    public void resendDoubleOptIn(@NotNull ContactChannel contactChannel) {
        Intrinsics.checkNotNullParameter(contactChannel, "contactChannel");
        if (!ContactKt.isContactsEnabled(this.privacyManager)) {
            UALog.w$default(null, new Function0() { // from class: com.urbanairship.contacts.Contact.resendDoubleOptIn.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Ignoring resend double opt-in request while contacts are disabled.";
                }
            }, 1, null);
        } else {
            this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Resend(contactChannel));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    static /* synthetic */ Object validateSms$suspendImpl(Contact contact, String str, String str2, Continuation continuation) {
        C52211 c52211;
        if (continuation instanceof C52211) {
            c52211 = (C52211) continuation;
            int i = c52211.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52211.label = i - Integer.MIN_VALUE;
            } else {
                c52211 = contact.new C52211(continuation);
            }
        } else {
            c52211 = contact.new C52211(continuation);
        }
        Object objValidate = c52211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52211.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objValidate);
            AirshipInputValidation.Validator validator = contact.smsValidator;
            AirshipInputValidation.Request.ValidateSms validateSms = new AirshipInputValidation.Request.ValidateSms(new AirshipInputValidation.Request.Sms(str, new AirshipInputValidation.Request.Sms.ValidationOptions.Sender(str2, null, 2, null), null, 4, null));
            c52211.label = 1;
            objValidate = validator.validate(validateSms, c52211);
            if (objValidate == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objValidate);
        }
        AirshipInputValidation.Result result = (AirshipInputValidation.Result) objValidate;
        if (Intrinsics.areEqual(result, AirshipInputValidation.Result.Invalid.INSTANCE)) {
            z = false;
        } else if (!(result instanceof AirshipInputValidation.Result.Valid)) {
            throw new NoWhenBranchMatchedException();
        }
        return Boxing.boxBoolean(z);
    }

    public void setSmsValidationHandler(@Nullable SmsValidationHandler handler) {
        this.smsValidator.setLegacySmsDelegate(handler);
    }

    @NotNull
    public AttributeEditor editAttributes() {
        return new AttributeEditor(this.clock) { // from class: com.urbanairship.contacts.Contact.editAttributes.1
            @Override // com.urbanairship.channel.AttributeEditor
            protected void onApply(@NotNull List<? extends AttributeMutation> collapsedMutations) {
                Intrinsics.checkNotNullParameter(collapsedMutations, "collapsedMutations");
                if (!ContactKt.isContactsAudienceEnabled(Contact.this.privacyManager)) {
                    UALog.m1754w("Contact - Ignoring tag edits while contacts and/or tags and attributes are disabled.", new Object[0]);
                } else {
                    if (collapsedMutations.isEmpty()) {
                        return;
                    }
                    Contact.this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Update(null, collapsedMutations, null, 5, null));
                    Contact.this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
                }
            }
        };
    }

    @NotNull
    public ScopedSubscriptionListEditor editSubscriptionLists() {
        return new ScopedSubscriptionListEditor(this.clock) { // from class: com.urbanairship.contacts.Contact.editSubscriptionLists.1
            @Override // com.urbanairship.contacts.ScopedSubscriptionListEditor
            protected void onApply(@NotNull List<? extends ScopedSubscriptionListMutation> mutations) {
                Intrinsics.checkNotNullParameter(mutations, "mutations");
                if (!ContactKt.isContactsAudienceEnabled(Contact.this.privacyManager)) {
                    UALog.m1754w("Contact - Ignoring subscription list edits while contacts and/or tags and attributes are disabled.", new Object[0]);
                } else {
                    if (mutations.isEmpty()) {
                        return;
                    }
                    Contact.this.contactManager.addOperation$urbanairship_core_release(new ContactOperation.Update(null, null, mutations, 3, null));
                    Contact.this.audienceOverridesProvider.notifyPendingChanged$urbanairship_core_release();
                }
            }
        };
    }

    @Override // com.urbanairship.AirshipComponent
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @WorkerThread
    @NotNull
    public JobResult onPerformJob(@NotNull UAirship airship, @NotNull JobInfo jobInfo) {
        Intrinsics.checkNotNullParameter(airship, "airship");
        Intrinsics.checkNotNullParameter(jobInfo, "jobInfo");
        if (Intrinsics.areEqual(ACTION_UPDATE_CONTACT, jobInfo.getAction())) {
            return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new Contact$onPerformJob$result$1(this, null), 1, null)).booleanValue() ? JobResult.SUCCESS : JobResult.FAILURE;
        }
        return JobResult.SUCCESS;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: fetchSubscriptionLists-IoAF18A$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m5081fetchSubscriptionListsIoAF18A$suspendImpl(Contact contact, Continuation continuation) {
        Contact$fetchSubscriptionLists$1 contact$fetchSubscriptionLists$1;
        if (continuation instanceof Contact$fetchSubscriptionLists$1) {
            contact$fetchSubscriptionLists$1 = (Contact$fetchSubscriptionLists$1) continuation;
            int i = contact$fetchSubscriptionLists$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contact$fetchSubscriptionLists$1.label = i - Integer.MIN_VALUE;
            } else {
                contact$fetchSubscriptionLists$1 = new Contact$fetchSubscriptionLists$1(contact, continuation);
            }
        } else {
            contact$fetchSubscriptionLists$1 = new Contact$fetchSubscriptionLists$1(contact, continuation);
        }
        Object objFirst = contact$fetchSubscriptionLists$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contact$fetchSubscriptionLists$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirst);
            SharedFlow<Result<Map<String, ? extends Set<? extends Scope>>>> updates = contact.subscriptionsProvider.getUpdates();
            contact$fetchSubscriptionLists$1.label = 1;
            objFirst = FlowKt.first(updates, contact$fetchSubscriptionLists$1);
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
    public Flow<Result<List<ContactChannel>>> getChannelContacts() {
        return this.channelContacts;
    }

    @NotNull
    public Flow<Result<Map<String, Set<Scope>>>> getSubscriptions() {
        return this.subscriptions;
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$fetchSubscriptionListsPendingResult$1 */
    static final class C52111 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        Object L$0;
        int label;
        final /* synthetic */ Contact this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52111(PendingResult pendingResult, Contact contact, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = contact;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C52111(this.$pendingResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Contact contact = this.this$0;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object objM5082fetchSubscriptionListsIoAF18A = contact.m5082fetchSubscriptionListsIoAF18A(this);
                if (objM5082fetchSubscriptionListsIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM5082fetchSubscriptionListsIoAF18A;
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
    public PendingResult<Map<String, Set<Scope>>> fetchSubscriptionListsPendingResult() {
        PendingResult<Map<String, Set<Scope>>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.subscriptionsScope, null, null, new C52111(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.Contact$getSubscriptionLists$1 */
    static final class C52121 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        Object L$0;
        int label;
        final /* synthetic */ Contact this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52121(PendingResult pendingResult, Contact contact, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = contact;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C52121(this.$pendingResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Contact contact = this.this$0;
                this.L$0 = pendingResult2;
                this.label = 1;
                Object objM5082fetchSubscriptionListsIoAF18A = contact.m5082fetchSubscriptionListsIoAF18A(this);
                if (objM5082fetchSubscriptionListsIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM5082fetchSubscriptionListsIoAF18A;
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

    @Deprecated(message = "Use fetchSubscriptionListsPendingResult() instead")
    @NotNull
    public PendingResult<Map<String, Set<Scope>>> getSubscriptionLists() {
        PendingResult<Map<String, Set<Scope>>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.subscriptionsScope, null, null, new C52121(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    @Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, m1836d2 = {"Lcom/urbanairship/contacts/Contact$Companion;", "", "()V", "ACTION_UPDATE_CONTACT", "", "getACTION_UPDATE_CONTACT$urbanairship_core_release$annotations", "getACTION_UPDATE_CONTACT$urbanairship_core_release", "()Ljava/lang/String;", "CONTACT_UPDATE_PUSH_KEY", "CRA_MAX_AGE", "", "FOREGROUND_INTERVAL", "LAST_RESOLVED_DATE_KEY", "LEGACY_ATTRIBUTE_MUTATION_STORE_KEY", "getLEGACY_ATTRIBUTE_MUTATION_STORE_KEY$urbanairship_core_release$annotations", "getLEGACY_ATTRIBUTE_MUTATION_STORE_KEY$urbanairship_core_release", "LEGACY_NAMED_USER_ID_KEY", "getLEGACY_NAMED_USER_ID_KEY$urbanairship_core_release$annotations", "getLEGACY_NAMED_USER_ID_KEY$urbanairship_core_release", "LEGACY_TAG_GROUP_MUTATIONS_KEY", "getLEGACY_TAG_GROUP_MUTATIONS_KEY$urbanairship_core_release$annotations", "getLEGACY_TAG_GROUP_MUTATIONS_KEY$urbanairship_core_release", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getACTION_UPDATE_CONTACT$urbanairship_core_release$annotations() {
        }

        @VisibleForTesting
        /* JADX INFO: renamed from: getLEGACY_ATTRIBUTE_MUTATION_STORE_KEY$urbanairship_core_release$annotations */
        public static /* synthetic */ void m1766xadd7991c() {
        }

        @VisibleForTesting
        /* JADX INFO: renamed from: getLEGACY_NAMED_USER_ID_KEY$urbanairship_core_release$annotations */
        public static /* synthetic */ void m1767xf2c00f37() {
        }

        @VisibleForTesting
        /* JADX INFO: renamed from: getLEGACY_TAG_GROUP_MUTATIONS_KEY$urbanairship_core_release$annotations */
        public static /* synthetic */ void m1768x74d1b373() {
        }

        private Companion() {
        }

        @NotNull
        public final String getLEGACY_NAMED_USER_ID_KEY$urbanairship_core_release() {
            return Contact.LEGACY_NAMED_USER_ID_KEY;
        }

        @NotNull
        public final String getLEGACY_ATTRIBUTE_MUTATION_STORE_KEY$urbanairship_core_release() {
            return Contact.LEGACY_ATTRIBUTE_MUTATION_STORE_KEY;
        }

        @NotNull
        public final String getLEGACY_TAG_GROUP_MUTATIONS_KEY$urbanairship_core_release() {
            return Contact.LEGACY_TAG_GROUP_MUTATIONS_KEY;
        }

        @NotNull
        public final String getACTION_UPDATE_CONTACT$urbanairship_core_release() {
            return Contact.ACTION_UPDATE_CONTACT;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        FOREGROUND_INTERVAL = timeUnit.toMillis(60L);
        CRA_MAX_AGE = timeUnit.toMillis(10L);
        CONTACT_UPDATE_PUSH_KEY = "com.urbanairship.contact.update";
    }
}
