package javax.xml.bind;

/* loaded from: classes5.dex */
abstract class WhiteSpaceProcessor {
    public static final boolean isWhiteSpace(char c) {
        if (c > ' ') {
            return false;
        }
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    public static CharSequence trim(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && isWhiteSpace(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        int i3 = i2;
        while (i3 > i && isWhiteSpace(charSequence.charAt(i3))) {
            i3--;
        }
        return (i == 0 && i3 == i2) ? charSequence : charSequence.subSequence(i, i3 + 1);
    }
}
