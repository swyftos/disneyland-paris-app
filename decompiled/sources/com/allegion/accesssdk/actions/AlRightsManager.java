package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.AuthenticationMAHResponse;
import com.allegion.accesshub.models.CreateAccountMAHResponse;
import com.allegion.accesshub.models.RegisterDeviceMAHResponse;
import com.allegion.accesssdk.actions.AlSdkConfiguration;
import com.allegion.accesssdk.actions.factories.interfaces.Factory;
import com.allegion.accesssdk.enums.AlPayloadType;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.interfaces.IAlRightsManager;
import com.allegion.accesssdk.listeners.IAlListener;
import com.allegion.accesssdk.models.AlPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.models.AlPullRightsRequest;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import com.allegion.accesssdk.models.AlRight;
import com.allegion.accesssdk.models.AlUpdatePayloadsRequest;
import com.allegion.logging.AlLog;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.picocontainer.Characteristics;

/* loaded from: classes2.dex */
public class AlRightsManager implements IAlRightsManager, Disposable {
    private final CompositeDisposable compositeDisposable;
    private Consumer<Throwable> onPullAccessPayloadsError;
    private Consumer<AlPullPayloadsResponse> onPullAccessPayloadsSuccess;
    private Consumer<Throwable> onPullAccessRightsError;
    private Consumer<AlPullRightsResponse> onPullAccessRightsSuccess;
    private final Factory<AlPullPayloadsRequest, AlPullAccessPayloadsCompositeAction> pullPayloadsCompositeActionFactory;

    public AlRightsManager() {
        this(AlSdkConfiguration.getActionProvider().getPullPayloadsCompositeActionFactory());
    }

