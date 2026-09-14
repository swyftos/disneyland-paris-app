package expo.modules.kotlin.functions;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ReadableArrayIterator;
import expo.modules.kotlin.ReadableArrayIteratorKt;
import expo.modules.kotlin.exception.ArgumentCastException;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.InvalidArgsNumberException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010%\u001a\u00020&H\u0004¢\u0006\u0002\u0010'J3\u0010$\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00052\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u0004¢\u0006\u0002\u0010*J \u0010+\u001a\u00020,2\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0003H&J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0000¢\u0006\u0002\b3J\u0010\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, m1836d2 = {"Lexpo/modules/kotlin/functions/AnyFunction;", "", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "<init>", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "getName", "()Ljava/lang/String;", "getDesiredArgsTypes", "()[Lexpo/modules/kotlin/types/AnyType;", "[Lexpo/modules/kotlin/types/AnyType;", "canTakeOwner", "", "getCanTakeOwner$annotations", "()V", "getCanTakeOwner", "()Z", "setCanTakeOwner", "(Z)V", "ownerType", "Lkotlin/reflect/KType;", "getOwnerType$annotations", "getOwnerType", "()Lkotlin/reflect/KType;", "setOwnerType", "(Lkotlin/reflect/KType;)V", "isEnumerable", "isEnumerable$expo_modules_core_release", "setEnumerable$expo_modules_core_release", "takesOwner", "getTakesOwner$expo_modules_core_release", "requiredArgumentsCount", "", "convertArgs", "args", "Lcom/facebook/react/bridge/ReadableArray;", "(Lcom/facebook/react/bridge/ReadableArray;)[Ljava/lang/Object;", "appContext", "Lexpo/modules/kotlin/AppContext;", "([Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)[Ljava/lang/Object;", "attachToJSObject", "", "jsObject", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "moduleName", "getCppRequiredTypes", "", "Lexpo/modules/kotlin/jni/ExpectedType;", "getCppRequiredTypes$expo_modules_core_release", "enumerable", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAnyFunction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnyFunction.kt\nexpo/modules/kotlin/functions/AnyFunction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 DynamicExtenstions.kt\nexpo/modules/kotlin/DynamicExtenstionsKt\n+ 4 ExceptionDecorator.kt\nexpo/modules/kotlin/exception/ExceptionDecoratorKt\n+ 5 CodedException.kt\nexpo/modules/kotlin/exception/CodedExceptionKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,130:1\n360#2,7:131\n7#3,2:138\n10#3:150\n5#4,4:140\n5#4,4:151\n11#5,6:144\n11#5,6:155\n11165#6:161\n11500#6,3:162\n*S KotlinDebug\n*F\n+ 1 AnyFunction.kt\nexpo/modules/kotlin/functions/AnyFunction\n*L\n56#1:131,7\n80#1:138,2\n80#1:150\n81#1:140,4\n108#1:151,4\n81#1:144,6\n108#1:155,6\n123#1:161\n123#1:162,3\n*E\n"})
public abstract class AnyFunction {
    private boolean canTakeOwner;
    private final AnyType[] desiredArgsTypes;
    private boolean isEnumerable;
    private final String name;
    private KType ownerType;
    private final int requiredArgumentsCount;

    @PublishedApi
    public static /* synthetic */ void getCanTakeOwner$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getOwnerType$annotations() {
    }

    public abstract void attachToJSObject(@NotNull AppContext appContext, @NotNull JSDecoratorsBridgingObject jsObject, @NotNull String moduleName);

