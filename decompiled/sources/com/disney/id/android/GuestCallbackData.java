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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJZ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/disney/id/android/GuestCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "guest", "Lcom/disney/id/android/Guest;", "accountCreated", "ppus", "", "Lcom/disney/id/android/PPU;", "didReauth", "(ZLcom/disney/id/android/OneIDError;Lcom/disney/id/android/Guest;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)V", "getAccountCreated", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDidReauth", "getError", "()Lcom/disney/id/android/OneIDError;", "getGuest", "()Lcom/disney/id/android/Guest;", "getPpus", "()Ljava/util/List;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLcom/disney/id/android/OneIDError;Lcom/disney/id/android/Guest;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;)Lcom/disney/id/android/GuestCallbackData;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GuestCallbackData extends OneIDCallbackData {

    @Nullable
    private final Boolean accountCreated;

    @Nullable
    private final Boolean didReauth;

    @Nullable
    private final OneIDError error;

    @Nullable
    private final Guest guest;

    @Nullable
    private final List<PPU> ppus;
    private final boolean success;

    public static /* synthetic */ GuestCallbackData copy$default(GuestCallbackData guestCallbackData, boolean z, OneIDError oneIDError, Guest guest, Boolean bool, List list, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = guestCallbackData.success;
        }
        if ((i & 2) != 0) {
            oneIDError = guestCallbackData.error;
        }
        OneIDError oneIDError2 = oneIDError;
        if ((i & 4) != 0) {
            guest = guestCallbackData.guest;
        }
        Guest guest2 = guest;
        if ((i & 8) != 0) {
            bool = guestCallbackData.accountCreated;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            list = guestCallbackData.ppus;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            bool2 = guestCallbackData.didReauth;
        }
        return guestCallbackData.copy(z, oneIDError2, guest2, bool3, list2, bool2);
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
    /* renamed from: component3, reason: from getter */
    public final Guest getGuest() {
        return this.guest;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Boolean getAccountCreated() {
        return this.accountCreated;
    }

    @Nullable
    public final List<PPU> component5() {
        return this.ppus;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getDidReauth() {
        return this.didReauth;
    }

    @NotNull
    public final GuestCallbackData copy(boolean success, @Nullable OneIDError error, @Nullable Guest guest, @Nullable Boolean accountCreated, @Nullable List<? extends PPU> ppus, @Nullable Boolean didReauth) {
        return new GuestCallbackData(success, error, guest, accountCreated, ppus, didReauth);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuestCallbackData)) {
            return false;
        }
        GuestCallbackData guestCallbackData = (GuestCallbackData) other;
        return this.success == guestCallbackData.success && Intrinsics.areEqual(this.error, guestCallbackData.error) && Intrinsics.areEqual(this.guest, guestCallbackData.guest) && Intrinsics.areEqual(this.accountCreated, guestCallbackData.accountCreated) && Intrinsics.areEqual(this.ppus, guestCallbackData.ppus) && Intrinsics.areEqual(this.didReauth, guestCallbackData.didReauth);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        OneIDError oneIDError = this.error;
        int iHashCode2 = (iHashCode + (oneIDError == null ? 0 : oneIDError.hashCode())) * 31;
        Guest guest = this.guest;
        int iHashCode3 = (iHashCode2 + (guest == null ? 0 : guest.hashCode())) * 31;
        Boolean bool = this.accountCreated;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<PPU> list = this.ppus;
        int iHashCode5 = (iHashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool2 = this.didReauth;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GuestCallbackData(success=" + this.success + ", error=" + this.error + ", guest=" + this.guest + ", accountCreated=" + this.accountCreated + ", ppus=" + this.ppus + ", didReauth=" + this.didReauth + ")";
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
    public final Guest getGuest() {
        return this.guest;
    }

    public /* synthetic */ GuestCallbackData(boolean z, OneIDError oneIDError, Guest guest, Boolean bool, List list, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError, (i & 4) != 0 ? null : guest, (i & 8) != 0 ? Boolean.FALSE : bool, (i & 16) == 0 ? list : null, (i & 32) != 0 ? Boolean.FALSE : bool2);
    }

    @Nullable
    public final Boolean getAccountCreated() {
        return this.accountCreated;
    }

    @Nullable
    public final List<PPU> getPpus() {
        return this.ppus;
    }

    @Nullable
    public final Boolean getDidReauth() {
        return this.didReauth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuestCallbackData(boolean z, @Nullable OneIDError oneIDError, @Nullable Guest guest, @Nullable Boolean bool, @Nullable List<? extends PPU> list, @Nullable Boolean bool2) {
        super(z, oneIDError);
        this.success = z;
        this.error = oneIDError;
        this.guest = guest;
        this.accountCreated = bool;
        this.ppus = list;
        this.didReauth = bool2;
    }
}
