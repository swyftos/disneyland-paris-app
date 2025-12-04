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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/disney/id/android/ProfileChangePPU;", "Lcom/disney/id/android/PPU;", "fields", "", "Lcom/disney/id/android/Field;", "(Ljava/util/List;)V", "getFields", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ProfileChangePPU implements PPU {

    @NotNull
    private final List<Field> fields;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProfileChangePPU copy$default(ProfileChangePPU profileChangePPU, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = profileChangePPU.fields;
        }
        return profileChangePPU.copy(list);
    }

    @NotNull
    public final List<Field> component1() {
        return this.fields;
    }

    @NotNull
    public final ProfileChangePPU copy(@NotNull List<Field> fields) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        return new ProfileChangePPU(fields);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ProfileChangePPU) && Intrinsics.areEqual(this.fields, ((ProfileChangePPU) other).fields);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    @NotNull
    public String toString() {
        return "ProfileChangePPU(fields=" + this.fields + ")";
    }

    public ProfileChangePPU(@NotNull List<Field> fields) {
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.fields = fields;
    }

    @NotNull
    public final List<Field> getFields() {
        return this.fields;
    }
}