    public AnyFunction(@NotNull String name, @NotNull AnyType[] desiredArgsTypes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        this.name = name;
        this.desiredArgsTypes = desiredArgsTypes;
        this.isEnumerable = true;
        Iterator it = ArraysKt.reversed(desiredArgsTypes).iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (!((AnyType) it.next()).getKType().getIsMarkedNullable()) {
                break;
            } else {
                i++;
            }
        }
        this.requiredArgumentsCount = i >= 0 ? this.desiredArgsTypes.length - i : 0;
    }

    @NotNull
    protected final String getName() {
        return this.name;
    }

    @NotNull
    protected final AnyType[] getDesiredArgsTypes() {
        return this.desiredArgsTypes;
    }

    public final boolean getCanTakeOwner() {
        return this.canTakeOwner;
    }

    public final void setCanTakeOwner(boolean z) {
        this.canTakeOwner = z;
    }

    @Nullable
    public final KType getOwnerType() {
        return this.ownerType;
    }

    public final void setOwnerType(@Nullable KType kType) {
        this.ownerType = kType;
    }

    /* JADX INFO: renamed from: isEnumerable$expo_modules_core_release, reason: from getter */
    public final boolean getIsEnumerable() {
        return this.isEnumerable;
    }

    public final void setEnumerable$expo_modules_core_release(boolean z) {
        this.isEnumerable = z;
    }

    public final boolean getTakesOwner$expo_modules_core_release() {
        KType kType;
        if (!this.canTakeOwner) {
            return false;
        }
        AnyType anyType = (AnyType) ArraysKt.firstOrNull(this.desiredArgsTypes);
        KClassifier classifier = (anyType == null || (kType = anyType.getKType()) == null) ? null : kType.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            return false;
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(JavaScriptObject.class))) {
            return true;
        }
        KType kType2 = this.ownerType;
        KClassifier classifier2 = kType2 != null ? kType2.getClassifier() : null;
        KClass kClass2 = classifier2 instanceof KClass ? (KClass) classifier2 : null;
        if (kClass2 == null) {
            return false;
        }
        return Intrinsics.areEqual(kClass, kClass2);
    }

    @NotNull
    protected final Object[] convertArgs(@NotNull ReadableArray args) throws CodedException {
        CodedException unexpectedException;
        Intrinsics.checkNotNullParameter(args, "args");
        if (this.requiredArgumentsCount <= args.size()) {
            int size = args.size();
            AnyType[] anyTypeArr = this.desiredArgsTypes;
            if (size <= anyTypeArr.length) {
                int length = anyTypeArr.length;
                Object[] objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = null;
                }
                ReadableArrayIterator it = ReadableArrayIteratorKt.iterator(args);
                int size2 = args.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    AnyType anyType = this.desiredArgsTypes[i2];
                    Dynamic next = it.next();
                    try {
                        objArr[i2] = AnyType.convert$default(anyType, next, null, 2, null);
                        Unit unit = Unit.INSTANCE;
                        next.recycle();
                    } catch (Throwable th) {
                        try {
                            if (th instanceof CodedException) {
                                unexpectedException = (CodedException) th;
                            } else if (th instanceof expo.modules.core.errors.CodedException) {
                                String code = ((expo.modules.core.errors.CodedException) th).getCode();
                                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                                unexpectedException = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                            } else {
                                unexpectedException = new UnexpectedException(th);
                            }
                            throw new ArgumentCastException(anyType.getKType(), i2, next.getType().toString(), unexpectedException);
                        } catch (Throwable th2) {
                            next.recycle();
                            throw th2;
                        }
                    }
                }
                return objArr;
            }
        }
        throw new InvalidArgsNumberException(args.size(), this.desiredArgsTypes.length, this.requiredArgumentsCount);
    }

    public static /* synthetic */ Object[] convertArgs$default(AnyFunction anyFunction, Object[] objArr, AppContext appContext, int i, Object obj) throws CodedException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertArgs");
        }
        if ((i & 2) != 0) {
            appContext = null;
        }
        return anyFunction.convertArgs(objArr, appContext);
    }

    @NotNull
    protected final Object[] convertArgs(@NotNull Object[] args, @Nullable AppContext appContext) throws CodedException {
        CodedException unexpectedException;
        CodedException codedException;
        Intrinsics.checkNotNullParameter(args, "args");
        if (this.requiredArgumentsCount <= args.length) {
            int length = args.length;
            AnyType[] anyTypeArr = this.desiredArgsTypes;
            if (length <= anyTypeArr.length) {
                int length2 = anyTypeArr.length;
                Object[] objArr = new Object[length2];
                int i = 0;
                while (true) {
                    if (i >= length2) {
                        break;
                    }
                    objArr[i] = null;
                    i++;
                }
                Iterator it = ArrayIteratorKt.iterator(args);
                int length3 = args.length;
                for (int i2 = 0; i2 < length3; i2++) {
                    Object next = it.next();
                    AnyType anyType = this.desiredArgsTypes[i2];
                    try {
                        objArr[i2] = anyType.convert(next, appContext);
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        if (th instanceof CodedException) {
                            codedException = (CodedException) th;
                        } else {
                            if (th instanceof expo.modules.core.errors.CodedException) {
                                expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) th;
                                String code = codedException2.getCode();
                                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                                unexpectedException = new CodedException(code, codedException2.getMessage(), codedException2.getCause());
                            } else {
                                unexpectedException = new UnexpectedException(th);
                            }
                            codedException = unexpectedException;
                        }
                        throw new ArgumentCastException(anyType.getKType(), i2, String.valueOf(next != null ? next.getClass() : null), codedException);
                    }
                }
                return objArr;
            }
        }
        throw new InvalidArgsNumberException(args.length, this.desiredArgsTypes.length, this.requiredArgumentsCount);
    }

    @NotNull
    public final List<ExpectedType> getCppRequiredTypes$expo_modules_core_release() {
        AnyType[] anyTypeArr = this.desiredArgsTypes;
        ArrayList arrayList = new ArrayList(anyTypeArr.length);
        for (AnyType anyType : anyTypeArr) {
            arrayList.add(anyType.getCppRequiredTypes());
        }
        return arrayList;
    }

    public static /* synthetic */ AnyFunction enumerable$default(AnyFunction anyFunction, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enumerable");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return anyFunction.enumerable(z);
    }

    @NotNull
    public final AnyFunction enumerable(boolean isEnumerable) {
        this.isEnumerable = isEnumerable;
        return this;
    }
}
