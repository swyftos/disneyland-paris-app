package com.allegion.logging.filelogging.s3upload;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.dlp.BluetoothManager;
import com.rumax.reactnative.pdfviewer.PDFView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/allegion/logging/filelogging/s3upload/AlTransferListener;", "", PDFView.EVENT_ON_ERROR, "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", BluetoothManager.BLE_STATUS_PARAM, "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface AlTransferListener {
    void onError(int id, @Nullable Exception ex);

    void onProgressChanged(int id, long bytesCurrent, long bytesTotal);

    void onStateChanged(int id, @Nullable TransferState state);
}
