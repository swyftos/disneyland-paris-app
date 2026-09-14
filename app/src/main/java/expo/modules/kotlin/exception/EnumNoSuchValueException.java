package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m1836d2 = {"Lexpo/modules/kotlin/exception/EnumNoSuchValueException;", "Lexpo/modules/kotlin/exception/CodedException;", "enumType", "Lkotlin/reflect/KClass;", "", "enumConstants", "", "value", "", "<init>", "(Lkotlin/reflect/KClass;[Ljava/lang/Enum;Ljava/lang/Object;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class EnumNoSuchValueException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumNoSuchValueException(@NotNull KClass<Enum<?>> enumType, @NotNull Enum<?>[] enumConstants, @Nullable Object obj) {
        super("'" + obj + "' is not present in " + enumType.getSimpleName() + " enum, it must be one of: " + ArraysKt.joinToString$default(enumConstants, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: expo.modules.kotlin.exception.EnumNoSuchValueException$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return EnumNoSuchValueException._init_$lambda$0((Enum) obj2);
            }
        }, 30, (Object) null), null, 2, null);
        Intrinsics.checkNotNullParameter(enumType, "enumType");
        Intrinsics.checkNotNullParameter(enumConstants, "enumConstants");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence _init_$lambda$0(Enum it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "'" + it.name() + "'";
    }
}
