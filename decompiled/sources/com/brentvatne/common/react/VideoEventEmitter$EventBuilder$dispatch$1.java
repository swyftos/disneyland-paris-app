package com.brentvatne.common.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0015\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\u0014¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"com/brentvatne/common/react/VideoEventEmitter$EventBuilder$dispatch$1", "Lcom/facebook/react/uimanager/events/Event;", "getEventName", "", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "kotlin.jvm.PlatformType", "()Lcom/facebook/react/bridge/WritableMap;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VideoEventEmitter$EventBuilder$dispatch$1 extends Event<Event<?>> {
    final /* synthetic */ EventTypes $event;
    final /* synthetic */ Function1 $paramsSetter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoEventEmitter$EventBuilder$dispatch$1(EventTypes eventTypes, Function1 function1, int i, int i2) {
        super(i, i2);
        this.$event = eventTypes;
        this.$paramsSetter = function1;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return ViewProps.TOP + StringsKt.removePrefix(this.$event.getEventName(), (CharSequence) "on");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEventData$lambda$0(WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(writableMap, "<this>");
        return Unit.INSTANCE;
    }

    @Override // com.facebook.react.uimanager.events.Event
    /* renamed from: getEventData */
    protected WritableMap getData() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Function1 function1 = this.$paramsSetter;
        if (function1 == null) {
            function1 = new Function1() { // from class: com.brentvatne.common.react.VideoEventEmitter$EventBuilder$dispatch$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return VideoEventEmitter$EventBuilder$dispatch$1.getEventData$lambda$0((WritableMap) obj);
                }
            };
        }
        function1.invoke(writableMapCreateMap);
        return writableMapCreateMap;
    }
}
