package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.schemas.TCVideoEventPropertiesNames;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.channel.SubscriptionListMutation;
import com.urbanairship.channel.TagGroupsMutation;
import com.urbanairship.contacts.ContactChannelMutation;
import com.urbanairship.contacts.Scope;
import com.urbanairship.contacts.ScopedSubscriptionListMutation;
import com.urbanairship.util.CachedList;
import com.urbanairship.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\n2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0004\b#\u0010$J\u001a\u0010%\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\nH\u0080@¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0)H\u0002J\r\u0010-\u001a\u00020.H\u0000¢\u0006\u0002\b/JK\u00100\u001a\u00020.2\u0006\u0010!\u001a\u00020\n2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010)2\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010)2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0000¢\u0006\u0002\b6JW\u00107\u001a\u00020.2\u0006\u0010\"\u001a\u00020\n2\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010)2\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010)2\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010)2\n\b\u0002\u00108\u001a\u0004\u0018\u000109H\u0000¢\u0006\u0002\b:R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0017\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006="}, m1836d2 = {"Lcom/urbanairship/audience/AudienceOverridesProvider;", "", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/util/Clock;)V", "_updates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/UInt;", "pendingChannelOverridesDelegate", "Lkotlin/Function1;", "", "Lcom/urbanairship/audience/AudienceOverrides$Channel;", "getPendingChannelOverridesDelegate$urbanairship_core_release", "()Lkotlin/jvm/functions/Function1;", "setPendingChannelOverridesDelegate$urbanairship_core_release", "(Lkotlin/jvm/functions/Function1;)V", "pendingContactOverridesDelegate", "Lcom/urbanairship/audience/AudienceOverrides$Contact;", "getPendingContactOverridesDelegate$urbanairship_core_release", "setPendingContactOverridesDelegate$urbanairship_core_release", "records", "Lcom/urbanairship/util/CachedList;", "Lcom/urbanairship/audience/AudienceOverridesProvider$Record;", "stableContactIdDelegate", "Lkotlin/coroutines/Continuation;", "getStableContactIdDelegate$urbanairship_core_release", "setStableContactIdDelegate$urbanairship_core_release", "Lkotlin/jvm/functions/Function1;", "updates", "Lkotlinx/coroutines/flow/SharedFlow;", "getUpdates$urbanairship_core_release", "()Lkotlinx/coroutines/flow/SharedFlow;", "channelOverrides", "channelId", "contactId", "channelOverrides$urbanairship_core_release", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contactOverrides", "contactOverrides$urbanairship_core_release", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertAppScopes", "", "Lcom/urbanairship/channel/SubscriptionListMutation;", "scoped", "Lcom/urbanairship/contacts/ScopedSubscriptionListMutation;", "notifyPendingChanged", "", "notifyPendingChanged$urbanairship_core_release", "recordChannelUpdate", FetchDeviceInfoAction.TAGS_KEY, "Lcom/urbanairship/channel/TagGroupsMutation;", "attributes", "Lcom/urbanairship/channel/AttributeMutation;", "subscriptions", "recordChannelUpdate$urbanairship_core_release", "recordContactUpdate", TCVideoEventPropertiesNames.TCV_CHANNEL, "Lcom/urbanairship/contacts/ContactChannelMutation;", "recordContactUpdate$urbanairship_core_release", "Companion", "Record", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nAudienceOverridesProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceOverridesProvider.kt\ncom/urbanairship/audience/AudienceOverridesProvider\n+ 2 StateFlow.kt\nkotlinx/coroutines/flow/StateFlowKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n230#2,5:162\n1#3:167\n1#3:178\n1603#4,9:168\n1855#4:177\n1856#4:179\n1612#4:180\n1855#4,2:181\n1855#4,2:183\n*S KotlinDebug\n*F\n+ 1 AudienceOverridesProvider.kt\ncom/urbanairship/audience/AudienceOverridesProvider\n*L\n41#1:162,5\n68#1:178\n68#1:168,9\n68#1:177\n68#1:179\n68#1:180\n87#1:181,2\n120#1:183,2\n*E\n"})
public final class AudienceOverridesProvider {
    public static final long EXPIRY_MS = 600000;
    private final MutableStateFlow _updates;
    private Function1 pendingChannelOverridesDelegate;
    private Function1 pendingContactOverridesDelegate;
    private final CachedList records;
    private Function1 stableContactIdDelegate;
    private final SharedFlow updates;

