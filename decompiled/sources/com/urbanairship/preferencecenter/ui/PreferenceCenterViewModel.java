package com.urbanairship.preferencecenter.ui;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import ch.qos.logback.core.CoreConstants;
import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.contentsquare.android.api.Currencies;
import com.dlp.BluetoothManager;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.UALog;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.actions.DefaultActionRunner;
import com.urbanairship.annotation.OpenForTesting;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.contacts.Contact;
import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.contacts.Scope;
import com.urbanairship.inputvalidation.AirshipInputValidation;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.ConditionStateMonitor;
import com.urbanairship.preferencecenter.PreferenceCenter;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.data.Options;
import com.urbanairship.preferencecenter.data.PreferenceCenterConfig;
import com.urbanairship.preferencecenter.data.PreferenceCenterConfigParceler;
import com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel;
import com.urbanairship.preferencecenter.ui.item.PrefCenterItem;
import com.urbanairship.preferencecenter.util.FlowExtensionsKt;
import com.urbanairship.preferencecenter.widget.ContactChannelDialogInputView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@OpenForTesting
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0011\u0018\u0000 ]2\u00020\u0001:\u0006[\\]^_`B]\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0002\u0010\u0013J\u0010\u0010,\u001a\u00020-2\u0006\u0010\b\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010\b\u001a\u00020 H\u0016J\u0010\u0010/\u001a\u00020-2\u0006\u0010\b\u001a\u00020 H\u0016J\u001c\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00182\u0006\u00102\u001a\u00020\u0016H\u0092@¢\u0006\u0002\u00103J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u00102\u001a\u00020\u0016H\u0092@¢\u0006\u0002\u00103J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0018H\u0012J\u0014\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 070\u0018H\u0012J\u001a\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000307090\u0018H\u0012J'\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0003072\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030709H\u0012¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0012J&\u0010?\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020A070@090\u0018H\u0012J?\u0010B\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020A070@2\u001e\u0010;\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020A070@09H\u0012¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020-2\u0006\u00102\u001a\u00020\u0016H\u0016JB\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020A070@2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u0003072\u0018\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020A070@H\u0012J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u0002010\u0018H\u0012J\u001a\u0010I\u001a\u00020-2\u0006\u0010\b\u001a\u00020 2\b\b\u0002\u0010J\u001a\u00020KH\u0016J$\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00182\u0006\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u000201H\u0092@¢\u0006\u0002\u0010NJ.\u0010O\u001a\b\u0012\u0004\u0012\u0002010\u00182\u0006\u0010P\u001a\u00020Q2\u000e\b\u0002\u0010R\u001a\b\u0012\u0004\u0012\u00020A072\u0006\u0010S\u001a\u00020KH\u0012J\u0016\u0010T\u001a\u00020U2\u0006\u00102\u001a\u00020VH\u0092@¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u00020U2\u0006\u00102\u001a\u00020YH\u0092@¢\u0006\u0002\u0010ZR\u000e\u0010\u000e\u001a\u00020\u000fX\u0092\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dX\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0092\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0092\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0092\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0092\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006a"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel;", "Landroidx/lifecycle/ViewModel;", "preferenceCenterId", "", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "preferenceCenter", "Lcom/urbanairship/preferencecenter/PreferenceCenter;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/channel/AirshipChannel;", "contact", "Lcom/urbanairship/contacts/Contact;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "actionRunner", "Lcom/urbanairship/actions/ActionRunner;", "conditionMonitor", "Lcom/urbanairship/preferencecenter/ConditionStateMonitor;", "dispatcher", "(Ljava/lang/String;Landroidx/lifecycle/SavedStateHandle;Lcom/urbanairship/preferencecenter/PreferenceCenter;Lcom/urbanairship/channel/AirshipChannel;Lcom/urbanairship/contacts/Contact;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/urbanairship/actions/ActionRunner;Lcom/urbanairship/preferencecenter/ConditionStateMonitor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "actions", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "effects", "Lkotlinx/coroutines/flow/Flow;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "getEffects", "()Lkotlinx/coroutines/flow/Flow;", "effectsChannel", "Lkotlinx/coroutines/channels/Channel;", "hidePendingLabelJobs", "", "Lcom/urbanairship/contacts/ContactChannel;", "Lkotlinx/coroutines/Job;", "restoredState", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content;", "showResendButtonJobs", "stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;", "states", "Lkotlinx/coroutines/flow/StateFlow;", "getStates", "()Lkotlinx/coroutines/flow/StateFlow;", "cancelPendingResendVisibilityChanges", "", "cancelPendingVisibilityChanges", "cancelResendVisibilityChanges", "changes", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", "action", "(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enrichedConfig", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$EnrichedConfig;", "getAssociatedChannels", "", "getChannelSubscriptions", "Lkotlin/Result;", "getChannelSubscriptionsAsSet", "subscriptionsResult", "(Ljava/lang/Object;)Ljava/util/Set;", "getConfig", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "getContactSubscriptions", "", "Lcom/urbanairship/contacts/Scope;", "getContactSubscriptionsAsMap", "(Ljava/lang/Object;)Ljava/util/Map;", "handle", "mergeSubscriptions", "channelSubscriptions", "contactSubscriptions", "refresh", "schedulePendingResendVisibilityChanges", "onlyHide", "", BluetoothManager.BLE_STATUS_PARAM, "change", "(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePreference", "item", "Lcom/urbanairship/preferencecenter/data/Item;", "scopes", "isEnabled", "validateEmailAction", "Lcom/urbanairship/inputvalidation/AirshipInputValidation$Result;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateEmailChannel;", "(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateEmailChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSmsAction", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateSmsChannel;", "(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateSmsChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", JsonDocumentFields.ACTION, "Change", "Companion", JsonDocumentFields.STATEMENT_EFFECT, "EnrichedConfig", "State", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferenceCenterViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 7 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,806:1\n49#2:807\n51#2:811\n49#2:819\n51#2:823\n56#2:824\n59#2:828\n46#3:808\n51#3:810\n46#3:820\n51#3:822\n46#3:825\n51#3:827\n105#4:809\n105#4:821\n105#4:826\n125#5:812\n152#5,3:813\n1#6:816\n1855#7,2:817\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel\n*L\n152#1:807\n152#1:811\n527#1:819\n527#1:823\n565#1:824\n565#1:828\n152#1:808\n152#1:810\n527#1:820\n527#1:822\n565#1:825\n565#1:827\n152#1:809\n527#1:821\n565#1:826\n383#1:812\n383#1:813,3\n436#1:817,2\n*E\n"})
/* loaded from: classes5.dex */
public class PreferenceCenterViewModel extends ViewModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long defaultPendingLabelHideDelay;
    private static final long defaultResendLabelHideDelay;
    private final ActionRunner actionRunner;
    private final MutableSharedFlow actions;
    private final AirshipChannel channel;
    private final ConditionStateMonitor conditionMonitor;
    private final Contact contact;
    private final CoroutineDispatcher dispatcher;
    private final Flow effects;
    private final Channel effectsChannel;
    private Map hidePendingLabelJobs;
    private final CoroutineDispatcher ioDispatcher;
    private final PreferenceCenter preferenceCenter;
    private final String preferenceCenterId;
    private final State.Content restoredState;
    private final SavedStateHandle savedStateHandle;
    private Map showResendButtonJobs;
    private final MutableStateFlow stateFlow;
    private final StateFlow states;

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$effects$2, reason: invalid class name and case insensitive filesystem */
    static final class C12902 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12902(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreferenceCenterViewModel.this.effects(null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle) {
        this(preferenceCenterId, savedStateHandle, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle, @NotNull PreferenceCenter preferenceCenter) {
        this(preferenceCenterId, savedStateHandle, preferenceCenter, null, null, null, null, null, null, 504, null);
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(preferenceCenter, "preferenceCenter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle, @NotNull PreferenceCenter preferenceCenter, @NotNull AirshipChannel channel) {
        this(preferenceCenterId, savedStateHandle, preferenceCenter, channel, null, null, null, null, null, Currencies.MNT, null);
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(preferenceCenter, "preferenceCenter");
        Intrinsics.checkNotNullParameter(channel, "channel");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle, @NotNull PreferenceCenter preferenceCenter, @NotNull AirshipChannel channel, @NotNull Contact contact) {
        this(preferenceCenterId, savedStateHandle, preferenceCenter, channel, contact, null, null, null, null, Currencies.MUR, null);
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(preferenceCenter, "preferenceCenter");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(contact, "contact");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle, @NotNull PreferenceCenter preferenceCenter, @NotNull AirshipChannel channel, @NotNull Contact contact, @NotNull CoroutineDispatcher ioDispatcher) {
        this(preferenceCenterId, savedStateHandle, preferenceCenter, channel, contact, ioDispatcher, null, null, null, 448, null);
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(preferenceCenter, "preferenceCenter");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle, @NotNull PreferenceCenter preferenceCenter, @NotNull AirshipChannel channel, @NotNull Contact contact, @NotNull CoroutineDispatcher ioDispatcher, @NotNull ActionRunner actionRunner) {
        this(preferenceCenterId, savedStateHandle, preferenceCenter, channel, contact, ioDispatcher, actionRunner, null, null, 384, null);
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(preferenceCenter, "preferenceCenter");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle, @NotNull PreferenceCenter preferenceCenter, @NotNull AirshipChannel channel, @NotNull Contact contact, @NotNull CoroutineDispatcher ioDispatcher, @NotNull ActionRunner actionRunner, @NotNull ConditionStateMonitor conditionMonitor) {
        this(preferenceCenterId, savedStateHandle, preferenceCenter, channel, contact, ioDispatcher, actionRunner, conditionMonitor, null, 256, null);
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(preferenceCenter, "preferenceCenter");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        Intrinsics.checkNotNullParameter(conditionMonitor, "conditionMonitor");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bR\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Companion;", "", "()V", "defaultPendingLabelHideDelay", "Lkotlin/time/Duration;", "J", "defaultResendLabelHideDelay", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "preferenceCenterId", "", "factory$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPreferenceCenterViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Companion\n+ 2 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryKt\n*L\n1#1,806:1\n35#2:807\n77#2,2:808\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Companion\n*L\n99#1:807\n100#1:808,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ViewModelProvider.Factory factory$urbanairship_preference_center_release(@NotNull final String preferenceCenterId) {
            Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(PreferenceCenterViewModel.class), new Function1() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Companion$factory$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final PreferenceCenterViewModel invoke(CreationExtras initializer) {
                    Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
                    return new PreferenceCenterViewModel(preferenceCenterId, SavedStateHandleSupport.createSavedStateHandle(initializer), null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
                }
            });
            return initializerViewModelFactoryBuilder.build();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PreferenceCenterViewModel(String str, SavedStateHandle savedStateHandle, PreferenceCenter preferenceCenter, AirshipChannel airshipChannel, Contact contact, CoroutineDispatcher coroutineDispatcher, ActionRunner actionRunner, ConditionStateMonitor conditionStateMonitor, CoroutineDispatcher coroutineDispatcher2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        AirshipChannel airshipChannel2;
        Contact contact2;
        PreferenceCenter preferenceCenterShared = (i & 4) != 0 ? PreferenceCenter.INSTANCE.shared() : preferenceCenter;
        if ((i & 8) != 0) {
            AirshipChannel channel = UAirship.shared().getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
            airshipChannel2 = channel;
        } else {
            airshipChannel2 = airshipChannel;
        }
        if ((i & 16) != 0) {
            Contact contact3 = UAirship.shared().getContact();
            Intrinsics.checkNotNullExpressionValue(contact3, "getContact(...)");
            contact2 = contact3;
        } else {
            contact2 = contact;
        }
        this(str, savedStateHandle, preferenceCenterShared, airshipChannel2, contact2, (i & 32) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i & 64) != 0 ? DefaultActionRunner.INSTANCE : actionRunner, (i & 128) != 0 ? new ConditionStateMonitor(null, 1, null) : conditionStateMonitor, (i & 256) != 0 ? Dispatchers.getMain().getImmediate() : coroutineDispatcher2);
    }

    @JvmOverloads
    public PreferenceCenterViewModel(@NotNull String preferenceCenterId, @NotNull SavedStateHandle savedStateHandle, @NotNull PreferenceCenter preferenceCenter, @NotNull AirshipChannel channel, @NotNull Contact contact, @NotNull CoroutineDispatcher ioDispatcher, @NotNull ActionRunner actionRunner, @NotNull ConditionStateMonitor conditionMonitor, @NotNull CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(preferenceCenterId, "preferenceCenterId");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(preferenceCenter, "preferenceCenter");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        Intrinsics.checkNotNullParameter(conditionMonitor, "conditionMonitor");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.preferenceCenterId = preferenceCenterId;
        this.savedStateHandle = savedStateHandle;
        this.preferenceCenter = preferenceCenter;
        this.channel = channel;
        this.contact = contact;
        this.ioDispatcher = ioDispatcher;
        this.actionRunner = actionRunner;
        this.conditionMonitor = conditionMonitor;
        this.dispatcher = dispatcher;
        State.Content content = (State.Content) savedStateHandle.get(BluetoothManager.BLE_STATUS_PARAM);
        this.restoredState = content;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(content == null ? State.Loading.INSTANCE : content);
        this.stateFlow = MutableStateFlow;
        this.actions = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        Channel channelChannel$default = ChannelKt.Channel$default(0, null, null, 7, null);
        this.effectsChannel = channelChannel$default;
        this.states = FlowKt.asStateFlow(MutableStateFlow);
        this.effects = FlowKt.onEach(FlowKt.receiveAsFlow(channelChannel$default), new C12891(null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), dispatcher, null, new AnonymousClass1(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), dispatcher, null, new AnonymousClass2(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), dispatcher, null, new AnonymousClass3(null), 2, null);
        final Flow<Condition.State> states = conditionMonitor.getStates();
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(new Flow<Action.ConditionStateChanged>() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel\n*L\n1#1,218:1\n50#2:219\n152#3:220\n*E\n"})
            /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1$2", f = "PreferenceCenterViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1$2$1 r0 = (com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1$2$1 r0 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L46
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        com.urbanairship.preferencecenter.data.Condition$State r5 = (com.urbanairship.preferencecenter.data.Condition.State) r5
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ConditionStateChanged r6 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action$ConditionStateChanged
                        r6.<init>(r5)
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r6, r0)
                        if (r4 != r1) goto L46
                        return r1
                    L46:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super PreferenceCenterViewModel.Action.ConditionStateChanged> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = states.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass5(null)), dispatcher), ViewModelKt.getViewModelScope(this));
        this.showResendButtonJobs = new LinkedHashMap();
        this.hidePendingLabelJobs = new LinkedHashMap();
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        DurationUnit durationUnit = DurationUnit.SECONDS;
        defaultPendingLabelHideDelay = DurationKt.toDuration(30, durationUnit);
        defaultResendLabelHideDelay = DurationKt.toDuration(15, durationUnit);
    }

    @NotNull
    public StateFlow<State> getStates() {
        return this.states;
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$effects$1, reason: invalid class name and case insensitive filesystem */
    static final class C12891 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C12891(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C12891 c12891 = new C12891(continuation);
            c12891.L$0 = obj;
            return c12891;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Effect effect, Continuation continuation) {
            return ((C12891) create(effect, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            UALog.v("! " + ((Effect) this.L$0), new Object[0]);
            return Unit.INSTANCE;
        }
    }

    @NotNull
    public Flow<Effect> getEffects() {
        return this.effects;
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = PreferenceCenterViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
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
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                MutableSharedFlow mutableSharedFlow = PreferenceCenterViewModel.this.actions;
                final PreferenceCenterViewModel preferenceCenterViewModel = PreferenceCenterViewModel.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Action action, Continuation continuation) {
                        UALog.v("< " + action, new Object[0]);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01581(preferenceCenterViewModel, action, null), 3, null);
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(preferenceCenterViewModel, action, null), 3, null);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C01581 extends SuspendLambda implements Function2 {
                        final /* synthetic */ Action $action;
                        int label;
                        final /* synthetic */ PreferenceCenterViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C01581(PreferenceCenterViewModel preferenceCenterViewModel, Action action, Continuation continuation) {
                            super(2, continuation);
                            this.this$0 = preferenceCenterViewModel;
                            this.$action = action;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new C01581(this.this$0, this.$action, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((C01581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                PreferenceCenterViewModel preferenceCenterViewModel = this.this$0;
                                Action action = this.$action;
                                this.label = 1;
                                obj = preferenceCenterViewModel.changes(action, this);
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
                                ResultKt.throwOnFailure(obj);
                            }
                            Flow flowScanConcat = FlowExtensionsKt.scanConcat((Flow) obj, this.this$0.getStates().getValue(), new C01591(this.this$0));
                            final PreferenceCenterViewModel preferenceCenterViewModel2 = this.this$0;
                            FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.1.1.1.2
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                public final Object emit(State state, Continuation continuation) {
                                    State.Content content = state instanceof State.Content ? (State.Content) state : null;
                                    if (content != null) {
                                        preferenceCenterViewModel2.savedStateHandle.set(BluetoothManager.BLE_STATUS_PARAM, content);
                                    }
                                    preferenceCenterViewModel2.stateFlow.setValue(state);
                                    return Unit.INSTANCE;
                                }
                            };
                            this.label = 2;
                            if (flowScanConcat.collect(flowCollector, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }

                        /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* synthetic */ class C01591 extends FunctionReferenceImpl implements Function3, SuspendFunction {
                            C01591(Object obj) {
                                super(3, obj, PreferenceCenterViewModel.class, "states", "states(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(State state, Change change, Continuation continuation) {
                                return ((PreferenceCenterViewModel) this.receiver).states(state, change, continuation);
                            }
                        }
                    }

                    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$1$1$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
                        final /* synthetic */ Action $action;
                        int label;
                        final /* synthetic */ PreferenceCenterViewModel this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(PreferenceCenterViewModel preferenceCenterViewModel, Action action, Continuation continuation) {
                            super(2, continuation);
                            this.this$0 = preferenceCenterViewModel;
                            this.$action = action;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass2(this.this$0, this.$action, continuation);
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
                                PreferenceCenterViewModel preferenceCenterViewModel = this.this$0;
                                Action action = this.$action;
                                this.label = 1;
                                obj = preferenceCenterViewModel.effects(action, this);
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
                                ResultKt.throwOnFailure(obj);
                            }
                            C01601 c01601 = new C01601(this.this$0.effectsChannel);
                            this.label = 2;
                            if (((Flow) obj).collect(c01601, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }

                        /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$1$1$2$1, reason: invalid class name and collision with other inner class name */
                        /* synthetic */ class C01601 implements FlowCollector, FunctionAdapter {
                            final /* synthetic */ Channel $tmp0;

                            C01601(Channel channel) {
                                this.$tmp0 = channel;
                            }

                            public final boolean equals(Object obj) {
                                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                                }
                                return false;
                            }

                            @Override // kotlin.jvm.internal.FunctionAdapter
                            public final Function getFunctionDelegate() {
                                return new FunctionReferenceImpl(2, this.$tmp0, Channel.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
                            }

                            public final int hashCode() {
                                return getFunctionDelegate().hashCode();
                            }

                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Effect effect, Continuation continuation) {
                                Object objSend = this.$tmp0.send(effect, continuation);
                                return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                            }
                        }
                    }
                };
                this.label = 1;
                if (mutableSharedFlow.collect(flowCollector, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterViewModel.this.new AnonymousClass2(continuation);
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
                Flow flowDrop = FlowKt.drop(PreferenceCenterViewModel.this.contact.getNamedUserIdFlow(), 1);
                final PreferenceCenterViewModel preferenceCenterViewModel = PreferenceCenterViewModel.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(String str, Continuation continuation) {
                        Object objEmit = preferenceCenterViewModel.actions.emit(Action.Refresh.INSTANCE, continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowDrop.collect(flowCollector, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<State> states = PreferenceCenterViewModel.this.getStates();
                AnonymousClass1 anonymousClass1 = new FlowCollector() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(State state, Continuation continuation) {
                        UALog.v("> " + state, new Object[0]);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (states.collect(anonymousClass1, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass5 anonymousClass5 = PreferenceCenterViewModel.this.new AnonymousClass5(continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Action.ConditionStateChanged conditionStateChanged, Continuation continuation) {
            return ((AnonymousClass5) create(conditionStateChanged, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Action.ConditionStateChanged conditionStateChanged = (Action.ConditionStateChanged) this.L$0;
                MutableSharedFlow mutableSharedFlow = PreferenceCenterViewModel.this.actions;
                this.label = 1;
                if (mutableSharedFlow.emit(conditionStateChanged, this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$handle$1, reason: invalid class name and case insensitive filesystem */
    static final class C12931 extends SuspendLambda implements Function2 {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12931(Action action, Continuation continuation) {
            super(2, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterViewModel.this.new C12931(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PreferenceCenterViewModel.this.actions;
                Action action = this.$action;
                this.label = 1;
                if (mutableSharedFlow.emit(action, this) == coroutine_suspended) {
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

    public void handle(@NotNull Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, null, new C12931(action, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object changes(Action action, Continuation continuation) {
        if (action instanceof Action.Refresh) {
            return refresh();
        }
        if (action instanceof Action.PreferenceItemChanged) {
            Action.PreferenceItemChanged preferenceItemChanged = (Action.PreferenceItemChanged) action;
            return updatePreference$default(this, preferenceItemChanged.getItem(), null, preferenceItemChanged.isEnabled(), 2, null);
        }
        if (action instanceof Action.ScopedPreferenceItemChanged) {
            Action.ScopedPreferenceItemChanged scopedPreferenceItemChanged = (Action.ScopedPreferenceItemChanged) action;
            return updatePreference(scopedPreferenceItemChanged.getItem(), scopedPreferenceItemChanged.getScopes(), scopedPreferenceItemChanged.isEnabled());
        }
        if (action instanceof Action.ConditionStateChanged) {
            return FlowKt.flowOf(new Change.UpdateConditionState(((Action.ConditionStateChanged) action).getState()));
        }
        if (action instanceof Action.UpdateContactChannel) {
            Action.UpdateContactChannel updateContactChannel = (Action.UpdateContactChannel) action;
            return FlowKt.flowOf(new Change.UpdateContactChannel(updateContactChannel.getChannel(), updateContactChannel.getChannelState()));
        }
        return FlowKt.emptyFlow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object effects(com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.Action r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.effects(com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Action, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$effects$9, reason: invalid class name */
    static final class AnonymousClass9 extends SuspendLambda implements Function2 {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Action action, Continuation continuation) {
            super(2, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterViewModel.this.new AnonymousClass9(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PreferenceCenterViewModel.this.handle(new Action.UpdateContactChannel(((Action.ResendChannelVerification) this.$action).getChannel(), new State.Content.ContactChannelState(false, true)));
                Duration.Companion companion = Duration.INSTANCE;
                long rawValue = ((Duration) RangesKt.coerceAtLeast(Duration.m3465boximpl(DurationKt.toDuration(((Action.ResendChannelVerification) this.$action).getItem().getPlatform().getResendOptions$urbanairship_preference_center_release().getInterval(), DurationUnit.SECONDS)), Duration.m3465boximpl(PreferenceCenterViewModel.defaultResendLabelHideDelay))).getRawValue();
                this.label = 1;
                if (DelayKt.m3608delayVtjQ1oo(rawValue, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PreferenceCenterViewModel.this.handle(new Action.UpdateContactChannel(((Action.ResendChannelVerification) this.$action).getChannel(), new State.Content.ContactChannelState(true, true)));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object validateEmailAction(Action.ValidateEmailChannel validateEmailChannel, Continuation continuation) {
        return this.preferenceCenter.getInputValidator().validate(new AirshipInputValidation.Request.ValidateEmail(new AirshipInputValidation.Request.Email(validateEmailChannel.getAddress())), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object validateSmsAction(Action.ValidateSmsChannel validateSmsChannel, Continuation continuation) {
        return this.preferenceCenter.getInputValidator().validate(new AirshipInputValidation.Request.ValidateSms(new AirshipInputValidation.Request.Sms(validateSmsChannel.getAddress(), new AirshipInputValidation.Request.Sms.ValidationOptions.Sender(validateSmsChannel.getSenderId(), validateSmsChannel.getPrefix()), null, 4, null)), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object states(State state, Change change, Continuation continuation) {
        Set setMinus;
        Set setMinus2;
        State.Content state2;
        if (change instanceof Change.ShowLoading) {
            state = State.Loading.INSTANCE;
        } else if (change instanceof Change.ShowContent) {
            if (state instanceof State.Content) {
                state2 = ((State.Content) state).merge(((Change.ShowContent) change).getState(), new Function1() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.states.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final State.Content.ContactChannelState invoke(ContactChannel channel) {
                        Intrinsics.checkNotNullParameter(channel, "channel");
                        boolean zIsOptedIn = PreferenceCenterViewModelKt.isOptedIn(channel);
                        boolean z = !zIsOptedIn;
                        if (!zIsOptedIn) {
                            PreferenceCenterViewModel.schedulePendingResendVisibilityChanges$default(PreferenceCenterViewModel.this, channel, false, 2, null);
                        } else {
                            PreferenceCenterViewModel.this.cancelPendingResendVisibilityChanges(channel);
                        }
                        return new State.Content.ContactChannelState(false, z);
                    }
                }, new Function2() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.states.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final State.Content.ContactChannelState invoke(ContactChannel channel, State.Content.ContactChannelState channelState) {
                        Intrinsics.checkNotNullParameter(channel, "channel");
                        Intrinsics.checkNotNullParameter(channelState, "channelState");
                        if (!PreferenceCenterViewModelKt.isOptedIn(channel)) {
                            PreferenceCenterViewModel.this.schedulePendingResendVisibilityChanges(channel, true);
                        } else {
                            PreferenceCenterViewModel.this.cancelPendingResendVisibilityChanges(channel);
                        }
                        return channelState;
                    }
                });
            } else {
                state2 = ((Change.ShowContent) change).getState();
            }
            state = state2;
        } else if (change instanceof Change.ShowError) {
            state = new State.Error(null, ((Change.ShowError) change).getError(), 1, 0 == true ? 1 : 0);
        } else if (change instanceof Change.UpdateSubscriptions) {
            if (state instanceof State.Content) {
                Change.UpdateSubscriptions updateSubscriptions = (Change.UpdateSubscriptions) change;
                if (updateSubscriptions.isSubscribed()) {
                    setMinus2 = SetsKt.plus(((State.Content) state).getChannelSubscriptions(), updateSubscriptions.getSubscriptionId());
                } else {
                    setMinus2 = SetsKt.minus(((State.Content) state).getChannelSubscriptions(), updateSubscriptions.getSubscriptionId());
                }
                state = State.Content.copy$default((State.Content) state, null, null, null, null, null, setMinus2, null, null, null, 479, null);
            }
        } else if (change instanceof Change.UpdateScopedSubscriptions) {
            if (state instanceof State.Content) {
                State.Content content = (State.Content) state;
                Change.UpdateScopedSubscriptions updateScopedSubscriptions = (Change.UpdateScopedSubscriptions) change;
                Set<Scope> setEmptySet = content.getContactSubscriptions().get(updateScopedSubscriptions.getSubscriptionId());
                if (setEmptySet == null) {
                    setEmptySet = SetsKt.emptySet();
                }
                if (updateScopedSubscriptions.isSubscribed()) {
                    setMinus = SetsKt.plus((Set) setEmptySet, (Iterable) updateScopedSubscriptions.getScopes());
                } else {
                    setMinus = SetsKt.minus((Set) setEmptySet, (Iterable) updateScopedSubscriptions.getScopes());
                }
                Map mutableMap = MapsKt.toMutableMap(content.getContactSubscriptions());
                mutableMap.put(updateScopedSubscriptions.getSubscriptionId(), setMinus);
                state = State.Content.copy$default(content, null, null, null, null, null, null, mutableMap, null, null, 447, null);
            }
        } else if (change instanceof Change.UpdateConditionState) {
            if (state instanceof State.Content) {
                Condition.State state3 = ((Change.UpdateConditionState) change).getState();
                State.Content content2 = (State.Content) state;
                state = State.Content.copy$default(content2, null, state3, PreferenceCenterViewModelKt.asPrefCenterItems(PreferenceCenterViewModelKt.filterByConditions(content2.getConfig(), state3)), null, null, null, null, null, null, TypedValues.PositionType.TYPE_SIZE_PERCENT, null);
            }
        } else if (change instanceof Change.UpdateContactChannel) {
            if (state instanceof State.Content) {
                State.Content content3 = (State.Content) state;
                Map<ContactChannel, State.Content.ContactChannelState> contactChannelState = content3.getContactChannelState();
                ArrayList arrayList = new ArrayList(contactChannelState.size());
                for (Map.Entry<ContactChannel, State.Content.ContactChannelState> entry : contactChannelState.entrySet()) {
                    ContactChannel key = entry.getKey();
                    State.Content.ContactChannelState value = entry.getValue();
                    Change.UpdateContactChannel updateContactChannel = (Change.UpdateContactChannel) change;
                    State.Content.ContactChannelState state4 = updateContactChannel.getState();
                    if (Intrinsics.areEqual(key, updateContactChannel.getChannel())) {
                        value = value.copy(state4.getShowResendButton(), state4.getShowPendingButton());
                    }
                    arrayList.add(TuplesKt.to(key, value));
                }
                state = State.Content.copy$default(content3, null, null, null, null, null, null, null, null, MapsKt.toMap(arrayList), 255, null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return FlowKt.flowOf(state);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1, reason: invalid class name and case insensitive filesystem */
    static final class C12941 extends SuspendLambda implements Function2 {
        private /* synthetic */ Object L$0;
        int label;

        C12941(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C12941 c12941 = PreferenceCenterViewModel.this.new C12941(continuation);
            c12941.L$0 = obj;
            return c12941;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((C12941) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                Change.ShowLoading showLoading = Change.ShowLoading.INSTANCE;
                this.L$0 = flowCollector;
                this.label = 1;
                if (flowCollector.emit(showLoading, this) == coroutine_suspended) {
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
            final Flow flowEnrichedConfig = PreferenceCenterViewModel.this.enrichedConfig();
            final PreferenceCenterViewModel preferenceCenterViewModel = PreferenceCenterViewModel.this;
            Flow flowFlowOn = FlowKt.flowOn(FlowKt.m3656catch(new Flow<Change.ShowContent>() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1

                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$refresh$1\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,218:1\n50#2:219\n405#3,14:220\n419#3,3:238\n424#3:242\n1271#4,2:234\n1285#4,2:236\n1288#4:241\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$refresh$1\n*L\n418#1:234,2\n418#1:236,2\n418#1:241\n*E\n"})
                /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ PreferenceCenterViewModel this$0;

                    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1$2", f = "PreferenceCenterViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, PreferenceCenterViewModel preferenceCenterViewModel) {
                        this.$this_unsafeFlow = flowCollector;
                        this.this$0 = preferenceCenterViewModel;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @org.jetbrains.annotations.Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r20) {
                        /*
                            r18 = this;
                            r0 = r18
                            r1 = r20
                            boolean r2 = r1 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r2 == 0) goto L17
                            r2 = r1
                            com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1$2$1 r2 = (com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                            int r3 = r2.label
                            r4 = -2147483648(0xffffffff80000000, float:-0.0)
                            r5 = r3 & r4
                            if (r5 == 0) goto L17
                            int r3 = r3 - r4
                            r2.label = r3
                            goto L1c
                        L17:
                            com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1$2$1 r2 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1$2$1
                            r2.<init>(r1)
                        L1c:
                            java.lang.Object r1 = r2.result
                            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r4 = r2.label
                            r5 = 1
                            if (r4 == 0) goto L36
                            if (r4 != r5) goto L2e
                            kotlin.ResultKt.throwOnFailure(r1)
                            goto Lc4
                        L2e:
                            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                            r0.<init>(r1)
                            throw r0
                        L36:
                            kotlin.ResultKt.throwOnFailure(r1)
                            kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                            r4 = r19
                            com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$EnrichedConfig r4 = (com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.EnrichedConfig) r4
                            com.urbanairship.preferencecenter.data.PreferenceCenterConfig r7 = r4.component1()
                            java.util.Set r12 = r4.component2()
                            java.util.Map r13 = r4.component3()
                            java.util.Set r14 = r4.component4()
                            com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel r0 = r0.this$0
                            com.urbanairship.preferencecenter.ConditionStateMonitor r0 = com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.access$getConditionMonitor$p(r0)
                            com.urbanairship.preferencecenter.data.Condition$State r8 = r0.getCurrentState()
                            com.urbanairship.preferencecenter.data.PreferenceCenterConfig r0 = com.urbanairship.preferencecenter.ui.PreferenceCenterViewModelKt.filterByConditions(r7, r8)
                            java.util.List r9 = com.urbanairship.preferencecenter.ui.PreferenceCenterViewModelKt.asPrefCenterItems(r0)
                            com.urbanairship.preferencecenter.data.CommonDisplay r0 = r7.getDisplay()
                            java.lang.String r10 = r0.getName()
                            java.lang.String r11 = r0.getDescription()
                            java.util.LinkedHashMap r15 = new java.util.LinkedHashMap
                            r0 = 10
                            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r0)
                            int r0 = kotlin.collections.MapsKt.mapCapacity(r0)
                            r4 = 16
                            int r0 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r4)
                            r15.<init>(r0)
                            java.util.Iterator r0 = r14.iterator()
                        L86:
                            boolean r4 = r0.hasNext()
                            if (r4 == 0) goto Laf
                            java.lang.Object r4 = r0.next()
                            r6 = r4
                            com.urbanairship.contacts.ContactChannel r6 = (com.urbanairship.contacts.ContactChannel) r6
                            com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$State$Content$ContactChannelState r5 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$State$Content$ContactChannelState
                            boolean r16 = com.urbanairship.preferencecenter.ui.PreferenceCenterViewModelKt.isOptedIn(r6)
                            r18 = r0
                            r17 = 1
                            r0 = r16 ^ 1
                            boolean r6 = com.urbanairship.preferencecenter.ui.PreferenceCenterViewModelKt.isOptedIn(r6)
                            r6 = r6 ^ 1
                            r5.<init>(r0, r6)
                            r15.put(r4, r5)
                            r0 = r18
                            r5 = 1
                            goto L86
                        Laf:
                            com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$State$Content r0 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$State$Content
                            r6 = r0
                            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15)
                            com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Change$ShowContent r4 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$Change$ShowContent
                            r4.<init>(r0)
                            r0 = 1
                            r2.label = r0
                            java.lang.Object r0 = r1.emit(r4, r2)
                            if (r0 != r3) goto Lc4
                            return r3
                        Lc4:
                            kotlin.Unit r0 = kotlin.Unit.INSTANCE
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super PreferenceCenterViewModel.Change.ShowContent> flowCollector2, @NotNull Continuation continuation) {
                    Object objCollect = flowEnrichedConfig.collect(new AnonymousClass2(flowCollector2, preferenceCenterViewModel), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }, new AnonymousClass2(null)), PreferenceCenterViewModel.this.ioDispatcher);
            this.L$0 = null;
            this.label = 2;
            if (FlowKt.emitAll(flowCollector, flowFlowOn, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$refresh$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function3 {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass2(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector flowCollector, Throwable th, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                anonymousClass2.L$0 = flowCollector;
                anonymousClass2.L$1 = th;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                int i2 = 1;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector = (FlowCollector) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    UALog.e(th, "Failed to fetch preference center data!", new Object[0]);
                    Change.ShowError showError = new Change.ShowError(null, th, i2, 0 == true ? 1 : 0);
                    this.L$0 = null;
                    this.label = 1;
                    if (flowCollector.emit(showError, this) == coroutine_suspended) {
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
    }

    private Flow refresh() {
        return FlowKt.flow(new C12941(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map mergeSubscriptions(Set channelSubscriptions, Map contactSubscriptions) {
        Set of;
        Map mutableMap = MapsKt.toMutableMap(contactSubscriptions);
        Iterator it = channelSubscriptions.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Set set = (Set) mutableMap.get(str);
            if (set != null && (of = CollectionsKt.toMutableSet(set)) != null) {
                of.add(Scope.APP);
            } else {
                of = SetsKt.setOf(Scope.APP);
            }
            mutableMap.put(str, of);
        }
        return MapsKt.toMap(mutableMap);
    }

    static /* synthetic */ Flow updatePreference$default(PreferenceCenterViewModel preferenceCenterViewModel, Item item, Set set, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updatePreference");
        }
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return preferenceCenterViewModel.updatePreference(item, set, z);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$updatePreference$1, reason: invalid class name and case insensitive filesystem */
    static final class C12991 extends SuspendLambda implements Function2 {
        final /* synthetic */ boolean $isEnabled;
        final /* synthetic */ Item $item;
        final /* synthetic */ Set $scopes;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PreferenceCenterViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12991(Item item, Set set, boolean z, PreferenceCenterViewModel preferenceCenterViewModel, Continuation continuation) {
            super(2, continuation);
            this.$item = item;
            this.$scopes = set;
            this.$isEnabled = z;
            this.this$0 = preferenceCenterViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C12991 c12991 = new C12991(this.$item, this.$scopes, this.$isEnabled, this.this$0, continuation);
            c12991.L$0 = obj;
            return c12991;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((C12991) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                UALog.v("Updating preference item: id = " + this.$item.getId() + ", title = " + this.$item.getDisplay().getName() + ", scopes = " + this.$scopes + ", state = " + this.$isEnabled, new Object[0]);
                Item item = this.$item;
                if (item instanceof Item.ChannelSubscription) {
                    PreferenceCenterViewModel preferenceCenterViewModel = this.this$0;
                    boolean z = this.$isEnabled;
                    Item.ChannelSubscription channelSubscription = (Item.ChannelSubscription) item;
                    preferenceCenterViewModel.channel.editSubscriptionLists().mutate(channelSubscription.getSubscriptionId(), z).apply();
                    Change.UpdateSubscriptions updateSubscriptions = new Change.UpdateSubscriptions(channelSubscription.getSubscriptionId(), z);
                    this.label = 1;
                    if (flowCollector.emit(updateSubscriptions, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (item instanceof Item.ContactSubscription) {
                    PreferenceCenterViewModel preferenceCenterViewModel2 = this.this$0;
                    Set<Scope> set = this.$scopes;
                    boolean z2 = this.$isEnabled;
                    Item.ContactSubscription contactSubscription = (Item.ContactSubscription) item;
                    preferenceCenterViewModel2.contact.editSubscriptionLists().mutate(contactSubscription.getSubscriptionId(), set, z2).apply();
                    Change.UpdateScopedSubscriptions updateScopedSubscriptions = new Change.UpdateScopedSubscriptions(contactSubscription.getSubscriptionId(), set, z2);
                    this.label = 2;
                    if (flowCollector.emit(updateScopedSubscriptions, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (item instanceof Item.ContactSubscriptionGroup) {
                    PreferenceCenterViewModel preferenceCenterViewModel3 = this.this$0;
                    Set<Scope> set2 = this.$scopes;
                    boolean z3 = this.$isEnabled;
                    Item.ContactSubscriptionGroup contactSubscriptionGroup = (Item.ContactSubscriptionGroup) item;
                    preferenceCenterViewModel3.contact.editSubscriptionLists().mutate(contactSubscriptionGroup.getSubscriptionId(), set2, z3).apply();
                    Change.UpdateScopedSubscriptions updateScopedSubscriptions2 = new Change.UpdateScopedSubscriptions(contactSubscriptionGroup.getSubscriptionId(), set2, z3);
                    this.label = 3;
                    if (flowCollector.emit(updateScopedSubscriptions2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private Flow updatePreference(Item item, Set scopes, boolean isEnabled) {
        return FlowKt.flow(new C12991(item, scopes, isEnabled, this, null));
    }

    public void cancelPendingResendVisibilityChanges(@NotNull ContactChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        cancelPendingVisibilityChanges(channel);
        cancelResendVisibilityChanges(channel);
    }

    public void cancelPendingVisibilityChanges(@NotNull ContactChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Job job = (Job) this.hidePendingLabelJobs.get(channel);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.hidePendingLabelJobs.remove(channel);
    }

    public void cancelResendVisibilityChanges(@NotNull ContactChannel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Job job = (Job) this.showResendButtonJobs.get(channel);
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.showResendButtonJobs.remove(channel);
    }

    public static /* synthetic */ void schedulePendingResendVisibilityChanges$default(PreferenceCenterViewModel preferenceCenterViewModel, ContactChannel contactChannel, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: schedulePendingResendVisibilityChanges");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        preferenceCenterViewModel.schedulePendingResendVisibilityChanges(contactChannel, z);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$schedulePendingResendVisibilityChanges$1, reason: invalid class name and case insensitive filesystem */
    static final class C12951 extends SuspendLambda implements Function2 {
        final /* synthetic */ ContactChannel $channel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12951(ContactChannel contactChannel, Continuation continuation) {
            super(2, continuation);
            this.$channel = contactChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterViewModel.this.new C12951(this.$channel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = PreferenceCenterViewModel.defaultResendLabelHideDelay;
                this.label = 1;
                if (DelayKt.m3608delayVtjQ1oo(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PreferenceCenterViewModel.this.handle(new Action.UpdateContactChannel(this.$channel, new State.Content.ContactChannelState(true, true)));
            return Unit.INSTANCE;
        }
    }

    public void schedulePendingResendVisibilityChanges(@NotNull ContactChannel channel, boolean onlyHide) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (!onlyHide) {
            cancelResendVisibilityChanges(channel);
            this.showResendButtonJobs.put(channel, BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, null, new C12951(channel, null), 2, null));
        }
        cancelPendingVisibilityChanges(channel);
        this.hidePendingLabelJobs.put(channel, BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, null, new C12962(channel, null), 2, null));
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$schedulePendingResendVisibilityChanges$2, reason: invalid class name and case insensitive filesystem */
    static final class C12962 extends SuspendLambda implements Function2 {
        final /* synthetic */ ContactChannel $channel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12962(ContactChannel contactChannel, Continuation continuation) {
            super(2, continuation);
            this.$channel = contactChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterViewModel.this.new C12962(this.$channel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12962) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = PreferenceCenterViewModel.defaultPendingLabelHideDelay;
                this.label = 1;
                if (DelayKt.m3608delayVtjQ1oo(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PreferenceCenterViewModel.this.handle(new Action.UpdateContactChannel(this.$channel, new State.Content.ContactChannelState(false, false)));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class EnrichedConfig {
        private final Set channelSubscriptions;
        private final PreferenceCenterConfig config;
        private final Set contactChannels;
        private final Map contactSubscriptions;

        public static /* synthetic */ EnrichedConfig copy$default(EnrichedConfig enrichedConfig, PreferenceCenterConfig preferenceCenterConfig, Set set, Map map, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                preferenceCenterConfig = enrichedConfig.config;
            }
            if ((i & 2) != 0) {
                set = enrichedConfig.channelSubscriptions;
            }
            if ((i & 4) != 0) {
                map = enrichedConfig.contactSubscriptions;
            }
            if ((i & 8) != 0) {
                set2 = enrichedConfig.contactChannels;
            }
            return enrichedConfig.copy(preferenceCenterConfig, set, map, set2);
        }

        public final PreferenceCenterConfig component1() {
            return this.config;
        }

        public final Set component2() {
            return this.channelSubscriptions;
        }

        public final Map component3() {
            return this.contactSubscriptions;
        }

        public final Set component4() {
            return this.contactChannels;
        }

        public final EnrichedConfig copy(PreferenceCenterConfig config, Set channelSubscriptions, Map contactSubscriptions, Set contactChannels) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(channelSubscriptions, "channelSubscriptions");
            Intrinsics.checkNotNullParameter(contactSubscriptions, "contactSubscriptions");
            Intrinsics.checkNotNullParameter(contactChannels, "contactChannels");
            return new EnrichedConfig(config, channelSubscriptions, contactSubscriptions, contactChannels);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EnrichedConfig)) {
                return false;
            }
            EnrichedConfig enrichedConfig = (EnrichedConfig) obj;
            return Intrinsics.areEqual(this.config, enrichedConfig.config) && Intrinsics.areEqual(this.channelSubscriptions, enrichedConfig.channelSubscriptions) && Intrinsics.areEqual(this.contactSubscriptions, enrichedConfig.contactSubscriptions) && Intrinsics.areEqual(this.contactChannels, enrichedConfig.contactChannels);
        }

        public int hashCode() {
            return (((((this.config.hashCode() * 31) + this.channelSubscriptions.hashCode()) * 31) + this.contactSubscriptions.hashCode()) * 31) + this.contactChannels.hashCode();
        }

        public String toString() {
            return "EnrichedConfig(config=" + this.config + ", channelSubscriptions=" + this.channelSubscriptions + ", contactSubscriptions=" + this.contactSubscriptions + ", contactChannels=" + this.contactChannels + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public EnrichedConfig(PreferenceCenterConfig config, Set channelSubscriptions, Map contactSubscriptions, Set contactChannels) {
            Intrinsics.checkNotNullParameter(config, "config");
            Intrinsics.checkNotNullParameter(channelSubscriptions, "channelSubscriptions");
            Intrinsics.checkNotNullParameter(contactSubscriptions, "contactSubscriptions");
            Intrinsics.checkNotNullParameter(contactChannels, "contactChannels");
            this.config = config;
            this.channelSubscriptions = channelSubscriptions;
            this.contactSubscriptions = contactSubscriptions;
            this.contactChannels = contactChannels;
        }

        public final PreferenceCenterConfig getConfig() {
            return this.config;
        }

        public /* synthetic */ EnrichedConfig(PreferenceCenterConfig preferenceCenterConfig, Set set, Map map, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(preferenceCenterConfig, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? SetsKt.emptySet() : set2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flow enrichedConfig() {
        final Flow config = getConfig(this.preferenceCenterId);
        return FlowKt.distinctUntilChanged(FlowKt.flatMapConcat(new Flow<EnrichedConfig>() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel\n*L\n1#1,218:1\n50#2:219\n527#3:220\n*E\n"})
            /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1$2", f = "PreferenceCenterViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r13) {
                    /*
                        r11 = this;
                        boolean r0 = r13 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r13
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1$2$1 r0 = (com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1$2$1 r0 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1$2$1
                        r0.<init>(r13)
                    L18:
                        java.lang.Object r13 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r13)
                        goto L4e
                    L29:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L31:
                        kotlin.ResultKt.throwOnFailure(r13)
                        kotlinx.coroutines.flow.FlowCollector r11 = r11.$this_unsafeFlow
                        r5 = r12
                        com.urbanairship.preferencecenter.data.PreferenceCenterConfig r5 = (com.urbanairship.preferencecenter.data.PreferenceCenterConfig) r5
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$EnrichedConfig r12 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$EnrichedConfig
                        r9 = 14
                        r10 = 0
                        r6 = 0
                        r7 = 0
                        r8 = 0
                        r4 = r12
                        r4.<init>(r5, r6, r7, r8, r9, r10)
                        r0.label = r3
                        java.lang.Object r11 = r11.emit(r12, r0)
                        if (r11 != r1) goto L4e
                        return r1
                    L4e:
                        kotlin.Unit r11 = kotlin.Unit.INSTANCE
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super PreferenceCenterViewModel.EnrichedConfig> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = config.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new C12913(null)));
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$3, reason: invalid class name and case insensitive filesystem */
    static final class C12913 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        C12913(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C12913 c12913 = PreferenceCenterViewModel.this.new C12913(continuation);
            c12913.L$0 = obj;
            return c12913;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(EnrichedConfig enrichedConfig, Continuation continuation) {
            return ((C12913) create(enrichedConfig, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flowFlowOf;
            Flow flowFlowOf2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EnrichedConfig enrichedConfig = (EnrichedConfig) this.L$0;
            PreferenceCenterConfig config = enrichedConfig.getConfig();
            Options options = config.getOptions();
            boolean mergeChannelDataToContact = options != null ? options.getMergeChannelDataToContact() : false;
            boolean z = config.getHasChannelSubscriptions() || mergeChannelDataToContact;
            boolean hasContactSubscriptions = config.getHasContactSubscriptions();
            boolean hasContactManagement = config.getHasContactManagement();
            if (z) {
                flowFlowOf = PreferenceCenterViewModel.this.getChannelSubscriptions();
            } else {
                Result.Companion companion = Result.INSTANCE;
                flowFlowOf = FlowKt.flowOf(Result.m2967boximpl(Result.m2968constructorimpl(SetsKt.emptySet())));
            }
            if (hasContactSubscriptions) {
                flowFlowOf2 = PreferenceCenterViewModel.this.getContactSubscriptions();
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                flowFlowOf2 = FlowKt.flowOf(Result.m2967boximpl(Result.m2968constructorimpl(MapsKt.emptyMap())));
            }
            return FlowKt.combine(flowFlowOf, flowFlowOf2, hasContactManagement ? PreferenceCenterViewModel.this.getAssociatedChannels() : FlowKt.flowOf(SetsKt.emptySet()), new AnonymousClass1(enrichedConfig, PreferenceCenterViewModel.this, mergeChannelDataToContact, null));
        }

        /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$enrichedConfig$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function4 {
            final /* synthetic */ EnrichedConfig $enrichedConfig;
            final /* synthetic */ boolean $mergeChannelDataToContact;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ Object L$2;
            int label;
            final /* synthetic */ PreferenceCenterViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(EnrichedConfig enrichedConfig, PreferenceCenterViewModel preferenceCenterViewModel, boolean z, Continuation continuation) {
                super(4, continuation);
                this.$enrichedConfig = enrichedConfig;
                this.this$0 = preferenceCenterViewModel;
                this.$mergeChannelDataToContact = z;
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return invoke(((Result) obj).getValue(), ((Result) obj2).getValue(), (Set) obj3, (Continuation) obj4);
            }

            public final Object invoke(Object obj, Object obj2, Set set, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$enrichedConfig, this.this$0, this.$mergeChannelDataToContact, continuation);
                anonymousClass1.L$0 = Result.m2967boximpl(obj);
                anonymousClass1.L$1 = Result.m2967boximpl(obj2);
                anonymousClass1.L$2 = set;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Map contactSubscriptionsAsMap;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Object value = ((Result) this.L$0).getValue();
                Object value2 = ((Result) this.L$1).getValue();
                Set set = (Set) this.L$2;
                EnrichedConfig enrichedConfig = this.$enrichedConfig;
                Set channelSubscriptionsAsSet = this.this$0.getChannelSubscriptionsAsSet(value);
                if (this.$mergeChannelDataToContact) {
                    PreferenceCenterViewModel preferenceCenterViewModel = this.this$0;
                    contactSubscriptionsAsMap = preferenceCenterViewModel.mergeSubscriptions(preferenceCenterViewModel.getChannelSubscriptionsAsSet(value), this.this$0.getContactSubscriptionsAsMap(value2));
                } else {
                    contactSubscriptionsAsMap = this.this$0.getContactSubscriptionsAsMap(value2);
                }
                return EnrichedConfig.copy$default(enrichedConfig, null, channelSubscriptionsAsSet, contactSubscriptionsAsMap, CollectionsKt.toSet(set), 1, null);
            }
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getConfig$1, reason: invalid class name and case insensitive filesystem */
    static final class C12921 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $preferenceCenterId;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12921(String str, Continuation continuation) {
            super(2, continuation);
            this.$preferenceCenterId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C12921 c12921 = PreferenceCenterViewModel.this.new C12921(this.$preferenceCenterId, continuation);
            c12921.L$0 = obj;
            return c12921;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
            return ((C12921) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                PreferenceCenter preferenceCenter = PreferenceCenterViewModel.this.preferenceCenter;
                String str = this.$preferenceCenterId;
                this.L$0 = flowCollector;
                this.label = 1;
                obj = preferenceCenter.getConfig(str, this);
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
            PreferenceCenterConfig preferenceCenterConfig = (PreferenceCenterConfig) obj;
            if (preferenceCenterConfig == null) {
                throw new IllegalStateException("Null preference center for id: " + this.$preferenceCenterId);
            }
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(preferenceCenterConfig, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    private Flow getConfig(String preferenceCenterId) {
        return FlowKt.flow(new C12921(preferenceCenterId, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flow getChannelSubscriptions() {
        return this.channel.getSubscriptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set getChannelSubscriptionsAsSet(Object subscriptionsResult) {
        if (Result.m2973isFailureimpl(subscriptionsResult)) {
            subscriptionsResult = null;
        }
        Set set = (Set) subscriptionsResult;
        return set != null ? set : SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flow getContactSubscriptions() {
        return this.contact.getSubscriptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map getContactSubscriptionsAsMap(Object subscriptionsResult) {
        if (Result.m2973isFailureimpl(subscriptionsResult)) {
            subscriptionsResult = null;
        }
        Map map = (Map) subscriptionsResult;
        return map != null ? map : MapsKt.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flow getAssociatedChannels() {
        final Flow<Result<List<ContactChannel>>> channelContacts = this.contact.getChannelContacts();
        return new Flow<Set<? extends ContactChannel>>() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel\n*L\n1#1,218:1\n57#2:219\n58#2:221\n566#3:220\n*E\n"})
            /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1$2", f = "PreferenceCenterViewModel.kt", i = {}, l = {221}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L50
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                        kotlin.Result r5 = (kotlin.Result) r5
                        java.lang.Object r5 = r5.getValue()
                        kotlin.ResultKt.throwOnFailure(r5)
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        java.util.Set r5 = kotlin.collections.CollectionsKt.toSet(r5)
                        if (r5 == 0) goto L50
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L50
                        return r1
                    L50:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel$getAssociatedChannels$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super Set<? extends ContactChannel>> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = channelContacts.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @Parcelize
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;", "Landroid/os/Parcelable;", "()V", "Content", "Error", "Loading", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Error;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Loading;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State implements Parcelable {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }

        @Parcelize
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004HÖ\u0001¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Loading;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;", "()V", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Loading extends State {

            @NotNull
            public static final Loading INSTANCE = new Loading();

            @NotNull
            public static final Parcelable.Creator<Loading> CREATOR = new Creator();

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Loading> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Loading createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Loading.INSTANCE;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Loading[] newArray(int i) {
                    return new Loading[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Loading);
            }

            public int hashCode() {
                return 1618719644;
            }

            @NotNull
            public String toString() {
                return "Loading";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }

            private Loading() {
                super(null);
            }
        }

        @Parcelize
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Error;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;", "message", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Error extends State {

            @NotNull
            public static final Parcelable.Creator<Error> CREATOR = new Creator();
            private final Throwable error;
            private final String message;

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Error> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Error createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Error(parcel.readString(), (Throwable) parcel.readSerializable());
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Error[] newArray(int i) {
                    return new Error[i];
                }
            }

            public Error() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Error copy$default(Error error, String str, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                if ((i & 2) != 0) {
                    th = error.error;
                }
                return error.copy(str, th);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final Throwable getError() {
                return this.error;
            }

            @NotNull
            public final Error copy(@Nullable String message, @Nullable Throwable error) {
                return new Error(message, error);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.message, error.message) && Intrinsics.areEqual(this.error, error.error);
            }

            public int hashCode() {
                String str = this.message;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                Throwable th = this.error;
                return iHashCode + (th != null ? th.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Error(message=" + this.message + ", error=" + this.error + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.message);
                parcel.writeSerializable(this.error);
            }

            public Error(@Nullable String str, @Nullable Throwable th) {
                super(null);
                this.message = str;
                this.error = th;
            }

            public /* synthetic */ Error(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
            }

            @Nullable
            public final Throwable getError() {
                return this.error;
            }

            @Nullable
            public final String getMessage() {
                return this.message;
            }
        }

        @Parcelize
        @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001EB\u0088\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\n0\rHÆ\u0003J\u001b\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u000fHÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\rHÆ\u0003J\u001a\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0002\b\u0015HÆ\u0003J\u009c\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0002\b\u0015HÆ\u0001J\t\u00102\u001a\u000203HÖ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u000203HÖ\u0001J<\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00002\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140<2\u0018\u0010=\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140>J\t\u0010?\u001a\u00020\nHÖ\u0001J\u0019\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u000203HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\u000f¢\u0006\u0002\b\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R#\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&¨\u0006F"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State;", "config", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "conditionState", "Lcom/urbanairship/preferencecenter/data/Condition$State;", "listItems", "", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "title", "", "subtitle", "channelSubscriptions", "", "contactSubscriptions", "", "Lcom/urbanairship/contacts/Scope;", "contactChannels", "Lcom/urbanairship/contacts/ContactChannel;", "contactChannelState", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "Lkotlinx/parcelize/RawValue;", "(Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;Lcom/urbanairship/preferencecenter/data/Condition$State;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Set;Ljava/util/Map;)V", "getChannelSubscriptions", "()Ljava/util/Set;", "getConditionState", "()Lcom/urbanairship/preferencecenter/data/Condition$State;", "getConfig", "()Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "getContactChannelState", "()Ljava/util/Map;", "getContactChannels", "getContactSubscriptions", "getListItems$annotations", "()V", "getListItems", "()Ljava/util/List;", "getSubtitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "merge", "update", "onNewChannel", "Lkotlin/Function1;", "onExistingChannel", "Lkotlin/Function2;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ContactChannelState", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nPreferenceCenterViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,806:1\n526#2:807\n511#2,6:808\n453#2:814\n403#2:815\n526#2:820\n511#2,6:821\n1238#3,4:816\n125#4:827\n152#4,3:828\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterViewModel.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content\n*L\n606#1:807\n606#1:808,6\n609#1:814\n609#1:815\n612#1:820\n612#1:821,6\n609#1:816,4\n615#1:827\n615#1:828,3\n*E\n"})
        public static final /* data */ class Content extends State {

            @NotNull
            public static final Parcelable.Creator<Content> CREATOR = new Creator();
            private final Set channelSubscriptions;
            private final Condition.State conditionState;
            private final PreferenceCenterConfig config;
            private final Map contactChannelState;
            private final Set contactChannels;
            private final Map contactSubscriptions;
            private final List listItems;
            private final String subtitle;
            private final String title;

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Content> {
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Content createFromParcel(@NotNull Parcel parcel) throws JsonException {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    PreferenceCenterConfig preferenceCenterConfigM2930create = PreferenceCenterConfigParceler.INSTANCE.m2930create(parcel);
                    Condition.State stateCreateFromParcel = Condition.State.CREATOR.createFromParcel(parcel);
                    String string = parcel.readString();
                    String string2 = parcel.readString();
                    int i = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(i);
                    for (int i2 = 0; i2 != i; i2++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    int i3 = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(i3);
                    for (int i4 = 0; i4 != i3; i4++) {
                        String string3 = parcel.readString();
                        int i5 = parcel.readInt();
                        LinkedHashSet linkedHashSet2 = new LinkedHashSet(i5);
                        for (int i6 = 0; i6 != i5; i6++) {
                            linkedHashSet2.add(Scope.valueOf(parcel.readString()));
                        }
                        linkedHashMap.put(string3, linkedHashSet2);
                    }
                    int i7 = parcel.readInt();
                    LinkedHashSet linkedHashSet3 = new LinkedHashSet(i7);
                    for (int i8 = 0; i8 != i7; i8++) {
                        linkedHashSet3.add(ContactChannelParceler.INSTANCE.m2932create(parcel));
                    }
                    int i9 = parcel.readInt();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(i9);
                    for (int i10 = 0; i10 != i9; i10++) {
                        linkedHashMap2.put(ContactChannelParceler.INSTANCE.m2932create(parcel), ContactChannelState.CREATOR.createFromParcel(parcel));
                    }
                    return new Content(preferenceCenterConfigM2930create, stateCreateFromParcel, null, string, string2, linkedHashSet, linkedHashMap, linkedHashSet3, linkedHashMap2, 4, null);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Content[] newArray(int i) {
                    return new Content[i];
                }
            }

            public static /* synthetic */ Content copy$default(Content content, PreferenceCenterConfig preferenceCenterConfig, Condition.State state, List list, String str, String str2, Set set, Map map, Set set2, Map map2, int i, Object obj) {
                return content.copy((i & 1) != 0 ? content.config : preferenceCenterConfig, (i & 2) != 0 ? content.conditionState : state, (i & 4) != 0 ? content.listItems : list, (i & 8) != 0 ? content.title : str, (i & 16) != 0 ? content.subtitle : str2, (i & 32) != 0 ? content.channelSubscriptions : set, (i & 64) != 0 ? content.contactSubscriptions : map, (i & 128) != 0 ? content.contactChannels : set2, (i & 256) != 0 ? content.contactChannelState : map2);
            }

            public static /* synthetic */ void getListItems$annotations() {
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final PreferenceCenterConfig getConfig() {
                return this.config;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final Condition.State getConditionState() {
                return this.conditionState;
            }

            @NotNull
            public final List<PrefCenterItem> component3() {
                return this.listItems;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            /* renamed from: component5, reason: from getter */
            public final String getSubtitle() {
                return this.subtitle;
            }

            @NotNull
            public final Set<String> component6() {
                return this.channelSubscriptions;
            }

            @NotNull
            public final Map<String, Set<Scope>> component7() {
                return this.contactSubscriptions;
            }

            @NotNull
            public final Set<ContactChannel> component8() {
                return this.contactChannels;
            }

            @NotNull
            public final Map<ContactChannel, ContactChannelState> component9() {
                return this.contactChannelState;
            }

            @NotNull
            public final Content copy(@NotNull PreferenceCenterConfig config, @NotNull Condition.State conditionState, @NotNull List<? extends PrefCenterItem> listItems, @Nullable String title, @Nullable String subtitle, @NotNull Set<String> channelSubscriptions, @NotNull Map<String, ? extends Set<? extends Scope>> contactSubscriptions, @NotNull Set<? extends ContactChannel> contactChannels, @NotNull Map<ContactChannel, ContactChannelState> contactChannelState) {
                Intrinsics.checkNotNullParameter(config, "config");
                Intrinsics.checkNotNullParameter(conditionState, "conditionState");
                Intrinsics.checkNotNullParameter(listItems, "listItems");
                Intrinsics.checkNotNullParameter(channelSubscriptions, "channelSubscriptions");
                Intrinsics.checkNotNullParameter(contactSubscriptions, "contactSubscriptions");
                Intrinsics.checkNotNullParameter(contactChannels, "contactChannels");
                Intrinsics.checkNotNullParameter(contactChannelState, "contactChannelState");
                return new Content(config, conditionState, listItems, title, subtitle, channelSubscriptions, contactSubscriptions, contactChannels, contactChannelState);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.config, content.config) && Intrinsics.areEqual(this.conditionState, content.conditionState) && Intrinsics.areEqual(this.listItems, content.listItems) && Intrinsics.areEqual(this.title, content.title) && Intrinsics.areEqual(this.subtitle, content.subtitle) && Intrinsics.areEqual(this.channelSubscriptions, content.channelSubscriptions) && Intrinsics.areEqual(this.contactSubscriptions, content.contactSubscriptions) && Intrinsics.areEqual(this.contactChannels, content.contactChannels) && Intrinsics.areEqual(this.contactChannelState, content.contactChannelState);
            }

            public int hashCode() {
                int iHashCode = ((((this.config.hashCode() * 31) + this.conditionState.hashCode()) * 31) + this.listItems.hashCode()) * 31;
                String str = this.title;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.subtitle;
                return ((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.channelSubscriptions.hashCode()) * 31) + this.contactSubscriptions.hashCode()) * 31) + this.contactChannels.hashCode()) * 31) + this.contactChannelState.hashCode();
            }

            @NotNull
            public String toString() {
                return "Content(config=" + this.config + ", conditionState=" + this.conditionState + ", listItems=" + this.listItems + ", title=" + this.title + ", subtitle=" + this.subtitle + ", channelSubscriptions=" + this.channelSubscriptions + ", contactSubscriptions=" + this.contactSubscriptions + ", contactChannels=" + this.contactChannels + ", contactChannelState=" + this.contactChannelState + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int flags) throws JsonException {
                Intrinsics.checkNotNullParameter(parcel, "out");
                PreferenceCenterConfigParceler.INSTANCE.write(this.config, parcel, flags);
                this.conditionState.writeToParcel(parcel, flags);
                parcel.writeString(this.title);
                parcel.writeString(this.subtitle);
                Set set = this.channelSubscriptions;
                parcel.writeInt(set.size());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    parcel.writeString((String) it.next());
                }
                Map map = this.contactSubscriptions;
                parcel.writeInt(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    parcel.writeString((String) entry.getKey());
                    Set set2 = (Set) entry.getValue();
                    parcel.writeInt(set2.size());
                    Iterator it2 = set2.iterator();
                    while (it2.hasNext()) {
                        parcel.writeString(((Scope) it2.next()).name());
                    }
                }
                Set set3 = this.contactChannels;
                parcel.writeInt(set3.size());
                Iterator it3 = set3.iterator();
                while (it3.hasNext()) {
                    ContactChannelParceler.INSTANCE.write((ContactChannel) it3.next(), parcel, flags);
                }
                Map map2 = this.contactChannelState;
                parcel.writeInt(map2.size());
                for (Map.Entry entry2 : map2.entrySet()) {
                    ContactChannelParceler.INSTANCE.write((ContactChannel) entry2.getKey(), parcel, flags);
                    ((ContactChannelState) entry2.getValue()).writeToParcel(parcel, flags);
                }
            }

            @NotNull
            public final PreferenceCenterConfig getConfig() {
                return this.config;
            }

            @NotNull
            public final Condition.State getConditionState() {
                return this.conditionState;
            }

            public /* synthetic */ Content(PreferenceCenterConfig preferenceCenterConfig, Condition.State state, List list, String str, String str2, Set set, Map map, Set set2, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(preferenceCenterConfig, state, (i & 4) != 0 ? PreferenceCenterViewModelKt.asPrefCenterItems(PreferenceCenterViewModelKt.filterByConditions(preferenceCenterConfig, state)) : list, str, str2, set, map, set2, map2);
            }

            @NotNull
            public final List<PrefCenterItem> getListItems() {
                return this.listItems;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            public final String getSubtitle() {
                return this.subtitle;
            }

            @NotNull
            public final Set<String> getChannelSubscriptions() {
                return this.channelSubscriptions;
            }

            @NotNull
            public final Map<String, Set<Scope>> getContactSubscriptions() {
                return this.contactSubscriptions;
            }

            @NotNull
            public final Set<ContactChannel> getContactChannels() {
                return this.contactChannels;
            }

            @NotNull
            public final Map<ContactChannel, ContactChannelState> getContactChannelState() {
                return this.contactChannelState;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Content(@NotNull PreferenceCenterConfig config, @NotNull Condition.State conditionState, @NotNull List<? extends PrefCenterItem> listItems, @Nullable String str, @Nullable String str2, @NotNull Set<String> channelSubscriptions, @NotNull Map<String, ? extends Set<? extends Scope>> contactSubscriptions, @NotNull Set<? extends ContactChannel> contactChannels, @NotNull Map<ContactChannel, ContactChannelState> contactChannelState) {
                super(null);
                Intrinsics.checkNotNullParameter(config, "config");
                Intrinsics.checkNotNullParameter(conditionState, "conditionState");
                Intrinsics.checkNotNullParameter(listItems, "listItems");
                Intrinsics.checkNotNullParameter(channelSubscriptions, "channelSubscriptions");
                Intrinsics.checkNotNullParameter(contactSubscriptions, "contactSubscriptions");
                Intrinsics.checkNotNullParameter(contactChannels, "contactChannels");
                Intrinsics.checkNotNullParameter(contactChannelState, "contactChannelState");
                this.config = config;
                this.conditionState = conditionState;
                this.listItems = listItems;
                this.title = str;
                this.subtitle = str2;
                this.channelSubscriptions = channelSubscriptions;
                this.contactSubscriptions = contactSubscriptions;
                this.contactChannels = contactChannels;
                this.contactChannelState = contactChannelState;
            }

            @NotNull
            public final Content merge(@NotNull Content update, @NotNull Function1<? super ContactChannel, ContactChannelState> onNewChannel, @NotNull Function2<? super ContactChannel, ? super ContactChannelState, ContactChannelState> onExistingChannel) {
                Intrinsics.checkNotNullParameter(update, "update");
                Intrinsics.checkNotNullParameter(onNewChannel, "onNewChannel");
                Intrinsics.checkNotNullParameter(onExistingChannel, "onExistingChannel");
                PreferenceCenterConfig preferenceCenterConfig = update.config;
                List list = update.listItems;
                String str = update.title;
                String str2 = update.subtitle;
                Set set = update.channelSubscriptions;
                Map map = update.contactSubscriptions;
                Set set2 = update.contactChannels;
                Map map2 = this.contactChannelState;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map2.entrySet()) {
                    if (update.contactChannels.contains(entry.getKey())) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    linkedHashMap2.put(entry2.getKey(), onExistingChannel.invoke(entry2.getKey(), entry2.getValue()));
                }
                Map map3 = update.contactChannelState;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Map.Entry entry3 : map3.entrySet()) {
                    if (!this.contactChannelState.containsKey(entry3.getKey())) {
                        linkedHashMap3.put(entry3.getKey(), entry3.getValue());
                    }
                }
                ArrayList arrayList = new ArrayList(linkedHashMap3.size());
                for (Map.Entry entry4 : linkedHashMap3.entrySet()) {
                    arrayList.add(TuplesKt.to(entry4.getKey(), onNewChannel.invoke(entry4.getKey())));
                }
                return copy$default(this, preferenceCenterConfig, null, list, str, str2, set, map, set2, MapsKt.plus(linkedHashMap2, arrayList), 2, null);
            }

            @Parcelize
            @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "Landroid/os/Parcelable;", "showResendButton", "", "showPendingButton", "(ZZ)V", "getShowPendingButton", "()Z", "getShowResendButton", "component1", "component2", "copy", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class ContactChannelState implements Parcelable {

                @NotNull
                public static final Parcelable.Creator<ContactChannelState> CREATOR = new Creator();
                private final boolean showPendingButton;
                private final boolean showResendButton;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                public static final class Creator implements Parcelable.Creator<ContactChannelState> {
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final ContactChannelState createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        return new ContactChannelState(parcel.readInt() != 0, parcel.readInt() != 0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final ContactChannelState[] newArray(int i) {
                        return new ContactChannelState[i];
                    }
                }

                /* JADX WARN: Illegal instructions before constructor call */
                public ContactChannelState() {
                    boolean z = false;
                    this(z, z, 3, null);
                }

                public static /* synthetic */ ContactChannelState copy$default(ContactChannelState contactChannelState, boolean z, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z = contactChannelState.showResendButton;
                    }
                    if ((i & 2) != 0) {
                        z2 = contactChannelState.showPendingButton;
                    }
                    return contactChannelState.copy(z, z2);
                }

                /* renamed from: component1, reason: from getter */
                public final boolean getShowResendButton() {
                    return this.showResendButton;
                }

                /* renamed from: component2, reason: from getter */
                public final boolean getShowPendingButton() {
                    return this.showPendingButton;
                }

                @NotNull
                public final ContactChannelState copy(boolean showResendButton, boolean showPendingButton) {
                    return new ContactChannelState(showResendButton, showPendingButton);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof ContactChannelState)) {
                        return false;
                    }
                    ContactChannelState contactChannelState = (ContactChannelState) other;
                    return this.showResendButton == contactChannelState.showResendButton && this.showPendingButton == contactChannelState.showPendingButton;
                }

                public int hashCode() {
                    return (Boolean.hashCode(this.showResendButton) * 31) + Boolean.hashCode(this.showPendingButton);
                }

                @NotNull
                public String toString() {
                    return "ContactChannelState(showResendButton=" + this.showResendButton + ", showPendingButton=" + this.showPendingButton + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int flags) {
                    Intrinsics.checkNotNullParameter(parcel, "out");
                    parcel.writeInt(this.showResendButton ? 1 : 0);
                    parcel.writeInt(this.showPendingButton ? 1 : 0);
                }

                public ContactChannelState(boolean z, boolean z2) {
                    this.showResendButton = z;
                    this.showPendingButton = z2;
                }

                public /* synthetic */ ContactChannelState(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
                }

                public final boolean getShowResendButton() {
                    return this.showResendButton;
                }

                public final boolean getShowPendingButton() {
                    return this.showPendingButton;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u000e\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u000e\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "", "()V", "ButtonActions", "ConditionStateChanged", "ConfirmAddChannel", "PreferenceItemChanged", HttpHeaders.REFRESH, "RegisterChannel", "RequestAddChannel", "RequestRemoveChannel", "ResendChannelVerification", "ScopedPreferenceItemChanged", "UnregisterChannel", "UpdateContactChannel", "ValidateEmailChannel", "ValidateSmsChannel", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ButtonActions;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ConditionStateChanged;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ConfirmAddChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$PreferenceItemChanged;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$Refresh;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RequestAddChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RequestRemoveChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ResendChannelVerification;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ScopedPreferenceItemChanged;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$UnregisterChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$UpdateContactChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateEmailChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateSmsChannel;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Action {
        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$Refresh;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Refresh extends Action {

            @NotNull
            public static final Refresh INSTANCE = new Refresh();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof Refresh);
            }

            public int hashCode() {
                return -1686079546;
            }

            @NotNull
            public String toString() {
                return HttpHeaders.REFRESH;
            }

            private Refresh() {
                super(null);
            }
        }

        private Action() {
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$PreferenceItemChanged;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item;", "isEnabled", "", "(Lcom/urbanairship/preferencecenter/data/Item;Z)V", "()Z", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PreferenceItemChanged extends Action {
            private final boolean isEnabled;
            private final Item item;

            public static /* synthetic */ PreferenceItemChanged copy$default(PreferenceItemChanged preferenceItemChanged, Item item, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    item = preferenceItemChanged.item;
                }
                if ((i & 2) != 0) {
                    z = preferenceItemChanged.isEnabled;
                }
                return preferenceItemChanged.copy(item, z);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item getItem() {
                return this.item;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsEnabled() {
                return this.isEnabled;
            }

            @NotNull
            public final PreferenceItemChanged copy(@NotNull Item item, boolean isEnabled) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new PreferenceItemChanged(item, isEnabled);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PreferenceItemChanged)) {
                    return false;
                }
                PreferenceItemChanged preferenceItemChanged = (PreferenceItemChanged) other;
                return Intrinsics.areEqual(this.item, preferenceItemChanged.item) && this.isEnabled == preferenceItemChanged.isEnabled;
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + Boolean.hashCode(this.isEnabled);
            }

            @NotNull
            public String toString() {
                return "PreferenceItemChanged(item=" + this.item + ", isEnabled=" + this.isEnabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PreferenceItemChanged(@NotNull Item item, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
                this.isEnabled = z;
            }

            @NotNull
            public final Item getItem() {
                return this.item;
            }

            public final boolean isEnabled() {
                return this.isEnabled;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ScopedPreferenceItemChanged;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item;", "scopes", "", "Lcom/urbanairship/contacts/Scope;", "isEnabled", "", "(Lcom/urbanairship/preferencecenter/data/Item;Ljava/util/Set;Z)V", "()Z", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item;", "getScopes", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ScopedPreferenceItemChanged extends Action {
            private final boolean isEnabled;
            private final Item item;
            private final Set scopes;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ScopedPreferenceItemChanged copy$default(ScopedPreferenceItemChanged scopedPreferenceItemChanged, Item item, Set set, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    item = scopedPreferenceItemChanged.item;
                }
                if ((i & 2) != 0) {
                    set = scopedPreferenceItemChanged.scopes;
                }
                if ((i & 4) != 0) {
                    z = scopedPreferenceItemChanged.isEnabled;
                }
                return scopedPreferenceItemChanged.copy(item, set, z);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item getItem() {
                return this.item;
            }

            @NotNull
            public final Set<Scope> component2() {
                return this.scopes;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsEnabled() {
                return this.isEnabled;
            }

            @NotNull
            public final ScopedPreferenceItemChanged copy(@NotNull Item item, @NotNull Set<? extends Scope> scopes, boolean isEnabled) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                return new ScopedPreferenceItemChanged(item, scopes, isEnabled);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScopedPreferenceItemChanged)) {
                    return false;
                }
                ScopedPreferenceItemChanged scopedPreferenceItemChanged = (ScopedPreferenceItemChanged) other;
                return Intrinsics.areEqual(this.item, scopedPreferenceItemChanged.item) && Intrinsics.areEqual(this.scopes, scopedPreferenceItemChanged.scopes) && this.isEnabled == scopedPreferenceItemChanged.isEnabled;
            }

            public int hashCode() {
                return (((this.item.hashCode() * 31) + this.scopes.hashCode()) * 31) + Boolean.hashCode(this.isEnabled);
            }

            @NotNull
            public String toString() {
                return "ScopedPreferenceItemChanged(item=" + this.item + ", scopes=" + this.scopes + ", isEnabled=" + this.isEnabled + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item getItem() {
                return this.item;
            }

            @NotNull
            public final Set<Scope> getScopes() {
                return this.scopes;
            }

            public final boolean isEnabled() {
                return this.isEnabled;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ScopedPreferenceItemChanged(@NotNull Item item, @NotNull Set<? extends Scope> scopes, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                this.item = item;
                this.scopes = scopes;
                this.isEnabled = z;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ButtonActions;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "actions", "", "", "Lcom/urbanairship/json/JsonValue;", "(Ljava/util/Map;)V", "getActions", "()Ljava/util/Map;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ButtonActions extends Action {
            private final Map actions;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ButtonActions copy$default(ButtonActions buttonActions, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = buttonActions.actions;
                }
                return buttonActions.copy(map);
            }

            @NotNull
            public final Map<String, JsonValue> component1() {
                return this.actions;
            }

            @NotNull
            public final ButtonActions copy(@NotNull Map<String, ? extends JsonValue> actions) {
                Intrinsics.checkNotNullParameter(actions, "actions");
                return new ButtonActions(actions);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ButtonActions) && Intrinsics.areEqual(this.actions, ((ButtonActions) other).actions);
            }

            public int hashCode() {
                return this.actions.hashCode();
            }

            @NotNull
            public String toString() {
                return "ButtonActions(actions=" + this.actions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ButtonActions(@NotNull Map<String, ? extends JsonValue> actions) {
                super(null);
                Intrinsics.checkNotNullParameter(actions, "actions");
                this.actions = actions;
            }

            @NotNull
            public final Map<String, JsonValue> getActions() {
                return this.actions;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ConditionStateChanged;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/data/Condition$State;", "(Lcom/urbanairship/preferencecenter/data/Condition$State;)V", "getState", "()Lcom/urbanairship/preferencecenter/data/Condition$State;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConditionStateChanged extends Action {
            private final Condition.State state;

            public static /* synthetic */ ConditionStateChanged copy$default(ConditionStateChanged conditionStateChanged, Condition.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = conditionStateChanged.state;
                }
                return conditionStateChanged.copy(state);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Condition.State getState() {
                return this.state;
            }

            @NotNull
            public final ConditionStateChanged copy(@NotNull Condition.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new ConditionStateChanged(state);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ConditionStateChanged) && Intrinsics.areEqual(this.state, ((ConditionStateChanged) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            @NotNull
            public String toString() {
                return "ConditionStateChanged(state=" + this.state + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConditionStateChanged(@NotNull Condition.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            @NotNull
            public final Condition.State getState() {
                return this.state;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RequestAddChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;)V", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RequestAddChannel extends Action {
            private final Item.ContactManagement item;

            public static /* synthetic */ RequestAddChannel copy$default(RequestAddChannel requestAddChannel, Item.ContactManagement contactManagement, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = requestAddChannel.item;
                }
                return requestAddChannel.copy(contactManagement);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final RequestAddChannel copy(@NotNull Item.ContactManagement item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new RequestAddChannel(item);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RequestAddChannel) && Intrinsics.areEqual(this.item, ((RequestAddChannel) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            @NotNull
            public String toString() {
                return "RequestAddChannel(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RequestAddChannel(@NotNull Item.ContactManagement item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RequestRemoveChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Lcom/urbanairship/contacts/ContactChannel;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RequestRemoveChannel extends Action {
            private final ContactChannel channel;
            private final Item.ContactManagement item;

            public static /* synthetic */ RequestRemoveChannel copy$default(RequestRemoveChannel requestRemoveChannel, Item.ContactManagement contactManagement, ContactChannel contactChannel, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = requestRemoveChannel.item;
                }
                if ((i & 2) != 0) {
                    contactChannel = requestRemoveChannel.channel;
                }
                return requestRemoveChannel.copy(contactManagement, contactChannel);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final RequestRemoveChannel copy(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new RequestRemoveChannel(item, channel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RequestRemoveChannel)) {
                    return false;
                }
                RequestRemoveChannel requestRemoveChannel = (RequestRemoveChannel) other;
                return Intrinsics.areEqual(this.item, requestRemoveChannel.item) && Intrinsics.areEqual(this.channel, requestRemoveChannel.channel);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.channel.hashCode();
            }

            @NotNull
            public String toString() {
                return "RequestRemoveChannel(item=" + this.item + ", channel=" + this.channel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RequestRemoveChannel(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.item = item;
                this.channel = channel;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ConfirmAddChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "result", "Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult;)V", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "getResult", "()Lcom/urbanairship/preferencecenter/widget/ContactChannelDialogInputView$DialogResult;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ConfirmAddChannel extends Action {
            private final Item.ContactManagement item;
            private final ContactChannelDialogInputView.DialogResult result;

            public static /* synthetic */ ConfirmAddChannel copy$default(ConfirmAddChannel confirmAddChannel, Item.ContactManagement contactManagement, ContactChannelDialogInputView.DialogResult dialogResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = confirmAddChannel.item;
                }
                if ((i & 2) != 0) {
                    dialogResult = confirmAddChannel.result;
                }
                return confirmAddChannel.copy(contactManagement, dialogResult);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final ContactChannelDialogInputView.DialogResult getResult() {
                return this.result;
            }

            @NotNull
            public final ConfirmAddChannel copy(@NotNull Item.ContactManagement item, @NotNull ContactChannelDialogInputView.DialogResult result) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(result, "result");
                return new ConfirmAddChannel(item, result);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ConfirmAddChannel)) {
                    return false;
                }
                ConfirmAddChannel confirmAddChannel = (ConfirmAddChannel) other;
                return Intrinsics.areEqual(this.item, confirmAddChannel.item) && Intrinsics.areEqual(this.result, confirmAddChannel.result);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.result.hashCode();
            }

            @NotNull
            public String toString() {
                return "ConfirmAddChannel(item=" + this.item + ", result=" + this.result + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final ContactChannelDialogInputView.DialogResult getResult() {
                return this.result;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfirmAddChannel(@NotNull Item.ContactManagement item, @NotNull ContactChannelDialogInputView.DialogResult result) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(result, "result");
                this.item = item;
                this.result = result;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "Email", "Sms", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel$Email;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel$Sms;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class RegisterChannel extends Action {
            public /* synthetic */ RegisterChannel(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public abstract String getAddress();

            @NotNull
            public abstract Item.ContactManagement getItem();

            private RegisterChannel() {
                super(null);
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel$Email;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "address", "", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Email extends RegisterChannel {
                private final String address;
                private final Item.ContactManagement item;

                public static /* synthetic */ Email copy$default(Email email, Item.ContactManagement contactManagement, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        contactManagement = email.item;
                    }
                    if ((i & 2) != 0) {
                        str = email.address;
                    }
                    return email.copy(contactManagement, str);
                }

                @NotNull
                /* renamed from: component1, reason: from getter */
                public final Item.ContactManagement getItem() {
                    return this.item;
                }

                @NotNull
                /* renamed from: component2, reason: from getter */
                public final String getAddress() {
                    return this.address;
                }

                @NotNull
                public final Email copy(@NotNull Item.ContactManagement item, @NotNull String address) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Intrinsics.checkNotNullParameter(address, "address");
                    return new Email(item, address);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Email)) {
                        return false;
                    }
                    Email email = (Email) other;
                    return Intrinsics.areEqual(this.item, email.item) && Intrinsics.areEqual(this.address, email.address);
                }

                public int hashCode() {
                    return (this.item.hashCode() * 31) + this.address.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Email(item=" + this.item + ", address=" + this.address + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                @Override // com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.Action.RegisterChannel
                @NotNull
                public Item.ContactManagement getItem() {
                    return this.item;
                }

                @Override // com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.Action.RegisterChannel
                @NotNull
                public String getAddress() {
                    return this.address;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Email(@NotNull Item.ContactManagement item, @NotNull String address) {
                    super(null);
                    Intrinsics.checkNotNullParameter(item, "item");
                    Intrinsics.checkNotNullParameter(address, "address");
                    this.item = item;
                    this.address = address;
                }
            }

            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel$Sms;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$RegisterChannel;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "address", "", "senderId", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "getSenderId", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Sms extends RegisterChannel {
                private final String address;
                private final Item.ContactManagement item;
                private final String senderId;

                public static /* synthetic */ Sms copy$default(Sms sms, Item.ContactManagement contactManagement, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        contactManagement = sms.item;
                    }
                    if ((i & 2) != 0) {
                        str = sms.address;
                    }
                    if ((i & 4) != 0) {
                        str2 = sms.senderId;
                    }
                    return sms.copy(contactManagement, str, str2);
                }

                @NotNull
                /* renamed from: component1, reason: from getter */
                public final Item.ContactManagement getItem() {
                    return this.item;
                }

                @NotNull
                /* renamed from: component2, reason: from getter */
                public final String getAddress() {
                    return this.address;
                }

                @NotNull
                /* renamed from: component3, reason: from getter */
                public final String getSenderId() {
                    return this.senderId;
                }

                @NotNull
                public final Sms copy(@NotNull Item.ContactManagement item, @NotNull String address, @NotNull String senderId) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Intrinsics.checkNotNullParameter(address, "address");
                    Intrinsics.checkNotNullParameter(senderId, "senderId");
                    return new Sms(item, address, senderId);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Sms)) {
                        return false;
                    }
                    Sms sms = (Sms) other;
                    return Intrinsics.areEqual(this.item, sms.item) && Intrinsics.areEqual(this.address, sms.address) && Intrinsics.areEqual(this.senderId, sms.senderId);
                }

                public int hashCode() {
                    return (((this.item.hashCode() * 31) + this.address.hashCode()) * 31) + this.senderId.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Sms(item=" + this.item + ", address=" + this.address + ", senderId=" + this.senderId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                @Override // com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.Action.RegisterChannel
                @NotNull
                public Item.ContactManagement getItem() {
                    return this.item;
                }

                @Override // com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel.Action.RegisterChannel
                @NotNull
                public String getAddress() {
                    return this.address;
                }

                @NotNull
                public final String getSenderId() {
                    return this.senderId;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Sms(@NotNull Item.ContactManagement item, @NotNull String address, @NotNull String senderId) {
                    super(null);
                    Intrinsics.checkNotNullParameter(item, "item");
                    Intrinsics.checkNotNullParameter(address, "address");
                    Intrinsics.checkNotNullParameter(senderId, "senderId");
                    this.item = item;
                    this.address = address;
                    this.senderId = senderId;
                }
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$UnregisterChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "(Lcom/urbanairship/contacts/ContactChannel;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UnregisterChannel extends Action {
            private final ContactChannel channel;

            public static /* synthetic */ UnregisterChannel copy$default(UnregisterChannel unregisterChannel, ContactChannel contactChannel, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactChannel = unregisterChannel.channel;
                }
                return unregisterChannel.copy(contactChannel);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final UnregisterChannel copy(@NotNull ContactChannel channel) {
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new UnregisterChannel(channel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UnregisterChannel) && Intrinsics.areEqual(this.channel, ((UnregisterChannel) other).channel);
            }

            public int hashCode() {
                return this.channel.hashCode();
            }

            @NotNull
            public String toString() {
                return "UnregisterChannel(channel=" + this.channel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UnregisterChannel(@NotNull ContactChannel channel) {
                super(null);
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.channel = channel;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ResendChannelVerification;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Lcom/urbanairship/contacts/ContactChannel;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ResendChannelVerification extends Action {
            private final ContactChannel channel;
            private final Item.ContactManagement item;

            public static /* synthetic */ ResendChannelVerification copy$default(ResendChannelVerification resendChannelVerification, Item.ContactManagement contactManagement, ContactChannel contactChannel, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = resendChannelVerification.item;
                }
                if ((i & 2) != 0) {
                    contactChannel = resendChannelVerification.channel;
                }
                return resendChannelVerification.copy(contactManagement, contactChannel);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final ResendChannelVerification copy(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new ResendChannelVerification(item, channel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResendChannelVerification)) {
                    return false;
                }
                ResendChannelVerification resendChannelVerification = (ResendChannelVerification) other;
                return Intrinsics.areEqual(this.item, resendChannelVerification.item) && Intrinsics.areEqual(this.channel, resendChannelVerification.channel);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.channel.hashCode();
            }

            @NotNull
            public String toString() {
                return "ResendChannelVerification(item=" + this.item + ", channel=" + this.channel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ResendChannelVerification(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.item = item;
                this.channel = channel;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateSmsChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "address", "", "senderId", "prefix", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "getPrefix", "getSenderId", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ValidateSmsChannel extends Action {
            private final String address;
            private final Item.ContactManagement item;
            private final String prefix;
            private final String senderId;

            public static /* synthetic */ ValidateSmsChannel copy$default(ValidateSmsChannel validateSmsChannel, Item.ContactManagement contactManagement, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = validateSmsChannel.item;
                }
                if ((i & 2) != 0) {
                    str = validateSmsChannel.address;
                }
                if ((i & 4) != 0) {
                    str2 = validateSmsChannel.senderId;
                }
                if ((i & 8) != 0) {
                    str3 = validateSmsChannel.prefix;
                }
                return validateSmsChannel.copy(contactManagement, str, str2, str3);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getAddress() {
                return this.address;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final String getSenderId() {
                return this.senderId;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final String getPrefix() {
                return this.prefix;
            }

            @NotNull
            public final ValidateSmsChannel copy(@NotNull Item.ContactManagement item, @NotNull String address, @NotNull String senderId, @Nullable String prefix) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(address, "address");
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                return new ValidateSmsChannel(item, address, senderId, prefix);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ValidateSmsChannel)) {
                    return false;
                }
                ValidateSmsChannel validateSmsChannel = (ValidateSmsChannel) other;
                return Intrinsics.areEqual(this.item, validateSmsChannel.item) && Intrinsics.areEqual(this.address, validateSmsChannel.address) && Intrinsics.areEqual(this.senderId, validateSmsChannel.senderId) && Intrinsics.areEqual(this.prefix, validateSmsChannel.prefix);
            }

            public int hashCode() {
                int iHashCode = ((((this.item.hashCode() * 31) + this.address.hashCode()) * 31) + this.senderId.hashCode()) * 31;
                String str = this.prefix;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            @NotNull
            public String toString() {
                return "ValidateSmsChannel(item=" + this.item + ", address=" + this.address + ", senderId=" + this.senderId + ", prefix=" + this.prefix + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public /* synthetic */ ValidateSmsChannel(Item.ContactManagement contactManagement, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(contactManagement, str, str2, (i & 8) != 0 ? null : str3);
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final String getAddress() {
                return this.address;
            }

            @NotNull
            public final String getSenderId() {
                return this.senderId;
            }

            @Nullable
            public final String getPrefix() {
                return this.prefix;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ValidateSmsChannel(@NotNull Item.ContactManagement item, @NotNull String address, @NotNull String senderId, @Nullable String str) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(address, "address");
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                this.item = item;
                this.address = address;
                this.senderId = senderId;
                this.prefix = str;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$ValidateEmailChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "address", "", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ValidateEmailChannel extends Action {
            private final String address;
            private final Item.ContactManagement item;

            public static /* synthetic */ ValidateEmailChannel copy$default(ValidateEmailChannel validateEmailChannel, Item.ContactManagement contactManagement, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = validateEmailChannel.item;
                }
                if ((i & 2) != 0) {
                    str = validateEmailChannel.address;
                }
                return validateEmailChannel.copy(contactManagement, str);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getAddress() {
                return this.address;
            }

            @NotNull
            public final ValidateEmailChannel copy(@NotNull Item.ContactManagement item, @NotNull String address) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(address, "address");
                return new ValidateEmailChannel(item, address);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ValidateEmailChannel)) {
                    return false;
                }
                ValidateEmailChannel validateEmailChannel = (ValidateEmailChannel) other;
                return Intrinsics.areEqual(this.item, validateEmailChannel.item) && Intrinsics.areEqual(this.address, validateEmailChannel.address);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.address.hashCode();
            }

            @NotNull
            public String toString() {
                return "ValidateEmailChannel(item=" + this.item + ", address=" + this.address + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final String getAddress() {
                return this.address;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ValidateEmailChannel(@NotNull Item.ContactManagement item, @NotNull String address) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(address, "address");
                this.item = item;
                this.address = address;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action$UpdateContactChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Action;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "channelState", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "(Lcom/urbanairship/contacts/ContactChannel;Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getChannelState", "()Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateContactChannel extends Action {
            private final ContactChannel channel;
            private final State.Content.ContactChannelState channelState;

            public static /* synthetic */ UpdateContactChannel copy$default(UpdateContactChannel updateContactChannel, ContactChannel contactChannel, State.Content.ContactChannelState contactChannelState, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactChannel = updateContactChannel.channel;
                }
                if ((i & 2) != 0) {
                    contactChannelState = updateContactChannel.channelState;
                }
                return updateContactChannel.copy(contactChannel, contactChannelState);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final State.Content.ContactChannelState getChannelState() {
                return this.channelState;
            }

            @NotNull
            public final UpdateContactChannel copy(@NotNull ContactChannel channel, @NotNull State.Content.ContactChannelState channelState) {
                Intrinsics.checkNotNullParameter(channel, "channel");
                Intrinsics.checkNotNullParameter(channelState, "channelState");
                return new UpdateContactChannel(channel, channelState);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateContactChannel)) {
                    return false;
                }
                UpdateContactChannel updateContactChannel = (UpdateContactChannel) other;
                return Intrinsics.areEqual(this.channel, updateContactChannel.channel) && Intrinsics.areEqual(this.channelState, updateContactChannel.channelState);
            }

            public int hashCode() {
                return (this.channel.hashCode() * 31) + this.channelState.hashCode();
            }

            @NotNull
            public String toString() {
                return "UpdateContactChannel(channel=" + this.channel + ", channelState=" + this.channelState + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final State.Content.ContactChannelState getChannelState() {
                return this.channelState;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateContactChannel(@NotNull ContactChannel channel, @NotNull State.Content.ContactChannelState channelState) {
                super(null);
                Intrinsics.checkNotNullParameter(channel, "channel");
                Intrinsics.checkNotNullParameter(channelState, "channelState");
                this.channel = channel;
                this.channelState = channelState;
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", "", "()V", "ShowContent", "ShowError", "ShowLoading", "UpdateConditionState", "UpdateContactChannel", "UpdateScopedSubscriptions", "UpdateSubscriptions", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$ShowContent;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$ShowError;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$ShowLoading;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateConditionState;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateContactChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateScopedSubscriptions;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateSubscriptions;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Change {
        public /* synthetic */ Change(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$ShowLoading;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowLoading extends Change {

            @NotNull
            public static final ShowLoading INSTANCE = new ShowLoading();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof ShowLoading);
            }

            public int hashCode() {
                return -1614783132;
            }

            @NotNull
            public String toString() {
                return "ShowLoading";
            }

            private ShowLoading() {
                super(null);
            }
        }

        private Change() {
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$ShowError;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", "message", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowError extends Change {
            private final Throwable error;
            private final String message;

            public ShowError() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ ShowError copy$default(ShowError showError, String str, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showError.message;
                }
                if ((i & 2) != 0) {
                    th = showError.error;
                }
                return showError.copy(str, th);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final Throwable getError() {
                return this.error;
            }

            @NotNull
            public final ShowError copy(@Nullable String message, @Nullable Throwable error) {
                return new ShowError(message, error);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowError)) {
                    return false;
                }
                ShowError showError = (ShowError) other;
                return Intrinsics.areEqual(this.message, showError.message) && Intrinsics.areEqual(this.error, showError.error);
            }

            public int hashCode() {
                String str = this.message;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                Throwable th = this.error;
                return iHashCode + (th != null ? th.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "ShowError(message=" + this.message + ", error=" + this.error + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public ShowError(@Nullable String str, @Nullable Throwable th) {
                super(null);
                this.message = str;
                this.error = th;
            }

            public /* synthetic */ ShowError(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
            }

            @Nullable
            public final Throwable getError() {
                return this.error;
            }

            @Nullable
            public final String getMessage() {
                return this.message;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$ShowContent;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content;", "(Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content;)V", "getState", "()Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowContent extends Change {
            private final State.Content state;

            public static /* synthetic */ ShowContent copy$default(ShowContent showContent, State.Content content, int i, Object obj) {
                if ((i & 1) != 0) {
                    content = showContent.state;
                }
                return showContent.copy(content);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final State.Content getState() {
                return this.state;
            }

            @NotNull
            public final ShowContent copy(@NotNull State.Content state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new ShowContent(state);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowContent) && Intrinsics.areEqual(this.state, ((ShowContent) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            @NotNull
            public String toString() {
                return "ShowContent(state=" + this.state + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowContent(@NotNull State.Content state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            @NotNull
            public final State.Content getState() {
                return this.state;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateSubscriptions;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", "subscriptionId", "", "isSubscribed", "", "(Ljava/lang/String;Z)V", "()Z", "getSubscriptionId", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateSubscriptions extends Change {
            private final boolean isSubscribed;
            private final String subscriptionId;

            public static /* synthetic */ UpdateSubscriptions copy$default(UpdateSubscriptions updateSubscriptions, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updateSubscriptions.subscriptionId;
                }
                if ((i & 2) != 0) {
                    z = updateSubscriptions.isSubscribed;
                }
                return updateSubscriptions.copy(str, z);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getSubscriptionId() {
                return this.subscriptionId;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsSubscribed() {
                return this.isSubscribed;
            }

            @NotNull
            public final UpdateSubscriptions copy(@NotNull String subscriptionId, boolean isSubscribed) {
                Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
                return new UpdateSubscriptions(subscriptionId, isSubscribed);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateSubscriptions)) {
                    return false;
                }
                UpdateSubscriptions updateSubscriptions = (UpdateSubscriptions) other;
                return Intrinsics.areEqual(this.subscriptionId, updateSubscriptions.subscriptionId) && this.isSubscribed == updateSubscriptions.isSubscribed;
            }

            public int hashCode() {
                return (this.subscriptionId.hashCode() * 31) + Boolean.hashCode(this.isSubscribed);
            }

            @NotNull
            public String toString() {
                return "UpdateSubscriptions(subscriptionId=" + this.subscriptionId + ", isSubscribed=" + this.isSubscribed + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateSubscriptions(@NotNull String subscriptionId, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
                this.subscriptionId = subscriptionId;
                this.isSubscribed = z;
            }

            @NotNull
            public final String getSubscriptionId() {
                return this.subscriptionId;
            }

            public final boolean isSubscribed() {
                return this.isSubscribed;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateScopedSubscriptions;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", "subscriptionId", "", "scopes", "", "Lcom/urbanairship/contacts/Scope;", "isSubscribed", "", "(Ljava/lang/String;Ljava/util/Set;Z)V", "()Z", "getScopes", "()Ljava/util/Set;", "getSubscriptionId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateScopedSubscriptions extends Change {
            private final boolean isSubscribed;
            private final Set scopes;
            private final String subscriptionId;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateScopedSubscriptions copy$default(UpdateScopedSubscriptions updateScopedSubscriptions, String str, Set set, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updateScopedSubscriptions.subscriptionId;
                }
                if ((i & 2) != 0) {
                    set = updateScopedSubscriptions.scopes;
                }
                if ((i & 4) != 0) {
                    z = updateScopedSubscriptions.isSubscribed;
                }
                return updateScopedSubscriptions.copy(str, set, z);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getSubscriptionId() {
                return this.subscriptionId;
            }

            @NotNull
            public final Set<Scope> component2() {
                return this.scopes;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsSubscribed() {
                return this.isSubscribed;
            }

            @NotNull
            public final UpdateScopedSubscriptions copy(@NotNull String subscriptionId, @NotNull Set<? extends Scope> scopes, boolean isSubscribed) {
                Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                return new UpdateScopedSubscriptions(subscriptionId, scopes, isSubscribed);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateScopedSubscriptions)) {
                    return false;
                }
                UpdateScopedSubscriptions updateScopedSubscriptions = (UpdateScopedSubscriptions) other;
                return Intrinsics.areEqual(this.subscriptionId, updateScopedSubscriptions.subscriptionId) && Intrinsics.areEqual(this.scopes, updateScopedSubscriptions.scopes) && this.isSubscribed == updateScopedSubscriptions.isSubscribed;
            }

            public int hashCode() {
                return (((this.subscriptionId.hashCode() * 31) + this.scopes.hashCode()) * 31) + Boolean.hashCode(this.isSubscribed);
            }

            @NotNull
            public String toString() {
                return "UpdateScopedSubscriptions(subscriptionId=" + this.subscriptionId + ", scopes=" + this.scopes + ", isSubscribed=" + this.isSubscribed + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateScopedSubscriptions(@NotNull String subscriptionId, @NotNull Set<? extends Scope> scopes, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                this.subscriptionId = subscriptionId;
                this.scopes = scopes;
                this.isSubscribed = z;
            }

            @NotNull
            public final Set<Scope> getScopes() {
                return this.scopes;
            }

            @NotNull
            public final String getSubscriptionId() {
                return this.subscriptionId;
            }

            public final boolean isSubscribed() {
                return this.isSubscribed;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateConditionState;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/data/Condition$State;", "(Lcom/urbanairship/preferencecenter/data/Condition$State;)V", "getState", "()Lcom/urbanairship/preferencecenter/data/Condition$State;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateConditionState extends Change {
            private final Condition.State state;

            public static /* synthetic */ UpdateConditionState copy$default(UpdateConditionState updateConditionState, Condition.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = updateConditionState.state;
                }
                return updateConditionState.copy(state);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Condition.State getState() {
                return this.state;
            }

            @NotNull
            public final UpdateConditionState copy(@NotNull Condition.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new UpdateConditionState(state);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateConditionState) && Intrinsics.areEqual(this.state, ((UpdateConditionState) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            @NotNull
            public String toString() {
                return "UpdateConditionState(state=" + this.state + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateConditionState(@NotNull Condition.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            @NotNull
            public final Condition.State getState() {
                return this.state;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change$UpdateContactChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Change;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "(Lcom/urbanairship/contacts/ContactChannel;Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getState", "()Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class UpdateContactChannel extends Change {
            private final ContactChannel channel;
            private final State.Content.ContactChannelState state;

            public static /* synthetic */ UpdateContactChannel copy$default(UpdateContactChannel updateContactChannel, ContactChannel contactChannel, State.Content.ContactChannelState contactChannelState, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactChannel = updateContactChannel.channel;
                }
                if ((i & 2) != 0) {
                    contactChannelState = updateContactChannel.state;
                }
                return updateContactChannel.copy(contactChannel, contactChannelState);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final State.Content.ContactChannelState getState() {
                return this.state;
            }

            @NotNull
            public final UpdateContactChannel copy(@NotNull ContactChannel channel, @NotNull State.Content.ContactChannelState state) {
                Intrinsics.checkNotNullParameter(channel, "channel");
                Intrinsics.checkNotNullParameter(state, "state");
                return new UpdateContactChannel(channel, state);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateContactChannel)) {
                    return false;
                }
                UpdateContactChannel updateContactChannel = (UpdateContactChannel) other;
                return Intrinsics.areEqual(this.channel, updateContactChannel.channel) && Intrinsics.areEqual(this.state, updateContactChannel.state);
            }

            public int hashCode() {
                return (this.channel.hashCode() * 31) + this.state.hashCode();
            }

            @NotNull
            public String toString() {
                return "UpdateContactChannel(channel=" + this.channel + ", state=" + this.state + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateContactChannel(@NotNull ContactChannel channel, @NotNull State.Content.ContactChannelState state) {
                super(null);
                Intrinsics.checkNotNullParameter(channel, "channel");
                Intrinsics.checkNotNullParameter(state, "state");
                this.channel = channel;
                this.state = state;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final State.Content.ContactChannelState getState() {
                return this.state;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "", "()V", "DismissContactManagementAddDialog", "ShowChannelVerificationResentDialog", "ShowContactManagementAddConfirmDialog", "ShowContactManagementAddDialog", "ShowContactManagementAddDialogError", "ShowContactManagementRemoveDialog", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$DismissContactManagementAddDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowChannelVerificationResentDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementAddConfirmDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementAddDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementAddDialogError;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementRemoveDialog;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Effect {
        public /* synthetic */ Effect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementAddDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;)V", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowContactManagementAddDialog extends Effect {
            private final Item.ContactManagement item;

            public static /* synthetic */ ShowContactManagementAddDialog copy$default(ShowContactManagementAddDialog showContactManagementAddDialog, Item.ContactManagement contactManagement, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = showContactManagementAddDialog.item;
                }
                return showContactManagementAddDialog.copy(contactManagement);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final ShowContactManagementAddDialog copy(@NotNull Item.ContactManagement item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new ShowContactManagementAddDialog(item);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowContactManagementAddDialog) && Intrinsics.areEqual(this.item, ((ShowContactManagementAddDialog) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            @NotNull
            public String toString() {
                return "ShowContactManagementAddDialog(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowContactManagementAddDialog(@NotNull Item.ContactManagement item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }
        }

        private Effect() {
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementAddConfirmDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;)V", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowContactManagementAddConfirmDialog extends Effect {
            private final Item.ContactManagement item;

            public static /* synthetic */ ShowContactManagementAddConfirmDialog copy$default(ShowContactManagementAddConfirmDialog showContactManagementAddConfirmDialog, Item.ContactManagement contactManagement, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = showContactManagementAddConfirmDialog.item;
                }
                return showContactManagementAddConfirmDialog.copy(contactManagement);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final ShowContactManagementAddConfirmDialog copy(@NotNull Item.ContactManagement item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new ShowContactManagementAddConfirmDialog(item);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowContactManagementAddConfirmDialog) && Intrinsics.areEqual(this.item, ((ShowContactManagementAddConfirmDialog) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            @NotNull
            public String toString() {
                return "ShowContactManagementAddConfirmDialog(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowContactManagementAddConfirmDialog(@NotNull Item.ContactManagement item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementRemoveDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Lcom/urbanairship/contacts/ContactChannel;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowContactManagementRemoveDialog extends Effect {
            private final ContactChannel channel;
            private final Item.ContactManagement item;

            public static /* synthetic */ ShowContactManagementRemoveDialog copy$default(ShowContactManagementRemoveDialog showContactManagementRemoveDialog, Item.ContactManagement contactManagement, ContactChannel contactChannel, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = showContactManagementRemoveDialog.item;
                }
                if ((i & 2) != 0) {
                    contactChannel = showContactManagementRemoveDialog.channel;
                }
                return showContactManagementRemoveDialog.copy(contactManagement, contactChannel);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final ShowContactManagementRemoveDialog copy(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new ShowContactManagementRemoveDialog(item, channel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowContactManagementRemoveDialog)) {
                    return false;
                }
                ShowContactManagementRemoveDialog showContactManagementRemoveDialog = (ShowContactManagementRemoveDialog) other;
                return Intrinsics.areEqual(this.item, showContactManagementRemoveDialog.item) && Intrinsics.areEqual(this.channel, showContactManagementRemoveDialog.channel);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.channel.hashCode();
            }

            @NotNull
            public String toString() {
                return "ShowContactManagementRemoveDialog(item=" + this.item + ", channel=" + this.channel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowContactManagementRemoveDialog(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.item = item;
                this.channel = channel;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowChannelVerificationResentDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;)V", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowChannelVerificationResentDialog extends Effect {
            private final Item.ContactManagement item;

            public static /* synthetic */ ShowChannelVerificationResentDialog copy$default(ShowChannelVerificationResentDialog showChannelVerificationResentDialog, Item.ContactManagement contactManagement, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = showChannelVerificationResentDialog.item;
                }
                return showChannelVerificationResentDialog.copy(contactManagement);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final ShowChannelVerificationResentDialog copy(@NotNull Item.ContactManagement item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new ShowChannelVerificationResentDialog(item);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowChannelVerificationResentDialog) && Intrinsics.areEqual(this.item, ((ShowChannelVerificationResentDialog) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            @NotNull
            public String toString() {
                return "ShowChannelVerificationResentDialog(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowChannelVerificationResentDialog(@NotNull Item.ContactManagement item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$ShowContactManagementAddDialogError;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowContactManagementAddDialogError extends Effect {
            private final String message;

            public static /* synthetic */ ShowContactManagementAddDialogError copy$default(ShowContactManagementAddDialogError showContactManagementAddDialogError, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showContactManagementAddDialogError.message;
                }
                return showContactManagementAddDialogError.copy(str);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            @NotNull
            public final ShowContactManagementAddDialogError copy(@NotNull String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                return new ShowContactManagementAddDialogError(message);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowContactManagementAddDialogError) && Intrinsics.areEqual(this.message, ((ShowContactManagementAddDialogError) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            @NotNull
            public String toString() {
                return "ShowContactManagementAddDialogError(message=" + this.message + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowContactManagementAddDialogError(@NotNull String message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            @NotNull
            public final String getMessage() {
                return this.message;
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect$DismissContactManagementAddDialog;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$Effect;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class DismissContactManagementAddDialog extends Effect {

            @NotNull
            public static final DismissContactManagementAddDialog INSTANCE = new DismissContactManagementAddDialog();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof DismissContactManagementAddDialog);
            }

            public int hashCode() {
                return -1879861258;
            }

            @NotNull
            public String toString() {
                return "DismissContactManagementAddDialog";
            }

            private DismissContactManagementAddDialog() {
                super(null);
            }
        }
    }
}
