package org.bouncycastle.util.encoders;

/* loaded from: classes6.dex */
public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        byte[] bArr = this.encodingTable;
        bArr[bArr.length - 2] = 45;
        bArr[bArr.length - 1] = 95;
        this.padding = (byte) 46;
        initialiseDecodingTable();
    }
}
