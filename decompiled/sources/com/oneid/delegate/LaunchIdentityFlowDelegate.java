package com.oneid.delegate;

import com.facebook.react.bridge.WritableMap;
import com.oneid.common.EventId;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B?\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/oneid/delegate/LaunchIdentityFlowDelegate;", "Lcom/oneid/delegate/BaseDelegate;", "sendEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "eventName", "Lcom/facebook/react/bridge/WritableMap;", "params", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "dlp-mobile_react-native-oneid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LaunchIdentityFlowDelegate extends BaseDelegate {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LaunchIdentityFlowDelegate(@NotNull Function2<? super String, ? super WritableMap, Unit> sendEvent) {
        super(EventId.LaunchIdentityFlow, sendEvent);
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
    }
}
