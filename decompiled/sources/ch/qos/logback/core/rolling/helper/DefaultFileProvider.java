package ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public class DefaultFileProvider implements FileProvider {
    @Override // ch.qos.logback.core.rolling.helper.FileProvider
    public boolean deleteFile(File file) {
        return file.delete();
    }

    @Override // ch.qos.logback.core.rolling.helper.FileProvider
    public boolean exists(File file) {
        return file.exists();
    }

    @Override // ch.qos.logback.core.rolling.helper.FileProvider
    public boolean isDirectory(File file) {
        return file.isDirectory();
    }

    @Override // ch.qos.logback.core.rolling.helper.FileProvider
    public long length(File file) {
        return file.length();
    }

    @Override // ch.qos.logback.core.rolling.helper.FileProvider
    public String[] list(File file, FilenameFilter filenameFilter) {
        return file.list(filenameFilter);
    }

    @Override // ch.qos.logback.core.rolling.helper.FileProvider
    public File[] listFiles(File file, FilenameFilter filenameFilter) {
        return file.listFiles(filenameFilter);
    }
}
