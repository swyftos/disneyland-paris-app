package io.cucumber.junit;

import android.content.Context;
import cucumber.runtime.io.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/* loaded from: classes5.dex */
public final class AndroidResource implements Resource {
    private final Context context;
    private final URI path;
    private final String pathInAssets;

    AndroidResource(Context context, URI uri) {
        this.context = context;
        this.path = uri;
        this.pathInAssets = uri.getSchemeSpecificPart();
    }

    @Override // cucumber.runtime.io.Resource
    public URI getPath() {
        return this.path;
    }

    @Override // cucumber.runtime.io.Resource
    public InputStream getInputStream() throws IOException {
        return this.context.getAssets().open(this.pathInAssets, 0);
    }

    public String toString() {
        return "AndroidResource (" + this.pathInAssets + ")";
    }
}
