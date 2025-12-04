package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.UALog;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.gestures.PagerGestureEvent;
import com.urbanairship.android.layout.info.AccessibilityAction;
import com.urbanairship.android.layout.info.PagerInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.AutomatedAction;
import com.urbanairship.android.layout.property.AutomatedActionKt;
import com.urbanairship.android.layout.property.ButtonClickBehaviorType;
import com.urbanairship.android.layout.property.ButtonClickBehaviorTypeKt;
import com.urbanairship.android.layout.property.GestureLocation;
import com.urbanairship.android.layout.property.PageBranching;
import com.urbanairship.android.layout.property.PagerControllerBranching;
import com.urbanairship.android.layout.property.PagerGesture;
import com.urbanairship.android.layout.property.PagerGestureBehavior;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.android.layout.reporting.PagerData;
import com.urbanairship.android.layout.util.Timer;
import com.urbanairship.android.layout.view.PagerView;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002ijB9\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0019\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020.2\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0007H\u0002J\u000e\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\"J\u0018\u00106\u001a\u00020.2\u0006\u00107\u001a\u0002082\u0006\u0010\t\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u00020.H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020<H\u0002J4\u0010=\u001a\u00020.2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020@\u0018\u00010?2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u00020.H\u0002J\u0012\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\"H\u0002J\"\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\u0016\u0010R\u001a\u00020.2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0015\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020\u0002H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020.2\u0006\u0010U\u001a\u00020\u0002H\u0010¢\u0006\u0002\bXJ\b\u0010Y\u001a\u00020.H\u0002J\u0018\u0010Z\u001a\u00020.2\u0006\u00107\u001a\u00020B2\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0018\u0010[\u001a\u00020.2\u0006\u0010\\\u001a\u00020]2\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010^\u001a\u00020.2\u0006\u0010\t\u001a\u00020\u000bH\u0002J\u0010\u0010_\u001a\u00020\u001a2\u0006\u0010`\u001a\u00020IH\u0002J\b\u0010a\u001a\u00020.H\u0002J\u0010\u0010b\u001a\u00020.2\u0006\u00107\u001a\u00020BH\u0002J\u0010\u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020\u001aH\u0002J\u0010\u0010e\u001a\u00020.2\u0006\u0010f\u001a\u00020\u0018H\u0002J\u000e\u0010g\u001a\u00020.H\u0082@¢\u0006\u0002\u0010hR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`$0\u00072\u001c\u0010#\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001j\u0002`$0\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/urbanairship/android/layout/model/PagerModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/PagerView;", "Lcom/urbanairship/android/layout/info/PagerInfo;", "Lcom/urbanairship/android/layout/model/PagerModel$Listener;", "viewInfo", "availablePages", "", "Lcom/urbanairship/android/layout/model/PagerModel$Item;", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/PagerInfo;Ljava/util/List;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "_allPages", "accessibilityListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "automatedActionsTimers", "", "Lcom/urbanairship/android/layout/util/Timer;", "branchControl", "Lcom/urbanairship/android/layout/model/PagerBranchControl;", "isSinglePage", "", "()Z", "lastDisplayedPageId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "navigationActionTimer", "pageViewIds", "", "", "<set-?>", "Lcom/urbanairship/android/layout/model/AnyModel;", "pages", "getPages", "()Ljava/util/List;", "recyclerViewId", "getRecyclerViewId", "()I", "scheduledJob", "Lkotlinx/coroutines/Job;", "clearAutomatedActions", "", "pageIndex", "(Ljava/lang/Integer;)V", "evaluateClickBehaviors", "behaviors", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "getPageViewId", ViewProps.POSITION, "handleAccessibilityAction", "action", "Lcom/urbanairship/android/layout/info/AccessibilityAction;", "handleDismiss", "handleGesture", "event", "Lcom/urbanairship/android/layout/gestures/PagerGestureEvent;", "handlePageActions", "displayActions", "", "Lcom/urbanairship/json/JsonValue;", "automatedActions", "Lcom/urbanairship/android/layout/property/AutomatedAction;", "(Ljava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePagerNext", "fallback", "Lcom/urbanairship/android/layout/model/PagerNextFallback;", "handlePagerPrevious", "makePageRequest", "Lcom/urbanairship/android/layout/model/PageRequest;", "toPosition", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onPagesDataUpdated", "updated", "onViewAttached", "view", "onViewAttached$urbanairship_layout_release", "onViewDetached", "onViewDetached$urbanairship_layout_release", "pauseStory", "reportAutomatedAction", "reportGesture", "gesture", "Lcom/urbanairship/android/layout/property/PagerGesture;", "reportPageSwipe", "resolve", "request", "resumeStory", "scheduleAutomatedAction", "updateTouchExplorationState", "enabled", "wireBranchControlFlows", "control", "wireSwipeSelector", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Item", "Listener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerModel.kt\ncom/urbanairship/android/layout/model/PagerModel\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 7 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,620:1\n17#2:621\n19#2:625\n46#3:622\n51#3:624\n105#4:623\n1549#5:626\n1620#5,3:627\n766#5:638\n857#5,2:639\n1855#5,2:641\n800#5,11:643\n766#5:654\n857#5,2:655\n1549#5:657\n1620#5,3:658\n800#5,11:661\n766#5:672\n857#5,2:673\n1549#5:675\n1620#5,3:676\n800#5,11:679\n1549#5:690\n1620#5,3:691\n1855#5,2:694\n372#6,7:630\n1#7:637\n*S KotlinDebug\n*F\n+ 1 PagerModel.kt\ncom/urbanairship/android/layout/model/PagerModel\n*L\n169#1:621\n169#1:625\n169#1:622\n169#1:624\n169#1:623\n182#1:626\n182#1:627,3\n425#1:638\n425#1:639,2\n425#1:641,2\n459#1:643,11\n460#1:654\n460#1:655,2\n461#1:657\n461#1:658,3\n464#1:661,11\n464#1:672\n464#1:673,2\n465#1:675\n465#1:676,3\n467#1:679,11\n467#1:690\n467#1:691,3\n475#1:694,2\n319#1:630,7\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerModel extends BaseModel<PagerView, PagerInfo, Listener> {
    private List _allPages;
    private AccessibilityManager.TouchExplorationStateChangeListener accessibilityListener;
    private final List automatedActionsTimers;
    private final PagerBranchControl branchControl;
    private final MutableStateFlow lastDisplayedPageId;
    private Timer navigationActionTimer;
    private final Map pageViewIds;
    private final SharedState pagerState;
    private List pages;
    private final int recyclerViewId;
    private Job scheduledJob;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PagerGestureEvent.Hold.Action.values().length];
            try {
                iArr[PagerGestureEvent.Hold.Action.PRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PagerGestureEvent.Hold.Action.RELEASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PagerNextFallback.values().length];
            try {
                iArr2[PagerNextFallback.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PagerNextFallback.DISMISS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PagerNextFallback.FIRST.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$wireSwipeSelector$1, reason: invalid class name and case insensitive filesystem */
    static final class C09491 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09491(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerModel.this.wireSwipeSelector(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerModel(@NotNull PagerInfo viewInfo, @NotNull List<Item> availablePages, @NotNull SharedState<State.Pager> pagerState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(availablePages, "availablePages");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.pagerState = pagerState;
        this.recyclerViewId = View.generateViewId();
        this._allPages = CollectionsKt.emptyList();
        this.pages = CollectionsKt.emptyList();
        this.pageViewIds = new LinkedHashMap();
        this.automatedActionsTimers = new ArrayList();
        this.lastDisplayedPageId = StateFlowKt.MutableStateFlow(null);
        PagerControllerBranching branching = pagerState.getValue().getBranching();
        if (branching != null) {
            PagerBranchControl pagerBranchControl = new PagerBranchControl(availablePages, branching, environment.getLayoutState().getThomasState(), new AnonymousClass1(this), new AnonymousClass2(this), null, 32, null);
            this.branchControl = pagerBranchControl;
            wireBranchControlFlows(pagerBranchControl);
        } else {
            this.branchControl = null;
            onPagesDataUpdated(availablePages);
        }
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass3(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new AnonymousClass4(null), 3, null);
        final Flow<LayoutEvent> layoutEvents = environment.getLayoutEvents();
        FlowKt.launchIn(FlowKt.onEach(new Flow<LayoutEvent>() { // from class: com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PagerModel.kt\ncom/urbanairship/android/layout/model/PagerModel\n*L\n1#1,218:1\n18#2:219\n19#2:221\n169#3:220\n*E\n"})
            /* renamed from: com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1$2", f = "PagerModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                /* renamed from: com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1$2$1 r0 = (com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1$2$1 r0 = new com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1$2$1
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
                        com.urbanairship.android.layout.environment.LayoutEvent r6 = (com.urbanairship.android.layout.environment.LayoutEvent) r6
                        boolean r2 = r6 instanceof com.urbanairship.android.layout.environment.LayoutEvent.PagerNext
                        if (r2 != 0) goto L41
                        boolean r6 = r6 instanceof com.urbanairship.android.layout.environment.LayoutEvent.PagerPrevious
                        if (r6 == 0) goto L4a
                    L41:
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L4a
                        return r1
                    L4a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.PagerModel$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super LayoutEvent> flowCollector, @NotNull Continuation continuation) {
                Object objCollect = layoutEvents.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass6(null)), getModelScope());
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001Bu\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R!\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/urbanairship/android/layout/model/PagerModel$Item;", "", "view", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "identifier", "", "displayActions", "", "Lcom/urbanairship/json/JsonValue;", "automatedActions", "", "Lcom/urbanairship/android/layout/property/AutomatedAction;", ViewProps.ACCESSIBILITY_ACTIONS, "Lcom/urbanairship/android/layout/info/AccessibilityAction;", "stateActions", "Lcom/urbanairship/android/layout/property/StateAction;", "branching", "Lcom/urbanairship/android/layout/property/PageBranching;", "(Lcom/urbanairship/android/layout/model/BaseModel;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/urbanairship/android/layout/property/PageBranching;)V", "getAccessibilityActions", "()Ljava/util/List;", "getAutomatedActions", "getBranching", "()Lcom/urbanairship/android/layout/property/PageBranching;", "getDisplayActions", "()Ljava/util/Map;", "getIdentifier", "()Ljava/lang/String;", "getStateActions", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Item {
        private final List accessibilityActions;
        private final List automatedActions;
        private final PageBranching branching;
        private final Map displayActions;
        private final String identifier;
        private final List stateActions;
        private final BaseModel view;

        public Item(@NotNull BaseModel<?, ?, ?> view, @NotNull String identifier, @Nullable Map<String, ? extends JsonValue> map, @Nullable List<AutomatedAction> list, @Nullable List<AccessibilityAction> list2, @Nullable List<? extends StateAction> list3, @Nullable PageBranching pageBranching) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.view = view;
            this.identifier = identifier;
            this.displayActions = map;
            this.automatedActions = list;
            this.accessibilityActions = list2;
            this.stateActions = list3;
            this.branching = pageBranching;
        }

        @NotNull
        public final BaseModel<?, ?, ?> getView() {
            return this.view;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final Map<String, JsonValue> getDisplayActions() {
            return this.displayActions;
        }

        @Nullable
        public final List<AutomatedAction> getAutomatedActions() {
            return this.automatedActions;
        }

        @Nullable
        public final List<AccessibilityAction> getAccessibilityActions() {
            return this.accessibilityActions;
        }

        @Nullable
        public final List<StateAction> getStateActions() {
            return this.stateActions;
        }

        @Nullable
        public final PageBranching getBranching() {
            return this.branching;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/PagerModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "onDataUpdated", "", "scrollTo", ViewProps.POSITION, "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void onDataUpdated();

        void scrollTo(int position);

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStateUpdated(@NotNull Listener listener, @NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Listener.super.onStateUpdated(state);
            }
        }
    }

    public final int getRecyclerViewId() {
        return this.recyclerViewId;
    }

    @NotNull
    public final List<BaseModel<?, ?, ?>> getPages() {
        return this.pages;
    }

    public final boolean isSinglePage() {
        return this.branchControl == null && this.pages.size() < 2;
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass1(Object obj) {
            super(1, obj, PagerModel.class, "onPagesDataUpdated", "onPagesDataUpdated(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(List p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PagerModel) this.receiver).onPagesDataUpdated(p0);
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends AdaptedFunctionReference implements Function1 {
        AnonymousClass2(Object obj) {
            super(1, obj, PagerModel.class, "runStateActions", "runStateActions(Ljava/util/List;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(List list) {
            BaseModel.runStateActions$default((PagerModel) this.receiver, list, null, 2, null);
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerModel.this.new AnonymousClass3(continuation);
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
                final StateFlow changes = PagerModel.this.pagerState.getChanges();
                Flow<State.Pager> flow = new Flow<State.Pager>() { // from class: com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1

                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 PagerModel.kt\ncom/urbanairship/android/layout/model/PagerModel$3\n*L\n1#1,218:1\n18#2:219\n19#2:221\n124#3:220\n*E\n"})
                    /* renamed from: com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1$2", f = "PagerModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                        /* renamed from: com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
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
                        public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                            /*
                                r5 = this;
                                boolean r0 = r7 instanceof com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r7
                                com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1$2$1
                                r0.<init>(r7)
                            L18:
                                java.lang.Object r7 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L5e
                            L29:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L31:
                                kotlin.ResultKt.throwOnFailure(r7)
                                kotlinx.coroutines.flow.FlowCollector r5 = r5.$this_unsafeFlow
                                r7 = r6
                                com.urbanairship.android.layout.environment.State$Pager r7 = (com.urbanairship.android.layout.environment.State.Pager) r7
                                int r2 = r7.getPageIndex()
                                if (r2 != 0) goto L45
                                int r2 = r7.getLastPageIndex()
                                if (r2 == 0) goto L4f
                            L45:
                                int r2 = r7.getPageIndex()
                                int r4 = r7.getLastPageIndex()
                                if (r2 == r4) goto L5e
                            L4f:
                                int r7 = r7.getProgress()
                                if (r7 != 0) goto L5e
                                r0.label = r3
                                java.lang.Object r5 = r5.emit(r6, r0)
                                if (r5 != r1) goto L5e
                                return r1
                            L5e:
                                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.PagerModel$3$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    @Nullable
                    public Object collect(@NotNull FlowCollector<? super State.Pager> flowCollector, @NotNull Continuation continuation) {
                        Object objCollect = changes.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(PagerModel.this);
                this.label = 1;
                if (flow.collect(anonymousClass2, this) == coroutine_suspended) {
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

        /* renamed from: com.urbanairship.android.layout.model.PagerModel$3$2, reason: invalid class name */
        static final class AnonymousClass2 implements FlowCollector {
            final /* synthetic */ PagerModel this$0;

            AnonymousClass2(PagerModel pagerModel) {
                this.this$0 = pagerModel;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(com.urbanairship.android.layout.environment.State.Pager r8, kotlin.coroutines.Continuation r9) {
                /*
                    Method dump skipped, instructions count: 309
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.PagerModel.AnonymousClass3.AnonymousClass2.emit(com.urbanairship.android.layout.environment.State$Pager, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$4, reason: invalid class name */
    static final class AnonymousClass4 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass4(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerModel.this.new AnonymousClass4(continuation);
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
                PagerModel pagerModel = PagerModel.this;
                this.label = 1;
                if (pagerModel.wireSwipeSelector(this) == coroutine_suspended) {
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

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2 {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass6(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass6 anonymousClass6 = PagerModel.this.new AnonymousClass6(continuation);
            anonymousClass6.L$0 = obj;
            return anonymousClass6;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LayoutEvent layoutEvent, Continuation continuation) {
            return ((AnonymousClass6) create(layoutEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            LayoutEvent layoutEvent = (LayoutEvent) this.L$0;
            if (layoutEvent instanceof LayoutEvent.PagerNext) {
                PagerModel.this.handlePagerNext(((LayoutEvent.PagerNext) layoutEvent).getFallback());
            } else if (layoutEvent instanceof LayoutEvent.PagerPrevious) {
                PagerModel.this.handlePagerPrevious();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPagesDataUpdated(final List updated) {
        this._allPages = updated;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(updated, 10));
        Iterator it = updated.iterator();
        while (it.hasNext()) {
            arrayList.add(((Item) it.next()).getView());
        }
        this.pages = arrayList;
        this.pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel.onPagesDataUpdated.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Pager invoke(State.Pager state) {
                boolean completed;
                boolean z;
                AutomatedAction earliestNavigationAction;
                Intrinsics.checkNotNullParameter(state, "state");
                List list = updated;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Item) it2.next()).getIdentifier());
                }
                List list2 = updated;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it3 = list2.iterator();
                while (it3.hasNext()) {
                    List<AutomatedAction> automatedActions = ((Item) it3.next()).getAutomatedActions();
                    arrayList3.add((automatedActions == null || (earliestNavigationAction = AutomatedActionKt.getEarliestNavigationAction(automatedActions)) == null) ? null : Integer.valueOf(earliestNavigationAction.getDelay()));
                }
                if (state.getBranching() != null) {
                    completed = state.getCompleted();
                } else {
                    if (updated.size() == 1) {
                        z = true;
                        return State.Pager.copy$default(state, null, 0, 0, z, arrayList2, arrayList3, 0, false, false, false, false, null, false, 8135, null);
                    }
                    completed = false;
                }
                z = completed;
                return State.Pager.copy$default(state, null, 0, 0, z, arrayList2, arrayList3, 0, false, false, false, false, null, false, 8135, null);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new C09413(null), 3, null);
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$onPagesDataUpdated$3, reason: invalid class name and case insensitive filesystem */
    static final class C09413 extends SuspendLambda implements Function2 {
        int label;

        C09413(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PagerModel.this.new C09413(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09413) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Listener listener = PagerModel.this.getListener();
            if (listener != null) {
                listener.onDataUpdated();
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.android.layout.model.PagerModel$wireBranchControlFlows$1, reason: invalid class name and case insensitive filesystem */
    static final class C09481 extends SuspendLambda implements Function2 {
        final /* synthetic */ PagerBranchControl $control;
        int label;
        final /* synthetic */ PagerModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09481(PagerBranchControl pagerBranchControl, PagerModel pagerModel, Continuation continuation) {
            super(2, continuation);
            this.$control = pagerBranchControl;
            this.this$0 = pagerModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09481(this.$control, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<Boolean> stateFlowIsComplete = this.$control.isComplete();
                final PagerModel pagerModel = this.this$0;
                FlowCollector<? super Boolean> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.model.PagerModel.wireBranchControlFlows.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), continuation);
                    }

                    public final Object emit(final boolean z, Continuation continuation) {
                        pagerModel.pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel.wireBranchControlFlows.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final State.Pager invoke(State.Pager it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return State.Pager.copy$default(it, null, 0, 0, z, null, null, 0, false, false, false, false, null, false, 8183, null);
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (stateFlowIsComplete.collect(flowCollector, this) == coroutine_suspended) {
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

    private final void wireBranchControlFlows(PagerBranchControl control) {
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new C09481(control, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object wireSwipeSelector(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.urbanairship.android.layout.model.PagerModel.C09491
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.android.layout.model.PagerModel$wireSwipeSelector$1 r0 = (com.urbanairship.android.layout.model.PagerModel.C09491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.layout.model.PagerModel$wireSwipeSelector$1 r0 = new com.urbanairship.android.layout.model.PagerModel$wireSwipeSelector$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5d
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.android.layout.info.View r6 = r5.getViewInfo()
            com.urbanairship.android.layout.info.PagerInfo r6 = (com.urbanairship.android.layout.info.PagerInfo) r6
            java.util.List r6 = r6.getDisableSwipeWhen()
            if (r6 != 0) goto L43
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L43:
            com.urbanairship.android.layout.environment.ModelEnvironment r2 = r5.getEnvironment()
            com.urbanairship.android.layout.environment.LayoutState r2 = r2.getLayoutState()
            kotlinx.coroutines.flow.StateFlow r2 = r2.getThomasState()
            com.urbanairship.android.layout.model.PagerModel$wireSwipeSelector$2 r4 = new com.urbanairship.android.layout.model.PagerModel$wireSwipeSelector$2
            r4.<init>()
            r0.label = r3
            java.lang.Object r5 = r2.collect(r4, r0)
            if (r5 != r1) goto L5d
            return r1
        L5d:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.PagerModel.wireSwipeSelector(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resolve(final PageRequest request) {
        this.pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel.resolve.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Pager invoke(State.Pager it) {
                PagerBranchControl pagerBranchControl;
                Intrinsics.checkNotNullParameter(it, "it");
                State.Pager pagerCopyWithPageRequest = it.copyWithPageRequest(request);
                if (pagerCopyWithPageRequest.getPageIndex() != it.getPageIndex() && (pagerBranchControl = this.branchControl) != null) {
                    pagerBranchControl.onPageRequest(request);
                }
                return pagerCopyWithPageRequest;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public PagerView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        PagerView pagerView = new PagerView(context, this, viewEnvironment);
        pagerView.setId(getViewId());
        return pagerView;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull PagerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new PagerModel$onViewAttached$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new PagerModel$onViewAttached$2(view, this, null), 3, null);
        if (getViewInfo().getGestures() != null) {
            BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new PagerModel$onViewAttached$3(view, this, null), 3, null);
        } else {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.android.layout.model.PagerModel$onViewAttached$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No gestures defined.";
                }
            }, 1, null);
        }
        Object systemService = view.getContext().getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        if (accessibilityManager != null) {
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.urbanairship.android.layout.model.PagerModel$$ExternalSyntheticLambda0
                @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
                public final void onTouchExplorationStateChanged(boolean z) {
                    PagerModel.onViewAttached$lambda$5$lambda$3(this.f$0, z);
                }
            };
            accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
            this.accessibilityListener = touchExplorationStateChangeListener;
            updateTouchExplorationState(accessibilityManager.isTouchExplorationEnabled());
        }
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new PagerModel$onViewAttached$6(this, view, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewAttached$lambda$5$lambda$3(PagerModel this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateTouchExplorationState(z);
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewDetached$urbanairship_layout_release(@NotNull PagerView view) {
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
        Intrinsics.checkNotNullParameter(view, "view");
        clearAutomatedActions$default(this, null, 1, null);
        Object systemService = view.getContext().getSystemService("accessibility");
        AccessibilityManager accessibilityManager = systemService instanceof AccessibilityManager ? (AccessibilityManager) systemService : null;
        if (accessibilityManager == null || (touchExplorationStateChangeListener = this.accessibilityListener) == null) {
            return;
        }
        accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
    }

    public final int getPageViewId(int position) {
        Map map = this.pageViewIds;
        Integer numValueOf = Integer.valueOf(position);
        Object objValueOf = map.get(numValueOf);
        if (objValueOf == null) {
            objValueOf = Integer.valueOf(View.generateViewId());
            map.put(numValueOf, objValueOf);
        }
        return ((Number) objValueOf).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PageRequest makePageRequest(int toPosition) {
        int pageIndex = ((State.Pager) this.pagerState.getChanges().getValue()).getPageIndex();
        if (toPosition > pageIndex) {
            return PageRequest.NEXT;
        }
        if (toPosition < pageIndex) {
            return PageRequest.BACK;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportPageSwipe(State.Pager pagerState) {
        String previousPageId;
        String currentPageId = pagerState.getCurrentPageId();
        if (currentPageId == null || (previousPageId = pagerState.getPreviousPageId()) == null) {
            return;
        }
        PagerData pagerDataReportingContext = pagerState.reportingContext(CollectionsKt.emptyList());
        report(new ReportingEvent.PageSwipe(new ReportingEvent.PageSwipeData(pagerDataReportingContext.getIdentifier(), pagerState.getPageIndex(), currentPageId, pagerState.getLastPageIndex(), previousPageId), LayoutState.reportingContext$default(getLayoutState(), null, pagerDataReportingContext, null, 5, null)));
    }

    private final void reportGesture(PagerGesture gesture, State.Pager pagerState) {
        report(new ReportingEvent.Gesture(new ReportingEvent.GestureData(gesture.getIdentifier(), gesture.getReportingMetadata()), LayoutState.reportingContext$default(getLayoutState(), null, pagerState.reportingContext(CollectionsKt.emptyList()), null, 5, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportAutomatedAction(AutomatedAction action, State.Pager pagerState) {
        report(new ReportingEvent.PageAction(new ReportingEvent.PageActionData(action.getIdentifier(), action.getReportingMetadata()), LayoutState.reportingContext$default(getLayoutState(), null, pagerState.reportingContext(CollectionsKt.emptyList()), null, 5, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAccessibilityAction(AccessibilityAction action, State.Pager pagerState) {
        List<ButtonClickBehaviorType> behaviors = action.getBehaviors();
        if (behaviors != null) {
            evaluateClickBehaviors(behaviors);
        }
        BaseModel.runActions$default(this, action.getActions(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.urbanairship.android.layout.model.PagerModel$handlePageActions$2$1$1, com.urbanairship.android.layout.util.Timer] */
    public final Object handlePageActions(Map map, List list, Continuation continuation) {
        BaseModel.runActions$default(this, map, null, 2, null);
        if (list != null) {
            final AutomatedAction earliestNavigationAction = AutomatedActionKt.getEarliestNavigationAction(list);
            if (earliestNavigationAction != null) {
                final long delay = earliestNavigationAction.getDelay() * 1000;
                ?? r3 = new Timer(delay) { // from class: com.urbanairship.android.layout.model.PagerModel$handlePageActions$2$1$1
                    @Override // com.urbanairship.android.layout.util.Timer
                    protected void onFinish() {
                        Job job = this.this$0.scheduledJob;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                        }
                        this.this$0.automatedActionsTimers.remove(this);
                        List<ButtonClickBehaviorType> behaviors = earliestNavigationAction.getBehaviors();
                        if (behaviors != null) {
                            this.this$0.evaluateClickBehaviors(behaviors);
                        }
                        Map<String, JsonValue> actions = earliestNavigationAction.getActions();
                        if (actions != null) {
                            BaseModel.runActions$default(this.this$0, actions, null, 2, null);
                        }
                        PagerModel pagerModel = this.this$0;
                        pagerModel.reportAutomatedAction(earliestNavigationAction, (State.Pager) pagerModel.pagerState.getChanges().getValue());
                    }
                };
                r3.start();
                this.scheduledJob = BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new PagerModel$handlePageActions$2$1$2$1(this, r3, null), 3, null);
                this.navigationActionTimer = r3;
            }
            ArrayList<AutomatedAction> arrayList = new ArrayList();
            for (Object obj : list) {
                if (!Intrinsics.areEqual((AutomatedAction) obj, AutomatedActionKt.getEarliestNavigationAction(list))) {
                    arrayList.add(obj);
                }
            }
            for (AutomatedAction automatedAction : arrayList) {
                if (automatedAction.getDelay() == 0) {
                    List<ButtonClickBehaviorType> behaviors = automatedAction.getBehaviors();
                    if (behaviors != null) {
                        evaluateClickBehaviors(behaviors);
                    }
                    Map<String, JsonValue> actions = automatedAction.getActions();
                    if (actions != null) {
                        BaseModel.runActions$default(this, actions, null, 2, null);
                    }
                    reportAutomatedAction(automatedAction, (State.Pager) this.pagerState.getChanges().getValue());
                } else {
                    scheduleAutomatedAction(automatedAction);
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void scheduleAutomatedAction(final AutomatedAction action) {
        final long delay = action.getDelay() * 1000;
        Timer timer = new Timer(delay) { // from class: com.urbanairship.android.layout.model.PagerModel$scheduleAutomatedAction$timer$1
            @Override // com.urbanairship.android.layout.util.Timer
            protected void onFinish() {
                this.this$0.automatedActionsTimers.remove(this);
                List<ButtonClickBehaviorType> behaviors = action.getBehaviors();
                if (behaviors != null) {
                    this.this$0.evaluateClickBehaviors(behaviors);
                }
                Map<String, JsonValue> actions = action.getActions();
                if (actions != null) {
                    BaseModel.runActions$default(this.this$0, actions, null, 2, null);
                }
                PagerModel pagerModel = this.this$0;
                pagerModel.reportAutomatedAction(action, (State.Pager) pagerModel.pagerState.getChanges().getValue());
            }
        };
        this.automatedActionsTimers.add(timer);
        timer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleGesture(final PagerGestureEvent event) {
        ArrayList<Pair> arrayList;
        PagerGestureBehavior pressBehavior;
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.android.layout.model.PagerModel.handleGesture.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "handleGesture: " + event;
            }
        }, 1, null);
        if (!(event instanceof PagerGestureEvent.Tap)) {
            if (!(event instanceof PagerGestureEvent.Swipe)) {
                if (event instanceof PagerGestureEvent.Hold) {
                    List<PagerGesture> gestures = getViewInfo().getGestures();
                    if (gestures == null) {
                        gestures = CollectionsKt.emptyList();
                    }
                    ArrayList<PagerGesture.Hold> arrayList2 = new ArrayList();
                    for (Object obj : gestures) {
                        if (obj instanceof PagerGesture.Hold) {
                            arrayList2.add(obj);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (PagerGesture.Hold hold : arrayList2) {
                        int i = WhenMappings.$EnumSwitchMapping$0[((PagerGestureEvent.Hold) event).getAction().ordinal()];
                        if (i == 1) {
                            pressBehavior = hold.getPressBehavior();
                        } else {
                            if (i != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            pressBehavior = hold.getReleaseBehavior();
                        }
                        arrayList3.add(TuplesKt.to(hold, pressBehavior));
                    }
                    arrayList = arrayList3;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                List<PagerGesture> gestures2 = getViewInfo().getGestures();
                if (gestures2 == null) {
                    gestures2 = CollectionsKt.emptyList();
                }
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : gestures2) {
                    if (obj2 instanceof PagerGesture.Swipe) {
                        arrayList4.add(obj2);
                    }
                }
                ArrayList<PagerGesture.Swipe> arrayList5 = new ArrayList();
                for (Object obj3 : arrayList4) {
                    if (((PagerGesture.Swipe) obj3).getDirection() == ((PagerGestureEvent.Swipe) event).getDirection()) {
                        arrayList5.add(obj3);
                    }
                }
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                for (PagerGesture.Swipe swipe : arrayList5) {
                    arrayList.add(TuplesKt.to(swipe, swipe.getBehavior()));
                }
            }
        } else {
            List<PagerGesture> gestures3 = getViewInfo().getGestures();
            if (gestures3 == null) {
                gestures3 = CollectionsKt.emptyList();
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj4 : gestures3) {
                if (obj4 instanceof PagerGesture.Tap) {
                    arrayList6.add(obj4);
                }
            }
            ArrayList<PagerGesture.Tap> arrayList7 = new ArrayList();
            for (Object obj5 : arrayList6) {
                PagerGesture.Tap tap = (PagerGesture.Tap) obj5;
                if (tap.getLocation() == ((PagerGestureEvent.Tap) event).getLocation() || tap.getLocation() == GestureLocation.ANY) {
                    arrayList7.add(obj5);
                }
            }
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
            for (PagerGesture.Tap tap2 : arrayList7) {
                arrayList.add(TuplesKt.to(tap2, tap2.getBehavior()));
            }
        }
        for (Pair pair : arrayList) {
            PagerGesture pagerGesture = (PagerGesture) pair.component1();
            PagerGestureBehavior pagerGestureBehavior = (PagerGestureBehavior) pair.component2();
            Map<String, JsonValue> actions = pagerGestureBehavior.getActions();
            if (actions != null) {
                BaseModel.runActions$default(this, actions, null, 2, null);
            }
            List<ButtonClickBehaviorType> behaviors = pagerGestureBehavior.getBehaviors();
            if (behaviors != null) {
                evaluateClickBehaviors(behaviors);
            }
            reportGesture(pagerGesture, (State.Pager) this.pagerState.getChanges().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void evaluateClickBehaviors(List behaviors) {
        if (ButtonClickBehaviorTypeKt.getHasCancelOrDismiss(behaviors)) {
            handleDismiss();
            return;
        }
        if (ButtonClickBehaviorTypeKt.getHasPagerNext(behaviors)) {
            handlePagerNext(PagerModelKt.getPagerNextFallback(behaviors));
        }
        if (ButtonClickBehaviorTypeKt.getHasPagerPrevious(behaviors)) {
            handlePagerPrevious();
        }
        if (ButtonClickBehaviorTypeKt.getHasPagerPause(behaviors)) {
            pauseStory();
        }
        if (ButtonClickBehaviorTypeKt.getHasPagerResume(behaviors)) {
            resumeStory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePagerNext(PagerNextFallback fallback) {
        if (((State.Pager) this.pagerState.getValue()).getHasNext()) {
            resolve(PageRequest.NEXT);
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[fallback.ordinal()];
        if (i == 2) {
            handleDismiss();
        } else {
            if (i != 3) {
                return;
            }
            resolve(PageRequest.FIRST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePagerPrevious() {
        resolve(PageRequest.BACK);
    }

    private final void handleDismiss() {
        clearAutomatedActions$default(this, null, 1, null);
        ReportingEvent.DismissData.UserDismissed userDismissed = ReportingEvent.DismissData.UserDismissed.INSTANCE;
        Duration.Companion companion = Duration.INSTANCE;
        report(new ReportingEvent.Dismiss(userDismissed, DurationKt.toDuration(getEnvironment().getDisplayTimer().getTime(), DurationUnit.MILLISECONDS), LayoutState.reportingContext$default(getLayoutState(), null, null, null, 7, null), null));
        broadcast(LayoutEvent.Finish.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pauseStory() {
        Timer timer = this.navigationActionTimer;
        if ((timer != null && timer.isStarted()) || !this.automatedActionsTimers.isEmpty()) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.android.layout.model.PagerModel.pauseStory.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "pause story";
                }
            }, 1, null);
        }
        Timer timer2 = this.navigationActionTimer;
        if (timer2 != null) {
            timer2.stop();
        }
        Iterator it = this.automatedActionsTimers.iterator();
        while (it.hasNext()) {
            ((Timer) it.next()).stop();
        }
        this.pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel.pauseStory.2
            @Override // kotlin.jvm.functions.Function1
            public final State.Pager invoke(State.Pager it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return it2.copyWithStoryPaused(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resumeStory() {
        Timer timer = this.navigationActionTimer;
        if ((timer != null && !timer.isStarted()) || !this.automatedActionsTimers.isEmpty()) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.android.layout.model.PagerModel.resumeStory.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "resume story";
                }
            }, 1, null);
        }
        Timer timer2 = this.navigationActionTimer;
        if (timer2 != null) {
            timer2.start();
        }
        Iterator it = this.automatedActionsTimers.iterator();
        while (it.hasNext()) {
            ((Timer) it.next()).start();
        }
        this.pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel.resumeStory.2
            @Override // kotlin.jvm.functions.Function1
            public final State.Pager invoke(State.Pager it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return it2.copyWithStoryPaused(false);
            }
        });
    }

    static /* synthetic */ void clearAutomatedActions$default(PagerModel pagerModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        pagerModel.clearAutomatedActions(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearAutomatedActions(final Integer pageIndex) {
        Timer timer = this.navigationActionTimer;
        if (timer != null) {
            timer.stop();
        }
        Job job = this.scheduledJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Iterator it = this.automatedActionsTimers.iterator();
        while (it.hasNext()) {
            ((Timer) it.next()).stop();
        }
        if (!this.automatedActionsTimers.isEmpty()) {
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.android.layout.model.PagerModel.clearAutomatedActions.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    if (pageIndex != null) {
                        return "Cleared all automated actions! For page: '" + pageIndex + CoreConstants.SINGLE_QUOTE_CHAR;
                    }
                    return "Cleared all automated actions! For pager: '" + ((State.Pager) this.pagerState.getValue()).getIdentifier() + CoreConstants.SINGLE_QUOTE_CHAR;
                }
            }, 1, null);
        }
        this.automatedActionsTimers.clear();
    }

    private final void updateTouchExplorationState(final boolean enabled) {
        this.pagerState.update(new Function1() { // from class: com.urbanairship.android.layout.model.PagerModel.updateTouchExplorationState.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final State.Pager invoke(State.Pager it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.copyWithTouchExplorationState(enabled);
            }
        });
        if (enabled) {
            pauseStory();
        } else {
            resumeStory();
        }
    }
}
