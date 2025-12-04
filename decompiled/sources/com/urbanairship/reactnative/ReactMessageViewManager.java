package com.urbanairship.reactnative;

import android.content.Context;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNAirshipMessageViewManagerInterface;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0017J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\u0017H\u0016R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/urbanairship/reactnative/ReactMessageViewManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/urbanairship/reactnative/ReactMessageView;", "Lcom/facebook/react/viewmanagers/RNAirshipMessageViewManagerInterface;", "<init>", "()V", "delegate", "com/urbanairship/reactnative/ReactMessageViewManager$delegate$1", "Lcom/urbanairship/reactnative/ReactMessageViewManager$delegate$1;", "getName", "", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", "messageView", "setMessageId", "view", Constants.FirelogAnalytics.PARAM_MESSAGE_ID, "getExportedCustomBubblingEventTypeConstants", "", "", "Companion", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactMessageViewManager extends SimpleViewManager<ReactMessageView> implements RNAirshipMessageViewManagerInterface<ReactMessageView> {

    @NotNull
    public static final String REACT_CLASS = "RNAirshipMessageView";

    @NotNull
    private final ReactMessageViewManager$delegate$1 delegate = new ViewManagerDelegate<ReactMessageView>() { // from class: com.urbanairship.reactnative.ReactMessageViewManager$delegate$1
        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        /* renamed from: receiveCommand, reason: merged with bridge method [inline-methods] */
        public void kotlinCompat$receiveCommand(ReactMessageView view, String commandName, ReadableArray args) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(commandName, "commandName");
        }

        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        /* renamed from: setProperty, reason: merged with bridge method [inline-methods] */
        public void kotlinCompat$setProperty(ReactMessageView view, String propName, Object value) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(propName, "propName");
            if (Intrinsics.areEqual(propName, Constants.FirelogAnalytics.PARAM_MESSAGE_ID)) {
                this.this$0.setMessageId(view, value instanceof String ? (String) value : null);
            }
        }
    };

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    protected ViewManagerDelegate<ReactMessageView> getDelegate() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactMessageView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ReactMessageView reactMessageView = new ReactMessageView(reactContext);
        reactContext.addLifecycleEventListener(reactMessageView);
        return reactMessageView;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull ReactMessageView messageView) {
        Intrinsics.checkNotNullParameter(messageView, "messageView");
        super.onDropViewInstance((ReactMessageViewManager) messageView);
        Context context = messageView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.uimanager.ThemedReactContext");
        ((ThemedReactContext) context).removeLifecycleEventListener(messageView);
        messageView.cleanup();
    }

    @Override // com.facebook.react.viewmanagers.RNAirshipMessageViewManagerInterface
    @ReactProp(name = Constants.FirelogAnalytics.PARAM_MESSAGE_ID)
    public void setMessageId(@NotNull ReactMessageView view, @Nullable String messageId) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (messageId != null) {
            view.loadMessage(messageId);
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        List<Pair> listListOf = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("topClose", "onClose"), TuplesKt.to(ReactMessageView.EVENT_LOAD_ERROR_REGISTRATION_NAME, ReactMessageView.EVENT_LOAD_ERROR_HANDLER_NAME), TuplesKt.to(ReactMessageView.EVENT_LOAD_FINISHED_REGISTRATION_NAME, ReactMessageView.EVENT_LOAD_FINISHED_HANDLER_NAME), TuplesKt.to(ReactMessageView.EVENT_LOAD_STARTED_REGISTRATION_NAME, ReactMessageView.EVENT_LOAD_STARTED_HANDLER_NAME)});
        MapBuilder.Builder builder = MapBuilder.builder();
        Intrinsics.checkNotNullExpressionValue(builder, "builder(...)");
        for (Pair pair : listListOf) {
            builder.put((String) pair.component1(), MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", (String) pair.component2())));
        }
        Map<String, Object> mapBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(mapBuild, "build(...)");
        return mapBuild;
    }
}
