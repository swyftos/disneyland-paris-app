package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.util.OutConfig;

/* loaded from: classes.dex */
final class AutoValue_DualOutConfig extends DualOutConfig {
    private final OutConfig primaryOutConfig;
    private final OutConfig secondaryOutConfig;

    AutoValue_DualOutConfig(OutConfig outConfig, OutConfig outConfig2) {
        if (outConfig == null) {
            throw new NullPointerException("Null primaryOutConfig");
        }
        this.primaryOutConfig = outConfig;
        if (outConfig2 == null) {
            throw new NullPointerException("Null secondaryOutConfig");
        }
        this.secondaryOutConfig = outConfig2;
    }

    @Override // androidx.camera.core.processing.concurrent.DualOutConfig
    public OutConfig getPrimaryOutConfig() {
        return this.primaryOutConfig;
    }

    @Override // androidx.camera.core.processing.concurrent.DualOutConfig
    public OutConfig getSecondaryOutConfig() {
        return this.secondaryOutConfig;
    }

    public String toString() {
        return "DualOutConfig{primaryOutConfig=" + this.primaryOutConfig + ", secondaryOutConfig=" + this.secondaryOutConfig + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DualOutConfig)) {
            return false;
        }
        DualOutConfig dualOutConfig = (DualOutConfig) obj;
        return this.primaryOutConfig.equals(dualOutConfig.getPrimaryOutConfig()) && this.secondaryOutConfig.equals(dualOutConfig.getSecondaryOutConfig());
    }

    public int hashCode() {
        return this.secondaryOutConfig.hashCode() ^ ((this.primaryOutConfig.hashCode() ^ 1000003) * 1000003);
    }
}
