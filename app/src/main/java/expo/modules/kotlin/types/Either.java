package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.DynamicExtenstionsKt;
import expo.modules.kotlin.apifeatures.EitherType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@EitherType
@Metadata(m1835d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B+\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u0015\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0013J\u001b\u0010\r\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0007¢\u0006\u0002\b\u0016J\u001b\u0010\r\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0007¢\u0006\u0002\b\u0017J\u001d\u0010\u0012\u001a\u00028\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0012\u001a\u00028\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0019J\u000b\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u00028\u0001¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m1836d2 = {"Lexpo/modules/kotlin/types/Either;", "FirstType", "", "SecondType", "bareValue", "deferredValue", "", "Lexpo/modules/kotlin/types/DeferredValue;", "types", "", "Lkotlin/reflect/KType;", "<init>", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "is", "", ArrayContainsMatcher.INDEX_KEY, "", "is$expo_modules_core_release", "get", "get$expo_modules_core_release", "type", "Lkotlin/reflect/KClass;", "isFirstType", "isSecondType", "getFirstType", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getSecondType", "first", "()Ljava/lang/Object;", "second", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
public class Either<FirstType, SecondType> {
    private final Object bareValue;
    private final List deferredValue;
    private final List types;

    public Either(@NotNull Object bareValue, @NotNull List<DeferredValue> deferredValue, @NotNull List<? extends KType> types) {
        Intrinsics.checkNotNullParameter(bareValue, "bareValue");
        Intrinsics.checkNotNullParameter(deferredValue, "deferredValue");
        Intrinsics.checkNotNullParameter(types, "types");
        this.bareValue = bareValue;
        this.deferredValue = deferredValue;
        this.types = types;
    }

    public final boolean is$expo_modules_core_release(int index) {
        DeferredValue deferredValue = (DeferredValue) this.deferredValue.get(index);
        if (deferredValue instanceof ConvertedValue) {
            return true;
        }
        if (!Intrinsics.areEqual(deferredValue, IncompatibleValue.INSTANCE)) {
            if (!(deferredValue instanceof UnconvertedValue)) {
                throw new NoWhenBranchMatchedException();
            }
            try {
                this.deferredValue.set(index, new ConvertedValue(((UnconvertedValue) deferredValue).getConvertedValue()));
                return true;
            } catch (Throwable unused) {
                this.deferredValue.set(index, IncompatibleValue.INSTANCE);
            }
        }
        return false;
    }

    @NotNull
    public final Object get$expo_modules_core_release(int index) {
        DeferredValue deferredValue = (DeferredValue) this.deferredValue.get(index);
        if (deferredValue instanceof ConvertedValue) {
            return ((ConvertedValue) deferredValue).getConvertedValue();
        }
        if (Intrinsics.areEqual(deferredValue, IncompatibleValue.INSTANCE)) {
            throw new TypeCastException("Cannot cast '" + this.bareValue + "' to '" + this.types.get(index) + "'");
        }
        if (!(deferredValue instanceof UnconvertedValue)) {
            throw new NoWhenBranchMatchedException();
        }
        try {
            Object convertedValue = ((UnconvertedValue) deferredValue).getConvertedValue();
            this.deferredValue.set(index, new ConvertedValue(convertedValue));
            return convertedValue;
        } catch (Throwable th) {
            this.deferredValue.set(index, IncompatibleValue.INSTANCE);
            if (this.bareValue instanceof Dynamic) {
                Object obj = this.bareValue;
                throw new TypeCastException("Cannot cast '[" + obj + "] " + DynamicExtenstionsKt.unwrap((Dynamic) obj) + "' to '" + this.types.get(index) + "' - " + th.getMessage());
            }
            throw new TypeCastException("Cannot cast '" + this.bareValue + "' to '" + this.types.get(index) + "' - " + th.getMessage());
        }
    }

    @JvmName(name = "isFirstType")
    public final boolean isFirstType(@NotNull KClass<FirstType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return is$expo_modules_core_release(0);
    }

    @JvmName(name = "isSecondType")
    public final boolean isSecondType(@NotNull KClass<SecondType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return is$expo_modules_core_release(1);
    }

    @JvmName(name = "getFirstType")
    @NotNull
    public final FirstType getFirstType(@NotNull KClass<FirstType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        FirstType firsttype = (FirstType) get$expo_modules_core_release(0);
        Intrinsics.checkNotNull(firsttype, "null cannot be cast to non-null type FirstType of expo.modules.kotlin.types.Either");
        return firsttype;
    }

    @JvmName(name = "getSecondType")
    @NotNull
    public final SecondType getSecondType(@NotNull KClass<SecondType> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        SecondType secondtype = (SecondType) get$expo_modules_core_release(1);
        Intrinsics.checkNotNull(secondtype, "null cannot be cast to non-null type SecondType of expo.modules.kotlin.types.Either");
        return secondtype;
    }

    @NotNull
    public final FirstType first() {
        FirstType firsttype = (FirstType) get$expo_modules_core_release(0);
        Intrinsics.checkNotNull(firsttype, "null cannot be cast to non-null type FirstType of expo.modules.kotlin.types.Either");
        return firsttype;
    }

    @NotNull
    public final SecondType second() {
        SecondType secondtype = (SecondType) get$expo_modules_core_release(1);
        Intrinsics.checkNotNull(secondtype, "null cannot be cast to non-null type SecondType of expo.modules.kotlin.types.Either");
        return secondtype;
    }
}
