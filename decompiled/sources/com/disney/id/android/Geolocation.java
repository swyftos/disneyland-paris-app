package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/disney/id/android/Geolocation;", "", "ip", "", "continentAlpha2", "countryAlpha2", "regionAlpha2", "latitude", "", "longitude", "usedFallback", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getContinentAlpha2", "()Ljava/lang/String;", "getCountryAlpha2", "getIp", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "getRegionAlpha2", "getUsedFallback", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)Lcom/disney/id/android/Geolocation;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Geolocation {

    @Nullable
    private final String continentAlpha2;

    @Nullable
    private final String countryAlpha2;

    @Nullable
    private final String ip;

    @Nullable
    private final Double latitude;

    @Nullable
    private final Double longitude;

    @Nullable
    private final String regionAlpha2;

    @Nullable
    private final Boolean usedFallback;

    public static /* synthetic */ Geolocation copy$default(Geolocation geolocation, String str, String str2, String str3, String str4, Double d, Double d2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geolocation.ip;
        }
        if ((i & 2) != 0) {
            str2 = geolocation.continentAlpha2;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = geolocation.countryAlpha2;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = geolocation.regionAlpha2;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            d = geolocation.latitude;
        }
        Double d3 = d;
        if ((i & 32) != 0) {
            d2 = geolocation.longitude;
        }
        Double d4 = d2;
        if ((i & 64) != 0) {
            bool = geolocation.usedFallback;
        }
        return geolocation.copy(str, str5, str6, str7, d3, d4, bool);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getIp() {
        return this.ip;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getContinentAlpha2() {
        return this.continentAlpha2;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getCountryAlpha2() {
        return this.countryAlpha2;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getRegionAlpha2() {
        return this.regionAlpha2;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Double getLongitude() {
        return this.longitude;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final Boolean getUsedFallback() {
        return this.usedFallback;
    }

    @NotNull
    public final Geolocation copy(@Nullable String ip, @Nullable String continentAlpha2, @Nullable String countryAlpha2, @Nullable String regionAlpha2, @Nullable Double latitude, @Nullable Double longitude, @Nullable Boolean usedFallback) {
        return new Geolocation(ip, continentAlpha2, countryAlpha2, regionAlpha2, latitude, longitude, usedFallback);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Geolocation)) {
            return false;
        }
        Geolocation geolocation = (Geolocation) other;
        return Intrinsics.areEqual(this.ip, geolocation.ip) && Intrinsics.areEqual(this.continentAlpha2, geolocation.continentAlpha2) && Intrinsics.areEqual(this.countryAlpha2, geolocation.countryAlpha2) && Intrinsics.areEqual(this.regionAlpha2, geolocation.regionAlpha2) && Intrinsics.areEqual((Object) this.latitude, (Object) geolocation.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) geolocation.longitude) && Intrinsics.areEqual(this.usedFallback, geolocation.usedFallback);
    }

    public int hashCode() {
        String str = this.ip;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.continentAlpha2;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.countryAlpha2;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.regionAlpha2;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d = this.latitude;
        int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.longitude;
        int iHashCode6 = (iHashCode5 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Boolean bool = this.usedFallback;
        return iHashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Geolocation(ip=" + this.ip + ", continentAlpha2=" + this.continentAlpha2 + ", countryAlpha2=" + this.countryAlpha2 + ", regionAlpha2=" + this.regionAlpha2 + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", usedFallback=" + this.usedFallback + ")";
    }

    public Geolocation(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Double d, @Nullable Double d2, @Nullable Boolean bool) {
        this.ip = str;
        this.continentAlpha2 = str2;
        this.countryAlpha2 = str3;
        this.regionAlpha2 = str4;
        this.latitude = d;
        this.longitude = d2;
        this.usedFallback = bool;
    }

    @Nullable
    public final String getIp() {
        return this.ip;
    }

    @Nullable
    public final String getContinentAlpha2() {
        return this.continentAlpha2;
    }

    @Nullable
    public final String getCountryAlpha2() {
        return this.countryAlpha2;
    }

    @Nullable
    public final String getRegionAlpha2() {
        return this.regionAlpha2;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final Boolean getUsedFallback() {
        return this.usedFallback;
    }
}
