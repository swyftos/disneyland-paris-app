package com.urbanairship.iam.content;

import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.api.Currencies;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.actions.RateAppAction;
import com.urbanairship.iam.info.InAppMessageButtonInfo;
import com.urbanairship.iam.info.InAppMessageButtonLayoutType;
import com.urbanairship.iam.info.InAppMessageColor;
import com.urbanairship.iam.info.InAppMessageMediaInfo;
import com.urbanairship.iam.info.InAppMessageTextInfo;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0003=>?B\u008b\u0001\b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\u0090\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0096\u0002J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020:H\u0016J\r\u0010;\u001a\u000202H\u0000¢\u0006\u0002\b<R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006@"}, d2 = {"Lcom/urbanairship/iam/content/Banner;", "Lcom/urbanairship/json/JsonSerializable;", "heading", "Lcom/urbanairship/iam/info/InAppMessageTextInfo;", RateAppAction.BODY_KEY, "media", "Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "buttons", "", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "buttonLayoutType", "Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "template", "Lcom/urbanairship/iam/content/Banner$Template;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/iam/info/InAppMessageColor;", "dismissButtonColor", "borderRadius", "", "durationMs", "", "placement", "Lcom/urbanairship/iam/content/Banner$Placement;", "actions", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/iam/info/InAppMessageTextInfo;Lcom/urbanairship/iam/info/InAppMessageTextInfo;Lcom/urbanairship/iam/info/InAppMessageMediaInfo;Ljava/util/List;Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;Lcom/urbanairship/iam/content/Banner$Template;Lcom/urbanairship/iam/info/InAppMessageColor;Lcom/urbanairship/iam/info/InAppMessageColor;FJLcom/urbanairship/iam/content/Banner$Placement;Lcom/urbanairship/json/JsonMap;)V", "getActions", "()Lcom/urbanairship/json/JsonMap;", "getBackgroundColor", "()Lcom/urbanairship/iam/info/InAppMessageColor;", "getBody", "()Lcom/urbanairship/iam/info/InAppMessageTextInfo;", "getBorderRadius", "()F", "getButtonLayoutType", "()Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "getButtons", "()Ljava/util/List;", "getDismissButtonColor", "getDurationMs", "()J", "getHeading", "getMedia", "()Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "getPlacement", "()Lcom/urbanairship/iam/content/Banner$Placement;", "getTemplate", "()Lcom/urbanairship/iam/content/Banner$Template;", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "validate$urbanairship_automation_release", "Companion", "Placement", "Template", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Banner implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final long DEFAULT_DURATION_MS = 15000;
    public static final int MAX_BUTTONS = 2;
    private final JsonMap actions;
    private final InAppMessageColor backgroundColor;
    private final InAppMessageTextInfo body;
    private final float borderRadius;
    private final InAppMessageButtonLayoutType buttonLayoutType;
    private final List buttons;
    private final InAppMessageColor dismissButtonColor;
    private final long durationMs;
    private final InAppMessageTextInfo heading;
    private final InAppMessageMediaInfo media;
    private final Placement placement;
    private final Template template;

    @JvmOverloads
    @NotNull
    public final Banner copy() {
        return copy$default(this, null, null, null, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 4095, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo) {
        return copy$default(this, inAppMessageTextInfo, null, null, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 4094, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, null, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 4092, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 4088, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, null, null, null, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 4080, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, buttonLayoutType, null, null, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 4064, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, buttonLayoutType, template, null, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 4032, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, buttonLayoutType, template, backgroundColor, null, BitmapDescriptorFactory.HUE_RED, 0L, null, null, Utf8.MASK_2BYTES, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, buttonLayoutType, template, backgroundColor, dismissButtonColor, BitmapDescriptorFactory.HUE_RED, 0L, null, null, 3840, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float f) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, buttonLayoutType, template, backgroundColor, dismissButtonColor, f, 0L, null, null, RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float f, long j) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, buttonLayoutType, template, backgroundColor, dismissButtonColor, f, j, null, null, 3072, null);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float f, long j, @NotNull Placement placement) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        Intrinsics.checkNotNullParameter(placement, "placement");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, list, buttonLayoutType, template, backgroundColor, dismissButtonColor, f, j, placement, null, 2048, null);
    }

    @VisibleForTesting
    public Banner(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable List<InAppMessageButtonInfo> list, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float f, long j, @NotNull Placement placement, @Nullable JsonMap jsonMap) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.heading = inAppMessageTextInfo;
        this.body = inAppMessageTextInfo2;
        this.media = inAppMessageMediaInfo;
        this.buttons = list;
        this.buttonLayoutType = buttonLayoutType;
        this.template = template;
        this.backgroundColor = backgroundColor;
        this.dismissButtonColor = dismissButtonColor;
        this.borderRadius = f;
        this.durationMs = j;
        this.placement = placement;
        this.actions = jsonMap;
    }

    @Nullable
    public final InAppMessageTextInfo getHeading() {
        return this.heading;
    }

    @Nullable
    public final InAppMessageTextInfo getBody() {
        return this.body;
    }

    @Nullable
    public final InAppMessageMediaInfo getMedia() {
        return this.media;
    }

    @Nullable
    public final List<InAppMessageButtonInfo> getButtons() {
        return this.buttons;
    }

    public /* synthetic */ Banner(InAppMessageTextInfo inAppMessageTextInfo, InAppMessageTextInfo inAppMessageTextInfo2, InAppMessageMediaInfo inAppMessageMediaInfo, List list, InAppMessageButtonLayoutType inAppMessageButtonLayoutType, Template template, InAppMessageColor inAppMessageColor, InAppMessageColor inAppMessageColor2, float f, long j, Placement placement, JsonMap jsonMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : inAppMessageTextInfo, (i & 2) != 0 ? null : inAppMessageTextInfo2, (i & 4) != 0 ? null : inAppMessageMediaInfo, (i & 8) != 0 ? null : list, (i & 16) != 0 ? InAppMessageButtonLayoutType.SEPARATE : inAppMessageButtonLayoutType, template, (i & 64) != 0 ? new InAppMessageColor(-1) : inAppMessageColor, (i & 128) != 0 ? new InAppMessageColor(-16777216) : inAppMessageColor2, (i & 256) != 0 ? 0.0f : f, (i & 512) != 0 ? 15000L : j, placement, (i & 2048) != 0 ? null : jsonMap);
    }

    @NotNull
    public final InAppMessageButtonLayoutType getButtonLayoutType() {
        return this.buttonLayoutType;
    }

    @NotNull
    public final Template getTemplate() {
        return this.template;
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

    public final long getDurationMs() {
        return this.durationMs;
    }

    @NotNull
    public final Placement getPlacement() {
        return this.placement;
    }

    @Nullable
    public final JsonMap getActions() {
        return this.actions;
    }

    public static /* synthetic */ Banner copy$default(Banner banner, InAppMessageTextInfo inAppMessageTextInfo, InAppMessageTextInfo inAppMessageTextInfo2, InAppMessageMediaInfo inAppMessageMediaInfo, List list, InAppMessageButtonLayoutType inAppMessageButtonLayoutType, Template template, InAppMessageColor inAppMessageColor, InAppMessageColor inAppMessageColor2, float f, long j, Placement placement, JsonMap jsonMap, int i, Object obj) {
        return banner.copy((i & 1) != 0 ? banner.heading : inAppMessageTextInfo, (i & 2) != 0 ? banner.body : inAppMessageTextInfo2, (i & 4) != 0 ? banner.media : inAppMessageMediaInfo, (i & 8) != 0 ? banner.buttons : list, (i & 16) != 0 ? banner.buttonLayoutType : inAppMessageButtonLayoutType, (i & 32) != 0 ? banner.template : template, (i & 64) != 0 ? banner.backgroundColor : inAppMessageColor, (i & 128) != 0 ? banner.dismissButtonColor : inAppMessageColor2, (i & 256) != 0 ? banner.borderRadius : f, (i & 512) != 0 ? banner.durationMs : j, (i & 1024) != 0 ? banner.placement : placement, (i & 2048) != 0 ? banner.actions : jsonMap);
    }

    @JvmOverloads
    @NotNull
    public final Banner copy(@Nullable InAppMessageTextInfo heading, @Nullable InAppMessageTextInfo body, @Nullable InAppMessageMediaInfo media, @Nullable List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor, float borderRadius, long durationMs, @NotNull Placement placement, @Nullable JsonMap actions) {
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        Intrinsics.checkNotNullParameter(placement, "placement");
        return new Banner(heading, body, media, buttons, buttonLayoutType, template, backgroundColor, dismissButtonColor, borderRadius, durationMs, placement, actions);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/content/Banner$Template;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "MEDIA_LEFT", "MEDIA_RIGHT", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Template implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Template[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final Template MEDIA_LEFT = new Template("MEDIA_LEFT", 0, "media_left");
        public static final Template MEDIA_RIGHT = new Template("MEDIA_RIGHT", 1, "media_right");
        private final String json;

        private static final /* synthetic */ Template[] $values() {
            return new Template[]{MEDIA_LEFT, MEDIA_RIGHT};
        }

        @NotNull
        public static EnumEntries<Template> getEntries() {
            return $ENTRIES;
        }

        public static Template valueOf(String str) {
            return (Template) Enum.valueOf(Template.class, str);
        }

        public static Template[] values() {
            return (Template[]) $VALUES.clone();
        }

        private Template(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            Template[] templateArr$values = $values();
            $VALUES = templateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(templateArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/content/Banner$Template$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/content/Banner$Template;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nBanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Banner.kt\ncom/urbanairship/iam/content/Banner$Template$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,271:1\n288#2,2:272\n*S KotlinDebug\n*F\n+ 1 Banner.kt\ncom/urbanairship/iam/content/Banner$Template$Companion\n*L\n119#1:272,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Template fromJson(@NotNull JsonValue value) throws JsonException {
                Template next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<Template> it = Template.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), strRequireString)) {
                        break;
                    }
                }
                Template template = next;
                if (template != null) {
                    return template;
                }
                throw new JsonException("Invalid template value " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/content/Banner$Placement;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", Currencies.AlphabeticCode.TOP_STR, "BOTTOM", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Placement implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Placement[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final Placement TOP = new Placement(Currencies.AlphabeticCode.TOP_STR, 0, ViewProps.TOP);
        public static final Placement BOTTOM = new Placement("BOTTOM", 1, ViewProps.BOTTOM);

        private static final /* synthetic */ Placement[] $values() {
            return new Placement[]{TOP, BOTTOM};
        }

        @NotNull
        public static EnumEntries<Placement> getEntries() {
            return $ENTRIES;
        }

        public static Placement valueOf(String str) {
            return (Placement) Enum.valueOf(Placement.class, str);
        }

        public static Placement[] values() {
            return (Placement[]) $VALUES.clone();
        }

        private Placement(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            Placement[] placementArr$values = $values();
            $VALUES = placementArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(placementArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/content/Banner$Placement$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/content/Banner$Placement;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nBanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Banner.kt\ncom/urbanairship/iam/content/Banner$Placement$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,271:1\n288#2,2:272\n*S KotlinDebug\n*F\n+ 1 Banner.kt\ncom/urbanairship/iam/content/Banner$Placement$Companion\n*L\n143#1:272,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Placement fromJson(@NotNull JsonValue value) throws JsonException {
                Placement next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<Placement> it = Placement.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), strRequireString)) {
                        break;
                    }
                }
                Placement placement = next;
                if (placement != null) {
                    return placement;
                }
                throw new JsonException("Invalid placement value " + strRequireString);
            }
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        public JsonValue toJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/iam/content/Banner$Companion;", "", "()V", "ACTIONS_KEY", "", "BACKGROUND_COLOR_KEY", "BODY_KEY", "BORDER_RADIUS_KEY", "BUTTONS_KEY", "BUTTON_LAYOUT_KEY", "DEFAULT_DURATION_MS", "", "DISMISS_BUTTON_COLOR_KEY", "DURATION_KEY", "HEADING_KEY", "MAX_BUTTONS", "", "MEDIA_KEY", "PLACEMENT_KEY", "TEMPLATE_KEY", "fromJson", "Lcom/urbanairship/iam/content/Banner;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Banner.kt\ncom/urbanairship/iam/content/Banner$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,271:1\n1#2:272\n1549#3:273\n1620#3,3:274\n79#4,16:277\n*S KotlinDebug\n*F\n+ 1 Banner.kt\ncom/urbanairship/iam/content/Banner$Companion\n*L\n189#1:273\n189#1:274,3\n201#1:277,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Banner fromJson(@NotNull JsonValue value) throws JsonException {
            ArrayList arrayList;
            InAppMessageButtonLayoutType inAppMessageButtonLayoutTypeFromJson;
            Placement placementFromJson;
            Template templateFromJson;
            InAppMessageColor inAppMessageColor;
            InAppMessageColor inAppMessageColor2;
            Placement placement;
            long j;
            JsonMap jsonMapOptMap;
            JsonList jsonListRequireList;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("heading");
            JsonMap jsonMap = null;
            InAppMessageTextInfo inAppMessageTextInfoFromJson = jsonValue != null ? InAppMessageTextInfo.INSTANCE.fromJson(jsonValue) : null;
            JsonValue jsonValue2 = jsonMapRequireMap.get(RateAppAction.BODY_KEY);
            InAppMessageTextInfo inAppMessageTextInfoFromJson2 = jsonValue2 != null ? InAppMessageTextInfo.INSTANCE.fromJson(jsonValue2) : null;
            JsonValue jsonValue3 = jsonMapRequireMap.get("media");
            InAppMessageMediaInfo inAppMessageMediaInfoFromJson = jsonValue3 != null ? InAppMessageMediaInfo.INSTANCE.fromJson(jsonValue3) : null;
            JsonValue jsonValue4 = jsonMapRequireMap.get("buttons");
            if (jsonValue4 == null || (jsonListRequireList = jsonValue4.requireList()) == null) {
                arrayList = null;
            } else {
                InAppMessageButtonInfo.Companion companion = InAppMessageButtonInfo.INSTANCE;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    arrayList.add(companion.fromJson(it.next()));
                }
            }
            JsonValue jsonValue5 = jsonMapRequireMap.get("button_layout");
            if (jsonValue5 == null || (inAppMessageButtonLayoutTypeFromJson = InAppMessageButtonLayoutType.INSTANCE.fromJson(jsonValue5)) == null) {
                inAppMessageButtonLayoutTypeFromJson = InAppMessageButtonLayoutType.SEPARATE;
            }
            InAppMessageButtonLayoutType inAppMessageButtonLayoutType = inAppMessageButtonLayoutTypeFromJson;
            JsonValue jsonValue6 = jsonMapRequireMap.get("placement");
            if (jsonValue6 == null || (placementFromJson = Placement.INSTANCE.fromJson(jsonValue6)) == null) {
                placementFromJson = Placement.BOTTOM;
            }
            Placement placement2 = placementFromJson;
            JsonValue jsonValue7 = jsonMapRequireMap.get("template");
            if (jsonValue7 == null || (templateFromJson = Template.INSTANCE.fromJson(jsonValue7)) == null) {
                templateFromJson = Template.MEDIA_LEFT;
            }
            Template template = templateFromJson;
            long j2 = jsonMapRequireMap.opt(TypedValues.TransitionType.S_DURATION).getLong(15000L);
            JsonValue jsonValue8 = jsonMapRequireMap.get("background_color");
            if (jsonValue8 == null || (inAppMessageColor = InAppMessageColor.INSTANCE.fromJson(jsonValue8)) == null) {
                inAppMessageColor = new InAppMessageColor(-1);
            }
            InAppMessageColor inAppMessageColor3 = inAppMessageColor;
            JsonValue jsonValue9 = jsonMapRequireMap.get("dismiss_button_color");
            if (jsonValue9 == null || (inAppMessageColor2 = InAppMessageColor.INSTANCE.fromJson(jsonValue9)) == null) {
                inAppMessageColor2 = new InAppMessageColor(-16777216);
            }
            InAppMessageColor inAppMessageColor4 = inAppMessageColor2;
            float f = jsonMapRequireMap.opt("border_radius").getFloat(BitmapDescriptorFactory.HUE_RED);
            JsonValue jsonValue10 = jsonMapRequireMap.get("actions");
            if (jsonValue10 == null) {
                j = j2;
                placement = placement2;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonMap.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    JsonMap jsonMap2 = (JsonMap) jsonValue10.optString();
                    jsonMap = jsonMap2;
                    j = j2;
                    placement = placement2;
                } else {
                    placement = placement2;
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMap = (JsonMap) Boolean.valueOf(jsonValue10.getBoolean(false));
                        j = j2;
                    } else {
                        j = j2;
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue10.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue10.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue10.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue10.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            jsonMapOptMap = (JsonMap) jsonValue10.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap = jsonValue10.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'actions" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonMapOptMap = (JsonMap) jsonValue10.toJsonValue();
                        }
                        jsonMap = jsonMapOptMap;
                    }
                }
            }
            return new Banner(inAppMessageTextInfoFromJson, inAppMessageTextInfoFromJson2, inAppMessageMediaInfoFromJson, arrayList, inAppMessageButtonLayoutType, template, inAppMessageColor3, inAppMessageColor4, f, j, placement, jsonMap);
        }
    }

    public final boolean validate$urbanairship_automation_release() {
        InAppMessageTextInfo inAppMessageTextInfo;
        InAppMessageTextInfo inAppMessageTextInfo2 = this.heading;
        if ((inAppMessageTextInfo2 == null || !inAppMessageTextInfo2.validate$urbanairship_automation_release()) && ((inAppMessageTextInfo = this.body) == null || !inAppMessageTextInfo.validate$urbanairship_automation_release())) {
            return false;
        }
        List list = this.buttons;
        return list == null || list.size() <= 2;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("heading", this.heading), TuplesKt.to(RateAppAction.BODY_KEY, this.body), TuplesKt.to("media", this.media), TuplesKt.to("buttons", this.buttons), TuplesKt.to("button_layout", this.buttonLayoutType), TuplesKt.to("placement", this.placement), TuplesKt.to("template", this.template), TuplesKt.to(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.durationMs)), TuplesKt.to("background_color", this.backgroundColor), TuplesKt.to("dismiss_button_color", this.dismissButtonColor), TuplesKt.to("border_radius", Float.valueOf(this.borderRadius)), TuplesKt.to("actions", this.actions)).toJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @NotNull
    public String toString() {
        String string = toJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Banner.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.content.Banner");
        Banner banner = (Banner) other;
        if (Intrinsics.areEqual(this.heading, banner.heading) && Intrinsics.areEqual(this.body, banner.body) && Intrinsics.areEqual(this.media, banner.media) && Intrinsics.areEqual(this.buttons, banner.buttons) && this.buttonLayoutType == banner.buttonLayoutType && this.template == banner.template && Intrinsics.areEqual(this.backgroundColor, banner.backgroundColor) && Intrinsics.areEqual(this.dismissButtonColor, banner.dismissButtonColor) && this.borderRadius == banner.borderRadius && this.durationMs == banner.durationMs && this.placement == banner.placement) {
            return Intrinsics.areEqual(this.actions, banner.actions);
        }
        return false;
    }

    public int hashCode() {
        InAppMessageTextInfo inAppMessageTextInfo = this.heading;
        int iHashCode = (inAppMessageTextInfo != null ? inAppMessageTextInfo.hashCode() : 0) * 31;
        InAppMessageTextInfo inAppMessageTextInfo2 = this.body;
        int iHashCode2 = (iHashCode + (inAppMessageTextInfo2 != null ? inAppMessageTextInfo2.hashCode() : 0)) * 31;
        InAppMessageMediaInfo inAppMessageMediaInfo = this.media;
        int iHashCode3 = (iHashCode2 + (inAppMessageMediaInfo != null ? inAppMessageMediaInfo.hashCode() : 0)) * 31;
        List list = this.buttons;
        int iHashCode4 = (((((((((((((((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.buttonLayoutType.hashCode()) * 31) + this.template.hashCode()) * 31) + this.backgroundColor.hashCode()) * 31) + this.dismissButtonColor.hashCode()) * 31) + Float.hashCode(this.borderRadius)) * 31) + Long.hashCode(this.durationMs)) * 31) + this.placement.hashCode()) * 31;
        JsonMap jsonMap = this.actions;
        return iHashCode4 + (jsonMap != null ? jsonMap.hashCode() : 0);
    }
}
