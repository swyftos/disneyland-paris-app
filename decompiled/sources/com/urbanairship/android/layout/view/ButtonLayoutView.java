package com.urbanairship.android.layout.view;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.ButtonLayoutInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.ButtonLayoutModel;
import com.urbanairship.android.layout.model.ButtonModel;
import com.urbanairship.android.layout.model.ItemProperties;
import com.urbanairship.android.layout.property.TapEffect;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.widget.ShrinkableView;
import com.urbanairship.android.layout.widget.TappableView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0016J\u0014\u0010\"\u001a\u00020\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001b0$H\u0016J\u0014\u0010%\u001a\u00020\u001b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0014\u0010&\u001a\u00020\u000f*\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/urbanairship/android/layout/view/ButtonLayoutView;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "Lcom/urbanairship/android/layout/widget/ShrinkableView;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/ButtonLayoutModel;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/ButtonLayoutModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;Lcom/urbanairship/android/layout/model/ItemProperties;)V", "isButtonForAccessibility", "", "()Z", "getItemProperties", "()Lcom/urbanairship/android/layout/model/ItemProperties;", "getModel", "()Lcom/urbanairship/android/layout/model/ButtonLayoutModel;", "rippleAnimationDuration", "Lkotlin/time/Duration;", "J", "view", "Landroid/view/View;", "clearRipple", "", "getAccessibilityClassName", "", "isShrinkable", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "showRipple", "taps", "Lkotlinx/coroutines/flow/Flow;", "triggerDefaultAnimation", "isWithinClickableDescendantOf", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nButtonLayoutView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ButtonLayoutView.kt\ncom/urbanairship/android/layout/view/ButtonLayoutView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,147:1\n1#2:148\n*E\n"})
/* loaded from: classes5.dex */
public final class ButtonLayoutView extends FrameLayout implements BaseView, TappableView, ShrinkableView {
    private final ItemProperties itemProperties;
    private final ButtonLayoutModel model;
    private final long rippleAnimationDuration;
    private final View view;

    @NotNull
    public final ButtonLayoutModel getModel() {
        return this.model;
    }

    @Nullable
    public final ItemProperties getItemProperties() {
        return this.itemProperties;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonLayoutView(@NotNull Context context, @NotNull ButtonLayoutModel model, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        this.model = model;
        this.itemProperties = itemProperties;
        View viewCreateView = model.getView().createView(context, viewEnvironment, itemProperties);
        this.view = viewCreateView;
        Duration.Companion companion = Duration.INSTANCE;
        this.rippleAnimationDuration = DurationKt.toDuration(getResources().getInteger(R.integer.config_shortAnimTime), DurationUnit.MILLISECONDS);
        setClickable(true);
        setFocusable(true);
        LayoutUtils.applyButtonLayoutModel(this, model);
        addView(viewCreateView, -1, -1);
        if (isButtonForAccessibility()) {
            viewCreateView.setImportantForAccessibility(4);
            String strContentDescription = model.contentDescription(context);
            if (strContentDescription != null) {
                StringExtensionsKt.ifNotEmpty(strContentDescription, new Function1() { // from class: com.urbanairship.android.layout.view.ButtonLayoutView.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ButtonLayoutView.this.setContentDescription(it);
                    }
                });
            }
        } else {
            setImportantForAccessibility(2);
        }
        final Drawable background = getBackground();
        model.setListener$urbanairship_layout_release(new ButtonModel.Listener() { // from class: com.urbanairship.android.layout.view.ButtonLayoutView.2
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                ButtonLayoutView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                ButtonLayoutView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.ButtonModel.Listener
            public void dismissSoftKeyboard() {
                LayoutUtils.dismissSoftKeyboard(ButtonLayoutView.this);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background2) {
                Intrinsics.checkNotNullParameter(background2, "new");
                LayoutUtils.updateBackground(ButtonLayoutView.this, background, old, background2);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isButtonForAccessibility() {
        ButtonLayoutInfo.AccessibilityRole accessibilityRole = ((ButtonLayoutInfo) this.model.getViewInfo()).getAccessibilityRole();
        if (Intrinsics.areEqual(accessibilityRole, ButtonLayoutInfo.AccessibilityRole.Button.INSTANCE)) {
            return true;
        }
        if (Intrinsics.areEqual(accessibilityRole, ButtonLayoutInfo.AccessibilityRole.Container.INSTANCE)) {
            return false;
        }
        if (accessibilityRole == null) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isButtonForAccessibility()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (ButtonLayoutViewKt.isTouchExplorationEnabled(context)) {
                return false;
            }
        }
        if (event.getAction() == 1 && !isWithinClickableDescendantOf(event, this.view)) {
            TapEffect tapEffect = ((ButtonLayoutInfo) this.model.getViewInfo()).getTapEffect();
            if (Intrinsics.areEqual(tapEffect, TapEffect.Default.INSTANCE)) {
                triggerDefaultAnimation$default(this, null, 1, null);
            } else {
                Intrinsics.areEqual(tapEffect, TapEffect.None.INSTANCE);
            }
            performClick();
        }
        return false;
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        return ViewExtensionsKt.debouncedClicks$default(this, 0L, 1, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @NotNull
    public CharSequence getAccessibilityClassName() {
        String name = Button.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
    }

    @Override // com.urbanairship.android.layout.widget.ShrinkableView
    public boolean isShrinkable() {
        return this.model.getIsShrinkable();
    }

    private final boolean isWithinClickableDescendantOf(MotionEvent motionEvent, View view) {
        return ViewExtensionsKt.findTargetDescendant(motionEvent, view, new Function1() { // from class: com.urbanairship.android.layout.view.ButtonLayoutView.isWithinClickableDescendantOf.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.isClickable() && it.isEnabled());
            }
        }) != null;
    }

    /* renamed from: com.urbanairship.android.layout.view.ButtonLayoutView$triggerDefaultAnimation$1, reason: invalid class name and case insensitive filesystem */
    static final class C09681 extends SuspendLambda implements Function2 {
        final /* synthetic */ MotionEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09681(MotionEvent motionEvent, Continuation continuation) {
            super(2, continuation);
            this.$event = motionEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ButtonLayoutView.this.new C09681(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ButtonLayoutView.this.showRipple(this.$event);
                long j = ButtonLayoutView.this.rippleAnimationDuration;
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
            ButtonLayoutView.this.clearRipple();
            return Unit.INSTANCE;
        }
    }

    static /* synthetic */ void triggerDefaultAnimation$default(ButtonLayoutView buttonLayoutView, MotionEvent motionEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            motionEvent = null;
        }
        buttonLayoutView.triggerDefaultAnimation(motionEvent);
    }

    private final void triggerDefaultAnimation(MotionEvent event) {
        BuildersKt__Builders_commonKt.launch$default(this.model.getViewScope(), null, null, new C09681(event, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRipple(MotionEvent event) {
        Drawable foreground = getForeground();
        if (foreground == null) {
            return;
        }
        if ((foreground instanceof RippleDrawable) && event != null) {
            foreground.setHotspot(event.getX(), event.getY());
        }
        setPressed(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearRipple() {
        setPressed(false);
    }
}
