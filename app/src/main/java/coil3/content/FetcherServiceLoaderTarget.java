package coil3.content;

import androidx.exifinterface.media.ExifInterface;
import coil3.annotation.InternalCoilApi;
import coil3.fetch.Fetcher;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H&J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/util/FetcherServiceLoaderTarget;", ExifInterface.GPS_DIRECTION_TRUE, "", "factory", "Lcoil3/fetch/Fetcher$Factory;", "type", "Lkotlin/reflect/KClass;", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@InternalCoilApi
public interface FetcherServiceLoaderTarget<T> {
    @Nullable
    Fetcher.Factory<T> factory();

    default int priority() {
        return 0;
    }

    @Nullable
    KClass<T> type();
}
