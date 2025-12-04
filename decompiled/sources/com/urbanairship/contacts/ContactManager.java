package com.urbanairship.contacts;

import androidx.annotation.OpenForTesting;
import androidx.core.util.Predicate;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.joran.action.Action;
import com.facebook.imageutils.JfifUtil;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.TagGroupsMutation;
import com.urbanairship.contacts.ConflictEvent;
import com.urbanairship.contacts.ContactApiClient;
import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.contacts.ContactChannelMutation;
import com.urbanairship.contacts.ContactManager;
import com.urbanairship.contacts.ContactOperation;
import com.urbanairship.http.AuthToken;
import com.urbanairship.http.AuthTokenProvider;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestResult;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.locale.LocaleManager;
import com.urbanairship.util.CachedValue;
import com.urbanairship.util.Clock;
import com.urbanairship.util.SerialQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 ¤\u00012\u00020\u0001:\u0006¤\u0001¥\u0001¦\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0015\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b\\J\b\u0010]\u001a\u00020YH\u0002J(\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020\u00172\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0012\u0010d\u001a\u00020Y2\b\b\u0002\u0010e\u001a\u00020fH\u0002J,\u0010g\u001a\u0002062\u001c\u0010Z\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002060i\u0012\u0006\u0012\u0004\u0018\u00010j0hH\u0082@¢\u0006\u0002\u0010kJ\u0016\u0010l\u001a\u00020Y2\u0006\u0010m\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010nJ$\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00170p2\u0006\u0010q\u001a\u00020\u0017H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010nJ\r\u0010s\u001a\u00020YH\u0000¢\u0006\u0002\btJ\u0010\u0010u\u001a\u00020v2\u0006\u0010_\u001a\u00020\u0017H\u0002J\u0010\u0010w\u001a\u0002062\u0006\u0010Z\u001a\u00020[H\u0002J\u0016\u0010x\u001a\u0002062\u0006\u0010Z\u001a\u00020yH\u0082@¢\u0006\u0002\u0010zJ\u0016\u0010{\u001a\u0002062\u0006\u0010Z\u001a\u00020|H\u0082@¢\u0006\u0002\u0010}J \u0010~\u001a\u0002062\u0006\u0010\u007f\u001a\u00020\u00172\u0007\u0010Z\u001a\u00030\u0080\u0001H\u0082@¢\u0006\u0003\u0010\u0081\u0001J\u0010\u0010\u0082\u0001\u001a\u000206H\u0086@¢\u0006\u0003\u0010\u0083\u0001J\u0018\u0010\u0084\u0001\u001a\u0002062\u0006\u0010Z\u001a\u00020[H\u0082@¢\u0006\u0003\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u0087\u0001H\u0082@¢\u0006\u0003\u0010\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u008a\u0001H\u0082@¢\u0006\u0003\u0010\u008b\u0001J\u0019\u0010\u008c\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u008d\u0001H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\u0019\u0010\u008f\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0091\u0001J\u0017\u0010\u0092\u0001\u001a\u0002062\u0006\u0010\u007f\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010nJ\u0017\u0010\u0093\u0001\u001a\u0002062\u0006\u0010\u007f\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010nJ\u0018\u0010\u0094\u0001\u001a\u0002062\u0006\u0010Z\u001a\u00020aH\u0082@¢\u0006\u0003\u0010\u0095\u0001J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0002J\u000f\u0010\u0098\u0001\u001a\u00020YH\u0000¢\u0006\u0003\b\u0099\u0001J\u001e\u0010\u009a\u0001\u001a\u00020\u00152\t\b\u0002\u0010\u009b\u0001\u001a\u00020KH\u0080@¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u000b\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J&\u0010\u009f\u0001\u001a\u00020Y2\b\u0010 \u0001\u001a\u00030¡\u00012\b\u0010L\u001a\u0004\u0018\u00010\u00172\u0007\u0010¢\u0001\u001a\u000206H\u0002J\t\u0010£\u0001\u001a\u00020YH\u0002R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u00010\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0019\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170-¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010>\u001a\u0002062\u0006\u0010=\u001a\u000206@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010AR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010B\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\bC\u0010DR(\u0010E\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00198B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\u0004\u0018\u00010\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010DR\u000e\u0010N\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010T\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006§\u0001"}, d2 = {"Lcom/urbanairship/contacts/ContactManager;", "Lcom/urbanairship/http/AuthTokenProvider;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/channel/AirshipChannel;", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "contactApiClient", "Lcom/urbanairship/contacts/ContactApiClient;", "localeManager", "Lcom/urbanairship/locale/LocaleManager;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/job/JobDispatcher;Lcom/urbanairship/contacts/ContactApiClient;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_contactIdUpdates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/contacts/ContactIdUpdate;", "_currentNamedUserIdUpdates", "", "_identity", "Lcom/urbanairship/contacts/ContactIdentity;", "_operations", "", "Lcom/urbanairship/contacts/ContactManager$OperationEntry;", "newValue", "Lcom/urbanairship/contacts/AnonContactData;", "anonData", "getAnonData", "()Lcom/urbanairship/contacts/AnonContactData;", "setAnonData", "(Lcom/urbanairship/contacts/AnonContactData;)V", "cachedAuthToken", "Lcom/urbanairship/util/CachedValue;", "Lcom/urbanairship/http/AuthToken;", "conflictEvents", "Lkotlinx/coroutines/channels/Channel;", "Lcom/urbanairship/contacts/ConflictEvent;", "getConflictEvents", "()Lkotlinx/coroutines/channels/Channel;", "contactIdUpdates", "Lkotlinx/coroutines/flow/StateFlow;", "getContactIdUpdates", "()Lkotlinx/coroutines/flow/StateFlow;", "currentContactIdUpdate", "getCurrentContactIdUpdate$urbanairship_core_release", "()Lcom/urbanairship/contacts/ContactIdUpdate;", "currentNamedUserIdUpdates", "getCurrentNamedUserIdUpdates", "hasAnonDate", "", "getHasAnonDate", "()Z", "identifyOperationQueue", "Lcom/urbanairship/util/SerialQueue;", "identityLock", "Ljava/util/concurrent/locks/ReentrantLock;", "value", "isEnabled", "isEnabled$urbanairship_core_release", "setEnabled$urbanairship_core_release", "(Z)V", "lastContactId", "getLastContactId", "()Ljava/lang/String;", "lastContactIdentity", "getLastContactIdentity", "()Lcom/urbanairship/contacts/ContactIdentity;", "setLastContactIdentity", "(Lcom/urbanairship/contacts/ContactIdentity;)V", "lastIdentifyTimeMs", "", "namedUserId", "getNamedUserId$urbanairship_core_release", "operationLock", "operations", "getOperations", "()Ljava/util/List;", "setOperations", "(Ljava/util/List;)V", "possiblyOrphanedContactId", "getPossiblyOrphanedContactId", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "addOperation", "", "operation", "Lcom/urbanairship/contacts/ContactOperation;", "addOperation$urbanairship_core_release", "clearSkippableOperations", "contactUpdated", "contactId", "updateOperation", "Lcom/urbanairship/contacts/ContactOperation$Update;", "channelUpdate", "Lcom/urbanairship/contacts/ContactChannelMutation;", "dispatchContactUpdateJob", "conflictStrategy", "", "doIdentify", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expireToken", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToken", "Lkotlin/Result;", "identifier", "fetchToken-gIAlu-s", "generateDefaultContactIdIfNotSet", "generateDefaultContactIdIfNotSet$urbanairship_core_release", "getPendingAudienceOverrides", "Lcom/urbanairship/audience/AudienceOverrides$Contact;", "isSkippable", "performAssociateChannel", "Lcom/urbanairship/contacts/ContactOperation$AssociateChannel;", "(Lcom/urbanairship/contacts/ContactOperation$AssociateChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDisassociateChannel", "Lcom/urbanairship/contacts/ContactOperation$DisassociateChannel;", "(Lcom/urbanairship/contacts/ContactOperation$DisassociateChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performIdentify", "channelId", "Lcom/urbanairship/contacts/ContactOperation$Identify;", "(Ljava/lang/String;Lcom/urbanairship/contacts/ContactOperation$Identify;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performNextOperation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performOperation", "(Lcom/urbanairship/contacts/ContactOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRegisterEmail", "Lcom/urbanairship/contacts/ContactOperation$RegisterEmail;", "(Lcom/urbanairship/contacts/ContactOperation$RegisterEmail;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRegisterOpen", "Lcom/urbanairship/contacts/ContactOperation$RegisterOpen;", "(Lcom/urbanairship/contacts/ContactOperation$RegisterOpen;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRegisterSms", "Lcom/urbanairship/contacts/ContactOperation$RegisterSms;", "(Lcom/urbanairship/contacts/ContactOperation$RegisterSms;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performResend", "Lcom/urbanairship/contacts/ContactOperation$Resend;", "(Lcom/urbanairship/contacts/ContactOperation$Resend;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performReset", "performResolve", "performUpdate", "(Lcom/urbanairship/contacts/ContactOperation$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareNextOperationGroup", "Lcom/urbanairship/contacts/ContactManager$OperationGroup;", "resetIfNeeded", "resetIfNeeded$urbanairship_core_release", "stableContactIdUpdate", "minResolveDate", "stableContactIdUpdate$urbanairship_core_release", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tokenIfValid", "updateContactIdentity", "result", "Lcom/urbanairship/contacts/ContactApiClient$IdentityResult;", "isResolve", "yieldContactUpdates", "Companion", "OperationEntry", "OperationGroup", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@OpenForTesting
@SourceDebugExtension({"SMAP\nContactManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactManager.kt\ncom/urbanairship/contacts/ContactManager\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 5 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 6 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 7 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 9 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 10 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1014:1\n19#2,2:1015\n21#2,5:1021\n18#2,3:1030\n21#2,5:1037\n18#2,8:1042\n18#2,8:1050\n1549#3:1017\n1620#3,3:1018\n1549#3:1026\n1620#3,3:1027\n1549#3:1033\n1620#3,3:1034\n288#3,2:1058\n288#3,2:1060\n288#3,2:1077\n1549#3:1079\n1620#3,3:1080\n766#3:1084\n857#3,2:1085\n1549#3:1087\n1620#3,3:1088\n766#3:1091\n857#3,2:1092\n1855#3,2:1112\n1855#3,2:1114\n1855#3,2:1116\n60#4:1062\n63#4:1066\n50#5:1063\n55#5:1065\n106#6:1064\n230#7,5:1067\n230#7,5:1072\n1#8:1083\n215#9:1094\n216#9:1102\n215#9:1103\n216#9:1111\n372#10,7:1095\n372#10,7:1104\n*S KotlinDebug\n*F\n+ 1 ContactManager.kt\ncom/urbanairship/contacts/ContactManager\n*L\n192#1:1015,2\n192#1:1021,5\n91#1:1030,3\n91#1:1037,5\n112#1:1042,8\n123#1:1050,8\n192#1:1017\n192#1:1018,3\n193#1:1026\n193#1:1027,3\n92#1:1033\n92#1:1034,3\n146#1:1058,2\n171#1:1060,2\n354#1:1077,2\n364#1:1079\n364#1:1080,3\n531#1:1084\n531#1:1085,2\n882#1:1087\n882#1:1088,3\n900#1:1091\n900#1:1092,2\n947#1:1112,2\n955#1:1114,2\n959#1:1116,2\n223#1:1062\n223#1:1066\n223#1:1063\n223#1:1065\n223#1:1064\n293#1:1067,5\n294#1:1072,5\n935#1:1094\n935#1:1102\n941#1:1103\n941#1:1111\n936#1:1095,7\n942#1:1104,7\n*E\n"})
/* loaded from: classes5.dex */
public final class ContactManager implements AuthTokenProvider {

    @NotNull
    public static final String IDENTITY_RATE_LIMIT = "Contact.identify";

    @NotNull
    public static final String UPDATE_RATE_LIMIT = "Contact.update";
    private final MutableStateFlow _contactIdUpdates;
    private final MutableStateFlow _currentNamedUserIdUpdates;
    private ContactIdentity _identity;
    private List _operations;
    private final AudienceOverridesProvider audienceOverridesProvider;
    private final CachedValue cachedAuthToken;
    private final AirshipChannel channel;
    private final Clock clock;
    private final Channel conflictEvents;
    private final ContactApiClient contactApiClient;
    private final StateFlow contactIdUpdates;
    private final StateFlow currentNamedUserIdUpdates;
    private final CoroutineDispatcher dispatcher;
    private final SerialQueue identifyOperationQueue;
    private final ReentrantLock identityLock;
    private volatile boolean isEnabled;
    private final JobDispatcher jobDispatcher;
    private long lastIdentifyTimeMs;
    private final LocaleManager localeManager;
    private final ReentrantLock operationLock;
    private final PreferenceDataStore preferenceDataStore;
    private final CoroutineScope scope;

    /* renamed from: com.urbanairship.contacts.ContactManager$performAssociateChannel$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performAssociateChannel(null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performDisassociateChannel$1, reason: invalid class name and case insensitive filesystem */
    static final class C11071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11071(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performDisassociateChannel(null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performRegisterEmail$1, reason: invalid class name and case insensitive filesystem */
    static final class C11101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11101(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performRegisterEmail(null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performRegisterOpen$1, reason: invalid class name and case insensitive filesystem */
    static final class C11111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11111(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performRegisterOpen(null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performRegisterSms$1, reason: invalid class name and case insensitive filesystem */
    static final class C11121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11121(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performRegisterSms(null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performResend$1, reason: invalid class name and case insensitive filesystem */
    static final class C11131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11131(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performResend(null, this);
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C11161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11161(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performUpdate(null, this);
        }
    }

    public ContactManager(@NotNull PreferenceDataStore preferenceDataStore, @NotNull AirshipChannel channel, @NotNull JobDispatcher jobDispatcher, @NotNull ContactApiClient contactApiClient, @NotNull LocaleManager localeManager, @NotNull AudienceOverridesProvider audienceOverridesProvider, @NotNull Clock clock, @NotNull CoroutineDispatcher dispatcher) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(preferenceDataStore, "preferenceDataStore");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(jobDispatcher, "jobDispatcher");
        Intrinsics.checkNotNullParameter(contactApiClient, "contactApiClient");
        Intrinsics.checkNotNullParameter(localeManager, "localeManager");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.preferenceDataStore = preferenceDataStore;
        this.channel = channel;
        this.jobDispatcher = jobDispatcher;
        this.contactApiClient = contactApiClient;
        this.localeManager = localeManager;
        this.audienceOverridesProvider = audienceOverridesProvider;
        this.clock = clock;
        this.dispatcher = dispatcher;
        this.scope = CoroutineScopeKt.CoroutineScope(dispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.identifyOperationQueue = new SerialQueue();
        this.operationLock = new ReentrantLock();
        this.identityLock = new ReentrantLock();
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._contactIdUpdates = MutableStateFlow;
        this.contactIdUpdates = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._currentNamedUserIdUpdates = MutableStateFlow2;
        this.currentNamedUserIdUpdates = FlowKt.asStateFlow(MutableStateFlow2);
        this.conflictEvents = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.cachedAuthToken = new CachedValue();
        JsonValue jsonValueOptJsonValue = preferenceDataStore.optJsonValue("com.urbanairship.contacts.OPERATIONS");
        if (jsonValueOptJsonValue != null) {
            if (!preferenceDataStore.isSet("com.urbanairship.contacts.OPERATION_ENTRIES")) {
                JsonList jsonListOptList = jsonValueOptJsonValue.optList();
                try {
                    Intrinsics.checkNotNull(jsonListOptList);
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
                    for (JsonValue jsonValue : jsonListOptList) {
                        ContactOperation.Companion companion = ContactOperation.INSTANCE;
                        Intrinsics.checkNotNull(jsonValue);
                        arrayList.add(companion.fromJson(jsonValue));
                    }
                } catch (JsonException e) {
                    UALog.e("Failed to parse json", e);
                    arrayList = null;
                }
                if (arrayList != null) {
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new OperationEntry(this.clock.currentTimeMillis(), (ContactOperation) it.next(), null, 4, null));
                    }
                    setOperations(arrayList2);
                }
            }
            this.preferenceDataStore.remove("com.urbanairship.contacts.OPERATIONS");
        }
        this.audienceOverridesProvider.setPendingContactOverridesDelegate$urbanairship_core_release(new Function1() { // from class: com.urbanairship.contacts.ContactManager.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AudienceOverrides.Contact invoke(String it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return ContactManager.this.getPendingAudienceOverrides(it2);
            }
        });
        this.audienceOverridesProvider.setStableContactIdDelegate$urbanairship_core_release(new AnonymousClass3(null));
        this.jobDispatcher.setRateLimit(IDENTITY_RATE_LIMIT, 1, 5L, TimeUnit.SECONDS);
        this.jobDispatcher.setRateLimit(UPDATE_RATE_LIMIT, 1, 500L, TimeUnit.MILLISECONDS);
        yieldContactUpdates();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass4(null), 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ContactManager(PreferenceDataStore preferenceDataStore, AirshipChannel airshipChannel, JobDispatcher jobDispatcher, ContactApiClient contactApiClient, LocaleManager localeManager, AudienceOverridesProvider audienceOverridesProvider, Clock clock, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Clock clock2;
        if ((i & 64) != 0) {
            Clock DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
            clock2 = DEFAULT_CLOCK;
        } else {
            clock2 = clock;
        }
        this(preferenceDataStore, airshipChannel, jobDispatcher, contactApiClient, localeManager, audienceOverridesProvider, clock2, (i & 128) != 0 ? AirshipDispatchers.INSTANCE.newSerialDispatcher() : coroutineDispatcher);
    }

    @NotNull
    public final StateFlow<ContactIdUpdate> getContactIdUpdates() {
        return this.contactIdUpdates;
    }

    @NotNull
    public final StateFlow<String> getCurrentNamedUserIdUpdates() {
        return this.currentNamedUserIdUpdates;
    }

    @NotNull
    public final Channel<ConflictEvent> getConflictEvents() {
        return this.conflictEvents;
    }

    /* renamed from: isEnabled$urbanairship_core_release, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled$urbanairship_core_release(boolean z) {
        this.isEnabled = z;
        if (z) {
            dispatchContactUpdateJob$default(this, 0, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List getOperations() {
        ReentrantLock reentrantLock = this.operationLock;
        reentrantLock.lock();
        try {
            List listEmptyList = this._operations;
            if (listEmptyList == null) {
                JsonValue jsonValueOptJsonValue = this.preferenceDataStore.optJsonValue("com.urbanairship.contacts.OPERATIONS");
                ArrayList arrayList = null;
                if (jsonValueOptJsonValue != null) {
                    try {
                        JsonList jsonListRequireList = jsonValueOptJsonValue.requireList();
                        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                        for (JsonValue jsonValue : jsonListRequireList) {
                            Intrinsics.checkNotNull(jsonValue);
                            arrayList2.add(new OperationEntry(jsonValue));
                        }
                        arrayList = arrayList2;
                    } catch (JsonException unused) {
                    }
                }
                listEmptyList = arrayList;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
            }
            this._operations = listEmptyList;
            return listEmptyList;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOperations(List list) {
        ReentrantLock reentrantLock = this.operationLock;
        reentrantLock.lock();
        try {
            this._operations = list;
            this.preferenceDataStore.put("com.urbanairship.contacts.OPERATIONS", JsonExtensionsKt.toJsonList(list));
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final boolean getHasAnonDate() {
        AnonContactData anonData;
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        return (lastContactIdentity == null || !lastContactIdentity.getIsAnonymous() || (anonData = getAnonData()) == null || anonData.isEmpty$urbanairship_core_release()) ? false : true;
    }

    private final AnonContactData getAnonData() {
        JsonValue jsonValueOptJsonValue = this.preferenceDataStore.optJsonValue("com.urbanairship.contacts.ANON_CONTACT_DATA_KEY");
        if (jsonValueOptJsonValue == null) {
            return null;
        }
        try {
            return AnonContactData.INSTANCE.fromJson(jsonValueOptJsonValue);
        } catch (JsonException unused) {
            return null;
        }
    }

    private final void setAnonData(AnonContactData anonContactData) {
        this.preferenceDataStore.put("com.urbanairship.contacts.ANON_CONTACT_DATA_KEY", anonContactData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContactIdentity getLastContactIdentity() {
        ReentrantLock reentrantLock = this.identityLock;
        reentrantLock.lock();
        try {
            ContactIdentity contactIdentity = this._identity;
            if (contactIdentity == null) {
                JsonValue jsonValueOptJsonValue = this.preferenceDataStore.optJsonValue("com.urbanairship.contacts.LAST_CONTACT_IDENTITY_KEY");
                if (jsonValueOptJsonValue != null) {
                    try {
                        contactIdentity = new ContactIdentity(jsonValueOptJsonValue);
                    } catch (JsonException unused) {
                    }
                } else {
                    contactIdentity = null;
                }
            }
            this._identity = contactIdentity;
            return contactIdentity;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void setLastContactIdentity(ContactIdentity contactIdentity) {
        ReentrantLock reentrantLock = this.identityLock;
        reentrantLock.lock();
        try {
            this._identity = contactIdentity;
            this.preferenceDataStore.put("com.urbanairship.contacts.LAST_CONTACT_IDENTITY_KEY", contactIdentity);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPossiblyOrphanedContactId() {
        List<AnonChannel> associatedChannels;
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        if (lastContactIdentity == null || !lastContactIdentity.getIsAnonymous()) {
            return null;
        }
        AnonContactData anonData = getAnonData();
        if (anonData == null || (associatedChannels = anonData.getAssociatedChannels()) == null || associatedChannels.isEmpty()) {
            return lastContactIdentity.getContactId();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.urbanairship.contacts.ContactIdUpdate getCurrentContactIdUpdate$urbanairship_core_release() {
        /*
            r11 = this;
            com.urbanairship.contacts.ContactIdentity r0 = r11.getLastContactIdentity()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.util.List r11 = r11.getOperations()
            java.util.Iterator r11 = r11.iterator()
        L10:
            boolean r2 = r11.hasNext()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L55
            java.lang.Object r2 = r11.next()
            r5 = r2
            com.urbanairship.contacts.ContactManager$OperationEntry r5 = (com.urbanairship.contacts.ContactManager.OperationEntry) r5
            com.urbanairship.contacts.ContactOperation r6 = r5.getOperation()
            boolean r7 = r6 instanceof com.urbanairship.contacts.ContactOperation.Reset
            if (r7 == 0) goto L29
        L27:
            r5 = r4
            goto L52
        L29:
            boolean r7 = r6 instanceof com.urbanairship.contacts.ContactOperation.Verify
            if (r7 == 0) goto L38
            com.urbanairship.contacts.ContactOperation r5 = r5.getOperation()
            com.urbanairship.contacts.ContactOperation$Verify r5 = (com.urbanairship.contacts.ContactOperation.Verify) r5
            boolean r5 = r5.getRequired()
            goto L52
        L38:
            boolean r6 = r6 instanceof com.urbanairship.contacts.ContactOperation.Identify
            if (r6 == 0) goto L51
            com.urbanairship.contacts.ContactOperation r5 = r5.getOperation()
            com.urbanairship.contacts.ContactOperation$Identify r5 = (com.urbanairship.contacts.ContactOperation.Identify) r5
            java.lang.String r5 = r5.getIdentifier()
            java.lang.String r6 = r0.getNamedUserId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 != 0) goto L51
            goto L27
        L51:
            r5 = r3
        L52:
            if (r5 == 0) goto L10
            r1 = r2
        L55:
            if (r1 != 0) goto L59
            r8 = r4
            goto L5a
        L59:
            r8 = r3
        L5a:
            com.urbanairship.contacts.ContactIdUpdate r11 = new com.urbanairship.contacts.ContactIdUpdate
            java.lang.String r6 = r0.getContactId()
            java.lang.String r7 = r0.getNamedUserId()
            java.lang.Long r0 = r0.getResolveDateMs()
            if (r0 == 0) goto L70
            long r0 = r0.longValue()
        L6e:
            r9 = r0
            goto L73
        L70:
            r0 = 0
            goto L6e
        L73:
            r5 = r11
            r5.<init>(r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.getCurrentContactIdUpdate$urbanairship_core_release():com.urbanairship.contacts.ContactIdUpdate");
    }

    @Nullable
    public final String getNamedUserId$urbanairship_core_release() {
        Object next;
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        String namedUserId = lastContactIdentity != null ? lastContactIdentity.getNamedUserId() : null;
        Iterator it = CollectionsKt.reversed(getOperations()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            OperationEntry operationEntry = (OperationEntry) next;
            if ((operationEntry.getOperation() instanceof ContactOperation.Identify) || (operationEntry.getOperation() instanceof ContactOperation.Reset)) {
                break;
            }
        }
        OperationEntry operationEntry2 = (OperationEntry) next;
        if (operationEntry2 == null) {
            return namedUserId;
        }
        ContactOperation operation = operationEntry2.getOperation();
        if (operation instanceof ContactOperation.Reset) {
            return null;
        }
        return operation instanceof ContactOperation.Identify ? ((ContactOperation.Identify) operationEntry2.getOperation()).getIdentifier() : namedUserId;
    }

    @Nullable
    public final String getLastContactId() {
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        if (lastContactIdentity != null) {
            return lastContactIdentity.getContactId();
        }
        return null;
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function1 {
        int label;

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ContactManager contactManager = ContactManager.this;
                this.label = 1;
                obj = ContactManager.stableContactIdUpdate$urbanairship_core_release$default(contactManager, 0L, this, 1, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((ContactIdUpdate) obj).getContactId();
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ContactManager.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final String id = ContactManager.this.channel.getId();
                final StateFlow<String> channelIdFlow = ContactManager.this.channel.getChannelIdFlow();
                Flow<String> flow = new Flow<String>() { // from class: com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1
                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super String> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = channelIdFlow.collect(new AnonymousClass2(flowCollector, id), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ContactManager.kt\ncom/urbanairship/contacts/ContactManager$4\n*L\n1#1,222:1\n22#2:223\n23#2:225\n216#3:224\n*E\n"})
                    /* renamed from: com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ String $startingChannelId$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2", f = "ContactManager.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                        /* renamed from: com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                            this.$startingChannelId$inlined = str;
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
                                boolean r0 = r6 instanceof com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2$1
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
                                java.lang.String r4 = r4.$startingChannelId$inlined
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
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }
                };
                final ContactManager contactManager = ContactManager.this;
                FlowCollector<? super String> flowCollector = new FlowCollector() { // from class: com.urbanairship.contacts.ContactManager.4.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(String str, Continuation continuation) {
                        ContactManager.dispatchContactUpdateJob$default(contactManager, 0, 1, null);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
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

    public static /* synthetic */ Object stableContactIdUpdate$urbanairship_core_release$default(ContactManager contactManager, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return contactManager.stableContactIdUpdate$urbanairship_core_release(j, continuation);
    }

    @Nullable
    public final Object stableContactIdUpdate$urbanairship_core_release(long j, @NotNull Continuation<? super ContactIdUpdate> continuation) {
        final StateFlow stateFlow = this.contactIdUpdates;
        return FlowKt.first(new Flow<ContactIdUpdate>() { // from class: com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1
            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super ContactIdUpdate> flowCollector, @NotNull Continuation continuation2) {
                Object objCollect = stateFlow.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ContactManager.kt\ncom/urbanairship/contacts/ContactManager\n*L\n1#1,222:1\n61#2:223\n62#2:225\n223#3:224\n*E\n"})
            /* renamed from: com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2", f = "ContactManager.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
                /* renamed from: com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2$1
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
                        com.urbanairship.contacts.ContactIdUpdate r5 = (com.urbanairship.contacts.ContactIdUpdate) r5
                        if (r5 == 0) goto L43
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new ContactManager$stableContactIdUpdate$3(j, null), continuation);
    }

    public final void resetIfNeeded$urbanairship_core_release() {
        AnonContactData anonData;
        ContactIdentity lastContactIdentity;
        if (getLastContactIdentity() == null || !(((anonData = getAnonData()) == null || anonData.isEmpty$urbanairship_core_release()) && (((lastContactIdentity = getLastContactIdentity()) == null || lastContactIdentity.getIsAnonymous()) && getOperations().isEmpty()))) {
            addOperation$urbanairship_core_release(ContactOperation.Reset.INSTANCE);
        }
    }

    public final void addOperation$urbanairship_core_release(@NotNull ContactOperation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        ReentrantLock reentrantLock = this.operationLock;
        reentrantLock.lock();
        try {
            List mutableList = CollectionsKt.toMutableList((Collection) getOperations());
            mutableList.add(new OperationEntry(this.clock.currentTimeMillis(), operation, null, 4, null));
            setOperations(mutableList);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            dispatchContactUpdateJob$default(this, 0, 1, null);
            yieldContactUpdates();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.urbanairship.http.AuthTokenProvider
    @org.jetbrains.annotations.Nullable
    /* renamed from: fetchToken-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo2833fetchTokengIAlus(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.urbanairship.contacts.ContactManager$fetchToken$1
            if (r0 == 0) goto L13
            r0 = r7
            com.urbanairship.contacts.ContactManager$fetchToken$1 r0 = (com.urbanairship.contacts.ContactManager$fetchToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.ContactManager$fetchToken$1 r0 = new com.urbanairship.contacts.ContactManager$fetchToken$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = r5.dispatcher
            com.urbanairship.contacts.ContactManager$fetchToken$2 r2 = new com.urbanairship.contacts.ContactManager$fetchToken$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.getValue()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.mo2833fetchTokengIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void generateDefaultContactIdIfNotSet$urbanairship_core_release() {
        ReentrantLock reentrantLock = this.identityLock;
        reentrantLock.lock();
        try {
            if (getLastContactIdentity() == null) {
                String string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                setLastContactIdentity(new ContactIdentity(string, true, null, Long.valueOf(this.clock.currentTimeMillis())));
                addOperation$urbanairship_core_release(ContactOperation.Resolve.INSTANCE);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            yieldContactUpdates();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$expireToken$2, reason: invalid class name and case insensitive filesystem */
    static final class C11062 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11062(String str, Continuation continuation) {
            super(2, continuation);
            this.$token = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ContactManager.this.new C11062(this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11062) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CachedValue cachedValue = ContactManager.this.cachedAuthToken;
                final String str = this.$token;
                cachedValue.expireIf(new Predicate() { // from class: com.urbanairship.contacts.ContactManager$expireToken$2$$ExternalSyntheticLambda0
                    @Override // androidx.core.util.Predicate
                    public final boolean test(Object obj2) {
                        return ContactManager.C11062.invokeSuspend$lambda$0(str, (AuthToken) obj2);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(String str, AuthToken authToken) {
            return Intrinsics.areEqual(authToken.getToken(), str);
        }
    }

    @Override // com.urbanairship.http.AuthTokenProvider
    @Nullable
    public Object expireToken(@NotNull String str, @NotNull Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C11062(str, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yieldContactUpdates() {
        Object value;
        Object value2;
        MutableStateFlow mutableStateFlow = this._currentNamedUserIdUpdates;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, getNamedUserId$urbanairship_core_release()));
        MutableStateFlow mutableStateFlow2 = this._contactIdUpdates;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, getCurrentContactIdUpdate$urbanairship_core_release()));
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performNextOperation$2, reason: invalid class name and case insensitive filesystem */
    static final class C11092 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C11092(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ContactManager.this.new C11092(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C11092) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 290
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.C11092.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Nullable
    public final Object performNextOperation(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C11092(null), continuation);
    }

    static /* synthetic */ void dispatchContactUpdateJob$default(ContactManager contactManager, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        contactManager.dispatchContactUpdateJob(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchContactUpdateJob(int conflictStrategy) {
        Object next;
        String id = this.channel.getId();
        if (id == null || id.length() == 0 || !this.isEnabled) {
            return;
        }
        List operations = getOperations();
        if (operations.isEmpty()) {
            return;
        }
        JobInfo.Builder builderAddRateLimit = JobInfo.newBuilder().setAction(Contact.INSTANCE.getACTION_UPDATE_CONTACT$urbanairship_core_release()).setNetworkAccessRequired(true).setAirshipComponent(Contact.class).setConflictStrategy(conflictStrategy).addRateLimit(UPDATE_RATE_LIMIT);
        Intrinsics.checkNotNullExpressionValue(builderAddRateLimit, "addRateLimit(...)");
        Iterator it = operations.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (!isSkippable(((OperationEntry) next).getOperation())) {
                    break;
                }
            }
        }
        OperationEntry operationEntry = (OperationEntry) next;
        ContactOperation operation = operationEntry != null ? operationEntry.getOperation() : null;
        boolean z = operation instanceof ContactOperation.Reset;
        if (z || (operation instanceof ContactOperation.Resolve) || z) {
            builderAddRateLimit.addRateLimit(IDENTITY_RATE_LIMIT);
        }
        this.jobDispatcher.dispatch(builderAddRateLimit.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AudienceOverrides.Contact getPendingAudienceOverrides(String contactId) {
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        if (lastContactIdentity == null) {
            return new AudienceOverrides.Contact(null, null, null, null, 15, null);
        }
        List operations = getOperations();
        ArrayList<ContactOperation> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(operations, 10));
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            arrayList.add(((OperationEntry) it.next()).getOperation());
        }
        if (!Intrinsics.areEqual(contactId, lastContactIdentity.getContactId())) {
            return new AudienceOverrides.Contact(null, null, null, null, 15, null);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        String str = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        String identifier = null;
        for (ContactOperation contactOperation : arrayList) {
            if (contactOperation instanceof ContactOperation.Reset) {
                break;
            }
            if (contactOperation instanceof ContactOperation.Identify) {
                if ((!lastContactIdentity.getIsAnonymous() && !Intrinsics.areEqual(((ContactOperation.Identify) contactOperation).getIdentifier(), lastContactIdentity.getNamedUserId())) || (identifier != null && !Intrinsics.areEqual(identifier, ((ContactOperation.Identify) contactOperation).getIdentifier()))) {
                    break;
                }
                identifier = ((ContactOperation.Identify) contactOperation).getIdentifier();
            } else if (contactOperation instanceof ContactOperation.Update) {
                ContactOperation.Update update = (ContactOperation.Update) contactOperation;
                List<TagGroupsMutation> tags = update.getTags();
                if (tags != null) {
                    arrayList2.addAll(tags);
                }
                List<AttributeMutation> attributes = update.getAttributes();
                if (attributes != null) {
                    arrayList3.addAll(attributes);
                }
                List<ScopedSubscriptionListMutation> subscriptions = update.getSubscriptions();
                if (subscriptions != null) {
                    arrayList4.addAll(subscriptions);
                }
            } else {
                int i = 2;
                if (contactOperation instanceof ContactOperation.RegisterSms) {
                    ContactOperation.RegisterSms registerSms = (ContactOperation.RegisterSms) contactOperation;
                    arrayList5.add(new ContactChannelMutation.Associate(new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Pending(registerSms.getMsisdn(), registerSms.getOptions())), b2 == true ? 1 : 0, i, b == true ? 1 : 0));
                } else if (contactOperation instanceof ContactOperation.RegisterEmail) {
                    ContactOperation.RegisterEmail registerEmail = (ContactOperation.RegisterEmail) contactOperation;
                    arrayList5.add(new ContactChannelMutation.Associate(new ContactChannel.Email(new ContactChannel.Email.RegistrationInfo.Pending(registerEmail.getEmailAddress(), registerEmail.getOptions())), b4 == true ? 1 : 0, i, b3 == true ? 1 : 0));
                } else if (contactOperation instanceof ContactOperation.DisassociateChannel) {
                    arrayList5.add(new ContactChannelMutation.Disassociated(((ContactOperation.DisassociateChannel) contactOperation).getChannel(), str, i, b5 == true ? 1 : 0));
                } else if (contactOperation instanceof ContactOperation.AssociateChannel) {
                    ContactOperation.AssociateChannel associateChannel = (ContactOperation.AssociateChannel) contactOperation;
                    arrayList5.add(new ContactChannelMutation.AssociateAnon(associateChannel.getChannelId(), associateChannel.getChannelType()));
                }
            }
        }
        return new AudienceOverrides.Contact(arrayList2, arrayList3, arrayList4, arrayList5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OperationGroup prepareNextOperationGroup() {
        List<OperationEntry> mutableList = CollectionsKt.toMutableList((Collection) getOperations());
        if (mutableList.isEmpty()) {
            return null;
        }
        OperationEntry operationEntry = (OperationEntry) mutableList.remove(0);
        ContactOperation operation = operationEntry.getOperation();
        if (operation instanceof ContactOperation.Update) {
            List listMutableListOf = CollectionsKt.mutableListOf(operationEntry);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            List<TagGroupsMutation> tags = ((ContactOperation.Update) operationEntry.getOperation()).getTags();
            if (tags != null) {
                arrayList.addAll(tags);
            }
            List<AttributeMutation> attributes = ((ContactOperation.Update) operationEntry.getOperation()).getAttributes();
            if (attributes != null) {
                arrayList2.addAll(attributes);
            }
            List<ScopedSubscriptionListMutation> subscriptions = ((ContactOperation.Update) operationEntry.getOperation()).getSubscriptions();
            if (subscriptions != null) {
                arrayList3.addAll(subscriptions);
            }
            for (OperationEntry operationEntry2 : mutableList) {
                if (!(operationEntry2.getOperation() instanceof ContactOperation.Update)) {
                    break;
                }
                List<TagGroupsMutation> tags2 = ((ContactOperation.Update) operationEntry2.getOperation()).getTags();
                if (tags2 != null) {
                    arrayList.addAll(tags2);
                }
                List<AttributeMutation> attributes2 = ((ContactOperation.Update) operationEntry2.getOperation()).getAttributes();
                if (attributes2 != null) {
                    arrayList2.addAll(attributes2);
                }
                List<ScopedSubscriptionListMutation> subscriptions2 = ((ContactOperation.Update) operationEntry2.getOperation()).getSubscriptions();
                if (subscriptions2 != null) {
                    arrayList3.addAll(subscriptions2);
                }
                listMutableListOf.add(operationEntry2);
            }
            return new OperationGroup(listMutableListOf, new ContactOperation.Update(TagGroupsMutation.collapseMutations(arrayList), AttributeMutation.collapseMutations(arrayList2), ScopedSubscriptionListMutation.collapseMutations(arrayList3)));
        }
        if (operation instanceof ContactOperation.Reset ? true : operation instanceof ContactOperation.Identify) {
            if (getHasAnonDate()) {
                return new OperationGroup(CollectionsKt.listOf(operationEntry), operationEntry.getOperation());
            }
            List listMutableListOf2 = CollectionsKt.mutableListOf(operationEntry);
            for (OperationEntry operationEntry3 : mutableList) {
                if (!(operationEntry3.getOperation() instanceof ContactOperation.Reset) && !(operationEntry3.getOperation() instanceof ContactOperation.Identify)) {
                    break;
                }
                listMutableListOf2.add(operationEntry3);
            }
            return new OperationGroup(listMutableListOf2, ((OperationEntry) CollectionsKt.last(listMutableListOf2)).getOperation());
        }
        return new OperationGroup(CollectionsKt.listOf(operationEntry), operationEntry.getOperation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String tokenIfValid() {
        AuthToken authToken = (AuthToken) this.cachedAuthToken.get();
        if (authToken == null || !Intrinsics.areEqual(authToken.getIdentifier(), getLastContactId()) || this.clock.currentTimeMillis() > authToken.getExpirationDateMillis() - 30000) {
            return null;
        }
        return authToken.getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearSkippableOperations() {
        ReentrantLock reentrantLock = this.operationLock;
        reentrantLock.lock();
        try {
            List operations = getOperations();
            ArrayList arrayList = new ArrayList();
            for (Object obj : operations) {
                if (!isSkippable(((OperationEntry) obj).getOperation())) {
                    arrayList.add(obj);
                }
            }
            setOperations(arrayList);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private final boolean isSkippable(ContactOperation operation) {
        if (operation instanceof ContactOperation.Update) {
            ContactOperation.Update update = (ContactOperation.Update) operation;
            List<AttributeMutation> attributes = update.getAttributes();
            if (attributes != null && !attributes.isEmpty()) {
                return false;
            }
            List<TagGroupsMutation> tags = update.getTags();
            if (tags != null && !tags.isEmpty()) {
                return false;
            }
            List<ScopedSubscriptionListMutation> subscriptions = update.getSubscriptions();
            return subscriptions == null || subscriptions.isEmpty();
        }
        if (operation instanceof ContactOperation.Identify) {
            String identifier = ((ContactOperation.Identify) operation).getIdentifier();
            ContactIdentity lastContactIdentity = getLastContactIdentity();
            return Intrinsics.areEqual(identifier, lastContactIdentity != null ? lastContactIdentity.getNamedUserId() : null) && tokenIfValid() != null;
        }
        if (operation instanceof ContactOperation.Reset) {
            ContactIdentity lastContactIdentity2 = getLastContactIdentity();
            return (lastContactIdentity2 == null || !lastContactIdentity2.getIsAnonymous() || getHasAnonDate() || tokenIfValid() == null) ? false : true;
        }
        if (operation instanceof ContactOperation.Resolve) {
            return tokenIfValid() != null;
        }
        if (!(operation instanceof ContactOperation.Verify)) {
            return false;
        }
        ContactIdentity lastContactIdentity3 = getLastContactIdentity();
        Long resolveDateMs = lastContactIdentity3 != null ? lastContactIdentity3.getResolveDateMs() : null;
        return resolveDateMs != null && ((ContactOperation.Verify) operation).getDateMs() <= resolveDateMs.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performOperation(ContactOperation contactOperation, Continuation continuation) {
        if (isSkippable(contactOperation)) {
            return Boxing.boxBoolean(true);
        }
        String id = this.channel.getId();
        if (id == null) {
            return Boxing.boxBoolean(false);
        }
        if (contactOperation instanceof ContactOperation.Reset) {
            return performReset(id, continuation);
        }
        if (contactOperation instanceof ContactOperation.Identify) {
            return performIdentify(id, (ContactOperation.Identify) contactOperation, continuation);
        }
        if (!(contactOperation instanceof ContactOperation.Resolve) && !(contactOperation instanceof ContactOperation.Verify)) {
            if (contactOperation instanceof ContactOperation.Update) {
                return performUpdate((ContactOperation.Update) contactOperation, continuation);
            }
            if (contactOperation instanceof ContactOperation.AssociateChannel) {
                return performAssociateChannel((ContactOperation.AssociateChannel) contactOperation, continuation);
            }
            if (contactOperation instanceof ContactOperation.RegisterEmail) {
                return performRegisterEmail((ContactOperation.RegisterEmail) contactOperation, continuation);
            }
            if (contactOperation instanceof ContactOperation.RegisterSms) {
                return performRegisterSms((ContactOperation.RegisterSms) contactOperation, continuation);
            }
            if (contactOperation instanceof ContactOperation.RegisterOpen) {
                return performRegisterOpen((ContactOperation.RegisterOpen) contactOperation, continuation);
            }
            if (contactOperation instanceof ContactOperation.DisassociateChannel) {
                return performDisassociateChannel((ContactOperation.DisassociateChannel) contactOperation, continuation);
            }
            if (contactOperation instanceof ContactOperation.Resend) {
                return performResend((ContactOperation.Resend) contactOperation, continuation);
            }
            throw new NoWhenBranchMatchedException();
        }
        return performResolve(id, continuation);
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performReset$2, reason: invalid class name and case insensitive filesystem */
    static final class C11142 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $channelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11142(String str, Continuation continuation) {
            super(1, continuation);
            this.$channelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C11142(this.$channelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C11142) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws RequestException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ContactApiClient contactApiClient = ContactManager.this.contactApiClient;
                String str = this.$channelId;
                String possiblyOrphanedContactId = ContactManager.this.getPossiblyOrphanedContactId();
                this.label = 1;
                obj = contactApiClient.reset(str, possiblyOrphanedContactId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RequestResult requestResult = (RequestResult) obj;
            if (requestResult.getValue() != null && requestResult.isSuccessful()) {
                ContactManager.this.updateContactIdentity((ContactApiClient.IdentityResult) requestResult.getValue(), null, false);
            }
            if (!requestResult.isSuccessful() && !requestResult.isClientError()) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performReset(String str, Continuation continuation) {
        return doIdentify(new C11142(str, null), continuation);
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performIdentify$2, reason: invalid class name and case insensitive filesystem */
    static final class C11082 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $channelId;
        final /* synthetic */ ContactOperation.Identify $operation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11082(String str, ContactOperation.Identify identify, Continuation continuation) {
            super(1, continuation);
            this.$channelId = str;
            this.$operation = identify;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C11082(this.$channelId, this.$operation, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C11082) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws RequestException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ContactApiClient contactApiClient = ContactManager.this.contactApiClient;
                String str = this.$channelId;
                ContactIdentity lastContactIdentity = ContactManager.this.getLastContactIdentity();
                String contactId = lastContactIdentity != null ? lastContactIdentity.getContactId() : null;
                String identifier = this.$operation.getIdentifier();
                String possiblyOrphanedContactId = ContactManager.this.getPossiblyOrphanedContactId();
                this.label = 1;
                obj = contactApiClient.identify(str, contactId, identifier, possiblyOrphanedContactId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RequestResult requestResult = (RequestResult) obj;
            if (requestResult.getValue() != null && requestResult.isSuccessful()) {
                ContactManager.this.updateContactIdentity((ContactApiClient.IdentityResult) requestResult.getValue(), this.$operation.getIdentifier(), false);
            }
            if (!requestResult.isSuccessful() && !requestResult.isClientError()) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performIdentify(String str, ContactOperation.Identify identify, Continuation continuation) {
        return doIdentify(new C11082(str, identify, null), continuation);
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$performResolve$2, reason: invalid class name and case insensitive filesystem */
    static final class C11152 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $channelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11152(String str, Continuation continuation) {
            super(1, continuation);
            this.$channelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C11152(this.$channelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C11152) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws RequestException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ContactApiClient contactApiClient = ContactManager.this.contactApiClient;
                String str = this.$channelId;
                ContactIdentity lastContactIdentity = ContactManager.this.getLastContactIdentity();
                String contactId = lastContactIdentity != null ? lastContactIdentity.getContactId() : null;
                String possiblyOrphanedContactId = ContactManager.this.getPossiblyOrphanedContactId();
                this.label = 1;
                obj = contactApiClient.resolve(str, contactId, possiblyOrphanedContactId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RequestResult requestResult = (RequestResult) obj;
            if (requestResult.getValue() != null && requestResult.isSuccessful()) {
                ContactManager.this.updateContactIdentity((ContactApiClient.IdentityResult) requestResult.getValue(), null, true);
            }
            if (!requestResult.isSuccessful() && !requestResult.isClientError()) {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performResolve(String str, Continuation continuation) {
        return doIdentify(new C11152(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performUpdate(com.urbanairship.contacts.ContactOperation.Update r18, kotlin.coroutines.Continuation r19) throws com.urbanairship.http.RequestException {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.urbanairship.contacts.ContactManager.C11161
            if (r2 == 0) goto L18
            r2 = r1
            com.urbanairship.contacts.ContactManager$performUpdate$1 r2 = (com.urbanairship.contacts.ContactManager.C11161) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r8 = r2
            goto L1e
        L18:
            com.urbanairship.contacts.ContactManager$performUpdate$1 r2 = new com.urbanairship.contacts.ContactManager$performUpdate$1
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r9 = 0
            r10 = 1
            if (r3 == 0) goto L47
            if (r3 != r10) goto L3f
            java.lang.Object r0 = r8.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r8.L$1
            com.urbanairship.contacts.ContactOperation$Update r2 = (com.urbanairship.contacts.ContactOperation.Update) r2
            java.lang.Object r3 = r8.L$0
            com.urbanairship.contacts.ContactManager r3 = (com.urbanairship.contacts.ContactManager) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r0
            r13 = r2
            r11 = r3
            goto L79
        L3f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L47:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r1 = r17.getLastContactId()
            if (r1 != 0) goto L55
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r0
        L55:
            com.urbanairship.contacts.ContactApiClient r3 = r0.contactApiClient
            java.util.List r5 = r18.getTags()
            java.util.List r6 = r18.getAttributes()
            java.util.List r7 = r18.getSubscriptions()
            r8.L$0 = r0
            r11 = r18
            r8.L$1 = r11
            r8.L$2 = r1
            r8.label = r10
            r4 = r1
            java.lang.Object r3 = r3.update(r4, r5, r6, r7, r8)
            if (r3 != r2) goto L75
            return r2
        L75:
            r12 = r1
            r1 = r3
            r13 = r11
            r11 = r0
        L79:
            com.urbanairship.http.RequestResult r1 = (com.urbanairship.http.RequestResult) r1
            boolean r0 = r1.isSuccessful()
            if (r0 == 0) goto L88
            r15 = 4
            r16 = 0
            r14 = 0
            contactUpdated$default(r11, r12, r13, r14, r15, r16)
        L88:
            boolean r0 = r1.isSuccessful()
            if (r0 != 0) goto L94
            boolean r0 = r1.isClientError()
            if (r0 == 0) goto L95
        L94:
            r9 = r10
        L95:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.performUpdate(com.urbanairship.contacts.ContactOperation$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.contacts.ContactManager$doIdentify$2, reason: invalid class name and case insensitive filesystem */
    static final class C11052 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function1 $operation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11052(Function1 function1, Continuation continuation) {
            super(1, continuation);
            this.$operation = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C11052(this.$operation, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C11052) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r10)
                goto L63
            L15:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1d:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L58
            L21:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L4d
            L25:
                kotlin.ResultKt.throwOnFailure(r10)
                com.urbanairship.contacts.ContactManager r10 = com.urbanairship.contacts.ContactManager.this
                long r5 = com.urbanairship.contacts.ContactManager.access$getLastIdentifyTimeMs$p(r10)
                java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.SECONDS
                r7 = 5
                long r7 = r10.toMillis(r7)
                long r5 = r5 + r7
                com.urbanairship.util.Clock r10 = com.urbanairship.util.Clock.DEFAULT_CLOCK
                long r7 = r10.currentTimeMillis()
                long r5 = r5 - r7
                r7 = 0
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 <= 0) goto L4d
                r9.label = r4
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r5, r9)
                if (r10 != r0) goto L4d
                return r0
            L4d:
                r9.label = r3
                r3 = 200(0xc8, double:9.9E-322)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r3, r9)
                if (r10 != r0) goto L58
                return r0
            L58:
                kotlin.jvm.functions.Function1 r10 = r9.$operation
                r9.label = r2
                java.lang.Object r10 = r10.invoke(r9)
                if (r10 != r0) goto L63
                return r0
            L63:
                java.lang.Boolean r10 = (java.lang.Boolean) r10
                boolean r10 = r10.booleanValue()
                com.urbanairship.contacts.ContactManager r9 = com.urbanairship.contacts.ContactManager.this
                com.urbanairship.util.Clock r0 = com.urbanairship.util.Clock.DEFAULT_CLOCK
                long r0 = r0.currentTimeMillis()
                com.urbanairship.contacts.ContactManager.access$setLastIdentifyTimeMs$p(r9, r0)
                java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.C11052.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doIdentify(Function1 function1, Continuation continuation) {
        return this.identifyOperationQueue.run(new C11052(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performAssociateChannel(com.urbanairship.contacts.ContactOperation.AssociateChannel r12, kotlin.coroutines.Continuation r13) throws com.urbanairship.http.RequestException {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.urbanairship.contacts.ContactManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r13
            com.urbanairship.contacts.ContactManager$performAssociateChannel$1 r0 = (com.urbanairship.contacts.ContactManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.contacts.ContactManager$performAssociateChannel$1 r0 = new com.urbanairship.contacts.ContactManager$performAssociateChannel$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r11 = r0.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.L$1
            com.urbanairship.contacts.ContactOperation$AssociateChannel r12 = (com.urbanairship.contacts.ContactOperation.AssociateChannel) r12
            java.lang.Object r0 = r0.L$0
            com.urbanairship.contacts.ContactManager r0 = (com.urbanairship.contacts.ContactManager) r0
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r11
            r5 = r0
            goto L6a
        L38:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L40:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = r11.getLastContactId()
            if (r13 != 0) goto L4e
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r11
        L4e:
            com.urbanairship.contacts.ContactApiClient r2 = r11.contactApiClient
            java.lang.String r5 = r12.getChannelId()
            com.urbanairship.contacts.ChannelType r6 = r12.getChannelType()
            r0.L$0 = r11
            r0.L$1 = r12
            r0.L$2 = r13
            r0.label = r4
            java.lang.Object r0 = r2.associatedChannel(r13, r5, r6, r0)
            if (r0 != r1) goto L67
            return r1
        L67:
            r5 = r11
            r6 = r13
            r13 = r0
        L6a:
            com.urbanairship.http.RequestResult r13 = (com.urbanairship.http.RequestResult) r13
            java.lang.Object r11 = r13.getValue()
            if (r11 == 0) goto L8b
            boolean r11 = r13.isSuccessful()
            if (r11 == 0) goto L8b
            com.urbanairship.contacts.ContactChannelMutation$AssociateAnon r8 = new com.urbanairship.contacts.ContactChannelMutation$AssociateAnon
            java.lang.String r11 = r12.getChannelId()
            com.urbanairship.contacts.ChannelType r12 = r12.getChannelType()
            r8.<init>(r11, r12)
            r9 = 2
            r10 = 0
            r7 = 0
            contactUpdated$default(r5, r6, r7, r8, r9, r10)
        L8b:
            boolean r11 = r13.isSuccessful()
            if (r11 != 0) goto L97
            boolean r11 = r13.isClientError()
            if (r11 == 0) goto L98
        L97:
            r3 = r4
        L98:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.performAssociateChannel(com.urbanairship.contacts.ContactOperation$AssociateChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performRegisterSms(com.urbanairship.contacts.ContactOperation.RegisterSms r18, kotlin.coroutines.Continuation r19) throws com.urbanairship.http.RequestException {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.urbanairship.contacts.ContactManager.C11121
            if (r2 == 0) goto L18
            r2 = r1
            com.urbanairship.contacts.ContactManager$performRegisterSms$1 r2 = (com.urbanairship.contacts.ContactManager.C11121) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r8 = r2
            goto L1e
        L18:
            com.urbanairship.contacts.ContactManager$performRegisterSms$1 r2 = new com.urbanairship.contacts.ContactManager$performRegisterSms$1
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r9 = 0
            r10 = 1
            if (r3 == 0) goto L46
            if (r3 != r10) goto L3e
            java.lang.Object r0 = r8.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r8.L$1
            com.urbanairship.contacts.ContactOperation$RegisterSms r2 = (com.urbanairship.contacts.ContactOperation.RegisterSms) r2
            java.lang.Object r3 = r8.L$0
            com.urbanairship.contacts.ContactManager r3 = (com.urbanairship.contacts.ContactManager) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r0
            r11 = r3
            goto L7f
        L3e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L46:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r1 = r17.getLastContactId()
            if (r1 != 0) goto L54
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r0
        L54:
            com.urbanairship.contacts.ContactApiClient r3 = r0.contactApiClient
            java.lang.String r5 = r18.getMsisdn()
            com.urbanairship.contacts.SmsRegistrationOptions r6 = r18.getOptions()
            com.urbanairship.locale.LocaleManager r4 = r0.localeManager
            java.util.Locale r7 = r4.getLocale()
            java.lang.String r4 = "getLocale(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r8.L$0 = r0
            r11 = r18
            r8.L$1 = r11
            r8.L$2 = r1
            r8.label = r10
            r4 = r1
            java.lang.Object r3 = r3.registerSms(r4, r5, r6, r7, r8)
            if (r3 != r2) goto L7b
            return r2
        L7b:
            r12 = r1
            r1 = r3
            r2 = r11
            r11 = r0
        L7f:
            com.urbanairship.http.RequestResult r1 = (com.urbanairship.http.RequestResult) r1
            java.lang.Object r0 = r1.getValue()
            if (r0 == 0) goto Lb1
            boolean r0 = r1.isSuccessful()
            if (r0 == 0) goto Lb1
            com.urbanairship.contacts.ContactChannelMutation$Associate r14 = new com.urbanairship.contacts.ContactChannelMutation$Associate
            com.urbanairship.contacts.ContactChannel$Sms r0 = new com.urbanairship.contacts.ContactChannel$Sms
            com.urbanairship.contacts.ContactChannel$Sms$RegistrationInfo$Pending r3 = new com.urbanairship.contacts.ContactChannel$Sms$RegistrationInfo$Pending
            java.lang.String r4 = r2.getMsisdn()
            com.urbanairship.contacts.SmsRegistrationOptions r2 = r2.getOptions()
            r3.<init>(r4, r2)
            r0.<init>(r3)
            java.lang.Object r2 = r1.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r14.<init>(r0, r2)
            r15 = 2
            r16 = 0
            r13 = 0
            contactUpdated$default(r11, r12, r13, r14, r15, r16)
        Lb1:
            boolean r0 = r1.isSuccessful()
            if (r0 != 0) goto Lbd
            boolean r0 = r1.isClientError()
            if (r0 == 0) goto Lbe
        Lbd:
            r9 = r10
        Lbe:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.performRegisterSms(com.urbanairship.contacts.ContactOperation$RegisterSms, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performRegisterEmail(com.urbanairship.contacts.ContactOperation.RegisterEmail r18, kotlin.coroutines.Continuation r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r1 instanceof com.urbanairship.contacts.ContactManager.C11101
            if (r2 == 0) goto L18
            r2 = r1
            com.urbanairship.contacts.ContactManager$performRegisterEmail$1 r2 = (com.urbanairship.contacts.ContactManager.C11101) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r8 = r2
            goto L1e
        L18:
            com.urbanairship.contacts.ContactManager$performRegisterEmail$1 r2 = new com.urbanairship.contacts.ContactManager$performRegisterEmail$1
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r8.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r8.label
            r9 = 0
            r10 = 1
            if (r3 == 0) goto L46
            if (r3 != r10) goto L3e
            java.lang.Object r0 = r8.L$2
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r8.L$1
            com.urbanairship.contacts.ContactOperation$RegisterEmail r2 = (com.urbanairship.contacts.ContactOperation.RegisterEmail) r2
            java.lang.Object r3 = r8.L$0
            com.urbanairship.contacts.ContactManager r3 = (com.urbanairship.contacts.ContactManager) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r0
            r11 = r3
            goto L7f
        L3e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L46:
            kotlin.ResultKt.throwOnFailure(r1)
            java.lang.String r1 = r17.getLastContactId()
            if (r1 != 0) goto L54
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r0
        L54:
            com.urbanairship.contacts.ContactApiClient r3 = r0.contactApiClient
            java.lang.String r5 = r18.getEmailAddress()
            com.urbanairship.contacts.EmailRegistrationOptions r6 = r18.getOptions()
            com.urbanairship.locale.LocaleManager r4 = r0.localeManager
            java.util.Locale r7 = r4.getLocale()
            java.lang.String r4 = "getLocale(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r8.L$0 = r0
            r11 = r18
            r8.L$1 = r11
            r8.L$2 = r1
            r8.label = r10
            r4 = r1
            java.lang.Object r3 = r3.registerEmail(r4, r5, r6, r7, r8)
            if (r3 != r2) goto L7b
            return r2
        L7b:
            r12 = r1
            r1 = r3
            r2 = r11
            r11 = r0
        L7f:
            com.urbanairship.http.RequestResult r1 = (com.urbanairship.http.RequestResult) r1
            java.lang.Object r0 = r1.getValue()
            if (r0 == 0) goto Lb1
            boolean r0 = r1.isSuccessful()
            if (r0 == 0) goto Lb1
            com.urbanairship.contacts.ContactChannelMutation$Associate r14 = new com.urbanairship.contacts.ContactChannelMutation$Associate
            com.urbanairship.contacts.ContactChannel$Email r0 = new com.urbanairship.contacts.ContactChannel$Email
            com.urbanairship.contacts.ContactChannel$Email$RegistrationInfo$Pending r3 = new com.urbanairship.contacts.ContactChannel$Email$RegistrationInfo$Pending
            java.lang.String r4 = r2.getEmailAddress()
            com.urbanairship.contacts.EmailRegistrationOptions r2 = r2.getOptions()
            r3.<init>(r4, r2)
            r0.<init>(r3)
            java.lang.Object r2 = r1.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r14.<init>(r0, r2)
            r15 = 2
            r16 = 0
            r13 = 0
            contactUpdated$default(r11, r12, r13, r14, r15, r16)
        Lb1:
            boolean r0 = r1.isSuccessful()
            if (r0 != 0) goto Lbd
            boolean r0 = r1.isClientError()
            if (r0 == 0) goto Lbe
        Lbd:
            r9 = r10
        Lbe:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.performRegisterEmail(com.urbanairship.contacts.ContactOperation$RegisterEmail, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performRegisterOpen(com.urbanairship.contacts.ContactOperation.RegisterOpen r10, kotlin.coroutines.Continuation r11) throws com.urbanairship.http.RequestException {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.urbanairship.contacts.ContactManager.C11111
            if (r0 == 0) goto L14
            r0 = r11
            com.urbanairship.contacts.ContactManager$performRegisterOpen$1 r0 = (com.urbanairship.contacts.ContactManager.C11111) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.urbanairship.contacts.ContactManager$performRegisterOpen$1 r0 = new com.urbanairship.contacts.ContactManager$performRegisterOpen$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r7 = 0
            r8 = 1
            if (r1 == 0) goto L3e
            if (r1 != r8) goto L36
            java.lang.Object r9 = r6.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r6.L$0
            com.urbanairship.contacts.ContactManager r10 = (com.urbanairship.contacts.ContactManager) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r2 = r9
            r1 = r10
            goto L72
        L36:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3e:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = r9.getLastContactId()
            if (r11 != 0) goto L4c
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r9
        L4c:
            com.urbanairship.contacts.ContactApiClient r1 = r9.contactApiClient
            java.lang.String r3 = r10.getAddress()
            com.urbanairship.contacts.OpenChannelRegistrationOptions r4 = r10.getOptions()
            com.urbanairship.locale.LocaleManager r10 = r9.localeManager
            java.util.Locale r5 = r10.getLocale()
            java.lang.String r10 = "getLocale(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)
            r6.L$0 = r9
            r6.L$1 = r11
            r6.label = r8
            r2 = r11
            java.lang.Object r10 = r1.registerOpen(r2, r3, r4, r5, r6)
            if (r10 != r0) goto L6f
            return r0
        L6f:
            r1 = r9
            r2 = r11
            r11 = r10
        L72:
            com.urbanairship.http.RequestResult r11 = (com.urbanairship.http.RequestResult) r11
            java.lang.Object r9 = r11.getValue()
            if (r9 == 0) goto L93
            boolean r9 = r11.isSuccessful()
            if (r9 == 0) goto L93
            com.urbanairship.contacts.ContactChannelMutation$AssociateAnon r4 = new com.urbanairship.contacts.ContactChannelMutation$AssociateAnon
            java.lang.Object r9 = r11.getValue()
            java.lang.String r9 = (java.lang.String) r9
            com.urbanairship.contacts.ChannelType r10 = com.urbanairship.contacts.ChannelType.OPEN
            r4.<init>(r9, r10)
            r5 = 2
            r6 = 0
            r3 = 0
            contactUpdated$default(r1, r2, r3, r4, r5, r6)
        L93:
            boolean r9 = r11.isSuccessful()
            if (r9 != 0) goto L9f
            boolean r9 = r11.isClientError()
            if (r9 == 0) goto La0
        L9f:
            r7 = r8
        La0:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.performRegisterOpen(com.urbanairship.contacts.ContactOperation$RegisterOpen, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performResend(com.urbanairship.contacts.ContactOperation.Resend r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.performResend(com.urbanairship.contacts.ContactOperation$Resend, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performDisassociateChannel(com.urbanairship.contacts.ContactOperation.DisassociateChannel r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.performDisassociateChannel(com.urbanairship.contacts.ContactOperation$DisassociateChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContactIdentity(ContactApiClient.IdentityResult result, String namedUserId, boolean isResolve) {
        String namedUserId2;
        ReentrantLock reentrantLock = this.identityLock;
        reentrantLock.lock();
        try {
            this.cachedAuthToken.set(new AuthToken(result.getContactId(), result.getToken(), result.getTokenExpiryDateMs()), result.getTokenExpiryDateMs());
            String contactId = result.getContactId();
            ContactIdentity lastContactIdentity = getLastContactIdentity();
            if (Intrinsics.areEqual(contactId, lastContactIdentity != null ? lastContactIdentity.getContactId() : null) && namedUserId == null) {
                ContactIdentity lastContactIdentity2 = getLastContactIdentity();
                namedUserId2 = lastContactIdentity2 != null ? lastContactIdentity2.getNamedUserId() : null;
            } else {
                namedUserId2 = namedUserId;
            }
            ContactIdentity contactIdentity = new ContactIdentity(result.getContactId(), result.isAnonymous(), namedUserId2, Long.valueOf(this.clock.currentTimeMillis()));
            if (getLastContactIdentity() != null) {
                String contactId2 = contactIdentity.getContactId();
                ContactIdentity lastContactIdentity3 = getLastContactIdentity();
                if (!Intrinsics.areEqual(contactId2, lastContactIdentity3 != null ? lastContactIdentity3.getContactId() : null) && getHasAnonDate()) {
                    AnonContactData anonData = getAnonData();
                    if (anonData == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    Channel channel = this.conflictEvents;
                    Map<String, Set<String>> tagGroups = anonData.getTagGroups();
                    Map<String, Set<Scope>> subscriptionLists = anonData.getSubscriptionLists();
                    Map<String, JsonValue> attributes = anonData.getAttributes();
                    List<AnonChannel> associatedChannels = anonData.getAssociatedChannels();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(associatedChannels, 10));
                    for (AnonChannel anonChannel : associatedChannels) {
                        arrayList.add(new ConflictEvent.ChannelInfo(anonChannel.getChannelId(), anonChannel.getChannelType()));
                    }
                    channel.mo3620trySendJP2dKIU(new ConflictEvent(tagGroups, attributes, subscriptionLists, arrayList, namedUserId));
                    setAnonData(null);
                }
            }
            if (!contactIdentity.getIsAnonymous()) {
                setAnonData(null);
            }
            if (getLastContactIdentity() != null) {
                String contactId3 = contactIdentity.getContactId();
                ContactIdentity lastContactIdentity4 = getLastContactIdentity();
                if (!Intrinsics.areEqual(contactId3, lastContactIdentity4 != null ? lastContactIdentity4.getContactId() : null) && isResolve) {
                    ReentrantLock reentrantLock2 = this.operationLock;
                    reentrantLock2.lock();
                    try {
                        List operations = getOperations();
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj : operations) {
                            if (result.getChannelAssociatedDateMs() < ((OperationEntry) obj).getDateMillis()) {
                                arrayList2.add(obj);
                            }
                        }
                        setOperations(arrayList2);
                        Unit unit = Unit.INSTANCE;
                        reentrantLock2.unlock();
                    } finally {
                        reentrantLock2.unlock();
                    }
                }
            }
            setLastContactIdentity(contactIdentity);
            Unit unit2 = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    static /* synthetic */ void contactUpdated$default(ContactManager contactManager, String str, ContactOperation.Update update, ContactChannelMutation contactChannelMutation, int i, Object obj) {
        if ((i & 2) != 0) {
            update = null;
        }
        if ((i & 4) != 0) {
            contactChannelMutation = null;
        }
        contactManager.contactUpdated(str, update, contactChannelMutation);
    }

    private final void contactUpdated(String contactId, ContactOperation.Update updateOperation, ContactChannelMutation channelUpdate) {
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        if (Intrinsics.areEqual(contactId, lastContactIdentity != null ? lastContactIdentity.getContactId() : null)) {
            this.audienceOverridesProvider.recordContactUpdate$urbanairship_core_release(contactId, updateOperation != null ? updateOperation.getTags() : null, updateOperation != null ? updateOperation.getAttributes() : null, updateOperation != null ? updateOperation.getSubscriptions() : null, channelUpdate);
            ContactIdentity lastContactIdentity2 = getLastContactIdentity();
            if (lastContactIdentity2 == null || !lastContactIdentity2.getIsAnonymous()) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            AnonContactData anonData = getAnonData();
            if (anonData != null) {
                linkedHashMap.putAll(anonData.getAttributes());
                for (Map.Entry<String, Set<String>> entry : anonData.getTagGroups().entrySet()) {
                    String key = entry.getKey();
                    Object linkedHashSet2 = linkedHashMap2.get(key);
                    if (linkedHashSet2 == null) {
                        linkedHashSet2 = new LinkedHashSet();
                        linkedHashMap2.put(key, linkedHashSet2);
                    }
                    ((Set) linkedHashSet2).addAll(entry.getValue());
                }
                linkedHashSet.addAll(anonData.getAssociatedChannels());
                for (Map.Entry<String, Set<Scope>> entry2 : anonData.getSubscriptionLists().entrySet()) {
                    String key2 = entry2.getKey();
                    Object linkedHashSet3 = linkedHashMap3.get(key2);
                    if (linkedHashSet3 == null) {
                        linkedHashSet3 = new LinkedHashSet();
                        linkedHashMap3.put(key2, linkedHashSet3);
                    }
                    ((Set) linkedHashSet3).addAll(entry2.getValue());
                }
            }
            if (updateOperation != null) {
                List<AttributeMutation> attributes = updateOperation.getAttributes();
                if (attributes != null) {
                    for (AttributeMutation attributeMutation : attributes) {
                        String str = attributeMutation.action;
                        if (Intrinsics.areEqual(str, AttributeMutation.ATTRIBUTE_ACTION_SET)) {
                            String name = attributeMutation.name;
                            Intrinsics.checkNotNullExpressionValue(name, "name");
                            JsonValue value = attributeMutation.value;
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            linkedHashMap.put(name, value);
                        } else if (Intrinsics.areEqual(str, AttributeMutation.ATTRIBUTE_ACTION_REMOVE)) {
                            linkedHashMap.remove(attributeMutation.name);
                        }
                    }
                }
                List<TagGroupsMutation> tags = updateOperation.getTags();
                if (tags != null) {
                    Iterator<T> it = tags.iterator();
                    while (it.hasNext()) {
                        ((TagGroupsMutation) it.next()).apply(linkedHashMap2);
                    }
                }
                List<ScopedSubscriptionListMutation> subscriptions = updateOperation.getSubscriptions();
                if (subscriptions != null) {
                    Iterator<T> it2 = subscriptions.iterator();
                    while (it2.hasNext()) {
                        ((ScopedSubscriptionListMutation) it2.next()).apply(linkedHashMap3);
                    }
                }
            }
            if (channelUpdate instanceof ContactChannelMutation.AssociateAnon) {
                ContactChannelMutation.AssociateAnon associateAnon = (ContactChannelMutation.AssociateAnon) channelUpdate;
                linkedHashSet.add(new AnonChannel(associateAnon.getChannelId(), associateAnon.getChannelType()));
            } else if (channelUpdate instanceof ContactChannelMutation.Associate) {
                ContactChannelMutation.Associate associate = (ContactChannelMutation.Associate) channelUpdate;
                if (associate.getChannelId() != null) {
                    linkedHashSet.add(new AnonChannel(associate.getChannelId(), associate.getChannel().getChannelType()));
                }
            } else if (channelUpdate instanceof ContactChannelMutation.Disassociated) {
                ContactChannelMutation.Disassociated disassociated = (ContactChannelMutation.Disassociated) channelUpdate;
                if (disassociated.getChannelId() != null) {
                    linkedHashSet.remove(new AnonChannel(disassociated.getChannelId(), disassociated.getChannel().getChannelType()));
                }
            }
            setAnonData(new AnonContactData(linkedHashMap2, linkedHashMap, linkedHashMap3, CollectionsKt.toList(linkedHashSet)));
        }
    }

    private static final class OperationGroup {
        private final ContactOperation merged;
        private final List operations;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OperationGroup)) {
                return false;
            }
            OperationGroup operationGroup = (OperationGroup) obj;
            return Intrinsics.areEqual(this.operations, operationGroup.operations) && Intrinsics.areEqual(this.merged, operationGroup.merged);
        }

        public int hashCode() {
            return (this.operations.hashCode() * 31) + this.merged.hashCode();
        }

        public String toString() {
            return "OperationGroup(operations=" + this.operations + ", merged=" + this.merged + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public OperationGroup(List operations, ContactOperation merged) {
            Intrinsics.checkNotNullParameter(operations, "operations");
            Intrinsics.checkNotNullParameter(merged, "merged");
            this.operations = operations;
            this.merged = merged;
        }

        public final ContactOperation getMerged() {
            return this.merged;
        }

        public final List getOperations() {
            return this.operations;
        }
    }

    private static final class OperationEntry implements JsonSerializable {
        private final long dateMillis;
        private final String identifier;
        private final ContactOperation operation;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OperationEntry)) {
                return false;
            }
            OperationEntry operationEntry = (OperationEntry) obj;
            return this.dateMillis == operationEntry.dateMillis && Intrinsics.areEqual(this.operation, operationEntry.operation) && Intrinsics.areEqual(this.identifier, operationEntry.identifier);
        }

        public int hashCode() {
            return (((Long.hashCode(this.dateMillis) * 31) + this.operation.hashCode()) * 31) + this.identifier.hashCode();
        }

        public String toString() {
            return "OperationEntry(dateMillis=" + this.dateMillis + ", operation=" + this.operation + ", identifier=" + this.identifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public OperationEntry(long j, ContactOperation operation, String identifier) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.dateMillis = j;
            this.operation = operation;
            this.identifier = identifier;
        }

        public final long getDateMillis() {
            return this.dateMillis;
        }

        public final ContactOperation getOperation() {
            return this.operation;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ OperationEntry(long j, ContactOperation contactOperation, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 4) != 0) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            }
            this(j, contactOperation, str);
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Removed duplicated region for block: B:121:0x02f8  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0193  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public OperationEntry(com.urbanairship.json.JsonValue r24) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 859
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.contacts.ContactManager.OperationEntry.<init>(com.urbanairship.json.JsonValue):void");
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("timestamp", Long.valueOf(this.dateMillis)), TuplesKt.to("operation", this.operation), TuplesKt.to("identifier", this.identifier)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
