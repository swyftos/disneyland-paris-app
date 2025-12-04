package androidx.camera.video;

import androidx.camera.video.Quality;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_Quality_ConstantQuality extends Quality.ConstantQuality {
    private final String name;
    private final List typicalSizes;
    private final int value;

    AutoValue_Quality_ConstantQuality(int i, String str, List list) {
        this.value = i;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (list == null) {
            throw new NullPointerException("Null typicalSizes");
        }
        this.typicalSizes = list;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public int getValue() {
        return this.value;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public String getName() {
        return this.name;
    }

    @Override // androidx.camera.video.Quality.ConstantQuality
    public List getTypicalSizes() {
        return this.typicalSizes;
    }

    public String toString() {
        return "ConstantQuality{value=" + this.value + ", name=" + this.name + ", typicalSizes=" + this.typicalSizes + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Quality.ConstantQuality)) {
            return false;
        }
        Quality.ConstantQuality constantQuality = (Quality.ConstantQuality) obj;
        return this.value == constantQuality.getValue() && this.name.equals(constantQuality.getName()) && this.typicalSizes.equals(constantQuality.getTypicalSizes());
    }

    public int hashCode() {
        return this.typicalSizes.hashCode() ^ ((((this.value ^ 1000003) * 1000003) ^ this.name.hashCode()) * 1000003);
    }
}
