package expo.modules.kotlin.functions;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.PromiseImpl;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H ¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0002¨\u0006\u001a"}, m1836d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "<init>", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "callUserImplementation", "", "args", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "appContext", "Lexpo/modules/kotlin/AppContext;", "callUserImplementation$expo_modules_core_release", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;Lexpo/modules/kotlin/AppContext;)V", "attachToJSObject", "jsObject", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "moduleName", "dispatchOnQueue", "block", "Lkotlin/Function0;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAsyncFunctionComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncFunctionComponent.kt\nexpo/modules/kotlin/functions/AsyncFunctionComponent\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 AnyType.kt\nexpo/modules/kotlin/types/AnyType\n+ 5 ExceptionDecorator.kt\nexpo/modules/kotlin/exception/ExceptionDecoratorKt\n+ 6 CodedException.kt\nexpo/modules/kotlin/exception/CodedExceptionKt\n*L\n1#1,92:1\n11165#2:93\n11500#2,3:94\n12574#2:99\n12575#2:104\n37#3,2:97\n326#4,4:100\n5#5,4:105\n11#6,6:109\n11#6,6:115\n*S KotlinDebug\n*F\n+ 1 AsyncFunctionComponent.kt\nexpo/modules/kotlin/functions/AsyncFunctionComponent\n*L\n30#1:93\n30#1:94,3\n69#1:99\n69#1:104\n30#1:97,2\n69#1:100,4\n42#1:105,4\n42#1:109,6\n52#1:115,6\n*E\n"})
public abstract class AsyncFunctionComponent extends BaseAsyncFunctionComponent {
    public abstract void callUserImplementation$expo_modules_core_release(@NotNull Object[] args, @NotNull Promise promise, @NotNull AppContext appContext);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncFunctionComponent(@NotNull String name, @NotNull AnyType[] desiredArgsTypes) {
        super(name, desiredArgsTypes);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
    }

    @Override // expo.modules.kotlin.functions.AnyFunction
    public void attachToJSObject(@NotNull final AppContext appContext, @NotNull JSDecoratorsBridgingObject jsObject, @NotNull final String moduleName) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        final WeakReference weakReferenceWeak = UtilsKt.weak(appContext);
        String name = getName();
        boolean takesOwner$expo_modules_core_release = getTakesOwner$expo_modules_core_release();
        boolean isEnumerable = getIsEnumerable();
        AnyType[] desiredArgsTypes = getDesiredArgsTypes();
        ArrayList arrayList = new ArrayList(desiredArgsTypes.length);
        for (AnyType anyType : desiredArgsTypes) {
            arrayList.add(anyType.getCppRequiredTypes());
        }
        jsObject.registerAsyncFunction(name, takesOwner$expo_modules_core_release, isEnumerable, (ExpectedType[]) arrayList.toArray(new ExpectedType[0]), new JNIAsyncFunctionBody() { // from class: expo.modules.kotlin.functions.AsyncFunctionComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNIAsyncFunctionBody
            public final void invoke(Object[] objArr, PromiseImpl promiseImpl) {
                AsyncFunctionComponent.attachToJSObject$lambda$4(weakReferenceWeak, moduleName, this, appContext, objArr, promiseImpl);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachToJSObject$lambda$4(WeakReference weakReference, final String str, final AsyncFunctionComponent asyncFunctionComponent, final AppContext appContext, final Object[] args, final PromiseImpl promiseImpl) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promiseImpl, "promiseImpl");
        asyncFunctionComponent.dispatchOnQueue(appContext, new Function0() { // from class: expo.modules.kotlin.functions.AsyncFunctionComponent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AsyncFunctionComponent.attachToJSObject$lambda$4$lambda$3(promiseImpl, asyncFunctionComponent, str, args, appContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachToJSObject$lambda$4$lambda$3(PromiseImpl promiseImpl, AsyncFunctionComponent asyncFunctionComponent, String str, Object[] objArr, AppContext appContext) {
        CodedException unexpectedException;
        CodedException codedException;
        CodedException unexpectedException2;
        try {
            asyncFunctionComponent.callUserImplementation$expo_modules_core_release(objArr, promiseImpl, appContext);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                if (th instanceof CodedException) {
                    unexpectedException2 = (CodedException) th;
                } else if (!(th instanceof expo.modules.core.errors.CodedException)) {
                    unexpectedException2 = new UnexpectedException(th);
                } else {
                    String code = ((expo.modules.core.errors.CodedException) th).getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                    unexpectedException2 = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                }
                throw new FunctionCallException(asyncFunctionComponent.getName(), str, unexpectedException2);
            } catch (Throwable th2) {
                if (!promiseImpl.getWasSettled()) {
                    if (th2 instanceof CodedException) {
                        codedException = (CodedException) th2;
                    } else {
                        if (!(th2 instanceof expo.modules.core.errors.CodedException)) {
                            unexpectedException = new UnexpectedException(th2);
                        } else {
                            expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) th2;
                            String code2 = codedException2.getCode();
                            Intrinsics.checkNotNullExpressionValue(code2, "getCode(...)");
                            unexpectedException = new CodedException(code2, codedException2.getMessage(), codedException2.getCause());
                        }
                        codedException = unexpectedException;
                    }
                    promiseImpl.reject(codedException);
                } else {
                    throw th2;
                }
            }
        }
    }

    private final void dispatchOnQueue(AppContext appContext, Function0 block) {
        FunctionQueue queue = getQueue();
        if (queue == Queues.DEFAULT) {
            BuildersKt__Builders_commonKt.launch$default(appContext.getModulesQueue(), null, null, new C62941(block, null), 3, null);
        } else if (queue == Queues.MAIN) {
            BuildersKt__Builders_commonKt.launch$default(appContext.getMainQueue(), null, null, new C62953(block, null), 3, null);
        } else {
            if (queue instanceof CustomQueue) {
                BuildersKt__Builders_commonKt.launch$default(((CustomQueue) queue).getScope(), null, null, new C62964(block, null), 3, null);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionComponent$dispatchOnQueue$1 */
    static final class C62941 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62941(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C62941(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C62941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$block.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionComponent$dispatchOnQueue$3 */
    static final class C62953 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62953(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C62953(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C62953) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$block.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.functions.AsyncFunctionComponent$dispatchOnQueue$4 */
    static final class C62964 extends SuspendLambda implements Function2 {
        final /* synthetic */ Function0 $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62964(Function0 function0, Continuation continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new C62964(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C62964) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$block.invoke();
            return Unit.INSTANCE;
        }
    }
}
