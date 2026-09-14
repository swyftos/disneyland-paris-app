package com.ReactNativeBlobUtil.Utils;

import android.webkit.MimeTypeMap;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MimeType {
    static String BINARY_FILE = "application/octet-stream";
    static String UNKNOWN = "*/*";

    public static String getFullFileName(String str, String str2) {
        String extensionFromMimeType = getExtensionFromMimeType(str2);
        if (extensionFromMimeType == null || extensionFromMimeType.isEmpty()) {
            return str;
        }
        if (str.endsWith(InstructionFileId.DOT + extensionFromMimeType)) {
            return str;
        }
        String str3 = str + InstructionFileId.DOT + extensionFromMimeType;
        return str3.endsWith(InstructionFileId.DOT) ? StringUtils.stripEnd(str3, InstructionFileId.DOT) : str3;
    }

    public static String getExtensionFromMimeType(String str) {
        if (str != null) {
            return str.equals(BINARY_FILE) ? "bin" : MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        }
        return "";
    }

    public static String getExtensionFromMimeTypeOrFileName(String str, String str2) {
        if (str == null || str.equals(UNKNOWN)) {
            return StringUtils.substringAfterLast(str2, InstructionFileId.DOT);
        }
        return getExtensionFromMimeType(str);
    }

    public static String getMimeTypeFromExtension(String str) {
        if (str.equals("bin")) {
            return BINARY_FILE;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : UNKNOWN;
    }
}
