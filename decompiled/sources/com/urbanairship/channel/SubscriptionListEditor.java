package com.urbanairship.channel;

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
public abstract class SubscriptionListEditor {
    private final Clock clock;
    private final List mutations = new ArrayList();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract void onApply(@NonNull List<SubscriptionListMutation> list);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected SubscriptionListEditor(Clock clock) {
        this.clock = clock;
    }

    @NonNull
    public SubscriptionListEditor subscribe(@NonNull String str) {
        String strTrim = str.trim();
        if (UAStringUtil.isEmpty(strTrim)) {
            UALog.e("The subscription list ID must not be null or empty.", new Object[0]);
            return this;
        }
        this.mutations.add(SubscriptionListMutation.newSubscribeMutation(strTrim, this.clock.currentTimeMillis()));
        return this;
    }

    @NonNull
    public SubscriptionListEditor subscribe(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            subscribe(it.next());
        }
        return this;
    }

    @NonNull
    public SubscriptionListEditor unsubscribe(String str) {
        String strTrim = str.trim();
        if (UAStringUtil.isEmpty(strTrim)) {
            UALog.e("The subscription list ID must not be null or empty.", new Object[0]);
            return this;
        }
        this.mutations.add(SubscriptionListMutation.newUnsubscribeMutation(strTrim, this.clock.currentTimeMillis()));
        return this;
    }

    @NonNull
    public SubscriptionListEditor unsubscribe(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            unsubscribe(it.next());
        }
        return this;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SubscriptionListEditor mutate(String str, boolean z) {
        return z ? subscribe(str) : unsubscribe(str);
    }

    public void apply() {
        onApply(SubscriptionListMutation.collapseMutations(this.mutations));
    }
}
