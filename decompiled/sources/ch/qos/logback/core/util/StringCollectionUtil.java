package ch.qos.logback.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class StringCollectionUtil {
    public static void removeMatching(Collection<String> collection, Collection<String> collection2) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection2.iterator();
        while (it.hasNext()) {
            Pattern patternCompile = Pattern.compile(it.next());
            for (String str : collection) {
                if (patternCompile.matcher(str).matches()) {
                    arrayList.add(str);
                }
            }
        }
        collection.removeAll(arrayList);
    }

    public static void removeMatching(Collection<String> collection, String... strArr) {
        removeMatching(collection, Arrays.asList(strArr));
    }

    public static void retainMatching(Collection<String> collection, Collection<String> collection2) {
        if (collection2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<String> it = collection2.iterator();
        while (it.hasNext()) {
            Pattern patternCompile = Pattern.compile(it.next());
            for (String str : collection) {
                if (patternCompile.matcher(str).matches()) {
                    arrayList.add(str);
                }
            }
        }
        collection.retainAll(arrayList);
    }

    public static void retainMatching(Collection<String> collection, String... strArr) {
        retainMatching(collection, Arrays.asList(strArr));
    }
}
