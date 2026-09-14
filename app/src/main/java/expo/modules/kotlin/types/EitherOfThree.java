package expo.modules.kotlin.types;

import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.apifeatures.EitherType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@EitherType
@Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B+\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0012H\u0007¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00028\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0017\u001a\u00028\u0002¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, m1836d2 = {"Lexpo/modules/kotlin/types/EitherOfThree;", "FirstType", "", "SecondType", "ThirdType", "Lexpo/modules/kotlin/types/Either;", "bareValue", "deferredValue", "", "Lexpo/modules/kotlin/types/DeferredValue;", "types", "", "Lkotlin/reflect/KType;", "<init>", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "is", "", "type", "Lkotlin/reflect/KClass;", "isThirdType", "get", "getThirdType", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "third", "()Ljava/lang/Object;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
public class EitherOfThree<FirstType, SecondType, ThirdType> extends Either<FirstType, SecondType> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EitherOfThree(@NotNull Object bareValue, @NotNull List<DeferredValue> deferredValue, @NotNull List<? extends KType> types) {
        super(bareValue, deferredValue, types);
        Intrinsics.checkNotNullParameter(bareValue, "bareValue");
        Intrinsics.checkNotNullParameter(deferredValue, "deferredValue");
        Intrinsics.checkNotNullParameter(types, "types");
    }

    @JvmName(name = "isThirdType")
    public final boolean isThirdType(@NotNull KClass<ThirdType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return is$expo_modules_core_release(2);
    }

    @JvmName(name = "getThirdType")
    @NotNull
    public final ThirdType getThirdType(@NotNull KClass<ThirdType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ThirdType thirdtype = (ThirdType) get$expo_modules_core_release(2);
        Intrinsics.checkNotNull(thirdtype, "null cannot be cast to non-null type ThirdType of expo.modules.kotlin.types.EitherOfThree");
        return thirdtype;
    }

    @NotNull
    public final ThirdType third() {
        ThirdType thirdtype = (ThirdType) get$expo_modules_core_release(2);
        Intrinsics.checkNotNull(thirdtype, "null cannot be cast to non-null type ThirdType of expo.modules.kotlin.types.EitherOfThree");
        return thirdtype;
    }
}
