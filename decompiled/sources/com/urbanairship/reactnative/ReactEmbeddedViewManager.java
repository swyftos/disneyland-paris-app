package com.urbanairship.reactnative;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNAirshipEmbeddedViewManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0017R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/urbanairship/reactnative/ReactEmbeddedViewManager;", "Lcom/facebook/react/uimanager/SimpleViewManager;", "Lcom/urbanairship/reactnative/ReactEmbeddedView;", "Lcom/facebook/react/viewmanagers/RNAirshipEmbeddedViewManagerInterface;", "<init>", "()V", "manualDelegate", "com/urbanairship/reactnative/ReactEmbeddedViewManager$manualDelegate$1", "Lcom/urbanairship/reactnative/ReactEmbeddedViewManager$manualDelegate$1;", "getName", "", "getDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setEmbeddedId", "", "view", "embeddedId", "Companion", "ua_react-native-airship_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactEmbeddedViewManager extends SimpleViewManager<ReactEmbeddedView> implements RNAirshipEmbeddedViewManagerInterface<ReactEmbeddedView> {

    @NotNull
    public static final String REACT_CLASS = "RNAirshipEmbeddedView";

    @NotNull
    private final ReactEmbeddedViewManager$manualDelegate$1 manualDelegate = new ViewManagerDelegate<ReactEmbeddedView>() { // from class: com.urbanairship.reactnative.ReactEmbeddedViewManager$manualDelegate$1
        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        /* renamed from: receiveCommand, reason: merged with bridge method [inline-methods] */
        public void kotlinCompat$receiveCommand(ReactEmbeddedView view, String commandName, ReadableArray args) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(commandName, "commandName");
        }

        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        /* renamed from: setProperty, reason: merged with bridge method [inline-methods] */
        public void kotlinCompat$setProperty(ReactEmbeddedView view, String propName, Object value) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(propName, "propName");
            if (Intrinsics.areEqual(propName, "embeddedId")) {
                this.this$0.setEmbeddedId(view, value instanceof String ? (String) value : null);
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
    protected ViewManagerDelegate<ReactEmbeddedView> getDelegate() {
        return this.manualDelegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactEmbeddedView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ReactEmbeddedView(reactContext);
    }

    @Override // com.facebook.react.viewmanagers.RNAirshipEmbeddedViewManagerInterface
    @ReactProp(name = "embeddedId")
    public void setEmbeddedId(@NotNull ReactEmbeddedView view, @Nullable String embeddedId) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (embeddedId != null) {
            view.load(embeddedId);
        }
    }
}
