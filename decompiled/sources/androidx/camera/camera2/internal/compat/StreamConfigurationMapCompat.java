package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.workaround.OutputSizesCorrector;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class StreamConfigurationMapCompat {
    private final StreamConfigurationMapCompatImpl mImpl;
    private final OutputSizesCorrector mOutputSizesCorrector;
    private final Map mCachedFormatOutputSizes = new HashMap();
    private final Map mCachedFormatHighResolutionOutputSizes = new HashMap();
    private final Map mCachedClassOutputSizes = new HashMap();

    interface StreamConfigurationMapCompatImpl {
        Size[] getHighResolutionOutputSizes(int i);

        int[] getOutputFormats();

        Size[] getOutputSizes(int i);

        Size[] getOutputSizes(Class cls);

        StreamConfigurationMap unwrap();
    }

    private StreamConfigurationMapCompat(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        this.mImpl = new StreamConfigurationMapCompatApi23Impl(streamConfigurationMap);
        this.mOutputSizesCorrector = outputSizesCorrector;
    }

    static StreamConfigurationMapCompat toStreamConfigurationMapCompat(StreamConfigurationMap streamConfigurationMap, OutputSizesCorrector outputSizesCorrector) {
        return new StreamConfigurationMapCompat(streamConfigurationMap, outputSizesCorrector);
    }

    @Nullable
    public int[] getOutputFormats() {
        int[] outputFormats = this.mImpl.getOutputFormats();
        if (outputFormats == null) {
            return null;
        }
        return (int[]) outputFormats.clone();
    }

    @Nullable
    public Size[] getOutputSizes(int i) {
        if (this.mCachedFormatOutputSizes.containsKey(Integer.valueOf(i))) {
            if (((Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) this.mCachedFormatOutputSizes.get(Integer.valueOf(i))).clone();
        }
        Size[] outputSizes = this.mImpl.getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            Logger.w("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
            return outputSizes;
        }
        Size[] sizeArrApplyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, i);
        this.mCachedFormatOutputSizes.put(Integer.valueOf(i), sizeArrApplyQuirks);
        return (Size[]) sizeArrApplyQuirks.clone();
    }

    @Nullable
    public <T> Size[] getOutputSizes(@NonNull Class<T> cls) {
        if (this.mCachedClassOutputSizes.containsKey(cls)) {
            if (((Size[]) this.mCachedClassOutputSizes.get(cls)) == null) {
                return null;
            }
            return (Size[]) ((Size[]) this.mCachedClassOutputSizes.get(cls)).clone();
        }
        Size[] outputSizes = this.mImpl.getOutputSizes(cls);
        if (outputSizes == null || outputSizes.length == 0) {
            Logger.w("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for class " + cls);
            return outputSizes;
        }
        Size[] sizeArrApplyQuirks = this.mOutputSizesCorrector.applyQuirks(outputSizes, cls);
        this.mCachedClassOutputSizes.put(cls, sizeArrApplyQuirks);
        return (Size[]) sizeArrApplyQuirks.clone();
    }

    @Nullable
    public Size[] getHighResolutionOutputSizes(int i) {
        if (this.mCachedFormatHighResolutionOutputSizes.containsKey(Integer.valueOf(i))) {
            if (((Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) this.mCachedFormatHighResolutionOutputSizes.get(Integer.valueOf(i))).clone();
        }
        Size[] highResolutionOutputSizes = this.mImpl.getHighResolutionOutputSizes(i);
        if (highResolutionOutputSizes != null && highResolutionOutputSizes.length > 0) {
            highResolutionOutputSizes = this.mOutputSizesCorrector.applyQuirks(highResolutionOutputSizes, i);
        }
        this.mCachedFormatHighResolutionOutputSizes.put(Integer.valueOf(i), highResolutionOutputSizes);
        if (highResolutionOutputSizes != null) {
            return (Size[]) highResolutionOutputSizes.clone();
        }
        return null;
    }

    @NonNull
    public StreamConfigurationMap toStreamConfigurationMap() {
        return this.mImpl.unwrap();
    }
}
