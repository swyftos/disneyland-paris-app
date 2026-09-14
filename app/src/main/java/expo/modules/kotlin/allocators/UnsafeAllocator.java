package expo.modules.kotlin.allocators;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000 \u0005*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0005J\r\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, m1836d2 = {"Lexpo/modules/kotlin/allocators/UnsafeAllocator;", ExifInterface.GPS_DIRECTION_TRUE, "", "newInstance", "()Ljava/lang/Object;", "Companion", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface UnsafeAllocator<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    T newInstance() throws Exception;

    @Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0007¨\u0006\t"}, m1836d2 = {"Lexpo/modules/kotlin/allocators/UnsafeAllocator$Companion;", "", "<init>", "()V", "createAllocator", "Lexpo/modules/kotlin/allocators/UnsafeAllocator;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @SuppressLint({"DiscouragedPrivateApi"})
        @NotNull
        public final <T> UnsafeAllocator<T> createAllocator(@NotNull final Class<T> clazz) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    Object objInvoke = declaredMethod.invoke(null, Object.class);
                    Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Int");
                    final int iIntValue = ((Integer) objInvoke).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new UnsafeAllocator() { // from class: expo.modules.kotlin.allocators.UnsafeAllocator$Companion$$ExternalSyntheticLambda0
                        @Override // expo.modules.kotlin.allocators.UnsafeAllocator
                        public final Object newInstance() {
                            return UnsafeAllocator.Companion.createAllocator$lambda$0(declaredMethod2, clazz, iIntValue);
                        }
                    };
                } catch (Throwable unused) {
                    return new UnsafeAllocator() { // from class: expo.modules.kotlin.allocators.UnsafeAllocator$Companion$$ExternalSyntheticLambda2
                        @Override // expo.modules.kotlin.allocators.UnsafeAllocator
                        public final Object newInstance() {
                            return UnsafeAllocator.Companion.createAllocator$lambda$2(clazz);
                        }
                    };
                }
            } catch (Throwable unused2) {
                Class<?> cls = Class.forName("sun.misc.Unsafe");
                Field declaredField = cls.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                final Object obj = declaredField.get(null);
                final Method method = cls.getMethod("allocateInstance", Class.class);
                return new UnsafeAllocator() { // from class: expo.modules.kotlin.allocators.UnsafeAllocator$Companion$$ExternalSyntheticLambda1
                    @Override // expo.modules.kotlin.allocators.UnsafeAllocator
                    public final Object newInstance() {
                        return UnsafeAllocator.Companion.createAllocator$lambda$1(method, obj, clazz);
                    }
                };
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createAllocator$lambda$0(Method method, Class cls, int i) {
            return method.invoke(null, cls, Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createAllocator$lambda$1(Method method, Object obj, Class cls) {
            return method.invoke(obj, cls);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createAllocator$lambda$2(Class cls) {
            throw new IllegalArgumentException("Cannot allocate " + cls);
        }
    }
}
