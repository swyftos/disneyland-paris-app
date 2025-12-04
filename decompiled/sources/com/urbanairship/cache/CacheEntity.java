package com.urbanairship.cache;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import androidx.room.TypeConverters;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonTypeConverters;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@TypeConverters({JsonTypeConverters.class})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0007J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/urbanairship/cache/CacheEntity;", "", "key", "", "appVersion", "sdkVersion", "expireOn", "", "data", "Lcom/urbanairship/json/JsonValue;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/urbanairship/json/JsonValue;)V", "getAppVersion", "()Ljava/lang/String;", "getData", "()Lcom/urbanairship/json/JsonValue;", "getExpireOn", "()J", "getKey", "getSdkVersion", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "isExpired", "timestamp", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity(tableName = "cacheItems")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class CacheEntity {
    private final String appVersion;
    private final JsonValue data;
    private final long expireOn;
    private final String key;
    private final String sdkVersion;

    public static /* synthetic */ CacheEntity copy$default(CacheEntity cacheEntity, String str, String str2, String str3, long j, JsonValue jsonValue, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cacheEntity.key;
        }
        if ((i & 2) != 0) {
            str2 = cacheEntity.appVersion;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = cacheEntity.sdkVersion;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            j = cacheEntity.expireOn;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            jsonValue = cacheEntity.data;
        }
        return cacheEntity.copy(str, str4, str5, j2, jsonValue);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* renamed from: component4, reason: from getter */
    public final long getExpireOn() {
        return this.expireOn;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final JsonValue getData() {
        return this.data;
    }

    @NotNull
    public final CacheEntity copy(@NotNull String key, @NotNull String appVersion, @NotNull String sdkVersion, long expireOn, @NotNull JsonValue data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(data, "data");
        return new CacheEntity(key, appVersion, sdkVersion, expireOn, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheEntity)) {
            return false;
        }
        CacheEntity cacheEntity = (CacheEntity) other;
        return Intrinsics.areEqual(this.key, cacheEntity.key) && Intrinsics.areEqual(this.appVersion, cacheEntity.appVersion) && Intrinsics.areEqual(this.sdkVersion, cacheEntity.sdkVersion) && this.expireOn == cacheEntity.expireOn && Intrinsics.areEqual(this.data, cacheEntity.data);
    }

    public int hashCode() {
        return (((((((this.key.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.sdkVersion.hashCode()) * 31) + Long.hashCode(this.expireOn)) * 31) + this.data.hashCode();
    }

    @NotNull
    public String toString() {
        return "CacheEntity(key=" + this.key + ", appVersion=" + this.appVersion + ", sdkVersion=" + this.sdkVersion + ", expireOn=" + this.expireOn + ", data=" + this.data + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public CacheEntity(@NotNull String key, @NotNull String appVersion, @NotNull String sdkVersion, long j, @NotNull JsonValue data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(data, "data");
        this.key = key;
        this.appVersion = appVersion;
        this.sdkVersion = sdkVersion;
        this.expireOn = j;
        this.data = data;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    @NotNull
    public final String getAppVersion() {
        return this.appVersion;
    }

    @NotNull
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final long getExpireOn() {
        return this.expireOn;
    }

    @NotNull
    public final JsonValue getData() {
        return this.data;
    }

    public final boolean isExpired(long timestamp) {
        return timestamp > this.expireOn;
    }
}
