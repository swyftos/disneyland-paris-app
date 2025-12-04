package com.allegion.alsecurity;

import android.os.Build;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/allegion/alsecurity/AlRootProtection;", "", "()V", "Companion", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlRootProtection {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/allegion/alsecurity/AlRootProtection$Companion;", "", "()V", "checkForTestKeys", "", "checkSuExists", "checkSuperUserPaths", "isDeviceRooted", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean checkForTestKeys() {
            String str = Build.TAGS;
            return str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) "test-keys", false, 2, (Object) null);
        }

        public final boolean checkSuperUserPaths() {
            String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
            for (int i = 0; i < 10; i++) {
                if (new File(strArr[i]).exists()) {
                    return true;
                }
            }
            return false;
        }

        public final boolean checkSuExists() {
            AlRootProtection$Companion$checkSuExists$1 alRootProtection$Companion$checkSuExists$1 = AlRootProtection$Companion$checkSuExists$1.INSTANCE;
            return alRootProtection$Companion$checkSuExists$1.invoke2(CmcdConfiguration.KEY_STARTUP) || alRootProtection$Companion$checkSuExists$1.invoke2("/system/xbin/which") || alRootProtection$Companion$checkSuExists$1.invoke2("which su");
        }

        public final boolean isDeviceRooted() {
            return checkForTestKeys() || checkSuperUserPaths() || checkSuExists();
        }
    }
}
