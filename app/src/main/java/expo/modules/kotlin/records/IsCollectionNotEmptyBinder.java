package expo.modules.kotlin.records;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1836d2 = {"Lexpo/modules/kotlin/records/IsCollectionNotEmptyBinder;", "Lexpo/modules/kotlin/records/ValidationBinder;", "<init>", "()V", "bind", "Lexpo/modules/kotlin/records/FieldValidator;", "annotation", "", "fieldType", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class IsCollectionNotEmptyBinder implements ValidationBinder {
    @Override // expo.modules.kotlin.records.ValidationBinder
    @NotNull
    public FieldValidator<?> bind(@NotNull Annotation annotation, @NotNull KType fieldType) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        boolean z = annotation instanceof IsNotEmpty;
        if (Intrinsics.areEqual(fieldType, KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(int[].class), null, false, null, 7, null))) {
            return new IsNotEmptyIntArrayValidator();
        }
        if (Intrinsics.areEqual(fieldType, KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(double[].class), null, false, null, 7, null))) {
            return new IsNotEmptyDoubleArrayValidator();
        }
        if (Intrinsics.areEqual(fieldType, KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(float[].class), null, false, null, 7, null))) {
            return new IsNotEmptyFloatArrayValidator();
        }
        KClassifier classifier = fieldType.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        KClass kClass = (KClass) classifier;
        if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Object[].class)) || JvmClassMappingKt.getJavaClass(kClass).isArray()) {
            return new IsNotEmptyArrayValidator();
        }
        return new IsNotEmptyCollectionValidator();
    }
}
