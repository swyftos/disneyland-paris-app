package timber.log;

import java.util.List;
import timber.log.Timber;

/* loaded from: classes.dex */
public class Lumberjack {
    static final ThreadLocal explicitTag = new ThreadLocal();

    public static void callStackCorrection(Integer num) {
        List<Timber.Tree> listForest = Timber.forest();
        int size = listForest.size();
        for (int i = 0; i < size; i++) {
            if (listForest.get(i) instanceof BaseTree) {
                ((BaseTree) listForest.get(i)).callStackCorrection.set(num);
            }
        }
    }
}
