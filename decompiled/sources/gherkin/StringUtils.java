package gherkin;

import java.util.List;

/* loaded from: classes5.dex */
public class StringUtils {

    public interface ToString<T> {
        public static final ToString<String> DEFAULT = new ToString() { // from class: gherkin.StringUtils.ToString.1
            @Override // gherkin.StringUtils.ToString
            public String toString(String str) {
                return str;
            }
        };

        String toString(T t);
    }

    public static String join(String str, List<String> list) {
        return join(ToString.DEFAULT, str, list);
    }

    public static <T> String join(ToString<T> toString, String str, Iterable<T> iterable) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (T t : iterable) {
            if (z) {
                sb.append(str);
            }
            sb.append(toString.toString(t));
            z = true;
        }
        return sb.toString();
    }

    public static String ltrim(String str) {
        int i = 0;
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return str.substring(i);
    }
}
