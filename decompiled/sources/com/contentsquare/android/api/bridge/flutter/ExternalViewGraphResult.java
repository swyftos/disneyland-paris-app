package com.contentsquare.android.api.bridge.flutter;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/contentsquare/android/api/bridge/flutter/ExternalViewGraphResult;", "", "onSnapshotTaken", "", "view", "Landroid/view/View;", "jsonScreenGraph", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExternalViewGraphResult {
    void onSnapshotTaken(@NotNull View view, @NotNull String jsonScreenGraph);
}
