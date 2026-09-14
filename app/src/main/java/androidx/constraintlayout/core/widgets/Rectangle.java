package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x */
    public int f60x;

    /* JADX INFO: renamed from: y */
    public int f61y;

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f60x = i;
        this.f61y = i2;
        this.width = i3;
        this.height = i4;
    }

    public boolean contains(int i, int i2) {
        int i3;
        int i4 = this.f60x;
        return i >= i4 && i < i4 + this.width && i2 >= (i3 = this.f61y) && i2 < i3 + this.height;
    }

    public int getCenterX() {
        return (this.f60x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f61y + this.height) / 2;
    }
}
