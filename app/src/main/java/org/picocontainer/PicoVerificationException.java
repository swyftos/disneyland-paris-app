package org.picocontainer;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PicoVerificationException extends PicoException {
    private final List nestedExceptions;

    public PicoVerificationException(List<? extends Throwable> list) {
        ArrayList arrayList = new ArrayList();
        this.nestedExceptions = arrayList;
        arrayList.addAll(list);
    }

    public List<Throwable> getNestedExceptions() {
        return this.nestedExceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.nestedExceptions.toString();
    }
}
