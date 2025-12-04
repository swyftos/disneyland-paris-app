package com.allegion.accesssdk.actions;

import android.content.Context;
import com.allegion.accessblecredential.ble.CredentialBLEDevice;
import com.allegion.accessblecredential.controllers.AlBLEController;
import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlDeviceException;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.models.AlDeviceSearchResponse;
import com.allegion.core.exception.BleException;
import com.allegion.logging.AlLog;
import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
class AlDeviceSearchService implements IAlDeviceSearchService {
    private AlBLEController bleController;
    private ReplaySubject<AlDeviceSearchResponse> scanResults;
    private ReentrantLock lock = new ReentrantLock();
    private AtomicReference<WeakReference<Context>> context = new AtomicReference<>(new WeakReference(null));

    AlDeviceSearchService() {
    }

    @Override // com.allegion.accesssdk.actions.IAlDeviceSearchService
    public Observable<AlDeviceSearchResponse> startScanner(int i) {
        this.lock.lock();
        try {
            IAlSdkConfiguration config = AlSdkConfiguration.getConfig();
            if (this.scanResults != null && this.context.get().get() == config.getContext()) {
                return this.scanResults.publish().refCount();
            }
            this.scanResults = ReplaySubject.create();
            this.context = new AtomicReference<>(new WeakReference(config.getContext()));
            Context context = config.getContext();
            final ReplaySubject<AlDeviceSearchResponse> replaySubject = this.scanResults;
            final AtomicReference<WeakReference<Context>> atomicReference = this.context;
            AlBLEController alBLEController = new AlBLEController(context, new AlBLEController.IBleControllerListener() { // from class: com.allegion.accesssdk.actions.AlDeviceSearchService.1
                @Override // com.allegion.accessblecredential.controllers.AlBLEController.IBleControllerListener
                public void onError(@NotNull BleException bleException) {
                    replaySubject.onError(new AlException(AlErrorCode.SEARCH_FAILED_TO_START, "Unable to start scan", "", bleException));
                }

                @Override // com.allegion.accessblecredential.controllers.AlBLEController.IBleControllerListener
                public void onNewDeviceFound(CredentialBLEDevice credentialBLEDevice) {
                    Context context2 = (Context) ((WeakReference) atomicReference.get()).get();
                    if (credentialBLEDevice == null || context2 == null) {
                        return;
                    }
                    try {
                        replaySubject.onNext(new AlDeviceSearchResponse(new AlPlatinumDevice(credentialBLEDevice)));
                    } catch (AlDeviceException e) {
                        AlLog.d(e, "Unable to create platinum device", new Object[0]);
                    }
                }

                @Override // com.allegion.accessblecredential.controllers.AlBLEController.IBleControllerListener
                public void onScanningStateChanged(boolean z) {
                    if (z) {
                        return;
                    }
                    replaySubject.onComplete();
                    atomicReference.set(new WeakReference(null));
                }
            });
            this.bleController = alBLEController;
            if (i > 0) {
                alBLEController.startScanner(i);
            } else {
                alBLEController.startScanner();
            }
            return this.scanResults.publish().refCount();
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.allegion.accesssdk.actions.IAlDeviceSearchService
    public void stopScanner() {
        AlBLEController alBLEController = this.bleController;
        if (alBLEController != null) {
            alBLEController.stopScanner();
        }
    }
}
