package com.disney.id.android;

import com.disney.id.android.tracker.TrackerEventKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003H&J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/disney/id/android/SCALPBundle;", "", "initializeBundle", "", "conversationEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "configData", "Lcom/disney/id/android/ConfigData;", "(Lcom/disney/id/android/tracker/TrackerEventKey;Lcom/disney/id/android/ConfigData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBundleIntoWebview", "new", "previousLightboxReadyState", "loadSCALP", "(Lcom/disney/id/android/tracker/TrackerEventKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SCALPBundle {
    @Nullable
    Object initializeBundle(@NotNull TrackerEventKey trackerEventKey, @NotNull ConfigData configData, @NotNull Continuation<? super Boolean> continuation);

    boolean loadBundleIntoWebview(@NotNull TrackerEventKey conversationEventKey, boolean z, boolean previousLightboxReadyState);

    @Nullable
    Object loadSCALP(@NotNull TrackerEventKey trackerEventKey, @NotNull Continuation<? super ConfigData> continuation);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean loadBundleIntoWebview$default(SCALPBundle sCALPBundle, TrackerEventKey trackerEventKey, boolean z, boolean z2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadBundleIntoWebview");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            return sCALPBundle.loadBundleIntoWebview(trackerEventKey, z, z2);
        }
    }
}
