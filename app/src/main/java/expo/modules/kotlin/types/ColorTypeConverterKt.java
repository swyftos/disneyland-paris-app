package expo.modules.kotlin.types;

import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.recyclerview.widget.ItemTouchHelper;
import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.api.Currencies;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;
import org.bouncycastle.math.Primes;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1836d2 = {"namedColors", "", "", "", "", "expo-modules-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nColorTypeConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorTypeConverter.kt\nexpo/modules/kotlin/types/ColorTypeConverterKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,238:1\n462#2:239\n412#2:240\n1246#3,2:241\n1249#3:247\n11165#4:243\n11500#4,3:244\n*S KotlinDebug\n*F\n+ 1 ColorTypeConverter.kt\nexpo/modules/kotlin/types/ColorTypeConverterKt\n*L\n168#1:239\n168#1:240\n168#1:241,2\n168#1:247\n169#1:243\n169#1:244,3\n*E\n"})
public final class ColorTypeConverterKt {
    private static final Map namedColors;

    static {
        Integer numValueOf = Integer.valueOf(PsExtractor.VIDEO_STREAM_MASK);
        Pair pairM1842to = TuplesKt.m1842to("aliceblue", new Integer[]{numValueOf, 248, 255, 255});
        Integer numValueOf2 = Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        Pair pairM1842to2 = TuplesKt.m1842to("antiquewhite", new Integer[]{numValueOf2, 235, Integer.valueOf(JfifUtil.MARKER_RST7), 255});
        Pair pairM1842to3 = TuplesKt.m1842to("aqua", new Integer[]{0, 255, 255, 255});
        Pair pairM1842to4 = TuplesKt.m1842to("aquamarine", new Integer[]{127, 255, 212, 255});
        Pair pairM1842to5 = TuplesKt.m1842to("azure", new Integer[]{numValueOf, 255, 255, 255});
        Pair pairM1842to6 = TuplesKt.m1842to("beige", new Integer[]{245, 245, 220, 255});
        Pair pairM1842to7 = TuplesKt.m1842to("bisque", new Integer[]{255, 228, 196, 255});
        Pair pairM1842to8 = TuplesKt.m1842to("black", new Integer[]{0, 0, 0, 255});
        Integer numValueOf3 = Integer.valueOf(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR);
        Pair pairM1842to9 = TuplesKt.m1842to("blanchedalmond", new Integer[]{255, 235, numValueOf3, 255});
        Pair pairM1842to10 = TuplesKt.m1842to("blue", new Integer[]{0, 0, 255, 255});
        Pair pairM1842to11 = TuplesKt.m1842to("blueviolet", new Integer[]{Integer.valueOf(TsExtractor.TS_STREAM_TYPE_DTS), 43, 226, 255});
        Pair pairM1842to12 = TuplesKt.m1842to("brown", new Integer[]{165, 42, 42, 255});
        Pair pairM1842to13 = TuplesKt.m1842to("burlywood", new Integer[]{Integer.valueOf(Currencies.SVC), Integer.valueOf(SyslogConstants.LOG_LOCAL7), Integer.valueOf(TsExtractor.TS_STREAM_TYPE_E_AC3), 255});
        Pair pairM1842to14 = TuplesKt.m1842to("cadetblue", new Integer[]{95, 158, 160, 255});
        Pair pairM1842to15 = TuplesKt.m1842to("chartreuse", new Integer[]{127, 255, 0, 255});
        Pair pairM1842to16 = TuplesKt.m1842to("chocolate", new Integer[]{210, 105, 30, 255});
        Pair pairM1842to17 = TuplesKt.m1842to("coral", new Integer[]{255, 127, 80, 255});
        Pair pairM1842to18 = TuplesKt.m1842to("cornflowerblue", new Integer[]{100, 149, 237, 255});
        Pair pairM1842to19 = TuplesKt.m1842to("cornsilk", new Integer[]{255, 248, 220, 255});
        Pair pairM1842to20 = TuplesKt.m1842to("crimson", new Integer[]{220, 20, 60, 255});
        Pair pairM1842to21 = TuplesKt.m1842to("cyan", new Integer[]{0, 255, 255, 255});
        Integer numValueOf4 = Integer.valueOf(TsExtractor.TS_STREAM_TYPE_DTS_UHD);
        Pair pairM1842to22 = TuplesKt.m1842to("darkblue", new Integer[]{0, 0, numValueOf4, 255});
        Pair pairM1842to23 = TuplesKt.m1842to("darkcyan", new Integer[]{0, numValueOf4, numValueOf4, 255});
        Pair pairM1842to24 = TuplesKt.m1842to("darkgoldenrod", new Integer[]{Integer.valueOf(SyslogConstants.LOG_LOCAL7), Integer.valueOf(TsExtractor.TS_STREAM_TYPE_SPLICE_INFO), 11, 255});
        Pair pairM1842to25 = TuplesKt.m1842to("darkgray", new Integer[]{169, 169, 169, 255});
        Pair pairM1842to26 = TuplesKt.m1842to("darkgreen", new Integer[]{0, 100, 0, 255});
        Pair pairM1842to27 = TuplesKt.m1842to("darkgrey", new Integer[]{169, 169, 169, 255});
        Pair pairM1842to28 = TuplesKt.m1842to("darkkhaki", new Integer[]{Integer.valueOf(PsExtractor.PRIVATE_STREAM_1), 183, Integer.valueOf(PublicKeyAlgorithmTags.EXPERIMENTAL_8), 255});
        Pair pairM1842to29 = TuplesKt.m1842to("darkmagenta", new Integer[]{numValueOf4, 0, numValueOf4, 255});
        Pair pairM1842to30 = TuplesKt.m1842to("darkolivegreen", new Integer[]{85, Integer.valueOf(PublicKeyAlgorithmTags.EXPERIMENTAL_8), 47, 255});
        Pair pairM1842to31 = TuplesKt.m1842to("darkorange", new Integer[]{255, 140, 0, 255});
        Pair pairM1842to32 = TuplesKt.m1842to("darkorchid", new Integer[]{153, 50, Integer.valueOf(MlKitException.CODE_SCANNER_TASK_IN_PROGRESS), 255});
        Pair pairM1842to33 = TuplesKt.m1842to("darkred", new Integer[]{numValueOf4, 0, 0, 255});
        Pair pairM1842to34 = TuplesKt.m1842to("darksalmon", new Integer[]{233, 150, 122, 255});
        Pair pairM1842to35 = TuplesKt.m1842to("darkseagreen", new Integer[]{143, 188, 143, 255});
        Pair pairM1842to36 = TuplesKt.m1842to("darkslateblue", new Integer[]{72, 61, numValueOf4, 255});
        Pair pairM1842to37 = TuplesKt.m1842to("darkslategray", new Integer[]{47, 79, 79, 255});
        Pair pairM1842to38 = TuplesKt.m1842to("darkslategrey", new Integer[]{47, 79, 79, 255});
        Pair pairM1842to39 = TuplesKt.m1842to("darkturquoise", new Integer[]{0, Integer.valueOf(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR), 209, 255});
        Integer numValueOf5 = Integer.valueOf(Primes.SMALL_FACTOR_LIMIT);
        Pair pairM1842to40 = TuplesKt.m1842to("darkviolet", new Integer[]{148, 0, numValueOf5, 255});
        Pair pairM1842to41 = TuplesKt.m1842to("deeppink", new Integer[]{255, 20, 147, 255});
        Pair pairM1842to42 = TuplesKt.m1842to("deepskyblue", new Integer[]{0, Integer.valueOf(Currencies.HRK), 255, 255});
        Pair pairM1842to43 = TuplesKt.m1842to("dimgray", new Integer[]{105, 105, 105, 255});
        Pair pairM1842to44 = TuplesKt.m1842to("dimgrey", new Integer[]{105, 105, 105, 255});
        Pair pairM1842to45 = TuplesKt.m1842to("dodgerblue", new Integer[]{30, 144, 255, 255});
        Pair pairM1842to46 = TuplesKt.m1842to("firebrick", new Integer[]{178, 34, 34, 255});
        Pair pairM1842to47 = TuplesKt.m1842to("floralwhite", new Integer[]{255, numValueOf2, numValueOf, 255});
        Pair pairM1842to48 = TuplesKt.m1842to("forestgreen", new Integer[]{34, numValueOf4, 34, 255});
        Pair pairM1842to49 = TuplesKt.m1842to("fuchsia", new Integer[]{255, 0, 255, 255});
        Pair pairM1842to50 = TuplesKt.m1842to("gainsboro", new Integer[]{220, 220, 220, 255});
        Pair pairM1842to51 = TuplesKt.m1842to("ghostwhite", new Integer[]{248, 248, 255, 255});
        Pair pairM1842to52 = TuplesKt.m1842to("gold", new Integer[]{255, Integer.valueOf(JfifUtil.MARKER_RST7), 0, 255});
        Pair pairM1842to53 = TuplesKt.m1842to("goldenrod", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOS), 165, 32, 255});
        Pair pairM1842to54 = TuplesKt.m1842to("gray", new Integer[]{128, 128, 128, 255});
        Pair pairM1842to55 = TuplesKt.m1842to("green", new Integer[]{0, 128, 0, 255});
        Pair pairM1842to56 = TuplesKt.m1842to("greenyellow", new Integer[]{173, 255, 47, 255});
        Pair pairM1842to57 = TuplesKt.m1842to("grey", new Integer[]{128, 128, 128, 255});
        Pair pairM1842to58 = TuplesKt.m1842to("honeydew", new Integer[]{numValueOf, 255, numValueOf, 255});
        Pair pairM1842to59 = TuplesKt.m1842to("hotpink", new Integer[]{255, 105, Integer.valueOf(RotationOptions.ROTATE_180), 255});
        Pair pairM1842to60 = TuplesKt.m1842to("indianred", new Integer[]{numValueOf3, 92, 92, 255});
        Pair pairM1842to61 = TuplesKt.m1842to("indigo", new Integer[]{75, 0, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS), 255});
        Pair pairM1842to62 = TuplesKt.m1842to("ivory", new Integer[]{255, 255, numValueOf, 255});
        Integer numValueOf6 = Integer.valueOf(Currencies.ETB);
        Pair pairM1842to63 = TuplesKt.m1842to("khaki", new Integer[]{numValueOf, numValueOf6, 140, 255});
        Pair pairM1842to64 = TuplesKt.m1842to("lavender", new Integer[]{numValueOf6, numValueOf6, numValueOf2, 255});
        Pair pairM1842to65 = TuplesKt.m1842to("lavenderblush", new Integer[]{255, numValueOf, 245, 255});
        Pair pairM1842to66 = TuplesKt.m1842to("lawngreen", new Integer[]{Integer.valueOf(Currencies.CAD), 252, 0, 255});
        Pair pairM1842to67 = TuplesKt.m1842to("lemonchiffon", new Integer[]{255, numValueOf2, numValueOf3, 255});
        Pair pairM1842to68 = TuplesKt.m1842to("lightblue", new Integer[]{173, Integer.valueOf(JfifUtil.MARKER_SOI), numValueOf6, 255});
        Pair pairM1842to69 = TuplesKt.m1842to("lightcoral", new Integer[]{numValueOf, 128, 128, 255});
        Pair pairM1842to70 = TuplesKt.m1842to("lightcyan", new Integer[]{224, 255, 255, 255});
        Pair pairM1842to71 = TuplesKt.m1842to("lightgoldenrodyellow", new Integer[]{numValueOf2, numValueOf2, 210, 255});
        Pair pairM1842to72 = TuplesKt.m1842to("lightgray", new Integer[]{numValueOf5, numValueOf5, numValueOf5, 255});
        Integer numValueOf7 = Integer.valueOf(Currencies.FKP);
        Pair pairM1842to73 = TuplesKt.m1842to("lightgreen", new Integer[]{144, numValueOf7, 144, 255});
        Pair pairM1842to74 = TuplesKt.m1842to("lightgrey", new Integer[]{numValueOf5, numValueOf5, numValueOf5, 255});
        Pair pairM1842to75 = TuplesKt.m1842to("lightpink", new Integer[]{255, 182, 193, 255});
        Pair pairM1842to76 = TuplesKt.m1842to("lightsalmon", new Integer[]{255, 160, 122, 255});
        Pair pairM1842to77 = TuplesKt.m1842to("lightseagreen", new Integer[]{32, 178, Integer.valueOf(Currencies.COP), 255});
        Pair pairM1842to78 = TuplesKt.m1842to("lightskyblue", new Integer[]{Integer.valueOf(TsExtractor.TS_STREAM_TYPE_E_AC3), Integer.valueOf(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR), numValueOf2, 255});
        Pair pairM1842to79 = TuplesKt.m1842to("lightslategray", new Integer[]{119, 136, 153, 255});
        Pair pairM1842to80 = TuplesKt.m1842to("lightslategrey", new Integer[]{119, 136, 153, 255});
        Pair pairM1842to81 = TuplesKt.m1842to("lightsteelblue", new Integer[]{Integer.valueOf(SyslogConstants.LOG_LOCAL6), 196, Integer.valueOf(Currencies.SVC), 255});
        Pair pairM1842to82 = TuplesKt.m1842to("lightyellow", new Integer[]{255, 255, 224, 255});
        Pair pairM1842to83 = TuplesKt.m1842to("lime", new Integer[]{0, 255, 0, 255});
        Pair pairM1842to84 = TuplesKt.m1842to("limegreen", new Integer[]{50, numValueOf3, 50, 255});
        Pair pairM1842to85 = TuplesKt.m1842to("linen", new Integer[]{numValueOf2, numValueOf, numValueOf6, 255});
        Pair pairM1842to86 = TuplesKt.m1842to("magenta", new Integer[]{255, 0, 255, 255});
        Pair pairM1842to87 = TuplesKt.m1842to("maroon", new Integer[]{128, 0, 0, 255});
        Pair pairM1842to88 = TuplesKt.m1842to("mediumaquamarine", new Integer[]{102, numValueOf3, Integer.valueOf(Currencies.COP), 255});
        Pair pairM1842to89 = TuplesKt.m1842to("mediumblue", new Integer[]{0, 0, numValueOf3, 255});
        Pair pairM1842to90 = TuplesKt.m1842to("mediumorchid", new Integer[]{186, 85, numValueOf5, 255});
        Integer numValueOf8 = Integer.valueOf(SyslogConstants.LOG_ALERT);
        Map mapMapOf = MapsKt.mapOf(pairM1842to, pairM1842to2, pairM1842to3, pairM1842to4, pairM1842to5, pairM1842to6, pairM1842to7, pairM1842to8, pairM1842to9, pairM1842to10, pairM1842to11, pairM1842to12, pairM1842to13, pairM1842to14, pairM1842to15, pairM1842to16, pairM1842to17, pairM1842to18, pairM1842to19, pairM1842to20, pairM1842to21, pairM1842to22, pairM1842to23, pairM1842to24, pairM1842to25, pairM1842to26, pairM1842to27, pairM1842to28, pairM1842to29, pairM1842to30, pairM1842to31, pairM1842to32, pairM1842to33, pairM1842to34, pairM1842to35, pairM1842to36, pairM1842to37, pairM1842to38, pairM1842to39, pairM1842to40, pairM1842to41, pairM1842to42, pairM1842to43, pairM1842to44, pairM1842to45, pairM1842to46, pairM1842to47, pairM1842to48, pairM1842to49, pairM1842to50, pairM1842to51, pairM1842to52, pairM1842to53, pairM1842to54, pairM1842to55, pairM1842to56, pairM1842to57, pairM1842to58, pairM1842to59, pairM1842to60, pairM1842to61, pairM1842to62, pairM1842to63, pairM1842to64, pairM1842to65, pairM1842to66, pairM1842to67, pairM1842to68, pairM1842to69, pairM1842to70, pairM1842to71, pairM1842to72, pairM1842to73, pairM1842to74, pairM1842to75, pairM1842to76, pairM1842to77, pairM1842to78, pairM1842to79, pairM1842to80, pairM1842to81, pairM1842to82, pairM1842to83, pairM1842to84, pairM1842to85, pairM1842to86, pairM1842to87, pairM1842to88, pairM1842to89, pairM1842to90, TuplesKt.m1842to("mediumpurple", new Integer[]{147, numValueOf8, 219, 255}), TuplesKt.m1842to("mediumseagreen", new Integer[]{60, 179, 113, 255}), TuplesKt.m1842to("mediumslateblue", new Integer[]{123, 104, numValueOf7, 255}), TuplesKt.m1842to("mediumspringgreen", new Integer[]{0, numValueOf2, 154, 255}), TuplesKt.m1842to("mediumturquoise", new Integer[]{72, 209, Integer.valueOf(MlKitException.CODE_SCANNER_TASK_IN_PROGRESS), 255}), TuplesKt.m1842to("mediumvioletred", new Integer[]{199, 21, 133, 255}), TuplesKt.m1842to("midnightblue", new Integer[]{25, 25, numValueOf8, 255}), TuplesKt.m1842to("mintcream", new Integer[]{245, 255, numValueOf2, 255}), TuplesKt.m1842to("mistyrose", new Integer[]{255, 228, Integer.valueOf(JfifUtil.MARKER_APP1), 255}), TuplesKt.m1842to("moccasin", new Integer[]{255, 228, 181, 255}), TuplesKt.m1842to("navajowhite", new Integer[]{255, Integer.valueOf(Currencies.SVC), 173, 255}), TuplesKt.m1842to("navy", new Integer[]{0, 0, 128, 255}), TuplesKt.m1842to("oldlace", new Integer[]{253, 245, numValueOf6, 255}), TuplesKt.m1842to("olive", new Integer[]{128, 128, 0, 255}), TuplesKt.m1842to("olivedrab", new Integer[]{Integer.valueOf(PublicKeyAlgorithmTags.EXPERIMENTAL_8), 142, 35, 255}), TuplesKt.m1842to("orange", new Integer[]{255, 165, 0, 255}), TuplesKt.m1842to("orangered", new Integer[]{255, 69, 0, 255}), TuplesKt.m1842to("orchid", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOS), numValueOf8, Integer.valueOf(Currencies.DOP), 255}), TuplesKt.m1842to("palegoldenrod", new Integer[]{numValueOf7, Integer.valueOf(Currencies.ERN), Integer.valueOf(Currencies.COP), 255}), TuplesKt.m1842to("palegreen", new Integer[]{152, 251, 152, 255}), TuplesKt.m1842to("paleturquoise", new Integer[]{175, numValueOf7, numValueOf7, 255}), TuplesKt.m1842to("palevioletred", new Integer[]{219, numValueOf8, 147, 255}), TuplesKt.m1842to("papayawhip", new Integer[]{255, 239, 213, 255}), TuplesKt.m1842to("peachpuff", new Integer[]{255, Integer.valueOf(JfifUtil.MARKER_SOS), 185, 255}), TuplesKt.m1842to("peru", new Integer[]{numValueOf3, 133, 63, 255}), TuplesKt.m1842to("pink", new Integer[]{255, 192, 203, 255}), TuplesKt.m1842to("plum", new Integer[]{221, 160, 221, 255}), TuplesKt.m1842to("powderblue", new Integer[]{Integer.valueOf(SyslogConstants.LOG_LOCAL6), 224, numValueOf6, 255}), TuplesKt.m1842to("purple", new Integer[]{128, 0, 128, 255}), TuplesKt.m1842to("rebeccapurple", new Integer[]{102, 51, 153, 255}), TuplesKt.m1842to("red", new Integer[]{255, 0, 0, 255}), TuplesKt.m1842to("rosybrown", new Integer[]{188, 143, 143, 255}), TuplesKt.m1842to("royalblue", new Integer[]{65, 105, Integer.valueOf(JfifUtil.MARKER_APP1), 255}), TuplesKt.m1842to("saddlebrown", new Integer[]{numValueOf4, 69, 19, 255}), TuplesKt.m1842to("salmon", new Integer[]{numValueOf2, 128, 114, 255}), TuplesKt.m1842to("sandybrown", new Integer[]{244, 164, 96, 255}), TuplesKt.m1842to("seagreen", new Integer[]{46, numValueOf4, 87, 255}), TuplesKt.m1842to("seashell", new Integer[]{255, 245, numValueOf7, 255}), TuplesKt.m1842to("sienna", new Integer[]{160, 82, 45, 255}), TuplesKt.m1842to("silver", new Integer[]{192, 192, 192, 255}), TuplesKt.m1842to("skyblue", new Integer[]{Integer.valueOf(TsExtractor.TS_STREAM_TYPE_E_AC3), Integer.valueOf(MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR), 235, 255}), TuplesKt.m1842to("slateblue", new Integer[]{Integer.valueOf(PublicKeyAlgorithmTags.EXPERIMENTAL_7), 90, numValueOf3, 255}), TuplesKt.m1842to("slategray", new Integer[]{numValueOf8, 128, 144, 255}), TuplesKt.m1842to("slategrey", new Integer[]{numValueOf8, 128, 144, 255}), TuplesKt.m1842to("snow", new Integer[]{255, numValueOf2, numValueOf2, 255}), TuplesKt.m1842to("springgreen", new Integer[]{0, 255, 127, 255}), TuplesKt.m1842to("steelblue", new Integer[]{70, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS), Integer.valueOf(RotationOptions.ROTATE_180), 255}), TuplesKt.m1842to("tan", new Integer[]{210, Integer.valueOf(RotationOptions.ROTATE_180), 140, 255}), TuplesKt.m1842to("teal", new Integer[]{0, 128, 128, 255}), TuplesKt.m1842to("thistle", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOI), Integer.valueOf(Currencies.HRK), Integer.valueOf(JfifUtil.MARKER_SOI), 255}), TuplesKt.m1842to("tomato", new Integer[]{255, 99, 71, 255}), TuplesKt.m1842to("transparent", new Integer[]{0, 0, 0, 0}), TuplesKt.m1842to("turquoise", new Integer[]{64, 224, 208, 255}), TuplesKt.m1842to("violet", new Integer[]{numValueOf7, Integer.valueOf(TsExtractor.TS_STREAM_TYPE_HDMV_DTS), numValueOf7, 255}), TuplesKt.m1842to("wheat", new Integer[]{245, Integer.valueOf(Currencies.SVC), 179, 255}), TuplesKt.m1842to("white", new Integer[]{255, 255, 255, 255}), TuplesKt.m1842to("whitesmoke", new Integer[]{245, 245, 245, 255}), TuplesKt.m1842to("yellow", new Integer[]{255, 255, 0, 255}), TuplesKt.m1842to("yellowgreen", new Integer[]{154, numValueOf3, 50, 255}));
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapMapOf.size()));
        for (Map.Entry entry : mapMapOf.entrySet()) {
            Object key = entry.getKey();
            Integer[] numArr = (Integer[]) entry.getValue();
            ArrayList arrayList = new ArrayList(numArr.length);
            for (Integer num : numArr) {
                arrayList.add(Float.valueOf(num.intValue() / 255.0f));
            }
            linkedHashMap.put(key, arrayList);
        }
        namedColors = linkedHashMap;
    }
}
