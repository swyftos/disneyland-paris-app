package com.urbanairship.preferencecenter.ui.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.R;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.preferencecenter.ui.CommonViewHolder;
import com.urbanairship.preferencecenter.util.ViewExtensionsKt;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0001H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0001H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006 "}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/DescriptionItem;", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "title", "", "description", "(Ljava/lang/String;Ljava/lang/String;)V", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "id", "getId", "getTitle", "areContentsTheSame", "", "otherItem", "areItemsTheSame", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "ViewHolder", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DescriptionItem extends PrefCenterItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int LAYOUT = R.layout.ua_item_preference_description;
    private final List conditions;
    private final String description;
    private final String id;
    private final String title;

    public static /* synthetic */ DescriptionItem copy$default(DescriptionItem descriptionItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = descriptionItem.title;
        }
        if ((i & 2) != 0) {
            str2 = descriptionItem.description;
        }
        return descriptionItem.copy(str, str2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final DescriptionItem copy(@Nullable String title, @Nullable String description) {
        return new DescriptionItem(title, description);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DescriptionItem)) {
            return false;
        }
        DescriptionItem descriptionItem = (DescriptionItem) other;
        return Intrinsics.areEqual(this.title, descriptionItem.title) && Intrinsics.areEqual(this.description, descriptionItem.description);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "DescriptionItem(title=" + this.title + ", description=" + this.description + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public DescriptionItem(@Nullable String str, @Nullable String str2) {
        super(0, null);
        this.title = str;
        this.description = str2;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.id = string;
        this.conditions = CollectionsKt.emptyList();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/DescriptionItem$Companion;", "", "()V", "LAYOUT", "", "getLAYOUT", "()I", "createViewHolder", "Lcom/urbanairship/preferencecenter/ui/item/DescriptionItem$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "inflater", "Landroid/view/LayoutInflater;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getLAYOUT() {
            return DescriptionItem.LAYOUT;
        }

        public static /* synthetic */ ViewHolder createViewHolder$default(Companion companion, ViewGroup viewGroup, LayoutInflater layoutInflater, int i, Object obj) {
            if ((i & 2) != 0) {
                layoutInflater = LayoutInflater.from(viewGroup.getContext());
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "from(...)");
            }
            return companion.createViewHolder(viewGroup, layoutInflater);
        }

        @NotNull
        public final ViewHolder createViewHolder(@NotNull ViewGroup parent, @NotNull LayoutInflater inflater) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View viewInflate = inflater.inflate(getLAYOUT(), parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(viewInflate);
        }
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    @NotNull
    public String getId() {
        return this.id;
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    @NotNull
    public List<Condition> getConditions() {
        return this.conditions;
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areItemsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        return this == otherItem || !Intrinsics.areEqual(DescriptionItem.class, otherItem.getClass());
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areContentsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (!Intrinsics.areEqual(DescriptionItem.class, otherItem.getClass())) {
            return false;
        }
        DescriptionItem descriptionItem = (DescriptionItem) otherItem;
        return Intrinsics.areEqual(this.title, descriptionItem.title) && Intrinsics.areEqual(this.description, descriptionItem.description);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/DescriptionItem$ViewHolder;", "Lcom/urbanairship/preferencecenter/ui/CommonViewHolder;", "Lcom/urbanairship/preferencecenter/ui/item/DescriptionItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "item", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends CommonViewHolder<DescriptionItem> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        @Override // com.urbanairship.preferencecenter.ui.PrefCenterViewHolder
        public void bind(@NotNull DescriptionItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ViewExtensionsKt.setTextOrHide(getTitleView(), item.getTitle());
            ViewExtensionsKt.setTextOrHide(getDescriptionView(), item.getDescription());
        }
    }
}
