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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateProxy;", "Lcom/urbanairship/json/JsonSerializable;", "liveUpdate", "Lcom/urbanairship/liveupdate/LiveUpdate;", "(Lcom/urbanairship/liveupdate/LiveUpdate;)V", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,173:1\n1#2:174\n*E\n"})
public final class LiveUpdateProxy implements JsonSerializable {
    private final LiveUpdate liveUpdate;

    public LiveUpdateProxy(@NotNull LiveUpdate liveUpdate) {
        Intrinsics.checkNotNullParameter(liveUpdate, "liveUpdate");
        this.liveUpdate = liveUpdate;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        Pair pairM1842to = TuplesKt.m1842to("name", this.liveUpdate.getName());
        Pair pairM1842to2 = TuplesKt.m1842to("type", this.liveUpdate.getType());
        Pair pairM1842to3 = TuplesKt.m1842to("content", this.liveUpdate.getContent());
        Pair pairM1842to4 = TuplesKt.m1842to("lastContentUpdateTimestamp", DateUtils.createIso8601TimeStamp(this.liveUpdate.getLastContentUpdateTime()));
        Pair pairM1842to5 = TuplesKt.m1842to("lastStateChangeTimestamp", DateUtils.createIso8601TimeStamp(this.liveUpdate.getLastStateChangeTime()));
        Long dismissalTime = this.liveUpdate.getDismissalTime();
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(pairM1842to, pairM1842to2, pairM1842to3, pairM1842to4, pairM1842to5, TuplesKt.m1842to("dismissTimestamp", dismissalTime != null ? DateUtils.createIso8601TimeStamp(dismissalTime.longValue()) : null)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
