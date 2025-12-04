package com.allegion.accesssdk.actions;

import android.util.Pair;
import com.allegion.accesssdk.exceptions.AlException;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.models.AlAuthenticationResponse;
import com.allegion.accesssdk.models.AlEnrollDeviceResponse;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import java.io.Serializable;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class AlAnalyticsDecorator<Q, P extends Serializable> implements IAlActionSingleExecution<Q, P> {
    private final IAlActionSingleExecution<Q, P> action;
    private final IAlAnalyticsService analyticsService = (IAlAnalyticsService) AlObjects.requireNonNull((IAlAnalyticsService) AlSdkConfiguration.getServiceProvider().locateService(IAlAnalyticsService.class), "Analytics service must not be null");

    AlAnalyticsDecorator(IAlActionSingleExecution<Q, P> iAlActionSingleExecution) {
        this.action = (IAlActionSingleExecution) AlObjects.requireNonNull(iAlActionSingleExecution, "Action must not be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SingleSource lambda$run$0(Object obj) throws Exception {
        return this.action.run((IAlActionSingleExecution<Q, P>) obj).doOnSuccess(new Consumer() { // from class: com.allegion.accesssdk.actions.AlAnalyticsDecorator$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                this.f$0.trackSuccess((Serializable) obj2);
            }
        }).doOnError(new Consumer() { // from class: com.allegion.accesssdk.actions.AlAnalyticsDecorator$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                this.f$0.trackFail((Throwable) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackFail(Throwable th) {
        IAlActionSingleExecution<Q, P> iAlActionSingleExecution = this.action;
        if (iAlActionSingleExecution instanceof AlEnrollmentAction) {
            this.analyticsService.trackFail("Enrollment ", "Enrolled", new Pair("Error", th.getMessage()));
            return;
        }
        if (iAlActionSingleExecution instanceof AlPayloadsPullAction) {
            this.analyticsService.trackFail("Rights Manager ", "Pull Payloads", new Pair("Error", th.getMessage()));
            return;
        }
        if (iAlActionSingleExecution instanceof AlRightsPullAction) {
            this.analyticsService.trackFail("Rights Manager ", "Pull Rights ", new Pair("Error", th.getMessage()));
        } else if (iAlActionSingleExecution instanceof AlAuthenticationAction) {
            this.analyticsService.trackFail("Authentication ", "Authenticated", new Pair("Error", th.getMessage()));
        } else {
            this.analyticsService.trackEvent("Unknown ", "Response Error", new Pair("Error", th.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackSuccess(Object obj) {
        if (obj instanceof AlEnrollDeviceResponse) {
            this.analyticsService.trackSuccess("Enrollment ", "Enrolled", new Pair("Response", obj.getClass().getSimpleName()));
            return;
        }
        if (obj instanceof AlPullRightsResponse) {
            this.analyticsService.trackSuccess("Rights Manager ", "Pull Rights ", new Pair("Response", obj.getClass().getSimpleName()));
            return;
        }
        if (obj instanceof AlPullPayloadsResponse) {
            this.analyticsService.trackSuccess("Rights Manager ", "Pull Payloads", new Pair("Response", obj.getClass().getSimpleName()));
        } else if (obj instanceof AlAuthenticationResponse) {
            this.analyticsService.trackSuccess("Authentication ", "Authenticated", new Pair("Response", obj.getClass().getSimpleName()));
        } else {
            this.analyticsService.trackEvent("Unknown ", "Response", new Pair("Response", obj.getClass().getSimpleName()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.allegion.accesssdk.actions.interfaces.IAlAction
    public /* bridge */ /* synthetic */ Object run(Object obj) throws AlException {
        return run((AlAnalyticsDecorator<Q, P>) obj);
    }

    @Override // com.allegion.accesssdk.actions.IAlActionSingleExecution, com.allegion.accesssdk.actions.interfaces.IAlAction
    public Single<P> run(final Q q) {
        return Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlAnalyticsDecorator$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$run$0(q);
            }
        });
    }
}
