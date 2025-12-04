package com.disney.id.android;

import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/disney/id/android/UnidCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "result", "", "", "(ZLcom/disney/id/android/OneIDError;Ljava/util/Map;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "getResult", "()Ljava/util/Map;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UnidCallbackData extends OneIDCallbackData {

    @Nullable
    private final OneIDError error;

    @Nullable
    private final Map<String, String> result;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UnidCallbackData copy$default(UnidCallbackData unidCallbackData, boolean z, OneIDError oneIDError, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = unidCallbackData.success;
        }
        if ((i & 2) != 0) {
            oneIDError = unidCallbackData.error;
        }
        if ((i & 4) != 0) {
            map = unidCallbackData.result;
        }
        return unidCallbackData.copy(z, oneIDError, map);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final OneIDError getError() {
        return this.error;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.result;
    }

    @NotNull
    public final UnidCallbackData copy(boolean success, @Nullable OneIDError error, @Nullable Map<String, String> result) {
        return new UnidCallbackData(success, error, result);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnidCallbackData)) {
            return false;
        }
        UnidCallbackData unidCallbackData = (UnidCallbackData) other;
        return this.success == unidCallbackData.success && Intrinsics.areEqual(this.error, unidCallbackData.error) && Intrinsics.areEqual(this.result, unidCallbackData.result);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        OneIDError oneIDError = this.error;
        int iHashCode2 = (iHashCode + (oneIDError == null ? 0 : oneIDError.hashCode())) * 31;
        Map<String, String> map = this.result;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UnidCallbackData(success=" + this.success + ", error=" + this.error + ", result=" + this.result + ")";
    }

    public /* synthetic */ UnidCallbackData(boolean z, OneIDError oneIDError, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError, (i & 4) != 0 ? null : map);
    }

    @Override // com.disney.id.android.OneIDCallbackData
    public boolean getSuccess() {
        return this.success;
    }

    @Override // com.disney.id.android.OneIDCallbackData
    @Nullable
    public OneIDError getError() {
        return this.error;
    }

    @Nullable
    public final Map<String, String> getResult() {
        return this.result;
    }

    public UnidCallbackData(boolean z, @Nullable OneIDError oneIDError, @Nullable Map<String, String> map) {
        super(z, oneIDError);
        this.success = z;
        this.error = oneIDError;
        this.result = map;
    }
}
