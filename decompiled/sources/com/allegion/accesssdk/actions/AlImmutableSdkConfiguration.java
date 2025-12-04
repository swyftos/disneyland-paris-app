package com.allegion.accesssdk.actions;

import android.content.Context;
import android.util.Pair;
import com.allegion.accessblecredential.communication.IAlBLEConfig;
import com.allegion.accessnfccredential.communication.IAlNFCConfig;
import com.allegion.accesssdk.actions.AlMutableSdkConfiguration;
import com.allegion.accesssdk.enums.IAlSdkEnvironment;
import com.allegion.accesssdk.exceptions.AlPublicKeyExportException;
import com.allegion.alsecurity.enums.AlKeyType;
import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.alsecurity.interfaces.IAlSecureStorage;
import com.allegion.logging.AlLog;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BW\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u00106\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\bE\u0010FJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR(\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001d\u00100\u001a\u00020)8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010+R\u001c\u00102\u001a\u0002018\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001c\u00106\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b7\u0010\fR\u001c\u00109\u001a\u0002088\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020\u001b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u001fR\u001d\u0010D\u001a\u00020%8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010.\u001a\u0004\bC\u0010'¨\u0006G"}, d2 = {"Lcom/allegion/accesssdk/actions/AlImmutableSdkConfiguration;", "Lcom/allegion/accesssdk/actions/IAlSdkConfiguration;", "Lcom/allegion/accessblecredential/communication/IAlBLEConfig;", "Lcom/allegion/accessnfccredential/communication/IAlNFCConfig;", "", "pullAndExportKeyPair", "()[B", "exportEccDevicePublicKeyUncompressed", "", "deviceKeyReference", "Ljava/lang/String;", "getDeviceKeyReference", "()Ljava/lang/String;", "sessionKeyReference", "getSessionKeyReference", "diversifiedKeyInputReference", "getDiversifiedKeyInputReference", "Lcom/allegion/accesssdk/actions/AlMutableSdkConfiguration$KeyManagementFactory;", "keyManagementFactory", "Lcom/allegion/accesssdk/actions/AlMutableSdkConfiguration$KeyManagementFactory;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/allegion/accesssdk/actions/IAlAnalyticsService;", "analyticsService", "Lcom/allegion/accesssdk/actions/IAlAnalyticsService;", "Ljava/util/UUID;", "deviceId", "Ljava/util/UUID;", "getDeviceId", "()Ljava/util/UUID;", "Ljava/util/HashMap;", "pinSet", "Ljava/util/HashMap;", "getPinSet", "()Ljava/util/HashMap;", "Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "getKeyManager", "()Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "keyManager", "Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "getSecureStorage", "()Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "secureStorage", "storage$delegate", "Lkotlin/Lazy;", "getStorage", "storage", "Lcom/allegion/accesssdk/actions/AlImmutableConfig;", "userConfig", "Lcom/allegion/accesssdk/actions/AlImmutableConfig;", "getUserConfig", "()Lcom/allegion/accesssdk/actions/AlImmutableConfig;", "diversifiedKeyReference", "getDiversifiedKeyReference", "Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "environment", "Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "getEnvironment", "()Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;", "Lcom/allegion/accesssdk/actions/AlMutableSdkConfiguration$SecureStorageFactory;", "storageFactory", "Lcom/allegion/accesssdk/actions/AlMutableSdkConfiguration$SecureStorageFactory;", "getSubscriptionKey", "subscriptionKey", "keyManagement$delegate", "getKeyManagement", "keyManagement", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Lcom/allegion/accesssdk/actions/AlMutableSdkConfiguration$KeyManagementFactory;Lcom/allegion/accesssdk/actions/AlMutableSdkConfiguration$SecureStorageFactory;Lcom/allegion/accesssdk/enums/IAlSdkEnvironment;Lcom/allegion/accesssdk/actions/AlImmutableConfig;Lcom/allegion/accesssdk/actions/IAlAnalyticsService;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlImmutableSdkConfiguration implements IAlSdkConfiguration, IAlBLEConfig, IAlNFCConfig {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AlImmutableSdkConfiguration.class), "keyManagement", "getKeyManagement()Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AlImmutableSdkConfiguration.class), "storage", "getStorage()Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;"))};
    private final IAlAnalyticsService analyticsService;

    @NotNull
    private final UUID deviceId;

    @NotNull
    private final String deviceKeyReference;

    @NotNull
    private final String diversifiedKeyInputReference;

    @NotNull
    private final String diversifiedKeyReference;

    @NotNull
    private final IAlSdkEnvironment environment;

    /* renamed from: keyManagement$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy keyManagement;
    private final AlMutableSdkConfiguration.KeyManagementFactory keyManagementFactory;

    @NotNull
    private final HashMap<String, String> pinSet;

    @NotNull
    private final String sessionKeyReference;

    /* renamed from: storage$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy storage;
    private final AlMutableSdkConfiguration.SecureStorageFactory storageFactory;

    @NotNull
    private final AlImmutableConfig userConfig;

    public AlImmutableSdkConfiguration(@NotNull String deviceKeyReference, @NotNull String sessionKeyReference, @NotNull String diversifiedKeyReference, @NotNull String diversifiedKeyInputReference, @NotNull UUID deviceId, @NotNull AlMutableSdkConfiguration.KeyManagementFactory keyManagementFactory, @NotNull AlMutableSdkConfiguration.SecureStorageFactory storageFactory, @NotNull IAlSdkEnvironment environment, @NotNull AlImmutableConfig userConfig, @NotNull IAlAnalyticsService analyticsService) {
        Intrinsics.checkParameterIsNotNull(deviceKeyReference, "deviceKeyReference");
        Intrinsics.checkParameterIsNotNull(sessionKeyReference, "sessionKeyReference");
        Intrinsics.checkParameterIsNotNull(diversifiedKeyReference, "diversifiedKeyReference");
        Intrinsics.checkParameterIsNotNull(diversifiedKeyInputReference, "diversifiedKeyInputReference");
        Intrinsics.checkParameterIsNotNull(deviceId, "deviceId");
        Intrinsics.checkParameterIsNotNull(keyManagementFactory, "keyManagementFactory");
        Intrinsics.checkParameterIsNotNull(storageFactory, "storageFactory");
        Intrinsics.checkParameterIsNotNull(environment, "environment");
        Intrinsics.checkParameterIsNotNull(userConfig, "userConfig");
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        this.deviceKeyReference = deviceKeyReference;
        this.sessionKeyReference = sessionKeyReference;
        this.diversifiedKeyReference = diversifiedKeyReference;
        this.diversifiedKeyInputReference = diversifiedKeyInputReference;
        this.deviceId = deviceId;
        this.keyManagementFactory = keyManagementFactory;
        this.storageFactory = storageFactory;
        this.environment = environment;
        this.userConfig = userConfig;
        this.analyticsService = analyticsService;
        this.keyManagement = LazyKt.lazy(new Function0<IAlKeyManagement>() { // from class: com.allegion.accesssdk.actions.AlImmutableSdkConfiguration$keyManagement$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public IAlKeyManagement invoke() {
                return this.this$0.keyManagementFactory.create(this.this$0.getContext(), false);
            }
        });
        this.storage = LazyKt.lazy(new Function0<IAlSecureStorage>() { // from class: com.allegion.accesssdk.actions.AlImmutableSdkConfiguration$storage$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public IAlSecureStorage invoke() {
                return this.this$0.storageFactory.create(this.this$0.getContext());
            }
        });
        this.pinSet = getUserConfig().getPinSet();
    }

    private final byte[] pullAndExportKeyPair() throws AlSecurityException {
        PublicKey publicKey = getKeyManagement().getKeyPair(getDeviceKeyReference()).getPublic();
        if (publicKey == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        }
        return getKeyManagement().exportPublicKeyX963Uncompressed((ECPublicKey) publicKey);
    }

    @Override // com.allegion.accesssdk.actions.IAlSdkConfiguration
    @NotNull
    public byte[] exportEccDevicePublicKeyUncompressed() throws AlPublicKeyExportException {
        try {
            return pullAndExportKeyPair();
        } catch (AlSecurityException e) {
            this.analyticsService.trackFail("ECC Public Key", "Export ECC Public Key.", new Pair("Error", e.getMessage()));
            AlLog.e(e);
            for (int i = 0; i < 3; i++) {
                try {
                    this.getKeyManagement().generateKey(AlKeyType.ECC_ECDSA_SPEC256R1, this.getDeviceKeyReference());
                    return this.pullAndExportKeyPair();
                } catch (AlSecurityException e2) {
                    this.analyticsService.trackFail("ECC Public Key", "Generate and export ECC Public Key.", new Pair("Error", e2.getMessage()));
                    AlLog.e(e2);
                }
            }
            throw new AlPublicKeyExportException(null, null, null, null, null, 31, null);
        }
    }

    @Override // com.allegion.accesssdk.actions.IAlSdkConfiguration, com.allegion.accessblecredential.communication.IAlBLEConfig, com.allegion.accessnfccredential.communication.IAlNFCConfig
    @NotNull
    public Context getContext() {
        Context applicationContext = getUserConfig().getApplication().getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "userConfig.application.applicationContext");
        return applicationContext;
    }

    @Override // com.allegion.accesshub.interfaces.IAlConfig
    @NotNull
    public UUID getDeviceId() {
        return this.deviceId;
    }

    @Override // com.allegion.accesshub.interfaces.IAlConfig, com.allegion.accessblecredential.communication.IAlBLEConfig, com.allegion.accessnfccredential.communication.IAlNFCConfig
    @NotNull
    public String getDeviceKeyReference() {
        return this.deviceKeyReference;
    }

    @Override // com.allegion.accessnfccredential.communication.IAlNFCConfig
    @NotNull
    public String getDiversifiedKeyInputReference() {
        return this.diversifiedKeyInputReference;
    }

    @Override // com.allegion.accessnfccredential.communication.IAlNFCConfig
    @NotNull
    public String getDiversifiedKeyReference() {
        return this.diversifiedKeyReference;
    }

    @Override // com.allegion.accesssdk.actions.IAlSdkConfiguration
    @NotNull
    public IAlSdkEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.allegion.accesshub.interfaces.IAlConfig
    @NotNull
    public IAlKeyManagement getKeyManagement() {
        Lazy lazy = this.keyManagement;
        KProperty kProperty = $$delegatedProperties[0];
        return (IAlKeyManagement) lazy.getValue();
    }

    @Override // com.allegion.accessblecredential.communication.IAlBLEConfig, com.allegion.accessnfccredential.communication.IAlNFCConfig
    @NotNull
    public IAlKeyManagement getKeyManager() {
        return getKeyManagement();
    }

    @Override // com.allegion.accesshub.interfaces.IAlConfig
    @NotNull
    public HashMap<String, String> getPinSet() {
        return this.pinSet;
    }

    @Override // com.allegion.accessblecredential.communication.IAlBLEConfig, com.allegion.accessnfccredential.communication.IAlNFCConfig
    @NotNull
    public IAlSecureStorage getSecureStorage() {
        return getStorage();
    }

    @Override // com.allegion.accessblecredential.communication.IAlBLEConfig, com.allegion.accessnfccredential.communication.IAlNFCConfig
    @NotNull
    public String getSessionKeyReference() {
        return this.sessionKeyReference;
    }

    @Override // com.allegion.accesshub.interfaces.IAlConfig
    @NotNull
    public IAlSecureStorage getStorage() {
        Lazy lazy = this.storage;
        KProperty kProperty = $$delegatedProperties[1];
        return (IAlSecureStorage) lazy.getValue();
    }

    @Override // com.allegion.accesshub.interfaces.IAlConfig
    @NotNull
    public UUID getSubscriptionKey() {
        return getUserConfig().getSubscriptionKey();
    }

    @Override // com.allegion.accesssdk.actions.IAlSdkConfiguration
    @NotNull
    public AlImmutableConfig getUserConfig() {
        return this.userConfig;
    }
}
