package com.amazonaws.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class StringInputStream extends ByteArrayInputStream {
    private final String string;

    public StringInputStream(String str) throws UnsupportedEncodingException {
        super(str.getBytes(StringUtils.UTF8));
        this.string = str;
    }

    public String getString() {
        return this.string;
    }
}
