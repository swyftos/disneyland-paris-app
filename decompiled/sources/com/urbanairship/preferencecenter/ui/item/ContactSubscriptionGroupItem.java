package com.urbanairship.preferencecenter.ui.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.chip.ChipGroup;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.contacts.Scope;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.R;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.ui.CommonViewHolder;
import com.urbanairship.preferencecenter.ui.item.ContactSubscriptionGroupItem;
import com.urbanairship.preferencecenter.util.ViewExtensionsKt;
import com.urbanairship.preferencecenter.widget.SubscriptionTypeChip;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 &2\u00020\u0001:\u0002&'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006("}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ContactSubscriptionGroupItem;", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;)V", "components", "", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component;", "getComponents", "()Ljava/util/List;", "conditions", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "id", "", "getId", "()Ljava/lang/String;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;", "subscriptionId", "getSubscriptionId", "subtitle", "getSubtitle", "title", "getTitle", "areContentsTheSame", "", "otherItem", "areItemsTheSame", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "ViewHolder", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ContactSubscriptionGroupItem extends PrefCenterItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int LAYOUT = R.layout.ua_item_preference_contact_subscription_group;
    private final List components;
    private final List conditions;
    private final String id;
    private final Item.ContactSubscriptionGroup item;
    private final String subscriptionId;
    private final String subtitle;
    private final String title;

    public static /* synthetic */ ContactSubscriptionGroupItem copy$default(ContactSubscriptionGroupItem contactSubscriptionGroupItem, Item.ContactSubscriptionGroup contactSubscriptionGroup, int i, Object obj) {
        if ((i & 1) != 0) {
            contactSubscriptionGroup = contactSubscriptionGroupItem.item;
        }
        return contactSubscriptionGroupItem.copy(contactSubscriptionGroup);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Item.ContactSubscriptionGroup getItem() {
        return this.item;
    }

    @NotNull
    public final ContactSubscriptionGroupItem copy(@NotNull Item.ContactSubscriptionGroup item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new ContactSubscriptionGroupItem(item);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ContactSubscriptionGroupItem) && Intrinsics.areEqual(this.item, ((ContactSubscriptionGroupItem) other).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    @NotNull
    public String toString() {
        return "ContactSubscriptionGroupItem(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @NotNull
    public final Item.ContactSubscriptionGroup getItem() {
        return this.item;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSubscriptionGroupItem(@NotNull Item.ContactSubscriptionGroup item) {
        super(5, null);
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.id = item.getId();
        this.conditions = item.getConditions();
        this.subscriptionId = item.getSubscriptionId();
        this.title = item.getDisplay().getName();
        this.subtitle = item.getDisplay().getDescription();
        this.components = item.getComponents();
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J©\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000e2Q\u0010\u0017\u001aM\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u001a0\u0018R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ContactSubscriptionGroupItem$Companion;", "", "()V", "LAYOUT", "", "getLAYOUT", "()I", "createViewHolder", "Lcom/urbanairship/preferencecenter/ui/item/ContactSubscriptionGroupItem$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "inflater", "Landroid/view/LayoutInflater;", "isChecked", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "", "Lcom/urbanairship/contacts/Scope;", "scopes", "", "onCheckedChange", "Lkotlin/Function3;", ViewProps.POSITION, "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getLAYOUT() {
            return ContactSubscriptionGroupItem.LAYOUT;
        }

        public static /* synthetic */ ViewHolder createViewHolder$default(Companion companion, ViewGroup viewGroup, LayoutInflater layoutInflater, Function2 function2, Function3 function3, int i, Object obj) {
            if ((i & 2) != 0) {
                layoutInflater = LayoutInflater.from(viewGroup.getContext());
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "from(...)");
            }
            return companion.createViewHolder(viewGroup, layoutInflater, function2, function3);
        }

        @NotNull
        public final ViewHolder createViewHolder(@NotNull ViewGroup parent, @NotNull LayoutInflater inflater, @NotNull Function2<? super String, ? super Set<? extends Scope>, Boolean> isChecked, @NotNull Function3<? super Integer, ? super Set<? extends Scope>, ? super Boolean, Unit> onCheckedChange) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(isChecked, "isChecked");
            Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
            View viewInflate = inflater.inflate(getLAYOUT(), parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(viewInflate, isChecked, onCheckedChange);
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

    @NotNull
    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final List<Item.ContactSubscriptionGroup.Component> getComponents() {
        return this.components;
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areItemsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (this == otherItem) {
            return true;
        }
        if (!Intrinsics.areEqual(ContactSubscriptionGroupItem.class, otherItem.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(getId(), otherItem.getId());
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areContentsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (!Intrinsics.areEqual(ContactSubscriptionGroupItem.class, otherItem.getClass())) {
            return false;
        }
        ContactSubscriptionGroupItem contactSubscriptionGroupItem = (ContactSubscriptionGroupItem) otherItem;
        return Intrinsics.areEqual(this.title, contactSubscriptionGroupItem.title) && Intrinsics.areEqual(this.subscriptionId, contactSubscriptionGroupItem.subscriptionId) && Intrinsics.areEqual(this.components, contactSubscriptionGroupItem.components);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u009e\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012<\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006\u0012Q\u0010\u000f\u001aM\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0015\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0002H\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u0005\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000RY\u0010\u000f\u001aM\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ContactSubscriptionGroupItem$ViewHolder;", "Lcom/urbanairship/preferencecenter/ui/CommonViewHolder;", "Lcom/urbanairship/preferencecenter/ui/item/ContactSubscriptionGroupItem;", "itemView", "Landroid/view/View;", "isChecked", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "", "Lcom/urbanairship/contacts/Scope;", "scopes", "", "onCheckedChange", "Lkotlin/Function3;", "", ViewProps.POSITION, "", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "chipGroup", "Lcom/google/android/material/chip/ChipGroup;", "bind", "item", "bindChips", "bindChips$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends CommonViewHolder<ContactSubscriptionGroupItem> {
        private final ChipGroup chipGroup;
        private final Function2 isChecked;
        private final Function3 onCheckedChange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView, @NotNull Function2<? super String, ? super Set<? extends Scope>, Boolean> isChecked, @NotNull Function3<? super Integer, ? super Set<? extends Scope>, ? super Boolean, Unit> onCheckedChange) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(isChecked, "isChecked");
            Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
            this.isChecked = isChecked;
            this.onCheckedChange = onCheckedChange;
            View viewFindViewById = itemView.findViewById(R.id.ua_pref_chip_group);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.chipGroup = (ChipGroup) viewFindViewById;
        }

        @Override // com.urbanairship.preferencecenter.ui.PrefCenterViewHolder
        public void bind(@NotNull ContactSubscriptionGroupItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ViewExtensionsKt.setTextOrHide(getTitleView(), item.getTitle());
            ViewExtensionsKt.setTextOrHide(getDescriptionView(), item.getSubtitle());
            bindChips$urbanairship_preference_center_release(item);
        }

        public final void bindChips$urbanairship_preference_center_release(@NotNull ContactSubscriptionGroupItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.chipGroup.removeAllViews();
            for (final Item.ContactSubscriptionGroup.Component component : item.getComponents()) {
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                final SubscriptionTypeChip subscriptionTypeChip = new SubscriptionTypeChip(context, 0, 2, null);
                subscriptionTypeChip.setText(component.getDisplay().getName());
                subscriptionTypeChip.setChecked(((Boolean) this.isChecked.invoke(item.getSubscriptionId(), component.getScopes())).booleanValue());
                subscriptionTypeChip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.urbanairship.preferencecenter.ui.item.ContactSubscriptionGroupItem$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        ContactSubscriptionGroupItem.ViewHolder.bindChips$lambda$2$lambda$0(this.f$0, component, compoundButton, z);
                    }
                });
                InstrumentationCallbacks.setOnFocusChangeListenerCalled(subscriptionTypeChip, new View.OnFocusChangeListener() { // from class: com.urbanairship.preferencecenter.ui.item.ContactSubscriptionGroupItem$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        ContactSubscriptionGroupItem.ViewHolder.bindChips$lambda$2$lambda$1(subscriptionTypeChip, view, z);
                    }
                });
                getTitleView().setLabelFor(subscriptionTypeChip.getId());
                this.chipGroup.addView(subscriptionTypeChip, -2, -2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindChips$lambda$2$lambda$0(ViewHolder this$0, Item.ContactSubscriptionGroup.Component component, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(component, "$component");
            if (this$0.getAdapterPosition() != -1) {
                this$0.onCheckedChange.invoke(Integer.valueOf(this$0.getAdapterPosition()), component.getScopes(), Boolean.valueOf(z));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindChips$lambda$2$lambda$1(SubscriptionTypeChip this_apply, View view, boolean z) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            if (z) {
                this_apply.setChipStrokeWidthResource(R.dimen.ua_preference_center_subscription_type_chip_stroke_focused_width);
            } else {
                this_apply.setChipStrokeWidthResource(R.dimen.ua_preference_center_subscription_type_chip_stroke_width);
            }
        }
    }
}
