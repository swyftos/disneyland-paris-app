package com.github.penfeizhou.animation.loader;

import com.github.penfeizhou.animation.p032io.Reader;
import com.github.penfeizhou.animation.p032io.StreamReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamLoader implements Loader {
    protected abstract InputStream getInputStream() throws IOException;

    @Override // com.github.penfeizhou.animation.loader.Loader
    public final synchronized Reader obtain() throws IOException {
        return new StreamReader(getInputStream());
    }
}
