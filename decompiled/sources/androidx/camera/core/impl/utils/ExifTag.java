package androidx.camera.core.impl.utils;

/* loaded from: classes.dex */
class ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    ExifTag(String str, int i, int i2) {
        this.name = str;
        this.number = i;
        this.primaryFormat = i2;
        this.secondaryFormat = -1;
    }

    ExifTag(String str, int i, int i2, int i3) {
        this.name = str;
        this.number = i;
        this.primaryFormat = i2;
        this.secondaryFormat = i3;
    }
}
