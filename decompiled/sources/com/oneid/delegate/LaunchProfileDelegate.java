package com.oneid.delegate;

import com.disney.id.android.OneID;
import com.disney.id.android.OneIDCallback;
import com.disney.id.android.OneIDError;
import com.disney.id.android.UpdateProfileCallbackData;
import com.facebook.react.bridge.WritableMap;
import com.oneid.common.ConstantsKt;
import com.oneid.common.EventId;
import com.oneid.model.EventResult;
import com.oneid.model.EventType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u008f\u0001\u0012N\u0010\u0003\u001aJ\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0004\u0012\u00020\n0\u0004\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0002H\u0016RV\u0010\u0003\u001aJ\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\f\u0012\n\u0018\u00010\bj\u0004\u0018\u0001`\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/oneid/delegate/LaunchProfileDelegate;", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/UpdateProfileCallbackData;", "getSessionCallback", "Lkotlin/reflect/KFunction5;", "", "Lcom/oneid/common/EventId;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "Lcom/oneid/model/EventResult;", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lcom/facebook/react/bridge/WritableMap;", "params", "<init>", "(Lkotlin/reflect/KFunction;Lkotlin/jvm/functions/Function2;)V", "onSuccess", "data", "onFailure", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LaunchProfileDelegate implements OneIDCallback<UpdateProfileCallbackData> {
    private final KFunction getSessionCallback;
    private final Function2 sendEvent;

    public LaunchProfileDelegate(@NotNull KFunction<Unit> getSessionCallback, @NotNull Function2<? super String, ? super WritableMap, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(getSessionCallback, "getSessionCallback");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.getSessionCallback = getSessionCallback;
        this.sendEvent = sendEvent;
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onSuccess(@NotNull UpdateProfileCallbackData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ((Function5) this.getSessionCallback).invoke(Boolean.TRUE, Boolean.FALSE, EventId.LaunchProfile, null, null);
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onFailure(@NotNull UpdateProfileCallbackData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        OneIDError error = data.getError();
        if (Intrinsics.areEqual(error != null ? error.getCode() : null, "USER_CANCELLED")) {
            this.sendEvent.invoke("onClose", new EventResult(EventType.Close, EventId.LaunchProfile, null, null, 12, null).serialize());
            return;
        }
        OneIDError error2 = data.getError();
        if (!Intrinsics.areEqual(error2 != null ? error2.getCode() : null, OneIDError.USER_LOGGED_OUT)) {
            OneIDError error3 = data.getError();
            if (!Intrinsics.areEqual(error3 != null ? error3.getCode() : null, OneIDError.GUEST_MISSING)) {
                return;
            }
        }
        OneID.logout$default(OneID.INSTANCE.shared(), null, 1, null);
        this.sendEvent.invoke(ConstantsKt.ON_LOGOUT, new EventResult(EventType.Logout, EventId.LaunchProfile, null, null, 12, null).serialize());
    }
}
