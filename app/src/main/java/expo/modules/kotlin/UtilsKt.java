package expo.modules.kotlin;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.kotlin.exception.Exceptions;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0086\b\u001a!\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0004\u0018\u0001H\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1836d2 = {"toStrongReference", "Lexpo/modules/kotlin/AppContext;", "weak", "Ljava/lang/ref/WeakReference;", ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/Object;)Ljava/lang/ref/WeakReference;", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class UtilsKt {
    @NotNull
    public static final AppContext toStrongReference(@Nullable AppContext appContext) throws Exceptions.AppContextLost {
        if (appContext != null) {
            return appContext;
        }
        throw new Exceptions.AppContextLost();
    }

    @NotNull
    public static final <T> WeakReference<T> weak(@Nullable T t) {
        return new WeakReference<>(t);
    }
}
