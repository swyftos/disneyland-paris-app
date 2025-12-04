package org.bouncycastle.apache.bzip2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.media3.extractor.ts.TsExtractor;
import ch.qos.logback.core.net.SyslogConstants;
import com.amazonaws.services.s3.internal.Constants;
import com.contentsquare.android.api.Currencies;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.TiffUtil;
import com.google.android.material.internal.ViewUtils;
import com.google.mlkit.common.MlKitException;
import com.microsoft.appcenter.crashes.utils.ErrorLogHelper;
import okhttp3.internal.ws.WebSocketProtocol;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;

/* loaded from: classes6.dex */
public interface BZip2Constants {
    public static final int G_SIZE = 50;
    public static final int MAX_ALPHA_SIZE = 258;
    public static final int MAX_CODE_LEN = 23;
    public static final int MAX_SELECTORS = 18002;
    public static final int NUM_OVERSHOOT_BYTES = 20;
    public static final int N_GROUPS = 6;
    public static final int N_ITERS = 4;
    public static final int RUNA = 0;
    public static final int RUNB = 1;
    public static final int baseBlockSize = 100000;
    public static final int[] rNums = {619, 720, 127, 481, Currencies.CUC, 816, 813, 233, Currencies.NGN, 247, Currencies.PLN, 724, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, Currencies.MWK, 863, 491, 741, Currencies.FJD, Currencies.TRY, Currencies.DOP, 733, 859, 335, 708, 621, 574, 73, Currencies.SHP, 730, 472, 419, 436, 278, Currencies.MNT, 867, 210, 399, 680, Currencies.MUR, 51, 878, 465, 811, 169, 869, 675, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, 697, 867, 561, 862, 687, TypedValues.PositionType.TYPE_PERCENT_Y, 283, 482, TsExtractor.TS_STREAM_TYPE_AC3, Currencies.MKD, 591, 733, 623, 150, Currencies.FKP, 59, 379, 684, 877, 625, 169, Currencies.RUB, 105, Currencies.COP, TypedValues.MotionType.TYPE_PATHMOTION_ARC, 520, Currencies.ZWL, 727, 476, 693, TypedValues.CycleType.TYPE_WAVE_PHASE, Currencies.KMF, 647, 73, 122, 335, 530, 442, 853, 695, 249, 445, 515, 909, 545, 703, 919, 874, 474, Currencies.WST, 500, 594, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 641, 801, 220, 162, 819, Currencies.BOV, 589, InputDeviceCompat.SOURCE_DPAD, 495, 799, 161, 604, Currencies.XBD, Currencies.AWG, 221, 400, 386, 867, 600, 782, 382, 596, Currencies.KWD, 171, Currencies.NAD, 375, Currencies.SAR, 485, 911, 276, 98, 553, 163, 354, 666, Currencies.BYN, TypedValues.CycleType.TYPE_WAVE_OFFSET, 341, Currencies.AWG, 870, 227, 730, 475, 186, 263, 647, 537, 686, 600, 224, 469, 68, 770, 919, 190, 373, 294, 822, 808, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, SyslogConstants.LOG_LOCAL7, Currencies.MZN, 795, 384, 383, 461, 404, 758, 839, 887, 715, 67, 618, 276, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 918, 873, 777, 604, 560, Currencies.XCD, 160, Currencies.NOK, 722, 79, 804, 96, 409, 713, Currencies.UYI, 652, Currencies.TMT, Currencies.COU, 447, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 353, 859, 672, SyslogConstants.LOG_ALERT, 785, 645, 863, 803, 350, TsExtractor.TS_STREAM_TYPE_DTS_UHD, 93, 354, 99, 820, 908, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 772, 154, TiffUtil.TIFF_TAG_ORIENTATION, 580, SyslogConstants.LOG_LOCAL7, 79, 626, 630, 742, 653, 282, 762, 623, 680, 81, Currencies.UYW, 626, 789, ErrorLogHelper.MAX_PROPERTY_ITEM_LENGTH, 411, 521, Currencies.SDG, 300, 821, 78, 343, 175, 128, 250, Currencies.COP, 774, Currencies.TJS, 275, 999, 639, 495, 78, Currencies.ISK, WebSocketProtocol.PAYLOAD_SHORT, 857, Currencies.XBB, 358, 619, 580, Currencies.CAD, 737, 594, TypedValues.TransitionType.TYPE_FROM, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 669, SyslogConstants.LOG_ALERT, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, Currencies.SLL, 363, 992, 809, 743, SyslogConstants.LOG_LOCAL5, 974, Currencies.AZN, 375, Currencies.SZL, 52, 600, 747, 642, 182, 862, 81, Currencies.HKD, 805, 988, 739, FrameMetricsAggregator.EVERY_DURATION, 655, 814, 334, 249, 515, 897, Currencies.XBA, 664, Currencies.GEL, 649, 113, 974, 459, 893, 228, 433, 837, 553, 268, Currencies.VED, PsExtractor.VIDEO_STREAM_MASK, 102, Currencies.SHP, 459, 51, 686, 754, 806, Currencies.SYP, 493, 403, 415, 394, 687, 700, Currencies.RON, 670, 656, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 738, Currencies.JPY, Currencies.SYP, 799, 887, 653, Currencies.EUR, 321, 576, 617, 626, TypedValues.PositionType.TYPE_DRAWPATH, 894, 679, 243, 440, 680, 879, 194, 572, 640, 724, Currencies.VED, 56, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 700, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 151, 457, 449, 797, 195, 791, Currencies.NIO, 945, 679, 297, 59, 87, 824, 713, 663, Constants.FAILED_PRECONDITION_STATUS_CODE, 693, 342, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, 108, 571, Currencies.IRR, 631, 212, Currencies.KMF, Currencies.RUB, 304, 329, 343, 97, Currencies.LRD, 751, 497, 314, 983, 374, 822, Currencies.VES, 140, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 73, 263, Currencies.UAH, 736, 876, 478, Currencies.LRD, 305, Currencies.COP, SyslogConstants.SYSLOG_PORT, Currencies.IRR, 692, 829, 82, 855, Currencies.XPF, 676, 246, 369, Currencies.COU, 294, 750, Currencies.MKD, 827, 150, 790, 288, 923, 804, 378, JfifUtil.MARKER_RST7, 828, 592, 281, 565, 555, Currencies.ZAR, 82, 896, 831, 547, 261, Currencies.NPR, Currencies.MVR, 293, 465, TypedValues.PositionType.TYPE_DRAWPATH, 56, 661, 821, Currencies.CDF, 991, 658, 869, TypedValues.Custom.TYPE_DIMENSION, 758, 745, 193, ViewUtils.EDGE_TO_EDGE_FLAGS, 550, 608, Currencies.BYN, 378, 286, JfifUtil.MARKER_RST7, Currencies.MXV, 792, Currencies.XAG, 61, 688, 793, 644, Currencies.BRL, 403, PublicKeyAlgorithmTags.EXPERIMENTAL_7, 366, TypedValues.Custom.TYPE_DIMENSION, 644, 372, 567, 466, Currencies.LYD, 645, 210, 389, 550, 919, TsExtractor.TS_STREAM_TYPE_E_AC3, Currencies.TTD, 773, 635, 389, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 100, 626, Currencies.XBD, 165, 504, 920, SyslogConstants.LOG_LOCAL6, 193, 713, 857, 265, 203, 50, 668, 108, 645, Currencies.CLF, 626, 197, TypedValues.PositionType.TYPE_POSITION_TYPE, 357, 358, 850, Currencies.UYU, Currencies.IRR, Currencies.GHS, 638};
}
