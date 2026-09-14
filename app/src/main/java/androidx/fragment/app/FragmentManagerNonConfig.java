package androidx.fragment.app;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentManagerNonConfig {
    private final Map mChildNonConfigs;
    private final Collection mFragments;
    private final Map mViewModelStores;

    FragmentManagerNonConfig(Collection collection, Map map, Map map2) {
        this.mFragments = collection;
        this.mChildNonConfigs = map;
        this.mViewModelStores = map2;
    }

    Collection getFragments() {
        return this.mFragments;
    }

    Map getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    Map getViewModelStores() {
        return this.mViewModelStores;
    }
}
