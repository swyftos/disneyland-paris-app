package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.C0740C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.hls.HlsTrackMetadataEntry;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.common.collect.Iterables;
import gherkin.GherkinLanguageConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private final HlsMultivariantPlaylist multivariantPlaylist;
    private final HlsMediaPlaylist previousMediaPlaylist;
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_ATTR_DURATION = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_TARGET_DURATION = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_CAN_SKIP_UNTIL = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_SKIP_DATE_RANGES = compileBooleanAttrPattern("CAN-SKIP-DATERANGES");
    private static final Pattern REGEX_SKIPPED_SEGMENTS = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern REGEX_HOLD_BACK = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_HOLD_BACK = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CAN_BLOCK_RELOAD = compileBooleanAttrPattern("CAN-BLOCK-RELOAD");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern REGEX_LAST_MSN = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern REGEX_LAST_PART = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_BYTERANGE_START = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE_LENGTH = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_PRELOAD_HINT_TYPE = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_INDEPENDENT = compileBooleanAttrPattern("INDEPENDENT");
    private static final Pattern REGEX_GAP = compileBooleanAttrPattern("GAP");
    private static final Pattern REGEX_PRECISE = compileBooleanAttrPattern("PRECISE");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    public static final class DeltaUpdateException extends IOException {
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.EMPTY, null);
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        this.multivariantPlaylist = hlsMultivariantPlaylist;
        this.previousMediaPlaylist = hlsMediaPlaylist;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!checkPlaylistHeader(bufferedReader)) {
                throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    String strTrim = line.trim();
                    if (!strTrim.isEmpty()) {
                        if (strTrim.startsWith("#EXT-X-STREAM-INF")) {
                            arrayDeque.add(strTrim);
                            HlsMultivariantPlaylist multivariantPlaylist = parseMultivariantPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                            Util.closeQuietly(bufferedReader);
                            return multivariantPlaylist;
                        }
                        if (!strTrim.startsWith("#EXT-X-TARGETDURATION") && !strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") && !strTrim.startsWith("#EXTINF") && !strTrim.startsWith("#EXT-X-KEY") && !strTrim.startsWith("#EXT-X-BYTERANGE") && !strTrim.equals("#EXT-X-DISCONTINUITY") && !strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") && !strTrim.equals("#EXT-X-ENDLIST")) {
                            arrayDeque.add(strTrim);
                        }
                        arrayDeque.add(strTrim);
                        HlsMediaPlaylist mediaPlaylist = parseMediaPlaylist(this.multivariantPlaylist, this.previousMediaPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
                        Util.closeQuietly(bufferedReader);
                        return mediaPlaylist;
                    }
                } else {
                    Util.closeQuietly(bufferedReader);
                    throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                }
            }
        } catch (Throwable th) {
            Util.closeQuietly(bufferedReader);
            throw th;
        }
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int i = bufferedReader.read();
        if (i == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i = bufferedReader.read();
        }
        int iSkipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, i);
        for (int i2 = 0; i2 < 7; i2++) {
            if (iSkipIgnorableWhitespace != "#EXTM3U".charAt(i2)) {
                return false;
            }
            iSkipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, iSkipIgnorableWhitespace));
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z, int i) throws IOException {
        while (i != -1 && Character.isWhitespace(i) && (z || !Util.isLinebreak(i))) {
            i = bufferedReader.read();
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:78:0x0312  */
    /* JADX WARN: Failed to find 'out' block for switch in B:95:0x033f. Please report as an issue. */
    private static HlsMultivariantPlaylist parseMultivariantPlaylist(LineIterator lineIterator, String str) throws IOException {
        ArrayList arrayList;
        String mediaMimeType;
        int i;
        String str2;
        int i2;
        String mediaMimeType2;
        int i3;
        int i4;
        int i5;
        Uri uriResolveToUri;
        HashMap map;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        boolean z = false;
        boolean zContains = false;
        while (true) {
            boolean zHasNext = lineIterator.hasNext();
            String str3 = MimeTypes.APPLICATION_M3U8;
            if (zHasNext) {
                String next = lineIterator.next();
                if (next.startsWith("#EXT")) {
                    arrayList9.add(next);
                }
                boolean zStartsWith = next.startsWith("#EXT-X-I-FRAME-STREAM-INF");
                if (next.startsWith("#EXT-X-DEFINE")) {
                    map3.put(parseStringAttr(next, REGEX_NAME, map3), parseStringAttr(next, REGEX_VALUE, map3));
                } else {
                    if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        map = map2;
                        arrayList4 = arrayList4;
                        arrayList5 = arrayList5;
                        z = true;
                    } else if (next.startsWith("#EXT-X-MEDIA")) {
                        arrayList7.add(next);
                    } else if (next.startsWith("#EXT-X-SESSION-KEY")) {
                        DrmInitData.SchemeData drmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr(next, REGEX_KEYFORMAT, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, map3), map3);
                        if (drmSchemeData != null) {
                            arrayList8.add(new DrmInitData(parseEncryptionScheme(parseStringAttr(next, REGEX_METHOD, map3)), drmSchemeData));
                        }
                    } else if (next.startsWith("#EXT-X-STREAM-INF") || zStartsWith) {
                        zContains |= next.contains("CLOSED-CAPTIONS=NONE");
                        int i6 = zStartsWith ? 16384 : 0;
                        int intAttr = parseIntAttr(next, REGEX_BANDWIDTH);
                        int optionalIntAttr = parseOptionalIntAttr(next, REGEX_AVERAGE_BANDWIDTH, -1);
                        String optionalStringAttr = parseOptionalStringAttr(next, REGEX_CODECS, map3);
                        String optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_RESOLUTION, map3);
                        if (optionalStringAttr2 != null) {
                            String[] strArrSplit = Util.split(optionalStringAttr2, "x");
                            i5 = Integer.parseInt(strArrSplit[0]);
                            i4 = Integer.parseInt(strArrSplit[1]);
                            if (i5 <= 0 || i4 <= 0) {
                                i4 = -1;
                                i5 = -1;
                            }
                        } else {
                            i4 = -1;
                            i5 = -1;
                        }
                        String optionalStringAttr3 = parseOptionalStringAttr(next, REGEX_FRAME_RATE, map3);
                        float f = optionalStringAttr3 != null ? Float.parseFloat(optionalStringAttr3) : -1.0f;
                        String optionalStringAttr4 = parseOptionalStringAttr(next, REGEX_VIDEO, map3);
                        String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_AUDIO, map3);
                        HashMap map4 = map2;
                        String optionalStringAttr6 = parseOptionalStringAttr(next, REGEX_SUBTITLES, map3);
                        String optionalStringAttr7 = parseOptionalStringAttr(next, REGEX_CLOSED_CAPTIONS, map3);
                        if (zStartsWith) {
                            uriResolveToUri = UriUtil.resolveToUri(str, parseStringAttr(next, REGEX_URI, map3));
                        } else {
                            if (!lineIterator.hasNext()) {
                                throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                            }
                            uriResolveToUri = UriUtil.resolveToUri(str, replaceVariableReferences(lineIterator.next(), map3));
                        }
                        arrayList2.add(new HlsMultivariantPlaylist.Variant(uriResolveToUri, new Format.Builder().setId(arrayList2.size()).setContainerMimeType(MimeTypes.APPLICATION_M3U8).setCodecs(optionalStringAttr).setAverageBitrate(optionalIntAttr).setPeakBitrate(intAttr).setWidth(i5).setHeight(i4).setFrameRate(f).setRoleFlags(i6).build(), optionalStringAttr4, optionalStringAttr5, optionalStringAttr6, optionalStringAttr7));
                        map = map4;
                        ArrayList arrayList10 = (ArrayList) map.get(uriResolveToUri);
                        if (arrayList10 == null) {
                            arrayList10 = new ArrayList();
                            map.put(uriResolveToUri, arrayList10);
                        }
                        arrayList10.add(new HlsTrackMetadataEntry.VariantInfo(optionalIntAttr, intAttr, optionalStringAttr4, optionalStringAttr5, optionalStringAttr6, optionalStringAttr7));
                    }
                    map2 = map;
                    arrayList8 = arrayList8;
                    arrayList6 = arrayList6;
                    arrayList9 = arrayList9;
                    arrayList5 = arrayList5;
                    arrayList4 = arrayList4;
                    arrayList3 = arrayList3;
                    arrayList7 = arrayList7;
                }
                map = map2;
                arrayList4 = arrayList4;
                arrayList5 = arrayList5;
                map2 = map;
                arrayList8 = arrayList8;
                arrayList6 = arrayList6;
                arrayList9 = arrayList9;
                arrayList5 = arrayList5;
                arrayList4 = arrayList4;
                arrayList3 = arrayList3;
                arrayList7 = arrayList7;
            } else {
                HashMap map5 = map2;
                ArrayList arrayList11 = arrayList3;
                ArrayList arrayList12 = arrayList4;
                ArrayList arrayList13 = arrayList5;
                ArrayList arrayList14 = arrayList6;
                ArrayList arrayList15 = arrayList7;
                ArrayList arrayList16 = arrayList8;
                ArrayList arrayList17 = arrayList9;
                ArrayList arrayList18 = new ArrayList();
                HashSet hashSet = new HashSet();
                int i7 = 0;
                while (i7 < arrayList2.size()) {
                    HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList2.get(i7);
                    if (hashSet.add(variant.url)) {
                        Assertions.checkState(variant.format.metadata == null);
                        i3 = 1;
                        arrayList18.add(variant.copyWithFormat(variant.format.buildUpon().setMetadata(new Metadata(new HlsTrackMetadataEntry(null, null, (List) Assertions.checkNotNull((ArrayList) map5.get(variant.url))))).build()));
                    } else {
                        i3 = 1;
                    }
                    i7 += i3;
                }
                Uri uri = null;
                ArrayList arrayList19 = null;
                Format formatBuild = null;
                int i8 = 0;
                while (i8 < arrayList15.size()) {
                    ArrayList arrayList20 = arrayList15;
                    String str4 = (String) arrayList20.get(i8);
                    String stringAttr = parseStringAttr(str4, REGEX_GROUP_ID, map3);
                    String stringAttr2 = parseStringAttr(str4, REGEX_NAME, map3);
                    Format.Builder language = new Format.Builder().setId(stringAttr + ":" + stringAttr2).setLabel(stringAttr2).setContainerMimeType(str3).setSelectionFlags(parseSelectionFlags(str4)).setRoleFlags(parseRoleFlags(str4, map3)).setLanguage(parseOptionalStringAttr(str4, REGEX_LANGUAGE, map3));
                    String optionalStringAttr8 = parseOptionalStringAttr(str4, REGEX_URI, map3);
                    Uri uriResolveToUri2 = optionalStringAttr8 == null ? uri : UriUtil.resolveToUri(str, optionalStringAttr8);
                    String str5 = str3;
                    arrayList15 = arrayList20;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(stringAttr, stringAttr2, Collections.emptyList()));
                    String stringAttr3 = parseStringAttr(str4, REGEX_TYPE, map3);
                    stringAttr3.hashCode();
                    switch (stringAttr3) {
                        case "SUBTITLES":
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            HlsMultivariantPlaylist.Variant variantWithSubtitleGroup = getVariantWithSubtitleGroup(arrayList2, stringAttr);
                            if (variantWithSubtitleGroup != null) {
                                String codecsOfType = Util.getCodecsOfType(variantWithSubtitleGroup.format.codecs, 3);
                                language.setCodecs(codecsOfType);
                                mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType);
                            } else {
                                mediaMimeType = null;
                            }
                            if (mediaMimeType == null) {
                                mediaMimeType = MimeTypes.TEXT_VTT;
                            }
                            language.setSampleMimeType(mediaMimeType).setMetadata(metadata);
                            if (uriResolveToUri2 != null) {
                                HlsMultivariantPlaylist.Rendition rendition = new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2);
                                arrayList13 = arrayList13;
                                arrayList13.add(rendition);
                            } else {
                                arrayList13 = arrayList13;
                                Log.m230w("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                            }
                            i2 = 1;
                            break;
                        case "CLOSED-CAPTIONS":
                            arrayList12 = arrayList12;
                            arrayList = arrayList11;
                            String stringAttr4 = parseStringAttr(str4, REGEX_INSTREAM_ID, map3);
                            if (stringAttr4.startsWith("CC")) {
                                i = Integer.parseInt(stringAttr4.substring(2));
                                str2 = MimeTypes.APPLICATION_CEA608;
                            } else {
                                i = Integer.parseInt(stringAttr4.substring(7));
                                str2 = MimeTypes.APPLICATION_CEA708;
                            }
                            if (arrayList19 == null) {
                                arrayList19 = new ArrayList();
                            }
                            language.setSampleMimeType(str2).setAccessibilityChannel(i);
                            arrayList19.add(language.build());
                            i2 = 1;
                            break;
                        case "AUDIO":
                            arrayList = arrayList11;
                            HlsMultivariantPlaylist.Variant variantWithAudioGroup = getVariantWithAudioGroup(arrayList2, stringAttr);
                            if (variantWithAudioGroup != null) {
                                String codecsOfType2 = Util.getCodecsOfType(variantWithAudioGroup.format.codecs, 1);
                                language.setCodecs(codecsOfType2);
                                mediaMimeType2 = MimeTypes.getMediaMimeType(codecsOfType2);
                            } else {
                                mediaMimeType2 = null;
                            }
                            String optionalStringAttr9 = parseOptionalStringAttr(str4, REGEX_CHANNELS, map3);
                            if (optionalStringAttr9 != null) {
                                language.setChannelCount(Integer.parseInt(Util.splitAtFirst(optionalStringAttr9, "/")[0]));
                                if (MimeTypes.AUDIO_E_AC3.equals(mediaMimeType2) && optionalStringAttr9.endsWith("/JOC")) {
                                    language.setCodecs(MimeTypes.CODEC_E_AC3_JOC);
                                    mediaMimeType2 = MimeTypes.AUDIO_E_AC3_JOC;
                                }
                            }
                            language.setSampleMimeType(mediaMimeType2);
                            if (uriResolveToUri2 == null) {
                                arrayList12 = arrayList12;
                                if (variantWithAudioGroup != null) {
                                    formatBuild = language.build();
                                    i2 = 1;
                                }
                                break;
                            } else {
                                language.setMetadata(metadata);
                                arrayList12 = arrayList12;
                                arrayList12.add(new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2));
                            }
                            arrayList13 = arrayList13;
                            i2 = 1;
                            break;
                        case "VIDEO":
                            HlsMultivariantPlaylist.Variant variantWithVideoGroup = getVariantWithVideoGroup(arrayList2, stringAttr);
                            if (variantWithVideoGroup != null) {
                                Format format = variantWithVideoGroup.format;
                                String codecsOfType3 = Util.getCodecsOfType(format.codecs, 2);
                                language.setCodecs(codecsOfType3).setSampleMimeType(MimeTypes.getMediaMimeType(codecsOfType3)).setWidth(format.width).setHeight(format.height).setFrameRate(format.frameRate);
                            }
                            if (uriResolveToUri2 != null) {
                                language.setMetadata(metadata);
                                arrayList = arrayList11;
                                arrayList.add(new HlsMultivariantPlaylist.Rendition(uriResolveToUri2, language.build(), stringAttr, stringAttr2));
                            }
                            i2 = 1;
                        default:
                            arrayList = arrayList11;
                            i2 = 1;
                            break;
                    }
                    i8 += i2;
                    arrayList13 = arrayList13;
                    arrayList11 = arrayList;
                    arrayList12 = arrayList12;
                    str3 = str5;
                    uri = null;
                }
                return new HlsMultivariantPlaylist(str, arrayList17, arrayList18, arrayList11, arrayList12, arrayList13, arrayList14, formatBuild, zContains ? Collections.emptyList() : arrayList19, z, map3, arrayList16);
            }
        }
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithAudioGroup(ArrayList arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList.get(i);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithVideoGroup(ArrayList arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList.get(i);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMultivariantPlaylist.Variant getVariantWithSubtitleGroup(ArrayList arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            HlsMultivariantPlaylist.Variant variant = (HlsMultivariantPlaylist.Variant) arrayList.get(i);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HlsMediaPlaylist parseMediaPlaylist(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist, LineIterator lineIterator, String str) throws DeltaUpdateException, ParserException {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        boolean z;
        int i;
        HlsMediaPlaylist.Part part;
        String optionalStringAttr;
        long j;
        long j2;
        long j3;
        long j4;
        boolean z2;
        Object drmInitData;
        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
        hlsMediaPlaylist = hlsMediaPlaylist;
        boolean z3 = hlsMultivariantPlaylist.hasIndependentSegments;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        HlsMediaPlaylist.ServerControl serverControl = new HlsMediaPlaylist.ServerControl(C0740C.TIME_UNSET, false, C0740C.TIME_UNSET, C0740C.TIME_UNSET, false);
        TreeMap treeMap = new TreeMap();
        boolean z4 = false;
        String str3 = "";
        boolean z5 = z3;
        HlsMediaPlaylist.ServerControl serverControl2 = serverControl;
        int i2 = 0;
        boolean optionalBooleanAttribute = false;
        boolean z6 = false;
        int i3 = 0;
        boolean z7 = false;
        boolean z8 = false;
        int i4 = 0;
        boolean z9 = false;
        String optionalStringAttr2 = str3;
        String stringAttr = null;
        long doubleAttr = C0740C.TIME_UNSET;
        long jMsToUs = 0;
        long j5 = 0;
        int intAttr = 1;
        long intAttr2 = C0740C.TIME_UNSET;
        long doubleAttr2 = C0740C.TIME_UNSET;
        DrmInitData playlistProtectionSchemes = null;
        long j6 = 0;
        Object obj = null;
        long j7 = 0;
        long j8 = -1;
        String str4 = null;
        String encryptionScheme = null;
        long j9 = 0;
        long longAttr = 0;
        HlsMediaPlaylist.Segment segment = null;
        long timeSecondsToUs = 0;
        long j10 = 0;
        ArrayList arrayList7 = arrayList4;
        HlsMediaPlaylist.Part part2 = null;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith("#EXT")) {
                arrayList6.add(next);
            }
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String stringAttr2 = parseStringAttr(next, REGEX_PLAYLIST_TYPE, map);
                if ("VOD".equals(stringAttr2)) {
                    i2 = 1;
                } else if ("EVENT".equals(stringAttr2)) {
                    i2 = 2;
                }
            } else if (next.equals("#EXT-X-I-FRAMES-ONLY")) {
                z9 = true;
            } else if (next.startsWith("#EXT-X-START")) {
                doubleAttr = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
                optionalBooleanAttribute = parseOptionalBooleanAttribute(next, REGEX_PRECISE, z4);
            } else if (next.startsWith("#EXT-X-SERVER-CONTROL")) {
                serverControl2 = parseServerControl(next);
            } else if (next.startsWith("#EXT-X-PART-INF")) {
                doubleAttr2 = (long) (parseDoubleAttr(next, REGEX_PART_TARGET_DURATION) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                String stringAttr3 = parseStringAttr(next, REGEX_URI, map);
                String optionalStringAttr3 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                if (optionalStringAttr3 != null) {
                    String[] strArrSplit = Util.split(optionalStringAttr3, GherkinLanguageConstants.TAG_PREFIX);
                    j8 = Long.parseLong(strArrSplit[z4 ? 1 : 0]);
                    if (strArrSplit.length > 1) {
                        j6 = Long.parseLong(strArrSplit[1]);
                    }
                }
                if (j8 == -1) {
                    j6 = 0;
                }
                String str5 = str4;
                if (stringAttr != null && str5 == null) {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
                segment = new HlsMediaPlaylist.Segment(stringAttr3, j6, j8, stringAttr, str5);
                if (j8 != -1) {
                    j6 += j8;
                }
                str4 = str5;
                j8 = -1;
            } else {
                String str6 = str4;
                if (next.startsWith("#EXT-X-TARGETDURATION")) {
                    intAttr2 = 1000000 * ((long) parseIntAttr(next, REGEX_TARGET_DURATION));
                } else {
                    if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                        longAttr = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                        str4 = str6;
                        j5 = longAttr;
                    } else if (next.startsWith("#EXT-X-VERSION")) {
                        intAttr = parseIntAttr(next, REGEX_VERSION);
                    } else {
                        if (next.startsWith("#EXT-X-DEFINE")) {
                            String optionalStringAttr4 = parseOptionalStringAttr(next, REGEX_IMPORT, map);
                            if (optionalStringAttr4 != null) {
                                String str7 = hlsMultivariantPlaylist.variableDefinitions.get(optionalStringAttr4);
                                if (str7 != null) {
                                    map.put(optionalStringAttr4, str7);
                                }
                            } else {
                                map.put(parseStringAttr(next, REGEX_NAME, map), parseStringAttr(next, REGEX_VALUE, map));
                            }
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            str2 = encryptionScheme;
                            z = false;
                            i = i2;
                        } else if (next.startsWith("#EXTINF")) {
                            timeSecondsToUs = parseTimeSecondsToUs(next, REGEX_MEDIA_DURATION);
                            optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_MEDIA_TITLE, str3, map);
                        } else {
                            String str8 = str3;
                            if (next.startsWith("#EXT-X-SKIP")) {
                                int intAttr3 = parseIntAttr(next, REGEX_SKIPPED_SEGMENTS);
                                Assertions.checkState(hlsMediaPlaylist != null && arrayList3.isEmpty());
                                int i5 = (int) (j5 - ((HlsMediaPlaylist) Util.castNonNull(hlsMediaPlaylist)).mediaSequence);
                                int i6 = intAttr3 + i5;
                                if (i5 < 0 || i6 > hlsMediaPlaylist.segments.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str3 = str8;
                                String str9 = str6;
                                long j11 = j9;
                                while (i5 < i6) {
                                    HlsMediaPlaylist.Segment segmentCopyWith = hlsMediaPlaylist.segments.get(i5);
                                    ArrayList arrayList8 = arrayList7;
                                    ArrayList arrayList9 = arrayList6;
                                    if (j5 != hlsMediaPlaylist.mediaSequence) {
                                        segmentCopyWith = segmentCopyWith.copyWith(j11, (hlsMediaPlaylist.discontinuitySequence - i3) + segmentCopyWith.relativeDiscontinuitySequence);
                                    }
                                    arrayList3.add(segmentCopyWith);
                                    j11 += segmentCopyWith.durationUs;
                                    long j12 = segmentCopyWith.byteRangeLength;
                                    if (j12 != -1) {
                                        j6 = segmentCopyWith.byteRangeOffset + j12;
                                    }
                                    int i7 = segmentCopyWith.relativeDiscontinuitySequence;
                                    HlsMediaPlaylist.Segment segment2 = segmentCopyWith.initializationSegment;
                                    DrmInitData drmInitData2 = segmentCopyWith.drmInitData;
                                    String str10 = segmentCopyWith.fullSegmentEncryptionKeyUri;
                                    String str11 = segmentCopyWith.encryptionIV;
                                    if (str11 == null || !str11.equals(Long.toHexString(longAttr))) {
                                        str9 = segmentCopyWith.encryptionIV;
                                    }
                                    longAttr++;
                                    i5++;
                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                    obj = drmInitData2;
                                    stringAttr = str10;
                                    j7 = j11;
                                    i6 = i6;
                                    i4 = i7;
                                    segment = segment2;
                                    arrayList7 = arrayList8;
                                    arrayList6 = arrayList9;
                                }
                                hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                hlsMediaPlaylist = hlsMediaPlaylist;
                                j9 = j11;
                                str4 = str9;
                            } else {
                                ArrayList arrayList10 = arrayList7;
                                arrayList2 = arrayList6;
                                str3 = str8;
                                if (next.startsWith("#EXT-X-KEY")) {
                                    String stringAttr4 = parseStringAttr(next, REGEX_METHOD, map);
                                    String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY, map);
                                    if ("NONE".equals(stringAttr4)) {
                                        treeMap.clear();
                                        optionalStringAttr = null;
                                        stringAttr = null;
                                    } else {
                                        optionalStringAttr = parseOptionalStringAttr(next, REGEX_IV, map);
                                        if (InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY.equals(optionalStringAttr5)) {
                                            if ("AES-128".equals(stringAttr4)) {
                                                stringAttr = parseStringAttr(next, REGEX_URI, map);
                                            }
                                            str4 = optionalStringAttr;
                                        } else {
                                            String str12 = encryptionScheme;
                                            encryptionScheme = str12 == null ? parseEncryptionScheme(stringAttr4) : str12;
                                            DrmInitData.SchemeData drmSchemeData = parseDrmSchemeData(next, optionalStringAttr5, map);
                                            if (drmSchemeData != null) {
                                                treeMap.put(optionalStringAttr5, drmSchemeData);
                                                stringAttr = null;
                                            }
                                            str4 = optionalStringAttr;
                                        }
                                        stringAttr = null;
                                        str4 = optionalStringAttr;
                                    }
                                    obj = stringAttr;
                                    str4 = optionalStringAttr;
                                } else {
                                    String str13 = encryptionScheme;
                                    if (next.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] strArrSplit2 = Util.split(parseStringAttr(next, REGEX_BYTERANGE, map), GherkinLanguageConstants.TAG_PREFIX);
                                        j8 = Long.parseLong(strArrSplit2[0]);
                                        if (strArrSplit2.length > 1) {
                                            j6 = Long.parseLong(strArrSplit2[1]);
                                        }
                                    } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i3 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                        encryptionScheme = str13;
                                        str4 = str6;
                                        arrayList7 = arrayList10;
                                        arrayList6 = arrayList2;
                                        z4 = false;
                                        z6 = true;
                                    } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                                        i4++;
                                    } else {
                                        if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                            if (jMsToUs == 0) {
                                                jMsToUs = Util.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j9;
                                            } else {
                                                i = i2;
                                                str2 = str13;
                                            }
                                        } else if (next.equals("#EXT-X-GAP")) {
                                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            encryptionScheme = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z4 = false;
                                            z8 = true;
                                        } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            encryptionScheme = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z4 = false;
                                            z5 = true;
                                        } else if (next.equals("#EXT-X-ENDLIST")) {
                                            hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                            hlsMediaPlaylist = hlsMediaPlaylist;
                                            encryptionScheme = str13;
                                            str4 = str6;
                                            arrayList7 = arrayList10;
                                            arrayList6 = arrayList2;
                                            z4 = false;
                                            z7 = true;
                                        } else if (next.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            i = i2;
                                            str2 = str13;
                                            arrayList5.add(new HlsMediaPlaylist.RenditionReport(Uri.parse(UriUtil.resolve(str, parseStringAttr(next, REGEX_URI, map))), parseOptionalLongAttr(next, REGEX_LAST_MSN, -1L), parseOptionalIntAttr(next, REGEX_LAST_PART, -1)));
                                        } else {
                                            i = i2;
                                            str2 = str13;
                                            if (next.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                if (part2 == null && "PART".equals(parseStringAttr(next, REGEX_PRELOAD_HINT_TYPE, map))) {
                                                    String stringAttr5 = parseStringAttr(next, REGEX_URI, map);
                                                    long optionalLongAttr = parseOptionalLongAttr(next, REGEX_BYTERANGE_START, -1L);
                                                    long optionalLongAttr2 = parseOptionalLongAttr(next, REGEX_BYTERANGE_LENGTH, -1L);
                                                    long j13 = longAttr;
                                                    String segmentEncryptionIV = getSegmentEncryptionIV(j13, stringAttr, str6);
                                                    if (obj == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData3 = new DrmInitData(str2, schemeDataArr);
                                                        if (playlistProtectionSchemes == null) {
                                                            playlistProtectionSchemes = getPlaylistProtectionSchemes(str2, schemeDataArr);
                                                        }
                                                        obj = drmInitData3;
                                                    }
                                                    if (optionalLongAttr == -1 || optionalLongAttr2 != -1) {
                                                        part2 = new HlsMediaPlaylist.Part(stringAttr5, segment, 0L, i4, j7, obj, stringAttr, segmentEncryptionIV, optionalLongAttr != -1 ? optionalLongAttr : 0L, optionalLongAttr2, false, false, true);
                                                    }
                                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                                    longAttr = j13;
                                                    str4 = str6;
                                                    arrayList7 = arrayList10;
                                                    i2 = i;
                                                    arrayList6 = arrayList2;
                                                    encryptionScheme = str2;
                                                }
                                            } else {
                                                longAttr = longAttr;
                                                if (next.startsWith("#EXT-X-PART")) {
                                                    String segmentEncryptionIV2 = getSegmentEncryptionIV(longAttr, stringAttr, str6);
                                                    String stringAttr6 = parseStringAttr(next, REGEX_URI, map);
                                                    long doubleAttr3 = (long) (parseDoubleAttr(next, REGEX_ATTR_DURATION) * 1000000.0d);
                                                    HlsMediaPlaylist.Part part3 = part2;
                                                    boolean optionalBooleanAttribute2 = parseOptionalBooleanAttribute(next, REGEX_INDEPENDENT, false) | (z5 && arrayList10.isEmpty());
                                                    boolean optionalBooleanAttribute3 = parseOptionalBooleanAttribute(next, REGEX_GAP, false);
                                                    String optionalStringAttr6 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                                                    if (optionalStringAttr6 != null) {
                                                        String[] strArrSplit3 = Util.split(optionalStringAttr6, GherkinLanguageConstants.TAG_PREFIX);
                                                        j2 = Long.parseLong(strArrSplit3[0]);
                                                        if (strArrSplit3.length > 1) {
                                                            j10 = Long.parseLong(strArrSplit3[1]);
                                                        }
                                                        j = -1;
                                                    } else {
                                                        j = -1;
                                                        j2 = -1;
                                                    }
                                                    if (j2 == j) {
                                                        j10 = 0;
                                                    }
                                                    if (obj == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData4 = new DrmInitData(str2, schemeDataArr2);
                                                        if (playlistProtectionSchemes == null) {
                                                            playlistProtectionSchemes = getPlaylistProtectionSchemes(str2, schemeDataArr2);
                                                        }
                                                        obj = drmInitData4;
                                                    }
                                                    arrayList10.add(new HlsMediaPlaylist.Part(stringAttr6, segment, doubleAttr3, i4, j7, obj, stringAttr, segmentEncryptionIV2, j10, j2, optionalBooleanAttribute3, optionalBooleanAttribute2, false));
                                                    j7 += doubleAttr3;
                                                    if (j2 != j) {
                                                        j10 += j2;
                                                    }
                                                    hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                    hlsMediaPlaylist = hlsMediaPlaylist;
                                                    str4 = str6;
                                                    i2 = i;
                                                    part2 = part3;
                                                    longAttr = longAttr;
                                                    encryptionScheme = str2;
                                                    arrayList7 = arrayList10;
                                                    arrayList6 = arrayList2;
                                                } else {
                                                    part = part2;
                                                    arrayList = arrayList10;
                                                    if (next.startsWith(GherkinLanguageConstants.COMMENT_PREFIX)) {
                                                        z = false;
                                                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                        str4 = str6;
                                                        i2 = i;
                                                        part2 = part;
                                                        longAttr = longAttr;
                                                        encryptionScheme = str2;
                                                        arrayList7 = arrayList;
                                                        arrayList6 = arrayList2;
                                                        z4 = z;
                                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                                    } else {
                                                        String segmentEncryptionIV3 = getSegmentEncryptionIV(longAttr, stringAttr, str6);
                                                        long j14 = longAttr + 1;
                                                        String strReplaceVariableReferences = replaceVariableReferences(next, map);
                                                        HlsMediaPlaylist.Segment segment3 = (HlsMediaPlaylist.Segment) map2.get(strReplaceVariableReferences);
                                                        if (j8 == -1) {
                                                            j3 = 0;
                                                        } else {
                                                            if (z9 && segment == null && segment3 == null) {
                                                                segment3 = new HlsMediaPlaylist.Segment(strReplaceVariableReferences, 0L, j6, null, null);
                                                                map2.put(strReplaceVariableReferences, segment3);
                                                            }
                                                            j3 = j6;
                                                        }
                                                        if (obj != null || treeMap.isEmpty()) {
                                                            j4 = j14;
                                                            z2 = false;
                                                            drmInitData = obj;
                                                        } else {
                                                            j4 = j14;
                                                            z2 = false;
                                                            DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            drmInitData = new DrmInitData(str2, schemeDataArr3);
                                                            if (playlistProtectionSchemes == null) {
                                                                playlistProtectionSchemes = getPlaylistProtectionSchemes(str2, schemeDataArr3);
                                                            }
                                                        }
                                                        arrayList3.add(new HlsMediaPlaylist.Segment(strReplaceVariableReferences, segment != null ? segment : segment3, optionalStringAttr2, timeSecondsToUs, i4, j9, drmInitData, stringAttr, segmentEncryptionIV3, j3, j8, z8, arrayList));
                                                        j7 = j9 + timeSecondsToUs;
                                                        arrayList7 = new ArrayList();
                                                        if (j8 != -1) {
                                                            j3 += j8;
                                                        }
                                                        j6 = j3;
                                                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                                                        z8 = z2;
                                                        str4 = str6;
                                                        obj = drmInitData;
                                                        optionalStringAttr2 = str3;
                                                        j9 = j7;
                                                        i2 = i;
                                                        part2 = part;
                                                        arrayList6 = arrayList2;
                                                        j8 = -1;
                                                        timeSecondsToUs = 0;
                                                        encryptionScheme = str2;
                                                        longAttr = j4;
                                                        hlsMediaPlaylist = hlsMediaPlaylist;
                                                        z4 = z8;
                                                    }
                                                }
                                            }
                                        }
                                        arrayList = arrayList10;
                                        z = false;
                                    }
                                    encryptionScheme = str13;
                                    str4 = str6;
                                }
                                arrayList7 = arrayList10;
                                arrayList6 = arrayList2;
                            }
                        }
                        part = part2;
                        hlsMultivariantPlaylist = hlsMultivariantPlaylist;
                        str4 = str6;
                        i2 = i;
                        part2 = part;
                        longAttr = longAttr;
                        encryptionScheme = str2;
                        arrayList7 = arrayList;
                        arrayList6 = arrayList2;
                        z4 = z;
                        hlsMediaPlaylist = hlsMediaPlaylist;
                    }
                    z4 = false;
                }
                str4 = str6;
                z4 = false;
            }
        }
        int i8 = i2;
        HlsMediaPlaylist.Part part4 = part2;
        ArrayList arrayList11 = arrayList7;
        ArrayList arrayList12 = arrayList6;
        byte b = z4 ? 1 : 0;
        HashMap map3 = new HashMap();
        for (int i9 = b == true ? 1 : 0; i9 < arrayList5.size(); i9++) {
            HlsMediaPlaylist.RenditionReport renditionReport = (HlsMediaPlaylist.RenditionReport) arrayList5.get(i9);
            long size = renditionReport.lastMediaSequence;
            if (size == -1) {
                size = (j5 + ((long) arrayList3.size())) - (arrayList11.isEmpty() ? 1L : 0L);
            }
            int size2 = renditionReport.lastPartIndex;
            if (size2 == -1 && doubleAttr2 != C0740C.TIME_UNSET) {
                size2 = (arrayList11.isEmpty() ? ((HlsMediaPlaylist.Segment) Iterables.getLast(arrayList3)).parts : arrayList11).size() - 1;
            }
            Uri uri = renditionReport.playlistUri;
            map3.put(uri, new HlsMediaPlaylist.RenditionReport(uri, size, size2));
        }
        if (part4 != null) {
            arrayList11.add(part4);
        }
        return new HlsMediaPlaylist(i8, str, arrayList12, doubleAttr, optionalBooleanAttribute, jMsToUs, z6, i3, j5, intAttr, intAttr2, doubleAttr2, z5, z7, jMsToUs != 0, playlistProtectionSchemes, arrayList3, arrayList11, serverControl2, map3);
    }

    private static DrmInitData getPlaylistProtectionSchemes(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i = 0; i < schemeDataArr.length; i++) {
            schemeDataArr2[i] = schemeDataArr[i].copyWithData(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String getSegmentEncryptionIV(long j, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private static int parseSelectionFlags(String str) {
        boolean optionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false);
        ?? r0 = optionalBooleanAttribute;
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            r0 = (optionalBooleanAttribute ? 1 : 0) | 2;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? r0 | 4 : r0;
    }

    private static int parseRoleFlags(String str, Map map) {
        String optionalStringAttr = parseOptionalStringAttr(str, REGEX_CHARACTERISTICS, map);
        if (TextUtils.isEmpty(optionalStringAttr)) {
            return 0;
        }
        String[] strArrSplit = Util.split(optionalStringAttr, ",");
        int i = Util.contains(strArrSplit, "public.accessibility.describes-video") ? 512 : 0;
        if (Util.contains(strArrSplit, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (Util.contains(strArrSplit, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        return Util.contains(strArrSplit, "public.easy-to-read") ? i | 8192 : i;
    }

    private static DrmInitData.SchemeData parseDrmSchemeData(String str, String str2, Map map) throws ParserException {
        String optionalStringAttr = parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String stringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C0740C.WIDEVINE_UUID, MimeTypes.VIDEO_MP4, Base64.decode(stringAttr.substring(stringAttr.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(C0740C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(optionalStringAttr)) {
            return null;
        }
        String stringAttr2 = parseStringAttr(str, REGEX_URI, map);
        byte[] bArrDecode = Base64.decode(stringAttr2.substring(stringAttr2.indexOf(44)), 0);
        UUID uuid = C0740C.PLAYREADY_UUID;
        return new DrmInitData.SchemeData(uuid, MimeTypes.VIDEO_MP4, PsshAtomUtil.buildPsshAtom(uuid, bArrDecode));
    }

    private static HlsMediaPlaylist.ServerControl parseServerControl(String str) {
        double optionalDoubleAttr = parseOptionalDoubleAttr(str, REGEX_CAN_SKIP_UNTIL, -9.223372036854776E18d);
        long j = C0740C.TIME_UNSET;
        long j2 = optionalDoubleAttr == -9.223372036854776E18d ? -9223372036854775807L : (long) (optionalDoubleAttr * 1000000.0d);
        boolean optionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_CAN_SKIP_DATE_RANGES, false);
        double optionalDoubleAttr2 = parseOptionalDoubleAttr(str, REGEX_HOLD_BACK, -9.223372036854776E18d);
        long j3 = optionalDoubleAttr2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (optionalDoubleAttr2 * 1000000.0d);
        double optionalDoubleAttr3 = parseOptionalDoubleAttr(str, REGEX_PART_HOLD_BACK, -9.223372036854776E18d);
        if (optionalDoubleAttr3 != -9.223372036854776E18d) {
            j = (long) (optionalDoubleAttr3 * 1000000.0d);
        }
        return new HlsMediaPlaylist.ServerControl(j2, optionalBooleanAttribute, j3, j, parseOptionalBooleanAttribute(str, REGEX_CAN_BLOCK_RELOAD, false));
    }

    private static String parseEncryptionScheme(String str) {
        if ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) {
            return C0740C.CENC_TYPE_cenc;
        }
        return C0740C.CENC_TYPE_cbcs;
    }

    private static int parseIntAttr(String str, Pattern pattern) {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static int parseOptionalIntAttr(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))) : i;
    }

    private static long parseLongAttr(String str, Pattern pattern) {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static long parseOptionalLongAttr(String str, Pattern pattern, long j) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) : j;
    }

    private static long parseTimeSecondsToUs(String str, Pattern pattern) {
        return new BigDecimal(parseStringAttr(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000L)).longValue();
    }

    private static double parseDoubleAttr(String str, Pattern pattern) {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map map) throws ParserException {
        String optionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (optionalStringAttr != null) {
            return optionalStringAttr;
        }
        throw ParserException.createForMalformedManifest("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, Map map) {
        return parseOptionalStringAttr(str, pattern, null, map);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) Assertions.checkNotNull(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : replaceVariableReferences(str2, map);
    }

    private static double parseOptionalDoubleAttr(String str, Pattern pattern, double d) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) Assertions.checkNotNull(matcher.group(1))) : d;
    }

    private static String replaceVariableReferences(String str, Map map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z;
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(NO" + GherkinLanguageConstants.TABLE_CELL_SEPARATOR + "YES)");
    }

    private static class LineIterator {
        private final Queue extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            String strTrim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = (String) Assertions.checkNotNull((String) this.extraLines.poll());
                return true;
            }
            do {
                String line = this.reader.readLine();
                this.next = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.next = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String next() {
            if (hasNext()) {
                String str = this.next;
                this.next = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }
}
