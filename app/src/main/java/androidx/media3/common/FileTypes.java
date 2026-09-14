package androidx.media3.common;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Ascii;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    public static final int AVI = 16;
    public static final int AVIF = 21;
    public static final int BMP = 19;
    public static final int FLAC = 4;
    public static final int FLV = 5;
    public static final int HEIF = 20;
    public static final int JPEG = 14;
    public static final int MATROSKA = 6;
    public static final int MIDI = 15;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;
    public static final int PNG = 17;

    /* JADX INFO: renamed from: PS */
    public static final int f100PS = 10;

    /* JADX INFO: renamed from: TS */
    public static final int f101TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBP = 18;
    public static final int WEBVTT = 13;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public static int inferFileTypeFromResponseHeaders(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : list.get(0));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int inferFileTypeFromMimeType(@Nullable String str) {
        byte b;
        if (str == null) {
            return -1;
        }
        String strNormalizeMimeType = MimeTypes.normalizeMimeType(str);
        strNormalizeMimeType.hashCode();
        switch (strNormalizeMimeType.hashCode()) {
            case -2123537834:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_E_AC3_JOC) ? (byte) -1 : (byte) 0;
                break;
            case -1662384011:
                b = !strNormalizeMimeType.equals(MimeTypes.VIDEO_PS) ? (byte) -1 : (byte) 1;
                break;
            case -1662384007:
                b = !strNormalizeMimeType.equals(MimeTypes.VIDEO_MP2T) ? (byte) -1 : (byte) 2;
                break;
            case -1662095187:
                b = !strNormalizeMimeType.equals(MimeTypes.VIDEO_WEBM) ? (byte) -1 : (byte) 3;
                break;
            case -1606874997:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_AMR_WB) ? (byte) -1 : (byte) 4;
                break;
            case -1487656890:
                b = !strNormalizeMimeType.equals(MimeTypes.IMAGE_AVIF) ? (byte) -1 : (byte) 5;
                break;
            case -1487464693:
                b = !strNormalizeMimeType.equals("image/heic") ? (byte) -1 : (byte) 6;
                break;
            case -1487464690:
                b = !strNormalizeMimeType.equals("image/heif") ? (byte) -1 : (byte) 7;
                break;
            case -1487394660:
                b = !strNormalizeMimeType.equals("image/jpeg") ? (byte) -1 : (byte) 8;
                break;
            case -1487018032:
                b = !strNormalizeMimeType.equals("image/webp") ? (byte) -1 : (byte) 9;
                break;
            case -1248337486:
                b = !strNormalizeMimeType.equals(MimeTypes.APPLICATION_MP4) ? (byte) -1 : (byte) 10;
                break;
            case -1079884372:
                b = !strNormalizeMimeType.equals(MimeTypes.VIDEO_AVI) ? (byte) -1 : Ascii.f3535VT;
                break;
            case -1004728940:
                b = !strNormalizeMimeType.equals(MimeTypes.TEXT_VTT) ? (byte) -1 : (byte) 12;
                break;
            case -879272239:
                b = !strNormalizeMimeType.equals(MimeTypes.IMAGE_BMP) ? (byte) -1 : (byte) 13;
                break;
            case -879258763:
                b = !strNormalizeMimeType.equals("image/png") ? (byte) -1 : (byte) 14;
                break;
            case -387023398:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_MATROSKA) ? (byte) -1 : (byte) 15;
                break;
            case -43467528:
                b = !strNormalizeMimeType.equals(MimeTypes.APPLICATION_WEBM) ? (byte) -1 : (byte) 16;
                break;
            case 13915911:
                b = !strNormalizeMimeType.equals(MimeTypes.VIDEO_FLV) ? (byte) -1 : (byte) 17;
                break;
            case 187078296:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_AC3) ? (byte) -1 : (byte) 18;
                break;
            case 187078297:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_AC4) ? (byte) -1 : (byte) 19;
                break;
            case 187078669:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_AMR) ? (byte) -1 : (byte) 20;
                break;
            case 187090232:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_MP4) ? (byte) -1 : (byte) 21;
                break;
            case 187091926:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_OGG) ? (byte) -1 : Ascii.SYN;
                break;
            case 187099443:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_WAV) ? (byte) -1 : Ascii.ETB;
                break;
            case 1331848029:
                b = !strNormalizeMimeType.equals(MimeTypes.VIDEO_MP4) ? (byte) -1 : Ascii.CAN;
                break;
            case 1503095341:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_AMR_NB) ? (byte) -1 : Ascii.f3523EM;
                break;
            case 1504578661:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_E_AC3) ? (byte) -1 : Ascii.SUB;
                break;
            case 1504619009:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_FLAC) ? (byte) -1 : Ascii.ESC;
                break;
            case 1504824762:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_MIDI) ? (byte) -1 : Ascii.f3525FS;
                break;
            case 1504831518:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_MPEG) ? (byte) -1 : Ascii.f3526GS;
                break;
            case 1505118770:
                b = !strNormalizeMimeType.equals(MimeTypes.AUDIO_WEBM) ? (byte) -1 : Ascii.f3530RS;
                break;
            case 2039520277:
                b = !strNormalizeMimeType.equals(MimeTypes.VIDEO_MATROSKA) ? (byte) -1 : Ascii.f3534US;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 18:
            case 26:
                return 0;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
            case 15:
            case 16:
            case 30:
            case 31:
                return 6;
            case 4:
            case 20:
            case 25:
                return 3;
            case 5:
                return 21;
            case 6:
            case 7:
                return 20;
            case 8:
                return 14;
            case 9:
                return 18;
            case 10:
            case 21:
            case 24:
                return 8;
            case 11:
                return 16;
            case 12:
                return 13;
            case 13:
                return 19;
            case 14:
                return 17;
            case 17:
                return 5;
            case 19:
                return 1;
            case 22:
                return 9;
            case 23:
                return 12;
            case 27:
                return 4;
            case 28:
                return 15;
            case 29:
                return 7;
            default:
                return -1;
        }
    }

    public static int inferFileTypeFromUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            return 20;
        }
        return lastPathSegment.endsWith(".avif") ? 21 : -1;
    }
}
