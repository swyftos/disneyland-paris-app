package expo.modules.adapters.react;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;
import expo.modules.core.interfaces.DoNotStrip;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\nH\u0082 J\u001c\u0010\f\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0082 ¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0004R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lexpo/modules/adapters/react/FabricComponentsRegistry;", "", "viewManagerList", "", "Lcom/facebook/react/uimanager/ViewManager;", "<init>", "(Ljava/util/List;)V", "componentNames", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "registerComponentsRegistry", "", "", "([Ljava/lang/String;)V", "finalize", "Companion", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
@SourceDebugExtension({"SMAP\nFabricComponentsRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FabricComponentsRegistry.kt\nexpo/modules/adapters/react/FabricComponentsRegistry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,36:1\n1557#2:37\n1628#2,3:38\n37#3,2:41\n*S KotlinDebug\n*F\n+ 1 FabricComponentsRegistry.kt\nexpo/modules/adapters/react/FabricComponentsRegistry\n*L\n13#1:37\n13#1:38,3\n19#1:41,2\n*E\n"})
public final class FabricComponentsRegistry {
    private final List componentNames;

    @DoNotStrip
    @NotNull
    private final HybridData mHybridData;

    private final native HybridData initHybrid();

    private final native void registerComponentsRegistry(String[] componentNames);

    public FabricComponentsRegistry(@NotNull List<? extends ViewManager<?, ?>> viewManagerList) {
        Intrinsics.checkNotNullParameter(viewManagerList, "viewManagerList");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(viewManagerList, 10));
        Iterator<T> it = viewManagerList.iterator();
        while (it.hasNext()) {
            arrayList.add(((ViewManager) it.next()).getName());
        }
        this.componentNames = arrayList;
        this.mHybridData = initHybrid();
        registerComponentsRegistry((String[]) arrayList.toArray(new String[0]));
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}
