package com.urbanairship.iam.content;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.Thomas;
import com.urbanairship.android.layout.info.LayoutInfo;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\r\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\r\u0010\u0014\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/iam/content/AirshipLayout;", "Lcom/urbanairship/json/JsonSerializable;", "layoutInfo", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "(Lcom/urbanairship/android/layout/info/LayoutInfo;Lcom/urbanairship/json/JsonValue;)V", "getLayoutInfo", "()Lcom/urbanairship/android/layout/info/LayoutInfo;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "isEmbedded", "isEmbedded$urbanairship_automation_release", "toJsonValue", "toString", "", "validate", "validate$urbanairship_automation_release", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AirshipLayout implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonValue jsonValue;
    private final LayoutInfo layoutInfo;

    public /* synthetic */ AirshipLayout(LayoutInfo layoutInfo, JsonValue jsonValue, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutInfo, jsonValue);
    }

    private AirshipLayout(LayoutInfo layoutInfo, JsonValue jsonValue) {
        this.layoutInfo = layoutInfo;
        this.jsonValue = jsonValue;
    }

    @NotNull
    public final LayoutInfo getLayoutInfo() {
        return this.layoutInfo;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbanairship/iam/content/AirshipLayout$Companion;", "", "()V", "LAYOUT_KEY", "", "fromJson", "Lcom/urbanairship/iam/content/AirshipLayout;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final AirshipLayout fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonMap jsonMapRequireMap2 = jsonMapRequireMap.require("layout").requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap2, "requireMap(...)");
            return new AirshipLayout(new LayoutInfo(jsonMapRequireMap2), value, null);
        }
    }

    public final boolean validate$urbanairship_automation_release() {
        return Thomas.isValid(this.layoutInfo);
    }

    public final boolean isEmbedded$urbanairship_automation_release() {
        return this.layoutInfo.isEmbedded();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue, reason: from getter */
    public JsonValue getJsonValue() {
        return this.jsonValue;
    }

    @NotNull
    public String toString() {
        String string = getJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AirshipLayout.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.content.AirshipLayout");
        return Intrinsics.areEqual(this.jsonValue, ((AirshipLayout) other).jsonValue);
    }

    public int hashCode() {
        return this.layoutInfo.hashCode();
    }
}
