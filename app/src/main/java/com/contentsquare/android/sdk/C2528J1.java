package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.GzipUtil;
import com.contentsquare.proto.sessionreplay.p023v1.SessionRecordingV1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.J1 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nEventsToBatchProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventsToBatchProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/EventsToBatchProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2:69\n1855#2,2:70\n1856#2:72\n1855#2,2:73\n*S KotlinDebug\n*F\n+ 1 EventsToBatchProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/EventsToBatchProcessor\n*L\n53#1:69\n55#1:70,2\n53#1:72\n64#1:73,2\n*E\n"})
public final class C2528J1 {

    /* JADX INFO: renamed from: a */
    public final int f1737a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final SessionRecordingV1.EventPayload.Position f1738b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public C2458C1 f1739c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final LinkedHashSet f1740d;

    public C2528J1(SessionRecordingV1.EventPayload.Position position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.f1737a = 524288;
        this.f1738b = position;
        this.f1739c = new C2458C1(position);
        this.f1740d = new LinkedHashSet();
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m954a(@NotNull List<? extends AbstractC2777i6> srEvents) {
        Intrinsics.checkNotNullParameter(srEvents, "srEvents");
        for (AbstractC2777i6 event : srEvents) {
            C2458C1 c2458c1 = this.f1739c;
            c2458c1.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            SessionRecordingV1.Event baseEvent = event.getBaseEvent();
            c2458c1.f1456b.addEvents(baseEvent);
            c2458c1.f1457c += baseEvent.toByteArray().length;
            Iterator it = this.f1740d.iterator();
            while (it.hasNext()) {
                ((InterfaceC2468D1) it.next()).mo896a(event);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m952a() {
        this.f1739c = new C2458C1(this.f1738b);
        Iterator it = this.f1740d.iterator();
        while (it.hasNext()) {
            ((InterfaceC2468D1) it.next()).mo895a();
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final synchronized C2596Q m951a(@NotNull String url) {
        C2596Q c2596q;
        Intrinsics.checkNotNullParameter(url, "url");
        C2458C1 c2458c1 = this.f1739c;
        c2458c1.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        c2596q = new C2596Q(url, GzipUtil.INSTANCE.compress(c2458c1.m882a(), c2458c1.f1435a));
        c2458c1.f1435a.reset();
        return c2596q;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m953a(@NotNull InterfaceC2468D1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f1740d.add(listener);
    }
}
