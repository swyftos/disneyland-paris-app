package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.dlp.BluetoothManager;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.Provider;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.LayoutEventHandler;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ThomasFormStatus;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.environment.ThomasStateTrigger;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.Accessible;
import com.urbanairship.android.layout.info.CommonViewOverrides;
import com.urbanairship.android.layout.info.FormValidationMode;
import com.urbanairship.android.layout.info.ThomasChannelRegistration;
import com.urbanairship.android.layout.info.Validatable;
import com.urbanairship.android.layout.info.ValidationAction;
import com.urbanairship.android.layout.info.View;
import com.urbanairship.android.layout.info.VisibilityInfo;
import com.urbanairship.android.layout.model.BaseModel.Listener;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.EnableBehaviorType;
import com.urbanairship.android.layout.property.EventHandler;
import com.urbanairship.android.layout.property.EventHandlerKt;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.android.layout.reporting.AttributeName;
import com.urbanairship.android.layout.reporting.LayoutData;
import com.urbanairship.android.layout.reporting.ThomasFormFieldStatus;
import com.urbanairship.android.layout.util.ContextExtensionsKt;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.widget.CheckableView;
import com.urbanairship.android.layout.widget.TappableView;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.preferencecenter.data.PreferenceCenterPayload;
import com.urbanairship.util.PlatformUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000 \u0080\u0001*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007:\u0006\u0080\u0001\u0081\u0001\u0082\u0001B-\u0012\u0006\u0010\b\u001a\u00028\u0001\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0004J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<H\u0016J%\u0010=\u001a\u00028\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A¢\u0006\u0002\u0010BJ\u001a\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0007J\u001c\u0010H\u001a\u00020\u00162\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0002J'\u0010M\u001a\u00028\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH$¢\u0006\u0002\u0010BJ@\u0010N\u001a\u00020D21\u0010O\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0016¢\u0006\f\bQ\u0012\b\bR\u0012\u0004\b\b(S\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0T\u0012\u0006\u0012\u0004\u0018\u00010\u00070PH\u0004¢\u0006\u0002\u0010UJ\u0017\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00028\u0000H\u0011¢\u0006\u0004\bX\u0010YJ\u0015\u0010Z\u001a\u00020D2\u0006\u0010W\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010YJ\u0017\u0010[\u001a\u00020D2\u0006\u0010W\u001a\u00028\u0000H\u0011¢\u0006\u0004\b\\\u0010YJ\u0016\u0010]\u001a\u00020D2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_H\u0004J\u0010\u0010a\u001a\u00020D2\u0006\u00107\u001a\u00020bH\u0004J(\u0010c\u001a\u00020D2\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020f\u0018\u00010e2\b\b\u0002\u0010g\u001a\u00020hH\u0004J\"\u0010i\u001a\u00020D2\u000e\u0010d\u001a\n\u0012\u0004\u0012\u00020j\u0018\u00010_2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0007J\b\u0010l\u001a\u00020DH\u0002J\u0015\u0010m\u001a\u00020D2\u0006\u0010W\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010YJ \u0010n\u001a\u00020D2\u0016\u0010o\u001a\u0012\u0012\u0004\u0012\u00020p\u0012\b\u0012\u00060fj\u0002`q0eH\u0004J\u0014\u0010r\u001a\u00020D2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010sH\u0002J\u0010\u0010t\u001a\u00020D2\u0006\u0010g\u001a\u00020uH\u0002JC\u0010v\u001a\u00020D\"\u0004\b\u0003\u0010\u00012\u0006\u0010w\u001a\u00020:2\u0006\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u0001H\u00012\f\u0010{\u001a\b\u0012\u0004\u0012\u0002H\u00010|2\u0006\u0010}\u001a\u00020~H\u0004¢\u0006\u0002\u0010\u007fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00018\u0002X\u0090\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020&X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\b\u001a\u00028\u0001¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u00020&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(¨\u0006\u0083\u0001"}, d2 = {"Lcom/urbanairship/android/layout/model/BaseModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "I", "Lcom/urbanairship/android/layout/info/View;", "L", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "", "viewInfo", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "platformProvider", "Lcom/urbanairship/Provider;", "", "(Lcom/urbanairship/android/layout/info/View;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;Lcom/urbanairship/Provider;)V", AppStateModule.APP_STATE_BACKGROUND, "Lcom/urbanairship/android/layout/model/Background;", "getEnvironment", "()Lcom/urbanairship/android/layout/environment/ModelEnvironment;", "isShrinkable", "", "isShrinkable$urbanairship_layout_release", "()Z", "setShrinkable$urbanairship_layout_release", "(Z)V", "layoutState", "Lcom/urbanairship/android/layout/environment/LayoutState;", "getLayoutState", "()Lcom/urbanairship/android/layout/environment/LayoutState;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "setListener$urbanairship_layout_release", "(Lcom/urbanairship/android/layout/model/BaseModel$Listener;)V", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "modelScope", "Lkotlinx/coroutines/CoroutineScope;", "getModelScope", "()Lkotlinx/coroutines/CoroutineScope;", "getProperties", "()Lcom/urbanairship/android/layout/model/ModelProperties;", "viewId", "getViewId", "()I", "getViewInfo", "()Lcom/urbanairship/android/layout/info/View;", "Lcom/urbanairship/android/layout/info/View;", "viewJob", "Lkotlinx/coroutines/CompletableJob;", "viewScope", "getViewScope$urbanairship_layout_release", "broadcast", "Lkotlinx/coroutines/Job;", "event", "Lcom/urbanairship/android/layout/environment/LayoutEvent;", "contentDescription", "", "context", "Landroid/content/Context;", "createView", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/environment/ViewEnvironment;Lcom/urbanairship/android/layout/model/ItemProperties;)Landroid/view/View;", "handleViewEvent", "", "type", "Lcom/urbanairship/android/layout/property/EventHandler$Type;", "value", "mapEnableBehavior", PreferenceCenterPayload.KEY_FORM, "Lcom/urbanairship/android/layout/environment/State$Form;", "pager", "Lcom/urbanairship/android/layout/environment/State$Pager;", "onCreateView", "onFormInputDisplayed", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isDisplayed", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;)V", "onViewAttached", "view", "onViewAttached$urbanairship_layout_release", "(Landroid/view/View;)V", "onViewCreated", "onViewDetached", "onViewDetached$urbanairship_layout_release", "registerChannels", "channels", "", "Lcom/urbanairship/android/layout/info/ThomasChannelRegistration;", "report", "Lcom/urbanairship/android/layout/event/ReportingEvent;", "runActions", "actions", "", "Lcom/urbanairship/json/JsonValue;", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/reporting/LayoutData;", "runStateActions", "Lcom/urbanairship/android/layout/property/StateAction;", "formValue", "setupStateListeners", "setupViewListeners", "updateAttributes", "attributes", "Lcom/urbanairship/android/layout/reporting/AttributeName;", "Lcom/urbanairship/android/layout/property/AttributeValue;", "updateBackground", "Lcom/urbanairship/android/layout/environment/ThomasState;", "updateVisibility", "Lcom/urbanairship/json/JsonSerializable;", "wireValidationActions", "identifier", "thomasForm", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "initialValue", "valueUpdates", "Lkotlinx/coroutines/flow/Flow;", "validatable", "Lcom/urbanairship/android/layout/info/Validatable;", "(Ljava/lang/String;Lcom/urbanairship/android/layout/environment/ThomasForm;Ljava/lang/Object;Lkotlinx/coroutines/flow/Flow;Lcom/urbanairship/android/layout/info/Validatable;)V", "Companion", "Listener", "ValidationAction", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseModel.kt\ncom/urbanairship/android/layout/model/BaseModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,425:1\n1855#2,2:426\n1549#2:428\n1620#2,3:429\n1726#2,3:432\n*S KotlinDebug\n*F\n+ 1 BaseModel.kt\ncom/urbanairship/android/layout/model/BaseModel\n*L\n238#1:426,2\n292#1:428\n292#1:429,3\n344#1:432,3\n*E\n"})
/* loaded from: classes5.dex */
public abstract class BaseModel<T extends View, I extends com.urbanairship.android.layout.info.View, L extends Listener> {
    private static final Companion Companion = new Companion(null);
    private Background background;
    private final ModelEnvironment environment;
    private boolean isShrinkable;
    private final LayoutState layoutState;
    private Listener listener;
    private final CoroutineScope modelScope;
    private final Provider platformProvider;
    private final ModelProperties properties;
    private final int viewId;
    private final com.urbanairship.android.layout.info.View viewInfo;
    private final CompletableJob viewJob;
    private final CoroutineScope viewScope;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ThomasFormStatus.values().length];
            try {
                iArr[ThomasFormStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ThomasFormStatus.VALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ThomasFormStatus.PENDING_VALIDATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ThomasFormStatus.VALIDATING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ThomasFormStatus.INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ThomasFormStatus.SUBMITTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FormValidationMode.values().length];
            try {
                iArr2[FormValidationMode.ON_DEMAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[FormValidationMode.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[EnableBehaviorType.values().length];
            try {
                iArr3[EnableBehaviorType.FORM_VALIDATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[EnableBehaviorType.FORM_SUBMISSION.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[EnableBehaviorType.PAGER_NEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[EnableBehaviorType.PAGER_PREVIOUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @NotNull
    protected abstract T onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties);

    @VisibleForTesting(otherwise = 4)
    public void onViewAttached$urbanairship_layout_release(@NotNull T view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    protected void onViewCreated(@NotNull T view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @VisibleForTesting(otherwise = 4)
    public void onViewDetached$urbanairship_layout_release(@NotNull T view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public BaseModel(@NotNull I viewInfo, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties, @NotNull Provider<Integer> platformProvider) {
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(platformProvider, "platformProvider");
        this.viewInfo = viewInfo;
        this.environment = environment;
        this.properties = properties;
        this.platformProvider = platformProvider;
        this.viewId = android.view.View.generateViewId();
        this.modelScope = environment.getModelScope();
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.viewJob = completableJobSupervisorJob$default;
        this.viewScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(completableJobSupervisorJob$default));
        this.layoutState = environment.getLayoutState();
    }

    @NotNull
    public final I getViewInfo() {
        return (I) this.viewInfo;
    }

    @NotNull
    protected final ModelEnvironment getEnvironment() {
        return this.environment;
    }

    @NotNull
    protected final ModelProperties getProperties() {
        return this.properties;
    }

    public /* synthetic */ BaseModel(com.urbanairship.android.layout.info.View view, ModelEnvironment modelEnvironment, ModelProperties modelProperties, Provider provider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, modelEnvironment, modelProperties, (i & 8) != 0 ? new Provider() { // from class: com.urbanairship.android.layout.model.BaseModel$$ExternalSyntheticLambda0
            @Override // com.urbanairship.Provider
            public final Object get() {
                return Integer.valueOf(BaseModel._init_$lambda$0());
            }
        } : provider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$0() {
        return UAirship.shared().getPlatformType();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\fH&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "", "onStateUpdated", "", BluetoothManager.BLE_STATUS_PARAM, "Lcom/urbanairship/android/layout/environment/ThomasState;", "setBackground", "old", "Lcom/urbanairship/android/layout/model/Background;", "new", "setEnabled", "enabled", "", "setVisibility", ViewProps.VISIBLE, "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        default void onStateUpdated(@NotNull ThomasState state) {
            Intrinsics.checkNotNullParameter(state, "state");
        }

        void setBackground(@Nullable Background old, @NotNull Background background);

        void setEnabled(boolean enabled);

        void setVisibility(boolean visible);

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStateUpdated(@NotNull Listener listener, @NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Listener.super.onStateUpdated(state);
            }
        }
    }

    @Nullable
    /* renamed from: getListener$urbanairship_layout_release */
    public L getListener() {
        return (L) this.listener;
    }

    public void setListener$urbanairship_layout_release(@Nullable L l) {
        this.listener = l;
    }

    public final int getViewId() {
        return this.viewId;
    }

    /* renamed from: isShrinkable$urbanairship_layout_release, reason: from getter */
    public boolean getIsShrinkable() {
        return this.isShrinkable;
    }

    public void setShrinkable$urbanairship_layout_release(boolean z) {
        this.isShrinkable = z;
    }

    @NotNull
    public final T createView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.background = null;
        final T t = (T) onCreateView(context, viewEnvironment, itemProperties);
        onViewCreated(t);
        updateBackground$default(this, null, 1, null);
        t.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.urbanairship.android.layout.model.BaseModel.createView.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull android.view.View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                BaseModel.this.setupViewListeners(t);
                BaseModel.this.onViewAttached$urbanairship_layout_release(t);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull android.view.View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                BaseModel.this.onViewDetached$urbanairship_layout_release(t);
                JobKt__JobKt.cancelChildren$default((Job) BaseModel.this.viewJob, (CancellationException) null, 1, (Object) null);
            }
        });
        if (this.viewInfo.getEnableBehaviors() != null && (!r10.isEmpty())) {
            BuildersKt__Builders_commonKt.launch$default(this.modelScope, null, null, new AnonymousClass2(null), 3, null);
        }
        if (this.viewInfo.getStateTriggers() != null) {
            setupStateListeners();
        }
        return t;
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseModel$createView$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flowFlowOf;
            Flow flowFlowOf2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedState<State.Pager> pager = BaseModel.this.getLayoutState().getPager();
                if (pager == null || (flowFlowOf = pager.getChanges()) == null) {
                    flowFlowOf = FlowKt.flowOf((Object) null);
                }
                ThomasForm thomasForm = BaseModel.this.getLayoutState().getThomasForm();
                if (thomasForm == null || (flowFlowOf2 = thomasForm.getFormUpdates()) == null) {
                    flowFlowOf2 = FlowKt.flowOf((Object) null);
                }
                Flow flowCombine = FlowKt.combine(flowFlowOf, flowFlowOf2, new AnonymousClass1(BaseModel.this, null));
                final BaseModel baseModel = BaseModel.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseModel.createView.2.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), continuation);
                    }

                    public final Object emit(boolean z, Continuation continuation) {
                        Listener listener$urbanairship_layout_release = baseModel.getListener();
                        if (listener$urbanairship_layout_release != null) {
                            listener$urbanairship_layout_release.setEnabled(z);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowCombine.collect(flowCollector, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.android.layout.model.BaseModel$createView$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function3 {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ BaseModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BaseModel baseModel, Continuation continuation) {
                super(3, continuation);
                this.this$0 = baseModel;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(State.Pager pager, State.Form form, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = pager;
                anonymousClass1.L$1 = form;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    State.Pager pager = (State.Pager) this.L$0;
                    return Boxing.boxBoolean(this.this$0.mapEnableBehavior((State.Form) this.L$1, pager));
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    protected final void onFormInputDisplayed(@NotNull Function2<? super Boolean, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.viewInfo.getType().isFormInput()) {
            BuildersKt__Builders_commonKt.launch$default(this.modelScope, null, null, new C09301(block, null), 3, null);
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseModel$onFormInputDisplayed$1, reason: invalid class name and case insensitive filesystem */
    static final class C09301 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function2 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09301(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09301(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            StateFlow<State.Pager> changes;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    throw new KotlinNothingValueException();
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            SharedState<State.Pager> pager = BaseModel.this.getLayoutState().getPager();
            if (pager == null || (changes = pager.getChanges()) == null) {
                Function2 function2 = this.$block;
                Boolean boolBoxBoolean = Boxing.boxBoolean(true);
                this.label = 2;
                if (function2.invoke(boolBoxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            final BaseModel baseModel = BaseModel.this;
            final Function2 function22 = this.$block;
            FlowCollector<? super State.Pager> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseModel.onFormInputDisplayed.1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(State.Pager pager2, Continuation continuation) {
                    String str = pager2.getPageIds().get(pager2.getPageIndex());
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    boolean z = booleanRef2.element;
                    booleanRef2.element = Intrinsics.areEqual(str, baseModel.getProperties().getPagerPageId());
                    boolean z2 = booleanRef.element;
                    if (z != z2) {
                        Object objInvoke = function22.invoke(Boxing.boxBoolean(z2), continuation);
                        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (changes.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseModel$setupViewListeners$1, reason: invalid class name and case insensitive filesystem */
    static final class C09321 extends SuspendLambda implements Function2 {
        final /* synthetic */ android.view.View $view;
        int label;
        final /* synthetic */ BaseModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09321(android.view.View view, BaseModel baseModel, Continuation continuation) {
            super(2, continuation);
            this.$view = view;
            this.this$0 = baseModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09321(this.$view, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flowDebouncedClicks$default = ViewExtensionsKt.debouncedClicks$default(this.$view, 0L, 1, null);
                final BaseModel baseModel = this.this$0;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseModel.setupViewListeners.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Unit unit, Continuation continuation) {
                        BaseModel.handleViewEvent$default(baseModel, EventHandler.Type.TAP, null, 2, null);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (flowDebouncedClicks$default.collect(flowCollector, this) == coroutine_suspended) {
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
    public final void setupViewListeners(android.view.View view) {
        if (EventHandlerKt.hasTapHandler(this.viewInfo.getEventHandlers()) && !(view instanceof TappableView) && !(view instanceof CheckableView)) {
            BuildersKt__Builders_commonKt.launch$default(this.viewScope, null, null, new C09321(view, this, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(this.viewScope, null, null, new C09332(null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseModel$setupViewListeners$2, reason: invalid class name and case insensitive filesystem */
    static final class C09332 extends SuspendLambda implements Function2 {
        int label;

        C09332(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09332(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<ThomasState> thomasState = BaseModel.this.getLayoutState().getThomasState();
                final BaseModel baseModel = BaseModel.this;
                FlowCollector<? super ThomasState> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseModel.setupViewListeners.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(ThomasState thomasState2, Continuation continuation) {
                        baseModel.updateBackground(thomasState2);
                        baseModel.updateVisibility(thomasState2);
                        Listener listener$urbanairship_layout_release = baseModel.getListener();
                        if (listener$urbanairship_layout_release != null) {
                            listener$urbanairship_layout_release.onStateUpdated(thomasState2);
                        }
                        baseModel.broadcast(new LayoutEvent.StateUpdate(thomasState2));
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (thomasState.collect(flowCollector, this) == coroutine_suspended) {
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

    private final void setupStateListeners() {
        List<ThomasStateTrigger> stateTriggers = this.viewInfo.getStateTriggers();
        if (stateTriggers == null || stateTriggers.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.modelScope, null, null, new C09311(stateTriggers, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseModel$setupStateListeners$1, reason: invalid class name and case insensitive filesystem */
    static final class C09311 extends SuspendLambda implements Function2 {
        final /* synthetic */ List $triggers;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09311(List list, Continuation continuation) {
            super(2, continuation);
            this.$triggers = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09311(this.$triggers, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final LinkedHashSet linkedHashSet = new LinkedHashSet();
                StateFlow<ThomasState> thomasState = BaseModel.this.getLayoutState().getThomasState();
                final List list = this.$triggers;
                final BaseModel baseModel = BaseModel.this;
                FlowCollector<? super ThomasState> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseModel.setupStateListeners.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(ThomasState thomasState2, Continuation continuation) {
                        JsonPredicate resetWhenStateMatches;
                        List<ThomasStateTrigger> list2 = list;
                        Set set = linkedHashSet;
                        BaseModel baseModel2 = baseModel;
                        for (ThomasStateTrigger thomasStateTrigger : list2) {
                            if (set.contains(thomasStateTrigger.getId()) && (resetWhenStateMatches = thomasStateTrigger.getResetWhenStateMatches()) != null && resetWhenStateMatches.apply((JsonSerializable) thomasState2)) {
                                set.remove(thomasStateTrigger.getId());
                            }
                            if (!set.contains(thomasStateTrigger.getId()) && thomasStateTrigger.getTriggerWhenStateMatches().apply((JsonSerializable) thomasState2)) {
                                set.add(thomasStateTrigger.getId());
                                BaseModel.runStateActions$default(baseModel2, thomasStateTrigger.getOnTrigger().getStateActions(), null, 2, null);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (thomasState.collect(flowCollector, this) == coroutine_suspended) {
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

    @Nullable
    public String contentDescription(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.urbanairship.android.layout.info.View view = this.viewInfo;
        if (view instanceof Accessible) {
            return ContextExtensionsKt.resolveContentDescription(context, ((Accessible) view).getContentDescription(), ((Accessible) this.viewInfo).getLocalizedContentDescription());
        }
        return null;
    }

    @NotNull
    protected final CoroutineScope getModelScope() {
        return this.modelScope;
    }

    @NotNull
    /* renamed from: getViewScope$urbanairship_layout_release, reason: from getter */
    public final CoroutineScope getViewScope() {
        return this.viewScope;
    }

    @NotNull
    protected final LayoutState getLayoutState() {
        return this.layoutState;
    }

    protected final void report(@NotNull ReportingEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.environment.getReporter().report(event);
    }

    public static /* synthetic */ void runActions$default(BaseModel baseModel, Map map, LayoutData layoutData, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runActions");
        }
        if ((i & 2) != 0) {
            layoutData = LayoutState.reportingContext$default(baseModel.layoutState, null, null, null, 7, null);
        }
        baseModel.runActions(map, layoutData);
    }

    protected final void runActions(@Nullable Map<String, ? extends JsonValue> actions, @NotNull LayoutData state) {
        JsonMap map;
        JsonValue jsonValue;
        JsonMap map2;
        Intrinsics.checkNotNullParameter(state, "state");
        String strAsString = PlatformUtils.asString(((Number) this.platformProvider.get()).intValue());
        Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        if (actions == null) {
            actions = MapsKt.emptyMap();
        }
        Map<String, ? extends JsonValue> mutableMap = MapsKt.toMutableMap(actions);
        JsonValue jsonValue2 = (JsonValue) mutableMap.remove("platform_action_overrides");
        if (jsonValue2 != null && (map = jsonValue2.getMap()) != null && (jsonValue = map.get(strAsString)) != null && (map2 = jsonValue.getMap()) != null) {
            for (Map.Entry<String, JsonValue> entry : map2) {
                String key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                JsonValue value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                mutableMap.put(key, value);
            }
        }
        this.environment.getActionsRunner().run(mutableMap, state);
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseModel$broadcast$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ LayoutEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LayoutEvent layoutEvent, Continuation continuation) {
            super(2, continuation);
            this.$event = layoutEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$event, continuation);
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
                LayoutEventHandler eventHandler = BaseModel.this.getEnvironment().getEventHandler();
                LayoutEvent layoutEvent = this.$event;
                this.label = 1;
                if (eventHandler.broadcast(layoutEvent, this) == coroutine_suspended) {
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
    protected final Job broadcast(@NotNull LayoutEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return BuildersKt__Builders_commonKt.launch$default(this.modelScope, null, null, new AnonymousClass1(event, null), 3, null);
    }

    protected final void registerChannels(@NotNull List<? extends ThomasChannelRegistration> channels) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        this.environment.getChannelRegistrar().register(channels);
    }

    protected final void updateAttributes(@NotNull Map<AttributeName, ? extends JsonValue> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.environment.getAttributeHandler().update(attributes);
    }

    static /* synthetic */ void updateBackground$default(BaseModel baseModel, ThomasState thomasState, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBackground");
        }
        if ((i & 1) != 0) {
            thomasState = null;
        }
        baseModel.updateBackground(thomasState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBackground(ThomasState state) {
        Background background;
        if (state != null) {
            CommonViewOverrides commonViewOverrides = this.viewInfo.getCommonViewOverrides();
            Color color = (Color) state.resolveOptional(commonViewOverrides != null ? commonViewOverrides.getBackgroundColor() : null, this.viewInfo.getBackgroundColor());
            CommonViewOverrides commonViewOverrides2 = this.viewInfo.getCommonViewOverrides();
            background = new Background(color, (Border) state.resolveOptional(commonViewOverrides2 != null ? commonViewOverrides2.getBorder() : null, this.viewInfo.getBorder()));
        } else {
            background = new Background(this.viewInfo.getBackgroundColor(), this.viewInfo.getBorder());
        }
        if (Intrinsics.areEqual(background, this.background)) {
            return;
        }
        Listener listener$urbanairship_layout_release = getListener();
        if (listener$urbanairship_layout_release != null) {
            listener$urbanairship_layout_release.setBackground(this.background, background);
        }
        this.background = background;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateVisibility(JsonSerializable state) {
        boolean z;
        VisibilityInfo visibility = this.viewInfo.getVisibility();
        if (visibility == null) {
            return;
        }
        if (visibility.getInvertWhenStateMatcher().apply(state)) {
            z = !visibility.getDefault();
        } else {
            z = visibility.getDefault();
        }
        Listener listener$urbanairship_layout_release = getListener();
        if (listener$urbanairship_layout_release != null) {
            listener$urbanairship_layout_release.setVisibility(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mapEnableBehavior(com.urbanairship.android.layout.environment.State.Form r7, com.urbanairship.android.layout.environment.State.Pager r8) {
        /*
            r6 = this;
            com.urbanairship.android.layout.info.View r6 = r6.viewInfo
            java.util.List r6 = r6.getEnableBehaviors()
            r0 = 1
            if (r6 != 0) goto La
            return r0
        La:
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r2)
            r1.<init>(r2)
            java.util.Iterator r6 = r6.iterator()
        L19:
            boolean r2 = r6.hasNext()
            r3 = 0
            if (r2 == 0) goto Lbb
            java.lang.Object r2 = r6.next()
            com.urbanairship.android.layout.property.EnableBehaviorType r2 = (com.urbanairship.android.layout.property.EnableBehaviorType) r2
            int[] r4 = com.urbanairship.android.layout.model.BaseModel.WhenMappings.$EnumSwitchMapping$2
            int r2 = r2.ordinal()
            r2 = r4[r2]
            r4 = 2
            if (r2 == r0) goto L6f
            if (r2 == r4) goto L60
            r4 = 3
            if (r2 == r4) goto L50
            r4 = 4
            if (r2 != r4) goto L4a
            if (r8 == 0) goto L43
            boolean r2 = r8.isScrollDisabled()
            if (r2 != r0) goto L43
            goto Lb2
        L43:
            if (r8 == 0) goto Lb2
            boolean r3 = r8.getHasPrevious()
            goto Lb2
        L4a:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L50:
            if (r8 == 0) goto L59
            boolean r2 = r8.isScrollDisabled()
            if (r2 != r0) goto L59
            goto Lb2
        L59:
            if (r8 == 0) goto Lb2
            boolean r3 = r8.getHasNext()
            goto Lb2
        L60:
            if (r7 != 0) goto L63
            goto Lb2
        L63:
            com.urbanairship.android.layout.environment.ThomasFormStatus r2 = r7.getStatus()
            boolean r2 = r2.isSubmitted()
            if (r2 != 0) goto Lb2
        L6d:
            r3 = r0
            goto Lb2
        L6f:
            if (r7 != 0) goto L72
            goto Lb2
        L72:
            com.urbanairship.android.layout.info.FormValidationMode r2 = r7.getValidationMode()
            int[] r5 = com.urbanairship.android.layout.model.BaseModel.WhenMappings.$EnumSwitchMapping$1
            int r2 = r2.ordinal()
            r2 = r5[r2]
            if (r2 == r0) goto L9d
            if (r2 != r4) goto L97
            com.urbanairship.android.layout.environment.ThomasFormStatus r2 = r7.getStatus()
            int[] r4 = com.urbanairship.android.layout.model.BaseModel.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r4[r2]
            switch(r2) {
                case 1: goto L6d;
                case 2: goto L6d;
                case 3: goto Lb2;
                case 4: goto Lb2;
                case 5: goto Lb2;
                case 6: goto Lb2;
                default: goto L91;
            }
        L91:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L97:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L9d:
            com.urbanairship.android.layout.environment.ThomasFormStatus r2 = r7.getStatus()
            int[] r4 = com.urbanairship.android.layout.model.BaseModel.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r4[r2]
            switch(r2) {
                case 1: goto L6d;
                case 2: goto L6d;
                case 3: goto L6d;
                case 4: goto Lb2;
                case 5: goto Lb2;
                case 6: goto Lb2;
                default: goto Lac;
            }
        Lac:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        Lb2:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            r1.add(r2)
            goto L19
        Lbb:
            boolean r6 = r1.isEmpty()
            if (r6 == 0) goto Lc2
            goto Ld9
        Lc2:
            java.util.Iterator r6 = r1.iterator()
        Lc6:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto Ld9
            java.lang.Object r7 = r6.next()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto Lc6
            r0 = r3
        Ld9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseModel.mapEnableBehavior(com.urbanairship.android.layout.environment.State$Form, com.urbanairship.android.layout.environment.State$Pager):boolean");
    }

    public static /* synthetic */ void handleViewEvent$default(BaseModel baseModel, EventHandler.Type type, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleViewEvent");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        baseModel.handleViewEvent(type, obj);
    }

    public final void handleViewEvent(@NotNull EventHandler.Type type, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<EventHandler> eventHandlers = this.viewInfo.getEventHandlers();
        if (eventHandlers == null) {
            eventHandlers = CollectionsKt.emptyList();
        }
        for (EventHandler eventHandler : eventHandlers) {
            if (eventHandler.getType() == type) {
                runStateActions(eventHandler.getActions(), value);
            }
        }
    }

    public static /* synthetic */ void runStateActions$default(BaseModel baseModel, List list, Object obj, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: runStateActions");
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        baseModel.runStateActions(list, obj);
    }

    public final void runStateActions(@Nullable List<? extends StateAction> actions, @Nullable Object formValue) {
        this.layoutState.processStateActions(actions, formValue);
    }

    protected final <T> void wireValidationActions(@NotNull String identifier, @NotNull ThomasForm thomasForm, @Nullable T initialValue, @NotNull Flow<? extends T> valueUpdates, @NotNull Validatable validatable) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(thomasForm, "thomasForm");
        Intrinsics.checkNotNullParameter(valueUpdates, "valueUpdates");
        Intrinsics.checkNotNullParameter(validatable, "validatable");
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        BuildersKt__Builders_commonKt.launch$default(this.modelScope, null, null, new C09341(thomasForm, valueUpdates, StateFlowKt.MutableStateFlow(initialValue), MutableStateFlow, identifier, validatable, this, null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1, reason: invalid class name and case insensitive filesystem */
    static final class C09341 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $identifier;
        final /* synthetic */ MutableStateFlow $isInitialValue;
        final /* synthetic */ MutableStateFlow $lastSelected;
        final /* synthetic */ ThomasForm $thomasForm;
        final /* synthetic */ Validatable $validatable;
        final /* synthetic */ Flow $valueUpdates;
        int label;
        final /* synthetic */ BaseModel this$0;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ValidationAction.values().length];
                try {
                    iArr[ValidationAction.EDIT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ValidationAction.VALID.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ValidationAction.ERROR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09341(ThomasForm thomasForm, Flow flow, MutableStateFlow mutableStateFlow, MutableStateFlow mutableStateFlow2, String str, Validatable validatable, BaseModel baseModel, Continuation continuation) {
            super(2, continuation);
            this.$thomasForm = thomasForm;
            this.$valueUpdates = flow;
            this.$lastSelected = mutableStateFlow;
            this.$isInitialValue = mutableStateFlow2;
            this.$identifier = str;
            this.$validatable = validatable;
            this.this$0 = baseModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09341(this.$thomasForm, this.$valueUpdates, this.$lastSelected, this.$isInitialValue, this.$identifier, this.$validatable, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* renamed from: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00991 extends SuspendLambda implements Function3 {
            final /* synthetic */ String $identifier;
            final /* synthetic */ MutableStateFlow $isInitialValue;
            final /* synthetic */ MutableStateFlow $lastSelected;
            final /* synthetic */ ThomasForm $thomasForm;
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$1$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ThomasFormStatus.values().length];
                    try {
                        iArr[ThomasFormStatus.VALID.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ThomasFormStatus.INVALID.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ThomasFormStatus.ERROR.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00991(MutableStateFlow mutableStateFlow, MutableStateFlow mutableStateFlow2, ThomasForm thomasForm, String str, Continuation continuation) {
                super(3, continuation);
                this.$lastSelected = mutableStateFlow;
                this.$isInitialValue = mutableStateFlow2;
                this.$thomasForm = thomasForm;
                this.$identifier = str;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(ThomasFormStatus thomasFormStatus, Object obj, Continuation continuation) {
                C00991 c00991 = new C00991(this.$lastSelected, this.$isInitialValue, this.$thomasForm, this.$identifier, continuation);
                c00991.L$0 = thomasFormStatus;
                c00991.L$1 = obj;
                return c00991.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ThomasFormStatus thomasFormStatus = (ThomasFormStatus) this.L$0;
                Object obj2 = this.L$1;
                boolean z = false;
                if (!Intrinsics.areEqual(this.$lastSelected.getValue(), obj2)) {
                    MutableStateFlow mutableStateFlow = this.$lastSelected;
                    while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), obj2)) {
                    }
                    MutableStateFlow mutableStateFlow2 = this.$isInitialValue;
                    do {
                        value = mutableStateFlow2.getValue();
                        ((Boolean) value).booleanValue();
                    } while (!mutableStateFlow2.compareAndSet(value, Boxing.boxBoolean(false)));
                    z = true;
                }
                int i = WhenMappings.$EnumSwitchMapping$0[thomasFormStatus.ordinal()];
                if (i != 1 && i != 2 && i != 3) {
                    if (z) {
                        return ValidationAction.EDIT;
                    }
                    return null;
                }
                ThomasFormFieldStatus<?> thomasFormFieldStatusLastProcessedStatus = this.$thomasForm.lastProcessedStatus(this.$identifier);
                if (thomasFormFieldStatusLastProcessedStatus instanceof ThomasFormFieldStatus.Invalid) {
                    if (this.$thomasForm.getValidationMode() == FormValidationMode.ON_DEMAND || !((Boolean) this.$isInitialValue.getValue()).booleanValue()) {
                        return ValidationAction.ERROR;
                    }
                    return null;
                }
                if (thomasFormFieldStatusLastProcessedStatus instanceof ThomasFormFieldStatus.Valid) {
                    return ValidationAction.VALID;
                }
                if (thomasFormFieldStatusLastProcessedStatus instanceof ThomasFormFieldStatus.Pending) {
                    return ValidationAction.EDIT;
                }
                return null;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(FlowKt.combine(this.$thomasForm.getStatus(), this.$valueUpdates, new C00991(this.$lastSelected, this.$isInitialValue, this.$thomasForm, this.$identifier, null)));
                final Validatable validatable = this.$validatable;
                Flow<com.urbanairship.android.layout.info.ValidationAction> flow = new Flow<com.urbanairship.android.layout.info.ValidationAction>() { // from class: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 BaseModel.kt\ncom/urbanairship/android/layout/model/BaseModel$wireValidationActions$1\n*L\n1#1,218:1\n57#2:219\n58#2:225\n404#3,5:220\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ Validatable $validatable$inlined;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "BaseModel.kt", i = {}, l = {JfifUtil.MARKER_APP1}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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

                        public AnonymousClass2(FlowCollector flowCollector, Validatable validatable) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$validatable$inlined = validatable;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r7
                                com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                                r0.<init>(r7)
                            L18:
                                java.lang.Object r7 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L76
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                kotlin.ResultKt.throwOnFailure(r7)
                                kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                                com.urbanairship.android.layout.model.BaseModel$ValidationAction r6 = (com.urbanairship.android.layout.model.BaseModel.ValidationAction) r6
                                r2 = -1
                                if (r6 != 0) goto L3d
                                r6 = r2
                                goto L45
                            L3d:
                                int[] r4 = com.urbanairship.android.layout.model.BaseModel.C09341.WhenMappings.$EnumSwitchMapping$0
                                int r6 = r6.ordinal()
                                r6 = r4[r6]
                            L45:
                                if (r6 == r2) goto L6a
                                if (r6 == r3) goto L63
                                r2 = 2
                                if (r6 == r2) goto L5c
                                r2 = 3
                                if (r6 != r2) goto L56
                                com.urbanairship.android.layout.info.Validatable r5 = r5.$validatable$inlined
                                com.urbanairship.android.layout.info.ValidationAction r5 = r5.getOnError()
                                goto L6b
                            L56:
                                kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                                r5.<init>()
                                throw r5
                            L5c:
                                com.urbanairship.android.layout.info.Validatable r5 = r5.$validatable$inlined
                                com.urbanairship.android.layout.info.ValidationAction r5 = r5.getOnValid()
                                goto L6b
                            L63:
                                com.urbanairship.android.layout.info.Validatable r5 = r5.$validatable$inlined
                                com.urbanairship.android.layout.info.ValidationAction r5 = r5.getOnEdit()
                                goto L6b
                            L6a:
                                r5 = 0
                            L6b:
                                if (r5 == 0) goto L76
                                r0.label = r3
                                java.lang.Object r5 = r7.emit(r5, r0)
                                if (r5 != r1) goto L76
                                return r1
                            L76:
                                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.BaseModel$wireValidationActions$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super ValidationAction> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector, validatable), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                final BaseModel baseModel = this.this$0;
                final MutableStateFlow mutableStateFlow = this.$lastSelected;
                FlowCollector<? super com.urbanairship.android.layout.info.ValidationAction> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.BaseModel.wireValidationActions.1.3
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(com.urbanairship.android.layout.info.ValidationAction validationAction, Continuation continuation) {
                        baseModel.runStateActions(validationAction.getActions(), mutableStateFlow.getValue());
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

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/layout/model/BaseModel$ValidationAction;", "", "(Ljava/lang/String;I)V", "EDIT", "VALID", "ERROR", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ValidationAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ValidationAction[] $VALUES;
        public static final ValidationAction EDIT = new ValidationAction("EDIT", 0);
        public static final ValidationAction VALID = new ValidationAction("VALID", 1);
        public static final ValidationAction ERROR = new ValidationAction("ERROR", 2);

        private static final /* synthetic */ ValidationAction[] $values() {
            return new ValidationAction[]{EDIT, VALID, ERROR};
        }

        @NotNull
        public static EnumEntries<ValidationAction> getEntries() {
            return $ENTRIES;
        }

        public static ValidationAction valueOf(String str) {
            return (ValidationAction) Enum.valueOf(ValidationAction.class, str);
        }

        public static ValidationAction[] values() {
            return (ValidationAction[]) $VALUES.clone();
        }

        private ValidationAction(String str, int i) {
        }

        static {
            ValidationAction[] validationActionArr$values = $values();
            $VALUES = validationActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(validationActionArr$values);
        }
    }
}
