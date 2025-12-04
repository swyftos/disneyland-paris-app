package com.urbanairship.reactnative;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.joran.action.Action;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.actions.ActionResult;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.android.framework.proxy.ProxyLogger;
import com.urbanairship.android.framework.proxy.events.EventEmitter;
import com.urbanairship.android.framework.proxy.proxies.ActionProxy;
import com.urbanairship.android.framework.proxy.proxies.AirshipProxy;
import com.urbanairship.android.framework.proxy.proxies.AnalyticsProxy;
import com.urbanairship.android.framework.proxy.proxies.ChannelProxy;
import com.urbanairship.android.framework.proxy.proxies.ContactProxy;
import com.urbanairship.android.framework.proxy.proxies.EnableUserNotificationsArgs;
import com.urbanairship.android.framework.proxy.proxies.FeatureFlagManagerProxy;
import com.urbanairship.android.framework.proxy.proxies.FeatureFlagProxy;
import com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest;
import com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy;
import com.urbanairship.android.framework.proxy.proxies.MessageCenterProxy;
import com.urbanairship.android.framework.proxy.proxies.PreferenceCenterProxy;
import com.urbanairship.android.framework.proxy.proxies.PrivacyManagerProxy;
import com.urbanairship.android.framework.proxy.proxies.PushProxy;
import com.urbanairship.android.framework.proxy.proxies.SuspendingPredicate;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bo\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0014\u0018\u0000 \u009f\u00012\u00020\u0001:\u0002\u009f\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u001a\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\tH\u0017J\"\u0010!\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0012\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\tH\u0017J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0017J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010+\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010,\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010/\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u00100\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u00101\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u00102\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u00103\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u00104\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u00105\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0018\u00106\u001a\u00020\u00172\u0006\u00107\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u00108\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u00109\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010;\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010=\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u0010>\u001a\u00020\u0017H\u0017J\u0012\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010\tH\u0017J\u001a\u0010A\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010B\u001a\u00020\u00172\b\u0010:\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0018\u0010C\u001a\u00020\u00172\u0006\u00107\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010D\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0018\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010G\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010H\u001a\u00020\u00172\u0006\u00107\u001a\u00020\rH\u0017J\u001c\u0010I\u001a\u00020\u00172\b\u0010J\u001a\u0004\u0018\u00010\t2\b\u0010:\u001a\u0004\u0018\u00010.H\u0017J\u0010\u0010K\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010M\u001a\u00020\u00172\b\u0010N\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010O\u001a\u00020\u00172\u0006\u00107\u001a\u00020\rH\u0017J\u001a\u0010P\u001a\u00020\u00172\b\u0010J\u001a\u0004\u0018\u00010\t2\u0006\u0010Q\u001a\u00020\rH\u0017J\u0012\u0010R\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u001a\u0010S\u001a\u00020\u00172\b\u0010T\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010U\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010V\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010W\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010X\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010Y\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010Z\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010[\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010\\\u001a\u00020\u00172\b\u0010]\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J$\u0010^\u001a\u00020\u00172\b\u0010_\u001a\u0004\u0018\u00010\t2\b\u0010@\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010`\u001a\u00020\u00172\b\u0010a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0018\u0010c\u001a\u00020\u00172\u0006\u0010d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010e\u001a\u00020\u00172\b\u0010f\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010g\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010h\u001a\u00020\u00172\b\u0010f\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010i\u001a\u00020\u00172\b\u0010f\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010j\u001a\u00020\u00172\b\u0010f\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0018\u0010k\u001a\u00020\u00172\u0006\u0010l\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010m\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0018\u0010n\u001a\u00020\u00172\u0006\u0010o\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010p\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u0010q\u001a\u00020\u0017H\u0017J\u0010\u0010r\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010s\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010t\u001a\u00020\u00172\b\u0010u\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010v\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010w\u001a\u00020\u00172\b\u0010u\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010x\u001a\u00020\u00172\b\u0010u\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010y\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0010\u0010z\u001a\u00020\u00172\u0006\u00107\u001a\u00020\rH\u0017J\u001a\u0010{\u001a\u00020\u00172\b\u0010u\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010|\u001a\u00020\u00172\b\u0010u\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010}\u001a\u00020\u00172\b\u0010~\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010\u007f\u001a\u00020\u00172\b\u0010~\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0080\u0001\u001a\u00020\u00172\b\u0010~\u001a\u0004\u0018\u00010\t2\u0007\u0010\u0081\u0001\u001a\u00020\rH\u0017J\u001c\u0010\u0082\u0001\u001a\u00020\u00172\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0011\u0010\u0084\u0001\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0011\u0010\u0085\u0001\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J#\u0010\u0086\u0001\u001a\u00020\u00172\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0088\u0001\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010\u0089\u0001\u001a\u00020\u00172\u0007\u0010\u008a\u0001\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010\u008b\u0001\u001a\u00020\u00172\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J#\u0010\u008c\u0001\u001a\u00020\u00172\u0007\u0010\u008a\u0001\u001a\u00020\u001b2\u0007\u0010\u008d\u0001\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001a\u0010\u008e\u0001\u001a\u00020\u00172\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0011\u0010\u008f\u0001\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0090\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0092\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0093\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0094\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0011\u0010\u0095\u0001\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0096\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0097\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0098\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u001c\u0010\u0099\u0001\u001a\u00020\u00172\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\u0011\u0010\u009a\u0001\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\t\u0010\u009b\u0001\u001a\u00020\u0017H\u0002J\u0013\u0010\u009c\u0001\u001a\u00020\u00172\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006 \u0001"}, d2 = {"Lcom/urbanairship/reactnative/AirshipModule;", "Lcom/urbanairship/reactnative/AirshipSpec;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "getName", "", "proxy", "Lcom/urbanairship/android/framework/proxy/proxies/AirshipProxy;", "isOverrideForegroundDisplayEnabled", "", "foregroundDisplayRequestMap", "", "Lkotlinx/coroutines/CompletableDeferred;", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "foregroundDisplayPredicate", "com/urbanairship/reactnative/AirshipModule$foregroundDisplayPredicate$1", "Lcom/urbanairship/reactnative/AirshipModule$foregroundDisplayPredicate$1;", "initialize", "", "invalidate", "takeOff", "config", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "isFlying", "airshipListenerAdded", "eventName", "takePendingEvents", "isHeadlessJS", "addListener", "eventType", "removeListeners", "count", "", "channelEnableChannelCreation", "channelAddTag", "tag", "channelRemoveTag", "channelEditTags", "operations", "Lcom/facebook/react/bridge/ReadableArray;", "channelGetTags", "channelGetChannelId", "channelWaitForChannelId", "channelGetSubscriptionLists", "channelEditTagGroups", "channelEditAttributes", "channelEditSubscriptionLists", "pushSetUserNotificationsEnabled", "enabled", "pushIsUserNotificationsEnabled", "pushEnableUserNotifications", "options", "pushGetNotificationStatus", "pushGetRegistrationToken", "pushGetActiveNotifications", "pushClearNotifications", "pushClearNotification", "identifier", "pushIosSetForegroundPresentationOptions", "pushIosSetNotificationOptions", "pushIosSetAutobadgeEnabled", "pushIosIsAutobadgeEnabled", "pushIosSetBadgeNumber", "badgeNumber", "pushIosGetBadgeNumber", "pushIosIsOverridePresentationOptionsEnabled", "pushIosOverridePresentationOptions", "requestId", "pushIosGetAuthorizedNotificationSettings", "pushIosGetAuthorizedNotificationStatus", "pushAndroidIsNotificationChannelEnabled", TCVideoEventPropertiesNames.TCV_CHANNEL, "pushAndroidIsOverrideForegroundDisplayEnabled", "pushAndroidOverrideForegroundDisplay", "shouldDisplay", "pushAndroidSetNotificationConfig", "contactIdentify", "namedUser", "contactReset", "contactNotifyRemoteLogin", "contactGetNamedUserId", "contactGetSubscriptionLists", "contactEditTagGroups", "contactEditAttributes", "contactEditSubscriptionLists", "analyticsTrackScreen", TCEventPropertiesNames.TCD_SCREEN, "analyticsAssociateIdentifier", "key", "addCustomEvent", "event", "analyticsGetSessionId", "actionRun", "action", "privacyManagerSetEnabledFeatures", "features", "privacyManagerGetEnabledFeatures", "privacyManagerEnableFeature", "privacyManagerDisableFeature", "privacyManagerIsFeatureEnabled", "inAppSetDisplayInterval", "milliseconds", "inAppGetDisplayInterval", "inAppSetPaused", "paused", "inAppIsPaused", "inAppResendPendingEmbeddedEvent", "messageCenterGetUnreadCount", "messageCenterDismiss", "messageCenterDisplay", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "messageCenterGetMessages", "messageCenterDeleteMessage", "messageCenterMarkMessageRead", "messageCenterRefresh", "messageCenterSetAutoLaunchDefaultMessageCenter", "messageCenterShowMessageCenter", "messageCenterShowMessageView", "preferenceCenterDisplay", "preferenceCenterId", "preferenceCenterGetConfig", "preferenceCenterAutoLaunchDefaultPreferenceCenter", "autoLaunch", "localeSetLocaleOverride", "localeIdentifier", "localeGetLocale", "localeClearLocaleOverride", "featureFlagManagerFlag", "flagName", "useResultCache", "featureFlagManagerTrackInteraction", "flag", "featureFlagManagerResultCacheGetFlag", "featureFlagManagerResultCacheSetFlag", Constants.FirelogAnalytics.PARAM_TTL, "featureFlagManagerResultCacheRemoveFlag", "liveActivityListAll", "liveActivityList", "request", "liveActivityStart", "liveActivityUpdate", "liveActivityEnd", "liveUpdateListAll", "liveUpdateList", "liveUpdateStart", "liveUpdateUpdate", "liveUpdateEnd", "liveUpdateClearAll", "notifyPending", "notifyForegroundDisplayRequest", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "Companion", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAirshipModule.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipModule.kt\ncom/urbanairship/reactnative/AirshipModule\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,889:1\n1755#2,3:890\n1755#2,3:893\n1863#2,2:896\n*S KotlinDebug\n*F\n+ 1 AirshipModule.kt\ncom/urbanairship/reactnative/AirshipModule\n*L\n128#1:890,3\n132#1:893,3\n382#1:896,2\n*E\n"})
/* loaded from: classes5.dex */
public final class AirshipModule extends AirshipSpec {

