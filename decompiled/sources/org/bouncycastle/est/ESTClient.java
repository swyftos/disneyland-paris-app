package org.bouncycastle.est;

import java.io.IOException;

/* loaded from: classes6.dex */
public interface ESTClient {
    ESTResponse doRequest(ESTRequest eSTRequest) throws IOException;
}
