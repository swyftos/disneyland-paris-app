package com.urbanairship.contacts;

import androidx.annotation.RestrictTo;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, m1836d2 = {"Lcom/urbanairship/contacts/ChannelType;", "", "Lcom/urbanairship/json/JsonSerializable;", "json", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getJson", "()Ljava/lang/String;", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "OPEN", "SMS", "EMAIL", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public enum ChannelType implements JsonSerializable {
    OPEN(AbstractCircuitBreaker.PROPERTY_NAME),
    SMS("sms"),
    EMAIL("email");

    private final String json;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static EnumEntries<ChannelType> getEntries() {
        return $ENTRIES;
    }

    ChannelType(String str) {
        this.json = str;
    }

    @NotNull
    public final String getJson() {
        return this.json;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* JADX INFO: renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValueWrap = JsonValue.wrap(this.json);
        Intrinsics.checkNotNullExpressionValue(jsonValueWrap, "wrap(...)");
        return jsonValueWrap;
    }

    @Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/contacts/ChannelType$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/contacts/ChannelType;", "value", "Lcom/urbanairship/json/JsonValue;", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    @SourceDebugExtension({"SMAP\nChannelType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelType.kt\ncom/urbanairship/contacts/ChannelType$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n288#2,2:45\n*S KotlinDebug\n*F\n+ 1 ChannelType.kt\ncom/urbanairship/contacts/ChannelType$Companion\n*L\n38#1:45,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ChannelType fromJson(@NotNull JsonValue value) throws JsonException {
            ChannelType next;
            Intrinsics.checkNotNullParameter(value, "value");
            String strRequireString = value.requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
            String lowerCase = strRequireString.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Iterator<ChannelType> it = ChannelType.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.getJson(), lowerCase));
            ChannelType channelType = next;
            if (channelType != null) {
                return channelType;
            }
            throw new JsonException("invalid channel type " + lowerCase);
        }
    }
}
