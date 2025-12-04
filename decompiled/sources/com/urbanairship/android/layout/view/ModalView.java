package com.urbanairship.android.layout.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.ModalPresentation;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.Border;
import com.urbanairship.android.layout.property.Color;
import com.urbanairship.android.layout.property.ConstrainedSize;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.property.ModalPlacement;
import com.urbanairship.android.layout.property.Position;
import com.urbanairship.android.layout.property.Shadow;
import com.urbanairship.android.layout.util.ConstraintSetBuilder;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.ResourceUtils;
import com.urbanairship.android.layout.widget.ClippableFrameLayout;
import com.urbanairship.android.layout.widget.ConstrainedFrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00172\b\u0010$\u001a\u0004\u0018\u00010\rR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/urbanairship/android/layout/view/ModalView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "presentation", "Lcom/urbanairship/android/layout/ModalPresentation;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/ModalPresentation;Lcom/urbanairship/android/layout/environment/ViewEnvironment;)V", "clickOutsideListener", "Landroid/view/View$OnClickListener;", "modalFrame", "Landroid/view/ViewGroup;", "windowTouchSlop", "", "getWindowTouchSlop", "()I", "windowTouchSlop$delegate", "Lkotlin/Lazy;", "applyShadow", "", "view", "Landroid/view/View;", "color", "elevation", "", "isOpaque", "", "isTouchOutside", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "setOnClickOutsideListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nModalView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModalView.kt\ncom/urbanairship/android/layout/view/ModalView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1#2:144\n*E\n"})
/* loaded from: classes5.dex */
public final class ModalView extends ConstraintLayout {
    private View.OnClickListener clickOutsideListener;
    private final ViewGroup modalFrame;

    /* renamed from: windowTouchSlop$delegate, reason: from kotlin metadata */
    private final Lazy windowTouchSlop;

    @Override // android.view.View
    public boolean isOpaque() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalView(@NotNull final Context context, @NotNull BaseModel<?, ?, ?> model, @NotNull ModalPresentation presentation, @NotNull ViewEnvironment viewEnvironment) {
        float[] fArrInnerRadii;
        Shadow.ElevationShadow androidShadow;
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.windowTouchSlop = LazyKt.lazy(new Function0() { // from class: com.urbanairship.android.layout.view.ModalView$windowTouchSlop$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(context).getScaledWindowTouchSlop());
            }
        });
        ModalPlacement resolvedPlacement = presentation.getResolvedPlacement(context);
        Intrinsics.checkNotNullExpressionValue(resolvedPlacement, "getResolvedPlacement(...)");
        ConstrainedSize size = resolvedPlacement.getSize();
        Position position = resolvedPlacement.getPosition();
        Margin margin = resolvedPlacement.getMargin();
        Color shadeColor = resolvedPlacement.getShadeColor();
        Integer numValueOf = shadeColor != null ? Integer.valueOf(shadeColor.resolve(context)) : null;
        ConstrainedFrameLayout constrainedFrameLayout = new ConstrainedFrameLayout(context, size);
        constrainedFrameLayout.setId(View.generateViewId());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        if (margin != null) {
            layoutParams.setMargins((int) ResourceUtils.dpToPx(context, margin.getStart()), (int) ResourceUtils.dpToPx(context, margin.getTop()), (int) ResourceUtils.dpToPx(context, margin.getEnd()), (int) ResourceUtils.dpToPx(context, margin.getBottom()));
        }
        constrainedFrameLayout.setLayoutParams(layoutParams);
        constrainedFrameLayout.setClipChildren(false);
        constrainedFrameLayout.setClipToPadding(false);
        constrainedFrameLayout.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        LayoutUtils.applyBorderAndBackground(constrainedFrameLayout, null, resolvedPlacement.getBorder(), resolvedPlacement.getBackgroundColor());
        Shadow shadow = resolvedPlacement.getShadow();
        if (shadow != null && (androidShadow = shadow.getAndroidShadow()) != null) {
            applyShadow(constrainedFrameLayout, androidShadow.getColor().resolve(context), androidShadow.getElevation());
        }
        this.modalFrame = constrainedFrameLayout;
        final ClippableFrameLayout clippableFrameLayout = new ClippableFrameLayout(context);
        clippableFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Border border = resolvedPlacement.getBorder();
        if (border != null && (fArrInnerRadii = border.innerRadii(new Function1() { // from class: com.urbanairship.android.layout.view.ModalView$containerView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Float invoke(int i) {
                return Float.valueOf(ResourceUtils.dpToPx(context, i));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        })) != null) {
            clippableFrameLayout.setClipPathBorderRadius(fArrInnerRadii);
        }
        clippableFrameLayout.addView(model.createView(context, viewEnvironment, null));
        constrainedFrameLayout.addView(clippableFrameLayout);
        addView(constrainedFrameLayout);
        int id = constrainedFrameLayout.getId();
        ConstraintSet constraintSetBuild = ConstraintSetBuilder.newBuilder(context).constrainWithinParent(id).size(size, resolvedPlacement.getIgnoreSafeArea(), id).position(position, id).build();
        Intrinsics.checkNotNullExpressionValue(constraintSetBuild, "build(...)");
        constraintSetBuild.applyTo(this);
        if (numValueOf != null) {
            setBackgroundColor(numValueOf.intValue());
        }
        if (viewEnvironment.getIsIgnoringSafeAreas()) {
            ViewCompat.setOnApplyWindowInsetsListener(constrainedFrameLayout, new OnApplyWindowInsetsListener() { // from class: com.urbanairship.android.layout.view.ModalView$$ExternalSyntheticLambda0
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return ModalView._init_$lambda$7(clippableFrameLayout, view, windowInsetsCompat);
                }
            });
        }
    }

    private final int getWindowTouchSlop() {
        return ((Number) this.windowTouchSlop.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat _init_$lambda$7(ClippableFrameLayout containerView, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(containerView, "$containerView");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        return ViewCompat.dispatchApplyWindowInsets(containerView, insets);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        View.OnClickListener onClickListener;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            return true;
        }
        if (action != 1 || !isTouchOutside(event) || (onClickListener = this.clickOutsideListener) == null) {
            return super.onTouchEvent(event);
        }
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
        return true;
    }

    public final void setOnClickOutsideListener(@Nullable View.OnClickListener listener) {
        this.clickOutsideListener = listener;
    }

    private final void applyShadow(View view, int color, float elevation) {
        view.setOutlineAmbientShadowColor(color);
        view.setOutlineSpotShadowColor(color);
        view.setElevation(ResourceUtils.dpToPx(getContext(), (int) elevation));
    }

    private final boolean isTouchOutside(MotionEvent event) {
        Rect rect = new Rect();
        this.modalFrame.getHitRect(rect);
        rect.inset(-getWindowTouchSlop(), -getWindowTouchSlop());
        return !rect.contains((int) event.getX(), (int) event.getY());
    }
}
