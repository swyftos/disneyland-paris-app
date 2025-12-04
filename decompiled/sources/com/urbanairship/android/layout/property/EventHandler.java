package com.urbanairship.android.layout.property;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.property.StateAction;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/property/EventHandler;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "type", "Lcom/urbanairship/android/layout/property/EventHandler$Type;", "actions", "", "Lcom/urbanairship/android/layout/property/StateAction;", "(Lcom/urbanairship/android/layout/property/EventHandler$Type;Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "getType", "()Lcom/urbanairship/android/layout/property/EventHandler$Type;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Type", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEventHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventHandler.kt\ncom/urbanairship/android/layout/property/EventHandler\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n44#2,15:38\n44#2,15:53\n1549#3:68\n1620#3,3:69\n*S KotlinDebug\n*F\n+ 1 EventHandler.kt\ncom/urbanairship/android/layout/property/EventHandler\n*L\n13#1:38,15\n14#1:53,15\n14#1:68\n14#1:69,3\n*E\n"})
/* loaded from: classes5.dex */
public final /* data */ class EventHandler {
    private final List actions;
    private final Type type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventHandler copy$default(EventHandler eventHandler, Type type, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            type = eventHandler.type;
        }
        if ((i & 2) != 0) {
            list = eventHandler.actions;
        }
        return eventHandler.copy(type, list);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    @NotNull
    public final List<StateAction> component2() {
        return this.actions;
    }

    @NotNull
    public final EventHandler copy(@NotNull Type type, @NotNull List<? extends StateAction> actions) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actions, "actions");
        return new EventHandler(type, actions);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventHandler)) {
            return false;
        }
        EventHandler eventHandler = (EventHandler) other;
        return this.type == eventHandler.type && Intrinsics.areEqual(this.actions, eventHandler.actions);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.actions.hashCode();
    }

    @NotNull
    public String toString() {
        return "EventHandler(type=" + this.type + ", actions=" + this.actions + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public EventHandler(@NotNull Type type, @NotNull List<? extends StateAction> actions) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.type = type;
        this.actions = actions;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    @NotNull
    public final List<StateAction> getActions() {
        return this.actions;
    }

    public EventHandler(@NotNull JsonMap json) throws JsonException {
        String strOptString;
        JsonList jsonListOptList;
        Intrinsics.checkNotNullParameter(json, "json");
        Type.Companion companion = Type.INSTANCE;
        JsonValue jsonValue = json.get("type");
        if (jsonValue == null) {
            throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
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
                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Object jsonValue2 = jsonValue.toJsonValue();
            if (jsonValue2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            strOptString = (String) jsonValue2;
        }
        Type typeFrom = companion.from(strOptString);
        JsonValue jsonValue3 = json.get("state_actions");
        if (jsonValue3 == null) {
            throw new JsonException("Missing required field: 'state_actions" + CoreConstants.SINGLE_QUOTE_CHAR);
        }
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonList.class);
        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
            Object objOptString = jsonValue3.optString();
            if (objOptString == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) objOptString;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
            Object objOptString2 = jsonValue3.optString();
            if (objOptString2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) objOptString2;
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            jsonListOptList = (JsonList) Boolean.valueOf(jsonValue3.getBoolean(false));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            jsonListOptList = (JsonList) Long.valueOf(jsonValue3.getLong(0L));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
            jsonListOptList = (JsonList) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue3.getLong(0L)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
            jsonListOptList = (JsonList) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            jsonListOptList = (JsonList) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
            jsonListOptList = (JsonList) Integer.valueOf(jsonValue3.getInt(0));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
            jsonListOptList = (JsonList) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue3.getInt(0)));
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
            jsonListOptList = jsonValue3.optList();
            if (jsonListOptList == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
            JsonSerializable jsonSerializableOptMap = jsonValue3.optMap();
            if (jsonSerializableOptMap == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) jsonSerializableOptMap;
        } else {
            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                throw new JsonException("Invalid type '" + JsonList.class.getSimpleName() + "' for field 'state_actions" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            JsonSerializable jsonValue4 = jsonValue3.toJsonValue();
            if (jsonValue4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.urbanairship.json.JsonList");
            }
            jsonListOptList = (JsonList) jsonValue4;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListOptList, 10));
        for (JsonValue jsonValue5 : jsonListOptList) {
            StateAction.Companion companion2 = StateAction.INSTANCE;
            JsonMap jsonMapOptMap = jsonValue5.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            arrayList.add(companion2.fromJson(jsonMapOptMap));
        }
        this(typeFrom, arrayList);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbanairship/android/layout/property/EventHandler$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TAP", "FORM_INPUT", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        private final String value;
        public static final Type TAP = new Type("TAP", 0, "tap");
        public static final Type FORM_INPUT = new Type("FORM_INPUT", 1, "form_input");

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{TAP, FORM_INPUT};
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String str, int i, String str2) {
            this.value = str2;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            INSTANCE = new Companion(null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/EventHandler$Type$Companion;", "", "()V", "from", "Lcom/urbanairship/android/layout/property/EventHandler$Type;", "value", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nEventHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventHandler.kt\ncom/urbanairship/android/layout/property/EventHandler$Type$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,37:1\n1282#2,2:38\n*S KotlinDebug\n*F\n+ 1 EventHandler.kt\ncom/urbanairship/android/layout/property/EventHandler$Type$Companion\n*L\n25#1:38,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Type from(@NotNull String value) throws JsonException {
                Type type;
                Intrinsics.checkNotNullParameter(value, "value");
                Type[] typeArrValues = Type.values();
                int length = typeArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        type = null;
                        break;
                    }
                    type = typeArrValues[i];
                    if (Intrinsics.areEqual(type.getValue(), value)) {
                        break;
                    }
                    i++;
                }
                if (type != null) {
                    return type;
                }
                throw new JsonException("Unknown EventHandler type: '" + value + CoreConstants.SINGLE_QUOTE_CHAR);
            }
        }
    }
}
