package com.allegion.accessblecredential.listeners;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u001b\u0010\u000e\u001a\u00020\u00042\n\u0010\r\u001a\u00060\u000bj\u0002`\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/allegion/accessblecredential/listeners/IAlBlePeripheralTransportListener;", "", "", "data", "", "onDataReceived", "([B)V", "onConnection", "()V", "onConnectionFailed", "onDisconnection", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onException", "(Ljava/lang/Exception;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlBlePeripheralTransportListener {
    void onConnection();

    void onConnectionFailed();

    void onDataReceived(@NotNull byte[] data) throws AlBleComponentException;

    void onDisconnection();

    void onException(@NotNull Exception e);
}
