package ch.qos.logback.core.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HardenedObjectInputStream extends ObjectInputStream {
    static final String[] JAVA_PACKAGES = {"java.lang", "java.util"};
    final List whitelistedClassNames;

    public HardenedObjectInputStream(InputStream inputStream, List<String> list) throws IOException {
        super(inputStream);
        ArrayList arrayList = new ArrayList();
        this.whitelistedClassNames = arrayList;
        arrayList.addAll(list);
    }

    public HardenedObjectInputStream(InputStream inputStream, String[] strArr) throws IOException {
        super(inputStream);
        this.whitelistedClassNames = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                this.whitelistedClassNames.add(str);
            }
        }
    }

    private boolean isWhitelisted(String str) {
        int i = 0;
        while (true) {
            String[] strArr = JAVA_PACKAGES;
            if (i >= strArr.length) {
                Iterator it = this.whitelistedClassNames.iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return true;
                    }
                }
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    protected void addToWhitelist(List<String> list) {
        this.whitelistedClassNames.addAll(list);
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        if (isWhitelisted(objectStreamClass.getName())) {
            return super.resolveClass(objectStreamClass);
        }
        throw new InvalidClassException("Unauthorized deserialization attempt", objectStreamClass.getName());
    }
}
