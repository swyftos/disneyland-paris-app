package org.apache.commons.codec.digest;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.Charsets;

/* loaded from: classes6.dex */
public class Md5Crypt {
    public static String apr1Crypt(byte[] bArr) {
        return apr1Crypt(bArr, "$apr1$" + B64.getRandomSalt(8));
    }

    public static String apr1Crypt(byte[] bArr, Random random) {
        return apr1Crypt(bArr, "$apr1$" + B64.getRandomSalt(8, random));
    }

    public static String apr1Crypt(byte[] bArr, String str) {
        if (str != null && !str.startsWith("$apr1$")) {
            str = "$apr1$" + str;
        }
        return md5Crypt(bArr, str, "$apr1$");
    }

    public static String apr1Crypt(String str) {
        return apr1Crypt(str.getBytes(Charsets.UTF_8));
    }

    public static String apr1Crypt(String str, String str2) {
        return apr1Crypt(str.getBytes(Charsets.UTF_8), str2);
    }

    public static String md5Crypt(byte[] bArr) {
        return md5Crypt(bArr, "$1$" + B64.getRandomSalt(8));
    }

    public static String md5Crypt(byte[] bArr, Random random) {
        return md5Crypt(bArr, "$1$" + B64.getRandomSalt(8, random));
    }

    public static String md5Crypt(byte[] bArr, String str) {
        return md5Crypt(bArr, str, "$1$");
    }

    public static String md5Crypt(byte[] bArr, String str, String str2) {
        return md5Crypt(bArr, str, str2, new SecureRandom());
    }

    public static String md5Crypt(byte[] bArr, String str, String str2, Random random) {
        String strGroup;
        int length = bArr.length;
        if (str == null) {
            strGroup = B64.getRandomSalt(8, random);
        } else {
            Matcher matcher = Pattern.compile("^" + str2.replace("$", "\\$") + "([\\.\\/a-zA-Z0-9]{1,8}).*").matcher(str);
            if (!matcher.find()) {
                throw new IllegalArgumentException("Invalid salt value: " + str);
            }
            strGroup = matcher.group(1);
        }
        Charset charset = Charsets.UTF_8;
        byte[] bytes = strGroup.getBytes(charset);
        MessageDigest md5Digest = DigestUtils.getMd5Digest();
        md5Digest.update(bArr);
        md5Digest.update(str2.getBytes(charset));
        md5Digest.update(bytes);
        MessageDigest md5Digest2 = DigestUtils.getMd5Digest();
        md5Digest2.update(bArr);
        md5Digest2.update(bytes);
        md5Digest2.update(bArr);
        byte[] bArrDigest = md5Digest2.digest();
        int i = length;
        while (true) {
            int i2 = 16;
            if (i <= 0) {
                break;
            }
            if (i <= 16) {
                i2 = i;
            }
            md5Digest.update(bArrDigest, 0, i2);
            i -= 16;
        }
        Arrays.fill(bArrDigest, (byte) 0);
        while (length > 0) {
            if ((length & 1) == 1) {
                md5Digest.update(bArrDigest[0]);
            } else {
                md5Digest.update(bArr[0]);
            }
            length >>= 1;
        }
        StringBuilder sb = new StringBuilder(str2 + strGroup + "$");
        byte[] bArrDigest2 = md5Digest.digest();
        for (int i3 = 0; i3 < 1000; i3++) {
            md5Digest2 = DigestUtils.getMd5Digest();
            int i4 = i3 & 1;
            if (i4 != 0) {
                md5Digest2.update(bArr);
            } else {
                md5Digest2.update(bArrDigest2, 0, 16);
            }
            if (i3 % 3 != 0) {
                md5Digest2.update(bytes);
            }
            if (i3 % 7 != 0) {
                md5Digest2.update(bArr);
            }
            if (i4 != 0) {
                md5Digest2.update(bArrDigest2, 0, 16);
            } else {
                md5Digest2.update(bArr);
            }
            bArrDigest2 = md5Digest2.digest();
        }
        B64.b64from24bit(bArrDigest2[0], bArrDigest2[6], bArrDigest2[12], 4, sb);
        B64.b64from24bit(bArrDigest2[1], bArrDigest2[7], bArrDigest2[13], 4, sb);
        B64.b64from24bit(bArrDigest2[2], bArrDigest2[8], bArrDigest2[14], 4, sb);
        B64.b64from24bit(bArrDigest2[3], bArrDigest2[9], bArrDigest2[15], 4, sb);
        B64.b64from24bit(bArrDigest2[4], bArrDigest2[10], bArrDigest2[5], 4, sb);
        B64.b64from24bit((byte) 0, (byte) 0, bArrDigest2[11], 2, sb);
        md5Digest.reset();
        md5Digest2.reset();
        Arrays.fill(bArr, (byte) 0);
        Arrays.fill(bytes, (byte) 0);
        Arrays.fill(bArrDigest2, (byte) 0);
        return sb.toString();
    }
}
