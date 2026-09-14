package com.github.penfeizhou.animation.p032io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FileReader extends FilterReader {
    private final File mFile;

    public FileReader(File file) throws IOException {
        super(new StreamReader(new FileInputStream(file)));
        this.mFile = file;
    }

    @Override // com.github.penfeizhou.animation.p032io.FilterReader, com.github.penfeizhou.animation.p032io.Reader
    public void reset() throws IOException {
        this.reader.close();
        this.reader = new StreamReader(new FileInputStream(this.mFile));
    }
}
