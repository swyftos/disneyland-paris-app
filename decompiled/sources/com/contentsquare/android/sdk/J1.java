package com.contentsquare.android.sdk;

import com.contentsquare.android.core.utils.GzipUtil;
import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nEventsToBatchProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventsToBatchProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/EventsToBatchProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,68:1\n1855#2:69\n1855#2,2:70\n1856#2:72\n1855#2,2:73\n*S KotlinDebug\n*F\n+ 1 EventsToBatchProcessor.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/batch/EventsToBatchProcessor\n*L\n53#1:69\n55#1:70,2\n53#1:72\n64#1:73,2\n*E\n"})
/* loaded from: classes2.dex */
public final class J1 {
    public final int a;

    @NotNull
    public final SessionRecordingV1.EventPayload.Position b;

    @NotNull
    public C1 c;

    @NotNull
    public final LinkedHashSet d;

    public J1(SessionRecordingV1.EventPayload.Position position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.a = 524288;
        this.b = position;
        this.c = new C1(position);
        this.d = new LinkedHashSet();
    }

    public final synchronized void a(@NotNull List<? extends AbstractC0707i6> srEvents) {
        Intrinsics.checkNotNullParameter(srEvents, "srEvents");
        for (AbstractC0707i6 event : srEvents) {
            C1 c1 = this.c;
            c1.getClass();
            Intrinsics.checkNotNullParameter(event, "event");
            SessionRecordingV1.Event baseEvent = event.getBaseEvent();
            c1.b.addEvents(baseEvent);
            c1.c += baseEvent.toByteArray().length;
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((D1) it.next()).a(event);
            }
        }
    }

    public final synchronized void a() {
        this.c = new C1(this.b);
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((D1) it.next()).a();
        }
    }

    @NotNull
    public final synchronized Q a(@NotNull String url) {
        Q q;
        Intrinsics.checkNotNullParameter(url, "url");
        C1 c1 = this.c;
        c1.getClass();
        Intrinsics.checkNotNullParameter(url, "url");
        q = new Q(url, GzipUtil.INSTANCE.compress(c1.a(), c1.a));
        c1.a.reset();
        return q;
    }

    public final synchronized void a(@NotNull D1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.d.add(listener);
    }
}
