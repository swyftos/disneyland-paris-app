package androidx.camera.extensions.internal;

import android.util.Pair;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ExtensionsUseCaseConfigFactory implements UseCaseConfigFactory {
    private final ImageAnalysisConfigProvider mImageAnalysisConfigProvider;
    private final ImageCaptureConfigProvider mImageCaptureConfigProvider;
    private final PreviewConfigProvider mPreviewConfigProvider;

    public ExtensionsUseCaseConfigFactory(@NonNull VendorExtender vendorExtender) {
        this.mImageCaptureConfigProvider = new ImageCaptureConfigProvider(vendorExtender);
        this.mPreviewConfigProvider = new PreviewConfigProvider(vendorExtender);
        this.mImageAnalysisConfigProvider = new ImageAnalysisConfigProvider(vendorExtender);
    }

    private boolean isImageAnalysisSupported(List list) {
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            int iIntValue = ((Integer) pair.first).intValue();
            Size[] sizeArr = (Size[]) pair.second;
            if (iIntValue == 35 && sizeArr != null && sizeArr.length > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: androidx.camera.extensions.internal.ExtensionsUseCaseConfigFactory$1 */
    static /* synthetic */ class C02891 {

        /* JADX INFO: renamed from: $SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType */
        static final /* synthetic */ int[] f23x65b8d150;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            f23x65b8d150 = iArr;
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23x65b8d150[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23x65b8d150[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23x65b8d150[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    @Nullable
    public Config getConfig(@NonNull UseCaseConfigFactory.CaptureType captureType, int i) {
        MutableOptionsBundle mutableOptionsBundleFrom;
        int i2 = C02891.f23x65b8d150[captureType.ordinal()];
        if (i2 == 1) {
            mutableOptionsBundleFrom = MutableOptionsBundle.from((Config) this.mImageCaptureConfigProvider.getConfig());
        } else if (i2 == 2) {
            mutableOptionsBundleFrom = MutableOptionsBundle.from((Config) this.mPreviewConfigProvider.getConfig());
        } else {
            if (i2 != 3) {
                if (i2 != 4) {
                    return null;
                }
                throw new IllegalArgumentException("Should not go here. VideoCapture is supported by recording the preview stream when Extension is enabled.");
            }
            ImageAnalysisConfig config = this.mImageAnalysisConfigProvider.getConfig();
            if (!isImageAnalysisSupported(config.getSupportedResolutions(null))) {
                throw new IllegalArgumentException("ImageAnalysis is not supported when Extension is enabled on this device. Check ExtensionsManager.isImageAnalysisSupported before binding the ImageAnalysis use case.");
            }
            mutableOptionsBundleFrom = MutableOptionsBundle.from((Config) config);
        }
        mutableOptionsBundleFrom.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.TRUE);
        return OptionsBundle.from(mutableOptionsBundleFrom);
    }
}
