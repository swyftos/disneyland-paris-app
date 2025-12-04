package com.allegion.analytics.tracker;

import android.util.Pair;
import androidx.annotation.StringRes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001JQ\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n22\u0010\f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000e0\r\"\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000eH\u0016¢\u0006\u0002\u0010\u0011JQ\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f22\u0010\f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000e0\r\"\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000eH\u0016¢\u0006\u0002\u0010\u0012JU\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n22\u0010\f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000e0\r\"\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000eH\u0016¢\u0006\u0002\u0010\u0011JQ\u0010\u0013\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f22\u0010\f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000e0\r\"\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000eH\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000fH\u0016JU\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n22\u0010\f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000e0\r\"\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000eH\u0016¢\u0006\u0002\u0010\u0011JQ\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f22\u0010\f\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000e0\r\"\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00100\u000eH\u0016¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/allegion/analytics/tracker/AlCompositeEventTracker;", "Lcom/allegion/analytics/tracker/IAlEventTracker;", "()V", "eventTrackers", "", "add", "", "eventTracker", "event", "category", "", "action", "args", "", "Landroid/util/Pair;", "", "", "(II[Landroid/util/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;[Landroid/util/Pair;)V", "failureEvent", "screenName", "successEvent", "Analytics_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class AlCompositeEventTracker implements IAlEventTracker {
    private List<IAlEventTracker> eventTrackers = new ArrayList();

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void screenName(@NotNull String screenName) {
        Intrinsics.checkParameterIsNotNull(screenName, "screenName");
        Iterator<T> it = this.eventTrackers.iterator();
        while (it.hasNext()) {
            ((IAlEventTracker) it.next()).screenName(screenName);
        }
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void successEvent(@StringRes int category, @StringRes int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        Iterator<T> it = this.eventTrackers.iterator();
        while (it.hasNext()) {
            ((IAlEventTracker) it.next()).successEvent(category, action, (Pair<String, ? extends Object>[]) Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void successEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        Iterator<T> it = this.eventTrackers.iterator();
        while (it.hasNext()) {
            ((IAlEventTracker) it.next()).successEvent(category, action, (Pair<String, ? extends Object>[]) Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void failureEvent(@StringRes int category, @StringRes int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        Iterator<T> it = this.eventTrackers.iterator();
        while (it.hasNext()) {
            ((IAlEventTracker) it.next()).failureEvent(category, action, (Pair<String, ? extends Object>[]) Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void failureEvent(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        Iterator<T> it = this.eventTrackers.iterator();
        while (it.hasNext()) {
            ((IAlEventTracker) it.next()).failureEvent(category, action, (Pair<String, ? extends Object>[]) Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void event(int category, int action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        Iterator<T> it = this.eventTrackers.iterator();
        while (it.hasNext()) {
            ((IAlEventTracker) it.next()).event(category, action, (Pair<String, ? extends Object>[]) Arrays.copyOf(args, args.length));
        }
    }

    @Override // com.allegion.analytics.tracker.IAlEventTracker
    public void event(@NotNull String category, @NotNull String action, @NotNull Pair<String, ? extends Object>... args) {
        Intrinsics.checkParameterIsNotNull(category, "category");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Intrinsics.checkParameterIsNotNull(args, "args");
        Iterator<T> it = this.eventTrackers.iterator();
        while (it.hasNext()) {
            ((IAlEventTracker) it.next()).event(category, action, (Pair<String, ? extends Object>[]) Arrays.copyOf(args, args.length));
        }
    }

    public final void add(@NotNull IAlEventTracker eventTracker) {
        Intrinsics.checkParameterIsNotNull(eventTracker, "eventTracker");
        this.eventTrackers.add(eventTracker);
    }
}
