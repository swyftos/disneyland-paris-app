package kotlin.jdk7;

import ch.qos.logback.core.net.SyslogConstants;
import com.urbanairship.reactnative.ReactMessageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m1836d2 = {"<anonymous>", "", ReactMessageView.EVENT_CLOSE}, m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class AutoCloseableKt$AutoCloseable$1 implements AutoCloseable {
    final /* synthetic */ Function0 $closeAction;

    public AutoCloseableKt$AutoCloseable$1(Function0<Unit> function0) {
        this.$closeAction = function0;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.$closeAction.invoke();
    }
}
