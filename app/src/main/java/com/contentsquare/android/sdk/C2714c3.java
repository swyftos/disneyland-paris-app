package com.contentsquare.android.sdk;

import android.content.Context;
import com.contentsquare.android.ErrorAnalysisModule;
import com.contentsquare.android.core.communication.HeapInterface;
import com.contentsquare.android.core.communication.StartableModule;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.error.analysis.internal.ErrorAnalysisLibraryInterfaceImpl;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.c3 */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nModuleStarter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleStarter.kt\ncom/contentsquare/android/internal/features/initialize/ModuleStarter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,110:1\n63#1:111\n800#2,11:112\n1855#2,2:123\n800#2,11:125\n*S KotlinDebug\n*F\n+ 1 ModuleStarter.kt\ncom/contentsquare/android/internal/features/initialize/ModuleStarter\n*L\n36#1:111\n36#1:112,11\n50#1:123,2\n63#1:125,11\n*E\n"})
public final class C2714c3 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public static final Logger f2438a = new Logger("ModuleStarter");

    /* JADX INFO: renamed from: b */
    @NotNull
    public static final ArrayList f2439b = new ArrayList();

    /* JADX INFO: renamed from: c */
    @NotNull
    public static final Lazy f2440c = LazyKt.lazy(a.f2442a);

    /* JADX INFO: renamed from: d */
    @NotNull
    public static final Lazy f2441d = LazyKt.lazy(b.f2443a);

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c3$a */
    public static final class a extends Lambda implements Function0<ComposeInterface> {

        /* JADX INFO: renamed from: a */
        public static final a f2442a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ComposeInterface invoke() {
            Logger logger = C2714c3.f2438a;
            ComposeInterface composeInterface = null;
            try {
                composeInterface = (ComposeInterface) Class.forName("com.contentsquare.android.ComposeModule").asSubclass(ComposeInterface.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                C2714c3.f2438a.m827d("Loading module failed: " + e);
            }
            C2714c3.f2438a.m827d(composeInterface + " loaded and started");
            return composeInterface;
        }
    }

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.c3$b */
    public static final class b extends Lambda implements Function0<HeapInterface> {

        /* JADX INFO: renamed from: a */
        public static final b f2443a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final HeapInterface invoke() {
            HeapInterface heapInterface;
            Logger logger = C2714c3.f2438a;
            try {
                Class<?> heapClass = Class.forName("io.heap.core.Heap");
                Intrinsics.checkNotNullExpressionValue(heapClass, "heapClass");
                heapInterface = new HeapInterface(heapClass, C2724d3.f2495a);
            } catch (Exception e) {
                C2714c3.f2438a.m827d("Loading Heap module failed: " + e);
                heapInterface = null;
            }
            if (heapInterface == null) {
                return null;
            }
            C2714c3.f2438a.m827d("Heap Detected and loaded: " + heapInterface);
            return heapInterface;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public static final ComposeInterface m1108a() {
        return (ComposeInterface) f2440c.getValue();
    }

    @JvmStatic
    /* JADX INFO: renamed from: a */
    public static final void m1109a(@NotNull Context context) {
        StartableModule startableModule;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        for (StartableModule startableModule2 : f2439b) {
            startableModule2.stop(context);
            f2438a.m827d(startableModule2 + " stopped");
        }
        f2439b.clear();
        try {
            startableModule = (StartableModule) ErrorAnalysisModule.class.asSubclass(StartableModule.class).getConstructor(ErrorAnalysisLibraryInterface.class).newInstance(new ErrorAnalysisLibraryInterfaceImpl());
        } catch (Exception e) {
            f2438a.m827d("Loading module failed: " + e);
            startableModule = null;
        }
        if (startableModule != null) {
            startableModule.start(context);
            f2439b.add(startableModule);
            f2438a.m827d(startableModule + " loaded and started");
        }
    }
}
