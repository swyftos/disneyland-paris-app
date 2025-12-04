package com.urbanairship.reactnative;

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

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/reactnative/PendingEmbeddedUpdated;", "Lcom/urbanairship/android/framework/proxy/Event;", ETCPurchaseStatus.PENDING, "", "Lcom/urbanairship/embedded/AirshipEmbeddedInfo;", "<init>", "(Ljava/util/List;)V", "type", "Lcom/urbanairship/android/framework/proxy/EventType;", "getType", "()Lcom/urbanairship/android/framework/proxy/EventType;", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "getBody", "()Lcom/urbanairship/json/JsonMap;", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactAutopilot.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactAutopilot.kt\ncom/urbanairship/reactnative/PendingEmbeddedUpdated\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1557#2:92\n1628#2,3:93\n*S KotlinDebug\n*F\n+ 1 ReactAutopilot.kt\ncom/urbanairship/reactnative/PendingEmbeddedUpdated\n*L\n87#1:92\n87#1:93,3\n*E\n"})
/* loaded from: classes5.dex */
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
