package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 k2\u00020\u0001:\u0001kB³\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001e\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010%J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010S\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010U\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eHÆ\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001eHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\u0010\u0010[\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\r\u0010c\u001a\u00020\u0000H\u0000¢\u0006\u0002\bdJö\u0002\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020\u00142\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020iHÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b-\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b1\u0010+R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010)R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0015\u0010$\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b$\u0010+R\u0015\u0010#\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b#\u0010+R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b6\u0010+R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010,\u001a\u0004\b9\u0010+R\u0019\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010'R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010)R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010)R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010)R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010)R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010)R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010)¨\u0006l"}, d2 = {"Lcom/disney/id/android/Profile;", "", "swid", "", "referenceId", "testProfileFlag", "username", "prefix", "firstName", "middleName", "lastName", "suffix", "languagePreference", "region", "email", "parentEmail", "dateOfBirth", "gender", "ageBand", "ageBandAssumed", "", "countryCodeDetected", "emailVerified", "parentEmailVerified", "registrationDate", "Ljava/util/Date;", "linkedAccountsAvailable", "complete", "status", Profile.ADDRESSES, "", "Lcom/disney/id/android/Address;", Profile.PHONES, "Lcom/disney/id/android/Phone;", "pronunciationName", "isShareable", "isAdultVerified", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAddresses", "()Ljava/util/List;", "getAgeBand", "()Ljava/lang/String;", "getAgeBandAssumed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getComplete", "getCountryCodeDetected", "getDateOfBirth", "getEmail", "getEmailVerified", "getFirstName", "getGender", "getLanguagePreference", "getLastName", "getLinkedAccountsAvailable", "getMiddleName", "getParentEmail", "getParentEmailVerified", "getPhones", "getPrefix", "getPronunciationName", "getReferenceId", "getRegion", "getRegistrationDate", "()Ljava/util/Date;", "getStatus", "getSuffix", "getSwid", "getTestProfileFlag", "getUsername", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy$OneID_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/disney/id/android/Profile;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Profile {

    @NotNull
    public static final String ADDRESSES = "addresses";

    @NotNull
    public static final String PHONES = "phones";

    @NotNull
    public static final String SWID = "swid";

    @Nullable
    private final List<Address> addresses;

    @Nullable
    private final String ageBand;

    @Nullable
    private final Boolean ageBandAssumed;

    @Nullable
    private final Boolean complete;

    @Nullable
    private final String countryCodeDetected;

    @Nullable
    private final String dateOfBirth;

    @Nullable
    private final String email;

    @Nullable
    private final Boolean emailVerified;

    @Nullable
    private final String firstName;

    @Nullable
    private final String gender;

    @Nullable
    private final Boolean isAdultVerified;

    @Nullable
    private final Boolean isShareable;

    @Nullable
    private final String languagePreference;

    @Nullable
    private final String lastName;

    @Nullable
    private final Boolean linkedAccountsAvailable;

    @Nullable
    private final String middleName;

    @Nullable
    private final String parentEmail;

    @Nullable
    private final Boolean parentEmailVerified;

    @Nullable
    private final List<Phone> phones;

    @Nullable
    private final String prefix;

    @Nullable
    private final String pronunciationName;

    @Nullable
    private final String referenceId;

    @Nullable
    private final String region;

    @Nullable
    private final Date registrationDate;

    @Nullable
    private final String status;

    @Nullable
    private final String suffix;

    @Nullable
    private final String swid;

    @Nullable
    private final String testProfileFlag;

    @Nullable
    private final String username;

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getSwid() {
        return this.swid;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getLanguagePreference() {
        return this.languagePreference;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final String getParentEmail() {
        return this.parentEmail;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    /* renamed from: component16, reason: from getter */
    public final String getAgeBand() {
        return this.ageBand;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final Boolean getAgeBandAssumed() {
        return this.ageBandAssumed;
    }

    @Nullable
    /* renamed from: component18, reason: from getter */
    public final String getCountryCodeDetected() {
        return this.countryCodeDetected;
    }

    @Nullable
    /* renamed from: component19, reason: from getter */
    public final Boolean getEmailVerified() {
        return this.emailVerified;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getReferenceId() {
        return this.referenceId;
    }

    @Nullable
    /* renamed from: component20, reason: from getter */
    public final Boolean getParentEmailVerified() {
        return this.parentEmailVerified;
    }

    @Nullable
    /* renamed from: component21, reason: from getter */
    public final Date getRegistrationDate() {
        return this.registrationDate;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Boolean getLinkedAccountsAvailable() {
        return this.linkedAccountsAvailable;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final Boolean getComplete() {
        return this.complete;
    }

    @Nullable
    /* renamed from: component24, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final List<Address> component25() {
        return this.addresses;
    }

    @Nullable
    public final List<Phone> component26() {
        return this.phones;
    }

    @Nullable
    /* renamed from: component27, reason: from getter */
    public final String getPronunciationName() {
        return this.pronunciationName;
    }

    @Nullable
    /* renamed from: component28, reason: from getter */
    public final Boolean getIsShareable() {
        return this.isShareable;
    }

    @Nullable
    /* renamed from: component29, reason: from getter */
    public final Boolean getIsAdultVerified() {
        return this.isAdultVerified;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getTestProfileFlag() {
        return this.testProfileFlag;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getMiddleName() {
        return this.middleName;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getSuffix() {
        return this.suffix;
    }

    @NotNull
    public final Profile copy(@Nullable String swid, @Nullable String referenceId, @Nullable String testProfileFlag, @Nullable String username, @Nullable String prefix, @Nullable String firstName, @Nullable String middleName, @Nullable String lastName, @Nullable String suffix, @Nullable String languagePreference, @Nullable String region, @Nullable String email, @Nullable String parentEmail, @Nullable String dateOfBirth, @Nullable String gender, @Nullable String ageBand, @Nullable Boolean ageBandAssumed, @Nullable String countryCodeDetected, @Nullable Boolean emailVerified, @Nullable Boolean parentEmailVerified, @Nullable Date registrationDate, @Nullable Boolean linkedAccountsAvailable, @Nullable Boolean complete, @Nullable String status, @Nullable List<Address> addresses, @Nullable List<Phone> phones, @Nullable String pronunciationName, @Nullable Boolean isShareable, @Nullable Boolean isAdultVerified) {
        return new Profile(swid, referenceId, testProfileFlag, username, prefix, firstName, middleName, lastName, suffix, languagePreference, region, email, parentEmail, dateOfBirth, gender, ageBand, ageBandAssumed, countryCodeDetected, emailVerified, parentEmailVerified, registrationDate, linkedAccountsAvailable, complete, status, addresses, phones, pronunciationName, isShareable, isAdultVerified);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) other;
        return Intrinsics.areEqual(this.swid, profile.swid) && Intrinsics.areEqual(this.referenceId, profile.referenceId) && Intrinsics.areEqual(this.testProfileFlag, profile.testProfileFlag) && Intrinsics.areEqual(this.username, profile.username) && Intrinsics.areEqual(this.prefix, profile.prefix) && Intrinsics.areEqual(this.firstName, profile.firstName) && Intrinsics.areEqual(this.middleName, profile.middleName) && Intrinsics.areEqual(this.lastName, profile.lastName) && Intrinsics.areEqual(this.suffix, profile.suffix) && Intrinsics.areEqual(this.languagePreference, profile.languagePreference) && Intrinsics.areEqual(this.region, profile.region) && Intrinsics.areEqual(this.email, profile.email) && Intrinsics.areEqual(this.parentEmail, profile.parentEmail) && Intrinsics.areEqual(this.dateOfBirth, profile.dateOfBirth) && Intrinsics.areEqual(this.gender, profile.gender) && Intrinsics.areEqual(this.ageBand, profile.ageBand) && Intrinsics.areEqual(this.ageBandAssumed, profile.ageBandAssumed) && Intrinsics.areEqual(this.countryCodeDetected, profile.countryCodeDetected) && Intrinsics.areEqual(this.emailVerified, profile.emailVerified) && Intrinsics.areEqual(this.parentEmailVerified, profile.parentEmailVerified) && Intrinsics.areEqual(this.registrationDate, profile.registrationDate) && Intrinsics.areEqual(this.linkedAccountsAvailable, profile.linkedAccountsAvailable) && Intrinsics.areEqual(this.complete, profile.complete) && Intrinsics.areEqual(this.status, profile.status) && Intrinsics.areEqual(this.addresses, profile.addresses) && Intrinsics.areEqual(this.phones, profile.phones) && Intrinsics.areEqual(this.pronunciationName, profile.pronunciationName) && Intrinsics.areEqual(this.isShareable, profile.isShareable) && Intrinsics.areEqual(this.isAdultVerified, profile.isAdultVerified);
    }

    public int hashCode() {
        String str = this.swid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.referenceId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.testProfileFlag;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.username;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.prefix;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.firstName;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.middleName;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.lastName;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.suffix;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.languagePreference;
        int iHashCode10 = (iHashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.region;
        int iHashCode11 = (iHashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.email;
        int iHashCode12 = (iHashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.parentEmail;
        int iHashCode13 = (iHashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.dateOfBirth;
        int iHashCode14 = (iHashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.gender;
        int iHashCode15 = (iHashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.ageBand;
        int iHashCode16 = (iHashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Boolean bool = this.ageBandAssumed;
        int iHashCode17 = (iHashCode16 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str17 = this.countryCodeDetected;
        int iHashCode18 = (iHashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Boolean bool2 = this.emailVerified;
        int iHashCode19 = (iHashCode18 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.parentEmailVerified;
        int iHashCode20 = (iHashCode19 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Date date = this.registrationDate;
        int iHashCode21 = (iHashCode20 + (date == null ? 0 : date.hashCode())) * 31;
        Boolean bool4 = this.linkedAccountsAvailable;
        int iHashCode22 = (iHashCode21 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.complete;
        int iHashCode23 = (iHashCode22 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        String str18 = this.status;
        int iHashCode24 = (iHashCode23 + (str18 == null ? 0 : str18.hashCode())) * 31;
        List<Address> list = this.addresses;
        int iHashCode25 = (iHashCode24 + (list == null ? 0 : list.hashCode())) * 31;
        List<Phone> list2 = this.phones;
        int iHashCode26 = (iHashCode25 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str19 = this.pronunciationName;
        int iHashCode27 = (iHashCode26 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Boolean bool6 = this.isShareable;
        int iHashCode28 = (iHashCode27 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.isAdultVerified;
        return iHashCode28 + (bool7 != null ? bool7.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Profile(swid=" + this.swid + ", referenceId=" + this.referenceId + ", testProfileFlag=" + this.testProfileFlag + ", username=" + this.username + ", prefix=" + this.prefix + ", firstName=" + this.firstName + ", middleName=" + this.middleName + ", lastName=" + this.lastName + ", suffix=" + this.suffix + ", languagePreference=" + this.languagePreference + ", region=" + this.region + ", email=" + this.email + ", parentEmail=" + this.parentEmail + ", dateOfBirth=" + this.dateOfBirth + ", gender=" + this.gender + ", ageBand=" + this.ageBand + ", ageBandAssumed=" + this.ageBandAssumed + ", countryCodeDetected=" + this.countryCodeDetected + ", emailVerified=" + this.emailVerified + ", parentEmailVerified=" + this.parentEmailVerified + ", registrationDate=" + this.registrationDate + ", linkedAccountsAvailable=" + this.linkedAccountsAvailable + ", complete=" + this.complete + ", status=" + this.status + ", addresses=" + this.addresses + ", phones=" + this.phones + ", pronunciationName=" + this.pronunciationName + ", isShareable=" + this.isShareable + ", isAdultVerified=" + this.isAdultVerified + ")";
    }

    public Profile(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable Boolean bool, @Nullable String str17, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Date date, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable String str18, @Nullable List<Address> list, @Nullable List<Phone> list2, @Nullable String str19, @Nullable Boolean bool6, @Nullable Boolean bool7) {
        this.swid = str;
        this.referenceId = str2;
        this.testProfileFlag = str3;
        this.username = str4;
        this.prefix = str5;
        this.firstName = str6;
        this.middleName = str7;
        this.lastName = str8;
        this.suffix = str9;
        this.languagePreference = str10;
        this.region = str11;
        this.email = str12;
        this.parentEmail = str13;
        this.dateOfBirth = str14;
        this.gender = str15;
        this.ageBand = str16;
        this.ageBandAssumed = bool;
        this.countryCodeDetected = str17;
        this.emailVerified = bool2;
        this.parentEmailVerified = bool3;
        this.registrationDate = date;
        this.linkedAccountsAvailable = bool4;
        this.complete = bool5;
        this.status = str18;
        this.addresses = list;
        this.phones = list2;
        this.pronunciationName = str19;
        this.isShareable = bool6;
        this.isAdultVerified = bool7;
    }

    @Nullable
    public final String getSwid() {
        return this.swid;
    }

    @Nullable
    public final String getReferenceId() {
        return this.referenceId;
    }

    @Nullable
    public final String getTestProfileFlag() {
        return this.testProfileFlag;
    }

    @Nullable
    public final String getUsername() {
        return this.username;
    }

    @Nullable
    public final String getPrefix() {
        return this.prefix;
    }

    @Nullable
    public final String getFirstName() {
        return this.firstName;
    }

    @Nullable
    public final String getMiddleName() {
        return this.middleName;
    }

    @Nullable
    public final String getLastName() {
        return this.lastName;
    }

    @Nullable
    public final String getSuffix() {
        return this.suffix;
    }

    @Nullable
    public final String getLanguagePreference() {
        return this.languagePreference;
    }

    @Nullable
    public final String getRegion() {
        return this.region;
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
    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Nullable
    public final String getGender() {
        return this.gender;
    }

    @Nullable
    public final String getAgeBand() {
        return this.ageBand;
    }

    @Nullable
    public final Boolean getAgeBandAssumed() {
        return this.ageBandAssumed;
    }

    @Nullable
    public final String getCountryCodeDetected() {
        return this.countryCodeDetected;
    }

    @Nullable
    public final Boolean getEmailVerified() {
        return this.emailVerified;
    }

    @Nullable
    public final Boolean getParentEmailVerified() {
        return this.parentEmailVerified;
    }

    @Nullable
    public final Date getRegistrationDate() {
        return this.registrationDate;
    }

    @Nullable
    public final Boolean getLinkedAccountsAvailable() {
        return this.linkedAccountsAvailable;
    }

    @Nullable
    public final Boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final List<Address> getAddresses() {
        return this.addresses;
    }

    @Nullable
    public final List<Phone> getPhones() {
        return this.phones;
    }

    @Nullable
    public final String getPronunciationName() {
        return this.pronunciationName;
    }

    @Nullable
    public final Boolean isShareable() {
        return this.isShareable;
    }

    @Nullable
    public final Boolean isAdultVerified() {
        return this.isAdultVerified;
    }

    @NotNull
    public final Profile copy$OneID_release() {
        String str = this.swid;
        String str2 = this.referenceId;
        String str3 = this.testProfileFlag;
        String str4 = this.username;
        String str5 = this.prefix;
        String str6 = this.firstName;
        String str7 = this.middleName;
        String str8 = this.lastName;
        String str9 = this.suffix;
        String str10 = this.languagePreference;
        String str11 = this.region;
        String str12 = this.email;
        String str13 = this.parentEmail;
        String str14 = this.dateOfBirth;
        String str15 = this.gender;
        String str16 = this.ageBand;
        Boolean bool = this.ageBandAssumed;
        String str17 = this.countryCodeDetected;
        Boolean bool2 = this.emailVerified;
        Boolean bool3 = this.parentEmailVerified;
        Date date = this.registrationDate;
        Date date2 = (Date) (date != null ? date.clone() : null);
        Boolean bool4 = this.linkedAccountsAvailable;
        Boolean bool5 = this.complete;
        String str18 = this.status;
        List<Address> list = this.addresses;
        List list2 = list != null ? CollectionsKt.toList(list) : null;
        List<Phone> list3 = this.phones;
        return new Profile(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, bool, str17, bool2, bool3, date2, bool4, bool5, str18, list2, list3 != null ? CollectionsKt.toList(list3) : null, this.pronunciationName, this.isShareable, this.isAdultVerified);
    }
}
