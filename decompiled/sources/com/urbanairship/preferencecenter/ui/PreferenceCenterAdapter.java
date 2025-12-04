package com.urbanairship.preferencecenter.ui;

import android.content.res.Resources;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.Provider;
import com.urbanairship.contacts.ContactChannel;
import com.urbanairship.contacts.Scope;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.Item;
import com.urbanairship.preferencecenter.ui.PreferenceCenterViewModel;
import com.urbanairship.preferencecenter.ui.item.AlertItem;
import com.urbanairship.preferencecenter.ui.item.ChannelSubscriptionItem;
import com.urbanairship.preferencecenter.ui.item.ContactManagementItem;
import com.urbanairship.preferencecenter.ui.item.ContactSubscriptionGroupItem;
import com.urbanairship.preferencecenter.ui.item.ContactSubscriptionItem;
import com.urbanairship.preferencecenter.ui.item.DescriptionItem;
import com.urbanairship.preferencecenter.ui.item.PrefCenterItem;
import com.urbanairship.preferencecenter.ui.item.SectionBreakItem;
import com.urbanairship.preferencecenter.ui.item.SectionItem;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u0000 @2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001:\u0003@ABB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\rH\u0002J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\rH\u0002J\u0018\u0010&\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0002J&\u0010&\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\nH\u0002J\u001e\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001c\u0010/\u001a\u00020\u001c2\n\u00100\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010!\u001a\u00020\"H\u0016J*\u0010/\u001a\u00020\u001c2\n\u00100\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010!\u001a\u00020\"2\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0016J\u001c\u00104\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\"H\u0016J!\u00108\u001a\u00020\u001c2\b\u00109\u001a\u0004\u0018\u00010\n2\b\u0010:\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\b;JD\u0010<\u001a\u00020\u001c2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u001e2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u001eH\u0002JP\u0010=\u001a\u00020\u001c2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00020?2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u001e2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u001eR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "Lcom/urbanairship/preferencecenter/ui/PrefCenterViewHolder;", "scopeProvider", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function0;)V", "channelSubscriptions", "", "", "contactChannels", "", "Lcom/urbanairship/contacts/ContactChannel;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterViewModel$State$Content$ContactChannelState;", "contactSubscriptions", "", "Lcom/urbanairship/contacts/Scope;", "descriptionItem", "Lcom/urbanairship/preferencecenter/ui/item/DescriptionItem;", "itemEvents", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "getItemEvents", "()Lkotlinx/coroutines/flow/SharedFlow;", "itemEventsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "emitActions", "", "actions", "", "Lcom/urbanairship/json/JsonValue;", "emitContactManagementAddEvent", ViewProps.POSITION, "", "emitContactManagementRemoveEvent", TCVideoEventPropertiesNames.TCV_CHANNEL, "emitContactManagementResendVerificationEvent", "emitItemEvent", "isChecked", "", "scopes", "getItemId", "", "getItemViewType", "isSubscribed", "id", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHeaderItem", "title", "description", "setHeaderItem$urbanairship_preference_center_release", "setSubscriptions", "submit", "items", "", "Companion", "ItemEvent", "ItemPayload", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPreferenceCenterAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreferenceCenterAdapter.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,348:1\n1#2:349\n1864#3,3:350\n1864#3,3:353\n1864#3,3:356\n*S KotlinDebug\n*F\n+ 1 PreferenceCenterAdapter.kt\ncom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter\n*L\n211#1:350,3\n223#1:353,3\n235#1:356,3\n*E\n"})
/* loaded from: classes5.dex */
public final class PreferenceCenterAdapter extends ListAdapter<PrefCenterItem, PrefCenterViewHolder<?>> {
    private static final PreferenceCenterAdapter$Companion$DIFF_CALLBACK$1 DIFF_CALLBACK = new DiffUtil.ItemCallback<PrefCenterItem>() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$Companion$DIFF_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull PrefCenterItem oldItem, @NotNull PrefCenterItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.areItemsTheSame(newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull PrefCenterItem oldItem, @NotNull PrefCenterItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.areContentsTheSame(newItem);
        }
    };
    private final Set channelSubscriptions;
    private final Map contactChannels;
    private final Map contactSubscriptions;
    private DescriptionItem descriptionItem;
    private final SharedFlow itemEvents;
    private final MutableSharedFlow itemEventsFlow;
    private final Function0 scopeProvider;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) throws Resources.NotFoundException {
        onBindViewHolder((PrefCenterViewHolder<?>) viewHolder, i, (List<Object>) list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceCenterAdapter(@NotNull Function0<? extends CoroutineScope> scopeProvider) {
        super(DIFF_CALLBACK);
        Intrinsics.checkNotNullParameter(scopeProvider, "scopeProvider");
        this.scopeProvider = scopeProvider;
        setHasStableIds(true);
        this.channelSubscriptions = new LinkedHashSet();
        this.contactSubscriptions = new LinkedHashMap();
        this.contactChannels = new LinkedHashMap();
        MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.itemEventsFlow = mutableSharedFlowMutableSharedFlow$default;
        this.itemEvents = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "", "()V", "ButtonClick", "ChannelSubscriptionChange", "ContactManagementAddClick", "ContactManagementRemoveClick", "ContactManagementResendClick", "ContactSubscriptionChange", "ContactSubscriptionGroupChange", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ButtonClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ChannelSubscriptionChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactManagementAddClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactManagementRemoveClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactManagementResendClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactSubscriptionChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactSubscriptionGroupChange;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class ItemEvent {
        public /* synthetic */ ItemEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ItemEvent() {
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ChannelSubscriptionChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;", "isChecked", "", "(Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;Z)V", "()Z", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ChannelSubscriptionChange extends ItemEvent {
            private final boolean isChecked;
            private final Item.ChannelSubscription item;

            public static /* synthetic */ ChannelSubscriptionChange copy$default(ChannelSubscriptionChange channelSubscriptionChange, Item.ChannelSubscription channelSubscription, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    channelSubscription = channelSubscriptionChange.item;
                }
                if ((i & 2) != 0) {
                    z = channelSubscriptionChange.isChecked;
                }
                return channelSubscriptionChange.copy(channelSubscription, z);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ChannelSubscription getItem() {
                return this.item;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsChecked() {
                return this.isChecked;
            }

            @NotNull
            public final ChannelSubscriptionChange copy(@NotNull Item.ChannelSubscription item, boolean isChecked) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new ChannelSubscriptionChange(item, isChecked);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ChannelSubscriptionChange)) {
                    return false;
                }
                ChannelSubscriptionChange channelSubscriptionChange = (ChannelSubscriptionChange) other;
                return Intrinsics.areEqual(this.item, channelSubscriptionChange.item) && this.isChecked == channelSubscriptionChange.isChecked;
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + Boolean.hashCode(this.isChecked);
            }

            @NotNull
            public String toString() {
                return "ChannelSubscriptionChange(item=" + this.item + ", isChecked=" + this.isChecked + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ChannelSubscription getItem() {
                return this.item;
            }

            public final boolean isChecked() {
                return this.isChecked;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChannelSubscriptionChange(@NotNull Item.ChannelSubscription item, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
                this.isChecked = z;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactSubscriptionChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscription;", "scopes", "", "Lcom/urbanairship/contacts/Scope;", "isChecked", "", "(Lcom/urbanairship/preferencecenter/data/Item$ContactSubscription;Ljava/util/Set;Z)V", "()Z", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactSubscription;", "getScopes", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ContactSubscriptionChange extends ItemEvent {
            private final boolean isChecked;
            private final Item.ContactSubscription item;
            private final Set scopes;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ContactSubscriptionChange copy$default(ContactSubscriptionChange contactSubscriptionChange, Item.ContactSubscription contactSubscription, Set set, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactSubscription = contactSubscriptionChange.item;
                }
                if ((i & 2) != 0) {
                    set = contactSubscriptionChange.scopes;
                }
                if ((i & 4) != 0) {
                    z = contactSubscriptionChange.isChecked;
                }
                return contactSubscriptionChange.copy(contactSubscription, set, z);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactSubscription getItem() {
                return this.item;
            }

            @NotNull
            public final Set<Scope> component2() {
                return this.scopes;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsChecked() {
                return this.isChecked;
            }

            @NotNull
            public final ContactSubscriptionChange copy(@NotNull Item.ContactSubscription item, @NotNull Set<? extends Scope> scopes, boolean isChecked) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                return new ContactSubscriptionChange(item, scopes, isChecked);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContactSubscriptionChange)) {
                    return false;
                }
                ContactSubscriptionChange contactSubscriptionChange = (ContactSubscriptionChange) other;
                return Intrinsics.areEqual(this.item, contactSubscriptionChange.item) && Intrinsics.areEqual(this.scopes, contactSubscriptionChange.scopes) && this.isChecked == contactSubscriptionChange.isChecked;
            }

            public int hashCode() {
                return (((this.item.hashCode() * 31) + this.scopes.hashCode()) * 31) + Boolean.hashCode(this.isChecked);
            }

            @NotNull
            public String toString() {
                return "ContactSubscriptionChange(item=" + this.item + ", scopes=" + this.scopes + ", isChecked=" + this.isChecked + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ContactSubscription getItem() {
                return this.item;
            }

            @NotNull
            public final Set<Scope> getScopes() {
                return this.scopes;
            }

            public final boolean isChecked() {
                return this.isChecked;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ContactSubscriptionChange(@NotNull Item.ContactSubscription item, @NotNull Set<? extends Scope> scopes, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                this.item = item;
                this.scopes = scopes;
                this.isChecked = z;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactSubscriptionGroupChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;", "scopes", "", "Lcom/urbanairship/contacts/Scope;", "isChecked", "", "(Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;Ljava/util/Set;Z)V", "()Z", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;", "getScopes", "()Ljava/util/Set;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ContactSubscriptionGroupChange extends ItemEvent {
            private final boolean isChecked;
            private final Item.ContactSubscriptionGroup item;
            private final Set scopes;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ContactSubscriptionGroupChange copy$default(ContactSubscriptionGroupChange contactSubscriptionGroupChange, Item.ContactSubscriptionGroup contactSubscriptionGroup, Set set, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactSubscriptionGroup = contactSubscriptionGroupChange.item;
                }
                if ((i & 2) != 0) {
                    set = contactSubscriptionGroupChange.scopes;
                }
                if ((i & 4) != 0) {
                    z = contactSubscriptionGroupChange.isChecked;
                }
                return contactSubscriptionGroupChange.copy(contactSubscriptionGroup, set, z);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactSubscriptionGroup getItem() {
                return this.item;
            }

            @NotNull
            public final Set<Scope> component2() {
                return this.scopes;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsChecked() {
                return this.isChecked;
            }

            @NotNull
            public final ContactSubscriptionGroupChange copy(@NotNull Item.ContactSubscriptionGroup item, @NotNull Set<? extends Scope> scopes, boolean isChecked) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                return new ContactSubscriptionGroupChange(item, scopes, isChecked);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContactSubscriptionGroupChange)) {
                    return false;
                }
                ContactSubscriptionGroupChange contactSubscriptionGroupChange = (ContactSubscriptionGroupChange) other;
                return Intrinsics.areEqual(this.item, contactSubscriptionGroupChange.item) && Intrinsics.areEqual(this.scopes, contactSubscriptionGroupChange.scopes) && this.isChecked == contactSubscriptionGroupChange.isChecked;
            }

            public int hashCode() {
                return (((this.item.hashCode() * 31) + this.scopes.hashCode()) * 31) + Boolean.hashCode(this.isChecked);
            }

            @NotNull
            public String toString() {
                return "ContactSubscriptionGroupChange(item=" + this.item + ", scopes=" + this.scopes + ", isChecked=" + this.isChecked + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ContactSubscriptionGroup getItem() {
                return this.item;
            }

            @NotNull
            public final Set<Scope> getScopes() {
                return this.scopes;
            }

            public final boolean isChecked() {
                return this.isChecked;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ContactSubscriptionGroupChange(@NotNull Item.ContactSubscriptionGroup item, @NotNull Set<? extends Scope> scopes, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                this.item = item;
                this.scopes = scopes;
                this.isChecked = z;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ButtonClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "actions", "", "", "Lcom/urbanairship/json/JsonValue;", "(Ljava/util/Map;)V", "getActions", "()Ljava/util/Map;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ButtonClick extends ItemEvent {
            private final Map actions;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ButtonClick copy$default(ButtonClick buttonClick, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = buttonClick.actions;
                }
                return buttonClick.copy(map);
            }

            @NotNull
            public final Map<String, JsonValue> component1() {
                return this.actions;
            }

            @NotNull
            public final ButtonClick copy(@NotNull Map<String, ? extends JsonValue> actions) {
                Intrinsics.checkNotNullParameter(actions, "actions");
                return new ButtonClick(actions);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ButtonClick) && Intrinsics.areEqual(this.actions, ((ButtonClick) other).actions);
            }

            public int hashCode() {
                return this.actions.hashCode();
            }

            @NotNull
            public String toString() {
                return "ButtonClick(actions=" + this.actions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Map<String, JsonValue> getActions() {
                return this.actions;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ButtonClick(@NotNull Map<String, ? extends JsonValue> actions) {
                super(null);
                Intrinsics.checkNotNullParameter(actions, "actions");
                this.actions = actions;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactManagementAddClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;)V", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ContactManagementAddClick extends ItemEvent {
            private final Item.ContactManagement item;

            public static /* synthetic */ ContactManagementAddClick copy$default(ContactManagementAddClick contactManagementAddClick, Item.ContactManagement contactManagement, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = contactManagementAddClick.item;
                }
                return contactManagementAddClick.copy(contactManagement);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final ContactManagementAddClick copy(@NotNull Item.ContactManagement item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new ContactManagementAddClick(item);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ContactManagementAddClick) && Intrinsics.areEqual(this.item, ((ContactManagementAddClick) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            @NotNull
            public String toString() {
                return "ContactManagementAddClick(item=" + this.item + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ContactManagementAddClick(@NotNull Item.ContactManagement item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactManagementRemoveClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Lcom/urbanairship/contacts/ContactChannel;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ContactManagementRemoveClick extends ItemEvent {
            private final ContactChannel channel;
            private final Item.ContactManagement item;

            public static /* synthetic */ ContactManagementRemoveClick copy$default(ContactManagementRemoveClick contactManagementRemoveClick, Item.ContactManagement contactManagement, ContactChannel contactChannel, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = contactManagementRemoveClick.item;
                }
                if ((i & 2) != 0) {
                    contactChannel = contactManagementRemoveClick.channel;
                }
                return contactManagementRemoveClick.copy(contactManagement, contactChannel);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final ContactManagementRemoveClick copy(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new ContactManagementRemoveClick(item, channel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContactManagementRemoveClick)) {
                    return false;
                }
                ContactManagementRemoveClick contactManagementRemoveClick = (ContactManagementRemoveClick) other;
                return Intrinsics.areEqual(this.item, contactManagementRemoveClick.item) && Intrinsics.areEqual(this.channel, contactManagementRemoveClick.channel);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.channel.hashCode();
            }

            @NotNull
            public String toString() {
                return "ContactManagementRemoveClick(item=" + this.item + ", channel=" + this.channel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ContactManagementRemoveClick(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.item = item;
                this.channel = channel;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent$ContactManagementResendClick;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemEvent;", "item", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannel;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;Lcom/urbanairship/contacts/ContactChannel;)V", "getChannel", "()Lcom/urbanairship/contacts/ContactChannel;", "getItem", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ContactManagementResendClick extends ItemEvent {
            private final ContactChannel channel;
            private final Item.ContactManagement item;

            public static /* synthetic */ ContactManagementResendClick copy$default(ContactManagementResendClick contactManagementResendClick, Item.ContactManagement contactManagement, ContactChannel contactChannel, int i, Object obj) {
                if ((i & 1) != 0) {
                    contactManagement = contactManagementResendClick.item;
                }
                if ((i & 2) != 0) {
                    contactChannel = contactManagementResendClick.channel;
                }
                return contactManagementResendClick.copy(contactManagement, contactChannel);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final ContactChannel getChannel() {
                return this.channel;
            }

            @NotNull
            public final ContactManagementResendClick copy(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                return new ContactManagementResendClick(item, channel);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContactManagementResendClick)) {
                    return false;
                }
                ContactManagementResendClick contactManagementResendClick = (ContactManagementResendClick) other;
                return Intrinsics.areEqual(this.item, contactManagementResendClick.item) && Intrinsics.areEqual(this.channel, contactManagementResendClick.channel);
            }

            public int hashCode() {
                return (this.item.hashCode() * 31) + this.channel.hashCode();
            }

            @NotNull
            public String toString() {
                return "ContactManagementResendClick(item=" + this.item + ", channel=" + this.channel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @NotNull
            public final Item.ContactManagement getItem() {
                return this.item;
            }

            @NotNull
            public final ContactChannel getChannel() {
                return this.channel;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ContactManagementResendClick(@NotNull Item.ContactManagement item, @NotNull ContactChannel channel) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(channel, "channel");
                this.item = item;
                this.channel = channel;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemPayload;", "", "()V", "ContactManagementChange", "SubscriptionChange", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemPayload$ContactManagementChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemPayload$SubscriptionChange;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class ItemPayload {
        public /* synthetic */ ItemPayload(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemPayload$SubscriptionChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemPayload;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SubscriptionChange extends ItemPayload {

            @NotNull
            public static final SubscriptionChange INSTANCE = new SubscriptionChange();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof SubscriptionChange);
            }

            public int hashCode() {
                return 1005831416;
            }

            @NotNull
            public String toString() {
                return "SubscriptionChange";
            }

            private SubscriptionChange() {
                super(null);
            }
        }

        private ItemPayload() {
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemPayload$ContactManagementChange;", "Lcom/urbanairship/preferencecenter/ui/PreferenceCenterAdapter$ItemPayload;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ContactManagementChange extends ItemPayload {

            @NotNull
            public static final ContactManagementChange INSTANCE = new ContactManagementChange();

            public boolean equals(@Nullable Object other) {
                return this == other || (other instanceof ContactManagementChange);
            }

            public int hashCode() {
                return 1803457320;
            }

            @NotNull
            public String toString() {
                return "ContactManagementChange";
            }

            private ContactManagementChange() {
                super(null);
            }
        }
    }

    @NotNull
    public final SharedFlow<ItemEvent> getItemEvents() {
        return this.itemEvents;
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C12861 extends FunctionReferenceImpl implements Function1 {
        C12861(Object obj) {
            super(1, obj, PreferenceCenterAdapter.class, "isSubscribed", "isSubscribed(Ljava/lang/String;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(String p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return Boolean.valueOf(((PreferenceCenterAdapter) this.receiver).isSubscribed(p0));
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$2, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C12872 extends FunctionReferenceImpl implements Function2 {
        C12872(Object obj) {
            super(2, obj, PreferenceCenterAdapter.class, "emitItemEvent", "emitItemEvent(IZ)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i, boolean z) {
            ((PreferenceCenterAdapter) this.receiver).emitItemEvent(i, z);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2 {
        AnonymousClass3(Object obj) {
            super(2, obj, PreferenceCenterAdapter.class, "isSubscribed", "isSubscribed(Ljava/lang/String;Ljava/util/Set;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(String p0, Set p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return Boolean.valueOf(((PreferenceCenterAdapter) this.receiver).isSubscribed(p0, p1));
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function3 {
        AnonymousClass4(Object obj) {
            super(3, obj, PreferenceCenterAdapter.class, "emitItemEvent", "emitItemEvent(ILjava/util/Set;Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke(((Number) obj).intValue(), (Set) obj2, ((Boolean) obj3).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i, Set p1, boolean z) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((PreferenceCenterAdapter) this.receiver).emitItemEvent(i, p1, z);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$5, reason: invalid class name */
    /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function2 {
        AnonymousClass5(Object obj) {
            super(2, obj, PreferenceCenterAdapter.class, "isSubscribed", "isSubscribed(Ljava/lang/String;Ljava/util/Set;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(String p0, Set p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            return Boolean.valueOf(((PreferenceCenterAdapter) this.receiver).isSubscribed(p0, p1));
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$6, reason: invalid class name */
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function3 {
        AnonymousClass6(Object obj) {
            super(3, obj, PreferenceCenterAdapter.class, "emitItemEvent", "emitItemEvent(ILjava/util/Set;Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke(((Number) obj).intValue(), (Set) obj2, ((Boolean) obj3).booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i, Set p1, boolean z) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((PreferenceCenterAdapter) this.receiver).emitItemEvent(i, p1, z);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$7, reason: invalid class name */
    /* synthetic */ class AnonymousClass7 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass7(Object obj) {
            super(1, obj, PreferenceCenterAdapter.class, "emitActions", "emitActions(Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Map) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(Map p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PreferenceCenterAdapter) this.receiver).emitActions(p0);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$9, reason: invalid class name */
    /* synthetic */ class AnonymousClass9 extends FunctionReferenceImpl implements Function1 {
        AnonymousClass9(Object obj) {
            super(1, obj, PreferenceCenterAdapter.class, "emitContactManagementAddEvent", "emitContactManagementAddEvent(I)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Number) obj).intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(int i) {
            ((PreferenceCenterAdapter) this.receiver).emitContactManagementAddEvent(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map onCreateViewHolder$lambda$0(PreferenceCenterAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.contactChannels;
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$10, reason: invalid class name */
    /* synthetic */ class AnonymousClass10 extends FunctionReferenceImpl implements Function2 {
        AnonymousClass10(Object obj) {
            super(2, obj, PreferenceCenterAdapter.class, "emitContactManagementRemoveEvent", "emitContactManagementRemoveEvent(ILcom/urbanairship/contacts/ContactChannel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (ContactChannel) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, ContactChannel p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((PreferenceCenterAdapter) this.receiver).emitContactManagementRemoveEvent(i, p1);
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$onCreateViewHolder$11, reason: invalid class name */
    /* synthetic */ class AnonymousClass11 extends FunctionReferenceImpl implements Function2 {
        AnonymousClass11(Object obj) {
            super(2, obj, PreferenceCenterAdapter.class, "emitContactManagementResendVerificationEvent", "emitContactManagementResendVerificationEvent(ILcom/urbanairship/contacts/ContactChannel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke(((Number) obj).intValue(), (ContactChannel) obj2);
            return Unit.INSTANCE;
        }

        public final void invoke(int i, ContactChannel p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            ((PreferenceCenterAdapter) this.receiver).emitContactManagementResendVerificationEvent(i, p1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public PrefCenterViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return DescriptionItem.Companion.createViewHolder$default(DescriptionItem.INSTANCE, parent, null, 2, null);
            case 1:
                return SectionItem.Companion.createViewHolder$default(SectionItem.INSTANCE, parent, null, 2, null);
            case 2:
                return SectionBreakItem.Companion.createViewHolder$default(SectionBreakItem.INSTANCE, parent, null, 2, null);
            case 3:
                return ChannelSubscriptionItem.Companion.createViewHolder$default(ChannelSubscriptionItem.INSTANCE, parent, null, new C12861(this), new C12872(this), 2, null);
            case 4:
                return ContactSubscriptionItem.Companion.createViewHolder$default(ContactSubscriptionItem.INSTANCE, parent, null, new AnonymousClass3(this), new AnonymousClass4(this), 2, null);
            case 5:
                return ContactSubscriptionGroupItem.Companion.createViewHolder$default(ContactSubscriptionGroupItem.INSTANCE, parent, null, new AnonymousClass5(this), new AnonymousClass6(this), 2, null);
            case 6:
                return AlertItem.Companion.createViewHolder$default(AlertItem.INSTANCE, parent, null, new AnonymousClass7(this), 2, null);
            case 7:
                return ContactManagementItem.INSTANCE.createViewHolder(parent, new Provider() { // from class: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$$ExternalSyntheticLambda0
                    @Override // com.urbanairship.Provider
                    public final Object get() {
                        return PreferenceCenterAdapter.onCreateViewHolder$lambda$0(this.f$0);
                    }
                }, new AnonymousClass9(this), new AnonymousClass10(this), new AnonymousClass11(this));
            default:
                throw new IllegalArgumentException("Unsupported view type: " + viewType);
        }
    }

    public void onBindViewHolder(@NotNull PrefCenterViewHolder<?> holder, int position, @NotNull List<Object> payloads) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Object objLastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) payloads);
        if (objLastOrNull instanceof ItemPayload.SubscriptionChange) {
            if (holder instanceof ChannelSubscriptionItem.ViewHolder) {
                PrefCenterItem item = getItem(position);
                Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.urbanairship.preferencecenter.ui.item.ChannelSubscriptionItem");
                ((ChannelSubscriptionItem.ViewHolder) holder).bindSwitch$urbanairship_preference_center_release((ChannelSubscriptionItem) item);
                return;
            } else if (holder instanceof ContactSubscriptionItem.ViewHolder) {
                PrefCenterItem item2 = getItem(position);
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type com.urbanairship.preferencecenter.ui.item.ContactSubscriptionItem");
                ((ContactSubscriptionItem.ViewHolder) holder).bindSwitch$urbanairship_preference_center_release((ContactSubscriptionItem) item2);
                return;
            } else {
                if (holder instanceof ContactSubscriptionGroupItem.ViewHolder) {
                    PrefCenterItem item3 = getItem(position);
                    Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type com.urbanairship.preferencecenter.ui.item.ContactSubscriptionGroupItem");
                    ((ContactSubscriptionGroupItem.ViewHolder) holder).bindChips$urbanairship_preference_center_release((ContactSubscriptionGroupItem) item3);
                    return;
                }
                return;
            }
        }
        if (objLastOrNull instanceof ItemPayload.ContactManagementChange) {
            if (holder instanceof ContactManagementItem.ViewHolder) {
                PrefCenterItem item4 = getItem(position);
                Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type com.urbanairship.preferencecenter.ui.item.ContactManagementItem");
                ((ContactManagementItem.ViewHolder) holder).bindContactChannels$urbanairship_preference_center_release((ContactManagementItem) item4);
                return;
            }
            return;
        }
        onBindViewHolder(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull PrefCenterViewHolder<?> holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PrefCenterItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bindItem(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return UUID.fromString(getItem(position).getId()).getLeastSignificantBits();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    public final void submit(@NotNull List<? extends PrefCenterItem> items, @NotNull Set<String> channelSubscriptions, @NotNull Map<String, ? extends Set<? extends Scope>> contactSubscriptions, @NotNull Map<ContactChannel, PreferenceCenterViewModel.State.Content.ContactChannelState> contactChannels) {
        List<? extends PrefCenterItem> listPlus;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(channelSubscriptions, "channelSubscriptions");
        Intrinsics.checkNotNullParameter(contactSubscriptions, "contactSubscriptions");
        Intrinsics.checkNotNullParameter(contactChannels, "contactChannels");
        setSubscriptions(channelSubscriptions, contactSubscriptions, contactChannels);
        DescriptionItem descriptionItem = this.descriptionItem;
        if (descriptionItem != null && (listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(descriptionItem), (Iterable) items)) != null) {
            items = listPlus;
        }
        submitList(items);
    }

    private final void setSubscriptions(Set channelSubscriptions, Map contactSubscriptions, Map contactChannels) {
        int i = 0;
        if (!Intrinsics.areEqual(this.channelSubscriptions, channelSubscriptions)) {
            Set set = this.channelSubscriptions;
            set.clear();
            set.addAll(channelSubscriptions);
            List<PrefCenterItem> currentList = getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            int i2 = 0;
            for (Object obj : currentList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (((PrefCenterItem) obj) instanceof ChannelSubscriptionItem) {
                    notifyItemChanged(i2, ItemPayload.SubscriptionChange.INSTANCE);
                }
                i2 = i3;
            }
        }
        if (!Intrinsics.areEqual(this.contactSubscriptions, contactSubscriptions)) {
            Map map = this.contactSubscriptions;
            map.clear();
            map.putAll(contactSubscriptions);
            List<PrefCenterItem> currentList2 = getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList2, "getCurrentList(...)");
            int i4 = 0;
            for (Object obj2 : currentList2) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PrefCenterItem prefCenterItem = (PrefCenterItem) obj2;
                if ((prefCenterItem instanceof ContactSubscriptionItem) || (prefCenterItem instanceof ContactSubscriptionGroupItem)) {
                    notifyItemChanged(i4, ItemPayload.SubscriptionChange.INSTANCE);
                }
                i4 = i5;
            }
        }
        if (Intrinsics.areEqual(this.contactChannels, contactChannels)) {
            return;
        }
        Map map2 = this.contactChannels;
        map2.clear();
        map2.putAll(contactChannels);
        List<PrefCenterItem> currentList3 = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList3, "getCurrentList(...)");
        for (Object obj3 : currentList3) {
            int i6 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((PrefCenterItem) obj3) instanceof ContactManagementItem) {
                notifyItemChanged(i, ItemPayload.ContactManagementChange.INSTANCE);
            }
            i = i6;
        }
    }

    public final void setHeaderItem$urbanairship_preference_center_release(@Nullable String title, @Nullable String description) {
        DescriptionItem descriptionItem;
        DescriptionItem descriptionItem2 = ((title == null || StringsKt.isBlank(title)) && (description == null || StringsKt.isBlank(description))) ? null : new DescriptionItem(title, description);
        if (descriptionItem2 == null || (descriptionItem = this.descriptionItem) == null || !descriptionItem.areContentsTheSame(descriptionItem2)) {
            this.descriptionItem = descriptionItem2;
            if (getCurrentList().isEmpty()) {
                return;
            }
            List<PrefCenterItem> currentList = getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            List mutableList = CollectionsKt.toMutableList((Collection) currentList);
            if (CollectionsKt.firstOrNull(mutableList) instanceof DescriptionItem) {
                mutableList.remove(0);
            }
            if (descriptionItem2 != null) {
                mutableList.add(0, descriptionItem2);
                submitList(mutableList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSubscribed(String id) {
        return this.channelSubscriptions.contains(id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSubscribed(String id, Set scopes) {
        Set set = (Set) this.contactSubscriptions.get(id);
        Set setIntersect = set != null ? CollectionsKt.intersect(set, scopes) : null;
        return !(setIntersect == null || setIntersect.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitItemEvent(int position, boolean isChecked) {
        PrefCenterItem item = getItem(position);
        ItemEvent.ChannelSubscriptionChange channelSubscriptionChange = item instanceof ChannelSubscriptionItem ? new ItemEvent.ChannelSubscriptionChange(((ChannelSubscriptionItem) item).getItem(), isChecked) : null;
        if (channelSubscriptionChange == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.scopeProvider.invoke(), null, null, new C12851(channelSubscriptionChange, null), 3, null);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$emitItemEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C12851 extends SuspendLambda implements Function2 {
        final /* synthetic */ ItemEvent.ChannelSubscriptionChange $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12851(ItemEvent.ChannelSubscriptionChange channelSubscriptionChange, Continuation continuation) {
            super(2, continuation);
            this.$event = channelSubscriptionChange;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterAdapter.this.new C12851(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PreferenceCenterAdapter.this.itemEventsFlow;
                ItemEvent.ChannelSubscriptionChange channelSubscriptionChange = this.$event;
                this.label = 1;
                if (mutableSharedFlow.emit(channelSubscriptionChange, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitItemEvent(int position, Set scopes, boolean isChecked) {
        ItemEvent contactSubscriptionGroupChange;
        PrefCenterItem item = getItem(position);
        if (item instanceof ContactSubscriptionItem) {
            contactSubscriptionGroupChange = new ItemEvent.ContactSubscriptionChange(((ContactSubscriptionItem) item).getItem(), scopes, isChecked);
        } else {
            contactSubscriptionGroupChange = item instanceof ContactSubscriptionGroupItem ? new ItemEvent.ContactSubscriptionGroupChange(((ContactSubscriptionGroupItem) item).getItem(), scopes, isChecked) : null;
        }
        if (contactSubscriptionGroupChange == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.scopeProvider.invoke(), null, null, new AnonymousClass2(contactSubscriptionGroupChange, null), 3, null);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$emitItemEvent$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ ItemEvent $event;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ItemEvent itemEvent, Continuation continuation) {
            super(2, continuation);
            this.$event = itemEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterAdapter.this.new AnonymousClass2(this.$event, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PreferenceCenterAdapter.this.itemEventsFlow;
                ItemEvent itemEvent = this.$event;
                this.label = 1;
                if (mutableSharedFlow.emit(itemEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$emitActions$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2 {
        final /* synthetic */ Map $actions;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Map map, Continuation continuation) {
            super(2, continuation);
            this.$actions = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterAdapter.this.new AnonymousClass1(this.$actions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PreferenceCenterAdapter.this.itemEventsFlow;
                ItemEvent.ButtonClick buttonClick = new ItemEvent.ButtonClick(this.$actions);
                this.label = 1;
                if (mutableSharedFlow.emit(buttonClick, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitActions(Map actions) {
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.scopeProvider.invoke(), null, null, new AnonymousClass1(actions, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitContactManagementAddEvent(int position) {
        PrefCenterItem item = getItem(position);
        ContactManagementItem contactManagementItem = item instanceof ContactManagementItem ? (ContactManagementItem) item : null;
        if (contactManagementItem == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.scopeProvider.invoke(), null, null, new C12821(contactManagementItem, null), 3, null);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$emitContactManagementAddEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C12821 extends SuspendLambda implements Function2 {
        final /* synthetic */ ContactManagementItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12821(ContactManagementItem contactManagementItem, Continuation continuation) {
            super(2, continuation);
            this.$item = contactManagementItem;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterAdapter.this.new C12821(this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PreferenceCenterAdapter.this.itemEventsFlow;
                ItemEvent.ContactManagementAddClick contactManagementAddClick = new ItemEvent.ContactManagementAddClick(this.$item.getItem());
                this.label = 1;
                if (mutableSharedFlow.emit(contactManagementAddClick, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitContactManagementRemoveEvent(int position, ContactChannel channel) {
        PrefCenterItem item = getItem(position);
        ContactManagementItem contactManagementItem = item instanceof ContactManagementItem ? (ContactManagementItem) item : null;
        if (contactManagementItem == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.scopeProvider.invoke(), null, null, new C12831(contactManagementItem, channel, null), 3, null);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$emitContactManagementRemoveEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C12831 extends SuspendLambda implements Function2 {
        final /* synthetic */ ContactChannel $channel;
        final /* synthetic */ ContactManagementItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12831(ContactManagementItem contactManagementItem, ContactChannel contactChannel, Continuation continuation) {
            super(2, continuation);
            this.$item = contactManagementItem;
            this.$channel = contactChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterAdapter.this.new C12831(this.$item, this.$channel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PreferenceCenterAdapter.this.itemEventsFlow;
                ItemEvent.ContactManagementRemoveClick contactManagementRemoveClick = new ItemEvent.ContactManagementRemoveClick(this.$item.getItem(), this.$channel);
                this.label = 1;
                if (mutableSharedFlow.emit(contactManagementRemoveClick, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitContactManagementResendVerificationEvent(int position, ContactChannel channel) {
        PrefCenterItem item = getItem(position);
        ContactManagementItem contactManagementItem = item instanceof ContactManagementItem ? (ContactManagementItem) item : null;
        if (contactManagementItem == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.scopeProvider.invoke(), null, null, new C12841(contactManagementItem, channel, null), 3, null);
    }

    /* renamed from: com.urbanairship.preferencecenter.ui.PreferenceCenterAdapter$emitContactManagementResendVerificationEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C12841 extends SuspendLambda implements Function2 {
        final /* synthetic */ ContactChannel $channel;
        final /* synthetic */ ContactManagementItem $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12841(ContactManagementItem contactManagementItem, ContactChannel contactChannel, Continuation continuation) {
            super(2, continuation);
            this.$item = contactManagementItem;
            this.$channel = contactChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PreferenceCenterAdapter.this.new C12841(this.$item, this.$channel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C12841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = PreferenceCenterAdapter.this.itemEventsFlow;
                ItemEvent.ContactManagementResendClick contactManagementResendClick = new ItemEvent.ContactManagementResendClick(this.$item.getItem(), this.$channel);
                this.label = 1;
                if (mutableSharedFlow.emit(contactManagementResendClick, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
