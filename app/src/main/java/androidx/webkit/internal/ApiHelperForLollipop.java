package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class ApiHelperForLollipop {
    @DoNotInline
    public static boolean isForMainFrame(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.isForMainFrame();
    }

    @NonNull
    @DoNotInline
    public static Uri getUrl(@NonNull WebResourceRequest webResourceRequest) {
        return webResourceRequest.getUrl();
    }
}
