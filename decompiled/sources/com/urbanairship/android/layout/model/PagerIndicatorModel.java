package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.AutomatedAccessibilityAction;
import com.urbanairship.android.layout.info.AutomatedAccessibilityActionType;
import com.urbanairship.android.layout.info.PagerIndicatorInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.view.PagerIndicatorView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001&B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011J\"\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0002H\u0010¢\u0006\u0002\b%R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/urbanairship/android/layout/model/PagerIndicatorModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/PagerIndicatorView;", "Lcom/urbanairship/android/layout/info/PagerIndicatorInfo;", "Lcom/urbanairship/android/layout/model/PagerIndicatorModel$Listener;", "viewInfo", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/PagerIndicatorInfo;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "announcePage", "", "getAnnouncePage", "()Z", "indicatorViewIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "value", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/model/PagerIndicatorModel$Listener;", "setListener$urbanairship_layout_release", "(Lcom/urbanairship/android/layout/model/PagerIndicatorModel$Listener;)V", "getIndicatorViewId", ViewProps.POSITION, "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "", "view", "onViewAttached$urbanairship_layout_release", "Listener", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPagerIndicatorModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PagerIndicatorModel.kt\ncom/urbanairship/android/layout/model/PagerIndicatorModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,61:1\n1747#2,3:62\n372#3,7:65\n*S KotlinDebug\n*F\n+ 1 PagerIndicatorModel.kt\ncom/urbanairship/android/layout/model/PagerIndicatorModel\n*L\n39#1:62,3\n59#1:65,7\n*E\n"})
/* loaded from: classes5.dex */
public final class PagerIndicatorModel extends BaseModel<PagerIndicatorView, PagerIndicatorInfo, Listener> {
    private final HashMap indicatorViewIds;
    private Listener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerIndicatorModel(@NotNull PagerIndicatorInfo viewInfo, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.indicatorViewIds = new HashMap();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/PagerIndicatorModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "onUpdate", "", TCEventPropertiesNames.TCP_SIZE, "", ViewProps.POSITION, "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void onUpdate(int size, int position);

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
        StateFlow<State.Pager> changes;
        State.Pager value;
        Listener listener2;
        this.listener = listener;
        SharedState<State.Pager> pager = getLayoutState().getPager();
        if (pager == null || (changes = pager.getChanges()) == null || (value = changes.getValue()) == null || (listener2 = getListener()) == null) {
            return;
        }
        listener2.onUpdate(value.getPageIds().size(), value.getPageIndex());
    }

    public final boolean getAnnouncePage() {
        List<AutomatedAccessibilityAction> automatedAccessibilityActions = getViewInfo().getAutomatedAccessibilityActions();
        if (automatedAccessibilityActions == null || automatedAccessibilityActions.isEmpty()) {
            return false;
        }
        Iterator<T> it = automatedAccessibilityActions.iterator();
        while (it.hasNext()) {
            if (((AutomatedAccessibilityAction) it.next()).getType() == AutomatedAccessibilityActionType.ANNOUNCE) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public PagerIndicatorView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        PagerIndicatorView pagerIndicatorView = new PagerIndicatorView(context, this);
        pagerIndicatorView.setId(getViewId());
        return pagerIndicatorView;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull PagerIndicatorView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt__Builders_commonKt.launch$default(getModelScope(), null, null, new PagerIndicatorModel$onViewAttached$1(this, null), 3, null);
    }

    public final int getIndicatorViewId(int position) {
        HashMap map = this.indicatorViewIds;
        Integer numValueOf = Integer.valueOf(position);
        Object objValueOf = map.get(numValueOf);
        if (objValueOf == null) {
            objValueOf = Integer.valueOf(View.generateViewId());
            map.put(numValueOf, objValueOf);
        }
        return ((Number) objValueOf).intValue();
    }
}
