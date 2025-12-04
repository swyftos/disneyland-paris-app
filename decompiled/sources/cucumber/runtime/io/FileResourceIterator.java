package cucumber.runtime.io;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes5.dex */
class FileResourceIterator implements Iterator {
    private final FlatteningIterator flatteningIterator;

    static FileResourceIterator createFileResourceIterator(File file, File file2, String str) {
        return new FileResourceIterator(file, file2, str, false);
    }

    static FileResourceIterator createClasspathFileResourceIterator(File file, File file2, String str) {
        return new FileResourceIterator(file, file2, str, true);
    }

    private FileResourceIterator(File file, File file2, final String str, boolean z) {
        FlatteningIterator flatteningIterator = new FlatteningIterator();
        this.flatteningIterator = flatteningIterator;
        flatteningIterator.push(new FileIterator(file, file2, new FileFilter() { // from class: cucumber.runtime.io.FileResourceIterator.1
            @Override // java.io.FileFilter
            public boolean accept(File file3) {
                return file3.isDirectory() || Helpers.hasSuffix(str, file3.getPath());
            }
        }, z));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.flatteningIterator.hasNext();
    }

    @Override // java.util.Iterator
    public Resource next() {
        return (Resource) this.flatteningIterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private static class FileIterator implements Iterator {
        private final boolean classpathFileIterator;
        private final Iterator files;
        private final FileFilter filter;
        private final File root;

        FileIterator(File file, File file2, FileFilter fileFilter, boolean z) {
            this.root = file;
            if (file2.isDirectory()) {
                this.files = Arrays.asList(file2.listFiles(fileFilter)).iterator();
            } else if (file2.isFile()) {
                this.files = Arrays.asList(file2).iterator();
            } else {
                throw new IllegalArgumentException("Not a file or directory: " + file2.getAbsolutePath());
            }
            this.filter = fileFilter;
            this.classpathFileIterator = z;
        }

        @Override // java.util.Iterator
        public Object next() {
            File file = (File) this.files.next();
            if (file.isDirectory()) {
                return new FileIterator(this.root, file, this.filter, this.classpathFileIterator);
            }
            return createFileResource(file);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.files.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.files.remove();
        }

        private FileResource createFileResource(File file) {
            if (this.classpathFileIterator) {
                return FileResource.createClasspathFileResource(this.root, file);
            }
            return FileResource.createFileResource(this.root, file);
        }
    }
}
