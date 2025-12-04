package com.allegion.analytics.tracker;

import android.util.Pair;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JU\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u000522\u0010\u0007\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t0\b\"\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH&¢\u0006\u0002\u0010\u000bJQ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n22\u0010\u0007\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t0\b\"\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH&¢\u0006\u0002\u0010\fJU\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u000522\u0010\u0007\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t0\b\"\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH&¢\u0006\u0002\u0010\u000bJQ\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n22\u0010\u0007\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t0\b\"\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH&¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH&JU\u0010\u000f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u000522\u0010\u0007\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t0\b\"\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH&¢\u0006\u0002\u0010\u000bJQ\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n22\u0010\u0007\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t0\b\"\u0012\u0012\u0004\u0012\u00020\n\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\tH&¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/allegion/analytics/tracker/IAlEventTracker;", "", "event", "", "category", "", "action", "args", "", "Landroid/util/Pair;", "", "(II[Landroid/util/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;[Landroid/util/Pair;)V", "failureEvent", "screenName", "successEvent", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlEventTracker {
    void event(@StringRes int category, @StringRes int action, @NotNull Pair<String, ? extends Object>... args);

    void event(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args);

    void failureEvent(@StringRes int category, @StringRes int action, @NotNull Pair<String, ? extends Object>... args);

    void failureEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args);

    void screenName(@NotNull String screenName);

    void successEvent(@StringRes int category, @StringRes int action, @NotNull Pair<String, ? extends Object>... args);

    void successEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args);
}
