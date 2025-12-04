package org.apache.commons.codec.digest;

import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import java.util.Random;

/* loaded from: classes6.dex */
abstract class B64 {
    static void b64from24bit(byte b, byte b2, byte b3, int i, StringBuilder sb) {
        int i2 = ((b << Ascii.DLE) & ViewCompat.MEASURED_SIZE_MASK) | ((b2 << 8) & 65535) | (b3 & 255);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return;
            }
            sb.append("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(i2 & 63));
            i2 >>= 6;
            i = i3;
        }
    }

    static String getRandomSalt(int i) {
        return getRandomSalt(i, new SecureRandom());
    }

    static String getRandomSalt(int i, Random random) {
        StringBuilder sb = new StringBuilder(i);
        for (int i2 = 1; i2 <= i; i2++) {
            sb.append("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(64)));
        }
        return sb.toString();
    }
}
