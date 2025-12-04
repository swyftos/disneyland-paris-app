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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ^\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\nHÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0002\b\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/disney/id/android/UpdateProfileCallbackData;", "Lcom/disney/id/android/OneIDCallbackData;", "success", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "Lcom/disney/id/android/OneIDError;", "guest", "Lcom/disney/id/android/Guest;", "changes", "", "", "didReauth", "accountDeleted", "(ZLcom/disney/id/android/OneIDError;Lcom/disney/id/android/Guest;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAccountDeleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getChanges", "()Ljava/util/Map;", "getDidReauth", "getError", "()Lcom/disney/id/android/OneIDError;", "getGuest", "()Lcom/disney/id/android/Guest;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLcom/disney/id/android/OneIDError;Lcom/disney/id/android/Guest;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/disney/id/android/UpdateProfileCallbackData;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UpdateProfileCallbackData extends OneIDCallbackData {

    @Nullable
    private final Boolean accountDeleted;

    @Nullable
    private final Map<String, ?> changes;

    @Nullable
    private final Boolean didReauth;

    @Nullable
    private final OneIDError error;

    @Nullable
    private final Guest guest;
    private final boolean success;

    public static /* synthetic */ UpdateProfileCallbackData copy$default(UpdateProfileCallbackData updateProfileCallbackData, boolean z, OneIDError oneIDError, Guest guest, Map map, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = updateProfileCallbackData.success;
        }
        if ((i & 2) != 0) {
            oneIDError = updateProfileCallbackData.error;
        }
        OneIDError oneIDError2 = oneIDError;
        if ((i & 4) != 0) {
            guest = updateProfileCallbackData.guest;
        }
        Guest guest2 = guest;
        if ((i & 8) != 0) {
            map = updateProfileCallbackData.changes;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            bool = updateProfileCallbackData.didReauth;
        }
        Boolean bool3 = bool;
        if ((i & 32) != 0) {
            bool2 = updateProfileCallbackData.accountDeleted;
        }
        return updateProfileCallbackData.copy(z, oneIDError2, guest2, map2, bool3, bool2);
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
    public final Map<String, ?> component4() {
        return this.changes;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Boolean getDidReauth() {
        return this.didReauth;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Boolean getAccountDeleted() {
        return this.accountDeleted;
    }

    @NotNull
    public final UpdateProfileCallbackData copy(boolean success, @Nullable OneIDError error, @Nullable Guest guest, @Nullable Map<String, ?> changes, @Nullable Boolean didReauth, @Nullable Boolean accountDeleted) {
        return new UpdateProfileCallbackData(success, error, guest, changes, didReauth, accountDeleted);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateProfileCallbackData)) {
            return false;
        }
        UpdateProfileCallbackData updateProfileCallbackData = (UpdateProfileCallbackData) other;
        return this.success == updateProfileCallbackData.success && Intrinsics.areEqual(this.error, updateProfileCallbackData.error) && Intrinsics.areEqual(this.guest, updateProfileCallbackData.guest) && Intrinsics.areEqual(this.changes, updateProfileCallbackData.changes) && Intrinsics.areEqual(this.didReauth, updateProfileCallbackData.didReauth) && Intrinsics.areEqual(this.accountDeleted, updateProfileCallbackData.accountDeleted);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        OneIDError oneIDError = this.error;
        int iHashCode2 = (iHashCode + (oneIDError == null ? 0 : oneIDError.hashCode())) * 31;
        Guest guest = this.guest;
        int iHashCode3 = (iHashCode2 + (guest == null ? 0 : guest.hashCode())) * 31;
        Map<String, ?> map = this.changes;
        int iHashCode4 = (iHashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool = this.didReauth;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.accountDeleted;
        return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UpdateProfileCallbackData(success=" + this.success + ", error=" + this.error + ", guest=" + this.guest + ", changes=" + this.changes + ", didReauth=" + this.didReauth + ", accountDeleted=" + this.accountDeleted + ")";
    }

    public /* synthetic */ UpdateProfileCallbackData(boolean z, OneIDError oneIDError, Guest guest, Map map, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : oneIDError, (i & 4) != 0 ? null : guest, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : bool, (i & 32) == 0 ? bool2 : null);
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

    @Nullable
    public final Map<String, ?> getChanges() {
        return this.changes;
    }

    @Nullable
    public final Boolean getDidReauth() {
        return this.didReauth;
    }

    @Nullable
    public final Boolean getAccountDeleted() {
        return this.accountDeleted;
    }

    public UpdateProfileCallbackData(boolean z, @Nullable OneIDError oneIDError, @Nullable Guest guest, @Nullable Map<String, ?> map, @Nullable Boolean bool, @Nullable Boolean bool2) {
        super(z, oneIDError);
        this.success = z;
        this.error = oneIDError;
        this.guest = guest;
        this.changes = map;
        this.didReauth = bool;
        this.accountDeleted = bool2;
    }
}
