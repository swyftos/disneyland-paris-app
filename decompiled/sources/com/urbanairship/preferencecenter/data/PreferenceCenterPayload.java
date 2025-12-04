package com.urbanairship.preferencecenter.data;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.PreferenceCenterConfig;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\r\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0010J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/preferencecenter/data/PreferenceCenterPayload;", "", "config", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "(Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;)V", "getConfig", "()Lcom/urbanairship/preferencecenter/data/PreferenceCenterConfig;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toJson", "Lcom/urbanairship/json/JsonMap;", "toJson$urbanairship_preference_center_release", "toString", "", "Companion", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PreferenceCenterPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_FORM = "form";
    private final PreferenceCenterConfig config;

    public static /* synthetic */ PreferenceCenterPayload copy$default(PreferenceCenterPayload preferenceCenterPayload, PreferenceCenterConfig preferenceCenterConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            preferenceCenterConfig = preferenceCenterPayload.config;
        }
        return preferenceCenterPayload.copy(preferenceCenterConfig);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final PreferenceCenterConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final PreferenceCenterPayload copy(@NotNull PreferenceCenterConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new PreferenceCenterPayload(config);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PreferenceCenterPayload) && Intrinsics.areEqual(this.config, ((PreferenceCenterPayload) other).config);
    }

    public int hashCode() {
        return this.config.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreferenceCenterPayload(config=" + this.config + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PreferenceCenterPayload(@NotNull PreferenceCenterConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @NotNull
    public final PreferenceCenterConfig getConfig() {
        return this.config;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/preferencecenter/data/PreferenceCenterPayload$Companion;", "", "()V", "KEY_FORM", "", "parse", "Lcom/urbanairship/preferencecenter/data/PreferenceCenterPayload;", "json", "Lcom/urbanairship/json/JsonMap;", "parse$urbanairship_preference_center_release", "urbanairship-preference-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final PreferenceCenterPayload parse$urbanairship_preference_center_release(@NotNull JsonMap json) throws JsonException {
            Intrinsics.checkNotNullParameter(json, "json");
            PreferenceCenterConfig.Companion companion = PreferenceCenterConfig.INSTANCE;
            JsonMap jsonMapOptMap = json.opt(PreferenceCenterPayload.KEY_FORM).optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            return new PreferenceCenterPayload(companion.parse$urbanairship_preference_center_release(jsonMapOptMap));
        }
    }

    @NotNull
    public final JsonMap toJson$urbanairship_preference_center_release() throws JsonException {
        return JsonExtensionsKt.jsonMapOf(TuplesKt.to(KEY_FORM, this.config.toJson$urbanairship_preference_center_release()));
    }
}
