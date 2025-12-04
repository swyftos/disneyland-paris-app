package com.oneid.delegate;

import com.disney.id.android.GuestCallbackData;
import com.disney.id.android.NotInitialized;
import com.disney.id.android.OneID;
import com.disney.id.android.OneIDCallback;
import com.disney.id.android.OneIDError;
import com.disney.id.android.lightbox.LightboxActivity;
import com.facebook.react.bridge.WritableMap;
import com.oneid.common.EventId;
import com.oneid.model.EventResult;
import com.oneid.model.EventType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/oneid/delegate/BaseDelegate;", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/GuestCallbackData;", LightboxActivity.EVENT_ID_EXTRA, "Lcom/oneid/common/EventId;", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lcom/facebook/react/bridge/WritableMap;", "params", "", "<init>", "(Lcom/oneid/common/EventId;Lkotlin/jvm/functions/Function2;)V", "tokenDelegate", "Lcom/oneid/delegate/TokenDelegate;", "onSuccess", "data", "onFailure", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BaseDelegate implements OneIDCallback<GuestCallbackData> {
    private final EventId eventId;
    private final Function2 sendEvent;
    private TokenDelegate tokenDelegate;

    public BaseDelegate(@NotNull EventId eventId, @NotNull Function2<? super String, ? super WritableMap, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.eventId = eventId;
        this.sendEvent = sendEvent;
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onSuccess(@NotNull GuestCallbackData data) throws NotInitialized {
        Intrinsics.checkNotNullParameter(data, "data");
        this.tokenDelegate = new TokenDelegate(data, this.eventId, this.sendEvent);
        OneID oneIDShared = OneID.INSTANCE.shared();
        TokenDelegate tokenDelegate = this.tokenDelegate;
        if (tokenDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenDelegate");
            tokenDelegate = null;
        }
        OneID.getToken$default(oneIDShared, tokenDelegate, null, false, 6, null);
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onFailure(@NotNull GuestCallbackData data) {
        String code;
        Intrinsics.checkNotNullParameter(data, "data");
        OneIDError error = data.getError();
        if (error == null || (code = error.getCode()) == null || !code.equals("USER_CANCELLED")) {
            return;
        }
        this.sendEvent.invoke("onClose", new EventResult(EventType.Close, this.eventId, null, null, 12, null).serialize());
    }
}
