package org.bouncycastle.mime;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public interface MimeMultipartContext extends MimeContext {
    MimeContext createContext(int i) throws IOException;
}
