package androidx.camera.core.impl;

import android.util.Size;
import java.util.Map;

/* loaded from: classes.dex */
final class AutoValue_SurfaceSizeDefinition extends SurfaceSizeDefinition {
    private final Size analysisSize;
    private final Map maximumSizeMap;
    private final Size previewSize;
    private final Size recordSize;
    private final Map s1440pSizeMap;
    private final Map s720pSizeMap;
    private final Map ultraMaximumSizeMap;

    AutoValue_SurfaceSizeDefinition(Size size, Map map, Size size2, Map map2, Size size3, Map map3, Map map4) {
        if (size == null) {
            throw new NullPointerException("Null analysisSize");
        }
        this.analysisSize = size;
        if (map == null) {
            throw new NullPointerException("Null s720pSizeMap");
        }
        this.s720pSizeMap = map;
        if (size2 == null) {
            throw new NullPointerException("Null previewSize");
        }
        this.previewSize = size2;
        if (map2 == null) {
            throw new NullPointerException("Null s1440pSizeMap");
        }
        this.s1440pSizeMap = map2;
        if (size3 == null) {
            throw new NullPointerException("Null recordSize");
        }
        this.recordSize = size3;
        if (map3 == null) {
            throw new NullPointerException("Null maximumSizeMap");
        }
        this.maximumSizeMap = map3;
        if (map4 == null) {
            throw new NullPointerException("Null ultraMaximumSizeMap");
        }
        this.ultraMaximumSizeMap = map4;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getAnalysisSize() {
        return this.analysisSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map getS720pSizeMap() {
        return this.s720pSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getPreviewSize() {
        return this.previewSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map getS1440pSizeMap() {
        return this.s1440pSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Size getRecordSize() {
        return this.recordSize;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map getMaximumSizeMap() {
        return this.maximumSizeMap;
    }

    @Override // androidx.camera.core.impl.SurfaceSizeDefinition
    public Map getUltraMaximumSizeMap() {
        return this.ultraMaximumSizeMap;
    }

    public String toString() {
        return "SurfaceSizeDefinition{analysisSize=" + this.analysisSize + ", s720pSizeMap=" + this.s720pSizeMap + ", previewSize=" + this.previewSize + ", s1440pSizeMap=" + this.s1440pSizeMap + ", recordSize=" + this.recordSize + ", maximumSizeMap=" + this.maximumSizeMap + ", ultraMaximumSizeMap=" + this.ultraMaximumSizeMap + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceSizeDefinition)) {
            return false;
        }
        SurfaceSizeDefinition surfaceSizeDefinition = (SurfaceSizeDefinition) obj;
        return this.analysisSize.equals(surfaceSizeDefinition.getAnalysisSize()) && this.s720pSizeMap.equals(surfaceSizeDefinition.getS720pSizeMap()) && this.previewSize.equals(surfaceSizeDefinition.getPreviewSize()) && this.s1440pSizeMap.equals(surfaceSizeDefinition.getS1440pSizeMap()) && this.recordSize.equals(surfaceSizeDefinition.getRecordSize()) && this.maximumSizeMap.equals(surfaceSizeDefinition.getMaximumSizeMap()) && this.ultraMaximumSizeMap.equals(surfaceSizeDefinition.getUltraMaximumSizeMap());
    }

    public int hashCode() {
        return this.ultraMaximumSizeMap.hashCode() ^ ((((((((((((this.analysisSize.hashCode() ^ 1000003) * 1000003) ^ this.s720pSizeMap.hashCode()) * 1000003) ^ this.previewSize.hashCode()) * 1000003) ^ this.s1440pSizeMap.hashCode()) * 1000003) ^ this.recordSize.hashCode()) * 1000003) ^ this.maximumSizeMap.hashCode()) * 1000003);
    }
}
