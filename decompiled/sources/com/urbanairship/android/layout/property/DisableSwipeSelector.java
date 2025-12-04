package com.urbanairship.android.layout.property;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/property/DisableSwipeSelector;", "Lcom/urbanairship/json/JsonSerializable;", "predicate", "Lcom/urbanairship/json/JsonPredicate;", "direction", "Lcom/urbanairship/android/layout/property/DisableSwipeSelector$Direction;", "(Lcom/urbanairship/json/JsonPredicate;Lcom/urbanairship/android/layout/property/DisableSwipeSelector$Direction;)V", "getDirection", "()Lcom/urbanairship/android/layout/property/DisableSwipeSelector$Direction;", "getPredicate", "()Lcom/urbanairship/json/JsonPredicate;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "", "Companion", "Direction", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DisableSwipeSelector implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Direction direction;
    private final JsonPredicate predicate;

    public static /* synthetic */ DisableSwipeSelector copy$default(DisableSwipeSelector disableSwipeSelector, JsonPredicate jsonPredicate, Direction direction, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonPredicate = disableSwipeSelector.predicate;
        }
        if ((i & 2) != 0) {
            direction = disableSwipeSelector.direction;
        }
        return disableSwipeSelector.copy(jsonPredicate, direction);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final JsonPredicate getPredicate() {
        return this.predicate;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Direction getDirection() {
        return this.direction;
    }

    @NotNull
    public final DisableSwipeSelector copy(@Nullable JsonPredicate predicate, @NotNull Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new DisableSwipeSelector(predicate, direction);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisableSwipeSelector)) {
            return false;
        }
        DisableSwipeSelector disableSwipeSelector = (DisableSwipeSelector) other;
        return Intrinsics.areEqual(this.predicate, disableSwipeSelector.predicate) && this.direction == disableSwipeSelector.direction;
    }

    public int hashCode() {
        JsonPredicate jsonPredicate = this.predicate;
        return ((jsonPredicate == null ? 0 : jsonPredicate.hashCode()) * 31) + this.direction.hashCode();
    }

    @NotNull
    public String toString() {
        return "DisableSwipeSelector(predicate=" + this.predicate + ", direction=" + this.direction + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DisableSwipeSelector(@Nullable JsonPredicate jsonPredicate, @NotNull Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.predicate = jsonPredicate;
        this.direction = direction;
    }

    public /* synthetic */ DisableSwipeSelector(JsonPredicate jsonPredicate, Direction direction, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jsonPredicate, direction);
    }

    @Nullable
    public final JsonPredicate getPredicate() {
        return this.predicate;
    }

    @NotNull
    public final Direction getDirection() {
        return this.direction;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/layout/property/DisableSwipeSelector$Direction;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "HORIZONTAL", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Direction implements JsonSerializable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Direction[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final Direction HORIZONTAL = new Direction("HORIZONTAL", 0, "horizontal");
        private final String json;

        private static final /* synthetic */ Direction[] $values() {
            return new Direction[]{HORIZONTAL};
        }

        @NotNull
        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        private Direction(String str, int i, String str2) {
            this.json = str2;
        }

        @NotNull
        public final String getJson() {
            return this.json;
        }

        static {
            Direction[] directionArr$values = $values();
            $VALUES = directionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(directionArr$values);
            INSTANCE = new Companion(null);
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValueWrap = JsonValue.wrap(this.json);
            Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
            return jsonValueWrap;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/layout/property/DisableSwipeSelector$Direction$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/layout/property/DisableSwipeSelector$Direction;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nDisableSwipeSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DisableSwipeSelector.kt\ncom/urbanairship/android/layout/property/DisableSwipeSelector$Direction$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n288#2,2:53\n*S KotlinDebug\n*F\n+ 1 DisableSwipeSelector.kt\ncom/urbanairship/android/layout/property/DisableSwipeSelector$Direction$Companion\n*L\n25#1:53,2\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final Direction fromJson(@NotNull JsonValue value) throws JsonException {
                Direction next;
                Intrinsics.checkNotNullParameter(value, "value");
                String strRequireString = value.requireString();
                Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
                Iterator<Direction> it = Direction.getEntries().iterator();
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
                Direction direction = next;
                if (direction != null) {
                    return direction;
                }
                throw new JsonException("Invalid direction value for type " + strRequireString);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/property/DisableSwipeSelector$Companion;", "", "()V", "DIRECTIONS", "", "PREDICATE", "TYPE", "fromJson", "Lcom/urbanairship/android/layout/property/DisableSwipeSelector;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nDisableSwipeSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DisableSwipeSelector.kt\ncom/urbanairship/android/layout/property/DisableSwipeSelector$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DisableSwipeSelector fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapRequireMap = value.requireMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
            JsonValue jsonValue = jsonMapRequireMap.get("when_state_matches");
            JsonPredicate jsonPredicate = jsonValue != null ? JsonPredicate.parse(jsonValue) : null;
            JsonValue jsonValueRequire = JsonExtensionsKt.requireMap(jsonMapRequireMap, "directions").require("type");
            Intrinsics.checkNotNullExpressionValue(jsonValueRequire, "require(...)");
            return new DisableSwipeSelector(jsonPredicate, Direction.INSTANCE.fromJson(jsonValueRequire));
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("when_state_matches", this.predicate), TuplesKt.to("directions", JsonExtensionsKt.jsonMapOf(TuplesKt.to("type", this.direction)))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
