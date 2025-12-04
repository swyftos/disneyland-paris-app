package com.contentsquare.android.error.analysis.apierror.v2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorCollectionDuration;", "", TypedValues.TransitionType.S_DURATION, "", EventProcessorPerformanceManager.LOG_EVENT_DURATION_LEVEL, "", "requestSizeLevel", "responseSizeLevel", "(JILjava/lang/Integer;Ljava/lang/Integer;)V", "getDuration", "()J", "getDurationLevel", "()I", "getRequestSizeLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResponseSizeLevel", "component1", "component2", "component3", "component4", "copy", "(JILjava/lang/Integer;Ljava/lang/Integer;)Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorCollectionDuration;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ApiErrorCollectionDuration {
    private final long duration;
    private final int durationLevel;

    @Nullable
    private final Integer requestSizeLevel;

    @Nullable
    private final Integer responseSizeLevel;

    public ApiErrorCollectionDuration(long j, int i, Integer num, Integer num2) {
        this.duration = j;
        this.durationLevel = i;
        this.requestSizeLevel = num;
        this.responseSizeLevel = num2;
    }

    public static /* synthetic */ ApiErrorCollectionDuration copy$default(ApiErrorCollectionDuration apiErrorCollectionDuration, long j, int i, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = apiErrorCollectionDuration.duration;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            i = apiErrorCollectionDuration.durationLevel;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            num = apiErrorCollectionDuration.requestSizeLevel;
        }
        Integer num3 = num;
        if ((i2 & 8) != 0) {
            num2 = apiErrorCollectionDuration.responseSizeLevel;
        }
        return apiErrorCollectionDuration.copy(j2, i3, num3, num2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDurationLevel() {
        return this.durationLevel;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Integer getRequestSizeLevel() {
        return this.requestSizeLevel;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getResponseSizeLevel() {
        return this.responseSizeLevel;
    }

    @NotNull
    public final ApiErrorCollectionDuration copy(long duration, int durationLevel, Integer requestSizeLevel, Integer responseSizeLevel) {
        return new ApiErrorCollectionDuration(duration, durationLevel, requestSizeLevel, responseSizeLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiErrorCollectionDuration)) {
            return false;
        }
        ApiErrorCollectionDuration apiErrorCollectionDuration = (ApiErrorCollectionDuration) other;
        return this.duration == apiErrorCollectionDuration.duration && this.durationLevel == apiErrorCollectionDuration.durationLevel && Intrinsics.areEqual(this.requestSizeLevel, apiErrorCollectionDuration.requestSizeLevel) && Intrinsics.areEqual(this.responseSizeLevel, apiErrorCollectionDuration.responseSizeLevel);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getDurationLevel() {
        return this.durationLevel;
    }

    @Nullable
    public final Integer getRequestSizeLevel() {
        return this.requestSizeLevel;
    }

    @Nullable
    public final Integer getResponseSizeLevel() {
        return this.responseSizeLevel;
    }

    public int hashCode() {
        int iHashCode = (Integer.hashCode(this.durationLevel) + (Long.hashCode(this.duration) * 31)) * 31;
        Integer num = this.requestSizeLevel;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.responseSizeLevel;
        return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ApiErrorCollectionDuration(duration=" + this.duration + ", durationLevel=" + this.durationLevel + ", requestSizeLevel=" + this.requestSizeLevel + ", responseSizeLevel=" + this.responseSizeLevel + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }
}
