package com.allegion.accesssdk.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ \u0010\u000f\u001a\u00020\u00002\u000e\b\u0003\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/allegion/accesssdk/models/AlPullPayloadsResponse;", "Ljava/io/Serializable;", "", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "Lcom/allegion/accesssdk/models/AlPayload;", "component1", "()[Lcom/allegion/accesssdk/models/AlPayload;", "payloads", "copy", "([Lcom/allegion/accesssdk/models/AlPayload;)Lcom/allegion/accesssdk/models/AlPullPayloadsResponse;", "", "toString", "()Ljava/lang/String;", "[Lcom/allegion/accesssdk/models/AlPayload;", "getPayloads", "<init>", "([Lcom/allegion/accesssdk/models/AlPayload;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class AlPullPayloadsResponse implements java.io.Serializable {

    @NotNull
    private final AlPayload[] payloads;

    public AlPullPayloadsResponse(@JsonProperty("payloads") @NotNull AlPayload[] payloads) {
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        this.payloads = payloads;
    }

    public static /* synthetic */ AlPullPayloadsResponse copy$default(AlPullPayloadsResponse alPullPayloadsResponse, AlPayload[] alPayloadArr, int i, Object obj) {
        if ((i & 1) != 0) {
            alPayloadArr = alPullPayloadsResponse.payloads;
        }
        return alPullPayloadsResponse.copy(alPayloadArr);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final AlPayload[] getPayloads() {
        return this.payloads;
    }

    @NotNull
    public final AlPullPayloadsResponse copy(@JsonProperty("payloads") @NotNull AlPayload[] payloads) {
        Intrinsics.checkParameterIsNotNull(payloads, "payloads");
        return new AlPullPayloadsResponse(payloads);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AlPullPayloadsResponse.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            return Arrays.equals(this.payloads, ((AlPullPayloadsResponse) other).payloads);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.allegion.accesssdk.models.AlPullPayloadsResponse");
    }

    @NotNull
    public final AlPayload[] getPayloads() {
        return this.payloads;
    }

    public int hashCode() {
        return Arrays.hashCode(this.payloads);
    }

    @NotNull
    public String toString() {
        return "AlPullPayloadsResponse(payloads=" + Arrays.toString(this.payloads) + ")";
    }
}
