package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import androidx.camera.video.AudioStats;
import androidx.media3.common.C0740C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ColorParser;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleParser;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Ascii;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.actions.PromptPermissionAction;
import com.urbanairship.actions.RateAppAction;
import gherkin.GherkinLanguageConstants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class TtmlParser implements SubtitleParser {
    public static final int CUE_REPLACEMENT_BEHAVIOR = 1;
    private final XmlPullParserFactory xmlParserFactory;
    private static final Pattern CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern SIGNED_PERCENTAGE = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int getCueReplacementBehavior() {
        return 1;
    }

    public TtmlParser() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void parse(byte[] bArr, int i, int i2, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        LegacySubtitleUtil.toCuesWithTiming(parseToLegacySubtitle(bArr, i, i2), outputOptions, consumer);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public Subtitle parseToLegacySubtitle(byte[] bArr, int i, int i2) {
        FrameAndTickRate frameAndTickRate;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRates = DEFAULT_FRAME_AND_TICK_RATE;
            TtmlSubtitle ttmlSubtitle = null;
            int i3 = 0;
            int cellRows = 15;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i3 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRates = parseFrameAndTickRates(xmlPullParserNewPullParser);
                            cellRows = parseCellRows(xmlPullParserNewPullParser, 15);
                            ttsExtent = parseTtsExtent(xmlPullParserNewPullParser);
                        }
                        TtsExtent ttsExtent2 = ttsExtent;
                        FrameAndTickRate frameAndTickRate2 = frameAndTickRates;
                        int i4 = cellRows;
                        if (isSupportedTag(name)) {
                            if ("head".equals(name)) {
                                frameAndTickRate = frameAndTickRate2;
                                parseHeader(xmlPullParserNewPullParser, map, i4, ttsExtent2, map2, map3);
                            } else {
                                frameAndTickRate = frameAndTickRate2;
                                try {
                                    TtmlNode node = parseNode(xmlPullParserNewPullParser, ttmlNode, map2, frameAndTickRate);
                                    arrayDeque.push(node);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(node);
                                    }
                                } catch (SubtitleDecoderException e) {
                                    Log.m231w("TtmlParser", "Suppressing parser error", e);
                                    i3++;
                                }
                            }
                            frameAndTickRates = frameAndTickRate;
                        } else {
                            Log.m228i("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i3++;
                            frameAndTickRates = frameAndTickRate2;
                        }
                        ttsExtent = ttsExtent2;
                        cellRows = i4;
                    } else if (eventType == 4) {
                        ((TtmlNode) Assertions.checkNotNull(ttmlNode)).addChild(TtmlNode.buildTextNode(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.checkNotNull((TtmlNode) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i3++;
                } else if (eventType == 3) {
                    i3--;
                }
                xmlPullParserNewPullParser.next();
            }
            return (Subtitle) Assertions.checkNotNull(ttmlSubtitle);
        } catch (IOException e2) {
            throw new IllegalStateException("Unexpected error when reading input.", e2);
        } catch (XmlPullParserException e3) {
            throw new IllegalStateException("Unable to decode source", e3);
        }
    }

    private static FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser) {
        float f;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrSplit = Util.split(attributeValue2, " ");
            Assertions.checkArgument(strArrSplit.length == 2, "frameRateMultiplier doesn't have 2 parts");
            f = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
        } else {
            f = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = DEFAULT_FRAME_AND_TICK_RATE;
        int i2 = frameAndTickRate.subFrameRate;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = frameAndTickRate.tickRate;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(i * f, i2, i3);
    }

    private static int parseCellRows(XmlPullParser xmlPullParser, int i) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return i;
        }
        Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.m230w("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i;
        }
        boolean z = true;
        try {
            int i2 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)));
            int i3 = Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2)));
            if (i2 == 0 || i3 == 0) {
                z = false;
            }
            Assertions.checkArgument(z, "Invalid cell resolution " + i2 + " " + i3);
            return i3;
        } catch (NumberFormatException unused) {
            Log.m230w("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i;
        }
    }

    private static TtsExtent parseTtsExtent(XmlPullParser xmlPullParser) {
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue == null) {
            return null;
        }
        Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.m230w("TtmlParser", "Ignoring non-pixel tts extent: " + attributeValue);
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.m230w("TtmlParser", "Ignoring malformed tts extent: " + attributeValue);
            return null;
        }
    }

    private static Map parseHeader(XmlPullParser xmlPullParser, Map map, int i, TtsExtent ttsExtent, Map map2, Map map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                TtmlStyle styleAttributes = parseStyleAttributes(xmlPullParser, new TtmlStyle());
                if (attributeValue != null) {
                    for (String str : parseStyleIds(attributeValue)) {
                        styleAttributes.chain((TtmlStyle) map.get(str));
                    }
                }
                String id = styleAttributes.getId();
                if (id != null) {
                    map.put(id, styleAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                TtmlRegion regionAttributes = parseRegionAttributes(xmlPullParser, i, ttsExtent);
                if (regionAttributes != null) {
                    map2.put(regionAttributes.f140id, regionAttributes);
                }
            } else if (XmlPullParserUtil.isStartTag(xmlPullParser, "metadata")) {
                parseMetadata(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "head"));
        return map;
    }

    private static void parseMetadata(XmlPullParser xmlPullParser, Map map) throws XmlPullParserException, IOException {
        String attributeValue;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.isStartTag(xmlPullParser, MimeTypes.BASE_TYPE_IMAGE) && (attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id")) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.isEndTag(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0168  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b4  */
    private static TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser, int i, TtsExtent ttsExtent) {
        float f;
        float f2;
        float f3;
        float f4;
        int i2;
        int i3;
        byte b = 0;
        int i4 = 1;
        String attributeValue = XmlPullParserUtil.getAttributeValue(xmlPullParser, "id");
        if (attributeValue == null) {
            return null;
        }
        String attributeValue2 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "origin");
        if (attributeValue2 == null) {
            Log.m230w("TtmlParser", "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = PERCENTAGE_COORDINATES;
        Matcher matcher = pattern.matcher(attributeValue2);
        Pattern pattern2 = PIXEL_COORDINATES;
        Matcher matcher2 = pattern2.matcher(attributeValue2);
        if (matcher.matches()) {
            try {
                float f5 = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))) / 100.0f;
                f = Float.parseFloat((String) Assertions.checkNotNull(matcher.group(2))) / 100.0f;
                f2 = f5;
            } catch (NumberFormatException unused) {
                Log.m230w("TtmlParser", "Ignoring region with malformed origin: " + attributeValue2);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                Log.m230w("TtmlParser", "Ignoring region with unsupported origin: " + attributeValue2);
                return null;
            }
            if (ttsExtent == null) {
                Log.m230w("TtmlParser", "Ignoring region with missing tts:extent: " + attributeValue2);
                return null;
            }
            try {
                int i5 = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(1)));
                int i6 = Integer.parseInt((String) Assertions.checkNotNull(matcher2.group(2)));
                f2 = i5 / ttsExtent.width;
                f = i6 / ttsExtent.height;
            } catch (NumberFormatException unused2) {
                Log.m230w("TtmlParser", "Ignoring region with malformed origin: " + attributeValue2);
                return null;
            }
        }
        String attributeValue3 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "extent");
        if (attributeValue3 == null) {
            Log.m230w("TtmlParser", "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(attributeValue3);
        Matcher matcher4 = pattern2.matcher(attributeValue3);
        if (matcher3.matches()) {
            try {
                f3 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(1))) / 100.0f;
                f4 = Float.parseFloat((String) Assertions.checkNotNull(matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                Log.m230w("TtmlParser", "Ignoring region with malformed extent: " + attributeValue2);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                Log.m230w("TtmlParser", "Ignoring region with unsupported extent: " + attributeValue2);
                return null;
            }
            if (ttsExtent == null) {
                Log.m230w("TtmlParser", "Ignoring region with missing tts:extent: " + attributeValue2);
                return null;
            }
            try {
                int i7 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(1)));
                int i8 = Integer.parseInt((String) Assertions.checkNotNull(matcher4.group(2)));
                f3 = i7 / ttsExtent.width;
                f4 = i8 / ttsExtent.height;
            } catch (NumberFormatException unused4) {
                Log.m230w("TtmlParser", "Ignoring region with malformed extent: " + attributeValue2);
                return null;
            }
        }
        String attributeValue4 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "displayAlign");
        if (attributeValue4 != null) {
            String lowerCase = Ascii.toLowerCase(attributeValue4);
            lowerCase.hashCode();
            if (lowerCase.equals("center")) {
                f += f4 / 2.0f;
                i2 = 1;
            } else if (lowerCase.equals(PromptPermissionAction.AFTER_PERMISSION_STATUS_RESULT_KEY)) {
                f += f4;
                i2 = 2;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        float f6 = f;
        float f7 = 1.0f / i;
        String attributeValue5 = XmlPullParserUtil.getAttributeValue(xmlPullParser, "writingMode");
        if (attributeValue5 != null) {
            String lowerCase2 = Ascii.toLowerCase(attributeValue5);
            lowerCase2.hashCode();
            switch (lowerCase2.hashCode()) {
                case 3694:
                    if (!lowerCase2.equals(CmcdConfiguration.KEY_TOP_BITRATE)) {
                        b = -1;
                    }
                    break;
                case 3553396:
                    b = !lowerCase2.equals("tblr") ? (byte) -1 : (byte) 1;
                    break;
                case 3553576:
                    b = !lowerCase2.equals("tbrl") ? (byte) -1 : (byte) 2;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                    i3 = 2;
                    break;
                default:
                    i4 = Integer.MIN_VALUE;
                case 2:
                    i3 = i4;
                    break;
            }
        } else {
            i4 = Integer.MIN_VALUE;
            i3 = i4;
        }
        return new TtmlRegion(attributeValue, f2, f6, 0, i2, f3, f4, 1, f7, i3);
    }

    private static String[] parseStyleIds(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : Util.split(strTrim, "\\s+");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        byte b;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    b = attributeName.equals(ViewProps.FONT_STYLE) ? (byte) 0 : (byte) -1;
                    break;
                case -1224696685:
                    b = attributeName.equals(ViewProps.FONT_FAMILY) ? (byte) 1 : (byte) -1;
                    break;
                case -1065511464:
                    b = attributeName.equals(ViewProps.TEXT_ALIGN) ? (byte) 2 : (byte) -1;
                    break;
                case -879295043:
                    b = attributeName.equals("textDecoration") ? (byte) 3 : (byte) -1;
                    break;
                case -734428249:
                    b = attributeName.equals(ViewProps.FONT_WEIGHT) ? (byte) 4 : (byte) -1;
                    break;
                case 3355:
                    b = attributeName.equals("id") ? (byte) 5 : (byte) -1;
                    break;
                case 3511770:
                    b = attributeName.equals("ruby") ? (byte) 6 : (byte) -1;
                    break;
                case 94842723:
                    b = attributeName.equals("color") ? (byte) 7 : (byte) -1;
                    break;
                case 109403361:
                    b = attributeName.equals("shear") ? (byte) 8 : (byte) -1;
                    break;
                case 110138194:
                    b = attributeName.equals("textCombine") ? (byte) 9 : (byte) -1;
                    break;
                case 365601008:
                    b = attributeName.equals(ViewProps.FONT_SIZE) ? (byte) 10 : (byte) -1;
                    break;
                case 921125321:
                    b = attributeName.equals("textEmphasis") ? Ascii.f3535VT : (byte) -1;
                    break;
                case 1115953443:
                    b = attributeName.equals("rubyPosition") ? Ascii.f3524FF : (byte) -1;
                    break;
                case 1287124693:
                    b = attributeName.equals(ViewProps.BACKGROUND_COLOR) ? Ascii.f3522CR : (byte) -1;
                    break;
                case 1754920356:
                    b = attributeName.equals("multiRowAlign") ? Ascii.f3532SO : (byte) -1;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    ttmlStyle = createIfNull(ttmlStyle).setItalic("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    ttmlStyle = createIfNull(ttmlStyle).setFontFamily(attributeValue);
                    break;
                case 2:
                    ttmlStyle = createIfNull(ttmlStyle).setTextAlign(parseAlignment(attributeValue));
                    break;
                case 3:
                    String lowerCase = Ascii.toLowerCase(attributeValue);
                    lowerCase.hashCode();
                    switch (lowerCase) {
                        case "nounderline":
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(false);
                            break;
                        case "underline":
                            ttmlStyle = createIfNull(ttmlStyle).setUnderline(true);
                            break;
                        case "nolinethrough":
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(false);
                            break;
                        case "linethrough":
                            ttmlStyle = createIfNull(ttmlStyle).setLinethrough(true);
                            break;
                    }
                    break;
                case 4:
                    ttmlStyle = createIfNull(ttmlStyle).setBold("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyle = createIfNull(ttmlStyle).setId(attributeValue);
                    }
                    break;
                case 6:
                    String lowerCase2 = Ascii.toLowerCase(attributeValue);
                    lowerCase2.hashCode();
                    switch (lowerCase2) {
                        case "baseContainer":
                        case "base":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(2);
                            break;
                        case "container":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(1);
                            break;
                        case "delimiter":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(4);
                            break;
                        case "textContainer":
                        case "text":
                            ttmlStyle = createIfNull(ttmlStyle).setRubyType(3);
                            break;
                    }
                    break;
                case 7:
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setFontColor(ColorParser.parseTtmlColor(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        Log.m230w("TtmlParser", "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 8:
                    ttmlStyle = createIfNull(ttmlStyle).setShearPercentage(parseShear(attributeValue));
                    break;
                case 9:
                    String lowerCase3 = Ascii.toLowerCase(attributeValue);
                    lowerCase3.hashCode();
                    if (lowerCase3.equals(AirshipConfigOptions.FEATURE_ALL)) {
                        ttmlStyle = createIfNull(ttmlStyle).setTextCombine(true);
                    } else if (lowerCase3.equals("none")) {
                        ttmlStyle = createIfNull(ttmlStyle).setTextCombine(false);
                    }
                    break;
                case 10:
                    try {
                        ttmlStyle = createIfNull(ttmlStyle);
                        parseFontSize(attributeValue, ttmlStyle);
                    } catch (SubtitleDecoderException unused2) {
                        Log.m230w("TtmlParser", "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 11:
                    ttmlStyle = createIfNull(ttmlStyle).setTextEmphasis(TextEmphasis.parse(attributeValue));
                    break;
                case 12:
                    String lowerCase4 = Ascii.toLowerCase(attributeValue);
                    lowerCase4.hashCode();
                    if (lowerCase4.equals(PromptPermissionAction.BEFORE_PERMISSION_STATUS_RESULT_KEY)) {
                        ttmlStyle = createIfNull(ttmlStyle).setRubyPosition(1);
                    } else if (lowerCase4.equals(PromptPermissionAction.AFTER_PERMISSION_STATUS_RESULT_KEY)) {
                        ttmlStyle = createIfNull(ttmlStyle).setRubyPosition(2);
                    }
                    break;
                case 13:
                    ttmlStyle = createIfNull(ttmlStyle);
                    try {
                        ttmlStyle.setBackgroundColor(ColorParser.parseTtmlColor(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        Log.m230w("TtmlParser", "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 14:
                    ttmlStyle = createIfNull(ttmlStyle).setMultiRowAlign(parseAlignment(attributeValue));
                    break;
            }
        }
        return ttmlStyle;
    }

    private static TtmlStyle createIfNull(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static Layout.Alignment parseAlignment(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        switch (lowerCase) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:67:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:6:0x0039  */
    private static TtmlNode parseNode(XmlPullParser xmlPullParser, TtmlNode ttmlNode, Map map, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        long j;
        long j2;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle styleAttributes = parseStyleAttributes(xmlPullParser, null);
        String strSubstring = null;
        String str = "";
        long timeExpression = C0740C.TIME_UNSET;
        long timeExpression2 = C0740C.TIME_UNSET;
        long timeExpression3 = C0740C.TIME_UNSET;
        String[] strArr = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    timeExpression3 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "end":
                    timeExpression2 = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "begin":
                    timeExpression = parseTimeExpression(attributeValue, frameAndTickRate);
                    break;
                case "style":
                    String[] styleIds = parseStyleIds(attributeValue);
                    if (styleIds.length > 0) {
                        strArr = styleIds;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith(GherkinLanguageConstants.COMMENT_PREFIX)) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (ttmlNode != null) {
            long j3 = ttmlNode.startTimeUs;
            j = C0740C.TIME_UNSET;
            if (j3 != C0740C.TIME_UNSET) {
                if (timeExpression != C0740C.TIME_UNSET) {
                    timeExpression += j3;
                }
                if (timeExpression2 != C0740C.TIME_UNSET) {
                    timeExpression2 += j3;
                }
            }
        } else {
            j = C0740C.TIME_UNSET;
        }
        long j4 = timeExpression;
        if (timeExpression2 != j) {
            j2 = timeExpression2;
        } else if (timeExpression3 != j) {
            j2 = j4 + timeExpression3;
        } else if (ttmlNode != null) {
            long j5 = ttmlNode.endTimeUs;
            if (j5 != j) {
                j2 = j5;
            } else {
                j2 = timeExpression2;
            }
        } else {
            j2 = timeExpression2;
        }
        return TtmlNode.buildNode(xmlPullParser.getName(), j4, j2, styleAttributes, strArr, str, strSubstring, ttmlNode);
    }

    private static boolean isSupportedTag(String str) {
        return str.equals("tt") || str.equals("head") || str.equals(RateAppAction.BODY_KEY) || str.equals("div") || str.equals(ContextChain.TAG_PRODUCT) || str.equals("span") || str.equals(CmcdConfiguration.KEY_BITRATE) || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals(MimeTypes.BASE_TYPE_IMAGE) || str.equals("data") || str.equals("information");
    }

    private static void parseFontSize(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] strArrSplit = Util.split(str, "\\s+");
        if (strArrSplit.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (strArrSplit.length == 2) {
            matcher = FONT_SIZE.matcher(strArrSplit[1]);
            Log.m230w("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrSplit.length + InstructionFileId.DOT);
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(3));
            str2.hashCode();
            switch (str2) {
                case "%":
                    ttmlStyle.setFontSizeUnit(3);
                    break;
                case "em":
                    ttmlStyle.setFontSizeUnit(2);
                    break;
                case "px":
                    ttmlStyle.setFontSizeUnit(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
            }
            ttmlStyle.setFontSize(Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1))));
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static float parseShear(String str) {
        Matcher matcher = SIGNED_PERCENTAGE.matcher(str);
        if (!matcher.matches()) {
            Log.m230w("TtmlParser", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.checkNotNull(matcher.group(1)))));
        } catch (NumberFormatException e) {
            Log.m231w("TtmlParser", "Failed to parse shear: " + str, e);
            return Float.MAX_VALUE;
        }
    }

    private static long parseTimeExpression(String str, FrameAndTickRate frameAndTickRate) throws SubtitleDecoderException {
        double d;
        double d2;
        byte b = 4;
        Matcher matcher = CLOCK_TIME.matcher(str);
        if (matcher.matches()) {
            double d3 = (Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) * 3600) + (Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))) * 60) + Long.parseLong((String) Assertions.checkNotNull(matcher.group(3)));
            String strGroup = matcher.group(4);
            double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double d5 = d3 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d6 = d5 + (strGroup2 != null ? Long.parseLong(strGroup2) / frameAndTickRate.effectiveFrameRate : 0.0d);
            String strGroup3 = matcher.group(6);
            if (strGroup3 != null) {
                d4 = (Long.parseLong(strGroup3) / ((double) frameAndTickRate.subFrameRate)) / ((double) frameAndTickRate.effectiveFrameRate);
            }
            return (long) ((d6 + d4) * 1000000.0d);
        }
        Matcher matcher2 = OFFSET_TIME.matcher(str);
        if (matcher2.matches()) {
            double d7 = Double.parseDouble((String) Assertions.checkNotNull(matcher2.group(1)));
            String str2 = (String) Assertions.checkNotNull(matcher2.group(2));
            str2.hashCode();
            switch (str2.hashCode()) {
                case 102:
                    b = !str2.equals("f") ? (byte) -1 : (byte) 0;
                    break;
                case 104:
                    b = !str2.equals("h") ? (byte) -1 : (byte) 1;
                    break;
                case 109:
                    b = !str2.equals("m") ? (byte) -1 : (byte) 2;
                    break;
                case 116:
                    b = !str2.equals("t") ? (byte) -1 : (byte) 3;
                    break;
                case 3494:
                    if (!str2.equals("ms")) {
                        b = -1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    d = frameAndTickRate.effectiveFrameRate;
                    d7 /= d;
                    return (long) (d7 * 1000000.0d);
                case 1:
                    d2 = 3600.0d;
                    break;
                case 2:
                    d2 = 60.0d;
                    break;
                case 3:
                    d = frameAndTickRate.tickRate;
                    d7 /= d;
                    return (long) (d7 * 1000000.0d);
                case 4:
                    d = 1000.0d;
                    d7 /= d;
                    return (long) (d7 * 1000000.0d);
                default:
                    return (long) (d7 * 1000000.0d);
            }
            d7 *= d2;
            return (long) (d7 * 1000000.0d);
        }
        throw new SubtitleDecoderException("Malformed time expression: " + str);
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f, int i, int i2) {
            this.effectiveFrameRate = f;
            this.subFrameRate = i;
            this.tickRate = i2;
        }
    }

    private static final class TtsExtent {
        final int height;
        final int width;

        TtsExtent(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
