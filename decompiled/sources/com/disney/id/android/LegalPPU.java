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
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/disney/id/android/LegalPPU;", "Lcom/disney/id/android/PPU;", "legal", "", "Lcom/disney/id/android/LegalDetail;", "(Ljava/util/List;)V", "getLegal", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LegalPPU implements PPU {

    @NotNull
    private final List<LegalDetail> legal;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LegalPPU copy$default(LegalPPU legalPPU, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = legalPPU.legal;
        }
        return legalPPU.copy(list);
    }

    @NotNull
    public final List<LegalDetail> component1() {
        return this.legal;
    }

    @NotNull
    public final LegalPPU copy(@NotNull List<LegalDetail> legal) {
        Intrinsics.checkNotNullParameter(legal, "legal");
        return new LegalPPU(legal);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LegalPPU) && Intrinsics.areEqual(this.legal, ((LegalPPU) other).legal);
    }

    public int hashCode() {
        return this.legal.hashCode();
    }

    @NotNull
    public String toString() {
        return "LegalPPU(legal=" + this.legal + ")";
    }

    public LegalPPU(@NotNull List<LegalDetail> legal) {
        Intrinsics.checkNotNullParameter(legal, "legal");
        this.legal = legal;
    }

    @NotNull
    public final List<LegalDetail> getLegal() {
        return this.legal;
    }
}
