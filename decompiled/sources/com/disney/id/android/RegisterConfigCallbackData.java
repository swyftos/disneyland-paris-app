package com.disney.id.android;

import androidx.annotation.Keep;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/disney/id/android/RegisterConfigCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "complianceDetails", "Lcom/disney/id/android/ComplianceDetails;", "fieldDetails", "", "Lcom/disney/id/android/Field;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "(Lcom/disney/id/android/ComplianceDetails;Ljava/util/List;ZLcom/disney/id/android/OneIDError;)V", "getComplianceDetails", "()Lcom/disney/id/android/ComplianceDetails;", "getError", "()Lcom/disney/id/android/OneIDError;", "getFieldDetails", "()Ljava/util/List;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RegisterConfigCallbackData extends OneIDCallbackData {

    @Nullable
    private final ComplianceDetails complianceDetails;

    @Nullable
    private final OneIDError error;

    @NotNull
    private final List<Field> fieldDetails;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegisterConfigCallbackData copy$default(RegisterConfigCallbackData registerConfigCallbackData, ComplianceDetails complianceDetails, List list, boolean z, OneIDError oneIDError, int i, Object obj) {
        if ((i & 1) != 0) {
            complianceDetails = registerConfigCallbackData.complianceDetails;
        }
        if ((i & 2) != 0) {
            list = registerConfigCallbackData.fieldDetails;
        }
        if ((i & 4) != 0) {
            z = registerConfigCallbackData.success;
        }
        if ((i & 8) != 0) {
            oneIDError = registerConfigCallbackData.error;
        }
        return registerConfigCallbackData.copy(complianceDetails, list, z, oneIDError);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final ComplianceDetails getComplianceDetails() {
        return this.complianceDetails;
    }

    @NotNull
    public final List<Field> component2() {
        return this.fieldDetails;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final OneIDError getError() {
        return this.error;
    }

    @NotNull
    public final RegisterConfigCallbackData copy(@Nullable ComplianceDetails complianceDetails, @NotNull List<Field> fieldDetails, boolean success, @Nullable OneIDError error) {
        Intrinsics.checkNotNullParameter(fieldDetails, "fieldDetails");
        return new RegisterConfigCallbackData(complianceDetails, fieldDetails, success, error);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterConfigCallbackData)) {
            return false;
        }
        RegisterConfigCallbackData registerConfigCallbackData = (RegisterConfigCallbackData) other;
        return Intrinsics.areEqual(this.complianceDetails, registerConfigCallbackData.complianceDetails) && Intrinsics.areEqual(this.fieldDetails, registerConfigCallbackData.fieldDetails) && this.success == registerConfigCallbackData.success && Intrinsics.areEqual(this.error, registerConfigCallbackData.error);
    }

    public int hashCode() {
        ComplianceDetails complianceDetails = this.complianceDetails;
        int iHashCode = (((((complianceDetails == null ? 0 : complianceDetails.hashCode()) * 31) + this.fieldDetails.hashCode()) * 31) + Boolean.hashCode(this.success)) * 31;
        OneIDError oneIDError = this.error;
        return iHashCode + (oneIDError != null ? oneIDError.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RegisterConfigCallbackData(complianceDetails=" + this.complianceDetails + ", fieldDetails=" + this.fieldDetails + ", success=" + this.success + ", error=" + this.error + ")";
    }

    public /* synthetic */ RegisterConfigCallbackData(ComplianceDetails complianceDetails, List list, boolean z, OneIDError oneIDError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(complianceDetails, list, z, (i & 8) != 0 ? null : oneIDError);
    }

    @Nullable
    public final ComplianceDetails getComplianceDetails() {
        return this.complianceDetails;
    }

    @NotNull
    public final List<Field> getFieldDetails() {
        return this.fieldDetails;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RegisterConfigCallbackData(@Nullable ComplianceDetails complianceDetails, @NotNull List<Field> fieldDetails, boolean z, @Nullable OneIDError oneIDError) {
        super(z, oneIDError);
        Intrinsics.checkNotNullParameter(fieldDetails, "fieldDetails");
        this.complianceDetails = complianceDetails;
        this.fieldDetails = fieldDetails;
        this.success = z;
        this.error = oneIDError;
    }
}
