package com.allegion.accessblecredential.listeners;

import com.rumax.reactnative.pdfviewer.PDFView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/allegion/accessblecredential/listeners/IOnPeripheralInteractionListener;", "", "", "connectionTime", "unlockTime", "", "onDoorUnlocked", "(JJ)V", "onDataSuccess", "()V", "onDoorUnlockFailed", "onDataFailure", "onConnectPeripheral", "onSendingCredential", "onDisconnectPeripheral", "Ljava/lang/Exception;", "exception", PDFView.EVENT_ON_ERROR, "(Ljava/lang/Exception;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IOnPeripheralInteractionListener {
    void onConnectPeripheral();

    void onDataFailure();

    void onDataSuccess();

    void onDisconnectPeripheral();

    void onDoorUnlockFailed();

    void onDoorUnlocked(long connectionTime, long unlockTime);

    void onError(@NotNull Exception exception);

    void onSendingCredential();
}
