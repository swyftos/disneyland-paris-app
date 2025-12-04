package androidx.camera.extensions.internal;

/* loaded from: classes.dex */
final class AutoValue_Version extends Version {
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    AutoValue_Version(int i, int i2, int i3, String str) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
        if (str == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str;
    }

    @Override // androidx.camera.extensions.internal.Version
    public int getMajor() {
        return this.major;
    }

    @Override // androidx.camera.extensions.internal.Version
    int getMinor() {
        return this.minor;
    }

    @Override // androidx.camera.extensions.internal.Version
    int getPatch() {
        return this.patch;
    }

    @Override // androidx.camera.extensions.internal.Version
    String getDescription() {
        return this.description;
    }
}
