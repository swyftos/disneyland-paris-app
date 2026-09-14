package androidx.media3.extractor.mp4;

import androidx.media3.common.C0740C;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.Id3Util;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.collect.ImmutableList;

/* JADX INFO: loaded from: classes.dex */
abstract class MetadataUtil {
    public static void setFormatMetadata(int i, Metadata metadata, Format.Builder builder, Metadata... metadataArr) {
        Metadata metadata2 = new Metadata(new Metadata.Entry[0]);
        if (metadata != null) {
            for (int i2 = 0; i2 < metadata.length(); i2++) {
                Metadata.Entry entry = metadata.get(i2);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if (!mdtaMetadataEntry.key.equals(MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS)) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    } else if (i == 2) {
                        metadata2 = metadata2.copyWithAppendedEntries(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata metadata3 : metadataArr) {
            metadata2 = metadata2.copyWithAppendedEntriesFrom(metadata3);
        }
        if (metadata2.length() > 0) {
            builder.setMetadata(metadata2);
        }
    }

    public static void setFormatGaplessInfo(int i, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i == 1 && gaplessInfoHolder.hasGaplessInfo()) {
            builder.setEncoderDelay(gaplessInfoHolder.encoderDelay).setEncoderPadding(gaplessInfoHolder.encoderPadding);
        }
    }

    public static Metadata.Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition() + parsableByteArray.readInt();
        int i = parsableByteArray.readInt();
        int i2 = (i >> 24) & 255;
        try {
            if (i2 == 169 || i2 == 253) {
                int i3 = 16777215 & i;
                if (i3 == 6516084) {
                    CommentFrame commentAttribute = parseCommentAttribute(i, parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return commentAttribute;
                }
                if (i3 == 7233901 || i3 == 7631467) {
                    TextInformationFrame textAttribute = parseTextAttribute(i, "TIT2", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute;
                }
                if (i3 == 6516589 || i3 == 7828084) {
                    TextInformationFrame textAttribute2 = parseTextAttribute(i, "TCOM", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute2;
                }
                if (i3 == 6578553) {
                    TextInformationFrame textAttribute3 = parseTextAttribute(i, "TDRC", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute3;
                }
                if (i3 == 4280916) {
                    TextInformationFrame textAttribute4 = parseTextAttribute(i, "TPE1", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute4;
                }
                if (i3 == 7630703) {
                    TextInformationFrame textAttribute5 = parseTextAttribute(i, "TSSE", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute5;
                }
                if (i3 == 6384738) {
                    TextInformationFrame textAttribute6 = parseTextAttribute(i, "TALB", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute6;
                }
                if (i3 == 7108978) {
                    TextInformationFrame textAttribute7 = parseTextAttribute(i, "USLT", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute7;
                }
                if (i3 == 6776174) {
                    TextInformationFrame textAttribute8 = parseTextAttribute(i, "TCON", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute8;
                }
                if (i3 == 6779504) {
                    TextInformationFrame textAttribute9 = parseTextAttribute(i, "TIT1", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute9;
                }
            } else {
                if (i == 1735291493) {
                    TextInformationFrame standardGenreAttribute = parseStandardGenreAttribute(parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return standardGenreAttribute;
                }
                if (i == 1684632427) {
                    TextInformationFrame indexAndCountAttribute = parseIndexAndCountAttribute(i, "TPOS", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return indexAndCountAttribute;
                }
                if (i == 1953655662) {
                    TextInformationFrame indexAndCountAttribute2 = parseIndexAndCountAttribute(i, "TRCK", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return indexAndCountAttribute2;
                }
                if (i == 1953329263) {
                    Id3Frame integerAttribute = parseIntegerAttribute(i, "TBPM", parsableByteArray, true, false);
                    parsableByteArray.setPosition(position);
                    return integerAttribute;
                }
                if (i == 1668311404) {
                    Id3Frame integerAttribute2 = parseIntegerAttribute(i, "TCMP", parsableByteArray, true, true);
                    parsableByteArray.setPosition(position);
                    return integerAttribute2;
                }
                if (i == 1668249202) {
                    ApicFrame coverArt = parseCoverArt(parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return coverArt;
                }
                if (i == 1631670868) {
                    TextInformationFrame textAttribute10 = parseTextAttribute(i, "TPE2", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute10;
                }
                if (i == 1936682605) {
                    TextInformationFrame textAttribute11 = parseTextAttribute(i, "TSOT", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute11;
                }
                if (i == 1936679276) {
                    TextInformationFrame textAttribute12 = parseTextAttribute(i, "TSOA", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute12;
                }
                if (i == 1936679282) {
                    TextInformationFrame textAttribute13 = parseTextAttribute(i, "TSOP", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute13;
                }
                if (i == 1936679265) {
                    TextInformationFrame textAttribute14 = parseTextAttribute(i, "TSO2", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute14;
                }
                if (i == 1936679791) {
                    TextInformationFrame textAttribute15 = parseTextAttribute(i, "TSOC", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute15;
                }
                if (i == 1920233063) {
                    Id3Frame integerAttribute3 = parseIntegerAttribute(i, "ITUNESADVISORY", parsableByteArray, false, false);
                    parsableByteArray.setPosition(position);
                    return integerAttribute3;
                }
                if (i == 1885823344) {
                    Id3Frame integerAttribute4 = parseIntegerAttribute(i, "ITUNESGAPLESS", parsableByteArray, false, true);
                    parsableByteArray.setPosition(position);
                    return integerAttribute4;
                }
                if (i == 1936683886) {
                    TextInformationFrame textAttribute16 = parseTextAttribute(i, "TVSHOWSORT", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute16;
                }
                if (i == 1953919848) {
                    TextInformationFrame textAttribute17 = parseTextAttribute(i, "TVSHOW", parsableByteArray);
                    parsableByteArray.setPosition(position);
                    return textAttribute17;
                }
                if (i == 757935405) {
                    Id3Frame internalAttribute = parseInternalAttribute(parsableByteArray, position);
                    parsableByteArray.setPosition(position);
                    return internalAttribute;
                }
            }
            Log.m224d("MetadataUtil", "Skipped unknown metadata entry: " + Atom.getAtomTypeString(i));
            parsableByteArray.setPosition(position);
            return null;
        } catch (Throwable th) {
            parsableByteArray.setPosition(position);
            throw th;
        }
    }

    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray parsableByteArray, int i, String str) {
        while (true) {
            int position = parsableByteArray.getPosition();
            if (position >= i) {
                return null;
            }
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1684108385) {
                int i3 = parsableByteArray.readInt();
                int i4 = parsableByteArray.readInt();
                int i5 = i2 - 16;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                return new MdtaMetadataEntry(str, bArr, i4, i3);
            }
            parsableByteArray.setPosition(position + i2);
        }
    }

    private static TextInformationFrame parseTextAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            return new TextInformationFrame(str, (String) null, ImmutableList.m1517of(parsableByteArray.readNullTerminatedString(i2 - 16)));
        }
        Log.m230w("MetadataUtil", "Failed to parse text attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    private static CommentFrame parseCommentAttribute(int i, ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            String nullTerminatedString = parsableByteArray.readNullTerminatedString(i2 - 16);
            return new CommentFrame(C0740C.LANGUAGE_UNDETERMINED, nullTerminatedString, nullTerminatedString);
        }
        Log.m230w("MetadataUtil", "Failed to parse comment attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    private static Id3Frame parseIntegerAttribute(int i, String str, ParsableByteArray parsableByteArray, boolean z, boolean z2) {
        int integerAttribute = parseIntegerAttribute(parsableByteArray);
        if (z2) {
            integerAttribute = Math.min(1, integerAttribute);
        }
        if (integerAttribute >= 0) {
            if (z) {
                return new TextInformationFrame(str, (String) null, ImmutableList.m1517of(Integer.toString(integerAttribute)));
            }
            return new CommentFrame(C0740C.LANGUAGE_UNDETERMINED, str, Integer.toString(integerAttribute));
        }
        Log.m230w("MetadataUtil", "Failed to parse uint8 attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    private static int parseIntegerAttribute(ParsableByteArray parsableByteArray) {
        int i = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385) {
            parsableByteArray.skipBytes(8);
            int i2 = i - 16;
            if (i2 == 1) {
                return parsableByteArray.readUnsignedByte();
            }
            if (i2 == 2) {
                return parsableByteArray.readUnsignedShort();
            }
            if (i2 == 3) {
                return parsableByteArray.readUnsignedInt24();
            }
            if (i2 == 4 && (parsableByteArray.peekUnsignedByte() & 128) == 0) {
                return parsableByteArray.readUnsignedIntToInt();
            }
        }
        Log.m230w("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static TextInformationFrame parseIndexAndCountAttribute(int i, String str, ParsableByteArray parsableByteArray) {
        int i2 = parsableByteArray.readInt();
        if (parsableByteArray.readInt() == 1684108385 && i2 >= 22) {
            parsableByteArray.skipBytes(10);
            int unsignedShort = parsableByteArray.readUnsignedShort();
            if (unsignedShort > 0) {
                String str2 = "" + unsignedShort;
                int unsignedShort2 = parsableByteArray.readUnsignedShort();
                if (unsignedShort2 > 0) {
                    str2 = str2 + "/" + unsignedShort2;
                }
                return new TextInformationFrame(str, (String) null, ImmutableList.m1517of(str2));
            }
        }
        Log.m230w("MetadataUtil", "Failed to parse index/count attribute: " + Atom.getAtomTypeString(i));
        return null;
    }

    private static TextInformationFrame parseStandardGenreAttribute(ParsableByteArray parsableByteArray) {
        String strResolveV1Genre = Id3Util.resolveV1Genre(parseIntegerAttribute(parsableByteArray) - 1);
        if (strResolveV1Genre != null) {
            return new TextInformationFrame("TCON", (String) null, ImmutableList.m1517of(strResolveV1Genre));
        }
        Log.m230w("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray) {
        String str;
        int i = parsableByteArray.readInt();
        if (parsableByteArray.readInt() != 1684108385) {
            Log.m230w("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int fullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if (fullAtomFlags == 13) {
            str = "image/jpeg";
        } else {
            str = fullAtomFlags == 14 ? "image/png" : null;
        }
        if (str == null) {
            Log.m230w("MetadataUtil", "Unrecognized cover art flags: " + fullAtomFlags);
            return null;
        }
        parsableByteArray.skipBytes(4);
        int i2 = i - 16;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new ApicFrame(str, null, 3, bArr);
    }

    private static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray, int i) {
        String nullTerminatedString = null;
        String nullTerminatedString2 = null;
        int i2 = -1;
        int i3 = -1;
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i4 = parsableByteArray.readInt();
            int i5 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            if (i5 == 1835360622) {
                nullTerminatedString = parsableByteArray.readNullTerminatedString(i4 - 12);
            } else if (i5 == 1851878757) {
                nullTerminatedString2 = parsableByteArray.readNullTerminatedString(i4 - 12);
            } else {
                if (i5 == 1684108385) {
                    i2 = position;
                    i3 = i4;
                }
                parsableByteArray.skipBytes(i4 - 12);
            }
        }
        if (nullTerminatedString == null || nullTerminatedString2 == null || i2 == -1) {
            return null;
        }
        parsableByteArray.setPosition(i2);
        parsableByteArray.skipBytes(16);
        return new InternalFrame(nullTerminatedString, nullTerminatedString2, parsableByteArray.readNullTerminatedString(i3 - 16));
    }
}
