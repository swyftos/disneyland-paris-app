package com.disney.id.android;

import androidx.annotation.Keep;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/disney/id/android/Marketing;", "", "code", "", "subscribed", "", "status", "textID", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getStatus", "getSubscribed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTextID", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/id/android/Marketing;", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Marketing {

    @Nullable
    private final String code;

    @Nullable
    private final String status;

    @Nullable
    private final Boolean subscribed;

    @Nullable
    private final String textID;

    public static /* synthetic */ Marketing copy$default(Marketing marketing, String str, Boolean bool, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = marketing.code;
        }
        if ((i & 2) != 0) {
            bool = marketing.subscribed;
        }
        if ((i & 4) != 0) {
            str2 = marketing.status;
        }
        if ((i & 8) != 0) {
            str3 = marketing.textID;
        }
        return marketing.copy(str, bool, str2, str3);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Boolean getSubscribed() {
        return this.subscribed;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getTextID() {
        return this.textID;
    }

    @NotNull
    public final Marketing copy(@Nullable String code, @Nullable Boolean subscribed, @Nullable String status, @Nullable String textID) {
        return new Marketing(code, subscribed, status, textID);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Marketing)) {
            return false;
        }
        Marketing marketing = (Marketing) other;
        return Intrinsics.areEqual(this.code, marketing.code) && Intrinsics.areEqual(this.subscribed, marketing.subscribed) && Intrinsics.areEqual(this.status, marketing.status) && Intrinsics.areEqual(this.textID, marketing.textID);
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.subscribed;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.status;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.textID;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Marketing(code=" + this.code + ", subscribed=" + this.subscribed + ", status=" + this.status + ", textID=" + this.textID + ")";
    }

    public Marketing(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable String str3) {
        this.code = str;
        this.subscribed = bool;
        this.status = str2;
        this.textID = str3;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final Boolean getSubscribed() {
        return this.subscribed;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTextID() {
        return this.textID;
    }
}
