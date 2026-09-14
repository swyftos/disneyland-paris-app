package expo.modules.adapters.react.views;

import com.facebook.react.uimanager.ViewProps;

/* JADX INFO: loaded from: classes5.dex */
public class ViewManagerAdapterUtils {
    public static String normalizeEventName(String str) {
        if (!str.startsWith("on")) {
            return str;
        }
        return ViewProps.TOP + str.substring(2);
    }
}
