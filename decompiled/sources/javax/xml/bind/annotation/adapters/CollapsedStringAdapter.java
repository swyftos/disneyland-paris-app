package javax.xml.bind.annotation.adapters;

/* loaded from: classes5.dex */
public class CollapsedStringAdapter extends XmlAdapter<String, String> {
    protected static boolean isWhiteSpace(char c) {
        if (c > ' ') {
            return false;
        }
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    @Override // javax.xml.bind.annotation.adapters.XmlAdapter
    public String marshal(String str) {
        return str;
    }

    @Override // javax.xml.bind.annotation.adapters.XmlAdapter
    public String unmarshal(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        int i = 0;
        while (i < length && !isWhiteSpace(str.charAt(i))) {
            i++;
        }
        if (i == length) {
            return str;
        }
        StringBuilder sb = new StringBuilder(length);
        if (i != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(str.charAt(i2));
            }
            sb.append(' ');
        }
        boolean z = true;
        for (int i3 = i + 1; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            boolean zIsWhiteSpace = isWhiteSpace(cCharAt);
            if (!z || !zIsWhiteSpace) {
                if (zIsWhiteSpace) {
                    sb.append(' ');
                } else {
                    sb.append(cCharAt);
                }
                z = zIsWhiteSpace;
            }
        }
        int length2 = sb.length();
        if (length2 > 0) {
            int i4 = length2 - 1;
            if (sb.charAt(i4) == ' ') {
                sb.setLength(i4);
            }
        }
        return sb.toString();
    }
}
