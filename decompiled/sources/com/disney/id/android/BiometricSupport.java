package com.disney.id.android;

import android.content.Context;
import com.disney.id.android.lightbox.LightboxActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\u001c\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u000e\u001a\u00020\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/disney/id/android/BiometricSupport;", "", "encryptAfterAuthenticate", "", "lightboxActivity", "Lcom/disney/id/android/lightbox/LightboxActivity;", "plainText", "getBridgeBiometricResponse", "stateKeyToUse", "conversationID", "isBiometricEnabled", "", "context", "Landroid/content/Context;", "isOptedOut", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BiometricSupport {
    @Nullable
    String encryptAfterAuthenticate(@NotNull LightboxActivity lightboxActivity, @Nullable String plainText);

    @NotNull
    String getBridgeBiometricResponse(@NotNull LightboxActivity lightboxActivity, @NotNull String stateKeyToUse, @Nullable String conversationID);

    boolean isBiometricEnabled(@NotNull Context context, @Nullable String conversationID);

    boolean isOptedOut();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean isBiometricEnabled$default(BiometricSupport biometricSupport, Context context, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isBiometricEnabled");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return biometricSupport.isBiometricEnabled(context, str);
        }
    }
}
