package cucumber.runtime.io;

import io.cucumber.core.model.Classpath;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes5.dex */
class FileResource implements Resource {
    private final boolean classpathFileResource;
    private final File file;
    private final File root;

    static FileResource createFileResource(File file, File file2) {
        return new FileResource(file, file2, false);
    }

    static FileResource createClasspathFileResource(File file, File file2) {
        return new FileResource(file, file2, true);
    }

    private FileResource(File file, File file2, boolean z) {
        this.root = file;
        this.file = file2;
        this.classpathFileResource = z;
        if (file2.getAbsolutePath().startsWith(file.getAbsolutePath())) {
            return;
        }
        throw new IllegalArgumentException(file2.getAbsolutePath() + " is not a parent of " + file.getAbsolutePath());
    }

    @Override // cucumber.runtime.io.Resource
    public URI getPath() {
        if (this.classpathFileResource) {
            return createURI(Classpath.CLASSPATH_SCHEME, getRelativePath());
        }
        if (this.root.equals(this.file)) {
            return this.file.toURI();
        }
        return createURI("file", getRelativePath());
    }

    private static URI createURI(String str, String str2) {
        try {
            return new URI(str, str2, null);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String getRelativePath() {
        return this.root.toURI().relativize(this.file.toURI()).getSchemeSpecificPart();
    }

    @Override // cucumber.runtime.io.Resource
    public InputStream getInputStream() {
        return new FileInputStream(this.file);
    }
}
