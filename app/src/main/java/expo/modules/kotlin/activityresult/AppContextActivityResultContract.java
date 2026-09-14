package expo.modules.kotlin.activityresult;

import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ'\u0010\u000b\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "I", "Ljava/io/Serializable;", "O", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;Ljava/io/Serializable;)Landroid/content/Intent;", "parseResult", "resultCode", "", "intent", "(Ljava/io/Serializable;ILandroid/content/Intent;)Ljava/lang/Object;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface AppContextActivityResultContract<I extends Serializable, O> {
    @NotNull
    Intent createIntent(@NotNull Context context, @NotNull I input);

    O parseResult(@NotNull I input, int resultCode, @Nullable Intent intent);
}
