package com.disney.id.android;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Deprecated(level = DeprecationLevel.WARNING, message = "No longer supported as of 4.10")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/OneIDHeadlessListener;", "", "onTokenRefreshPPU", "", "ppus", "", "Lcom/disney/id/android/PPU;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OneIDHeadlessListener {
    void onTokenRefreshPPU(@NotNull List<? extends PPU> ppus);
}
