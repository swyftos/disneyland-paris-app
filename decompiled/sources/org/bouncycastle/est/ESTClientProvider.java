package org.bouncycastle.est;

/* loaded from: classes6.dex */
public interface ESTClientProvider {
    boolean isTrusted();

    ESTClient makeClient() throws ESTException;
}
