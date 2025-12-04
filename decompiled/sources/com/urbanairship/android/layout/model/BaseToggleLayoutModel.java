package com.urbanairship.android.layout.model;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.info.BaseToggleLayoutInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.property.EventHandlerKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005B=\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0016\u0010\b\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00028\u0000H\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u001cR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R!\u0010\b\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/urbanairship/android/layout/model/BaseToggleLayoutModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "I", "Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "view", "Lcom/urbanairship/android/layout/model/AnyModel;", "formState", "Lcom/urbanairship/android/layout/environment/ThomasForm;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo;Lcom/urbanairship/android/layout/model/BaseModel;Lcom/urbanairship/android/layout/environment/ThomasForm;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "_isOn", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isOn", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "setOn", "(Lkotlinx/coroutines/flow/StateFlow;)V", "getView", "()Lcom/urbanairship/android/layout/model/BaseModel;", "onChange", "", "onViewAttached", "onViewAttached$urbanairship_layout_release", "(Landroid/view/View;)V", "setChecked", "isChecked", "toggle", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseToggleLayoutModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseToggleLayoutModel.kt\ncom/urbanairship/android/layout/model/BaseToggleLayoutModel\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n*L\n1#1,69:1\n226#2,5:70\n226#2,5:75\n*S KotlinDebug\n*F\n+ 1 BaseToggleLayoutModel.kt\ncom/urbanairship/android/layout/model/BaseToggleLayoutModel\n*L\n29#1:70,5\n33#1:75,5\n*E\n"})
/* loaded from: classes5.dex */
public abstract class BaseToggleLayoutModel<T extends View, I extends BaseToggleLayoutInfo> extends BaseModel<T, I, BaseModel.Listener> {
    private MutableStateFlow _isOn;
    private final ThomasForm formState;
    private StateFlow isOn;
    private final BaseModel view;

    @NotNull
    public final BaseModel<?, ?, ?> getView() {
        return this.view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseToggleLayoutModel(@NotNull I viewInfo, @NotNull BaseModel<?, ?, ?> view, @NotNull ThomasForm formState, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(formState, "formState");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.view = view;
        this.formState = formState;
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this._isOn = MutableStateFlow;
        this.isOn = FlowKt.asStateFlow(MutableStateFlow);
    }

    @NotNull
    public final StateFlow<Boolean> isOn() {
        return this.isOn;
    }

    public final void setOn(@NotNull StateFlow<Boolean> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<set-?>");
        this.isOn = stateFlow;
    }

    public final void toggle() {
        MutableStateFlow mutableStateFlow = this._isOn;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), Boolean.valueOf(!((Boolean) r0).booleanValue())));
    }

    public final void setChecked(boolean isChecked) {
        Object value;
        MutableStateFlow mutableStateFlow = this._isOn;
        do {
            value = mutableStateFlow.getValue();
            ((Boolean) value).booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(isChecked)));
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    @CallSuper
    public void onViewAttached$urbanairship_layout_release(@NotNull T view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewAttached$urbanairship_layout_release(view);
        if (EventHandlerKt.hasTapHandler(getViewInfo().getEventHandlers())) {
            BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new BaseToggleLayoutModel$onViewAttached$1(this, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new BaseToggleLayoutModel$onViewAttached$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new BaseToggleLayoutModel$onViewAttached$3(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChange(boolean isOn) {
        BaseToggleLayoutInfo.ToggleActions onToggleOff;
        if (isOn) {
            onToggleOff = getViewInfo().getOnToggleOn();
        } else if (!isOn) {
            onToggleOff = getViewInfo().getOnToggleOff();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        BaseModel.runStateActions$default(this, onToggleOff.getStateActions(), null, 2, null);
    }
}
