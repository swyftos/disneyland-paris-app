package com.urbanairship.preferencecenter.data;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.amazonaws.cognito.clientcontext.datacollection.DataRecordKey;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.contacts.ChannelType;
import com.urbanairship.contacts.Scope;
import com.urbanairship.deferred.DeferredApiClient;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.CommonDisplay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 !2\u00020\u0001:\u0006\u001f !\"#$B'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0004J\r\u0010\u001c\u001a\u00020\u001dH ¢\u0006\u0002\b\u001eR\u001c\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0012\u0010\u0017\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0005%&'()¨\u0006*"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item;", "", "type", "", "hasChannelSubscriptions", "", "hasContactSubscriptions", "hasContactManagement", "(Ljava/lang/String;ZZZ)V", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "getConditions", "()Ljava/util/List;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getHasChannelSubscriptions$urbanairship_preference_center_release", "()Z", "getHasContactManagement$urbanairship_preference_center_release", "getHasContactSubscriptions$urbanairship_preference_center_release", "id", "getId", "()Ljava/lang/String;", "jsonMapBuilder", "Lcom/urbanairship/json/JsonMap$Builder;", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "Alert", "ChannelSubscription", "Companion", "ContactManagement", "ContactSubscription", "ContactSubscriptionGroup", "Lcom/urbanairship/preferencecenter/data/Item$Alert;", "Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscription;", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,690:1\n1549#2:691\n1620#2,3:692\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item\n*L\n688#1:691\n688#1:692,3\n*E\n"})
/* loaded from: classes5.dex */
public abstract class Item {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean hasChannelSubscriptions;
    private final boolean hasContactManagement;
    private final boolean hasContactSubscriptions;
    private final String type;

