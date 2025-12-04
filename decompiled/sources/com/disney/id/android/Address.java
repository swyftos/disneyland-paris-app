package com.disney.id.android;

import androidx.annotation.Keep;
import androidx.autofill.HintConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.util.Attributes;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u009e\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u00065"}, d2 = {"Lcom/disney/id/android/Address;", "", "addressGuid", "", "type", "line1", "line2", "line3", Attributes.CITY, "stateProvince", HintConstants.AUTOFILL_HINT_POSTAL_CODE, Attributes.COUNTRY, "preferred", "", "dateCreated", "Ljava/util/Date;", "dateLastModified", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/util/Date;)V", "getAddressGuid", "()Ljava/lang/String;", "getCity", "getCountry", "getDateCreated", "()Ljava/util/Date;", "getDateLastModified", "getLine1", "getLine2", "getLine3", "getPostalCode", "getPreferred", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStateProvince", "getType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/util/Date;)Lcom/disney/id/android/Address;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Address {

    @Nullable
    private final String addressGuid;

    @Nullable
    private final String city;

    @Nullable
    private final String country;

    @Nullable
    private final Date dateCreated;

    @Nullable
    private final Date dateLastModified;

    @Nullable
    private final String line1;

    @Nullable
    private final String line2;

    @Nullable
    private final String line3;

    @Nullable
    private final String postalCode;

    @Nullable
    private final Boolean preferred;

    @Nullable
    private final String stateProvince;

    @Nullable
    private final String type;

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getAddressGuid() {
        return this.addressGuid;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final Boolean getPreferred() {
        return this.preferred;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Date getDateCreated() {
        return this.dateCreated;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final Date getDateLastModified() {
        return this.dateLastModified;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getLine1() {
        return this.line1;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getLine2() {
        return this.line2;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getLine3() {
        return this.line3;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getStateProvince() {
        return this.stateProvince;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final Address copy(@Nullable String addressGuid, @Nullable String type, @Nullable String line1, @Nullable String line2, @Nullable String line3, @Nullable String city, @Nullable String stateProvince, @Nullable String postalCode, @Nullable String country, @Nullable Boolean preferred, @Nullable Date dateCreated, @Nullable Date dateLastModified) {
        return new Address(addressGuid, type, line1, line2, line3, city, stateProvince, postalCode, country, preferred, dateCreated, dateLastModified);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address address = (Address) other;
        return Intrinsics.areEqual(this.addressGuid, address.addressGuid) && Intrinsics.areEqual(this.type, address.type) && Intrinsics.areEqual(this.line1, address.line1) && Intrinsics.areEqual(this.line2, address.line2) && Intrinsics.areEqual(this.line3, address.line3) && Intrinsics.areEqual(this.city, address.city) && Intrinsics.areEqual(this.stateProvince, address.stateProvince) && Intrinsics.areEqual(this.postalCode, address.postalCode) && Intrinsics.areEqual(this.country, address.country) && Intrinsics.areEqual(this.preferred, address.preferred) && Intrinsics.areEqual(this.dateCreated, address.dateCreated) && Intrinsics.areEqual(this.dateLastModified, address.dateLastModified);
    }

    public int hashCode() {
        String str = this.addressGuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.line1;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.line2;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.line3;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.city;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.stateProvince;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.postalCode;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.country;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.preferred;
        int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        Date date = this.dateCreated;
        int iHashCode11 = (iHashCode10 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.dateLastModified;
        return iHashCode11 + (date2 != null ? date2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Address(addressGuid=" + this.addressGuid + ", type=" + this.type + ", line1=" + this.line1 + ", line2=" + this.line2 + ", line3=" + this.line3 + ", city=" + this.city + ", stateProvince=" + this.stateProvince + ", postalCode=" + this.postalCode + ", country=" + this.country + ", preferred=" + this.preferred + ", dateCreated=" + this.dateCreated + ", dateLastModified=" + this.dateLastModified + ")";
    }

    public Address(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Boolean bool, @Nullable Date date, @Nullable Date date2) {
        this.addressGuid = str;
        this.type = str2;
        this.line1 = str3;
        this.line2 = str4;
        this.line3 = str5;
        this.city = str6;
        this.stateProvince = str7;
        this.postalCode = str8;
        this.country = str9;
        this.preferred = bool;
        this.dateCreated = date;
        this.dateLastModified = date2;
    }

    @Nullable
    public final String getAddressGuid() {
        return this.addressGuid;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getLine1() {
        return this.line1;
    }

    @Nullable
    public final String getLine2() {
        return this.line2;
    }

    @Nullable
    public final String getLine3() {
        return this.line3;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final String getStateProvince() {
        return this.stateProvince;
    }

    @Nullable
    public final String getPostalCode() {
        return this.postalCode;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final Boolean getPreferred() {
        return this.preferred;
    }

    @Nullable
    public final Date getDateCreated() {
        return this.dateCreated;
    }

    @Nullable
    public final Date getDateLastModified() {
        return this.dateLastModified;
    }
}
