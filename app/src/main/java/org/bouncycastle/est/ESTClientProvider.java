package org.bouncycastle.est;

/* JADX INFO: loaded from: classes6.dex */
public interface ESTClientProvider {
    boolean isTrusted();

    ESTClient makeClient() throws ESTException;
}
