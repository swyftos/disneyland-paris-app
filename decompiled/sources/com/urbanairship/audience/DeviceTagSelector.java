package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.util.ObjectsCompat;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonPredicate;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/audience/DeviceTagSelector;", "Lcom/urbanairship/json/JsonSerializable;", "type", "Lcom/urbanairship/audience/DeviceTagSelector$Type;", "tag", "", "selectors", "", "(Lcom/urbanairship/audience/DeviceTagSelector$Type;Ljava/lang/String;Ljava/util/List;)V", "getSelectors$urbanairship_core_release", "()Ljava/util/List;", "getTag$urbanairship_core_release", "()Ljava/lang/String;", "getType$urbanairship_core_release", "()Lcom/urbanairship/audience/DeviceTagSelector$Type;", "apply", "", FetchDeviceInfoAction.TAGS_KEY, "", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "Type", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class DeviceTagSelector implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List selectors;
    private final String tag;
    private final Type type;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.TAG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.NOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Type.AND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Type.OR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private DeviceTagSelector(Type type, String str, List list) {
        this.type = type;
        this.tag = str;
        this.selectors = list;
    }

    @NotNull
    /* renamed from: getType$urbanairship_core_release, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: getTag$urbanairship_core_release, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* synthetic */ DeviceTagSelector(Type type, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, (i & 2) != 0 ? null : str, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final List<DeviceTagSelector> getSelectors$urbanairship_core_release() {
        return this.selectors;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0014\b\u0001\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J!\u0010\u000e\u001a\u00020\u00042\u0014\b\u0001\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\u00020\u00042\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/urbanairship/audience/DeviceTagSelector$Companion;", "", "()V", JsonPredicate.AND_PREDICATE_TYPE, "Lcom/urbanairship/audience/DeviceTagSelector;", "selectors", "", "([Lcom/urbanairship/audience/DeviceTagSelector;)Lcom/urbanairship/audience/DeviceTagSelector;", "", "fromJson", "value", "Lcom/urbanairship/json/JsonValue;", JsonPredicate.NOT_PREDICATE_TYPE, "selector", JsonPredicate.OR_PREDICATE_TYPE, "parseSelectors", "jsonList", "Lcom/urbanairship/json/JsonList;", "tag", "", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final DeviceTagSelector and(@Size(min = 1) @NotNull List<DeviceTagSelector> selectors) {
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            return new DeviceTagSelector(Type.AND, null, selectors, 2, null);
        }

        @NotNull
        public final DeviceTagSelector and(@Size(min = 1) @NotNull DeviceTagSelector... selectors) {
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            return new DeviceTagSelector(Type.AND, null, CollectionsKt.listOf(Arrays.copyOf(selectors, selectors.length)), 2, null);
        }

        @NotNull
        public final DeviceTagSelector or(@Size(min = 1) @NotNull List<DeviceTagSelector> selectors) {
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            return new DeviceTagSelector(Type.OR, null, selectors, 2, null);
        }

        @NotNull
        public final DeviceTagSelector or(@Size(min = 1) @NotNull DeviceTagSelector... selectors) {
            Intrinsics.checkNotNullParameter(selectors, "selectors");
            return new DeviceTagSelector(Type.OR, null, CollectionsKt.listOf(Arrays.copyOf(selectors, selectors.length)), 2, null);
        }

        @NotNull
        public final DeviceTagSelector not(@NotNull DeviceTagSelector selector) {
            Intrinsics.checkNotNullParameter(selector, "selector");
            return new DeviceTagSelector(Type.NOT, null, CollectionsKt.listOf(selector), 2, null);
        }

        @NotNull
        public final DeviceTagSelector tag(@NotNull String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            return new DeviceTagSelector(Type.TAG, tag, null, 4, null);
        }

        @NotNull
        public final DeviceTagSelector fromJson(@NotNull JsonValue value) throws JsonException {
            Intrinsics.checkNotNullParameter(value, "value");
            JsonMap jsonMapOptMap = value.optMap();
            Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
            Type type = Type.TAG;
            if (jsonMapOptMap.containsKey(type.getValue())) {
                String string = jsonMapOptMap.opt(type.getValue()).getString();
                if (string == null) {
                    throw new JsonException("Tag selector expected a tag: " + jsonMapOptMap.opt(type.getValue()));
                }
                return tag(string);
            }
            Type type2 = Type.OR;
            if (jsonMapOptMap.containsKey(type2.getValue())) {
                JsonList list = jsonMapOptMap.opt(type2.getValue()).getList();
                if (list == null) {
                    throw new JsonException("OR selector expected array of tag selectors: " + jsonMapOptMap.opt(type2.getValue()));
                }
                return or((List<DeviceTagSelector>) parseSelectors(list));
            }
            Type type3 = Type.AND;
            if (jsonMapOptMap.containsKey(type3.getValue())) {
                JsonList list2 = jsonMapOptMap.opt(type3.getValue()).getList();
                if (list2 == null) {
                    throw new JsonException("AND selector expected array of tag selectors: " + jsonMapOptMap.opt(type3.getValue()));
                }
                return and((List<DeviceTagSelector>) parseSelectors(list2));
            }
            Type type4 = Type.NOT;
            if (jsonMapOptMap.containsKey(type4.getValue())) {
                JsonValue jsonValueOpt = jsonMapOptMap.opt(type4.getValue());
                Intrinsics.checkNotNullExpressionValue(jsonValueOpt, "opt(...)");
                return not(fromJson(jsonValueOpt));
            }
            throw new JsonException("Json value did not contain a valid selector: " + value);
        }

        private final List parseSelectors(JsonList jsonList) throws JsonException {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = jsonList.iterator();
            while (it.hasNext()) {
                JsonValue next = it.next();
                Intrinsics.checkNotNull(next);
                arrayList.add(fromJson(next));
            }
            if (arrayList.isEmpty()) {
                throw new JsonException("Expected 1 or more selectors");
            }
            return arrayList;
        }
    }

    public final boolean apply(@NotNull Collection<String> tags) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i == 1) {
            return CollectionsKt.contains(tags, this.tag);
        }
        if (i != 2) {
            if (i == 3) {
                Iterator it = this.selectors.iterator();
                while (it.hasNext()) {
                    if (!((DeviceTagSelector) it.next()).apply(tags)) {
                        return false;
                    }
                }
                return true;
            }
            if (i == 4) {
                Iterator it2 = this.selectors.iterator();
                while (it2.hasNext()) {
                    if (((DeviceTagSelector) it2.next()).apply(tags)) {
                        return true;
                    }
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!((DeviceTagSelector) this.selectors.get(0)).apply(tags)) {
            return true;
        }
        return false;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonMap.Builder builderNewBuilder = JsonMap.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        int i = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i == 1) {
            builderNewBuilder.put(this.type.getValue(), this.tag);
        } else if (i == 2) {
            builderNewBuilder.put(this.type.getValue(), (JsonSerializable) this.selectors.get(0));
        } else if (i == 3 || i == 4) {
            builderNewBuilder.put(this.type.getValue(), JsonValue.wrapOpt(this.selectors));
        }
        JsonValue jsonValue = builderNewBuilder.build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(DeviceTagSelector.class, other.getClass())) {
            return false;
        }
        DeviceTagSelector deviceTagSelector = (DeviceTagSelector) other;
        return ObjectsCompat.equals(this.type, deviceTagSelector.type) && ObjectsCompat.equals(this.tag, deviceTagSelector.tag) && ObjectsCompat.equals(this.selectors, deviceTagSelector.selectors);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.type, this.tag, this.selectors);
    }

    @NotNull
    public String toString() {
        String string = getJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/audience/DeviceTagSelector$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OR", "AND", "NOT", "TAG", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        private final String value;
        public static final Type OR = new Type("OR", 0, JsonPredicate.OR_PREDICATE_TYPE);
        public static final Type AND = new Type("AND", 1, JsonPredicate.AND_PREDICATE_TYPE);
        public static final Type NOT = new Type("NOT", 2, JsonPredicate.NOT_PREDICATE_TYPE);
        public static final Type TAG = new Type("TAG", 3, "tag");

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{OR, AND, NOT, TAG};
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
        }
    }
}
