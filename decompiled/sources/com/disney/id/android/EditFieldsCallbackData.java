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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/disney/id/android/EditFieldsCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "fields", "", "Lcom/disney/id/android/EditableField;", "(ZLcom/disney/id/android/OneIDError;Ljava/util/List;)V", "getError", "()Lcom/disney/id/android/OneIDError;", "getFields", "()Ljava/util/List;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class EditFieldsCallbackData extends OneIDCallbackData {

    @Nullable
    private final OneIDError error;

    @Nullable
    private final List<EditableField> fields;
    private final boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EditFieldsCallbackData copy$default(EditFieldsCallbackData editFieldsCallbackData, boolean z, OneIDError oneIDError, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = editFieldsCallbackData.success;
        }
        if ((i & 2) != 0) {
            oneIDError = editFieldsCallbackData.error;
        }
        if ((i & 4) != 0) {
            list = editFieldsCallbackData.fields;
        }
        return editFieldsCallbackData.copy(z, oneIDError, list);
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
    public final List<EditableField> component3() {
        return this.fields;
    }

    @NotNull
    public final EditFieldsCallbackData copy(boolean success, @Nullable OneIDError error, @Nullable List<EditableField> fields) {
        return new EditFieldsCallbackData(success, error, fields);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditFieldsCallbackData)) {
            return false;
        }
        EditFieldsCallbackData editFieldsCallbackData = (EditFieldsCallbackData) other;
        return this.success == editFieldsCallbackData.success && Intrinsics.areEqual(this.error, editFieldsCallbackData.error) && Intrinsics.areEqual(this.fields, editFieldsCallbackData.fields);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        OneIDError oneIDError = this.error;
        int iHashCode2 = (iHashCode + (oneIDError == null ? 0 : oneIDError.hashCode())) * 31;
        List<EditableField> list = this.fields;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "EditFieldsCallbackData(success=" + this.success + ", error=" + this.error + ", fields=" + this.fields + ")";
    }

    public /* synthetic */ EditFieldsCallbackData(boolean z, OneIDError oneIDError, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError, (i & 4) != 0 ? null : list);
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
    public final List<EditableField> getFields() {
        return this.fields;
    }

    public EditFieldsCallbackData(boolean z, @Nullable OneIDError oneIDError, @Nullable List<EditableField> list) {
        super(z, oneIDError);
        this.success = z;
        this.error = oneIDError;
        this.fields = list;
    }
}
