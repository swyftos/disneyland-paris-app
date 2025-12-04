package com.allegion.accesssdk.interfaces;

import com.allegion.accesssdk.listeners.IAlListener;
import com.allegion.accesssdk.models.AlAuthenticationRequest;
import com.allegion.accesssdk.models.AlAuthenticationResponse;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.rumax.reactnative.pdfviewer.PDFView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\n\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&¢\u0006\u0004\b\n\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/allegion/accesssdk/interfaces/IAlAuthenticationManager;", "", "Lcom/allegion/accesssdk/models/AlAuthenticationRequest;", "authenticationRequest", "", "validateSecret", "(Lcom/allegion/accesssdk/models/AlAuthenticationRequest;)V", "Lcom/allegion/accesssdk/listeners/IAlListener;", "Lcom/allegion/accesssdk/models/AlAuthenticationResponse;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAuthenticationListener", "(Lcom/allegion/accesssdk/listeners/IAlListener;)V", "Lcom/allegion/accesssdk/listeners/IAlListener$Success;", "onSuccess", "Lcom/allegion/accesssdk/listeners/IAlListener$Error;", "", PDFView.EVENT_ON_ERROR, "(Lcom/allegion/accesssdk/listeners/IAlListener$Success;Lcom/allegion/accesssdk/listeners/IAlListener$Error;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public interface IAlAuthenticationManager {
    void setAuthenticationListener(@Nullable IAlListener.Success<AlAuthenticationResponse> onSuccess, @Nullable IAlListener.Error<Throwable> onError);

    void setAuthenticationListener(@Nullable IAlListener<AlAuthenticationResponse> listener);

    void validateSecret(@NotNull AlAuthenticationRequest authenticationRequest);
}
