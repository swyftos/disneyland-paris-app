package io.invertase.firebase.common;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.OverridingMethodsMustInvokeSuper;

/* loaded from: classes5.dex */
public class UniversalFirebaseModule {
    private static Map executors = new HashMap();
    private final Context context;
    private final String serviceName;

    protected UniversalFirebaseModule(Context context, String str) {
        this.context = context;
        this.serviceName = str;
    }

    public Context getContext() {
        return this.context;
    }

    public Context getApplicationContext() {
        return getContext().getApplicationContext();
    }

    protected ExecutorService getExecutor() {
        ExecutorService executorService = (ExecutorService) executors.get(getName());
        if (executorService != null) {
            return executorService;
        }
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        executors.put(getName(), executorServiceNewSingleThreadExecutor);
        return executorServiceNewSingleThreadExecutor;
    }

    public String getName() {
        return "Universal" + this.serviceName + "Module";
    }

    @OverridingMethodsMustInvokeSuper
    public void onTearDown() {
        ExecutorService executorService = (ExecutorService) executors.get(getName());
        if (executorService != null) {
            executorService.shutdownNow();
            executors.remove(getName());
        }
    }

    public Map<String, Object> getConstants() {
        return new HashMap();
    }
}