    public /* synthetic */ Item(String str, boolean z, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, z2, z3);
    }

    @NotNull
    public abstract List<Condition> getConditions();

    @NotNull
    public abstract CommonDisplay getDisplay();

    @NotNull
    public abstract String getId();

    @NotNull
    public abstract JsonMap toJson$urbanairship_preference_center_release();

    private Item(String str, boolean z, boolean z2, boolean z3) {
        this.type = str;
        this.hasChannelSubscriptions = z;
        this.hasContactSubscriptions = z2;
        this.hasContactManagement = z3;
    }

    /* renamed from: getHasChannelSubscriptions$urbanairship_preference_center_release, reason: from getter */
    public final boolean getHasChannelSubscriptions() {
        return this.hasChannelSubscriptions;
    }

    /* renamed from: getHasContactSubscriptions$urbanairship_preference_center_release, reason: from getter */
    public final boolean getHasContactSubscriptions() {
        return this.hasContactSubscriptions;
    }

    /* renamed from: getHasContactManagement$urbanairship_preference_center_release, reason: from getter */
    public final boolean getHasContactManagement() {
        return this.hasContactManagement;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\nHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\r\u0010\u001e\u001a\u00020\u001fH\u0010¢\u0006\u0002\b J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t0\bj\u0002`\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\""}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ChannelSubscription;", "Lcom/urbanairship/preferencecenter/data/Item;", "id", "", "subscriptionId", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/CommonDisplay;Ljava/util/List;)V", "getConditions", "()Ljava/util/List;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getId", "()Ljava/lang/String;", "getSubscriptionId", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChannelSubscription extends Item {
        private final List conditions;
        private final CommonDisplay display;
        private final String id;
        private final String subscriptionId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChannelSubscription copy$default(ChannelSubscription channelSubscription, String str, String str2, CommonDisplay commonDisplay, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = channelSubscription.id;
            }
            if ((i & 2) != 0) {
                str2 = channelSubscription.subscriptionId;
            }
            if ((i & 4) != 0) {
                commonDisplay = channelSubscription.display;
            }
            if ((i & 8) != 0) {
                list = channelSubscription.conditions;
            }
            return channelSubscription.copy(str, str2, commonDisplay, list);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final CommonDisplay getDisplay() {
            return this.display;
        }

        @NotNull
        public final List<Condition> component4() {
            return this.conditions;
        }

        @NotNull
        public final ChannelSubscription copy(@NotNull String id, @NotNull String subscriptionId, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            return new ChannelSubscription(id, subscriptionId, display, conditions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelSubscription)) {
                return false;
            }
            ChannelSubscription channelSubscription = (ChannelSubscription) other;
            return Intrinsics.areEqual(this.id, channelSubscription.id) && Intrinsics.areEqual(this.subscriptionId, channelSubscription.subscriptionId) && Intrinsics.areEqual(this.display, channelSubscription.display) && Intrinsics.areEqual(this.conditions, channelSubscription.conditions);
        }

        public int hashCode() {
            return (((((this.id.hashCode() * 31) + this.subscriptionId.hashCode()) * 31) + this.display.hashCode()) * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "ChannelSubscription(id=" + this.id + ", subscriptionId=" + this.subscriptionId + ", display=" + this.display + ", conditions=" + this.conditions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public String getId() {
            return this.id;
        }

        @NotNull
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public CommonDisplay getDisplay() {
            return this.display;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public List<Condition> getConditions() {
            return this.conditions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelSubscription(@NotNull String id, @NotNull String subscriptionId, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            super("channel_subscription", true, false, false, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.id = id;
            this.subscriptionId = subscriptionId;
            this.display = display;
            this.conditions = conditions;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() {
            JsonMap jsonMapBuild = jsonMapBuilder().put("subscription_id", this.subscriptionId).build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000 42\u00020\u0001:\u000e123456789:;<=>BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010%\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010HÆ\u0003J[\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\r\u0010-\u001a\u00020.H\u0010¢\u0006\u0002\b/J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006?"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "Lcom/urbanairship/preferencecenter/data/Item;", "id", "", DeferredApiClient.KEY_PLATFORM, "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "addPrompt", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt;", "removePrompt", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt;", "emptyLabel", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "(Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;Lcom/urbanairship/preferencecenter/data/CommonDisplay;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt;Ljava/lang/String;Ljava/util/List;)V", "getAddPrompt", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt;", "getConditions", "()Ljava/util/List;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getEmptyLabel", "()Ljava/lang/String;", "getId", "getPlatform", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "getRemovePrompt", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "ActionableMessage", "AddChannelPrompt", "AddPrompt", "Companion", "ErrorMessages", "IconButton", "LabeledButton", DataRecordKey.PLATFORM, "PromptDisplay", "RegistrationOptions", "RemoveChannelPrompt", "RemovePrompt", "ResendOptions", "SmsSenderInfo", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ContactManagement extends Item {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final AddPrompt addPrompt;
        private final List conditions;
        private final CommonDisplay display;
        private final String emptyLabel;
        private final String id;
        private final Platform platform;
        private final RemovePrompt removePrompt;

        public static /* synthetic */ ContactManagement copy$default(ContactManagement contactManagement, String str, Platform platform, CommonDisplay commonDisplay, AddPrompt addPrompt, RemovePrompt removePrompt, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contactManagement.id;
            }
            if ((i & 2) != 0) {
                platform = contactManagement.platform;
            }
            Platform platform2 = platform;
            if ((i & 4) != 0) {
                commonDisplay = contactManagement.display;
            }
            CommonDisplay commonDisplay2 = commonDisplay;
            if ((i & 8) != 0) {
                addPrompt = contactManagement.addPrompt;
            }
            AddPrompt addPrompt2 = addPrompt;
            if ((i & 16) != 0) {
                removePrompt = contactManagement.removePrompt;
            }
            RemovePrompt removePrompt2 = removePrompt;
            if ((i & 32) != 0) {
                str2 = contactManagement.emptyLabel;
            }
            String str3 = str2;
            if ((i & 64) != 0) {
                list = contactManagement.conditions;
            }
            return contactManagement.copy(str, platform2, commonDisplay2, addPrompt2, removePrompt2, str3, list);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final Platform getPlatform() {
            return this.platform;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final CommonDisplay getDisplay() {
            return this.display;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final AddPrompt getAddPrompt() {
            return this.addPrompt;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final RemovePrompt getRemovePrompt() {
            return this.removePrompt;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getEmptyLabel() {
            return this.emptyLabel;
        }

        @NotNull
        public final List<Condition> component7() {
            return this.conditions;
        }

        @NotNull
        public final ContactManagement copy(@NotNull String id, @NotNull Platform platform, @NotNull CommonDisplay display, @NotNull AddPrompt addPrompt, @NotNull RemovePrompt removePrompt, @Nullable String emptyLabel, @NotNull List<? extends Condition> conditions) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(platform, "platform");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(addPrompt, "addPrompt");
            Intrinsics.checkNotNullParameter(removePrompt, "removePrompt");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            return new ContactManagement(id, platform, display, addPrompt, removePrompt, emptyLabel, conditions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContactManagement)) {
                return false;
            }
            ContactManagement contactManagement = (ContactManagement) other;
            return Intrinsics.areEqual(this.id, contactManagement.id) && Intrinsics.areEqual(this.platform, contactManagement.platform) && Intrinsics.areEqual(this.display, contactManagement.display) && Intrinsics.areEqual(this.addPrompt, contactManagement.addPrompt) && Intrinsics.areEqual(this.removePrompt, contactManagement.removePrompt) && Intrinsics.areEqual(this.emptyLabel, contactManagement.emptyLabel) && Intrinsics.areEqual(this.conditions, contactManagement.conditions);
        }

        public int hashCode() {
            int iHashCode = ((((((((this.id.hashCode() * 31) + this.platform.hashCode()) * 31) + this.display.hashCode()) * 31) + this.addPrompt.hashCode()) * 31) + this.removePrompt.hashCode()) * 31;
            String str = this.emptyLabel;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "ContactManagement(id=" + this.id + ", platform=" + this.platform + ", display=" + this.display + ", addPrompt=" + this.addPrompt + ", removePrompt=" + this.removePrompt + ", emptyLabel=" + this.emptyLabel + ", conditions=" + this.conditions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H&R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions;", "", "type", "", "(Ljava/lang/String;)V", "errorMessages", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "getErrorMessages", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "resendOptions", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "getResendOptions", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "getType", "()Ljava/lang/String;", "toJson", "Lcom/urbanairship/json/JsonMap;", "Email", "Sms", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class RegistrationOptions {
            private final String type;

            public /* synthetic */ RegistrationOptions(String str, DefaultConstructorMarker defaultConstructorMarker) {
                this(str);
            }

            @NotNull
            public abstract ErrorMessages getErrorMessages();

            @NotNull
            public abstract ResendOptions getResendOptions();

            @NotNull
            public abstract JsonMap toJson() throws JsonException;

            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions;", "senders", "", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$SmsSenderInfo;", "countryLabel", "", "phoneLabel", "resendOptions", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "errorMessages", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;)V", "getCountryLabel", "()Ljava/lang/String;", "getErrorMessages", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "getPhoneLabel", "getResendOptions", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "getSenders", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,690:1\n1549#2:691\n1620#2,3:692\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms\n*L\n503#1:691\n503#1:692,3\n*E\n"})
            public static final /* data */ class Sms extends RegistrationOptions {

                /* renamed from: Companion, reason: from kotlin metadata */
                @NotNull
                public static final Companion INSTANCE = new Companion(null);
                private final String countryLabel;
                private final ErrorMessages errorMessages;
                private final String phoneLabel;
                private final ResendOptions resendOptions;
                private final List senders;

                public static /* synthetic */ Sms copy$default(Sms sms, List list, String str, String str2, ResendOptions resendOptions, ErrorMessages errorMessages, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = sms.senders;
                    }
                    if ((i & 2) != 0) {
                        str = sms.countryLabel;
                    }
                    String str3 = str;
                    if ((i & 4) != 0) {
                        str2 = sms.phoneLabel;
                    }
                    String str4 = str2;
                    if ((i & 8) != 0) {
                        resendOptions = sms.resendOptions;
                    }
                    ResendOptions resendOptions2 = resendOptions;
                    if ((i & 16) != 0) {
                        errorMessages = sms.errorMessages;
                    }
                    return sms.copy(list, str3, str4, resendOptions2, errorMessages);
                }

                @NotNull
                public final List<SmsSenderInfo> component1() {
                    return this.senders;
                }

                @NotNull
                /* renamed from: component2, reason: from getter */
                public final String getCountryLabel() {
                    return this.countryLabel;
                }

                @NotNull
                /* renamed from: component3, reason: from getter */
                public final String getPhoneLabel() {
                    return this.phoneLabel;
                }

                @NotNull
                /* renamed from: component4, reason: from getter */
                public final ResendOptions getResendOptions() {
                    return this.resendOptions;
                }

                @NotNull
                /* renamed from: component5, reason: from getter */
                public final ErrorMessages getErrorMessages() {
                    return this.errorMessages;
                }

                @NotNull
                public final Sms copy(@NotNull List<SmsSenderInfo> senders, @NotNull String countryLabel, @NotNull String phoneLabel, @NotNull ResendOptions resendOptions, @NotNull ErrorMessages errorMessages) {
                    Intrinsics.checkNotNullParameter(senders, "senders");
                    Intrinsics.checkNotNullParameter(countryLabel, "countryLabel");
                    Intrinsics.checkNotNullParameter(phoneLabel, "phoneLabel");
                    Intrinsics.checkNotNullParameter(resendOptions, "resendOptions");
                    Intrinsics.checkNotNullParameter(errorMessages, "errorMessages");
                    return new Sms(senders, countryLabel, phoneLabel, resendOptions, errorMessages);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Sms)) {
                        return false;
                    }
                    Sms sms = (Sms) other;
                    return Intrinsics.areEqual(this.senders, sms.senders) && Intrinsics.areEqual(this.countryLabel, sms.countryLabel) && Intrinsics.areEqual(this.phoneLabel, sms.phoneLabel) && Intrinsics.areEqual(this.resendOptions, sms.resendOptions) && Intrinsics.areEqual(this.errorMessages, sms.errorMessages);
                }

                public int hashCode() {
                    return (((((((this.senders.hashCode() * 31) + this.countryLabel.hashCode()) * 31) + this.phoneLabel.hashCode()) * 31) + this.resendOptions.hashCode()) * 31) + this.errorMessages.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Sms(senders=" + this.senders + ", countryLabel=" + this.countryLabel + ", phoneLabel=" + this.phoneLabel + ", resendOptions=" + this.resendOptions + ", errorMessages=" + this.errorMessages + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms$Companion;", "", "()V", "KEY_COUNTRY_LABEL", "", "KEY_PHONE_LABEL", "KEY_SENDERS", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:710\n44#2,15:725\n44#2,15:740\n1549#3:706\n1620#3,3:707\n1#4:755\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms$Companion\n*L\n518#1:691,15\n519#1:710,15\n520#1:725,15\n521#1:740,15\n518#1:706\n518#1:707,3\n*E\n"})
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    /* JADX WARN: Removed duplicated region for block: B:121:0x02c5  */
                    /* JADX WARN: Removed duplicated region for block: B:243:0x05b6  */
                    @org.jetbrains.annotations.NotNull
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions.Sms fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r26) throws com.urbanairship.json.JsonException {
                        /*
                            Method dump skipped, instructions count: 1625
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions.Sms.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item$ContactManagement$RegistrationOptions$Sms");
                    }

                    private Companion() {
                    }
                }

                @NotNull
                public final List<SmsSenderInfo> getSenders() {
                    return this.senders;
                }

                @NotNull
                public final String getCountryLabel() {
                    return this.countryLabel;
                }

                @NotNull
                public final String getPhoneLabel() {
                    return this.phoneLabel;
                }

                @Override // com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions
                @NotNull
                public ResendOptions getResendOptions() {
                    return this.resendOptions;
                }

                @Override // com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions
                @NotNull
                public ErrorMessages getErrorMessages() {
                    return this.errorMessages;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Sms(@NotNull List<SmsSenderInfo> senders, @NotNull String countryLabel, @NotNull String phoneLabel, @NotNull ResendOptions resendOptions, @NotNull ErrorMessages errorMessages) {
                    super("sms", null);
                    Intrinsics.checkNotNullParameter(senders, "senders");
                    Intrinsics.checkNotNullParameter(countryLabel, "countryLabel");
                    Intrinsics.checkNotNullParameter(phoneLabel, "phoneLabel");
                    Intrinsics.checkNotNullParameter(resendOptions, "resendOptions");
                    Intrinsics.checkNotNullParameter(errorMessages, "errorMessages");
                    this.senders = senders;
                    this.countryLabel = countryLabel;
                    this.phoneLabel = phoneLabel;
                    this.resendOptions = resendOptions;
                    this.errorMessages = errorMessages;
                }

                @Override // com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions
                @NotNull
                public JsonMap toJson() throws JsonException {
                    List list = this.senders;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((SmsSenderInfo) it.next()).toJson());
                    }
                    return JsonExtensionsKt.jsonMapOf(TuplesKt.to("senders", arrayList), TuplesKt.to("country_label", this.countryLabel), TuplesKt.to("msisdn_label", this.phoneLabel), TuplesKt.to("resend", getResendOptions().toJson()), TuplesKt.to("error_messages", getErrorMessages().toJson()));
                }
            }

            @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\b\u0010!\u001a\u00020\u0006H\u0016J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions;", ReactTextInputShadowNode.PROP_PLACEHOLDER, "", "addressLabel", CustomEvent.PROPERTIES, "Lcom/urbanairship/json/JsonMap;", "resendOptions", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "errorMessages", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;)V", "getAddressLabel", "()Ljava/lang/String;", "getErrorMessages", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "getPlaceholder", "getProperties", "()Lcom/urbanairship/json/JsonMap;", "getResendOptions", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Email extends RegistrationOptions {

                /* renamed from: Companion, reason: from kotlin metadata */
                @NotNull
                public static final Companion INSTANCE = new Companion(null);
                private final String addressLabel;
                private final ErrorMessages errorMessages;
                private final String placeholder;
                private final JsonMap properties;
                private final ResendOptions resendOptions;

                public static /* synthetic */ Email copy$default(Email email, String str, String str2, JsonMap jsonMap, ResendOptions resendOptions, ErrorMessages errorMessages, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = email.placeholder;
                    }
                    if ((i & 2) != 0) {
                        str2 = email.addressLabel;
                    }
                    String str3 = str2;
                    if ((i & 4) != 0) {
                        jsonMap = email.properties;
                    }
                    JsonMap jsonMap2 = jsonMap;
                    if ((i & 8) != 0) {
                        resendOptions = email.resendOptions;
                    }
                    ResendOptions resendOptions2 = resendOptions;
                    if ((i & 16) != 0) {
                        errorMessages = email.errorMessages;
                    }
                    return email.copy(str, str3, jsonMap2, resendOptions2, errorMessages);
                }

                @Nullable
                /* renamed from: component1, reason: from getter */
                public final String getPlaceholder() {
                    return this.placeholder;
                }

                @NotNull
                /* renamed from: component2, reason: from getter */
                public final String getAddressLabel() {
                    return this.addressLabel;
                }

                @Nullable
                /* renamed from: component3, reason: from getter */
                public final JsonMap getProperties() {
                    return this.properties;
                }

                @NotNull
                /* renamed from: component4, reason: from getter */
                public final ResendOptions getResendOptions() {
                    return this.resendOptions;
                }

                @NotNull
                /* renamed from: component5, reason: from getter */
                public final ErrorMessages getErrorMessages() {
                    return this.errorMessages;
                }

                @NotNull
                public final Email copy(@Nullable String placeholder, @NotNull String addressLabel, @Nullable JsonMap properties, @NotNull ResendOptions resendOptions, @NotNull ErrorMessages errorMessages) {
                    Intrinsics.checkNotNullParameter(addressLabel, "addressLabel");
                    Intrinsics.checkNotNullParameter(resendOptions, "resendOptions");
                    Intrinsics.checkNotNullParameter(errorMessages, "errorMessages");
                    return new Email(placeholder, addressLabel, properties, resendOptions, errorMessages);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Email)) {
                        return false;
                    }
                    Email email = (Email) other;
                    return Intrinsics.areEqual(this.placeholder, email.placeholder) && Intrinsics.areEqual(this.addressLabel, email.addressLabel) && Intrinsics.areEqual(this.properties, email.properties) && Intrinsics.areEqual(this.resendOptions, email.resendOptions) && Intrinsics.areEqual(this.errorMessages, email.errorMessages);
                }

                public int hashCode() {
                    String str = this.placeholder;
                    int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.addressLabel.hashCode()) * 31;
                    JsonMap jsonMap = this.properties;
                    return ((((iHashCode + (jsonMap != null ? jsonMap.hashCode() : 0)) * 31) + this.resendOptions.hashCode()) * 31) + this.errorMessages.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Email(placeholder=" + this.placeholder + ", addressLabel=" + this.addressLabel + ", properties=" + this.properties + ", resendOptions=" + this.resendOptions + ", errorMessages=" + this.errorMessages + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email$Companion;", "", "()V", "KEY_ADDRESS_LABEL", "", "KEY_PROPERTIES", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
                @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,690:1\n79#2,16:691\n44#2,15:707\n79#2,16:722\n44#2,15:738\n1#3:753\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email$Companion\n*L\n553#1:691,16\n554#1:707,15\n555#1:722,16\n556#1:738,15\n*E\n"})
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    /* JADX WARN: Removed duplicated region for block: B:103:0x0284  */
                    /* JADX WARN: Removed duplicated region for block: B:104:0x0289  */
                    /* JADX WARN: Removed duplicated region for block: B:147:0x03bc  */
                    /* JADX WARN: Removed duplicated region for block: B:207:0x0534  */
                    @org.jetbrains.annotations.NotNull
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions.Email fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r26) throws com.urbanairship.json.JsonException {
                        /*
                            Method dump skipped, instructions count: 1510
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions.Email.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item$ContactManagement$RegistrationOptions$Email");
                    }

                    private Companion() {
                    }
                }

                @Nullable
                public final String getPlaceholder() {
                    return this.placeholder;
                }

                @NotNull
                public final String getAddressLabel() {
                    return this.addressLabel;
                }

                @Nullable
                public final JsonMap getProperties() {
                    return this.properties;
                }

                @Override // com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions
                @NotNull
                public ResendOptions getResendOptions() {
                    return this.resendOptions;
                }

                @Override // com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions
                @NotNull
                public ErrorMessages getErrorMessages() {
                    return this.errorMessages;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Email(@Nullable String str, @NotNull String addressLabel, @Nullable JsonMap jsonMap, @NotNull ResendOptions resendOptions, @NotNull ErrorMessages errorMessages) {
                    super("email", null);
                    Intrinsics.checkNotNullParameter(addressLabel, "addressLabel");
                    Intrinsics.checkNotNullParameter(resendOptions, "resendOptions");
                    Intrinsics.checkNotNullParameter(errorMessages, "errorMessages");
                    this.placeholder = str;
                    this.addressLabel = addressLabel;
                    this.properties = jsonMap;
                    this.resendOptions = resendOptions;
                    this.errorMessages = errorMessages;
                }

                @Override // com.urbanairship.preferencecenter.data.Item.ContactManagement.RegistrationOptions
                @NotNull
                public JsonMap toJson() throws JsonException {
                    return JsonExtensionsKt.jsonMapOf(TuplesKt.to("placeholder_text", this.placeholder), TuplesKt.to("address_label", this.addressLabel), TuplesKt.to(CustomEvent.PROPERTIES, this.properties), TuplesKt.to("resend", getResendOptions().toJson()), TuplesKt.to("error_messages", getErrorMessages().toJson()));
                }
            }

            private RegistrationOptions(String str) {
                this.type = str;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt;", "", "type", "", "display", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;", "submitButton", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "closeButton", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "cancelButton", "onSubmit", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "(Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;)V", "getCancelButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "getCloseButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;", "getOnSubmit", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "getSubmitButton", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AddChannelPrompt {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final LabeledButton cancelButton;
            private final IconButton closeButton;
            private final PromptDisplay display;
            private final ActionableMessage onSubmit;
            private final LabeledButton submitButton;
            private final String type;

            public static /* synthetic */ AddChannelPrompt copy$default(AddChannelPrompt addChannelPrompt, String str, PromptDisplay promptDisplay, LabeledButton labeledButton, IconButton iconButton, LabeledButton labeledButton2, ActionableMessage actionableMessage, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = addChannelPrompt.type;
                }
                if ((i & 2) != 0) {
                    promptDisplay = addChannelPrompt.display;
                }
                PromptDisplay promptDisplay2 = promptDisplay;
                if ((i & 4) != 0) {
                    labeledButton = addChannelPrompt.submitButton;
                }
                LabeledButton labeledButton3 = labeledButton;
                if ((i & 8) != 0) {
                    iconButton = addChannelPrompt.closeButton;
                }
                IconButton iconButton2 = iconButton;
                if ((i & 16) != 0) {
                    labeledButton2 = addChannelPrompt.cancelButton;
                }
                LabeledButton labeledButton4 = labeledButton2;
                if ((i & 32) != 0) {
                    actionableMessage = addChannelPrompt.onSubmit;
                }
                return addChannelPrompt.copy(str, promptDisplay2, labeledButton3, iconButton2, labeledButton4, actionableMessage);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final PromptDisplay getDisplay() {
                return this.display;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final LabeledButton getSubmitButton() {
                return this.submitButton;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final IconButton getCloseButton() {
                return this.closeButton;
            }

            @Nullable
            /* renamed from: component5, reason: from getter */
            public final LabeledButton getCancelButton() {
                return this.cancelButton;
            }

            @Nullable
            /* renamed from: component6, reason: from getter */
            public final ActionableMessage getOnSubmit() {
                return this.onSubmit;
            }

            @NotNull
            public final AddChannelPrompt copy(@NotNull String type, @NotNull PromptDisplay display, @NotNull LabeledButton submitButton, @Nullable IconButton closeButton, @Nullable LabeledButton cancelButton, @Nullable ActionableMessage onSubmit) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(display, "display");
                Intrinsics.checkNotNullParameter(submitButton, "submitButton");
                return new AddChannelPrompt(type, display, submitButton, closeButton, cancelButton, onSubmit);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AddChannelPrompt)) {
                    return false;
                }
                AddChannelPrompt addChannelPrompt = (AddChannelPrompt) other;
                return Intrinsics.areEqual(this.type, addChannelPrompt.type) && Intrinsics.areEqual(this.display, addChannelPrompt.display) && Intrinsics.areEqual(this.submitButton, addChannelPrompt.submitButton) && Intrinsics.areEqual(this.closeButton, addChannelPrompt.closeButton) && Intrinsics.areEqual(this.cancelButton, addChannelPrompt.cancelButton) && Intrinsics.areEqual(this.onSubmit, addChannelPrompt.onSubmit);
            }

            public int hashCode() {
                int iHashCode = ((((this.type.hashCode() * 31) + this.display.hashCode()) * 31) + this.submitButton.hashCode()) * 31;
                IconButton iconButton = this.closeButton;
                int iHashCode2 = (iHashCode + (iconButton == null ? 0 : iconButton.hashCode())) * 31;
                LabeledButton labeledButton = this.cancelButton;
                int iHashCode3 = (iHashCode2 + (labeledButton == null ? 0 : labeledButton.hashCode())) * 31;
                ActionableMessage actionableMessage = this.onSubmit;
                return iHashCode3 + (actionableMessage != null ? actionableMessage.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "AddChannelPrompt(type=" + this.type + ", display=" + this.display + ", submitButton=" + this.submitButton + ", closeButton=" + this.closeButton + ", cancelButton=" + this.cancelButton + ", onSubmit=" + this.onSubmit + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n1#3:721\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt$Companion\n*L\n289#1:691,15\n290#1:706,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @NotNull
                public final AddChannelPrompt fromJson(@NotNull JsonMap json) throws JsonException {
                    String strOptString;
                    JsonMap jsonMapOptMap;
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonValue jsonValue = json.get("type");
                    if (jsonValue == null) {
                        throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                    String str = strOptString;
                    PromptDisplay.Companion companion = PromptDisplay.INSTANCE;
                    JsonValue jsonValue3 = json.get("display");
                    if (jsonValue3 == null) {
                        throw new JsonException("Missing required field: 'display" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString = jsonValue3.optString();
                        if (objOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString2 = jsonValue3.optString();
                        if (objOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList = jsonValue3.optList();
                        if (jsonSerializableOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap = jsonValue3.optMap();
                        if (jsonMapOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'display" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        JsonSerializable jsonValue4 = jsonValue3.getJsonValue();
                        if (jsonValue4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonValue4;
                    }
                    PromptDisplay promptDisplayFromJson = companion.fromJson(jsonMapOptMap);
                    JsonMap jsonMapRequireMap = JsonExtensionsKt.requireMap(json, "submit_button");
                    LabeledButton.Companion companion2 = LabeledButton.INSTANCE;
                    LabeledButton labeledButtonFromJson = companion2.fromJson(jsonMapRequireMap);
                    JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(json, "close_button");
                    IconButton iconButtonFromJson = jsonMapOptionalMap != null ? IconButton.INSTANCE.fromJson(jsonMapOptionalMap) : null;
                    JsonMap jsonMapOptionalMap2 = JsonExtensionsKt.optionalMap(json, "cancel_button");
                    LabeledButton labeledButtonFromJson2 = jsonMapOptionalMap2 != null ? companion2.fromJson(jsonMapOptionalMap2) : null;
                    JsonMap jsonMapOptionalMap3 = JsonExtensionsKt.optionalMap(json, "on_submit");
                    return new AddChannelPrompt(str, promptDisplayFromJson, labeledButtonFromJson, iconButtonFromJson, labeledButtonFromJson2, jsonMapOptionalMap3 != null ? ActionableMessage.INSTANCE.fromJson(jsonMapOptionalMap3) : null);
                }

                private Companion() {
                }
            }

            public AddChannelPrompt(@NotNull String type, @NotNull PromptDisplay display, @NotNull LabeledButton submitButton, @Nullable IconButton iconButton, @Nullable LabeledButton labeledButton, @Nullable ActionableMessage actionableMessage) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(display, "display");
                Intrinsics.checkNotNullParameter(submitButton, "submitButton");
                this.type = type;
                this.display = display;
                this.submitButton = submitButton;
                this.closeButton = iconButton;
                this.cancelButton = labeledButton;
                this.onSubmit = actionableMessage;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            @NotNull
            public final PromptDisplay getDisplay() {
                return this.display;
            }

            @NotNull
            public final LabeledButton getSubmitButton() {
                return this.submitButton;
            }

            @Nullable
            public final IconButton getCloseButton() {
                return this.closeButton;
            }

            @Nullable
            public final LabeledButton getCancelButton() {
                return this.cancelButton;
            }

            @Nullable
            public final ActionableMessage getOnSubmit() {
                return this.onSubmit;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                Pair pair = TuplesKt.to("type", this.type);
                Pair pair2 = TuplesKt.to("display", this.display.toJson());
                Pair pair3 = TuplesKt.to("submit_button", this.submitButton.toJson());
                LabeledButton labeledButton = this.cancelButton;
                Pair pair4 = TuplesKt.to("cancel_button", labeledButton != null ? labeledButton.toJson() : null);
                IconButton iconButton = this.closeButton;
                Pair pair5 = TuplesKt.to("close_button", iconButton != null ? iconButton.toJson() : null);
                ActionableMessage actionableMessage = this.onSubmit;
                return JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("on_submit", actionableMessage != null ? actionableMessage.toJson() : null));
            }
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt;", "", "type", "", "display", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;", "submitButton", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "closeButton", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "cancelButton", "onSubmit", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "(Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;)V", "getCancelButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "getCloseButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;", "getOnSubmit", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "getSubmitButton", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RemoveChannelPrompt {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final LabeledButton cancelButton;
            private final IconButton closeButton;
            private final PromptDisplay display;
            private final ActionableMessage onSubmit;
            private final LabeledButton submitButton;
            private final String type;

            public static /* synthetic */ RemoveChannelPrompt copy$default(RemoveChannelPrompt removeChannelPrompt, String str, PromptDisplay promptDisplay, LabeledButton labeledButton, IconButton iconButton, LabeledButton labeledButton2, ActionableMessage actionableMessage, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = removeChannelPrompt.type;
                }
                if ((i & 2) != 0) {
                    promptDisplay = removeChannelPrompt.display;
                }
                PromptDisplay promptDisplay2 = promptDisplay;
                if ((i & 4) != 0) {
                    labeledButton = removeChannelPrompt.submitButton;
                }
                LabeledButton labeledButton3 = labeledButton;
                if ((i & 8) != 0) {
                    iconButton = removeChannelPrompt.closeButton;
                }
                IconButton iconButton2 = iconButton;
                if ((i & 16) != 0) {
                    labeledButton2 = removeChannelPrompt.cancelButton;
                }
                LabeledButton labeledButton4 = labeledButton2;
                if ((i & 32) != 0) {
                    actionableMessage = removeChannelPrompt.onSubmit;
                }
                return removeChannelPrompt.copy(str, promptDisplay2, labeledButton3, iconButton2, labeledButton4, actionableMessage);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getType() {
                return this.type;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final PromptDisplay getDisplay() {
                return this.display;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final LabeledButton getSubmitButton() {
                return this.submitButton;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final IconButton getCloseButton() {
                return this.closeButton;
            }

            @Nullable
            /* renamed from: component5, reason: from getter */
            public final LabeledButton getCancelButton() {
                return this.cancelButton;
            }

            @Nullable
            /* renamed from: component6, reason: from getter */
            public final ActionableMessage getOnSubmit() {
                return this.onSubmit;
            }

            @NotNull
            public final RemoveChannelPrompt copy(@NotNull String type, @NotNull PromptDisplay display, @NotNull LabeledButton submitButton, @Nullable IconButton closeButton, @Nullable LabeledButton cancelButton, @Nullable ActionableMessage onSubmit) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(display, "display");
                Intrinsics.checkNotNullParameter(submitButton, "submitButton");
                return new RemoveChannelPrompt(type, display, submitButton, closeButton, cancelButton, onSubmit);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemoveChannelPrompt)) {
                    return false;
                }
                RemoveChannelPrompt removeChannelPrompt = (RemoveChannelPrompt) other;
                return Intrinsics.areEqual(this.type, removeChannelPrompt.type) && Intrinsics.areEqual(this.display, removeChannelPrompt.display) && Intrinsics.areEqual(this.submitButton, removeChannelPrompt.submitButton) && Intrinsics.areEqual(this.closeButton, removeChannelPrompt.closeButton) && Intrinsics.areEqual(this.cancelButton, removeChannelPrompt.cancelButton) && Intrinsics.areEqual(this.onSubmit, removeChannelPrompt.onSubmit);
            }

            public int hashCode() {
                int iHashCode = ((((this.type.hashCode() * 31) + this.display.hashCode()) * 31) + this.submitButton.hashCode()) * 31;
                IconButton iconButton = this.closeButton;
                int iHashCode2 = (iHashCode + (iconButton == null ? 0 : iconButton.hashCode())) * 31;
                LabeledButton labeledButton = this.cancelButton;
                int iHashCode3 = (iHashCode2 + (labeledButton == null ? 0 : labeledButton.hashCode())) * 31;
                ActionableMessage actionableMessage = this.onSubmit;
                return iHashCode3 + (actionableMessage != null ? actionableMessage.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "RemoveChannelPrompt(type=" + this.type + ", display=" + this.display + ", submitButton=" + this.submitButton + ", closeButton=" + this.closeButton + ", cancelButton=" + this.cancelButton + ", onSubmit=" + this.onSubmit + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n1#3:721\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt$Companion\n*L\n322#1:691,15\n323#1:706,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @NotNull
                public final RemoveChannelPrompt fromJson(@NotNull JsonMap json) throws JsonException {
                    String strOptString;
                    JsonMap jsonMapOptMap;
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonValue jsonValue = json.get("type");
                    if (jsonValue == null) {
                        throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                    String str = strOptString;
                    PromptDisplay.Companion companion = PromptDisplay.INSTANCE;
                    JsonValue jsonValue3 = json.get("display");
                    if (jsonValue3 == null) {
                        throw new JsonException("Missing required field: 'display" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString = jsonValue3.optString();
                        if (objOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString2 = jsonValue3.optString();
                        if (objOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue3.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue3.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue3.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList = jsonValue3.optList();
                        if (jsonSerializableOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap = jsonValue3.optMap();
                        if (jsonMapOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'display" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        JsonSerializable jsonValue4 = jsonValue3.getJsonValue();
                        if (jsonValue4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonValue4;
                    }
                    PromptDisplay promptDisplayFromJson = companion.fromJson(jsonMapOptMap);
                    JsonMap jsonMapRequireMap = JsonExtensionsKt.requireMap(json, "submit_button");
                    LabeledButton.Companion companion2 = LabeledButton.INSTANCE;
                    LabeledButton labeledButtonFromJson = companion2.fromJson(jsonMapRequireMap);
                    JsonMap jsonMapOptionalMap = JsonExtensionsKt.optionalMap(json, "close_button");
                    IconButton iconButtonFromJson = jsonMapOptionalMap != null ? IconButton.INSTANCE.fromJson(jsonMapOptionalMap) : null;
                    JsonMap jsonMapOptionalMap2 = JsonExtensionsKt.optionalMap(json, "cancel_button");
                    LabeledButton labeledButtonFromJson2 = jsonMapOptionalMap2 != null ? companion2.fromJson(jsonMapOptionalMap2) : null;
                    JsonMap jsonMapOptionalMap3 = JsonExtensionsKt.optionalMap(json, "on_submit");
                    return new RemoveChannelPrompt(str, promptDisplayFromJson, labeledButtonFromJson, iconButtonFromJson, labeledButtonFromJson2, jsonMapOptionalMap3 != null ? ActionableMessage.INSTANCE.fromJson(jsonMapOptionalMap3) : null);
                }

                private Companion() {
                }
            }

            public RemoveChannelPrompt(@NotNull String type, @NotNull PromptDisplay display, @NotNull LabeledButton submitButton, @Nullable IconButton iconButton, @Nullable LabeledButton labeledButton, @Nullable ActionableMessage actionableMessage) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(display, "display");
                Intrinsics.checkNotNullParameter(submitButton, "submitButton");
                this.type = type;
                this.display = display;
                this.submitButton = submitButton;
                this.closeButton = iconButton;
                this.cancelButton = labeledButton;
                this.onSubmit = actionableMessage;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            @NotNull
            public final PromptDisplay getDisplay() {
                return this.display;
            }

            @NotNull
            public final LabeledButton getSubmitButton() {
                return this.submitButton;
            }

            @Nullable
            public final IconButton getCloseButton() {
                return this.closeButton;
            }

            @Nullable
            public final LabeledButton getCancelButton() {
                return this.cancelButton;
            }

            @Nullable
            public final ActionableMessage getOnSubmit() {
                return this.onSubmit;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                Pair pair = TuplesKt.to("type", this.type);
                Pair pair2 = TuplesKt.to("display", this.display.toJson());
                Pair pair3 = TuplesKt.to("submit_button", this.submitButton.toJson());
                LabeledButton labeledButton = this.cancelButton;
                Pair pair4 = TuplesKt.to("cancel_button", labeledButton != null ? labeledButton.toJson() : null);
                IconButton iconButton = this.closeButton;
                Pair pair5 = TuplesKt.to("close_button", iconButton != null ? iconButton.toJson() : null);
                ActionableMessage actionableMessage = this.onSubmit;
                return JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("on_submit", actionableMessage != null ? actionableMessage.toJson() : null));
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "", "interval", "", "message", "", "button", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "onSuccess", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "(ILjava/lang/String;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;)V", "getButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "getInterval", "()I", "getMessage", "()Ljava/lang/String;", "getOnSuccess", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ResendOptions {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final LabeledButton button;
            private final int interval;
            private final String message;
            private final ActionableMessage onSuccess;

            public static /* synthetic */ ResendOptions copy$default(ResendOptions resendOptions, int i, String str, LabeledButton labeledButton, ActionableMessage actionableMessage, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = resendOptions.interval;
                }
                if ((i2 & 2) != 0) {
                    str = resendOptions.message;
                }
                if ((i2 & 4) != 0) {
                    labeledButton = resendOptions.button;
                }
                if ((i2 & 8) != 0) {
                    actionableMessage = resendOptions.onSuccess;
                }
                return resendOptions.copy(i, str, labeledButton, actionableMessage);
            }

            /* renamed from: component1, reason: from getter */
            public final int getInterval() {
                return this.interval;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final LabeledButton getButton() {
                return this.button;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final ActionableMessage getOnSuccess() {
                return this.onSuccess;
            }

            @NotNull
            public final ResendOptions copy(int interval, @NotNull String message, @NotNull LabeledButton button, @Nullable ActionableMessage onSuccess) {
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(button, "button");
                return new ResendOptions(interval, message, button, onSuccess);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ResendOptions)) {
                    return false;
                }
                ResendOptions resendOptions = (ResendOptions) other;
                return this.interval == resendOptions.interval && Intrinsics.areEqual(this.message, resendOptions.message) && Intrinsics.areEqual(this.button, resendOptions.button) && Intrinsics.areEqual(this.onSuccess, resendOptions.onSuccess);
            }

            public int hashCode() {
                int iHashCode = ((((Integer.hashCode(this.interval) * 31) + this.message.hashCode()) * 31) + this.button.hashCode()) * 31;
                ActionableMessage actionableMessage = this.onSuccess;
                return iHashCode + (actionableMessage == null ? 0 : actionableMessage.hashCode());
            }

            @NotNull
            public String toString() {
                return "ResendOptions(interval=" + this.interval + ", message=" + this.message + ", button=" + this.button + ", onSuccess=" + this.onSuccess + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions$Companion;", "", "()V", "KEY_INTERVAL", "", "KEY_MESSAGE", "KEY_ON_SUCCESS", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n44#2,15:721\n1#3:736\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions$Companion\n*L\n475#1:691,15\n476#1:706,15\n477#1:721,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX WARN: Removed duplicated region for block: B:116:0x0297  */
                /* JADX WARN: Removed duplicated region for block: B:180:0x0409  */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.urbanairship.preferencecenter.data.Item.ContactManagement.ResendOptions fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r20) throws com.urbanairship.json.JsonException {
                    /*
                        Method dump skipped, instructions count: 1196
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.ContactManagement.ResendOptions.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item$ContactManagement$ResendOptions");
                }

                private Companion() {
                }
            }

            public ResendOptions(int i, @NotNull String message, @NotNull LabeledButton button, @Nullable ActionableMessage actionableMessage) {
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(button, "button");
                this.interval = i;
                this.message = message;
                this.button = button;
                this.onSuccess = actionableMessage;
            }

            public final int getInterval() {
                return this.interval;
            }

            @NotNull
            public final String getMessage() {
                return this.message;
            }

            @NotNull
            public final LabeledButton getButton() {
                return this.button;
            }

            @Nullable
            public final ActionableMessage getOnSuccess() {
                return this.onSuccess;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                Pair pair = TuplesKt.to("interval", Integer.valueOf(this.interval));
                Pair pair2 = TuplesKt.to("message", this.message);
                Pair pair3 = TuplesKt.to("button", this.button.toJson());
                ActionableMessage actionableMessage = this.onSuccess;
                return JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, TuplesKt.to("on_success", actionableMessage != null ? actionableMessage.toJson() : null));
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Companion;", "", "()V", "PLATFORM_EMAIL", "", "PLATFORM_SMS", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n44#2,15:721\n44#2,15:736\n44#2,15:751\n44#2,15:766\n44#2,15:781\n79#2,16:796\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$Companion\n*L\n187#1:691,15\n188#1:706,15\n190#1:721,15\n191#1:736,15\n195#1:751,15\n196#1:766,15\n197#1:781,15\n198#1:796,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final ContactManagement fromJson(@NotNull JsonMap json) throws JsonException {
                String strOptString;
                String strOptString2;
                String str;
                String str2;
                JsonMap jsonMapOptMap;
                Platform email;
                JsonMap jsonMapOptMap2;
                JsonMap jsonMapOptMap3;
                JsonMap jsonMapOptMap4;
                String strOptString3;
                String str3;
                JsonMap jsonMapOptMap5;
                Intrinsics.checkNotNullParameter(json, "json");
                JsonValue jsonValue = json.get("id");
                if (jsonValue == null) {
                    throw new JsonException("Missing required field: 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue2 = jsonValue.getJsonValue();
                    if (jsonValue2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue2;
                }
                String str4 = strOptString;
                JsonValue jsonValue3 = json.get(DeferredApiClient.KEY_PLATFORM);
                if (jsonValue3 == null) {
                    throw new JsonException("Missing required field: '" + DeferredApiClient.KEY_PLATFORM + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString2 = jsonValue3.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue3.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList2 = jsonValue3.optList();
                    if (objOptList2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptList2;
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap2 = jsonValue3.optMap();
                    if (objOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) objOptMap2;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + DeferredApiClient.KEY_PLATFORM + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue4 = jsonValue3.getJsonValue();
                    if (jsonValue4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString2 = (String) jsonValue4;
                }
                if (Intrinsics.areEqual(strOptString2, "sms")) {
                    RegistrationOptions.Sms.Companion companion = RegistrationOptions.Sms.INSTANCE;
                    JsonValue jsonValue5 = json.get("registration_options");
                    if (jsonValue5 == null) {
                        throw new JsonException("Missing required field: 'registration_options" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString = jsonValue5.optString();
                        if (objOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap5 = (JsonMap) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString2 = jsonValue5.optString();
                        if (objOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap5 = (JsonMap) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap5 = (JsonMap) Boolean.valueOf(jsonValue5.getBoolean(false));
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str3 = "Missing required field: '";
                            jsonMapOptMap5 = (JsonMap) Long.valueOf(jsonValue5.getLong(0L));
                        } else {
                            str3 = "Missing required field: '";
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                jsonMapOptMap5 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                jsonMapOptMap5 = (JsonMap) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                jsonMapOptMap5 = (JsonMap) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                jsonMapOptMap5 = (JsonMap) Integer.valueOf(jsonValue5.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                jsonMapOptMap5 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                JsonSerializable jsonSerializableOptList = jsonValue5.optList();
                                if (jsonSerializableOptList == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                                jsonMapOptMap5 = (JsonMap) jsonSerializableOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                jsonMapOptMap5 = jsonValue5.optMap();
                                if (jsonMapOptMap5 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'registration_options" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                JsonSerializable jsonValue6 = jsonValue5.getJsonValue();
                                if (jsonValue6 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                                jsonMapOptMap5 = (JsonMap) jsonValue6;
                            }
                        }
                        email = new Platform.Sms(companion.fromJson(jsonMapOptMap5));
                        str = str3;
                        str2 = "' for field '";
                    }
                    str3 = "Missing required field: '";
                    email = new Platform.Sms(companion.fromJson(jsonMapOptMap5));
                    str = str3;
                    str2 = "' for field '";
                } else {
                    str = "Missing required field: '";
                    if (!Intrinsics.areEqual(strOptString2, "email")) {
                        throw new JsonException("Invalid registration type: " + strOptString2);
                    }
                    RegistrationOptions.Email.Companion companion2 = RegistrationOptions.Email.INSTANCE;
                    JsonValue jsonValue7 = json.get("registration_options");
                    if (jsonValue7 == null) {
                        throw new JsonException(str + "registration_options" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString3 = jsonValue7.optString();
                        if (objOptString3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString4 = jsonValue7.optString();
                        if (objOptString4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue7.getBoolean(false));
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str2 = "' for field '";
                            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue7.getLong(0L));
                        } else {
                            str2 = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                JsonSerializable jsonSerializableOptList2 = jsonValue7.optList();
                                if (jsonSerializableOptList2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                                jsonMapOptMap = (JsonMap) jsonSerializableOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                jsonMapOptMap = jsonValue7.optMap();
                                if (jsonMapOptMap == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + "registration_options" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                JsonSerializable jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                                }
                                jsonMapOptMap = (JsonMap) jsonValue8;
                            }
                        }
                        email = new Platform.Email(companion2.fromJson(jsonMapOptMap));
                    }
                    str2 = "' for field '";
                    email = new Platform.Email(companion2.fromJson(jsonMapOptMap));
                }
                CommonDisplay.Companion companion3 = CommonDisplay.INSTANCE;
                JsonValue jsonValue9 = json.get("display");
                if (jsonValue9 == null) {
                    throw new JsonException(str + "display" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString5 = jsonValue9.optString();
                    if (objOptString5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap2 = (JsonMap) objOptString5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString6 = jsonValue9.optString();
                    if (objOptString6 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap2 = (JsonMap) objOptString6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Boolean.valueOf(jsonValue9.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Long.valueOf(jsonValue9.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap2 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue9.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap2 = (JsonMap) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonMapOptMap2 = (JsonMap) Integer.valueOf(jsonValue9.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap2 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue9.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList3 = jsonValue9.optList();
                    if (jsonSerializableOptList3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap2 = (JsonMap) jsonSerializableOptList3;
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap2 = jsonValue9.optMap();
                    if (jsonMapOptMap2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + "display" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue10 = jsonValue9.getJsonValue();
                    if (jsonValue10 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap2 = (JsonMap) jsonValue10;
                }
                CommonDisplay commonDisplay = companion3.parse$urbanairship_preference_center_release(jsonMapOptMap2);
                AddPrompt.Companion companion4 = AddPrompt.INSTANCE;
                JsonValue jsonValue11 = json.get("add");
                if (jsonValue11 == null) {
                    throw new JsonException(str + "add" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString7 = jsonValue11.optString();
                    if (objOptString7 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap3 = (JsonMap) objOptString7;
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString8 = jsonValue11.optString();
                    if (objOptString8 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap3 = (JsonMap) objOptString8;
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Boolean.valueOf(jsonValue11.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Long.valueOf(jsonValue11.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap3 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue11.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap3 = (JsonMap) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonMapOptMap3 = (JsonMap) Integer.valueOf(jsonValue11.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap3 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue11.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList4 = jsonValue11.optList();
                    if (jsonSerializableOptList4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap3 = (JsonMap) jsonSerializableOptList4;
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap3 = jsonValue11.optMap();
                    if (jsonMapOptMap3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + "add" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue12 = jsonValue11.getJsonValue();
                    if (jsonValue12 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap3 = (JsonMap) jsonValue12;
                }
                AddPrompt addPromptFromJson = companion4.fromJson(jsonMapOptMap3);
                RemovePrompt.Companion companion5 = RemovePrompt.INSTANCE;
                JsonValue jsonValue13 = json.get(AttributeMutation.ATTRIBUTE_ACTION_REMOVE);
                if (jsonValue13 == null) {
                    throw new JsonException(str + AttributeMutation.ATTRIBUTE_ACTION_REMOVE + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                    Object objOptString9 = jsonValue13.optString();
                    if (objOptString9 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap4 = (JsonMap) objOptString9;
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    Object objOptString10 = jsonValue13.optString();
                    if (objOptString10 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap4 = (JsonMap) objOptString10;
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    jsonMapOptMap4 = (JsonMap) Boolean.valueOf(jsonValue13.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    jsonMapOptMap4 = (JsonMap) Long.valueOf(jsonValue13.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    jsonMapOptMap4 = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue13.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    jsonMapOptMap4 = (JsonMap) Double.valueOf(jsonValue13.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    jsonMapOptMap4 = (JsonMap) Float.valueOf(jsonValue13.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    jsonMapOptMap4 = (JsonMap) Integer.valueOf(jsonValue13.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    jsonMapOptMap4 = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue13.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    JsonSerializable jsonSerializableOptList5 = jsonValue13.optList();
                    if (jsonSerializableOptList5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap4 = (JsonMap) jsonSerializableOptList5;
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    jsonMapOptMap4 = jsonValue13.optMap();
                    if (jsonMapOptMap4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str2 + AttributeMutation.ATTRIBUTE_ACTION_REMOVE + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    JsonSerializable jsonValue14 = jsonValue13.getJsonValue();
                    if (jsonValue14 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                    }
                    jsonMapOptMap4 = (JsonMap) jsonValue14;
                }
                RemovePrompt removePromptFromJson = companion5.fromJson(jsonMapOptMap4);
                JsonValue jsonValue15 = json.get("empty_message");
                if (jsonValue15 == null) {
                    strOptString3 = null;
                } else {
                    KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString3 = jsonValue15.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString3 = (String) Boolean.valueOf(jsonValue15.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString3 = (String) Long.valueOf(jsonValue15.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue15.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString3 = (String) Double.valueOf(jsonValue15.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString3 = (String) Float.valueOf(jsonValue15.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString3 = (String) Integer.valueOf(jsonValue15.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue15.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        strOptString3 = (String) jsonValue15.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        strOptString3 = (String) jsonValue15.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str2 + "empty_message" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        strOptString3 = (String) jsonValue15.getJsonValue();
                    }
                }
                return new ContactManagement(str4, email, commonDisplay, addPromptFromJson, removePromptFromJson, strOptString3, Condition.INSTANCE.parse$urbanairship_preference_center_release(json.opt("conditions")));
            }

            private Companion() {
            }
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public String getId() {
            return this.id;
        }

        @NotNull
        public final Platform getPlatform() {
            return this.platform;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public CommonDisplay getDisplay() {
            return this.display;
        }

        @NotNull
        public final AddPrompt getAddPrompt() {
            return this.addPrompt;
        }

        @NotNull
        public final RemovePrompt getRemovePrompt() {
            return this.removePrompt;
        }

        @Nullable
        public final String getEmptyLabel() {
            return this.emptyLabel;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public List<Condition> getConditions() {
            return this.conditions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactManagement(@NotNull String id, @NotNull Platform platform, @NotNull CommonDisplay display, @NotNull AddPrompt addPrompt, @NotNull RemovePrompt removePrompt, @Nullable String str, @NotNull List<? extends Condition> conditions) {
            super("contact_management", false, false, true, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(platform, "platform");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(addPrompt, "addPrompt");
            Intrinsics.checkNotNullParameter(removePrompt, "removePrompt");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.id = id;
            this.platform = platform;
            this.display = display;
            this.addPrompt = addPrompt;
            this.removePrompt = removePrompt;
            this.emptyLabel = str;
            this.conditions = conditions;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
            JsonMap.Builder builderJsonMapBuilder = jsonMapBuilder();
            Platform platform = this.platform;
            if (platform instanceof Platform.Sms) {
                builderJsonMapBuilder.put(DeferredApiClient.KEY_PLATFORM, "sms").put("registration_options", ((Platform.Sms) this.platform).getRegistrationOptions().toJson());
            } else if (platform instanceof Platform.Email) {
                builderJsonMapBuilder.put(DeferredApiClient.KEY_PLATFORM, "email").put("registration_options", ((Platform.Email) this.platform).getRegistrationOptions().toJson());
            }
            JsonMap jsonMapBuild = builderJsonMapBuilder.put("add", this.addPrompt.toJson()).put(AttributeMutation.ATTRIBUTE_ACTION_REMOVE, this.removePrompt.toJson()).put("empty_message", this.emptyLabel).build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "", "channelType", "Lcom/urbanairship/contacts/ChannelType;", "(Lcom/urbanairship/contacts/ChannelType;)V", "getChannelType", "()Lcom/urbanairship/contacts/ChannelType;", "errorMessages", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "getErrorMessages$urbanairship_preference_center_release", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "resendOptions", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "getResendOptions$urbanairship_preference_center_release", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ResendOptions;", "Email", "Sms", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform$Email;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform$Sms;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class Platform {
            private final ChannelType channelType;

            public /* synthetic */ Platform(ChannelType channelType, DefaultConstructorMarker defaultConstructorMarker) {
                this(channelType);
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform$Sms;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "registrationOptions", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms;)V", "getRegistrationOptions", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Sms;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Sms extends Platform {
                private final RegistrationOptions.Sms registrationOptions;

                public static /* synthetic */ Sms copy$default(Sms sms, RegistrationOptions.Sms sms2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        sms2 = sms.registrationOptions;
                    }
                    return sms.copy(sms2);
                }

                @NotNull
                /* renamed from: component1, reason: from getter */
                public final RegistrationOptions.Sms getRegistrationOptions() {
                    return this.registrationOptions;
                }

                @NotNull
                public final Sms copy(@NotNull RegistrationOptions.Sms registrationOptions) {
                    Intrinsics.checkNotNullParameter(registrationOptions, "registrationOptions");
                    return new Sms(registrationOptions);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Sms) && Intrinsics.areEqual(this.registrationOptions, ((Sms) other).registrationOptions);
                }

                public int hashCode() {
                    return this.registrationOptions.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Sms(registrationOptions=" + this.registrationOptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Sms(@NotNull RegistrationOptions.Sms registrationOptions) {
                    super(ChannelType.SMS, null);
                    Intrinsics.checkNotNullParameter(registrationOptions, "registrationOptions");
                    this.registrationOptions = registrationOptions;
                }

                @NotNull
                public final RegistrationOptions.Sms getRegistrationOptions() {
                    return this.registrationOptions;
                }
            }

            private Platform(ChannelType channelType) {
                this.channelType = channelType;
            }

            @NotNull
            public final ChannelType getChannelType() {
                return this.channelType;
            }

            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform$Email;", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$Platform;", "registrationOptions", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email;)V", "getRegistrationOptions", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RegistrationOptions$Email;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final /* data */ class Email extends Platform {
                private final RegistrationOptions.Email registrationOptions;

                public static /* synthetic */ Email copy$default(Email email, RegistrationOptions.Email email2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        email2 = email.registrationOptions;
                    }
                    return email.copy(email2);
                }

                @NotNull
                /* renamed from: component1, reason: from getter */
                public final RegistrationOptions.Email getRegistrationOptions() {
                    return this.registrationOptions;
                }

                @NotNull
                public final Email copy(@NotNull RegistrationOptions.Email registrationOptions) {
                    Intrinsics.checkNotNullParameter(registrationOptions, "registrationOptions");
                    return new Email(registrationOptions);
                }

                public boolean equals(@Nullable Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof Email) && Intrinsics.areEqual(this.registrationOptions, ((Email) other).registrationOptions);
                }

                public int hashCode() {
                    return this.registrationOptions.hashCode();
                }

                @NotNull
                public String toString() {
                    return "Email(registrationOptions=" + this.registrationOptions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Email(@NotNull RegistrationOptions.Email registrationOptions) {
                    super(ChannelType.EMAIL, null);
                    Intrinsics.checkNotNullParameter(registrationOptions, "registrationOptions");
                    this.registrationOptions = registrationOptions;
                }

                @NotNull
                public final RegistrationOptions.Email getRegistrationOptions() {
                    return this.registrationOptions;
                }
            }

            @NotNull
            public final ResendOptions getResendOptions$urbanairship_preference_center_release() {
                if (this instanceof Sms) {
                    return ((Sms) this).getRegistrationOptions().getResendOptions();
                }
                if (this instanceof Email) {
                    return ((Email) this).getRegistrationOptions().getResendOptions();
                }
                throw new NoWhenBranchMatchedException();
            }

            @NotNull
            public final ErrorMessages getErrorMessages$urbanairship_preference_center_release() {
                if (this instanceof Sms) {
                    return ((Sms) this).getRegistrationOptions().getErrorMessages();
                }
                if (this instanceof Email) {
                    return ((Email) this).getRegistrationOptions().getErrorMessages();
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt;", "", "prompt", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt;", "button", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;)V", "getButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "getPrompt", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddChannelPrompt;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class AddPrompt {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final LabeledButton button;
            private final AddChannelPrompt prompt;

            public static /* synthetic */ AddPrompt copy$default(AddPrompt addPrompt, AddChannelPrompt addChannelPrompt, LabeledButton labeledButton, int i, Object obj) {
                if ((i & 1) != 0) {
                    addChannelPrompt = addPrompt.prompt;
                }
                if ((i & 2) != 0) {
                    labeledButton = addPrompt.button;
                }
                return addPrompt.copy(addChannelPrompt, labeledButton);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final AddChannelPrompt getPrompt() {
                return this.prompt;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final LabeledButton getButton() {
                return this.button;
            }

            @NotNull
            public final AddPrompt copy(@NotNull AddChannelPrompt prompt, @NotNull LabeledButton button) {
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                Intrinsics.checkNotNullParameter(button, "button");
                return new AddPrompt(prompt, button);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AddPrompt)) {
                    return false;
                }
                AddPrompt addPrompt = (AddPrompt) other;
                return Intrinsics.areEqual(this.prompt, addPrompt.prompt) && Intrinsics.areEqual(this.button, addPrompt.button);
            }

            public int hashCode() {
                return (this.prompt.hashCode() * 31) + this.button.hashCode();
            }

            @NotNull
            public String toString() {
                return "AddPrompt(prompt=" + this.prompt + ", button=" + this.button + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public AddPrompt(@NotNull AddChannelPrompt prompt, @NotNull LabeledButton button) {
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                Intrinsics.checkNotNullParameter(button, "button");
                this.prompt = prompt;
                this.button = button;
            }

            @NotNull
            public final AddChannelPrompt getPrompt() {
                return this.prompt;
            }

            @NotNull
            public final LabeledButton getButton() {
                return this.button;
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$AddPrompt$Companion\n*L\n233#1:691,15\n234#1:706,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Removed duplicated region for block: B:121:0x02c6  */
                /* JADX WARN: Removed duplicated region for block: B:61:0x0168  */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.urbanairship.preferencecenter.data.Item.ContactManagement.AddPrompt fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r21) throws com.urbanairship.json.JsonException {
                    /*
                        Method dump skipped, instructions count: 804
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.ContactManagement.AddPrompt.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item$ContactManagement$AddPrompt");
                }
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("view", this.prompt.toJson()), TuplesKt.to("button", this.button.toJson()));
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt;", "", "prompt", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt;", "button", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "(Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;)V", "getButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "getPrompt", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemoveChannelPrompt;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RemovePrompt {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final IconButton button;
            private final RemoveChannelPrompt prompt;

            public static /* synthetic */ RemovePrompt copy$default(RemovePrompt removePrompt, RemoveChannelPrompt removeChannelPrompt, IconButton iconButton, int i, Object obj) {
                if ((i & 1) != 0) {
                    removeChannelPrompt = removePrompt.prompt;
                }
                if ((i & 2) != 0) {
                    iconButton = removePrompt.button;
                }
                return removePrompt.copy(removeChannelPrompt, iconButton);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final RemoveChannelPrompt getPrompt() {
                return this.prompt;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final IconButton getButton() {
                return this.button;
            }

            @NotNull
            public final RemovePrompt copy(@NotNull RemoveChannelPrompt prompt, @NotNull IconButton button) {
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                Intrinsics.checkNotNullParameter(button, "button");
                return new RemovePrompt(prompt, button);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RemovePrompt)) {
                    return false;
                }
                RemovePrompt removePrompt = (RemovePrompt) other;
                return Intrinsics.areEqual(this.prompt, removePrompt.prompt) && Intrinsics.areEqual(this.button, removePrompt.button);
            }

            public int hashCode() {
                return (this.prompt.hashCode() * 31) + this.button.hashCode();
            }

            @NotNull
            public String toString() {
                return "RemovePrompt(prompt=" + this.prompt + ", button=" + this.button + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public RemovePrompt(@NotNull RemoveChannelPrompt prompt, @NotNull IconButton button) {
                Intrinsics.checkNotNullParameter(prompt, "prompt");
                Intrinsics.checkNotNullParameter(button, "button");
                this.prompt = prompt;
                this.button = button;
            }

            @NotNull
            public final RemoveChannelPrompt getPrompt() {
                return this.prompt;
            }

            @NotNull
            public final IconButton getButton() {
                return this.button;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("view", this.prompt.toJson()), TuplesKt.to("button", this.button.toJson()));
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$RemovePrompt$Companion\n*L\n260#1:691,15\n261#1:706,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Removed duplicated region for block: B:121:0x02c6  */
                /* JADX WARN: Removed duplicated region for block: B:61:0x0168  */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.urbanairship.preferencecenter.data.Item.ContactManagement.RemovePrompt fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r21) throws com.urbanairship.json.JsonException {
                    /*
                        Method dump skipped, instructions count: 804
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.ContactManagement.RemovePrompt.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item$ContactManagement$RemovePrompt");
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;", "", "title", "", "description", "footer", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getFooter", "getTitle", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class PromptDisplay {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final String description;
            private final String footer;
            private final String title;

            public static /* synthetic */ PromptDisplay copy$default(PromptDisplay promptDisplay, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = promptDisplay.title;
                }
                if ((i & 2) != 0) {
                    str2 = promptDisplay.description;
                }
                if ((i & 4) != 0) {
                    str3 = promptDisplay.footer;
                }
                return promptDisplay.copy(str, str2, str3);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final String getDescription() {
                return this.description;
            }

            @Nullable
            /* renamed from: component3, reason: from getter */
            public final String getFooter() {
                return this.footer;
            }

            @NotNull
            public final PromptDisplay copy(@NotNull String title, @Nullable String description, @Nullable String footer) {
                Intrinsics.checkNotNullParameter(title, "title");
                return new PromptDisplay(title, description, footer);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PromptDisplay)) {
                    return false;
                }
                PromptDisplay promptDisplay = (PromptDisplay) other;
                return Intrinsics.areEqual(this.title, promptDisplay.title) && Intrinsics.areEqual(this.description, promptDisplay.description) && Intrinsics.areEqual(this.footer, promptDisplay.footer);
            }

            public int hashCode() {
                int iHashCode = this.title.hashCode() * 31;
                String str = this.description;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.footer;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "PromptDisplay(title=" + this.title + ", description=" + this.description + ", footer=" + this.footer + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public PromptDisplay(@NotNull String title, @Nullable String str, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
                this.description = str;
                this.footer = str2;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            public final String getDescription() {
                return this.description;
            }

            @Nullable
            public final String getFooter() {
                return this.footer;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("title", this.title), TuplesKt.to("description", this.description), TuplesKt.to("footer", this.footer));
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay$Companion;", "", "()V", "KEY_FOOTER", "", "KEY_TITLE", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n79#2,16:706\n79#2,16:722\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$PromptDisplay$Companion\n*L\n352#1:691,15\n353#1:706,16\n354#1:722,16\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final PromptDisplay fromJson(@NotNull JsonMap json) throws JsonException {
                    String strOptString;
                    String str;
                    String strOptString2;
                    String strOptString3;
                    String str2;
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonValue jsonValue = json.get("title");
                    if (jsonValue == null) {
                        throw new JsonException("Missing required field: 'title" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'title" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                    JsonValue jsonValue3 = json.get("description");
                    if (jsonValue3 == null) {
                        str = "' for field '";
                        strOptString2 = null;
                    } else {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString2 = jsonValue3.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str = "' for field '";
                            strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
                        } else {
                            str = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                strOptString2 = (String) jsonValue3.optList();
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                strOptString2 = (String) jsonValue3.optMap();
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "description" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                strOptString2 = (String) jsonValue3.getJsonValue();
                            }
                        }
                        str = "' for field '";
                    }
                    JsonValue jsonValue4 = json.get("footer");
                    if (jsonValue4 == null) {
                        str2 = null;
                    } else {
                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString3 = jsonValue4.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString3 = (String) Boolean.valueOf(jsonValue4.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString3 = (String) Long.valueOf(jsonValue4.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString3 = (String) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString3 = (String) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString3 = (String) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString3 = (String) jsonValue4.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString3 = (String) jsonValue4.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "footer" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString3 = (String) jsonValue4.getJsonValue();
                        }
                        str2 = strOptString3;
                    }
                    return new PromptDisplay(strOptString, strOptString2, str2);
                }
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "", "title", "", "description", "button", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "contentDescription", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;Ljava/lang/String;)V", "getButton", "()Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "getContentDescription", "()Ljava/lang/String;", "getDescription", "getTitle", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ActionableMessage {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final LabeledButton button;
            private final String contentDescription;
            private final String description;
            private final String title;

            public static /* synthetic */ ActionableMessage copy$default(ActionableMessage actionableMessage, String str, String str2, LabeledButton labeledButton, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = actionableMessage.title;
                }
                if ((i & 2) != 0) {
                    str2 = actionableMessage.description;
                }
                if ((i & 4) != 0) {
                    labeledButton = actionableMessage.button;
                }
                if ((i & 8) != 0) {
                    str3 = actionableMessage.contentDescription;
                }
                return actionableMessage.copy(str, str2, labeledButton, str3);
            }

            @NotNull
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
            /* renamed from: component3, reason: from getter */
            public final LabeledButton getButton() {
                return this.button;
            }

            @Nullable
            /* renamed from: component4, reason: from getter */
            public final String getContentDescription() {
                return this.contentDescription;
            }

            @NotNull
            public final ActionableMessage copy(@NotNull String title, @Nullable String description, @NotNull LabeledButton button, @Nullable String contentDescription) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(button, "button");
                return new ActionableMessage(title, description, button, contentDescription);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ActionableMessage)) {
                    return false;
                }
                ActionableMessage actionableMessage = (ActionableMessage) other;
                return Intrinsics.areEqual(this.title, actionableMessage.title) && Intrinsics.areEqual(this.description, actionableMessage.description) && Intrinsics.areEqual(this.button, actionableMessage.button) && Intrinsics.areEqual(this.contentDescription, actionableMessage.contentDescription);
            }

            public int hashCode() {
                int iHashCode = this.title.hashCode() * 31;
                String str = this.description;
                int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.button.hashCode()) * 31;
                String str2 = this.contentDescription;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            @NotNull
            public String toString() {
                return "ActionableMessage(title=" + this.title + ", description=" + this.description + ", button=" + this.button + ", contentDescription=" + this.contentDescription + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public ActionableMessage(@NotNull String title, @Nullable String str, @NotNull LabeledButton button, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(button, "button");
                this.title = title;
                this.description = str;
                this.button = button;
                this.contentDescription = str2;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Nullable
            public final String getDescription() {
                return this.description;
            }

            @NotNull
            public final LabeledButton getButton() {
                return this.button;
            }

            @Nullable
            public final String getContentDescription() {
                return this.contentDescription;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("name", this.title), TuplesKt.to("description", this.description), TuplesKt.to("button", this.button.toJson()), TuplesKt.to("content_description", this.contentDescription));
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n79#2,16:706\n44#2,15:722\n79#2,16:737\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$ActionableMessage$Companion\n*L\n378#1:691,15\n379#1:706,16\n380#1:722,15\n381#1:737,16\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final ActionableMessage fromJson(@NotNull JsonMap json) throws JsonException {
                    String strOptString;
                    String str;
                    String strOptString2;
                    JsonMap jsonMapOptMap;
                    String strOptString3;
                    String str2;
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonValue jsonValue = json.get("name");
                    if (jsonValue == null) {
                        throw new JsonException("Missing required field: 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                    JsonValue jsonValue3 = json.get("description");
                    if (jsonValue3 == null) {
                        str = "' for field '";
                        strOptString2 = null;
                    } else {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString2 = jsonValue3.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str = "' for field '";
                            strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
                        } else {
                            str = "' for field '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                strOptString2 = (String) jsonValue3.optList();
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                strOptString2 = (String) jsonValue3.optMap();
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "description" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                strOptString2 = (String) jsonValue3.getJsonValue();
                            }
                        }
                        str = "' for field '";
                    }
                    LabeledButton.Companion companion = LabeledButton.INSTANCE;
                    JsonValue jsonValue4 = json.get("button");
                    if (jsonValue4 == null) {
                        throw new JsonException("Missing required field: 'button" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        Object objOptString = jsonValue4.optString();
                        if (objOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        Object objOptString2 = jsonValue4.optString();
                        if (objOptString2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        JsonSerializable jsonSerializableOptList = jsonValue4.optList();
                        if (jsonSerializableOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonSerializableOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        jsonMapOptMap = jsonValue4.optMap();
                        if (jsonMapOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + str + "button" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        JsonSerializable jsonValue5 = jsonValue4.getJsonValue();
                        if (jsonValue5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonMap");
                        }
                        jsonMapOptMap = (JsonMap) jsonValue5;
                    }
                    LabeledButton labeledButtonFromJson = companion.fromJson(jsonMapOptMap);
                    JsonValue jsonValue6 = json.get("content_description");
                    if (jsonValue6 == null) {
                        str2 = null;
                    } else {
                        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString3 = jsonValue6.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString3 = (String) Boolean.valueOf(jsonValue6.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString3 = (String) Long.valueOf(jsonValue6.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString3 = (String) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString3 = (String) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString3 = (String) Integer.valueOf(jsonValue6.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString3 = (String) jsonValue6.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString3 = (String) jsonValue6.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "content_description" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString3 = (String) jsonValue6.getJsonValue();
                        }
                        str2 = strOptString3;
                    }
                    return new ActionableMessage(strOptString, strOptString2, labeledButtonFromJson, str2);
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "", "contentDescription", "", "(Ljava/lang/String;)V", "getContentDescription", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class IconButton {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final String contentDescription;

            public static /* synthetic */ IconButton copy$default(IconButton iconButton, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = iconButton.contentDescription;
                }
                return iconButton.copy(str);
            }

            @Nullable
            /* renamed from: component1, reason: from getter */
            public final String getContentDescription() {
                return this.contentDescription;
            }

            @NotNull
            public final IconButton copy(@Nullable String contentDescription) {
                return new IconButton(contentDescription);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof IconButton) && Intrinsics.areEqual(this.contentDescription, ((IconButton) other).contentDescription);
            }

            public int hashCode() {
                String str = this.contentDescription;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            @NotNull
            public String toString() {
                return "IconButton(contentDescription=" + this.contentDescription + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public IconButton(@Nullable String str) {
                this.contentDescription = str;
            }

            @Nullable
            public final String getContentDescription() {
                return this.contentDescription;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("content_description", this.contentDescription));
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n79#2,16:691\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$IconButton$Companion\n*L\n399#1:691,16\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final IconButton fromJson(@NotNull JsonMap json) throws JsonException {
                    String strOptString;
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonValue jsonValue = json.get("content_description");
                    if (jsonValue == null) {
                        strOptString = null;
                    } else {
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString = jsonValue.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString = (String) jsonValue.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString = (String) jsonValue.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'content_description" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString = (String) jsonValue.getJsonValue();
                        }
                    }
                    return new IconButton(strOptString);
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "", "text", "", "contentDescription", "(Ljava/lang/String;Ljava/lang/String;)V", "getContentDescription", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class LabeledButton {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final String contentDescription;
            private final String text;

            public static /* synthetic */ LabeledButton copy$default(LabeledButton labeledButton, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = labeledButton.text;
                }
                if ((i & 2) != 0) {
                    str2 = labeledButton.contentDescription;
                }
                return labeledButton.copy(str, str2);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            @Nullable
            /* renamed from: component2, reason: from getter */
            public final String getContentDescription() {
                return this.contentDescription;
            }

            @NotNull
            public final LabeledButton copy(@NotNull String text, @Nullable String contentDescription) {
                Intrinsics.checkNotNullParameter(text, "text");
                return new LabeledButton(text, contentDescription);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LabeledButton)) {
                    return false;
                }
                LabeledButton labeledButton = (LabeledButton) other;
                return Intrinsics.areEqual(this.text, labeledButton.text) && Intrinsics.areEqual(this.contentDescription, labeledButton.contentDescription);
            }

            public int hashCode() {
                int iHashCode = this.text.hashCode() * 31;
                String str = this.contentDescription;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            @NotNull
            public String toString() {
                return "LabeledButton(text=" + this.text + ", contentDescription=" + this.contentDescription + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public LabeledButton(@NotNull String text, @Nullable String str) {
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
                this.contentDescription = str;
            }

            @NotNull
            public final String getText() {
                return this.text;
            }

            @Nullable
            public final String getContentDescription() {
                return this.contentDescription;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("text", this.text), TuplesKt.to("content_description", this.contentDescription));
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n79#2,16:706\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$LabeledButton$Companion\n*L\n419#1:691,15\n420#1:706,16\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final LabeledButton fromJson(@NotNull JsonMap json) throws JsonException {
                    String strOptString;
                    String strOptString2;
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonValue jsonValue = json.get("text");
                    if (jsonValue == null) {
                        throw new JsonException("Missing required field: 'text" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString = jsonValue.optString();
                        if (strOptString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList = jsonValue.optList();
                        if (objOptList == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptList;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap = jsonValue.optMap();
                        if (objOptMap == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) objOptMap;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'text" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.getJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                    JsonValue jsonValue3 = json.get("content_description");
                    if (jsonValue3 == null) {
                        strOptString2 = null;
                    } else {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString2 = jsonValue3.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString2 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString2 = (String) Long.valueOf(jsonValue3.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString2 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString2 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            strOptString2 = (String) Integer.valueOf(jsonValue3.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            strOptString2 = (String) jsonValue3.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            strOptString2 = (String) jsonValue3.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'content_description" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            strOptString2 = (String) jsonValue3.getJsonValue();
                        }
                    }
                    return new LabeledButton(strOptString, strOptString2);
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "", "invalidMessage", "", "defaultMessage", "(Ljava/lang/String;Ljava/lang/String;)V", "getDefaultMessage", "()Ljava/lang/String;", "getInvalidMessage", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ErrorMessages {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final String defaultMessage;
            private final String invalidMessage;

            public static /* synthetic */ ErrorMessages copy$default(ErrorMessages errorMessages, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorMessages.invalidMessage;
                }
                if ((i & 2) != 0) {
                    str2 = errorMessages.defaultMessage;
                }
                return errorMessages.copy(str, str2);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getInvalidMessage() {
                return this.invalidMessage;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getDefaultMessage() {
                return this.defaultMessage;
            }

            @NotNull
            public final ErrorMessages copy(@NotNull String invalidMessage, @NotNull String defaultMessage) {
                Intrinsics.checkNotNullParameter(invalidMessage, "invalidMessage");
                Intrinsics.checkNotNullParameter(defaultMessage, "defaultMessage");
                return new ErrorMessages(invalidMessage, defaultMessage);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorMessages)) {
                    return false;
                }
                ErrorMessages errorMessages = (ErrorMessages) other;
                return Intrinsics.areEqual(this.invalidMessage, errorMessages.invalidMessage) && Intrinsics.areEqual(this.defaultMessage, errorMessages.defaultMessage);
            }

            public int hashCode() {
                return (this.invalidMessage.hashCode() * 31) + this.defaultMessage.hashCode();
            }

            @NotNull
            public String toString() {
                return "ErrorMessages(invalidMessage=" + this.invalidMessage + ", defaultMessage=" + this.defaultMessage + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public ErrorMessages(@NotNull String invalidMessage, @NotNull String defaultMessage) {
                Intrinsics.checkNotNullParameter(invalidMessage, "invalidMessage");
                Intrinsics.checkNotNullParameter(defaultMessage, "defaultMessage");
                this.invalidMessage = invalidMessage;
                this.defaultMessage = defaultMessage;
            }

            @NotNull
            public final String getInvalidMessage() {
                return this.invalidMessage;
            }

            @NotNull
            public final String getDefaultMessage() {
                return this.defaultMessage;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to(Constants.COLLATION_INVALID, this.invalidMessage), TuplesKt.to("default", this.defaultMessage));
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages$Companion;", "", "()V", "KEY_DEFAULT", "", "KEY_INVALID", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$ErrorMessages$Companion\n*L\n445#1:691,15\n446#1:706,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Removed duplicated region for block: B:120:0x02b6  */
                /* JADX WARN: Removed duplicated region for block: B:60:0x015e  */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.urbanairship.preferencecenter.data.Item.ContactManagement.ErrorMessages fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r20) throws com.urbanairship.json.JsonException {
                    /*
                        Method dump skipped, instructions count: 788
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.ContactManagement.ErrorMessages.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item$ContactManagement$ErrorMessages");
                }
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$SmsSenderInfo;", "", "senderId", "", "placeholderText", "dialingCode", "displayName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDialingCode", "()Ljava/lang/String;", "getDisplayName", "getPlaceholderText", "getSenderId", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toString", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SmsSenderInfo {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final String dialingCode;
            private final String displayName;
            private final String placeholderText;
            private final String senderId;

            public static /* synthetic */ SmsSenderInfo copy$default(SmsSenderInfo smsSenderInfo, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = smsSenderInfo.senderId;
                }
                if ((i & 2) != 0) {
                    str2 = smsSenderInfo.placeholderText;
                }
                if ((i & 4) != 0) {
                    str3 = smsSenderInfo.dialingCode;
                }
                if ((i & 8) != 0) {
                    str4 = smsSenderInfo.displayName;
                }
                return smsSenderInfo.copy(str, str2, str3, str4);
            }

            @NotNull
            /* renamed from: component1, reason: from getter */
            public final String getSenderId() {
                return this.senderId;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final String getPlaceholderText() {
                return this.placeholderText;
            }

            @NotNull
            /* renamed from: component3, reason: from getter */
            public final String getDialingCode() {
                return this.dialingCode;
            }

            @NotNull
            /* renamed from: component4, reason: from getter */
            public final String getDisplayName() {
                return this.displayName;
            }

            @NotNull
            public final SmsSenderInfo copy(@NotNull String senderId, @NotNull String placeholderText, @NotNull String dialingCode, @NotNull String displayName) {
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                Intrinsics.checkNotNullParameter(placeholderText, "placeholderText");
                Intrinsics.checkNotNullParameter(dialingCode, "dialingCode");
                Intrinsics.checkNotNullParameter(displayName, "displayName");
                return new SmsSenderInfo(senderId, placeholderText, dialingCode, displayName);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SmsSenderInfo)) {
                    return false;
                }
                SmsSenderInfo smsSenderInfo = (SmsSenderInfo) other;
                return Intrinsics.areEqual(this.senderId, smsSenderInfo.senderId) && Intrinsics.areEqual(this.placeholderText, smsSenderInfo.placeholderText) && Intrinsics.areEqual(this.dialingCode, smsSenderInfo.dialingCode) && Intrinsics.areEqual(this.displayName, smsSenderInfo.displayName);
            }

            public int hashCode() {
                return (((((this.senderId.hashCode() * 31) + this.placeholderText.hashCode()) * 31) + this.dialingCode.hashCode()) * 31) + this.displayName.hashCode();
            }

            @NotNull
            public String toString() {
                return "SmsSenderInfo(senderId=" + this.senderId + ", placeholderText=" + this.placeholderText + ", dialingCode=" + this.dialingCode + ", displayName=" + this.displayName + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public SmsSenderInfo(@NotNull String senderId, @NotNull String placeholderText, @NotNull String dialingCode, @NotNull String displayName) {
                Intrinsics.checkNotNullParameter(senderId, "senderId");
                Intrinsics.checkNotNullParameter(placeholderText, "placeholderText");
                Intrinsics.checkNotNullParameter(dialingCode, "dialingCode");
                Intrinsics.checkNotNullParameter(displayName, "displayName");
                this.senderId = senderId;
                this.placeholderText = placeholderText;
                this.dialingCode = dialingCode;
                this.displayName = displayName;
            }

            @NotNull
            public final String getSenderId() {
                return this.senderId;
            }

            @NotNull
            public final String getPlaceholderText() {
                return this.placeholderText;
            }

            @NotNull
            public final String getDialingCode() {
                return this.dialingCode;
            }

            @NotNull
            public final String getDisplayName() {
                return this.displayName;
            }

            @NotNull
            public final JsonMap toJson() throws JsonException {
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("sender_id", this.senderId), TuplesKt.to("placeholder_text", this.placeholderText), TuplesKt.to("country_calling_code", this.dialingCode), TuplesKt.to("display_name", this.displayName));
            }

            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$SmsSenderInfo$Companion;", "", "()V", "KEY_COUNTRY_CODE", "", "KEY_DISPLAY_NAME", "KEY_SENDER_ID", "fromJson", "Lcom/urbanairship/preferencecenter/data/Item$ContactManagement$SmsSenderInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$SmsSenderInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n44#2,15:721\n44#2,15:736\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactManagement$SmsSenderInfo$Companion\n*L\n586#1:691,15\n587#1:706,15\n588#1:721,15\n589#1:736,15\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                /* JADX WARN: Removed duplicated region for block: B:116:0x0295  */
                /* JADX WARN: Removed duplicated region for block: B:172:0x03d1  */
                /* JADX WARN: Removed duplicated region for block: B:232:0x052b  */
                /* JADX WARN: Removed duplicated region for block: B:238:0x0573  */
                /* JADX WARN: Removed duplicated region for block: B:244:0x05bc  */
                /* JADX WARN: Removed duplicated region for block: B:60:0x015e  */
                @org.jetbrains.annotations.NotNull
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final com.urbanairship.preferencecenter.data.Item.ContactManagement.SmsSenderInfo fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r22) throws com.urbanairship.json.JsonException {
                    /*
                        Method dump skipped, instructions count: 1567
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.ContactManagement.SmsSenderInfo.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item$ContactManagement$SmsSenderInfo");
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$Companion;", "", "()V", "KEY_ADD", "", "KEY_BUTTON", "KEY_CANCEL_BUTTON", "KEY_CLOSE_BUTTON", "KEY_COMPONENTS", "KEY_CONDITIONS", "KEY_CONTENT_DESCRIPTION", "KEY_DESCRIPTION", "KEY_DISPLAY", "KEY_EMPTY_LABEL", "KEY_ERROR_MESSAGES", "KEY_ID", "KEY_NAME", "KEY_ON_SUBMIT", "KEY_PLACEHOLDER", "KEY_PLATFORM", "KEY_REGISTRATION_OPTIONS", "KEY_REMOVE", "KEY_RESEND", "KEY_SCOPES", "KEY_SUBMIT_BUTTON", "KEY_SUBSCRIPTION_ID", "KEY_TEXT", "KEY_TYPE", "KEY_VIEW", "TYPE_ALERT", "TYPE_CHANNEL_SUBSCRIPTION", "TYPE_CONTACT_MANAGEMENT", "TYPE_CONTACT_SUBSCRIPTION", "TYPE_CONTACT_SUBSCRIPTION_GROUP", "parse", "Lcom/urbanairship/preferencecenter/data/Item;", "json", "Lcom/urbanairship/json/JsonMap;", "parse$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,690:1\n44#2,15:691\n44#2,15:706\n44#2,15:721\n44#2,15:744\n44#2,15:759\n79#2,16:774\n1549#3:736\n1620#3,3:737\n1549#3:740\n1620#3,3:741\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$Companion\n*L\n641#1:691,15\n646#1:706,15\n652#1:721,15\n663#1:744,15\n671#1:759,15\n672#1:774,16\n654#1:736\n654#1:737,3\n658#1:740\n658#1:741,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v8 com.urbanairship.preferencecenter.data.Item$ChannelSubscription, still in use, count: 3, list:
              (r2v8 com.urbanairship.preferencecenter.data.Item$ChannelSubscription) from 0x08c9: MOVE (r17v1 com.urbanairship.preferencecenter.data.Item$ChannelSubscription) = (r2v8 com.urbanairship.preferencecenter.data.Item$ChannelSubscription)
              (r2v8 com.urbanairship.preferencecenter.data.Item$ChannelSubscription) from 0x08b7: MOVE (r17v2 com.urbanairship.preferencecenter.data.Item$ChannelSubscription) = (r2v8 com.urbanairship.preferencecenter.data.Item$ChannelSubscription)
              (r2v8 com.urbanairship.preferencecenter.data.Item$ChannelSubscription) from 0x0871: MOVE (r17v4 com.urbanairship.preferencecenter.data.Item$ChannelSubscription) = (r2v8 com.urbanairship.preferencecenter.data.Item$ChannelSubscription)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
            	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
            	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
            */
        @org.jetbrains.annotations.NotNull
        public final com.urbanairship.preferencecenter.data.Item parse$urbanairship_preference_center_release(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r27) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 2668
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.preferencecenter.data.Item.Companion.parse$urbanairship_preference_center_release(com.urbanairship.json.JsonMap):com.urbanairship.preferencecenter.data.Item");
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\r\u0010$\u001a\u00020%H\u0010¢\u0006\u0002\b&J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006("}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactSubscription;", "Lcom/urbanairship/preferencecenter/data/Item;", "id", "", "subscriptionId", "scopes", "", "Lcom/urbanairship/contacts/Scope;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/urbanairship/preferencecenter/data/CommonDisplay;Ljava/util/List;)V", "getConditions", "()Ljava/util/List;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getId", "()Ljava/lang/String;", "getScopes", "()Ljava/util/Set;", "getSubscriptionId", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ContactSubscription extends Item {
        private final List conditions;
        private final CommonDisplay display;
        private final String id;
        private final Set scopes;
        private final String subscriptionId;

        public static /* synthetic */ ContactSubscription copy$default(ContactSubscription contactSubscription, String str, String str2, Set set, CommonDisplay commonDisplay, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contactSubscription.id;
            }
            if ((i & 2) != 0) {
                str2 = contactSubscription.subscriptionId;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                set = contactSubscription.scopes;
            }
            Set set2 = set;
            if ((i & 8) != 0) {
                commonDisplay = contactSubscription.display;
            }
            CommonDisplay commonDisplay2 = commonDisplay;
            if ((i & 16) != 0) {
                list = contactSubscription.conditions;
            }
            return contactSubscription.copy(str, str3, set2, commonDisplay2, list);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        @NotNull
        public final Set<Scope> component3() {
            return this.scopes;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final CommonDisplay getDisplay() {
            return this.display;
        }

        @NotNull
        public final List<Condition> component5() {
            return this.conditions;
        }

        @NotNull
        public final ContactSubscription copy(@NotNull String id, @NotNull String subscriptionId, @NotNull Set<? extends Scope> scopes, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            return new ContactSubscription(id, subscriptionId, scopes, display, conditions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContactSubscription)) {
                return false;
            }
            ContactSubscription contactSubscription = (ContactSubscription) other;
            return Intrinsics.areEqual(this.id, contactSubscription.id) && Intrinsics.areEqual(this.subscriptionId, contactSubscription.subscriptionId) && Intrinsics.areEqual(this.scopes, contactSubscription.scopes) && Intrinsics.areEqual(this.display, contactSubscription.display) && Intrinsics.areEqual(this.conditions, contactSubscription.conditions);
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.subscriptionId.hashCode()) * 31) + this.scopes.hashCode()) * 31) + this.display.hashCode()) * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "ContactSubscription(id=" + this.id + ", subscriptionId=" + this.subscriptionId + ", scopes=" + this.scopes + ", display=" + this.display + ", conditions=" + this.conditions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public String getId() {
            return this.id;
        }

        @NotNull
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        @NotNull
        public final Set<Scope> getScopes() {
            return this.scopes;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public CommonDisplay getDisplay() {
            return this.display;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public List<Condition> getConditions() {
            return this.conditions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactSubscription(@NotNull String id, @NotNull String subscriptionId, @NotNull Set<? extends Scope> scopes, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            super("contact_subscription", false, true, false, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.id = id;
            this.subscriptionId = subscriptionId;
            this.scopes = scopes;
            this.display = display;
            this.conditions = conditions;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() {
            JsonMap jsonMapBuild = jsonMapBuilder().put("subscription_id", this.subscriptionId).build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001'B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\f¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fHÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\r\u0010\"\u001a\u00020#H\u0010¢\u0006\u0002\b$J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0012\u0010\"\u001a\u00020&*\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006("}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup;", "Lcom/urbanairship/preferencecenter/data/Item;", "id", "", "subscriptionId", "components", "", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "conditions", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/urbanairship/preferencecenter/data/CommonDisplay;Ljava/util/List;)V", "getComponents", "()Ljava/util/List;", "getConditions", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getId", "()Ljava/lang/String;", "getSubscriptionId", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "Lcom/urbanairship/json/JsonValue;", "Component", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,690:1\n1549#2:691\n1620#2,3:692\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup\n*L\n118#1:691\n118#1:692,3\n*E\n"})
    public static final /* data */ class ContactSubscriptionGroup extends Item {
        private final List components;
        private final List conditions;
        private final CommonDisplay display;
        private final String id;
        private final String subscriptionId;

        public static /* synthetic */ ContactSubscriptionGroup copy$default(ContactSubscriptionGroup contactSubscriptionGroup, String str, String str2, List list, CommonDisplay commonDisplay, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contactSubscriptionGroup.id;
            }
            if ((i & 2) != 0) {
                str2 = contactSubscriptionGroup.subscriptionId;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                list = contactSubscriptionGroup.components;
            }
            List list3 = list;
            if ((i & 8) != 0) {
                commonDisplay = contactSubscriptionGroup.display;
            }
            CommonDisplay commonDisplay2 = commonDisplay;
            if ((i & 16) != 0) {
                list2 = contactSubscriptionGroup.conditions;
            }
            return contactSubscriptionGroup.copy(str, str3, list3, commonDisplay2, list2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        @NotNull
        public final List<Component> component3() {
            return this.components;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final CommonDisplay getDisplay() {
            return this.display;
        }

        @NotNull
        public final List<Condition> component5() {
            return this.conditions;
        }

        @NotNull
        public final ContactSubscriptionGroup copy(@NotNull String id, @NotNull String subscriptionId, @NotNull List<Component> components, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
            Intrinsics.checkNotNullParameter(components, "components");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            return new ContactSubscriptionGroup(id, subscriptionId, components, display, conditions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ContactSubscriptionGroup)) {
                return false;
            }
            ContactSubscriptionGroup contactSubscriptionGroup = (ContactSubscriptionGroup) other;
            return Intrinsics.areEqual(this.id, contactSubscriptionGroup.id) && Intrinsics.areEqual(this.subscriptionId, contactSubscriptionGroup.subscriptionId) && Intrinsics.areEqual(this.components, contactSubscriptionGroup.components) && Intrinsics.areEqual(this.display, contactSubscriptionGroup.display) && Intrinsics.areEqual(this.conditions, contactSubscriptionGroup.conditions);
        }

        public int hashCode() {
            return (((((((this.id.hashCode() * 31) + this.subscriptionId.hashCode()) * 31) + this.components.hashCode()) * 31) + this.display.hashCode()) * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "ContactSubscriptionGroup(id=" + this.id + ", subscriptionId=" + this.subscriptionId + ", components=" + this.components + ", display=" + this.display + ", conditions=" + this.conditions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public String getId() {
            return this.id;
        }

        @NotNull
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        @NotNull
        public final List<Component> getComponents() {
            return this.components;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public CommonDisplay getDisplay() {
            return this.display;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public List<Condition> getConditions() {
            return this.conditions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactSubscriptionGroup(@NotNull String id, @NotNull String subscriptionId, @NotNull List<Component> components, @NotNull CommonDisplay display, @NotNull List<? extends Condition> conditions) {
            super("contact_subscription_group", false, true, false, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(subscriptionId, "subscriptionId");
            Intrinsics.checkNotNullParameter(components, "components");
            Intrinsics.checkNotNullParameter(display, "display");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.id = id;
            this.subscriptionId = subscriptionId;
            this.components = components;
            this.display = display;
            this.conditions = conditions;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
            JsonMap jsonMapBuild = jsonMapBuilder().put("subscription_id", this.subscriptionId).put("components", toJson(this.components)).build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component;", "", "scopes", "", "Lcom/urbanairship/contacts/Scope;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "(Ljava/util/Set;Lcom/urbanairship/preferencecenter/data/CommonDisplay;)V", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getScopes", "()Ljava/util/Set;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,690:1\n1549#2:691\n1620#2,3:692\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component\n*L\n101#1:691\n101#1:692,3\n*E\n"})
        public static final /* data */ class Component {

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE = new Companion(null);
            private final CommonDisplay display;
            private final Set scopes;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Component copy$default(Component component, Set set, CommonDisplay commonDisplay, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = component.scopes;
                }
                if ((i & 2) != 0) {
                    commonDisplay = component.display;
                }
                return component.copy(set, commonDisplay);
            }

            @NotNull
            public final Set<Scope> component1() {
                return this.scopes;
            }

            @NotNull
            /* renamed from: component2, reason: from getter */
            public final CommonDisplay getDisplay() {
                return this.display;
            }

            @NotNull
            public final Component copy(@NotNull Set<? extends Scope> scopes, @NotNull CommonDisplay display) {
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                Intrinsics.checkNotNullParameter(display, "display");
                return new Component(scopes, display);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Component)) {
                    return false;
                }
                Component component = (Component) other;
                return Intrinsics.areEqual(this.scopes, component.scopes) && Intrinsics.areEqual(this.display, component.display);
            }

            public int hashCode() {
                return (this.scopes.hashCode() * 31) + this.display.hashCode();
            }

            @NotNull
            public String toString() {
                return "Component(scopes=" + this.scopes + ", display=" + this.display + CoreConstants.RIGHT_PARENTHESIS_CHAR;
            }

            public Component(@NotNull Set<? extends Scope> scopes, @NotNull CommonDisplay display) {
                Intrinsics.checkNotNullParameter(scopes, "scopes");
                Intrinsics.checkNotNullParameter(display, "display");
                this.scopes = scopes;
                this.display = display;
            }

            @NotNull
            public final Set<Scope> getScopes() {
                return this.scopes;
            }

            @NotNull
            public final CommonDisplay getDisplay() {
                return this.display;
            }

            @NotNull
            public final JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
                Set set = this.scopes;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Scope) it.next()).getJsonValue());
                }
                return JsonExtensionsKt.jsonMapOf(TuplesKt.to("scopes", JsonValue.wrap(arrayList)), TuplesKt.to("display", this.display.toJson$urbanairship_preference_center_release()));
            }

            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component$Companion;", "", "()V", "parse", "Lcom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component;", "json", "Lcom/urbanairship/json/JsonMap;", "parse$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            @SourceDebugExtension({"SMAP\nItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,690:1\n1549#2:691\n1620#2,3:692\n*S KotlinDebug\n*F\n+ 1 Item.kt\ncom/urbanairship/preferencecenter/data/Item$ContactSubscriptionGroup$Component$Companion\n*L\n109#1:691\n109#1:692,3\n*E\n"})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @NotNull
                public final Component parse$urbanairship_preference_center_release(@NotNull JsonMap json) throws JsonException {
                    Intrinsics.checkNotNullParameter(json, "json");
                    JsonList jsonListOptList = json.opt("scopes").optList();
                    Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
                    Iterator<JsonValue> it = jsonListOptList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Scope.fromJson(it.next()));
                    }
                    return new Component(CollectionsKt.toSet(arrayList), CommonDisplay.INSTANCE.parse$urbanairship_preference_center_release(json.get("display")));
                }
            }
        }

        private final JsonValue toJson(List list) throws JsonException {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Component) it.next()).toJson$urbanairship_preference_center_release());
            }
            JsonValue jsonValueWrap = JsonValue.wrap(arrayList);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\r\u0010$\u001a\u00020%H\u0010¢\u0006\u0002\b&J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/urbanairship/preferencecenter/data/Item$Alert;", "Lcom/urbanairship/preferencecenter/data/Item;", "id", "", "iconDisplay", "Lcom/urbanairship/preferencecenter/data/IconDisplay;", "button", "Lcom/urbanairship/preferencecenter/data/Button;", "conditions", "", "Lcom/urbanairship/preferencecenter/data/Condition;", "Lcom/urbanairship/preferencecenter/data/Conditions;", "(Ljava/lang/String;Lcom/urbanairship/preferencecenter/data/IconDisplay;Lcom/urbanairship/preferencecenter/data/Button;Ljava/util/List;)V", "getButton", "()Lcom/urbanairship/preferencecenter/data/Button;", "getConditions", "()Ljava/util/List;", "display", "Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getDisplay", "()Lcom/urbanairship/preferencecenter/data/CommonDisplay;", "getIconDisplay", "()Lcom/urbanairship/preferencecenter/data/IconDisplay;", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Alert extends Item {
        private final Button button;
        private final List conditions;
        private final CommonDisplay display;
        private final IconDisplay iconDisplay;
        private final String id;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Alert copy$default(Alert alert, String str, IconDisplay iconDisplay, Button button, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = alert.id;
            }
            if ((i & 2) != 0) {
                iconDisplay = alert.iconDisplay;
            }
            if ((i & 4) != 0) {
                button = alert.button;
            }
            if ((i & 8) != 0) {
                list = alert.conditions;
            }
            return alert.copy(str, iconDisplay, button, list);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final IconDisplay getIconDisplay() {
            return this.iconDisplay;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Button getButton() {
            return this.button;
        }

        @NotNull
        public final List<Condition> component4() {
            return this.conditions;
        }

        @NotNull
        public final Alert copy(@NotNull String id, @NotNull IconDisplay iconDisplay, @Nullable Button button, @NotNull List<? extends Condition> conditions) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(iconDisplay, "iconDisplay");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            return new Alert(id, iconDisplay, button, conditions);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Alert)) {
                return false;
            }
            Alert alert = (Alert) other;
            return Intrinsics.areEqual(this.id, alert.id) && Intrinsics.areEqual(this.iconDisplay, alert.iconDisplay) && Intrinsics.areEqual(this.button, alert.button) && Intrinsics.areEqual(this.conditions, alert.conditions);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.iconDisplay.hashCode()) * 31;
            Button button = this.button;
            return ((iHashCode + (button == null ? 0 : button.hashCode())) * 31) + this.conditions.hashCode();
        }

        @NotNull
        public String toString() {
            return "Alert(id=" + this.id + ", iconDisplay=" + this.iconDisplay + ", button=" + this.button + ", conditions=" + this.conditions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public String getId() {
            return this.id;
        }

        @NotNull
        public final IconDisplay getIconDisplay() {
            return this.iconDisplay;
        }

        @Nullable
        public final Button getButton() {
            return this.button;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public List<Condition> getConditions() {
            return this.conditions;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Alert(@NotNull String id, @NotNull IconDisplay iconDisplay, @Nullable Button button, @NotNull List<? extends Condition> conditions) {
            super("alert", false, false, false, null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(iconDisplay, "iconDisplay");
            Intrinsics.checkNotNullParameter(conditions, "conditions");
            this.id = id;
            this.iconDisplay = iconDisplay;
            this.button = button;
            this.conditions = conditions;
            this.display = new CommonDisplay(iconDisplay.getName(), iconDisplay.getDescription());
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public CommonDisplay getDisplay() {
            return this.display;
        }

        @Override // com.urbanairship.preferencecenter.data.Item
        @NotNull
        public JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
            JsonMap.Builder builderPut = jsonMapBuilder().put("display", this.iconDisplay.toJson$urbanairship_preference_center_release());
            Button button = this.button;
            JsonMap jsonMapBuild = builderPut.put("button", button != null ? button.toJson$urbanairship_preference_center_release() : null).build();
            Intrinsics.checkNotNullExpressionValue(jsonMapBuild, "build(...)");
            return jsonMapBuild;
        }
    }

    @NotNull
    protected final JsonMap.Builder jsonMapBuilder() {
        JsonMap.Builder builderPut = JsonMap.newBuilder().put("id", getId()).put("type", this.type).put("display", getDisplay().toJson$urbanairship_preference_center_release());
        List<Condition> conditions = getConditions();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(conditions, 10));
        Iterator<T> it = conditions.iterator();
        while (it.hasNext()) {
            arrayList.add(((Condition) it.next()).toJson$urbanairship_preference_center_release());
        }
        JsonMap.Builder builderPut2 = builderPut.put("conditions", JsonExtensionsKt.toJsonList(arrayList));
        Intrinsics.checkNotNullExpressionValue(builderPut2, "put(...)");
        return builderPut2;
    }
}
