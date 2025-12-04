package com.google.common.net;

import androidx.media3.common.MimeTypes;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.rnmaps.maps.MapModule;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@Immutable
@GwtCompatible
/* loaded from: classes4.dex */
public final class MediaType {
    private int hashCode;
    private final ImmutableListMultimap parameters;
    private Optional parsedCharset;
    private final String subtype;
    private String toString;
    private final String type;
    private static final ImmutableListMultimap UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of("charset", Ascii.toLowerCase(Charsets.UTF_8.name()));
    private static final CharMatcher TOKEN_MATCHER = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    private static final CharMatcher QUOTED_TEXT_MATCHER = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));
    private static final CharMatcher LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
    private static final Map KNOWN_TYPES = Maps.newHashMap();
    public static final MediaType ANY_TYPE = createConstant("*", "*");
    public static final MediaType ANY_TEXT_TYPE = createConstant("text", "*");
    public static final MediaType ANY_IMAGE_TYPE = createConstant(MimeTypes.BASE_TYPE_IMAGE, "*");
    public static final MediaType ANY_AUDIO_TYPE = createConstant(MimeTypes.BASE_TYPE_AUDIO, "*");
    public static final MediaType ANY_VIDEO_TYPE = createConstant(MimeTypes.BASE_TYPE_VIDEO, "*");
    public static final MediaType ANY_APPLICATION_TYPE = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "*");
    public static final MediaType ANY_FONT_TYPE = createConstant("font", "*");
    public static final MediaType CACHE_MANIFEST_UTF_8 = createConstantUtf8("text", "cache-manifest");
    public static final MediaType CSS_UTF_8 = createConstantUtf8("text", "css");
    public static final MediaType CSV_UTF_8 = createConstantUtf8("text", "csv");
    public static final MediaType HTML_UTF_8 = createConstantUtf8("text", "html");
    public static final MediaType I_CALENDAR_UTF_8 = createConstantUtf8("text", "calendar");
    public static final MediaType PLAIN_TEXT_UTF_8 = createConstantUtf8("text", "plain");
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8("text", "javascript");
    public static final MediaType TSV_UTF_8 = createConstantUtf8("text", "tab-separated-values");
    public static final MediaType VCARD_UTF_8 = createConstantUtf8("text", "vcard");
    public static final MediaType WML_UTF_8 = createConstantUtf8("text", "vnd.wap.wml");
    public static final MediaType XML_UTF_8 = createConstantUtf8("text", "xml");
    public static final MediaType VTT_UTF_8 = createConstantUtf8("text", "vtt");
    public static final MediaType BMP = createConstant(MimeTypes.BASE_TYPE_IMAGE, "bmp");
    public static final MediaType CRW = createConstant(MimeTypes.BASE_TYPE_IMAGE, "x-canon-crw");
    public static final MediaType GIF = createConstant(MimeTypes.BASE_TYPE_IMAGE, "gif");
    public static final MediaType ICO = createConstant(MimeTypes.BASE_TYPE_IMAGE, "vnd.microsoft.icon");
    public static final MediaType JPEG = createConstant(MimeTypes.BASE_TYPE_IMAGE, "jpeg");
    public static final MediaType PNG = createConstant(MimeTypes.BASE_TYPE_IMAGE, MapModule.SNAPSHOT_FORMAT_PNG);
    public static final MediaType PSD = createConstant(MimeTypes.BASE_TYPE_IMAGE, "vnd.adobe.photoshop");
    public static final MediaType SVG_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_IMAGE, "svg+xml");
    public static final MediaType TIFF = createConstant(MimeTypes.BASE_TYPE_IMAGE, "tiff");
    public static final MediaType WEBP = createConstant(MimeTypes.BASE_TYPE_IMAGE, "webp");
    public static final MediaType HEIF = createConstant(MimeTypes.BASE_TYPE_IMAGE, "heif");
    public static final MediaType JP2K = createConstant(MimeTypes.BASE_TYPE_IMAGE, "jp2");
    public static final MediaType MP4_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "mp4");
    public static final MediaType MPEG_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "mpeg");
    public static final MediaType OGG_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "ogg");
    public static final MediaType WEBM_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "webm");
    public static final MediaType L16_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "l16");
    public static final MediaType L24_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "l24");
    public static final MediaType BASIC_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "basic");
    public static final MediaType AAC_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "aac");
    public static final MediaType VORBIS_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "vorbis");
    public static final MediaType WMA_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "x-ms-wma");
    public static final MediaType WAX_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "x-ms-wax");
    public static final MediaType VND_REAL_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "vnd.rn-realaudio");
    public static final MediaType VND_WAVE_AUDIO = createConstant(MimeTypes.BASE_TYPE_AUDIO, "vnd.wave");
    public static final MediaType MP4_VIDEO = createConstant(MimeTypes.BASE_TYPE_VIDEO, "mp4");
    public static final MediaType MPEG_VIDEO = createConstant(MimeTypes.BASE_TYPE_VIDEO, "mpeg");
    public static final MediaType OGG_VIDEO = createConstant(MimeTypes.BASE_TYPE_VIDEO, "ogg");
    public static final MediaType QUICKTIME = createConstant(MimeTypes.BASE_TYPE_VIDEO, "quicktime");
    public static final MediaType WEBM_VIDEO = createConstant(MimeTypes.BASE_TYPE_VIDEO, "webm");
    public static final MediaType WMV = createConstant(MimeTypes.BASE_TYPE_VIDEO, "x-ms-wmv");
    public static final MediaType FLV_VIDEO = createConstant(MimeTypes.BASE_TYPE_VIDEO, "x-flv");
    public static final MediaType THREE_GPP_VIDEO = createConstant(MimeTypes.BASE_TYPE_VIDEO, "3gpp");
    public static final MediaType THREE_GPP2_VIDEO = createConstant(MimeTypes.BASE_TYPE_VIDEO, "3gpp2");
    public static final MediaType APPLICATION_XML_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "xml");
    public static final MediaType ATOM_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "atom+xml");
    public static final MediaType BZIP2 = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-bzip2");
    public static final MediaType DART_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "dart");
    public static final MediaType APPLE_PASSBOOK = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.apple.pkpass");
    public static final MediaType EOT = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-fontobject");
    public static final MediaType EPUB = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "epub+zip");
    public static final MediaType FORM_DATA = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-www-form-urlencoded");
    public static final MediaType KEY_ARCHIVE = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "pkcs12");
    public static final MediaType APPLICATION_BINARY = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "binary");
    public static final MediaType GEO_JSON = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "geo+json");
    public static final MediaType GZIP = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-gzip");
    public static final MediaType HAL_JSON = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "hal+json");
    public static final MediaType JAVASCRIPT_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "javascript");
    public static final MediaType JOSE = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "jose");
    public static final MediaType JOSE_JSON = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "jose+json");
    public static final MediaType JSON_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "json");
    public static final MediaType JWT = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "jwt");
    public static final MediaType MANIFEST_JSON_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "manifest+json");
    public static final MediaType KML = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.google-earth.kml+xml");
    public static final MediaType KMZ = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.google-earth.kmz");
    public static final MediaType MBOX = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "mbox");
    public static final MediaType APPLE_MOBILE_CONFIG = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-apple-aspen-config");
    public static final MediaType MICROSOFT_EXCEL = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-excel");
    public static final MediaType MICROSOFT_OUTLOOK = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-outlook");
    public static final MediaType MICROSOFT_POWERPOINT = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.ms-powerpoint");
    public static final MediaType MICROSOFT_WORD = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "msword");
    public static final MediaType MEDIA_PRESENTATION_DESCRIPTION = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "dash+xml");
    public static final MediaType WASM_APPLICATION = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "wasm");
    public static final MediaType NACL_APPLICATION = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-nacl");
    public static final MediaType NACL_PORTABLE_APPLICATION = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-pnacl");
    public static final MediaType OCTET_STREAM = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "octet-stream");
    public static final MediaType OGG_CONTAINER = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "ogg");
    public static final MediaType OOXML_DOCUMENT = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType OOXML_PRESENTATION = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType OOXML_SHEET = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType OPENDOCUMENT_GRAPHICS = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.graphics");
    public static final MediaType OPENDOCUMENT_PRESENTATION = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.presentation");
    public static final MediaType OPENDOCUMENT_SPREADSHEET = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType OPENDOCUMENT_TEXT = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.oasis.opendocument.text");
    public static final MediaType OPENSEARCH_DESCRIPTION_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "opensearchdescription+xml");
    public static final MediaType PDF = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "pdf");
    public static final MediaType POSTSCRIPT = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "postscript");
    public static final MediaType PROTOBUF = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "protobuf");
    public static final MediaType RDF_XML_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "rdf+xml");
    public static final MediaType RTF_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "rtf");
    public static final MediaType SFNT = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "font-sfnt");
    public static final MediaType SHOCKWAVE_FLASH = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-shockwave-flash");
    public static final MediaType SKETCHUP = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "vnd.sketchup.skp");
    public static final MediaType SOAP_XML_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "soap+xml");
    public static final MediaType TAR = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "x-tar");
    public static final MediaType WOFF = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "font-woff");
    public static final MediaType WOFF2 = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "font-woff2");
    public static final MediaType XHTML_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "xhtml+xml");
    public static final MediaType XRD_UTF_8 = createConstantUtf8(MimeTypes.BASE_TYPE_APPLICATION, "xrd+xml");
    public static final MediaType ZIP = createConstant(MimeTypes.BASE_TYPE_APPLICATION, "zip");
    public static final MediaType FONT_COLLECTION = createConstant("font", "collection");
    public static final MediaType FONT_OTF = createConstant("font", "otf");
    public static final MediaType FONT_SFNT = createConstant("font", "sfnt");
    public static final MediaType FONT_TTF = createConstant("font", "ttf");
    public static final MediaType FONT_WOFF = createConstant("font", "woff");
    public static final MediaType FONT_WOFF2 = createConstant("font", "woff2");
    private static final Joiner.MapJoiner PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");

    private static MediaType createConstant(String str, String str2) {
        MediaType mediaTypeAddKnownType = addKnownType(new MediaType(str, str2, ImmutableListMultimap.of()));
        mediaTypeAddKnownType.parsedCharset = Optional.absent();
        return mediaTypeAddKnownType;
    }

    private static MediaType createConstantUtf8(String str, String str2) {
        MediaType mediaTypeAddKnownType = addKnownType(new MediaType(str, str2, UTF_8_CONSTANT_PARAMETERS));
        mediaTypeAddKnownType.parsedCharset = Optional.of(Charsets.UTF_8);
        return mediaTypeAddKnownType;
    }

    private static MediaType addKnownType(MediaType mediaType) {
        KNOWN_TYPES.put(mediaType, mediaType);
        return mediaType;
    }

    private MediaType(String str, String str2, ImmutableListMultimap immutableListMultimap) {
        this.type = str;
        this.subtype = str2;
        this.parameters = immutableListMultimap;
    }

    public String type() {
        return this.type;
    }

    public String subtype() {
        return this.subtype;
    }

    public ImmutableListMultimap<String, String> parameters() {
        return this.parameters;
    }

    private Map parametersAsMap() {
        return Maps.transformValues(this.parameters.asMap(), new Function() { // from class: com.google.common.net.MediaType$$ExternalSyntheticLambda1
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ImmutableMultiset.copyOf((Collection) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Optional<Charset> charset() {
        Optional<Charset> optionalAbsent = this.parsedCharset;
        if (optionalAbsent == null) {
            optionalAbsent = Optional.absent();
            UnmodifiableIterator it = this.parameters.get((ImmutableListMultimap) "charset").iterator();
            String str = null;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str == null) {
                    optionalAbsent = Optional.of(Charset.forName(str2));
                    str = str2;
                } else if (!str.equals(str2)) {
                    throw new IllegalStateException("Multiple charset values defined: " + str + ", " + str2);
                }
            }
            this.parsedCharset = optionalAbsent;
        }
        return optionalAbsent;
    }

    public MediaType withoutParameters() {
        return this.parameters.isEmpty() ? this : create(this.type, this.subtype);
    }

    public MediaType withParameters(Multimap<String, String> multimap) {
        return create(this.type, this.subtype, multimap);
    }

    public MediaType withParameters(String str, Iterable<String> iterable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iterable);
        String strNormalizeToken = normalizeToken(str);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        UnmodifiableIterator it = this.parameters.entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            if (!strNormalizeToken.equals(str2)) {
                builder.put((ImmutableListMultimap.Builder) str2, (String) entry.getValue());
            }
        }
        Iterator<String> it2 = iterable.iterator();
        while (it2.hasNext()) {
            builder.put((ImmutableListMultimap.Builder) strNormalizeToken, normalizeParameterValue(strNormalizeToken, it2.next()));
        }
        MediaType mediaType = new MediaType(this.type, this.subtype, builder.build());
        if (!strNormalizeToken.equals("charset")) {
            mediaType.parsedCharset = this.parsedCharset;
        }
        return (MediaType) MoreObjects.firstNonNull((MediaType) KNOWN_TYPES.get(mediaType), mediaType);
    }

    public MediaType withParameter(String str, String str2) {
        return withParameters(str, ImmutableSet.of(str2));
    }

    public MediaType withCharset(Charset charset) {
        Preconditions.checkNotNull(charset);
        MediaType mediaTypeWithParameter = withParameter("charset", charset.name());
        mediaTypeWithParameter.parsedCharset = Optional.of(charset);
        return mediaTypeWithParameter;
    }

    public boolean hasWildcard() {
        return "*".equals(this.type) || "*".equals(this.subtype);
    }

    public boolean is(MediaType mediaType) {
        return (mediaType.type.equals("*") || mediaType.type.equals(this.type)) && (mediaType.subtype.equals("*") || mediaType.subtype.equals(this.subtype)) && this.parameters.entries().containsAll(mediaType.parameters.entries());
    }

    public static MediaType create(String str, String str2) {
        MediaType mediaTypeCreate = create(str, str2, ImmutableListMultimap.of());
        mediaTypeCreate.parsedCharset = Optional.absent();
        return mediaTypeCreate;
    }

    private static MediaType create(String str, String str2, Multimap multimap) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(multimap);
        String strNormalizeToken = normalizeToken(str);
        String strNormalizeToken2 = normalizeToken(str2);
        Preconditions.checkArgument(!"*".equals(strNormalizeToken) || "*".equals(strNormalizeToken2), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        for (Map.Entry entry : multimap.entries()) {
            String strNormalizeToken3 = normalizeToken((String) entry.getKey());
            builder.put((ImmutableListMultimap.Builder) strNormalizeToken3, normalizeParameterValue(strNormalizeToken3, (String) entry.getValue()));
        }
        MediaType mediaType = new MediaType(strNormalizeToken, strNormalizeToken2, builder.build());
        return (MediaType) MoreObjects.firstNonNull((MediaType) KNOWN_TYPES.get(mediaType), mediaType);
    }

    private static String normalizeToken(String str) {
        Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(str));
        Preconditions.checkArgument(!str.isEmpty());
        return Ascii.toLowerCase(str);
    }

    private static String normalizeParameterValue(String str, String str2) {
        Preconditions.checkNotNull(str2);
        Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(str2), "parameter values must be ASCII: %s", str2);
        return "charset".equals(str) ? Ascii.toLowerCase(str2) : str2;
    }

    @CanIgnoreReturnValue
    public static MediaType parse(String str) {
        String strConsumeToken;
        Preconditions.checkNotNull(str);
        Tokenizer tokenizer = new Tokenizer(str);
        try {
            CharMatcher charMatcher = TOKEN_MATCHER;
            String strConsumeToken2 = tokenizer.consumeToken(charMatcher);
            consumeSeparator(tokenizer, '/');
            String strConsumeToken3 = tokenizer.consumeToken(charMatcher);
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            while (tokenizer.hasMore()) {
                consumeSeparator(tokenizer, ';');
                CharMatcher charMatcher2 = TOKEN_MATCHER;
                String strConsumeToken4 = tokenizer.consumeToken(charMatcher2);
                consumeSeparator(tokenizer, '=');
                if ('\"' == tokenizer.previewChar()) {
                    tokenizer.consumeCharacter('\"');
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != tokenizer.previewChar()) {
                        if ('\\' == tokenizer.previewChar()) {
                            tokenizer.consumeCharacter('\\');
                            sb.append(tokenizer.consumeCharacter(CharMatcher.ascii()));
                        } else {
                            sb.append(tokenizer.consumeToken(QUOTED_TEXT_MATCHER));
                        }
                    }
                    strConsumeToken = sb.toString();
                    tokenizer.consumeCharacter('\"');
                } else {
                    strConsumeToken = tokenizer.consumeToken(charMatcher2);
                }
                builder.put((ImmutableListMultimap.Builder) strConsumeToken4, strConsumeToken);
            }
            return create(strConsumeToken2, strConsumeToken3, builder.build());
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("Could not parse '" + str + "'", e);
        }
    }

    private static void consumeSeparator(Tokenizer tokenizer, char c) {
        CharMatcher charMatcher = LINEAR_WHITE_SPACE;
        tokenizer.consumeTokenIfPresent(charMatcher);
        tokenizer.consumeCharacter(c);
        tokenizer.consumeTokenIfPresent(charMatcher);
    }

    private static final class Tokenizer {
        final String input;
        int position = 0;

        Tokenizer(String str) {
            this.input = str;
        }

        String consumeTokenIfPresent(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            int i = this.position;
            this.position = charMatcher.negate().indexIn(this.input, i);
            return hasMore() ? this.input.substring(i, this.position) : this.input.substring(i);
        }

        String consumeToken(CharMatcher charMatcher) {
            int i = this.position;
            String strConsumeTokenIfPresent = consumeTokenIfPresent(charMatcher);
            Preconditions.checkState(this.position != i);
            return strConsumeTokenIfPresent;
        }

        char consumeCharacter(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            char cPreviewChar = previewChar();
            Preconditions.checkState(charMatcher.matches(cPreviewChar));
            this.position++;
            return cPreviewChar;
        }

        char consumeCharacter(char c) {
            Preconditions.checkState(hasMore());
            Preconditions.checkState(previewChar() == c);
            this.position++;
            return c;
        }

        char previewChar() {
            Preconditions.checkState(hasMore());
            return this.input.charAt(this.position);
        }

        boolean hasMore() {
            int i = this.position;
            return i >= 0 && i < this.input.length();
        }
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        return this.type.equals(mediaType.type) && this.subtype.equals(mediaType.subtype) && parametersAsMap().equals(mediaType.parametersAsMap());
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Objects.hashCode(this.type, this.subtype, parametersAsMap());
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String toString() {
        String str = this.toString;
        if (str != null) {
            return str;
        }
        String strComputeToString = computeToString();
        this.toString = strComputeToString;
        return strComputeToString;
    }

    private String computeToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('/');
        sb.append(this.subtype);
        if (!this.parameters.isEmpty()) {
            sb.append("; ");
            PARAMETER_JOINER.appendTo(sb, Multimaps.transformValues((ListMultimap) this.parameters, new Function() { // from class: com.google.common.net.MediaType$$ExternalSyntheticLambda0
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return MediaType.lambda$computeToString$0((String) obj);
                }
            }).entries());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$computeToString$0(String str) {
        return (!TOKEN_MATCHER.matchesAllOf(str) || str.isEmpty()) ? escapeAndQuote(str) : str;
    }

    private static String escapeAndQuote(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\r' || cCharAt == '\\' || cCharAt == '\"') {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        sb.append('\"');
        return sb.toString();
    }
}
