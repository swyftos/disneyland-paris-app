package expo.modules.kotlin.allocators;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bJ$\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0002J(\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0002J\"\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0002¨\u0006\r"}, m1836d2 = {"Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "", "<init>", "()V", "get", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "tryToUseDefaultConstructor", "Ljava/lang/Class;", "tryToUseDefaultKotlinConstructor", "useUnsafeAllocator", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nObjectConstructorFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectConstructorFactory.kt\nexpo/modules/kotlin/allocators/ObjectConstructorFactory\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,44:1\n669#2,4:45\n1734#2,3:49\n673#2,7:52\n*S KotlinDebug\n*F\n+ 1 ObjectConstructorFactory.kt\nexpo/modules/kotlin/allocators/ObjectConstructorFactory\n*L\n30#1:45,4\n30#1:49,3\n30#1:52,7\n*E\n"})
public final class ObjectConstructorFactory {
    @NotNull
    public final <T> ObjectConstructor<T> get(@NotNull KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ObjectConstructor<T> objectConstructorTryToUseDefaultConstructor = tryToUseDefaultConstructor(JvmClassMappingKt.getJavaClass((KClass) clazz));
        if (objectConstructorTryToUseDefaultConstructor != null) {
            return objectConstructorTryToUseDefaultConstructor;
        }
        ObjectConstructor<T> objectConstructorTryToUseDefaultKotlinConstructor = tryToUseDefaultKotlinConstructor(clazz);
        return objectConstructorTryToUseDefaultKotlinConstructor == null ? useUnsafeAllocator(JvmClassMappingKt.getJavaClass((KClass) clazz)) : objectConstructorTryToUseDefaultKotlinConstructor;
    }

    private final ObjectConstructor tryToUseDefaultConstructor(Class clazz) {
        try {
            final Constructor declaredConstructor = clazz.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda1
                @Override // expo.modules.kotlin.allocators.ObjectConstructor
                public final Object construct() {
                    return ObjectConstructorFactory.tryToUseDefaultConstructor$lambda$0(declaredConstructor);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultConstructor$lambda$0(Constructor constructor) {
        return constructor.newInstance(new Object[0]);
    }

    private final ObjectConstructor tryToUseDefaultKotlinConstructor(KClass clazz) {
        Iterator it = clazz.getConstructors().iterator();
        boolean z = false;
        Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
                break;
            }
            Object next = it.next();
            List<KParameter> parameters = ((KFunction) next).getParameters();
            if (parameters == null || !parameters.isEmpty()) {
                Iterator<T> it2 = parameters.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((KParameter) it2.next()).isOptional()) {
                        }
                    }
                }
            }
            if (!z) {
                z = true;
                obj = next;
            }
            obj = null;
            break;
        }
        final KFunction kFunction = (KFunction) obj;
        if (kFunction == null) {
            return null;
        }
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda2
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return ObjectConstructorFactory.tryToUseDefaultKotlinConstructor$lambda$2(kFunction);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object tryToUseDefaultKotlinConstructor$lambda$2(KFunction kFunction) {
        return kFunction.callBy(MapsKt.emptyMap());
    }

    private final ObjectConstructor useUnsafeAllocator(Class clazz) {
        final UnsafeAllocator unsafeAllocatorCreateAllocator = UnsafeAllocator.INSTANCE.createAllocator(clazz);
        return new ObjectConstructor() { // from class: expo.modules.kotlin.allocators.ObjectConstructorFactory$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.allocators.ObjectConstructor
            public final Object construct() {
                return unsafeAllocatorCreateAllocator.newInstance();
            }
        };
    }
}
