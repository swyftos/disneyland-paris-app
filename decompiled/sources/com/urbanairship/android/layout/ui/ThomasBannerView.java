package com.urbanairship.android.layout.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AnimatorRes;
import androidx.annotation.CallSuper;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.widget.ViewDragHelper;
import com.dlp.BluetoothManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.BannerPresentation;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.BannerPlacement;
import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.property.Position;
import com.urbanairship.android.layout.property.VerticalPosition;
import com.urbanairship.android.layout.util.ConstraintSetBuilder;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.util.Timer;
import com.urbanairship.android.layout.widget.ConstrainedFrameLayout;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 C2\u00020\u0001:\u0003CDEB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0002J\u0018\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0018H\u0007J\u0006\u00104\u001a\u00020/J\u0010\u00105\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020/H\u0007J\b\u0010=\u001a\u00020/H\u0007J\u0010\u0010>\u001a\u00020\u00182\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010?\u001a\u00020/H\u0003J\u001a\u0010@\u001a\u00020/2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\rJ\u0010\u0010A\u001a\u00020/2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010B\u001a\u00020/2\u0006\u0010%\u001a\u00020&R\u0012\u0010\f\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R$\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#¨\u0006F"}, d2 = {"Lcom/urbanairship/android/layout/ui/ThomasBannerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "presentation", "Lcom/urbanairship/android/layout/BannerPresentation;", "environment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/BannerPresentation;Lcom/urbanairship/android/layout/environment/ViewEnvironment;)V", "animationIn", "", "animationOut", "bannerFrame", "Lcom/urbanairship/android/layout/widget/ConstrainedFrameLayout;", "displayTimer", "Lcom/urbanairship/android/layout/util/Timer;", "getDisplayTimer", "()Lcom/urbanairship/android/layout/util/Timer;", "dragHelper", "Landroidx/customview/widget/ViewDragHelper;", "isDismissed", "", "<set-?>", "isResumed", "()Z", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/android/layout/ui/ThomasBannerView$Listener;", "minFlingVelocity", "", "getMinFlingVelocity", "()F", "setMinFlingVelocity", "(F)V", "overDragAmount", "placement", "Lcom/urbanairship/android/layout/property/VerticalPosition;", "value", "xFraction", "getXFraction", "setXFraction", "yFraction", "getYFraction", "setYFraction", "computeScroll", "", "configureBanner", "dismiss", "animate", "isInternal", "dismissAnimated", "initDragHelper", "makeFrame", TCEventPropertiesNames.TCP_SIZE, "Lcom/urbanairship/android/layout/property/ConstrainedSize;", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onPause", "onResume", "onTouchEvent", "removeSelf", "setAnimations", "setListener", "setPlacement", "Companion", "Listener", "ViewDragCallback", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThomasBannerView extends ConstraintLayout {
    private int animationIn;
    private int animationOut;
    private ConstrainedFrameLayout bannerFrame;
    private final Timer displayTimer;
    private ViewDragHelper dragHelper;
    private final ViewEnvironment environment;
    private boolean isDismissed;
    private boolean isResumed;
    private Listener listener;
    private float minFlingVelocity;
    private final BaseModel model;
    private float overDragAmount;
    private VerticalPosition placement;
    private final BannerPresentation presentation;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H'¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/ui/ThomasBannerView$Listener;", "", "onDismissed", "", "onDragStateChanged", BluetoothManager.BLE_STATUS_PARAM, "", "onTimedOut", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onDismissed();

        void onDragStateChanged(int state);

        @MainThread
        void onTimedOut();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThomasBannerView(@NotNull Context context, @NotNull BaseModel<?, ?, ?> model, @NotNull BannerPresentation presentation, @NotNull ViewEnvironment environment) throws Resources.NotFoundException {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.model = model;
        this.presentation = presentation;
        this.environment = environment;
        this.placement = VerticalPosition.BOTTOM;
        this.displayTimer = new Timer(presentation.getDurationMs()) { // from class: com.urbanairship.android.layout.ui.ThomasBannerView.1
            @Override // com.urbanairship.android.layout.util.Timer
            protected void onFinish() throws Resources.NotFoundException {
                Listener listener = ThomasBannerView.this.listener;
                if (listener != null) {
                    listener.onTimedOut();
                }
                ThomasBannerView.this.dismissAnimated();
            }
        };
        initDragHelper(context);
        setId(model.getViewId());
        configureBanner();
        onResume();
    }

    public final float getMinFlingVelocity() {
        return this.minFlingVelocity;
    }

    public final void setMinFlingVelocity(float f) {
        this.minFlingVelocity = f;
    }

    @NotNull
    public final Timer getDisplayTimer() {
        return this.displayTimer;
    }

    /* renamed from: isResumed, reason: from getter */
    public final boolean getIsResumed() {
        return this.isResumed;
    }

    private final void initDragHelper(Context context) {
        if (isInEditMode()) {
            return;
        }
        this.dragHelper = ViewDragHelper.create(this, new ViewDragCallback());
        this.minFlingVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.overDragAmount = TypedValue.applyDimension(1, 24.0f, context.getResources().getDisplayMetrics());
    }

    private final void configureBanner() throws Resources.NotFoundException {
        BannerPlacement resolvedPlacement = this.presentation.getResolvedPlacement(getContext());
        Intrinsics.checkNotNullExpressionValue(resolvedPlacement, "getResolvedPlacement(...)");
        ConstrainedSize size = resolvedPlacement.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "getSize(...)");
        Position position = resolvedPlacement.getPosition();
        Margin margin = resolvedPlacement.getMargin();
        ConstrainedFrameLayout constrainedFrameLayoutMakeFrame = makeFrame(size);
        BaseModel baseModel = this.model;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        constrainedFrameLayoutMakeFrame.addView(baseModel.createView(context, this.environment, null));
        addView(constrainedFrameLayoutMakeFrame);
        LayoutUtils.applyBorderAndBackground(constrainedFrameLayoutMakeFrame, null, resolvedPlacement.getBorder(), resolvedPlacement.getBackgroundColor());
        int id = constrainedFrameLayoutMakeFrame.getId();
        ConstraintSetBuilder.newBuilder(getContext()).position(position, id).size(size, id).margin(margin, id).build().applyTo(this);
        if (this.environment.getIsIgnoringSafeAreas()) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ViewCompat.setOnApplyWindowInsetsListener(constrainedFrameLayoutMakeFrame, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.layout.ui.ThomasBannerView$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return ThomasBannerView.configureBanner$lambda$0(objectRef, view, windowInsetsCompat);
                }
            });
        }
        if (this.animationIn != 0) {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), this.animationIn);
            animatorLoadAnimator.setTarget(this.bannerFrame);
            animatorLoadAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final WindowInsetsCompat configureBanner$lambda$0(Ref.ObjectRef lastAppliedInset, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(lastAppliedInset, "$lastAppliedInset");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (Intrinsics.areEqual(lastAppliedInset.element, insets)) {
            return insets;
        }
        lastAppliedInset.element = insets;
        return ViewCompat.dispatchApplyWindowInsets(v, insets);
    }

    private final ConstrainedFrameLayout makeFrame(ConstrainedSize size) {
        ConstrainedFrameLayout constrainedFrameLayout = new ConstrainedFrameLayout(getContext(), size);
        constrainedFrameLayout.setId(View.generateViewId());
        constrainedFrameLayout.setLayoutParams(new ConstraintLayout.LayoutParams(0, 0));
        constrainedFrameLayout.setElevation(ResourceUtils.dpToPx(constrainedFrameLayout.getContext(), 16));
        this.bannerFrame = constrainedFrameLayout;
        return constrainedFrameLayout;
    }

    @CallSuper
    @MainThread
    public final void onResume() {
        this.isResumed = true;
        if (this.isDismissed) {
            return;
        }
        this.displayTimer.start();
    }

    @CallSuper
    @MainThread
    public final void onPause() {
        this.isResumed = false;
        this.displayTimer.stop();
    }

    public final void dismissAnimated() throws Resources.NotFoundException {
        dismiss(true, false);
    }

    @MainThread
    public final void dismiss(boolean animate, final boolean isInternal) throws Resources.NotFoundException {
        Listener listener;
        this.isDismissed = true;
        this.displayTimer.stop();
        if (animate && this.bannerFrame != null && this.animationOut != 0) {
            clearAnimation();
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), this.animationOut);
            animatorLoadAnimator.setTarget(this.bannerFrame);
            animatorLoadAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.urbanairship.android.layout.ui.ThomasBannerView.dismiss.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(@NotNull Animator animation) {
                    Listener listener2;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    ThomasBannerView.this.removeSelf();
                    if (isInternal || (listener2 = ThomasBannerView.this.listener) == null) {
                        return;
                    }
                    listener2.onDismissed();
                }
            });
            animatorLoadAnimator.start();
            return;
        }
        removeSelf();
        if (isInternal || (listener = this.listener) == null) {
            return;
        }
        listener.onDismissed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSelf() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.bannerFrame = null;
        }
    }

    public final void setAnimations(@AnimatorRes int animationIn, @AnimatorRes int animationOut) {
        this.animationIn = animationIn;
        this.animationOut = animationOut;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    @Keep
    public final float getYFraction() {
        int height = getHeight();
        return height == 0 ? BitmapDescriptorFactory.HUE_RED : getTranslationY() / height;
    }

    @Keep
    public final void setYFraction(final float f) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.urbanairship.android.layout.ui.ThomasBannerView$yFraction$preDrawListener$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    this.this$0.setYFraction(f);
                    this.this$0.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
        } else {
            setTranslationY(f * getHeight());
        }
    }

    @Keep
    public final float getXFraction() {
        int width = getWidth();
        return width == 0 ? BitmapDescriptorFactory.HUE_RED : getTranslationX() / width;
    }

    @Keep
    public final void setXFraction(final float f) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.urbanairship.android.layout.ui.ThomasBannerView$xFraction$preDrawListener$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    this.this$0.setXFraction(f);
                    this.this$0.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
        } else {
            setTranslationX(f * getWidth());
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
            return;
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        View viewFindTopChildUnder;
        Intrinsics.checkNotNullParameter(event, "event");
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper == null) {
            return false;
        }
        if (viewDragHelper.shouldInterceptTouchEvent(event) || super.onInterceptTouchEvent(event)) {
            return true;
        }
        if (viewDragHelper.getViewDragState() != 0 || event.getActionMasked() != 2 || !viewDragHelper.checkTouchSlop(2) || (viewFindTopChildUnder = viewDragHelper.findTopChildUnder((int) event.getX(), (int) event.getY())) == null || viewFindTopChildUnder.canScrollVertically(viewDragHelper.getTouchSlop())) {
            return false;
        }
        viewDragHelper.captureChildView(viewFindTopChildUnder, event.getPointerId(0));
        return viewDragHelper.getViewDragState() == 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        View viewFindTopChildUnder;
        Intrinsics.checkNotNullParameter(event, "event");
        ViewDragHelper viewDragHelper = this.dragHelper;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(event);
        if (viewDragHelper.getCapturedView() == null && event.getActionMasked() == 2 && viewDragHelper.checkTouchSlop(2) && (viewFindTopChildUnder = viewDragHelper.findTopChildUnder((int) event.getX(), (int) event.getY())) != null && !viewFindTopChildUnder.canScrollVertically(viewDragHelper.getTouchSlop())) {
            viewDragHelper.captureChildView(viewFindTopChildUnder, event.getPointerId(0));
        }
        return viewDragHelper.getCapturedView() != null;
    }

    public final void setPlacement(@NotNull VerticalPosition placement) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.placement = placement;
    }

    private final class ViewDragCallback extends ViewDragHelper.Callback {
        private View capturedView;
        private float dragPercent;
        private boolean isDismissed;
        private int startLeft;
        private int startTop;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[VerticalPosition.values().length];
                try {
                    iArr[VerticalPosition.TOP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[VerticalPosition.BOTTOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[VerticalPosition.CENTER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public ViewDragCallback() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            return this.capturedView == null;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int i, int i2) {
            Intrinsics.checkNotNullParameter(child, "child");
            return child.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View child, int i, int i2) {
            Intrinsics.checkNotNullParameter(child, "child");
            int i3 = WhenMappings.$EnumSwitchMapping$0[ThomasBannerView.this.placement.ordinal()];
            if (i3 == 1) {
                return MathKt.roundToInt(RangesKt.coerceAtMost(i, this.startTop + ThomasBannerView.this.overDragAmount));
            }
            if (i3 == 2 || i3 == 3) {
                return MathKt.roundToInt(RangesKt.coerceAtLeast(i, this.startTop - ThomasBannerView.this.overDragAmount));
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.capturedView = view;
            this.startTop = view.getTop();
            this.startLeft = view.getLeft();
            this.dragPercent = BitmapDescriptorFactory.HUE_RED;
            this.isDismissed = false;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(view, "view");
            int height = ThomasBannerView.this.getHeight();
            int iAbs = Math.abs(i2 - this.startTop);
            if (height > 0) {
                this.dragPercent = iAbs / height;
            }
            ThomasBannerView.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            View view = this.capturedView;
            if (view == null) {
                return;
            }
            ThomasBannerView thomasBannerView = ThomasBannerView.this;
            synchronized (this) {
                try {
                    Listener listener = thomasBannerView.listener;
                    if (listener != null) {
                        listener.onDragStateChanged(i);
                    }
                    if (i == 0) {
                        if (this.isDismissed) {
                            Listener listener2 = thomasBannerView.listener;
                            if (listener2 != null) {
                                listener2.onDismissed();
                            }
                            thomasBannerView.removeView(view);
                        }
                        this.capturedView = null;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int height;
            Intrinsics.checkNotNullParameter(view, "view");
            float fAbs = Math.abs(f2);
            VerticalPosition verticalPosition = VerticalPosition.TOP;
            if ((verticalPosition == ThomasBannerView.this.placement && this.startTop >= view.getTop()) || this.startTop <= view.getTop()) {
                this.isDismissed = this.dragPercent >= 0.4f || fAbs > ThomasBannerView.this.getMinFlingVelocity() || this.dragPercent > 0.1f;
            }
            if (this.isDismissed) {
                if (verticalPosition == ThomasBannerView.this.placement) {
                    height = -view.getHeight();
                } else {
                    height = view.getHeight() + ThomasBannerView.this.getHeight();
                }
                ViewDragHelper viewDragHelper = ThomasBannerView.this.dragHelper;
                if (viewDragHelper != null) {
                    viewDragHelper.settleCapturedViewAt(this.startLeft, height);
                }
            } else {
                ViewDragHelper viewDragHelper2 = ThomasBannerView.this.dragHelper;
                if (viewDragHelper2 != null) {
                    viewDragHelper2.settleCapturedViewAt(this.startLeft, this.startTop);
                }
            }
            ThomasBannerView.this.invalidate();
        }
    }
}
