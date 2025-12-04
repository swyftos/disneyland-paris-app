package org.junit.rules;

import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;

/* loaded from: classes6.dex */
public class TemporaryFolder extends ExternalResource {
    private final boolean assureDeletion;
    private File folder;
    private final File parentFolder;

    public TemporaryFolder() {
        this((File) null);
    }

    public TemporaryFolder(File file) {
        this.parentFolder = file;
        this.assureDeletion = false;
    }

    protected TemporaryFolder(Builder builder) {
        this.parentFolder = builder.parentFolder;
        this.assureDeletion = builder.assureDeletion;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean assureDeletion;
        private File parentFolder;

        protected Builder() {
        }

        public Builder parentFolder(File file) {
            this.parentFolder = file;
            return this;
        }

        public Builder assureDeletion() {
            this.assureDeletion = true;
            return this;
        }

        public TemporaryFolder build() {
            return new TemporaryFolder(this);
        }
    }

    @Override // org.junit.rules.ExternalResource
    protected void before() throws Throwable {
        create();
    }

    @Override // org.junit.rules.ExternalResource
    protected void after() {
        delete();
    }

    public void create() throws IOException {
        this.folder = createTemporaryFolderIn(this.parentFolder);
    }

    public File newFile(String str) throws IOException {
        File file = new File(getRoot(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new IOException("a file with the name '" + str + "' already exists in the test folder");
    }

    public File newFile() throws IOException {
        return File.createTempFile("junit", null, getRoot());
    }

    public File newFolder(String str) throws IOException {
        return newFolder(str);
    }

    public File newFolder(String... strArr) throws IOException {
        if (strArr.length == 0) {
            throw new IllegalArgumentException("must pass at least one path");
        }
        File root = getRoot();
        int i = 0;
        for (String str : strArr) {
            if (new File(str).isAbsolute()) {
                throw new IOException("folder path '" + str + "' is not a relative path");
            }
        }
        int length = strArr.length;
        boolean z = true;
        File file = null;
        File file2 = root;
        while (i < length) {
            File file3 = new File(file, strArr[i]);
            File file4 = new File(root, file3.getPath());
            boolean zMkdirs = file4.mkdirs();
            if (!zMkdirs && !file4.isDirectory()) {
                if (file4.exists()) {
                    throw new IOException("a file with the path '" + file3.getPath() + "' exists");
                }
                throw new IOException("could not create a folder with the path '" + file3.getPath() + "'");
            }
            i++;
            file2 = file4;
            z = zMkdirs;
            file = file3;
        }
        if (z) {
            return file2;
        }
        throw new IOException("a folder with the path '" + file.getPath() + "' already exists");
    }

    public File newFolder() throws IOException {
        return createTemporaryFolderIn(getRoot());
    }

    private File createTemporaryFolderIn(File file) throws IOException {
        File file2 = null;
        int i = 0;
        while (i < 10000) {
            File fileCreateTempFile = File.createTempFile("junit", DefaultDiskStorage.FileType.TEMP, file);
            File file3 = new File(fileCreateTempFile.toString().substring(0, r2.length() - 4));
            if (file3.mkdir()) {
                fileCreateTempFile.delete();
                return file3;
            }
            fileCreateTempFile.delete();
            i++;
            file2 = file3;
        }
        throw new IOException("Unable to create temporary directory in: " + file.toString() + ". Tried 10000 times. Last attempted to create: " + file2.toString());
    }

    public File getRoot() {
        File file = this.folder;
        if (file != null) {
            return file;
        }
        throw new IllegalStateException("the temporary folder has not yet been created");
    }

    public void delete() {
        if (tryDelete() || !this.assureDeletion) {
            return;
        }
        Assert.fail("Unable to clean up temporary folder " + this.folder);
    }

    private boolean tryDelete() {
        File file = this.folder;
        if (file == null) {
            return true;
        }
        return recursiveDelete(file);
    }

    private boolean recursiveDelete(File file) {
        if (file.delete()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (!recursiveDelete(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }
}
