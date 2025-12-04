package org.picocontainer.references;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.picocontainer.ObjectReference;

/* loaded from: classes6.dex */
public class ThreadLocalReference<T> extends ThreadLocal<T> implements ObjectReference<T>, Serializable {
    private void readObject(ObjectInputStream objectInputStream) {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
    }
}
