package androidx.test.espresso;

import android.os.Looper;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class IdlingRegistry {
    private static final IdlingRegistry instance = new IdlingRegistry();
    private final Set resources = Collections.synchronizedSet(new HashSet());
    private final Set loopers = Collections.synchronizedSet(new HashSet());

    IdlingRegistry() {
    }

    public static IdlingRegistry getInstance() {
        return instance;
    }

    public boolean register(IdlingResource... idlingResourceArr) {
        if (idlingResourceArr == null) {
            throw new NullPointerException("idlingResources cannot be null!");
        }
        return this.resources.addAll(Arrays.asList(idlingResourceArr));
    }

    public boolean unregister(IdlingResource... idlingResourceArr) {
        if (idlingResourceArr == null) {
            throw new NullPointerException("idlingResources cannot be null!");
        }
        return this.resources.removeAll(Arrays.asList(idlingResourceArr));
    }

    public void registerLooperAsIdlingResource(Looper looper) {
        if (looper == null) {
            throw new NullPointerException("looper cannot be null!");
        }
        if (Looper.getMainLooper() == looper) {
            throw new IllegalArgumentException("Not intended for use with main looper!");
        }
        this.loopers.add(looper);
    }

    public boolean unregisterLooperAsIdlingResource(Looper looper) {
        if (looper == null) {
            throw new NullPointerException("looper cannot be null!");
        }
        return this.loopers.remove(looper);
    }

    public Collection<IdlingResource> getResources() {
        return new HashSet(this.resources);
    }

    public Collection<Looper> getLoopers() {
        return new HashSet(this.loopers);
    }
}
