package com.urbanairship.contacts;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.urbanairship.UALog;
import com.urbanairship.util.Clock;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public abstract class ScopedSubscriptionListEditor {
    private final Clock clock;
    private final List mutations = new ArrayList();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract void onApply(@NonNull List<ScopedSubscriptionListMutation> list);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ScopedSubscriptionListEditor(Clock clock) {
        this.clock = clock;
    }

    @NonNull
    public ScopedSubscriptionListEditor subscribe(@NonNull String str, @NonNull Scope scope) {
        String strTrim = str.trim();
        if (UAStringUtil.isEmpty(strTrim)) {
            UALog.e("The subscription list ID must not be null or empty.", new Object[0]);
            return this;
        }
        this.mutations.add(ScopedSubscriptionListMutation.newSubscribeMutation(strTrim, scope, this.clock.currentTimeMillis()));
        return this;
    }

    @NonNull
    public ScopedSubscriptionListEditor subscribe(Set<String> set, @NonNull Scope scope) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            subscribe(it.next(), scope);
        }
        return this;
    }

    @NonNull
    public ScopedSubscriptionListEditor unsubscribe(String str, @NonNull Scope scope) {
        String strTrim = str.trim();
        if (UAStringUtil.isEmpty(strTrim)) {
            UALog.e("The subscription list ID must not be null or empty.", new Object[0]);
            return this;
        }
        this.mutations.add(ScopedSubscriptionListMutation.newUnsubscribeMutation(strTrim, scope, this.clock.currentTimeMillis()));
        return this;
    }

    @NonNull
    public ScopedSubscriptionListEditor unsubscribe(Set<String> set, @NonNull Scope scope) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            unsubscribe(it.next(), scope);
        }
        return this;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ScopedSubscriptionListEditor mutate(@NonNull String str, @NonNull Set<Scope> set, boolean z) {
        for (Scope scope : set) {
            if (z) {
                subscribe(str, scope);
            } else {
                unsubscribe(str, scope);
            }
        }
        return this;
    }

    public void apply() {
        onApply(ScopedSubscriptionListMutation.collapseMutations(this.mutations));
    }
}
