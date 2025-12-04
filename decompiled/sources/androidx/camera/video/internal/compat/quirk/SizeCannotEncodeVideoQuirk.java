package androidx.camera.video.internal.compat.quirk;

import android.graphics.Rect;
import android.os.Build;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SizeCannotEncodeVideoQuirk implements Quirk {
    static boolean load() {
        return isMotoC();
    }

    private static boolean isMotoC() {
        return "motorola".equalsIgnoreCase(Build.BRAND) && "moto c".equalsIgnoreCase(Build.MODEL);
    }

    private static Set getProblematicSizes() {
        if (isMotoC()) {
            return new HashSet(Collections.singletonList(new Size(720, 1280)));
        }
        return Collections.emptySet();
    }

    public boolean isProblematicEncodeSize(@NonNull Size size) {
        return getProblematicSizes().contains(size);
    }

    @NonNull
    public Rect adjustCropRectForProblematicEncodeSize(@NonNull Rect rect, int i, @Nullable VideoEncoderInfo videoEncoderInfo) {
        Size sizeRotateSize = TransformUtils.rotateSize(TransformUtils.rectToSize(rect), i);
        if (!isProblematicEncodeSize(sizeRotateSize)) {
            return rect;
        }
        int heightAlignment = videoEncoderInfo != null ? videoEncoderInfo.getHeightAlignment() / 2 : 8;
        Rect rect2 = new Rect(rect);
        if (rect.width() == sizeRotateSize.getHeight()) {
            rect2.left += heightAlignment;
            rect2.right -= heightAlignment;
        } else {
            rect2.top += heightAlignment;
            rect2.bottom -= heightAlignment;
        }
        return rect2;
    }
}
