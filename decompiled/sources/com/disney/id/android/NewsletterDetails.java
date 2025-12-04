package com.disney.id.android;

import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/disney/id/android/NewsletterDetails;", "", Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, "", "email", "legal", "", "Lcom/disney/id/android/LegalDetail;", "marketing", "Lcom/disney/id/android/MarketingDetail;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCampaignId", "()Ljava/lang/String;", "getEmail", "setEmail", "(Ljava/lang/String;)V", "getLegal", "()Ljava/util/List;", "getMarketing", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class NewsletterDetails {

    @Nullable
    private final String campaignId;

    @Nullable
    private String email;

    @Nullable
    private final List<LegalDetail> legal;

    @NotNull
    private final List<MarketingDetail> marketing;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewsletterDetails copy$default(NewsletterDetails newsletterDetails, String str, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = newsletterDetails.campaignId;
        }
        if ((i & 2) != 0) {
            str2 = newsletterDetails.email;
        }
        if ((i & 4) != 0) {
            list = newsletterDetails.legal;
        }
        if ((i & 8) != 0) {
            list2 = newsletterDetails.marketing;
        }
        return newsletterDetails.copy(str, str2, list, list2);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCampaignId() {
        return this.campaignId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final List<LegalDetail> component3() {
        return this.legal;
    }

    @NotNull
    public final List<MarketingDetail> component4() {
        return this.marketing;
    }

    @NotNull
    public final NewsletterDetails copy(@Nullable String campaignId, @Nullable String email, @Nullable List<LegalDetail> legal, @NotNull List<MarketingDetail> marketing) {
        Intrinsics.checkNotNullParameter(marketing, "marketing");
        return new NewsletterDetails(campaignId, email, legal, marketing);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewsletterDetails)) {
            return false;
        }
        NewsletterDetails newsletterDetails = (NewsletterDetails) other;
        return Intrinsics.areEqual(this.campaignId, newsletterDetails.campaignId) && Intrinsics.areEqual(this.email, newsletterDetails.email) && Intrinsics.areEqual(this.legal, newsletterDetails.legal) && Intrinsics.areEqual(this.marketing, newsletterDetails.marketing);
    }

    public int hashCode() {
        String str = this.campaignId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.email;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<LegalDetail> list = this.legal;
        return ((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + this.marketing.hashCode();
    }

    @NotNull
    public String toString() {
        return "NewsletterDetails(campaignId=" + this.campaignId + ", email=" + this.email + ", legal=" + this.legal + ", marketing=" + this.marketing + ")";
    }

    public NewsletterDetails(@Nullable String str, @Nullable String str2, @Nullable List<LegalDetail> list, @NotNull List<MarketingDetail> marketing) {
        Intrinsics.checkNotNullParameter(marketing, "marketing");
        this.campaignId = str;
        this.email = str2;
        this.legal = list;
        this.marketing = marketing;
    }

    public /* synthetic */ NewsletterDetails(String str, String str2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, str2, list, list2);
    }

    @Nullable
    public final String getCampaignId() {
        return this.campaignId;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(@Nullable String str) {
        this.email = str;
    }

    @Nullable
    public final List<LegalDetail> getLegal() {
        return this.legal;
    }

    @NotNull
    public final List<MarketingDetail> getMarketing() {
        return this.marketing;
    }
}
