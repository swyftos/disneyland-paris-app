package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.android.framework.proxy.AttributeOperation;
import com.urbanairship.android.framework.proxy.AttributeOperationKt;
import com.urbanairship.android.framework.proxy.SubscriptionListOperation;
import com.urbanairship.android.framework.proxy.SubscriptionOperationKt;
import com.urbanairship.android.framework.proxy.TagGroupOperation;
import com.urbanairship.android.framework.proxy.TagGroupOperationKt;
import com.urbanairship.android.framework.proxy.TagOperation;
import com.urbanairship.android.framework.proxy.TagOperationKt;
import com.urbanairship.channel.AirshipChannel;
import com.urbanairship.channel.AttributeEditor;
import com.urbanairship.channel.SubscriptionListEditor;
import com.urbanairship.channel.TagEditor;
import com.urbanairship.channel.TagGroupsEditor;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u000f\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u0011\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00120\rJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u0013\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00140\rJ\u0006\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/ChannelProxy;", "", "channelProvider", "Lkotlin/Function0;", "Lcom/urbanairship/channel/AirshipChannel;", "(Lkotlin/jvm/functions/Function0;)V", "addTag", "", "tag", "", "editAttributes", "operations", "Lcom/urbanairship/json/JsonValue;", "", "Lcom/urbanairship/android/framework/proxy/AttributeOperation;", "editSubscriptionLists", "Lcom/urbanairship/android/framework/proxy/SubscriptionListOperation;", "editTagGroups", "Lcom/urbanairship/android/framework/proxy/TagGroupOperation;", "editTags", "Lcom/urbanairship/android/framework/proxy/TagOperation;", "enableChannelCreation", "getChannelId", "getSubscriptionLists", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTags", "removeTag", "waitForChannelId", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannelProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/ChannelProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n1549#2:103\n1620#2,3:104\n1855#2,2:107\n1549#2:109\n1620#2,3:110\n1855#2,2:113\n1549#2:115\n1620#2,3:116\n1855#2,2:119\n1549#2:121\n1620#2,3:122\n1855#2,2:125\n*S KotlinDebug\n*F\n+ 1 ChannelProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/ChannelProxy\n*L\n35#1:103\n35#1:104,3\n43#1:107,2\n58#1:109\n58#1:110,3\n66#1:113,2\n73#1:115\n73#1:116,3\n81#1:119,2\n88#1:121\n88#1:122,3\n96#1:125,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ChannelProxy {
    private final Function0 channelProvider;

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.ChannelProxy$getSubscriptionLists$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelProxy.this.getSubscriptionLists(this);
        }
    }

    public ChannelProxy(@NotNull Function0<? extends AirshipChannel> channelProvider) {
        Intrinsics.checkNotNullParameter(channelProvider, "channelProvider");
        this.channelProvider = channelProvider;
    }

    public final void enableChannelCreation() {
        ((AirshipChannel) this.channelProvider.invoke()).enableChannelCreation();
    }

    @Nullable
    public final String getChannelId() {
        return ((AirshipChannel) this.channelProvider.invoke()).getId();
    }

    @Nullable
    public final Object waitForChannelId(@NotNull Continuation<? super String> continuation) {
        return FlowKt.first(FlowKt.filterNotNull(((AirshipChannel) this.channelProvider.invoke()).getChannelIdFlow()), continuation);
    }

    public final void addTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ((AirshipChannel) this.channelProvider.invoke()).editTags().addTag(tag).apply();
    }

    public final void removeTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        ((AirshipChannel) this.channelProvider.invoke()).editTags().removeTag(tag).apply();
    }

    public final void editTags(@NotNull JsonValue operations) throws JsonException {
        Intrinsics.checkNotNullParameter(operations, "operations");
        JsonList jsonListRequireList = operations.requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        Iterator<JsonValue> it = jsonListRequireList.iterator();
        while (it.hasNext()) {
            JsonMap jsonMapRequireMap = it.next().requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            arrayList.add(new TagOperation(jsonMapRequireMap));
        }
        editTags(arrayList);
    }

    public final void editTags(@NotNull List<TagOperation> operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        TagEditor tagEditorEditTags = ((AirshipChannel) this.channelProvider.invoke()).editTags();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            TagOperationKt.applyOperation((TagOperation) it.next(), tagEditorEditTags);
        }
        tagEditorEditTags.apply();
    }

    @NotNull
    public final Set<String> getTags() {
        return ((AirshipChannel) this.channelProvider.invoke()).getTags();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getSubscriptionLists(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Set<java.lang.String>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.android.framework.proxy.proxies.ChannelProxy.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.android.framework.proxy.proxies.ChannelProxy$getSubscriptionLists$1 r0 = (com.urbanairship.android.framework.proxy.proxies.ChannelProxy.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.ChannelProxy$getSubscriptionLists$1 r0 = new com.urbanairship.android.framework.proxy.proxies.ChannelProxy$getSubscriptionLists$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r4 = r5.getValue()
            goto L4b
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.jvm.functions.Function0 r4 = r4.channelProvider
            java.lang.Object r4 = r4.invoke()
            com.urbanairship.channel.AirshipChannel r4 = (com.urbanairship.channel.AirshipChannel) r4
            r0.label = r3
            java.lang.Object r4 = r4.m2829fetchSubscriptionListsIoAF18A(r0)
            if (r4 != r1) goto L4b
            return r1
        L4b:
            kotlin.ResultKt.throwOnFailure(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.ChannelProxy.getSubscriptionLists(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void editSubscriptionLists(@NotNull JsonValue operations) throws JsonException {
        Intrinsics.checkNotNullParameter(operations, "operations");
        JsonList jsonListRequireList = operations.requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        Iterator<JsonValue> it = jsonListRequireList.iterator();
        while (it.hasNext()) {
            JsonMap jsonMapRequireMap = it.next().requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            arrayList.add(new SubscriptionListOperation(jsonMapRequireMap));
        }
        editSubscriptionLists(arrayList);
    }

    public final void editSubscriptionLists(@NotNull List<SubscriptionListOperation> operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        SubscriptionListEditor subscriptionListEditorEditSubscriptionLists = ((AirshipChannel) this.channelProvider.invoke()).editSubscriptionLists();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            SubscriptionOperationKt.applyOperation((SubscriptionListOperation) it.next(), subscriptionListEditorEditSubscriptionLists);
        }
        subscriptionListEditorEditSubscriptionLists.apply();
    }

    public final void editTagGroups(@NotNull JsonValue operations) throws JsonException {
        Intrinsics.checkNotNullParameter(operations, "operations");
        JsonList jsonListRequireList = operations.requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        Iterator<JsonValue> it = jsonListRequireList.iterator();
        while (it.hasNext()) {
            JsonMap jsonMapRequireMap = it.next().requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            arrayList.add(new TagGroupOperation(jsonMapRequireMap));
        }
        editTagGroups(arrayList);
    }

    public final void editTagGroups(@NotNull List<TagGroupOperation> operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        TagGroupsEditor tagGroupsEditorEditTagGroups = ((AirshipChannel) this.channelProvider.invoke()).editTagGroups();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            TagGroupOperationKt.applyOperation((TagGroupOperation) it.next(), tagGroupsEditorEditTagGroups);
        }
        tagGroupsEditorEditTagGroups.apply();
    }

    public final void editAttributes(@NotNull JsonValue operations) throws IllegalArgumentException, JsonException {
        Intrinsics.checkNotNullParameter(operations, "operations");
        JsonList jsonListRequireList = operations.requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        Iterator<JsonValue> it = jsonListRequireList.iterator();
        while (it.hasNext()) {
            JsonMap jsonMapRequireMap = it.next().requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            arrayList.add(new AttributeOperation(jsonMapRequireMap));
        }
        editAttributes(arrayList);
    }

    public final void editAttributes(@NotNull List<AttributeOperation> operations) throws IllegalArgumentException, JsonException {
        Intrinsics.checkNotNullParameter(operations, "operations");
        AttributeEditor attributeEditorEditAttributes = ((AirshipChannel) this.channelProvider.invoke()).editAttributes();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            AttributeOperationKt.applyOperation((AttributeOperation) it.next(), attributeEditorEditAttributes);
        }
        attributeEditorEditAttributes.apply();
    }
}
