package cucumber.runtime.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/* loaded from: classes5.dex */
public interface Resource {
    InputStream getInputStream() throws IOException;

    URI getPath();
}
