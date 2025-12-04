package androidx.camera.core.resolutionselector;

import android.util.Size;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes.dex */
public interface ResolutionFilter {
    @NonNull
    List<Size> filter(@NonNull List<Size> list, int i);
}
