package com.urbanairship.channel;

import androidx.annotation.VisibleForTesting;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UALog;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.audience.AudienceOverrides;
import com.urbanairship.audience.AudienceOverridesProvider;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.RequestResult;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 12\u00020\u0001:\u00011B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJU\u0010\u001a\u001a\u00020\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00132\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u00132\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00132\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u0013H\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u001bH\u0000¢\u0006\u0002\b&J\r\u0010'\u001a\u00020\u001bH\u0001¢\u0006\u0002\b(J\b\u0010)\u001a\u00020*H\u0002J\u0016\u0010+\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0018\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H\u0080@¢\u0006\u0004\b/\u00100R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00062"}, m1836d2 = {"Lcom/urbanairship/channel/ChannelBatchUpdateManager;", "", "dataStore", "Lcom/urbanairship/PreferenceDataStore;", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", "audienceOverridesProvider", "Lcom/urbanairship/audience/AudienceOverridesProvider;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/audience/AudienceOverridesProvider;)V", "apiClient", "Lcom/urbanairship/channel/ChannelBatchUpdateApiClient;", "(Lcom/urbanairship/PreferenceDataStore;Lcom/urbanairship/channel/ChannelBatchUpdateApiClient;Lcom/urbanairship/audience/AudienceOverridesProvider;)V", "hasPending", "", "getHasPending$urbanairship_core_release", "()Z", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "value", "", "Lcom/urbanairship/channel/AudienceUpdate;", "updates", "getUpdates", "()Ljava/util/List;", "setUpdates", "(Ljava/util/List;)V", "addUpdate", "", FetchDeviceInfoAction.TAGS_KEY, "Lcom/urbanairship/channel/TagGroupsMutation;", "attributes", "Lcom/urbanairship/channel/AttributeMutation;", "subscriptions", "Lcom/urbanairship/channel/SubscriptionListMutation;", "liveUpdates", "Lcom/urbanairship/channel/LiveUpdateMutation;", "addUpdate$urbanairship_core_release", "clearPending", "clearPending$urbanairship_core_release", "migrateData", "migrateData$urbanairship_core_release", "pendingOverrides", "Lcom/urbanairship/audience/AudienceOverrides$Channel;", "popAudienceUpdates", "uploadPending", "channelId", "", "uploadPending$urbanairship_core_release", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nChannelBatchUpdateManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelBatchUpdateManager.kt\ncom/urbanairship/channel/ChannelBatchUpdateManager\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,231:1\n19#2,2:232\n21#2,5:238\n1549#3:234\n1620#3,3:235\n1855#3:243\n1856#3:245\n1855#3,2:246\n1855#3,2:248\n1549#3:250\n1620#3,3:251\n1549#3:254\n1620#3,3:255\n1549#3:258\n1620#3,3:259\n1#4:244\n*S KotlinDebug\n*F\n+ 1 ChannelBatchUpdateManager.kt\ncom/urbanairship/channel/ChannelBatchUpdateManager\n*L\n43#1:232,2\n43#1:238,5\n44#1:234\n44#1:235,3\n73#1:243\n73#1:245\n135#1:246,2\n148#1:248,2\n163#1:250\n163#1:251,3\n168#1:254\n168#1:255,3\n173#1:258\n173#1:259,3\n*E\n"})
public final class ChannelBatchUpdateManager {
    private final ChannelBatchUpdateApiClient apiClient;
    private final AudienceOverridesProvider audienceOverridesProvider;
    private final PreferenceDataStore dataStore;
    private final ReentrantLock lock;

