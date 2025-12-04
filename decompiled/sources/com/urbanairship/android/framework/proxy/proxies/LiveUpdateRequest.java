package com.urbanairship.android.framework.proxy.proxies;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.DateUtils;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "", "()V", "Companion", "End", "List", "Start", "Update", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LiveUpdateRequest {

    @Deprecated
    @NotNull
    public static final String CONTENT = "content";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String DISMISSAL_TIMESTAMP = "dismissalTimestamp";

    @Deprecated
    @NotNull
    public static final String NAME = "name";

    @Deprecated
    @NotNull
    public static final String TIMESTAMP = "timestamp";

    @Deprecated
    @NotNull
    public static final String TYPE = "type";

    public /* synthetic */ LiveUpdateRequest(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LiveUpdateRequest() {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006 "}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Update extends LiveUpdateRequest {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final JsonMap content;
        private final Long dismissalTimestamp;
        private final String name;
        private final Long timestamp;

        public static /* synthetic */ Update copy$default(Update update, String str, JsonMap jsonMap, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = update.name;
            }
            if ((i & 2) != 0) {
                jsonMap = update.content;
            }
            if ((i & 4) != 0) {
                l = update.timestamp;
            }
            if ((i & 8) != 0) {
                l2 = update.dismissalTimestamp;
            }
            return update.copy(str, jsonMap, l, l2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @NotNull
        public final Update copy(@NotNull String name, @NotNull JsonMap content, @Nullable Long timestamp, @Nullable Long dismissalTimestamp) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(content, "content");
            return new Update(name, content, timestamp, dismissalTimestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Update)) {
                return false;
            }
            Update update = (Update) other;
            return Intrinsics.areEqual(this.name, update.name) && Intrinsics.areEqual(this.content, update.content) && Intrinsics.areEqual(this.timestamp, update.timestamp) && Intrinsics.areEqual(this.dismissalTimestamp, update.dismissalTimestamp);
        }

        public int hashCode() {
            int iHashCode = ((this.name.hashCode() * 31) + this.content.hashCode()) * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.dismissalTimestamp;
            return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Update(name=" + this.name + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ")";
        }

        public /* synthetic */ Update(String str, JsonMap jsonMap, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jsonMap, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n44#2,15:189\n79#2,16:204\n79#2,16:220\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Update$Companion\n*L\n88#1:174,15\n89#1:189,15\n90#1:204,16\n93#1:220,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:117:0x029c  */
            /* JADX WARN: Removed duplicated region for block: B:118:0x02a1  */
            /* JADX WARN: Removed duplicated region for block: B:176:0x03e9  */
            /* JADX WARN: Removed duplicated region for block: B:177:0x03f2  */
            /* JADX WARN: Removed duplicated region for block: B:180:0x03fb  */
            /* JADX WARN: Removed duplicated region for block: B:181:0x03fe  */
            /* JADX WARN: Removed duplicated region for block: B:239:0x0543  */
            /* JADX WARN: Removed duplicated region for block: B:240:0x054c  */
            /* JADX WARN: Removed duplicated region for block: B:255:0x05d9  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x0165  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest.Update fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r22) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 1593
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest.Update.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest$Update");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(@NotNull String name, @NotNull JsonMap content, @Nullable Long l, @Nullable Long l2) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(content, "content");
            this.name = name;
            this.content = content;
            this.timestamp = l;
            this.dismissalTimestamp = l2;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ<\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\r¨\u0006 "}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "name", "", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class End extends LiveUpdateRequest {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final JsonMap content;
        private final Long dismissalTimestamp;
        private final String name;
        private final Long timestamp;

        public static /* synthetic */ End copy$default(End end, String str, JsonMap jsonMap, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = end.name;
            }
            if ((i & 2) != 0) {
                jsonMap = end.content;
            }
            if ((i & 4) != 0) {
                l = end.timestamp;
            }
            if ((i & 8) != 0) {
                l2 = end.dismissalTimestamp;
            }
            return end.copy(str, jsonMap, l, l2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @NotNull
        public final End copy(@NotNull String name, @Nullable JsonMap content, @Nullable Long timestamp, @Nullable Long dismissalTimestamp) {
            Intrinsics.checkNotNullParameter(name, "name");
            return new End(name, content, timestamp, dismissalTimestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof End)) {
                return false;
            }
            End end = (End) other;
            return Intrinsics.areEqual(this.name, end.name) && Intrinsics.areEqual(this.content, end.content) && Intrinsics.areEqual(this.timestamp, end.timestamp) && Intrinsics.areEqual(this.dismissalTimestamp, end.dismissalTimestamp);
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() * 31;
            JsonMap jsonMap = this.content;
            int iHashCode2 = (iHashCode + (jsonMap == null ? 0 : jsonMap.hashCode())) * 31;
            Long l = this.timestamp;
            int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.dismissalTimestamp;
            return iHashCode3 + (l2 != null ? l2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "End(name=" + this.name + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ")";
        }

        public /* synthetic */ End(String str, JsonMap jsonMap, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, jsonMap, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : l2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n79#2,16:189\n79#2,16:205\n79#2,16:221\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$End$Companion\n*L\n112#1:174,15\n113#1:189,16\n114#1:205,16\n117#1:221,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final End fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                String strOptString;
                String str;
                JsonMap jsonMapOptMap;
                String strOptString2;
                String strOptString3;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                JsonMap jsonMapRequireMap = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue2 = jsonMapRequireMap.get("name");
                if (jsonValue2 == null) {
                    throw new JsonException("Missing required field: 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue2.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue2.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'name" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue3;
                }
                JsonValue jsonValue4 = jsonMapRequireMap.get("content");
                if (jsonValue4 == null) {
                    str = "null cannot be cast to non-null type kotlin.String";
                    jsonMapOptMap = null;
                } else {
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(JsonMap.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        jsonMapOptMap = (JsonMap) jsonValue4.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        jsonMapOptMap = (JsonMap) Boolean.valueOf(jsonValue4.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        str = "null cannot be cast to non-null type kotlin.String";
                        jsonMapOptMap = (JsonMap) Long.valueOf(jsonValue4.getLong(0L));
                    } else {
                        str = "null cannot be cast to non-null type kotlin.String";
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            jsonMapOptMap = (JsonMap) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue4.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            jsonMapOptMap = (JsonMap) Double.valueOf(jsonValue4.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            jsonMapOptMap = (JsonMap) Float.valueOf(jsonValue4.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                            jsonMapOptMap = (JsonMap) Integer.valueOf(jsonValue4.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            jsonMapOptMap = (JsonMap) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue4.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            jsonMapOptMap = (JsonMap) jsonValue4.optList();
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            jsonMapOptMap = jsonValue4.optMap();
                        } else {
                            if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + JsonMap.class.getSimpleName() + "' for field 'content" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonMapOptMap = (JsonMap) jsonValue4.getJsonValue();
                        }
                    }
                    str = "null cannot be cast to non-null type kotlin.String";
                }
                JsonValue jsonValue5 = jsonMapRequireMap.get("timestamp");
                if (jsonValue5 == null) {
                    strOptString2 = null;
                } else {
                    KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue5.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue5.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString2 = (String) Boolean.valueOf(jsonValue5.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString2 = (String) Long.valueOf(jsonValue5.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
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
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) objOptList2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap2 = jsonValue5.optMap();
                        if (objOptMap2 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) objOptMap2;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'timestamp" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue6 = jsonValue5.getJsonValue();
                        if (jsonValue6 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString2 = (String) jsonValue6;
                    }
                }
                Long lValueOf = strOptString2 != null ? Long.valueOf(DateUtils.parseIso8601(strOptString2)) : null;
                JsonValue jsonValue7 = jsonMapRequireMap.get(LiveUpdateRequest.DISMISSAL_TIMESTAMP);
                if (jsonValue7 == null) {
                    strOptString3 = null;
                } else {
                    KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue7.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString3 = jsonValue7.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString3 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString3 = (String) Long.valueOf(jsonValue7.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString3 = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue7.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString3 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString3 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        strOptString3 = (String) Integer.valueOf(jsonValue7.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString3 = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue7.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList3 = jsonValue7.optList();
                        if (objOptList3 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString3 = (String) objOptList3;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap3 = jsonValue7.optMap();
                        if (objOptMap3 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString3 = (String) objOptMap3;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field '" + LiveUpdateRequest.DISMISSAL_TIMESTAMP + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue8 = jsonValue7.getJsonValue();
                        if (jsonValue8 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString3 = (String) jsonValue8;
                    }
                }
                return new End(strOptString, jsonMapOptMap, lValueOf, strOptString3 != null ? Long.valueOf(DateUtils.parseIso8601(strOptString3)) : null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public End(@NotNull String name, @Nullable JsonMap jsonMap, @Nullable Long l, @Nullable Long l2) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.content = jsonMap;
            this.timestamp = l;
            this.dismissalTimestamp = l2;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006#"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "name", "", "type", "content", "Lcom/urbanairship/json/JsonMap;", "timestamp", "", LiveUpdateRequest.DISMISSAL_TIMESTAMP, "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)V", "getContent", "()Lcom/urbanairship/json/JsonMap;", "getDismissalTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getTimestamp", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbanairship/json/JsonMap;Ljava/lang/Long;Ljava/lang/Long;)Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Start extends LiveUpdateRequest {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final JsonMap content;
        private final Long dismissalTimestamp;
        private final String name;
        private final Long timestamp;
        private final String type;

        public static /* synthetic */ Start copy$default(Start start, String str, String str2, JsonMap jsonMap, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = start.name;
            }
            if ((i & 2) != 0) {
                str2 = start.type;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                jsonMap = start.content;
            }
            JsonMap jsonMap2 = jsonMap;
            if ((i & 8) != 0) {
                l = start.timestamp;
            }
            Long l3 = l;
            if ((i & 16) != 0) {
                l2 = start.dismissalTimestamp;
            }
            return start.copy(str, str3, jsonMap2, l3, l2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @NotNull
        public final Start copy(@NotNull String name, @NotNull String type, @NotNull JsonMap content, @Nullable Long timestamp, @Nullable Long dismissalTimestamp) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(content, "content");
            return new Start(name, type, content, timestamp, dismissalTimestamp);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Start)) {
                return false;
            }
            Start start = (Start) other;
            return Intrinsics.areEqual(this.name, start.name) && Intrinsics.areEqual(this.type, start.type) && Intrinsics.areEqual(this.content, start.content) && Intrinsics.areEqual(this.timestamp, start.timestamp) && Intrinsics.areEqual(this.dismissalTimestamp, start.dismissalTimestamp);
        }

        public int hashCode() {
            int iHashCode = ((((this.name.hashCode() * 31) + this.type.hashCode()) * 31) + this.content.hashCode()) * 31;
            Long l = this.timestamp;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.dismissalTimestamp;
            return iHashCode2 + (l2 != null ? l2.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Start(name=" + this.name + ", type=" + this.type + ", content=" + this.content + ", timestamp=" + this.timestamp + ", dismissalTimestamp=" + this.dismissalTimestamp + ")";
        }

        public /* synthetic */ Start(String str, String str2, JsonMap jsonMap, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, jsonMap, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final JsonMap getContent() {
            return this.content;
        }

        @Nullable
        public final Long getTimestamp() {
            return this.timestamp;
        }

        @Nullable
        public final Long getDismissalTimestamp() {
            return this.dismissalTimestamp;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n44#2,15:189\n44#2,15:204\n79#2,16:219\n79#2,16:235\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$Start$Companion\n*L\n137#1:174,15\n138#1:189,15\n139#1:204,15\n140#1:219,16\n143#1:235,16\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Removed duplicated region for block: B:175:0x03de  */
            /* JADX WARN: Removed duplicated region for block: B:176:0x03e1  */
            /* JADX WARN: Removed duplicated region for block: B:234:0x0525  */
            /* JADX WARN: Removed duplicated region for block: B:235:0x0530  */
            /* JADX WARN: Removed duplicated region for block: B:238:0x053a  */
            /* JADX WARN: Removed duplicated region for block: B:239:0x053d  */
            /* JADX WARN: Removed duplicated region for block: B:297:0x0681  */
            /* JADX WARN: Removed duplicated region for block: B:298:0x068c  */
            /* JADX WARN: Removed duplicated region for block: B:319:0x0759  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x016b  */
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest.Start fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonValue r25) throws com.urbanairship.json.JsonException {
                /*
                    Method dump skipped, instructions count: 1976
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest.Start.Companion.fromJson(com.urbanairship.json.JsonValue):com.urbanairship.android.framework.proxy.proxies.LiveUpdateRequest$Start");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Start(@NotNull String name, @NotNull String type, @NotNull JsonMap content, @Nullable Long l, @Nullable Long l2) {
            super(null);
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(content, "content");
            this.name = name;
            this.type = type;
            this.content = content;
            this.timestamp = l;
            this.dismissalTimestamp = l2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest;", "type", "", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class List extends LiveUpdateRequest {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final String type;

        public static /* synthetic */ List copy$default(List list, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = list.type;
            }
            return list.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List copy(@NotNull String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new List(type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof List) && Intrinsics.areEqual(this.type, ((List) other).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "List(type=" + this.type + ")";
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List$Companion;", "", "()V", "fromJson", "Lcom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List;", "jsonValue", "Lcom/urbanairship/json/JsonValue;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nLiveUpdatesManagerProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,173:1\n44#2,15:174\n*S KotlinDebug\n*F\n+ 1 LiveUpdatesManagerProxy.kt\ncom/urbanairship/android/framework/proxy/proxies/LiveUpdateRequest$List$Companion\n*L\n159#1:174,15\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final List fromJson(@NotNull JsonValue jsonValue) throws JsonException {
                String strOptString;
                Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
                JsonMap jsonMapRequireMap = jsonValue.requireMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapRequireMap, "requireMap(...)");
                JsonValue jsonValue2 = jsonMapRequireMap.get("type");
                if (jsonValue2 == null) {
                    throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString = jsonValue2.optString();
                    if (strOptString == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue2.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString = (String) Long.valueOf(jsonValue2.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString = (String) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString = (String) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString = (String) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString = (String) Integer.valueOf(jsonValue2.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString = (String) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    Object objOptList = jsonValue2.optList();
                    if (objOptList == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptList;
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    Object objOptMap = jsonValue2.optMap();
                    if (objOptMap == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) objOptMap;
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Object jsonValue3 = jsonValue2.getJsonValue();
                    if (jsonValue3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    strOptString = (String) jsonValue3;
                }
                return new List(strOptString);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public List(@NotNull String type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