    static void access$000(AlRightsManager alRightsManager, AlRight[] alRightArr) {
        alRightsManager.getClass();
        AlLog.d("Called with rights: " + Arrays.toString(alRightArr), new Object[0]);
        int length = alRightArr.length;
        for (int i = 0; i < length; i++) {
            AlRight alRight = alRightArr[i];
            IAlStorageService iAlStorageService = (IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class);
            if (iAlStorageService.contains(AlAuthenticationAction.URI_AUTHENTICATE)) {
                AuthenticationMAHResponse authenticationMAHResponse = (AuthenticationMAHResponse) iAlStorageService.retrieve(AlAuthenticationAction.URI_AUTHENTICATE, AuthenticationMAHResponse.class);
                AlPullPayloadsRequest alPullPayloadsRequest = new AlPullPayloadsRequest();
                alPullPayloadsRequest.setAccessToken(authenticationMAHResponse.getCom.disney.id.android.OneIDRecoveryContext.ACCESS_TOKEN java.lang.String());
                alPullPayloadsRequest.setRightId(alRight.getId());
                alPullPayloadsRequest.setIgnoreCache(true);
                AlPayloadType[] payloadTypes = alRight.getPayloadTypes();
                for (AlPayloadType alPayloadType : payloadTypes) {
                    AlPayloadsRequest alPayloadsRequest = new AlPayloadsRequest();
                    alPayloadsRequest.setPayloadType(alPayloadType);
                    alPullPayloadsRequest.addPayloadRequests(alPayloadsRequest);
                }
                AlLog.d("Supported payload types: " + Arrays.toString(payloadTypes), new Object[0]);
                try {
                    alRightsManager.compositeDisposable.add(alRightsManager.pullPayloadsCompositeActionFactory.create(alPullPayloadsRequest).run(alPullPayloadsRequest).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe());
                } catch (AlException e) {
                    AlLog.e(e);
                }
            } else {
                AlLog.d("Not authenticated", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SingleSource lambda$pullAccessRights$0() throws Exception {
        AlImmutableEnrollmentRegisterDeviceRequest alImmutableEnrollmentRegisterDeviceRequest = new AlImmutableEnrollmentRegisterDeviceRequest(false, true);
        return AlSdkConfiguration.getActionProvider().getEnrollmentRegisterDeviceActionFactory().create(alImmutableEnrollmentRegisterDeviceRequest).run((IAlActionSingleExecution<AlImmutableEnrollmentRegisterDeviceRequest, RegisterDeviceMAHResponse>) alImmutableEnrollmentRegisterDeviceRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$pullAccessRights$1(RegisterDeviceMAHResponse registerDeviceMAHResponse, AlMutableSdkConfiguration alMutableSdkConfiguration) {
        alMutableSdkConfiguration.setDeviceId(registerDeviceMAHResponse.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AlImmutableRightsPullRequest lambda$pullAccessRights$2(AlPullRightsRequest alPullRightsRequest, RegisterDeviceMAHResponse registerDeviceMAHResponse, CreateAccountMAHResponse createAccountMAHResponse) throws Exception {
        return new AlImmutableRightsPullRequest(alPullRightsRequest, registerDeviceMAHResponse.getId(), createAccountMAHResponse.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SingleSource lambda$pullAccessRights$3(final AlPullRightsRequest alPullRightsRequest, final RegisterDeviceMAHResponse registerDeviceMAHResponse) throws Exception {
        AlImmutableEnrollmentCreateAccountRequest alImmutableEnrollmentCreateAccountRequest = new AlImmutableEnrollmentCreateAccountRequest(registerDeviceMAHResponse.getId(), false, true);
        AlSdkConfiguration.updateConfig(new AlSdkConfiguration.UpdateWorkingConfig() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda1
            @Override // com.allegion.accesssdk.actions.AlSdkConfiguration.UpdateWorkingConfig
            public final void update(AlMutableSdkConfiguration alMutableSdkConfiguration) {
                AlRightsManager.lambda$pullAccessRights$1(registerDeviceMAHResponse, alMutableSdkConfiguration);
            }
        });
        return AlSdkConfiguration.getActionProvider().getEnrollmentCreateAccountActionFactory().create(alImmutableEnrollmentCreateAccountRequest).run((IAlActionSingleExecution<AlImmutableEnrollmentCreateAccountRequest, CreateAccountMAHResponse>) alImmutableEnrollmentCreateAccountRequest).map(new Function() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AlRightsManager.lambda$pullAccessRights$2(alPullRightsRequest, registerDeviceMAHResponse, (CreateAccountMAHResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SingleSource lambda$pullAccessRights$4(AlImmutableRightsPullRequest alImmutableRightsPullRequest) throws Exception {
        return AlSdkConfiguration.getActionProvider().getRightsPullActionFactory().create(alImmutableRightsPullRequest).run((IAlActionSingleExecution<AlImmutableRightsPullRequest, AlPullRightsResponse>) alImmutableRightsPullRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SingleSource lambda$updateAccessPayloads$5(AlImmutablePayloadsUpdateRequest alImmutablePayloadsUpdateRequest) throws Exception {
        return new AlPayloadsUpdateAction().run(alImmutablePayloadsUpdateRequest);
    }

    public Boolean checkForNoTour(AlRight alRight) {
        return alRight.getAttributes().containsKey("IsNoTourUpdateAvailable") ? Boolean.valueOf(alRight.getAttributes().get("IsNoTourUpdateAvailable").equalsIgnoreCase(Characteristics.TRUE)) : Boolean.FALSE;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.compositeDisposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.compositeDisposable.isDisposed();
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRightsManager
    public void pullAccessPayloads(AlPullPayloadsRequest alPullPayloadsRequest) {
        AlObjects.requireNonNull(alPullPayloadsRequest, "Request must not be null");
        try {
            this.compositeDisposable.add(this.pullPayloadsCompositeActionFactory.create(alPullPayloadsRequest).run(alPullPayloadsRequest).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe(this.onPullAccessPayloadsSuccess, this.onPullAccessPayloadsError));
        } catch (AlException e) {
            AlLog.e(e);
        }
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRightsManager
    public void pullAccessRights(final AlPullRightsRequest alPullRightsRequest) {
        AlObjects.requireNonNull(alPullRightsRequest, "Request must not be null");
        this.compositeDisposable.add(Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AlRightsManager.lambda$pullAccessRights$0();
            }
        }).flatMap(new Function() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AlRightsManager.lambda$pullAccessRights$3(alPullRightsRequest, (RegisterDeviceMAHResponse) obj);
            }
        }).flatMap(new Function() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AlRightsManager.lambda$pullAccessRights$4((AlImmutableRightsPullRequest) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe(this.onPullAccessRightsSuccess, this.onPullAccessRightsError));
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRightsManager
    public void setPullAccessPayloadsListener(@Nullable final IAlListener<AlPullPayloadsResponse> iAlListener) {
        this.onPullAccessPayloadsSuccess = iAlListener == null ? Functions.emptyConsumer() : new Consumer() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                iAlListener.onSuccess((AlPullPayloadsResponse) obj);
            }
        };
        this.onPullAccessPayloadsError = iAlListener == null ? Functions.ON_ERROR_MISSING : new AlEnrollmentManager$$ExternalSyntheticLambda1(iAlListener);
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRightsManager
    public void setPullAccessRightsListener(@Nullable final IAlListener<AlPullRightsResponse> iAlListener) {
        this.onPullAccessRightsSuccess = iAlListener == null ? Functions.emptyConsumer() : new Consumer() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                iAlListener.onSuccess((AlPullRightsResponse) obj);
            }
        };
        this.onPullAccessRightsError = iAlListener == null ? Functions.ON_ERROR_MISSING : new AlEnrollmentManager$$ExternalSyntheticLambda1(iAlListener);
    }

    public void updateAccessPayloads(AlUpdatePayloadsRequest alUpdatePayloadsRequest) {
        AlObjects.requireNonNull(alUpdatePayloadsRequest, "Request must not be null");
        this.compositeDisposable.add(updateAccessPayloads(new AlImmutablePayloadsUpdateRequest(alUpdatePayloadsRequest)).subscribe(this.onPullAccessPayloadsSuccess, this.onPullAccessPayloadsError));
    }

    public void validateAccessRights(final UUID[] uuidArr, final IAlListener<Map<UUID, Boolean>> iAlListener) {
        AlObjects.requireNonNull(uuidArr, "Input rightIds array must not be null");
        AlPullRightsRequest ignoreCache = new AlPullRightsRequest().setIgnoreCache(true);
        setPullAccessRightsListener(new IAlListener<AlPullRightsResponse>() { // from class: com.allegion.accesssdk.actions.AlRightsManager.1
            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onError(Throwable th) {
                AlLog.e(th);
                iAlListener.onError(th);
            }

            @Override // com.allegion.accesssdk.listeners.IAlListener
            public void onSuccess(AlPullRightsResponse alPullRightsResponse) {
                HashMap map = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (AlRight alRight : alPullRightsResponse.getRights()) {
                    if (Arrays.asList(uuidArr).contains(alRight.getId())) {
                        map.put(alRight.getId(), Boolean.TRUE);
                        if (AlRightsManager.this.checkForNoTour(alRight).booleanValue()) {
                            arrayList.add(alRight);
                        }
                    }
                }
                for (UUID uuid : uuidArr) {
                    if (!map.containsKey(uuid)) {
                        map.put(uuid, Boolean.FALSE);
                    }
                }
                AlRightsManager.access$000(AlRightsManager.this, (AlRight[]) arrayList.toArray(new AlRight[arrayList.size()]));
                iAlListener.onSuccess(map);
            }
        });
        pullAccessRights(ignoreCache);
    }

    protected AlRightsManager(Factory<AlPullPayloadsRequest, AlPullAccessPayloadsCompositeAction> factory) {
        this.compositeDisposable = new CompositeDisposable();
        this.onPullAccessRightsSuccess = Functions.emptyConsumer();
        Consumer<Throwable> consumer = Functions.ON_ERROR_MISSING;
        this.onPullAccessRightsError = consumer;
        this.onPullAccessPayloadsSuccess = Functions.emptyConsumer();
        this.onPullAccessPayloadsError = consumer;
        this.pullPayloadsCompositeActionFactory = factory;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRightsManager
    public void setPullAccessPayloadsListener(@Nullable final IAlListener.Success<AlPullPayloadsResponse> success, @Nullable IAlListener.Error<Throwable> error) {
        this.onPullAccessPayloadsSuccess = success == null ? Functions.emptyConsumer() : new Consumer() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                success.onSuccess((AlPullPayloadsResponse) obj);
            }
        };
        this.onPullAccessPayloadsError = error == null ? Functions.ON_ERROR_MISSING : new AlEnrollmentManager$$ExternalSyntheticLambda3(error);
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRightsManager
    public void setPullAccessRightsListener(@Nullable final IAlListener.Success<AlPullRightsResponse> success, @Nullable IAlListener.Error<Throwable> error) {
        this.onPullAccessRightsSuccess = success == null ? Functions.emptyConsumer() : new Consumer() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                success.onSuccess((AlPullRightsResponse) obj);
            }
        };
        this.onPullAccessRightsError = error == null ? Functions.ON_ERROR_MISSING : new AlEnrollmentManager$$ExternalSyntheticLambda3(error);
    }

    Single<AlPullPayloadsResponse> updateAccessPayloads(final AlImmutablePayloadsUpdateRequest alImmutablePayloadsUpdateRequest) {
        return Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlRightsManager$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AlRightsManager.lambda$updateAccessPayloads$5(alImmutablePayloadsUpdateRequest);
            }
        });
    }
}
