package com.urbanairship.preferencecenter.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.R;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.ui.CommonViewHolder;
import com.urbanairship.preferencecenter.ui.item.ChannelSubscriptionItem;
import com.urbanairship.preferencecenter.util.ViewExtensionsKt;
import com.urbanairship.util.AccessibilityUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 #2\u00020\u0001:\u0002#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\fHÖ\u0001R\u001e\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ChannelSubscriptionItem;", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;", "(Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;)V", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;", "subscriptionId", "getSubscriptionId", "subtitle", "getSubtitle", "title", "getTitle", "areContentsTheSame", "", "otherItem", "areItemsTheSame", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "ViewHolder", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChannelSubscriptionItem extends PrefCenterItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int LAYOUT = R.layout.ua_item_preference;
    private static final int WIDGET = R.layout.ua_item_preference_widget_switch;
    private final List conditions;
    private final String id;
    private final Item.ChannelSubscription item;
    private final String subscriptionId;
    private final String subtitle;
    private final String title;

    public static /* synthetic */ ChannelSubscriptionItem copy$default(ChannelSubscriptionItem channelSubscriptionItem, Item.ChannelSubscription channelSubscription, int i, Object obj) {
        if ((i & 1) != 0) {
            channelSubscription = channelSubscriptionItem.item;
        }
        return channelSubscriptionItem.copy(channelSubscription);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Item.ChannelSubscription getItem() {
        return this.item;
    }

    @NotNull
    public final ChannelSubscriptionItem copy(@NotNull Item.ChannelSubscription item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new ChannelSubscriptionItem(item);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChannelSubscriptionItem) && Intrinsics.areEqual(this.item, ((ChannelSubscriptionItem) other).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChannelSubscriptionItem(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @NotNull
    public final Item.ChannelSubscription getItem() {
        return this.item;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSubscriptionItem(@NotNull Item.ChannelSubscription item) {
        super(3, null);
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.id = item.getId();
        this.conditions = item.getConditions();
        this.subscriptionId = item.getSubscriptionId();
        this.title = item.getDisplay().getName();
        this.subtitle = item.getDisplay().getDescription();
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Js\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u001026\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00190\u0017R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ChannelSubscriptionItem$Companion;", "", "()V", "LAYOUT", "", "getLAYOUT", "()I", "WIDGET", "getWIDGET", "createViewHolder", "Lcom/urbanairship/preferencecenter/ui/item/ChannelSubscriptionItem$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "inflater", "Landroid/view/LayoutInflater;", "isChecked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "onCheckedChange", "Lkotlin/Function2;", ViewProps.POSITION, "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getLAYOUT() {
            return ChannelSubscriptionItem.LAYOUT;
        }

        public final int getWIDGET() {
            return ChannelSubscriptionItem.WIDGET;
        }

        public static /* synthetic */ ViewHolder createViewHolder$default(Companion companion, ViewGroup viewGroup, LayoutInflater layoutInflater, Function1 function1, Function2 function2, int i, Object obj) {
            if ((i & 2) != 0) {
                layoutInflater = LayoutInflater.from(viewGroup.getContext());
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "from(...)");
            }
            return companion.createViewHolder(viewGroup, layoutInflater, function1, function2);
        }

        @NotNull
        public final ViewHolder createViewHolder(@NotNull ViewGroup parent, @NotNull LayoutInflater inflater, @NotNull Function1<? super String, Boolean> isChecked, @NotNull Function2<? super Integer, ? super Boolean, Unit> onCheckedChange) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Intrinsics.checkNotNullParameter(isChecked, "isChecked");
            Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
            View viewInflate = inflater.inflate(getLAYOUT(), parent, false);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ua_pref_widget);
            if (linearLayout != null) {
                inflater.inflate(ChannelSubscriptionItem.INSTANCE.getWIDGET(), linearLayout);
                linearLayout.setVisibility(0);
            }
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

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areItemsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (this == otherItem) {
            return true;
        }
        if (!Intrinsics.areEqual(ChannelSubscriptionItem.class, otherItem.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(getId(), otherItem.getId());
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areContentsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (!Intrinsics.areEqual(ChannelSubscriptionItem.class, otherItem.getClass())) {
            return false;
        }
        ChannelSubscriptionItem channelSubscriptionItem = (ChannelSubscriptionItem) otherItem;
        return Intrinsics.areEqual(this.title, channelSubscriptionItem.title) && Intrinsics.areEqual(this.subtitle, channelSubscriptionItem.subtitle) && Intrinsics.areEqual(this.subscriptionId, channelSubscriptionItem.subscriptionId);
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bh\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00100\r¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002H\u0000¢\u0006\u0002\b\u0017J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH\u0002R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ChannelSubscriptionItem$ViewHolder;", "Lcom/urbanairship/preferencecenter/ui/CommonViewHolder;", "Lcom/urbanairship/preferencecenter/ui/item/ChannelSubscriptionItem;", "itemView", "Landroid/view/View;", "isChecked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "onCheckedChange", "Lkotlin/Function2;", "", ViewProps.POSITION, "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "switch", "Lcom/google/android/material/switchmaterial/SwitchMaterial;", "bind", "item", "bindSwitch", "bindSwitch$urbanairship_preference_center_release", "updateAccessibilityDescription", "context", "Landroid/content/Context;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nChannelSubscriptionItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelSubscriptionItem.kt\ncom/urbanairship/preferencecenter/ui/item/ChannelSubscriptionItem$ViewHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,129:1\n1#2:130\n*E\n"})
    public static final class ViewHolder extends CommonViewHolder<ChannelSubscriptionItem> {
        private final Function1 isChecked;
        private final Function2 onCheckedChange;
        private final SwitchMaterial switch;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView, @NotNull Function1<? super String, Boolean> isChecked, @NotNull Function2<? super Integer, ? super Boolean, Unit> onCheckedChange) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(isChecked, "isChecked");
            Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
            this.isChecked = isChecked;
            this.onCheckedChange = onCheckedChange;
            View viewFindViewById = itemView.findViewById(R.id.ua_pref_widget_switch);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.switch = (SwitchMaterial) viewFindViewById;
        }

        @Override // com.urbanairship.preferencecenter.ui.PrefCenterViewHolder
        public void bind(@NotNull ChannelSubscriptionItem item) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(item, "item");
            ViewExtensionsKt.setTextOrHide(getTitleView(), item.getTitle());
            ViewExtensionsKt.setTextOrHide(getDescriptionView(), item.getSubtitle());
            bindSwitch$urbanairship_preference_center_release(item);
            InstrumentationCallbacks.setOnClickListenerCalled(this.itemView, new View.OnClickListener() { // from class: com.urbanairship.preferencecenter.ui.item.ChannelSubscriptionItem$ViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Resources.NotFoundException {
                    ChannelSubscriptionItem.ViewHolder.bind$lambda$0(this.f$0, view);
                }
            });
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            updateAccessibilityDescription(context, item, ((Boolean) this.isChecked.invoke(item.getSubscriptionId())).booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(ViewHolder this$0, View view) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getAdapterPosition() != -1) {
                this$0.switch.setChecked(!r1.isChecked());
            }
        }

        public final void bindSwitch$urbanairship_preference_center_release(@NotNull final ChannelSubscriptionItem item) throws Resources.NotFoundException {
            Intrinsics.checkNotNullParameter(item, "item");
            SwitchMaterial switchMaterial = this.switch;
            switchMaterial.setOnCheckedChangeListener(null);
            switchMaterial.setChecked(((Boolean) this.isChecked.invoke(item.getSubscriptionId())).booleanValue());
            switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.urbanairship.preferencecenter.ui.item.ChannelSubscriptionItem$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ChannelSubscriptionItem.ViewHolder.bindSwitch$lambda$2$lambda$1(this.f$0, item, compoundButton, z);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindSwitch$lambda$2$lambda$1(ViewHolder this$0, ChannelSubscriptionItem item, CompoundButton compoundButton, boolean z) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (this$0.getAdapterPosition() != -1) {
                this$0.onCheckedChange.invoke(Integer.valueOf(this$0.getAdapterPosition()), Boolean.valueOf(z));
                Context context = this$0.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                this$0.updateAccessibilityDescription(context, item, z);
            }
        }

        private final void updateAccessibilityDescription(Context context, ChannelSubscriptionItem item, boolean isChecked) {
            int i;
            int i2;
            View view = this.itemView;
            int i3 = R.string.ua_preference_center_subscription_item_description;
            String title = item.getTitle();
            String subtitle = item.getSubtitle();
            if (isChecked) {
                i = R.string.ua_preference_center_subscribed_description;
            } else {
                i = R.string.ua_preference_center_unsubscribed_description;
            }
            view.setContentDescription(context.getString(i3, title, subtitle, context.getString(i)));
            View view2 = this.itemView;
            if (isChecked) {
                i2 = R.string.ua_preference_center_action_unsubscribe;
            } else {
                i2 = R.string.ua_preference_center_action_subscribe;
            }
            AccessibilityUtils.setClickActionLabel(view2, i2);
        }
    }
}