    public AudienceOverridesProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AudienceOverridesProvider(@NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.records = new CachedList(clock);
        MutableStateFlow MutableStateFlow = StateFlowKt.MutableStateFlow(UInt.m5311boximpl(0));
        this._updates = MutableStateFlow;
        this.updates = FlowKt.asSharedFlow(MutableStateFlow);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AudienceOverridesProvider(Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(DEFAULT_CLOCK);
    }

    @Nullable
    public final Function1<Continuation<? super String>, Object> getStableContactIdDelegate$urbanairship_core_release() {
        return this.stableContactIdDelegate;
    }

    public final void setStableContactIdDelegate$urbanairship_core_release(@Nullable Function1<? super Continuation<? super String>, ? extends Object> function1) {
        this.stableContactIdDelegate = function1;
    }

    @Nullable
    public final Function1<String, AudienceOverrides.Channel> getPendingChannelOverridesDelegate$urbanairship_core_release() {
        return this.pendingChannelOverridesDelegate;
    }

    public final void setPendingChannelOverridesDelegate$urbanairship_core_release(@Nullable Function1<? super String, AudienceOverrides.Channel> function1) {
        this.pendingChannelOverridesDelegate = function1;
    }

    @Nullable
    public final Function1<String, AudienceOverrides.Contact> getPendingContactOverridesDelegate$urbanairship_core_release() {
        return this.pendingContactOverridesDelegate;
    }

    public final void setPendingContactOverridesDelegate$urbanairship_core_release(@Nullable Function1<? super String, AudienceOverrides.Contact> function1) {
        this.pendingContactOverridesDelegate = function1;
    }

    @NotNull
    public final SharedFlow<UInt> getUpdates$urbanairship_core_release() {
        return this.updates;
    }

    public final void notifyPendingChanged$urbanairship_core_release() {
        Object value;
        MutableStateFlow mutableStateFlow = this._updates;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UInt.m5311boximpl(UInt.m5312constructorimpl(((UInt) value).getData() + 1))));
    }

    public final void recordContactUpdate$urbanairship_core_release(@NotNull String contactId, @Nullable List<? extends TagGroupsMutation> tags, @Nullable List<? extends AttributeMutation> attributes, @Nullable List<? extends ScopedSubscriptionListMutation> subscriptions, @Nullable ContactChannelMutation channel) {
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        this.records.append(new Record(contactId, new AudienceOverrides.Contact(tags, attributes, subscriptions, channel != null ? CollectionsKt.listOf(channel) : null)), EXPIRY_MS);
        notifyPendingChanged$urbanairship_core_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void recordChannelUpdate$urbanairship_core_release$default(AudienceOverridesProvider audienceOverridesProvider, String str, List list, List list2, List list3, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            list2 = null;
        }
        if ((i & 8) != 0) {
            list3 = null;
        }
        audienceOverridesProvider.recordChannelUpdate$urbanairship_core_release(str, list, list2, list3);
    }

    public final void recordChannelUpdate$urbanairship_core_release(@NotNull String channelId, @Nullable List<? extends TagGroupsMutation> tags, @Nullable List<? extends AttributeMutation> attributes, @Nullable List<? extends SubscriptionListMutation> subscriptions) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.records.append(new Record(channelId, new AudienceOverrides.Channel(tags, attributes, subscriptions)), EXPIRY_MS);
        notifyPendingChanged$urbanairship_core_release();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:29:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x008f  */
    /* JADX WARN: Code duplicated, block: B:67:0x0116  */
    /* JADX WARN: Code duplicated, block: B:70:0x011d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0124  */
    /* JADX WARN: Code duplicated, block: B:77:0x012c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object contactOverrides$urbanairship_core_release(@Nullable String str, @NotNull Continuation<? super AudienceOverrides.Contact> continuation) {
        AudienceOverridesProvider$contactOverrides$1 audienceOverridesProvider$contactOverrides$1;
        Function1 function1;
        AudienceOverrides.Contact contact;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        List<ContactChannelMutation> channels;
        List<ScopedSubscriptionListMutation> subscriptions;
        List<AttributeMutation> attributes;
        List<TagGroupsMutation> tags;
        if (continuation instanceof AudienceOverridesProvider$contactOverrides$1) {
            audienceOverridesProvider$contactOverrides$1 = (AudienceOverridesProvider$contactOverrides$1) continuation;
            int i = audienceOverridesProvider$contactOverrides$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                audienceOverridesProvider$contactOverrides$1.label = i - Integer.MIN_VALUE;
            } else {
                audienceOverridesProvider$contactOverrides$1 = new AudienceOverridesProvider$contactOverrides$1(this, continuation);
            }
        } else {
            audienceOverridesProvider$contactOverrides$1 = new AudienceOverridesProvider$contactOverrides$1(this, continuation);
        }
        Object objInvoke = audienceOverridesProvider$contactOverrides$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = audienceOverridesProvider$contactOverrides$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            if (str == null) {
                Function1 function2 = this.stableContactIdDelegate;
                if (function2 != null) {
                    audienceOverridesProvider$contactOverrides$1.L$0 = this;
                    audienceOverridesProvider$contactOverrides$1.label = 1;
                    objInvoke = function2.invoke(audienceOverridesProvider$contactOverrides$1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    str = null;
                }
                if (str == null) {
                    return new AudienceOverrides.Contact(null, null, null, null, 15, null);
                }
            }
            function1 = this.pendingContactOverridesDelegate;
            if (function1 != null) {
                contact = (AudienceOverrides.Contact) function1.invoke(str);
            } else {
                contact = null;
            }
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            arrayList3 = new ArrayList();
            arrayList4 = new ArrayList();
            for (Record record : this.records.getValues()) {
                if (!(record.getOverrides() instanceof AudienceOverrides.Contact) && Intrinsics.areEqual(record.getIdentifier(), str)) {
                    List<TagGroupsMutation> tags2 = ((AudienceOverrides.Contact) record.getOverrides()).getTags();
                    if (tags2 != null) {
                        CollectionsKt.addAll(arrayList, tags2);
                    }
                    List<AttributeMutation> attributes2 = ((AudienceOverrides.Contact) record.getOverrides()).getAttributes();
                    if (attributes2 != null) {
                        CollectionsKt.addAll(arrayList2, attributes2);
                    }
                    List<ScopedSubscriptionListMutation> subscriptions2 = ((AudienceOverrides.Contact) record.getOverrides()).getSubscriptions();
                    if (subscriptions2 != null) {
                        CollectionsKt.addAll(arrayList3, subscriptions2);
                    }
                    List<ContactChannelMutation> channels2 = ((AudienceOverrides.Contact) record.getOverrides()).getChannels();
                    if (channels2 != null) {
                        CollectionsKt.addAll(arrayList4, channels2);
                    }
                }
            }
            if (contact != null && (tags = contact.getTags()) != null) {
                CollectionsKt.addAll(arrayList, tags);
            }
            if (contact != null && (attributes = contact.getAttributes()) != null) {
                CollectionsKt.addAll(arrayList2, attributes);
            }
            if (contact != null && (subscriptions = contact.getSubscriptions()) != null) {
                CollectionsKt.addAll(arrayList3, subscriptions);
            }
            if (contact != null && (channels = contact.getChannels()) != null) {
                CollectionsKt.addAll(arrayList4, channels);
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList3.isEmpty()) {
                arrayList3 = null;
            }
            return new AudienceOverrides.Contact(arrayList, arrayList2, arrayList3, arrayList4.isEmpty() ? null : arrayList4);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this = (AudienceOverridesProvider) audienceOverridesProvider$contactOverrides$1.L$0;
        ResultKt.throwOnFailure(objInvoke);
        str = (String) objInvoke;
        if (str == null) {
            return new AudienceOverrides.Contact(null, null, null, null, 15, null);
        }
        function1 = this.pendingContactOverridesDelegate;
        if (function1 != null) {
            contact = (AudienceOverrides.Contact) function1.invoke(str);
        } else {
            contact = null;
        }
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList3 = new ArrayList();
        arrayList4 = new ArrayList();
        while (r12.hasNext()) {
            if (!(record.getOverrides() instanceof AudienceOverrides.Contact)) {
            }
        }
        if (contact != null) {
            CollectionsKt.addAll(arrayList, tags);
        }
        if (contact != null) {
            CollectionsKt.addAll(arrayList2, attributes);
        }
        if (contact != null) {
            CollectionsKt.addAll(arrayList3, subscriptions);
        }
        if (contact != null) {
            CollectionsKt.addAll(arrayList4, channels);
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        if (arrayList3.isEmpty()) {
            arrayList3 = null;
        }
        return new AudienceOverrides.Contact(arrayList, arrayList2, arrayList3, arrayList4.isEmpty() ? null : arrayList4);
    }

    public static /* synthetic */ Object channelOverrides$urbanairship_core_release$default(AudienceOverridesProvider audienceOverridesProvider, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return audienceOverridesProvider.channelOverrides$urbanairship_core_release(str, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x005a  */
    /* JADX WARN: Code duplicated, block: B:26:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x006f  */
    /* JADX WARN: Code duplicated, block: B:35:0x008f  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code duplicated, block: B:87:0x0162  */
    /* JADX WARN: Code duplicated, block: B:90:0x0169  */
    /* JADX WARN: Code duplicated, block: B:94:0x0171  */
    /* JADX WARN: Code duplicated, block: B:98:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00a7 A[SYNTHETIC] */
    @Nullable
    public final Object channelOverrides$urbanairship_core_release(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super AudienceOverrides.Channel> continuation) {
        AudienceOverridesProvider$channelOverrides$1 audienceOverridesProvider$channelOverrides$1;
        Function1 function1;
        AudienceOverrides.Channel channel;
        AudienceOverrides.Contact contact;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        List<ScopedSubscriptionListMutation> subscriptions;
        List<AttributeMutation> attributes;
        List<TagGroupsMutation> tags;
        List<SubscriptionListMutation> subscriptions2;
        List<AttributeMutation> attributes2;
        List<TagGroupsMutation> tags2;
        AudienceOverrides overrides;
        List<TagGroupsMutation> tags3;
        List<AttributeMutation> attributes3;
        List<SubscriptionListMutation> subscriptions3;
        Function1 function2;
        if (continuation instanceof AudienceOverridesProvider$channelOverrides$1) {
            audienceOverridesProvider$channelOverrides$1 = (AudienceOverridesProvider$channelOverrides$1) continuation;
            int i = audienceOverridesProvider$channelOverrides$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                audienceOverridesProvider$channelOverrides$1.label = i - Integer.MIN_VALUE;
            } else {
                audienceOverridesProvider$channelOverrides$1 = new AudienceOverridesProvider$channelOverrides$1(this, continuation);
            }
        } else {
            audienceOverridesProvider$channelOverrides$1 = new AudienceOverridesProvider$channelOverrides$1(this, continuation);
        }
        Object objInvoke = audienceOverridesProvider$channelOverrides$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = audienceOverridesProvider$channelOverrides$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objInvoke);
            if (str2 == null) {
                Function1 function3 = this.stableContactIdDelegate;
                if (function3 != null) {
                    audienceOverridesProvider$channelOverrides$1.L$0 = this;
                    audienceOverridesProvider$channelOverrides$1.L$1 = str;
                    audienceOverridesProvider$channelOverrides$1.label = 1;
                    objInvoke = function3.invoke(audienceOverridesProvider$channelOverrides$1);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    str2 = null;
                }
            }
            function1 = this.pendingChannelOverridesDelegate;
            if (function1 != null) {
                channel = (AudienceOverrides.Channel) function1.invoke(str);
            } else {
                channel = null;
            }
            if (str2 != null || (function2 = this.pendingContactOverridesDelegate) == null) {
                contact = null;
            } else {
                contact = (AudienceOverrides.Contact) function2.invoke(str2);
            }
            arrayList = new ArrayList();
            arrayList2 = new ArrayList();
            arrayList3 = new ArrayList();
            for (Record record : this.records.getValues()) {
                overrides = record.getOverrides();
                if (overrides instanceof AudienceOverrides.Channel) {
                    if (!Intrinsics.areEqual(record.getIdentifier(), str)) {
                        tags3 = ((AudienceOverrides.Channel) record.getOverrides()).getTags();
                        if (tags3 != null) {
                            CollectionsKt.addAll(arrayList, tags3);
                        }
                        attributes3 = ((AudienceOverrides.Channel) record.getOverrides()).getAttributes();
                        if (attributes3 != null) {
                            CollectionsKt.addAll(arrayList2, attributes3);
                        }
                        subscriptions3 = ((AudienceOverrides.Channel) record.getOverrides()).getSubscriptions();
                        if (subscriptions3 != null) {
                            CollectionsKt.addAll(arrayList3, subscriptions3);
                        }
                    }
                } else if (!(overrides instanceof AudienceOverrides.Contact) && Intrinsics.areEqual(record.getIdentifier(), str2)) {
                    List<TagGroupsMutation> tags4 = ((AudienceOverrides.Contact) record.getOverrides()).getTags();
                    if (tags4 != null) {
                        CollectionsKt.addAll(arrayList, tags4);
                    }
                    List<AttributeMutation> attributes4 = ((AudienceOverrides.Contact) record.getOverrides()).getAttributes();
                    if (attributes4 != null) {
                        CollectionsKt.addAll(arrayList2, attributes4);
                    }
                    List<ScopedSubscriptionListMutation> subscriptions4 = ((AudienceOverrides.Contact) record.getOverrides()).getSubscriptions();
                    if (subscriptions4 != null) {
                        CollectionsKt.addAll(arrayList3, this.convertAppScopes(subscriptions4));
                    }
                }
            }
            if (channel != null && (tags2 = channel.getTags()) != null) {
                CollectionsKt.addAll(arrayList, tags2);
            }
            if (channel != null && (attributes2 = channel.getAttributes()) != null) {
                CollectionsKt.addAll(arrayList2, attributes2);
            }
            if (channel != null && (subscriptions2 = channel.getSubscriptions()) != null) {
                CollectionsKt.addAll(arrayList3, subscriptions2);
            }
            if (contact != null && (tags = contact.getTags()) != null) {
                CollectionsKt.addAll(arrayList, tags);
            }
            if (contact != null && (attributes = contact.getAttributes()) != null) {
                CollectionsKt.addAll(arrayList2, attributes);
            }
            if (contact != null && (subscriptions = contact.getSubscriptions()) != null) {
                CollectionsKt.addAll(arrayList3, this.convertAppScopes(subscriptions));
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            return new AudienceOverrides.Channel(arrayList, arrayList2, arrayList3.isEmpty() ? null : arrayList3);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) audienceOverridesProvider$channelOverrides$1.L$1;
        this = (AudienceOverridesProvider) audienceOverridesProvider$channelOverrides$1.L$0;
        ResultKt.throwOnFailure(objInvoke);
        str2 = (String) objInvoke;
        function1 = this.pendingChannelOverridesDelegate;
        if (function1 != null) {
            channel = (AudienceOverrides.Channel) function1.invoke(str);
        } else {
            channel = null;
        }
        if (str2 != null) {
            contact = null;
        } else {
            contact = null;
        }
        arrayList = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList3 = new ArrayList();
        while (r5.hasNext()) {
            overrides = record.getOverrides();
            if (overrides instanceof AudienceOverrides.Channel) {
                if (!Intrinsics.areEqual(record.getIdentifier(), str)) {
                    tags3 = ((AudienceOverrides.Channel) record.getOverrides()).getTags();
                    if (tags3 != null) {
                        CollectionsKt.addAll(arrayList, tags3);
                    }
                    attributes3 = ((AudienceOverrides.Channel) record.getOverrides()).getAttributes();
                    if (attributes3 != null) {
                        CollectionsKt.addAll(arrayList2, attributes3);
                    }
                    subscriptions3 = ((AudienceOverrides.Channel) record.getOverrides()).getSubscriptions();
                    if (subscriptions3 != null) {
                        CollectionsKt.addAll(arrayList3, subscriptions3);
                    }
                }
            } else if (!(overrides instanceof AudienceOverrides.Contact)) {
            }
        }
        if (channel != null) {
            CollectionsKt.addAll(arrayList, tags2);
        }
        if (channel != null) {
            CollectionsKt.addAll(arrayList2, attributes2);
        }
        if (channel != null) {
            CollectionsKt.addAll(arrayList3, subscriptions2);
        }
        if (contact != null) {
            CollectionsKt.addAll(arrayList, tags);
        }
        if (contact != null) {
            CollectionsKt.addAll(arrayList2, attributes);
        }
        if (contact != null) {
            CollectionsKt.addAll(arrayList3, this.convertAppScopes(subscriptions));
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        return new AudienceOverrides.Channel(arrayList, arrayList2, arrayList3.isEmpty() ? null : arrayList3);
    }

    private static final class Record {
        private final String identifier;
        private final AudienceOverrides overrides;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Record)) {
                return false;
            }
            Record record = (Record) obj;
            return Intrinsics.areEqual(this.identifier, record.identifier) && Intrinsics.areEqual(this.overrides, record.overrides);
        }

        public int hashCode() {
            return (this.identifier.hashCode() * 31) + this.overrides.hashCode();
        }

        public String toString() {
            return "Record(identifier=" + this.identifier + ", overrides=" + this.overrides + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Record(String identifier, AudienceOverrides overrides) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(overrides, "overrides");
            this.identifier = identifier;
            this.overrides = overrides;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final AudienceOverrides getOverrides() {
            return this.overrides;
        }
    }

    private final List convertAppScopes(List scoped) {
        ArrayList arrayList = new ArrayList();
        Iterator it = scoped.iterator();
        while (it.hasNext()) {
            ScopedSubscriptionListMutation scopedSubscriptionListMutation = (ScopedSubscriptionListMutation) it.next();
            SubscriptionListMutation subscriptionListMutation = scopedSubscriptionListMutation.getScope() == Scope.APP ? new SubscriptionListMutation(scopedSubscriptionListMutation.getAction(), scopedSubscriptionListMutation.getListId(), scopedSubscriptionListMutation.getTimestamp()) : null;
            if (subscriptionListMutation != null) {
                arrayList.add(subscriptionListMutation);
            }
        }
        return arrayList;
    }
}
