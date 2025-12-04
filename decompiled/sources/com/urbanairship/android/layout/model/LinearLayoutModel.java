package com.urbanairship.android.layout.model;

import android.content.Context;
import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.android.layout.environment.ModelEnvironment;
import com.urbanairship.android.layout.environment.ViewEnvironment;
import com.urbanairship.android.layout.info.LinearLayoutInfo;
import com.urbanairship.android.layout.info.LinearLayoutItemInfo;
import com.urbanairship.android.layout.model.BaseModel;
import com.urbanairship.android.layout.view.LinearLayoutView;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001dB+\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\"\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u001a\u0010\u000e\u001a\u00020\u000fX\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/android/layout/model/LinearLayoutModel;", "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/view/LinearLayoutView;", "Lcom/urbanairship/android/layout/info/LinearLayoutInfo;", "Lcom/urbanairship/android/layout/model/BaseModel$Listener;", "viewInfo", "items", "", "Lcom/urbanairship/android/layout/model/LinearLayoutModel$Item;", "environment", "Lcom/urbanairship/android/layout/environment/ModelEnvironment;", CustomEvent.PROPERTIES, "Lcom/urbanairship/android/layout/model/ModelProperties;", "(Lcom/urbanairship/android/layout/info/LinearLayoutInfo;Ljava/util/List;Lcom/urbanairship/android/layout/environment/ModelEnvironment;Lcom/urbanairship/android/layout/model/ModelProperties;)V", "isShrinkable", "", "isShrinkable$urbanairship_layout_release", "()Z", "setShrinkable$urbanairship_layout_release", "(Z)V", "getItems", "()Ljava/util/List;", "onCreateView", "context", "Landroid/content/Context;", "viewEnvironment", "Lcom/urbanairship/android/layout/environment/ViewEnvironment;", "itemProperties", "Lcom/urbanairship/android/layout/model/ItemProperties;", "Item", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLinearLayoutModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LinearLayoutModel.kt\ncom/urbanairship/android/layout/model/LinearLayoutModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n1747#2,3:38\n*S KotlinDebug\n*F\n+ 1 LinearLayoutModel.kt\ncom/urbanairship/android/layout/model/LinearLayoutModel\n*L\n23#1:38,3\n*E\n"})
/* loaded from: classes5.dex */
public final class LinearLayoutModel extends BaseModel<LinearLayoutView, LinearLayoutInfo, BaseModel.Listener> {
    private boolean isShrinkable;
    private final List items;

    @NotNull
    public final List<Item> getItems() {
        return this.items;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinearLayoutModel(@NotNull LinearLayoutInfo viewInfo, @NotNull List<Item> items, @NotNull ModelEnvironment environment, @NotNull ModelProperties properties) {
        super(viewInfo, environment, properties, null, 8, null);
        Intrinsics.checkNotNullParameter(viewInfo, "viewInfo");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.items = items;
        boolean z = false;
        if (items == null || !items.isEmpty()) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((Item) it.next()).getModel().getIsShrinkable()) {
                    z = true;
                    break;
                }
            }
        }
        this.isShrinkable = z;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    /* renamed from: isShrinkable$urbanairship_layout_release, reason: from getter */
    public boolean getIsShrinkable() {
        return this.isShrinkable;
    }

    @Override // com.urbanairship.android.layout.model.BaseModel
    public void setShrinkable$urbanairship_layout_release(boolean z) {
        this.isShrinkable = z;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR!\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/model/LinearLayoutModel$Item;", "", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/LinearLayoutItemInfo;", TCEventPropertiesNames.TCD_MODEL, "Lcom/urbanairship/android/layout/model/BaseModel;", "Lcom/urbanairship/android/layout/model/AnyModel;", "(Lcom/urbanairship/android/layout/info/LinearLayoutItemInfo;Lcom/urbanairship/android/layout/model/BaseModel;)V", "getInfo", "()Lcom/urbanairship/android/layout/info/LinearLayoutItemInfo;", "getModel", "()Lcom/urbanairship/android/layout/model/BaseModel;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Item {
        private final LinearLayoutItemInfo info;
        private final BaseModel model;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Item copy$default(Item item, LinearLayoutItemInfo linearLayoutItemInfo, BaseModel baseModel, int i, Object obj) {
            if ((i & 1) != 0) {
                linearLayoutItemInfo = item.info;
            }
            if ((i & 2) != 0) {
                baseModel = item.model;
            }
            return item.copy(linearLayoutItemInfo, baseModel);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final LinearLayoutItemInfo getInfo() {
            return this.info;
        }

        @NotNull
        public final BaseModel<?, ?, ?> component2() {
            return this.model;
        }

        @NotNull
        public final Item copy(@NotNull LinearLayoutItemInfo info, @NotNull BaseModel<?, ?, ?> model) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(model, "model");
            return new Item(info, model);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Item)) {
                return false;
            }
            Item item = (Item) other;
            return Intrinsics.areEqual(this.info, item.info) && Intrinsics.areEqual(this.model, item.model);
        }

        public int hashCode() {
            return (this.info.hashCode() * 31) + this.model.hashCode();
        }

        @NotNull
        public String toString() {
            return "Item(info=" + this.info + ", model=" + this.model + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Item(@NotNull LinearLayoutItemInfo info, @NotNull BaseModel<?, ?, ?> model) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(model, "model");
            this.info = info;
            this.model = model;
        }

        @NotNull
        public final LinearLayoutItemInfo getInfo() {
            return this.info;
        }

        @NotNull
        public final BaseModel<?, ?, ?> getModel() {
            return this.model;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.urbanairship.android.layout.model.BaseModel
    @NotNull
    public LinearLayoutView onCreateView(@NotNull Context context, @NotNull ViewEnvironment viewEnvironment, @Nullable ItemProperties itemProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewEnvironment, "viewEnvironment");
        LinearLayoutView linearLayoutView = new LinearLayoutView(context, this, viewEnvironment);
        linearLayoutView.setId(getViewId());
        return linearLayoutView;
    }
}
