package androidx.test.runner.permission;

import androidx.annotation.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public abstract class ShellCommand {
    abstract void execute();

    static String shellEscape(String str) {
        int length = str.length();
        if (length == 0) {
            return "''";
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!Character.isLetterOrDigit(cCharAt) && "@%-_+:,./".indexOf(cCharAt) == -1) {
                String strReplace = str.replace("'", "'\\''");
                StringBuilder sb = new StringBuilder(String.valueOf(strReplace).length() + 2);
                sb.append("'");
                sb.append(strReplace);
                sb.append("'");
                return sb.toString();
            }
        }
        return str;
    }
}
