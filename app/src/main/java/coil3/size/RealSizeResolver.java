package coil3.size;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0002\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1836d2 = {"Lcoil3/size/RealSizeResolver;", "Lcoil3/size/SizeResolver;", TCEventPropertiesNames.TCP_SIZE, "Lcoil3/size/Size;", "<init>", "(Lcoil3/size/Size;)V", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class RealSizeResolver implements SizeResolver {
    private final Size size;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RealSizeResolver) && Intrinsics.areEqual(this.size, ((RealSizeResolver) obj).size);
    }

    public int hashCode() {
        return this.size.hashCode();
    }

    @NotNull
    public String toString() {
        return "RealSizeResolver(size=" + this.size + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public RealSizeResolver(@NotNull Size size) {
        this.size = size;
    }

    @Override // coil3.size.SizeResolver
    @Nullable
    public Object size(@NotNull Continuation<? super Size> continuation) {
        return this.size;
    }
}
