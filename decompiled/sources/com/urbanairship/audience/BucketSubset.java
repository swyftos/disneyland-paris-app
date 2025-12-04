package com.urbanairship.audience;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/audience/BucketSubset;", "Lcom/urbanairship/json/JsonSerializable;", "min", "Lkotlin/ULong;", "max", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMax-s-VKNKU", "()J", "J", "getMin-s-VKNKU", "contains", "", "value", "contains-VKZWuLQ", "(J)Z", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "Companion", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BucketSubset implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final long max;
    private final long min;

    public /* synthetic */ BucketSubset(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    private BucketSubset(long j, long j2) {
        this.min = j;
        this.max = j2;
    }

    /* renamed from: getMin-s-VKNKU, reason: not valid java name and from getter */
    public final long getMin() {
        return this.min;
    }

    /* renamed from: getMax-s-VKNKU, reason: not valid java name and from getter */
    public final long getMax() {
        return this.max;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/audience/BucketSubset$Companion;", "", "()V", "KEY_BUCKET_MAX", "", "KEY_BUCKET_MIN", "fromJson", "Lcom/urbanairship/audience/BucketSubset;", "json", "Lcom/urbanairship/json/JsonMap;", "fromJson$urbanairship_core_release", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBucketSubset.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BucketSubset.kt\ncom/urbanairship/audience/BucketSubset$Companion\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,68:1\n79#2,16:69\n79#2,16:85\n*S KotlinDebug\n*F\n+ 1 BucketSubset.kt\ncom/urbanairship/audience/BucketSubset$Companion\n*L\n31#1:69,16\n32#1:85,16\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final BucketSubset fromJson$urbanairship_core_release(@NotNull final JsonMap json) throws JsonException {
            Long lValueOf;
            Long lValueOf2;
            Intrinsics.checkNotNullParameter(json, "json");
            BucketSubset$Companion$fromJson$converted$1 bucketSubset$Companion$fromJson$converted$1 = new Function1() { // from class: com.urbanairship.audience.BucketSubset$Companion$fromJson$converted$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return ULong.m3027boximpl(m2770invokeI7RO_PI(((Number) obj).longValue()));
                }

                /* renamed from: invoke-I7RO_PI, reason: not valid java name */
                public final long m2770invokeI7RO_PI(long j) {
                    return ULong.m3028constructorimpl(j);
                }
            };
            try {
                JsonValue jsonValue = json.get("min_hash_bucket");
                if (jsonValue == null) {
                    lValueOf = null;
                } else {
                    Intrinsics.checkNotNull(jsonValue);
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        lValueOf = (Long) jsonValue.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf = (Long) Boolean.valueOf(jsonValue.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf = Long.valueOf(jsonValue.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf = (Long) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf = (Long) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        lValueOf = (Long) Integer.valueOf(jsonValue.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        lValueOf = (Long) jsonValue.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        lValueOf = (Long) jsonValue.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'min_hash_bucket" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        lValueOf = (Long) jsonValue.getJsonValue();
                    }
                }
                long data = ((ULong) bucketSubset$Companion$fromJson$converted$1.invoke(Long.valueOf(lValueOf != null ? lValueOf.longValue() : 0L))).getData();
                JsonValue jsonValue2 = json.get("max_hash_bucket");
                if (jsonValue2 == null) {
                    lValueOf2 = null;
                } else {
                    Intrinsics.checkNotNull(jsonValue2);
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        lValueOf2 = (Long) jsonValue2.optString();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        lValueOf2 = (Long) Boolean.valueOf(jsonValue2.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        lValueOf2 = Long.valueOf(jsonValue2.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        lValueOf2 = (Long) ULong.m3027boximpl(ULong.m3028constructorimpl(jsonValue2.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        lValueOf2 = (Long) Double.valueOf(jsonValue2.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        lValueOf2 = (Long) Float.valueOf(jsonValue2.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class)) || Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        lValueOf2 = (Long) Integer.valueOf(jsonValue2.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        lValueOf2 = (Long) UInt.m3002boximpl(UInt.m3003constructorimpl(jsonValue2.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        lValueOf2 = (Long) jsonValue2.optList();
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        lValueOf2 = (Long) jsonValue2.optMap();
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + Long.class.getSimpleName() + "' for field 'max_hash_bucket" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        lValueOf2 = (Long) jsonValue2.getJsonValue();
                    }
                }
                return new BucketSubset(data, ((ULong) bucketSubset$Companion$fromJson$converted$1.invoke(Long.valueOf(lValueOf2 != null ? lValueOf2.longValue() : Long.MAX_VALUE))).getData(), null);
            } catch (JsonException unused) {
                UALog.e$default(null, new Function0() { // from class: com.urbanairship.audience.BucketSubset$Companion$fromJson$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "failed to parse ExperimentBucket from json " + json;
                    }
                }, 1, null);
                return null;
            }
        }
    }

    /* renamed from: contains-VKZWuLQ, reason: not valid java name */
    public final boolean m2767containsVKZWuLQ(long value) {
        return UnsignedKt.ulongCompare(value, this.max) <= 0 && UnsignedKt.ulongCompare(value, this.min) >= 0;
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonMap.newBuilder().put("min_hash_bucket", this.min).put("max_hash_bucket", this.max).build().getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(BucketSubset.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.audience.BucketSubset");
        BucketSubset bucketSubset = (BucketSubset) other;
        return this.min == bucketSubset.min && this.max == bucketSubset.max;
    }

    public int hashCode() {
        return Objects.hash(ULong.m3027boximpl(this.min), ULong.m3027boximpl(this.max));
    }
}
