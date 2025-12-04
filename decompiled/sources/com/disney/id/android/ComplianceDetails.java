package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\fHÆ\u0003JQ\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2 = {"Lcom/disney/id/android/ComplianceDetails;", "", "legal", "", "Lcom/disney/id/android/LegalDetail;", "marketing", "Lcom/disney/id/android/MarketingDetail;", "countries", "Lcom/disney/id/android/Country;", "defaultCountry", "", "allowGALC", "", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)V", "getAllowGALC", "()Z", "getCountries", "()Ljava/util/List;", "getDefaultCountry", "()Ljava/lang/String;", "getLegal", "getMarketing", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ComplianceDetails {
    private final boolean allowGALC;

    @NotNull
    private final List<Country> countries;

    @NotNull
    private final String defaultCountry;

    @Nullable
    private final List<LegalDetail> legal;

    @Nullable
    private final List<MarketingDetail> marketing;

    public static /* synthetic */ ComplianceDetails copy$default(ComplianceDetails complianceDetails, List list, List list2, List list3, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = complianceDetails.legal;
        }
        if ((i & 2) != 0) {
            list2 = complianceDetails.marketing;
        }
        List list4 = list2;
        if ((i & 4) != 0) {
            list3 = complianceDetails.countries;
        }
        List list5 = list3;
        if ((i & 8) != 0) {
            str = complianceDetails.defaultCountry;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            z = complianceDetails.allowGALC;
        }
        return complianceDetails.copy(list, list4, list5, str2, z);
    }

    @Nullable
    public final List<LegalDetail> component1() {
        return this.legal;
    }

    @Nullable
    public final List<MarketingDetail> component2() {
        return this.marketing;
    }

    @NotNull
    public final List<Country> component3() {
        return this.countries;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getDefaultCountry() {
        return this.defaultCountry;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getAllowGALC() {
        return this.allowGALC;
    }

    @NotNull
    public final ComplianceDetails copy(@Nullable List<LegalDetail> legal, @Nullable List<MarketingDetail> marketing, @NotNull List<Country> countries, @NotNull String defaultCountry, boolean allowGALC) {
        Intrinsics.checkNotNullParameter(countries, "countries");
        Intrinsics.checkNotNullParameter(defaultCountry, "defaultCountry");
        return new ComplianceDetails(legal, marketing, countries, defaultCountry, allowGALC);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComplianceDetails)) {
            return false;
        }
        ComplianceDetails complianceDetails = (ComplianceDetails) other;
        return Intrinsics.areEqual(this.legal, complianceDetails.legal) && Intrinsics.areEqual(this.marketing, complianceDetails.marketing) && Intrinsics.areEqual(this.countries, complianceDetails.countries) && Intrinsics.areEqual(this.defaultCountry, complianceDetails.defaultCountry) && this.allowGALC == complianceDetails.allowGALC;
    }

    public int hashCode() {
        List<LegalDetail> list = this.legal;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<MarketingDetail> list2 = this.marketing;
        return ((((((iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31) + this.countries.hashCode()) * 31) + this.defaultCountry.hashCode()) * 31) + Boolean.hashCode(this.allowGALC);
    }

    @NotNull
    public String toString() {
        return "ComplianceDetails(legal=" + this.legal + ", marketing=" + this.marketing + ", countries=" + this.countries + ", defaultCountry=" + this.defaultCountry + ", allowGALC=" + this.allowGALC + ")";
    }

    public ComplianceDetails(@Nullable List<LegalDetail> list, @Nullable List<MarketingDetail> list2, @NotNull List<Country> countries, @NotNull String defaultCountry, boolean z) {
        Intrinsics.checkNotNullParameter(countries, "countries");
        Intrinsics.checkNotNullParameter(defaultCountry, "defaultCountry");
        this.legal = list;
        this.marketing = list2;
        this.countries = countries;
        this.defaultCountry = defaultCountry;
        this.allowGALC = z;
    }

    @Nullable
    public final List<LegalDetail> getLegal() {
        return this.legal;
    }

    @Nullable
    public final List<MarketingDetail> getMarketing() {
        return this.marketing;
    }

    @NotNull
    public final List<Country> getCountries() {
        return this.countries;
    }

    @NotNull
    public final String getDefaultCountry() {
        return this.defaultCountry;
    }

    public final boolean getAllowGALC() {
        return this.allowGALC;
    }
}
