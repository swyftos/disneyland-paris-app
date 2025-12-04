package com.allegion.accesssdk.actions;

import android.util.Pair;
import com.allegion.accesssdk.enums.AlDeviceType;
import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.exceptions.AlRuntimeException;
import com.allegion.accesssdk.interfaces.IAlDeviceSearchUtility;
import com.allegion.accesssdk.listeners.IAlDeviceSearchListener;
import com.allegion.accesssdk.models.AlDeviceSearchRequest;
import com.allegion.accesssdk.models.AlDeviceSearchResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class AlDeviceSearchUtility implements IAlDeviceSearchUtility, Disposable {
    private IAlDeviceSearchListener listener;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Consumer<AlDeviceSearchResponse> onDeviceSearchSuccess = Functions.emptyConsumer();
    private Consumer<Throwable> onDeviceSearchError = Functions.ON_ERROR_MISSING;
    private Action onDeviceSearchComplete = Functions.EMPTY_ACTION;
    private Long startScanTime = 0L;
    private Long stopScanTime = 0L;

    /* JADX INFO: Access modifiers changed from: private */
    public ObservableSource lambda$searchForDevices$3(AlDeviceSearchRequest alDeviceSearchRequest) throws Exception {
        AlDeviceSearchAction alDeviceSearchAction = new AlDeviceSearchAction();
        this.startScanTime = Long.valueOf(System.currentTimeMillis());
        IAlDeviceSearchListener iAlDeviceSearchListener = this.listener;
        if (iAlDeviceSearchListener != null) {
            iAlDeviceSearchListener.onScanStateChange(Boolean.TRUE);
        }
        return alDeviceSearchAction.run(new AlImmutableDeviceSearchRequest(alDeviceSearchRequest));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDeviceSearchListener$0(AlDeviceSearchResponse alDeviceSearchResponse) throws Exception {
        this.listener.onAccessDeviceFound(alDeviceSearchResponse.getAccessDevice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDeviceSearchListener$1(Throwable th) throws Exception {
        this.listener.onError(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDeviceSearchListener$2() throws Exception {
        this.listener.onScanStateChange(Boolean.FALSE);
    }

    @Override // com.allegion.accesssdk.interfaces.IAlDeviceSearchUtility
    public void cancelSearch(AlDeviceType[] alDeviceTypeArr) {
        for (AlDeviceType alDeviceType : alDeviceTypeArr) {
            if (alDeviceType != AlDeviceType.BLE_Platinum) {
                throw new AlRuntimeException(AlErrorCode.SEARCH_UNSUPPORTED_DEVICE, "Device type not implemented", "");
            }
            if (AlSdkConfiguration.getServiceProvider().containsService(IAlDeviceSearchService.class)) {
                IAlDeviceSearchService iAlDeviceSearchService = (IAlDeviceSearchService) AlSdkConfiguration.getServiceProvider().locateService(IAlDeviceSearchService.class);
                this.stopScanTime = Long.valueOf(System.currentTimeMillis());
                iAlDeviceSearchService.stopScanner();
                ((IAlAnalyticsService) AlSdkConfiguration.getServiceProvider().locateService(IAlAnalyticsService.class)).trackSuccess("Device Search ", alDeviceType.toString() + " Cancel Search", new Pair("Search Time", Long.toString(this.stopScanTime.longValue() - this.startScanTime.longValue())));
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.compositeDisposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.compositeDisposable.isDisposed();
    }

    public void searchForDevices(final AlDeviceSearchRequest alDeviceSearchRequest) {
        AlObjects.requireNonNull(alDeviceSearchRequest, "Request must not be null");
        for (AlDeviceType alDeviceType : alDeviceSearchRequest.getDeviceTypes()) {
            ((IAlAnalyticsService) AlSdkConfiguration.getServiceProvider().locateService(IAlAnalyticsService.class)).trackSuccess("Device Search ", alDeviceType.toString() + " Device Search", new Pair("Search Time", Long.toString(alDeviceSearchRequest.getSearchTime())));
            if (alDeviceType != AlDeviceType.BLE_Platinum) {
                throw new AlRuntimeException(AlErrorCode.SEARCH_UNSUPPORTED_DEVICE, "Device type not implemented", "");
            }
        }
        this.compositeDisposable.add(Observable.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlDeviceSearchUtility$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$searchForDevices$3(alDeviceSearchRequest);
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe(this.onDeviceSearchSuccess, this.onDeviceSearchError, this.onDeviceSearchComplete));
    }

    @Override // com.allegion.accesssdk.interfaces.IAlDeviceSearchUtility
    public void setDeviceSearchListener(@Nullable IAlDeviceSearchListener iAlDeviceSearchListener) {
        this.listener = iAlDeviceSearchListener;
        this.onDeviceSearchSuccess = iAlDeviceSearchListener == null ? Functions.emptyConsumer() : new Consumer() { // from class: com.allegion.accesssdk.actions.AlDeviceSearchUtility$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$setDeviceSearchListener$0((AlDeviceSearchResponse) obj);
            }
        };
        this.onDeviceSearchError = this.listener == null ? Functions.ON_ERROR_MISSING : new Consumer() { // from class: com.allegion.accesssdk.actions.AlDeviceSearchUtility$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$setDeviceSearchListener$1((Throwable) obj);
            }
        };
        this.onDeviceSearchComplete = this.listener == null ? Functions.EMPTY_ACTION : new Action() { // from class: com.allegion.accesssdk.actions.AlDeviceSearchUtility$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$setDeviceSearchListener$2();
            }
        };
    }

    @Override // com.allegion.accesssdk.interfaces.IAlDeviceSearchUtility
    public void searchForDevices(AlDeviceType[] alDeviceTypeArr, int i) {
        searchForDevices(new AlDeviceSearchRequest().setSearchTime(i).setDeviceTypes(alDeviceTypeArr));
    }
}
