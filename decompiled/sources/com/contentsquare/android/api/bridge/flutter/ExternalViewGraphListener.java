package com.contentsquare.android.api.bridge.flutter;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/contentsquare/android/api/bridge/flutter/ExternalViewGraphListener;", "", "takeSnapShot", "", "view", "Landroid/view/View;", "path", "", "result", "Lcom/contentsquare/android/api/bridge/flutter/ExternalViewGraphResult;", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExternalViewGraphListener {
    void takeSnapShot(@NotNull View view, @NotNull String path, @NotNull ExternalViewGraphResult result);
}
