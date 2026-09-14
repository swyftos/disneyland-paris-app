package coil3.network;

import coil3.annotation.ExperimentalCoilApi;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bç\u0080\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, m1836d2 = {"Lcoil3/network/ConnectivityChecker;", "", "isOnline", "", "Companion", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@ExperimentalCoilApi
public interface ConnectivityChecker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmField
    @NotNull
    public static final ConnectivityChecker ONLINE = new ConnectivityChecker() { // from class: coil3.network.ConnectivityChecker$$ExternalSyntheticLambda0
        @Override // coil3.network.ConnectivityChecker
        public final boolean isOnline() {
            return ConnectivityChecker.ONLINE$lambda$0();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    static boolean ONLINE$lambda$0() {
        return true;
    }

    boolean isOnline();

    @Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, m1836d2 = {"Lcoil3/network/ConnectivityChecker$Companion;", "", "<init>", "()V", "ONLINE", "Lcoil3/network/ConnectivityChecker;", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
