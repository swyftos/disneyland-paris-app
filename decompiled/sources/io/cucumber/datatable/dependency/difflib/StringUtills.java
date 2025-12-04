package io.cucumber.datatable.dependency.difflib;

import ch.qos.logback.classic.net.SyslogAppender;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes5.dex */
public class StringUtills {
    public static <T> String join(Iterable<T> iterable, String str) {
        Iterator<T> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(it.next()));
        while (it.hasNext()) {
            stringBuffer.append(str);
            stringBuffer.append(String.valueOf(it.next()));
        }
        return stringBuffer.toString();
    }

    public static String expandTabs(String str) {
        return str.replace(SyslogAppender.DEFAULT_STACKTRACE_PATTERN, "    ");
    }

    public static String htmlEntites(String str) {
        return str.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static String normalize(String str) {
        return expandTabs(htmlEntites(str));
    }

    public static List<String> normalize(List<String> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(normalize(it.next()));
        }
        return linkedList;
    }

    public static List<String> wrapText(List<String> list, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(wrapText(it.next(), i));
        }
        return linkedList;
    }

    public static String wrapText(String str, int i) {
        int length = str.length();
        int i2 = i;
        int i3 = 0;
        while (length > i2) {
            StringBuilder sb = new StringBuilder();
            int i4 = (4 * i3) + i2;
            sb.append((Object) str.subSequence(0, i4));
            sb.append("<br>");
            sb.append(str.substring(i4));
            str = sb.toString();
            i2 += i;
            i3++;
        }
        return str;
    }
}
