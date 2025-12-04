package com.urbanairship.iam.content;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.api.Currencies;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.iam.info.InAppMessageColor;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 -2\u00020\u0001:\u0001-Ba\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0002\u0010\u0010Jk\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\r\u0010+\u001a\u00020\bH\u0000¢\u0006\u0002\b,R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001c¨\u0006."}, d2 = {"Lcom/urbanairship/iam/content/HTML;", "Lcom/urbanairship/json/JsonSerializable;", "url", "", "height", "", "width", "aspectLock", "", "requiresConnectivity", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/iam/info/InAppMessageColor;", "dismissButtonColor", "borderRadius", "", "allowFullscreenDisplay", "(Ljava/lang/String;JJLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/urbanairship/iam/info/InAppMessageColor;Lcom/urbanairship/iam/info/InAppMessageColor;FZ)V", "getAllowFullscreenDisplay", "()Z", "getAspectLock", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBackgroundColor", "()Lcom/urbanairship/iam/info/InAppMessageColor;", "getBorderRadius", "()F", "getDismissButtonColor", "getHeight", "()J", "getRequiresConnectivity", "getUrl", "()Ljava/lang/String;", "getWidth", "copy", "(Ljava/lang/String;JJLjava/lang/Boolean;Ljava/lang/Boolean;Lcom/urbanairship/iam/info/InAppMessageColor;Lcom/urbanairship/iam/info/InAppMessageColor;FZ)Lcom/urbanairship/iam/content/HTML;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "validate", "validate$urbanairship_automation_release", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HTML implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean allowFullscreenDisplay;
    private final Boolean aspectLock;
    private final InAppMessageColor backgroundColor;
    private final float borderRadius;
    private final InAppMessageColor dismissButtonColor;
    private final long height;
    private final Boolean requiresConnectivity;
    private final String url;
    private final long width;

    @JvmOverloads
    @NotNull
    public final HTML copy() {
        return copy$default(this, null, 0L, 0L, null, null, null, null, BitmapDescriptorFactory.HUE_RED, false, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return copy$default(this, url, 0L, 0L, null, null, null, null, BitmapDescriptorFactory.HUE_RED, false, TypedValues.PositionType.TYPE_POSITION_TYPE, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long j) {
        Intrinsics.checkNotNullParameter(url, "url");
        return copy$default(this, url, j, 0L, null, null, null, null, BitmapDescriptorFactory.HUE_RED, false, TypedValues.PositionType.TYPE_CURVE_FIT, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long j, long j2) {
        Intrinsics.checkNotNullParameter(url, "url");
        return copy$default(this, url, j, j2, null, null, null, null, BitmapDescriptorFactory.HUE_RED, false, 504, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long j, long j2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(url, "url");
        return copy$default(this, url, j, j2, bool, null, null, null, BitmapDescriptorFactory.HUE_RED, false, Currencies.MNT, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long j, long j2, @Nullable Boolean bool, @Nullable Boolean bool2) {
        Intrinsics.checkNotNullParameter(url, "url");
        return copy$default(this, url, j, j2, bool, bool2, null, null, BitmapDescriptorFactory.HUE_RED, false, Currencies.MUR, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long j, long j2, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull InAppMessageColor backgroundColor) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return copy$default(this, url, j, j2, bool, bool2, backgroundColor, null, BitmapDescriptorFactory.HUE_RED, false, 448, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long j, long j2, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return copy$default(this, url, j, j2, bool, bool2, backgroundColor, dismissButtonColor, BitmapDescriptorFactory.HUE_RED, false, 384, null);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long j, long j2, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float f) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return copy$default(this, url, j, j2, bool, bool2, backgroundColor, dismissButtonColor, f, false, 256, null);
    }

    @VisibleForTesting
    public HTML(@NotNull String url, long j, long j2, @Nullable Boolean bool, @Nullable Boolean bool2, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float f, boolean z) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        this.url = url;
        this.height = j;
        this.width = j2;
        this.aspectLock = bool;
        this.requiresConnectivity = bool2;
        this.backgroundColor = backgroundColor;
        this.dismissButtonColor = dismissButtonColor;
        this.borderRadius = f;
        this.allowFullscreenDisplay = z;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final long getHeight() {
        return this.height;
    }

    public final long getWidth() {
        return this.width;
    }

    @Nullable
    public final Boolean getAspectLock() {
        return this.aspectLock;
    }

    @Nullable
    public final Boolean getRequiresConnectivity() {
        return this.requiresConnectivity;
    }

    public /* synthetic */ HTML(String str, long j, long j2, Boolean bool, Boolean bool2, InAppMessageColor inAppMessageColor, InAppMessageColor inAppMessageColor2, float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2, (i & 32) != 0 ? new InAppMessageColor(-1) : inAppMessageColor, (i & 64) != 0 ? new InAppMessageColor(-16777216) : inAppMessageColor2, (i & 128) != 0 ? 0.0f : f, z);
    }

    @NotNull
    public final InAppMessageColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final InAppMessageColor getDismissButtonColor() {
        return this.dismissButtonColor;
    }

    public final float getBorderRadius() {
        return this.borderRadius;
    }

    public final boolean getAllowFullscreenDisplay() {
        return this.allowFullscreenDisplay;
    }

    public static /* synthetic */ HTML copy$default(HTML html, String str, long j, long j2, Boolean bool, Boolean bool2, InAppMessageColor inAppMessageColor, InAppMessageColor inAppMessageColor2, float f, boolean z, int i, Object obj) {
        return html.copy((i & 1) != 0 ? html.url : str, (i & 2) != 0 ? html.height : j, (i & 4) != 0 ? html.width : j2, (i & 8) != 0 ? html.aspectLock : bool, (i & 16) != 0 ? html.requiresConnectivity : bool2, (i & 32) != 0 ? html.backgroundColor : inAppMessageColor, (i & 64) != 0 ? html.dismissButtonColor : inAppMessageColor2, (i & 128) != 0 ? html.borderRadius : f, (i & 256) != 0 ? html.allowFullscreenDisplay : z);
    }

    @JvmOverloads
    @NotNull
    public final HTML copy(@NotNull String url, long height, long width, @Nullable Boolean aspectLock, @Nullable Boolean requiresConnectivity, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float borderRadius, boolean allowFullscreenDisplay) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return new HTML(url, height, width, aspectLock, requiresConnectivity, backgroundColor, dismissButtonColor, borderRadius, allowFullscreenDisplay);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/content/HTML$Companion;", "", "()V", "ALLOW_FULLSCREEN_DISPLAY_KEY", "", "ASPECT_LOCK_KEY", "BACKGROUND_COLOR_KEY", "BORDER_RADIUS_KEY", "DISMISS_BUTTON_COLOR_KEY", "HEIGHT_KEY", "REQUIRE_CONNECTIVITY", "URL_KEY", "WIDTH_KEY", "fromJson", "Lcom/urbanairship/iam/content/HTML;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nHTML.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HTML.kt\ncom/urbanairship/iam/content/HTML$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,166:1\n44#2,15:167\n79#2,16:182\n79#2,16:198\n79#2,16:214\n79#2,16:230\n79#2,16:247\n1#3:246\n*S KotlinDebug\n*F\n+ 1 HTML.kt\ncom/urbanairship/iam/content/HTML$Companion\n*L\n101#1:167,15\n102#1:182,16\n103#1:198,16\n104#1:214,16\n105#1:230,16\n111#1:247,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:295:0x07b1  */
        /* JADX WARN: Removed duplicated region for block: B:296:0x07b8  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.iam.content.HTML fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r30) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 2260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.content.HTML.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.iam.content.HTML");
        }
    }

    public final boolean validate$urbanairship_automation_release() {
        return !StringsKt.isBlank(this.url);
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() throws JsonException {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("url", this.url), TuplesKt.to("width", Long.valueOf(this.width)), TuplesKt.to("height", Long.valueOf(this.height)), TuplesKt.to("aspect_lock", this.aspectLock), TuplesKt.to("require_connectivity", this.requiresConnectivity), TuplesKt.to("background_color", this.backgroundColor), TuplesKt.to("border_radius", Float.valueOf(this.borderRadius)), TuplesKt.to("dismiss_button_color", this.dismissButtonColor), TuplesKt.to("allow_fullscreen_display", Boolean.valueOf(this.allowFullscreenDisplay))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(HTML.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.content.HTML");
        HTML html = (HTML) other;
        return Intrinsics.areEqual(this.url, html.url) && this.height == html.height && this.width == html.width && Intrinsics.areEqual(this.aspectLock, html.aspectLock) && Intrinsics.areEqual(this.requiresConnectivity, html.requiresConnectivity) && Intrinsics.areEqual(this.backgroundColor, html.backgroundColor) && Intrinsics.areEqual(this.dismissButtonColor, html.dismissButtonColor) && this.borderRadius == html.borderRadius && this.allowFullscreenDisplay == html.allowFullscreenDisplay;
    }

    public int hashCode() {
        int iHashCode = ((((this.url.hashCode() * 31) + Long.hashCode(this.height)) * 31) + Long.hashCode(this.width)) * 31;
        Boolean bool = this.aspectLock;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.requiresConnectivity;
        return ((((((((iHashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31) + this.backgroundColor.hashCode()) * 31) + this.dismissButtonColor.hashCode()) * 31) + Float.hashCode(this.borderRadius)) * 31) + Boolean.hashCode(this.allowFullscreenDisplay);
    }

    @NotNull
    public String toString() {
        return "HTML(url='" + this.url + "', height=" + this.height + ", width=" + this.width + ", aspectLock=" + this.aspectLock + ", requiresConnectivity=" + this.requiresConnectivity + ", backgroundColor=" + this.backgroundColor + ", dismissButtonColor=" + this.dismissButtonColor + ", borderRadius=" + this.borderRadius + ", allowFullscreenDisplay=" + this.allowFullscreenDisplay + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
