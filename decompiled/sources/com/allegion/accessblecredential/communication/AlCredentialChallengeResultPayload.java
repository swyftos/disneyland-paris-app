package com.allegion.accessblecredential.communication;

import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes2.dex */
class AlCredentialChallengeResultPayload {

    @JsonProperty
    public byte[] devAuthKey;

    @JsonProperty
    public int genMaxSz;

    @JsonProperty
    public byte[] sNonce;

    AlCredentialChallengeResultPayload() {
    }
}
