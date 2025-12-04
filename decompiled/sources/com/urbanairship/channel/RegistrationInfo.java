package com.urbanairship.channel;

import ch.qos.logback.core.CoreConstants;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
final class RegistrationInfo implements JsonSerializable {
    private static final Companion Companion = new Companion(null);
    private final long dateMillis;
    private final Long lastFullUploadMillis;
    private final String location;
    private final ChannelRegistrationPayload payload;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegistrationInfo)) {
            return false;
        }
        RegistrationInfo registrationInfo = (RegistrationInfo) obj;
        return this.dateMillis == registrationInfo.dateMillis && Intrinsics.areEqual(this.lastFullUploadMillis, registrationInfo.lastFullUploadMillis) && Intrinsics.areEqual(this.payload, registrationInfo.payload) && Intrinsics.areEqual(this.location, registrationInfo.location);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.dateMillis) * 31;
        Long l = this.lastFullUploadMillis;
        return ((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + this.payload.hashCode()) * 31) + this.location.hashCode();
    }

    public String toString() {
        return "RegistrationInfo(dateMillis=" + this.dateMillis + ", lastFullUploadMillis=" + this.lastFullUploadMillis + ", payload=" + this.payload + ", location=" + this.location + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RegistrationInfo(com.urbanairship.json.JsonMap r26) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 1212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.channel.RegistrationInfo.<init>(com.urbanairship.json.JsonMap):void");
    }

    public RegistrationInfo(long j, Long l, ChannelRegistrationPayload payload, String location) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Intrinsics.checkNotNullParameter(location, "location");
        this.dateMillis = j;
        this.lastFullUploadMillis = l;
        this.payload = payload;
        this.location = location;
    }

    public final long getDateMillis() {
        return this.dateMillis;
    }

    public final Long getLastFullUploadMillis() {
        return this.lastFullUploadMillis;
    }

    public final ChannelRegistrationPayload getPayload() {
        return this.payload;
    }

    public final String getLocation() {
        return this.location;
    }

    @Override // com.urbanairship.json.JsonSerializable
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("date", Long.valueOf(this.dateMillis)), TuplesKt.to("last_full_upload_date", this.lastFullUploadMillis), TuplesKt.to("payload", this.payload), TuplesKt.to("location", this.location)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
