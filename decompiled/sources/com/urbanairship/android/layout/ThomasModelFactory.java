package com.urbanairship.android.layout;

import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.FormType;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.SharedState;
import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.environment.ThomasForm;
import com.urbanairship.android.layout.info.BasicToggleLayoutInfo;
import com.urbanairship.android.layout.info.ButtonLayoutInfo;
import com.urbanairship.android.layout.info.CheckboxControllerInfo;
import com.urbanairship.android.layout.info.CheckboxInfo;
import com.urbanairship.android.layout.info.CheckboxToggleLayoutInfo;
import com.urbanairship.android.layout.info.ContainerLayoutInfo;
import com.urbanairship.android.layout.info.ContainerLayoutItemInfo;
import com.urbanairship.android.layout.info.CustomViewInfo;
import com.urbanairship.android.layout.info.EmptyInfo;
import com.urbanairship.android.layout.info.FormControllerInfo;
import com.urbanairship.android.layout.info.IconViewInfo;
import com.urbanairship.android.layout.info.ImageButtonInfo;
import com.urbanairship.android.layout.info.ItemInfo;
import com.urbanairship.android.layout.info.LabelButtonInfo;
import com.urbanairship.android.layout.info.LabelInfo;
import com.urbanairship.android.layout.info.LinearLayoutInfo;
import com.urbanairship.android.layout.info.LinearLayoutItemInfo;
import com.urbanairship.android.layout.info.MediaInfo;
import com.urbanairship.android.layout.info.NpsFormControllerInfo;
import com.urbanairship.android.layout.info.PagerControllerInfo;
import com.urbanairship.android.layout.info.PagerIndicatorInfo;
import com.urbanairship.android.layout.info.PagerInfo;
import com.urbanairship.android.layout.info.PagerItemInfo;
import com.urbanairship.android.layout.info.RadioInputControllerInfo;
import com.urbanairship.android.layout.info.RadioInputInfo;
import com.urbanairship.android.layout.info.RadioInputToggleLayoutInfo;
import com.urbanairship.android.layout.info.ScoreControllerInfo;
import com.urbanairship.android.layout.info.ScoreInfo;
import com.urbanairship.android.layout.info.ScoreToggleLayoutInfo;
import com.urbanairship.android.layout.info.ScrollLayoutInfo;
import com.urbanairship.android.layout.info.StateControllerInfo;
import com.urbanairship.android.layout.info.StoryIndicatorInfo;
import com.urbanairship.android.layout.info.TextInputInfo;
import com.urbanairship.android.layout.info.ToggleInfo;
import com.urbanairship.android.layout.info.ViewGroupInfo;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.android.layout.info.WebViewInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.model.BasicToggleLayoutModel;
import com.urbanairship.android.layout.model.ButtonLayoutModel;
import com.urbanairship.android.layout.model.CheckboxController;
import com.urbanairship.android.layout.model.CheckboxModel;
import com.urbanairship.android.layout.model.CheckboxToggleLayoutModel;
import com.urbanairship.android.layout.model.ContainerLayoutModel;
import com.urbanairship.android.layout.model.CustomViewModel;
import com.urbanairship.android.layout.model.EmptyModel;
import com.urbanairship.android.layout.model.FormController;
import com.urbanairship.android.layout.model.HorizontalScrollLayoutModel;
import com.urbanairship.android.layout.model.IconModel;
import com.urbanairship.android.layout.model.ImageButtonModel;
import com.urbanairship.android.layout.model.LabelButtonModel;
import com.urbanairship.android.layout.model.LabelModel;
import com.urbanairship.android.layout.model.LinearLayoutModel;
import com.urbanairship.android.layout.model.MediaModel;
import com.urbanairship.android.layout.model.ModelProperties;
import com.urbanairship.android.layout.model.NpsFormController;
import com.urbanairship.android.layout.model.PagerController;
import com.urbanairship.android.layout.model.PagerIndicatorModel;
import com.urbanairship.android.layout.model.PagerModel;
import com.urbanairship.android.layout.model.RadioInputController;
import com.urbanairship.android.layout.model.RadioInputModel;
import com.urbanairship.android.layout.model.RadioInputToggleLayoutModel;
import com.urbanairship.android.layout.model.ScoreController;
import com.urbanairship.android.layout.model.ScoreInputToggleLayoutModel;
import com.urbanairship.android.layout.model.ScoreModel;
import com.urbanairship.android.layout.model.StateController;
import com.urbanairship.android.layout.model.StoryIndicatorModel;
import com.urbanairship.android.layout.model.TextInputModel;
import com.urbanairship.android.layout.model.ToggleModel;
import com.urbanairship.android.layout.model.VerticalScrollLayoutModel;
import com.urbanairship.android.layout.model.WebViewModel;
import com.urbanairship.android.layout.property.Direction;
import com.urbanairship.android.layout.property.ViewType;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.PreferenceCenterPayload;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002%&B\u0005¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0018\u001a\u00060\u0005j\u0002`\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002JZ\u0010\u0019\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2(\u0010\u001c\u001a$\u0012 \u0012\u001e\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0014H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\u0005j\u0002`\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/urbanairship/android/layout/ThomasModelFactory;", "Lcom/urbanairship/android/layout/ModelFactory;", "()V", "processedControllers", "", "", "Lcom/urbanairship/android/layout/Tag;", "Lcom/urbanairship/android/layout/ThomasModelFactory$LayoutNode$Builder;", "processedNodes", "rootTag", "tagIndexMap", "Lcom/urbanairship/android/layout/property/ViewType;", "", "build", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", "create", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/ViewInfo;", "createMutableSharedState", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State;", "generateTag", TCEventPropertiesNames.TCD_MODEL, "node", "Lcom/urbanairship/android/layout/ThomasModelFactory$LayoutNode;", "children", "", "Lkotlin/Pair;", "Lcom/urbanairship/android/layout/info/ItemInfo;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "process", "", "root", "Controllers", "LayoutNode", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelFactory.kt\ncom/urbanairship/android/layout/ThomasModelFactory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,643:1\n1#2:644\n453#3:645\n403#3:646\n453#3:651\n403#3:652\n526#3:657\n511#3,6:658\n1238#4,4:647\n1238#4,4:653\n1549#4:668\n1620#4,3:669\n1549#4:672\n1620#4,3:673\n1549#4:676\n1620#4,3:677\n1549#4:680\n1620#4,3:681\n125#5:664\n152#5,3:665\n*S KotlinDebug\n*F\n+ 1 ModelFactory.kt\ncom/urbanairship/android/layout/ThomasModelFactory\n*L\n197#1:645\n197#1:646\n202#1:651\n202#1:652\n209#1:657\n209#1:658,6\n197#1:647,4\n202#1:653,4\n217#1:668\n217#1:669,3\n368#1:672\n368#1:673,3\n378#1:676\n378#1:677,3\n388#1:680\n388#1:681,3\n212#1:664\n212#1:665,3\n*E\n"})
/* loaded from: classes5.dex */
public final class ThomasModelFactory implements ModelFactory {
    private String rootTag;
    private final Map processedControllers = new LinkedHashMap();
    private final Map processedNodes = new LinkedHashMap();
    private final Map tagIndexMap = new LinkedHashMap();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Direction.values().length];
            try {
                iArr[Direction.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.urbanairship.android.layout.ModelFactory
    @NotNull
    public BaseModel<?, ?, ?> create(@NotNull ViewInfo info, @NotNull ModelEnvironment environment) throws ModelFactoryException {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.rootTag = generateTag(info);
        process(info);
        return build(environment);
    }

    private final String generateTag(ViewInfo info) {
        Object obj = this.tagIndexMap.get(info.getType());
        if (obj == null) {
            obj = 0;
        }
        Number number = (Number) obj;
        this.tagIndexMap.put(info.getType(), Integer.valueOf(number.intValue() + 1));
        int iIntValue = number.intValue();
        StringBuilder sb = new StringBuilder();
        sb.append(info.getType());
        sb.append('_');
        sb.append(iIntValue);
        return sb.toString();
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B;\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\r\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JN\u0010\u0019\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"com/urbanairship/android/layout/ThomasModelFactory$process$StackEntry", "", "tag", "", "Lcom/urbanairship/android/layout/Tag;", "parentTag", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/ItemInfo;", "controllers", "Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;", "pagerPageId", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/android/layout/info/ItemInfo;Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;Ljava/lang/String;)V", "getControllers", "()Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;", "getInfo", "()Lcom/urbanairship/android/layout/info/ItemInfo;", "getPagerPageId", "()Ljava/lang/String;", "getParentTag", "getTag", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/android/layout/info/ItemInfo;Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;Ljava/lang/String;)Lcom/urbanairship/android/layout/ThomasModelFactory$process$StackEntry;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StackEntry {
        private final Controllers.Builder controllers;
        private final ItemInfo info;
        private final String pagerPageId;
        private final String parentTag;
        private final String tag;

        public static /* synthetic */ StackEntry copy$default(StackEntry stackEntry, String str, String str2, ItemInfo itemInfo, Controllers.Builder builder, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stackEntry.tag;
            }
            if ((i & 2) != 0) {
                str2 = stackEntry.parentTag;
            }
            String str4 = str2;
            if ((i & 4) != 0) {
                itemInfo = stackEntry.info;
            }
            ItemInfo itemInfo2 = itemInfo;
            if ((i & 8) != 0) {
                builder = stackEntry.controllers;
            }
            Controllers.Builder builder2 = builder;
            if ((i & 16) != 0) {
                str3 = stackEntry.pagerPageId;
            }
            return stackEntry.copy(str, str4, itemInfo2, builder2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getParentTag() {
            return this.parentTag;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final ItemInfo getInfo() {
            return this.info;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final Controllers.Builder getControllers() {
            return this.controllers;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getPagerPageId() {
            return this.pagerPageId;
        }

        @NotNull
        public final StackEntry copy(@NotNull String tag, @Nullable String parentTag, @NotNull ItemInfo info, @NotNull Controllers.Builder controllers, @Nullable String pagerPageId) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(controllers, "controllers");
            return new StackEntry(tag, parentTag, info, controllers, pagerPageId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StackEntry)) {
                return false;
            }
            StackEntry stackEntry = (StackEntry) other;
            return Intrinsics.areEqual(this.tag, stackEntry.tag) && Intrinsics.areEqual(this.parentTag, stackEntry.parentTag) && Intrinsics.areEqual(this.info, stackEntry.info) && Intrinsics.areEqual(this.controllers, stackEntry.controllers) && Intrinsics.areEqual(this.pagerPageId, stackEntry.pagerPageId);
        }

        public int hashCode() {
            int iHashCode = this.tag.hashCode() * 31;
            String str = this.parentTag;
            int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.info.hashCode()) * 31) + this.controllers.hashCode()) * 31;
            String str2 = this.pagerPageId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "StackEntry(tag=" + this.tag + ", parentTag=" + this.parentTag + ", info=" + this.info + ", controllers=" + this.controllers + ", pagerPageId=" + this.pagerPageId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public StackEntry(@NotNull String tag, @Nullable String str, @NotNull ItemInfo info, @NotNull Controllers.Builder controllers, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(controllers, "controllers");
            this.tag = tag;
            this.parentTag = str;
            this.info = info;
            this.controllers = controllers;
            this.pagerPageId = str2;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        public final String getParentTag() {
            return this.parentTag;
        }

        @NotNull
        public final ItemInfo getInfo() {
            return this.info;
        }

        @NotNull
        public final Controllers.Builder getControllers() {
            return this.controllers;
        }

        @Nullable
        public final String getPagerPageId() {
            return this.pagerPageId;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void process(ViewInfo root) {
        String str;
        String identifier;
        LayoutNode.Builder builder;
        List<String> childTags;
        ArrayDeque arrayDeque = new ArrayDeque();
        Controllers.Builder builder2 = new Controllers.Builder(null, null, null, null, null, null, null, 127, null);
        String str2 = this.rootTag;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootTag");
            str = null;
        } else {
            str = str2;
        }
        arrayDeque.addFirst(new StackEntry(str, null, new ItemInfo.ViewItemInfo(root), builder2, null));
        while (!arrayDeque.isEmpty()) {
            StackEntry stackEntry = (StackEntry) arrayDeque.remove(0);
            String tag = stackEntry.getTag();
            String parentTag = stackEntry.getParentTag();
            ItemInfo info = stackEntry.getInfo();
            Controllers.Builder controllers = stackEntry.getControllers();
            String pagerPageId = stackEntry.getPagerPageId();
            LayoutNode.Builder builder3 = new LayoutNode.Builder(tag, info, null, null, controllers, pagerPageId, 12, null);
            if (parentTag != null && parentTag.length() != 0 && (builder = (LayoutNode.Builder) this.processedNodes.get(parentTag)) != null && (childTags = builder.getChildTags()) != null) {
                childTags.add(builder3.getTag());
            }
            if (info.getType().isController()) {
                controllers = controllers.update(info.getType(), tag);
                this.processedControllers.put(tag, builder3);
                builder3.setControllers(builder3.getControllers().update(info.getType(), tag));
            }
            Controllers.Builder builder4 = controllers;
            this.processedNodes.put(tag, builder3);
            if (info.getInfo() instanceof ViewGroupInfo) {
                List children = ((ViewGroupInfo) info.getInfo()).getChildren();
                int size = children.size() - 1;
                while (-1 < size) {
                    ItemInfo itemInfo = (ItemInfo) children.get(size);
                    String strGenerateTag = generateTag(itemInfo.getInfo());
                    if (pagerPageId == null) {
                        PagerItemInfo pagerItemInfo = itemInfo instanceof PagerItemInfo ? (PagerItemInfo) itemInfo : null;
                        identifier = pagerItemInfo != null ? pagerItemInfo.getIdentifier() : null;
                    } else {
                        identifier = pagerPageId;
                    }
                    arrayDeque.addFirst(new StackEntry(strGenerateTag, tag, itemInfo, builder4, identifier));
                    size--;
                    tag = tag;
                }
            }
        }
    }

    private final BaseModel build(ModelEnvironment environment) throws ModelFactoryException {
        Map map = this.processedControllers;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((LayoutNode.Builder) entry.getValue()).build());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap3.put(entry2.getKey(), createMutableSharedState(((LayoutNode) entry2.getValue()).getInfo().getInfo()));
        }
        while (!this.processedNodes.isEmpty()) {
            Map map2 = this.processedNodes;
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            for (Map.Entry entry3 : map2.entrySet()) {
                if (((LayoutNode.Builder) entry3.getValue()).getChildTags().isEmpty() || linkedHashMap2.keySet().containsAll(((LayoutNode.Builder) entry3.getValue()).getChildTags())) {
                    linkedHashMap4.put(entry3.getKey(), entry3.getValue());
                }
            }
            ArrayList<Pair> arrayList = new ArrayList(linkedHashMap4.size());
            for (Map.Entry entry4 : linkedHashMap4.entrySet()) {
                arrayList.add(TuplesKt.to(entry4.getKey(), ((LayoutNode.Builder) entry4.getValue()).build()));
            }
            for (Pair pair : arrayList) {
                String str = (String) pair.component1();
                LayoutNode layoutNode = (LayoutNode) pair.component2();
                List<String> childTags = layoutNode.getChildTags();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(childTags, 10));
                for (String str2 : childTags) {
                    Pair pair2 = (Pair) linkedHashMap2.get(str2);
                    if (pair2 == null) {
                        throw new ModelFactoryException("Unable to build model. Child with tag '" + str2 + "' is not built yet!");
                    }
                    arrayList2.add(pair2);
                }
                linkedHashMap2.put(str, new Pair(model(layoutNode, arrayList2, environment.withState(layoutNode.getControllers().buildLayoutState(linkedHashMap3, environment.getPagerTracker())), new ModelProperties(layoutNode.getPagerPageId())), layoutNode.getInfo()));
                this.processedNodes.remove(str);
            }
        }
        String str3 = this.rootTag;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootTag");
            str3 = null;
        }
        Pair pair3 = (Pair) linkedHashMap2.get(str3);
        if (pair3 == null) {
            throw new ModelFactoryException("Failed to build models. Root model not found!");
        }
        return (BaseModel) pair3.getFirst();
    }

    private final SharedState createMutableSharedState(ViewInfo info) {
        if (info instanceof FormControllerInfo) {
            FormControllerInfo formControllerInfo = (FormControllerInfo) info;
            return new SharedState(new State.Form(formControllerInfo.getIdentifier(), FormType.Form.INSTANCE, formControllerInfo.getResponseType(), formControllerInfo.getValidationMode(), null, null, false, false, false, null, 1008, null));
        }
        if (info instanceof NpsFormControllerInfo) {
            NpsFormControllerInfo npsFormControllerInfo = (NpsFormControllerInfo) info;
            return new SharedState(new State.Form(npsFormControllerInfo.getIdentifier(), new FormType.Nps(npsFormControllerInfo.getNpsIdentifier()), npsFormControllerInfo.getResponseType(), npsFormControllerInfo.getValidationMode(), null, null, false, false, false, null, 1008, null));
        }
        if (info instanceof RadioInputControllerInfo) {
            return new SharedState(new State.Radio(((RadioInputControllerInfo) info).getIdentifier(), null, false, 6, null));
        }
        if (info instanceof ScoreControllerInfo) {
            return new SharedState(new State.Score(((ScoreControllerInfo) info).getIdentifier(), null, false, 6, null));
        }
        if (info instanceof CheckboxControllerInfo) {
            CheckboxControllerInfo checkboxControllerInfo = (CheckboxControllerInfo) info;
            return new SharedState(new State.Checkbox(checkboxControllerInfo.getIdentifier(), checkboxControllerInfo.getMinSelection(), checkboxControllerInfo.getMaxSelection(), null, false, 24, null));
        }
        if (info instanceof PagerControllerInfo) {
            PagerControllerInfo pagerControllerInfo = (PagerControllerInfo) info;
            return new SharedState(new State.Pager(pagerControllerInfo.getIdentifier(), 0, 0, false, null, null, 0, false, false, false, false, pagerControllerInfo.getBranching(), false, 6142, null));
        }
        if (info instanceof StateControllerInfo) {
            return new SharedState(new State.Layout(null, 1, null));
        }
        return null;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\"B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/urbanairship/android/layout/ThomasModelFactory$LayoutNode;", "", "tag", "", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/ItemInfo;", "childTags", "", "Lcom/urbanairship/android/layout/Tag;", "controllers", "Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers;", "pagerPageId", "(Ljava/lang/String;Lcom/urbanairship/android/layout/info/ItemInfo;Ljava/util/List;Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers;Ljava/lang/String;)V", "getChildTags", "()Ljava/util/List;", "getControllers", "()Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers;", "getInfo", "()Lcom/urbanairship/android/layout/info/ItemInfo;", "getPagerPageId", "()Ljava/lang/String;", "getTag", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Builder", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class LayoutNode {
        private final List childTags;
        private final Controllers controllers;
        private final ItemInfo info;
        private final String pagerPageId;
        private final String tag;

        public static /* synthetic */ LayoutNode copy$default(LayoutNode layoutNode, String str, ItemInfo itemInfo, List list, Controllers controllers, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = layoutNode.tag;
            }
            if ((i & 2) != 0) {
                itemInfo = layoutNode.info;
            }
            ItemInfo itemInfo2 = itemInfo;
            if ((i & 4) != 0) {
                list = layoutNode.childTags;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                controllers = layoutNode.controllers;
            }
            Controllers controllers2 = controllers;
            if ((i & 16) != 0) {
                str2 = layoutNode.pagerPageId;
            }
            return layoutNode.copy(str, itemInfo2, list2, controllers2, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final ItemInfo getInfo() {
            return this.info;
        }

        @NotNull
        public final List<String> component3() {
            return this.childTags;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final Controllers getControllers() {
            return this.controllers;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getPagerPageId() {
            return this.pagerPageId;
        }

        @NotNull
        public final LayoutNode copy(@NotNull String tag, @NotNull ItemInfo info, @NotNull List<String> childTags, @NotNull Controllers controllers, @Nullable String pagerPageId) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(childTags, "childTags");
            Intrinsics.checkNotNullParameter(controllers, "controllers");
            return new LayoutNode(tag, info, childTags, controllers, pagerPageId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LayoutNode)) {
                return false;
            }
            LayoutNode layoutNode = (LayoutNode) other;
            return Intrinsics.areEqual(this.tag, layoutNode.tag) && Intrinsics.areEqual(this.info, layoutNode.info) && Intrinsics.areEqual(this.childTags, layoutNode.childTags) && Intrinsics.areEqual(this.controllers, layoutNode.controllers) && Intrinsics.areEqual(this.pagerPageId, layoutNode.pagerPageId);
        }

        public int hashCode() {
            int iHashCode = ((((((this.tag.hashCode() * 31) + this.info.hashCode()) * 31) + this.childTags.hashCode()) * 31) + this.controllers.hashCode()) * 31;
            String str = this.pagerPageId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "LayoutNode(tag=" + this.tag + ", info=" + this.info + ", childTags=" + this.childTags + ", controllers=" + this.controllers + ", pagerPageId=" + this.pagerPageId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public LayoutNode(@NotNull String tag, @NotNull ItemInfo info, @NotNull List<String> childTags, @NotNull Controllers controllers, @Nullable String str) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(childTags, "childTags");
            Intrinsics.checkNotNullParameter(controllers, "controllers");
            this.tag = tag;
            this.info = info;
            this.childTags = childTags;
            this.controllers = controllers;
            this.pagerPageId = str;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        @NotNull
        public final ItemInfo getInfo() {
            return this.info;
        }

        @NotNull
        public final List<String> getChildTags() {
            return this.childTags;
        }

        @NotNull
        public final Controllers getControllers() {
            return this.controllers;
        }

        @Nullable
        public final String getPagerPageId() {
            return this.pagerPageId;
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\"\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019¨\u0006-"}, d2 = {"Lcom/urbanairship/android/layout/ThomasModelFactory$LayoutNode$Builder;", "", "tag", "", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/ItemInfo;", "childTags", "", "Lcom/urbanairship/android/layout/Tag;", "style", "controllers", "Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;", "pagerPageId", "(Ljava/lang/String;Lcom/urbanairship/android/layout/info/ItemInfo;Ljava/util/List;Ljava/lang/String;Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;Ljava/lang/String;)V", "getChildTags", "()Ljava/util/List;", "getControllers", "()Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;", "setControllers", "(Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;)V", "getInfo", "()Lcom/urbanairship/android/layout/info/ItemInfo;", "setInfo", "(Lcom/urbanairship/android/layout/info/ItemInfo;)V", "getPagerPageId", "()Ljava/lang/String;", "getStyle", "setStyle", "(Ljava/lang/String;)V", "getTag", "build", "Lcom/urbanairship/android/layout/ThomasModelFactory$LayoutNode;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Builder {
            private final List childTags;
            private Controllers.Builder controllers;
            private ItemInfo info;
            private final String pagerPageId;
            private String style;
            private final String tag;

            public static /* synthetic */ Builder copy$default(Builder builder, String str, ItemInfo itemInfo, List list, String str2, Controllers.Builder builder2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = builder.tag;
                }
                if ((i & 2) != 0) {
                    itemInfo = builder.info;
                }
                ItemInfo itemInfo2 = itemInfo;
                if ((i & 4) != 0) {
                    list = builder.childTags;
                }
                List list2 = list;
                if ((i & 8) != 0) {
                    str2 = builder.style;
                }
                String str4 = str2;
                if ((i & 16) != 0) {
                    builder2 = builder.controllers;
                }
                Controllers.Builder builder3 = builder2;
                if ((i & 32) != 0) {
                    str3 = builder.pagerPageId;
                }
                return builder.copy(str, itemInfo2, list2, str4, builder3, str3);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getTag() {
                return this.tag;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final ItemInfo getInfo() {
                return this.info;
            }

            @NotNull
            public final List<String> component3() {
                return this.childTags;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final String getStyle() {
                return this.style;
            }

            @NotNull
            /* renamed from: component5, reason: from getter */
            public final Controllers.Builder getControllers() {
                return this.controllers;
            }

            @Nullable
            /* renamed from: component6, reason: from getter */
            public final String getPagerPageId() {
                return this.pagerPageId;
            }

            @NotNull
            public final Builder copy(@NotNull String tag, @NotNull ItemInfo info, @NotNull List<String> childTags, @Nullable String style, @NotNull Controllers.Builder controllers, @Nullable String pagerPageId) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(childTags, "childTags");
                Intrinsics.checkNotNullParameter(controllers, "controllers");
                return new Builder(tag, info, childTags, style, controllers, pagerPageId);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Builder)) {
                    return false;
                }
                Builder builder = (Builder) other;
                return Intrinsics.areEqual(this.tag, builder.tag) && Intrinsics.areEqual(this.info, builder.info) && Intrinsics.areEqual(this.childTags, builder.childTags) && Intrinsics.areEqual(this.style, builder.style) && Intrinsics.areEqual(this.controllers, builder.controllers) && Intrinsics.areEqual(this.pagerPageId, builder.pagerPageId);
            }

            public int hashCode() {
                int iHashCode = ((((this.tag.hashCode() * 31) + this.info.hashCode()) * 31) + this.childTags.hashCode()) * 31;
                String str = this.style;
                int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.controllers.hashCode()) * 31;
                String str2 = this.pagerPageId;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Builder(tag=" + this.tag + ", info=" + this.info + ", childTags=" + this.childTags + ", style=" + this.style + ", controllers=" + this.controllers + ", pagerPageId=" + this.pagerPageId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Builder(@NotNull String tag, @NotNull ItemInfo info, @NotNull List<String> childTags, @Nullable String str, @NotNull Controllers.Builder controllers, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(info, "info");
                Intrinsics.checkNotNullParameter(childTags, "childTags");
                Intrinsics.checkNotNullParameter(controllers, "controllers");
                this.tag = tag;
                this.info = info;
                this.childTags = childTags;
                this.style = str;
                this.controllers = controllers;
                this.pagerPageId = str2;
            }

            @NotNull
            public final String getTag() {
                return this.tag;
            }

            @NotNull
            public final ItemInfo getInfo() {
                return this.info;
            }

            public final void setInfo(@NotNull ItemInfo itemInfo) {
                Intrinsics.checkNotNullParameter(itemInfo, "<set-?>");
                this.info = itemInfo;
            }

            public /* synthetic */ Builder(String str, ItemInfo itemInfo, List list, String str2, Controllers.Builder builder, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, itemInfo, (i & 4) != 0 ? new ArrayList() : list, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? new Controllers.Builder(null, null, null, null, null, null, null, 127, null) : builder, str3);
            }

            @NotNull
            public final List<String> getChildTags() {
                return this.childTags;
            }

            @Nullable
            public final String getStyle() {
                return this.style;
            }

            public final void setStyle(@Nullable String str) {
                this.style = str;
            }

            @NotNull
            public final Controllers.Builder getControllers() {
                return this.controllers;
            }

            public final void setControllers(@NotNull Controllers.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "<set-?>");
                this.controllers = builder;
            }

            @Nullable
            public final String getPagerPageId() {
                return this.pagerPageId;
            }

            @NotNull
            public final LayoutNode build() {
                return new LayoutNode(this.tag, this.info, CollectionsKt.toList(this.childTags), this.controllers.build(), this.pagerPageId);
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001,Bw\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u000e\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u000e\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u000e\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u000e\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\fJ0\u0010\u0016\u001a\u00020\u00172\u001e\u0010\u0018\u001a\u001a\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a0\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0013\u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010 \u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010!\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010#\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0089\u0001\u0010%\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0019\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0019\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0019\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006-"}, d2 = {"Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers;", "", PreferenceCenterPayload.KEY_FORM, "", "", "Lcom/urbanairship/android/layout/Tag;", "pager", "checkbox", "radio", FirebaseAnalytics.Param.SCORE, "layout", "story", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCheckbox", "()Ljava/lang/String;", "getForm", "()Ljava/util/List;", "getLayout", "getPager", "getRadio", "getScore", "getStory", "buildLayoutState", "Lcom/urbanairship/android/layout/environment/LayoutState;", "states", "", "Lcom/urbanairship/android/layout/environment/SharedState;", "Lcom/urbanairship/android/layout/environment/State;", "pagerTracker", "Lcom/urbanairship/android/layout/environment/PagersViewTracker;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Builder", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nModelFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModelFactory.kt\ncom/urbanairship/android/layout/ThomasModelFactory$Controllers\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,643:1\n1#2:644\n*E\n"})
    public static final /* data */ class Controllers {
        private final String checkbox;
        private final List form;
        private final String layout;
        private final String pager;
        private final String radio;
        private final String score;
        private final String story;

        public static /* synthetic */ Controllers copy$default(Controllers controllers, List list, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                list = controllers.form;
            }
            if ((i & 2) != 0) {
                str = controllers.pager;
            }
            String str7 = str;
            if ((i & 4) != 0) {
                str2 = controllers.checkbox;
            }
            String str8 = str2;
            if ((i & 8) != 0) {
                str3 = controllers.radio;
            }
            String str9 = str3;
            if ((i & 16) != 0) {
                str4 = controllers.score;
            }
            String str10 = str4;
            if ((i & 32) != 0) {
                str5 = controllers.layout;
            }
            String str11 = str5;
            if ((i & 64) != 0) {
                str6 = controllers.story;
            }
            return controllers.copy(list, str7, str8, str9, str10, str11, str6);
        }

        @NotNull
        public final List<String> component1() {
            return this.form;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getPager() {
            return this.pager;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getCheckbox() {
            return this.checkbox;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getRadio() {
            return this.radio;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getScore() {
            return this.score;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getLayout() {
            return this.layout;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getStory() {
            return this.story;
        }

        @NotNull
        public final Controllers copy(@NotNull List<String> form, @Nullable String pager, @Nullable String checkbox, @Nullable String radio, @Nullable String score, @Nullable String layout, @Nullable String story) {
            Intrinsics.checkNotNullParameter(form, "form");
            return new Controllers(form, pager, checkbox, radio, score, layout, story);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Controllers)) {
                return false;
            }
            Controllers controllers = (Controllers) other;
            return Intrinsics.areEqual(this.form, controllers.form) && Intrinsics.areEqual(this.pager, controllers.pager) && Intrinsics.areEqual(this.checkbox, controllers.checkbox) && Intrinsics.areEqual(this.radio, controllers.radio) && Intrinsics.areEqual(this.score, controllers.score) && Intrinsics.areEqual(this.layout, controllers.layout) && Intrinsics.areEqual(this.story, controllers.story);
        }

        public int hashCode() {
            int iHashCode = this.form.hashCode() * 31;
            String str = this.pager;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.checkbox;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.radio;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.score;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.layout;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.story;
            return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Controllers(form=" + this.form + ", pager=" + this.pager + ", checkbox=" + this.checkbox + ", radio=" + this.radio + ", score=" + this.score + ", layout=" + this.layout + ", story=" + this.story + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Controllers(@NotNull List<String> form, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            Intrinsics.checkNotNullParameter(form, "form");
            this.form = form;
            this.pager = str;
            this.checkbox = str2;
            this.radio = str3;
            this.score = str4;
            this.layout = str5;
            this.story = str6;
        }

        @NotNull
        public final List<String> getForm() {
            return this.form;
        }

        @Nullable
        public final String getPager() {
            return this.pager;
        }

        @Nullable
        public final String getCheckbox() {
            return this.checkbox;
        }

        @Nullable
        public final String getRadio() {
            return this.radio;
        }

        @Nullable
        public final String getScore() {
            return this.score;
        }

        @Nullable
        public final String getLayout() {
            return this.layout;
        }

        @Nullable
        public final String getStory() {
            return this.story;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.android.layout.environment.LayoutState buildLayoutState(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, com.urbanairship.android.layout.environment.SharedState<com.urbanairship.android.layout.environment.State>> r18, @org.jetbrains.annotations.Nullable com.urbanairship.android.layout.environment.PagersViewTracker r19) {
            /*
                Method dump skipped, instructions count: 212
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.ThomasModelFactory.Controllers.buildLayoutState(java.util.Map, com.urbanairship.android.layout.environment.PagersViewTracker):com.urbanairship.android.layout.environment.LayoutState");
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0013\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003HÆ\u0003J\u0011\u0010 \u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010!\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010\"\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010#\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0011\u0010%\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0003J\u0089\u0001\u0010&\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001J\u001a\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\n\u00100\u001a\u00060\u0004j\u0002`\u0005R\"\u0010\u0007\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\n\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\"\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\t\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010¨\u00061"}, d2 = {"Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers$Builder;", "", PreferenceCenterPayload.KEY_FORM, "", "", "Lcom/urbanairship/android/layout/Tag;", "pager", "checkbox", "radio", FirebaseAnalytics.Param.SCORE, "layout", "story", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCheckbox", "()Ljava/lang/String;", "setCheckbox", "(Ljava/lang/String;)V", "getForm", "()Ljava/util/List;", "getLayout", "setLayout", "getPager", "setPager", "getRadio", "setRadio", "getScore", "setScore", "getStory", "setStory", "build", "Lcom/urbanairship/android/layout/ThomasModelFactory$Controllers;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "update", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "tag", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Builder {
            private String checkbox;
            private final List form;
            private String layout;
            private String pager;
            private String radio;
            private String score;
            private String story;

            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ViewType.values().length];
                    try {
                        iArr[ViewType.FORM_CONTROLLER.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ViewType.NPS_FORM_CONTROLLER.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ViewType.PAGER_CONTROLLER.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[ViewType.CHECKBOX_CONTROLLER.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[ViewType.RADIO_INPUT_CONTROLLER.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[ViewType.SCORE_CONTROLLER.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[ViewType.STATE_CONTROLLER.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[ViewType.STORY_INDICATOR.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public Builder() {
                this(null, null, null, null, null, null, null, 127, null);
            }

            public static /* synthetic */ Builder copy$default(Builder builder, List list, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = builder.form;
                }
                if ((i & 2) != 0) {
                    str = builder.pager;
                }
                String str7 = str;
                if ((i & 4) != 0) {
                    str2 = builder.checkbox;
                }
                String str8 = str2;
                if ((i & 8) != 0) {
                    str3 = builder.radio;
                }
                String str9 = str3;
                if ((i & 16) != 0) {
                    str4 = builder.score;
                }
                String str10 = str4;
                if ((i & 32) != 0) {
                    str5 = builder.layout;
                }
                String str11 = str5;
                if ((i & 64) != 0) {
                    str6 = builder.story;
                }
                return builder.copy(list, str7, str8, str9, str10, str11, str6);
            }

            @NotNull
            public final List<String> component1() {
                return this.form;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final String getPager() {
                return this.pager;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final String getCheckbox() {
                return this.checkbox;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final String getRadio() {
                return this.radio;
            }

            @Nullable
            /* renamed from: component5, reason: from getter */
            public final String getScore() {
                return this.score;
            }

            @Nullable
            /* renamed from: component6, reason: from getter */
            public final String getLayout() {
                return this.layout;
            }

            @Nullable
            /* renamed from: component7, reason: from getter */
            public final String getStory() {
                return this.story;
            }

            @NotNull
            public final Builder copy(@NotNull List<String> form, @Nullable String pager, @Nullable String checkbox, @Nullable String radio, @Nullable String score, @Nullable String layout, @Nullable String story) {
                Intrinsics.checkNotNullParameter(form, "form");
                return new Builder(form, pager, checkbox, radio, score, layout, story);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Builder)) {
                    return false;
                }
                Builder builder = (Builder) other;
                return Intrinsics.areEqual(this.form, builder.form) && Intrinsics.areEqual(this.pager, builder.pager) && Intrinsics.areEqual(this.checkbox, builder.checkbox) && Intrinsics.areEqual(this.radio, builder.radio) && Intrinsics.areEqual(this.score, builder.score) && Intrinsics.areEqual(this.layout, builder.layout) && Intrinsics.areEqual(this.story, builder.story);
            }

            public int hashCode() {
                int iHashCode = this.form.hashCode() * 31;
                String str = this.pager;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.checkbox;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.radio;
                int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.score;
                int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.layout;
                int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.story;
                return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "Builder(form=" + this.form + ", pager=" + this.pager + ", checkbox=" + this.checkbox + ", radio=" + this.radio + ", score=" + this.score + ", layout=" + this.layout + ", story=" + this.story + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Builder(@NotNull List<String> form, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
                Intrinsics.checkNotNullParameter(form, "form");
                this.form = form;
                this.pager = str;
                this.checkbox = str2;
                this.radio = str3;
                this.score = str4;
                this.layout = str5;
                this.story = str6;
            }

            public /* synthetic */ Builder(List list, String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) == 0 ? str6 : null);
            }

            @NotNull
            public final List<String> getForm() {
                return this.form;
            }

            @Nullable
            public final String getPager() {
                return this.pager;
            }

            public final void setPager(@Nullable String str) {
                this.pager = str;
            }

            @Nullable
            public final String getCheckbox() {
                return this.checkbox;
            }

            public final void setCheckbox(@Nullable String str) {
                this.checkbox = str;
            }

            @Nullable
            public final String getRadio() {
                return this.radio;
            }

            public final void setRadio(@Nullable String str) {
                this.radio = str;
            }

            @Nullable
            public final String getScore() {
                return this.score;
            }

            public final void setScore(@Nullable String str) {
                this.score = str;
            }

            @Nullable
            public final String getLayout() {
                return this.layout;
            }

            public final void setLayout(@Nullable String str) {
                this.layout = str;
            }

            @Nullable
            public final String getStory() {
                return this.story;
            }

            public final void setStory(@Nullable String str) {
                this.story = str;
            }

            @NotNull
            public final Builder update(@NotNull ViewType type, @NotNull String tag) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(tag, "tag");
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                    case 2:
                        return copy$default(this, CollectionsKt.plus((Collection) CollectionsKt.listOf(tag), (Iterable) this.form), null, null, null, null, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
                    case 3:
                        return copy$default(this, null, tag, null, null, null, null, null, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH, null);
                    case 4:
                        return copy$default(this, null, null, tag, null, null, null, null, 123, null);
                    case 5:
                        return copy$default(this, null, null, null, tag, null, null, null, 119, null);
                    case 6:
                        return copy$default(this, null, null, null, null, tag, null, null, 111, null);
                    case 7:
                        return copy$default(this, null, null, null, null, null, tag, null, 95, null);
                    case 8:
                        return copy$default(this, null, null, null, null, null, null, tag, 63, null);
                    default:
                        return this;
                }
            }

            @NotNull
            public final Controllers build() {
                return new Controllers(CollectionsKt.toList(this.form), this.pager, this.checkbox, this.radio, this.score, this.layout, this.story);
            }
        }
    }

    private final BaseModel model(LayoutNode node, List children, ModelEnvironment environment, ModelProperties properties) throws ModelFactoryException {
        BaseModel stateController;
        ViewInfo info = node.getInfo().getInfo();
        if (info instanceof ViewGroupInfo) {
            ViewGroupInfo viewGroupInfo = (ViewGroupInfo) info;
            if (viewGroupInfo instanceof ContainerLayoutInfo) {
                ContainerLayoutInfo containerLayoutInfo = (ContainerLayoutInfo) info;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
                Iterator it = children.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    BaseModel baseModel = (BaseModel) pair.component1();
                    ItemInfo itemInfo = (ItemInfo) pair.component2();
                    ContainerLayoutItemInfo containerLayoutItemInfo = itemInfo instanceof ContainerLayoutItemInfo ? (ContainerLayoutItemInfo) itemInfo : null;
                    if (containerLayoutItemInfo == null) {
                        throw new ModelFactoryException("ContainerLayoutItemInfo expected");
                    }
                    arrayList.add(new ContainerLayoutModel.Item(containerLayoutItemInfo, baseModel));
                }
                return new ContainerLayoutModel(containerLayoutInfo, arrayList, environment, properties);
            }
            if (viewGroupInfo instanceof LinearLayoutInfo) {
                LinearLayoutInfo linearLayoutInfo = (LinearLayoutInfo) info;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
                Iterator it2 = children.iterator();
                while (it2.hasNext()) {
                    Pair pair2 = (Pair) it2.next();
                    BaseModel baseModel2 = (BaseModel) pair2.component1();
                    ItemInfo itemInfo2 = (ItemInfo) pair2.component2();
                    LinearLayoutItemInfo linearLayoutItemInfo = itemInfo2 instanceof LinearLayoutItemInfo ? (LinearLayoutItemInfo) itemInfo2 : null;
                    if (linearLayoutItemInfo == null) {
                        throw new ModelFactoryException("LinearLayoutItemInfo expected");
                    }
                    arrayList2.add(new LinearLayoutModel.Item(linearLayoutItemInfo, baseModel2));
                }
                return new LinearLayoutModel(linearLayoutInfo, arrayList2, environment, properties);
            }
            if (viewGroupInfo instanceof PagerInfo) {
                PagerInfo pagerInfo = (PagerInfo) info;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(children, 10));
                Iterator it3 = children.iterator();
                while (it3.hasNext()) {
                    Pair pair3 = (Pair) it3.next();
                    BaseModel baseModel3 = (BaseModel) pair3.component1();
                    ItemInfo itemInfo3 = (ItemInfo) pair3.component2();
                    if ((itemInfo3 instanceof PagerItemInfo ? (PagerItemInfo) itemInfo3 : null) != null) {
                        PagerItemInfo pagerItemInfo = (PagerItemInfo) itemInfo3;
                        arrayList3.add(new PagerModel.Item(baseModel3, pagerItemInfo.getIdentifier(), pagerItemInfo.getDisplayActions(), pagerItemInfo.getAutomatedActions(), pagerItemInfo.getAccessibilityActions(), pagerItemInfo.getStateActions(), pagerItemInfo.getBranching()));
                    } else {
                        throw new ModelFactoryException("PagerItemInfo expected");
                    }
                }
                SharedState<State.Pager> pager = environment.getLayoutState().getPager();
                if (pager != null) {
                    return new PagerModel(pagerInfo, arrayList3, pager, environment, properties);
                }
                throw new ModelFactoryException("Required pager state was null for PagerController!");
            }
            if (viewGroupInfo instanceof ScrollLayoutInfo) {
                ScrollLayoutInfo scrollLayoutInfo = (ScrollLayoutInfo) info;
                int i = WhenMappings.$EnumSwitchMapping$0[scrollLayoutInfo.getDirection().ordinal()];
                if (i == 1) {
                    stateController = new VerticalScrollLayoutModel(scrollLayoutInfo, (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst(), environment, properties);
                } else {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    stateController = new HorizontalScrollLayoutModel(scrollLayoutInfo, (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst(), environment, properties);
                }
            } else {
                if (viewGroupInfo instanceof ButtonLayoutInfo) {
                    return new ButtonLayoutModel((ButtonLayoutInfo) info, (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst(), environment.getLayoutState().getThomasForm(), environment.getLayoutState().getPager(), environment, properties);
                }
                if (viewGroupInfo instanceof FormControllerInfo) {
                    FormControllerInfo formControllerInfo = (FormControllerInfo) info;
                    BaseModel baseModel4 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                    ThomasForm thomasForm = environment.getLayoutState().getThomasForm();
                    if (thomasForm != null) {
                        return new FormController(formControllerInfo, baseModel4, thomasForm, environment.getLayoutState().getParentForm(), environment.getLayoutState().getPager(), environment, properties);
                    }
                    throw new ModelFactoryException("Required form state was null for FormController!");
                }
                if (viewGroupInfo instanceof NpsFormControllerInfo) {
                    NpsFormControllerInfo npsFormControllerInfo = (NpsFormControllerInfo) info;
                    BaseModel baseModel5 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                    ThomasForm thomasForm2 = environment.getLayoutState().getThomasForm();
                    if (thomasForm2 != null) {
                        return new NpsFormController(npsFormControllerInfo, baseModel5, thomasForm2, environment.getLayoutState().getParentForm(), environment.getLayoutState().getPager(), environment, properties);
                    }
                    throw new ModelFactoryException("Required form state was null for NpsFormController!");
                }
                if (viewGroupInfo instanceof PagerControllerInfo) {
                    BaseModel baseModel6 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                    SharedState<State.Pager> pager2 = environment.getLayoutState().getPager();
                    if (pager2 == null) {
                        throw new ModelFactoryException("Required pager state was null for PagerController!");
                    }
                    PagerControllerInfo pagerControllerInfo = (PagerControllerInfo) info;
                    return new PagerController(pagerControllerInfo, baseModel6, pagerControllerInfo.getBranching(), pager2, environment, properties);
                }
                if (viewGroupInfo instanceof CheckboxControllerInfo) {
                    CheckboxControllerInfo checkboxControllerInfo = (CheckboxControllerInfo) info;
                    BaseModel baseModel7 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                    ThomasForm thomasForm3 = environment.getLayoutState().getThomasForm();
                    if (thomasForm3 == null) {
                        throw new ModelFactoryException("Required form state was null for CheckboxController!");
                    }
                    SharedState<State.Checkbox> checkbox = environment.getLayoutState().getCheckbox();
                    if (checkbox != null) {
                        return new CheckboxController(checkboxControllerInfo, baseModel7, thomasForm3, checkbox, environment, properties);
                    }
                    throw new ModelFactoryException("Required checkbox state was null for CheckboxController!");
                }
                if (viewGroupInfo instanceof RadioInputControllerInfo) {
                    RadioInputControllerInfo radioInputControllerInfo = (RadioInputControllerInfo) info;
                    BaseModel baseModel8 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                    ThomasForm thomasForm4 = environment.getLayoutState().getThomasForm();
                    if (thomasForm4 == null) {
                        throw new ModelFactoryException("Required form state was null for RadioInputController!");
                    }
                    SharedState<State.Radio> radio = environment.getLayoutState().getRadio();
                    if (radio != null) {
                        return new RadioInputController(radioInputControllerInfo, baseModel8, thomasForm4, radio, environment, properties);
                    }
                    throw new ModelFactoryException("Required radio state was null for RadioInputController!");
                }
                if (viewGroupInfo instanceof ScoreControllerInfo) {
                    ScoreControllerInfo scoreControllerInfo = (ScoreControllerInfo) info;
                    BaseModel baseModel9 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                    ThomasForm thomasForm5 = environment.getLayoutState().getThomasForm();
                    if (thomasForm5 == null) {
                        throw new ModelFactoryException("Required form state(score) was null for ScoreController!");
                    }
                    SharedState<State.Score> score = environment.getLayoutState().getScore();
                    if (score != null) {
                        return new ScoreController(scoreControllerInfo, baseModel9, thomasForm5, score, environment, properties);
                    }
                    throw new ModelFactoryException("Required radio state(score) was null for ScoreController!");
                }
                if (viewGroupInfo instanceof StateControllerInfo) {
                    stateController = new StateController((StateControllerInfo) info, (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst(), environment, properties);
                } else {
                    if (viewGroupInfo instanceof BasicToggleLayoutInfo) {
                        BasicToggleLayoutInfo basicToggleLayoutInfo = (BasicToggleLayoutInfo) info;
                        BaseModel baseModel10 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                        ThomasForm thomasForm6 = environment.getLayoutState().getThomasForm();
                        if (thomasForm6 != null) {
                            return new BasicToggleLayoutModel(basicToggleLayoutInfo, baseModel10, thomasForm6, environment, properties);
                        }
                        throw new ModelFactoryException("Required form state was null for RadioInputController!");
                    }
                    if (viewGroupInfo instanceof CheckboxToggleLayoutInfo) {
                        CheckboxToggleLayoutInfo checkboxToggleLayoutInfo = (CheckboxToggleLayoutInfo) info;
                        BaseModel baseModel11 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                        SharedState<State.Checkbox> checkbox2 = environment.getLayoutState().getCheckbox();
                        if (checkbox2 == null) {
                            throw new ModelFactoryException("Required checkbox state was null for CheckboxController!");
                        }
                        ThomasForm thomasForm7 = environment.getLayoutState().getThomasForm();
                        if (thomasForm7 != null) {
                            return new CheckboxToggleLayoutModel(checkboxToggleLayoutInfo, baseModel11, checkbox2, thomasForm7, environment, properties);
                        }
                        throw new ModelFactoryException("Required form state was null for RadioInputController!");
                    }
                    if (viewGroupInfo instanceof RadioInputToggleLayoutInfo) {
                        RadioInputToggleLayoutInfo radioInputToggleLayoutInfo = (RadioInputToggleLayoutInfo) info;
                        BaseModel baseModel12 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                        SharedState<State.Radio> radio2 = environment.getLayoutState().getRadio();
                        if (radio2 == null) {
                            throw new ModelFactoryException("Required radio state was null for RadioInputController!");
                        }
                        ThomasForm thomasForm8 = environment.getLayoutState().getThomasForm();
                        if (thomasForm8 != null) {
                            return new RadioInputToggleLayoutModel(radioInputToggleLayoutInfo, baseModel12, radio2, thomasForm8, environment, properties);
                        }
                        throw new ModelFactoryException("Required form state was null for RadioInputController!");
                    }
                    if (viewGroupInfo instanceof ScoreToggleLayoutInfo) {
                        ScoreToggleLayoutInfo scoreToggleLayoutInfo = (ScoreToggleLayoutInfo) info;
                        BaseModel baseModel13 = (BaseModel) ((Pair) CollectionsKt.first(children)).getFirst();
                        SharedState<State.Score> score2 = environment.getLayoutState().getScore();
                        if (score2 == null) {
                            throw new ModelFactoryException("Required score state was null for ScoreToggleLayout!");
                        }
                        ThomasForm thomasForm9 = environment.getLayoutState().getThomasForm();
                        if (thomasForm9 != null) {
                            return new ScoreInputToggleLayoutModel(scoreToggleLayoutInfo, baseModel13, score2, thomasForm9, environment, properties);
                        }
                        throw new ModelFactoryException("Required form state(score) was null for RadioInputController!");
                    }
                    throw new ModelFactoryException("Unsupported view type: " + info.getClass().getName());
                }
            }
            return stateController;
        }
        if (info instanceof EmptyInfo) {
            return new EmptyModel((EmptyInfo) info, environment, properties);
        }
        if (info instanceof WebViewInfo) {
            return new WebViewModel((WebViewInfo) info, environment, properties);
        }
        if (info instanceof MediaInfo) {
            return new MediaModel((MediaInfo) info, environment.getLayoutState().getPager(), environment, properties);
        }
        if (info instanceof LabelInfo) {
            return new LabelModel((LabelInfo) info, environment, properties);
        }
        if (info instanceof LabelButtonInfo) {
            LabelButtonInfo labelButtonInfo = (LabelButtonInfo) info;
            return new LabelButtonModel(labelButtonInfo, new LabelModel(labelButtonInfo.getLabel(), environment, properties), environment.getLayoutState().getThomasForm(), environment.getLayoutState().getPager(), environment, properties);
        }
        if (info instanceof ImageButtonInfo) {
            return new ImageButtonModel((ImageButtonInfo) info, environment.getLayoutState().getThomasForm(), environment.getLayoutState().getPager(), environment, properties);
        }
        if (info instanceof PagerIndicatorInfo) {
            return new PagerIndicatorModel((PagerIndicatorInfo) info, environment, properties);
        }
        if (info instanceof StoryIndicatorInfo) {
            return new StoryIndicatorModel((StoryIndicatorInfo) info, environment, properties);
        }
        if (info instanceof CheckboxInfo) {
            CheckboxInfo checkboxInfo = (CheckboxInfo) info;
            SharedState<State.Checkbox> checkbox3 = environment.getLayoutState().getCheckbox();
            if (checkbox3 == null) {
                throw new ModelFactoryException("Required checkbox state was null for CheckboxModel!");
            }
            ThomasForm thomasForm10 = environment.getLayoutState().getThomasForm();
            if (thomasForm10 != null) {
                return new CheckboxModel(checkboxInfo, checkbox3, thomasForm10, environment, properties);
            }
            throw new ModelFactoryException("Required form state was null for CheckboxModel!");
        }
        if (info instanceof ToggleInfo) {
            ToggleInfo toggleInfo = (ToggleInfo) info;
            ThomasForm thomasForm11 = environment.getLayoutState().getThomasForm();
            if (thomasForm11 != null) {
                return new ToggleModel(toggleInfo, thomasForm11, environment, properties);
            }
            throw new ModelFactoryException("Required form state was null for ToggleModel!");
        }
        if (info instanceof RadioInputInfo) {
            RadioInputInfo radioInputInfo = (RadioInputInfo) info;
            SharedState<State.Radio> radio3 = environment.getLayoutState().getRadio();
            if (radio3 == null) {
                throw new ModelFactoryException("Required radio state was null for RadioInputModel!");
            }
            ThomasForm thomasForm12 = environment.getLayoutState().getThomasForm();
            if (thomasForm12 != null) {
                return new RadioInputModel(radioInputInfo, radio3, thomasForm12, environment, properties);
            }
            throw new ModelFactoryException("Required form state was null for RadioInputModel!");
        }
        if (info instanceof TextInputInfo) {
            TextInputInfo textInputInfo = (TextInputInfo) info;
            ThomasForm thomasForm13 = environment.getLayoutState().getThomasForm();
            if (thomasForm13 != null) {
                return new TextInputModel(textInputInfo, thomasForm13, environment, properties);
            }
            throw new ModelFactoryException("Required form state was null for TextInputModel!");
        }
        if (info instanceof ScoreInfo) {
            ScoreInfo scoreInfo = (ScoreInfo) info;
            ThomasForm thomasForm14 = environment.getLayoutState().getThomasForm();
            if (thomasForm14 != null) {
                return new ScoreModel(scoreInfo, thomasForm14, environment, properties);
            }
            throw new ModelFactoryException("Required form state was null for ScoreModel!");
        }
        if (info instanceof CustomViewInfo) {
            return new CustomViewModel((CustomViewInfo) info, environment, properties);
        }
        if (info instanceof IconViewInfo) {
            return new IconModel((IconViewInfo) info, environment, properties);
        }
        throw new ModelFactoryException("Unsupported view type: " + info.getClass().getName());
    }
}
