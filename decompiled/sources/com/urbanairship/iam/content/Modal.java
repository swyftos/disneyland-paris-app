package com.urbanairship.iam.content;

import androidx.annotation.FloatRange;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u000267B\u007f\b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0003\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0084\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007J\u0013\u0010,\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0002J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0016J\u0006\u00105\u001a\u00020\u0015R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u00068"}, d2 = {"Lcom/urbanairship/iam/content/Modal;", "Lcom/urbanairship/json/JsonSerializable;", "heading", "Lcom/urbanairship/iam/info/InAppMessageTextInfo;", RateAppAction.BODY_KEY, "media", "Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "footer", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "buttons", "", "buttonLayoutType", "Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "template", "Lcom/urbanairship/iam/content/Modal$Template;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/iam/info/InAppMessageColor;", "borderRadius", "", "dismissButtonColor", "allowFullscreenDisplay", "", "(Lcom/urbanairship/iam/info/InAppMessageTextInfo;Lcom/urbanairship/iam/info/InAppMessageTextInfo;Lcom/urbanairship/iam/info/InAppMessageMediaInfo;Lcom/urbanairship/iam/info/InAppMessageButtonInfo;Ljava/util/List;Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;Lcom/urbanairship/iam/content/Modal$Template;Lcom/urbanairship/iam/info/InAppMessageColor;FLcom/urbanairship/iam/info/InAppMessageColor;Z)V", "getAllowFullscreenDisplay", "()Z", "getBackgroundColor", "()Lcom/urbanairship/iam/info/InAppMessageColor;", "getBody", "()Lcom/urbanairship/iam/info/InAppMessageTextInfo;", "getBorderRadius", "()F", "getButtonLayoutType", "()Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "getButtons", "()Ljava/util/List;", "getDismissButtonColor", "getFooter", "()Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "getHeading", "getMedia", "()Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "getTemplate", "()Lcom/urbanairship/iam/content/Modal$Template;", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "Companion", "Template", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Modal implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_BUTTONS = 2;
    private final boolean allowFullscreenDisplay;
    private final InAppMessageColor backgroundColor;
    private final InAppMessageTextInfo body;
    private final float borderRadius;
    private final InAppMessageButtonLayoutType buttonLayoutType;
    private final List buttons;
    private final InAppMessageColor dismissButtonColor;
    private final InAppMessageButtonInfo footer;
    private final InAppMessageTextInfo heading;
    private final InAppMessageMediaInfo media;
    private final Template template;

    @JvmOverloads
    @NotNull
    public final Modal copy() {
        return copy$default(this, null, null, null, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, null, false, 2047, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo) {
        return copy$default(this, inAppMessageTextInfo, null, null, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, null, false, 2046, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, null, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, null, false, 2044, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, null, null, null, null, null, BitmapDescriptorFactory.HUE_RED, null, false, 2040, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, null, null, null, null, BitmapDescriptorFactory.HUE_RED, null, false, 2032, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, null, null, null, BitmapDescriptorFactory.HUE_RED, null, false, 2016, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, null, null, BitmapDescriptorFactory.HUE_RED, null, false, 1984, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, template, null, BitmapDescriptorFactory.HUE_RED, null, false, 1920, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, template, backgroundColor, BitmapDescriptorFactory.HUE_RED, null, false, 1792, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, template, backgroundColor, f, null, false, 1536, null);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f, @NotNull InAppMessageColor dismissButtonColor) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, template, backgroundColor, f, dismissButtonColor, false, 1024, null);
    }

    @VisibleForTesting
    public Modal(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float f, @NotNull InAppMessageColor dismissButtonColor, boolean z) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        this.heading = inAppMessageTextInfo;
        this.body = inAppMessageTextInfo2;
        this.media = inAppMessageMediaInfo;
        this.footer = inAppMessageButtonInfo;
        this.buttons = buttons;
        this.buttonLayoutType = buttonLayoutType;
        this.template = template;
        this.backgroundColor = backgroundColor;
        this.borderRadius = f;
        this.dismissButtonColor = dismissButtonColor;
        this.allowFullscreenDisplay = z;
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
    public final InAppMessageButtonInfo getFooter() {
        return this.footer;
    }

    @NotNull
    public final List<InAppMessageButtonInfo> getButtons() {
        return this.buttons;
    }

    public /* synthetic */ Modal(InAppMessageTextInfo inAppMessageTextInfo, InAppMessageTextInfo inAppMessageTextInfo2, InAppMessageMediaInfo inAppMessageMediaInfo, InAppMessageButtonInfo inAppMessageButtonInfo, List list, InAppMessageButtonLayoutType inAppMessageButtonLayoutType, Template template, InAppMessageColor inAppMessageColor, float f, InAppMessageColor inAppMessageColor2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : inAppMessageTextInfo, (i & 2) != 0 ? null : inAppMessageTextInfo2, (i & 4) != 0 ? null : inAppMessageMediaInfo, (i & 8) != 0 ? null : inAppMessageButtonInfo, list, (i & 32) != 0 ? InAppMessageButtonLayoutType.SEPARATE : inAppMessageButtonLayoutType, template, (i & 128) != 0 ? new InAppMessageColor(-1) : inAppMessageColor, (i & 256) != 0 ? 0.0f : f, (i & 512) != 0 ? new InAppMessageColor(-16777216) : inAppMessageColor2, (i & 1024) != 0 ? false : z);
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

    public final float getBorderRadius() {
        return this.borderRadius;
    }

    @NotNull
    public final InAppMessageColor getDismissButtonColor() {
        return this.dismissButtonColor;
    }

    public final boolean getAllowFullscreenDisplay() {
        return this.allowFullscreenDisplay;
    }

    public static /* synthetic */ Modal copy$default(Modal modal, InAppMessageTextInfo inAppMessageTextInfo, InAppMessageTextInfo inAppMessageTextInfo2, InAppMessageMediaInfo inAppMessageMediaInfo, InAppMessageButtonInfo inAppMessageButtonInfo, List list, InAppMessageButtonLayoutType inAppMessageButtonLayoutType, Template template, InAppMessageColor inAppMessageColor, float f, InAppMessageColor inAppMessageColor2, boolean z, int i, Object obj) {
        return modal.copy((i & 1) != 0 ? modal.heading : inAppMessageTextInfo, (i & 2) != 0 ? modal.body : inAppMessageTextInfo2, (i & 4) != 0 ? modal.media : inAppMessageMediaInfo, (i & 8) != 0 ? modal.footer : inAppMessageButtonInfo, (i & 16) != 0 ? modal.buttons : list, (i & 32) != 0 ? modal.buttonLayoutType : inAppMessageButtonLayoutType, (i & 64) != 0 ? modal.template : template, (i & 128) != 0 ? modal.backgroundColor : inAppMessageColor, (i & 256) != 0 ? modal.borderRadius : f, (i & 512) != 0 ? modal.dismissButtonColor : inAppMessageColor2, (i & 1024) != 0 ? modal.allowFullscreenDisplay : z);
    }

    @JvmOverloads
    @NotNull
    public final Modal copy(@Nullable InAppMessageTextInfo heading, @Nullable InAppMessageTextInfo body, @Nullable InAppMessageMediaInfo media, @Nullable InAppMessageButtonInfo footer, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE) float borderRadius, @NotNull InAppMessageColor dismissButtonColor, boolean allowFullscreenDisplay) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return new Modal(heading, body, media, footer, buttons, buttonLayoutType, template, backgroundColor, borderRadius, dismissButtonColor, allowFullscreenDisplay);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/content/Modal$Template;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "HEADER_MEDIA_BODY", "MEDIA_HEADER_BODY", "HEADER_BODY_MEDIA", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Template implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Template[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final Template HEADER_MEDIA_BODY = new Template("HEADER_MEDIA_BODY", 0, "header_media_body");
        public static final Template MEDIA_HEADER_BODY = new Template("MEDIA_HEADER_BODY", 1, "media_header_body");
        public static final Template HEADER_BODY_MEDIA = new Template("HEADER_BODY_MEDIA", 2, "header_body_media");

        private static final /* synthetic */ Template[] $values() {
            return new Template[]{HEADER_MEDIA_BODY, MEDIA_HEADER_BODY, HEADER_BODY_MEDIA};
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

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/content/Modal$Template$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/content/Modal$Template;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Modal.kt\ncom/urbanairship/iam/content/Modal$Template$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,234:1\n288#2,2:235\n*S KotlinDebug\n*F\n+ 1 Modal.kt\ncom/urbanairship/iam/content/Modal$Template$Companion\n*L\n118#1:235,2\n*E\n"})
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
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/iam/content/Modal$Companion;", "", "()V", "ALLOW_FULLSCREEN_DISPLAY_KEY", "", "BACKGROUND_COLOR_KEY", "BODY_KEY", "BORDER_RADIUS_KEY", "BUTTONS_KEY", "BUTTON_LAYOUT_KEY", "DISMISS_BUTTON_COLOR_KEY", "FOOTER_KEY", "HEADING_KEY", "MAX_BUTTONS", "", "MEDIA_KEY", "TEMPLATE_KEY", "fromJson", "Lcom/urbanairship/iam/content/Modal;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Modal.kt\ncom/urbanairship/iam/content/Modal$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,234:1\n1#2:235\n1549#3:236\n1620#3,3:237\n79#4,16:240\n*S KotlinDebug\n*F\n+ 1 Modal.kt\ncom/urbanairship/iam/content/Modal$Companion\n*L\n159#1:236\n159#1:237,3\n170#1:240,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Modal fromJson(@NotNull JsonValue value) throws JsonException {
            List listEmptyList;
            InAppMessageButtonLayoutType inAppMessageButtonLayoutTypeFromJson;
            Template templateFromJson;
            InAppMessageColor inAppMessageColor;
            InAppMessageColor inAppMessageColor2;
            boolean z;
            Boolean bool;
            Boolean bool2;
            Boolean boolValueOf;
            JsonList jsonListRequireList;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("heading");
            Boolean bool3 = null;
            InAppMessageTextInfo inAppMessageTextInfoFromJson = jsonValue != null ? InAppMessageTextInfo.INSTANCE.fromJson(jsonValue) : null;
            JsonValue jsonValue2 = jsonMapRequireMap.get(RateAppAction.BODY_KEY);
            InAppMessageTextInfo inAppMessageTextInfoFromJson2 = jsonValue2 != null ? InAppMessageTextInfo.INSTANCE.fromJson(jsonValue2) : null;
            JsonValue jsonValue3 = jsonMapRequireMap.get("media");
            InAppMessageMediaInfo inAppMessageMediaInfoFromJson = jsonValue3 != null ? InAppMessageMediaInfo.INSTANCE.fromJson(jsonValue3) : null;
            JsonValue jsonValue4 = jsonMapRequireMap.get("footer");
            InAppMessageButtonInfo inAppMessageButtonInfoFromJson = jsonValue4 != null ? InAppMessageButtonInfo.INSTANCE.fromJson(jsonValue4) : null;
            JsonValue jsonValue5 = jsonMapRequireMap.get("buttons");
            if (jsonValue5 == null || (jsonListRequireList = jsonValue5.requireList()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                InAppMessageButtonInfo.Companion companion = InAppMessageButtonInfo.INSTANCE;
                listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    listEmptyList.add(companion.fromJson(it.next()));
                }
            }
            JsonValue jsonValue6 = jsonMapRequireMap.get("button_layout");
            if (jsonValue6 == null || (inAppMessageButtonLayoutTypeFromJson = InAppMessageButtonLayoutType.INSTANCE.fromJson(jsonValue6)) == null) {
                inAppMessageButtonLayoutTypeFromJson = InAppMessageButtonLayoutType.SEPARATE;
            }
            InAppMessageButtonLayoutType inAppMessageButtonLayoutType = inAppMessageButtonLayoutTypeFromJson;
            JsonValue jsonValue7 = jsonMapRequireMap.get("template");
            if (jsonValue7 == null || (templateFromJson = Template.INSTANCE.fromJson(jsonValue7)) == null) {
                templateFromJson = Template.HEADER_MEDIA_BODY;
            }
            Template template = templateFromJson;
            JsonValue jsonValue8 = jsonMapRequireMap.get("background_color");
            if (jsonValue8 == null || (inAppMessageColor = InAppMessageColor.INSTANCE.fromJson(jsonValue8)) == null) {
                inAppMessageColor = new InAppMessageColor(-1);
            }
            InAppMessageColor inAppMessageColor3 = inAppMessageColor;
            float f = jsonMapRequireMap.opt("border_radius").getFloat(BitmapDescriptorFactory.HUE_RED);
            JsonValue jsonValue9 = jsonMapRequireMap.get("dismiss_button_color");
            if (jsonValue9 == null || (inAppMessageColor2 = InAppMessageColor.INSTANCE.fromJson(jsonValue9)) == null) {
                inAppMessageColor2 = new InAppMessageColor(-16777216);
            }
            InAppMessageColor inAppMessageColor4 = inAppMessageColor2;
            JsonValue jsonValue10 = jsonMapRequireMap.get("allow_fullscreen_display");
            if (jsonValue10 == null) {
                z = false;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    boolValueOf = (Boolean) jsonValue10.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    boolValueOf = Boolean.valueOf(jsonValue10.getBoolean(false));
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        bool2 = (Boolean) Long.valueOf(jsonValue10.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        bool2 = (Boolean) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue10.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        bool2 = (Boolean) Double.valueOf(jsonValue10.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        bool2 = (Boolean) Float.valueOf(jsonValue10.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            z = false;
                            bool = (Boolean) Integer.valueOf(jsonValue10.getInt(0));
                        } else {
                            z = false;
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                bool = (Boolean) Integer.valueOf(jsonValue10.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                bool = (Boolean) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue10.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                bool = (Boolean) jsonValue10.optList();
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                bool = (Boolean) jsonValue10.optMap();
                            } else {
                                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + Boolean.class.getSimpleName() + "' for field 'allow_fullscreen_display" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                bool = (Boolean) jsonValue10.getJsonValue();
                            }
                        }
                        bool3 = bool;
                    }
                    bool3 = bool2;
                    z = false;
                }
                bool3 = boolValueOf;
                z = false;
            }
            return new Modal(inAppMessageTextInfoFromJson, inAppMessageTextInfoFromJson2, inAppMessageMediaInfoFromJson, inAppMessageButtonInfoFromJson, listEmptyList, inAppMessageButtonLayoutType, template, inAppMessageColor3, f, inAppMessageColor4, bool3 != null ? bool3.booleanValue() : z);
        }
    }

    public final boolean validate() {
        InAppMessageTextInfo inAppMessageTextInfo = this.heading;
        if (inAppMessageTextInfo != null && inAppMessageTextInfo.validate$urbanairship_automation_release()) {
            return true;
        }
        InAppMessageTextInfo inAppMessageTextInfo2 = this.body;
        return inAppMessageTextInfo2 != null && inAppMessageTextInfo2.validate$urbanairship_automation_release();
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() throws JsonException {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("heading", this.heading), TuplesKt.to(RateAppAction.BODY_KEY, this.body), TuplesKt.to("media", this.media), TuplesKt.to("footer", this.footer), TuplesKt.to("buttons", this.buttons), TuplesKt.to("button_layout", this.buttonLayoutType), TuplesKt.to("template", this.template), TuplesKt.to("background_color", this.backgroundColor), TuplesKt.to("dismiss_button_color", this.dismissButtonColor), TuplesKt.to("border_radius", Float.valueOf(this.borderRadius)), TuplesKt.to("allow_fullscreen_display", Boolean.valueOf(this.allowFullscreenDisplay))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Modal.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.content.Modal");
        Modal modal = (Modal) other;
        return Intrinsics.areEqual(this.heading, modal.heading) && Intrinsics.areEqual(this.body, modal.body) && Intrinsics.areEqual(this.media, modal.media) && Intrinsics.areEqual(this.footer, modal.footer) && Intrinsics.areEqual(this.buttons, modal.buttons) && this.buttonLayoutType == modal.buttonLayoutType && this.borderRadius == modal.borderRadius && this.template == modal.template && Intrinsics.areEqual(this.backgroundColor, modal.backgroundColor) && Intrinsics.areEqual(this.dismissButtonColor, modal.dismissButtonColor) && this.allowFullscreenDisplay == modal.allowFullscreenDisplay;
    }

    public int hashCode() {
        InAppMessageTextInfo inAppMessageTextInfo = this.heading;
        int iHashCode = (inAppMessageTextInfo != null ? inAppMessageTextInfo.hashCode() : 0) * 31;
        InAppMessageTextInfo inAppMessageTextInfo2 = this.body;
        int iHashCode2 = (iHashCode + (inAppMessageTextInfo2 != null ? inAppMessageTextInfo2.hashCode() : 0)) * 31;
        InAppMessageMediaInfo inAppMessageMediaInfo = this.media;
        int iHashCode3 = (iHashCode2 + (inAppMessageMediaInfo != null ? inAppMessageMediaInfo.hashCode() : 0)) * 31;
        InAppMessageButtonInfo inAppMessageButtonInfo = this.footer;
        return ((((((((((((((iHashCode3 + (inAppMessageButtonInfo != null ? inAppMessageButtonInfo.hashCode() : 0)) * 31) + this.buttons.hashCode()) * 31) + this.buttonLayoutType.hashCode()) * 31) + this.template.hashCode()) * 31) + this.backgroundColor.hashCode()) * 31) + this.dismissButtonColor.hashCode()) * 31) + Float.hashCode(this.borderRadius)) * 31) + Boolean.hashCode(this.allowFullscreenDisplay);
    }

    @NotNull
    public String toString() {
        return "Modal(heading=" + this.heading + ", body=" + this.body + ", media=" + this.media + ", footer=" + this.footer + ", buttons=" + this.buttons + ", buttonLayoutType=" + this.buttonLayoutType + ", template=" + this.template + ", backgroundColor=" + this.backgroundColor + ", dismissButtonColor=" + this.dismissButtonColor + ", borderRadius=" + this.borderRadius + ", allowFullscreenDisplay=" + this.allowFullscreenDisplay + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
