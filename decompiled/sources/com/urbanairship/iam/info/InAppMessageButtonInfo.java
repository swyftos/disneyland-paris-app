package com.urbanairship.iam.info;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0002()BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\r\u0010&\u001a\u00020\u001eH\u0000¢\u0006\u0002\b'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "label", "Lcom/urbanairship/iam/info/InAppMessageTextInfo;", "actions", "Lcom/urbanairship/json/JsonMap;", "behavior", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior;", ViewProps.BACKGROUND_COLOR, "Lcom/urbanairship/iam/info/InAppMessageColor;", ViewProps.BORDER_COLOR, "borderRadius", "", "(Ljava/lang/String;Lcom/urbanairship/iam/info/InAppMessageTextInfo;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior;Lcom/urbanairship/iam/info/InAppMessageColor;Lcom/urbanairship/iam/info/InAppMessageColor;F)V", "getActions", "()Lcom/urbanairship/json/JsonMap;", "getBackgroundColor", "()Lcom/urbanairship/iam/info/InAppMessageColor;", "getBehavior", "()Lcom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior;", "getBorderColor", "getBorderRadius", "()F", "getIdentifier", "()Ljava/lang/String;", "getLabel", "()Lcom/urbanairship/iam/info/InAppMessageTextInfo;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "validate", "validate$urbanairship_automation_release", "Behavior", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InAppMessageButtonInfo implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_ID_LENGTH = 100;
    private final JsonMap actions;
    private final InAppMessageColor backgroundColor;
    private final Behavior behavior;
    private final InAppMessageColor borderColor;
    private final float borderRadius;
    private final String identifier;
    private final InAppMessageTextInfo label;

    public InAppMessageButtonInfo(@NotNull String identifier, @NotNull InAppMessageTextInfo label, @Nullable JsonMap jsonMap, @Nullable Behavior behavior, @Nullable InAppMessageColor inAppMessageColor, @Nullable InAppMessageColor inAppMessageColor2, float f) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(label, "label");
        this.identifier = identifier;
        this.label = label;
        this.actions = jsonMap;
        this.behavior = behavior;
        this.backgroundColor = inAppMessageColor;
        this.borderColor = inAppMessageColor2;
        this.borderRadius = f;
    }

    public /* synthetic */ InAppMessageButtonInfo(String str, InAppMessageTextInfo inAppMessageTextInfo, JsonMap jsonMap, Behavior behavior, InAppMessageColor inAppMessageColor, InAppMessageColor inAppMessageColor2, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, inAppMessageTextInfo, (i & 4) != 0 ? null : jsonMap, (i & 8) != 0 ? null : behavior, (i & 16) != 0 ? null : inAppMessageColor, (i & 32) != 0 ? null : inAppMessageColor2, (i & 64) != 0 ? 0.0f : f);
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    @NotNull
    public final InAppMessageTextInfo getLabel() {
        return this.label;
    }

    @Nullable
    public final JsonMap getActions() {
        return this.actions;
    }

    @Nullable
    public final Behavior getBehavior() {
        return this.behavior;
    }

    @Nullable
    public final InAppMessageColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final InAppMessageColor getBorderColor() {
        return this.borderColor;
    }

    public final float getBorderRadius() {
        return this.borderRadius;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "DISMISS", "CANCEL", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Behavior implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Behavior[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String json;
        public static final Behavior DISMISS = new Behavior("DISMISS", 0, "dismiss");
        public static final Behavior CANCEL = new Behavior("CANCEL", 1, "cancel");

        private static final /* synthetic */ Behavior[] $values() {
            return new Behavior[]{DISMISS, CANCEL};
        }

        @NotNull
        public static EnumEntries<Behavior> getEntries() {
            return $ENTRIES;
        }

        public static Behavior valueOf(String str) {
            return (Behavior) Enum.valueOf(Behavior.class, str);
        }

        public static Behavior[] values() {
            return (Behavior[]) $VALUES.clone();
        }

        private Behavior(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        /* renamed from: getJson$urbanairship_automation_release, reason: from getter */
        public final String getJson() {
            return this.json;
        }

        static {
            Behavior[] behaviorArr$values = $values();
            $VALUES = behaviorArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(behaviorArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nInAppMessageButtonInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageButtonInfo.kt\ncom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,160:1\n288#2,2:161\n*S KotlinDebug\n*F\n+ 1 InAppMessageButtonInfo.kt\ncom/urbanairship/iam/info/InAppMessageButtonInfo$Behavior$Companion\n*L\n65#1:161,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Behavior fromJson(@NotNull JsonValue value) throws JsonException {
                Behavior next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<Behavior> it = Behavior.getEntries().iterator();
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
                Behavior behavior = next;
                if (behavior != null) {
                    return behavior;
                }
                throw new JsonException("Invalid behaviour value " + strRequireString);
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/iam/info/InAppMessageButtonInfo$Companion;", "", "()V", "ACTIONS_KEY", "", "BACKGROUND_COLOR_KEY", "BEHAVIOR_KEY", "BORDER_COLOR_KEY", "BORDER_RADIUS_KEY", "ID_KEY", "LABEL_KEY", "MAX_ID_LENGTH", "", "fromJson", "Lcom/urbanairship/iam/info/InAppMessageButtonInfo;", "source", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nInAppMessageButtonInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageButtonInfo.kt\ncom/urbanairship/iam/info/InAppMessageButtonInfo$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,160:1\n44#2,15:161\n79#2,16:177\n1#3:176\n*S KotlinDebug\n*F\n+ 1 InAppMessageButtonInfo.kt\ncom/urbanairship/iam/info/InAppMessageButtonInfo$Companion\n*L\n103#1:161,15\n109#1:177,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final InAppMessageButtonInfo fromJson(@NotNull JsonValue source) throws JsonException {
            String strOptString;
            JsonMap jsonMapOptMap;
            JsonMap jsonMap;
            Intrinsics.checkNotNullParameter(source, "source");
            JsonMap jsonMapOptMap2 = source.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
            if (jsonMapOptMap2.require("id").requireString().length() <= 100) {
                JsonValue jsonValue = jsonMapOptMap2.get("id");
                if (jsonValue != null) {
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
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue2 = jsonValue.toJsonValue();
                        if (jsonValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        strOptString = (String) jsonValue2;
                    }
                    String str = strOptString;
                    JsonValue jsonValueRequire = jsonMapOptMap2.require("label");
                    Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
                    InAppMessageTextInfo inAppMessageTextInfoFromJson = InAppMessageTextInfo.INSTANCE.fromJson(jsonValueRequire);
                    JsonValue jsonValue3 = jsonMapOptMap2.get("behavior");
                    Behavior behaviorFromJson = jsonValue3 != null ? Behavior.INSTANCE.fromJson(jsonValue3) : null;
                    float f = jsonMapOptMap2.opt("border_radius").getFloat(BitmapDescriptorFactory.HUE_RED);
                    JsonValue jsonValue4 = jsonMapOptMap2.get("border_color");
                    InAppMessageColor inAppMessageColorFromJson = jsonValue4 != null ? InAppMessageColor.INSTANCE.fromJson(jsonValue4) : null;
                    JsonValue jsonValue5 = jsonMapOptMap2.get("background_color");
                    InAppMessageColor inAppMessageColorFromJson2 = jsonValue5 != null ? InAppMessageColor.INSTANCE.fromJson(jsonValue5) : null;
                    JsonValue jsonValue6 = jsonMapOptMap2.get("actions");
                    if (jsonValue6 == null) {
                        jsonMap = null;
                    } else {
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            jsonMapOptMap = (JsonMap) jsonValue6.optString();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue6.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue6.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue6.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue6.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue6.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue6.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue6.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            jsonMapOptMap = (JsonMap) jsonValue6.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap = jsonValue6.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'actions" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonMapOptMap = (JsonMap) jsonValue6.toJsonValue();
                        }
                        jsonMap = jsonMapOptMap;
                    }
                    return new InAppMessageButtonInfo(str, inAppMessageTextInfoFromJson, jsonMap, behaviorFromJson, inAppMessageColorFromJson2, inAppMessageColorFromJson, f);
                }
                throw new JsonException("Missing required field: 'id" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            throw new JsonException("identifier is too long");
        }
    }

    public final boolean validate$urbanairship_automation_release() {
        if (!this.label.validate$urbanairship_automation_release()) {
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.iam.info.InAppMessageButtonInfo$validate$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "In-app button infos require a nonempty label";
                }
            }, 1, null);
            return false;
        }
        if (this.identifier.length() != 0 && this.identifier.length() <= 100) {
            return true;
        }
        UALog.d$default(null, new Function0() { // from class: com.urbanairship.iam.info.InAppMessageButtonInfo$validate$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "In-app button infos require an identifier between [1, 100] characters";
            }
        }, 1, null);
        return false;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    public JsonValue toJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("id", this.identifier), TuplesKt.to("label", this.label), TuplesKt.to("behavior", this.behavior), TuplesKt.to("border_radius", Float.valueOf(this.borderRadius)), TuplesKt.to("border_color", this.borderColor), TuplesKt.to("background_color", this.backgroundColor), TuplesKt.to("actions", this.actions)).toJsonValue();
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
        if (!Intrinsics.areEqual(InAppMessageButtonInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.iam.info.InAppMessageButtonInfo");
        InAppMessageButtonInfo inAppMessageButtonInfo = (InAppMessageButtonInfo) other;
        return Intrinsics.areEqual(this.identifier, inAppMessageButtonInfo.identifier) && Intrinsics.areEqual(this.label, inAppMessageButtonInfo.label) && Intrinsics.areEqual(this.actions, inAppMessageButtonInfo.actions) && this.behavior == inAppMessageButtonInfo.behavior && Intrinsics.areEqual(this.backgroundColor, inAppMessageButtonInfo.backgroundColor) && Intrinsics.areEqual(this.borderColor, inAppMessageButtonInfo.borderColor) && this.borderRadius == inAppMessageButtonInfo.borderRadius;
    }

    public int hashCode() {
        return Objects.hash(this.identifier, this.label, this.actions, this.behavior, this.backgroundColor, this.borderColor, Float.valueOf(this.borderRadius));
    }
}
