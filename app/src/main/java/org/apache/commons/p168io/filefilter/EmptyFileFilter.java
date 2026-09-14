package org.apache.commons.p168io.filefilter;

import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class EmptyFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter EMPTY;
    public static final IOFileFilter NOT_EMPTY;
    private static final long serialVersionUID = 3631422087512832211L;

    static {
        EmptyFileFilter emptyFileFilter = new EmptyFileFilter();
        EMPTY = emptyFileFilter;
        NOT_EMPTY = new NotFileFilter(emptyFileFilter);
    }

    protected EmptyFileFilter() {
    }

    @Override // org.apache.commons.p168io.filefilter.AbstractFileFilter, org.apache.commons.p168io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (!file.isDirectory()) {
            return file.length() == 0;
        }
        File[] fileArrListFiles = file.listFiles();
        return fileArrListFiles == null || fileArrListFiles.length == 0;
    }
}
