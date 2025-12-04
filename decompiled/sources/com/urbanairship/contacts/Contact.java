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
import com.urbanairship.contacts.ContactOperation;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0014\b\u0017\u0018\u0000 ®\u00012\u00020\u0001:\u0002®\u0001B\u007f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fBQ\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\"J\u0010\u0010$\u001a\u00020#H\u0092@¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0012¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020&H\u0012¢\u0006\u0004\b)\u0010(J\u0010\u0010,\u001a\u00020*H\u0090@¢\u0006\u0004\b+\u0010%J\u000f\u0010.\u001a\u00020-H\u0017¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020&2\b\b\u0001\u00100\u001a\u00020#H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020&H\u0016¢\u0006\u0004\b3\u0010(J\u000f\u00104\u001a\u00020&H\u0016¢\u0006\u0004\b4\u0010(J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107J\u001f\u0010;\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u00020&2\u0006\u0010=\u001a\u00020#2\u0006\u0010:\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010B\u001a\u00020&2\u0006\u00108\u001a\u00020#2\u0006\u0010:\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u001f\u0010G\u001a\u00020&2\u0006\u0010D\u001a\u00020#2\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bG\u0010HJ!\u0010M\u001a\u00020&2\u0006\u0010J\u001a\u00020I2\b\b\u0002\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020&2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bO\u0010PJ \u0010R\u001a\u00020K2\u0006\u0010=\u001a\u00020#2\u0006\u0010Q\u001a\u00020#H\u0096@¢\u0006\u0004\bR\u0010SJ\u0019\u0010V\u001a\u00020&2\b\u0010U\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010Y\u001a\u00020XH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b\\\u0010]J\u001f\u0010c\u001a\u00020b2\u0006\u0010_\u001a\u00020^2\u0006\u0010a\u001a\u00020`H\u0017¢\u0006\u0004\bc\u0010dJ.\u0010j\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0f0eH\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bi\u0010%J)\u0010l\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g\u0018\u00010f0kH\u0016¢\u0006\u0004\bl\u0010mJ)\u0010n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g\u0018\u00010f0kH\u0017¢\u0006\u0004\bn\u0010mR\u0014\u0010\u0005\u001a\u00020\u00048\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010oR\u0014\u0010\u0007\u001a\u00020\u00068\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010pR\u0014\u0010\t\u001a\u00020\b8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\t\u0010qR\u0014\u0010\u000b\u001a\u00020\n8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010rR\u0014\u0010\r\u001a\u00020\f8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\r\u0010sR\u0014\u0010\u0011\u001a\u00020\u00108\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010tR\u0014\u0010\u0013\u001a\u00020\u00128\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010uR\u0014\u0010\u0015\u001a\u00020\u00148\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010vR\u0014\u0010\u0019\u001a\u00020\u00188\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010wR\u0014\u0010\u001b\u001a\u00020\u001a8\u0012X\u0092\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010xR\u001a\u0010z\u001a\u00020y8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u0015\u0010\u007f\u001a\u00020~8\u0012X\u0092\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0082\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010#0\u0081\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R)\u0010\u0088\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0087\u00010\u0086\u00018\u0010X\u0090\u0004¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R,\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0012X\u0092\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R3\u0010\u0097\u0001\u001a\u0016\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020I0\u0096\u00010e0\u0086\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0097\u0001\u0010\u0089\u0001\u001a\u0006\b\u0098\u0001\u0010\u008b\u0001R>\u0010\u0099\u0001\u001a!\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020h0g0f0e0\u0086\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010\u0089\u0001\u001a\u0006\b\u009a\u0001\u0010\u008b\u0001R,\u0010¡\u0001\u001a\u00030\u009b\u00012\b\u0010\u009c\u0001\u001a\u00030\u009b\u00018R@RX\u0092\u000e¢\u0006\u0010\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010£\u0001\u001a\u00030\u009b\u00018RX\u0092\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010\u009e\u0001R\u0018\u0010¥\u0001\u001a\u00030\u009b\u00018RX\u0092\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010\u009e\u0001R\u0019\u0010¨\u0001\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u001a\u0010«\u0001\u001a\u0005\u0018\u00010\u0087\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001R\u0019\u0010\u00ad\u0001\u001a\u0004\u0018\u00010#8WX\u0096\u0004¢\u0006\b\u001a\u0006\b¬\u0001\u0010§\u0001\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006¯\u0001"}, d2 = {"Lcom/urbanairship/contacts/Contact;", "Lcom/urbanairship/AirshipComponent;", "Landroid/content/Context;", "context", "Lcom/urbanairship/PreferenceDataStore;", "preferenceDataStore", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "config", "Lcom/urbanairship/PrivacyManager;", "privacyManager", "Lcom/urbanairship/channel/AirshipChannel;", "airshipChannel", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "audienceOverridesProvider", "Lcom/urbanairship/app/ActivityMonitor;", "activityMonitor", "Lcom/urbanairship/util/Clock;", "clock", "Lcom/urbanairship/contacts/ContactManager;", "contactManager", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "smsValidator", "Lcom/urbanairship/push/PushManager;", "pushManager", "Lcom/urbanairship/contacts/SubscriptionsProvider;", "subscriptionsProvider", "Lcom/urbanairship/contacts/ContactChannelsProvider;", "contactChannelsProvider", "Lkotlinx/coroutines/CoroutineDispatcher;", "subscriptionListDispatcher", "<init>", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/app/ActivityMonitor;Lcom/urbanairship/util/Clock;Lcom/urbanairship/contacts/ContactManager;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;Lcom/urbanairship/push/PushManager;Lcom/urbanairship/contacts/SubscriptionsProvider;Lcom/urbanairship/contacts/ContactChannelsProvider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lcom/urbanairship/locale/LocaleManager;", "localeManager", "(Landroid/content/Context;Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/PrivacyManager;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/push/PushManager;Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;)V", "", "stableVerifiedContactId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "checkPrivacyManager", "()V", "migrateNamedUser", "Lcom/urbanairship/contacts/StableContactInfo;", "stableContactInfo$urbanairship_core_release", "stableContactInfo", "", "getComponentGroup", "()I", "externalId", "identify", "(Ljava/lang/String;)V", "notifyRemoteLogin", "reset", "Lcom/urbanairship/channel/TagGroupsEditor;", "editTagGroups", "()Lcom/urbanairship/channel/TagGroupsEditor;", "address", "Lcom/urbanairship/contacts/EmailRegistrationOptions;", "options", "registerEmail", "(Ljava/lang/String;Lcom/urbanairship/contacts/EmailRegistrationOptions;)V", "msisdn", "Lcom/urbanairship/contacts/SmsRegistrationOptions;", "registerSms", "(Ljava/lang/String;Lcom/urbanairship/contacts/SmsRegistrationOptions;)V", "Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;", "registerOpenChannel", "(Ljava/lang/String;Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;)V", "channelId", "Lcom/urbanairship/contacts/ChannelType;", "channelType", "associateChannel", "(Ljava/lang/String;Lcom/urbanairship/contacts/ChannelType;)V", "Lcom/urbanairship/contacts/ContactChannel;", "contactChannel", "", "optOut", "disassociateChannel", "(Lcom/urbanairship/contacts/ContactChannel;Z)V", "resendDoubleOptIn", "(Lcom/urbanairship/contacts/ContactChannel;)V", "sender", "validateSms", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/urbanairship/channel/SmsValidationHandler;", "handler", "setSmsValidationHandler", "(Lcom/urbanairship/channel/SmsValidationHandler;)V", "Lcom/urbanairship/channel/AttributeEditor;", "editAttributes", "()Lcom/urbanairship/channel/AttributeEditor;", "Lcom/urbanairship/contacts/ScopedSubscriptionListEditor;", "editSubscriptionLists", "()Lcom/urbanairship/contacts/ScopedSubscriptionListEditor;", "Lcom/urbanairship/UAirship;", "airship", "Lcom/urbanairship/job/JobInfo;", "jobInfo", "Lcom/urbanairship/job/JobResult;", "onPerformJob", "(Lcom/urbanairship/UAirship;Lcom/urbanairship/job/JobInfo;)Lcom/urbanairship/job/JobResult;", "Lkotlin/Result;", "", "", "Lcom/urbanairship/contacts/Scope;", "fetchSubscriptionLists-IoAF18A", "fetchSubscriptionLists", "Lcom/urbanairship/PendingResult;", "fetchSubscriptionListsPendingResult", "()Lcom/urbanairship/PendingResult;", "getSubscriptionLists", "Lcom/urbanairship/PreferenceDataStore;", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "Lcom/urbanairship/PrivacyManager;", "Lcom/urbanairship/channel/AirshipChannel;", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "Lcom/urbanairship/util/Clock;", "Lcom/urbanairship/contacts/ContactManager;", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Validator;", "Lcom/urbanairship/contacts/SubscriptionsProvider;", "Lcom/urbanairship/contacts/ContactChannelsProvider;", "Lcom/urbanairship/http/AuthTokenProvider;", "authTokenProvider", "Lcom/urbanairship/http/AuthTokenProvider;", "getAuthTokenProvider", "()Lcom/urbanairship/http/AuthTokenProvider;", "Lkotlinx/coroutines/CoroutineScope;", "subscriptionsScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/StateFlow;", "namedUserIdFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getNamedUserIdFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/contacts/ContactIdUpdate;", "contactIdUpdateFlow", "Lkotlinx/coroutines/flow/Flow;", "getContactIdUpdateFlow$urbanairship_core_release", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/contacts/ContactConflictListener;", "contactConflictListener", "Lcom/urbanairship/contacts/ContactConflictListener;", "getContactConflictListener", "()Lcom/urbanairship/contacts/ContactConflictListener;", "setContactConflictListener", "(Lcom/urbanairship/contacts/ContactConflictListener;)V", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "channelExtender", "Lcom/urbanairship/channel/AirshipChannel$Extender$Suspending;", "", "channelContacts", "getChannelContacts", "subscriptions", "getSubscriptions", "", "newValue", "getLastResolvedDate", "()J", "setLastResolvedDate", "(J)V", "lastResolvedDate", "getForegroundResolveInterval", "foregroundResolveInterval", "getChannelRegistrationMaxResolveAge", "channelRegistrationMaxResolveAge", "getNamedUserId", "()Ljava/lang/String;", "namedUserId", "getCurrentContactIdUpdate$urbanairship_core_release", "()Lcom/urbanairship/contacts/ContactIdUpdate;", "currentContactIdUpdate", "getLastContactId", "lastContactId", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
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

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String LEGACY_NAMED_USER_ID_KEY = "com.urbanairship.nameduser.NAMED_USER_ID_KEY";
    private static final String LEGACY_ATTRIBUTE_MUTATION_STORE_KEY = "com.urbanairship.nameduser.ATTRIBUTE_MUTATION_STORE_KEY";
    private static final String LEGACY_TAG_GROUP_MUTATIONS_KEY = "com.urbanairship.nameduser.PENDING_TAG_GROUP_MUTATIONS_KEY";
    private static final String ACTION_UPDATE_CONTACT = "ACTION_UPDATE_CONTACT";

    /* renamed from: com.urbanairship.contacts.Contact$stableVerifiedContactId$1, reason: invalid class name and case insensitive filesystem */
    static final class C10931 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10931(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Contact.this.stableVerifiedContactId(this);
        }
    }

    /* renamed from: com.urbanairship.contacts.Contact$validateSms$1, reason: invalid class name and case insensitive filesystem */
    static final class C10941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10941(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Contact.validateSms$suspendImpl(Contact.this, null, null, this);
        }
    }

    /* renamed from: fetchSubscriptionLists-IoAF18A, reason: not valid java name */
    public /* synthetic */ Object m2840fetchSubscriptionListsIoAF18A(Continuation continuation) {
        return m2839fetchSubscriptionListsIoAF18A$suspendImpl(this, continuation);
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass3(null), 3, null);
        airshipChannel.addChannelListener(new AirshipChannelListener() { // from class: com.urbanairship.contacts.Contact$$ExternalSyntheticLambda1
            @Override // com.urbanairship.channel.AirshipChannelListener
            public final void onChannelCreated(String str) {
                Contact._init_$lambda$1(this.f$0, str);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass5(null), 3, null);
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

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object stableContactInfo$suspendImpl(com.urbanairship.contacts.Contact r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof com.urbanairship.contacts.Contact$stableContactInfo$1
            if (r0 == 0) goto L14
            r0 = r8
            com.urbanairship.contacts.Contact$stableContactInfo$1 r0 = (com.urbanairship.contacts.Contact$stableContactInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.urbanairship.contacts.Contact$stableContactInfo$1 r0 = new com.urbanairship.contacts.Contact$stableContactInfo$1
            r0.<init>(r7, r8)
            goto L12
        L1a:
            java.lang.Object r8 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L33
            if (r1 != r2) goto L2b
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            com.urbanairship.contacts.ContactManager r1 = r7.contactManager
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r8 = com.urbanairship.contacts.ContactManager.stableContactIdUpdate$urbanairship_core_release$default(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L45
            return r0
        L45:
            com.urbanairship.contacts.ContactIdUpdate r8 = (com.urbanairship.contacts.ContactIdUpdate) r8
            com.urbanairship.contacts.StableContactInfo r7 = r8.toContactInfo()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact.stableContactInfo$suspendImpl(com.urbanairship.contacts.Contact, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object stableVerifiedContactId(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.urbanairship.contacts.Contact.C10931
            if (r0 == 0) goto L13
            r0 = r13
            com.urbanairship.contacts.Contact$stableVerifiedContactId$1 r0 = (com.urbanairship.contacts.Contact.C10931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.Contact$stableVerifiedContactId$1 r0 = new com.urbanairship.contacts.Contact$stableVerifiedContactId$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L3c
            if (r1 == r2) goto L34
            if (r1 != r8) goto L2c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L8e
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L34:
            java.lang.Object r12 = r0.L$0
            com.urbanairship.contacts.Contact r12 = (com.urbanairship.contacts.Contact) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L51
        L3c:
            kotlin.ResultKt.throwOnFailure(r13)
            com.urbanairship.contacts.ContactManager r1 = r12.contactManager
            r0.L$0 = r12
            r0.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            r4 = r0
            java.lang.Object r13 = com.urbanairship.contacts.ContactManager.stableContactIdUpdate$urbanairship_core_release$default(r1, r2, r4, r5, r6)
            if (r13 != r7) goto L51
            return r7
        L51:
            com.urbanairship.contacts.ContactIdUpdate r13 = (com.urbanairship.contacts.ContactIdUpdate) r13
            com.urbanairship.util.Clock r1 = r12.clock
            long r1 = r1.currentTimeMillis()
            long r3 = r13.getResolveDateMs()
            long r1 = r1 - r3
            long r3 = r12.getChannelRegistrationMaxResolveAge()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L6b
            java.lang.String r12 = r13.getContactId()
            return r12
        L6b:
            com.urbanairship.util.Clock r13 = r12.clock
            long r9 = r13.currentTimeMillis()
            com.urbanairship.contacts.ContactManager r13 = r12.contactManager
            com.urbanairship.contacts.ContactOperation$Verify r11 = new com.urbanairship.contacts.ContactOperation$Verify
            r5 = 2
            r6 = 0
            r4 = 0
            r1 = r11
            r2 = r9
            r1.<init>(r2, r4, r5, r6)
            r13.addOperation$urbanairship_core_release(r11)
            com.urbanairship.contacts.ContactManager r12 = r12.contactManager
            r13 = 0
            r0.L$0 = r13
            r0.label = r8
            java.lang.Object r13 = r12.stableContactIdUpdate$urbanairship_core_release(r9, r0)
            if (r13 != r7) goto L8e
            return r7
        L8e:
            com.urbanairship.contacts.ContactIdUpdate r13 = (com.urbanairship.contacts.ContactIdUpdate) r13
            java.lang.String r12 = r13.getContactId()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact.stableVerifiedContactId(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Contact this$0, PushMessage message, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.containsKey(CONTACT_UPDATE_PUSH_KEY)) {
            this$0.contactChannelsProvider.refresh();
        }
    }

    /* renamed from: com.urbanairship.contacts.Contact$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Contact.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0037 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:12:0x0038). Please report as a decompilation issue!!! */
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
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
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

    /* renamed from: com.urbanairship.contacts.Contact$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return Contact.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        Object objCollect = flowDrop.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Contact.kt\ncom/urbanairship/contacts/Contact$5\n*L\n1#1,222:1\n61#2:223\n62#2:225\n233#3:224\n*E\n"})
                    /* renamed from: com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2", f = "Contact.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                        /* renamed from: com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1$2$1
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
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact$5$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object validateSms$suspendImpl(com.urbanairship.contacts.Contact r10, java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation r13) {
        /*
            boolean r0 = r13 instanceof com.urbanairship.contacts.Contact.C10941
            if (r0 == 0) goto L13
            r0 = r13
            com.urbanairship.contacts.Contact$validateSms$1 r0 = (com.urbanairship.contacts.Contact.C10941) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.Contact$validateSms$1 r0 = new com.urbanairship.contacts.Contact$validateSms$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r13)
            goto L55
        L29:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L31:
            kotlin.ResultKt.throwOnFailure(r13)
            com.urbanairship.inputvalidation.AirshipInputValidation$Validator r10 = r10.smsValidator
            com.urbanairship.inputvalidation.AirshipInputValidation$Request$ValidateSms r13 = new com.urbanairship.inputvalidation.AirshipInputValidation$Request$ValidateSms
            com.urbanairship.inputvalidation.AirshipInputValidation$Request$Sms r2 = new com.urbanairship.inputvalidation.AirshipInputValidation$Request$Sms
            com.urbanairship.inputvalidation.AirshipInputValidation$Request$Sms$ValidationOptions$Sender r6 = new com.urbanairship.inputvalidation.AirshipInputValidation$Request$Sms$ValidationOptions$Sender
            r4 = 2
            r5 = 0
            r6.<init>(r12, r5, r4, r5)
            r8 = 4
            r9 = 0
            r7 = 0
            r4 = r2
            r5 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            r13.<init>(r2)
            r0.label = r3
            java.lang.Object r13 = r10.validate(r13, r0)
            if (r13 != r1) goto L55
            return r1
        L55:
            com.urbanairship.inputvalidation.AirshipInputValidation$Result r13 = (com.urbanairship.inputvalidation.AirshipInputValidation.Result) r13
            com.urbanairship.inputvalidation.AirshipInputValidation$Result$Invalid r10 = com.urbanairship.inputvalidation.AirshipInputValidation.Result.Invalid.INSTANCE
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r10)
            if (r10 == 0) goto L61
            r3 = 0
            goto L65
        L61:
            boolean r10 = r13 instanceof com.urbanairship.inputvalidation.AirshipInputValidation.Result.Valid
            if (r10 == 0) goto L6a
        L65:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r10
        L6a:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact.validateSms$suspendImpl(com.urbanairship.contacts.Contact, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
                    UALog.w("Contact - Ignoring tag edits while contacts and/or tags and attributes are disabled.", new Object[0]);
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
                    UALog.w("Contact - Ignoring subscription list edits while contacts and/or tags and attributes are disabled.", new Object[0]);
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: fetchSubscriptionLists-IoAF18A$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m2839fetchSubscriptionListsIoAF18A$suspendImpl(com.urbanairship.contacts.Contact r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof com.urbanairship.contacts.Contact$fetchSubscriptionLists$1
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.contacts.Contact$fetchSubscriptionLists$1 r0 = (com.urbanairship.contacts.Contact$fetchSubscriptionLists$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.Contact$fetchSubscriptionLists$1 r0 = new com.urbanairship.contacts.Contact$fetchSubscriptionLists$1
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
            com.urbanairship.contacts.SubscriptionsProvider r4 = r4.subscriptionsProvider
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
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.Contact.m2839fetchSubscriptionListsIoAF18A$suspendImpl(com.urbanairship.contacts.Contact, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public Flow<Result<List<ContactChannel>>> getChannelContacts() {
        return this.channelContacts;
    }

    @NotNull
    public Flow<Result<Map<String, Set<Scope>>>> getSubscriptions() {
        return this.subscriptions;
    }

    /* renamed from: com.urbanairship.contacts.Contact$fetchSubscriptionListsPendingResult$1, reason: invalid class name and case insensitive filesystem */
    static final class C10841 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        Object L$0;
        int label;
        final /* synthetic */ Contact this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10841(PendingResult pendingResult, Contact contact, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = contact;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C10841(this.$pendingResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object objM2840fetchSubscriptionListsIoAF18A = contact.m2840fetchSubscriptionListsIoAF18A(this);
                if (objM2840fetchSubscriptionListsIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM2840fetchSubscriptionListsIoAF18A;
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
    public PendingResult<Map<String, Set<Scope>>> fetchSubscriptionListsPendingResult() {
        PendingResult<Map<String, Set<Scope>>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.subscriptionsScope, null, null, new C10841(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    /* renamed from: com.urbanairship.contacts.Contact$getSubscriptionLists$1, reason: invalid class name and case insensitive filesystem */
    static final class C10851 extends SuspendLambda implements Function2 {
        final /* synthetic */ PendingResult $pendingResult;
        Object L$0;
        int label;
        final /* synthetic */ Contact this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10851(PendingResult pendingResult, Contact contact, Continuation continuation) {
            super(2, continuation);
            this.$pendingResult = pendingResult;
            this.this$0 = contact;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C10851(this.$pendingResult, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C10851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                Object objM2840fetchSubscriptionListsIoAF18A = contact.m2840fetchSubscriptionListsIoAF18A(this);
                if (objM2840fetchSubscriptionListsIoAF18A == coroutine_suspended) {
                    return coroutine_suspended;
                }
                value = objM2840fetchSubscriptionListsIoAF18A;
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

    @Deprecated(message = "Use fetchSubscriptionListsPendingResult() instead")
    @NotNull
    public PendingResult<Map<String, Set<Scope>>> getSubscriptionLists() {
        PendingResult<Map<String, Set<Scope>>> pendingResult = new PendingResult<>();
        BuildersKt__Builders_commonKt.launch$default(this.subscriptionsScope, null, null, new C10851(pendingResult, this, null), 3, null);
        return pendingResult;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0007R\u001c\u0010\u0010\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0007R\u001c\u0010\u0013\u001a\u00020\u00048\u0000X\u0081D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/contacts/Contact$Companion;", "", "()V", "ACTION_UPDATE_CONTACT", "", "getACTION_UPDATE_CONTACT$urbanairship_core_release$annotations", "getACTION_UPDATE_CONTACT$urbanairship_core_release", "()Ljava/lang/String;", "CONTACT_UPDATE_PUSH_KEY", "CRA_MAX_AGE", "", "FOREGROUND_INTERVAL", "LAST_RESOLVED_DATE_KEY", "LEGACY_ATTRIBUTE_MUTATION_STORE_KEY", "getLEGACY_ATTRIBUTE_MUTATION_STORE_KEY$urbanairship_core_release$annotations", "getLEGACY_ATTRIBUTE_MUTATION_STORE_KEY$urbanairship_core_release", "LEGACY_NAMED_USER_ID_KEY", "getLEGACY_NAMED_USER_ID_KEY$urbanairship_core_release$annotations", "getLEGACY_NAMED_USER_ID_KEY$urbanairship_core_release", "LEGACY_TAG_GROUP_MUTATIONS_KEY", "getLEGACY_TAG_GROUP_MUTATIONS_KEY$urbanairship_core_release$annotations", "getLEGACY_TAG_GROUP_MUTATIONS_KEY$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getACTION_UPDATE_CONTACT$urbanairship_core_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getLEGACY_ATTRIBUTE_MUTATION_STORE_KEY$urbanairship_core_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getLEGACY_NAMED_USER_ID_KEY$urbanairship_core_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getLEGACY_TAG_GROUP_MUTATIONS_KEY$urbanairship_core_release$annotations() {
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
