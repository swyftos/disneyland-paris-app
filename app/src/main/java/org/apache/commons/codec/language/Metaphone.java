package org.apache.commons.codec.language;

import androidx.media3.extractor.p007ts.TsExtractor;
import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.api.Currencies;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: loaded from: classes6.dex */
public class Metaphone implements StringEncoder {
    private int maxCodeLen = 4;

    private boolean isLastChar(int i, int i2) {
        return i2 + 1 == i;
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0207  */
    public String metaphone(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return "";
        }
        if (length == 1) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        char[] charArray = str.toUpperCase(Locale.ENGLISH).toCharArray();
        StringBuilder sb = new StringBuilder(40);
        StringBuilder sb2 = new StringBuilder(10);
        int i = 0;
        char c = charArray[0];
        if (c != 'A') {
            if (c == 'G' || c == 'K' || c == 'P') {
                if (charArray[1] == 'N') {
                    sb.append(charArray, 1, charArray.length - 1);
                } else {
                    sb.append(charArray);
                }
            } else if (c == 'W') {
                char c2 = charArray[1];
                if (c2 == 'R') {
                    sb.append(charArray, 1, charArray.length - 1);
                } else if (c2 == 'H') {
                    sb.append(charArray, 1, charArray.length - 1);
                    sb.setCharAt(0, 'W');
                } else {
                    sb.append(charArray);
                }
            } else if (c == 'X') {
                charArray[0] = 'S';
                sb.append(charArray);
            } else {
                sb.append(charArray);
            }
        } else if (charArray[1] == 'E') {
            sb.append(charArray, 1, charArray.length - 1);
        } else {
            sb.append(charArray);
        }
        int length2 = sb.length();
        while (sb2.length() < getMaxCodeLen() && i < length2) {
            char cCharAt = sb.charAt(i);
            if (cCharAt == 'C' || !isPreviousChar(sb, i, cCharAt)) {
                switch (cCharAt) {
                    case EACTags.ELEMENT_LIST /* 65 */:
                    case EACTags.DISPLAY_IMAGE /* 69 */:
                    case 'I':
                    case 'O':
                    case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                        if (i == 0) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case EACTags.ADDRESS /* 66 */:
                        if (!isPreviousChar(sb, i, 'M') || !isLastChar(length2, i)) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case 'C':
                        if (!isPreviousChar(sb, i, 'S') || isLastChar(length2, i) || "EIY".indexOf(sb.charAt(i + 1)) < 0) {
                            if (regionMatch(sb, i, "CIA")) {
                                sb2.append('X');
                            } else if (!isLastChar(length2, i) && "EIY".indexOf(sb.charAt(i + 1)) >= 0) {
                                sb2.append('S');
                            } else if ((!isPreviousChar(sb, i, 'S') || !isNextChar(sb, i, 'H')) && isNextChar(sb, i, 'H')) {
                                if (i == 0 && length2 >= 3 && isVowel(sb, 2)) {
                                    sb2.append('K');
                                } else {
                                    sb2.append('X');
                                }
                            } else {
                                sb2.append('K');
                            }
                        }
                        break;
                    case 'D':
                        if (!isLastChar(length2, i + 1) && isNextChar(sb, i, 'G')) {
                            int i2 = i + 2;
                            if ("EIY".indexOf(sb.charAt(i2)) >= 0) {
                                sb2.append('J');
                                i = i2;
                            } else {
                                sb2.append('T');
                            }
                        } else {
                            sb2.append('T');
                        }
                        break;
                    case 'F':
                    case EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY /* 74 */:
                    case 'L':
                    case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                    case 'N':
                    case EACTags.HISTORICAL_BYTES /* 82 */:
                        sb2.append(cCharAt);
                        break;
                    case 'G':
                        int i3 = i + 1;
                        if ((!isLastChar(length2, i3) || !isNextChar(sb, i, 'H')) && ((isLastChar(length2, i3) || !isNextChar(sb, i, 'H') || isVowel(sb, i + 2)) && (i <= 0 || (!regionMatch(sb, i, "GN") && !regionMatch(sb, i, "GNED"))))) {
                            boolean zIsPreviousChar = isPreviousChar(sb, i, 'G');
                            if (!isLastChar(length2, i) && "EIY".indexOf(sb.charAt(i3)) >= 0 && !zIsPreviousChar) {
                                sb2.append('J');
                            } else {
                                sb2.append('K');
                            }
                        }
                        break;
                    case 'H':
                        if (!isLastChar(length2, i) && ((i <= 0 || "CSPTG".indexOf(sb.charAt(i - 1)) < 0) && isVowel(sb, i + 1))) {
                            sb2.append('H');
                        }
                        break;
                    case EACTags.DEPRECATED /* 75 */:
                        if (i <= 0 || !isPreviousChar(sb, i, 'C')) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case 'P':
                        if (isNextChar(sb, i, 'H')) {
                            sb2.append('F');
                        } else {
                            sb2.append(cCharAt);
                        }
                        break;
                    case EACTags.ANSWER_TO_RESET /* 81 */:
                        sb2.append('K');
                        break;
                    case 'S':
                        if (regionMatch(sb, i, "SH") || regionMatch(sb, i, "SIO") || regionMatch(sb, i, "SIA")) {
                            sb2.append('X');
                        } else {
                            sb2.append('S');
                        }
                        break;
                    case Currencies.BZD /* 84 */:
                        if (regionMatch(sb, i, "TIA") || regionMatch(sb, i, "TIO")) {
                            sb2.append('X');
                        } else if (!regionMatch(sb, i, "TCH")) {
                            if (regionMatch(sb, i, "TH")) {
                                sb2.append('0');
                            } else {
                                sb2.append('T');
                            }
                        }
                        break;
                    case 'V':
                        sb2.append('F');
                        break;
                    case 'W':
                    case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                        if (!isLastChar(length2, i) && isVowel(sb, i + 1)) {
                            sb2.append(cCharAt);
                        }
                        break;
                    case SyslogConstants.LOG_FTP /* 88 */:
                        sb2.append('K');
                        sb2.append('S');
                        break;
                    case 'Z':
                        sb2.append('S');
                        break;
                }
                i++;
            } else {
                i++;
            }
            if (sb2.length() > getMaxCodeLen()) {
                sb2.setLength(getMaxCodeLen());
            }
        }
        return sb2.toString();
    }

    private boolean isVowel(StringBuilder sb, int i) {
        return "AEIOU".indexOf(sb.charAt(i)) >= 0;
    }

    private boolean isPreviousChar(StringBuilder sb, int i, char c) {
        return i > 0 && i < sb.length() && sb.charAt(i - 1) == c;
    }

    private boolean isNextChar(StringBuilder sb, int i, char c) {
        return i >= 0 && i < sb.length() - 1 && sb.charAt(i + 1) == c;
    }

    private boolean regionMatch(StringBuilder sb, int i, String str) {
        if (i < 0 || (str.length() + i) - 1 >= sb.length()) {
            return false;
        }
        return sb.substring(i, str.length() + i).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (!(obj instanceof String)) {
            throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
        }
        return metaphone((String) obj);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }
}
