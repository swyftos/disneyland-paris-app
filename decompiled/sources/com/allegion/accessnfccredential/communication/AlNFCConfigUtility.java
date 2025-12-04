package com.allegion.accessnfccredential.communication;

import android.content.Context;
import com.allegion.accessnfccredential.exception.AlNFCComponentException;
import com.allegion.alsecurity.enums.AlKeyType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.logging.AlLog;
import java.security.KeyPair;
import java.util.Objects;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u0013\u0010%\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b&\u0010\u0013¨\u0006*"}, d2 = {"Lcom/allegion/accessnfccredential/communication/AlNFCConfigUtility;", "", "()V", "EXCEPTION_KEY_MANAGER_NULL", "", "EXCEPTION_NFC_CONFIG_NULL", "config", "Lcom/allegion/accessnfccredential/communication/IAlNFCConfig;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "deviceKey", "Ljava/security/KeyPair;", "getDeviceKey", "()Ljava/security/KeyPair;", "diversifiedKey", "Ljavax/crypto/SecretKey;", "getDiversifiedKey", "()Ljavax/crypto/SecretKey;", "diversifiedKeyInput", "getDiversifiedKeyInput", "kd", "", "getKd", "()[B", "setKd", "([B)V", "kd_div", "getKd_div", "setKd_div", "randomAndroid", "getRandomAndroid", "setRandomAndroid", "randomDevice", "getRandomDevice", "setRandomDevice", "sessionKey", "getSessionKey", "setConfig", "", "nfcConfig", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlNFCConfigUtility {
    private static final String EXCEPTION_KEY_MANAGER_NULL = "Key manager not set";
    private static final String EXCEPTION_NFC_CONFIG_NULL = "NFC config cannot be null";
    public static final AlNFCConfigUtility INSTANCE = new AlNFCConfigUtility();
    private static IAlNFCConfig config;

    @Nullable
    private static byte[] kd;

    @Nullable
    private static byte[] kd_div;

    @Nullable
    private static byte[] randomAndroid;

    @Nullable
    private static byte[] randomDevice;

    private AlNFCConfigUtility() {
    }

    @Nullable
    public final byte[] getKd() {
        return kd;
    }

    public final void setKd(@Nullable byte[] bArr) {
        kd = bArr;
    }

    @Nullable
    public final byte[] getKd_div() {
        return kd_div;
    }

    public final void setKd_div(@Nullable byte[] bArr) {
        kd_div = bArr;
    }

    @Nullable
    public final byte[] getRandomDevice() {
        return randomDevice;
    }

    public final void setRandomDevice(@Nullable byte[] bArr) {
        randomDevice = bArr;
    }

    @Nullable
    public final byte[] getRandomAndroid() {
        return randomAndroid;
    }

    public final void setRandomAndroid(@Nullable byte[] bArr) {
        randomAndroid = bArr;
    }

    @Nullable
    public final Context getContext() {
        IAlNFCConfig iAlNFCConfig = config;
        if (iAlNFCConfig != null) {
            return iAlNFCConfig.getContext();
        }
        return null;
    }

    @Nullable
    public final SecretKey getDiversifiedKey() throws AlNFCComponentException {
        IAlNFCConfig iAlNFCConfig = config;
        if (iAlNFCConfig != null) {
            IAlKeyManagement keyManager = iAlNFCConfig.getKeyManager();
            try {
                byte[] bArr = kd;
                if (bArr != null) {
                    keyManager.storeKey(bArr, iAlNFCConfig.getDiversifiedKeyReference());
                }
                return keyManager.getKey(iAlNFCConfig.getDiversifiedKeyReference());
            } catch (AlSecurityException e) {
                throw new AlNFCComponentException("Unable to get diversified key", e);
            }
        }
        throw new AlNFCComponentException("Unable to get diversified key");
    }

    @Nullable
    public final SecretKey getDiversifiedKeyInput() throws AlNFCComponentException {
        IAlNFCConfig iAlNFCConfig = config;
        if (iAlNFCConfig != null) {
            IAlKeyManagement keyManager = iAlNFCConfig.getKeyManager();
            try {
                byte[] bArr = kd_div;
                if (bArr != null) {
                    keyManager.storeKey(bArr, iAlNFCConfig.getDiversifiedKeyInputReference());
                }
                return keyManager.getKey(iAlNFCConfig.getDiversifiedKeyInputReference());
            } catch (AlSecurityException e) {
                throw new AlNFCComponentException("Unable to get diversified key input", e);
            }
        }
        throw new AlNFCComponentException("Unable to get diversified key input");
    }

    @NotNull
    public final KeyPair getDeviceKey() throws AlNFCComponentException {
        IAlNFCConfig iAlNFCConfig = config;
        if (iAlNFCConfig != null) {
            IAlKeyManagement keyManager = iAlNFCConfig.getKeyManager();
            try {
                return keyManager.getKeyPair(iAlNFCConfig.getDeviceKeyReference());
            } catch (AlSecurityException e) {
                AlLog.e("Unable to get key pair: %s", e.getMessage());
                try {
                    AlLog.i(e);
                    keyManager.generateKey(AlKeyType.ECC_ECDSA_SPEC256R1, iAlNFCConfig.getDeviceKeyReference());
                    return keyManager.getKeyPair(iAlNFCConfig.getDeviceKeyReference());
                } catch (AlSecurityException e2) {
                    throw new AlNFCComponentException("Unable to get device key", e2);
                }
            }
        }
        throw new AlNFCComponentException("Unable to get device key");
    }

    @Nullable
    public final SecretKey getSessionKey() throws AlNFCComponentException {
        IAlNFCConfig iAlNFCConfig = config;
        if (iAlNFCConfig != null) {
            IAlKeyManagement keyManager = iAlNFCConfig.getKeyManager();
            byte[] bArr = randomAndroid;
            if (bArr == null) {
                throw new AlNFCComponentException("Random number from the Android device is invalid or missing.");
            }
            byte[] bArr2 = randomDevice;
            if (bArr2 != null) {
                try {
                    keyManager.storeKey(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.sliceArray(bArr2, new IntRange(0, 3)), ArraysKt.sliceArray(bArr, new IntRange(4, 7))), ArraysKt.sliceArray(bArr2, new IntRange(8, 11))), ArraysKt.sliceArray(bArr, new IntRange(12, 15))), iAlNFCConfig.getSessionKeyReference());
                    return keyManager.getKey(iAlNFCConfig.getSessionKeyReference());
                } catch (AlSecurityException e) {
                    throw new AlNFCComponentException("Unable to get session key.", e);
                }
            }
            throw new AlNFCComponentException("Random number from the Allegion device is invalid or missing.");
        }
        throw new AlNFCComponentException("Unable to get session key.");
    }

    public final void setConfig(@NotNull IAlNFCConfig nfcConfig) {
        Intrinsics.checkParameterIsNotNull(nfcConfig, "nfcConfig");
        Objects.requireNonNull(nfcConfig, EXCEPTION_NFC_CONFIG_NULL);
        Objects.requireNonNull(nfcConfig.getKeyManager(), EXCEPTION_KEY_MANAGER_NULL);
        config = nfcConfig;
    }
}
