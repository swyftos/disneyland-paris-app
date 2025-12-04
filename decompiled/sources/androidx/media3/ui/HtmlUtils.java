package androidx.media3.ui;

import android.graphics.Color;
import androidx.media3.common.util.Util;
import com.amazonaws.services.s3.model.InstructionFileId;

/* loaded from: classes2.dex */
abstract class HtmlUtils {
    public static String toCssRgba(int i) {
        return Util.formatInvariant("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }

    public static String cssAllClassDescendantsSelector(String str) {
        return InstructionFileId.DOT + str + ",." + str + " *";
    }
}
