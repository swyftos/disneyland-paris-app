package androidx.media3.session.legacy;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.session.MediaSessionManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.media3.common.util.UnstableApi;

@RestrictTo({RestrictTo.Scope.LIBRARY})
@UnstableApi
/* loaded from: classes.dex */
public final class MediaSessionManager {
    static final boolean DEBUG = Log.isLoggable("MediaSessionManager", 3);
    private static final Object sLock = new Object();
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl mImpl;

    interface MediaSessionManagerImpl {
        boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl);
    }

    interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    public static MediaSessionManager getSessionManager(Context context) {
        MediaSessionManager mediaSessionManager;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        synchronized (sLock) {
            try {
                if (sSessionManager == null) {
                    sSessionManager = new MediaSessionManager(context.getApplicationContext());
                }
                mediaSessionManager = sSessionManager;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaSessionManager;
    }

    private MediaSessionManager(Context context) {
        this.mImpl = new MediaSessionManagerImplApi28(context);
    }

    public boolean isTrustedForMediaControl(RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("userInfo should not be null");
        }
        return this.mImpl.isTrustedForMediaControl(remoteUserInfo.mImpl);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        public static final int UNKNOWN_PID = -1;
        public static final int UNKNOWN_UID = -1;
        RemoteUserInfoImpl mImpl;

        public RemoteUserInfo(@Nullable String str, int i, int i2) {
            if (str == null) {
                throw new NullPointerException("package shouldn't be null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i, i2);
        }

        @RequiresApi(28)
        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            String packageName = MediaSessionManagerImplApi28.RemoteUserInfoImplApi28.getPackageName(remoteUserInfo);
            if (packageName == null) {
                throw new NullPointerException("package shouldn't be null");
            }
            if (TextUtils.isEmpty(packageName)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo);
        }

        public String getPackageName() {
            return this.mImpl.getPackageName();
        }

        public int getPid() {
            return this.mImpl.getPid();
        }

        public int getUid() {
            return this.mImpl.getUid();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteUserInfo) {
                return this.mImpl.equals(((RemoteUserInfo) obj).mImpl);
            }
            return false;
        }

        public int hashCode() {
            return this.mImpl.hashCode();
        }
    }

    private static class MediaSessionManagerImplBase implements MediaSessionManagerImpl {
        private static final boolean DEBUG = MediaSessionManager.DEBUG;
        ContentResolver mContentResolver;
        Context mContext;

        MediaSessionManagerImplBase(Context context) {
            this.mContext = context;
            this.mContentResolver = context.getContentResolver();
        }

        public Context getContext() {
            return this.mContext;
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImpl
        public boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl) {
            try {
                if (this.mContext.getPackageManager().getApplicationInfo(remoteUserInfoImpl.getPackageName(), 0) == null) {
                    return false;
                }
                return isPermissionGranted(remoteUserInfoImpl, "android.permission.STATUS_BAR_SERVICE") || isPermissionGranted(remoteUserInfoImpl, "android.permission.MEDIA_CONTENT_CONTROL") || remoteUserInfoImpl.getUid() == 1000 || isEnabledNotificationListener(remoteUserInfoImpl);
            } catch (PackageManager.NameNotFoundException unused) {
                if (DEBUG) {
                    Log.d("MediaSessionManager", "Package " + remoteUserInfoImpl.getPackageName() + " doesn't exist");
                }
                return false;
            }
        }

        private boolean isPermissionGranted(RemoteUserInfoImpl remoteUserInfoImpl, String str) {
            return remoteUserInfoImpl.getPid() < 0 ? this.mContext.getPackageManager().checkPermission(str, remoteUserInfoImpl.getPackageName()) == 0 : this.mContext.checkPermission(str, remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
        }

        boolean isEnabledNotificationListener(RemoteUserInfoImpl remoteUserInfoImpl) {
            String string = Settings.Secure.getString(this.mContentResolver, "enabled_notification_listeners");
            if (string != null) {
                for (String str : string.split(":")) {
                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                    if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(remoteUserInfoImpl.getPackageName())) {
                        return true;
                    }
                }
            }
            return false;
        }

        static class RemoteUserInfoImplBase implements RemoteUserInfoImpl {
            private String mPackageName;
            private int mPid;
            private int mUid;

            RemoteUserInfoImplBase(String str, int i, int i2) {
                this.mPackageName = str;
                this.mPid = i;
                this.mUid = i2;
            }

            @Override // androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfoImpl
            public String getPackageName() {
                return this.mPackageName;
            }

            @Override // androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfoImpl
            public int getPid() {
                return this.mPid;
            }

            @Override // androidx.media3.session.legacy.MediaSessionManager.RemoteUserInfoImpl
            public int getUid() {
                return this.mUid;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RemoteUserInfoImplBase)) {
                    return false;
                }
                RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
                return (this.mPid < 0 || remoteUserInfoImplBase.mPid < 0) ? TextUtils.equals(this.mPackageName, remoteUserInfoImplBase.mPackageName) && this.mUid == remoteUserInfoImplBase.mUid : TextUtils.equals(this.mPackageName, remoteUserInfoImplBase.mPackageName) && this.mPid == remoteUserInfoImplBase.mPid && this.mUid == remoteUserInfoImplBase.mUid;
            }

            public int hashCode() {
                return ObjectsCompat.hash(this.mPackageName, Integer.valueOf(this.mUid));
            }
        }
    }

    private static class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
        MediaSessionManagerImplApi21(Context context) {
            super(context);
            this.mContext = context;
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImplBase, androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImpl
        public boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl) {
            return hasMediaControlPermission(remoteUserInfoImpl) || super.isTrustedForMediaControl(remoteUserInfoImpl);
        }

        private boolean hasMediaControlPermission(RemoteUserInfoImpl remoteUserInfoImpl) {
            return getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0;
        }
    }

    private static final class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
        android.media.session.MediaSessionManager mObject;

        MediaSessionManagerImplApi28(Context context) {
            super(context);
            this.mObject = (android.media.session.MediaSessionManager) context.getSystemService("media_session");
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImplApi21, androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImplBase, androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImpl
        public boolean isTrustedForMediaControl(RemoteUserInfoImpl remoteUserInfoImpl) {
            return super.isTrustedForMediaControl(remoteUserInfoImpl);
        }

        private static final class RemoteUserInfoImplApi28 extends MediaSessionManagerImplBase.RemoteUserInfoImplBase {
            final MediaSessionManager.RemoteUserInfo mObject;

            RemoteUserInfoImplApi28(String str, int i, int i2) {
                super(str, i, i2);
                this.mObject = new MediaSessionManager.RemoteUserInfo(str, i, i2);
            }

            RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
                super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
                this.mObject = remoteUserInfo;
            }

            static String getPackageName(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
                return remoteUserInfo.getPackageName();
            }
        }
    }
}
