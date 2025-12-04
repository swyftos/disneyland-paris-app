package com.urbanairship.contacts;

import androidx.core.util.ObjectsCompat;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;", "Lcom/urbanairship/json/JsonSerializable;", "platformName", "", "identifiers", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getIdentifiers", "()Ljava/util/Map;", "getPlatformName", "()Ljava/lang/String;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OpenChannelRegistrationOptions implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Map identifiers;
    private final String platformName;

    public /* synthetic */ OpenChannelRegistrationOptions(String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final OpenChannelRegistrationOptions options(@NotNull String str) {
        return INSTANCE.options(str);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final OpenChannelRegistrationOptions options(@NotNull String str, @Nullable Map<String, String> map) {
        return INSTANCE.options(str, map);
    }

    private OpenChannelRegistrationOptions(String str, Map map) {
        this.platformName = str;
        this.identifiers = map;
    }

    @NotNull
    public final String getPlatformName() {
        return this.platformName;
    }

    @Nullable
    public final Map<String, String> getIdentifiers() {
        return this.identifiers;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().put("platform_name", this.platformName).putOpt("identifiers", this.identifiers).build().toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(OpenChannelRegistrationOptions.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.contacts.OpenChannelRegistrationOptions");
        OpenChannelRegistrationOptions openChannelRegistrationOptions = (OpenChannelRegistrationOptions) other;
        return Intrinsics.areEqual(this.platformName, openChannelRegistrationOptions.platformName) && Intrinsics.areEqual(this.identifiers, openChannelRegistrationOptions.identifiers);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.platformName, this.identifiers);
    }

    @NotNull
    public String toString() {
        return "OpenChannelRegistrationOptions(platformName='" + this.platformName + "', identifiers=" + this.identifiers + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ(\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/contacts/OpenChannelRegistrationOptions$Companion;", "", "()V", "IDENTIFIERS_KEY", "", "PLATFORM_NAME_KEY", "fromJson", "Lcom/urbanairship/contacts/OpenChannelRegistrationOptions;", "value", "Lcom/urbanairship/json/JsonValue;", "fromJson$urbanairship_core_release", "options", "platformName", "identifiers", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final OpenChannelRegistrationOptions options(@NotNull String platformName) {
            Intrinsics.checkNotNullParameter(platformName, "platformName");
            return options$default(this, platformName, null, 2, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OpenChannelRegistrationOptions options$default(Companion companion, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            return companion.options(str, map);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final OpenChannelRegistrationOptions options(@NotNull String platformName, @Nullable Map<String, String> identifiers) {
            Intrinsics.checkNotNullParameter(platformName, "platformName");
            return new OpenChannelRegistrationOptions(platformName, identifiers, null);
        }

        @NotNull
        public final OpenChannelRegistrationOptions fromJson$urbanairship_core_release(@NotNull JsonValue value) throws JsonException {
            HashMap map;
            Intrinsics.checkNotNullParameter(value, "value");
            String strRequireString = value.optMap().opt("platform_name").requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
            JsonMap map2 = value.optMap().opt("identifiers").getMap();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (map2 != null) {
                map = new HashMap();
                for (Map.Entry<String, JsonValue> entry : map2.entrySet()) {
                    Intrinsics.checkNotNull(entry);
                    String key = entry.getKey();
                    JsonValue value2 = entry.getValue();
                    Intrinsics.checkNotNull(key);
                    String strRequireString2 = value2.requireString();
                    Intrinsics.checkNotNullExpressionValue(strRequireString2, "requireString(...)");
                    map.put(key, strRequireString2);
                }
            } else {
                map = null;
            }
            return new OpenChannelRegistrationOptions(strRequireString, map, defaultConstructorMarker);
        }
    }
}
