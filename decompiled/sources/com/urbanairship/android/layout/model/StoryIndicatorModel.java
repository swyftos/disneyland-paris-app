package com.urbanairship.android.layout.model;

import android.content.Context;
import android.view.View;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasState;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.AutomatedAccessibilityAction;
import com.urbanairship.android.layout.info.AutomatedAccessibilityActionType;
import com.urbanairship.android.layout.info.StoryIndicatorInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.view.StoryIndicatorView;
import com.urbanairship.json.matchers.ExactValueMatcher;
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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002&'B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011J\"\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0002H\u0010¢\u0006\u0002\b%R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004@PX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/urbanairship/android/layout/model/StoryIndicatorModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/StoryIndicatorView;", "Lcom/urbanairship/android/layout/info/StoryIndicatorInfo;", "Lcom/urbanairship/android/layout/model/StoryIndicatorModel$Listener;", "viewInfo", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/StoryIndicatorInfo;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "announcePage", "", "getAnnouncePage", "()Z", "indicatorViewIds", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "value", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener$urbanairship_layout_release", "()Lcom/urbanairship/android/layout/model/StoryIndicatorModel$Listener;", "setListener$urbanairship_layout_release", "(Lcom/urbanairship/android/layout/model/StoryIndicatorModel$Listener;)V", "getIndicatorViewId", ViewProps.POSITION, "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "onViewAttached", "", "view", "onViewAttached$urbanairship_layout_release", "Listener", "StoryIndicatorUpdate", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStoryIndicatorModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StoryIndicatorModel.kt\ncom/urbanairship/android/layout/model/StoryIndicatorModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,97:1\n1747#2,3:98\n372#3,7:101\n*S KotlinDebug\n*F\n+ 1 StoryIndicatorModel.kt\ncom/urbanairship/android/layout/model/StoryIndicatorModel\n*L\n53#1:98,3\n95#1:101,7\n*E\n"})
/* loaded from: classes5.dex */
public final class StoryIndicatorModel extends BaseModel<StoryIndicatorView, StoryIndicatorInfo, Listener> {
    private final HashMap indicatorViewIds;
    private Listener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryIndicatorModel(@NotNull StoryIndicatorInfo viewInfo, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.indicatorViewIds = new HashMap();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/urbanairship/android/layout/model/StoryIndicatorModel$Listener;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "onUpdate", "", TCEventPropertiesNames.TCP_SIZE, "", "pageIndex", "progress", "durations", "", "announcePage", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener extends BaseModel.Listener {
        void onUpdate(int size, int pageIndex, int progress, @NotNull List<Integer> durations, boolean announcePage);

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
        listener2.onUpdate(value.getPageIds().size(), value.getPageIndex(), value.getProgress(), value.getDurations(), getAnnouncePage());
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
    public StoryIndicatorView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        StoryIndicatorView storyIndicatorView = new StoryIndicatorView(context, this);
        storyIndicatorView.setId(getViewId());
        return storyIndicatorView;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void onViewAttached$urbanairship_layout_release(@NotNull StoryIndicatorView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        BuildersKt__Builders_commonKt.launch$default(getViewScope(), null, null, new StoryIndicatorModel$onViewAttached$1(this, null), 3, null);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/model/StoryIndicatorModel$StoryIndicatorUpdate;", "", TCEventPropertiesNames.TCP_SIZE, "", "pageIndex", "progress", "durations", "", "announcePage", "", "(IIILjava/util/List;Z)V", "getAnnouncePage", "()Z", "getDurations", "()Ljava/util/List;", "getPageIndex", "()I", "getProgress", "getSize", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StoryIndicatorUpdate {
        private final boolean announcePage;
        private final List durations;
        private final int pageIndex;
        private final int progress;
        private final int size;

        public static /* synthetic */ StoryIndicatorUpdate copy$default(StoryIndicatorUpdate storyIndicatorUpdate, int i, int i2, int i3, List list, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = storyIndicatorUpdate.size;
            }
            if ((i4 & 2) != 0) {
                i2 = storyIndicatorUpdate.pageIndex;
            }
            int i5 = i2;
            if ((i4 & 4) != 0) {
                i3 = storyIndicatorUpdate.progress;
            }
            int i6 = i3;
            if ((i4 & 8) != 0) {
                list = storyIndicatorUpdate.durations;
            }
            List list2 = list;
            if ((i4 & 16) != 0) {
                z = storyIndicatorUpdate.announcePage;
            }
            return storyIndicatorUpdate.copy(i, i5, i6, list2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSize() {
            return this.size;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* renamed from: component3, reason: from getter */
        public final int getProgress() {
            return this.progress;
        }

        @NotNull
        public final List<Integer> component4() {
            return this.durations;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getAnnouncePage() {
            return this.announcePage;
        }

        @NotNull
        public final StoryIndicatorUpdate copy(int size, int pageIndex, int progress, @NotNull List<Integer> durations, boolean announcePage) {
            Intrinsics.checkNotNullParameter(durations, "durations");
            return new StoryIndicatorUpdate(size, pageIndex, progress, durations, announcePage);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoryIndicatorUpdate)) {
                return false;
            }
            StoryIndicatorUpdate storyIndicatorUpdate = (StoryIndicatorUpdate) other;
            return this.size == storyIndicatorUpdate.size && this.pageIndex == storyIndicatorUpdate.pageIndex && this.progress == storyIndicatorUpdate.progress && Intrinsics.areEqual(this.durations, storyIndicatorUpdate.durations) && this.announcePage == storyIndicatorUpdate.announcePage;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.size) * 31) + Integer.hashCode(this.pageIndex)) * 31) + Integer.hashCode(this.progress)) * 31) + this.durations.hashCode()) * 31) + Boolean.hashCode(this.announcePage);
        }

        @NotNull
        public String toString() {
            return "StoryIndicatorUpdate(size=" + this.size + ", pageIndex=" + this.pageIndex + ", progress=" + this.progress + ", durations=" + this.durations + ", announcePage=" + this.announcePage + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public StoryIndicatorUpdate(int i, int i2, int i3, @NotNull List<Integer> durations, boolean z) {
            Intrinsics.checkNotNullParameter(durations, "durations");
            this.size = i;
            this.pageIndex = i2;
            this.progress = i3;
            this.durations = durations;
            this.announcePage = z;
        }

        public final int getSize() {
            return this.size;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final int getProgress() {
            return this.progress;
        }

        @NotNull
        public final List<Integer> getDurations() {
            return this.durations;
        }

        public final boolean getAnnouncePage() {
            return this.announcePage;
        }
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
