package cucumber.runtime.io;

import java.net.URI;

/* loaded from: classes5.dex */
public interface ResourceLoader {
    Iterable<Resource> resources(URI uri, String str);
}
