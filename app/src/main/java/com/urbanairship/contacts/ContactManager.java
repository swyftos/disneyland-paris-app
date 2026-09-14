package com.urbanairship.contacts;

import androidx.annotation.OpenForTesting;
import androidx.camera.video.AudioStats;
import androidx.core.util.Predicate;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.p193serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.AirshipDispatchers;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.TagGroupsMutation;
import com.urbanairship.http.AuthToken;
import com.urbanairship.http.AuthTokenProvider;
import com.urbanairship.http.RequestException;
import com.urbanairship.http.RequestResult;
import com.urbanairship.job.JobDispatcher;
import com.urbanairship.job.JobInfo;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
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
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 ¤\u00012\u00020\u0001:\u0006¤\u0001¥\u0001¦\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0015\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b\\J\b\u0010]\u001a\u00020YH\u0002J(\u0010^\u001a\u00020Y2\u0006\u0010_\u001a\u00020\u00172\n\b\u0002\u0010`\u001a\u0004\u0018\u00010a2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010cH\u0002J\u0012\u0010d\u001a\u00020Y2\b\b\u0002\u0010e\u001a\u00020fH\u0002J,\u0010g\u001a\u0002062\u001c\u0010Z\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002060i\u0012\u0006\u0012\u0004\u0018\u00010j0hH\u0082@¢\u0006\u0002\u0010kJ\u0016\u0010l\u001a\u00020Y2\u0006\u0010m\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010nJ$\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00170p2\u0006\u0010q\u001a\u00020\u0017H\u0096@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010nJ\r\u0010s\u001a\u00020YH\u0000¢\u0006\u0002\btJ\u0010\u0010u\u001a\u00020v2\u0006\u0010_\u001a\u00020\u0017H\u0002J\u0010\u0010w\u001a\u0002062\u0006\u0010Z\u001a\u00020[H\u0002J\u0016\u0010x\u001a\u0002062\u0006\u0010Z\u001a\u00020yH\u0082@¢\u0006\u0002\u0010zJ\u0016\u0010{\u001a\u0002062\u0006\u0010Z\u001a\u00020|H\u0082@¢\u0006\u0002\u0010}J \u0010~\u001a\u0002062\u0006\u0010\u007f\u001a\u00020\u00172\u0007\u0010Z\u001a\u00030\u0080\u0001H\u0082@¢\u0006\u0003\u0010\u0081\u0001J\u0010\u0010\u0082\u0001\u001a\u000206H\u0086@¢\u0006\u0003\u0010\u0083\u0001J\u0018\u0010\u0084\u0001\u001a\u0002062\u0006\u0010Z\u001a\u00020[H\u0082@¢\u0006\u0003\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u0087\u0001H\u0082@¢\u0006\u0003\u0010\u0088\u0001J\u0019\u0010\u0089\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u008a\u0001H\u0082@¢\u0006\u0003\u0010\u008b\u0001J\u0019\u0010\u008c\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u008d\u0001H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\u0019\u0010\u008f\u0001\u001a\u0002062\u0007\u0010Z\u001a\u00030\u0090\u0001H\u0082@¢\u0006\u0003\u0010\u0091\u0001J\u0017\u0010\u0092\u0001\u001a\u0002062\u0006\u0010\u007f\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010nJ\u0017\u0010\u0093\u0001\u001a\u0002062\u0006\u0010\u007f\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010nJ\u0018\u0010\u0094\u0001\u001a\u0002062\u0006\u0010Z\u001a\u00020aH\u0082@¢\u0006\u0003\u0010\u0095\u0001J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0002J\u000f\u0010\u0098\u0001\u001a\u00020YH\u0000¢\u0006\u0003\b\u0099\u0001J\u001e\u0010\u009a\u0001\u001a\u00020\u00152\t\b\u0002\u0010\u009b\u0001\u001a\u00020KH\u0080@¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u000b\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J&\u0010\u009f\u0001\u001a\u00020Y2\b\u0010 \u0001\u001a\u00030¡\u00012\b\u0010L\u001a\u0004\u0018\u00010\u00172\u0007\u0010¢\u0001\u001a\u000206H\u0002J\t\u0010£\u0001\u001a\u00020YH\u0002R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u00010\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0019\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170-¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0002068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010>\u001a\u0002062\u0006\u0010=\u001a\u000206@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010AR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010B\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\bC\u0010DR(\u0010E\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00198B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010J\u001a\u00020KX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010L\u001a\u0004\u0018\u00010\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010DR\u000e\u0010N\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010T\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bU\u0010DR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006§\u0001"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactManager;", "Lcom/urbanairship/http/AuthTokenProvider;", "preferenceDataStore", "Lcom/urbanairship/PreferenceDataStore;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/channel/AirshipChannel;", "jobDispatcher", "Lcom/urbanairship/job/JobDispatcher;", "contactApiClient", "Lcom/urbanairship/contacts/ContactApiClient;", "localeManager", "Lcom/urbanairship/locale/LocaleManager;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "clock", "Lcom/urbanairship/util/Clock;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/job/JobDispatcher;Lcom/urbanairship/contacts/ContactApiClient;Lcom/urbanairship/locale/LocaleManager;Lcom/urbanairship/audience/AudienceOverridesProvider;Lcom/urbanairship/util/Clock;Lkotlinx/coroutines/CoroutineDispatcher;)V", "_contactIdUpdates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/contacts/ContactIdUpdate;", "_currentNamedUserIdUpdates", "", "_identity", "Lcom/urbanairship/contacts/ContactIdentity;", "_operations", "", "Lcom/urbanairship/contacts/ContactManager$OperationEntry;", "newValue", "Lcom/urbanairship/contacts/AnonContactData;", "anonData", "getAnonData", "()Lcom/urbanairship/contacts/AnonContactData;", "setAnonData", "(Lcom/urbanairship/contacts/AnonContactData;)V", "cachedAuthToken", "Lcom/urbanairship/util/CachedValue;", "Lcom/urbanairship/http/AuthToken;", "conflictEvents", "Lkotlinx/coroutines/channels/Channel;", "Lcom/urbanairship/contacts/ConflictEvent;", "getConflictEvents", "()Lkotlinx/coroutines/channels/Channel;", "contactIdUpdates", "Lkotlinx/coroutines/flow/StateFlow;", "getContactIdUpdates", "()Lkotlinx/coroutines/flow/StateFlow;", "currentContactIdUpdate", "getCurrentContactIdUpdate$urbanairship_core_release", "()Lcom/urbanairship/contacts/ContactIdUpdate;", "currentNamedUserIdUpdates", "getCurrentNamedUserIdUpdates", "hasAnonDate", "", "getHasAnonDate", "()Z", "identifyOperationQueue", "Lcom/urbanairship/util/SerialQueue;", "identityLock", "Ljava/util/concurrent/locks/ReentrantLock;", "value", "isEnabled", "isEnabled$urbanairship_core_release", "setEnabled$urbanairship_core_release", "(Z)V", "lastContactId", "getLastContactId", "()Ljava/lang/String;", "lastContactIdentity", "getLastContactIdentity", "()Lcom/urbanairship/contacts/ContactIdentity;", "setLastContactIdentity", "(Lcom/urbanairship/contacts/ContactIdentity;)V", "lastIdentifyTimeMs", "", "namedUserId", "getNamedUserId$urbanairship_core_release", "operationLock", "operations", "getOperations", "()Ljava/util/List;", "setOperations", "(Ljava/util/List;)V", "possiblyOrphanedContactId", "getPossiblyOrphanedContactId", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addOperation", "", "operation", "Lcom/urbanairship/contacts/ContactOperation;", "addOperation$urbanairship_core_release", "clearSkippableOperations", "contactUpdated", "contactId", "updateOperation", "Lcom/urbanairship/contacts/ContactOperation$Update;", "channelUpdate", "Lcom/urbanairship/contacts/ContactChannelMutation;", "dispatchContactUpdateJob", "conflictStrategy", "", "doIdentify", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expireToken", "token", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchToken", "Lkotlin/Result;", "identifier", "fetchToken-gIAlu-s", "generateDefaultContactIdIfNotSet", "generateDefaultContactIdIfNotSet$urbanairship_core_release", "getPendingAudienceOverrides", "Lcom/urbanairship/audience/AudienceOverrides$Contact;", "isSkippable", "performAssociateChannel", "Lcom/urbanairship/contacts/ContactOperation$AssociateChannel;", "(Lcom/urbanairship/contacts/ContactOperation$AssociateChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performDisassociateChannel", "Lcom/urbanairship/contacts/ContactOperation$DisassociateChannel;", "(Lcom/urbanairship/contacts/ContactOperation$DisassociateChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performIdentify", "channelId", "Lcom/urbanairship/contacts/ContactOperation$Identify;", "(Ljava/lang/String;Lcom/urbanairship/contacts/ContactOperation$Identify;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performNextOperation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performOperation", "(Lcom/urbanairship/contacts/ContactOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRegisterEmail", "Lcom/urbanairship/contacts/ContactOperation$RegisterEmail;", "(Lcom/urbanairship/contacts/ContactOperation$RegisterEmail;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRegisterOpen", "Lcom/urbanairship/contacts/ContactOperation$RegisterOpen;", "(Lcom/urbanairship/contacts/ContactOperation$RegisterOpen;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRegisterSms", "Lcom/urbanairship/contacts/ContactOperation$RegisterSms;", "(Lcom/urbanairship/contacts/ContactOperation$RegisterSms;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performResend", "Lcom/urbanairship/contacts/ContactOperation$Resend;", "(Lcom/urbanairship/contacts/ContactOperation$Resend;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performReset", "performResolve", "performUpdate", "(Lcom/urbanairship/contacts/ContactOperation$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareNextOperationGroup", "Lcom/urbanairship/contacts/ContactManager$OperationGroup;", "resetIfNeeded", "resetIfNeeded$urbanairship_core_release", "stableContactIdUpdate", "minResolveDate", "stableContactIdUpdate$urbanairship_core_release", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tokenIfValid", "updateContactIdentity", "result", "Lcom/urbanairship/contacts/ContactApiClient$IdentityResult;", "isResolve", "yieldContactUpdates", "Companion", "OperationEntry", "OperationGroup", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@OpenForTesting
@SourceDebugExtension({"SMAP\nContactManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactManager.kt\ncom/urbanairship/contacts/ContactManager\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 5 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 6 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 7 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 8 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 9 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 10 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1014:1\n19#2,2:1015\n21#2,5:1021\n18#2,3:1030\n21#2,5:1037\n18#2,8:1042\n18#2,8:1050\n1549#3:1017\n1620#3,3:1018\n1549#3:1026\n1620#3,3:1027\n1549#3:1033\n1620#3,3:1034\n288#3,2:1058\n288#3,2:1060\n288#3,2:1077\n1549#3:1079\n1620#3,3:1080\n766#3:1084\n857#3,2:1085\n1549#3:1087\n1620#3,3:1088\n766#3:1091\n857#3,2:1092\n1855#3,2:1112\n1855#3,2:1114\n1855#3,2:1116\n60#4:1062\n63#4:1066\n50#5:1063\n55#5:1065\n106#6:1064\n230#7,5:1067\n230#7,5:1072\n1#8:1083\n215#9:1094\n216#9:1102\n215#9:1103\n216#9:1111\n372#10,7:1095\n372#10,7:1104\n*S KotlinDebug\n*F\n+ 1 ContactManager.kt\ncom/urbanairship/contacts/ContactManager\n*L\n192#1:1015,2\n192#1:1021,5\n91#1:1030,3\n91#1:1037,5\n112#1:1042,8\n123#1:1050,8\n192#1:1017\n192#1:1018,3\n193#1:1026\n193#1:1027,3\n92#1:1033\n92#1:1034,3\n146#1:1058,2\n171#1:1060,2\n354#1:1077,2\n364#1:1079\n364#1:1080,3\n531#1:1084\n531#1:1085,2\n882#1:1087\n882#1:1088,3\n900#1:1091\n900#1:1092,2\n947#1:1112,2\n955#1:1114,2\n959#1:1116,2\n223#1:1062\n223#1:1066\n223#1:1063\n223#1:1065\n223#1:1064\n293#1:1067,5\n294#1:1072,5\n935#1:1094\n935#1:1102\n941#1:1103\n941#1:1111\n936#1:1095,7\n942#1:1104,7\n*E\n"})
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

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performAssociateChannel$1 */
    static final class C52421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52421(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performAssociateChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performDisassociateChannel$1 */
    static final class C52431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52431(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performDisassociateChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performRegisterEmail$1 */
    static final class C52461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52461(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performRegisterEmail(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performRegisterOpen$1 */
    static final class C52471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C52471(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performRegisterOpen(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performRegisterSms$1 */
    static final class C52481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52481(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performRegisterSms(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performResend$1 */
    static final class C52491 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C52491(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContactManager.this.performResend(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performUpdate$1 */
    static final class C52521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C52521(Continuation continuation) {
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
                    UALog.m1744e("Failed to parse json", e);
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
        this.audienceOverridesProvider.setStableContactIdDelegate$urbanairship_core_release(new C52373(null));
        this.jobDispatcher.setRateLimit(IDENTITY_RATE_LIMIT, 1, 5L, TimeUnit.SECONDS);
        this.jobDispatcher.setRateLimit(UPDATE_RATE_LIMIT, 1, 500L, TimeUnit.MILLISECONDS);
        yieldContactUpdates();
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C52384(null), 3, null);
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

    /* JADX INFO: renamed from: isEnabled$urbanairship_core_release, reason: from getter */
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
                        contactIdentity = null;
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

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    @Nullable
    public final ContactIdUpdate getCurrentContactIdUpdate$urbanairship_core_release() {
        boolean required;
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        Object obj = null;
        if (lastContactIdentity == null) {
            return null;
        }
        for (Object obj2 : getOperations()) {
            OperationEntry operationEntry = (OperationEntry) obj2;
            ContactOperation operation = operationEntry.getOperation();
            if (operation instanceof ContactOperation.Reset) {
                required = true;
            } else if (operation instanceof ContactOperation.Verify) {
                required = ((ContactOperation.Verify) operationEntry.getOperation()).getRequired();
            } else if (!(operation instanceof ContactOperation.Identify) || Intrinsics.areEqual(((ContactOperation.Identify) operationEntry.getOperation()).getIdentifier(), lastContactIdentity.getNamedUserId())) {
                required = false;
            } else {
                required = true;
            }
            if (required) {
                obj = obj2;
                break;
            }
        }
        boolean z = obj == null;
        String contactId = lastContactIdentity.getContactId();
        String namedUserId = lastContactIdentity.getNamedUserId();
        Long resolveDateMs = lastContactIdentity.getResolveDateMs();
        return new ContactIdUpdate(contactId, namedUserId, z, resolveDateMs != null ? resolveDateMs.longValue() : 0L);
    }

    @Nullable
    public final String getNamedUserId$urbanairship_core_release() {
        Object next;
        OperationEntry operationEntry;
        ContactIdentity lastContactIdentity = getLastContactIdentity();
        String namedUserId = lastContactIdentity != null ? lastContactIdentity.getNamedUserId() : null;
        Iterator it = CollectionsKt.reversed(getOperations()).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            operationEntry = (OperationEntry) next;
            if (operationEntry.getOperation() instanceof ContactOperation.Identify) {
                break;
            }
        } while (!(operationEntry.getOperation() instanceof ContactOperation.Reset));
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

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$3 */
    static final class C52373 extends SuspendLambda implements Function1 {
        int label;

        C52373(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C52373(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C52373) create(continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$4 */
    static final class C52384 extends SuspendLambda implements Function2 {
        int label;

        C52384(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ContactManager.this.new C52384(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52384) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        Object objCollect = channelIdFlow.collect(new C52392(flowCollector, id), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2 */
                    @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ContactManager.kt\ncom/urbanairship/contacts/ContactManager$4\n*L\n1#1,222:1\n22#2:223\n23#2:225\n216#3:224\n*E\n"})
                    public static final class C52392<T> implements FlowCollector {
                        final /* synthetic */ String $startingChannelId$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                        @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                        @DebugMetadata(m1844c = "com.urbanairship.contacts.ContactManager$4$invokeSuspend$$inlined$filter$1$2", m1845f = "ContactManager.kt", m1846i = {}, m1847l = {223}, m1848m = "emit", m1849n = {}, m1850s = {})
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
                                return C52392.this.emit(null, this);
                            }
                        }

                        public C52392(FlowCollector flowCollector, String str) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$startingChannelId$inlined = str;
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
                                if (!Intrinsics.areEqual((String) obj, this.$startingChannelId$inlined)) {
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
                Object objCollect = stateFlow.collect(new C52532(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2 */
            @Metadata(m1835d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1836d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 ContactManager.kt\ncom/urbanairship/contacts/ContactManager\n*L\n1#1,222:1\n61#2:223\n62#2:225\n223#3:224\n*E\n"})
            public static final class C52532<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
                @DebugMetadata(m1844c = "com.urbanairship.contacts.ContactManager$stableContactIdUpdate$$inlined$mapNotNull$1$2", m1845f = "ContactManager.kt", m1846i = {}, m1847l = {JfifUtil.MARKER_APP1}, m1848m = "emit", m1849n = {}, m1850s = {})
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
                        return C52532.this.emit(null, this);
                    }
                }

                public C52532(FlowCollector flowCollector) {
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
                        if (contactIdUpdate != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(contactIdUpdate, anonymousClass1) == coroutine_suspended) {
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.urbanairship.http.AuthTokenProvider
    @Nullable
    /* JADX INFO: renamed from: fetchToken-gIAlu-s */
    public Object mo5075fetchTokengIAlus(@NotNull String str, @NotNull Continuation<? super Result<String>> continuation) {
        ContactManager$fetchToken$1 contactManager$fetchToken$1;
        if (continuation instanceof ContactManager$fetchToken$1) {
            contactManager$fetchToken$1 = (ContactManager$fetchToken$1) continuation;
            int i = contactManager$fetchToken$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contactManager$fetchToken$1.label = i - Integer.MIN_VALUE;
            } else {
                contactManager$fetchToken$1 = new ContactManager$fetchToken$1(this, continuation);
            }
        } else {
            contactManager$fetchToken$1 = new ContactManager$fetchToken$1(this, continuation);
        }
        Object objWithContext = contactManager$fetchToken$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contactManager$fetchToken$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher coroutineDispatcher = this.dispatcher;
            ContactManager$fetchToken$2 contactManager$fetchToken$2 = new ContactManager$fetchToken$2(this, str, null);
            contactManager$fetchToken$1.label = 1;
            objWithContext = BuildersKt.withContext(coroutineDispatcher, contactManager$fetchToken$2, contactManager$fetchToken$1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        return ((Result) objWithContext).getValue();
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

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$expireToken$2 */
    static final class C52412 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $token;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52412(String str, Continuation continuation) {
            super(2, continuation);
            this.$token = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ContactManager.this.new C52412(this.$token, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52412) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        return ContactManager.C52412.invokeSuspend$lambda$0(str, (AuthToken) obj2);
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
        Object objWithContext = BuildersKt.withContext(this.dispatcher, new C52412(str, null), continuation);
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

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performNextOperation$2 */
    static final class C52452 extends SuspendLambda implements Function2 {
        Object L$0;
        int label;

        C52452(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ContactManager.this.new C52452(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C52452) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x007e  */
        /* JADX WARN: Code duplicated, block: B:31:0x0083  */
        /* JADX WARN: Code duplicated, block: B:33:0x0093 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0094  */
        /* JADX WARN: Code duplicated, block: B:37:0x009e  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c2 A[Catch: all -> 0x00d0, LOOP:0: B:39:0x00bc->B:41:0x00c2, LOOP_END, TryCatch #0 {all -> 0x00d0, blocks: (B:38:0x00a9, B:39:0x00bc, B:41:0x00c2, B:44:0x00d2, B:45:0x00df, B:47:0x00e5, B:49:0x00f6, B:50:0x00fa, B:52:0x0107, B:53:0x010a), top: B:59:0x00a9 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x00e5 A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:38:0x00a9, B:39:0x00bc, B:41:0x00c2, B:44:0x00d2, B:45:0x00df, B:47:0x00e5, B:49:0x00f6, B:50:0x00fa, B:52:0x0107, B:53:0x010a), top: B:59:0x00a9 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x0107 A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:38:0x00a9, B:39:0x00bc, B:41:0x00c2, B:44:0x00d2, B:45:0x00df, B:47:0x00e5, B:49:0x00f6, B:50:0x00fa, B:52:0x0107, B:53:0x010a), top: B:59:0x00a9 }] */
        /* JADX WARN: Code duplicated, block: B:62:0x00f6 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:65:0x00df A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            OperationGroup operationGroupPrepareNextOperationGroup;
            Object objPerformOperation;
            OperationGroup operationGroup;
            ReentrantLock reentrantLock;
            ContactManager contactManager;
            ArrayList arrayList;
            Iterator it;
            ArrayList arrayList2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = false;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (ContactManager.this.getIsEnabled()) {
                    if (!ContactManager.this.getOperations().isEmpty()) {
                        if (ContactManager.this.tokenIfValid() == null) {
                            ContactManager contactManager2 = ContactManager.this;
                            ContactOperation.Resolve resolve = ContactOperation.Resolve.INSTANCE;
                            this.label = 1;
                            obj = contactManager2.performOperation(resolve, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        ContactManager.this.clearSkippableOperations();
                        ContactManager.this.yieldContactUpdates();
                        operationGroupPrepareNextOperationGroup = ContactManager.this.prepareNextOperationGroup();
                        if (operationGroupPrepareNextOperationGroup == null) {
                            return Boxing.boxBoolean(true);
                        }
                        ContactManager contactManager3 = ContactManager.this;
                        ContactOperation merged = operationGroupPrepareNextOperationGroup.getMerged();
                        this.L$0 = operationGroupPrepareNextOperationGroup;
                        this.label = 2;
                        objPerformOperation = contactManager3.performOperation(merged, this);
                        if (objPerformOperation == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        operationGroup = operationGroupPrepareNextOperationGroup;
                        obj = objPerformOperation;
                        if (((Boolean) obj).booleanValue()) {
                            reentrantLock = ContactManager.this.operationLock;
                            contactManager = ContactManager.this;
                            reentrantLock.lock();
                            List operations = operationGroup.getOperations();
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(operations, 10));
                            it = operations.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((OperationEntry) it.next()).getIdentifier());
                            }
                            List operations2 = contactManager.getOperations();
                            arrayList2 = new ArrayList();
                            for (Object obj2 : operations2) {
                                if (!arrayList.contains(((OperationEntry) obj2).getIdentifier())) {
                                    arrayList2.add(obj2);
                                }
                            }
                            contactManager.setOperations(arrayList2);
                            if (!contactManager.getOperations().isEmpty()) {
                                contactManager.dispatchContactUpdateJob(0);
                            }
                            Unit unit = Unit.INSTANCE;
                            reentrantLock.unlock();
                            z = true;
                        }
                        Boolean boolBoxBoolean = Boxing.boxBoolean(z);
                        ContactManager contactManager4 = ContactManager.this;
                        boolBoxBoolean.booleanValue();
                        contactManager4.yieldContactUpdates();
                        return boolBoxBoolean;
                    }
                    return Boxing.boxBoolean(true);
                }
                return Boxing.boxBoolean(true);
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                operationGroup = (OperationGroup) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                reentrantLock = ContactManager.this.operationLock;
                contactManager = ContactManager.this;
                reentrantLock.lock();
                try {
                    List operations3 = operationGroup.getOperations();
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(operations3, 10));
                    it = operations3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((OperationEntry) it.next()).getIdentifier());
                    }
                    List operations4 = contactManager.getOperations();
                    arrayList2 = new ArrayList();
                    while (r0.hasNext()) {
                        if (!arrayList.contains(((OperationEntry) obj2).getIdentifier())) {
                            arrayList2.add(obj2);
                        }
                    }
                    contactManager.setOperations(arrayList2);
                    if (!contactManager.getOperations().isEmpty()) {
                        contactManager.dispatchContactUpdateJob(0);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    reentrantLock.unlock();
                    z = true;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            Boolean boolBoxBoolean2 = Boxing.boxBoolean(z);
            ContactManager contactManager5 = ContactManager.this;
            boolBoxBoolean2.booleanValue();
            contactManager5.yieldContactUpdates();
            return boolBoxBoolean2;
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            ContactManager.this.yieldContactUpdates();
            if (!zBooleanValue) {
                return Boxing.boxBoolean(false);
            }
            ContactManager.this.clearSkippableOperations();
            ContactManager.this.yieldContactUpdates();
            operationGroupPrepareNextOperationGroup = ContactManager.this.prepareNextOperationGroup();
            if (operationGroupPrepareNextOperationGroup == null) {
                return Boxing.boxBoolean(true);
            }
            ContactManager contactManager6 = ContactManager.this;
            ContactOperation merged2 = operationGroupPrepareNextOperationGroup.getMerged();
            this.L$0 = operationGroupPrepareNextOperationGroup;
            this.label = 2;
            objPerformOperation = contactManager6.performOperation(merged2, this);
            if (objPerformOperation == coroutine_suspended) {
                return coroutine_suspended;
            }
            operationGroup = operationGroupPrepareNextOperationGroup;
            obj = objPerformOperation;
            if (((Boolean) obj).booleanValue()) {
                reentrantLock = ContactManager.this.operationLock;
                contactManager = ContactManager.this;
                reentrantLock.lock();
                List operations5 = operationGroup.getOperations();
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(operations5, 10));
                it = operations5.iterator();
                while (it.hasNext()) {
                    arrayList.add(((OperationEntry) it.next()).getIdentifier());
                }
                List operations6 = contactManager.getOperations();
                arrayList2 = new ArrayList();
                while (r0.hasNext()) {
                    if (!arrayList.contains(((OperationEntry) obj2).getIdentifier())) {
                        arrayList2.add(obj2);
                    }
                }
                contactManager.setOperations(arrayList2);
                if (!contactManager.getOperations().isEmpty()) {
                    contactManager.dispatchContactUpdateJob(0);
                }
                Unit unit3 = Unit.INSTANCE;
                reentrantLock.unlock();
                z = true;
            }
            Boolean boolBoxBoolean3 = Boxing.boxBoolean(z);
            ContactManager contactManager7 = ContactManager.this;
            boolBoxBoolean3.booleanValue();
            contactManager7.yieldContactUpdates();
            return boolBoxBoolean3;
        }
    }

    @Nullable
    public final Object performNextOperation(@NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatcher, new C52452(null), continuation);
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
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (isSkippable(((OperationEntry) next).getOperation()));
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
        if (authToken == null || !Intrinsics.areEqual(authToken.getIdentifier(), getLastContactId()) || this.clock.currentTimeMillis() > authToken.getExpirationDateMillis() - ((long) 30000)) {
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
        } finally {
            reentrantLock.unlock();
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

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performReset$2 */
    static final class C52502 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $channelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52502(String str, Continuation continuation) {
            super(1, continuation);
            this.$channelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C52502(this.$channelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C52502) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        return doIdentify(new C52502(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performIdentify$2 */
    static final class C52442 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $channelId;
        final /* synthetic */ ContactOperation.Identify $operation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52442(String str, ContactOperation.Identify identify, Continuation continuation) {
            super(1, continuation);
            this.$channelId = str;
            this.$operation = identify;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C52442(this.$channelId, this.$operation, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C52442) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        return doIdentify(new C52442(str, identify, null), continuation);
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$performResolve$2 */
    static final class C52512 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $channelId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52512(String str, Continuation continuation) {
            super(1, continuation);
            this.$channelId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C52512(this.$channelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C52512) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        return doIdentify(new C52512(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object performUpdate(ContactOperation.Update update, Continuation continuation) throws RequestException {
        C52521 c52521;
        String str;
        ContactOperation.Update update2;
        ContactManager contactManager;
        if (continuation instanceof C52521) {
            c52521 = (C52521) continuation;
            int i = c52521.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52521.label = i - Integer.MIN_VALUE;
            } else {
                c52521 = new C52521(continuation);
            }
        } else {
            c52521 = new C52521(continuation);
        }
        C52521 c52522 = c52521;
        Object obj = c52522.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52522.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String lastContactId = getLastContactId();
            if (lastContactId == null) {
                return Boxing.boxBoolean(false);
            }
            ContactApiClient contactApiClient = this.contactApiClient;
            List<TagGroupsMutation> tags = update.getTags();
            List<AttributeMutation> attributes = update.getAttributes();
            List<ScopedSubscriptionListMutation> subscriptions = update.getSubscriptions();
            c52522.L$0 = this;
            c52522.L$1 = update;
            c52522.L$2 = lastContactId;
            c52522.label = 1;
            Object objUpdate = contactApiClient.update(lastContactId, tags, attributes, subscriptions, c52522);
            if (objUpdate == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = lastContactId;
            obj = objUpdate;
            update2 = update;
            contactManager = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) c52522.L$2;
            ContactOperation.Update update3 = (ContactOperation.Update) c52522.L$1;
            ContactManager contactManager2 = (ContactManager) c52522.L$0;
            ResultKt.throwOnFailure(obj);
            str = str2;
            update2 = update3;
            contactManager = contactManager2;
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.isSuccessful()) {
            contactUpdated$default(contactManager, str, update2, null, 4, null);
        }
        return Boxing.boxBoolean(requestResult.isSuccessful() || requestResult.isClientError());
    }

    /* JADX INFO: renamed from: com.urbanairship.contacts.ContactManager$doIdentify$2 */
    static final class C52402 extends SuspendLambda implements Function1 {
        final /* synthetic */ Function1 $operation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C52402(Function1 function1, Continuation continuation) {
            super(1, continuation);
            this.$operation = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ContactManager.this.new C52402(this.$operation, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C52402) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0062 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long millis = (ContactManager.this.lastIdentifyTimeMs + TimeUnit.SECONDS.toMillis(5L)) - Clock.DEFAULT_CLOCK.currentTimeMillis();
                if (millis > 0) {
                    this.label = 1;
                    if (DelayKt.delay(millis, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    Function1 function1 = this.$operation;
                    this.label = 3;
                    obj = function1.invoke(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                ContactManager.this.lastIdentifyTimeMs = Clock.DEFAULT_CLOCK.currentTimeMillis();
                return Boxing.boxBoolean(zBooleanValue);
            }
            this.label = 2;
            if (DelayKt.delay(200L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            Function1 function2 = this.$operation;
            this.label = 3;
            obj = function2.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            boolean zBooleanValue2 = ((Boolean) obj).booleanValue();
            ContactManager.this.lastIdentifyTimeMs = Clock.DEFAULT_CLOCK.currentTimeMillis();
            return Boxing.boxBoolean(zBooleanValue2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doIdentify(Function1 function1, Continuation continuation) {
        return this.identifyOperationQueue.run(new C52402(function1, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object performAssociateChannel(ContactOperation.AssociateChannel associateChannel, Continuation continuation) throws RequestException {
        C52421 c52421;
        ContactManager contactManager;
        String str;
        if (continuation instanceof C52421) {
            c52421 = (C52421) continuation;
            int i = c52421.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52421.label = i - Integer.MIN_VALUE;
            } else {
                c52421 = new C52421(continuation);
            }
        } else {
            c52421 = new C52421(continuation);
        }
        Object obj = c52421.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52421.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String lastContactId = getLastContactId();
            if (lastContactId == null) {
                return Boxing.boxBoolean(false);
            }
            ContactApiClient contactApiClient = this.contactApiClient;
            String channelId = associateChannel.getChannelId();
            ChannelType channelType = associateChannel.getChannelType();
            c52421.L$0 = this;
            c52421.L$1 = associateChannel;
            c52421.L$2 = lastContactId;
            c52421.label = 1;
            Object objAssociatedChannel = contactApiClient.associatedChannel(lastContactId, channelId, channelType, c52421);
            if (objAssociatedChannel == coroutine_suspended) {
                return coroutine_suspended;
            }
            contactManager = this;
            str = lastContactId;
            obj = objAssociatedChannel;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) c52421.L$2;
            associateChannel = (ContactOperation.AssociateChannel) c52421.L$1;
            ContactManager contactManager2 = (ContactManager) c52421.L$0;
            ResultKt.throwOnFailure(obj);
            str = str2;
            contactManager = contactManager2;
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.getValue() != null && requestResult.isSuccessful()) {
            contactUpdated$default(contactManager, str, null, new ContactChannelMutation.AssociateAnon(associateChannel.getChannelId(), associateChannel.getChannelType()), 2, null);
        }
        return Boxing.boxBoolean(requestResult.isSuccessful() || requestResult.isClientError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object performRegisterSms(ContactOperation.RegisterSms registerSms, Continuation continuation) throws RequestException {
        C52481 c52481;
        String str;
        ContactOperation.RegisterSms registerSms2;
        ContactManager contactManager;
        if (continuation instanceof C52481) {
            c52481 = (C52481) continuation;
            int i = c52481.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52481.label = i - Integer.MIN_VALUE;
            } else {
                c52481 = new C52481(continuation);
            }
        } else {
            c52481 = new C52481(continuation);
        }
        C52481 c52482 = c52481;
        Object obj = c52482.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52482.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String lastContactId = getLastContactId();
            if (lastContactId == null) {
                return Boxing.boxBoolean(false);
            }
            ContactApiClient contactApiClient = this.contactApiClient;
            String msisdn = registerSms.getMsisdn();
            SmsRegistrationOptions options = registerSms.getOptions();
            Locale locale = this.localeManager.getLocale();
            Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
            c52482.L$0 = this;
            c52482.L$1 = registerSms;
            c52482.L$2 = lastContactId;
            c52482.label = 1;
            Object objRegisterSms = contactApiClient.registerSms(lastContactId, msisdn, options, locale, c52482);
            if (objRegisterSms == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = lastContactId;
            obj = objRegisterSms;
            registerSms2 = registerSms;
            contactManager = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) c52482.L$2;
            registerSms2 = (ContactOperation.RegisterSms) c52482.L$1;
            ContactManager contactManager2 = (ContactManager) c52482.L$0;
            ResultKt.throwOnFailure(obj);
            str = str2;
            contactManager = contactManager2;
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.getValue() != null && requestResult.isSuccessful()) {
            contactUpdated$default(contactManager, str, null, new ContactChannelMutation.Associate(new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Pending(registerSms2.getMsisdn(), registerSms2.getOptions())), (String) requestResult.getValue()), 2, null);
        }
        return Boxing.boxBoolean(requestResult.isSuccessful() || requestResult.isClientError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    public final Object performRegisterEmail(ContactOperation.RegisterEmail registerEmail, Continuation continuation) {
        C52461 c52461;
        String str;
        ContactOperation.RegisterEmail registerEmail2;
        ContactManager contactManager;
        if (continuation instanceof C52461) {
            c52461 = (C52461) continuation;
            int i = c52461.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52461.label = i - Integer.MIN_VALUE;
            } else {
                c52461 = new C52461(continuation);
            }
        } else {
            c52461 = new C52461(continuation);
        }
        C52461 c52462 = c52461;
        Object obj = c52462.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52462.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String lastContactId = getLastContactId();
            if (lastContactId == null) {
                return Boxing.boxBoolean(false);
            }
            ContactApiClient contactApiClient = this.contactApiClient;
            String emailAddress = registerEmail.getEmailAddress();
            EmailRegistrationOptions options = registerEmail.getOptions();
            Locale locale = this.localeManager.getLocale();
            Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
            c52462.L$0 = this;
            c52462.L$1 = registerEmail;
            c52462.L$2 = lastContactId;
            c52462.label = 1;
            Object objRegisterEmail = contactApiClient.registerEmail(lastContactId, emailAddress, options, locale, c52462);
            if (objRegisterEmail == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = lastContactId;
            obj = objRegisterEmail;
            registerEmail2 = registerEmail;
            contactManager = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) c52462.L$2;
            registerEmail2 = (ContactOperation.RegisterEmail) c52462.L$1;
            ContactManager contactManager2 = (ContactManager) c52462.L$0;
            ResultKt.throwOnFailure(obj);
            str = str2;
            contactManager = contactManager2;
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.getValue() != null && requestResult.isSuccessful()) {
            contactUpdated$default(contactManager, str, null, new ContactChannelMutation.Associate(new ContactChannel.Email(new ContactChannel.Email.RegistrationInfo.Pending(registerEmail2.getEmailAddress(), registerEmail2.getOptions())), (String) requestResult.getValue()), 2, null);
        }
        return Boxing.boxBoolean(requestResult.isSuccessful() || requestResult.isClientError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object performRegisterOpen(ContactOperation.RegisterOpen registerOpen, Continuation continuation) throws RequestException {
        C52471 c52471;
        ContactManager contactManager;
        String str;
        if (continuation instanceof C52471) {
            c52471 = (C52471) continuation;
            int i = c52471.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52471.label = i - Integer.MIN_VALUE;
            } else {
                c52471 = new C52471(continuation);
            }
        } else {
            c52471 = new C52471(continuation);
        }
        C52471 c52472 = c52471;
        Object obj = c52472.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52472.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String lastContactId = getLastContactId();
            if (lastContactId == null) {
                return Boxing.boxBoolean(false);
            }
            ContactApiClient contactApiClient = this.contactApiClient;
            String address = registerOpen.getAddress();
            OpenChannelRegistrationOptions options = registerOpen.getOptions();
            Locale locale = this.localeManager.getLocale();
            Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
            c52472.L$0 = this;
            c52472.L$1 = lastContactId;
            c52472.label = 1;
            Object objRegisterOpen = contactApiClient.registerOpen(lastContactId, address, options, locale, c52472);
            if (objRegisterOpen == coroutine_suspended) {
                return coroutine_suspended;
            }
            contactManager = this;
            str = lastContactId;
            obj = objRegisterOpen;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str2 = (String) c52472.L$1;
            ContactManager contactManager2 = (ContactManager) c52472.L$0;
            ResultKt.throwOnFailure(obj);
            str = str2;
            contactManager = contactManager2;
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.getValue() != null && requestResult.isSuccessful()) {
            contactUpdated$default(contactManager, str, null, new ContactChannelMutation.AssociateAnon((String) requestResult.getValue(), ChannelType.OPEN), 2, null);
        }
        return Boxing.boxBoolean(requestResult.isSuccessful() || requestResult.isClientError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object performResend(ContactOperation.Resend resend, Continuation continuation) {
        C52491 c52491;
        RequestResult requestResult;
        if (continuation instanceof C52491) {
            c52491 = (C52491) continuation;
            int i = c52491.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52491.label = i - Integer.MIN_VALUE;
            } else {
                c52491 = new C52491(continuation);
            }
        } else {
            c52491 = new C52491(continuation);
        }
        Object objResendEmailOptIn$urbanairship_core_release = c52491.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52491.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objResendEmailOptIn$urbanairship_core_release);
            ContactChannel channel = resend.getChannel();
            if (channel instanceof ContactChannel.Sms) {
                ContactChannel.Sms.RegistrationInfo registrationInfo = ((ContactChannel.Sms) resend.getChannel()).getRegistrationInfo();
                if (registrationInfo instanceof ContactChannel.Sms.RegistrationInfo.Registered) {
                    ContactApiClient contactApiClient = this.contactApiClient;
                    String channelId = ((ContactChannel.Sms.RegistrationInfo.Registered) ((ContactChannel.Sms) resend.getChannel()).getRegistrationInfo()).getChannelId();
                    ChannelType channelType = ChannelType.SMS;
                    c52491.label = 1;
                    objResendEmailOptIn$urbanairship_core_release = contactApiClient.resendChannelOptIn$urbanairship_core_release(channelId, channelType, c52491);
                    if (objResendEmailOptIn$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
                } else {
                    if (!(registrationInfo instanceof ContactChannel.Sms.RegistrationInfo.Pending)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ContactApiClient contactApiClient2 = this.contactApiClient;
                    String address = ((ContactChannel.Sms.RegistrationInfo.Pending) ((ContactChannel.Sms) resend.getChannel()).getRegistrationInfo()).getAddress();
                    String senderId = ((ContactChannel.Sms.RegistrationInfo.Pending) ((ContactChannel.Sms) resend.getChannel()).getRegistrationInfo()).getRegistrationOptions().getSenderId();
                    c52491.label = 2;
                    objResendEmailOptIn$urbanairship_core_release = contactApiClient2.resendSmsOptIn$urbanairship_core_release(address, senderId, c52491);
                    if (objResendEmailOptIn$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
                }
            } else {
                if (!(channel instanceof ContactChannel.Email)) {
                    throw new NoWhenBranchMatchedException();
                }
                ContactChannel.Email.RegistrationInfo registrationInfo2 = ((ContactChannel.Email) resend.getChannel()).getRegistrationInfo();
                if (registrationInfo2 instanceof ContactChannel.Email.RegistrationInfo.Registered) {
                    ContactApiClient contactApiClient3 = this.contactApiClient;
                    String channelId2 = ((ContactChannel.Email.RegistrationInfo.Registered) ((ContactChannel.Email) resend.getChannel()).getRegistrationInfo()).getChannelId();
                    ChannelType channelType2 = ChannelType.EMAIL;
                    c52491.label = 3;
                    objResendEmailOptIn$urbanairship_core_release = contactApiClient3.resendChannelOptIn$urbanairship_core_release(channelId2, channelType2, c52491);
                    if (objResendEmailOptIn$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
                } else if (registrationInfo2 instanceof ContactChannel.Email.RegistrationInfo.Pending) {
                    ContactApiClient contactApiClient4 = this.contactApiClient;
                    String address2 = ((ContactChannel.Email.RegistrationInfo.Pending) ((ContactChannel.Email) resend.getChannel()).getRegistrationInfo()).getAddress();
                    c52491.label = 4;
                    objResendEmailOptIn$urbanairship_core_release = contactApiClient4.resendEmailOptIn$urbanairship_core_release(address2, c52491);
                    if (objResendEmailOptIn$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        } else if (i2 == 1) {
            ResultKt.throwOnFailure(objResendEmailOptIn$urbanairship_core_release);
            requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
        } else if (i2 == 2) {
            ResultKt.throwOnFailure(objResendEmailOptIn$urbanairship_core_release);
            requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
        } else if (i2 == 3) {
            ResultKt.throwOnFailure(objResendEmailOptIn$urbanairship_core_release);
            requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
        } else {
            if (i2 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objResendEmailOptIn$urbanairship_core_release);
            requestResult = (RequestResult) objResendEmailOptIn$urbanairship_core_release;
        }
        if (!requestResult.isSuccessful() && !requestResult.isClientError()) {
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public final Object performDisassociateChannel(ContactOperation.DisassociateChannel disassociateChannel, Continuation continuation) {
        C52431 c52431;
        String lastContactId;
        Object objDisassociateEmail$urbanairship_core_release;
        Object objDisassociateChannel$urbanairship_core_release;
        Object objDisassociateSms$urbanairship_core_release;
        Object objDisassociateChannel$urbanairship_core_release2;
        RequestResult requestResult;
        ContactManager contactManager = this;
        ContactOperation.DisassociateChannel disassociateChannel2 = disassociateChannel;
        if (continuation instanceof C52431) {
            c52431 = (C52431) continuation;
            int i = c52431.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c52431.label = i - Integer.MIN_VALUE;
            } else {
                c52431 = contactManager.new C52431(continuation);
            }
        } else {
            c52431 = contactManager.new C52431(continuation);
        }
        C52431 c52432 = c52431;
        Object obj = c52432.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c52432.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            lastContactId = getLastContactId();
            if (lastContactId == null) {
                return Boxing.boxBoolean(false);
            }
            ContactChannel channel = disassociateChannel.getChannel();
            if (channel instanceof ContactChannel.Sms) {
                ContactChannel.Sms.RegistrationInfo registrationInfo = ((ContactChannel.Sms) disassociateChannel.getChannel()).getRegistrationInfo();
                if (registrationInfo instanceof ContactChannel.Sms.RegistrationInfo.Registered) {
                    ContactApiClient contactApiClient = contactManager.contactApiClient;
                    String channelId = ((ContactChannel.Sms.RegistrationInfo.Registered) ((ContactChannel.Sms) disassociateChannel.getChannel()).getRegistrationInfo()).getChannelId();
                    ChannelType channelType = ChannelType.SMS;
                    boolean optOut = disassociateChannel.getOptOut();
                    c52432.L$0 = contactManager;
                    c52432.L$1 = disassociateChannel2;
                    c52432.L$2 = lastContactId;
                    c52432.label = 1;
                    objDisassociateChannel$urbanairship_core_release2 = contactApiClient.disassociateChannel$urbanairship_core_release(lastContactId, channelId, channelType, optOut, c52432);
                    if (objDisassociateChannel$urbanairship_core_release2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objDisassociateChannel$urbanairship_core_release2;
                } else {
                    if (!(registrationInfo instanceof ContactChannel.Sms.RegistrationInfo.Pending)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ContactApiClient contactApiClient2 = contactManager.contactApiClient;
                    String address = ((ContactChannel.Sms.RegistrationInfo.Pending) ((ContactChannel.Sms) disassociateChannel.getChannel()).getRegistrationInfo()).getAddress();
                    String senderId = ((ContactChannel.Sms.RegistrationInfo.Pending) ((ContactChannel.Sms) disassociateChannel.getChannel()).getRegistrationInfo()).getRegistrationOptions().getSenderId();
                    boolean optOut2 = disassociateChannel.getOptOut();
                    c52432.L$0 = contactManager;
                    c52432.L$1 = disassociateChannel2;
                    c52432.L$2 = lastContactId;
                    c52432.label = 2;
                    objDisassociateSms$urbanairship_core_release = contactApiClient2.disassociateSms$urbanairship_core_release(lastContactId, address, senderId, optOut2, c52432);
                    if (objDisassociateSms$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objDisassociateSms$urbanairship_core_release;
                }
            } else {
                if (!(channel instanceof ContactChannel.Email)) {
                    throw new NoWhenBranchMatchedException();
                }
                ContactChannel.Email.RegistrationInfo registrationInfo2 = ((ContactChannel.Email) disassociateChannel.getChannel()).getRegistrationInfo();
                if (registrationInfo2 instanceof ContactChannel.Email.RegistrationInfo.Registered) {
                    ContactApiClient contactApiClient3 = contactManager.contactApiClient;
                    String channelId2 = ((ContactChannel.Email.RegistrationInfo.Registered) ((ContactChannel.Email) disassociateChannel.getChannel()).getRegistrationInfo()).getChannelId();
                    ChannelType channelType2 = ChannelType.EMAIL;
                    boolean optOut3 = disassociateChannel.getOptOut();
                    c52432.L$0 = contactManager;
                    c52432.L$1 = disassociateChannel2;
                    c52432.L$2 = lastContactId;
                    c52432.label = 3;
                    objDisassociateChannel$urbanairship_core_release = contactApiClient3.disassociateChannel$urbanairship_core_release(lastContactId, channelId2, channelType2, optOut3, c52432);
                    if (objDisassociateChannel$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objDisassociateChannel$urbanairship_core_release;
                } else if (registrationInfo2 instanceof ContactChannel.Email.RegistrationInfo.Pending) {
                    ContactApiClient contactApiClient4 = contactManager.contactApiClient;
                    String address2 = ((ContactChannel.Email.RegistrationInfo.Pending) ((ContactChannel.Email) disassociateChannel.getChannel()).getRegistrationInfo()).getAddress();
                    boolean optOut4 = disassociateChannel.getOptOut();
                    c52432.L$0 = contactManager;
                    c52432.L$1 = disassociateChannel2;
                    c52432.L$2 = lastContactId;
                    c52432.label = 4;
                    objDisassociateEmail$urbanairship_core_release = contactApiClient4.disassociateEmail$urbanairship_core_release(lastContactId, address2, optOut4, c52432);
                    if (objDisassociateEmail$urbanairship_core_release == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    requestResult = (RequestResult) objDisassociateEmail$urbanairship_core_release;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        } else if (i2 == 1) {
            String str = (String) c52432.L$2;
            disassociateChannel2 = (ContactOperation.DisassociateChannel) c52432.L$1;
            ContactManager contactManager2 = (ContactManager) c52432.L$0;
            ResultKt.throwOnFailure(obj);
            objDisassociateChannel$urbanairship_core_release2 = obj;
            lastContactId = str;
            contactManager = contactManager2;
            requestResult = (RequestResult) objDisassociateChannel$urbanairship_core_release2;
        } else if (i2 == 2) {
            String str2 = (String) c52432.L$2;
            disassociateChannel2 = (ContactOperation.DisassociateChannel) c52432.L$1;
            ContactManager contactManager3 = (ContactManager) c52432.L$0;
            ResultKt.throwOnFailure(obj);
            objDisassociateSms$urbanairship_core_release = obj;
            lastContactId = str2;
            contactManager = contactManager3;
            requestResult = (RequestResult) objDisassociateSms$urbanairship_core_release;
        } else if (i2 == 3) {
            String str3 = (String) c52432.L$2;
            disassociateChannel2 = (ContactOperation.DisassociateChannel) c52432.L$1;
            ContactManager contactManager4 = (ContactManager) c52432.L$0;
            ResultKt.throwOnFailure(obj);
            objDisassociateChannel$urbanairship_core_release = obj;
            lastContactId = str3;
            contactManager = contactManager4;
            requestResult = (RequestResult) objDisassociateChannel$urbanairship_core_release;
        } else {
            if (i2 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str4 = (String) c52432.L$2;
            disassociateChannel2 = (ContactOperation.DisassociateChannel) c52432.L$1;
            ContactManager contactManager5 = (ContactManager) c52432.L$0;
            ResultKt.throwOnFailure(obj);
            objDisassociateEmail$urbanairship_core_release = obj;
            lastContactId = str4;
            contactManager = contactManager5;
            requestResult = (RequestResult) objDisassociateEmail$urbanairship_core_release;
        }
        ContactManager contactManager6 = contactManager;
        String str5 = lastContactId;
        if (requestResult.isSuccessful()) {
            contactUpdated$default(contactManager6, str5, null, new ContactChannelMutation.Disassociated(disassociateChannel2.getChannel(), (String) requestResult.getValue()), 2, null);
        }
        return Boxing.boxBoolean(requestResult.isSuccessful() || requestResult.isClientError());
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
                    channel.mo5925trySendJP2dKIU(new ConflictEvent(tagGroups, attributes, subscriptionLists, arrayList, namedUserId));
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
                    } catch (Throwable th) {
                        reentrantLock2.unlock();
                        throw th;
                    }
                }
            }
            setLastContactIdentity(contactIdentity);
            Unit unit2 = Unit.INSTANCE;
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
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

        /* JADX WARN: Code duplicated, block: B:100:0x0290  */
        /* JADX WARN: Code duplicated, block: B:101:0x0294  */
        /* JADX WARN: Code duplicated, block: B:103:0x029a  */
        /* JADX WARN: Code duplicated, block: B:105:0x02a4  */
        /* JADX WARN: Code duplicated, block: B:107:0x02aa  */
        /* JADX WARN: Code duplicated, block: B:108:0x02ae  */
        /* JADX WARN: Code duplicated, block: B:110:0x02b4  */
        /* JADX WARN: Code duplicated, block: B:112:0x02be  */
        /* JADX WARN: Code duplicated, block: B:114:0x02c4  */
        /* JADX WARN: Code duplicated, block: B:117:0x02cc  */
        /* JADX WARN: Code duplicated, block: B:119:0x02d2  */
        /* JADX WARN: Code duplicated, block: B:121:0x02f8  */
        /* JADX WARN: Code duplicated, block: B:61:0x0193  */
        /* JADX WARN: Code duplicated, block: B:63:0x01a6  */
        /* JADX WARN: Code duplicated, block: B:66:0x01b0  */
        /* JADX WARN: Code duplicated, block: B:68:0x01b6  */
        /* JADX WARN: Code duplicated, block: B:70:0x01c0  */
        /* JADX WARN: Code duplicated, block: B:73:0x01c7  */
        /* JADX WARN: Code duplicated, block: B:75:0x01cd  */
        /* JADX WARN: Code duplicated, block: B:77:0x01d9  */
        /* JADX WARN: Code duplicated, block: B:78:0x01e5  */
        /* JADX WARN: Code duplicated, block: B:80:0x01f1  */
        /* JADX WARN: Code duplicated, block: B:81:0x01fe  */
        /* JADX WARN: Code duplicated, block: B:83:0x020c  */
        /* JADX WARN: Code duplicated, block: B:84:0x021b  */
        /* JADX WARN: Code duplicated, block: B:86:0x0227  */
        /* JADX WARN: Code duplicated, block: B:87:0x0235  */
        /* JADX WARN: Code duplicated, block: B:89:0x0241  */
        /* JADX WARN: Code duplicated, block: B:90:0x024e  */
        /* JADX WARN: Code duplicated, block: B:92:0x0258  */
        /* JADX WARN: Code duplicated, block: B:93:0x0265  */
        /* JADX WARN: Code duplicated, block: B:95:0x0270  */
        /* JADX WARN: Code duplicated, block: B:96:0x0280  */
        /* JADX WARN: Code duplicated, block: B:98:0x028a  */
        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Instruction removed from duplicated block: B:119:0x02d2, please report this as an issue */
        /* JADX WARN: Instruction removed from duplicated block: B:121:0x02f8, please report this as an issue */
        public OperationEntry(JsonValue jsonValue) throws JsonException {
            String str;
            Long lValueOf;
            long jLongValue;
            ContactOperation contactOperationFromJson;
            JsonValue jsonValue2;
            KClass orCreateKotlinClass;
            Object jsonValue3;
            String strOptString;
            Object objOptMap;
            Object objOptList;
            Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
            JsonMap jsonMapRequireMap = jsonValue.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue4 = jsonMapRequireMap.get("timestamp");
            if (jsonValue4 == null) {
                throw new JsonException("Missing required field: 'timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue4);
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                Object objOptString = jsonValue4.optString();
                if (objOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                Object objOptString2 = jsonValue4.optString();
                if (objOptString2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                }
                lValueOf = (Long) objOptString2;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf = Long.valueOf(jsonValue4.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        str = "Missing required field: '";
                        lValueOf = (Long) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue4.getLong(0L)));
                    } else {
                        str = "Missing required field: '";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            lValueOf = (Long) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            lValueOf = (Long) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            lValueOf = (Long) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            lValueOf = (Long) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            Object objOptList2 = jsonValue4.optList();
                            if (objOptList2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptList2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            Object objOptMap2 = jsonValue4.optMap();
                            if (objOptMap2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) objOptMap2;
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Object jsonValue5 = jsonValue4.getJsonValue();
                            if (jsonValue5 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            lValueOf = (Long) jsonValue5;
                        }
                    }
                    jLongValue = lValueOf.longValue();
                    ContactOperation.Companion companion = ContactOperation.INSTANCE;
                    JsonValue jsonValueRequire = jsonValue.requireMap().require("operation");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                    contactOperationFromJson = companion.fromJson(jsonValueRequire);
                    JsonMap jsonMapRequireMap2 = jsonValue.requireMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
                    jsonValue2 = jsonMapRequireMap2.get("identifier");
                    if (jsonValue2 != null) {
                        throw new JsonException(str + "identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue2);
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue2.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue2.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList = jsonValue2.optList();
                        if (objOptList != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap = jsonValue2.optMap();
                        if (objOptMap != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue3 = jsonValue2.getJsonValue();
                        if (jsonValue3 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue3;
                    }
                    this(jLongValue, contactOperationFromJson, strOptString);
                }
                lValueOf = (Long) Boolean.valueOf(jsonValue4.getBoolean(false));
            }
            str = "Missing required field: '";
            jLongValue = lValueOf.longValue();
            ContactOperation.Companion companion2 = ContactOperation.INSTANCE;
            JsonValue jsonValueRequire2 = jsonValue.requireMap().require("operation");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire2, "require(...)");
            contactOperationFromJson = companion2.fromJson(jsonValueRequire2);
            JsonMap jsonMapRequireMap3 = jsonValue.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap3, "requireMap(...)");
            jsonValue2 = jsonMapRequireMap3.get("identifier");
            if (jsonValue2 != null) {
                throw new JsonException(str + "identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue2);
            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue2.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue2.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue2.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                objOptList = jsonValue2.optList();
                if (objOptList != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                objOptMap = jsonValue2.optMap();
                if (objOptMap != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'identifier" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                jsonValue3 = jsonValue2.getJsonValue();
                if (jsonValue3 != null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue3;
            }
            this(jLongValue, contactOperationFromJson, strOptString);
        }

        @Override // com.urbanairship.json.JsonSerializable
        /* JADX INFO: renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.m1842to("timestamp", Long.valueOf(this.dateMillis)), TuplesKt.m1842to("operation", this.operation), TuplesKt.m1842to("identifier", this.identifier)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }
}
