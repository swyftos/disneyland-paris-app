package com.ReactNativeBlobUtil.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class FileDescription {
    public String mimeType;
    public String name;
    public String partentFolder;

    public FileDescription(String str, String str2, String str3) {
        this.name = str;
        this.partentFolder = str3 == null ? "" : str3;
        this.mimeType = str2;
    }

    public String getFullPath() {
        return this.partentFolder + "/" + MimeType.getFullFileName(this.name, this.mimeType);
    }
}
