package com.urbanairship.android.layout.view;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ToggleButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.BaseToggleLayoutInfo;
import com.urbanairship.android.layout.model.Background;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.BaseToggleLayoutModel;
import com.urbanairship.android.layout.model.ItemProperties;
import com.urbanairship.android.layout.util.LayoutUtils;
import com.urbanairship.android.layout.util.StringExtensionsKt;
import com.urbanairship.android.layout.util.ViewExtensionsKt;
import com.urbanairship.android.layout.widget.TappableView;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B'\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001eH\u0016J\u0014\u0010%\u001a\u00020\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0'H\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\u0014\u0010)\u001a\u00020\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001eH\u0002J\u0014\u0010,\u001a\u00020\u001e*\u00020!2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u0015X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Lcom/urbanairship/android/layout/view/ToggleLayoutView;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/layout/model/BaseToggleLayoutModel;", "Landroid/widget/FrameLayout;", "Lcom/urbanairship/android/layout/view/BaseView;", "Lcom/urbanairship/android/layout/widget/TappableView;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", TCEventPropertiesNames.TCD_MODEL, "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "(Landroid/content/Context;Lcom/urbanairship/android/layout/model/BaseToggleLayoutModel;Lcom/urbanairship/android/layout/environment/ViewEnvironment;Lcom/urbanairship/android/layout/model/ItemProperties;)V", "getItemProperties", "()Lcom/urbanairship/android/layout/model/ItemProperties;", "getModel", "()Lcom/urbanairship/android/layout/model/BaseToggleLayoutModel;", "Lcom/urbanairship/android/layout/model/BaseToggleLayoutModel;", "rippleAnimationDuration", "Lkotlin/time/Duration;", "J", "view", "Landroid/view/View;", "clearRipple", "", "getAccessibilityClassName", "", "isChecked", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "setChecked", "checked", "showRipple", "taps", "Lkotlinx/coroutines/flow/Flow;", "toggle", "triggerDefaultAnimation", "updateToggleVisualState", "isOn", "isWithinClickableDescendantOf", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nToggleLayoutView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToggleLayoutView.kt\ncom/urbanairship/android/layout/view/ToggleLayoutView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,150:1\n1#2:151\n*E\n"})
/* loaded from: classes5.dex */
public final class ToggleLayoutView<T extends BaseToggleLayoutModel<?, ?>> extends FrameLayout implements BaseView, TappableView, Checkable {
    private final ItemProperties itemProperties;
    private final BaseToggleLayoutModel model;
    private final long rippleAnimationDuration;
    private final View view;

    @NotNull
    public final T getModel() {
        return (T) this.model;
    }

    @Nullable
    public final ItemProperties getItemProperties() {
        return this.itemProperties;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToggleLayoutView(@NotNull Context context, @NotNull T model, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
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
        LayoutUtils.applyToggleLayoutRippleEffect(this, (BaseToggleLayoutInfo) model.getViewInfo());
        addView(viewCreateView, -1, -1);
        viewCreateView.setImportantForAccessibility(4);
        String strContentDescription = model.contentDescription(context);
        if (strContentDescription != null) {
            StringExtensionsKt.ifNotEmpty(strContentDescription, new Function1() { // from class: com.urbanairship.android.layout.view.ToggleLayoutView.1
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
                    ToggleLayoutView.this.setContentDescription(it);
                }
            });
        }
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegateCompat() { // from class: com.urbanairship.android.layout.view.ToggleLayoutView.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                info.setClassName(ToggleButton.class.getName());
                info.setCheckable(host.isEnabled());
                if (host.isEnabled()) {
                    info.setChecked(ToggleLayoutView.this.getModel().isOn().getValue().booleanValue());
                }
            }
        });
        BuildersKt__Builders_commonKt.launch$default(model.getViewScope(), null, null, new AnonymousClass3(null), 3, null);
        final Drawable background = getBackground();
        model.setListener$urbanairship_layout_release(new BaseModel.Listener() { // from class: com.urbanairship.android.layout.view.ToggleLayoutView.4
            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setVisibility(boolean visible) {
                ToggleLayoutView.this.setVisibility(visible ? 0 : 8);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setEnabled(boolean enabled) {
                ToggleLayoutView.this.setEnabled(enabled);
            }

            @Override // com.urbanairship.android.layout.model.BaseModel.Listener
            public void setBackground(@Nullable Background old, @NotNull Background background2) {
                Intrinsics.checkNotNullParameter(background2, "new");
                LayoutUtils.updateBackground(ToggleLayoutView.this, background, old, background2);
            }
        });
    }

    /* renamed from: com.urbanairship.android.layout.view.ToggleLayoutView$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2 {
        int label;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(continuation);
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
                StateFlow<Boolean> stateFlowIsOn = ToggleLayoutView.this.getModel().isOn();
                final ToggleLayoutView toggleLayoutView = ToggleLayoutView.this;
                FlowCollector<? super Boolean> flowCollector = new FlowCollector() { // from class: com.urbanairship.android.layout.view.ToggleLayoutView.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Boolean) obj2).booleanValue(), continuation);
                    }

                    public final Object emit(boolean z, Continuation continuation) {
                        toggleLayoutView.updateToggleVisualState(z);
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (stateFlowIsOn.collect(flowCollector, this) == coroutine_suspended) {
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

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 1 || isWithinClickableDescendantOf(event, this.view)) {
            return false;
        }
        triggerDefaultAnimation(event);
        performClick();
        return false;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        this.model.toggle();
        return true;
    }

    @Override // com.urbanairship.android.layout.widget.TappableView
    @NotNull
    public Flow<Unit> taps() {
        return ViewExtensionsKt.debouncedClicks$default(this, 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateToggleVisualState(boolean isOn) {
        setActivated(isOn);
    }

    private final boolean isWithinClickableDescendantOf(MotionEvent motionEvent, View view) {
        return ViewExtensionsKt.findTargetDescendant(motionEvent, view, new Function1() { // from class: com.urbanairship.android.layout.view.ToggleLayoutView.isWithinClickableDescendantOf.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.isClickable() && it.isEnabled());
            }
        }) != null;
    }

    /* renamed from: com.urbanairship.android.layout.view.ToggleLayoutView$triggerDefaultAnimation$1, reason: invalid class name and case insensitive filesystem */
    static final class C09761 extends SuspendLambda implements Function2 {
        final /* synthetic */ MotionEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09761(MotionEvent motionEvent, Continuation continuation) {
            super(2, continuation);
            this.$event = motionEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C09761(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C09761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ToggleLayoutView.this.showRipple(this.$event);
                long j = ToggleLayoutView.this.rippleAnimationDuration;
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
            ToggleLayoutView.this.clearRipple();
            return Unit.INSTANCE;
        }
    }

    private final void triggerDefaultAnimation(MotionEvent event) {
        BuildersKt__Builders_commonKt.launch$default(this.model.getViewScope(), null, null, new C09761(event, null), 3, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    @NotNull
    public CharSequence getAccessibilityClassName() {
        String name = ToggleButton.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return name;
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

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        this.model.setChecked(checked);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.model.isOn().getValue().booleanValue();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.model.toggle();
    }
}
