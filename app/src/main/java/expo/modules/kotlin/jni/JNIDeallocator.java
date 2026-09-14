package expo.modules.kotlin.jni;

import com.urbanairship.reactnative.ReactMessageView;
import expo.modules.core.interfaces.DoNotStrip;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u000f\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\tH\u0007J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018J\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001a"}, m1836d2 = {"Lexpo/modules/kotlin/jni/JNIDeallocator;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "shouldCreateDestructorThread", "", "<init>", "(Z)V", "referenceQueue", "Ljava/lang/ref/ReferenceQueue;", "Lexpo/modules/kotlin/jni/Destructible;", "destructorMap", "", "Ljava/lang/ref/PhantomReference;", "Ljava/lang/ref/WeakReference;", "destructorThread", "expo/modules/kotlin/jni/JNIDeallocator$destructorThread$1", "Lexpo/modules/kotlin/jni/JNIDeallocator$destructorThread$1;", "addReference", "", "destructible", "deallocate", "deallocate$expo_modules_core_release", "()Lkotlin/Unit;", "inspectMemory", "", ReactMessageView.EVENT_CLOSE, "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
@SourceDebugExtension({"SMAP\nJNIDeallocator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JNIDeallocator.kt\nexpo/modules/kotlin/jni/JNIDeallocator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1863#2,2:88\n1611#2,9:90\n1863#2:99\n1864#2:101\n1620#2:102\n1#3:100\n*S KotlinDebug\n*F\n+ 1 JNIDeallocator.kt\nexpo/modules/kotlin/jni/JNIDeallocator\n*L\n68#1:88,2\n80#1:90,9\n80#1:99\n80#1:101\n80#1:102\n80#1:100\n*E\n"})
public final class JNIDeallocator implements AutoCloseable {
    private final Map destructorMap;
    private final JNIDeallocator$destructorThread$1 destructorThread;
    private final ReferenceQueue referenceQueue;

    public JNIDeallocator() {
        this(false, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JNIDeallocator(boolean z) {
        JNIDeallocator$destructorThread$1 jNIDeallocator$destructorThread$1;
        this.referenceQueue = new ReferenceQueue();
        this.destructorMap = new LinkedHashMap();
        if (z) {
            Thread thread = new Thread() { // from class: expo.modules.kotlin.jni.JNIDeallocator$destructorThread$1
                {
                    super("Expo JNI deallocator");
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (!isInterrupted()) {
                        try {
                            Reference referenceRemove = this.this$0.referenceQueue.remove();
                            JNIDeallocator jNIDeallocator = this.this$0;
                            synchronized (jNIDeallocator) {
                                try {
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
            };
            thread.start();
            jNIDeallocator$destructorThread$1 = thread;
        } else {
            jNIDeallocator$destructorThread$1 = 0;
        }
        this.destructorThread = jNIDeallocator$destructorThread$1;
    }

    public /* synthetic */ JNIDeallocator(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    @DoNotStrip
    public final void addReference(@NotNull Destructible destructible) {
        Intrinsics.checkNotNullParameter(destructible, "destructible");
        synchronized (this) {
            WeakReference weakReference = new WeakReference(destructible);
            this.destructorMap.put(new PhantomReference(destructible, this.referenceQueue), weakReference);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final Unit deallocate$expo_modules_core_release() {
        Unit unit;
        synchronized (this) {
            try {
                Iterator it = this.destructorMap.values().iterator();
                while (it.hasNext()) {
                    Destructible destructible = (Destructible) ((WeakReference) it.next()).get();
                    if (destructible != null) {
                        destructible.deallocate();
                    }
                }
                this.destructorMap.clear();
                JNIDeallocator$destructorThread$1 jNIDeallocator$destructorThread$1 = this.destructorThread;
                if (jNIDeallocator$destructorThread$1 != null) {
                    jNIDeallocator$destructorThread$1.interrupt();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return unit;
    }

    @NotNull
    public final List<Destructible> inspectMemory() {
        ArrayList arrayList;
        synchronized (this) {
            Collection collectionValues = this.destructorMap.values();
            arrayList = new ArrayList();
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                Destructible destructible = (Destructible) ((WeakReference) it.next()).get();
                if (destructible != null) {
                    arrayList.add(destructible);
                }
            }
        }
        return arrayList;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        deallocate$expo_modules_core_release();
    }
}
