package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SurfaceCombination {
    private final List mSurfaceConfigList = new ArrayList();

    private static void generateArrangements(List list, int i, int[] iArr, int i2) {
        if (i2 >= iArr.length) {
            list.add((int[]) iArr.clone());
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = 0;
            while (true) {
                if (i4 < i2) {
                    if (i3 == iArr[i4]) {
                        break;
                    } else {
                        i4++;
                    }
                } else {
                    iArr[i2] = i3;
                    generateArrangements(list, i, iArr, i2 + 1);
                    break;
                }
            }
        }
    }

    public boolean addSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    public boolean removeSurfaceConfig(@NonNull SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }

    @NonNull
    public List<SurfaceConfig> getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    @Nullable
    public List<SurfaceConfig> getOrderedSupportedSurfaceConfigList(@NonNull List<SurfaceConfig> list) {
        int i;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        if (list.size() != this.mSurfaceConfigList.size()) {
            return null;
        }
        List elementsArrangements = getElementsArrangements(this.mSurfaceConfigList.size());
        SurfaceConfig[] surfaceConfigArr = new SurfaceConfig[list.size()];
        Iterator it = elementsArrangements.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            int[] iArr = (int[]) it.next();
            boolean zIsSupported = true;
            while (i < this.mSurfaceConfigList.size()) {
                if (iArr[i] < list.size()) {
                    zIsSupported &= ((SurfaceConfig) this.mSurfaceConfigList.get(i)).isSupported(list.get(iArr[i]));
                    if (!zIsSupported) {
                        break;
                    }
                    surfaceConfigArr[iArr[i]] = (SurfaceConfig) this.mSurfaceConfigList.get(i);
                }
                i++;
            }
            if (zIsSupported) {
                i = 1;
                break;
            }
        }
        if (i != 0) {
            return Arrays.asList(surfaceConfigArr);
        }
        return null;
    }

    private List getElementsArrangements(int i) {
        ArrayList arrayList = new ArrayList();
        generateArrangements(arrayList, i, new int[i], 0);
        return arrayList;
    }
}
