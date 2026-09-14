package com.disney.p026id.android;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, m1836d2 = {"Lcom/disney/id/android/MigrationHandler;", "", "shouldNotifyOfLogout", "", "getShouldNotifyOfLogout", "()Z", "clearState", "", "migrate", "Lcom/disney/id/android/MigrationInfo;", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface MigrationHandler {
    void clearState();

    boolean getShouldNotifyOfLogout();

    @NotNull
    MigrationInfo migrate();
}
