package androidx.biometric;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;

/* loaded from: classes.dex */
abstract class DeviceUtils {
    static boolean shouldHideFingerprintDialog(Context context, String str) {
        return false;
    }

    static boolean shouldUseFingerprintForCrypto(Context context, String str, String str2) {
        return false;
    }

    static boolean shouldDelayShowingPrompt(Context context, String str) {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return isModelInList(context, str, R.array.delay_showing_prompt_models);
    }

    static boolean canAssumeStrongBiometrics(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        return isModelInList(context, str, R.array.assume_strong_biometrics_models);
    }

    private static boolean isModelInList(Context context, String str, int i) throws Resources.NotFoundException {
        if (str == null) {
            return false;
        }
        for (String str2 : context.getResources().getStringArray(i)) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
