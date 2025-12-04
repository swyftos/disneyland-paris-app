package com.swmansion.worklets;

import androidx.annotation.OptIn;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class JSCallInvokerResolver {
    @OptIn(markerClass = {FrameworkAPI.class})
    public static CallInvokerHolderImpl getJSCallInvokerHolder(ReactApplicationContext reactApplicationContext) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            try {
                return (CallInvokerHolderImpl) reactApplicationContext.getClass().getMethod("getJSCallInvokerHolder", new Class[0]).invoke(reactApplicationContext, new Object[0]);
            } catch (Exception unused) {
                Object objInvoke = reactApplicationContext.getClass().getMethod("getCatalystInstance", new Class[0]).invoke(reactApplicationContext, new Object[0]);
                return (CallInvokerHolderImpl) objInvoke.getClass().getMethod("getJSCallInvokerHolder", new Class[0]).invoke(objInvoke, new Object[0]);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get JSCallInvokerHolder", e);
        }
    }
}
