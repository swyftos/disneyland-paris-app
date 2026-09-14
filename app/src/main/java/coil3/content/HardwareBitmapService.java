package coil3.content;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import coil3.size.Size;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\u0007\u0010\b\u0082\u0001\u0001\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, m1836d2 = {"Lcoil3/util/HardwareBitmapService;", "", "Lcoil3/size/Size;", TCEventPropertiesNames.TCP_SIZE, "", "allowHardwareMainThread", "(Lcoil3/size/Size;)Z", "allowHardwareWorkerThread", "()Z", "Lcoil3/util/ImmutableHardwareBitmapService;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface HardwareBitmapService {
    @MainThread
    boolean allowHardwareMainThread(@NotNull Size size);

    @WorkerThread
    boolean allowHardwareWorkerThread();
}
