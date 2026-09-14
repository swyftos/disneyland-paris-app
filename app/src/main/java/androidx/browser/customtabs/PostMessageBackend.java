package androidx.browser.customtabs;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface PostMessageBackend {
    void onDisconnectChannel(@NonNull Context context);

    boolean onNotifyMessageChannelReady(@Nullable Bundle bundle);

    boolean onPostMessage(@NonNull String str, @Nullable Bundle bundle);
}
