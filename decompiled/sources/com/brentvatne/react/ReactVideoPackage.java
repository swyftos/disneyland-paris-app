package com.brentvatne.react;

import com.brentvatne.exoplayer.DefaultReactExoplayerConfig;
import com.brentvatne.exoplayer.ReactExoplayerConfig;
import com.brentvatne.exoplayer.ReactExoplayerViewManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u0007J\u001e\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/brentvatne/react/ReactVideoPackage;", "Lcom/facebook/react/ReactPackage;", "config", "Lcom/brentvatne/exoplayer/ReactExoplayerConfig;", "<init>", "(Lcom/brentvatne/exoplayer/ReactExoplayerConfig;)V", "createNativeModules", "", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createJSModules", "Ljava/lang/Class;", "Lcom/facebook/react/bridge/JavaScriptModule;", "createViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ReactVideoPackage implements ReactPackage {
    private final ReactExoplayerConfig config;

    public ReactVideoPackage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ReactVideoPackage(@Nullable ReactExoplayerConfig reactExoplayerConfig) {
        this.config = reactExoplayerConfig;
    }

    public /* synthetic */ ReactVideoPackage(ReactExoplayerConfig reactExoplayerConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : reactExoplayerConfig);
    }

    @Override // com.facebook.react.ReactPackage
    @NotNull
    public List<NativeModule> createNativeModules(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.listOf((Object[]) new ReactContextBaseJavaModule[]{new VideoDecoderInfoModule(reactContext), new VideoManagerModule(reactContext)});
    }

    @NotNull
    public final List<Class<? extends JavaScriptModule>> createJSModules() {
        return CollectionsKt.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    @NotNull
    public List<ViewManager<?, ?>> createViewManagers(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ReactExoplayerConfig defaultReactExoplayerConfig = this.config;
        if (defaultReactExoplayerConfig == null) {
            defaultReactExoplayerConfig = new DefaultReactExoplayerConfig(reactContext);
        }
        return CollectionsKt.listOf(new ReactExoplayerViewManager(defaultReactExoplayerConfig));
    }
}
