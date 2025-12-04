package com.facebook.react.shell;

import android.annotation.SuppressLint;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.fbreact.specs.NativeBlobModuleSpec;
import com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec;
import com.facebook.fbreact.specs.NativeFileReaderModuleSpec;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.BaseReactPackage;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.ClassFinder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.devloading.DevLoadingModule;
import com.facebook.react.modules.devtoolsruntimesettings.ReactDevToolsRuntimeSettingsModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.reactdevtoolssettings.ReactDevToolsSettingsManagerModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.sound.SoundManagerModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.safeareaview.ReactSafeAreaViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.unimplementedview.ReactUnimplementedViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0018\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/facebook/react/shell/MainReactPackage;", "Lcom/facebook/react/BaseReactPackage;", "Lcom/facebook/react/ViewManagerOnDemandReactPackage;", "config", "Lcom/facebook/react/shell/MainPackageConfig;", "<init>", "(Lcom/facebook/react/shell/MainPackageConfig;)V", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "name", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "", "Lcom/facebook/react/uimanager/ViewManager;", "viewManagersMap", "", "Lcom/facebook/react/bridge/ModuleSpec;", "getViewManagersMap", "()Ljava/util/Map;", "getViewManagers", "getViewManagerNames", "", "createViewManager", "viewManagerName", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "fallbackForMissingClass", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainReactPackage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainReactPackage.kt\ncom/facebook/react/shell/MainReactPackage\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,273:1\n3829#2:274\n4344#2,2:275\n1187#3,2:277\n1261#3,4:279\n*S KotlinDebug\n*F\n+ 1 MainReactPackage.kt\ncom/facebook/react/shell/MainReactPackage\n*L\n258#1:274\n258#1:275,2\n259#1:277,2\n259#1:279,4\n*E\n"})
/* loaded from: classes3.dex */
public final class MainReactPackage extends BaseReactPackage implements ViewManagerOnDemandReactPackage {

    @Nullable
    private final MainPackageConfig config;

    @SuppressLint({"VisibleForTests"})
    @NotNull
    private final Map<String, ModuleSpec> viewManagersMap;

    @JvmOverloads
    public MainReactPackage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map fallbackForMissingClass$lambda$19(Map map) {
        return map;
    }

