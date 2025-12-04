package com.allegion.accesshub.models;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.gson.annotations.SerializedName;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/allegion/accesshub/models/AuthenticationMAHWebRequest;", "", "", "component1", "()Ljava/lang/String;", "inviteSecret", "copy", "(Ljava/lang/String;)Lcom/allegion/accesshub/models/AuthenticationMAHWebRequest;", "toString", "", "hashCode", "()I", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getInviteSecret", "<init>", "(Ljava/lang/String;)V", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class AuthenticationMAHWebRequest {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName("InviteSecret")
    @Nullable
    private final String inviteSecret;

    public AuthenticationMAHWebRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AuthenticationMAHWebRequest(@Nullable String str) {
        this.inviteSecret = str;
    }

    public static /* synthetic */ AuthenticationMAHWebRequest copy$default(AuthenticationMAHWebRequest authenticationMAHWebRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationMAHWebRequest.inviteSecret;
        }
        return authenticationMAHWebRequest.copy(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getInviteSecret() {
        return this.inviteSecret;
    }

    @NotNull
    public final AuthenticationMAHWebRequest copy(@Nullable String inviteSecret) {
        return new AuthenticationMAHWebRequest(inviteSecret);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            return (other instanceof AuthenticationMAHWebRequest) && Intrinsics.areEqual(this.inviteSecret, ((AuthenticationMAHWebRequest) other).inviteSecret);
        }
        return true;
    }

    @Nullable
    public final String getInviteSecret() {
        return this.inviteSecret;
    }

    public int hashCode() {
        String str = this.inviteSecret;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "AuthenticationMAHWebRequest(inviteSecret=" + this.inviteSecret + ")";
    }

    public /* synthetic */ AuthenticationMAHWebRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
