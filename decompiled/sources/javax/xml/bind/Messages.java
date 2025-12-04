package javax.xml.bind;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/* loaded from: classes5.dex */
abstract class Messages {
    static String format(String str) {
        return format(str, null);
    }

    static String format(String str, Object obj, Object obj2) {
        return format(str, new Object[]{obj, obj2});
    }

    static String format(String str, Object[] objArr) {
        return MessageFormat.format(ResourceBundle.getBundle(Messages.class.getName()).getString(str), objArr);
    }
}
