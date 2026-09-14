package expo.modules.kotlin.activityresult;

import androidx.annotation.MainThread;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0006\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1836d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "", "registerForActivityResult", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "I", "O", "Ljava/io/Serializable;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "(Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface AppContextActivityResultCaller {
    @MainThread
    @Nullable
    <I extends Serializable, O> Object registerForActivityResult(@NotNull AppContextActivityResultContract<I, O> appContextActivityResultContract, @NotNull AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback, @NotNull Continuation<? super AppContextActivityResultLauncher<I, O>> continuation);

    @Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object registerForActivityResult$default(AppContextActivityResultCaller appContextActivityResultCaller, AppContextActivityResultContract appContextActivityResultContract, AppContextActivityResultFallbackCallback appContextActivityResultFallbackCallback, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerForActivityResult");
            }
            if ((i & 2) != 0) {
                appContextActivityResultFallbackCallback = new AppContextActivityResultFallbackCallback() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultCaller$DefaultImpls$$ExternalSyntheticLambda0
                    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultFallbackCallback
                    public final void onActivityResult(Serializable serializable, Object obj2) {
                        Intrinsics.checkNotNullParameter(serializable, "<unused var>");
                    }
                };
            }
            return appContextActivityResultCaller.registerForActivityResult(appContextActivityResultContract, appContextActivityResultFallbackCallback, continuation);
        }
    }
}
