package com.caverock.androidsvg;

import android.graphics.Matrix;
import android.util.Log;
import android.util.Xml;
import androidx.core.internal.view.SupportMenu;
import androidx.media3.extractor.p007ts.PsExtractor;
import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.api.Currencies;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.AirshipConfigOptions;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import net.zetetic.database.DatabaseUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.bouncycastle.asn1.eac.EACTags;
import org.bouncycastle.bcpg.PacketTags;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class SVGParser {
    private int ignoreDepth;
    private SVG svgDocument = null;
    private SVG.SvgContainer currentElement = null;
    private boolean ignoring = false;
    private boolean inMetadataElement = false;
    private SVGElem metadataTag = null;
    private StringBuilder metadataElementContents = null;
    private boolean inStyleElement = false;
    private StringBuilder styleElementContents = null;

    private void debug(String str, Object... objArr) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endDocument() {
    }

    private static float hueToRgb(float f, float f2, float f3) {
        float f4;
        if (f3 < BitmapDescriptorFactory.HUE_RED) {
            f3 += 6.0f;
        }
        if (f3 >= 6.0f) {
            f3 -= 6.0f;
        }
        if (f3 < 1.0f) {
            f4 = (f2 - f) * f3;
        } else {
            if (f3 < 3.0f) {
                return f2;
            }
            if (f3 >= 4.0f) {
                return f;
            }
            f4 = (f2 - f) * (4.0f - f3);
        }
        return f4 + f;
    }

    SVGParser() {
    }

    private enum SVGElem {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;

        private static final Map cache = new HashMap();

        static {
            for (SVGElem sVGElem : values()) {
                if (sVGElem == SWITCH) {
                    cache.put("switch", sVGElem);
                } else if (sVGElem != UNSUPPORTED) {
                    cache.put(sVGElem.name(), sVGElem);
                }
            }
        }

        public static SVGElem fromString(String str) {
            SVGElem sVGElem = (SVGElem) cache.get(str);
            return sVGElem != null ? sVGElem : UNSUPPORTED;
        }
    }

    private enum SVGAttr {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;

        private static final Map cache = new HashMap();

        static {
            for (SVGAttr sVGAttr : values()) {
                if (sVGAttr == CLASS) {
                    cache.put("class", sVGAttr);
                } else {
                    if (sVGAttr != UNSUPPORTED) {
                        cache.put(sVGAttr.name().replace('_', '-'), sVGAttr);
                    }
                }
            }
        }

        public static SVGAttr fromString(String str) {
            SVGAttr sVGAttr = (SVGAttr) cache.get(str);
            return sVGAttr != null ? sVGAttr : UNSUPPORTED;
        }
    }

    private static class ColourKeywords {
        private static final Map colourKeywords;

        static {
            HashMap map = new HashMap(47);
            colourKeywords = map;
            map.put("aliceblue", -984833);
            map.put("antiquewhite", -332841);
            map.put("aqua", -16711681);
            map.put("aquamarine", -8388652);
            map.put("azure", -983041);
            map.put("beige", -657956);
            map.put("bisque", -6972);
            map.put("black", -16777216);
            map.put("blanchedalmond", -5171);
            map.put("blue", -16776961);
            map.put("blueviolet", -7722014);
            map.put("brown", -5952982);
            map.put("burlywood", -2180985);
            map.put("cadetblue", -10510688);
            map.put("chartreuse", -8388864);
            map.put("chocolate", -2987746);
            map.put("coral", -32944);
            map.put("cornflowerblue", -10185235);
            map.put("cornsilk", -1828);
            map.put("crimson", -2354116);
            map.put("cyan", -16711681);
            map.put("darkblue", -16777077);
            map.put("darkcyan", -16741493);
            map.put("darkgoldenrod", -4684277);
            map.put("darkgray", -5658199);
            map.put("darkgreen", -16751616);
            map.put("darkgrey", -5658199);
            map.put("darkkhaki", -4343957);
            map.put("darkmagenta", -7667573);
            map.put("darkolivegreen", -11179217);
            map.put("darkorange", -29696);
            map.put("darkorchid", -6737204);
            map.put("darkred", -7667712);
            map.put("darksalmon", -1468806);
            map.put("darkseagreen", -7357297);
            map.put("darkslateblue", -12042869);
            map.put("darkslategray", -13676721);
            map.put("darkslategrey", -13676721);
            map.put("darkturquoise", -16724271);
            map.put("darkviolet", -7077677);
            map.put("deeppink", -60269);
            map.put("deepskyblue", -16728065);
            map.put("dimgray", -9868951);
            map.put("dimgrey", -9868951);
            map.put("dodgerblue", -14774017);
            map.put("firebrick", -5103070);
            map.put("floralwhite", -1296);
            map.put("forestgreen", -14513374);
            map.put("fuchsia", -65281);
            map.put("gainsboro", -2302756);
            map.put("ghostwhite", -460545);
            map.put("gold", -10496);
            map.put("goldenrod", -2448096);
            map.put("gray", -8355712);
            map.put("green", -16744448);
            map.put("greenyellow", -5374161);
            map.put("grey", -8355712);
            map.put("honeydew", -983056);
            map.put("hotpink", -38476);
            map.put("indianred", -3318692);
            map.put("indigo", -11861886);
            map.put("ivory", -16);
            map.put("khaki", -989556);
            map.put("lavender", -1644806);
            map.put("lavenderblush", -3851);
            map.put("lawngreen", -8586240);
            map.put("lemonchiffon", -1331);
            map.put("lightblue", -5383962);
            map.put("lightcoral", -1015680);
            map.put("lightcyan", -2031617);
            map.put("lightgoldenrodyellow", -329006);
            map.put("lightgray", -2894893);
            map.put("lightgreen", -7278960);
            map.put("lightgrey", -2894893);
            map.put("lightpink", -18751);
            map.put("lightsalmon", -24454);
            map.put("lightseagreen", -14634326);
            map.put("lightskyblue", -7876870);
            map.put("lightslategray", -8943463);
            map.put("lightslategrey", -8943463);
            map.put("lightsteelblue", -5192482);
            map.put("lightyellow", -32);
            map.put("lime", -16711936);
            map.put("limegreen", -13447886);
            map.put("linen", -331546);
            map.put("magenta", -65281);
            map.put("maroon", -8388608);
            map.put("mediumaquamarine", -10039894);
            map.put("mediumblue", -16777011);
            map.put("mediumorchid", -4565549);
            map.put("mediumpurple", -7114533);
            map.put("mediumseagreen", -12799119);
            map.put("mediumslateblue", -8689426);
            map.put("mediumspringgreen", -16713062);
            map.put("mediumturquoise", -12004916);
            map.put("mediumvioletred", -3730043);
            map.put("midnightblue", -15132304);
            map.put("mintcream", -655366);
            map.put("mistyrose", -6943);
            map.put("moccasin", -6987);
            map.put("navajowhite", -8531);
            map.put("navy", -16777088);
            map.put("oldlace", -133658);
            map.put("olive", -8355840);
            map.put("olivedrab", -9728477);
            map.put("orange", -23296);
            map.put("orangered", -47872);
            map.put("orchid", -2461482);
            map.put("palegoldenrod", -1120086);
            map.put("palegreen", -6751336);
            map.put("paleturquoise", -5247250);
            map.put("palevioletred", -2396013);
            map.put("papayawhip", -4139);
            map.put("peachpuff", -9543);
            map.put("peru", -3308225);
            map.put("pink", -16181);
            map.put("plum", -2252579);
            map.put("powderblue", -5185306);
            map.put("purple", -8388480);
            map.put("rebeccapurple", -10079335);
            map.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
            map.put("rosybrown", -4419697);
            map.put("royalblue", -12490271);
            map.put("saddlebrown", -7650029);
            map.put("salmon", -360334);
            map.put("sandybrown", -744352);
            map.put("seagreen", -13726889);
            map.put("seashell", -2578);
            map.put("sienna", -6270419);
            map.put("silver", -4144960);
            map.put("skyblue", -7876885);
            map.put("slateblue", -9807155);
            map.put("slategray", -9404272);
            map.put("slategrey", -9404272);
            map.put("snow", -1286);
            map.put("springgreen", -16711809);
            map.put("steelblue", -12156236);
            map.put("tan", -2968436);
            map.put("teal", -16744320);
            map.put("thistle", -2572328);
            map.put("tomato", -40121);
            map.put("turquoise", -12525360);
            map.put("violet", -1146130);
            map.put("wheat", -663885);
            map.put("white", -1);
            map.put("whitesmoke", -657931);
            map.put("yellow", -256);
            map.put("yellowgreen", -6632142);
            map.put("transparent", 0);
        }

        static Integer get(String str) {
            return (Integer) colourKeywords.get(str);
        }
    }

    private static class FontSizeKeywords {
        private static final Map fontSizeKeywords;

        static {
            HashMap map = new HashMap(9);
            fontSizeKeywords = map;
            SVG.Unit unit = SVG.Unit.pt;
            map.put("xx-small", new SVG.Length(0.694f, unit));
            map.put("x-small", new SVG.Length(0.833f, unit));
            map.put("small", new SVG.Length(10.0f, unit));
            map.put("medium", new SVG.Length(12.0f, unit));
            map.put("large", new SVG.Length(14.4f, unit));
            map.put("x-large", new SVG.Length(17.3f, unit));
            map.put("xx-large", new SVG.Length(20.7f, unit));
            SVG.Unit unit2 = SVG.Unit.percent;
            map.put("smaller", new SVG.Length(83.33f, unit2));
            map.put("larger", new SVG.Length(120.0f, unit2));
        }

        static SVG.Length get(String str) {
            return (SVG.Length) fontSizeKeywords.get(str);
        }
    }

    private static class FontWeightKeywords {
        private static final Map fontWeightKeywords;

        static {
            HashMap map = new HashMap(13);
            fontWeightKeywords = map;
            map.put("normal", 400);
            map.put("bold", 700);
            map.put("bolder", 1);
            map.put("lighter", -1);
            map.put("100", 100);
            map.put("200", 200);
            map.put("300", 300);
            map.put("400", 400);
            map.put("500", 500);
            map.put("600", 600);
            map.put("700", 700);
            map.put("800", Integer.valueOf(Currencies.UGX));
            map.put("900", 900);
        }

        static Integer get(String str) {
            return (Integer) fontWeightKeywords.get(str);
        }
    }

    private static class AspectRatioKeywords {
        private static final Map aspectRatioKeywords;

        static {
            HashMap map = new HashMap(10);
            aspectRatioKeywords = map;
            map.put("none", PreserveAspectRatio.Alignment.none);
            map.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            map.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            map.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            map.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            map.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            map.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            map.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            map.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            map.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }

        static PreserveAspectRatio.Alignment get(String str) {
            return (PreserveAspectRatio.Alignment) aspectRatioKeywords.get(str);
        }
    }

    SVG parse(InputStream inputStream, boolean z) {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int i = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (i == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            parseUsingXmlPullParser(inputStream, z);
            return this.svgDocument;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Log.e("SVGParser", "Exception thrown closing input stream");
            }
        }
    }

    private class XPPAttributesWrapper implements Attributes {
        private XmlPullParser parser;

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }

        public XPPAttributesWrapper(XmlPullParser xmlPullParser) {
            this.parser = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.parser.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i) {
            return this.parser.getAttributeNamespace(i);
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i) {
            return this.parser.getAttributeName(i);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i) {
            String attributeName = this.parser.getAttributeName(i);
            if (this.parser.getAttributePrefix(i) == null) {
                return attributeName;
            }
            return this.parser.getAttributePrefix(i) + ':' + attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i) {
            return this.parser.getAttributeValue(i);
        }
    }

    private void parseUsingXmlPullParser(InputStream inputStream, boolean z) throws SVGParseException {
        try {
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                XPPAttributesWrapper xPPAttributesWrapper = new XPPAttributesWrapper(xmlPullParserNewPullParser);
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                xmlPullParserNewPullParser.setInput(inputStream, null);
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.nextToken()) {
                    if (eventType == 0) {
                        startDocument();
                    } else if (eventType == 8) {
                        Log.d("SVGParser", "PROC INSTR: " + xmlPullParserNewPullParser.getText());
                        TextScanner textScanner = new TextScanner(xmlPullParserNewPullParser.getText());
                        handleProcessingInstruction(textScanner.nextToken(), parseProcessingInstructionAttributes(textScanner));
                    } else if (eventType == 10) {
                        if (z && this.svgDocument.getRootElement() == null && xmlPullParserNewPullParser.getText().contains("<!ENTITY ")) {
                            try {
                                Log.d("SVGParser", "Switching to SAX parser to process entities");
                                inputStream.reset();
                                parseUsingSAX(inputStream);
                                return;
                            } catch (IOException unused) {
                                Log.w("SVGParser", "Detected internal entity definitions, but could not parse them.");
                                return;
                            }
                        }
                    } else if (eventType == 2) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (xmlPullParserNewPullParser.getPrefix() != null) {
                            name = xmlPullParserNewPullParser.getPrefix() + ':' + name;
                        }
                        startElement(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name, xPPAttributesWrapper);
                    } else if (eventType == 3) {
                        String name2 = xmlPullParserNewPullParser.getName();
                        if (xmlPullParserNewPullParser.getPrefix() != null) {
                            name2 = xmlPullParserNewPullParser.getPrefix() + ':' + name2;
                        }
                        endElement(xmlPullParserNewPullParser.getNamespace(), xmlPullParserNewPullParser.getName(), name2);
                    } else if (eventType == 4) {
                        int[] iArr = new int[2];
                        text(xmlPullParserNewPullParser.getTextCharacters(iArr), iArr[0], iArr[1]);
                    } else if (eventType == 5) {
                        text(xmlPullParserNewPullParser.getText());
                    }
                }
                endDocument();
            } catch (XmlPullParserException e) {
                throw new SVGParseException("XML parser problem", e);
            }
        } catch (IOException e2) {
            throw new SVGParseException("Stream error", e2);
        }
    }

    private void parseUsingSAX(InputStream inputStream) throws SVGParseException {
        Log.d("SVGParser", "Falling back to SAX parser");
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = sAXParserFactoryNewInstance.newSAXParser().getXMLReader();
            SAXHandler sAXHandler = new SAXHandler(this, null);
            xMLReader.setContentHandler(sAXHandler);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", sAXHandler);
            xMLReader.parse(new InputSource(inputStream));
        } catch (IOException e) {
            throw new SVGParseException("Stream error", e);
        } catch (ParserConfigurationException e2) {
            throw new SVGParseException("XML parser problem", e2);
        } catch (SAXException e3) {
            throw new SVGParseException("SVG parse error", e3);
        }
    }

    private class SAXHandler extends DefaultHandler2 {
        private SAXHandler() {
        }

        /* synthetic */ SAXHandler(SVGParser sVGParser, C23561 c23561) {
            this();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() {
            SVGParser.this.startDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
            SVGParser.this.startElement(str, str2, str3, attributes);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            SVGParser.this.text(new String(cArr, i, i2));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            SVGParser.this.endElement(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() {
            SVGParser.this.endDocument();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
            SVGParser.this.handleProcessingInstruction(str, SVGParser.this.parseProcessingInstructionAttributes(new TextScanner(str2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDocument() {
        this.svgDocument = new SVG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SVGParseException {
        if (this.ignoring) {
            this.ignoreDepth++;
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            SVGElem sVGElemFromString = SVGElem.fromString(str2);
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[sVGElemFromString.ordinal()]) {
                case 1:
                    svg(attributes);
                    break;
                case 2:
                case 3:
                    m740g(attributes);
                    break;
                case 4:
                    defs(attributes);
                    break;
                case 5:
                    use(attributes);
                    break;
                case 6:
                    path(attributes);
                    break;
                case 7:
                    rect(attributes);
                    break;
                case 8:
                    circle(attributes);
                    break;
                case 9:
                    ellipse(attributes);
                    break;
                case 10:
                    line(attributes);
                    break;
                case 11:
                    polyline(attributes);
                    break;
                case 12:
                    polygon(attributes);
                    break;
                case 13:
                    text(attributes);
                    break;
                case 14:
                    tspan(attributes);
                    break;
                case 15:
                    tref(attributes);
                    break;
                case 16:
                    zwitch(attributes);
                    break;
                case 17:
                    symbol(attributes);
                    break;
                case 18:
                    marker(attributes);
                    break;
                case 19:
                    linearGradient(attributes);
                    break;
                case 20:
                    radialGradient(attributes);
                    break;
                case 21:
                    stop(attributes);
                    break;
                case 22:
                case 23:
                    this.inMetadataElement = true;
                    this.metadataTag = sVGElemFromString;
                    break;
                case 24:
                    clipPath(attributes);
                    break;
                case 25:
                    textPath(attributes);
                    break;
                case 26:
                    pattern(attributes);
                    break;
                case 27:
                    image(attributes);
                    break;
                case 28:
                    view(attributes);
                    break;
                case 29:
                    mask(attributes);
                    break;
                case 30:
                    style(attributes);
                    break;
                case 31:
                    solidColor(attributes);
                    break;
                default:
                    this.ignoring = true;
                    this.ignoreDepth = 1;
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void text(String str) {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(str.length());
            }
            this.metadataElementContents.append(str);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(str.length());
            }
            this.styleElementContents.append(str);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(str);
        }
    }

    private void text(char[] cArr, int i, int i2) {
        if (this.ignoring) {
            return;
        }
        if (this.inMetadataElement) {
            if (this.metadataElementContents == null) {
                this.metadataElementContents = new StringBuilder(i2);
            }
            this.metadataElementContents.append(cArr, i, i2);
        } else if (this.inStyleElement) {
            if (this.styleElementContents == null) {
                this.styleElementContents = new StringBuilder(i2);
            }
            this.styleElementContents.append(cArr, i, i2);
        } else if (this.currentElement instanceof SVG.TextContainer) {
            appendToTextContainer(new String(cArr, i, i2));
        }
    }

    private void appendToTextContainer(String str) {
        SVG.SvgConditionalContainer svgConditionalContainer = (SVG.SvgConditionalContainer) this.currentElement;
        int size = svgConditionalContainer.children.size();
        SVG.SvgObject svgObject = size == 0 ? null : (SVG.SvgObject) svgConditionalContainer.children.get(size - 1);
        if (svgObject instanceof SVG.TextSequence) {
            StringBuilder sb = new StringBuilder();
            SVG.TextSequence textSequence = (SVG.TextSequence) svgObject;
            sb.append(textSequence.text);
            sb.append(str);
            textSequence.text = sb.toString();
            return;
        }
        this.currentElement.addChild(new SVG.TextSequence(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endElement(String str, String str2, String str3) {
        if (this.ignoring) {
            int i = this.ignoreDepth - 1;
            this.ignoreDepth = i;
            if (i == 0) {
                this.ignoring = false;
                return;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.fromString(str2).ordinal()];
            if (i2 != 1 && i2 != 2 && i2 != 4 && i2 != 5 && i2 != 13 && i2 != 14) {
                switch (i2) {
                    case 22:
                    case 23:
                        this.inMetadataElement = false;
                        StringBuilder sb = this.metadataElementContents;
                        if (sb != null) {
                            SVGElem sVGElem = this.metadataTag;
                            if (sVGElem == SVGElem.title) {
                                this.svgDocument.setTitle(sb.toString());
                            } else if (sVGElem == SVGElem.desc) {
                                this.svgDocument.setDesc(sb.toString());
                            }
                            this.metadataElementContents.setLength(0);
                        }
                        break;
                    case 30:
                        StringBuilder sb2 = this.styleElementContents;
                        if (sb2 != null) {
                            this.inStyleElement = false;
                            parseCSSStyleSheet(sb2.toString());
                            this.styleElementContents.setLength(0);
                        }
                        break;
                }
                return;
            }
            this.currentElement = ((SVG.SvgObject) this.currentElement).parent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProcessingInstruction(String str, Map map) {
        String str2;
        String strResolveCSSStyleSheet;
        if (!str.equals("xml-stylesheet") || SVG.getFileResolver() == null) {
            return;
        }
        if (((String) map.get("type")) == null || "text/css".equals(map.get("type"))) {
            if ((((String) map.get("alternate")) != null && !BooleanUtils.f3980NO.equals(map.get("alternate"))) || (str2 = (String) map.get("href")) == null || (strResolveCSSStyleSheet = SVG.getFileResolver().resolveCSSStyleSheet(str2)) == null) {
                return;
            }
            String str3 = (String) map.get("media");
            if (str3 != null && !AirshipConfigOptions.FEATURE_ALL.equals(str3.trim())) {
                strResolveCSSStyleSheet = "@media " + str3 + " { " + strResolveCSSStyleSheet + "}";
            }
            parseCSSStyleSheet(strResolveCSSStyleSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map parseProcessingInstructionAttributes(TextScanner textScanner) {
        HashMap map = new HashMap();
        textScanner.skipWhitespace();
        String strNextToken = textScanner.nextToken('=');
        while (strNextToken != null) {
            textScanner.consume('=');
            map.put(strNextToken, textScanner.nextQuotedString());
            textScanner.skipWhitespace();
            strNextToken = textScanner.nextToken('=');
        }
        return map;
    }

    private void svg(Attributes attributes) throws SVGParseException {
        debug("<svg>", new Object[0]);
        SVG.Svg svg = new SVG.Svg();
        svg.document = this.svgDocument;
        svg.parent = this.currentElement;
        parseAttributesCore(svg, attributes);
        parseAttributesStyle(svg, attributes);
        parseAttributesConditional(svg, attributes);
        parseAttributesViewBox(svg, attributes);
        parseAttributesSVG(svg, attributes);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            this.svgDocument.setRootElement(svg);
        } else {
            svgContainer.addChild(svg);
        }
        this.currentElement = svg;
    }

    private void parseAttributesSVG(SVG.Svg svg, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                svg.f1056x = parseLength(strTrim);
            } else if (i2 == 2) {
                svg.f1057y = parseLength(strTrim);
            } else if (i2 == 3) {
                SVG.Length length = parseLength(strTrim);
                svg.width = length;
                if (length.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length length2 = parseLength(strTrim);
                svg.height = length2;
                if (length2.isNegative()) {
                    throw new SVGParseException("Invalid <svg> element. height cannot be negative");
                }
            } else if (i2 == 5) {
                svg.version = strTrim;
            }
        }
    }

    /* JADX INFO: renamed from: com.caverock.androidsvg.SVGParser$1 */
    static /* synthetic */ class C23561 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem;

        static {
            int[] iArr = new int[SVGAttr.values().length];
            $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr = iArr;
            try {
                iArr[SVGAttr.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.width.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.height.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.version.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.href.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.preserveAspectRatio.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.pathLength.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.rx.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.ry.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cx.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.cy.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x1.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.x2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.y2.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dx.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.dy.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFeatures.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredExtensions.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.systemLanguage.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFormats.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.requiredFonts.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refX.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.refY.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerWidth.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerHeight.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.markerUnits.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.orient.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientUnits.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.gradientTransform.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.spreadMethod.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fx.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fy.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.offset.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clipPathUnits.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.startOffset.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternUnits.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternContentUnits.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.patternTransform.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskUnits.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.maskContentUnits.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.style.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.CLASS.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_rule.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fill_opacity.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_opacity.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_width.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linecap.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_linejoin.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_miterlimit.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dasharray.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stroke_dashoffset.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.opacity.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.color.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_family.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_size.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_weight.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.font_style.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_decoration.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.direction.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.text_anchor.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.overflow.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_start.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_mid.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.marker_end.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.display.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.visibility.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_color.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.stop_opacity.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_path.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.clip_rule.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.mask.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_color.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.solid_opacity.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewport_fill_opacity.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.vector_effect.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.image_rendering.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.viewBox.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.type.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.media.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            int[] iArr2 = new int[SVGElem.values().length];
            $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem = iArr2;
            try {
                iArr2[SVGElem.svg.ordinal()] = 1;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.g.ordinal()] = 2;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.a.ordinal()] = 3;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.defs.ordinal()] = 4;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.use.ordinal()] = 5;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.path.ordinal()] = 6;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.rect.ordinal()] = 7;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.circle.ordinal()] = 8;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.ellipse.ordinal()] = 9;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.line.ordinal()] = 10;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polyline.ordinal()] = 11;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.polygon.ordinal()] = 12;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tspan.ordinal()] = 14;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.tref.ordinal()] = 15;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.SWITCH.ordinal()] = 16;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.symbol.ordinal()] = 17;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.marker.ordinal()] = 18;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.linearGradient.ordinal()] = 19;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.radialGradient.ordinal()] = 20;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.stop.ordinal()] = 21;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.title.ordinal()] = 22;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.desc.ordinal()] = 23;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.clipPath.ordinal()] = 24;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.textPath.ordinal()] = 25;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.pattern.ordinal()] = 26;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.image.ordinal()] = 27;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.view.ordinal()] = 28;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.mask.ordinal()] = 29;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.style.ordinal()] = 30;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$SVGParser$SVGElem[SVGElem.solidColor.ordinal()] = 31;
            } catch (NoSuchFieldError unused120) {
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m740g(Attributes attributes) throws SVGParseException {
        debug("<g>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Group group = new SVG.Group();
        group.document = this.svgDocument;
        group.parent = this.currentElement;
        parseAttributesCore(group, attributes);
        parseAttributesStyle(group, attributes);
        parseAttributesTransform(group, attributes);
        parseAttributesConditional(group, attributes);
        this.currentElement.addChild(group);
        this.currentElement = group;
    }

    private void defs(Attributes attributes) throws SVGParseException {
        debug("<defs>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Defs defs = new SVG.Defs();
        defs.document = this.svgDocument;
        defs.parent = this.currentElement;
        parseAttributesCore(defs, attributes);
        parseAttributesStyle(defs, attributes);
        parseAttributesTransform(defs, attributes);
        this.currentElement.addChild(defs);
        this.currentElement = defs;
    }

    private void use(Attributes attributes) throws SVGParseException {
        debug("<use>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Use use = new SVG.Use();
        use.document = this.svgDocument;
        use.parent = this.currentElement;
        parseAttributesCore(use, attributes);
        parseAttributesStyle(use, attributes);
        parseAttributesTransform(use, attributes);
        parseAttributesConditional(use, attributes);
        parseAttributesUse(use, attributes);
        this.currentElement.addChild(use);
        this.currentElement = use;
    }

    private void parseAttributesUse(SVG.Use use, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                use.f1080x = parseLength(strTrim);
            } else if (i2 == 2) {
                use.f1081y = parseLength(strTrim);
            } else if (i2 == 3) {
                SVG.Length length = parseLength(strTrim);
                use.width = length;
                if (length.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length length2 = parseLength(strTrim);
                use.height = length2;
                if (length2.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                use.href = strTrim;
            }
        }
    }

    private void image(Attributes attributes) throws SVGParseException {
        debug("<image>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Image image = new SVG.Image();
        image.document = this.svgDocument;
        image.parent = this.currentElement;
        parseAttributesCore(image, attributes);
        parseAttributesStyle(image, attributes);
        parseAttributesTransform(image, attributes);
        parseAttributesConditional(image, attributes);
        parseAttributesImage(image, attributes);
        this.currentElement.addChild(image);
        this.currentElement = image;
    }

    private void parseAttributesImage(SVG.Image image, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                image.f1041x = parseLength(strTrim);
            } else if (i2 == 2) {
                image.f1042y = parseLength(strTrim);
            } else if (i2 == 3) {
                SVG.Length length = parseLength(strTrim);
                image.width = length;
                if (length.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length length2 = parseLength(strTrim);
                image.height = length2;
                if (length2.isNegative()) {
                    throw new SVGParseException("Invalid <use> element. height cannot be negative");
                }
            } else if (i2 != 6) {
                if (i2 == 7) {
                    parsePreserveAspectRatio(image, strTrim);
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                image.href = strTrim;
            }
        }
    }

    private void path(Attributes attributes) throws SVGParseException {
        debug("<path>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Path path = new SVG.Path();
        path.document = this.svgDocument;
        path.parent = this.currentElement;
        parseAttributesCore(path, attributes);
        parseAttributesStyle(path, attributes);
        parseAttributesTransform(path, attributes);
        parseAttributesConditional(path, attributes);
        parseAttributesPath(path, attributes);
        this.currentElement.addChild(path);
    }

    private void parseAttributesPath(SVG.Path path, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 8) {
                path.f1049d = parsePath(strTrim);
            } else if (i2 != 9) {
                continue;
            } else {
                Float fValueOf = Float.valueOf(parseFloat(strTrim));
                path.pathLength = fValueOf;
                if (fValueOf.floatValue() < BitmapDescriptorFactory.HUE_RED) {
                    throw new SVGParseException("Invalid <path> element. pathLength cannot be negative");
                }
            }
        }
    }

    private void rect(Attributes attributes) throws SVGParseException {
        debug("<rect>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Rect rect = new SVG.Rect();
        rect.document = this.svgDocument;
        rect.parent = this.currentElement;
        parseAttributesCore(rect, attributes);
        parseAttributesStyle(rect, attributes);
        parseAttributesTransform(rect, attributes);
        parseAttributesConditional(rect, attributes);
        parseAttributesRect(rect, attributes);
        this.currentElement.addChild(rect);
    }

    private void parseAttributesRect(SVG.Rect rect, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                rect.f1054x = parseLength(strTrim);
            } else if (i2 == 2) {
                rect.f1055y = parseLength(strTrim);
            } else if (i2 == 3) {
                SVG.Length length = parseLength(strTrim);
                rect.width = length;
                if (length.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length length2 = parseLength(strTrim);
                rect.height = length2;
                if (length2.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. height cannot be negative");
                }
            } else if (i2 == 10) {
                SVG.Length length3 = parseLength(strTrim);
                rect.f1052rx = length3;
                if (length3.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. rx cannot be negative");
                }
            } else if (i2 != 11) {
                continue;
            } else {
                SVG.Length length4 = parseLength(strTrim);
                rect.f1053ry = length4;
                if (length4.isNegative()) {
                    throw new SVGParseException("Invalid <rect> element. ry cannot be negative");
                }
            }
        }
    }

    private void circle(Attributes attributes) throws SVGParseException {
        debug("<circle>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Circle circle = new SVG.Circle();
        circle.document = this.svgDocument;
        circle.parent = this.currentElement;
        parseAttributesCore(circle, attributes);
        parseAttributesStyle(circle, attributes);
        parseAttributesTransform(circle, attributes);
        parseAttributesConditional(circle, attributes);
        parseAttributesCircle(circle, attributes);
        this.currentElement.addChild(circle);
    }

    private void parseAttributesCircle(SVG.Circle circle, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 12:
                    circle.f1034cx = parseLength(strTrim);
                    break;
                case 13:
                    circle.f1035cy = parseLength(strTrim);
                    break;
                case 14:
                    SVG.Length length = parseLength(strTrim);
                    circle.f1036r = length;
                    if (length.isNegative()) {
                        throw new SVGParseException("Invalid <circle> element. r cannot be negative");
                    }
                    break;
                    break;
            }
        }
    }

    private void ellipse(Attributes attributes) throws SVGParseException {
        debug("<ellipse>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Ellipse ellipse = new SVG.Ellipse();
        ellipse.document = this.svgDocument;
        ellipse.parent = this.currentElement;
        parseAttributesCore(ellipse, attributes);
        parseAttributesStyle(ellipse, attributes);
        parseAttributesTransform(ellipse, attributes);
        parseAttributesConditional(ellipse, attributes);
        parseAttributesEllipse(ellipse, attributes);
        this.currentElement.addChild(ellipse);
    }

    private void parseAttributesEllipse(SVG.Ellipse ellipse, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 10:
                    SVG.Length length = parseLength(strTrim);
                    ellipse.f1039rx = length;
                    if (length.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. rx cannot be negative");
                    }
                    break;
                    break;
                case 11:
                    SVG.Length length2 = parseLength(strTrim);
                    ellipse.f1040ry = length2;
                    if (length2.isNegative()) {
                        throw new SVGParseException("Invalid <ellipse> element. ry cannot be negative");
                    }
                    break;
                    break;
                case 12:
                    ellipse.f1037cx = parseLength(strTrim);
                    break;
                case 13:
                    ellipse.f1038cy = parseLength(strTrim);
                    break;
            }
        }
    }

    private void line(Attributes attributes) throws SVGParseException {
        debug("<line>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Line line = new SVG.Line();
        line.document = this.svgDocument;
        line.parent = this.currentElement;
        parseAttributesCore(line, attributes);
        parseAttributesStyle(line, attributes);
        parseAttributesTransform(line, attributes);
        parseAttributesConditional(line, attributes);
        parseAttributesLine(line, attributes);
        this.currentElement.addChild(line);
    }

    private void parseAttributesLine(SVG.Line line, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    line.f1043x1 = parseLength(strTrim);
                    break;
                case 16:
                    line.f1045y1 = parseLength(strTrim);
                    break;
                case 17:
                    line.f1044x2 = parseLength(strTrim);
                    break;
                case 18:
                    line.f1046y2 = parseLength(strTrim);
                    break;
            }
        }
    }

    private void polyline(Attributes attributes) throws SVGParseException {
        debug("<polyline>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine polyLine = new SVG.PolyLine();
        polyLine.document = this.svgDocument;
        polyLine.parent = this.currentElement;
        parseAttributesCore(polyLine, attributes);
        parseAttributesStyle(polyLine, attributes);
        parseAttributesTransform(polyLine, attributes);
        parseAttributesConditional(polyLine, attributes);
        parseAttributesPolyLine(polyLine, attributes, "polyline");
        this.currentElement.addChild(polyLine);
    }

    private void parseAttributesPolyLine(SVG.PolyLine polyLine, Attributes attributes, String str) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.points) {
                TextScanner textScanner = new TextScanner(attributes.getValue(i));
                ArrayList arrayList = new ArrayList();
                textScanner.skipWhitespace();
                while (!textScanner.empty()) {
                    float fNextFloat = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. Non-coordinate content found in list.");
                    }
                    textScanner.skipCommaWhitespace();
                    float fNextFloat2 = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat2)) {
                        throw new SVGParseException("Invalid <" + str + "> points attribute. There should be an even number of coordinates.");
                    }
                    textScanner.skipCommaWhitespace();
                    arrayList.add(Float.valueOf(fNextFloat));
                    arrayList.add(Float.valueOf(fNextFloat2));
                }
                polyLine.points = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    polyLine.points[i2] = ((Float) it.next()).floatValue();
                    i2++;
                }
            }
        }
    }

    private void polygon(Attributes attributes) throws SVGParseException {
        debug("<polygon>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.PolyLine polygon = new SVG.Polygon();
        polygon.document = this.svgDocument;
        polygon.parent = this.currentElement;
        parseAttributesCore(polygon, attributes);
        parseAttributesStyle(polygon, attributes);
        parseAttributesTransform(polygon, attributes);
        parseAttributesConditional(polygon, attributes);
        parseAttributesPolyLine(polygon, attributes, "polygon");
        this.currentElement.addChild(polygon);
    }

    private void text(Attributes attributes) throws SVGParseException {
        debug("<text>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Text text = new SVG.Text();
        text.document = this.svgDocument;
        text.parent = this.currentElement;
        parseAttributesCore(text, attributes);
        parseAttributesStyle(text, attributes);
        parseAttributesTransform(text, attributes);
        parseAttributesConditional(text, attributes);
        parseAttributesTextPosition(text, attributes);
        this.currentElement.addChild(text);
        this.currentElement = text;
    }

    private void parseAttributesTextPosition(SVG.TextPositionedContainer textPositionedContainer, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                textPositionedContainer.f1070x = parseLengthList(strTrim);
            } else if (i2 == 2) {
                textPositionedContainer.f1071y = parseLengthList(strTrim);
            } else if (i2 == 19) {
                textPositionedContainer.f1068dx = parseLengthList(strTrim);
            } else if (i2 == 20) {
                textPositionedContainer.f1069dy = parseLengthList(strTrim);
            }
        }
    }

    private void tspan(Attributes attributes) throws SVGParseException {
        debug("<tspan>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tspan> elements are only valid inside <text> or other <tspan> elements.");
        }
        SVG.TSpan tSpan = new SVG.TSpan();
        tSpan.document = this.svgDocument;
        tSpan.parent = this.currentElement;
        parseAttributesCore(tSpan, attributes);
        parseAttributesStyle(tSpan, attributes);
        parseAttributesConditional(tSpan, attributes);
        parseAttributesTextPosition(tSpan, attributes);
        this.currentElement.addChild(tSpan);
        this.currentElement = tSpan;
        SVG.SvgContainer svgContainer2 = tSpan.parent;
        if (svgContainer2 instanceof SVG.TextRoot) {
            tSpan.setTextRoot((SVG.TextRoot) svgContainer2);
        } else {
            tSpan.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
        }
    }

    private void tref(Attributes attributes) throws SVGParseException {
        debug("<tref>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.TextContainer)) {
            throw new SVGParseException("Invalid document. <tref> elements are only valid inside <text> or <tspan> elements.");
        }
        SVG.TRef tRef = new SVG.TRef();
        tRef.document = this.svgDocument;
        tRef.parent = this.currentElement;
        parseAttributesCore(tRef, attributes);
        parseAttributesStyle(tRef, attributes);
        parseAttributesConditional(tRef, attributes);
        parseAttributesTRef(tRef, attributes);
        this.currentElement.addChild(tRef);
        SVG.SvgContainer svgContainer2 = tRef.parent;
        if (svgContainer2 instanceof SVG.TextRoot) {
            tRef.setTextRoot((SVG.TextRoot) svgContainer2);
        } else {
            tRef.setTextRoot(((SVG.TextChild) svgContainer2).getTextRoot());
        }
    }

    private void parseAttributesTRef(SVG.TRef tRef, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 6 && ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i)))) {
                tRef.href = strTrim;
            }
        }
    }

    private void zwitch(Attributes attributes) throws SVGParseException {
        debug("<switch>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Switch r0 = new SVG.Switch();
        r0.document = this.svgDocument;
        r0.parent = this.currentElement;
        parseAttributesCore(r0, attributes);
        parseAttributesStyle(r0, attributes);
        parseAttributesTransform(r0, attributes);
        parseAttributesConditional(r0, attributes);
        this.currentElement.addChild(r0);
        this.currentElement = r0;
    }

    private void parseAttributesConditional(SVG.SvgConditional svgConditional, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 21:
                    svgConditional.setRequiredFeatures(parseRequiredFeatures(strTrim));
                    break;
                case 22:
                    svgConditional.setRequiredExtensions(strTrim);
                    break;
                case 23:
                    svgConditional.setSystemLanguage(parseSystemLanguage(strTrim));
                    break;
                case 24:
                    svgConditional.setRequiredFormats(parseRequiredFormats(strTrim));
                    break;
                case 25:
                    List fontFamily = parseFontFamily(strTrim);
                    svgConditional.setRequiredFonts(fontFamily != null ? new HashSet(fontFamily) : new HashSet(0));
                    break;
            }
        }
    }

    private void symbol(Attributes attributes) throws SVGParseException {
        debug("<symbol>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgViewBoxContainer symbol = new SVG.Symbol();
        symbol.document = this.svgDocument;
        symbol.parent = this.currentElement;
        parseAttributesCore(symbol, attributes);
        parseAttributesStyle(symbol, attributes);
        parseAttributesConditional(symbol, attributes);
        parseAttributesViewBox(symbol, attributes);
        this.currentElement.addChild(symbol);
        this.currentElement = symbol;
    }

    private void marker(Attributes attributes) throws SVGParseException {
        debug("<marker>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Marker marker = new SVG.Marker();
        marker.document = this.svgDocument;
        marker.parent = this.currentElement;
        parseAttributesCore(marker, attributes);
        parseAttributesStyle(marker, attributes);
        parseAttributesConditional(marker, attributes);
        parseAttributesViewBox(marker, attributes);
        parseAttributesMarker(marker, attributes);
        this.currentElement.addChild(marker);
        this.currentElement = marker;
    }

    private void parseAttributesMarker(SVG.Marker marker, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 26:
                    marker.refX = parseLength(strTrim);
                    break;
                case 27:
                    marker.refY = parseLength(strTrim);
                    break;
                case 28:
                    SVG.Length length = parseLength(strTrim);
                    marker.markerWidth = length;
                    if (length.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerWidth cannot be negative");
                    }
                    break;
                    break;
                case 29:
                    SVG.Length length2 = parseLength(strTrim);
                    marker.markerHeight = length2;
                    if (length2.isNegative()) {
                        throw new SVGParseException("Invalid <marker> element. markerHeight cannot be negative");
                    }
                    break;
                    break;
                case 30:
                    if ("strokeWidth".equals(strTrim)) {
                        marker.markerUnitsAreUser = false;
                    } else if ("userSpaceOnUse".equals(strTrim)) {
                        marker.markerUnitsAreUser = true;
                    } else {
                        throw new SVGParseException("Invalid value for attribute markerUnits");
                    }
                    break;
                case 31:
                    if ("auto".equals(strTrim)) {
                        marker.orient = Float.valueOf(Float.NaN);
                    } else {
                        marker.orient = Float.valueOf(parseFloat(strTrim));
                    }
                    break;
            }
        }
    }

    private void linearGradient(Attributes attributes) throws SVGParseException {
        debug("<linearGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgLinearGradient svgLinearGradient = new SVG.SvgLinearGradient();
        svgLinearGradient.document = this.svgDocument;
        svgLinearGradient.parent = this.currentElement;
        parseAttributesCore(svgLinearGradient, attributes);
        parseAttributesStyle(svgLinearGradient, attributes);
        parseAttributesGradient(svgLinearGradient, attributes);
        parseAttributesLinearGradient(svgLinearGradient, attributes);
        this.currentElement.addChild(svgLinearGradient);
        this.currentElement = svgLinearGradient;
    }

    private void parseAttributesGradient(SVG.GradientElement gradientElement, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 6) {
                switch (i2) {
                    case 32:
                        if ("objectBoundingBox".equals(strTrim)) {
                            gradientElement.gradientUnitsAreUser = Boolean.FALSE;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            gradientElement.gradientUnitsAreUser = Boolean.TRUE;
                        } else {
                            throw new SVGParseException("Invalid value for attribute gradientUnits");
                        }
                        break;
                    case 33:
                        gradientElement.gradientTransform = parseTransformList(strTrim);
                        break;
                    case 34:
                        try {
                            gradientElement.spreadMethod = SVG.GradientSpread.valueOf(strTrim);
                        } catch (IllegalArgumentException unused) {
                            throw new SVGParseException("Invalid spreadMethod attribute. \"" + strTrim + "\" is not a valid value.");
                        }
                        break;
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                gradientElement.href = strTrim;
            }
        }
    }

    private void parseAttributesLinearGradient(SVG.SvgLinearGradient svgLinearGradient, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()]) {
                case 15:
                    svgLinearGradient.f1059x1 = parseLength(strTrim);
                    break;
                case 16:
                    svgLinearGradient.f1061y1 = parseLength(strTrim);
                    break;
                case 17:
                    svgLinearGradient.f1060x2 = parseLength(strTrim);
                    break;
                case 18:
                    svgLinearGradient.f1062y2 = parseLength(strTrim);
                    break;
            }
        }
    }

    private void radialGradient(Attributes attributes) throws SVGParseException {
        debug("<radialGradient>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgRadialGradient svgRadialGradient = new SVG.SvgRadialGradient();
        svgRadialGradient.document = this.svgDocument;
        svgRadialGradient.parent = this.currentElement;
        parseAttributesCore(svgRadialGradient, attributes);
        parseAttributesStyle(svgRadialGradient, attributes);
        parseAttributesGradient(svgRadialGradient, attributes);
        parseAttributesRadialGradient(svgRadialGradient, attributes);
        this.currentElement.addChild(svgRadialGradient);
        this.currentElement = svgRadialGradient;
    }

    private void parseAttributesRadialGradient(SVG.SvgRadialGradient svgRadialGradient, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 35) {
                svgRadialGradient.f1065fx = parseLength(strTrim);
            } else if (i2 != 36) {
                switch (i2) {
                    case 12:
                        svgRadialGradient.f1063cx = parseLength(strTrim);
                        break;
                    case 13:
                        svgRadialGradient.f1064cy = parseLength(strTrim);
                        break;
                    case 14:
                        SVG.Length length = parseLength(strTrim);
                        svgRadialGradient.f1067r = length;
                        if (length.isNegative()) {
                            throw new SVGParseException("Invalid <radialGradient> element. r cannot be negative");
                        }
                        break;
                        break;
                }
            } else {
                svgRadialGradient.f1066fy = parseLength(strTrim);
            }
        }
    }

    private void stop(Attributes attributes) throws SVGParseException {
        debug("<stop>", new Object[0]);
        SVG.SvgContainer svgContainer = this.currentElement;
        if (svgContainer == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        if (!(svgContainer instanceof SVG.GradientElement)) {
            throw new SVGParseException("Invalid document. <stop> elements are only valid inside <linearGradient> or <radialGradient> elements.");
        }
        SVG.Stop stop = new SVG.Stop();
        stop.document = this.svgDocument;
        stop.parent = this.currentElement;
        parseAttributesCore(stop, attributes);
        parseAttributesStyle(stop, attributes);
        parseAttributesStop(stop, attributes);
        this.currentElement.addChild(stop);
        this.currentElement = stop;
    }

    private void parseAttributesStop(SVG.Stop stop, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 37) {
                stop.offset = parseGradientOffset(strTrim);
            }
        }
    }

    private Float parseGradientOffset(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid offset value in <stop> (empty string)");
        }
        int length = str.length();
        boolean z = true;
        if (str.charAt(str.length() - 1) == '%') {
            length--;
        } else {
            z = false;
        }
        try {
            float f = parseFloat(str, 0, length);
            float f2 = 100.0f;
            if (z) {
                f /= 100.0f;
            }
            if (f < BitmapDescriptorFactory.HUE_RED) {
                f2 = 0.0f;
            } else if (f <= 100.0f) {
                f2 = f;
            }
            return Float.valueOf(f2);
        } catch (NumberFormatException e) {
            throw new SVGParseException("Invalid offset value in <stop>: " + str, e);
        }
    }

    private void solidColor(Attributes attributes) throws SVGParseException {
        debug("<solidColor>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SolidColor solidColor = new SVG.SolidColor();
        solidColor.document = this.svgDocument;
        solidColor.parent = this.currentElement;
        parseAttributesCore(solidColor, attributes);
        parseAttributesStyle(solidColor, attributes);
        this.currentElement.addChild(solidColor);
        this.currentElement = solidColor;
    }

    private void clipPath(Attributes attributes) throws SVGParseException {
        debug("<clipPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.ClipPath clipPath = new SVG.ClipPath();
        clipPath.document = this.svgDocument;
        clipPath.parent = this.currentElement;
        parseAttributesCore(clipPath, attributes);
        parseAttributesStyle(clipPath, attributes);
        parseAttributesTransform(clipPath, attributes);
        parseAttributesConditional(clipPath, attributes);
        parseAttributesClipPath(clipPath, attributes);
        this.currentElement.addChild(clipPath);
        this.currentElement = clipPath;
    }

    private void parseAttributesClipPath(SVG.ClipPath clipPath, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()] == 38) {
                if ("objectBoundingBox".equals(strTrim)) {
                    clipPath.clipPathUnitsAreUser = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(strTrim)) {
                    clipPath.clipPathUnitsAreUser = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute clipPathUnits");
                }
            }
        }
    }

    private void textPath(Attributes attributes) throws SVGParseException {
        debug("<textPath>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.TextPath textPath = new SVG.TextPath();
        textPath.document = this.svgDocument;
        textPath.parent = this.currentElement;
        parseAttributesCore(textPath, attributes);
        parseAttributesStyle(textPath, attributes);
        parseAttributesConditional(textPath, attributes);
        parseAttributesTextPath(textPath, attributes);
        this.currentElement.addChild(textPath);
        this.currentElement = textPath;
        SVG.SvgContainer svgContainer = textPath.parent;
        if (svgContainer instanceof SVG.TextRoot) {
            textPath.setTextRoot((SVG.TextRoot) svgContainer);
        } else {
            textPath.setTextRoot(((SVG.TextChild) svgContainer).getTextRoot());
        }
    }

    private void parseAttributesTextPath(SVG.TextPath textPath, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 != 6) {
                if (i2 == 39) {
                    textPath.startOffset = parseLength(strTrim);
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                textPath.href = strTrim;
            }
        }
    }

    private void pattern(Attributes attributes) throws SVGParseException {
        debug("<pattern>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Pattern pattern = new SVG.Pattern();
        pattern.document = this.svgDocument;
        pattern.parent = this.currentElement;
        parseAttributesCore(pattern, attributes);
        parseAttributesStyle(pattern, attributes);
        parseAttributesConditional(pattern, attributes);
        parseAttributesViewBox(pattern, attributes);
        parseAttributesPattern(pattern, attributes);
        this.currentElement.addChild(pattern);
        this.currentElement = pattern;
    }

    private void parseAttributesPattern(SVG.Pattern pattern, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                pattern.f1050x = parseLength(strTrim);
            } else if (i2 == 2) {
                pattern.f1051y = parseLength(strTrim);
            } else if (i2 == 3) {
                SVG.Length length = parseLength(strTrim);
                pattern.width = length;
                if (length.isNegative()) {
                    throw new SVGParseException("Invalid <pattern> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length length2 = parseLength(strTrim);
                pattern.height = length2;
                if (length2.isNegative()) {
                    throw new SVGParseException("Invalid <pattern> element. height cannot be negative");
                }
            } else if (i2 != 6) {
                switch (i2) {
                    case 40:
                        if ("objectBoundingBox".equals(strTrim)) {
                            pattern.patternUnitsAreUser = Boolean.FALSE;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            pattern.patternUnitsAreUser = Boolean.TRUE;
                        } else {
                            throw new SVGParseException("Invalid value for attribute patternUnits");
                        }
                        break;
                    case 41:
                        if ("objectBoundingBox".equals(strTrim)) {
                            pattern.patternContentUnitsAreUser = Boolean.FALSE;
                        } else if ("userSpaceOnUse".equals(strTrim)) {
                            pattern.patternContentUnitsAreUser = Boolean.TRUE;
                        } else {
                            throw new SVGParseException("Invalid value for attribute patternContentUnits");
                        }
                        break;
                    case 42:
                        pattern.patternTransform = parseTransformList(strTrim);
                        break;
                }
            } else if ("".equals(attributes.getURI(i)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i))) {
                pattern.href = strTrim;
            }
        }
    }

    private void view(Attributes attributes) throws SVGParseException {
        debug("<view>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.SvgViewBoxContainer view = new SVG.View();
        view.document = this.svgDocument;
        view.parent = this.currentElement;
        parseAttributesCore(view, attributes);
        parseAttributesConditional(view, attributes);
        parseAttributesViewBox(view, attributes);
        this.currentElement.addChild(view);
        this.currentElement = view;
    }

    private void mask(Attributes attributes) throws SVGParseException {
        debug("<mask>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        SVG.Mask mask = new SVG.Mask();
        mask.document = this.svgDocument;
        mask.parent = this.currentElement;
        parseAttributesCore(mask, attributes);
        parseAttributesStyle(mask, attributes);
        parseAttributesConditional(mask, attributes);
        parseAttributesMask(mask, attributes);
        this.currentElement.addChild(mask);
        this.currentElement = mask;
    }

    private void parseAttributesMask(SVG.Mask mask, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 1) {
                mask.f1047x = parseLength(strTrim);
            } else if (i2 == 2) {
                mask.f1048y = parseLength(strTrim);
            } else if (i2 == 3) {
                SVG.Length length = parseLength(strTrim);
                mask.width = length;
                if (length.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. width cannot be negative");
                }
            } else if (i2 == 4) {
                SVG.Length length2 = parseLength(strTrim);
                mask.height = length2;
                if (length2.isNegative()) {
                    throw new SVGParseException("Invalid <mask> element. height cannot be negative");
                }
            } else if (i2 != 43) {
                if (i2 != 44) {
                    continue;
                } else if ("objectBoundingBox".equals(strTrim)) {
                    mask.maskContentUnitsAreUser = Boolean.FALSE;
                } else if ("userSpaceOnUse".equals(strTrim)) {
                    mask.maskContentUnitsAreUser = Boolean.TRUE;
                } else {
                    throw new SVGParseException("Invalid value for attribute maskContentUnits");
                }
            } else if ("objectBoundingBox".equals(strTrim)) {
                mask.maskUnitsAreUser = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(strTrim)) {
                mask.maskUnitsAreUser = Boolean.TRUE;
            } else {
                throw new SVGParseException("Invalid value for attribute maskUnits");
            }
        }
    }

    static class TextScanner {
        String input;
        int inputLength;
        int position = 0;
        private NumberParser numberParser = new NumberParser();

        boolean isEOL(int i) {
            return i == 10 || i == 13;
        }

        boolean isWhitespace(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        TextScanner(String str) {
            this.inputLength = 0;
            String strTrim = str.trim();
            this.input = strTrim;
            this.inputLength = strTrim.length();
        }

        boolean empty() {
            return this.position == this.inputLength;
        }

        void skipWhitespace() {
            while (true) {
                int i = this.position;
                if (i >= this.inputLength || !isWhitespace(this.input.charAt(i))) {
                    return;
                } else {
                    this.position++;
                }
            }
        }

        boolean skipCommaWhitespace() {
            skipWhitespace();
            int i = this.position;
            if (i == this.inputLength || this.input.charAt(i) != ',') {
                return false;
            }
            this.position++;
            skipWhitespace();
            return true;
        }

        float nextFloat() {
            float number = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(number)) {
                this.position = this.numberParser.getEndPos();
            }
            return number;
        }

        float possibleNextFloat() {
            skipCommaWhitespace();
            float number = this.numberParser.parseNumber(this.input, this.position, this.inputLength);
            if (!Float.isNaN(number)) {
                this.position = this.numberParser.getEndPos();
            }
            return number;
        }

        float checkedNextFloat(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        float checkedNextFloat(Boolean bool) {
            if (bool == null) {
                return Float.NaN;
            }
            skipCommaWhitespace();
            return nextFloat();
        }

        Integer nextChar() {
            int i = this.position;
            if (i == this.inputLength) {
                return null;
            }
            String str = this.input;
            this.position = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        SVG.Length nextLength() {
            float fNextFloat = nextFloat();
            if (Float.isNaN(fNextFloat)) {
                return null;
            }
            SVG.Unit unitNextUnit = nextUnit();
            if (unitNextUnit == null) {
                return new SVG.Length(fNextFloat, SVG.Unit.px);
            }
            return new SVG.Length(fNextFloat, unitNextUnit);
        }

        Boolean nextFlag() {
            int i = this.position;
            if (i == this.inputLength) {
                return null;
            }
            char cCharAt = this.input.charAt(i);
            if (cCharAt != '0' && cCharAt != '1') {
                return null;
            }
            this.position++;
            return Boolean.valueOf(cCharAt == '1');
        }

        Boolean checkedNextFlag(Object obj) {
            if (obj == null) {
                return null;
            }
            skipCommaWhitespace();
            return nextFlag();
        }

        boolean consume(char c) {
            int i = this.position;
            boolean z = i < this.inputLength && this.input.charAt(i) == c;
            if (z) {
                this.position++;
            }
            return z;
        }

        boolean consume(String str) {
            int length = str.length();
            int i = this.position;
            boolean z = i <= this.inputLength - length && this.input.substring(i, i + length).equals(str);
            if (z) {
                this.position += length;
            }
            return z;
        }

        int advanceChar() {
            int i = this.position;
            int i2 = this.inputLength;
            if (i == i2) {
                return -1;
            }
            int i3 = i + 1;
            this.position = i3;
            if (i3 < i2) {
                return this.input.charAt(i3);
            }
            return -1;
        }

        String nextToken() {
            return nextToken(' ', false);
        }

        String nextToken(char c) {
            return nextToken(c, false);
        }

        String nextTokenWithWhitespace(char c) {
            return nextToken(c, true);
        }

        String nextToken(char c, boolean z) {
            if (empty()) {
                return null;
            }
            char cCharAt = this.input.charAt(this.position);
            if ((!z && isWhitespace(cCharAt)) || cCharAt == c) {
                return null;
            }
            int i = this.position;
            int iAdvanceChar = advanceChar();
            while (iAdvanceChar != -1 && iAdvanceChar != c && (z || !isWhitespace(iAdvanceChar))) {
                iAdvanceChar = advanceChar();
            }
            return this.input.substring(i, this.position);
        }

        String nextWord() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            char cCharAt = this.input.charAt(i);
            if ((cCharAt >= 'A' && cCharAt <= 'Z') || (cCharAt >= 'a' && cCharAt <= 'z')) {
                int iAdvanceChar = advanceChar();
                while (true) {
                    if ((iAdvanceChar < 65 || iAdvanceChar > 90) && (iAdvanceChar < 97 || iAdvanceChar > 122)) {
                        break;
                    }
                    iAdvanceChar = advanceChar();
                }
                return this.input.substring(i, this.position);
            }
            this.position = i;
            return null;
        }

        String nextFunction() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            int iCharAt = this.input.charAt(i);
            while (true) {
                if ((iCharAt < 97 || iCharAt > 122) && (iCharAt < 65 || iCharAt > 90)) {
                    break;
                }
                iCharAt = advanceChar();
            }
            int i2 = this.position;
            while (isWhitespace(iCharAt)) {
                iCharAt = advanceChar();
            }
            if (iCharAt == 40) {
                this.position++;
                return this.input.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        String ahead() {
            int i = this.position;
            while (!empty() && !isWhitespace(this.input.charAt(this.position))) {
                this.position++;
            }
            String strSubstring = this.input.substring(i, this.position);
            this.position = i;
            return strSubstring;
        }

        SVG.Unit nextUnit() {
            if (empty()) {
                return null;
            }
            if (this.input.charAt(this.position) == '%') {
                this.position++;
                return SVG.Unit.percent;
            }
            int i = this.position;
            if (i > this.inputLength - 2) {
                return null;
            }
            try {
                SVG.Unit unitValueOf = SVG.Unit.valueOf(this.input.substring(i, i + 2).toLowerCase(Locale.US));
                this.position += 2;
                return unitValueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        boolean hasLetter() {
            int i = this.position;
            if (i == this.inputLength) {
                return false;
            }
            char cCharAt = this.input.charAt(i);
            return (cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z');
        }

        String nextQuotedString() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            char cCharAt = this.input.charAt(i);
            if (cCharAt != '\'' && cCharAt != '\"') {
                return null;
            }
            int iAdvanceChar = advanceChar();
            while (iAdvanceChar != -1 && iAdvanceChar != cCharAt) {
                iAdvanceChar = advanceChar();
            }
            if (iAdvanceChar == -1) {
                this.position = i;
                return null;
            }
            int i2 = this.position;
            this.position = i2 + 1;
            return this.input.substring(i + 1, i2);
        }

        String restOfText() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            this.position = this.inputLength;
            return this.input.substring(i);
        }
    }

    private void parseAttributesCore(SVG.SvgElementBase svgElementBase, Attributes attributes) throws SVGParseException {
        for (int i = 0; i < attributes.getLength(); i++) {
            String qName = attributes.getQName(i);
            if (qName.equals("id") || qName.equals("xml:id")) {
                svgElementBase.f1058id = attributes.getValue(i).trim();
                return;
            }
            if (qName.equals("xml:space")) {
                String strTrim = attributes.getValue(i).trim();
                if ("default".equals(strTrim)) {
                    svgElementBase.spacePreserve = Boolean.FALSE;
                    return;
                } else {
                    if ("preserve".equals(strTrim)) {
                        svgElementBase.spacePreserve = Boolean.TRUE;
                        return;
                    }
                    throw new SVGParseException("Invalid value for \"xml:space\" attribute: " + strTrim);
                }
            }
        }
    }

    private void parseAttributesStyle(SVG.SvgElementBase svgElementBase, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            if (strTrim.length() != 0) {
                int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
                if (i2 == 45) {
                    parseStyle(svgElementBase, strTrim);
                } else if (i2 == 46) {
                    svgElementBase.classNames = CSSParser.parseClassAttribute(strTrim);
                } else {
                    if (svgElementBase.baseStyle == null) {
                        svgElementBase.baseStyle = new SVG.Style();
                    }
                    processStyleProperty(svgElementBase.baseStyle, attributes.getLocalName(i), attributes.getValue(i).trim());
                }
            }
        }
    }

    private static void parseStyle(SVG.SvgElementBase svgElementBase, String str) {
        TextScanner textScanner = new TextScanner(str.replaceAll("/\\*.*?\\*/", ""));
        while (true) {
            String strNextToken = textScanner.nextToken(':');
            textScanner.skipWhitespace();
            if (!textScanner.consume(':')) {
                return;
            }
            textScanner.skipWhitespace();
            String strNextTokenWithWhitespace = textScanner.nextTokenWithWhitespace(';');
            if (strNextTokenWithWhitespace == null) {
                return;
            }
            textScanner.skipWhitespace();
            if (textScanner.empty() || textScanner.consume(';')) {
                if (svgElementBase.style == null) {
                    svgElementBase.style = new SVG.Style();
                }
                processStyleProperty(svgElementBase.style, strNextToken, strNextTokenWithWhitespace);
                textScanner.skipWhitespace();
            }
        }
    }

    static void processStyleProperty(SVG.Style style, String str, String str2) {
        if (str2.length() == 0 || str2.equals("inherit")) {
            return;
        }
        try {
            switch (C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(str).ordinal()]) {
                case 47:
                    SVG.SvgPaint paintSpecifier = parsePaintSpecifier(str2);
                    style.fill = paintSpecifier;
                    if (paintSpecifier != null) {
                        style.specifiedFlags |= 1;
                        return;
                    }
                    return;
                case 48:
                    SVG.Style.FillRule fillRule = parseFillRule(str2);
                    style.fillRule = fillRule;
                    if (fillRule != null) {
                        style.specifiedFlags |= 2;
                        return;
                    }
                    return;
                case 49:
                    Float opacity = parseOpacity(str2);
                    style.fillOpacity = opacity;
                    if (opacity != null) {
                        style.specifiedFlags |= 4;
                        return;
                    }
                    return;
                case 50:
                    SVG.SvgPaint paintSpecifier2 = parsePaintSpecifier(str2);
                    style.stroke = paintSpecifier2;
                    if (paintSpecifier2 != null) {
                        style.specifiedFlags |= 8;
                        return;
                    }
                    return;
                case 51:
                    Float opacity2 = parseOpacity(str2);
                    style.strokeOpacity = opacity2;
                    if (opacity2 != null) {
                        style.specifiedFlags |= 16;
                        return;
                    }
                    return;
                case 52:
                    style.strokeWidth = parseLength(str2);
                    style.specifiedFlags |= 32;
                    break;
                case EACTags.SEX /* 53 */:
                    SVG.Style.LineCap strokeLineCap = parseStrokeLineCap(str2);
                    style.strokeLineCap = strokeLineCap;
                    if (strokeLineCap != null) {
                        style.specifiedFlags |= 64;
                        return;
                    }
                    return;
                case EACTags.CURRENCY_EXPONENT /* 54 */:
                    SVG.Style.LineJoin strokeLineJoin = parseStrokeLineJoin(str2);
                    style.strokeLineJoin = strokeLineJoin;
                    if (strokeLineJoin != null) {
                        style.specifiedFlags |= 128;
                        return;
                    }
                    return;
                case 55:
                    style.strokeMiterLimit = Float.valueOf(parseFloat(str2));
                    style.specifiedFlags |= 256;
                    break;
                case 56:
                    if ("none".equals(str2)) {
                        style.strokeDashArray = null;
                        style.specifiedFlags |= 512;
                        return;
                    }
                    SVG.Length[] strokeDashArray = parseStrokeDashArray(str2);
                    style.strokeDashArray = strokeDashArray;
                    if (strokeDashArray != null) {
                        style.specifiedFlags |= 512;
                        return;
                    }
                    return;
                case 57:
                    style.strokeDashOffset = parseLength(str2);
                    style.specifiedFlags |= 1024;
                    break;
                case 58:
                    style.opacity = parseOpacity(str2);
                    style.specifiedFlags |= 2048;
                    return;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    style.color = parseColour(str2);
                    style.specifiedFlags |= 4096;
                    break;
                case 60:
                    parseFont(style, str2);
                    return;
                case 61:
                    List fontFamily = parseFontFamily(str2);
                    style.fontFamily = fontFamily;
                    if (fontFamily != null) {
                        style.specifiedFlags |= 8192;
                        return;
                    }
                    return;
                case PacketTags.EXPERIMENTAL_3 /* 62 */:
                    SVG.Length fontSize = parseFontSize(str2);
                    style.fontSize = fontSize;
                    if (fontSize != null) {
                        style.specifiedFlags |= 16384;
                        return;
                    }
                    return;
                case 63:
                    Integer fontWeight = parseFontWeight(str2);
                    style.fontWeight = fontWeight;
                    if (fontWeight != null) {
                        style.specifiedFlags |= 32768;
                        return;
                    }
                    return;
                case 64:
                    SVG.Style.FontStyle fontStyle = parseFontStyle(str2);
                    style.fontStyle = fontStyle;
                    if (fontStyle != null) {
                        style.specifiedFlags |= 65536;
                        return;
                    }
                    return;
                case EACTags.ELEMENT_LIST /* 65 */:
                    SVG.Style.TextDecoration textDecoration = parseTextDecoration(str2);
                    style.textDecoration = textDecoration;
                    if (textDecoration != null) {
                        style.specifiedFlags |= 131072;
                        return;
                    }
                    return;
                case EACTags.ADDRESS /* 66 */:
                    SVG.Style.TextDirection textDirection = parseTextDirection(str2);
                    style.direction = textDirection;
                    if (textDirection != null) {
                        style.specifiedFlags |= 68719476736L;
                        return;
                    }
                    return;
                case 67:
                    SVG.Style.TextAnchor textAnchor = parseTextAnchor(str2);
                    style.textAnchor = textAnchor;
                    if (textAnchor != null) {
                        style.specifiedFlags |= 262144;
                        return;
                    }
                    return;
                case 68:
                    Boolean overflow = parseOverflow(str2);
                    style.overflow = overflow;
                    if (overflow != null) {
                        style.specifiedFlags |= 524288;
                        return;
                    }
                    return;
                case EACTags.DISPLAY_IMAGE /* 69 */:
                    String functionalIRI = parseFunctionalIRI(str2, str);
                    style.markerStart = functionalIRI;
                    style.markerMid = functionalIRI;
                    style.markerEnd = functionalIRI;
                    style.specifiedFlags |= 14680064;
                    return;
                case 70:
                    style.markerStart = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 2097152;
                    return;
                case 71:
                    style.markerMid = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 4194304;
                    return;
                case 72:
                    style.markerEnd = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 8388608;
                    return;
                case 73:
                    if (str2.indexOf(Currencies.CAD) < 0) {
                        if ("|inline|block|list-item|run-in|compact|marker|table|inline-table|table-row-group|table-header-group|table-footer-group|table-row|table-column-group|table-column|table-cell|table-caption|none|".contains('|' + str2 + '|')) {
                            style.display = Boolean.valueOf(!str2.equals("none"));
                            style.specifiedFlags |= 16777216;
                            return;
                        }
                        return;
                    }
                    return;
                case EACTags.CERTIFICATION_AUTHORITY_PUBLIC_KEY /* 74 */:
                    if (str2.indexOf(Currencies.CAD) < 0) {
                        if ("|visible|hidden|collapse|".contains('|' + str2 + '|')) {
                            style.visibility = Boolean.valueOf(str2.equals(ViewProps.VISIBLE));
                            style.specifiedFlags |= 33554432;
                            return;
                        }
                        return;
                    }
                    return;
                case EACTags.DEPRECATED /* 75 */:
                    if (str2.equals("currentColor")) {
                        style.stopColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.stopColor = parseColour(str2);
                        } catch (SVGParseException e) {
                            Log.w("SVGParser", e.getMessage());
                            return;
                        }
                        break;
                    }
                    style.specifiedFlags |= 67108864;
                    return;
                case 76:
                    style.stopOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 134217728;
                    return;
                case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                    SVG.CSSClipRect clip = parseClip(str2);
                    style.clip = clip;
                    if (clip != null) {
                        style.specifiedFlags |= 1048576;
                        return;
                    }
                    return;
                case 78:
                    style.clipPath = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 268435456;
                    return;
                case 79:
                    style.clipRule = parseFillRule(str2);
                    style.specifiedFlags |= 536870912;
                    return;
                case 80:
                    style.mask = parseFunctionalIRI(str2, str);
                    style.specifiedFlags |= 1073741824;
                    return;
                case EACTags.ANSWER_TO_RESET /* 81 */:
                    if (str2.equals("currentColor")) {
                        style.solidColor = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.solidColor = parseColour(str2);
                        } catch (SVGParseException e2) {
                            Log.w("SVGParser", e2.getMessage());
                            return;
                        }
                        break;
                    }
                    style.specifiedFlags |= 2147483648L;
                    return;
                case EACTags.HISTORICAL_BYTES /* 82 */:
                    style.solidOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 4294967296L;
                    return;
                case 83:
                    if (str2.equals("currentColor")) {
                        style.viewportFill = SVG.CurrentColor.getInstance();
                    } else {
                        try {
                            style.viewportFill = parseColour(str2);
                        } catch (SVGParseException e3) {
                            Log.w("SVGParser", e3.getMessage());
                            return;
                        }
                        break;
                    }
                    style.specifiedFlags |= 8589934592L;
                    return;
                case Currencies.BZD /* 84 */:
                    style.viewportFillOpacity = parseOpacity(str2);
                    style.specifiedFlags |= 17179869184L;
                    return;
                case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
                    SVG.Style.VectorEffect vectorEffect = parseVectorEffect(str2);
                    style.vectorEffect = vectorEffect;
                    if (vectorEffect != null) {
                        style.specifiedFlags |= 34359738368L;
                        return;
                    }
                    return;
                case 86:
                    SVG.Style.RenderQuality renderQuality = parseRenderQuality(str2);
                    style.imageRendering = renderQuality;
                    if (renderQuality != null) {
                        style.specifiedFlags |= 137438953472L;
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (SVGParseException unused) {
        }
    }

    private void parseAttributesViewBox(SVG.SvgViewBoxContainer svgViewBoxContainer, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 7) {
                parsePreserveAspectRatio(svgViewBoxContainer, strTrim);
            } else if (i2 == 87) {
                svgViewBoxContainer.viewBox = parseViewBox(strTrim);
            }
        }
    }

    private void parseAttributesTransform(SVG.HasTransform hasTransform, Attributes attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            if (SVGAttr.fromString(attributes.getLocalName(i)) == SVGAttr.transform) {
                hasTransform.setTransform(parseTransformList(attributes.getValue(i)));
            }
        }
    }

    private Matrix parseTransformList(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            String strNextFunction = textScanner.nextFunction();
            if (strNextFunction == null) {
                throw new SVGParseException("Bad transform function encountered in transform list: " + str);
            }
            switch (strNextFunction) {
                case "matrix":
                    textScanner.skipWhitespace();
                    float fNextFloat = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat2 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat3 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat4 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat5 = textScanner.nextFloat();
                    textScanner.skipCommaWhitespace();
                    float fNextFloat6 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat6) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    Matrix matrix2 = new Matrix();
                    matrix2.setValues(new float[]{fNextFloat, fNextFloat3, fNextFloat5, fNextFloat2, fNextFloat4, fNextFloat6, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f});
                    matrix.preConcat(matrix2);
                    break;
                    break;
                case "rotate":
                    textScanner.skipWhitespace();
                    float fNextFloat7 = textScanner.nextFloat();
                    float fPossibleNextFloat = textScanner.possibleNextFloat();
                    float fPossibleNextFloat2 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat7) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(fPossibleNextFloat)) {
                        matrix.preRotate(fNextFloat7);
                    } else {
                        if (Float.isNaN(fPossibleNextFloat2)) {
                            throw new SVGParseException("Invalid transform list: " + str);
                        }
                        matrix.preRotate(fNextFloat7, fPossibleNextFloat, fPossibleNextFloat2);
                    }
                    break;
                    break;
                case "scale":
                    textScanner.skipWhitespace();
                    float fNextFloat8 = textScanner.nextFloat();
                    float fPossibleNextFloat3 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat8) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(fPossibleNextFloat3)) {
                        matrix.preScale(fNextFloat8, fNextFloat8);
                    } else {
                        matrix.preScale(fNextFloat8, fPossibleNextFloat3);
                    }
                    break;
                    break;
                case "skewX":
                    textScanner.skipWhitespace();
                    float fNextFloat9 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat9) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    matrix.preSkew((float) Math.tan(Math.toRadians(fNextFloat9)), BitmapDescriptorFactory.HUE_RED);
                    break;
                    break;
                case "skewY":
                    textScanner.skipWhitespace();
                    float fNextFloat10 = textScanner.nextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat10) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    matrix.preSkew(BitmapDescriptorFactory.HUE_RED, (float) Math.tan(Math.toRadians(fNextFloat10)));
                    break;
                    break;
                case "translate":
                    textScanner.skipWhitespace();
                    float fNextFloat11 = textScanner.nextFloat();
                    float fPossibleNextFloat4 = textScanner.possibleNextFloat();
                    textScanner.skipWhitespace();
                    if (Float.isNaN(fNextFloat11) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                        throw new SVGParseException("Invalid transform list: " + str);
                    }
                    if (Float.isNaN(fPossibleNextFloat4)) {
                        matrix.preTranslate(fNextFloat11, BitmapDescriptorFactory.HUE_RED);
                    } else {
                        matrix.preTranslate(fNextFloat11, fPossibleNextFloat4);
                    }
                    break;
                    break;
                default:
                    throw new SVGParseException("Invalid transform list fn: " + strNextFunction + ")");
            }
            if (textScanner.empty()) {
                return matrix;
            }
            textScanner.skipCommaWhitespace();
        }
        return matrix;
    }

    static SVG.Length parseLength(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length value (empty string)");
        }
        int length = str.length();
        SVG.Unit unitValueOf = SVG.Unit.px;
        char cCharAt = str.charAt(length - 1);
        if (cCharAt == '%') {
            length--;
            unitValueOf = SVG.Unit.percent;
        } else if (length > 2 && Character.isLetter(cCharAt) && Character.isLetter(str.charAt(length - 2))) {
            length -= 2;
            try {
                unitValueOf = SVG.Unit.valueOf(str.substring(length).toLowerCase(Locale.US));
            } catch (IllegalArgumentException unused) {
                throw new SVGParseException("Invalid length unit specifier: " + str);
            }
        }
        try {
            return new SVG.Length(parseFloat(str, 0, length), unitValueOf);
        } catch (NumberFormatException e) {
            throw new SVGParseException("Invalid length value: " + str, e);
        }
    }

    private static List parseLengthList(String str) throws SVGParseException {
        if (str.length() == 0) {
            throw new SVGParseException("Invalid length list (empty string)");
        }
        ArrayList arrayList = new ArrayList(1);
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        while (!textScanner.empty()) {
            float fNextFloat = textScanner.nextFloat();
            if (Float.isNaN(fNextFloat)) {
                throw new SVGParseException("Invalid length list value: " + textScanner.ahead());
            }
            SVG.Unit unitNextUnit = textScanner.nextUnit();
            if (unitNextUnit == null) {
                unitNextUnit = SVG.Unit.px;
            }
            arrayList.add(new SVG.Length(fNextFloat, unitNextUnit));
            textScanner.skipCommaWhitespace();
        }
        return arrayList;
    }

    private static float parseFloat(String str) throws SVGParseException {
        int length = str.length();
        if (length == 0) {
            throw new SVGParseException("Invalid float value (empty string)");
        }
        return parseFloat(str, 0, length);
    }

    private static float parseFloat(String str, int i, int i2) throws SVGParseException {
        float number = new NumberParser().parseNumber(str, i, i2);
        if (!Float.isNaN(number)) {
            return number;
        }
        throw new SVGParseException("Invalid float value: " + str);
    }

    private static Float parseOpacity(String str) {
        try {
            float f = parseFloat(str);
            float f2 = BitmapDescriptorFactory.HUE_RED;
            if (f < BitmapDescriptorFactory.HUE_RED) {
                f = f2;
            } else {
                f2 = 1.0f;
                if (f > 1.0f) {
                    f = f2;
                }
            }
            return Float.valueOf(f);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVG.Box parseViewBox(String str) throws SVGParseException {
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        float fNextFloat = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float fNextFloat2 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float fNextFloat3 = textScanner.nextFloat();
        textScanner.skipCommaWhitespace();
        float fNextFloat4 = textScanner.nextFloat();
        if (Float.isNaN(fNextFloat) || Float.isNaN(fNextFloat2) || Float.isNaN(fNextFloat3) || Float.isNaN(fNextFloat4)) {
            throw new SVGParseException("Invalid viewBox definition - should have four numbers");
        }
        if (fNextFloat3 < BitmapDescriptorFactory.HUE_RED) {
            throw new SVGParseException("Invalid viewBox. width cannot be negative");
        }
        if (fNextFloat4 < BitmapDescriptorFactory.HUE_RED) {
            throw new SVGParseException("Invalid viewBox. height cannot be negative");
        }
        return new SVG.Box(fNextFloat, fNextFloat2, fNextFloat3, fNextFloat4);
    }

    private static void parsePreserveAspectRatio(SVG.SvgPreserveAspectRatioContainer svgPreserveAspectRatioContainer, String str) {
        svgPreserveAspectRatioContainer.preserveAspectRatio = parsePreserveAspectRatio(str);
    }

    static PreserveAspectRatio parsePreserveAspectRatio(String str) throws SVGParseException {
        PreserveAspectRatio.Scale scale;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        String strNextToken = textScanner.nextToken();
        if ("defer".equals(strNextToken)) {
            textScanner.skipWhitespace();
            strNextToken = textScanner.nextToken();
        }
        PreserveAspectRatio.Alignment alignment = AspectRatioKeywords.get(strNextToken);
        textScanner.skipWhitespace();
        if (textScanner.empty()) {
            scale = null;
        } else {
            String strNextToken2 = textScanner.nextToken();
            strNextToken2.hashCode();
            if (strNextToken2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else if (strNextToken2.equals("slice")) {
                scale = PreserveAspectRatio.Scale.slice;
            } else {
                throw new SVGParseException("Invalid preserveAspectRatio definition: " + str);
            }
        }
        return new PreserveAspectRatio(alignment, scale);
    }

    private static SVG.SvgPaint parsePaintSpecifier(String str) {
        if (str.startsWith("url(")) {
            int iIndexOf = str.indexOf(")");
            if (iIndexOf != -1) {
                String strTrim = str.substring(4, iIndexOf).trim();
                String strTrim2 = str.substring(iIndexOf + 1).trim();
                return new SVG.PaintReference(strTrim, strTrim2.length() > 0 ? parseColourSpecifer(strTrim2) : null);
            }
            return new SVG.PaintReference(str.substring(4).trim(), null);
        }
        return parseColourSpecifer(str);
    }

    private static SVG.SvgPaint parseColourSpecifer(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return SVG.Colour.TRANSPARENT;
        }
        if (str.equals("currentColor")) {
            return SVG.CurrentColor.getInstance();
        }
        try {
            return parseColour(str);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static SVG.Colour parseColour(String str) throws SVGParseException {
        if (str.charAt(0) == '#') {
            IntegerParser hex = IntegerParser.parseHex(str, 1, str.length());
            if (hex == null) {
                throw new SVGParseException("Bad hex colour value: " + str);
            }
            int endPos = hex.getEndPos();
            if (endPos == 4) {
                int iValue = hex.value();
                int i = iValue & 3840;
                int i2 = iValue & PsExtractor.VIDEO_STREAM_MASK;
                int i3 = iValue & 15;
                return new SVG.Colour(i3 | (i << 8) | (-16777216) | (i << 12) | (i2 << 8) | (i2 << 4) | (i3 << 4));
            }
            if (endPos == 5) {
                int iValue2 = hex.value();
                int i4 = 61440 & iValue2;
                int i5 = iValue2 & 3840;
                int i6 = iValue2 & PsExtractor.VIDEO_STREAM_MASK;
                int i7 = iValue2 & 15;
                return new SVG.Colour((i7 << 24) | (i7 << 28) | (i4 << 8) | (i4 << 4) | (i5 << 4) | i5 | i6 | (i6 >> 4));
            }
            if (endPos == 7) {
                return new SVG.Colour(hex.value() | (-16777216));
            }
            if (endPos != 9) {
                throw new SVGParseException("Bad hex colour value: " + str);
            }
            return new SVG.Colour((hex.value() >>> 8) | (hex.value() << 24));
        }
        String lowerCase = str.toLowerCase(Locale.US);
        boolean zStartsWith = lowerCase.startsWith("rgba(");
        if (zStartsWith || lowerCase.startsWith("rgb(")) {
            TextScanner textScanner = new TextScanner(str.substring(zStartsWith ? 5 : 4));
            textScanner.skipWhitespace();
            float fNextFloat = textScanner.nextFloat();
            if (!Float.isNaN(fNextFloat) && textScanner.consume(CoreConstants.PERCENT_CHAR)) {
                fNextFloat = (fNextFloat * 256.0f) / 100.0f;
            }
            float fCheckedNextFloat = textScanner.checkedNextFloat(fNextFloat);
            if (!Float.isNaN(fCheckedNextFloat) && textScanner.consume(CoreConstants.PERCENT_CHAR)) {
                fCheckedNextFloat = (fCheckedNextFloat * 256.0f) / 100.0f;
            }
            float fCheckedNextFloat2 = textScanner.checkedNextFloat(fCheckedNextFloat);
            if (!Float.isNaN(fCheckedNextFloat2) && textScanner.consume(CoreConstants.PERCENT_CHAR)) {
                fCheckedNextFloat2 = (fCheckedNextFloat2 * 256.0f) / 100.0f;
            }
            if (zStartsWith) {
                float fCheckedNextFloat3 = textScanner.checkedNextFloat(fCheckedNextFloat2);
                textScanner.skipWhitespace();
                if (Float.isNaN(fCheckedNextFloat3) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                    throw new SVGParseException("Bad rgba() colour value: " + str);
                }
                return new SVG.Colour((clamp255(fCheckedNextFloat3 * 256.0f) << 24) | (clamp255(fNextFloat) << 16) | (clamp255(fCheckedNextFloat) << 8) | clamp255(fCheckedNextFloat2));
            }
            textScanner.skipWhitespace();
            if (Float.isNaN(fCheckedNextFloat2) || !textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                throw new SVGParseException("Bad rgb() colour value: " + str);
            }
            return new SVG.Colour((clamp255(fNextFloat) << 16) | (-16777216) | (clamp255(fCheckedNextFloat) << 8) | clamp255(fCheckedNextFloat2));
        }
        boolean zStartsWith2 = lowerCase.startsWith("hsla(");
        if (zStartsWith2 || lowerCase.startsWith("hsl(")) {
            TextScanner textScanner2 = new TextScanner(str.substring(zStartsWith2 ? 5 : 4));
            textScanner2.skipWhitespace();
            float fNextFloat2 = textScanner2.nextFloat();
            float fCheckedNextFloat4 = textScanner2.checkedNextFloat(fNextFloat2);
            if (!Float.isNaN(fCheckedNextFloat4)) {
                textScanner2.consume(CoreConstants.PERCENT_CHAR);
            }
            float fCheckedNextFloat5 = textScanner2.checkedNextFloat(fCheckedNextFloat4);
            if (!Float.isNaN(fCheckedNextFloat5)) {
                textScanner2.consume(CoreConstants.PERCENT_CHAR);
            }
            if (zStartsWith2) {
                float fCheckedNextFloat6 = textScanner2.checkedNextFloat(fCheckedNextFloat5);
                textScanner2.skipWhitespace();
                if (Float.isNaN(fCheckedNextFloat6) || !textScanner2.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                    throw new SVGParseException("Bad hsla() colour value: " + str);
                }
                return new SVG.Colour((clamp255(fCheckedNextFloat6 * 256.0f) << 24) | hslToRgb(fNextFloat2, fCheckedNextFloat4, fCheckedNextFloat5));
            }
            textScanner2.skipWhitespace();
            if (Float.isNaN(fCheckedNextFloat5) || !textScanner2.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR)) {
                throw new SVGParseException("Bad hsl() colour value: " + str);
            }
            return new SVG.Colour(hslToRgb(fNextFloat2, fCheckedNextFloat4, fCheckedNextFloat5) | (-16777216));
        }
        return parseColourKeyword(lowerCase);
    }

    private static int clamp255(float f) {
        if (f < BitmapDescriptorFactory.HUE_RED) {
            return 0;
        }
        if (f > 255.0f) {
            return 255;
        }
        return Math.round(f);
    }

    private static int hslToRgb(float f, float f2, float f3) {
        float f4 = BitmapDescriptorFactory.HUE_RED;
        float f5 = f % 360.0f;
        if (f < BitmapDescriptorFactory.HUE_RED) {
            f5 += 360.0f;
        }
        float f6 = f5 / 60.0f;
        float f7 = f2 / 100.0f;
        float f8 = f3 / 100.0f;
        if (f7 < BitmapDescriptorFactory.HUE_RED) {
            f7 = 0.0f;
        } else if (f7 > 1.0f) {
            f7 = 1.0f;
        }
        if (f8 >= BitmapDescriptorFactory.HUE_RED) {
            f4 = f8 > 1.0f ? 1.0f : f8;
        }
        float f9 = f4 <= 0.5f ? (f7 + 1.0f) * f4 : (f4 + f7) - (f7 * f4);
        float f10 = (f4 * 2.0f) - f9;
        return clamp255(hueToRgb(f10, f9, f6 - 2.0f) * 256.0f) | (clamp255(hueToRgb(f10, f9, f6 + 2.0f) * 256.0f) << 16) | (clamp255(hueToRgb(f10, f9, f6) * 256.0f) << 8);
    }

    private static SVG.Colour parseColourKeyword(String str) throws SVGParseException {
        Integer num = ColourKeywords.get(str);
        if (num == null) {
            throw new SVGParseException("Invalid colour keyword: " + str);
        }
        return new SVG.Colour(num.intValue());
    }

    private static void parseFont(SVG.Style style, String str) {
        String strNextToken;
        if ("|caption|icon|menu|message-box|small-caption|status-bar|".contains('|' + str + '|')) {
            TextScanner textScanner = new TextScanner(str);
            Integer num = null;
            SVG.Style.FontStyle fontStyle = null;
            String str2 = null;
            while (true) {
                strNextToken = textScanner.nextToken('/');
                textScanner.skipWhitespace();
                if (strNextToken != null) {
                    if (num != null && fontStyle != null) {
                        break;
                    }
                    if (!strNextToken.equals("normal") && (num != null || (num = FontWeightKeywords.get(strNextToken)) == null)) {
                        if (fontStyle != null || (fontStyle = parseFontStyle(strNextToken)) == null) {
                            if (str2 != null || !strNextToken.equals("small-caps")) {
                                break;
                            } else {
                                str2 = strNextToken;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
            SVG.Length fontSize = parseFontSize(strNextToken);
            if (textScanner.consume('/')) {
                textScanner.skipWhitespace();
                String strNextToken2 = textScanner.nextToken();
                if (strNextToken2 != null) {
                    try {
                        parseLength(strNextToken2);
                    } catch (SVGParseException unused) {
                        return;
                    }
                }
                textScanner.skipWhitespace();
            }
            style.fontFamily = parseFontFamily(textScanner.restOfText());
            style.fontSize = fontSize;
            style.fontWeight = Integer.valueOf(num == null ? 400 : num.intValue());
            if (fontStyle == null) {
                fontStyle = SVG.Style.FontStyle.Normal;
            }
            style.fontStyle = fontStyle;
            style.specifiedFlags |= 122880;
        }
    }

    private static List parseFontFamily(String str) {
        TextScanner textScanner = new TextScanner(str);
        ArrayList arrayList = null;
        do {
            String strNextQuotedString = textScanner.nextQuotedString();
            if (strNextQuotedString == null) {
                strNextQuotedString = textScanner.nextTokenWithWhitespace(',');
            }
            if (strNextQuotedString == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(strNextQuotedString);
            textScanner.skipCommaWhitespace();
        } while (!textScanner.empty());
        return arrayList;
    }

    private static SVG.Length parseFontSize(String str) {
        try {
            SVG.Length length = FontSizeKeywords.get(str);
            return length == null ? parseLength(str) : length;
        } catch (SVGParseException unused) {
            return null;
        }
    }

    private static Integer parseFontWeight(String str) {
        return FontWeightKeywords.get(str);
    }

    private static SVG.Style.FontStyle parseFontStyle(String str) {
        str.hashCode();
        switch (str) {
            case "oblique":
                return SVG.Style.FontStyle.Oblique;
            case "italic":
                return SVG.Style.FontStyle.Italic;
            case "normal":
                return SVG.Style.FontStyle.Normal;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDecoration parseTextDecoration(String str) {
        str.hashCode();
        switch (str) {
            case "line-through":
                return SVG.Style.TextDecoration.LineThrough;
            case "underline":
                return SVG.Style.TextDecoration.Underline;
            case "none":
                return SVG.Style.TextDecoration.None;
            case "blink":
                return SVG.Style.TextDecoration.Blink;
            case "overline":
                return SVG.Style.TextDecoration.Overline;
            default:
                return null;
        }
    }

    private static SVG.Style.TextDirection parseTextDirection(String str) {
        str.hashCode();
        if (str.equals("ltr")) {
            return SVG.Style.TextDirection.LTR;
        }
        if (str.equals("rtl")) {
            return SVG.Style.TextDirection.RTL;
        }
        return null;
    }

    private static SVG.Style.FillRule parseFillRule(String str) {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    private static SVG.Style.LineCap parseStrokeLineCap(String str) {
        if ("butt".equals(str)) {
            return SVG.Style.LineCap.Butt;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineCap.Round;
        }
        if ("square".equals(str)) {
            return SVG.Style.LineCap.Square;
        }
        return null;
    }

    private static SVG.Style.LineJoin parseStrokeLineJoin(String str) {
        if ("miter".equals(str)) {
            return SVG.Style.LineJoin.Miter;
        }
        if ("round".equals(str)) {
            return SVG.Style.LineJoin.Round;
        }
        if ("bevel".equals(str)) {
            return SVG.Style.LineJoin.Bevel;
        }
        return null;
    }

    private static SVG.Length[] parseStrokeDashArray(String str) {
        SVG.Length lengthNextLength;
        TextScanner textScanner = new TextScanner(str);
        textScanner.skipWhitespace();
        if (textScanner.empty() || (lengthNextLength = textScanner.nextLength()) == null || lengthNextLength.isNegative()) {
            return null;
        }
        float fFloatValue = lengthNextLength.floatValue();
        ArrayList arrayList = new ArrayList();
        arrayList.add(lengthNextLength);
        while (!textScanner.empty()) {
            textScanner.skipCommaWhitespace();
            SVG.Length lengthNextLength2 = textScanner.nextLength();
            if (lengthNextLength2 == null || lengthNextLength2.isNegative()) {
                return null;
            }
            arrayList.add(lengthNextLength2);
            fFloatValue += lengthNextLength2.floatValue();
        }
        if (fFloatValue == BitmapDescriptorFactory.HUE_RED) {
            return null;
        }
        return (SVG.Length[]) arrayList.toArray(new SVG.Length[arrayList.size()]);
    }

    private static SVG.Style.TextAnchor parseTextAnchor(String str) {
        str.hashCode();
        switch (str) {
            case "middle":
                return SVG.Style.TextAnchor.Middle;
            case "end":
                return SVG.Style.TextAnchor.End;
            case "start":
                return SVG.Style.TextAnchor.Start;
            default:
                return null;
        }
    }

    private static Boolean parseOverflow(String str) {
        str.hashCode();
        switch (str) {
            case "hidden":
            case "scroll":
                return Boolean.FALSE;
            case "auto":
            case "visible":
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    private static SVG.CSSClipRect parseClip(String str) {
        if ("auto".equals(str) || !str.startsWith("rect(")) {
            return null;
        }
        TextScanner textScanner = new TextScanner(str.substring(5));
        textScanner.skipWhitespace();
        SVG.Length lengthOrAuto = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length lengthOrAuto2 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length lengthOrAuto3 = parseLengthOrAuto(textScanner);
        textScanner.skipCommaWhitespace();
        SVG.Length lengthOrAuto4 = parseLengthOrAuto(textScanner);
        textScanner.skipWhitespace();
        if (textScanner.consume(CoreConstants.RIGHT_PARENTHESIS_CHAR) || textScanner.empty()) {
            return new SVG.CSSClipRect(lengthOrAuto, lengthOrAuto2, lengthOrAuto3, lengthOrAuto4);
        }
        return null;
    }

    private static SVG.Length parseLengthOrAuto(TextScanner textScanner) {
        if (textScanner.consume("auto")) {
            return new SVG.Length(BitmapDescriptorFactory.HUE_RED);
        }
        return textScanner.nextLength();
    }

    private static SVG.Style.VectorEffect parseVectorEffect(String str) {
        str.hashCode();
        if (str.equals("none")) {
            return SVG.Style.VectorEffect.None;
        }
        if (str.equals("non-scaling-stroke")) {
            return SVG.Style.VectorEffect.NonScalingStroke;
        }
        return null;
    }

    private static SVG.Style.RenderQuality parseRenderQuality(String str) {
        str.hashCode();
        switch (str) {
            case "optimizeQuality":
                return SVG.Style.RenderQuality.optimizeQuality;
            case "auto":
                return SVG.Style.RenderQuality.auto;
            case "optimizeSpeed":
                return SVG.Style.RenderQuality.optimizeSpeed;
            default:
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0282  */
    /* JADX WARN: Code duplicated, block: B:117:0x027b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x028a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x027c  */
    private static SVG.PathDefinition parsePath(String str) {
        float fCheckedNextFloat;
        float fCheckedNextFloat2;
        float f;
        float f2;
        TextScanner textScanner = new TextScanner(str);
        SVG.PathDefinition pathDefinition = new SVG.PathDefinition();
        if (textScanner.empty()) {
            return pathDefinition;
        }
        int iIntValue = textScanner.nextChar().intValue();
        int i = 109;
        if (iIntValue != 77 && iIntValue != 109) {
            return pathDefinition;
        }
        int iIntValue2 = iIntValue;
        float f3 = BitmapDescriptorFactory.HUE_RED;
        float fNextFloat = BitmapDescriptorFactory.HUE_RED;
        float f4 = BitmapDescriptorFactory.HUE_RED;
        float fCheckedNextFloat3 = BitmapDescriptorFactory.HUE_RED;
        float f5 = BitmapDescriptorFactory.HUE_RED;
        float f6 = BitmapDescriptorFactory.HUE_RED;
        while (true) {
            textScanner.skipWhitespace();
            switch (iIntValue2) {
                case EACTags.ELEMENT_LIST /* 65 */:
                case 97:
                    float fNextFloat2 = textScanner.nextFloat();
                    float fCheckedNextFloat4 = textScanner.checkedNextFloat(fNextFloat2);
                    float fCheckedNextFloat5 = textScanner.checkedNextFloat(fCheckedNextFloat4);
                    Boolean boolCheckedNextFlag = textScanner.checkedNextFlag(Float.valueOf(fCheckedNextFloat5));
                    Boolean boolCheckedNextFlag2 = textScanner.checkedNextFlag(boolCheckedNextFlag);
                    float fCheckedNextFloat6 = textScanner.checkedNextFloat(boolCheckedNextFlag2);
                    float fCheckedNextFloat7 = textScanner.checkedNextFloat(fCheckedNextFloat6);
                    if (Float.isNaN(fCheckedNextFloat7) || fNextFloat2 < BitmapDescriptorFactory.HUE_RED || fCheckedNextFloat4 < BitmapDescriptorFactory.HUE_RED) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 97) {
                            fCheckedNextFloat6 += f3;
                            fCheckedNextFloat7 += f4;
                        }
                        pathDefinition.arcTo(fNextFloat2, fCheckedNextFloat4, fCheckedNextFloat5, boolCheckedNextFlag.booleanValue(), boolCheckedNextFlag2.booleanValue(), fCheckedNextFloat6, fCheckedNextFloat7);
                        f3 = fCheckedNextFloat6;
                        fNextFloat = f3;
                        f4 = fCheckedNextFloat7;
                        fCheckedNextFloat3 = f4;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 67:
                case DatabaseUtils.STATEMENT_OTHER /* 99 */:
                    float fNextFloat3 = textScanner.nextFloat();
                    float fCheckedNextFloat8 = textScanner.checkedNextFloat(fNextFloat3);
                    float fCheckedNextFloat9 = textScanner.checkedNextFloat(fCheckedNextFloat8);
                    float fCheckedNextFloat10 = textScanner.checkedNextFloat(fCheckedNextFloat9);
                    fCheckedNextFloat = textScanner.checkedNextFloat(fCheckedNextFloat10);
                    fCheckedNextFloat2 = textScanner.checkedNextFloat(fCheckedNextFloat);
                    if (Float.isNaN(fCheckedNextFloat2)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 99) {
                            fCheckedNextFloat += f3;
                            fCheckedNextFloat2 += f4;
                            fNextFloat3 += f3;
                            fCheckedNextFloat8 += f4;
                            fCheckedNextFloat9 += f3;
                            fCheckedNextFloat10 += f4;
                        }
                        f = fCheckedNextFloat9;
                        f2 = fCheckedNextFloat10;
                        pathDefinition.cubicTo(fNextFloat3, fCheckedNextFloat8, f, f2, fCheckedNextFloat, fCheckedNextFloat2);
                        fNextFloat = f;
                        f3 = fCheckedNextFloat;
                        fCheckedNextFloat3 = f2;
                        f4 = fCheckedNextFloat2;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 72:
                case 104:
                    float fNextFloat4 = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat4)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 104) {
                            fNextFloat4 += f3;
                        }
                        f3 = fNextFloat4;
                        pathDefinition.lineTo(f3, f4);
                        fNextFloat = f3;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 76:
                case 108:
                    float fNextFloat5 = textScanner.nextFloat();
                    float fCheckedNextFloat11 = textScanner.checkedNextFloat(fNextFloat5);
                    if (Float.isNaN(fCheckedNextFloat11)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 108) {
                            fNextFloat5 += f3;
                            fCheckedNextFloat11 += f4;
                        }
                        f3 = fNextFloat5;
                        f4 = fCheckedNextFloat11;
                        pathDefinition.lineTo(f3, f4);
                        fNextFloat = f3;
                        fCheckedNextFloat3 = f4;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case EACTags.INTEGRATED_CIRCUIT_MANUFACTURER_ID /* 77 */:
                case 109:
                    float fNextFloat6 = textScanner.nextFloat();
                    float fCheckedNextFloat12 = textScanner.checkedNextFloat(fNextFloat6);
                    if (Float.isNaN(fCheckedNextFloat12)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == i && !pathDefinition.isEmpty()) {
                            fNextFloat6 += f3;
                            fCheckedNextFloat12 += f4;
                        }
                        f3 = fNextFloat6;
                        f4 = fCheckedNextFloat12;
                        pathDefinition.moveTo(f3, f4);
                        fNextFloat = f3;
                        f5 = fNextFloat;
                        fCheckedNextFloat3 = f4;
                        f6 = fCheckedNextFloat3;
                        iIntValue2 = iIntValue2 != i ? 76 : 108;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case EACTags.ANSWER_TO_RESET /* 81 */:
                case 113:
                    fNextFloat = textScanner.nextFloat();
                    fCheckedNextFloat3 = textScanner.checkedNextFloat(fNextFloat);
                    float fCheckedNextFloat13 = textScanner.checkedNextFloat(fCheckedNextFloat3);
                    float fCheckedNextFloat14 = textScanner.checkedNextFloat(fCheckedNextFloat13);
                    if (Float.isNaN(fCheckedNextFloat14)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 113) {
                            fCheckedNextFloat13 += f3;
                            fCheckedNextFloat14 += f4;
                            fNextFloat += f3;
                            fCheckedNextFloat3 += f4;
                        }
                        f3 = fCheckedNextFloat13;
                        f4 = fCheckedNextFloat14;
                        pathDefinition.quadTo(fNextFloat, fCheckedNextFloat3, f3, f4);
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 83:
                case 115:
                    float f7 = (f3 * 2.0f) - fNextFloat;
                    float f8 = (2.0f * f4) - fCheckedNextFloat3;
                    float fNextFloat7 = textScanner.nextFloat();
                    float fCheckedNextFloat15 = textScanner.checkedNextFloat(fNextFloat7);
                    fCheckedNextFloat = textScanner.checkedNextFloat(fCheckedNextFloat15);
                    fCheckedNextFloat2 = textScanner.checkedNextFloat(fCheckedNextFloat);
                    if (Float.isNaN(fCheckedNextFloat2)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 115) {
                            fCheckedNextFloat += f3;
                            fCheckedNextFloat2 += f4;
                            fNextFloat7 += f3;
                            fCheckedNextFloat15 += f4;
                        }
                        f = fNextFloat7;
                        f2 = fCheckedNextFloat15;
                        pathDefinition.cubicTo(f7, f8, f, f2, fCheckedNextFloat, fCheckedNextFloat2);
                        fNextFloat = f;
                        f3 = fCheckedNextFloat;
                        fCheckedNextFloat3 = f2;
                        f4 = fCheckedNextFloat2;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case Currencies.BZD /* 84 */:
                case 116:
                    fNextFloat = (f3 * 2.0f) - fNextFloat;
                    fCheckedNextFloat3 = (2.0f * f4) - fCheckedNextFloat3;
                    float fNextFloat8 = textScanner.nextFloat();
                    float fCheckedNextFloat16 = textScanner.checkedNextFloat(fNextFloat8);
                    if (Float.isNaN(fCheckedNextFloat16)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 116) {
                            fNextFloat8 += f3;
                            fCheckedNextFloat16 += f4;
                        }
                        f3 = fNextFloat8;
                        f4 = fCheckedNextFloat16;
                        pathDefinition.quadTo(fNextFloat, fCheckedNextFloat3, f3, f4);
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 86:
                case 118:
                    float fNextFloat9 = textScanner.nextFloat();
                    if (Float.isNaN(fNextFloat9)) {
                        Log.e("SVGParser", "Bad path coords for " + ((char) iIntValue2) + " path segment");
                    } else {
                        if (iIntValue2 == 118) {
                            fNextFloat9 += f4;
                        }
                        f4 = fNextFloat9;
                        pathDefinition.lineTo(f3, f4);
                        fCheckedNextFloat3 = f4;
                        textScanner.skipCommaWhitespace();
                        if (textScanner.empty()) {
                            if (textScanner.hasLetter()) {
                                iIntValue2 = textScanner.nextChar().intValue();
                            }
                            i = 109;
                        }
                    }
                    break;
                case 90:
                case 122:
                    pathDefinition.close();
                    f3 = f5;
                    fNextFloat = f3;
                    f4 = f6;
                    fCheckedNextFloat3 = f4;
                    textScanner.skipCommaWhitespace();
                    if (textScanner.empty()) {
                        if (textScanner.hasLetter()) {
                            iIntValue2 = textScanner.nextChar().intValue();
                        }
                        i = 109;
                    }
                    break;
                default:
                    break;
            }
            return pathDefinition;
        }
    }

    private static Set parseRequiredFeatures(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String strNextToken = textScanner.nextToken();
            if (strNextToken.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                hashSet.add(strNextToken.substring(35));
            } else {
                hashSet.add("UNSUPPORTED");
            }
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set parseSystemLanguage(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            String strNextToken = textScanner.nextToken();
            int iIndexOf = strNextToken.indexOf(45);
            if (iIndexOf != -1) {
                strNextToken = strNextToken.substring(0, iIndexOf);
            }
            hashSet.add(new Locale(strNextToken, "", "").getLanguage());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static Set parseRequiredFormats(String str) {
        TextScanner textScanner = new TextScanner(str);
        HashSet hashSet = new HashSet();
        while (!textScanner.empty()) {
            hashSet.add(textScanner.nextToken());
            textScanner.skipWhitespace();
        }
        return hashSet;
    }

    private static String parseFunctionalIRI(String str, String str2) {
        if (str.equals("none") || !str.startsWith("url(")) {
            return null;
        }
        if (str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        return str.substring(4).trim();
    }

    private void style(Attributes attributes) throws SVGParseException {
        debug("<style>", new Object[0]);
        if (this.currentElement == null) {
            throw new SVGParseException("Invalid document. Root element must be <svg>");
        }
        String str = AirshipConfigOptions.FEATURE_ALL;
        boolean zEquals = true;
        for (int i = 0; i < attributes.getLength(); i++) {
            String strTrim = attributes.getValue(i).trim();
            int i2 = C23561.$SwitchMap$com$caverock$androidsvg$SVGParser$SVGAttr[SVGAttr.fromString(attributes.getLocalName(i)).ordinal()];
            if (i2 == 88) {
                zEquals = strTrim.equals("text/css");
            } else if (i2 == 89) {
                str = strTrim;
            }
        }
        if (zEquals && CSSParser.mediaMatches(str, CSSParser.MediaType.screen)) {
            this.inStyleElement = true;
        } else {
            this.ignoring = true;
            this.ignoreDepth = 1;
        }
    }

    private void parseCSSStyleSheet(String str) {
        this.svgDocument.addCSSRules(new CSSParser(CSSParser.MediaType.screen, CSSParser.Source.Document).parse(str));
    }
}
