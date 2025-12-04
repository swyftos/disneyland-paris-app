package ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
abstract class PathPart {
    String part;

    PathPart(String str) {
        this.part = str;
    }

    abstract List listFiles(FileProvider fileProvider);

    List listFiles(FileProvider fileProvider, String str) {
        File[] fileArrListFiles = fileProvider.listFiles(new File(str).getAbsoluteFile(), null);
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        return Arrays.asList(fileArrListFiles);
    }

    abstract boolean matches(File file);
}
