package com.oneid.delegate;

import android.util.Log;
import com.disney.id.android.Guest;
import com.disney.id.android.GuestCallbackData;
import com.disney.id.android.OneIDCallback;
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
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00126\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/oneid/delegate/TokenDelegate;", "Lcom/disney/id/android/OneIDCallback;", "Lcom/disney/id/android/TokenCallbackData;", "guestData", "Lcom/disney/id/android/GuestCallbackData;", LightboxActivity.EVENT_ID_EXTRA, "Lcom/oneid/common/EventId;", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lcom/facebook/react/bridge/WritableMap;", "params", "", "<init>", "(Lcom/disney/id/android/GuestCallbackData;Lcom/oneid/common/EventId;Lkotlin/jvm/functions/Function2;)V", "onSuccess", "data", "onFailure", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TokenDelegate implements OneIDCallback<TokenCallbackData> {
    private final EventId eventId;
    private final GuestCallbackData guestData;
    private final Function2 sendEvent;

    public TokenDelegate(@NotNull GuestCallbackData guestData, @NotNull EventId eventId, @NotNull Function2<? super String, ? super WritableMap, Unit> sendEvent) {
        Intrinsics.checkNotNullParameter(guestData, "guestData");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.guestData = guestData;
        this.eventId = eventId;
        this.sendEvent = sendEvent;
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onSuccess(@NotNull TokenCallbackData data) {
        Profile profile;
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d(ConstantsKt.ONEID_TAG, "onSuccess Token");
        EventType eventType = EventType.Login;
        EventId eventId = this.eventId;
        Guest guest = this.guestData.getGuest();
        Map<?, ?> map = (guest == null || (profile = guest.getProfile()) == null) ? null : ExtensionsKt.toMap(profile);
        Token token = data.getToken();
        this.sendEvent.invoke(ConstantsKt.ON_LOGIN, new EventResult(eventType, eventId, map, token != null ? ExtensionsKt.toMap(token) : null).serialize());
    }

    @Override // com.disney.id.android.OneIDCallback
    public void onFailure(@NotNull TokenCallbackData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d(ConstantsKt.ONEID_TAG, "onFailure token");
        this.sendEvent.invoke(ConstantsKt.ON_LOGOUT, new EventResult(EventType.Logout, this.eventId, null, null, 12, null).serialize());
    }
}
