package androidx.camera.extensions.internal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public class ClientVersion {
    private static ClientVersion sCurrent = new ClientVersion("1.4.0");
    private final Version mVersion;

    @NonNull
    public static ClientVersion getCurrentVersion() {
        return sCurrent;
    }

    @VisibleForTesting
    public static void setCurrentVersion(@NonNull ClientVersion clientVersion) {
        sCurrent = clientVersion;
    }

    @NonNull
    public Version getVersion() {
        return this.mVersion;
    }

    public ClientVersion(@NonNull String str) {
        this.mVersion = Version.parse(str);
    }

    public static boolean isMinimumCompatibleVersion(@NonNull Version version) {
        return getCurrentVersion().mVersion.compareTo(version.getMajor(), version.getMinor()) >= 0;
    }

    public static boolean isMaximumCompatibleVersion(@NonNull Version version) {
        return getCurrentVersion().mVersion.compareTo(version.getMajor(), version.getMinor()) <= 0;
    }

    @NonNull
    public String toVersionString() {
        return this.mVersion.toString();
    }
}
