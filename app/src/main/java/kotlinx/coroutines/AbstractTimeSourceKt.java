package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0080\b¢\u0006\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1836d2 = {"Lkotlinx/coroutines/AbstractTimeSource;", "source", "", "mockTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "kotlinx-coroutines-core"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class AbstractTimeSourceKt {
    private static AbstractTimeSource timeSource;

    public static final void mockTimeSource(@Nullable AbstractTimeSource abstractTimeSource) {
        timeSource = abstractTimeSource;
    }
}
