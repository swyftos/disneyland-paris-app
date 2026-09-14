package coil3.content;

import android.view.View;
import coil3.request.ImageResult;
import coil3.request.ViewTargetRequestManagerKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\n"}, m1836d2 = {"Lcoil3/util/CoilUtils;", "", "<init>", "()V", "dispose", "", "view", "Landroid/view/View;", "result", "Lcoil3/request/ImageResult;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class CoilUtils {

    @NotNull
    public static final CoilUtils INSTANCE = new CoilUtils();

    private CoilUtils() {
    }

    @JvmStatic
    public static final void dispose(@NotNull View view) {
        ViewTargetRequestManagerKt.getRequestManager(view).dispose();
    }

    @JvmStatic
    @Nullable
    public static final ImageResult result(@NotNull View view) {
        return ViewTargetRequestManagerKt.getRequestManager(view).getResult();
    }
}
