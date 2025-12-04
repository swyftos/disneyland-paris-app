package cucumber.runtime.io;

import java.io.File;
import java.net.URI;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes5.dex */
class ZipResourceIterator implements Iterator {
    private final Enumeration entries;
    private final ZipFile jarFile;
    private Resource next;
    private final String path;
    private final String suffix;

    ZipResourceIterator(URI uri, String str, String str2) {
        this.path = str;
        this.suffix = str2;
        ZipFile zipFile = new ZipFile(new File(uri));
        this.jarFile = zipFile;
        this.entries = zipFile.entries();
        moveToNext();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public Resource next() {
        try {
            Resource resource = this.next;
            if (resource != null) {
                return resource;
            }
            throw new NoSuchElementException();
        } finally {
            moveToNext();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private void moveToNext() {
        this.next = null;
        while (this.entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) this.entries.nextElement();
            String name = zipEntry.getName();
            if (name.startsWith(this.path) && Helpers.hasSuffix(this.suffix, name)) {
                this.next = new ZipResource(this.jarFile, zipEntry);
                return;
            }
        }
    }
}
