package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class HevcConfig {
    public final int bitdepthChroma;
    public final int bitdepthLuma;

    @Nullable
    public final String codecs;
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    public final int height;
    public final List<byte[]> initializationData;
    public final int maxNumReorderPics;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.skipBytes(21);
            int unsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int unsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < unsignedByte2; i3++) {
                parsableByteArray.skipBytes(1);
                int unsignedShort = parsableByteArray.readUnsignedShort();
                for (int i4 = 0; i4 < unsignedShort; i4++) {
                    int unsignedShort2 = parsableByteArray.readUnsignedShort();
                    i2 += unsignedShort2 + 4;
                    parsableByteArray.skipBytes(unsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i2];
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            float f = 1.0f;
            String strBuildHevcCodecString = null;
            int i13 = 0;
            int i14 = 0;
            while (i13 < unsignedByte2) {
                int unsignedByte3 = parsableByteArray.readUnsignedByte() & 63;
                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                int i15 = i;
                while (i15 < unsignedShort3) {
                    int unsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    int i16 = unsignedByte2;
                    System.arraycopy(bArr2, i, bArr, i14, bArr2.length);
                    int length = i14 + bArr2.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, unsignedShort4);
                    if (unsignedByte3 == 33 && i15 == 0) {
                        NalUnitUtil.H265SpsData h265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + unsignedShort4);
                        int i17 = h265SpsNalUnit.width;
                        i6 = h265SpsNalUnit.height;
                        i7 = h265SpsNalUnit.bitDepthLumaMinus8 + 8;
                        i8 = h265SpsNalUnit.bitDepthChromaMinus8 + 8;
                        int i18 = h265SpsNalUnit.colorSpace;
                        int i19 = h265SpsNalUnit.colorRange;
                        int i20 = h265SpsNalUnit.colorTransfer;
                        float f2 = h265SpsNalUnit.pixelWidthHeightRatio;
                        int i21 = h265SpsNalUnit.maxNumReorderPics;
                        i5 = i17;
                        strBuildHevcCodecString = CodecSpecificDataUtil.buildHevcCodecString(h265SpsNalUnit.generalProfileSpace, h265SpsNalUnit.generalTierFlag, h265SpsNalUnit.generalProfileIdc, h265SpsNalUnit.generalProfileCompatibilityFlags, h265SpsNalUnit.constraintBytes, h265SpsNalUnit.generalLevelIdc);
                        i10 = i19;
                        i9 = i18;
                        i12 = i21;
                        f = f2;
                        i11 = i20;
                    }
                    i14 = length + unsignedShort4;
                    parsableByteArray.skipBytes(unsignedShort4);
                    i15++;
                    unsignedByte2 = i16;
                    unsignedByte3 = unsignedByte3;
                    unsignedShort3 = unsignedShort3;
                    i = 0;
                }
                i13++;
                i = 0;
            }
            return new HevcConfig(i2 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), unsignedByte + 1, i5, i6, i7, i8, i9, i10, i11, f, i12, strBuildHevcCodecString);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e);
        }
    }

    private HevcConfig(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.bitdepthLuma = i4;
        this.bitdepthChroma = i5;
        this.colorSpace = i6;
        this.colorRange = i7;
        this.colorTransfer = i8;
        this.pixelWidthHeightRatio = f;
        this.maxNumReorderPics = i9;
        this.codecs = str;
    }
}
