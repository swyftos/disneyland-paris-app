package com.urbanairship.iam.content;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import com.contentsquare.android.api.Currencies;
import com.facebook.react.uimanager.ViewProps;
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
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0002/0Bm\b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012Jp\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0007J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020%R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/urbanairship/iam/content/Fullscreen;", "Lcom/urbanairship/json/JsonSerializable;", "heading", "Lcom/urbanairship/iam/info/InAppMessageTextInfo;", RateAppAction.BODY_KEY, "media", "Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "footer", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "buttons", "", "buttonLayoutType", "Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "template", "Lcom/urbanairship/iam/content/Fullscreen$Template;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/iam/info/InAppMessageColor;", "dismissButtonColor", "(Lcom/urbanairship/iam/info/InAppMessageTextInfo;Lcom/urbanairship/iam/info/InAppMessageTextInfo;Lcom/urbanairship/iam/info/InAppMessageMediaInfo;Lcom/urbanairship/iam/info/InAppMessageButtonInfo;Ljava/util/List;Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;Lcom/urbanairship/iam/content/Fullscreen$Template;Lcom/urbanairship/iam/info/InAppMessageColor;Lcom/urbanairship/iam/info/InAppMessageColor;)V", "getBackgroundColor", "()Lcom/urbanairship/iam/info/InAppMessageColor;", "getBody", "()Lcom/urbanairship/iam/info/InAppMessageTextInfo;", "getButtonLayoutType", "()Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "getButtons", "()Ljava/util/List;", "getDismissButtonColor", "getFooter", "()Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "getHeading", "getMedia", "()Lcom/urbanairship/iam/info/InAppMessageMediaInfo;", "getTemplate", "()Lcom/urbanairship/iam/content/Fullscreen$Template;", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "validate", "Companion", "Template", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Fullscreen implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_BUTTONS = 5;
    private final InAppMessageColor backgroundColor;
    private final InAppMessageTextInfo body;
    private final InAppMessageButtonLayoutType buttonLayoutType;
    private final List buttons;
    private final InAppMessageColor dismissButtonColor;
    private final InAppMessageButtonInfo footer;
    private final InAppMessageTextInfo heading;
    private final InAppMessageMediaInfo media;
    private final Template template;

    @JvmOverloads
    @NotNull
    public final Fullscreen copy() {
        return copy$default(this, null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo) {
        return copy$default(this, inAppMessageTextInfo, null, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_POSITION_TYPE, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, null, null, null, null, null, null, null, TypedValues.PositionType.TYPE_CURVE_FIT, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, null, null, null, null, null, null, 504, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo) {
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, null, null, null, null, null, Currencies.MNT, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, null, null, null, null, Currencies.MUR, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, null, null, null, 448, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, template, null, null, 384, null);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return copy$default(this, inAppMessageTextInfo, inAppMessageTextInfo2, inAppMessageMediaInfo, inAppMessageButtonInfo, buttons, buttonLayoutType, template, backgroundColor, null, 256, null);
    }

    @VisibleForTesting
    public Fullscreen(@Nullable InAppMessageTextInfo inAppMessageTextInfo, @Nullable InAppMessageTextInfo inAppMessageTextInfo2, @Nullable InAppMessageMediaInfo inAppMessageMediaInfo, @Nullable InAppMessageButtonInfo inAppMessageButtonInfo, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor) {
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
        this.dismissButtonColor = dismissButtonColor;
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

    public /* synthetic */ Fullscreen(InAppMessageTextInfo inAppMessageTextInfo, InAppMessageTextInfo inAppMessageTextInfo2, InAppMessageMediaInfo inAppMessageMediaInfo, InAppMessageButtonInfo inAppMessageButtonInfo, List list, InAppMessageButtonLayoutType inAppMessageButtonLayoutType, Template template, InAppMessageColor inAppMessageColor, InAppMessageColor inAppMessageColor2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : inAppMessageTextInfo, (i & 2) != 0 ? null : inAppMessageTextInfo2, (i & 4) != 0 ? null : inAppMessageMediaInfo, (i & 8) != 0 ? null : inAppMessageButtonInfo, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? InAppMessageButtonLayoutType.SEPARATE : inAppMessageButtonLayoutType, template, (i & 128) != 0 ? new InAppMessageColor(-1) : inAppMessageColor, (i & 256) != 0 ? new InAppMessageColor(-16777216) : inAppMessageColor2);
    }

    @NotNull
    public final List<InAppMessageButtonInfo> getButtons() {
        return this.buttons;
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

    public static /* synthetic */ Fullscreen copy$default(Fullscreen fullscreen, InAppMessageTextInfo inAppMessageTextInfo, InAppMessageTextInfo inAppMessageTextInfo2, InAppMessageMediaInfo inAppMessageMediaInfo, InAppMessageButtonInfo inAppMessageButtonInfo, List list, InAppMessageButtonLayoutType inAppMessageButtonLayoutType, Template template, InAppMessageColor inAppMessageColor, InAppMessageColor inAppMessageColor2, int i, Object obj) {
        return fullscreen.copy((i & 1) != 0 ? fullscreen.heading : inAppMessageTextInfo, (i & 2) != 0 ? fullscreen.body : inAppMessageTextInfo2, (i & 4) != 0 ? fullscreen.media : inAppMessageMediaInfo, (i & 8) != 0 ? fullscreen.footer : inAppMessageButtonInfo, (i & 16) != 0 ? fullscreen.buttons : list, (i & 32) != 0 ? fullscreen.buttonLayoutType : inAppMessageButtonLayoutType, (i & 64) != 0 ? fullscreen.template : template, (i & 128) != 0 ? fullscreen.backgroundColor : inAppMessageColor, (i & 256) != 0 ? fullscreen.dismissButtonColor : inAppMessageColor2);
    }

    @JvmOverloads
    @NotNull
    public final Fullscreen copy(@Nullable InAppMessageTextInfo heading, @Nullable InAppMessageTextInfo body, @Nullable InAppMessageMediaInfo media, @Nullable InAppMessageButtonInfo footer, @NotNull List<InAppMessageButtonInfo> buttons, @NotNull InAppMessageButtonLayoutType buttonLayoutType, @NotNull Template template, @NotNull InAppMessageColor backgroundColor, @NotNull InAppMessageColor dismissButtonColor) {
        Intrinsics.checkNotNullParameter(buttons, "buttons");
        Intrinsics.checkNotNullParameter(buttonLayoutType, "buttonLayoutType");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(dismissButtonColor, "dismissButtonColor");
        return new Fullscreen(heading, body, media, footer, buttons, buttonLayoutType, template, backgroundColor, dismissButtonColor);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/content/Fullscreen$Template;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "HEADER_MEDIA_BODY", "MEDIA_HEADER_BODY", "HEADER_BODY_MEDIA", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/content/Fullscreen$Template$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/content/Fullscreen$Template;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nFullscreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fullscreen.kt\ncom/urbanairship/iam/content/Fullscreen$Template$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,203:1\n288#2,2:204\n*S KotlinDebug\n*F\n+ 1 Fullscreen.kt\ncom/urbanairship/iam/content/Fullscreen$Template$Companion\n*L\n104#1:204,2\n*E\n"})
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

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/iam/content/Fullscreen$Companion;", "", "()V", "BACKGROUND_COLOR_KEY", "", "BODY_KEY", "BUTTONS_KEY", "BUTTON_LAYOUT_KEY", "DISMISS_BUTTON_COLOR_KEY", "FOOTER_KEY", "HEADING_KEY", "MAX_BUTTONS", "", "MEDIA_KEY", "TEMPLATE_KEY", "fromJson", "Lcom/urbanairship/iam/content/Fullscreen;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFullscreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Fullscreen.kt\ncom/urbanairship/iam/content/Fullscreen$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,203:1\n1549#2:204\n1620#2,3:205\n1#3:208\n*S KotlinDebug\n*F\n+ 1 Fullscreen.kt\ncom/urbanairship/iam/content/Fullscreen$Companion\n*L\n138#1:204\n138#1:205,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Fullscreen fromJson(@NotNull JsonValue value) throws JsonException {
            List listEmptyList;
            InAppMessageButtonLayoutType inAppMessageButtonLayoutTypeFromJson;
            Template templateFromJson;
            InAppMessageColor inAppMessageColor;
            InAppMessageColor inAppMessageColor2;
            JsonList jsonListRequireList;
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("buttons");
            if (jsonValue == null || (jsonListRequireList = jsonValue.requireList()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                InAppMessageButtonInfo.Companion companion = InAppMessageButtonInfo.INSTANCE;
                listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    listEmptyList.add(companion.fromJson(it.next()));
                }
            }
            List list = listEmptyList;
            if (list.size() > 2) {
                inAppMessageButtonLayoutTypeFromJson = InAppMessageButtonLayoutType.STACKED;
            } else {
                JsonValue jsonValue2 = jsonMapRequireMap.get("button_layout");
                if (jsonValue2 == null || (inAppMessageButtonLayoutTypeFromJson = InAppMessageButtonLayoutType.INSTANCE.fromJson(jsonValue2)) == null) {
                    inAppMessageButtonLayoutTypeFromJson = InAppMessageButtonLayoutType.SEPARATE;
                }
            }
            InAppMessageButtonLayoutType inAppMessageButtonLayoutType = inAppMessageButtonLayoutTypeFromJson;
            JsonValue jsonValue3 = jsonMapRequireMap.get("heading");
            InAppMessageTextInfo inAppMessageTextInfoFromJson = jsonValue3 != null ? InAppMessageTextInfo.INSTANCE.fromJson(jsonValue3) : null;
            JsonValue jsonValue4 = jsonMapRequireMap.get(RateAppAction.BODY_KEY);
            InAppMessageTextInfo inAppMessageTextInfoFromJson2 = jsonValue4 != null ? InAppMessageTextInfo.INSTANCE.fromJson(jsonValue4) : null;
            JsonValue jsonValue5 = jsonMapRequireMap.get("media");
            InAppMessageMediaInfo inAppMessageMediaInfoFromJson = jsonValue5 != null ? InAppMessageMediaInfo.INSTANCE.fromJson(jsonValue5) : null;
            JsonValue jsonValue6 = jsonMapRequireMap.get("footer");
            InAppMessageButtonInfo inAppMessageButtonInfoFromJson = jsonValue6 != null ? InAppMessageButtonInfo.INSTANCE.fromJson(jsonValue6) : null;
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
            JsonValue jsonValue9 = jsonMapRequireMap.get("dismiss_button_color");
            if (jsonValue9 == null || (inAppMessageColor2 = InAppMessageColor.INSTANCE.fromJson(jsonValue9)) == null) {
                inAppMessageColor2 = new InAppMessageColor(-16777216);
            }
            return new Fullscreen(inAppMessageTextInfoFromJson, inAppMessageTextInfoFromJson2, inAppMessageMediaInfoFromJson, inAppMessageButtonInfoFromJson, list, inAppMessageButtonLayoutType, template, inAppMessageColor3, inAppMessageColor2);
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
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("heading", this.heading), TuplesKt.to(RateAppAction.BODY_KEY, this.body), TuplesKt.to("media", this.media), TuplesKt.to("buttons", this.buttons), TuplesKt.to("button_layout", this.buttonLayoutType), TuplesKt.to("footer", this.footer), TuplesKt.to("template", this.template), TuplesKt.to("background_color", this.backgroundColor), TuplesKt.to("dismiss_button_color", this.dismissButtonColor)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
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
        if (!Intrinsics.areEqual(Fullscreen.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.content.Fullscreen");
        Fullscreen fullscreen = (Fullscreen) other;
        if (Intrinsics.areEqual(this.heading, fullscreen.heading) && Intrinsics.areEqual(this.body, fullscreen.body) && Intrinsics.areEqual(this.media, fullscreen.media) && Intrinsics.areEqual(this.footer, fullscreen.footer) && Intrinsics.areEqual(this.buttons, fullscreen.buttons) && this.buttonLayoutType == fullscreen.buttonLayoutType && this.template == fullscreen.template && Intrinsics.areEqual(this.backgroundColor, fullscreen.backgroundColor)) {
            return Intrinsics.areEqual(this.dismissButtonColor, fullscreen.dismissButtonColor);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.heading, this.body, this.media, this.footer, this.buttons, this.buttonLayoutType, this.template, this.backgroundColor, this.dismissButtonColor);
    }
}
