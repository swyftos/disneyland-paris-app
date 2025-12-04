package com.allegion.accesshub.interfaces;

import com.allegion.alsecurity.interfaces.IAlKeyManagement;
import com.allegion.alsecurity.interfaces.IAlSecureStorage;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR2\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0014j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/allegion/accesshub/interfaces/IAlConfig;", "", "Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "getKeyManagement", "()Lcom/allegion/alsecurity/interfaces/IAlKeyManagement;", "keyManagement", "Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "getStorage", "()Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "storage", "Ljava/util/UUID;", "getDeviceId", "()Ljava/util/UUID;", "deviceId", "", "getDeviceKeyReference", "()Ljava/lang/String;", "deviceKeyReference", "getSubscriptionKey", "subscriptionKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getPinSet", "()Ljava/util/HashMap;", "pinSet", "AccessHub_prodRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlConfig {
    @NotNull
    UUID getDeviceId();

    @NotNull
    String getDeviceKeyReference();

    @NotNull
    IAlKeyManagement getKeyManagement();

    @NotNull
    HashMap<String, String> getPinSet();

    @NotNull
    IAlSecureStorage getStorage();

    @NotNull
    UUID getSubscriptionKey();
}
