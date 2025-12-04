package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.android.framework.proxy.AttributeOperation;
import com.urbanairship.android.framework.proxy.AttributeOperationKt;
import com.urbanairship.android.framework.proxy.ScopedSubscriptionListOperation;
import com.urbanairship.android.framework.proxy.ScopedSubscriptionOperationKt;
import com.urbanairship.android.framework.proxy.TagGroupOperation;
import com.urbanairship.android.framework.proxy.TagGroupOperationKt;
import com.urbanairship.channel.AttributeEditor;
import com.urbanairship.channel.TagGroupsEditor;
import com.urbanairship.contacts.Contact;
import com.urbanairship.contacts.ScopedSubscriptionListEditor;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\r0\nJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u000e\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000f0\nJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/ContactProxy;", "", "contactProvider", "Lkotlin/Function0;", "Lcom/urbanairship/contacts/Contact;", "(Lkotlin/jvm/functions/Function0;)V", "editAttributes", "", "operations", "Lcom/urbanairship/json/JsonValue;", "", "Lcom/urbanairship/android/framework/proxy/AttributeOperation;", "editSubscriptionLists", "Lcom/urbanairship/android/framework/proxy/ScopedSubscriptionListOperation;", "editTagGroups", "Lcom/urbanairship/android/framework/proxy/TagGroupOperation;", "getNamedUserId", "", "getSubscriptionLists", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identify", "namedUser", "notifyRemoteLogin", "reset", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nContactProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/ContactProxy\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,82:1\n453#2:83\n403#2:84\n1238#3,2:85\n1549#3:87\n1620#3,3:88\n1241#3:91\n1549#3:92\n1620#3,3:93\n1855#3,2:96\n1549#3:98\n1620#3,3:99\n1855#3,2:102\n1549#3:104\n1620#3,3:105\n1855#3,2:108\n*S KotlinDebug\n*F\n+ 1 ContactProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/ContactProxy\n*L\n28#1:83\n28#1:84\n28#1:85,2\n29#1:87\n29#1:88,3\n28#1:91\n38#1:92\n38#1:93,3\n46#1:96,2\n53#1:98\n53#1:99,3\n61#1:102,2\n68#1:104\n68#1:105,3\n76#1:108,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ContactProxy {
    private final Function0 contactProvider;

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.ContactProxy$getSubscriptionLists$1, reason: invalid class name */
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
            return ContactProxy.this.getSubscriptionLists(this);
        }
    }

    public ContactProxy(@NotNull Function0<? extends Contact> contactProvider) {
        Intrinsics.checkNotNullParameter(contactProvider, "contactProvider");
        this.contactProvider = contactProvider;
    }

    public final void identify(@Nullable String namedUser) {
        if (namedUser == null || StringsKt.isBlank(namedUser)) {
            ((Contact) this.contactProvider.invoke()).reset();
        } else {
            ((Contact) this.contactProvider.invoke()).identify(namedUser);
        }
    }

    public final void reset() {
        ((Contact) this.contactProvider.invoke()).reset();
    }

    @Nullable
    public final String getNamedUserId() {
        return ((Contact) this.contactProvider.invoke()).getNamedUserId();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getSubscriptionLists(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.urbanairship.android.framework.proxy.proxies.ContactProxy.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.android.framework.proxy.proxies.ContactProxy$getSubscriptionLists$1 r0 = (com.urbanairship.android.framework.proxy.proxies.ContactProxy.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.ContactProxy$getSubscriptionLists$1 r0 = new com.urbanairship.android.framework.proxy.proxies.ContactProxy$getSubscriptionLists$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L4b
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.jvm.functions.Function0 r5 = r5.contactProvider
            java.lang.Object r5 = r5.invoke()
            com.urbanairship.contacts.Contact r5 = (com.urbanairship.contacts.Contact) r5
            r0.label = r3
            java.lang.Object r5 = r5.m2840fetchSubscriptionListsIoAF18A(r0)
            if (r5 != r1) goto L4b
            return r1
        L4b:
            kotlin.ResultKt.throwOnFailure(r5)
            java.util.Map r5 = (java.util.Map) r5
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            int r0 = r5.size()
            int r0 = kotlin.collections.MapsKt.mapCapacity(r0)
            r6.<init>(r0)
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L65:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto La7
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.Object r0 = r0.getValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            r2.<init>(r3)
            java.util.Iterator r0 = r0.iterator()
        L8a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto La3
            java.lang.Object r3 = r0.next()
            com.urbanairship.contacts.Scope r3 = (com.urbanairship.contacts.Scope) r3
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.add(r3)
            goto L8a
        La3:
            r6.put(r1, r2)
            goto L65
        La7:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.ContactProxy.getSubscriptionLists(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void notifyRemoteLogin() {
        ((Contact) this.contactProvider.invoke()).notifyRemoteLogin();
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
            arrayList.add(new ScopedSubscriptionListOperation(jsonMapRequireMap));
        }
        editSubscriptionLists(arrayList);
    }

    public final void editSubscriptionLists(@NotNull List<ScopedSubscriptionListOperation> operations) {
        Intrinsics.checkNotNullParameter(operations, "operations");
        ScopedSubscriptionListEditor scopedSubscriptionListEditorEditSubscriptionLists = ((Contact) this.contactProvider.invoke()).editSubscriptionLists();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            ScopedSubscriptionOperationKt.applyOperation((ScopedSubscriptionListOperation) it.next(), scopedSubscriptionListEditorEditSubscriptionLists);
        }
        scopedSubscriptionListEditorEditSubscriptionLists.apply();
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
        TagGroupsEditor tagGroupsEditorEditTagGroups = ((Contact) this.contactProvider.invoke()).editTagGroups();
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
        AttributeEditor attributeEditorEditAttributes = ((Contact) this.contactProvider.invoke()).editAttributes();
        Iterator<T> it = operations.iterator();
        while (it.hasNext()) {
            AttributeOperationKt.applyOperation((AttributeOperation) it.next(), attributeEditorEditAttributes);
        }
        attributeEditorEditAttributes.apply();
    }
}
