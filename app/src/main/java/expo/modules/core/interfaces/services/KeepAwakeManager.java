package expo.modules.core.interfaces.services;

import expo.modules.core.errors.CurrentActivityNotFoundException;

/* JADX INFO: loaded from: classes5.dex */
public interface KeepAwakeManager {
    void activate(String str, Runnable runnable) throws CurrentActivityNotFoundException;

    void deactivate(String str, Runnable runnable) throws CurrentActivityNotFoundException;

    boolean isActivated();
}
