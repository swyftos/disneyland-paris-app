package org.apache.commons.lang3.builder;

/* JADX INFO: loaded from: classes6.dex */
final class IDKey {

    /* JADX INFO: renamed from: id */
    private final int f3988id;
    private final Object value;

    IDKey(Object obj) {
        this.f3988id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        return this.f3988id == iDKey.f3988id && this.value == iDKey.value;
    }

    public int hashCode() {
        return this.f3988id;
    }
}
