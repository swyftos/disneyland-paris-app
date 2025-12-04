package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
class QualityRatioToResolutionsTable {
    private static final Map sAspectRatioMap;
    private static final Map sQualityRangeMap;
    private final Map mTable = new HashMap();

    static {
        HashMap map = new HashMap();
        sQualityRangeMap = map;
        map.put(Quality.UHD, Range.create(2160, 4319));
        map.put(Quality.FHD, Range.create(1080, 1439));
        map.put(Quality.HD, Range.create(720, 1079));
        map.put(Quality.SD, Range.create(241, Integer.valueOf(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD)));
        HashMap map2 = new HashMap();
        sAspectRatioMap = map2;
        map2.put(0, AspectRatioUtil.ASPECT_RATIO_4_3);
        map2.put(1, AspectRatioUtil.ASPECT_RATIO_16_9);
    }

    QualityRatioToResolutionsTable(List list, Map map) {
        for (Quality quality : sQualityRangeMap.keySet()) {
            this.mTable.put(QualityRatio.of(quality, -1), new ArrayList());
            Iterator it = sAspectRatioMap.keySet().iterator();
            while (it.hasNext()) {
                this.mTable.put(QualityRatio.of(quality, ((Integer) it.next()).intValue()), new ArrayList());
            }
        }
        addProfileSizesToTable(map);
        addResolutionsToTable(list);
        sortQualityRatioRow(map);
    }

    List getResolutions(Quality quality, int i) {
        List qualityRatioRow = getQualityRatioRow(quality, i);
        return qualityRatioRow != null ? new ArrayList(qualityRatioRow) : new ArrayList(0);
    }

    private void addProfileSizesToTable(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            List qualityRatioRow = getQualityRatioRow((Quality) entry.getKey(), -1);
            Objects.requireNonNull(qualityRatioRow);
            qualityRatioRow.add((Size) entry.getValue());
        }
    }

    private void addResolutionsToTable(List list) {
        Integer numFindMappedAspectRatio;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Size size = (Size) it.next();
            Quality qualityFindMappedQuality = findMappedQuality(size);
            if (qualityFindMappedQuality != null && (numFindMappedAspectRatio = findMappedAspectRatio(size)) != null) {
                List qualityRatioRow = getQualityRatioRow(qualityFindMappedQuality, numFindMappedAspectRatio.intValue());
                Objects.requireNonNull(qualityRatioRow);
                qualityRatioRow.add(size);
            }
        }
    }

    private void sortQualityRatioRow(Map map) {
        for (Map.Entry entry : this.mTable.entrySet()) {
            Size size = (Size) map.get(((QualityRatio) entry.getKey()).getQuality());
            if (size != null) {
                final int area = SizeUtil.getArea(size);
                Collections.sort((List) entry.getValue(), new Comparator() { // from class: androidx.camera.video.QualityRatioToResolutionsTable$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return QualityRatioToResolutionsTable.lambda$sortQualityRatioRow$0(area, (Size) obj, (Size) obj2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortQualityRatioRow$0(int i, Size size, Size size2) {
        return Math.abs(SizeUtil.getArea(size) - i) - Math.abs(SizeUtil.getArea(size2) - i);
    }

    private static Quality findMappedQuality(Size size) {
        for (Map.Entry entry : sQualityRangeMap.entrySet()) {
            if (((Range) entry.getValue()).contains((Range) Integer.valueOf(size.getHeight()))) {
                return (Quality) entry.getKey();
            }
        }
        return null;
    }

    private static Integer findMappedAspectRatio(Size size) {
        for (Map.Entry entry : sAspectRatioMap.entrySet()) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, (Rational) entry.getValue(), SizeUtil.RESOLUTION_QVGA)) {
                return (Integer) entry.getKey();
            }
        }
        return null;
    }

    private List getQualityRatioRow(Quality quality, int i) {
        return (List) this.mTable.get(QualityRatio.of(quality, i));
    }

    static abstract class QualityRatio {
        abstract int getAspectRatio();

        abstract Quality getQuality();

        QualityRatio() {
        }

        static QualityRatio of(Quality quality, int i) {
            return new AutoValue_QualityRatioToResolutionsTable_QualityRatio(quality, i);
        }
    }
}