    @NotNull
    public static final String NAME = "RNAirship";

    @NotNull
    private final ReactApplicationContext context;

    @NotNull
    private final AirshipModule$foregroundDisplayPredicate$1 foregroundDisplayPredicate;

    @NotNull
    private final Map<String, CompletableDeferred<Boolean>> foregroundDisplayRequestMap;
    private boolean isOverrideForegroundDisplayEnabled;

    @NotNull
    private final AirshipProxy proxy;

    @NotNull
    private final CoroutineScope scope;

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void addListener(@Nullable String eventType) {
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosGetAuthorizedNotificationSettings(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosGetAuthorizedNotificationStatus(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosIsOverridePresentationOptionsEnabled(boolean enabled) {
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosOverridePresentationOptions(@Nullable String requestId, @Nullable ReadableArray options) {
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void removeListeners(double count) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.urbanairship.reactnative.AirshipModule$foregroundDisplayPredicate$1] */
    public AirshipModule(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.proxy = AirshipProxy.INSTANCE.shared(context);
        this.foregroundDisplayRequestMap = new LinkedHashMap();
        this.scope = CoroutineScopeKt.plus(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        this.foregroundDisplayPredicate = new SuspendingPredicate<Map<String, ? extends Object>>() { // from class: com.urbanairship.reactnative.AirshipModule$foregroundDisplayPredicate$1
            @Override // com.urbanairship.android.framework.proxy.proxies.SuspendingPredicate
            public /* bridge */ /* synthetic */ Object apply(Map<String, ? extends Object> map, Continuation continuation) {
                return apply2(map, (Continuation<? super Boolean>) continuation);
            }

            /* renamed from: apply, reason: avoid collision after fix types in other method */
            public Object apply2(Map<String, ? extends Object> map, Continuation<? super Boolean> continuation) {
                CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                Map map2 = this.this$0.foregroundDisplayRequestMap;
                AirshipModule airshipModule = this.this$0;
                synchronized (map2) {
                    if (airshipModule.isOverrideForegroundDisplayEnabled && airshipModule.getContext().hasActiveReactInstance()) {
                        String string = UUID.randomUUID().toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        airshipModule.foregroundDisplayRequestMap.put(string, completableDeferredCompletableDeferred$default);
                        JsonMap jsonMapBuild = JsonMap.newBuilder().putOpt("pushPayload", map).put("requestId", string).build();
                        Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
                        airshipModule.notifyForegroundDisplayRequest(jsonMapBuild);
                        Unit unit = Unit.INSTANCE;
                        return completableDeferredCompletableDeferred$default.await(continuation);
                    }
                    return Boxing.boxBoolean(true);
                }
            }
        };
    }

    @NotNull
    public final ReactApplicationContext getContext() {
        return this.context;
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "RNAirship";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    @SuppressLint({"RestrictedApi"})
    public void initialize() {
        super.initialize();
        if (!ManifestUtils.INSTANCE.isHeadlessJSTaskEnabledOnStart(this.context)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C13331(null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
        this.context.addLifecycleEventListener(new LifecycleEventListener() { // from class: com.urbanairship.reactnative.AirshipModule.initialize.3
            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostDestroy() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostPause() {
            }

            @Override // com.facebook.react.bridge.LifecycleEventListener
            public void onHostResume() {
                EventType[] eventTypeArrValues = EventType.values();
                ArrayList arrayList = new ArrayList();
                for (EventType eventType : eventTypeArrValues) {
                    if (!AirshipModuleKt.isForeground(eventType)) {
                        arrayList.add(eventType);
                    }
                }
                if (EventEmitter.INSTANCE.shared().hasEvents(arrayList)) {
                    AirshipHeadlessEventService.INSTANCE.startService(AirshipModule.this.getContext());
                }
            }
        });
        this.proxy.getPush().setForegroundNotificationDisplayPredicate(this.foregroundDisplayPredicate);
        ProxyLogger.debug("AirshipModule initialized", new Object[0]);
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$initialize$1, reason: invalid class name and case insensitive filesystem */
    static final class C13331 extends SuspendLambda implements Function2 {
        int label;

        C13331(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipModule.this.new C13331(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C13331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final SharedFlow<Event> pendingEventListener = EventEmitter.INSTANCE.shared().getPendingEventListener();
                Flow<Event> flow = new Flow<Event>() { // from class: com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipModule.kt\ncom/urbanairship/reactnative/AirshipModule$initialize$1\n*L\n1#1,218:1\n18#2:219\n19#2:221\n65#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1$2", f = "AirshipModule.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        /* renamed from: com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1$2$1
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
                                r6 = r5
                                com.urbanairship.android.framework.proxy.Event r6 = (com.urbanairship.android.framework.proxy.Event) r6
                                com.urbanairship.android.framework.proxy.EventType r6 = r6.getType()
                                boolean r6 = com.urbanairship.reactnative.AirshipModuleKt.isForeground(r6)
                                if (r6 != 0) goto L4c
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L4c
                                return r1
                            L4c:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.reactnative.AirshipModule$initialize$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Event> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = pendingEventListener.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final AirshipModule airshipModule = AirshipModule.this;
                FlowCollector<? super Event> flowCollector = new FlowCollector() { // from class: com.urbanairship.reactnative.AirshipModule.initialize.1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Event event, Continuation continuation) {
                        AirshipHeadlessEventService.INSTANCE.startService(airshipModule.getContext());
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

    /* renamed from: com.urbanairship.reactnative.AirshipModule$initialize$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipModule.this.new AnonymousClass2(continuation);
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
                final SharedFlow<Event> pendingEventListener = EventEmitter.INSTANCE.shared().getPendingEventListener();
                Flow<Event> flow = new Flow<Event>() { // from class: com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipModule.kt\ncom/urbanairship/reactnative/AirshipModule$initialize$2\n*L\n1#1,218:1\n18#2:219\n19#2:221\n76#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1$2", f = "AirshipModule.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        /* renamed from: com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                                boolean r0 = r6 instanceof com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1$2$1
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
                                r6 = r5
                                com.urbanairship.android.framework.proxy.Event r6 = (com.urbanairship.android.framework.proxy.Event) r6
                                com.urbanairship.android.framework.proxy.EventType r6 = r6.getType()
                                boolean r6 = com.urbanairship.reactnative.AirshipModuleKt.isForeground(r6)
                                if (r6 == 0) goto L4c
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L4c
                                return r1
                            L4c:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.reactnative.AirshipModule$initialize$2$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super Event> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = pendingEventListener.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final AirshipModule airshipModule = AirshipModule.this;
                FlowCollector<? super Event> flowCollector = new FlowCollector() { // from class: com.urbanairship.reactnative.AirshipModule.initialize.2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Event event, Continuation continuation) {
                        airshipModule.notifyPending();
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

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$takeOff$1, reason: invalid class name and case insensitive filesystem */
    static final class C13781 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13781(ReadableMap readableMap, Continuation continuation) {
            super(1, continuation);
            this.$config = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13781(this.$config, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13781) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipProxy airshipProxy = AirshipModule.this.proxy;
                ReadableMap readableMap = this.$config;
                if (readableMap == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                JsonValue jsonValue = Utils.convertMap(readableMap).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                return Boxing.boxBoolean(airshipProxy.takeOff(jsonValue));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void takeOff(@Nullable ReadableMap config, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13781(config, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$isFlying$1, reason: invalid class name and case insensitive filesystem */
    static final class C13341 extends SuspendLambda implements Function1 {
        int label;

        C13341(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13341(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13341) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(AirshipModule.this.proxy.isFlying());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void isFlying(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13341(null));
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void airshipListenerAdded(@Nullable String eventName) {
        if (eventName == null) {
            return;
        }
        List<EventType> eventTypes = Utils.INSTANCE.parseEventTypes(eventName);
        if (eventTypes.isEmpty()) {
            return;
        }
        if (!eventTypes.isEmpty()) {
            Iterator<T> it = eventTypes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (AirshipModuleKt.isForeground((EventType) it.next())) {
                    notifyPending();
                    break;
                }
            }
        }
        if (eventTypes.isEmpty()) {
            return;
        }
        Iterator<T> it2 = eventTypes.iterator();
        while (it2.hasNext()) {
            if (!AirshipModuleKt.isForeground((EventType) it2.next())) {
                AirshipHeadlessEventService.INSTANCE.startService(this.context);
                return;
            }
        }
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$takePendingEvents$1, reason: invalid class name and case insensitive filesystem */
    static final class C13791 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $eventName;
        final /* synthetic */ boolean $isHeadlessJS;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13791(String str, boolean z, Continuation continuation) {
            super(1, continuation);
            this.$eventName = str;
            this.$isHeadlessJS = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13791(this.$eventName, this.$isHeadlessJS, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13791) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Utils utils = Utils.INSTANCE;
            String str = this.$eventName;
            if (str == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            List<EventType> eventTypes = utils.parseEventTypes(str);
            boolean z = this.$isHeadlessJS;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = eventTypes.iterator();
            while (true) {
                boolean zIsForeground = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                EventType eventType = (EventType) next;
                if (z) {
                    if (!AirshipModuleKt.isForeground(eventType)) {
                        zIsForeground = true;
                    }
                } else {
                    zIsForeground = AirshipModuleKt.isForeground(eventType);
                }
                if (zIsForeground) {
                    arrayList.add(next);
                }
            }
            List<Event> listTakePending = EventEmitter.INSTANCE.shared().takePending(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listTakePending, 10));
            Iterator<T> it2 = listTakePending.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Event) it2.next()).getBody());
            }
            JsonValue jsonValueWrapOpt = JsonValue.wrapOpt(arrayList2);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrapOpt, "wrapOpt(...)");
            ProxyLogger.verbose("Taking events: " + this.$eventName + ", isHeadlessJS: " + this.$isHeadlessJS + ", filteredTypes:" + arrayList + ", result: " + jsonValueWrapOpt, new Object[0]);
            return jsonValueWrapOpt;
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    @SuppressLint({"RestrictedApi"})
    public void takePendingEvents(@Nullable String eventName, boolean isHeadlessJS, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13791(eventName, isHeadlessJS, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelEnableChannelCreation$1, reason: invalid class name and case insensitive filesystem */
    static final class C13101 extends SuspendLambda implements Function1 {
        int label;

        C13101(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13101(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13101) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getChannel().enableChannelCreation();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelEnableChannelCreation(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13101(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelAddTag$1, reason: invalid class name and case insensitive filesystem */
    static final class C13051 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $tag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13051(String str, Continuation continuation) {
            super(1, continuation);
            this.$tag = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13051(this.$tag, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13051) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                String str = this.$tag;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                channel.addTag(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelAddTag(@Nullable String tag, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13051(tag, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelRemoveTag$1, reason: invalid class name and case insensitive filesystem */
    static final class C13141 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $tag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13141(String str, Continuation continuation) {
            super(1, continuation);
            this.$tag = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13141(this.$tag, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13141) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                String str = this.$tag;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                channel.removeTag(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelRemoveTag(@Nullable String tag, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13141(tag, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelEditTags$1, reason: invalid class name and case insensitive filesystem */
    static final class C13091 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13091(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$operations = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13091(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13091) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                JsonValue jsonValue = Utils.INSTANCE.convertArray(this.$operations).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                channel.editTags(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelEditTags(@Nullable ReadableArray operations, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13091(operations, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelGetTags$1, reason: invalid class name and case insensitive filesystem */
    static final class C13131 extends SuspendLambda implements Function1 {
        int label;

        C13131(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13131(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13131) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getChannel().getTags();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelGetTags(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13131(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelGetChannelId$1, reason: invalid class name and case insensitive filesystem */
    static final class C13111 extends SuspendLambda implements Function1 {
        int label;

        C13111(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13111(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13111) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getChannel().getChannelId();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelGetChannelId(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13111(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelWaitForChannelId$1, reason: invalid class name and case insensitive filesystem */
    static final class C13151 extends SuspendLambda implements Function1 {
        int label;

        C13151(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13151(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13151) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                this.label = 1;
                obj = channel.waitForChannelId(this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelWaitForChannelId(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13151(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelGetSubscriptionLists$1, reason: invalid class name and case insensitive filesystem */
    static final class C13121 extends SuspendLambda implements Function1 {
        int label;

        C13121(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13121(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13121) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                this.label = 1;
                obj = channel.getSubscriptionLists(this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelGetSubscriptionLists(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13121(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelEditTagGroups$1, reason: invalid class name and case insensitive filesystem */
    static final class C13081 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13081(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$operations = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13081(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13081) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                JsonValue jsonValue = Utils.INSTANCE.convertArray(this.$operations).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                channel.editTagGroups(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelEditTagGroups(@Nullable ReadableArray operations, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13081(operations, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelEditAttributes$1, reason: invalid class name and case insensitive filesystem */
    static final class C13061 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13061(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$operations = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13061(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13061) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IllegalArgumentException, JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                JsonValue jsonValue = Utils.INSTANCE.convertArray(this.$operations).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                channel.editAttributes(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelEditAttributes(@Nullable ReadableArray operations, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13061(operations, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$channelEditSubscriptionLists$1, reason: invalid class name and case insensitive filesystem */
    static final class C13071 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13071(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$operations = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13071(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13071) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ChannelProxy channel = AirshipModule.this.proxy.getChannel();
                JsonValue jsonValue = Utils.INSTANCE.convertArray(this.$operations).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                channel.editSubscriptionLists(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void channelEditSubscriptionLists(@Nullable ReadableArray operations, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13071(operations, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushSetUserNotificationsEnabled$1, reason: invalid class name and case insensitive filesystem */
    static final class C13771 extends SuspendLambda implements Function1 {
        final /* synthetic */ boolean $enabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13771(boolean z, Continuation continuation) {
            super(1, continuation);
            this.$enabled = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13771(this.$enabled, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13771) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getPush().setUserNotificationsEnabled(this.$enabled);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushSetUserNotificationsEnabled(boolean enabled, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13771(enabled, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushIsUserNotificationsEnabled$1, reason: invalid class name and case insensitive filesystem */
    static final class C13761 extends SuspendLambda implements Function1 {
        int label;

        C13761(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13761(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13761) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(AirshipModule.this.proxy.getPush().isUserNotificationsEnabled());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIsUserNotificationsEnabled(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13761(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushEnableUserNotifications$1, reason: invalid class name and case insensitive filesystem */
    static final class C13661 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $options;
        int label;
        final /* synthetic */ AirshipModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13661(ReadableMap readableMap, AirshipModule airshipModule, Continuation continuation) {
            super(1, continuation);
            this.$options = readableMap;
            this.this$0 = airshipModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13661(this.$options, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13661) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            EnableUserNotificationsArgs enableUserNotificationsArgsFromJson;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReadableMap readableMap = this.$options;
                if (readableMap != null) {
                    EnableUserNotificationsArgs.Companion companion = EnableUserNotificationsArgs.INSTANCE;
                    JsonValue jsonValue = Utils.convertMap(readableMap).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    enableUserNotificationsArgsFromJson = companion.fromJson(jsonValue);
                } else {
                    enableUserNotificationsArgsFromJson = null;
                }
                PushProxy push = this.this$0.proxy.getPush();
                this.label = 1;
                obj = push.enableUserPushNotifications(enableUserNotificationsArgsFromJson, this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushEnableUserNotifications(@Nullable ReadableMap options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13661(options, this, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushGetNotificationStatus$1, reason: invalid class name and case insensitive filesystem */
    static final class C13681 extends SuspendLambda implements Function1 {
        int label;

        C13681(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13681(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13681) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PushProxy push = AirshipModule.this.proxy.getPush();
                this.label = 1;
                obj = push.getNotificationStatus(this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushGetNotificationStatus(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13681(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushGetRegistrationToken$1, reason: invalid class name and case insensitive filesystem */
    static final class C13691 extends SuspendLambda implements Function1 {
        int label;

        C13691(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13691(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13691) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getPush().getRegistrationToken();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushGetRegistrationToken(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13691(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushGetActiveNotifications$1, reason: invalid class name and case insensitive filesystem */
    static final class C13671 extends SuspendLambda implements Function1 {
        int label;

        C13671(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13671(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13671) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getPush().getActiveNotifications();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushGetActiveNotifications(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13671(null));
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushClearNotifications() {
        this.proxy.getPush().clearNotifications();
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushClearNotification(@Nullable String identifier) throws NumberFormatException {
        if (identifier != null) {
            this.proxy.getPush().clearNotification(identifier);
        }
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushIosSetForegroundPresentationOptions$1, reason: invalid class name and case insensitive filesystem */
    static final class C13741 extends SuspendLambda implements Function1 {
        int label;

        C13741(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13741(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13741) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosSetForegroundPresentationOptions(@Nullable ReadableArray options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13741(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushIosSetNotificationOptions$1, reason: invalid class name and case insensitive filesystem */
    static final class C13751 extends SuspendLambda implements Function1 {
        int label;

        C13751(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13751(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13751) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosSetNotificationOptions(@Nullable ReadableArray options, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13751(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushIosSetAutobadgeEnabled$1, reason: invalid class name and case insensitive filesystem */
    static final class C13721 extends SuspendLambda implements Function1 {
        int label;

        C13721(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13721(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13721) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosSetAutobadgeEnabled(boolean enabled, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13721(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushIosIsAutobadgeEnabled$1, reason: invalid class name and case insensitive filesystem */
    static final class C13711 extends SuspendLambda implements Function1 {
        int label;

        C13711(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13711(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13711) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosIsAutobadgeEnabled(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13711(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushIosSetBadgeNumber$1, reason: invalid class name and case insensitive filesystem */
    static final class C13731 extends SuspendLambda implements Function1 {
        int label;

        C13731(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13731(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13731) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosSetBadgeNumber(double badgeNumber, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13731(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushIosGetBadgeNumber$1, reason: invalid class name and case insensitive filesystem */
    static final class C13701 extends SuspendLambda implements Function1 {
        int label;

        C13701(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13701(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13701) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushIosGetBadgeNumber(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13701(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$pushAndroidIsNotificationChannelEnabled$1, reason: invalid class name and case insensitive filesystem */
    static final class C13651 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $channel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13651(String str, Continuation continuation) {
            super(1, continuation);
            this.$channel = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13651(this.$channel, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13651) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PushProxy push = AirshipModule.this.proxy.getPush();
                String str = this.$channel;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                return Boxing.boxBoolean(push.isNotificationChannelEnabled(str));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushAndroidIsNotificationChannelEnabled(@Nullable String channel, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13651(channel, null));
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushAndroidIsOverrideForegroundDisplayEnabled(boolean enabled) {
        synchronized (this.foregroundDisplayRequestMap) {
            try {
                this.isOverrideForegroundDisplayEnabled = enabled;
                if (!enabled) {
                    Iterator<T> it = this.foregroundDisplayRequestMap.values().iterator();
                    while (it.hasNext()) {
                        ((CompletableDeferred) it.next()).complete(Boolean.TRUE);
                    }
                    this.foregroundDisplayRequestMap.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushAndroidOverrideForegroundDisplay(@Nullable String requestId, boolean shouldDisplay) {
        if (requestId == null) {
            return;
        }
        synchronized (this.foregroundDisplayRequestMap) {
            CompletableDeferred<Boolean> completableDeferredRemove = this.foregroundDisplayRequestMap.remove(requestId);
            if (completableDeferredRemove != null) {
                completableDeferredRemove.complete(Boolean.valueOf(shouldDisplay));
            }
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void pushAndroidSetNotificationConfig(@Nullable ReadableMap config) {
        PushProxy push = this.proxy.getPush();
        JsonValue jsonValue = Utils.convertMap(config).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        push.setNotificationConfig(jsonValue);
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactIdentify$1, reason: invalid class name and case insensitive filesystem */
    static final class C13211 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $namedUser;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13211(String str, Continuation continuation) {
            super(1, continuation);
            this.$namedUser = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13211(this.$namedUser, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13211) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getContact().identify(this.$namedUser);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactIdentify(@Nullable String namedUser, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13211(namedUser, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactReset$1, reason: invalid class name and case insensitive filesystem */
    static final class C13231 extends SuspendLambda implements Function1 {
        int label;

        C13231(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13231(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13231) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getContact().reset();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactReset(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13231(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactNotifyRemoteLogin$1, reason: invalid class name and case insensitive filesystem */
    static final class C13221 extends SuspendLambda implements Function1 {
        int label;

        C13221(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13221(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13221) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getContact().notifyRemoteLogin();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactNotifyRemoteLogin(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13221(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactGetNamedUserId$1, reason: invalid class name and case insensitive filesystem */
    static final class C13191 extends SuspendLambda implements Function1 {
        int label;

        C13191(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13191(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13191) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getContact().getNamedUserId();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactGetNamedUserId(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13191(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactGetSubscriptionLists$1, reason: invalid class name and case insensitive filesystem */
    static final class C13201 extends SuspendLambda implements Function1 {
        int label;

        C13201(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13201(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13201) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ContactProxy contact = AirshipModule.this.proxy.getContact();
                this.label = 1;
                obj = contact.getSubscriptionLists(this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactGetSubscriptionLists(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13201(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactEditTagGroups$1, reason: invalid class name and case insensitive filesystem */
    static final class C13181 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13181(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$operations = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13181(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13181) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ContactProxy contact = AirshipModule.this.proxy.getContact();
                JsonValue jsonValue = Utils.INSTANCE.convertArray(this.$operations).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                contact.editTagGroups(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactEditTagGroups(@Nullable ReadableArray operations, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13181(operations, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactEditAttributes$1, reason: invalid class name and case insensitive filesystem */
    static final class C13161 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13161(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$operations = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13161(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13161) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IllegalArgumentException, JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ContactProxy contact = AirshipModule.this.proxy.getContact();
                JsonValue jsonValue = Utils.INSTANCE.convertArray(this.$operations).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                contact.editAttributes(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactEditAttributes(@Nullable ReadableArray operations, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13161(operations, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$contactEditSubscriptionLists$1, reason: invalid class name and case insensitive filesystem */
    static final class C13171 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $operations;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13171(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$operations = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13171(this.$operations, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13171) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ContactProxy contact = AirshipModule.this.proxy.getContact();
                JsonValue jsonValue = Utils.INSTANCE.convertArray(this.$operations).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                contact.editSubscriptionLists(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void contactEditSubscriptionLists(@Nullable ReadableArray operations, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13171(operations, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$analyticsTrackScreen$1, reason: invalid class name and case insensitive filesystem */
    static final class C13041 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $screen;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13041(String str, Continuation continuation) {
            super(1, continuation);
            this.$screen = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13041(this.$screen, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13041) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getAnalytics().trackScreen(this.$screen);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void analyticsTrackScreen(@Nullable String screen, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13041(screen, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$analyticsAssociateIdentifier$1, reason: invalid class name and case insensitive filesystem */
    static final class C13021 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $identifier;
        final /* synthetic */ String $key;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13021(String str, String str2, Continuation continuation) {
            super(1, continuation);
            this.$key = str;
            this.$identifier = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13021(this.$key, this.$identifier, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13021) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AnalyticsProxy analytics = AirshipModule.this.proxy.getAnalytics();
                String str = this.$key;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                analytics.associateIdentifier(str, this.$identifier);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void analyticsAssociateIdentifier(@Nullable String key, @Nullable String identifier, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13021(key, identifier, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$addCustomEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C13011 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13011(ReadableMap readableMap, Continuation continuation) {
            super(1, continuation);
            this.$event = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13011(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13011) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws NumberFormatException, JsonException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AnalyticsProxy analytics = AirshipModule.this.proxy.getAnalytics();
                JsonValue jsonValue = Utils.convertMap(this.$event).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                analytics.addEvent(jsonValue);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void addCustomEvent(@Nullable ReadableMap event, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13011(event, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$analyticsGetSessionId$1, reason: invalid class name and case insensitive filesystem */
    static final class C13031 extends SuspendLambda implements Function1 {
        int label;

        C13031(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13031(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13031) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getAnalytics().getSessionId();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void analyticsGetSessionId(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13031(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$actionRun$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ReadableMap readableMap, Continuation continuation) {
            super(1, continuation);
            this.$action = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new AnonymousClass1(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ActionProxy actions = AirshipModule.this.proxy.getActions();
                String string = this.$action.getString("name");
                if (string == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                JsonValue jsonValueConvertDynamic = Utils.convertDynamic(this.$action.getDynamic("value"));
                this.label = 1;
                obj = actions.runAction(string, jsonValueConvertDynamic, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ActionResult actionResult = (ActionResult) obj;
            if (actionResult.getStatus() == 1) {
                return actionResult.getValue();
            }
            throw new Exception("Action failed " + actionResult.getStatus());
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void actionRun(@NotNull ReadableMap action, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new AnonymousClass1(action, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$privacyManagerSetEnabledFeatures$1, reason: invalid class name and case insensitive filesystem */
    static final class C13641 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $features;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13641(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$features = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13641(this.$features, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13641) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PrivacyManagerProxy privacyManager = AirshipModule.this.proxy.getPrivacyManager();
                Utils utils = Utils.INSTANCE;
                ReadableArray readableArray = this.$features;
                if (readableArray != null) {
                    privacyManager.setEnabledFeatures(utils.convertArray(readableArray));
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void privacyManagerSetEnabledFeatures(@Nullable ReadableArray features, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13641(features, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$privacyManagerGetEnabledFeatures$1, reason: invalid class name and case insensitive filesystem */
    static final class C13621 extends SuspendLambda implements Function1 {
        int label;

        C13621(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13621(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13621) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getPrivacyManager().getFeatureNames();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void privacyManagerGetEnabledFeatures(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13621(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$privacyManagerEnableFeature$1, reason: invalid class name and case insensitive filesystem */
    static final class C13611 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $features;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13611(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$features = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13611(this.$features, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13611) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PrivacyManagerProxy privacyManager = AirshipModule.this.proxy.getPrivacyManager();
                Utils utils = Utils.INSTANCE;
                ReadableArray readableArray = this.$features;
                if (readableArray != null) {
                    privacyManager.enableFeatures(utils.convertArray(readableArray));
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void privacyManagerEnableFeature(@Nullable ReadableArray features, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13611(features, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$privacyManagerDisableFeature$1, reason: invalid class name and case insensitive filesystem */
    static final class C13601 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $features;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13601(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$features = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13601(this.$features, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13601) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PrivacyManagerProxy privacyManager = AirshipModule.this.proxy.getPrivacyManager();
                Utils utils = Utils.INSTANCE;
                ReadableArray readableArray = this.$features;
                if (readableArray != null) {
                    privacyManager.disableFeatures(utils.convertArray(readableArray));
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void privacyManagerDisableFeature(@Nullable ReadableArray features, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13601(features, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$privacyManagerIsFeatureEnabled$1, reason: invalid class name and case insensitive filesystem */
    static final class C13631 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableArray $features;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13631(ReadableArray readableArray, Continuation continuation) {
            super(1, continuation);
            this.$features = readableArray;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13631(this.$features, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13631) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PrivacyManagerProxy privacyManager = AirshipModule.this.proxy.getPrivacyManager();
                Utils utils = Utils.INSTANCE;
                ReadableArray readableArray = this.$features;
                if (readableArray != null) {
                    return Boxing.boxBoolean(privacyManager.isFeatureEnabled(utils.convertArray(readableArray)));
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void privacyManagerIsFeatureEnabled(@Nullable ReadableArray features, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13631(features, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$inAppSetDisplayInterval$1, reason: invalid class name and case insensitive filesystem */
    static final class C13311 extends SuspendLambda implements Function1 {
        final /* synthetic */ double $milliseconds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13311(double d, Continuation continuation) {
            super(1, continuation);
            this.$milliseconds = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13311(this.$milliseconds, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13311) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getInApp().setDisplayInterval((long) this.$milliseconds);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void inAppSetDisplayInterval(double milliseconds, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13311(milliseconds, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$inAppGetDisplayInterval$1, reason: invalid class name and case insensitive filesystem */
    static final class C13291 extends SuspendLambda implements Function1 {
        int label;

        C13291(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13291(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13291) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxLong(AirshipModule.this.proxy.getInApp().getDisplayInterval());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void inAppGetDisplayInterval(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13291(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$inAppSetPaused$1, reason: invalid class name and case insensitive filesystem */
    static final class C13321 extends SuspendLambda implements Function1 {
        final /* synthetic */ boolean $paused;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13321(boolean z, Continuation continuation) {
            super(1, continuation);
            this.$paused = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13321(this.$paused, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13321) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getInApp().setPaused(this.$paused);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void inAppSetPaused(boolean paused, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13321(paused, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$inAppIsPaused$1, reason: invalid class name and case insensitive filesystem */
    static final class C13301 extends SuspendLambda implements Function1 {
        int label;

        C13301(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13301(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13301) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(AirshipModule.this.proxy.getInApp().isPaused());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void inAppIsPaused(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13301(null));
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void inAppResendPendingEmbeddedEvent() {
        this.proxy.getInApp().resendLastEmbeddedEvent();
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterGetUnreadCount$1, reason: invalid class name and case insensitive filesystem */
    static final class C13531 extends SuspendLambda implements Function1 {
        int label;

        C13531(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13531(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13531) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageCenterProxy messageCenter = AirshipModule.this.proxy.getMessageCenter();
                this.label = 1;
                obj = messageCenter.getUnreadMessagesCount(this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterGetUnreadCount(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13531(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterDismiss$1, reason: invalid class name and case insensitive filesystem */
    static final class C13501 extends SuspendLambda implements Function1 {
        int label;

        C13501(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13501(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13501) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getMessageCenter().dismiss();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterDismiss(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13501(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterDisplay$1, reason: invalid class name and case insensitive filesystem */
    static final class C13511 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13511(String str, Continuation continuation) {
            super(1, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13511(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13511) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getMessageCenter().display(this.$messageId);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterDisplay(@Nullable String messageId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13511(messageId, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterGetMessages$1, reason: invalid class name and case insensitive filesystem */
    static final class C13521 extends SuspendLambda implements Function1 {
        int label;

        C13521(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13521(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13521) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageCenterProxy messageCenter = AirshipModule.this.proxy.getMessageCenter();
                this.label = 1;
                obj = messageCenter.getMessages(this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterGetMessages(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13521(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterDeleteMessage$1, reason: invalid class name and case insensitive filesystem */
    static final class C13491 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13491(String str, Continuation continuation) {
            super(1, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13491(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13491) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MessageCenterProxy messageCenter = AirshipModule.this.proxy.getMessageCenter();
                String str = this.$messageId;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                messageCenter.deleteMessage(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterDeleteMessage(@Nullable String messageId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13491(messageId, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterMarkMessageRead$1, reason: invalid class name and case insensitive filesystem */
    static final class C13541 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13541(String str, Continuation continuation) {
            super(1, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13541(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13541) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MessageCenterProxy messageCenter = AirshipModule.this.proxy.getMessageCenter();
                String str = this.$messageId;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                messageCenter.markMessageRead(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterMarkMessageRead(@Nullable String messageId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13541(messageId, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterRefresh$1, reason: invalid class name and case insensitive filesystem */
    static final class C13551 extends SuspendLambda implements Function1 {
        int label;

        C13551(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13551(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13551) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MessageCenterProxy messageCenter = AirshipModule.this.proxy.getMessageCenter();
                this.label = 1;
                obj = messageCenter.refreshInbox(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                throw new Exception("Failed to refresh");
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterRefresh(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13551(null));
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterSetAutoLaunchDefaultMessageCenter(boolean enabled) {
        this.proxy.getMessageCenter().setAutoLaunchDefaultMessageCenter(enabled);
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterShowMessageCenter$1, reason: invalid class name and case insensitive filesystem */
    static final class C13561 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13561(String str, Continuation continuation) {
            super(1, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13561(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13561) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getMessageCenter().showMessageCenter(this.$messageId);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterShowMessageCenter(@Nullable String messageId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13561(messageId, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$messageCenterShowMessageView$1, reason: invalid class name and case insensitive filesystem */
    static final class C13571 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $messageId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13571(String str, Continuation continuation) {
            super(1, continuation);
            this.$messageId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13571(this.$messageId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13571) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MessageCenterProxy messageCenter = AirshipModule.this.proxy.getMessageCenter();
                String str = this.$messageId;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                messageCenter.showMessageView(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void messageCenterShowMessageView(@Nullable String messageId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13571(messageId, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$preferenceCenterDisplay$1, reason: invalid class name and case insensitive filesystem */
    static final class C13581 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $preferenceCenterId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13581(String str, Continuation continuation) {
            super(1, continuation);
            this.$preferenceCenterId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13581(this.$preferenceCenterId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13581) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PreferenceCenterProxy preferenceCenter = AirshipModule.this.proxy.getPreferenceCenter();
                String str = this.$preferenceCenterId;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                preferenceCenter.displayPreferenceCenter(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void preferenceCenterDisplay(@Nullable String preferenceCenterId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13581(preferenceCenterId, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$preferenceCenterGetConfig$1, reason: invalid class name and case insensitive filesystem */
    static final class C13591 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $preferenceCenterId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13591(String str, Continuation continuation) {
            super(1, continuation);
            this.$preferenceCenterId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13591(this.$preferenceCenterId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13591) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PreferenceCenterProxy preferenceCenter = AirshipModule.this.proxy.getPreferenceCenter();
                String str = this.$preferenceCenterId;
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                this.label = 1;
                obj = preferenceCenter.getPreferenceCenterConfig(str, this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void preferenceCenterGetConfig(@Nullable String preferenceCenterId, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13591(preferenceCenterId, null));
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void preferenceCenterAutoLaunchDefaultPreferenceCenter(@Nullable String preferenceCenterId, boolean autoLaunch) {
        if (preferenceCenterId != null) {
            this.proxy.getPreferenceCenter().setAutoLaunchPreferenceCenter(preferenceCenterId, autoLaunch);
        }
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$localeSetLocaleOverride$1, reason: invalid class name and case insensitive filesystem */
    static final class C13481 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $localeIdentifier;
        int label;
        final /* synthetic */ AirshipModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13481(String str, AirshipModule airshipModule, Continuation continuation) {
            super(1, continuation);
            this.$localeIdentifier = str;
            this.this$0 = airshipModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13481(this.$localeIdentifier, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13481) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$localeIdentifier;
            if (str == null || str.length() == 0) {
                this.this$0.proxy.getLocale().clearLocale();
            } else {
                this.this$0.proxy.getLocale().setCurrentLocale(this.$localeIdentifier);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void localeSetLocaleOverride(@Nullable String localeIdentifier, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13481(localeIdentifier, this, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$localeGetLocale$1, reason: invalid class name and case insensitive filesystem */
    static final class C13471 extends SuspendLambda implements Function1 {
        int label;

        C13471(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13471(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13471) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return AirshipModule.this.proxy.getLocale().getCurrentLocale();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void localeGetLocale(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13471(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$localeClearLocaleOverride$1, reason: invalid class name and case insensitive filesystem */
    static final class C13461 extends SuspendLambda implements Function1 {
        int label;

        C13461(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13461(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13461) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getLocale().clearLocale();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void localeClearLocaleOverride(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13461(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$featureFlagManagerFlag$1, reason: invalid class name and case insensitive filesystem */
    static final class C13241 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $flagName;
        final /* synthetic */ boolean $useResultCache;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13241(String str, boolean z, Continuation continuation) {
            super(1, continuation);
            this.$flagName = str;
            this.$useResultCache = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13241(this.$flagName, this.$useResultCache, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13241) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FeatureFlagManagerProxy featureFlagManager = AirshipModule.this.proxy.getFeatureFlagManager();
                String str = this.$flagName;
                boolean z = this.$useResultCache;
                this.label = 1;
                obj = featureFlagManager.flag(str, z, this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void featureFlagManagerFlag(@NotNull String flagName, boolean useResultCache, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(flagName, "flagName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13241(flagName, useResultCache, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$featureFlagManagerTrackInteraction$1, reason: invalid class name and case insensitive filesystem */
    static final class C13281 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $flag;
        int label;
        final /* synthetic */ AirshipModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13281(ReadableMap readableMap, AirshipModule airshipModule, Continuation continuation) {
            super(1, continuation);
            this.$flag = readableMap;
            this.this$0 = airshipModule;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13281(this.$flag, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13281) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            JsonValue jsonValue = Utils.convertMap(this.$flag).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            this.this$0.proxy.getFeatureFlagManager().trackInteraction(new FeatureFlagProxy(jsonValue));
            return Unit.INSTANCE;
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void featureFlagManagerTrackInteraction(@NotNull ReadableMap flag, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13281(flag, this, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$featureFlagManagerResultCacheGetFlag$1, reason: invalid class name and case insensitive filesystem */
    static final class C13251 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $flagName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13251(String str, Continuation continuation) {
            super(1, continuation);
            this.$flagName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13251(this.$flagName, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13251) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FeatureFlagManagerProxy.ResultCacheProxy resultCache = AirshipModule.this.proxy.getFeatureFlagManager().getResultCache();
                String str = this.$flagName;
                this.label = 1;
                obj = resultCache.flag(str, this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void featureFlagManagerResultCacheGetFlag(@NotNull String flagName, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(flagName, "flagName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13251(flagName, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$featureFlagManagerResultCacheSetFlag$1, reason: invalid class name and case insensitive filesystem */
    static final class C13271 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $flag;
        final /* synthetic */ double $ttl;
        int label;
        final /* synthetic */ AirshipModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13271(ReadableMap readableMap, AirshipModule airshipModule, double d, Continuation continuation) {
            super(1, continuation);
            this.$flag = readableMap;
            this.this$0 = airshipModule;
            this.$ttl = d;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13271(this.$flag, this.this$0, this.$ttl, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13271) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                JsonValue jsonValue = Utils.convertMap(this.$flag).getJsonValue();
                Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                FeatureFlagProxy featureFlagProxy = new FeatureFlagProxy(jsonValue);
                FeatureFlagManagerProxy.ResultCacheProxy resultCache = this.this$0.proxy.getFeatureFlagManager().getResultCache();
                Duration.Companion companion = Duration.INSTANCE;
                long duration = DurationKt.toDuration(this.$ttl, DurationUnit.MILLISECONDS);
                this.label = 1;
                if (resultCache.m2712cache8Mi8wO0(featureFlagProxy, duration, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void featureFlagManagerResultCacheSetFlag(@NotNull ReadableMap flag, double ttl, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(flag, "flag");
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13271(flag, this, ttl, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$featureFlagManagerResultCacheRemoveFlag$1, reason: invalid class name and case insensitive filesystem */
    static final class C13261 extends SuspendLambda implements Function1 {
        final /* synthetic */ String $flagName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13261(String str, Continuation continuation) {
            super(1, continuation);
            this.$flagName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13261(this.$flagName, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13261) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FeatureFlagManagerProxy.ResultCacheProxy resultCache = AirshipModule.this.proxy.getFeatureFlagManager().getResultCache();
                String str = this.$flagName;
                this.label = 1;
                if (resultCache.removeCachedFlag(str, this) == coroutine_suspended) {
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void featureFlagManagerResultCacheRemoveFlag(@NotNull String flagName, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(flagName, "flagName");
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13261(flagName, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveActivityListAll$1, reason: invalid class name and case insensitive filesystem */
    static final class C13371 extends SuspendLambda implements Function1 {
        int label;

        C13371(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13371(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13371) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveActivityListAll(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13371(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveActivityList$1, reason: invalid class name and case insensitive filesystem */
    static final class C13361 extends SuspendLambda implements Function1 {
        int label;

        C13361(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13361(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13361) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveActivityList(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13361(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveActivityStart$1, reason: invalid class name and case insensitive filesystem */
    static final class C13381 extends SuspendLambda implements Function1 {
        int label;

        C13381(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13381(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13381) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveActivityStart(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13381(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveActivityUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C13391 extends SuspendLambda implements Function1 {
        int label;

        C13391(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13391(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13391) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveActivityUpdate(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13391(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveActivityEnd$1, reason: invalid class name and case insensitive filesystem */
    static final class C13351 extends SuspendLambda implements Function1 {
        int label;

        C13351(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new C13351(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13351) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new IllegalStateException("Not supported on Android");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveActivityEnd(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13351(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveUpdateListAll$1, reason: invalid class name and case insensitive filesystem */
    static final class C13431 extends SuspendLambda implements Function1 {
        int label;

        C13431(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13431(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13431) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LiveUpdatesManagerProxy liveUpdateManager = AirshipModule.this.proxy.getLiveUpdateManager();
                this.label = 1;
                obj = liveUpdateManager.listAll(this);
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveUpdateListAll(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13431(null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveUpdateList$1, reason: invalid class name and case insensitive filesystem */
    static final class C13421 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13421(ReadableMap readableMap, Continuation continuation) {
            super(1, continuation);
            this.$request = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13421(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13421) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws JsonException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LiveUpdatesManagerProxy liveUpdateManager = AirshipModule.this.proxy.getLiveUpdateManager();
                LiveUpdateRequest.List.Companion companion = LiveUpdateRequest.List.INSTANCE;
                ReadableMap readableMap = this.$request;
                if (readableMap != null) {
                    JsonValue jsonValue = Utils.convertMap(readableMap).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    LiveUpdateRequest.List listFromJson = companion.fromJson(jsonValue);
                    this.label = 1;
                    obj = liveUpdateManager.list(listFromJson, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.");
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

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveUpdateList(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13421(request, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveUpdateStart$1, reason: invalid class name and case insensitive filesystem */
    static final class C13441 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13441(ReadableMap readableMap, Continuation continuation) {
            super(1, continuation);
            this.$request = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13441(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13441) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LiveUpdatesManagerProxy liveUpdateManager = AirshipModule.this.proxy.getLiveUpdateManager();
                LiveUpdateRequest.Start.Companion companion = LiveUpdateRequest.Start.INSTANCE;
                ReadableMap readableMap = this.$request;
                if (readableMap != null) {
                    JsonValue jsonValue = Utils.convertMap(readableMap).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    liveUpdateManager.start(companion.fromJson(jsonValue));
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveUpdateStart(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13441(request, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveUpdateUpdate$1, reason: invalid class name and case insensitive filesystem */
    static final class C13451 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13451(ReadableMap readableMap, Continuation continuation) {
            super(1, continuation);
            this.$request = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13451(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13451) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LiveUpdatesManagerProxy liveUpdateManager = AirshipModule.this.proxy.getLiveUpdateManager();
                LiveUpdateRequest.Update.Companion companion = LiveUpdateRequest.Update.INSTANCE;
                ReadableMap readableMap = this.$request;
                if (readableMap != null) {
                    JsonValue jsonValue = Utils.convertMap(readableMap).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    liveUpdateManager.update(companion.fromJson(jsonValue));
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveUpdateUpdate(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13451(request, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveUpdateEnd$1, reason: invalid class name and case insensitive filesystem */
    static final class C13411 extends SuspendLambda implements Function1 {
        final /* synthetic */ ReadableMap $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13411(ReadableMap readableMap, Continuation continuation) {
            super(1, continuation);
            this.$request = readableMap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13411(this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13411) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                LiveUpdatesManagerProxy liveUpdateManager = AirshipModule.this.proxy.getLiveUpdateManager();
                LiveUpdateRequest.End.Companion companion = LiveUpdateRequest.End.INSTANCE;
                ReadableMap readableMap = this.$request;
                if (readableMap != null) {
                    JsonValue jsonValue = Utils.convertMap(readableMap).getJsonValue();
                    Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
                    liveUpdateManager.end(companion.fromJson(jsonValue));
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveUpdateEnd(@Nullable ReadableMap request, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13411(request, null));
    }

    /* renamed from: com.urbanairship.reactnative.AirshipModule$liveUpdateClearAll$1, reason: invalid class name and case insensitive filesystem */
    static final class C13401 extends SuspendLambda implements Function1 {
        int label;

        C13401(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return AirshipModule.this.new C13401(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((C13401) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                AirshipModule.this.proxy.getLiveUpdateManager().clearAll();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.urbanairship.reactnative.NativeRNAirshipSpec
    @ReactMethod
    public void liveUpdateClearAll(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        AirshipModuleKt.resolve(promise, this.scope, new C13401(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyPending() {
        if (this.context.hasActiveReactInstance()) {
            ((RCTNativeAppEventEmitter) this.context.getJSModule(RCTNativeAppEventEmitter.class)).emit("com.airship.pending_events", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyForegroundDisplayRequest(JsonMap body) {
        if (this.context.hasActiveReactInstance()) {
            ((RCTNativeAppEventEmitter) this.context.getJSModule(RCTNativeAppEventEmitter.class)).emit("com.airship.android.override_foreground_display", AirshipModuleKt.toReactType(body));
        }
    }
}
