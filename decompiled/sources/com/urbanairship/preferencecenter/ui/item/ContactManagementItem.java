package com.urbanairship.preferencecenter.ui.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.InstrumentationCallbacks;
import com.dlp.BluetoothManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.button.MaterialButton;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.Provider;
import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.R;
import com.urbanairship.preferencecenter.data.CommonDisplay;
import com.urbanairship.preferencecenter.data.Condition;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.ui.CommonViewHolder;
import com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel;
import com.urbanairship.preferencecenter.ui.PreferenceCenterViewModelKt;
import com.urbanairship.preferencecenter.ui.item.ContactManagementItem;
import com.urbanairship.preferencecenter.util.ViewExtensionsKt;
import com.urbanairship.util.AccessibilityUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0080\b\u0018\u0000 +2\u00020\u0001:\u0002+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0013\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ContactManagementItem;", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;)V", "addPrompt", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt;", "getAddPrompt", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt;", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "()Ljava/util/List;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "emptyLabel", "", "getEmptyLabel", "()Ljava/lang/String;", "id", "getId", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", DeferredApiClient.KEY_PLATFORM, "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "getPlatform", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "areContentsTheSame", "", "otherItem", "areItemsTheSame", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "ViewHolder", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ContactManagementItem extends PrefCenterItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int LAYOUT = R.layout.ua_item_contact_management;
    private final Item.ContactManagement.AddPrompt addPrompt;
    private final List conditions;
    private final CommonDisplay display;
    private final String emptyLabel;
    private final String id;
    private final Item.ContactManagement item;
    private final Item.ContactManagement.Platform platform;

    public static /* synthetic */ ContactManagementItem copy$default(ContactManagementItem contactManagementItem, Item.ContactManagement contactManagement, int i, Object obj) {
        if ((i & 1) != 0) {
            contactManagement = contactManagementItem.item;
        }
        return contactManagementItem.copy(contactManagement);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Item.ContactManagement getItem() {
        return this.item;
    }

    @NotNull
    public final ContactManagementItem copy(@NotNull Item.ContactManagement item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new ContactManagementItem(item);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ContactManagementItem) && Intrinsics.areEqual(this.item, ((ContactManagementItem) other).item);
    }

    public int hashCode() {
        return this.item.hashCode();
    }

    @NotNull
    public String toString() {
        return "ContactManagementItem(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @NotNull
    public final Item.ContactManagement getItem() {
        return this.item;
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J»\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\f2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u001126\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u001726\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0017R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ContactManagementItem$Companion;", "", "()V", "LAYOUT", "", "getLAYOUT", "()I", "createViewHolder", "Lcom/urbanairship/preferencecenter/ui/item/ContactManagementItem$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "contactChannelsProvider", "Lcom/urbanairship/Provider;", "", "Lcom/urbanairship/contacts/ContactChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "onAddClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ViewProps.POSITION, "", "onRemoveClick", "Lkotlin/Function2;", TCVideoEventPropertiesNames.TCV_CHANNEL, "onResendClick", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getLAYOUT() {
            return ContactManagementItem.LAYOUT;
        }

        @NotNull
        public final ViewHolder createViewHolder(@NotNull ViewGroup parent, @NotNull Provider<Map<ContactChannel, PreferenceCenterViewModel.State.Content.ContactChannelState>> contactChannelsProvider, @NotNull Function1<? super Integer, Unit> onAddClick, @NotNull Function2<? super Integer, ? super ContactChannel, Unit> onRemoveClick, @NotNull Function2<? super Integer, ? super ContactChannel, Unit> onResendClick) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(contactChannelsProvider, "contactChannelsProvider");
            Intrinsics.checkNotNullParameter(onAddClick, "onAddClick");
            Intrinsics.checkNotNullParameter(onRemoveClick, "onRemoveClick");
            Intrinsics.checkNotNullParameter(onResendClick, "onResendClick");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(getLAYOUT(), parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new ViewHolder(viewInflate, contactChannelsProvider, onAddClick, onRemoveClick, onResendClick);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactManagementItem(@NotNull Item.ContactManagement item) {
        super(7, null);
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.id = item.getId();
        this.conditions = item.getConditions();
        this.platform = item.getPlatform();
        this.addPrompt = item.getAddPrompt();
        this.emptyLabel = item.getEmptyLabel();
        this.display = item.getDisplay();
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
    public final Item.ContactManagement.Platform getPlatform() {
        return this.platform;
    }

    @NotNull
    public final Item.ContactManagement.AddPrompt getAddPrompt() {
        return this.addPrompt;
    }

    @Nullable
    public final String getEmptyLabel() {
        return this.emptyLabel;
    }

    @NotNull
    public final CommonDisplay getDisplay() {
        return this.display;
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areItemsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (this == otherItem) {
            return true;
        }
        if (!Intrinsics.areEqual(ContactManagementItem.class, otherItem.getClass())) {
            return false;
        }
        return Intrinsics.areEqual(getId(), otherItem.getId());
    }

    @Override // com.urbanairship.preferencecenter.ui.item.PrefCenterItem
    public boolean areContentsTheSame(@NotNull PrefCenterItem otherItem) {
        Intrinsics.checkNotNullParameter(otherItem, "otherItem");
        if (Intrinsics.areEqual(ContactManagementItem.class, otherItem.getClass())) {
            return Intrinsics.areEqual(this.item, ((ContactManagementItem) otherItem).item);
        }
        return false;
    }

    @Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B«\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u00126\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000f\u00126\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\u0010\u0015J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0015\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0002H\u0000¢\u0006\u0002\b%J$\u0010&\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0'2\u0006\u0010#\u001a\u00020(2\u0006\u0010!\u001a\u00020 H\u0002J.\u0010)\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010 0'2\u0006\u0010#\u001a\u00020(2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010#\u001a\u00020(H\u0003J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020 H\u0002J(\u0010/\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u00100\u001a\u00020\tH\u0002J\\\u00101\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000726\u00103\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u000206H\u0002J\u0012\u00107\u001a\u0004\u0018\u00010 2\u0006\u0010*\u001a\u00020+H\u0002R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/ContactManagementItem$ViewHolder;", "Lcom/urbanairship/preferencecenter/ui/CommonViewHolder;", "Lcom/urbanairship/preferencecenter/ui/item/ContactManagementItem;", "itemView", "Landroid/view/View;", "contactChannelsProvider", "Lcom/urbanairship/Provider;", "", "Lcom/urbanairship/contacts/ContactChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "onAddClick", "Lkotlin/Function1;", "", "", "onRemoveClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", ViewProps.POSITION, TCVideoEventPropertiesNames.TCV_CHANNEL, "onResendClick", "(Landroid/view/View;Lcom/urbanairship/Provider;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "addButton", "Lcom/google/android/material/button/MaterialButton;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "widget", "Landroid/widget/LinearLayout;", "addressDescription", "", "maskedAddress", "bind", "item", "bindContactChannels", "bindContactChannels$urbanairship_preference_center_release", "deleteContentDescription", "Lkotlin/Pair;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "itemContentDescription", "isOptedIn", "", "itemIcon", "makeEmptyView", "emptyLabel", "makeListItem", BluetoothManager.BLE_STATUS_PARAM, "makeListView", "items", "itemBuilder", "platformDescription", DeferredApiClient.KEY_PLATFORM, "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "statusDescription", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nContactManagementItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactManagementItem.kt\ncom/urbanairship/preferencecenter/ui/item/ContactManagementItem$ViewHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,273:1\n1#2:274\n526#3:275\n511#3,6:276\n256#4,2:282\n256#4,2:284\n*S KotlinDebug\n*F\n+ 1 ContactManagementItem.kt\ncom/urbanairship/preferencecenter/ui/item/ContactManagementItem$ViewHolder\n*L\n110#1:275\n110#1:276,6\n173#1:282,2\n181#1:284,2\n*E\n"})
    public static final class ViewHolder extends CommonViewHolder<ContactManagementItem> {
        private static final Companion Companion = new Companion(null);
        private static final Regex contentDescriptionRedactedPattern = new Regex("\\*+");
        private final MaterialButton addButton;
        private final Provider contactChannelsProvider;
        private final Function1 onAddClick;
        private final Function2 onRemoveClick;
        private final Function2 onResendClick;
        private final LinearLayout widget;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView, @NotNull Provider<Map<ContactChannel, PreferenceCenterViewModel.State.Content.ContactChannelState>> contactChannelsProvider, @NotNull Function1<? super Integer, Unit> onAddClick, @NotNull Function2<? super Integer, ? super ContactChannel, Unit> onRemoveClick, @NotNull Function2<? super Integer, ? super ContactChannel, Unit> onResendClick) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(contactChannelsProvider, "contactChannelsProvider");
            Intrinsics.checkNotNullParameter(onAddClick, "onAddClick");
            Intrinsics.checkNotNullParameter(onRemoveClick, "onRemoveClick");
            Intrinsics.checkNotNullParameter(onResendClick, "onResendClick");
            this.contactChannelsProvider = contactChannelsProvider;
            this.onAddClick = onAddClick;
            this.onRemoveClick = onRemoveClick;
            this.onResendClick = onResendClick;
            this.addButton = (MaterialButton) itemView.findViewById(R.id.ua_pref_button);
            this.widget = (LinearLayout) itemView.findViewById(R.id.ua_pref_widget);
        }

        private final Context getContext() {
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            return context;
        }

        @Override // com.urbanairship.preferencecenter.ui.PrefCenterViewHolder
        public void bind(@NotNull ContactManagementItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            ViewExtensionsKt.setTextOrHide(getTitleView(), item.getDisplay().getName());
            ViewExtensionsKt.setTextOrHide(getDescriptionView(), item.getDisplay().getDescription());
            bindContactChannels$urbanairship_preference_center_release(item);
            Item.ContactManagement.LabeledButton button = item.getAddPrompt().getButton();
            MaterialButton materialButton = this.addButton;
            materialButton.setText(button.getText());
            String contentDescription = button.getContentDescription();
            if (contentDescription != null) {
                materialButton.setContentDescription(contentDescription);
            }
            InstrumentationCallbacks.setOnClickListenerCalled(materialButton, new View.OnClickListener() { // from class: com.urbanairship.preferencecenter.ui.item.ContactManagementItem$ViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactManagementItem.ViewHolder.bind$lambda$2$lambda$1(this.f$0, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2$lambda$1(ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getAdapterPosition() != -1) {
                this$0.onAddClick.invoke(Integer.valueOf(this$0.getAdapterPosition()));
            }
        }

        public final void bindContactChannels$urbanairship_preference_center_release(@NotNull final ContactManagementItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            Map map = (Map) this.contactChannelsProvider.get();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (((ContactChannel) entry.getKey()).getChannelType() == item.getPlatform().getChannelType()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            this.widget.removeAllViews();
            if (linkedHashMap.isEmpty()) {
                String emptyLabel = item.getEmptyLabel();
                if (emptyLabel != null) {
                    this.widget.addView(makeEmptyView(getContext(), emptyLabel));
                    return;
                }
                return;
            }
            this.widget.addView(makeListView(getContext(), linkedHashMap, new Function2() { // from class: com.urbanairship.preferencecenter.ui.item.ContactManagementItem$ViewHolder$bindContactChannels$listView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final View invoke(ContactChannel channel, PreferenceCenterViewModel.State.Content.ContactChannelState state) {
                    Intrinsics.checkNotNullParameter(channel, "channel");
                    Intrinsics.checkNotNullParameter(state, "state");
                    ContactManagementItem.ViewHolder viewHolder = this.this$0;
                    Context context = viewHolder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    return viewHolder.makeListItem(context, item.getItem(), channel, state);
                }
            }));
        }

        private final View makeEmptyView(Context context, String emptyLabel) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ua_item_contact_management_empty, (ViewGroup) this.widget, false);
            ((TextView) viewInflate.findViewById(R.id.ua_optin_empty_label)).setText(emptyLabel);
            Intrinsics.checkNotNull(viewInflate);
            return viewInflate;
        }

        private final View makeListView(Context context, Map items, Function2 itemBuilder) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ua_item_contact_management_list, (ViewGroup) this.widget, false);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ua_optin_list);
            for (Map.Entry entry : items.entrySet()) {
                linearLayout.addView((View) itemBuilder.invoke((ContactChannel) entry.getKey(), (PreferenceCenterViewModel.State.Content.ContactChannelState) entry.getValue()));
            }
            Intrinsics.checkNotNull(viewInflate);
            return viewInflate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View makeListItem(Context context, Item.ContactManagement item, final ContactChannel channel, PreferenceCenterViewModel.State.Content.ContactChannelState state) {
            boolean z;
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.ua_item_contact_management_list_item, (ViewGroup) this.widget, false);
            ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.ua_optin_list_item_info);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ua_optin_list_item_icon);
            TextView textView = (TextView) viewInflate.findViewById(R.id.ua_optin_list_item_text);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ua_optin_list_item_delete);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.ua_optin_list_item_pending);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.ua_optin_list_item_resend);
            imageView.setImageResource(itemIcon(item));
            textView.setText(channel.getMaskedAddress());
            InstrumentationCallbacks.setOnClickListenerCalled(imageView2, new View.OnClickListener() { // from class: com.urbanairship.preferencecenter.ui.item.ContactManagementItem$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactManagementItem.ViewHolder.makeListItem$lambda$10$lambda$7$lambda$5(this.f$0, channel, view);
                }
            });
            String contentDescription = item.getRemovePrompt().getButton().getContentDescription();
            if (contentDescription != null) {
                imageView2.setContentDescription(contentDescription);
            }
            Item.ContactManagement.ResendOptions resendOptions$urbanairship_preference_center_release = item.getPlatform().getResendOptions$urbanairship_preference_center_release();
            Intrinsics.checkNotNull(textView2);
            boolean z2 = true;
            if (state.getShowPendingButton()) {
                textView2.setText(resendOptions$urbanairship_preference_center_release.getMessage());
                z = true;
            } else {
                z = false;
            }
            textView2.setVisibility(z ? 0 : 8);
            Intrinsics.checkNotNull(textView3);
            if (state.getShowResendButton()) {
                InstrumentationCallbacks.setOnClickListenerCalled(viewGroup, new View.OnClickListener() { // from class: com.urbanairship.preferencecenter.ui.item.ContactManagementItem$ViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContactManagementItem.ViewHolder.makeListItem$lambda$10$lambda$8(this.f$0, channel, view);
                    }
                });
                textView3.setText(resendOptions$urbanairship_preference_center_release.getButton().getText());
            } else {
                z2 = false;
            }
            textView3.setVisibility(z2 ? 0 : 8);
            Pair pairItemContentDescription = itemContentDescription(item, channel.getMaskedAddress(), PreferenceCenterViewModelKt.isOptedIn(channel));
            String str = (String) pairItemContentDescription.component1();
            String str2 = (String) pairItemContentDescription.component2();
            viewGroup.setContentDescription(str);
            if (str2 != null) {
                AccessibilityUtils.setClickActionLabel(viewGroup, str2);
            }
            Pair pairDeleteContentDescription = deleteContentDescription(item, channel.getMaskedAddress());
            String str3 = (String) pairDeleteContentDescription.component1();
            String str4 = (String) pairDeleteContentDescription.component2();
            imageView2.setContentDescription(str3);
            AccessibilityUtils.setClickActionLabel(imageView2, str4);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "apply(...)");
            return viewInflate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void makeListItem$lambda$10$lambda$7$lambda$5(ViewHolder this$0, ContactChannel channel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(channel, "$channel");
            this$0.onRemoveClick.invoke(Integer.valueOf(this$0.getAdapterPosition()), channel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void makeListItem$lambda$10$lambda$8(ViewHolder this$0, ContactChannel channel, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(channel, "$channel");
            this$0.onResendClick.invoke(Integer.valueOf(this$0.getAdapterPosition()), channel);
        }

        private final Pair itemContentDescription(Item.ContactManagement item, String maskedAddress, boolean isOptedIn) {
            StringBuilder sb = new StringBuilder();
            sb.append(platformDescription(item.getPlatform()));
            sb.append(" ");
            sb.append(addressDescription(maskedAddress));
            String strStatusDescription = statusDescription(isOptedIn);
            if (strStatusDescription != null) {
                sb.append(" ");
                sb.append(strStatusDescription);
            }
            String contentDescription = item.getPlatform().getResendOptions$urbanairship_preference_center_release().getButton().getContentDescription();
            if (contentDescription == null) {
                contentDescription = item.getPlatform().getResendOptions$urbanairship_preference_center_release().getButton().getText();
            }
            if (isOptedIn) {
                contentDescription = null;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return TuplesKt.to(string, contentDescription);
        }

        private final Pair deleteContentDescription(Item.ContactManagement item, String maskedAddress) {
            String contentDescription = item.getRemovePrompt().getButton().getContentDescription();
            if (contentDescription == null) {
                contentDescription = getContext().getString(com.urbanairship.R.string.ua_delete);
                Intrinsics.checkNotNullExpressionValue(contentDescription, "getString(...)");
            }
            String str = platformDescription(item.getPlatform()) + " " + addressDescription(maskedAddress);
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            return TuplesKt.to(str, contentDescription);
        }

        private final String statusDescription(boolean isOptedIn) {
            if (isOptedIn) {
                return null;
            }
            return getContext().getString(R.string.ua_preference_center_contact_management_pending);
        }

        private final String platformDescription(Item.ContactManagement.Platform platform) {
            if (platform instanceof Item.ContactManagement.Platform.Email) {
                String string = getContext().getString(R.string.ua_preference_center_contact_management_email_description);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            if (!(platform instanceof Item.ContactManagement.Platform.Sms)) {
                throw new NoWhenBranchMatchedException();
            }
            String string2 = getContext().getString(R.string.ua_preference_center_contact_management_sms_description);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }

        private final String addressDescription(String maskedAddress) {
            Regex regex = contentDescriptionRedactedPattern;
            String string = getContext().getString(R.string.ua_preference_center_contact_management_redacted_description);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return regex.replace(maskedAddress, string);
        }

        private final int itemIcon(Item.ContactManagement item) {
            Item.ContactManagement.Platform platform = item.getPlatform();
            if (platform instanceof Item.ContactManagement.Platform.Email) {
                return R.drawable.ua_ic_preference_center_email;
            }
            if (platform instanceof Item.ContactManagement.Platform.Sms) {
                return R.drawable.ua_ic_preference_center_phone;
            }
            throw new NoWhenBranchMatchedException();
        }

        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
