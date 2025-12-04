package com.urbanairship.channel;

import androidx.annotation.RestrictTo;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.Clock;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0003X¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\b\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation;", "Lcom/urbanairship/json/JsonSerializable;", "action", "", "(Ljava/lang/String;)V", "actionTime", "", "getActionTime", "()J", "name", "getName", "()Ljava/lang/String;", "startTime", "getStartTime", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "Remove", "Set", "Lcom/urbanairship/channel/LiveUpdateMutation$Remove;", "Lcom/urbanairship/channel/LiveUpdateMutation$Set;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public abstract class LiveUpdateMutation implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String action;

    public /* synthetic */ LiveUpdateMutation(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    protected abstract long getActionTime();

    @NotNull
    protected abstract String getName();

    protected abstract long getStartTime();

    private LiveUpdateMutation(String str) {
        this.action = str;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation$Set;", "Lcom/urbanairship/channel/LiveUpdateMutation;", "name", "", "startTime", "", "actionTime", "(Ljava/lang/String;JJ)V", "getActionTime", "()J", "getName", "()Ljava/lang/String;", "getStartTime", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Set extends LiveUpdateMutation {
        private final long actionTime;
        private final String name;
        private final long startTime;

        @Override // com.urbanairship.channel.LiveUpdateMutation
        @NotNull
        protected String getName() {
            return this.name;
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getStartTime() {
            return this.startTime;
        }

        public /* synthetic */ Set(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, (i & 4) != 0 ? Clock.DEFAULT_CLOCK.currentTimeMillis() : j2);
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getActionTime() {
            return this.actionTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Set(@NotNull String name, long j, long j2) {
            super(AttributeMutation.ATTRIBUTE_ACTION_SET, null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.startTime = j;
            this.actionTime = j2;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation$Remove;", "Lcom/urbanairship/channel/LiveUpdateMutation;", "name", "", "startTime", "", "actionTime", "(Ljava/lang/String;JJ)V", "getActionTime", "()J", "getName", "()Ljava/lang/String;", "getStartTime", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Remove extends LiveUpdateMutation {
        private final long actionTime;
        private final String name;
        private final long startTime;

        @Override // com.urbanairship.channel.LiveUpdateMutation
        @NotNull
        protected String getName() {
            return this.name;
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getStartTime() {
            return this.startTime;
        }

        public /* synthetic */ Remove(String str, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, (i & 4) != 0 ? Clock.DEFAULT_CLOCK.currentTimeMillis() : j2);
        }

        @Override // com.urbanairship.channel.LiveUpdateMutation
        protected long getActionTime() {
            return this.actionTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Remove(@NotNull String name, long j, long j2) {
            super(AttributeMutation.ATTRIBUTE_ACTION_REMOVE, null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.startTime = j;
            this.actionTime = j2;
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("action", this.action), TuplesKt.to("name", getName()), TuplesKt.to("start_ts_ms", Long.valueOf(getStartTime())), TuplesKt.to("action_ts_ms", Long.valueOf(getActionTime()))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/urbanairship/channel/LiveUpdateMutation$Companion;", "", "()V", "ACTION_REMOVE", "", "ACTION_SET", "KEY_ACTION", "KEY_ACTION_TS", "KEY_NAME", "KEY_START_TS", "fromJson", "Lcom/urbanairship/channel/LiveUpdateMutation;", "json", "Lcom/urbanairship/json/JsonMap;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLiveUpdateMutation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LiveUpdateMutation.kt\ncom/urbanairship/channel/LiveUpdateMutation$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,90:1\n44#2,15:91\n44#2,15:106\n44#2,15:121\n44#2,15:136\n*S KotlinDebug\n*F\n+ 1 LiveUpdateMutation.kt\ncom/urbanairship/channel/LiveUpdateMutation$Companion\n*L\n77#1:91,15\n78#1:106,15\n79#1:121,15\n80#1:136,15\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:117:0x029a  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x03df  */
        /* JADX WARN: Removed duplicated region for block: B:242:0x0575  */
        /* JADX WARN: Removed duplicated region for block: B:248:0x05bd  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.urbanairship.channel.LiveUpdateMutation fromJson(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r28) throws com.urbanairship.json.JsonException {
            /*
                Method dump skipped, instructions count: 1635
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.LiveUpdateMutation.Companion.fromJson(com.urbanairship.json.JsonMap):com.urbanairship.channel.LiveUpdateMutation");
        }

        private Companion() {
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.channel.LiveUpdateMutation");
        LiveUpdateMutation liveUpdateMutation = (LiveUpdateMutation) other;
        return Intrinsics.areEqual(this.action, liveUpdateMutation.action) && Intrinsics.areEqual(getName(), liveUpdateMutation.getName()) && getStartTime() == liveUpdateMutation.getStartTime() && getActionTime() == liveUpdateMutation.getActionTime();
    }

    public int hashCode() {
        return (((((this.action.hashCode() * 31) + getName().hashCode()) * 31) + Long.hashCode(getStartTime())) * 31) + Long.hashCode(getActionTime());
    }
}
