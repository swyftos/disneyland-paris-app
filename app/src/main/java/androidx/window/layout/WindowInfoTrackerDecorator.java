package androidx.window.layout;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H'¨\u0006\u0005"}, m1836d2 = {"Landroidx/window/layout/WindowInfoTrackerDecorator;", "", "decorate", "Landroidx/window/layout/WindowInfoTracker;", "tracker", "window_release"}, m1837k = 1, m1838mv = {1, 6, 0}, m1840xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface WindowInfoTrackerDecorator {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    WindowInfoTracker decorate(@NotNull WindowInfoTracker tracker);
}
