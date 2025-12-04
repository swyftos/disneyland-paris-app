package com.google.common.escape;

import java.util.Objects;

/* loaded from: classes4.dex */
abstract class Platform {
    private static final ThreadLocal DEST_TL = new ThreadLocal() { // from class: com.google.common.escape.Platform.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public char[] initialValue() {
            return new char[1024];
        }
    };

    static char[] charBufferFromThreadLocal() {
        char[] cArr = (char[]) DEST_TL.get();
        Objects.requireNonNull(cArr);
        return cArr;
    }
}
