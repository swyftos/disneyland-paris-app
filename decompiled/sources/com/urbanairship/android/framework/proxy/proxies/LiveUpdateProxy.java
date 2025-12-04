package com.urbanairship.android.framework.proxy.proxies;

import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.liveupdate.LiveUpdate;
import com.urbanairship.util.DateUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateProxy;", "Lcom/urbanairship/json/JsonSerializable;", "liveUpdate", "Lcom/urbanairship/liveupdate/LiveUpdate;", "(Lcom/urbanairship/liveupdate/LiveUpdate;)V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,173:1\n1#2:174\n*E\n"})
/* loaded from: classes2.dex */
public final class LiveUpdateProxy implements JsonSerializable {
    private final LiveUpdate liveUpdate;

    public LiveUpdateProxy(@NotNull LiveUpdate liveUpdate) {
        Intrinsics.checkNotNullParameter(liveUpdate, "liveUpdate");
        this.liveUpdate = liveUpdate;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        Pair pair = TuplesKt.to("name", this.liveUpdate.getName());
        Pair pair2 = TuplesKt.to("type", this.liveUpdate.getType());
        Pair pair3 = TuplesKt.to("content", this.liveUpdate.getContent());
        Pair pair4 = TuplesKt.to("lastContentUpdateTimestamp", DateUtils.createIso8601TimeStamp(this.liveUpdate.getLastContentUpdateTime()));
        Pair pair5 = TuplesKt.to("lastStateChangeTimestamp", DateUtils.createIso8601TimeStamp(this.liveUpdate.getLastStateChangeTime()));
        Long dismissalTime = this.liveUpdate.getDismissalTime();
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pair, pair2, pair3, pair4, pair5, TuplesKt.to("dismissTimestamp", dismissalTime != null ? DateUtils.createIso8601TimeStamp(dismissalTime.longValue()) : null)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
