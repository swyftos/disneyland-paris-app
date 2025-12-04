package com.urbanairship.android.framework.proxy.proxies;

import androidx.camera.video.AudioStats;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.analytics.AssociatedIdentifiers;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/AnalyticsProxy;", "", "analyticsProvider", "Lkotlin/Function0;", "Lcom/urbanairship/analytics/Analytics;", "(Lkotlin/jvm/functions/Function0;)V", "addEvent", "", "json", "Lcom/urbanairship/json/JsonValue;", "associateIdentifier", "key", "", "value", "getSessionId", "trackScreen", TCEventPropertiesNames.TCD_SCREEN, "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnalyticsProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnalyticsProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/AnalyticsProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
/* loaded from: classes2.dex */
public final class AnalyticsProxy {
    private final Function0 analyticsProvider;

    public AnalyticsProxy(@NotNull Function0<Analytics> analyticsProvider) {
        Intrinsics.checkNotNullParameter(analyticsProvider, "analyticsProvider");
        this.analyticsProvider = analyticsProvider;
    }

    public final void associateIdentifier(@NotNull String key, @Nullable String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        AssociatedIdentifiers.Editor editorEditAssociatedIdentifiers = ((Analytics) this.analyticsProvider.invoke()).editAssociatedIdentifiers();
        if (value == null) {
            editorEditAssociatedIdentifiers.removeIdentifier(key);
        } else {
            editorEditAssociatedIdentifiers.addIdentifier(key, value);
        }
        editorEditAssociatedIdentifiers.apply();
    }

    public final void trackScreen(@Nullable String screen) {
        ((Analytics) this.analyticsProvider.invoke()).trackScreen(screen);
    }

    public final void addEvent(@NotNull JsonValue json) throws NumberFormatException, JsonException {
        Intrinsics.checkNotNullParameter(json, "json");
        JsonMap jsonMapOptMap = json.optMap();
        Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
        CustomEvent.Companion companion = CustomEvent.INSTANCE;
        String strRequireString = jsonMapOptMap.require("eventName").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
        CustomEvent.Builder builderNewBuilder = companion.newBuilder(strRequireString);
        JsonValue jsonValueOpt = jsonMapOptMap.opt("eventValue");
        Intrinsics.checkNotNullExpressionValue(jsonValueOpt, "opt(...)");
        if (jsonValueOpt.isNumber()) {
            builderNewBuilder.setEventValue(jsonValueOpt.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        }
        builderNewBuilder.setProperties(jsonMapOptMap.opt(CustomEvent.PROPERTIES).getMap());
        builderNewBuilder.setTransactionId(jsonMapOptMap.opt("transactionId").getString());
        String string = jsonMapOptMap.opt("interactionId").getString();
        String string2 = jsonMapOptMap.opt("interactionType").getString();
        if (string != null && string2 != null) {
            builderNewBuilder.setInteraction(string2, string);
        }
        CustomEvent customEventBuild = builderNewBuilder.build();
        if (customEventBuild.isValid()) {
            ((Analytics) this.analyticsProvider.invoke()).addEvent(customEventBuild);
            return;
        }
        throw new IllegalArgumentException("Invalid event " + json);
    }

    @NotNull
    public final String getSessionId() {
        return ((Analytics) this.analyticsProvider.invoke()).getSessionId();
    }
}
