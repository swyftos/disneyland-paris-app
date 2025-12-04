package javax.xml.bind.annotation.adapters;

/* loaded from: classes5.dex */
public final class NormalizedStringAdapter extends XmlAdapter<String, String> {
    protected static boolean isWhiteSpaceExceptSpace(char c) {
        if (c >= ' ') {
            return false;
        }
        return c == '\t' || c == '\n' || c == '\r';
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
        int length = str.length() - 1;
        while (length >= 0 && !isWhiteSpaceExceptSpace(str.charAt(length))) {
            length--;
        }
        if (length < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[length] = ' ';
        for (int i = length - 1; i >= 0; i--) {
            if (isWhiteSpaceExceptSpace(charArray[i])) {
                charArray[i] = ' ';
            }
        }
        return new String(charArray);
    }
}
