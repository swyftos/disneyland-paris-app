package com.urbanairship.remoteconfig;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "Lcom/urbanairship/json/JsonSerializable;", "isEnabled", "", "context", "Lcom/urbanairship/json/JsonValue;", "url", "", "(ZLcom/urbanairship/json/JsonValue;Ljava/lang/String;)V", "getContext", "()Lcom/urbanairship/json/JsonValue;", "()Z", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class AdditionalAudienceCheckConfig implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final JsonValue context;
    private final boolean isEnabled;
    private final String url;

    public static /* synthetic */ AdditionalAudienceCheckConfig copy$default(AdditionalAudienceCheckConfig additionalAudienceCheckConfig, boolean z, JsonValue jsonValue, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = additionalAudienceCheckConfig.isEnabled;
        }
        if ((i & 2) != 0) {
            jsonValue = additionalAudienceCheckConfig.context;
        }
        if ((i & 4) != 0) {
            str = additionalAudienceCheckConfig.url;
        }
        return additionalAudienceCheckConfig.copy(z, jsonValue, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final JsonValue getContext() {
        return this.context;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final AdditionalAudienceCheckConfig copy(boolean isEnabled, @Nullable JsonValue context, @Nullable String url) {
        return new AdditionalAudienceCheckConfig(isEnabled, context, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdditionalAudienceCheckConfig)) {
            return false;
        }
        AdditionalAudienceCheckConfig additionalAudienceCheckConfig = (AdditionalAudienceCheckConfig) other;
        return this.isEnabled == additionalAudienceCheckConfig.isEnabled && Intrinsics.areEqual(this.context, additionalAudienceCheckConfig.context) && Intrinsics.areEqual(this.url, additionalAudienceCheckConfig.url);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isEnabled) * 31;
        JsonValue jsonValue = this.context;
        int iHashCode2 = (iHashCode + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        String str = this.url;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AdditionalAudienceCheckConfig(isEnabled=" + this.isEnabled + ", context=" + this.context + ", url=" + this.url + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public AdditionalAudienceCheckConfig(boolean z, @Nullable JsonValue jsonValue, @Nullable String str) {
        this.isEnabled = z;
        this.context = jsonValue;
        this.url = str;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @Nullable
    public final JsonValue getContext() {
        return this.context;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig$Companion;", "", "()V", "CONTEXT", "", "IS_ENABLED", "URL", "fromJson", "Lcom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nRemoteConfig.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,283:1\n44#2,15:284\n79#2,16:299\n*S KotlinDebug\n*F\n+ 1 RemoteConfig.kt\ncom/urbanairship/remoteconfig/AdditionalAudienceCheckConfig$Companion\n*L\n270#1:284,15\n272#1:299,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:61:0x017b  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.remoteconfig.AdditionalAudienceCheckConfig fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r20) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 782
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.remoteconfig.AdditionalAudienceCheckConfig.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.remoteconfig.AdditionalAudienceCheckConfig");
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("enabled", Boolean.valueOf(this.isEnabled)), TuplesKt.to("context", this.context), TuplesKt.to("url", this.url)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
