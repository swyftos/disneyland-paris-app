package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\r\u0010,\u001a\u00020\u0000H\u0000¢\u0006\u0002\b-J¤\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0004\u0010\u0016R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0006\u0010\u0016R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00064"}, d2 = {"Lcom/disney/id/android/LinkedAccount;", "", "swid", "", "isNRT", "", "isPrimaryDID", "username", "email", "parentEmail", "dateRegistered", "dateLastLogin", "registeredAffiliate", "registeredDomain", "loginDomains", "", "status", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getDateLastLogin", "()Ljava/lang/String;", "getDateRegistered", "getEmail", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLoginDomains", "()Ljava/util/List;", "getParentEmail", "getRegisteredAffiliate", "getRegisteredDomain", "getStatus", "getSwid", "getUsername", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy$OneID_release", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/disney/id/android/LinkedAccount;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LinkedAccount {

    @Nullable
    private final String dateLastLogin;

    @Nullable
    private final String dateRegistered;

    @Nullable
    private final String email;

    @Nullable
    private final Boolean isNRT;

    @Nullable
    private final Boolean isPrimaryDID;

    @Nullable
    private final List<String> loginDomains;

    @Nullable
    private final String parentEmail;

    @Nullable
    private final String registeredAffiliate;

    @Nullable
    private final String registeredDomain;

    @Nullable
    private final String status;

    @Nullable
    private final String swid;

    @Nullable
    private final String username;

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSwid() {
        return this.swid;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getRegisteredDomain() {
        return this.registeredDomain;
    }

    @Nullable
    public final List<String> component11() {
        return this.loginDomains;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getIsNRT() {
        return this.isNRT;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Boolean getIsPrimaryDID() {
        return this.isPrimaryDID;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getParentEmail() {
        return this.parentEmail;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getDateRegistered() {
        return this.dateRegistered;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getDateLastLogin() {
        return this.dateLastLogin;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getRegisteredAffiliate() {
        return this.registeredAffiliate;
    }

    @NotNull
    public final LinkedAccount copy(@Nullable String swid, @Nullable Boolean isNRT, @Nullable Boolean isPrimaryDID, @Nullable String username, @Nullable String email, @Nullable String parentEmail, @Nullable String dateRegistered, @Nullable String dateLastLogin, @Nullable String registeredAffiliate, @Nullable String registeredDomain, @Nullable List<String> loginDomains, @Nullable String status) {
        return new LinkedAccount(swid, isNRT, isPrimaryDID, username, email, parentEmail, dateRegistered, dateLastLogin, registeredAffiliate, registeredDomain, loginDomains, status);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinkedAccount)) {
            return false;
        }
        LinkedAccount linkedAccount = (LinkedAccount) other;
        return Intrinsics.areEqual(this.swid, linkedAccount.swid) && Intrinsics.areEqual(this.isNRT, linkedAccount.isNRT) && Intrinsics.areEqual(this.isPrimaryDID, linkedAccount.isPrimaryDID) && Intrinsics.areEqual(this.username, linkedAccount.username) && Intrinsics.areEqual(this.email, linkedAccount.email) && Intrinsics.areEqual(this.parentEmail, linkedAccount.parentEmail) && Intrinsics.areEqual(this.dateRegistered, linkedAccount.dateRegistered) && Intrinsics.areEqual(this.dateLastLogin, linkedAccount.dateLastLogin) && Intrinsics.areEqual(this.registeredAffiliate, linkedAccount.registeredAffiliate) && Intrinsics.areEqual(this.registeredDomain, linkedAccount.registeredDomain) && Intrinsics.areEqual(this.loginDomains, linkedAccount.loginDomains) && Intrinsics.areEqual(this.status, linkedAccount.status);
    }

    public int hashCode() {
        String str = this.swid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isNRT;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isPrimaryDID;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.username;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.parentEmail;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.dateRegistered;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.dateLastLogin;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.registeredAffiliate;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.registeredDomain;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<String> list = this.loginDomains;
        int iHashCode11 = (iHashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str9 = this.status;
        return iHashCode11 + (str9 != null ? str9.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LinkedAccount(swid=" + this.swid + ", isNRT=" + this.isNRT + ", isPrimaryDID=" + this.isPrimaryDID + ", username=" + this.username + ", email=" + this.email + ", parentEmail=" + this.parentEmail + ", dateRegistered=" + this.dateRegistered + ", dateLastLogin=" + this.dateLastLogin + ", registeredAffiliate=" + this.registeredAffiliate + ", registeredDomain=" + this.registeredDomain + ", loginDomains=" + this.loginDomains + ", status=" + this.status + ")";
    }

    public LinkedAccount(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable List<String> list, @Nullable String str9) {
        this.swid = str;
        this.isNRT = bool;
        this.isPrimaryDID = bool2;
        this.username = str2;
        this.email = str3;
        this.parentEmail = str4;
        this.dateRegistered = str5;
        this.dateLastLogin = str6;
        this.registeredAffiliate = str7;
        this.registeredDomain = str8;
        this.loginDomains = list;
        this.status = str9;
    }

    @Nullable
    public final String getSwid() {
        return this.swid;
    }

    @Nullable
    public final Boolean isNRT() {
        return this.isNRT;
    }

    @Nullable
    public final Boolean isPrimaryDID() {
        return this.isPrimaryDID;
    }

    @Nullable
    public final String getUsername() {
        return this.username;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final String getParentEmail() {
        return this.parentEmail;
    }

    @Nullable
    public final String getDateRegistered() {
        return this.dateRegistered;
    }

    @Nullable
    public final String getDateLastLogin() {
        return this.dateLastLogin;
    }

    @Nullable
    public final String getRegisteredAffiliate() {
        return this.registeredAffiliate;
    }

    @Nullable
    public final String getRegisteredDomain() {
        return this.registeredDomain;
    }

    @Nullable
    public final List<String> getLoginDomains() {
        return this.loginDomains;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @NotNull
    public final LinkedAccount copy$OneID_release() {
        String str = this.swid;
        Boolean bool = this.isNRT;
        Boolean bool2 = this.isPrimaryDID;
        String str2 = this.username;
        String str3 = this.email;
        String str4 = this.parentEmail;
        String str5 = this.dateRegistered;
        String str6 = this.dateLastLogin;
        String str7 = this.registeredAffiliate;
        String str8 = this.registeredDomain;
        List<String> list = this.loginDomains;
        return new LinkedAccount(str, bool, bool2, str2, str3, str4, str5, str6, str7, str8, list != null ? CollectionsKt.toList(list) : null, this.status);
    }
}
