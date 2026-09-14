package androidx.webkit.internal;

import androidx.annotation.NonNull;
import java.util.List;
import org.chromium.support_lib_boundary.WebViewCookieManagerBoundaryInterface;

/* JADX INFO: loaded from: classes2.dex */
public class CookieManagerAdapter {
    private final WebViewCookieManagerBoundaryInterface mBoundaryInterface;

    public CookieManagerAdapter(@NonNull WebViewCookieManagerBoundaryInterface webViewCookieManagerBoundaryInterface) {
        this.mBoundaryInterface = webViewCookieManagerBoundaryInterface;
    }

    @NonNull
    public List<String> getCookieInfo(@NonNull String str) {
        return this.mBoundaryInterface.getCookieInfo(str);
    }
}
