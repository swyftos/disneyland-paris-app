package org.bouncycastle.est;

import java.io.IOException;

/* loaded from: classes6.dex */
public interface ESTHijacker {
    ESTResponse hijack(ESTRequest eSTRequest, Source source) throws IOException;
}