    public ChannelBatchUpdateManager(@NotNull PreferenceDataStore dataStore, @NotNull ChannelBatchUpdateApiClient apiClient, @NotNull AudienceOverridesProvider audienceOverridesProvider) {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
        this.dataStore = dataStore;
        this.apiClient = apiClient;
        this.audienceOverridesProvider = audienceOverridesProvider;
        this.lock = new ReentrantLock();
        migrateData$urbanairship_core_release();
        audienceOverridesProvider.setPendingChannelOverridesDelegate$urbanairship_core_release(new Function1() { // from class: com.urbanairship.channel.ChannelBatchUpdateManager.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AudienceOverrides.Channel invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ChannelBatchUpdateManager.this.pendingOverrides();
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelBatchUpdateManager(@NotNull PreferenceDataStore dataStore, @NotNull AirshipRuntimeConfig runtimeConfig, @NotNull AudienceOverridesProvider audienceOverridesProvider) {
        this(dataStore, new ChannelBatchUpdateApiClient(runtimeConfig, null, 2, 0 == true ? 1 : 0), audienceOverridesProvider);
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(audienceOverridesProvider, "audienceOverridesProvider");
    }

    public final boolean getHasPending$urbanairship_core_release() {
        return !this.dataStore.getJsonValue("com.urbanairship.channel.PENDING_AUDIENCE_UPDATES").optList().isEmpty();
    }

    private final List getUpdates() {
        ArrayList arrayList;
        JsonValue jsonValueOptJsonValue = this.dataStore.optJsonValue("com.urbanairship.channel.PENDING_AUDIENCE_UPDATES");
        if (jsonValueOptJsonValue != null) {
            try {
                JsonList jsonListRequireList = jsonValueOptJsonValue.requireList();
                Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    JsonMap jsonMapRequireMap = it.next().requireMap();
                    Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                    arrayList.add(new AudienceUpdate(jsonMapRequireMap));
                }
            } catch (JsonException e) {
                UALog.m1744e("Failed to parse json", e);
                arrayList = null;
            }
            if (arrayList != null) {
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }

    private final void setUpdates(List list) {
        this.dataStore.put("com.urbanairship.channel.PENDING_AUDIENCE_UPDATES", JsonValue.wrap(list));
    }

    public final void clearPending$urbanairship_core_release() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.dataStore.remove("com.urbanairship.channel.PENDING_AUDIENCE_UPDATES");
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, java.lang.Object, java.util.List] */
    @Nullable
    public final Object uploadPending$urbanairship_core_release(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        ChannelBatchUpdateManager$uploadPending$1 channelBatchUpdateManager$uploadPending$1;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        List list;
        if (continuation instanceof ChannelBatchUpdateManager$uploadPending$1) {
            channelBatchUpdateManager$uploadPending$1 = (ChannelBatchUpdateManager$uploadPending$1) continuation;
            int i = channelBatchUpdateManager$uploadPending$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                channelBatchUpdateManager$uploadPending$1.label = i - Integer.MIN_VALUE;
            } else {
                channelBatchUpdateManager$uploadPending$1 = new ChannelBatchUpdateManager$uploadPending$1(this, continuation);
            }
        } else {
            channelBatchUpdateManager$uploadPending$1 = new ChannelBatchUpdateManager$uploadPending$1(this, continuation);
        }
        ChannelBatchUpdateManager$uploadPending$1 channelBatchUpdateManager$uploadPending$2 = channelBatchUpdateManager$uploadPending$1;
        Object obj = channelBatchUpdateManager$uploadPending$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = channelBatchUpdateManager$uploadPending$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            List<AudienceUpdate> updates = getUpdates();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            objectRef4.element = new ArrayList();
            objectRef = new Ref.ObjectRef();
            objectRef.element = new ArrayList();
            objectRef2 = new Ref.ObjectRef();
            objectRef2.element = new ArrayList();
            Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
            objectRef5.element = new ArrayList();
            for (AudienceUpdate audienceUpdate : updates) {
                List tags = audienceUpdate.getTags();
                if (tags != null) {
                    Boxing.boxBoolean(((List) objectRef4.element).addAll(tags));
                }
                List attributes = audienceUpdate.getAttributes();
                if (attributes != null) {
                    Boxing.boxBoolean(((List) objectRef.element).addAll(attributes));
                }
                List subscriptions = audienceUpdate.getSubscriptions();
                if (subscriptions != null) {
                    Boxing.boxBoolean(((List) objectRef2.element).addAll(subscriptions));
                }
                List liveUpdates = audienceUpdate.getLiveUpdates();
                if (liveUpdates != null) {
                    ((List) objectRef5.element).addAll(liveUpdates);
                }
            }
            ?? CollapseMutations = TagGroupsMutation.collapseMutations((List) objectRef4.element);
            Intrinsics.checkNotNullExpressionValue(CollapseMutations, "collapseMutations(...)");
            objectRef4.element = CollapseMutations;
            ?? CollapseMutations2 = AttributeMutation.collapseMutations((List) objectRef.element);
            Intrinsics.checkNotNullExpressionValue(CollapseMutations2, "collapseMutations(...)");
            objectRef.element = CollapseMutations2;
            ?? CollapseMutations3 = SubscriptionListMutation.collapseMutations((List) objectRef2.element);
            Intrinsics.checkNotNullExpressionValue(CollapseMutations3, "collapseMutations(...)");
            objectRef2.element = CollapseMutations3;
            if (((List) objectRef4.element).isEmpty() && ((List) objectRef.element).isEmpty() && ((List) objectRef2.element).isEmpty() && ((List) objectRef5.element).isEmpty()) {
                popAudienceUpdates(updates);
                return Boxing.boxBoolean(true);
            }
            ChannelBatchUpdateApiClient channelBatchUpdateApiClient = this.apiClient;
            List<? extends TagGroupsMutation> list2 = (List) objectRef4.element;
            List<? extends AttributeMutation> list3 = (List) objectRef.element;
            List<? extends SubscriptionListMutation> list4 = (List) objectRef2.element;
            List<? extends LiveUpdateMutation> list5 = (List) objectRef5.element;
            channelBatchUpdateManager$uploadPending$2.L$0 = this;
            channelBatchUpdateManager$uploadPending$2.L$1 = str;
            channelBatchUpdateManager$uploadPending$2.L$2 = updates;
            channelBatchUpdateManager$uploadPending$2.L$3 = objectRef4;
            channelBatchUpdateManager$uploadPending$2.L$4 = objectRef;
            channelBatchUpdateManager$uploadPending$2.L$5 = objectRef2;
            channelBatchUpdateManager$uploadPending$2.label = 1;
            Object objUpdate = channelBatchUpdateApiClient.update(str, list2, list3, list4, list5, channelBatchUpdateManager$uploadPending$2);
            if (objUpdate == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef3 = objectRef4;
            list = updates;
            obj = objUpdate;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.ObjectRef objectRef6 = (Ref.ObjectRef) channelBatchUpdateManager$uploadPending$2.L$5;
            Ref.ObjectRef objectRef7 = (Ref.ObjectRef) channelBatchUpdateManager$uploadPending$2.L$4;
            objectRef3 = (Ref.ObjectRef) channelBatchUpdateManager$uploadPending$2.L$3;
            list = (List) channelBatchUpdateManager$uploadPending$2.L$2;
            String str2 = (String) channelBatchUpdateManager$uploadPending$2.L$1;
            ChannelBatchUpdateManager channelBatchUpdateManager = (ChannelBatchUpdateManager) channelBatchUpdateManager$uploadPending$2.L$0;
            ResultKt.throwOnFailure(obj);
            objectRef2 = objectRef6;
            objectRef = objectRef7;
            str = str2;
            this = channelBatchUpdateManager;
        }
        RequestResult requestResult = (RequestResult) obj;
        if (requestResult.isSuccessful() || requestResult.isClientError()) {
            if (requestResult.isSuccessful()) {
                this.audienceOverridesProvider.recordChannelUpdate$urbanairship_core_release(str, (List) objectRef3.element, (List) objectRef.element, (List) objectRef2.element);
            }
            this.popAudienceUpdates(list);
            return Boxing.boxBoolean(true);
        }
        return Boxing.boxBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addUpdate$urbanairship_core_release$default(ChannelBatchUpdateManager channelBatchUpdateManager, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            list2 = null;
        }
        if ((i & 4) != 0) {
            list3 = null;
        }
        if ((i & 8) != 0) {
            list4 = null;
        }
        channelBatchUpdateManager.addUpdate$urbanairship_core_release(list, list2, list3, list4);
    }

    public final void addUpdate$urbanairship_core_release(@Nullable List<? extends TagGroupsMutation> tags, @Nullable List<? extends AttributeMutation> attributes, @Nullable List<? extends SubscriptionListMutation> subscriptions, @Nullable List<? extends LiveUpdateMutation> liveUpdates) {
        if ((tags == null || tags.isEmpty()) && ((attributes == null || attributes.isEmpty()) && ((subscriptions == null || subscriptions.isEmpty()) && (liveUpdates == null || liveUpdates.isEmpty())))) {
            return;
        }
        AudienceUpdate audienceUpdate = new AudienceUpdate(tags, attributes, subscriptions, liveUpdates);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List mutableList = CollectionsKt.toMutableList((Collection) getUpdates());
            mutableList.add(audienceUpdate);
            setUpdates(mutableList);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void popAudienceUpdates(List updates) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            List mutableList = CollectionsKt.toMutableList((Collection) updates);
            Iterator it = updates.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(mutableList.get(0), (AudienceUpdate) it.next())) {
                    mutableList.remove(0);
                }
            }
            setUpdates(mutableList);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AudienceOverrides.Channel pendingOverrides() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (AudienceUpdate audienceUpdate : getUpdates()) {
            List tags = audienceUpdate.getTags();
            if (tags != null) {
                arrayList.addAll(tags);
            }
            List attributes = audienceUpdate.getAttributes();
            if (attributes != null) {
                arrayList2.addAll(attributes);
            }
            List subscriptions = audienceUpdate.getSubscriptions();
            if (subscriptions != null) {
                arrayList3.addAll(subscriptions);
            }
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
        return new AudienceOverrides.Channel(arrayList, arrayList2, arrayList3);
    }

    @VisibleForTesting
    public final void migrateData$urbanairship_core_release() {
        List listFlatten;
        List listFlatten2;
        JsonList list = this.dataStore.getJsonValue("com.urbanairship.push.ATTRIBUTE_DATA_STORE").getList();
        ArrayList arrayList = null;
        if (list != null) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<JsonValue> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(AttributeMutation.fromJsonList(it.next().optList()));
            }
            listFlatten = CollectionsKt.flatten(arrayList2);
        } else {
            listFlatten = null;
        }
        JsonList list2 = this.dataStore.getJsonValue("com.urbanairship.push.PENDING_SUBSCRIPTION_MUTATIONS").getList();
        if (list2 != null) {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<JsonValue> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(SubscriptionListMutation.fromJsonList(it2.next().optList()));
            }
            listFlatten2 = CollectionsKt.flatten(arrayList3);
        } else {
            listFlatten2 = null;
        }
        JsonList list3 = this.dataStore.getJsonValue("com.urbanairship.push.PENDING_TAG_GROUP_MUTATIONS").getList();
        if (list3 != null) {
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<JsonValue> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList.add(TagGroupsMutation.fromJsonValue(it3.next()));
            }
        }
        addUpdate$urbanairship_core_release$default(this, arrayList, listFlatten, listFlatten2, null, 8, null);
        this.dataStore.remove("com.urbanairship.push.ATTRIBUTE_DATA_STORE");
        this.dataStore.remove("com.urbanairship.push.PENDING_SUBSCRIPTION_MUTATIONS");
        this.dataStore.remove("com.urbanairship.push.PENDING_TAG_GROUP_MUTATIONS");
    }
}
