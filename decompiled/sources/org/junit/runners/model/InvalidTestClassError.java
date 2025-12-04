package org.junit.runners.model;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class InvalidTestClassError extends InitializationError {
    private static final long serialVersionUID = 1;
    private final String message;

    public InvalidTestClassError(Class<?> cls, List<Throwable> list) {
        super(list);
        this.message = createMessage(cls, list);
    }

    private static String createMessage(Class cls, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Invalid test class '%s':", cls.getName()));
        Iterator it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            sb.append("\n  " + i + ". " + ((Throwable) it.next()).getMessage());
            i++;
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
