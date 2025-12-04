package com.allegion.accesssdk.models;

import com.allegion.accesssdk.interfaces.IAlRequestCacheable;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001bR\"\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\u001bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010 ¨\u0006#"}, d2 = {"Lcom/allegion/accesssdk/models/AlAuthenticationRequest;", "Lcom/allegion/accesssdk/interfaces/IAlRequestCacheable;", "", "getIgnoreCache", "()Z", "", "component1", "()Ljava/lang/String;", "component2", "component3", "subscriptionKey", "inviteId", "inviteSecret", "shouldIgnoreCache", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/allegion/accesssdk/models/AlAuthenticationRequest;", "toString", "", "hashCode", "()I", "", ETCPaymentMethod.OTHER, ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getInviteId", "setInviteId", "(Ljava/lang/String;)V", "getInviteSecret", "setInviteSecret", "getSubscriptionKey", "setSubscriptionKey", "Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class AlAuthenticationRequest implements IAlRequestCacheable {

    @NotNull
    private String inviteId;

    @NotNull
    private String inviteSecret;
    private boolean shouldIgnoreCache;

    @NotNull
    private String subscriptionKey;

    public AlAuthenticationRequest() {
        this(null, null, null, false, 15, null);
    }

    public AlAuthenticationRequest(@NotNull String subscriptionKey, @NotNull String inviteId, @NotNull String inviteSecret, boolean z) {
        Intrinsics.checkParameterIsNotNull(subscriptionKey, "subscriptionKey");
        Intrinsics.checkParameterIsNotNull(inviteId, "inviteId");
        Intrinsics.checkParameterIsNotNull(inviteSecret, "inviteSecret");
        this.subscriptionKey = subscriptionKey;
        this.inviteId = inviteId;
        this.inviteSecret = inviteSecret;
        this.shouldIgnoreCache = z;
    }

    public static /* synthetic */ AlAuthenticationRequest copy$default(AlAuthenticationRequest alAuthenticationRequest, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = alAuthenticationRequest.subscriptionKey;
        }
        if ((i & 2) != 0) {
            str2 = alAuthenticationRequest.inviteId;
        }
        if ((i & 4) != 0) {
            str3 = alAuthenticationRequest.inviteSecret;
        }
        if ((i & 8) != 0) {
            z = alAuthenticationRequest.shouldIgnoreCache;
        }
        return alAuthenticationRequest.copy(str, str2, str3, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getSubscriptionKey() {
        return this.subscriptionKey;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getInviteId() {
        return this.inviteId;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getInviteSecret() {
        return this.inviteSecret;
    }

    @NotNull
    public final AlAuthenticationRequest copy(@NotNull String subscriptionKey, @NotNull String inviteId, @NotNull String inviteSecret, boolean shouldIgnoreCache) {
        Intrinsics.checkParameterIsNotNull(subscriptionKey, "subscriptionKey");
        Intrinsics.checkParameterIsNotNull(inviteId, "inviteId");
        Intrinsics.checkParameterIsNotNull(inviteSecret, "inviteSecret");
        return new AlAuthenticationRequest(subscriptionKey, inviteId, inviteSecret, shouldIgnoreCache);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlAuthenticationRequest)) {
            return false;
        }
        AlAuthenticationRequest alAuthenticationRequest = (AlAuthenticationRequest) other;
        return Intrinsics.areEqual(this.subscriptionKey, alAuthenticationRequest.subscriptionKey) && Intrinsics.areEqual(this.inviteId, alAuthenticationRequest.inviteId) && Intrinsics.areEqual(this.inviteSecret, alAuthenticationRequest.inviteSecret) && this.shouldIgnoreCache == alAuthenticationRequest.shouldIgnoreCache;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    /* renamed from: getIgnoreCache, reason: from getter */
    public boolean getShouldIgnoreCache() {
        return this.shouldIgnoreCache;
    }

    @NotNull
    public final String getInviteId() {
        return this.inviteId;
    }

    @NotNull
    public final String getInviteSecret() {
        return this.inviteSecret;
    }

    @NotNull
    public final String getSubscriptionKey() {
        return this.subscriptionKey;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.subscriptionKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.inviteId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.inviteSecret;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.shouldIgnoreCache;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode3 + i;
    }

    public final void setInviteId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.inviteId = str;
    }

    public final void setInviteSecret(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.inviteSecret = str;
    }

    public final void setSubscriptionKey(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.subscriptionKey = str;
    }

    @NotNull
    public String toString() {
        return "AlAuthenticationRequest(subscriptionKey=" + this.subscriptionKey + ", inviteId=" + this.inviteId + ", inviteSecret=" + this.inviteSecret + ", shouldIgnoreCache=" + this.shouldIgnoreCache + ")";
    }

    public /* synthetic */ AlAuthenticationRequest(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : z);
    }
}
