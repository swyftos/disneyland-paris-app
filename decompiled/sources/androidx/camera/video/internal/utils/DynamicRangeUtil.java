package androidx.camera.video.internal.utils;

import androidx.annotation.NonNull;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import androidx.media3.common.MimeTypes;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class DynamicRangeUtil {
    public static final Map<Integer, Set<Integer>> DR_TO_VP_BIT_DEPTH_MAP;
    public static final Map<Integer, Set<Integer>> DR_TO_VP_FORMAT_MAP;
    private static final Map MIME_TO_DEFAULT_PROFILE_LEVEL_MAP;
    public static final Map<Integer, Integer> VP_TO_DR_BIT_DEPTH;
    public static final Map<Integer, Integer> VP_TO_DR_FORMAT_MAP;

    static {
        HashMap map = new HashMap();
        DR_TO_VP_BIT_DEPTH_MAP = map;
        HashMap map2 = new HashMap();
        DR_TO_VP_FORMAT_MAP = map2;
        HashMap map3 = new HashMap();
        VP_TO_DR_BIT_DEPTH = map3;
        HashMap map4 = new HashMap();
        VP_TO_DR_FORMAT_MAP = map4;
        HashMap map5 = new HashMap();
        MIME_TO_DEFAULT_PROFILE_LEVEL_MAP = map5;
        map.put(8, new HashSet(Collections.singletonList(8)));
        map.put(10, new HashSet(Collections.singletonList(10)));
        map.put(0, new HashSet(Arrays.asList(8, 10)));
        map2.put(0, new HashSet(Arrays.asList(0, 1, 2, 3, 4)));
        map2.put(1, new HashSet(Collections.singletonList(0)));
        map2.put(2, new HashSet(Arrays.asList(1, 2, 3, 4)));
        map2.put(3, new HashSet(Collections.singletonList(1)));
        map2.put(4, new HashSet(Collections.singletonList(2)));
        map2.put(5, new HashSet(Collections.singletonList(3)));
        map2.put(6, new HashSet(Collections.singletonList(4)));
        map3.put(8, 8);
        map3.put(10, 10);
        map4.put(0, 1);
        map4.put(1, 3);
        map4.put(2, 4);
        map4.put(3, 5);
        map4.put(4, 6);
        HashMap map6 = new HashMap();
        DynamicRange dynamicRange = DynamicRange.SDR;
        map6.put(dynamicRange, 1);
        DynamicRange dynamicRange2 = DynamicRange.HLG_10_BIT;
        map6.put(dynamicRange2, 2);
        DynamicRange dynamicRange3 = DynamicRange.HDR10_10_BIT;
        map6.put(dynamicRange3, 4096);
        DynamicRange dynamicRange4 = DynamicRange.HDR10_PLUS_10_BIT;
        map6.put(dynamicRange4, 8192);
        HashMap map7 = new HashMap();
        map7.put(dynamicRange, 1);
        map7.put(dynamicRange2, 2);
        map7.put(dynamicRange3, 4096);
        map7.put(dynamicRange4, 8192);
        HashMap map8 = new HashMap();
        map8.put(dynamicRange, 1);
        map8.put(dynamicRange2, 4);
        map8.put(dynamicRange3, 4096);
        map8.put(dynamicRange4, 16384);
        HashMap map9 = new HashMap();
        map9.put(DynamicRange.DOLBY_VISION_10_BIT, 256);
        map9.put(DynamicRange.DOLBY_VISION_8_BIT, 512);
        map5.put(MimeTypes.VIDEO_H265, map6);
        map5.put(MimeTypes.VIDEO_AV1, map7);
        map5.put(MimeTypes.VIDEO_VP9, map8);
        map5.put(MimeTypes.VIDEO_DOLBY_VISION, map9);
    }

    @NonNull
    public static Set<Integer> dynamicRangeToVideoProfileHdrFormats(@NonNull DynamicRange dynamicRange) {
        Set<Integer> set = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(dynamicRange.getEncoding()));
        return set == null ? Collections.emptySet() : set;
    }

    @NonNull
    public static Set<Integer> dynamicRangeToVideoProfileBitDepth(@NonNull DynamicRange dynamicRange) {
        Set<Integer> set = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(dynamicRange.getBitDepth()));
        return set == null ? Collections.emptySet() : set;
    }

    public static int dynamicRangeToCodecProfileLevelForMime(@NonNull String str, @NonNull DynamicRange dynamicRange) {
        Integer num;
        Map map = (Map) MIME_TO_DEFAULT_PROFILE_LEVEL_MAP.get(str);
        if (map == null || (num = (Integer) map.get(dynamicRange)) == null) {
            return -1;
        }
        return num.intValue();
    }

    public static int videoProfileHdrFormatsToDynamicRangeEncoding(int i) {
        Map<Integer, Integer> map = VP_TO_DR_FORMAT_MAP;
        Preconditions.checkArgument(map.containsKey(Integer.valueOf(i)));
        Integer num = map.get(Integer.valueOf(i));
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public static int videoProfileBitDepthToDynamicRangeBitDepth(int i) {
        Map<Integer, Integer> map = VP_TO_DR_BIT_DEPTH;
        Preconditions.checkArgument(map.containsKey(Integer.valueOf(i)));
        Integer num = map.get(Integer.valueOf(i));
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public static boolean isHdrSettingsMatched(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, @NonNull DynamicRange dynamicRange) {
        return isBitDepthMatched(videoProfileProxy.getBitDepth(), dynamicRange) && isHdrEncodingMatched(videoProfileProxy.getHdrFormat(), dynamicRange);
    }

    private static boolean isBitDepthMatched(int i, DynamicRange dynamicRange) {
        Set<Integer> set = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(dynamicRange.getBitDepth()));
        return set != null && set.contains(Integer.valueOf(i));
    }

    private static boolean isHdrEncodingMatched(int i, DynamicRange dynamicRange) {
        Set<Integer> set = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(dynamicRange.getEncoding()));
        return set != null && set.contains(Integer.valueOf(i));
    }
}
