package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.exceptions.AlRuntimeException;
import java.util.HashMap;

/* loaded from: classes2.dex */
final class AlServiceProvider {
    private final HashMap<Class, Object> services = new HashMap<>();

    AlServiceProvider() {
        registerService(new AlEnrollmentProvidable(), IAlEnrollmentProvidable.class);
        registerService(new AlRightsService(), IAlRightsService.class);
        registerService(new AlStorageService(), IAlStorageService.class);
        registerService(new AlDeviceSearchService(), IAlDeviceSearchService.class);
        registerService(new AlAuthenticationService(), IAlAuthenticationService.class);
    }

    public boolean containsService(Class cls) {
        return this.services.containsKey(cls);
    }

    public <T> T locateService(Class cls) {
        AlObjects.requireNonNull(cls, "Action interface must not be null");
        if (this.services.containsKey(cls)) {
            return (T) this.services.get(cls);
        }
        throw new AlRuntimeException("Service not found");
    }

    public void registerService(Object obj, Class cls) {
        AlObjects.requireNonNull(cls, "Action interface must not be null");
        AlObjects.requireNonNull(obj, "Action service must not be null");
        if (!cls.isInstance(obj)) {
            throw new IllegalStateException("Located service does not implement matching interface");
        }
        this.services.put(cls, obj);
    }
}
