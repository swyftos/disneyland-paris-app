package com.allegion.accesssdk.models;

import android.app.Application;
import java.util.HashMap;
import java.util.UUID;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class AlConfig {
    private Application application;
    private HashMap<String, String> pinSet;
    private UUID subscriptionKey;

    public AlConfig() {
    }

    @Nullable
    public final Application getApplication() {
        return this.application;
    }

    public HashMap<String, String> getPinSet() {
        return this.pinSet;
    }

    @Nullable
    public final UUID getSubscriptionKey() {
        return this.subscriptionKey;
    }

    public AlConfig setApplication(Application application) {
        this.application = application;
        return this;
    }

    public AlConfig setPinSet(HashMap<String, String> map) {
        this.pinSet = map;
        return this;
    }

    public AlConfig setSubscriptionKey(UUID uuid) {
        this.subscriptionKey = uuid;
        return this;
    }

    public AlConfig(AlConfig alConfig) {
        this.subscriptionKey = alConfig.getSubscriptionKey();
        this.application = alConfig.getApplication();
        this.pinSet = alConfig.getPinSet();
    }
}