    public /* synthetic */ MainReactPackage(MainPackageConfig mainPackageConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mainPackageConfig);
    }

    @JvmOverloads
    public MainReactPackage(@Nullable MainPackageConfig mainPackageConfig) {
        this.config = mainPackageConfig;
        this.viewManagersMap = MapsKt.mapOf(TuplesKt.to(ReactDrawerLayoutManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda1
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$0();
            }
        })), TuplesKt.to(ReactHorizontalScrollViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda9
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$1();
            }
        })), TuplesKt.to(ReactHorizontalScrollContainerViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda10
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$2();
            }
        })), TuplesKt.to(ReactProgressBarViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda11
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$3();
            }
        })), TuplesKt.to(ReactSafeAreaViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda12
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$4();
            }
        })), TuplesKt.to(ReactScrollViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda13
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$5();
            }
        })), TuplesKt.to(ReactSwitchManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda14
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$6();
            }
        })), TuplesKt.to(SwipeRefreshLayoutManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda15
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$7();
            }
        })), TuplesKt.to(FrescoBasedReactTextInlineImageViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda16
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$8();
            }
        })), TuplesKt.to(ReactImageManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda17
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$9();
            }
        })), TuplesKt.to(ReactModalHostManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda2
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$10();
            }
        })), TuplesKt.to(ReactRawTextManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda3
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$11();
            }
        })), TuplesKt.to(ReactTextInputManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda4
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$12();
            }
        })), TuplesKt.to(ReactTextViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda5
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$13();
            }
        })), TuplesKt.to("RCTView", ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda6
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$14();
            }
        })), TuplesKt.to(ReactVirtualTextViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda7
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$15();
            }
        })), TuplesKt.to(ReactUnimplementedViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new Provider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda8
            @Override // javax.inject.Provider
            /* renamed from: get */
            public final Object get2() {
                return MainReactPackage.viewManagersMap$lambda$16();
            }
        })));
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    @Nullable
    public NativeModule getModule(@NotNull String name, @NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        switch (name.hashCode()) {
            case -2115067288:
                if (name.equals("ToastAndroid")) {
                    return new ToastModule(reactContext);
                }
                return null;
            case -1962922905:
                if (name.equals("ImageStoreManager")) {
                    return new ImageStoreManager(reactContext);
                }
                return null;
            case -1850625090:
                if (name.equals("SoundManager")) {
                    return new SoundManagerModule(reactContext);
                }
                return null;
            case -1654566518:
                if (name.equals(NativeDialogManagerAndroidSpec.NAME)) {
                    return new DialogModule(reactContext);
                }
                return null;
            case -1344126773:
                if (name.equals(NativeFileReaderModuleSpec.NAME)) {
                    return new FileReaderModule(reactContext);
                }
                return null;
            case -1067020766:
                if (name.equals("ReactDevToolsRuntimeSettingsModule")) {
                    return new ReactDevToolsRuntimeSettingsModule(reactContext);
                }
                return null;
            case -1062061717:
                if (name.equals("PermissionsAndroid")) {
                    return new PermissionsModule(reactContext);
                }
                return null;
            case -657277650:
                if (name.equals("ImageLoader")) {
                    return new ImageLoaderModule(reactContext);
                }
                return null;
            case -585704955:
                if (name.equals("ReactDevToolsSettingsManager")) {
                    return new ReactDevToolsSettingsManagerModule(reactContext);
                }
                return null;
            case -570370161:
                if (name.equals("I18nManager")) {
                    return new I18nManagerModule(reactContext);
                }
                return null;
            case -504784764:
                if (name.equals("Appearance")) {
                    return new AppearanceModule(reactContext, null, 2, null);
                }
                return null;
            case -457866500:
                if (name.equals("AccessibilityInfo")) {
                    return new AccessibilityInfoModule(reactContext);
                }
                return null;
            case -382654004:
                if (name.equals("StatusBarManager")) {
                    return new StatusBarModule(reactContext);
                }
                return null;
            case -254310125:
                if (name.equals("WebSocketModule")) {
                    return new WebSocketModule(reactContext);
                }
                return null;
            case -99249460:
                if (name.equals("DevLoadingView")) {
                    return new DevLoadingModule(reactContext);
                }
                return null;
            case 163245714:
                if (!name.equals(FrescoModule.NAME)) {
                    return null;
                }
                MainPackageConfig mainPackageConfig = this.config;
                return new FrescoModule(reactContext, true, mainPackageConfig != null ? mainPackageConfig.getFrescoConfig() : null);
            case 403570038:
                if (name.equals("Clipboard")) {
                    return new ClipboardModule(reactContext);
                }
                return null;
            case 563961875:
                if (name.equals("IntentAndroid")) {
                    return new IntentModule(reactContext);
                }
                return null;
            case 1221389072:
                if (name.equals("AppState")) {
                    return new AppStateModule(reactContext);
                }
                return null;
            case 1515242260:
                if (name.equals(NativeNetworkingAndroidSpec.NAME)) {
                    return new NetworkingModule(reactContext);
                }
                return null;
            case 1547941001:
                if (name.equals(NativeBlobModuleSpec.NAME)) {
                    return new BlobModule(reactContext);
                }
                return null;
            case 1555425035:
                if (name.equals("ShareModule")) {
                    return new ShareModule(reactContext);
                }
                return null;
            case 1721274886:
                if (name.equals(NativeAnimatedModuleSpec.NAME)) {
                    return new NativeAnimatedModule(reactContext);
                }
                return null;
            case 1922110066:
                if (name.equals("Vibration")) {
                    return new VibrationModule(reactContext);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    @NotNull
    public List<ViewManager<?, ?>> createViewManagers(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.listOf((Object[]) new ViewManager[]{new ReactDrawerLayoutManager(), new ReactHorizontalScrollViewManager(), new ReactHorizontalScrollContainerViewManager(), new ReactProgressBarViewManager(), new ReactScrollViewManager(), new ReactSwitchManager(), new ReactSafeAreaViewManager(), new SwipeRefreshLayoutManager(), new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null), new ReactImageManager(null, null, null, 7, null), new ReactModalHostManager(), new ReactRawTextManager(), new ReactTextInputManager(), new ReactTextViewManager(), new ReactViewManager(), new ReactVirtualTextViewManager(), new ReactUnimplementedViewManager()});
    }

    @NotNull
    public final Map<String, ModuleSpec> getViewManagersMap() {
        return this.viewManagersMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$0() {
        return new ReactDrawerLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$1() {
        return new ReactHorizontalScrollViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$2() {
        return new ReactHorizontalScrollContainerViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$3() {
        return new ReactProgressBarViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$4() {
        return new ReactSafeAreaViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$5() {
        return new ReactScrollViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$6() {
        return new ReactSwitchManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$7() {
        return new SwipeRefreshLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$8() {
        return new FrescoBasedReactTextInlineImageViewManager(null, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$9() {
        return new ReactImageManager(null, null, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$10() {
        return new ReactModalHostManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$11() {
        return new ReactRawTextManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$12() {
        return new ReactTextInputManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$13() {
        return new ReactTextViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$14() {
        return new ReactViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$15() {
        return new ReactVirtualTextViewManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NativeModule viewManagersMap$lambda$16() {
        return new ReactUnimplementedViewManager();
    }

    @Override // com.facebook.react.BaseReactPackage
    @NotNull
    public List<ModuleSpec> getViewManagers(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.toList(this.viewManagersMap.values());
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    @NotNull
    public Collection<String> getViewManagerNames(@NotNull ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return this.viewManagersMap.keySet();
    }

    @Override // com.facebook.react.ViewManagerOnDemandReactPackage
    @Nullable
    public ViewManager<?, ?> createViewManager(@NotNull ReactApplicationContext reactContext, @NotNull String viewManagerName) {
        Provider<? extends NativeModule> provider;
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(viewManagerName, "viewManagerName");
        ModuleSpec moduleSpec = this.viewManagersMap.get(viewManagerName);
        NativeModule nativeModule = (moduleSpec == null || (provider = moduleSpec.getProvider()) == null) ? null : provider.get2();
        if (nativeModule instanceof ViewManager) {
            return (ViewManager) nativeModule;
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    @NotNull
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        if (!ClassFinder.canLoadClassesFromAnnotationProcessors()) {
            return fallbackForMissingClass();
        }
        try {
            Class<?> clsFindClass = ClassFinder.findClass("com.facebook.react.shell.MainReactPackage$$ReactModuleInfoProvider");
            Object objNewInstance = clsFindClass != null ? clsFindClass.newInstance() : null;
            ReactModuleInfoProvider reactModuleInfoProvider = objNewInstance instanceof ReactModuleInfoProvider ? (ReactModuleInfoProvider) objNewInstance : null;
            return reactModuleInfoProvider == null ? fallbackForMissingClass() : reactModuleInfoProvider;
        } catch (ClassNotFoundException unused) {
            return fallbackForMissingClass();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for MainReactPackage$$ReactModuleInfoProvider", e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for MainReactPackage$$ReactModuleInfoProvider", e2);
        }
    }

    private final ReactModuleInfoProvider fallbackForMissingClass() {
        Class[] clsArr = {AccessibilityInfoModule.class, AppearanceModule.class, AppStateModule.class, BlobModule.class, DevLoadingModule.class, FileReaderModule.class, ClipboardModule.class, DialogModule.class, FrescoModule.class, I18nManagerModule.class, ImageLoaderModule.class, ImageStoreManager.class, IntentModule.class, NativeAnimatedModule.class, NetworkingModule.class, PermissionsModule.class, ReactDevToolsSettingsManagerModule.class, ReactDevToolsRuntimeSettingsModule.class, ShareModule.class, StatusBarModule.class, SoundManagerModule.class, ToastModule.class, VibrationModule.class, WebSocketModule.class};
        ArrayList<Class<?>> arrayList = new ArrayList();
        for (int i = 0; i < 24; i++) {
            Class cls = clsArr[i];
            if (cls.isAnnotationPresent(ReactModule.class)) {
                arrayList.add(cls);
            }
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Class<?> cls2 : arrayList) {
            Annotation annotation = cls2.getAnnotation(ReactModule.class);
            if (annotation == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ReactModule reactModule = (ReactModule) annotation;
            String strName = reactModule.name();
            String strName2 = reactModule.name();
            String name = cls2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Pair pair = TuplesKt.to(strName, new ReactModuleInfo(strName2, name, reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), ReactModuleInfo.INSTANCE.classIsTurboModule(cls2)));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return new ReactModuleInfoProvider() { // from class: com.facebook.react.shell.MainReactPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return MainReactPackage.fallbackForMissingClass$lambda$19(linkedHashMap);
            }
        };
    }
}
