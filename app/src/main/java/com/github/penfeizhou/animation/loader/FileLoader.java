package com.github.penfeizhou.animation.loader;

import com.github.penfeizhou.animation.p032io.FileReader;
import com.github.penfeizhou.animation.p032io.Reader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FileLoader implements Loader {
    private final File mFile;

    public FileLoader(String str) {
        this.mFile = new File(str);
    }

    @Override // com.github.penfeizhou.animation.loader.Loader
    public synchronized Reader obtain() throws IOException {
        return new FileReader(this.mFile);
    }
}
