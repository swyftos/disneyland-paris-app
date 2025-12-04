package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;

/* loaded from: classes2.dex */
abstract class ViewGroupUtils {
    static void suppressLayout(ViewGroup viewGroup, boolean z) {
        Api29Impl.suppressLayout(viewGroup, z);
    }

    static int getChildDrawingOrder(ViewGroup viewGroup, int i) {
        return Api29Impl.getChildDrawingOrder(viewGroup, i);
    }

    static class Api29Impl {
        @DoNotInline
        static void suppressLayout(ViewGroup viewGroup, boolean z) {
            viewGroup.suppressLayout(z);
        }

        @DoNotInline
        static int getChildDrawingOrder(ViewGroup viewGroup, int i) {
            return viewGroup.getChildDrawingOrder(i);
        }
    }
}
