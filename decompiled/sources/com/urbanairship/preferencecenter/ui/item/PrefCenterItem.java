package com.urbanairship.preferencecenter.ui.item;

import com.urbanairship.preferencecenter.data.Condition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000H&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0000H&R\u001c\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\b\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/preferencecenter/ui/item/PrefCenterItem;", "", "type", "", "(I)V", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "()Ljava/util/List;", "id", "", "getId", "()Ljava/lang/String;", "getType", "()I", "areContentsTheSame", "", "otherItem", "areItemsTheSame", "Companion", "Lcom/urbanairship/preferencecenter/ui/item/AlertItem;", "Lcom/urbanairship/preferencecenter/ui/item/ChannelSubscriptionItem;", "Lcom/urbanairship/preferencecenter/ui/item/ContactManagementItem;", "Lcom/urbanairship/preferencecenter/ui/item/ContactSubscriptionGroupItem;", "Lcom/urbanairship/preferencecenter/ui/item/ContactSubscriptionItem;", "Lcom/urbanairship/preferencecenter/ui/item/DescriptionItem;", "Lcom/urbanairship/preferencecenter/ui/item/SectionBreakItem;", "Lcom/urbanairship/preferencecenter/ui/item/SectionItem;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PrefCenterItem {
    public static final int TYPE_ALERT = 6;
    public static final int TYPE_CONTACT_MANAGEMENT = 7;
    public static final int TYPE_DESCRIPTION = 0;
    public static final int TYPE_PREF_CHANNEL_SUBSCRIPTION = 3;
    public static final int TYPE_PREF_CONTACT_SUBSCRIPTION = 4;
    public static final int TYPE_PREF_CONTACT_SUBSCRIPTION_GROUP = 5;
    public static final int TYPE_SECTION = 1;
    public static final int TYPE_SECTION_BREAK = 2;
    private final int type;

    public /* synthetic */ PrefCenterItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    public abstract boolean areContentsTheSame(@NotNull PrefCenterItem otherItem);

    public abstract boolean areItemsTheSame(@NotNull PrefCenterItem otherItem);

    @NotNull
    public abstract List<Condition> getConditions();

    @NotNull
    public abstract String getId();

    private PrefCenterItem(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
