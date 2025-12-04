package com.urbanairship.android.framework.proxy.proxies;

import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest;
import com.urbanairship.json.JsonMap;
import com.urbanairship.liveupdate.LiveUpdateManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0018R\u0014\u0010\u0006\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy;", "", "managerProvider", "Lkotlin/Function0;", "Lcom/urbanairship/liveupdate/LiveUpdateManager;", "(Lkotlin/jvm/functions/Function0;)V", "manager", "getManager", "()Lcom/urbanairship/liveupdate/LiveUpdateManager;", "clearAll", "", ViewProps.END, "request", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "list", "", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateProxy;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "(Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ViewProps.START, "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "update", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,173:1\n766#2:174\n857#2,2:175\n1549#2:177\n1620#2,3:178\n1549#2:181\n1620#2,3:182\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy\n*L\n22#1:174\n22#1:175,2\n22#1:177\n22#1:178,3\n26#1:181\n26#1:182,3\n*E\n"})
/* loaded from: classes2.dex */
public final class LiveUpdatesManagerProxy {
    private final Function0 managerProvider;

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$list$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdatesManagerProxy.this.list(null, this);
        }
    }

    /* renamed from: com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$listAll$1, reason: invalid class name and case insensitive filesystem */
    static final class C09141 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C09141(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdatesManagerProxy.this.listAll(this);
        }
    }

    public LiveUpdatesManagerProxy(@NotNull Function0<LiveUpdateManager> managerProvider) {
        Intrinsics.checkNotNullParameter(managerProvider, "managerProvider");
        this.managerProvider = managerProvider;
    }

    private final LiveUpdateManager getManager() {
        return (LiveUpdateManager) this.managerProvider.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object list(@org.jetbrains.annotations.NotNull com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest.List r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.android.framework.proxy.proxies.LiveUpdateProxy>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$list$1 r0 = (com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$list$1 r0 = new com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$list$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r5 = r4
            com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest$List r5 = (com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest.List) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L48
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            com.urbanairship.liveupdate.LiveUpdateManager r4 = r4.getManager()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.getAllActiveUpdates(r0)
            if (r6 != r1) goto L48
            return r1
        L48:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r6 = r6.iterator()
        L53:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L72
            java.lang.Object r0 = r6.next()
            r1 = r0
            com.urbanairship.liveupdate.LiveUpdate r1 = (com.urbanairship.liveupdate.LiveUpdate) r1
            java.lang.String r1 = r1.getType()
            java.lang.String r2 = r5.getType()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L53
            r4.add(r0)
            goto L53
        L72:
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r6)
            r5.<init>(r6)
            java.util.Iterator r4 = r4.iterator()
        L81:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L96
            java.lang.Object r6 = r4.next()
            com.urbanairship.liveupdate.LiveUpdate r6 = (com.urbanairship.liveupdate.LiveUpdate) r6
            com.urbanairship.android.framework.proxy.proxies.LiveUpdateProxy r0 = new com.urbanairship.android.framework.proxy.proxies.LiveUpdateProxy
            r0.<init>(r6)
            r5.add(r0)
            goto L81
        L96:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy.list(com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest$List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object listAll(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.urbanairship.android.framework.proxy.proxies.LiveUpdateProxy>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy.C09141
            if (r0 == 0) goto L13
            r0 = r5
            com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$listAll$1 r0 = (com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy.C09141) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$listAll$1 r0 = new com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$listAll$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r5)
            com.urbanairship.liveupdate.LiveUpdateManager r4 = r4.getManager()
            r0.label = r3
            java.lang.Object r5 = r4.getAllActiveUpdates(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r5, r0)
            r4.<init>(r0)
            java.util.Iterator r5 = r5.iterator()
        L52:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r5.next()
            com.urbanairship.liveupdate.LiveUpdate r0 = (com.urbanairship.liveupdate.LiveUpdate) r0
            com.urbanairship.android.framework.proxy.proxies.LiveUpdateProxy r1 = new com.urbanairship.android.framework.proxy.proxies.LiveUpdateProxy
            r1.<init>(r0)
            r4.add(r1)
            goto L52
        L67:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy.listAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void start(@NotNull LiveUpdateRequest.Start request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LiveUpdateManager manager = getManager();
        String name = request.getName();
        String type = request.getType();
        JsonMap content = request.getContent();
        Long timestamp = request.getTimestamp();
        manager.start(name, type, content, timestamp != null ? timestamp.longValue() : System.currentTimeMillis(), request.getDismissalTimestamp());
    }

    public final void update(@NotNull LiveUpdateRequest.Update request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LiveUpdateManager manager = getManager();
        String name = request.getName();
        JsonMap content = request.getContent();
        Long timestamp = request.getTimestamp();
        manager.update(name, content, timestamp != null ? timestamp.longValue() : System.currentTimeMillis(), request.getDismissalTimestamp());
    }

    public final void end(@NotNull LiveUpdateRequest.End request) {
        Intrinsics.checkNotNullParameter(request, "request");
        LiveUpdateManager manager = getManager();
        String name = request.getName();
        JsonMap content = request.getContent();
        Long timestamp = request.getTimestamp();
        manager.end(name, content, timestamp != null ? timestamp.longValue() : System.currentTimeMillis(), request.getDismissalTimestamp());
    }

    public final void clearAll() {
        getManager().clearAll();
    }
}
