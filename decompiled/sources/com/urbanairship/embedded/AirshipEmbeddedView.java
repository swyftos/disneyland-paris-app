package com.urbanairship.embedded;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.AnimatorRes;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.UALog;
import com.urbanairship.android.layout.AirshipEmbeddedViewManager;
import com.urbanairship.android.layout.EmbeddedDisplayRequest;
import com.urbanairship.android.layout.EmbeddedDisplayRequestResult;
import com.urbanairship.android.layout.display.DisplayArgs;
import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.property.EmbeddedPlacement;
import com.urbanairship.android.layout.ui.EmbeddedLayout;
import com.urbanairship.automation.R;
import java.util.Comparator;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bBA\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010B[\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0014J\b\u00105\u001a\u000203H\u0014J\u0012\u00106\u001a\u0002032\b\u00107\u001a\u0004\u0018\u000108H\u0002J#\u00109\u001a\u0002032\n\b\u0001\u0010:\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010<RL\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0019@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R4\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010#@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0012\u0010,\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/urbanairship/embedded/AirshipEmbeddedView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "embeddedId", "", "comparator", "Ljava/util/Comparator;", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "Lkotlin/Comparator;", "placeholderRes", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Comparator;Ljava/lang/Integer;)V", "manager", "Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/lang/String;Ljava/lang/Integer;Ljava/util/Comparator;Lcom/urbanairship/android/layout/AirshipEmbeddedViewManager;)V", "value", "getComparator", "()Ljava/util/Comparator;", "setComparator", "(Ljava/util/Comparator;)V", "Lkotlinx/coroutines/Job;", "displayRequestsJob", "setDisplayRequestsJob", "(Lkotlinx/coroutines/Job;)V", "id", "logTag", "getLogTag", "()Ljava/lang/String;", "logTag$delegate", "Lkotlin/Lazy;", "Lkotlin/Function0;", "parentHeightProvider", "getParentHeightProvider", "()Lkotlin/jvm/functions/Function0;", "setParentHeightProvider", "(Lkotlin/jvm/functions/Function0;)V", "parentWidthProvider", "getParentWidthProvider", "setParentWidthProvider", "placeholderLayoutRes", "Ljava/lang/Integer;", "viewJob", "Lkotlinx/coroutines/CompletableJob;", "viewScope", "Lkotlinx/coroutines/CoroutineScope;", "collectDisplayRequests", "", "onAttachedToWindow", "onDetachedFromWindow", "onUpdate", "request", "Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;", "setAnimations", "inAnimation", "outAnimation", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAirshipEmbeddedView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirshipEmbeddedView.kt\ncom/urbanairship/embedded/AirshipEmbeddedView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
/* loaded from: classes5.dex */
public final class AirshipEmbeddedView extends RelativeLayout {
    private Comparator comparator;
    private Job displayRequestsJob;
    private final String id;

    /* renamed from: logTag$delegate, reason: from kotlin metadata */
    private final Lazy logTag;
    private final AirshipEmbeddedViewManager manager;
    private Function0 parentHeightProvider;
    private Function0 parentWidthProvider;
    private final Integer placeholderLayoutRes;
    private final CompletableJob viewJob;
    private final CoroutineScope viewScope;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipEmbeddedView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipEmbeddedView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipEmbeddedView(@NotNull Context context, @NotNull String embeddedId) {
        this(context, embeddedId, null, null, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(embeddedId, "embeddedId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipEmbeddedView(@NotNull Context context, @NotNull String embeddedId, @Nullable Comparator<AirshipEmbeddedInfo> comparator) {
        this(context, embeddedId, comparator, null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(embeddedId, "embeddedId");
    }

    private AirshipEmbeddedView(Context context, AttributeSet attributeSet, int i, String str, Integer num, Comparator comparator, AirshipEmbeddedViewManager airshipEmbeddedViewManager) {
        super(context, attributeSet, i);
        this.manager = airshipEmbeddedViewManager;
        this.comparator = comparator;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.viewJob = completableJobSupervisorJob$default;
        this.viewScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(completableJobSupervisorJob$default));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AirshipEmbeddedView, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        if (str == null) {
            str = typedArrayObtainStyledAttributes.getString(R.styleable.AirshipEmbeddedView_airshipEmbeddedId);
            if (str == null) {
                throw new IllegalArgumentException("AirshipEmbeddedView requires a layout_id!");
            }
            Intrinsics.checkNotNullExpressionValue(str, "requireNotNull(...)");
        }
        this.id = str;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AirshipEmbeddedView_airshipPlaceholder, num != null ? num.intValue() : 0);
        this.placeholderLayoutRes = resourceId != 0 ? Integer.valueOf(resourceId) : null;
        setAnimations(Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.AirshipEmbeddedView_airshipInAnimation, 0)), Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(R.styleable.AirshipEmbeddedView_airshipOutAnimation, 0)));
        typedArrayObtainStyledAttributes.recycle();
        this.logTag = LazyKt.lazy(new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView$logTag$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "(embeddedId: '" + this.this$0.id + "')";
            }
        });
    }

    public /* synthetic */ AirshipEmbeddedView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipEmbeddedView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, null, null, EmbeddedViewManager.INSTANCE);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AirshipEmbeddedView(Context context, String str, Comparator comparator, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : comparator, (i & 8) != 0 ? null : num);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AirshipEmbeddedView(@NotNull Context context, @NotNull String embeddedId, @Nullable Comparator<AirshipEmbeddedInfo> comparator, @LayoutRes @Nullable Integer num) {
        this(context, null, 0, embeddedId, num, comparator, EmbeddedViewManager.INSTANCE);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(embeddedId, "embeddedId");
    }

    @Nullable
    public final Function0<Integer> getParentWidthProvider() {
        return this.parentWidthProvider;
    }

    public final void setParentWidthProvider(@Nullable Function0<Integer> function0) {
        this.parentWidthProvider = function0;
        requestLayout();
        invalidate();
    }

    @Nullable
    public final Function0<Integer> getParentHeightProvider() {
        return this.parentHeightProvider;
    }

    public final void setParentHeightProvider(@Nullable Function0<Integer> function0) {
        this.parentHeightProvider = function0;
        requestLayout();
        invalidate();
    }

    @Nullable
    public final Comparator<AirshipEmbeddedInfo> getComparator() {
        return this.comparator;
    }

    public final void setComparator(@Nullable Comparator<AirshipEmbeddedInfo> comparator) {
        this.comparator = comparator;
        if (isAttachedToWindow()) {
            collectDisplayRequests();
        }
    }

    private final void setDisplayRequestsJob(Job job) {
        Job job2 = this.displayRequestsJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.displayRequestsJob = job;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTag() {
        return (String) this.logTag.getValue();
    }

    public final void setAnimations(@AnimatorRes @Nullable Integer inAnimation, @AnimatorRes @Nullable Integer outAnimation) {
        Animator animatorLoadAnimator;
        int iIntValue;
        LayoutTransition layoutTransition = null;
        if (inAnimation != null) {
            try {
                int iIntValue2 = inAnimation.intValue();
                animatorLoadAnimator = iIntValue2 == 0 ? null : AnimatorInflater.loadAnimator(getContext(), iIntValue2);
            } catch (Exception e) {
                UALog.e(e, new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView.setAnimations.3
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to load embedded view animations!";
                    }
                });
                return;
            }
        }
        Pair pair = new Pair(animatorLoadAnimator, (outAnimation == null || (iIntValue = outAnimation.intValue()) == 0) ? null : AnimatorInflater.loadAnimator(getContext(), iIntValue));
        Animator animator = (Animator) pair.component1();
        Animator animator2 = (Animator) pair.component2();
        if (animator != null || animator2 != null) {
            layoutTransition = new LayoutTransition();
            layoutTransition.setAnimator(2, animator);
            layoutTransition.setAnimator(3, animator2);
        }
        setLayoutTransition(layoutTransition);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView.onAttachedToWindow.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onAttachedToWindow " + AirshipEmbeddedView.this.getLogTag();
            }
        }, 1, null);
        collectDisplayRequests();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView.onDetachedFromWindow.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onDetachedFromWindow " + AirshipEmbeddedView.this.getLogTag();
            }
        }, 1, null);
        JobKt__JobKt.cancelChildren$default((Job) this.viewJob, (CancellationException) null, 1, (Object) null);
    }

    /* renamed from: com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return AirshipEmbeddedView.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v11 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final Flow<EmbeddedDisplayRequestResult> flowDisplayRequests = AirshipEmbeddedView.this.manager.displayRequests(AirshipEmbeddedView.this.id, AirshipEmbeddedView.this.getComparator(), AirshipEmbeddedView.this.viewScope);
                    Flow<EmbeddedDisplayRequest> flow = new Flow<EmbeddedDisplayRequest>() { // from class: com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1

                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
                        @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 AirshipEmbeddedView.kt\ncom/urbanairship/embedded/AirshipEmbeddedView$collectDisplayRequests$1\n*L\n1#1,218:1\n50#2:219\n223#3:220\n*E\n"})
                        /* renamed from: com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1$2", f = "AirshipEmbeddedView.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                            @SourceDebugExtension({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,218:1\n*E\n"})
                            /* renamed from: com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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
                                    boolean r0 = r6 instanceof com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                    if (r0 == 0) goto L13
                                    r0 = r6
                                    com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                    int r1 = r0.label
                                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                    r3 = r1 & r2
                                    if (r3 == 0) goto L13
                                    int r1 = r1 - r2
                                    r0.label = r1
                                    goto L18
                                L13:
                                    com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1$2$1
                                    r0.<init>(r6)
                                L18:
                                    java.lang.Object r6 = r0.result
                                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r2 = r0.label
                                    r3 = 1
                                    if (r2 == 0) goto L31
                                    if (r2 != r3) goto L29
                                    kotlin.ResultKt.throwOnFailure(r6)
                                    goto L45
                                L29:
                                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                    r4.<init>(r5)
                                    throw r4
                                L31:
                                    kotlin.ResultKt.throwOnFailure(r6)
                                    kotlinx.coroutines.flow.FlowCollector r4 = r4.$this_unsafeFlow
                                    com.urbanairship.android.layout.EmbeddedDisplayRequestResult r5 = (com.urbanairship.android.layout.EmbeddedDisplayRequestResult) r5
                                    com.urbanairship.android.layout.EmbeddedDisplayRequest r5 = r5.getNext()
                                    r0.label = r3
                                    java.lang.Object r4 = r4.emit(r5, r0)
                                    if (r4 != r1) goto L45
                                    return r1
                                L45:
                                    kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                    return r4
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        @Nullable
                        public Object collect(@NotNull FlowCollector<? super EmbeddedDisplayRequest> flowCollector, @NotNull Continuation continuation) {
                            Object objCollect = flowDisplayRequests.collect(new AnonymousClass2(flowCollector), continuation);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }
                    };
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(AirshipEmbeddedView.this);
                    this.label = 1;
                    Object objCollect = flow.collect(anonymousClass2, this);
                    this = objCollect;
                    if (objCollect == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this = this;
                }
            } catch (CancellationException unused) {
                final AirshipEmbeddedView airshipEmbeddedView = AirshipEmbeddedView.this;
                UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView.collectDisplayRequests.1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Stopped collecting display requests for " + airshipEmbeddedView.getLogTag();
                    }
                }, 1, null);
            } catch (Exception e) {
                final AirshipEmbeddedView airshipEmbeddedView2 = AirshipEmbeddedView.this;
                UALog.e(e, (Function0<String>) new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView.collectDisplayRequests.1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Failed to collect display requests for " + airshipEmbeddedView2.getLogTag();
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* renamed from: com.urbanairship.embedded.AirshipEmbeddedView$collectDisplayRequests$1$2, reason: invalid class name */
        /* synthetic */ class AnonymousClass2 implements FlowCollector, FunctionAdapter {
            final /* synthetic */ AirshipEmbeddedView $tmp0;

            AnonymousClass2(AirshipEmbeddedView airshipEmbeddedView) {
                this.$tmp0 = airshipEmbeddedView;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                    return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
                }
                return false;
            }

            @Override // kotlin.jvm.internal.FunctionAdapter
            public final Function getFunctionDelegate() {
                return new AdaptedFunctionReference(2, this.$tmp0, AirshipEmbeddedView.class, "onUpdate", "onUpdate(Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;)V", 4);
            }

            public final int hashCode() {
                return getFunctionDelegate().hashCode();
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(EmbeddedDisplayRequest embeddedDisplayRequest, Continuation continuation) {
                Object objInvokeSuspend$onUpdate = AnonymousClass1.invokeSuspend$onUpdate(this.$tmp0, embeddedDisplayRequest, continuation);
                return objInvokeSuspend$onUpdate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvokeSuspend$onUpdate : Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ Object invokeSuspend$onUpdate(AirshipEmbeddedView airshipEmbeddedView, EmbeddedDisplayRequest embeddedDisplayRequest, Continuation continuation) {
            airshipEmbeddedView.onUpdate(embeddedDisplayRequest);
            return Unit.INSTANCE;
        }
    }

    private final void collectDisplayRequests() {
        setDisplayRequestsJob(BuildersKt__Builders_commonKt.launch$default(this.viewScope, null, null, new AnonymousClass1(null), 3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUpdate(EmbeddedDisplayRequest request) {
        final EmbeddedLayout embeddedLayout;
        ConstrainedSize size;
        EmbeddedSize embeddedSize;
        Function0<DisplayArgs> displayArgsProvider;
        DisplayArgs displayArgsInvoke = (request == null || (displayArgsProvider = request.getDisplayArgsProvider()) == null) ? null : displayArgsProvider.invoke();
        if (displayArgsInvoke != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            embeddedLayout = new EmbeddedLayout(context, this.id, request.getViewInstanceId(), displayArgsInvoke, this.manager);
        } else {
            embeddedLayout = null;
        }
        UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView.onUpdate.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onUpdate: " + (embeddedLayout != null ? "available" : "empty") + ' ' + this.getLogTag();
            }
        }, 1, null);
        removeAllViews();
        if (embeddedLayout != null) {
            EmbeddedPlacement placement = embeddedLayout.getPlacement();
            if (placement == null || (size = placement.getSize()) == null || (embeddedSize = AirshipEmbeddedViewKt.toEmbeddedSize(size, this.parentWidthProvider, this.parentHeightProvider)) == null) {
                return;
            }
            EmbeddedDimension embeddedDimensionComponent1 = embeddedSize.component1();
            EmbeddedDimension embeddedDimensionComponent2 = embeddedSize.component2();
            View orCreateView = embeddedLayout.getOrCreateView(embeddedDimensionComponent1.getFill(), embeddedDimensionComponent2.getFill());
            if (orCreateView != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(embeddedDimensionComponent1.getSpec(), embeddedDimensionComponent2.getSpec());
                setGravity(17);
                orCreateView.setLayoutParams(layoutParams);
                addView(orCreateView);
                UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView.onUpdate.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onUpdate: displayed content " + AirshipEmbeddedView.this.getLogTag();
                    }
                }, 1, null);
                return;
            }
            return;
        }
        Integer num = this.placeholderLayoutRes;
        if (num != null) {
            addView(LayoutInflater.from(getContext()).inflate(num.intValue(), (ViewGroup) this, false));
            UALog.v$default(null, new Function0() { // from class: com.urbanairship.embedded.AirshipEmbeddedView$onUpdate$3$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "onUpdate: displayed placeholder " + this.this$0.getLogTag();
                }
            }, 1, null);
        }
    }
}
