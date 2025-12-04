package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.LayoutEvent;
import com.urbanairship.android.layout.environment.LayoutState;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.android.layout.info.Button;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.widget.TappableView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u0000*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003*\b\b\u0001\u0010\u0004*\u00020\u00052\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00070\u0006:\u0001,B7\u0012\u0006\u0010\b\u001a\u00028\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\"\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010#J\u0016\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cJ\u0017\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00028\u0000H\u0011¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/urbanairship/android/layout/model/ButtonModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcom/urbanairship/android/layout/widget/TappableView;", "I", "Lcom/urbanairship/android/layout/info/Button;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/ButtonModel$Listener;", "viewInfo", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "pagerState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State$Pager;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/Button;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/SharedState;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/model/ButtonModel$Listener;", "setListener$urbanairship_layout_release", "(Lcom/urbanairship/android/layout/model/ButtonModel$Listener;)V", "evaluateClickBehaviors", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDismiss", "isCancel", "", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleFormValidation", "handlePagerNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePagerPrevious", "handleSubmit", "onViewAttached", "view", "onViewAttached$urbanairship_layout_release", "(Landroid/view/View;)V", "reportingDescription", "", "Listener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ButtonModel<T extends View & TappableView, I extends Button> extends BaseModel<T, I, Listener> {
    private final ThomasForm formState;
    private Listener listener;
    private final SharedState pagerState;

    /* renamed from: com.urbanairship.android.layout.model.ButtonModel$evaluateClickBehaviors$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ButtonModel.this.evaluateClickBehaviors(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonModel(@NotNull I viewInfo, @Nullable ThomasForm thomasForm, @Nullable SharedState<State.Pager> sharedState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.formState = thomasForm;
        this.pagerState = sharedState;
    }

    @NotNull
    public String reportingDescription(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String strContentDescription = contentDescription(context);
        return strContentDescription == null ? getViewInfo().getIdentifier() : strContentDescription;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/ButtonModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "dismissSoftKeyboard", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void dismissSoftKeyboard();

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onStateUpdated(@NotNull Listener listener, @NotNull ThomasState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Listener.super.onStateUpdated(state);
            }
        }
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    @Nullable
    /* renamed from: getListener$urbanairship_layout_release, reason: from getter */
    public Listener getListener() {
        return this.listener;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void setListener$urbanairship_layout_release(@Nullable Listener listener) {
        this.listener = listener;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    @CallSuper
    public void onViewAttached$urbanairship_layout_release(@NotNull T view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new ButtonModel$onViewAttached$1(view, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object evaluateClickBehaviors(android.content.Context r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.model.ButtonModel.evaluateClickBehaviors(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleSubmit(Context context, Continuation continuation) {
        Listener listener = getListener();
        if (listener != null) {
            listener.dismissSoftKeyboard();
        }
        Object objJoin = broadcast(new LayoutEvent.SubmitForm(getViewInfo().getIdentifier(), new ButtonModel$handleSubmit$submitEvent$1(this, context, null))).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleFormValidation(Context context, Continuation continuation) {
        Listener listener = getListener();
        if (listener != null) {
            listener.dismissSoftKeyboard();
        }
        Object objJoin = broadcast(new LayoutEvent.ValidateForm(getViewInfo().getIdentifier(), new ButtonModel$handleFormValidation$validateEvent$1(this, context, null))).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handlePagerNext(Continuation continuation) {
        Object objJoin = broadcast(new LayoutEvent.PagerNext(PagerModelKt.getPagerNextFallback(getViewInfo().getClickBehaviors()))).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handlePagerPrevious(Continuation continuation) {
        Object objJoin = broadcast(LayoutEvent.PagerPrevious.INSTANCE).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleDismiss(Context context, boolean z, Continuation continuation) {
        ReportingEvent.DismissData.ButtonTapped buttonTapped = new ReportingEvent.DismissData.ButtonTapped(getViewInfo().getIdentifier(), reportingDescription(context), z);
        Duration.Companion companion = Duration.INSTANCE;
        report(new ReportingEvent.Dismiss(buttonTapped, DurationKt.toDuration(getEnvironment().getDisplayTimer().getTime(), DurationUnit.MILLISECONDS), LayoutState.reportingContext$default(getLayoutState(), null, null, getViewInfo().getIdentifier(), 3, null), null));
        Object objJoin = broadcast(LayoutEvent.Finish.INSTANCE).join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }
}
