package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import com.allegion.accessblecredential.utility.AlDeviceStorage;
import com.allegion.alsecurity.enums.AlKeyType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.logging.AlLog;
import java.security.KeyPair;
import java.security.interfaces.ECPublicKey;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0015\u001a\u00020\u00128F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\u000e8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/allegion/accessblecredential/communication/AlBLEConfigUtility;", "", "Lcom/allegion/accessblecredential/communication/IAlBLEConfig;", "bleConfig", "", "setConfig", "(Lcom/allegion/accessblecredential/communication/IAlBLEConfig;)V", "Ljava/security/interfaces/ECPublicKey;", "eccPublicKey", "", "exportEccPublicKey", "(Ljava/security/interfaces/ECPublicKey;)[B", "config", "Lcom/allegion/accessblecredential/communication/IAlBLEConfig;", "Ljava/security/KeyPair;", "getDeviceKey", "()Ljava/security/KeyPair;", "deviceKey", "Lcom/allegion/accessblecredential/utility/AlDeviceStorage;", "getDeviceStorage", "()Lcom/allegion/accessblecredential/utility/AlDeviceStorage;", "deviceStorage", "getSessionKey", "sessionKey", "<init>", "()V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlBLEConfigUtility {
    public static final AlBLEConfigUtility INSTANCE = new AlBLEConfigUtility();
    private static IAlBLEConfig config;

    private AlBLEConfigUtility() {
    }

    @NotNull
    public final byte[] exportEccPublicKey(@NotNull ECPublicKey eccPublicKey) throws AlBleComponentException {
        Intrinsics.checkParameterIsNotNull(eccPublicKey, "eccPublicKey");
        IAlBLEConfig iAlBLEConfig = config;
        if (iAlBLEConfig == null) {
            Intrinsics.throwNpe();
        }
        try {
            return iAlBLEConfig.getKeyManager().exportPublicKeyX963Uncompressed(eccPublicKey);
        } catch (AlSecurityException e) {
            String message = e.getMessage();
            if (message == null) {
                Intrinsics.throwNpe();
            }
            throw new AlBleComponentException(message, e);
        }
    }

    @NotNull
    public final KeyPair getDeviceKey() throws AlBleComponentException {
        IAlBLEConfig iAlBLEConfig = config;
        if (iAlBLEConfig == null) {
            Intrinsics.throwNpe();
        }
        IAlKeyManagement keyManager = iAlBLEConfig.getKeyManager();
        try {
            IAlBLEConfig iAlBLEConfig2 = config;
            if (iAlBLEConfig2 == null) {
                Intrinsics.throwNpe();
            }
            return keyManager.getKeyPair(iAlBLEConfig2.getDeviceKeyReference());
        } catch (AlSecurityException e) {
            String message = e.getMessage();
            if (message == null) {
                Intrinsics.throwNpe();
            }
            AlLog.e("Unable to get key pair: %s", message);
            try {
                AlLog.i(e);
                AlKeyType alKeyType = AlKeyType.ECC_ECDSA_SPEC256R1;
                IAlBLEConfig iAlBLEConfig3 = config;
                if (iAlBLEConfig3 == null) {
                    Intrinsics.throwNpe();
                }
                keyManager.generateKey(alKeyType, iAlBLEConfig3.getDeviceKeyReference());
                IAlBLEConfig iAlBLEConfig4 = config;
                if (iAlBLEConfig4 == null) {
                    Intrinsics.throwNpe();
                }
                return keyManager.getKeyPair(iAlBLEConfig4.getDeviceKeyReference());
            } catch (AlSecurityException e2) {
                throw new AlBleComponentException("Unable to get device key", e2);
            }
        }
    }

    @NotNull
    public final AlDeviceStorage getDeviceStorage() {
        IAlBLEConfig iAlBLEConfig = config;
        if (iAlBLEConfig == null) {
            Intrinsics.throwNpe();
        }
        return new AlDeviceStorage(iAlBLEConfig.getSecureStorage());
    }

    @NotNull
    public final KeyPair getSessionKey() throws AlBleComponentException {
        IAlBLEConfig iAlBLEConfig = config;
        if (iAlBLEConfig == null) {
            Intrinsics.throwNpe();
        }
        IAlKeyManagement keyManager = iAlBLEConfig.getKeyManager();
        try {
            AlKeyType alKeyType = AlKeyType.ECC_ECDH_SPEC256R1;
            IAlBLEConfig iAlBLEConfig2 = config;
            if (iAlBLEConfig2 == null) {
                Intrinsics.throwNpe();
            }
            keyManager.generateKey(alKeyType, iAlBLEConfig2.getSessionKeyReference());
            IAlBLEConfig iAlBLEConfig3 = config;
            if (iAlBLEConfig3 == null) {
                Intrinsics.throwNpe();
            }
            return keyManager.getKeyPair(iAlBLEConfig3.getSessionKeyReference());
        } catch (AlSecurityException e) {
            throw new AlBleComponentException("Unable to get session key", e);
        }
    }

    public final void setConfig(@NotNull IAlBLEConfig bleConfig) {
        Intrinsics.checkParameterIsNotNull(bleConfig, "bleConfig");
        Objects.requireNonNull(bleConfig, "BLE config cannot be null");
        Objects.requireNonNull(bleConfig.getKeyManager(), "Key manager not set");
        config = bleConfig;
    }
}
