package com.urbanairship.android.framework.proxy.events;

import ch.qos.logback.core.joran.action.Action;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.EventType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J(\u0010\u0018\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u001aJ\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/framework/proxy/events/EventEmitter;", "", "()V", "_pendingEventsUpdates", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/urbanairship/android/framework/proxy/Event;", "lock", "pendingEventListener", "Lkotlinx/coroutines/flow/SharedFlow;", "getPendingEventListener", "()Lkotlinx/coroutines/flow/SharedFlow;", "pendingEvents", "", Action.SCOPE_ATTRIBUTE, "Lkotlinx/coroutines/CoroutineScope;", "addEvent", "", "event", "replacePending", "", "hasEvents", "types", "", "Lcom/urbanairship/android/framework/proxy/EventType;", "processPending", "onProcess", "Lkotlin/Function1;", "takePending", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEventEmitter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventEmitter.kt\ncom/urbanairship/android/framework/proxy/events/EventEmitter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,98:1\n288#2,2:99\n*S KotlinDebug\n*F\n+ 1 EventEmitter.kt\ncom/urbanairship/android/framework/proxy/events/EventEmitter\n*L\n61#1:99,2\n*E\n"})
/* loaded from: classes2.dex */
public final class EventEmitter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final EventEmitter sharedInstance = new EventEmitter();
    private final MutableSharedFlow _pendingEventsUpdates;
    private final SharedFlow pendingEventListener;
    private final Object lock = new Object();
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    private final List pendingEvents = new ArrayList();

    @JvmStatic
    @NotNull
    public static final EventEmitter shared() {
        return INSTANCE.shared();
    }

    public EventEmitter() {
        MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._pendingEventsUpdates = mutableSharedFlowMutableSharedFlow$default;
        this.pendingEventListener = mutableSharedFlowMutableSharedFlow$default;
    }

    @NotNull
    public final SharedFlow<Event> getPendingEventListener() {
        return this.pendingEventListener;
    }

    public static /* synthetic */ void addEvent$default(EventEmitter eventEmitter, Event event, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        eventEmitter.addEvent(event, z);
    }

    public final void addEvent(@NotNull final Event event, boolean replacePending) {
        Intrinsics.checkNotNullParameter(event, "event");
        synchronized (this.lock) {
            if (replacePending) {
                try {
                    CollectionsKt.removeAll(this.pendingEvents, new Function1() { // from class: com.urbanairship.android.framework.proxy.events.EventEmitter$addEvent$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(Event it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return Boolean.valueOf(event.getType() == it.getType());
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.pendingEvents.add(event);
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new EventEmitter$addEvent$1$2(this, event, null), 3, null);
        }
    }

    @NotNull
    public final List<Event> takePending(@NotNull final List<? extends EventType> types) {
        final ArrayList arrayList;
        Intrinsics.checkNotNullParameter(types, "types");
        synchronized (this.lock) {
            arrayList = new ArrayList();
            CollectionsKt.removeAll(this.pendingEvents, new Function1() { // from class: com.urbanairship.android.framework.proxy.events.EventEmitter$takePending$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Event it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(types.contains(it.getType()) && arrayList.add(it));
                }
            });
        }
        return arrayList;
    }

    public final boolean hasEvents(@NotNull List<? extends EventType> types) {
        Object next;
        boolean z;
        Intrinsics.checkNotNullParameter(types, "types");
        synchronized (this.lock) {
            Iterator it = this.pendingEvents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (types.contains(((Event) next).getType())) {
                    break;
                }
            }
            z = next != null;
        }
        return z;
    }

    public final void processPending(@NotNull final List<? extends EventType> types, @NotNull final Function1<? super Event, Boolean> onProcess) {
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(onProcess, "onProcess");
        synchronized (this.lock) {
            CollectionsKt.removeAll(this.pendingEvents, new Function1() { // from class: com.urbanairship.android.framework.proxy.events.EventEmitter$processPending$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Event it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(!types.contains(it.getType()) ? false : ((Boolean) onProcess.invoke(it)).booleanValue());
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/framework/proxy/events/EventEmitter$Companion;", "", "()V", "sharedInstance", "Lcom/urbanairship/android/framework/proxy/events/EventEmitter;", "shared", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final EventEmitter shared() {
            return EventEmitter.sharedInstance;
        }
    }
}
