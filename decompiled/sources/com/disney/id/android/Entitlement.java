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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\r\u0010\u001f\u001a\u00020\u0000H\u0000¢\u0006\u0002\b Jb\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006("}, d2 = {"Lcom/disney/id/android/Entitlement;", "", "digitalAssetName", "", "digitalAssetSourceName", "productId", "", "assetId", "effectiveDate", "Ljava/util/Date;", "expirationDate", "policyType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)V", "getAssetId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDigitalAssetName", "()Ljava/lang/String;", "getDigitalAssetSourceName", "getEffectiveDate", "()Ljava/util/Date;", "getExpirationDate", "getPolicyType", "getProductId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "copy$OneID_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;)Lcom/disney/id/android/Entitlement;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Entitlement {

    @Nullable
    private final Long assetId;

    @Nullable
    private final String digitalAssetName;

    @Nullable
    private final String digitalAssetSourceName;

    @Nullable
    private final Date effectiveDate;

    @Nullable
    private final Date expirationDate;

    @Nullable
    private final String policyType;

    @Nullable
    private final Long productId;

    public static /* synthetic */ Entitlement copy$default(Entitlement entitlement, String str, String str2, Long l, Long l2, Date date, Date date2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = entitlement.digitalAssetName;
        }
        if ((i & 2) != 0) {
            str2 = entitlement.digitalAssetSourceName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            l = entitlement.productId;
        }
        Long l3 = l;
        if ((i & 8) != 0) {
            l2 = entitlement.assetId;
        }
        Long l4 = l2;
        if ((i & 16) != 0) {
            date = entitlement.effectiveDate;
        }
        Date date3 = date;
        if ((i & 32) != 0) {
            date2 = entitlement.expirationDate;
        }
        Date date4 = date2;
        if ((i & 64) != 0) {
            str3 = entitlement.policyType;
        }
        return entitlement.copy(str, str4, l3, l4, date3, date4, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getDigitalAssetName() {
        return this.digitalAssetName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getDigitalAssetSourceName() {
        return this.digitalAssetSourceName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getProductId() {
        return this.productId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Long getAssetId() {
        return this.assetId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Date getEffectiveDate() {
        return this.effectiveDate;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getPolicyType() {
        return this.policyType;
    }

    @NotNull
    public final Entitlement copy(@Nullable String digitalAssetName, @Nullable String digitalAssetSourceName, @Nullable Long productId, @Nullable Long assetId, @Nullable Date effectiveDate, @Nullable Date expirationDate, @Nullable String policyType) {
        return new Entitlement(digitalAssetName, digitalAssetSourceName, productId, assetId, effectiveDate, expirationDate, policyType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Entitlement)) {
            return false;
        }
        Entitlement entitlement = (Entitlement) other;
        return Intrinsics.areEqual(this.digitalAssetName, entitlement.digitalAssetName) && Intrinsics.areEqual(this.digitalAssetSourceName, entitlement.digitalAssetSourceName) && Intrinsics.areEqual(this.productId, entitlement.productId) && Intrinsics.areEqual(this.assetId, entitlement.assetId) && Intrinsics.areEqual(this.effectiveDate, entitlement.effectiveDate) && Intrinsics.areEqual(this.expirationDate, entitlement.expirationDate) && Intrinsics.areEqual(this.policyType, entitlement.policyType);
    }

    public int hashCode() {
        String str = this.digitalAssetName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.digitalAssetSourceName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.productId;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.assetId;
        int iHashCode4 = (iHashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Date date = this.effectiveDate;
        int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.expirationDate;
        int iHashCode6 = (iHashCode5 + (date2 == null ? 0 : date2.hashCode())) * 31;
        String str3 = this.policyType;
        return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Entitlement(digitalAssetName=" + this.digitalAssetName + ", digitalAssetSourceName=" + this.digitalAssetSourceName + ", productId=" + this.productId + ", assetId=" + this.assetId + ", effectiveDate=" + this.effectiveDate + ", expirationDate=" + this.expirationDate + ", policyType=" + this.policyType + ")";
    }

    public Entitlement(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable Long l2, @Nullable Date date, @Nullable Date date2, @Nullable String str3) {
        this.digitalAssetName = str;
        this.digitalAssetSourceName = str2;
        this.productId = l;
        this.assetId = l2;
        this.effectiveDate = date;
        this.expirationDate = date2;
        this.policyType = str3;
    }

    @Nullable
    public final String getDigitalAssetName() {
        return this.digitalAssetName;
    }

    @Nullable
    public final String getDigitalAssetSourceName() {
        return this.digitalAssetSourceName;
    }

    @Nullable
    public final Long getProductId() {
        return this.productId;
    }

    @Nullable
    public final Long getAssetId() {
        return this.assetId;
    }

    @Nullable
    public final Date getEffectiveDate() {
        return this.effectiveDate;
    }

    @Nullable
    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    @Nullable
    public final String getPolicyType() {
        return this.policyType;
    }

    @NotNull
    public final Entitlement copy$OneID_release() {
        String str = this.digitalAssetName;
        String str2 = this.digitalAssetSourceName;
        Long l = this.productId;
        Long l2 = this.assetId;
        Date date = this.effectiveDate;
        Date date2 = (Date) (date != null ? date.clone() : null);
        Date date3 = this.expirationDate;
        return new Entitlement(str, str2, l, l2, date2, (Date) (date3 != null ? date3.clone() : null), this.policyType);
    }
}
