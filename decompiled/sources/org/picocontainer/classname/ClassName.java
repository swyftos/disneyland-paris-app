package org.picocontainer.classname;

/* loaded from: classes6.dex */
public class ClassName implements CharSequence {
    private final String className;

    public ClassName(String str) {
        this.className = str;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.className.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.className.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.className.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.className.toString();
    }

    public int hashCode() {
        return this.className.hashCode();
    }

    public boolean equals(Object obj) {
        return this.className.equals(obj);
    }
}
