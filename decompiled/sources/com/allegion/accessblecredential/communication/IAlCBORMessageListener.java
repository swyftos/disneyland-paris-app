package com.allegion.accessblecredential.communication;

import com.allegion.accessblecredential.exception.AlBleComponentException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/allegion/accessblecredential/communication/IAlCBORMessageListener;", "", "Lcom/allegion/accessblecredential/communication/AlCBORMessage;", "message", "", "onCBORMessageReceived", "(Lcom/allegion/accessblecredential/communication/AlCBORMessage;)V", "Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;", "onTransmissionMessageReceived", "(Lcom/allegion/accessblecredential/communication/AlCBORTransmissionMessage;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlCBORMessageListener {
    void onCBORMessageReceived(@NotNull AlCBORMessage message) throws AlBleComponentException;

    void onTransmissionMessageReceived(@NotNull AlCBORTransmissionMessage message) throws AlBleComponentException;
}
