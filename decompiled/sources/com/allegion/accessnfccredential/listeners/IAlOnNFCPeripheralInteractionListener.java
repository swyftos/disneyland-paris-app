package com.allegion.accessnfccredential.listeners;

import com.rumax.reactnative.pdfviewer.PDFView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/allegion/accessnfccredential/listeners/IAlOnNFCPeripheralInteractionListener;", "", "onConnectPeripheral", "", "onDisconnectPeripheral", "onDoorUnlockFailed", "onDoorUnlocked", "connectionTime", "", "unlockTime", PDFView.EVENT_ON_ERROR, "exception", "Ljava/lang/Exception;", "onSendingCredential", "AccessNFCCredential_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface IAlOnNFCPeripheralInteractionListener {
    void onConnectPeripheral();

    void onDisconnectPeripheral();

    void onDoorUnlockFailed();

    void onDoorUnlocked(long connectionTime, long unlockTime);

    void onError(@NotNull Exception exception);

    void onSendingCredential();
}
