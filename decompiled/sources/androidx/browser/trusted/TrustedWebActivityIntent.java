package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class TrustedWebActivityIntent {
    private final Intent mIntent;
    private final List mSharedFileUris;

    TrustedWebActivityIntent(Intent intent, List list) {
        this.mIntent = intent;
        this.mSharedFileUris = list;
    }

    public void launchTrustedWebActivity(@NonNull Context context) {
        grantUriPermissionToProvider(context);
        ContextCompat.startActivity(context, this.mIntent, null);
    }

    private void grantUriPermissionToProvider(Context context) {
        Iterator it = this.mSharedFileUris.iterator();
        while (it.hasNext()) {
            context.grantUriPermission(this.mIntent.getPackage(), (Uri) it.next(), 1);
        }
    }

    @NonNull
    public Intent getIntent() {
        return this.mIntent;
    }
}
