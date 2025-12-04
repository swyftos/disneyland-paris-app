package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlAuthenticationResponse;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B'\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u000f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\u0010\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\bR\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010 R\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b!\u0010\b¨\u0006%"}, d2 = {"Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;", "Lcom/allegion/accesssdk/actions/IAlImmutableRequestCacheable;", "Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", "", "getIgnoreCache", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Ljava/lang/Class;", "getResponseType", "()Ljava/lang/Class;", "component1", "component2", "component3", "inviteId", "inviteSecret", "subscriptionKey", "ignoreCache", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/allegion/accesssdk/actions/AlImmutableAuthenticationRequest;", "toString", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getInviteId", "getInviteSecret", "Z", "getSubscriptionKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class AlImmutableAuthenticationRequest implements IAlImmutableRequestCacheable<AlAuthenticationResponse> {
    private static final Class<AlAuthenticationResponse> RESPONSE_TYPE = AlAuthenticationResponse.class;
    private final boolean ignoreCache;

    @NotNull
    private final String inviteId;

    @NotNull
    private final String inviteSecret;

    @NotNull
    private final String subscriptionKey;

    public AlImmutableAuthenticationRequest(@NotNull String inviteId, @NotNull String inviteSecret, @NotNull String subscriptionKey, boolean z) {
        Intrinsics.checkParameterIsNotNull(inviteId, "inviteId");
        Intrinsics.checkParameterIsNotNull(inviteSecret, "inviteSecret");
        Intrinsics.checkParameterIsNotNull(subscriptionKey, "subscriptionKey");
        this.inviteId = inviteId;
        this.inviteSecret = inviteSecret;
        this.subscriptionKey = subscriptionKey;
        this.ignoreCache = z;
    }

    public static /* synthetic */ AlImmutableAuthenticationRequest copy$default(AlImmutableAuthenticationRequest alImmutableAuthenticationRequest, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alImmutableAuthenticationRequest.inviteId;
        }
        if ((i & 2) != 0) {
            str2 = alImmutableAuthenticationRequest.inviteSecret;
        }
        if ((i & 4) != 0) {
            str3 = alImmutableAuthenticationRequest.subscriptionKey;
        }
        if ((i & 8) != 0) {
            z = alImmutableAuthenticationRequest.ignoreCache;
        }
        return alImmutableAuthenticationRequest.copy(str, str2, str3, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getInviteId() {
        return this.inviteId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getInviteSecret() {
        return this.inviteSecret;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getSubscriptionKey() {
        return this.subscriptionKey;
    }

    @NotNull
    public final AlImmutableAuthenticationRequest copy(@NotNull String inviteId, @NotNull String inviteSecret, @NotNull String subscriptionKey, boolean ignoreCache) {
        Intrinsics.checkParameterIsNotNull(inviteId, "inviteId");
        Intrinsics.checkParameterIsNotNull(inviteSecret, "inviteSecret");
        Intrinsics.checkParameterIsNotNull(subscriptionKey, "subscriptionKey");
        return new AlImmutableAuthenticationRequest(inviteId, inviteSecret, subscriptionKey, ignoreCache);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlImmutableAuthenticationRequest)) {
            return false;
        }
        AlImmutableAuthenticationRequest alImmutableAuthenticationRequest = (AlImmutableAuthenticationRequest) other;
        return Intrinsics.areEqual(this.inviteId, alImmutableAuthenticationRequest.inviteId) && Intrinsics.areEqual(this.inviteSecret, alImmutableAuthenticationRequest.inviteSecret) && Intrinsics.areEqual(this.subscriptionKey, alImmutableAuthenticationRequest.subscriptionKey) && this.ignoreCache == alImmutableAuthenticationRequest.ignoreCache;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    @NotNull
    public String getCacheKey() {
        return AlAuthenticationAction.URI_AUTHENTICATE;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    public boolean getIgnoreCache() {
        return this.ignoreCache;
    }

    @NotNull
    public final String getInviteId() {
        return this.inviteId;
    }

    @NotNull
    public final String getInviteSecret() {
        return this.inviteSecret;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    @NotNull
    public Class<AlAuthenticationResponse> getResponseType() {
        return RESPONSE_TYPE;
    }

    @NotNull
    public final String getSubscriptionKey() {
        return this.subscriptionKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.inviteId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.inviteSecret;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subscriptionKey;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.ignoreCache;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "AlImmutableAuthenticationRequest(inviteId=" + this.inviteId + ", inviteSecret=" + this.inviteSecret + ", subscriptionKey=" + this.subscriptionKey + ", ignoreCache=" + this.ignoreCache + ")";
    }
}
