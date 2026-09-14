package com.urbanairship.android.framework.proxy.proxies;

import com.facebook.react.uimanager.ViewProps;
import com.urbanairship.json.JsonMap;
import com.urbanairship.liveupdate.LiveUpdate;
import com.urbanairship.liveupdate.LiveUpdateManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0018R\u0014\u0010\u0006\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy;", "", "managerProvider", "Lkotlin/Function0;", "Lcom/urbanairship/liveupdate/LiveUpdateManager;", "(Lkotlin/jvm/functions/Function0;)V", "manager", "getManager", "()Lcom/urbanairship/liveupdate/LiveUpdateManager;", "clearAll", "", ViewProps.END, "request", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "list", "", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateProxy;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "(Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ViewProps.START, "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "update", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,173:1\n766#2:174\n857#2,2:175\n1549#2:177\n1620#2,3:178\n1549#2:181\n1620#2,3:182\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdatesManagerProxy\n*L\n22#1:174\n22#1:175,2\n22#1:177\n22#1:178,3\n26#1:181\n26#1:182,3\n*E\n"})
public final class LiveUpdatesManagerProxy {
    private final Function0 managerProvider;

    /* JADX INFO: renamed from: com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$list$1 */
    static final class C46951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C46951(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LiveUpdatesManagerProxy.this.list(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbanairship.android.framework.proxy.proxies.LiveUpdatesManagerProxy$listAll$1 */
    static final class C46961 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C46961(Continuation continuation) {
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

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object list(@NotNull LiveUpdateRequest.List list, @NotNull Continuation<? super List<LiveUpdateProxy>> continuation) {
        C46951 c46951;
        if (continuation instanceof C46951) {
            c46951 = (C46951) continuation;
            int i = c46951.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c46951.label = i - Integer.MIN_VALUE;
            } else {
                c46951 = new C46951(continuation);
            }
        } else {
            c46951 = new C46951(continuation);
        }
        Object allActiveUpdates = c46951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c46951.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(allActiveUpdates);
            LiveUpdateManager manager = getManager();
            c46951.L$0 = list;
            c46951.label = 1;
            allActiveUpdates = manager.getAllActiveUpdates(c46951);
            if (allActiveUpdates == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (LiveUpdateRequest.List) c46951.L$0;
            ResultKt.throwOnFailure(allActiveUpdates);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) allActiveUpdates) {
            if (Intrinsics.areEqual(((LiveUpdate) obj).getType(), list.getType())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new LiveUpdateProxy((LiveUpdate) it.next()));
        }
        return arrayList2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object listAll(@NotNull Continuation<? super List<LiveUpdateProxy>> continuation) {
        C46961 c46961;
        if (continuation instanceof C46961) {
            c46961 = (C46961) continuation;
            int i = c46961.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c46961.label = i - Integer.MIN_VALUE;
            } else {
                c46961 = new C46961(continuation);
            }
        } else {
            c46961 = new C46961(continuation);
        }
        Object allActiveUpdates = c46961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c46961.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(allActiveUpdates);
            LiveUpdateManager manager = getManager();
            c46961.label = 1;
            allActiveUpdates = manager.getAllActiveUpdates(c46961);
            if (allActiveUpdates == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(allActiveUpdates);
        }
        Iterable iterable = (Iterable) allActiveUpdates;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new LiveUpdateProxy((LiveUpdate) it.next()));
        }
        return arrayList;
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
