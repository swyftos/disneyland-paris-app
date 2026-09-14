package org.bouncycastle.operator;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public interface AADProcessor {
    OutputStream getAADStream();

    byte[] getMAC();
}
