package org.bouncycastle.asn1.eac;

/* loaded from: classes6.dex */
public class Flags {
    int value;

    public Flags() {
        this.value = 0;
    }

    public Flags(int i) {
        this.value = i;
    }

    public int getFlags() {
        return this.value;
    }

    public boolean isSet(int i) {
        return (this.value & i) != 0;
    }

    public void set(int i) {
        this.value = i | this.value;
    }
}
