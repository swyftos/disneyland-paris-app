package com.urbanairship.iam.analytics;

import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventSource;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "AIRSHIP", "APP_DEFINED", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppEventSource implements JsonSerializable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InAppEventSource[] $VALUES;
    public static final InAppEventSource AIRSHIP = new InAppEventSource("AIRSHIP", 0, "urban-airship");
    public static final InAppEventSource APP_DEFINED = new InAppEventSource("APP_DEFINED", 1, "app-defined");
    private final String json;

    private static final /* synthetic */ InAppEventSource[] $values() {
        return new InAppEventSource[]{AIRSHIP, APP_DEFINED};
    }

    @NotNull
    public static EnumEntries<InAppEventSource> getEntries() {
        return $ENTRIES;
    }

    public static InAppEventSource valueOf(String str) {
        return (InAppEventSource) Enum.valueOf(InAppEventSource.class, str);
    }

    public static InAppEventSource[] values() {
        return (InAppEventSource[]) $VALUES.clone();
    }

    private InAppEventSource(String str, int i, String str2) {
        this.json = str2;
    }

    @NotNull
    public final String getJson() {
        return this.json;
    }

    static {
        InAppEventSource[] inAppEventSourceArr$values = $values();
        $VALUES = inAppEventSourceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(inAppEventSourceArr$values);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValueWrap = JsonValue.wrap(this.json);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
        return jsonValueWrap;
    }
}
