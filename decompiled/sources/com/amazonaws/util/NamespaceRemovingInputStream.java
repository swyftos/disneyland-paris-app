package com.amazonaws.util;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
class NamespaceRemovingInputStream extends SdkFilterInputStream {
    private boolean hasRemovedNamespace;
    private final byte[] lookAheadData;

    public NamespaceRemovingInputStream(InputStream inputStream) {
        super(new BufferedInputStream(inputStream));
        this.lookAheadData = new byte[200];
        this.hasRemovedNamespace = false;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        abortIfNeeded();
        int i = ((FilterInputStream) this).in.read();
        if (i != 120 || this.hasRemovedNamespace) {
            return i;
        }
        this.lookAheadData[0] = (byte) i;
        ((FilterInputStream) this).in.mark(this.lookAheadData.length);
        InputStream inputStream = ((FilterInputStream) this).in;
        byte[] bArr = this.lookAheadData;
        int i2 = inputStream.read(bArr, 1, bArr.length - 1);
        ((FilterInputStream) this).in.reset();
        int iMatchXmlNamespaceAttribute = matchXmlNamespaceAttribute(new String(this.lookAheadData, 0, i2 + 1, StringUtils.UTF8));
        if (iMatchXmlNamespaceAttribute <= 0) {
            return i;
        }
        for (int i3 = 0; i3 < iMatchXmlNamespaceAttribute - 1; i3++) {
            ((FilterInputStream) this).in.read();
        }
        int i4 = ((FilterInputStream) this).in.read();
        this.hasRemovedNamespace = true;
        return i4;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = read();
            if (i4 == -1) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            bArr[i3 + i] = (byte) i4;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    private int matchXmlNamespaceAttribute(String str) {
        StringPrefixSlicer stringPrefixSlicer = new StringPrefixSlicer(str);
        if (!stringPrefixSlicer.removePrefix("xmlns")) {
            return -1;
        }
        stringPrefixSlicer.removeRepeatingPrefix(" ");
        if (!stringPrefixSlicer.removePrefix("=")) {
            return -1;
        }
        stringPrefixSlicer.removeRepeatingPrefix(" ");
        if (stringPrefixSlicer.removePrefix("\"") && stringPrefixSlicer.removePrefixEndingWith("\"")) {
            return str.length() - stringPrefixSlicer.getString().length();
        }
        return -1;
    }

    private static final class StringPrefixSlicer {
        private String s;

        public StringPrefixSlicer(String str) {
            this.s = str;
        }

        public String getString() {
            return this.s;
        }

        public boolean removePrefix(String str) {
            if (!this.s.startsWith(str)) {
                return false;
            }
            this.s = this.s.substring(str.length());
            return true;
        }

        public boolean removeRepeatingPrefix(String str) {
            if (!this.s.startsWith(str)) {
                return false;
            }
            while (this.s.startsWith(str)) {
                this.s = this.s.substring(str.length());
            }
            return true;
        }

        public boolean removePrefixEndingWith(String str) {
            int iIndexOf = this.s.indexOf(str);
            if (iIndexOf < 0) {
                return false;
            }
            this.s = this.s.substring(iIndexOf + str.length());
            return true;
        }
    }
}
