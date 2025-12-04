package com.urbanairship.analytics;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/analytics/ConversionData;", "", "conversionSendId", "", "conversionMetadata", "lastReceivedMetadata", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConversionMetadata", "()Ljava/lang/String;", "getConversionSendId", "getLastReceivedMetadata", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public final /* data */ class ConversionData {
    private final String conversionMetadata;
    private final String conversionSendId;
    private final String lastReceivedMetadata;

    public ConversionData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ConversionData copy$default(ConversionData conversionData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = conversionData.conversionSendId;
        }
        if ((i & 2) != 0) {
            str2 = conversionData.conversionMetadata;
        }
        if ((i & 4) != 0) {
            str3 = conversionData.lastReceivedMetadata;
        }
        return conversionData.copy(str, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getConversionSendId() {
        return this.conversionSendId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getConversionMetadata() {
        return this.conversionMetadata;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getLastReceivedMetadata() {
        return this.lastReceivedMetadata;
    }

    @NotNull
    public final ConversionData copy(@Nullable String conversionSendId, @Nullable String conversionMetadata, @Nullable String lastReceivedMetadata) {
        return new ConversionData(conversionSendId, conversionMetadata, lastReceivedMetadata);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversionData)) {
            return false;
        }
        ConversionData conversionData = (ConversionData) other;
        return Intrinsics.areEqual(this.conversionSendId, conversionData.conversionSendId) && Intrinsics.areEqual(this.conversionMetadata, conversionData.conversionMetadata) && Intrinsics.areEqual(this.lastReceivedMetadata, conversionData.lastReceivedMetadata);
    }

    public int hashCode() {
        String str = this.conversionSendId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.conversionMetadata;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lastReceivedMetadata;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ConversionData(conversionSendId=" + this.conversionSendId + ", conversionMetadata=" + this.conversionMetadata + ", lastReceivedMetadata=" + this.lastReceivedMetadata + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ConversionData(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.conversionSendId = str;
        this.conversionMetadata = str2;
        this.lastReceivedMetadata = str3;
    }

    public /* synthetic */ ConversionData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getConversionSendId() {
        return this.conversionSendId;
    }

    @Nullable
    public final String getConversionMetadata() {
        return this.conversionMetadata;
    }

    @Nullable
    public final String getLastReceivedMetadata() {
        return this.lastReceivedMetadata;
    }
}
