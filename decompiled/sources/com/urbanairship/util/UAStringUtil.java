package com.urbanairship.util;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.urbanairship.UALog;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public abstract class UAStringUtil {
    @NonNull
    public static String repeat(@NonNull String str, int i, @NonNull String str2) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < i) {
            sb.append(str);
            i2++;
            if (i2 != i) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static boolean isEmpty(@Nullable String str) {
        return str == null || str.length() == 0;
    }

    public static boolean equals(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    @NonNull
    public static String join(@NonNull Collection<String> collection, @NonNull String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    @Nullable
    public static String sha256(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return byteToHex(MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            UALog.e(e, "Failed to encode string: %s", str);
            return null;
        }
    }

    @Nullable
    public static byte[] sha256Digest(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            return MessageDigest.getInstance("SHA-256").digest(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            UALog.e(e, "Failed to encode string: %s", str);
            return null;
        }
    }

    @NonNull
    public static String byteToHex(@NonNull byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    @Nullable
    public static byte[] base64Decode(@Nullable String str) {
        if (isEmpty(str)) {
            return null;
        }
        try {
            return Base64.decode(str, 0);
        } catch (IllegalArgumentException unused) {
            UALog.v("Failed to decode string: %s", str);
            return null;
        }
    }

    @Nullable
    public static String base64DecodedString(@Nullable String str) {
        byte[] bArrBase64Decode = base64Decode(str);
        if (bArrBase64Decode == null) {
            return null;
        }
        try {
            return new String(bArrBase64Decode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            UALog.e(e, "Failed to create string", new Object[0]);
            return null;
        }
    }

    @Nullable
    public static String nullIfEmpty(@Nullable String str) {
        if (isEmpty(str)) {
            return null;
        }
        return str;
    }

    @NonNull
    public static String namedStringResource(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        int identifier = context.getResources().getIdentifier(str, "string", context.getApplicationInfo().packageName);
        return identifier == 0 ? str2 : context.getString(identifier);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static String generateSignedToken(@NonNull String str, @NonNull List<String> list) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(str.getBytes("UTF-8"), "HmacSHA256"));
        return Base64.encodeToString(mac.doFinal(String.join(":", list).getBytes("UTF-8")), 0);
    }
}
