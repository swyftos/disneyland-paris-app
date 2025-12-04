package javax.xml.bind.helpers;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/* loaded from: classes5.dex */
abstract class Messages {
    static String format(String str) {
        return format(str, (Object[]) null);
    }

    static String format(String str, Object obj) {
        return format(str, new Object[]{obj});
    }

    static String format(String str, Object obj, Object obj2, Object obj3) {
        return format(str, new Object[]{obj, obj2, obj3});
    }

    static String format(String str, Object[] objArr) {
        return MessageFormat.format(ResourceBundle.getBundle(Messages.class.getName()).getString(str), objArr);
    }
}
