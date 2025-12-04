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
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nModuleStarter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ModuleStarter.kt\ncom/contentsquare/android/internal/features/initialize/ModuleStarter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,110:1\n63#1:111\n800#2,11:112\n1855#2,2:123\n800#2,11:125\n*S KotlinDebug\n*F\n+ 1 ModuleStarter.kt\ncom/contentsquare/android/internal/features/initialize/ModuleStarter\n*L\n36#1:111\n36#1:112,11\n50#1:123,2\n63#1:125,11\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.c3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0644c3 {

    @NotNull
    public static final Logger a = new Logger("ModuleStarter");

    @NotNull
    public static final ArrayList b = new ArrayList();

    @NotNull
    public static final Lazy c = LazyKt.lazy(a.a);

    @NotNull
    public static final Lazy d = LazyKt.lazy(b.a);

    /* renamed from: com.contentsquare.android.sdk.c3$a */
    public static final class a extends Lambda implements Function0<ComposeInterface> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ComposeInterface invoke() {
            Logger logger = C0644c3.a;
            ComposeInterface composeInterface = null;
            try {
                composeInterface = (ComposeInterface) Class.forName("com.contentsquare.android.ComposeModule").asSubclass(ComposeInterface.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                C0644c3.a.d("Loading module failed: " + e);
            }
            C0644c3.a.d(composeInterface + " loaded and started");
            return composeInterface;
        }
    }

    /* renamed from: com.contentsquare.android.sdk.c3$b */
    public static final class b extends Lambda implements Function0<HeapInterface> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final HeapInterface invoke() throws ClassNotFoundException {
            HeapInterface heapInterface;
            Logger logger = C0644c3.a;
            try {
                Class<?> heapClass = Class.forName("io.heap.core.Heap");
                Intrinsics.checkNotNullExpressionValue(heapClass, "heapClass");
                heapInterface = new HeapInterface(heapClass, C0654d3.a);
            } catch (Exception e) {
                C0644c3.a.d("Loading Heap module failed: " + e);
                heapInterface = null;
            }
            if (heapInterface == null) {
                return null;
            }
            C0644c3.a.d("Heap Detected and loaded: " + heapInterface);
            return heapInterface;
        }
    }

    @Nullable
    public static final ComposeInterface a() {
        return (ComposeInterface) c.getValue();
    }

    @JvmStatic
    public static final void a(@NotNull Context context) {
        StartableModule startableModule;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator it = b.iterator();
        while (it.hasNext()) {
            StartableModule startableModule2 = (StartableModule) it.next();
            startableModule2.stop(context);
            a.d(startableModule2 + " stopped");
        }
        b.clear();
        try {
            startableModule = (StartableModule) ErrorAnalysisModule.class.asSubclass(StartableModule.class).getConstructor(ErrorAnalysisLibraryInterface.class).newInstance(new ErrorAnalysisLibraryInterfaceImpl());
        } catch (Exception e) {
            a.d("Loading module failed: " + e);
            startableModule = null;
        }
        if (startableModule != null) {
            startableModule.start(context);
            b.add(startableModule);
            a.d(startableModule + " loaded and started");
        }
    }
}
