package ch.qos.logback.core.pattern;

/* loaded from: classes2.dex */
public class SpacePadder {
    static final String[] SPACES = {" ", "  ", "    ", "        ", "                ", "                                "};

    public static final void leftPad(StringBuilder sb, String str, int i) {
        int length = str != null ? str.length() : 0;
        if (length < i) {
            spacePad(sb, i - length);
        }
        if (str != null) {
            sb.append(str);
        }
    }

    public static final void rightPad(StringBuilder sb, String str, int i) {
        int length = str != null ? str.length() : 0;
        if (str != null) {
            sb.append(str);
        }
        if (length < i) {
            spacePad(sb, i - length);
        }
    }

    public static final void spacePad(StringBuilder sb, int i) {
        while (i >= 32) {
            sb.append(SPACES[5]);
            i -= 32;
        }
        for (int i2 = 4; i2 >= 0; i2--) {
            if (((1 << i2) & i) != 0) {
                sb.append(SPACES[i2]);
            }
        }
    }
}
