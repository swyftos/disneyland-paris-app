package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.enums.AlErrorCode;
import com.allegion.accesssdk.exceptions.AlAlreadyEnrolledException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.interfaces.IAlEnrollmentManager;
import com.allegion.accesssdk.listeners.IAlListener;
import com.allegion.accesssdk.models.AlEnrollDeviceRequest;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import com.allegion.accesssdk.utilities.Constants;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public class AlEnrollmentManager implements IAlEnrollmentManager, Disposable {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private Consumer<AlEnrollDeviceResponse> onEnrollDeviceSuccess = Functions.emptyConsumer();
    private Consumer<Throwable> onEnrollDeviceError = Functions.ON_ERROR_MISSING;

    /* JADX INFO: Access modifiers changed from: private */
    public SingleSource lambda$enrollDevice$0(AlEnrollDeviceRequest alEnrollDeviceRequest) throws Exception {
        AlImmutableEnrollmentRequest alImmutableEnrollmentRequest = new AlImmutableEnrollmentRequest(alEnrollDeviceRequest);
        if (isEnrolled().booleanValue()) {
            throw new AlAlreadyEnrolledException();
        }
        return AlSdkConfiguration.getActionProvider().getEnrollmentActionFactory().create(alImmutableEnrollmentRequest).run((IAlActionSingleExecution<AlImmutableEnrollmentRequest, AlEnrollDeviceResponse>) alImmutableEnrollmentRequest);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.compositeDisposable.dispose();
    }

    @Override // com.allegion.accesssdk.interfaces.IAlEnrollmentManager
    public void enrollDevice(final AlEnrollDeviceRequest alEnrollDeviceRequest) {
        AlObjects.requireNonNull(alEnrollDeviceRequest, "Request must not be null");
        this.compositeDisposable.add(Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlEnrollmentManager$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$enrollDevice$0(alEnrollDeviceRequest);
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe(this.onEnrollDeviceSuccess, this.onEnrollDeviceError));
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.compositeDisposable.isDisposed();
    }

    public Boolean isEnrolled() {
        return Boolean.valueOf(((IAlStorageService) AlObjects.requireNonNull((IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class), "Storage service must not be null", AlErrorCode.SDK_NULL_VALUE_ERROR)).contains(Constants.URI_ENROLL));
    }

    @Override // com.allegion.accesssdk.interfaces.IAlEnrollmentManager
    public void setEnrollDeviceListener(@Nullable final IAlListener<AlEnrollDeviceResponse> iAlListener) {
        this.onEnrollDeviceSuccess = iAlListener == null ? Functions.emptyConsumer() : new Consumer() { // from class: com.allegion.accesssdk.actions.AlEnrollmentManager$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                iAlListener.onSuccess((AlEnrollDeviceResponse) obj);
            }
        };
        this.onEnrollDeviceError = iAlListener == null ? Functions.ON_ERROR_MISSING : new AlEnrollmentManager$$ExternalSyntheticLambda1(iAlListener);
    }

    @Override // com.allegion.accesssdk.interfaces.IAlEnrollmentManager
    public void setEnrollDeviceListener(@Nullable final IAlListener.Success<AlEnrollDeviceResponse> success, @Nullable IAlListener.Error<Throwable> error) {
        this.onEnrollDeviceSuccess = success == null ? Functions.emptyConsumer() : new Consumer() { // from class: com.allegion.accesssdk.actions.AlEnrollmentManager$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                success.onSuccess((AlEnrollDeviceResponse) obj);
            }
        };
        this.onEnrollDeviceError = error == null ? Functions.ON_ERROR_MISSING : new AlEnrollmentManager$$ExternalSyntheticLambda3(error);
    }
}
