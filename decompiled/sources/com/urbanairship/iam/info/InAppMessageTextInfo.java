package com.urbanairship.iam.info;

import android.content.Context;
import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.UALog;
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
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0003+,-Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\r\u0010)\u001a\u00020\u001eH\u0000¢\u0006\u0002\b*R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006."}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageTextInfo;", "Lcom/urbanairship/json/JsonSerializable;", "text", "", "color", "Lcom/urbanairship/iam/info/InAppMessageColor;", TCEventPropertiesNames.TCP_SIZE, "", "fontFamilies", "", "alignment", "Lcom/urbanairship/iam/info/InAppMessageTextInfo$Alignment;", "style", "Lcom/urbanairship/iam/info/InAppMessageTextInfo$Style;", "drawableName", "(Ljava/lang/String;Lcom/urbanairship/iam/info/InAppMessageColor;Ljava/lang/Float;Ljava/util/List;Lcom/urbanairship/iam/info/InAppMessageTextInfo$Alignment;Ljava/util/List;Ljava/lang/String;)V", "getAlignment", "()Lcom/urbanairship/iam/info/InAppMessageTextInfo$Alignment;", "getColor", "()Lcom/urbanairship/iam/info/InAppMessageColor;", "getDrawableName", "()Ljava/lang/String;", "getFontFamilies", "()Ljava/util/List;", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getStyle", "getText", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "getDrawable", "", "context", "Landroid/content/Context;", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "validate", "validate$urbanairship_automation_release", "Alignment", "Companion", "Style", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageTextInfo implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Alignment alignment;
    private final InAppMessageColor color;
    private final String drawableName;
    private final List fontFamilies;
    private final Float size;
    private final List style;
    private final String text;

    public InAppMessageTextInfo(@NotNull String text, @Nullable InAppMessageColor inAppMessageColor, @Nullable Float f, @Nullable List<String> list, @Nullable Alignment alignment, @Nullable List<? extends Style> list2, @Nullable String str) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.color = inAppMessageColor;
        this.size = f;
        this.fontFamilies = list;
        this.alignment = alignment;
        this.style = list2;
        this.drawableName = str;
    }

    public /* synthetic */ InAppMessageTextInfo(String str, InAppMessageColor inAppMessageColor, Float f, List list, Alignment alignment, List list2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : inAppMessageColor, (i & 4) != 0 ? null : f, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : alignment, (i & 32) != 0 ? null : list2, (i & 64) == 0 ? str2 : null);
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final InAppMessageColor getColor() {
        return this.color;
    }

    @Nullable
    public final Float getSize() {
        return this.size;
    }

    @Nullable
    public final List<String> getFontFamilies() {
        return this.fontFamilies;
    }

    @Nullable
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Nullable
    public final List<Style> getStyle() {
        return this.style;
    }

    @Nullable
    public final String getDrawableName() {
        return this.drawableName;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageTextInfo$Style;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "BOLD", "ITALIC", "UNDERLINE", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Style implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Style[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final Style BOLD = new Style("BOLD", 0, "bold");
        public static final Style ITALIC = new Style("ITALIC", 1, "italic");
        public static final Style UNDERLINE = new Style("UNDERLINE", 2, "underline");

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{BOLD, ITALIC, UNDERLINE};
        }

        @NotNull
        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        private Style(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            Style[] styleArr$values = $values();
            $VALUES = styleArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(styleArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageTextInfo$Style$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/info/InAppMessageTextInfo$Style;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nInAppMessageTextInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageTextInfo.kt\ncom/urbanairship/iam/info/InAppMessageTextInfo$Style$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,186:1\n288#2,2:187\n*S KotlinDebug\n*F\n+ 1 InAppMessageTextInfo.kt\ncom/urbanairship/iam/info/InAppMessageTextInfo$Style$Companion\n*L\n49#1:187,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Style fromJson(@NotNull JsonValue value) throws JsonException {
                Style next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = strRequireString.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Iterator<Style> it = Style.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), lowerCase)) {
                        break;
                    }
                }
                Style style = next;
                if (style != null) {
                    return style;
                }
                throw new JsonException("Invalid style: " + value);
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageTextInfo$Alignment;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "LEFT", "CENTER", "RIGHT", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Alignment implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Alignment[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final Alignment LEFT = new Alignment("LEFT", 0, ViewProps.LEFT);
        public static final Alignment CENTER = new Alignment("CENTER", 1, "center");
        public static final Alignment RIGHT = new Alignment("RIGHT", 2, ViewProps.RIGHT);

        private static final /* synthetic */ Alignment[] $values() {
            return new Alignment[]{LEFT, CENTER, RIGHT};
        }

        @NotNull
        public static EnumEntries<Alignment> getEntries() {
            return $ENTRIES;
        }

        public static Alignment valueOf(String str) {
            return (Alignment) Enum.valueOf(Alignment.class, str);
        }

        public static Alignment[] values() {
            return (Alignment[]) $VALUES.clone();
        }

        private Alignment(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            Alignment[] alignmentArr$values = $values();
            $VALUES = alignmentArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(alignmentArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageTextInfo$Alignment$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/info/InAppMessageTextInfo$Alignment;", "value", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nInAppMessageTextInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageTextInfo.kt\ncom/urbanairship/iam/info/InAppMessageTextInfo$Alignment$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,186:1\n288#2,2:187\n*S KotlinDebug\n*F\n+ 1 InAppMessageTextInfo.kt\ncom/urbanairship/iam/info/InAppMessageTextInfo$Alignment$Companion\n*L\n77#1:187,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Alignment fromJson(@NotNull String value) throws JsonException {
                Alignment next;
                Intrinsics.checkNotNullParameter(value, "value");
                Iterator<Alignment> it = Alignment.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getJson(), value)) {
                        break;
                    }
                }
                Alignment alignment = next;
                if (alignment != null) {
                    return alignment;
                }
                throw new JsonException("Unsupported alignment value " + value);
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

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageTextInfo$Companion;", "", "()V", "ALIGNMENT_KEY", "", "ANDROID_DRAWABLE_RES_NAME_KEY", "COLOR_KEY", "FONT_FAMILY_KEY", "SIZE_KEY", "STYLE_KEY", "TEXT_KEY", "fromJson", "Lcom/urbanairship/iam/info/InAppMessageTextInfo;", "source", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nInAppMessageTextInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageTextInfo.kt\ncom/urbanairship/iam/info/InAppMessageTextInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,186:1\n44#2,15:187\n79#2,16:203\n79#2,16:219\n79#2,16:243\n1#3:202\n1549#4:235\n1620#4,3:236\n1549#4:239\n1620#4,3:240\n*S KotlinDebug\n*F\n+ 1 InAppMessageTextInfo.kt\ncom/urbanairship/iam/info/InAppMessageTextInfo$Companion\n*L\n114#1:187,15\n116#1:203,16\n117#1:219,16\n120#1:243,16\n118#1:235\n118#1:236,3\n119#1:239\n119#1:240,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final InAppMessageTextInfo fromJson(@NotNull JsonValue source) throws JsonException {
            String strOptString;
            Float fValueOf;
            Float f;
            String str;
            String strOptString2;
            ArrayList arrayList;
            String strOptString3;
            String str2;
            JsonList jsonListRequireList;
            Intrinsics.checkNotNullParameter(source, "source");
            JsonMap jsonMapOptMap = source.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            if (jsonMapOptMap.containsKey("style") && !jsonMapOptMap.opt("style").isJsonList()) {
                throw new JsonException("Style must be an array: " + jsonMapOptMap.opt("style"));
            }
            if (jsonMapOptMap.containsKey("font_family") && !jsonMapOptMap.opt("font_family").isJsonList()) {
                throw new JsonException("Fonts must be an array: " + jsonMapOptMap.opt("style"));
            }
            JsonValue jsonValue = jsonMapOptMap.get("text");
            if (jsonValue == null) {
                throw new JsonException("Missing required field: 'text" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                strOptString = (String) Boolean.valueOf(jsonValue.getBoolean(false));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                strOptString = (String) Long.valueOf(jsonValue.getLong(0L));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                strOptString = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                strOptString = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                strOptString = (String) Integer.valueOf(jsonValue.getInt(0));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                Object objOptList = jsonValue.optList();
                if (objOptList == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptList;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                Object objOptMap = jsonValue.optMap();
                if (objOptMap == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) objOptMap;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'text" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Object jsonValue2 = jsonValue.getJsonValue();
                if (jsonValue2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                strOptString = (String) jsonValue2;
            }
            String str3 = strOptString;
            JsonValue jsonValue3 = jsonMapOptMap.get("color");
            InAppMessageColor inAppMessageColorFromJson = jsonValue3 != null ? InAppMessageColor.INSTANCE.fromJson(jsonValue3) : null;
            JsonValue jsonValue4 = jsonMapOptMap.get(TCEventPropertiesNames.TCP_SIZE);
            if (jsonValue4 == null) {
                f = null;
            } else {
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Float.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    fValueOf = (Float) jsonValue4.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    fValueOf = (Float) Boolean.valueOf(jsonValue4.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    fValueOf = (Float) Long.valueOf(jsonValue4.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    fValueOf = (Float) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    fValueOf = (Float) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    fValueOf = Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    fValueOf = (Float) Integer.valueOf(jsonValue4.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    fValueOf = (Float) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    fValueOf = (Float) jsonValue4.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    fValueOf = (Float) jsonValue4.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + Float.class.getSimpleName() + "' for field '" + TCEventPropertiesNames.TCP_SIZE + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    fValueOf = (Float) jsonValue4.getJsonValue();
                }
                f = fValueOf;
            }
            JsonValue jsonValue5 = jsonMapOptMap.get("alignment");
            if (jsonValue5 == null) {
                str = "' for field '";
                strOptString2 = null;
            } else {
                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString2 = jsonValue5.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString2 = jsonValue5.optString();
                    if (strOptString2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString2 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "' for field '";
                    strOptString2 = (String) Long.valueOf(jsonValue5.getLong(0L));
                } else {
                    str = "' for field '";
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString2 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue5.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString2 = (String) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString2 = (String) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString2 = (String) Integer.valueOf(jsonValue5.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString2 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue5.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList2 = jsonValue5.optList();
                        if (objOptList2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap2 = jsonValue5.optMap();
                        if (objOptMap2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) objOptMap2;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "alignment" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue6 = jsonValue5.getJsonValue();
                        if (jsonValue6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString2 = (String) jsonValue6;
                    }
                }
                str = "' for field '";
            }
            Alignment alignmentFromJson = strOptString2 != null ? Alignment.INSTANCE.fromJson(strOptString2) : null;
            JsonValue jsonValue7 = jsonMapOptMap.get("style");
            if (jsonValue7 == null || (jsonListRequireList = jsonValue7.requireList()) == null) {
                arrayList = null;
            } else {
                Style.Companion companion = Style.INSTANCE;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
                Iterator<JsonValue> it = jsonListRequireList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(companion.fromJson(it.next()));
                }
                arrayList = arrayList2;
            }
            JsonList jsonListOptList = jsonMapOptMap.opt("font_family").optList();
            Intrinsics.checkNotNullExpressionValue(jsonListOptList, "optList(...)");
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
            Iterator<JsonValue> it2 = jsonListOptList.iterator();
            while (it2.hasNext()) {
                String strRequireString = it2.next().requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                arrayList3.add(strRequireString);
            }
            JsonValue jsonValue8 = jsonMapOptMap.get("android_drawable_res_name");
            if (jsonValue8 == null) {
                str2 = null;
            } else {
                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString3 = jsonValue8.optString();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString3 = (String) Boolean.valueOf(jsonValue8.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString3 = (String) Long.valueOf(jsonValue8.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue8.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString3 = (String) Double.valueOf(jsonValue8.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString3 = (String) Float.valueOf(jsonValue8.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    strOptString3 = (String) Integer.valueOf(jsonValue8.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue8.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    strOptString3 = (String) jsonValue8.optList();
                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    strOptString3 = (String) jsonValue8.optMap();
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + str + "android_drawable_res_name" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    strOptString3 = (String) jsonValue8.getJsonValue();
                }
                str2 = strOptString3;
            }
            return new InAppMessageTextInfo(str3, inAppMessageColorFromJson, f, arrayList3, alignmentFromJson, arrayList, str2);
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("text", this.text), TuplesKt.to("color", this.color), TuplesKt.to(TCEventPropertiesNames.TCP_SIZE, this.size), TuplesKt.to("alignment", this.alignment), TuplesKt.to("style", this.style), TuplesKt.to("font_family", this.fontFamilies), TuplesKt.to("android_drawable_res_name", this.drawableName)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public final int getDrawable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        final String str = this.drawableName;
        if (str == null) {
            return 0;
        }
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception unused) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.iam.info.InAppMessageTextInfo.getDrawable.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Drawable " + str + " no longer exists.";
                }
            }, 1, null);
            return 0;
        }
    }

    public final boolean validate$urbanairship_automation_release() {
        if (this.text.length() != 0) {
            return true;
        }
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.iam.info.InAppMessageTextInfo$validate$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "In-app text infos require nonempty text";
            }
        }, 1, null);
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(InAppMessageTextInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.info.InAppMessageTextInfo");
        InAppMessageTextInfo inAppMessageTextInfo = (InAppMessageTextInfo) other;
        if (Intrinsics.areEqual(this.text, inAppMessageTextInfo.text) && Intrinsics.areEqual(this.color, inAppMessageTextInfo.color) && Intrinsics.areEqual(this.size, inAppMessageTextInfo.size) && Intrinsics.areEqual(this.fontFamilies, inAppMessageTextInfo.fontFamilies) && this.alignment == inAppMessageTextInfo.alignment && Intrinsics.areEqual(this.style, inAppMessageTextInfo.style)) {
            return Intrinsics.areEqual(this.drawableName, inAppMessageTextInfo.drawableName);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.text, this.color, this.size, this.fontFamilies, this.alignment, this.style, this.drawableName);
    }

    @NotNull
    public String toString() {
        String string = getJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
