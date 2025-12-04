package ch.qos.logback.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class FileSize {
    private static final Pattern FILE_SIZE_PATTERN = Pattern.compile("([0-9]+)\\s*(|kb|mb|gb)s?", 2);
    public static final long GB_COEFFICIENT = 1073741824;
    public static final long KB_COEFFICIENT = 1024;
    public static final long MB_COEFFICIENT = 1048576;
    final long size;

    public FileSize(long j) {
        this.size = j;
    }

    public static FileSize valueOf(String str) {
        long j;
        Matcher matcher = FILE_SIZE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("String value [" + str + "] is not in the expected format.");
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        long jLongValue = Long.valueOf(strGroup).longValue();
        if (strGroup2.equalsIgnoreCase("")) {
            j = 1;
        } else if (strGroup2.equalsIgnoreCase("kb")) {
            j = 1024;
        } else if (strGroup2.equalsIgnoreCase("mb")) {
            j = 1048576;
        } else {
            if (!strGroup2.equalsIgnoreCase("gb")) {
                throw new IllegalStateException("Unexpected " + strGroup2);
            }
            j = 1073741824;
        }
        return new FileSize(jLongValue * j);
    }

    public long getSize() {
        return this.size;
    }

    public String toString() {
        long j = this.size;
        long j2 = j / 1024;
        if (j2 == 0) {
            return this.size + " Bytes";
        }
        long j3 = j / 1048576;
        if (j3 == 0) {
            return j2 + " KB";
        }
        long j4 = j / 1073741824;
        if (j4 == 0) {
            return j3 + " MB";
        }
        return j4 + " GB";
    }
}
