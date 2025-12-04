package com.allegion.accessnfccredential.communication;

import android.content.Context;
import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.alsecurity.interfaces.IAlSecureStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/allegion/accessnfccredential/communication/IAlNFCConfig;", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "deviceKeyReference", "", "getDeviceKeyReference", "()Ljava/lang/String;", "diversifiedKeyInputReference", "getDiversifiedKeyInputReference", "diversifiedKeyReference", "getDiversifiedKeyReference", "keyManager", "Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "getKeyManager", "()Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "secureStorage", "Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "getSecureStorage", "()Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "sessionKeyReference", "getSessionKeyReference", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlNFCConfig {
    @NotNull
    Context getContext();

    @NotNull
    String getDeviceKeyReference();

    @NotNull
    String getDiversifiedKeyInputReference();

    @NotNull
    String getDiversifiedKeyReference();

    @NotNull
    IAlKeyManagement getKeyManager();

    @NotNull
    IAlSecureStorage getSecureStorage();

    @NotNull
    String getSessionKeyReference();
}
