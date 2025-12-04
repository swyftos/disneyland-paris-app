package com.urbanairship.iam.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.dlp.BluetoothManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.iam.content.Banner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 *2\u00020\u0001:\u0003*+,B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006-"}, d2 = {"Lcom/urbanairship/iam/view/BannerDismissLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dragHelper", "Landroidx/customview/widget/ViewDragHelper;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/urbanairship/iam/view/BannerDismissLayout$Listener;", "getListener", "()Lcom/urbanairship/iam/view/BannerDismissLayout$Listener;", "setListener", "(Lcom/urbanairship/iam/view/BannerDismissLayout$Listener;)V", "minFlingVelocity", "", "overDragAmount", "placement", "Lcom/urbanairship/iam/content/Banner$Placement;", "getPlacement", "()Lcom/urbanairship/iam/content/Banner$Placement;", "setPlacement", "(Lcom/urbanairship/iam/content/Banner$Placement;)V", "value", "xFraction", "getXFraction", "()F", "setXFraction", "(F)V", "yFraction", "getYFraction", "setYFraction", "computeScroll", "", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "Companion", "Listener", "ViewDragCallback", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BannerDismissLayout extends FrameLayout {
    private final ViewDragHelper dragHelper;
    private Listener listener;
    private final float minFlingVelocity;
    private final int overDragAmount;
    private Banner.Placement placement;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/iam/view/BannerDismissLayout$Listener;", "", "onDismissed", "", "view", "Landroid/view/View;", "onDragStateChanged", BluetoothManager.BLE_STATUS_PARAM, "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onDismissed(@NotNull View view);

        void onDragStateChanged(@NotNull View view, int state);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerDismissLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BannerDismissLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerDismissLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.placement = Banner.Placement.BOTTOM;
        this.minFlingVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        this.overDragAmount = MathKt.roundToInt(TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        ViewDragHelper viewDragHelperCreate = ViewDragHelper.create(this, new ViewDragCallback());
        Intrinsics.checkNotNullExpressionValue(viewDragHelperCreate, "create(...)");
        this.dragHelper = viewDragHelperCreate;
    }

    @NotNull
    public final Banner.Placement getPlacement() {
        return this.placement;
    }

    public final void setPlacement(@NotNull Banner.Placement placement) {
        Intrinsics.checkNotNullParameter(placement, "<set-?>");
        this.placement = placement;
    }

    @Nullable
    public final Listener getListener() {
        return this.listener;
    }

    public final void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    public final float getYFraction() {
        return getHeight() == 0 ? BitmapDescriptorFactory.HUE_RED : getTranslationY() / getHeight();
    }

    public final void setYFraction(final float f) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.urbanairship.iam.view.BannerDismissLayout$yFraction$preDrawListener$1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    this.this$0.setYFraction(f);
                    this.this$0.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
        } else {
            setTranslationY(getYFraction() * getHeight());
        }
    }

    public final float getXFraction() {
        return getWidth() == 0 ? BitmapDescriptorFactory.HUE_RED : getTranslationX() / getWidth();
    }

    public final void setXFraction(final float f) {
        if (getVisibility() == 0 && getHeight() == 0) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.urbanairship.iam.view.BannerDismissLayout$xFraction$preDrawListener$1
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
        if (this.dragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        View viewFindTopChildUnder;
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dragHelper.shouldInterceptTouchEvent(event) || super.onInterceptTouchEvent(event)) {
            return true;
        }
        if (this.dragHelper.getViewDragState() != 0 || event.getActionMasked() != 2 || !this.dragHelper.checkTouchSlop(2) || (viewFindTopChildUnder = this.dragHelper.findTopChildUnder((int) event.getX(), (int) event.getY())) == null || viewFindTopChildUnder.canScrollVertically(this.dragHelper.getTouchSlop())) {
            return false;
        }
        this.dragHelper.captureChildView(viewFindTopChildUnder, event.getPointerId(0));
        return this.dragHelper.getViewDragState() == 1;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.dragHelper.processTouchEvent(event);
        if (this.dragHelper.getCapturedView() == null && event.getActionMasked() == 2 && this.dragHelper.checkTouchSlop(2)) {
            View viewFindTopChildUnder = this.dragHelper.findTopChildUnder((int) event.getX(), (int) event.getY());
            if (viewFindTopChildUnder == null) {
                return false;
            }
            if (!viewFindTopChildUnder.canScrollVertically(this.dragHelper.getTouchSlop())) {
                this.dragHelper.captureChildView(viewFindTopChildUnder, event.getPointerId(0));
            }
        }
        return this.dragHelper.getCapturedView() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ViewDragCallback extends ViewDragHelper.Callback {
        private View capturedView;
        private float dragPercent;
        private boolean isDismissed;
        private int startLeft;
        private int startTop;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Banner.Placement.values().length];
                try {
                    iArr[Banner.Placement.TOP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Banner.Placement.BOTTOM.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
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
            int i3 = WhenMappings.$EnumSwitchMapping$0[BannerDismissLayout.this.getPlacement().ordinal()];
            if (i3 == 1) {
                return Math.min(i, this.startTop + BannerDismissLayout.this.overDragAmount);
            }
            if (i3 == 2) {
                return Math.max(i, this.startTop - BannerDismissLayout.this.overDragAmount);
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
            UALog.e$default(null, new Function0() { // from class: com.urbanairship.iam.view.BannerDismissLayout$ViewDragCallback$onViewCaptured$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Start top: " + this.this$0.startTop;
                }
            }, 1, null);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(view, "view");
            int height = view.getHeight();
            int iAbs = Math.abs(i2 - this.startTop);
            if (height > 0) {
                this.dragPercent = iAbs / height;
            }
            BannerDismissLayout.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            View view = this.capturedView;
            if (view == null) {
                return;
            }
            BannerDismissLayout bannerDismissLayout = BannerDismissLayout.this;
            synchronized (this) {
                try {
                    Listener listener = bannerDismissLayout.getListener();
                    if (listener != null) {
                        listener.onDragStateChanged(view, i);
                    }
                    if (i == 0) {
                        if (this.isDismissed) {
                            Listener listener2 = bannerDismissLayout.getListener();
                            if (listener2 != null) {
                                listener2.onDismissed(view);
                            }
                            bannerDismissLayout.removeView(this.capturedView);
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
            Intrinsics.checkNotNullParameter(view, "view");
            float fAbs = Math.abs(f2);
            Banner.Placement placement = BannerDismissLayout.this.getPlacement();
            Banner.Placement placement2 = Banner.Placement.TOP;
            if (placement != placement2 ? this.startTop <= view.getTop() : this.startTop >= view.getTop()) {
                this.isDismissed = this.dragPercent >= 0.4f || fAbs > BannerDismissLayout.this.minFlingVelocity || this.dragPercent > 0.1f;
            }
            if (this.isDismissed) {
                BannerDismissLayout.this.dragHelper.settleCapturedViewAt(this.startLeft, BannerDismissLayout.this.getPlacement() == placement2 ? -view.getHeight() : view.getHeight() + BannerDismissLayout.this.getHeight());
            } else {
                BannerDismissLayout.this.dragHelper.settleCapturedViewAt(this.startLeft, this.startTop);
            }
            BannerDismissLayout.this.invalidate();
        }
    }
}
