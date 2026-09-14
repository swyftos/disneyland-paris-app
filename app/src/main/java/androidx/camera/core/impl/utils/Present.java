package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
final class Present extends Optional {
    private static final long serialVersionUID = 0;
    private final Object mReference;

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean isPresent() {
        return true;
    }

    Present(Object obj) {
        this.mReference = obj;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public Object get() {
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    /* JADX INFO: renamed from: or */
    public Object mo53or(Object obj) {
        Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    /* JADX INFO: renamed from: or */
    public Optional mo51or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    /* JADX INFO: renamed from: or */
    public Object mo52or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public Object orNull() {
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean equals(Object obj) {
        if (obj instanceof Present) {
            return this.mReference.equals(((Present) obj).mReference);
        }
        return false;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public String toString() {
        return "Optional.of(" + this.mReference + ")";
    }
}
