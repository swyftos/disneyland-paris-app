package androidx.camera.core.internal.compat.quirk;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.StreamSpec;

/* loaded from: classes.dex */
public interface AeFpsRangeQuirk extends Quirk {
    @NonNull
    default Range<Integer> getTargetAeFpsRange() {
        return StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }
}
