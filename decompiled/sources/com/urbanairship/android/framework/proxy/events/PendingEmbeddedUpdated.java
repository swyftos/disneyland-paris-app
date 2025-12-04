package com.urbanairship.android.framework.proxy.events;

import com.tagcommander.lib.serverside.ETCPurchaseStatus;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.embedded.AirshipEmbeddedInfo;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/android/framework/proxy/events/PendingEmbeddedUpdated;", "Lcom/urbanairship/android/framework/proxy/Event;", ETCPurchaseStatus.PENDING, "", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "(Ljava/util/List;)V", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "getBody", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/framework/proxy/EventType;", "getType", "()Lcom/urbanairship/android/framework/proxy/EventType;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPendingEmbeddedUpdated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PendingEmbeddedUpdated.kt\ncom/urbanairship/android/framework/proxy/events/PendingEmbeddedUpdated\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,18:1\n1549#2:19\n1620#2,3:20\n*S KotlinDebug\n*F\n+ 1 PendingEmbeddedUpdated.kt\ncom/urbanairship/android/framework/proxy/events/PendingEmbeddedUpdated\n*L\n15#1:19\n15#1:20,3\n*E\n"})
/* loaded from: classes2.dex */
public final class PendingEmbeddedUpdated implements Event {
    private final JsonMap body;
    private final EventType type;

    public PendingEmbeddedUpdated(@NotNull List<AirshipEmbeddedInfo> pending) {
        Intrinsics.checkNotNullParameter(pending, "pending");
        this.type = EventType.PENDING_EMBEDDED_UPDATED;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pending, 10));
        Iterator<T> it = pending.iterator();
        while (it.hasNext()) {
            arrayList.add(JsonExtensionsKt.jsonMapOf(TuplesKt.to("embeddedId", ((AirshipEmbeddedInfo) it.next()).getEmbeddedId())));
        }
        this.body = JsonExtensionsKt.jsonMapOf(TuplesKt.to(ETCPurchaseStatus.PENDING, arrayList));
    }

    @Override // com.urbanairship.android.framework.proxy.Event
    @NotNull
    public EventType getType() {
        return this.type;
    }

    @Override // com.urbanairship.android.framework.proxy.Event
    @NotNull
    public JsonMap getBody() {
        return this.body;
    }
}
