package com.brentvatne.react;

import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.exoplayer.DRMManagerSpec;
import com.brentvatne.exoplayer.RNVExoplayerPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0005j\b\u0012\u0004\u0012\u00020\u0001`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/brentvatne/react/ReactNativeVideoManager;", "Lcom/brentvatne/react/RNVPlugin;", "<init>", "()V", "pluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "customDRMManager", "Lcom/brentvatne/exoplayer/DRMManagerSpec;", "instanceList", "", "registerView", "", "newInstance", "unregisterView", "registerPlugin", "plugin", "unregisterPlugin", "onInstanceCreated", "id", "", "player", "onInstanceRemoved", "getDRMManager", "maybeRegisterExoplayerPlugin", "maybeUnregisterExoplayerPlugin", "Companion", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactNativeVideoManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactNativeVideoManager.kt\ncom/brentvatne/react/ReactNativeVideoManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1863#2,2:106\n1863#2,2:108\n*S KotlinDebug\n*F\n+ 1 ReactNativeVideoManager.kt\ncom/brentvatne/react/ReactNativeVideoManager\n*L\n68#1:106,2\n72#1:108,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ReactNativeVideoManager implements RNVPlugin {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static volatile ReactNativeVideoManager instance;
    private DRMManagerSpec customDRMManager;
    private final ArrayList pluginList = new ArrayList();
    private ArrayList instanceList = new ArrayList();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/brentvatne/react/ReactNativeVideoManager$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/brentvatne/react/ReactNativeVideoManager;", "getInstance", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nReactNativeVideoManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactNativeVideoManager.kt\ncom/brentvatne/react/ReactNativeVideoManager$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ReactNativeVideoManager getInstance() {
            ReactNativeVideoManager reactNativeVideoManager = ReactNativeVideoManager.instance;
            if (reactNativeVideoManager == null) {
                synchronized (this) {
                    reactNativeVideoManager = ReactNativeVideoManager.instance;
                    if (reactNativeVideoManager == null) {
                        reactNativeVideoManager = new ReactNativeVideoManager();
                        ReactNativeVideoManager.instance = reactNativeVideoManager;
                    }
                }
            }
            return reactNativeVideoManager;
        }
    }

    public final void registerView(@NotNull Object newInstance) {
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        if (this.instanceList.size() > 2) {
            DebugLog.d("ReactNativeVideoManager", "multiple Video displayed ?");
        }
        this.instanceList.add(newInstance);
    }

    public final void unregisterView(@NotNull Object newInstance) {
        Intrinsics.checkNotNullParameter(newInstance, "newInstance");
        this.instanceList.remove(newInstance);
    }

    public final void registerPlugin(@NotNull RNVPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.pluginList.add(plugin);
        maybeRegisterExoplayerPlugin(plugin);
    }

    public final void unregisterPlugin(@NotNull RNVPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.pluginList.remove(plugin);
        maybeUnregisterExoplayerPlugin(plugin);
    }

    @Override // com.brentvatne.react.RNVPlugin
    public void onInstanceCreated(@NotNull String id, @NotNull Object player) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(player, "player");
        Iterator it = this.pluginList.iterator();
        while (it.hasNext()) {
            ((RNVPlugin) it.next()).onInstanceCreated(id, player);
        }
    }

    @Override // com.brentvatne.react.RNVPlugin
    public void onInstanceRemoved(@NotNull String id, @NotNull Object player) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(player, "player");
        Iterator it = this.pluginList.iterator();
        while (it.hasNext()) {
            ((RNVPlugin) it.next()).onInstanceRemoved(id, player);
        }
    }

    @Nullable
    /* renamed from: getDRMManager, reason: from getter */
    public final DRMManagerSpec getCustomDRMManager() {
        return this.customDRMManager;
    }

    private final void maybeRegisterExoplayerPlugin(RNVPlugin plugin) {
        DRMManagerSpec dRMManager;
        if ((plugin instanceof RNVExoplayerPlugin) && (dRMManager = ((RNVExoplayerPlugin) plugin).getDRMManager()) != null) {
            if (this.customDRMManager != null) {
                DebugLog.w("ReactNativeVideoManager", "Multiple DRM managers registered. This is not supported. Using first registered manager.");
            } else {
                this.customDRMManager = dRMManager;
            }
        }
    }

    private final void maybeUnregisterExoplayerPlugin(RNVPlugin plugin) {
        if ((plugin instanceof RNVExoplayerPlugin) && ((RNVExoplayerPlugin) plugin).getDRMManager() == this.customDRMManager) {
            this.customDRMManager = null;
        }
    }
}
