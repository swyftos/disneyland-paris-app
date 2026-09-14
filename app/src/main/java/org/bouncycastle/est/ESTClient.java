package org.bouncycastle.est;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface ESTClient {
    ESTResponse doRequest(ESTRequest eSTRequest) throws IOException;
}
