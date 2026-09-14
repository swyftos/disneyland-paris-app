package com.urbanairship.iam.info;

import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m1836d2 = {"Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson$urbanairship_automation_release", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "STACKED", "JOINED", "SEPARATE", "Companion", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public enum InAppMessageButtonLayoutType implements JsonSerializable {
    STACKED("stacked"),
    JOINED("joined"),
    SEPARATE("separate");

    private final String json;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<InAppMessageButtonLayoutType> getEntries() {
        return $ENTRIES;
    }

    InAppMessageButtonLayoutType(String str) {
        this.json = str;
    }

    @NotNull
    /* JADX INFO: renamed from: getJson$urbanairship_automation_release, reason: from getter */
    public final String getJson() {
        return this.json;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/iam/info/InAppMessageButtonLayoutType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-automation_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nInAppMessageButtonLayoutType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InAppMessageButtonLayoutType.kt\ncom/urbanairship/iam/info/InAppMessageButtonLayoutType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n288#2,2:41\n*S KotlinDebug\n*F\n+ 1 InAppMessageButtonLayoutType.kt\ncom/urbanairship/iam/info/InAppMessageButtonLayoutType$Companion\n*L\n33#1:41,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final InAppMessageButtonLayoutType fromJson(@NotNull JsonValue value) throws JsonException {
            InAppMessageButtonLayoutType next;
            Intrinsics.checkNotNullParameter(value, "value");
            String strRequireString = value.requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
            Iterator<InAppMessageButtonLayoutType> it = InAppMessageButtonLayoutType.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.getJson(), strRequireString));
            InAppMessageButtonLayoutType inAppMessageButtonLayoutType = next;
            if (inAppMessageButtonLayoutType != null) {
                return inAppMessageButtonLayoutType;
            }
            throw new JsonException("Invalid button layout " + strRequireString);
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
