package com.urbanairship.preferencecenter.ui.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ch.qos.logback.core.CoreConstants;
import com.google.android.material.chip.Chip;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.R;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.preferencecenter.data.Section;
import com.urbanairship.preferencecenter.ui.PrefCenterViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\fHÖ\u0001R\u001e\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/SectionBreakItem;", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "section", "Lcom/urbanairship/preferencecenter/data/Section$SectionBreak;", "(Lcom/urbanairship/preferencecenter/data/Section$SectionBreak;)V", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "label", "getLabel", "getSection", "()Lcom/urbanairship/preferencecenter/data/Section$SectionBreak;", "areContentsTheSame", "", "otherItem", "areItemsTheSame", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "ViewHolder", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SectionBreakItem extends PrefCenterItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int LAYOUT = R.layout.ua_item_preference_section_break;
    private final List conditions;
    private final String id;
    private final String label;
    private final Section.SectionBreak section;

    public static /* synthetic */ SectionBreakItem copy$default(SectionBreakItem sectionBreakItem, Section.SectionBreak sectionBreak, int i, Object obj) {
        if ((i & 1) != 0) {
            sectionBreak = sectionBreakItem.section;
        }
        return sectionBreakItem.copy(sectionBreak);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Section.SectionBreak getSection() {
        return this.section;
    }

    @NotNull
    public final SectionBreakItem copy(@NotNull Section.SectionBreak section) {
        Intrinsics.checkNotNullParameter(section, "section");
        return new SectionBreakItem(section);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SectionBreakItem) && Intrinsics.areEqual(this.section, ((SectionBreakItem) other).section);
    }

    public int hashCode() {
        return this.section.hashCode();
    }

    @NotNull
    public String toString() {
        return "SectionBreakItem(section=" + this.section + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @NotNull
    public final Section.SectionBreak getSection() {
        return this.section;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionBreakItem(@NotNull Section.SectionBreak section) {
        super(2, null);
        Intrinsics.checkNotNullParameter(section, "section");
        this.section = section;
        this.id = section.getId();
        this.conditions = section.getConditions();
        this.label = section.getDisplay().getName();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/SectionBreakItem$Companion;", "", "()V", "LAYOUT", "", "getLAYOUT", "()I", "createViewHolder", "Lcom/urbanairship/preferencecenter/ui/item/SectionBreakItem$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "inflater", "Landroid/view/LayoutInflater;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getLAYOUT() {
            return SectionBreakItem.LAYOUT;
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

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areItemsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (this == otherItem) {
            return true;
        }
        if (!Intrinsics.areEqual(SectionBreakItem.class, otherItem.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(getId(), otherItem.getId());
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areContentsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (Intrinsics.areEqual(SectionBreakItem.class, otherItem.getClass())) {
            return Intrinsics.areEqual(this.label, ((SectionBreakItem) otherItem).label);
        }
        return false;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/SectionBreakItem$ViewHolder;", "Lcom/urbanairship/preferencecenter/ui/PrefCenterViewHolder;", "Lcom/urbanairship/preferencecenter/ui/item/SectionBreakItem;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "chipView", "Lcom/google/android/material/chip/Chip;", "bind", "", "item", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends PrefCenterViewHolder<SectionBreakItem> {
        private final Chip chipView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.ua_pref_chip);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.chipView = (Chip) viewFindViewById;
        }

        @Override // com.urbanairship.preferencecenter.ui.PrefCenterViewHolder
        public void bind(@NotNull SectionBreakItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.chipView.setText(item.getLabel());
        }
    }
}
