package expo.modules.kotlin.activityresult;

import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bæ\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\t¨\u0006\n"}, m1836d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "I", "Ljava/io/Serializable;", "O", "", "onActivityResult", "", "input", "result", "(Ljava/io/Serializable;Ljava/lang/Object;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface AppContextActivityResultFallbackCallback<I extends Serializable, O> {
    void onActivityResult(@NotNull I input, O result);
}
