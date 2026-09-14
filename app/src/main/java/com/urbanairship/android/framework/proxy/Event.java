package com.urbanairship.android.framework.proxy;

import com.urbanairship.actions.RateAppAction;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/Event;", "", RateAppAction.BODY_KEY, "Lcom/urbanairship/json/JsonMap;", "getBody", "()Lcom/urbanairship/json/JsonMap;", "type", "Lcom/urbanairship/android/framework/proxy/EventType;", "getType", "()Lcom/urbanairship/android/framework/proxy/EventType;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface Event {
    @NotNull
    JsonMap getBody();

    @NotNull
    EventType getType();
}
