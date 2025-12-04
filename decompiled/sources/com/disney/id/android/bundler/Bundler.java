package com.disney.id.android.bundler;

import com.disney.id.android.tracker.TrackerEventKey;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u0013J \u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J.\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/disney/id/android/bundler/Bundler;", "", "getBundle", "", "conversationEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "callback", "Lcom/disney/id/android/bundler/BundlerCallback;", "Lcom/disney/id/android/bundler/BundlerCallbackData;", "getBundleVersion", "", "hasBundle", "", "initialize", "conversationId", "bundleVersion", "baseBundlerURL", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/bundler/Bundler$Listener;", "Listener", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Bundler {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/disney/id/android/bundler/Bundler$Listener;", "", "onComplete", "", "new", "", "onFailure", "transactionEventKey", "Lcom/disney/id/android/tracker/TrackerEventKey;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Listener {
        void onComplete(boolean z);

        void onFailure(@NotNull TrackerEventKey transactionEventKey);
    }

    void getBundle(@Nullable TrackerEventKey conversationEventKey, @NotNull BundlerCallback<BundlerCallbackData> callback);

    @NotNull
    String getBundleVersion();

    boolean hasBundle();

    void initialize(@Nullable String conversationId, @NotNull String bundleVersion, @NotNull String baseBundlerURL, @Nullable Listener listener);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void initialize$default(Bundler bundler, String str, String str2, String str3, Listener listener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
            }
            if ((i & 8) != 0) {
                listener = null;
            }
            bundler.initialize(str, str2, str3, listener);
        }
    }
}
