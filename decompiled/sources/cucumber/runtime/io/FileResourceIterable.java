package cucumber.runtime.io;

import java.io.File;
import java.util.Iterator;

/* loaded from: classes5.dex */
class FileResourceIterable implements Iterable {
    private final File file;
    private final File root;
    private final String suffix;

    FileResourceIterable(File file, File file2, String str) {
        this.root = file;
        this.file = file2;
        this.suffix = str;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return FileResourceIterator.createFileResourceIterator(this.root, this.file, this.suffix);
    }
}
