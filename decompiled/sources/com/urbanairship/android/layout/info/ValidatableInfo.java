package com.urbanairship.android.layout.info;

import ch.qos.logback.core.CoreConstants;
import com.rumax.reactnative.pdfviewer.PDFView;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/android/layout/info/ValidatableInfo;", "Lcom/urbanairship/android/layout/info/Validatable;", "isRequired", "", PDFView.EVENT_ON_ERROR, "Lcom/urbanairship/android/layout/info/ValidationAction;", "onValid", "onEdit", "(ZLcom/urbanairship/android/layout/info/ValidationAction;Lcom/urbanairship/android/layout/info/ValidationAction;Lcom/urbanairship/android/layout/info/ValidationAction;)V", "()Z", "getOnEdit", "()Lcom/urbanairship/android/layout/info/ValidationAction;", "getOnError", "getOnValid", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ValidatableInfo implements Validatable {
    private final boolean isRequired;
    private final ValidationAction onEdit;
    private final ValidationAction onError;
    private final ValidationAction onValid;

    public static /* synthetic */ ValidatableInfo copy$default(ValidatableInfo validatableInfo, boolean z, ValidationAction validationAction, ValidationAction validationAction2, ValidationAction validationAction3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = validatableInfo.isRequired;
        }
        if ((i & 2) != 0) {
            validationAction = validatableInfo.onError;
        }
        if ((i & 4) != 0) {
            validationAction2 = validatableInfo.onValid;
        }
        if ((i & 8) != 0) {
            validationAction3 = validatableInfo.onEdit;
        }
        return validatableInfo.copy(z, validationAction, validationAction2, validationAction3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsRequired() {
        return this.isRequired;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final ValidationAction getOnError() {
        return this.onError;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final ValidationAction getOnValid() {
        return this.onValid;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final ValidationAction getOnEdit() {
        return this.onEdit;
    }

    @NotNull
    public final ValidatableInfo copy(boolean isRequired, @Nullable ValidationAction onError, @Nullable ValidationAction onValid, @Nullable ValidationAction onEdit) {
        return new ValidatableInfo(isRequired, onError, onValid, onEdit);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidatableInfo)) {
            return false;
        }
        ValidatableInfo validatableInfo = (ValidatableInfo) other;
        return this.isRequired == validatableInfo.isRequired && Intrinsics.areEqual(this.onError, validatableInfo.onError) && Intrinsics.areEqual(this.onValid, validatableInfo.onValid) && Intrinsics.areEqual(this.onEdit, validatableInfo.onEdit);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isRequired) * 31;
        ValidationAction validationAction = this.onError;
        int iHashCode2 = (iHashCode + (validationAction == null ? 0 : validationAction.hashCode())) * 31;
        ValidationAction validationAction2 = this.onValid;
        int iHashCode3 = (iHashCode2 + (validationAction2 == null ? 0 : validationAction2.hashCode())) * 31;
        ValidationAction validationAction3 = this.onEdit;
        return iHashCode3 + (validationAction3 != null ? validationAction3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ValidatableInfo(isRequired=" + this.isRequired + ", onError=" + this.onError + ", onValid=" + this.onValid + ", onEdit=" + this.onEdit + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public ValidatableInfo(boolean z, @Nullable ValidationAction validationAction, @Nullable ValidationAction validationAction2, @Nullable ValidationAction validationAction3) {
        this.isRequired = z;
        this.onError = validationAction;
        this.onValid = validationAction2;
        this.onEdit = validationAction3;
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    public boolean isRequired() {
        return this.isRequired;
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnError() {
        return this.onError;
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnValid() {
        return this.onValid;
    }

    @Override // com.urbanairship.android.layout.info.Validatable
    @Nullable
    public ValidationAction getOnEdit() {
        return this.onEdit;
    }
}
