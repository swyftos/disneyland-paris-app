package com.urbanairship.audience;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.audience.AudienceHash;
import com.urbanairship.audience.BucketSubset;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.ULong;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u001d\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/urbanairship/audience/AudienceHashSelector;", "Lcom/urbanairship/json/JsonSerializable;", "hash", "Lcom/urbanairship/audience/AudienceHash;", "bucket", "Lcom/urbanairship/audience/BucketSubset;", "sticky", "Lcom/urbanairship/audience/AudienceSticky;", "(Lcom/urbanairship/audience/AudienceHash;Lcom/urbanairship/audience/BucketSubset;Lcom/urbanairship/audience/AudienceSticky;)V", "getBucket$urbanairship_core_release", "()Lcom/urbanairship/audience/BucketSubset;", "getHash$urbanairship_core_release", "()Lcom/urbanairship/audience/AudienceHash;", "getSticky$urbanairship_core_release", "()Lcom/urbanairship/audience/AudienceSticky;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "evaluate", "channelId", "", "contactId", "evaluate$urbanairship_core_release", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nAudienceHashSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceHashSelector.kt\ncom/urbanairship/audience/AudienceHashSelector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
/* loaded from: classes5.dex */
public final class AudienceHashSelector implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final BucketSubset bucket;
    private final AudienceHash hash;
    private final AudienceSticky sticky;

    public AudienceHashSelector(@NotNull AudienceHash hash, @NotNull BucketSubset bucket, @Nullable AudienceSticky audienceSticky) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        this.hash = hash;
        this.bucket = bucket;
        this.sticky = audienceSticky;
    }

    public /* synthetic */ AudienceHashSelector(AudienceHash audienceHash, BucketSubset bucketSubset, AudienceSticky audienceSticky, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(audienceHash, bucketSubset, (i & 4) != 0 ? null : audienceSticky);
    }

    @NotNull
    /* renamed from: getHash$urbanairship_core_release, reason: from getter */
    public final AudienceHash getHash() {
        return this.hash;
    }

    @NotNull
    /* renamed from: getBucket$urbanairship_core_release, reason: from getter */
    public final BucketSubset getBucket() {
        return this.bucket;
    }

    @Nullable
    /* renamed from: getSticky$urbanairship_core_release, reason: from getter */
    public final AudienceSticky getSticky() {
        return this.sticky;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbanairship/audience/AudienceHashSelector$Companion;", "", "()V", "KEY_BUCKET_SUBSET", "", "KEY_HASH", "KEY_STICKY", "fromJson", "Lcom/urbanairship/audience/AudienceHashSelector;", "json", "Lcom/urbanairship/json/JsonMap;", "fromJson$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAudienceHashSelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudienceHashSelector.kt\ncom/urbanairship/audience/AudienceHashSelector$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1#2:94\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final AudienceHashSelector fromJson$urbanairship_core_release(@NotNull final JsonMap json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                AudienceHash.Companion companion = AudienceHash.INSTANCE;
                JsonMap jsonMapOptMap = json.require("audience_hash").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap, "optMap(...)");
                AudienceHash audienceHashFromJson$urbanairship_core_release = companion.fromJson$urbanairship_core_release(jsonMapOptMap);
                if (audienceHashFromJson$urbanairship_core_release == null) {
                    return null;
                }
                BucketSubset.Companion companion2 = BucketSubset.INSTANCE;
                JsonMap jsonMapOptMap2 = json.require("audience_subset").optMap();
                Intrinsics.checkNotNullExpressionValue(jsonMapOptMap2, "optMap(...)");
                BucketSubset bucketSubsetFromJson$urbanairship_core_release = companion2.fromJson$urbanairship_core_release(jsonMapOptMap2);
                if (bucketSubsetFromJson$urbanairship_core_release == null) {
                    return null;
                }
                JsonValue jsonValue = json.get("sticky");
                return new AudienceHashSelector(audienceHashFromJson$urbanairship_core_release, bucketSubsetFromJson$urbanairship_core_release, jsonValue != null ? AudienceSticky.INSTANCE.fromJson(jsonValue) : null);
            } catch (JsonException unused) {
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.audience.AudienceHashSelector$Companion$fromJson$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "failed to parse AudienceSelector from json " + json;
                    }
                }, 1, null);
                return null;
            }
        }
    }

    public final boolean evaluate$urbanairship_core_release(@NotNull String channelId, @NotNull String contactId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(contactId, "contactId");
        ULong uLongM2762generateJlBESG8$urbanairship_core_release = this.hash.m2762generateJlBESG8$urbanairship_core_release(MapsKt.mapOf(TuplesKt.to(HashIdentifiers.CONTACT.getJsonValue(), contactId), TuplesKt.to(HashIdentifiers.CHANNEL.getJsonValue(), channelId)));
        if (uLongM2762generateJlBESG8$urbanairship_core_release == null) {
            return false;
        }
        return this.bucket.m2767containsVKZWuLQ(uLongM2762generateJlBESG8$urbanairship_core_release.getData());
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("audience_hash", this.hash), TuplesKt.to("audience_subset", this.bucket), TuplesKt.to("sticky", this.sticky)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    @NotNull
    public String toString() {
        return "AudienceHashSelector(hash=" + this.hash + ", bucket=" + this.bucket + ", sticky: " + this.sticky + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AudienceHashSelector.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.audience.AudienceHashSelector");
        AudienceHashSelector audienceHashSelector = (AudienceHashSelector) other;
        return Intrinsics.areEqual(this.hash, audienceHashSelector.hash) && Intrinsics.areEqual(this.bucket, audienceHashSelector.bucket) && Intrinsics.areEqual(this.sticky, audienceHashSelector.sticky);
    }

    public int hashCode() {
        return Objects.hash(this.hash, this.bucket, this.sticky);
    }
}
