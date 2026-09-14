package org.apache.commons.lang3;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes6.dex */
abstract class Charsets {
    static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    static Charset toCharset(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    static String toCharsetName(String str) {
        return str == null ? Charset.defaultCharset().name() : str;
    }
}
