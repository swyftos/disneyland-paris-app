package com.contentsquare.rn.utils;

import android.util.Log;
import com.contentsquare.android.api.bridge.logmonitor.LogMonitorInterface;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/contentsquare/rn/utils/LogMonitorUtil;", "", "<init>", "()V", "Companion", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogMonitorUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final void monitorError(@NotNull ReadableMap readableMap) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        INSTANCE.monitorError(readableMap);
    }

    @JvmStatic
    public static final void monitorWarn(@NotNull ReadableMap readableMap) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        INSTANCE.monitorWarn(readableMap);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/contentsquare/rn/utils/LogMonitorUtil$Companion;", "", "<init>", "()V", "monitorWarn", "", "params", "Lcom/facebook/react/bridge/ReadableMap;", "monitorError", "contentsquare_react-native-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void monitorWarn(@NotNull ReadableMap params) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(params, "params");
            try {
                Object objNewInstance = LogMonitorInterface.class.newInstance();
                Map<String, Object> map = ReactNativeTypesConverter.readableMapToMap(params, null, null);
                Intrinsics.checkNotNullExpressionValue(map, "readableMapToMap(...)");
                try {
                    Method declaredMethod = LogMonitorInterface.class.getDeclaredMethod("warn", String.class, Map.class);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
                    declaredMethod.setAccessible(true);
                    Object obj = map.get("args");
                    Object obj2 = map.get("description");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) obj2;
                    Object map2 = new HashMap();
                    if (obj instanceof Map) {
                        map2 = (Map) obj;
                    } else if (obj instanceof ArrayList) {
                        Log.d("CSLIB", "Received args as an ArrayList: " + obj);
                    }
                    declaredMethod.invoke(objNewInstance, str, map2);
                } catch (Exception e) {
                    Log.d("CSLIB", "Exception failure while calling monitorWarnMethod", e);
                }
            } catch (Exception e2) {
                Log.e("CSLIB", "Exception failure while monitorWarn", e2);
                e2.printStackTrace();
            }
        }

        @JvmStatic
        public final void monitorError(@NotNull ReadableMap params) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Intrinsics.checkNotNullParameter(params, "params");
            try {
                Object objNewInstance = LogMonitorInterface.class.newInstance();
                Map<String, Object> map = ReactNativeTypesConverter.readableMapToMap(params, null, null);
                Intrinsics.checkNotNullExpressionValue(map, "readableMapToMap(...)");
                try {
                    Method declaredMethod = LogMonitorInterface.class.getDeclaredMethod(Constants.IPC_BUNDLE_KEY_SEND_ERROR, String.class, String.class, String.class, String.class, Map.class);
                    Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
                    declaredMethod.setAccessible(true);
                    Object obj = map.get("args");
                    Object obj2 = map.get("description");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) obj2;
                    Object obj3 = map.get("errorDescription");
                    String str2 = obj3 instanceof String ? (String) obj3 : null;
                    if (str2 == null) {
                        str2 = "Unknown error";
                    }
                    Object map2 = new HashMap();
                    if (obj instanceof Map) {
                        map2 = (Map) obj;
                    } else if (obj instanceof ArrayList) {
                        Log.d("CSLIB", "Received args as an ArrayList: " + obj);
                    }
                    declaredMethod.invoke(objNewInstance, str, "", str2, "", map2);
                } catch (Exception e) {
                    Log.d("CSLIB", "Exception failure while calling monitorErrorMethod", e);
                }
            } catch (Exception e2) {
                Log.e("CSLIB", "Exception failure while monitorError", e2);
                e2.printStackTrace();
            }
        }
    }
}
