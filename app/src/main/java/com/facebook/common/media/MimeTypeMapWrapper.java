package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public class MimeTypeMapWrapper {
    private static final MimeTypeMap sMimeTypeMap = MimeTypeMap.getSingleton();
    private static final Map sMimeTypeToExtensionMap = ImmutableMap.m1264of("image/heif", "heif", "image/heic", "heic");
    private static final Map sExtensionToMimeTypeMap = ImmutableMap.m1264of("heif", "image/heif", "heic", "image/heic");

    @Nullable
    public static String getExtensionFromMimeType(String str) {
        String str2 = (String) sMimeTypeToExtensionMap.get(str);
        return str2 != null ? str2 : sMimeTypeMap.getExtensionFromMimeType(str);
    }

    @Nullable
    public static String getMimeTypeFromExtension(String str) {
        String str2 = (String) sExtensionToMimeTypeMap.get(str);
        return str2 != null ? str2 : sMimeTypeMap.getMimeTypeFromExtension(str);
    }

    public static boolean hasExtension(String str) {
        return sExtensionToMimeTypeMap.containsKey(str) || sMimeTypeMap.hasExtension(str);
    }

    public static boolean hasMimeType(String str) {
        return sMimeTypeToExtensionMap.containsKey(str) || sMimeTypeMap.hasMimeType(str);
    }
}
