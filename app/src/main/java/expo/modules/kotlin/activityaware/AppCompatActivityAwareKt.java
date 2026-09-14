package expo.modules.kotlin.activityaware;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086H¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1836d2 = {"withActivityAvailable", "R", "Lexpo/modules/kotlin/activityaware/AppCompatActivityAware;", "onActivityAvailable", "Lkotlin/Function1;", "Landroidx/appcompat/app/AppCompatActivity;", "(Lexpo/modules/kotlin/activityaware/AppCompatActivityAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nAppCompatActivityAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppCompatActivityAware.kt\nexpo/modules/kotlin/activityaware/AppCompatActivityAwareKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,52:1\n314#2,11:53\n*S KotlinDebug\n*F\n+ 1 AppCompatActivityAware.kt\nexpo/modules/kotlin/activityaware/AppCompatActivityAwareKt\n*L\n38#1:53,11\n*E\n"})
public final class AppCompatActivityAwareKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [expo.modules.kotlin.activityaware.AppCompatActivityAwareKt$withActivityAvailable$2$listener$1, expo.modules.kotlin.activityaware.OnActivityAvailableListener] */
    @Nullable
    public static final <R> Object withActivityAvailable(@NotNull final AppCompatActivityAware appCompatActivityAware, @NotNull final Function1<? super AppCompatActivity, ? extends R> function1, @NotNull Continuation<? super R> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final ?? r1 = new OnActivityAvailableListener() { // from class: expo.modules.kotlin.activityaware.AppCompatActivityAwareKt$withActivityAvailable$2$listener$1
            @Override // expo.modules.kotlin.activityaware.OnActivityAvailableListener
            public void onActivityAvailable(AppCompatActivity activity) {
                Object objM5277constructorimpl;
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (cancellableContinuationImpl.isActive()) {
                    appCompatActivityAware.removeOnActivityAvailableListener(this);
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Function1 function2 = function1;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM5277constructorimpl = Result.m5277constructorimpl(function2.invoke(activity));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM5277constructorimpl = Result.m5277constructorimpl(ResultKt.createFailure(th));
                    }
                    cancellableContinuation.resumeWith(objM5277constructorimpl);
                }
            }
        };
        appCompatActivityAware.addOnActivityAvailableListener(r1);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: expo.modules.kotlin.activityaware.AppCompatActivityAwareKt$withActivityAvailable$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                appCompatActivityAware.removeOnActivityAvailableListener(r1);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
