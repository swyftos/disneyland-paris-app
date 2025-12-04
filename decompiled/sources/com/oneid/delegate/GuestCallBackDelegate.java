package com.oneid.delegate;

import android.util.Log;
import com.disney.id.android.Guest;
import com.disney.id.android.GuestCallbackData;
import com.disney.id.android.OneID;
import com.disney.id.android.OneIDCallback;
import com.disney.id.android.OneIDError;
import com.disney.id.android.Profile;
import com.disney.id.android.Token;
import com.disney.id.android.TokenCallbackData;
import com.disney.id.android.lightbox.LightboxActivity;
import com.facebook.react.bridge.WritableMap;
import com.oneid.common.ConstantsKt;
import com.oneid.common.EventId;
import com.oneid.common.ExtensionsKt;
import com.oneid.model.EventResult;
import com.oneid.model.EventType;
import com.rumax.reactnative.pdfviewer.PDFView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u001f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00126\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\f\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014\u0012\u001c\u0010\u0016\u001a\u0018\u0012\f\u0012\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u0018\u0012\f\u0012\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018\u0012\u0004\u0012\u00020\n\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0002X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 ¨\u0006$"}, d2 = {"Lcom/oneid/delegate/GuestCallBackDelegate;", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/GuestCallbackData;", LightboxActivity.EVENT_ID_EXTRA, "Lcom/oneid/common/EventId;", "sinkEventNeeded", "", "serverUpdate", "retryGetSession", "Lkotlin/Function0;", "", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lcom/facebook/react/bridge/WritableMap;", "params", "callback", "Lkotlin/Function1;", "Lcom/oneid/model/EventResult;", PDFView.EVENT_ON_ERROR, "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Lcom/oneid/common/EventId;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "guestData", "handleError", "errorCode", "tokenCallback", "com/oneid/delegate/GuestCallBackDelegate$tokenCallback$1", "Lcom/oneid/delegate/GuestCallBackDelegate$tokenCallback$1;", "onSuccess", "data", "onFailure", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GuestCallBackDelegate implements OneIDCallback<GuestCallbackData> {
    private final Function1 callback;
    private EventId eventId;
    private GuestCallbackData guestData;
    private final Function1 onError;
    private final Function0 retryGetSession;
    private final Function2 sendEvent;
    private boolean serverUpdate;
    private boolean sinkEventNeeded;
    private final GuestCallBackDelegate$tokenCallback$1 tokenCallback;

    /* JADX WARN: Type inference failed for: r2v1, types: [com.oneid.delegate.GuestCallBackDelegate$tokenCallback$1] */
    public GuestCallBackDelegate(@NotNull EventId eventId, boolean z, boolean z2, @NotNull Function0<Unit> retryGetSession, @NotNull Function2<? super String, ? super WritableMap, Unit> sendEvent, @Nullable Function1<? super EventResult, Unit> function1, @Nullable Function1<? super Exception, Unit> function12) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(retryGetSession, "retryGetSession");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.eventId = eventId;
        this.sinkEventNeeded = z;
        this.serverUpdate = z2;
        this.retryGetSession = retryGetSession;
        this.sendEvent = sendEvent;
        this.callback = function1;
        this.onError = function12;
        this.tokenCallback = new OneIDCallback<TokenCallbackData>() { // from class: com.oneid.delegate.GuestCallBackDelegate$tokenCallback$1
            @Override // com.disney.id.android.OneIDCallback
            public void onFailure(TokenCallbackData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                GuestCallBackDelegate guestCallBackDelegate = this.this$0;
                OneIDError error = data.getError();
                guestCallBackDelegate.handleError(error != null ? error.getCode() : null);
            }

            @Override // com.disney.id.android.OneIDCallback
            public void onSuccess(TokenCallbackData data) {
                Profile profile;
                Intrinsics.checkNotNullParameter(data, "data");
                Log.d(ConstantsKt.ONEID_TAG, "onSuccess Token");
                EventType eventType = EventType.Login;
                EventId eventId2 = this.this$0.eventId;
                GuestCallbackData guestCallbackData = this.this$0.guestData;
                if (guestCallbackData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guestData");
                    guestCallbackData = null;
                }
                Guest guest = guestCallbackData.getGuest();
                Map<?, ?> map = (guest == null || (profile = guest.getProfile()) == null) ? null : ExtensionsKt.toMap(profile);
                Token token = data.getToken();
                EventResult eventResult = new EventResult(eventType, eventId2, map, token != null ? ExtensionsKt.toMap(token) : null);
                if (this.this$0.sinkEventNeeded) {
                    this.this$0.sendEvent.invoke(ConstantsKt.ON_LOGIN, eventResult.serialize());
                }
                Function1 function13 = this.this$0.callback;
                if (function13 != null) {
                    function13.invoke(eventResult);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(String errorCode) {
        Log.d(ConstantsKt.ONEID_TAG, "onFailure data");
        if (errorCode != null && errorCode.equals("NO_CONNECTION") && this.serverUpdate) {
            this.retryGetSession.invoke();
            return;
        }
        EventResult eventResult = new EventResult(EventType.Logout, this.eventId, null, null, 12, null);
        if (this.sinkEventNeeded) {
            this.sendEvent.invoke(ConstantsKt.ON_LOGOUT, eventResult.serialize());
        }
        Function1 function1 = this.callback;
        if (function1 != null) {
            function1.invoke(eventResult);
        }
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onSuccess(@NotNull GuestCallbackData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d(ConstantsKt.ONEID_TAG, "onSuccess data");
        this.guestData = data;
        OneID.getToken$default(OneID.INSTANCE.shared(), this.tokenCallback, null, this.serverUpdate, 2, null);
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onFailure(@NotNull GuestCallbackData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        OneIDError error = data.getError();
        handleError(error != null ? error.getCode() : null);
    }
}
