package com.urbanairship.app;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class ForwardingApplicationListener implements ApplicationListener {
    private final List listeners = new ArrayList();

    public void addListener(@NonNull ApplicationListener applicationListener) {
        synchronized (this.listeners) {
            this.listeners.add(applicationListener);
        }
    }

    public void removeListener(@NonNull ApplicationListener applicationListener) {
        synchronized (this.listeners) {
            this.listeners.remove(applicationListener);
        }
    }

    @Override // com.urbanairship.app.ApplicationListener
    public void onForeground(long j) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ApplicationListener) it.next()).onForeground(j);
        }
    }

    @Override // com.urbanairship.app.ApplicationListener
    public void onBackground(long j) {
        Iterator it = new ArrayList(this.listeners).iterator();
        while (it.hasNext()) {
            ((ApplicationListener) it.next()).onBackground(j);
        }
    }
}
