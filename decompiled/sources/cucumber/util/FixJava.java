package cucumber.util;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class FixJava {
    public static String join(List<? extends Object> list, String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            if (i != 0) {
                sb.append(str);
            }
            sb.append(obj);
            i++;
        }
        return sb.toString();
    }

    public static <T, R> List<R> map(List<T> list, Mapper<T, R> mapper) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(mapper.map(it.next()));
        }
        return arrayList;
    }

    public static String readReader(Reader reader) throws IOException, RuntimeException {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[65536];
            while (true) {
                int i = reader.read(cArr, 0, 65536);
                if (i != -1) {
                    sb.append(cArr, 0, i);
                } else {
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
