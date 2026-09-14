package com.disney.p026id.android;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, m1836d2 = {"Lcom/disney/id/android/Connectivity;", "", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/disney/id/android/Connectivity$Listener;", "isConnected", "", "networkType", "", "removeListener", "Listener", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface Connectivity {

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m1836d2 = {"Lcom/disney/id/android/Connectivity$Listener;", "", "onConnected", "", "onDisconnected", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
    public interface Listener {
        void onConnected();

        void onDisconnected();
    }

    void addListener(@NotNull Listener listener);

    boolean isConnected();

    @NotNull
    String networkType();

    void removeListener(@NotNull Listener listener);
}
