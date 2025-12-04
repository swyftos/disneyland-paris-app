package ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.io.FilenameFilter;

/* loaded from: classes2.dex */
public interface FileProvider {
    boolean deleteFile(File file);

    boolean exists(File file);

    boolean isDirectory(File file);

    long length(File file);

    String[] list(File file, FilenameFilter filenameFilter);

    File[] listFiles(File file, FilenameFilter filenameFilter);
}
