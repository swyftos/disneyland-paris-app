package com.allegion.accessblecredential.communication;

import com.fasterxml.jackson.annotation.JsonProperty;

/* loaded from: classes2.dex */
class AlCredentialChallengeResult {

    @JsonProperty
    public byte[] encPayload;

    @JsonProperty
    public String genMsgType;

    @JsonProperty
    public AlSignatures[] signatures;

    AlCredentialChallengeResult() {
    }
}
