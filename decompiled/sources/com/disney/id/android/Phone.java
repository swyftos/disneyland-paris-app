package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0086\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001a¨\u0006/"}, d2 = {"Lcom/disney/id/android/Phone;", "", "phoneGuid", "", "type", "number", "internationalPrefix", "extension", "preferred", "", "countryCode", "verified", "dateCreated", "Ljava/util/Date;", "dateLastModified", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/util/Date;)V", "getCountryCode", "()Ljava/lang/String;", "getDateCreated", "()Ljava/util/Date;", "getDateLastModified", "getExtension", "getInternationalPrefix", "getNumber", "getPhoneGuid", "getPreferred", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "getVerified", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/util/Date;)Lcom/disney/id/android/Phone;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Phone {

    @Nullable
    private final String countryCode;

    @Nullable
    private final Date dateCreated;

    @Nullable
    private final Date dateLastModified;

    @Nullable
    private final String extension;

    @Nullable
    private final String internationalPrefix;

    @Nullable
    private final String number;

    @Nullable
    private final String phoneGuid;

    @Nullable
    private final Boolean preferred;

    @Nullable
    private final String type;

    @Nullable
    private final Boolean verified;

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getPhoneGuid() {
        return this.phoneGuid;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
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
    public final String getNumber() {
        return this.number;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getInternationalPrefix() {
        return this.internationalPrefix;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getExtension() {
        return this.extension;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getPreferred() {
        return this.preferred;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getCountryCode() {
        return this.countryCode;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final Boolean getVerified() {
        return this.verified;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final Date getDateCreated() {
        return this.dateCreated;
    }

    @NotNull
    public final Phone copy(@Nullable String phoneGuid, @Nullable String type, @Nullable String number, @Nullable String internationalPrefix, @Nullable String extension, @Nullable Boolean preferred, @Nullable String countryCode, @Nullable Boolean verified, @Nullable Date dateCreated, @Nullable Date dateLastModified) {
        return new Phone(phoneGuid, type, number, internationalPrefix, extension, preferred, countryCode, verified, dateCreated, dateLastModified);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Phone)) {
            return false;
        }
        Phone phone = (Phone) other;
        return Intrinsics.areEqual(this.phoneGuid, phone.phoneGuid) && Intrinsics.areEqual(this.type, phone.type) && Intrinsics.areEqual(this.number, phone.number) && Intrinsics.areEqual(this.internationalPrefix, phone.internationalPrefix) && Intrinsics.areEqual(this.extension, phone.extension) && Intrinsics.areEqual(this.preferred, phone.preferred) && Intrinsics.areEqual(this.countryCode, phone.countryCode) && Intrinsics.areEqual(this.verified, phone.verified) && Intrinsics.areEqual(this.dateCreated, phone.dateCreated) && Intrinsics.areEqual(this.dateLastModified, phone.dateLastModified);
    }

    public int hashCode() {
        String str = this.phoneGuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.type;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.number;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.internationalPrefix;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.extension;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.preferred;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.countryCode;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool2 = this.verified;
        int iHashCode8 = (iHashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Date date = this.dateCreated;
        int iHashCode9 = (iHashCode8 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.dateLastModified;
        return iHashCode9 + (date2 != null ? date2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Phone(phoneGuid=" + this.phoneGuid + ", type=" + this.type + ", number=" + this.number + ", internationalPrefix=" + this.internationalPrefix + ", extension=" + this.extension + ", preferred=" + this.preferred + ", countryCode=" + this.countryCode + ", verified=" + this.verified + ", dateCreated=" + this.dateCreated + ", dateLastModified=" + this.dateLastModified + ")";
    }

    public Phone(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Boolean bool, @Nullable String str6, @Nullable Boolean bool2, @Nullable Date date, @Nullable Date date2) {
        this.phoneGuid = str;
        this.type = str2;
        this.number = str3;
        this.internationalPrefix = str4;
        this.extension = str5;
        this.preferred = bool;
        this.countryCode = str6;
        this.verified = bool2;
        this.dateCreated = date;
        this.dateLastModified = date2;
    }

    @Nullable
    public final String getPhoneGuid() {
        return this.phoneGuid;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getNumber() {
        return this.number;
    }

    @Nullable
    public final String getInternationalPrefix() {
        return this.internationalPrefix;
    }

    @Nullable
    public final String getExtension() {
        return this.extension;
    }

    @Nullable
    public final Boolean getPreferred() {
        return this.preferred;
    }

    @Nullable
    public final String getCountryCode() {
        return this.countryCode;
    }

    @Nullable
    public final Boolean getVerified() {
        return this.verified;
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
