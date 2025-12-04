package com.microsoft.appcenter.utils.context;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class UserIdContext {

    @VisibleForTesting
    public static final int USER_ID_APP_CENTER_MAX_LENGTH = 256;
    private static UserIdContext sInstance;
    private final Set mListeners = Collections.newSetFromMap(new ConcurrentHashMap());
    private String mUserId;

    public interface Listener {
        void onNewUserId(String str);
    }

    public static synchronized UserIdContext getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new UserIdContext();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    @VisibleForTesting
    public static synchronized void unsetInstance() {
        sInstance = null;
    }

    public static boolean checkUserIdValidForOneCollector(String str) {
        if (str == null) {
            return true;
        }
        if (str.isEmpty()) {
            AppCenterLog.error("AppCenter", "userId must not be empty.");
            return false;
        }
        int iIndexOf = str.indexOf(":");
        if (iIndexOf >= 0) {
            String strSubstring = str.substring(0, iIndexOf);
            if (!strSubstring.equals("c")) {
                AppCenterLog.error("AppCenter", String.format("userId prefix must be '%s%s', '%s%s' is not supported.", "c", ":", strSubstring, ":"));
                return false;
            }
            if (iIndexOf == str.length() - 1) {
                AppCenterLog.error("AppCenter", "userId must not be empty.");
                return false;
            }
        }
        return true;
    }

    public static boolean checkUserIdValidForAppCenter(String str) {
        if (str == null || str.length() <= 256) {
            return true;
        }
        AppCenterLog.error("AppCenter", "userId is limited to 256 characters.");
        return false;
    }

    public static String getPrefixedUserId(String str) {
        if (str == null || str.contains(":")) {
            return str;
        }
        return "c:" + str;
    }

    public void addListener(@NonNull Listener listener) {
        this.mListeners.add(listener);
    }

    public void removeListener(@NonNull Listener listener) {
        this.mListeners.remove(listener);
    }

    public synchronized String getUserId() {
        return this.mUserId;
    }

    public void setUserId(String str) {
        if (updateUserId(str)) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).onNewUserId(this.mUserId);
            }
        }
    }

    private synchronized boolean updateUserId(String str) {
        if (TextUtils.equals(this.mUserId, str)) {
            return false;
        }
        this.mUserId = str;
        return true;
    }
}
