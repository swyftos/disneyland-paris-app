package com.contentsquare.android.internal.features.bridge.heap;

import com.contentsquare.android.core.communication.HeapInterface;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/internal/features/bridge/heap/HeapExternalInterface;", "", "extendOrCreateSession", "Lcom/contentsquare/android/core/communication/HeapInterface$HeapMetadata;", "onContentsquareScreenView", "", "title", "", "timestamp", "", "customVariables", "", "isHeapPageView", "", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HeapExternalInterface {
    @Nullable
    HeapInterface.HeapMetadata extendOrCreateSession();

    void onContentsquareScreenView(@NotNull String title, long timestamp, @NotNull Map<String, String> customVariables, boolean isHeapPageView);
}
