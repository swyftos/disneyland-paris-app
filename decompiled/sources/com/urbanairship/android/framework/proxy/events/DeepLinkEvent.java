package com.urbanairship.android.framework.proxy.events;

import com.urbanairship.actions.RateAppAction;
import com.urbanairship.android.framework.proxy.Event;
import com.urbanairship.android.framework.proxy.EventType;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbanairship/android/framework/proxy/events/DeepLinkEvent;", "Lcom/urbanairship/android/framework/proxy/Event;", "deepLink", "", "(Ljava/lang/String;)V", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "getBody", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/framework/proxy/EventType;", "getType", "()Lcom/urbanairship/android/framework/proxy/EventType;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeepLinkEvent implements Event {
    private final JsonMap body;
    private final EventType type;

    public DeepLinkEvent(@NotNull String deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.type = EventType.DEEP_LINK_RECEIVED;
        this.body = JsonExtensionsKt.jsonMapOf(TuplesKt.to("deepLink", deepLink));
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
