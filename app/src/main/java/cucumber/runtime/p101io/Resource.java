package cucumber.runtime.p101io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public interface Resource {
    InputStream getInputStream() throws IOException;

    URI getPath();
}
