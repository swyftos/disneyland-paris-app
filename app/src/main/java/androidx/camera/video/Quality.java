package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.contentsquare.android.api.Currencies;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Quality {
    public static final Quality FHD;

    /* JADX INFO: renamed from: HD */
    public static final Quality f28HD;
    public static final Quality HIGHEST;
    public static final Quality LOWEST;
    static final Quality NONE;
    private static final Set QUALITIES;
    private static final List QUALITIES_ORDER_BY_SIZE;

    /* JADX INFO: renamed from: SD */
    public static final Quality f29SD;
    public static final Quality UHD;

    private Quality() {
    }

    static {
        ConstantQuality constantQualityM75of = ConstantQuality.m75of(4, "SD", Collections.unmodifiableList(Arrays.asList(new Size(720, Currencies.MUR), new Size(640, Currencies.MUR))));
        f29SD = constantQualityM75of;
        ConstantQuality constantQualityM75of2 = ConstantQuality.m75of(5, "HD", Collections.singletonList(new Size(1280, 720)));
        f28HD = constantQualityM75of2;
        ConstantQuality constantQualityM75of3 = ConstantQuality.m75of(6, "FHD", Collections.singletonList(new Size(1920, 1080)));
        FHD = constantQualityM75of3;
        ConstantQuality constantQualityM75of4 = ConstantQuality.m75of(8, "UHD", Collections.singletonList(new Size(3840, 2160)));
        UHD = constantQualityM75of4;
        ConstantQuality constantQualityM75of5 = ConstantQuality.m75of(0, "LOWEST", Collections.emptyList());
        LOWEST = constantQualityM75of5;
        ConstantQuality constantQualityM75of6 = ConstantQuality.m75of(1, "HIGHEST", Collections.emptyList());
        HIGHEST = constantQualityM75of6;
        NONE = ConstantQuality.m75of(-1, "NONE", Collections.emptyList());
        QUALITIES = new HashSet(Arrays.asList(constantQualityM75of5, constantQualityM75of6, constantQualityM75of, constantQualityM75of2, constantQualityM75of3, constantQualityM75of4));
        QUALITIES_ORDER_BY_SIZE = Arrays.asList(constantQualityM75of4, constantQualityM75of3, constantQualityM75of2, constantQualityM75of);
    }

    static boolean containsQuality(Quality quality) {
        return QUALITIES.contains(quality);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static List<Quality> getSortedQualities() {
        return new ArrayList(QUALITIES_ORDER_BY_SIZE);
    }

    @AutoValue
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class ConstantQuality extends Quality {
        @NonNull
        public abstract String getName();

        @NonNull
        public abstract List<Size> getTypicalSizes();

        public abstract int getValue();

        public ConstantQuality() {
            super();
        }

        /* JADX INFO: renamed from: of */
        static ConstantQuality m75of(int i, String str, List list) {
            return new AutoValue_Quality_ConstantQuality(i, str, list);
        }
    }
}
