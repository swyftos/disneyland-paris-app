package com.urbanairship.iam.analytics;

import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1836d2 = {"Lcom/urbanairship/iam/analytics/InAppEventSource;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "AIRSHIP", "APP_DEFINED", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum InAppEventSource implements JsonSerializable {
    AIRSHIP("urban-airship"),
    APP_DEFINED("app-defined");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String json;

    @NotNull
    public static EnumEntries<InAppEventSource> getEntries() {
        return $ENTRIES;
    }

    InAppEventSource(String str) {
        this.json = str;
    }

    @NotNull
    public final String getJson() {
        return this.json;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValueWrap = JsonValue.wrap(this.json);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
        return jsonValueWrap;
    }
}
