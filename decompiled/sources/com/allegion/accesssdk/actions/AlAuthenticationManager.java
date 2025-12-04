package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.interfaces.IAlAuthenticationManager;
import com.allegion.accesssdk.listeners.IAlListener;
import com.allegion.accesssdk.models.AlAuthenticationRequest;
import com.allegion.accesssdk.models.AlAuthenticationResponse;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.rumax.reactnative.pdfviewer.PDFView;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u000b\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R:\u0010\u001a\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00100\u0010 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u00180\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/allegion/accesssdk/actions/AlAuthenticationManager;", "Lcom/allegion/accesssdk/interfaces/IAlAuthenticationManager;", "", "Lcom/allegion/accesssdk/models/AlAuthenticationRequest;", "authenticationRequest", "", "validateSecret", "(Lcom/allegion/accesssdk/models/AlAuthenticationRequest;)V", "Lcom/allegion/accesssdk/listeners/IAlListener;", "Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAuthenticationListener", "(Lcom/allegion/accesssdk/listeners/IAlListener;)V", "Lcom/allegion/accesssdk/listeners/IAlListener$Success;", "onSuccess", "Lcom/allegion/accesssdk/listeners/IAlListener$Error;", "", PDFView.EVENT_ON_ERROR, "(Lcom/allegion/accesssdk/listeners/IAlListener$Success;Lcom/allegion/accesssdk/listeners/IAlListener$Error;)V", "dispose", "()V", "", "isDisposed", "()Z", "Lio/reactivex/functions/Consumer;", "kotlin.jvm.PlatformType", "onAuthenticationError", "Lio/reactivex/functions/Consumer;", "onAuthenticationSuccess", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "(Lio/reactivex/disposables/CompositeDisposable;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlAuthenticationManager implements IAlAuthenticationManager, Disposable {
    private final CompositeDisposable compositeDisposable;
    private Consumer<Throwable> onAuthenticationError;
    private Consumer<AlAuthenticationResponse> onAuthenticationSuccess;

    public AlAuthenticationManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AlAuthenticationManager(@NotNull CompositeDisposable compositeDisposable) {
        Intrinsics.checkParameterIsNotNull(compositeDisposable, "compositeDisposable");
        this.compositeDisposable = compositeDisposable;
        Consumer<AlAuthenticationResponse> consumerEmptyConsumer = Functions.emptyConsumer();
        Intrinsics.checkExpressionValueIsNotNull(consumerEmptyConsumer, "Functions.emptyConsumer()");
        this.onAuthenticationSuccess = consumerEmptyConsumer;
        this.onAuthenticationError = Functions.ON_ERROR_MISSING;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.compositeDisposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.compositeDisposable.isDisposed();
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAuthenticationManager
    public void setAuthenticationListener(@Nullable final IAlListener<AlAuthenticationResponse> listener) {
        Consumer<AlAuthenticationResponse> consumerEmptyConsumer;
        if (listener == null) {
            consumerEmptyConsumer = Functions.emptyConsumer();
            Intrinsics.checkExpressionValueIsNotNull(consumerEmptyConsumer, "Functions.emptyConsumer()");
        } else {
            consumerEmptyConsumer = new Consumer<AlAuthenticationResponse>() { // from class: com.allegion.accesssdk.actions.AlAuthenticationManager.setAuthenticationListener.1
                @Override // io.reactivex.functions.Consumer
                public void accept(AlAuthenticationResponse alAuthenticationResponse) {
                    AlAuthenticationResponse alAuthenticationResponse2 = alAuthenticationResponse;
                    IAlListener iAlListener = listener;
                    if (alAuthenticationResponse2 == null) {
                        Intrinsics.throwNpe();
                    }
                    iAlListener.onSuccess(alAuthenticationResponse2);
                }
            };
        }
        this.onAuthenticationSuccess = consumerEmptyConsumer;
        this.onAuthenticationError = listener == null ? Functions.ON_ERROR_MISSING : new Consumer<Throwable>() { // from class: com.allegion.accesssdk.actions.AlAuthenticationManager.setAuthenticationListener.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                IAlListener iAlListener = listener;
                if (th2 == null) {
                    Intrinsics.throwNpe();
                }
                iAlListener.onError(th2);
            }
        };
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAuthenticationManager
    public void validateSecret(@NotNull final AlAuthenticationRequest authenticationRequest) {
        Intrinsics.checkParameterIsNotNull(authenticationRequest, "authenticationRequest");
        Disposable disposableSubscribe = Single.defer(new Callable() { // from class: com.allegion.accesssdk.actions.AlAuthenticationManager$validateSecret$cancelSubscription$1
            @Override // java.util.concurrent.Callable
            public Object call() {
                AlAuthenticationRequest alAuthenticationRequest = authenticationRequest;
                AlImmutableAuthenticationRequest alImmutableAuthenticationRequest = new AlImmutableAuthenticationRequest(alAuthenticationRequest.getInviteId(), alAuthenticationRequest.getInviteSecret(), alAuthenticationRequest.getSubscriptionKey(), alAuthenticationRequest.getIgnoreCache());
                Intrinsics.checkExpressionValueIsNotNull(alImmutableAuthenticationRequest, "AlImmutableProvider.build(authenticationRequest)");
                AlActionProvider actionProvider = AlSdkConfiguration.getActionProvider();
                Intrinsics.checkExpressionValueIsNotNull(actionProvider, "AlSdkConfiguration.getActionProvider()");
                return actionProvider.getAuthenticationActionFactory().create(alImmutableAuthenticationRequest).run((IAlActionSingleExecution<AlImmutableAuthenticationRequest, AlAuthenticationResponse>) alImmutableAuthenticationRequest);
            }
        }).subscribeOn(Schedulers.io()).observeOn(Schedulers.single()).subscribe(this.onAuthenticationSuccess, this.onAuthenticationError);
        Intrinsics.checkExpressionValueIsNotNull(disposableSubscribe, "Single.defer {\n         …s, onAuthenticationError)");
        this.compositeDisposable.add(disposableSubscribe);
    }

    public /* synthetic */ AlAuthenticationManager(CompositeDisposable compositeDisposable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new CompositeDisposable() : compositeDisposable);
    }

    @Override // com.allegion.accesssdk.interfaces.IAlAuthenticationManager
    public void setAuthenticationListener(@Nullable final IAlListener.Success<AlAuthenticationResponse> onSuccess, @Nullable final IAlListener.Error<Throwable> onError) {
        Consumer<AlAuthenticationResponse> consumerEmptyConsumer;
        if (onSuccess == null) {
            consumerEmptyConsumer = Functions.emptyConsumer();
            Intrinsics.checkExpressionValueIsNotNull(consumerEmptyConsumer, "Functions.emptyConsumer()");
        } else {
            consumerEmptyConsumer = new Consumer<AlAuthenticationResponse>() { // from class: com.allegion.accesssdk.actions.AlAuthenticationManager.setAuthenticationListener.3
                @Override // io.reactivex.functions.Consumer
                public void accept(AlAuthenticationResponse alAuthenticationResponse) {
                    AlAuthenticationResponse alAuthenticationResponse2 = alAuthenticationResponse;
                    IAlListener.Success success = onSuccess;
                    if (alAuthenticationResponse2 == null) {
                        Intrinsics.throwNpe();
                    }
                    success.onSuccess(alAuthenticationResponse2);
                }
            };
        }
        this.onAuthenticationSuccess = consumerEmptyConsumer;
        this.onAuthenticationError = onError == null ? Functions.ON_ERROR_MISSING : new Consumer<Throwable>() { // from class: com.allegion.accesssdk.actions.AlAuthenticationManager.setAuthenticationListener.4
            @Override // io.reactivex.functions.Consumer
            public void accept(Throwable th) {
                Throwable th2 = th;
                IAlListener.Error error = onError;
                if (th2 == null) {
                    Intrinsics.throwNpe();
                }
                error.onError(th2);
            }
        };
    }
}
