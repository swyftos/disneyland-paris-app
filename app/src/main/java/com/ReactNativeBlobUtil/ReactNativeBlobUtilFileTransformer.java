package com.ReactNativeBlobUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ReactNativeBlobUtilFileTransformer {
    public static FileTransformer sharedFileTransformer;

    public interface FileTransformer {
        byte[] onReadFile(byte[] bArr);

        byte[] onWriteFile(byte[] bArr);
    }
}
