package com.learnium.RNDeviceInfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class RNInstallReferrerClient {
    private static Class InstallReferrerClientClazz;
    private static Class InstallReferrerStateListenerClazz;
    private static Class ReferrerDetailsClazz;
    private final ExecutorService executorService;
    private Object installReferrerStateListener;
    private Object mReferrerClient;
    private final Handler mainHandler;
    private final SharedPreferences sharedPreferences;

    static {
        try {
            InstallReferrerClientClazz = InstallReferrerClient.class;
            InstallReferrerStateListenerClazz = InstallReferrerStateListener.class;
            ReferrerDetailsClazz = ReferrerDetails.class;
        } catch (Exception unused) {
            System.err.println("RNInstallReferrerClient exception. 'installreferrer' APIs are unavailable.");
        }
    }

    RNInstallReferrerClient(final Context context) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.executorService = executorServiceNewSingleThreadExecutor;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.sharedPreferences = context.getSharedPreferences("react-native-device-info", 0);
        if (InstallReferrerClientClazz == null || InstallReferrerStateListenerClazz == null || ReferrerDetailsClazz == null) {
            return;
        }
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.learnium.RNDeviceInfo.RNInstallReferrerClient$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                this.f$0.lambda$new$0(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = InstallReferrerClientClazz.getMethod("newBuilder", Context.class).invoke(null, context);
            this.mReferrerClient = objInvoke.getClass().getMethod("build", new Class[0]).invoke(objInvoke, new Object[0]);
            this.installReferrerStateListener = Proxy.newProxyInstance(InstallReferrerStateListenerClazz.getClassLoader(), new Class[]{InstallReferrerStateListenerClazz}, new InstallReferrerStateListenerProxy());
            InstallReferrerClientClazz.getMethod("startConnection", InstallReferrerStateListenerClazz).invoke(this.mReferrerClient, this.installReferrerStateListener);
        } catch (Exception e) {
            PrintStream printStream = System.err;
            printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e.getMessage());
            e.printStackTrace(printStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InstallReferrerStateListenerProxy implements InvocationHandler {
        private InstallReferrerStateListenerProxy() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            try {
                if (name.equals("onInstallReferrerSetupFinished") && objArr != null) {
                    Object obj2 = objArr[0];
                    if (obj2 instanceof Integer) {
                        final int iIntValue = ((Integer) obj2).intValue();
                        RNInstallReferrerClient.this.mainHandler.post(new Runnable() { // from class: com.learnium.RNDeviceInfo.RNInstallReferrerClient.InstallReferrerStateListenerProxy.1
                            @Override // java.lang.Runnable
                            public void run() {
                                InstallReferrerStateListenerProxy.this.onInstallReferrerSetupFinished(iIntValue);
                            }
                        });
                        return null;
                    }
                }
                if (!name.equals("onInstallReferrerServiceDisconnected")) {
                    return null;
                }
                RNInstallReferrerClient.this.mainHandler.post(new Runnable() { // from class: com.learnium.RNDeviceInfo.RNInstallReferrerClient.InstallReferrerStateListenerProxy.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InstallReferrerStateListenerProxy.this.onInstallReferrerServiceDisconnected();
                    }
                });
                return null;
            } catch (Exception e) {
                throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
            }
        }

        public void onInstallReferrerSetupFinished(int i) {
            if (i == 0) {
                RNInstallReferrerClient.this.executorService.execute(new Runnable() { // from class: com.learnium.RNDeviceInfo.RNInstallReferrerClient$InstallReferrerStateListenerProxy$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                        this.f$0.lambda$onInstallReferrerSetupFinished$0();
                    }
                });
            } else if (i == 1) {
                Log.d("InstallReferrerState", "SERVICE_UNAVAILABLE");
            } else {
                if (i != 2) {
                    return;
                }
                Log.d("InstallReferrerState", "FEATURE_NOT_SUPPORTED");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInstallReferrerSetupFinished$0() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                Log.d("InstallReferrerState", "OK");
                String str = (String) RNInstallReferrerClient.ReferrerDetailsClazz.getMethod("getInstallReferrer", new Class[0]).invoke(RNInstallReferrerClient.InstallReferrerClientClazz.getMethod("getInstallReferrer", new Class[0]).invoke(RNInstallReferrerClient.this.mReferrerClient, new Object[0]), new Object[0]);
                SharedPreferences.Editor editorEdit = RNInstallReferrerClient.this.sharedPreferences.edit();
                editorEdit.putString("installReferrer", str);
                editorEdit.apply();
                RNInstallReferrerClient.InstallReferrerClientClazz.getMethod("endConnection", new Class[0]).invoke(RNInstallReferrerClient.this.mReferrerClient, new Object[0]);
            } catch (Exception e) {
                PrintStream printStream = System.err;
                printStream.println("RNInstallReferrerClient exception. getInstallReferrer will be unavailable: " + e.getMessage());
                e.printStackTrace(printStream);
            }
        }

        public void onInstallReferrerServiceDisconnected() {
            Log.d("RNInstallReferrerClient", "InstallReferrerService disconnected");
        }
    }
}
