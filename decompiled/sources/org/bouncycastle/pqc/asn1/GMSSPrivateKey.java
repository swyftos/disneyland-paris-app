package org.bouncycastle.pqc.asn1;

import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.crypto.gmss.GMSSLeaf;
import org.bouncycastle.pqc.crypto.gmss.GMSSParameters;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootSig;
import org.bouncycastle.pqc.crypto.gmss.Treehash;

/* loaded from: classes6.dex */
public class GMSSPrivateKey extends ASN1Object {
    private ASN1Primitive primitive;

    public GMSSPrivateKey(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][][] bArr5, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, AlgorithmIdentifier algorithmIdentifier) {
        this.primitive = encode(iArr, bArr, bArr2, bArr3, bArr4, bArr5, treehashArr, treehashArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, gMSSLeafArr, gMSSLeafArr2, gMSSLeafArr3, iArr2, bArr6, gMSSRootCalcArr, bArr7, gMSSRootSigArr, gMSSParameters, new AlgorithmIdentifier[]{algorithmIdentifier});
    }

    private ASN1Primitive encode(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, byte[][][] bArr5, Treehash[][] treehashArr, Treehash[][] treehashArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, GMSSLeaf[] gMSSLeafArr, GMSSLeaf[] gMSSLeafArr2, GMSSLeaf[] gMSSLeafArr3, int[] iArr2, byte[][] bArr6, GMSSRootCalc[] gMSSRootCalcArr, byte[][] bArr7, GMSSRootSig[] gMSSRootSigArr, GMSSParameters gMSSParameters, AlgorithmIdentifier[] algorithmIdentifierArr) {
        Treehash[][] treehashArr3 = treehashArr;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (int i : iArr) {
            aSN1EncodableVector2.add(new ASN1Integer(i));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        for (byte[] bArr8 : bArr) {
            aSN1EncodableVector3.add(new DEROctetString(bArr8));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        for (byte[] bArr9 : bArr2) {
            aSN1EncodableVector4.add(new DEROctetString(bArr9));
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
        for (byte[][] bArr10 : bArr3) {
            int i2 = 0;
            while (true) {
                if (i2 < bArr10.length) {
                    aSN1EncodableVector5.add(new DEROctetString(bArr10[i2]));
                    i2++;
                }
            }
            aSN1EncodableVector6.add(new DERSequence(aSN1EncodableVector5));
            aSN1EncodableVector5 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector6));
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
        for (byte[][] bArr11 : bArr4) {
            int i3 = 0;
            while (true) {
                if (i3 < bArr11.length) {
                    aSN1EncodableVector7.add(new DEROctetString(bArr11[i3]));
                    i3++;
                }
            }
            aSN1EncodableVector8.add(new DERSequence(aSN1EncodableVector7));
            aSN1EncodableVector7 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector8));
        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
        int i4 = 0;
        while (i4 < treehashArr3.length) {
            int i5 = 0;
            while (i5 < treehashArr3[i4].length) {
                aSN1EncodableVector11.add(new DERSequence(algorithmIdentifierArr[0]));
                int i6 = treehashArr3[i4][i5].getStatInt()[1];
                aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i4][i5].getStatByte()[0]));
                aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i4][i5].getStatByte()[1]));
                aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i4][i5].getStatByte()[2]));
                for (int i7 = 0; i7 < i6; i7++) {
                    aSN1EncodableVector12.add(new DEROctetString(treehashArr3[i4][i5].getStatByte()[i7 + 3]));
                }
                aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector12));
                aSN1EncodableVector12 = new ASN1EncodableVector();
                aSN1EncodableVector13.add(new ASN1Integer(treehashArr3[i4][i5].getStatInt()[0]));
                aSN1EncodableVector13.add(new ASN1Integer(i6));
                aSN1EncodableVector13.add(new ASN1Integer(treehashArr3[i4][i5].getStatInt()[2]));
                aSN1EncodableVector13.add(new ASN1Integer(treehashArr3[i4][i5].getStatInt()[3]));
                aSN1EncodableVector13.add(new ASN1Integer(treehashArr3[i4][i5].getStatInt()[4]));
                aSN1EncodableVector13.add(new ASN1Integer(treehashArr3[i4][i5].getStatInt()[5]));
                int i8 = 0;
                while (i8 < i6) {
                    aSN1EncodableVector13.add(new ASN1Integer(treehashArr3[i4][i5].getStatInt()[i8 + 6]));
                    i8++;
                    treehashArr3 = treehashArr;
                }
                aSN1EncodableVector11.add(new DERSequence(aSN1EncodableVector13));
                aSN1EncodableVector13 = new ASN1EncodableVector();
                aSN1EncodableVector10.add(new DERSequence(aSN1EncodableVector11));
                aSN1EncodableVector11 = new ASN1EncodableVector();
                i5++;
                treehashArr3 = treehashArr;
            }
            aSN1EncodableVector9.add(new DERSequence(aSN1EncodableVector10));
            aSN1EncodableVector10 = new ASN1EncodableVector();
            i4++;
            treehashArr3 = treehashArr;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector9));
        ASN1EncodableVector aSN1EncodableVector14 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector15 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector16 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector17 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector18 = new ASN1EncodableVector();
        for (int i9 = 0; i9 < treehashArr2.length; i9++) {
            for (int i10 = 0; i10 < treehashArr2[i9].length; i10++) {
                aSN1EncodableVector16.add(new DERSequence(algorithmIdentifierArr[0]));
                int i11 = treehashArr2[i9][i10].getStatInt()[1];
                aSN1EncodableVector17.add(new DEROctetString(treehashArr2[i9][i10].getStatByte()[0]));
                aSN1EncodableVector17.add(new DEROctetString(treehashArr2[i9][i10].getStatByte()[1]));
                aSN1EncodableVector17.add(new DEROctetString(treehashArr2[i9][i10].getStatByte()[2]));
                for (int i12 = 0; i12 < i11; i12++) {
                    aSN1EncodableVector17.add(new DEROctetString(treehashArr2[i9][i10].getStatByte()[i12 + 3]));
                }
                aSN1EncodableVector16.add(new DERSequence(aSN1EncodableVector17));
                aSN1EncodableVector17 = new ASN1EncodableVector();
                aSN1EncodableVector18.add(new ASN1Integer(treehashArr2[i9][i10].getStatInt()[0]));
                aSN1EncodableVector18.add(new ASN1Integer(i11));
                aSN1EncodableVector18.add(new ASN1Integer(treehashArr2[i9][i10].getStatInt()[2]));
                aSN1EncodableVector18.add(new ASN1Integer(treehashArr2[i9][i10].getStatInt()[3]));
                aSN1EncodableVector18.add(new ASN1Integer(treehashArr2[i9][i10].getStatInt()[4]));
                aSN1EncodableVector18.add(new ASN1Integer(treehashArr2[i9][i10].getStatInt()[5]));
                for (int i13 = 0; i13 < i11; i13++) {
                    aSN1EncodableVector18.add(new ASN1Integer(treehashArr2[i9][i10].getStatInt()[i13 + 6]));
                }
                aSN1EncodableVector16.add(new DERSequence(aSN1EncodableVector18));
                aSN1EncodableVector18 = new ASN1EncodableVector();
                aSN1EncodableVector15.add(new DERSequence(aSN1EncodableVector16));
                aSN1EncodableVector16 = new ASN1EncodableVector();
            }
            aSN1EncodableVector14.add(new DERSequence(new DERSequence(aSN1EncodableVector15)));
            aSN1EncodableVector15 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector14));
        ASN1EncodableVector aSN1EncodableVector19 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector20 = new ASN1EncodableVector();
        for (byte[][] bArr12 : bArr5) {
            int i14 = 0;
            while (true) {
                if (i14 < bArr12.length) {
                    aSN1EncodableVector19.add(new DEROctetString(bArr12[i14]));
                    i14++;
                }
            }
            aSN1EncodableVector20.add(new DERSequence(aSN1EncodableVector19));
            aSN1EncodableVector19 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector20));
        ASN1EncodableVector aSN1EncodableVector21 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector22 = new ASN1EncodableVector();
        for (int i15 = 0; i15 < vectorArr.length; i15++) {
            for (int i16 = 0; i16 < vectorArr[i15].size(); i16++) {
                aSN1EncodableVector21.add(new DEROctetString((byte[]) vectorArr[i15].elementAt(i16)));
            }
            aSN1EncodableVector22.add(new DERSequence(aSN1EncodableVector21));
            aSN1EncodableVector21 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector22));
        ASN1EncodableVector aSN1EncodableVector23 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector24 = new ASN1EncodableVector();
        for (int i17 = 0; i17 < vectorArr2.length; i17++) {
            for (int i18 = 0; i18 < vectorArr2[i17].size(); i18++) {
                aSN1EncodableVector23.add(new DEROctetString((byte[]) vectorArr2[i17].elementAt(i18)));
            }
            aSN1EncodableVector24.add(new DERSequence(aSN1EncodableVector23));
            aSN1EncodableVector23 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector24));
        ASN1EncodableVector aSN1EncodableVector25 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector26 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector27 = new ASN1EncodableVector();
        for (int i19 = 0; i19 < vectorArr3.length; i19++) {
            for (int i20 = 0; i20 < vectorArr3[i19].length; i20++) {
                for (int i21 = 0; i21 < vectorArr3[i19][i20].size(); i21++) {
                    aSN1EncodableVector25.add(new DEROctetString((byte[]) vectorArr3[i19][i20].elementAt(i21)));
                }
                aSN1EncodableVector26.add(new DERSequence(aSN1EncodableVector25));
                aSN1EncodableVector25 = new ASN1EncodableVector();
            }
            aSN1EncodableVector27.add(new DERSequence(aSN1EncodableVector26));
            aSN1EncodableVector26 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector27));
        ASN1EncodableVector aSN1EncodableVector28 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector29 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector30 = new ASN1EncodableVector();
        for (int i22 = 0; i22 < vectorArr4.length; i22++) {
            for (int i23 = 0; i23 < vectorArr4[i22].length; i23++) {
                for (int i24 = 0; i24 < vectorArr4[i22][i23].size(); i24++) {
                    aSN1EncodableVector28.add(new DEROctetString((byte[]) vectorArr4[i22][i23].elementAt(i24)));
                }
                aSN1EncodableVector29.add(new DERSequence(aSN1EncodableVector28));
                aSN1EncodableVector28 = new ASN1EncodableVector();
            }
            aSN1EncodableVector30.add(new DERSequence(aSN1EncodableVector29));
            aSN1EncodableVector29 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector30));
        ASN1EncodableVector aSN1EncodableVector31 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector32 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector33 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector34 = new ASN1EncodableVector();
        for (int i25 = 0; i25 < gMSSLeafArr.length; i25++) {
            aSN1EncodableVector32.add(new DERSequence(algorithmIdentifierArr[0]));
            byte[][] statByte = gMSSLeafArr[i25].getStatByte();
            aSN1EncodableVector33.add(new DEROctetString(statByte[0]));
            aSN1EncodableVector33.add(new DEROctetString(statByte[1]));
            aSN1EncodableVector33.add(new DEROctetString(statByte[2]));
            aSN1EncodableVector33.add(new DEROctetString(statByte[3]));
            aSN1EncodableVector32.add(new DERSequence(aSN1EncodableVector33));
            aSN1EncodableVector33 = new ASN1EncodableVector();
            int[] statInt = gMSSLeafArr[i25].getStatInt();
            aSN1EncodableVector34.add(new ASN1Integer(statInt[0]));
            aSN1EncodableVector34.add(new ASN1Integer(statInt[1]));
            aSN1EncodableVector34.add(new ASN1Integer(statInt[2]));
            aSN1EncodableVector34.add(new ASN1Integer(statInt[3]));
            aSN1EncodableVector32.add(new DERSequence(aSN1EncodableVector34));
            aSN1EncodableVector34 = new ASN1EncodableVector();
            aSN1EncodableVector31.add(new DERSequence(aSN1EncodableVector32));
            aSN1EncodableVector32 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector31));
        ASN1EncodableVector aSN1EncodableVector35 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector36 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector37 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector38 = new ASN1EncodableVector();
        for (int i26 = 0; i26 < gMSSLeafArr2.length; i26++) {
            aSN1EncodableVector36.add(new DERSequence(algorithmIdentifierArr[0]));
            byte[][] statByte2 = gMSSLeafArr2[i26].getStatByte();
            aSN1EncodableVector37.add(new DEROctetString(statByte2[0]));
            aSN1EncodableVector37.add(new DEROctetString(statByte2[1]));
            aSN1EncodableVector37.add(new DEROctetString(statByte2[2]));
            aSN1EncodableVector37.add(new DEROctetString(statByte2[3]));
            aSN1EncodableVector36.add(new DERSequence(aSN1EncodableVector37));
            aSN1EncodableVector37 = new ASN1EncodableVector();
            int[] statInt2 = gMSSLeafArr2[i26].getStatInt();
            aSN1EncodableVector38.add(new ASN1Integer(statInt2[0]));
            aSN1EncodableVector38.add(new ASN1Integer(statInt2[1]));
            aSN1EncodableVector38.add(new ASN1Integer(statInt2[2]));
            aSN1EncodableVector38.add(new ASN1Integer(statInt2[3]));
            aSN1EncodableVector36.add(new DERSequence(aSN1EncodableVector38));
            aSN1EncodableVector38 = new ASN1EncodableVector();
            aSN1EncodableVector35.add(new DERSequence(aSN1EncodableVector36));
            aSN1EncodableVector36 = new ASN1EncodableVector();
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector35));
        ASN1EncodableVector aSN1EncodableVector39 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector40 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector41 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector42 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector43 = aSN1EncodableVector;
        for (int i27 = 0; i27 < gMSSLeafArr3.length; i27++) {
            aSN1EncodableVector40.add(new DERSequence(algorithmIdentifierArr[0]));
            byte[][] statByte3 = gMSSLeafArr3[i27].getStatByte();
            aSN1EncodableVector41.add(new DEROctetString(statByte3[0]));
            aSN1EncodableVector41.add(new DEROctetString(statByte3[1]));
            aSN1EncodableVector41.add(new DEROctetString(statByte3[2]));
            aSN1EncodableVector41.add(new DEROctetString(statByte3[3]));
            aSN1EncodableVector40.add(new DERSequence(aSN1EncodableVector41));
            aSN1EncodableVector41 = new ASN1EncodableVector();
            int[] statInt3 = gMSSLeafArr3[i27].getStatInt();
            aSN1EncodableVector42.add(new ASN1Integer(statInt3[0]));
            aSN1EncodableVector42.add(new ASN1Integer(statInt3[1]));
            aSN1EncodableVector42.add(new ASN1Integer(statInt3[2]));
            aSN1EncodableVector42.add(new ASN1Integer(statInt3[3]));
            aSN1EncodableVector40.add(new DERSequence(aSN1EncodableVector42));
            aSN1EncodableVector42 = new ASN1EncodableVector();
            aSN1EncodableVector39.add(new DERSequence(aSN1EncodableVector40));
            aSN1EncodableVector40 = new ASN1EncodableVector();
        }
        aSN1EncodableVector43.add(new DERSequence(aSN1EncodableVector39));
        ASN1EncodableVector aSN1EncodableVector44 = new ASN1EncodableVector();
        for (int i28 : iArr2) {
            aSN1EncodableVector44.add(new ASN1Integer(i28));
        }
        aSN1EncodableVector43.add(new DERSequence(aSN1EncodableVector44));
        ASN1EncodableVector aSN1EncodableVector45 = new ASN1EncodableVector();
        for (byte[] bArr13 : bArr6) {
            aSN1EncodableVector45.add(new DEROctetString(bArr13));
        }
        aSN1EncodableVector43.add(new DERSequence(aSN1EncodableVector45));
        ASN1EncodableVector aSN1EncodableVector46 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector47 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector48 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector49 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector50 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector51 = new ASN1EncodableVector();
        int i29 = 0;
        while (i29 < gMSSRootCalcArr.length) {
            aSN1EncodableVector47.add(new DERSequence(algorithmIdentifierArr[0]));
            new ASN1EncodableVector();
            int i30 = gMSSRootCalcArr[i29].getStatInt()[0];
            int i31 = gMSSRootCalcArr[i29].getStatInt()[7];
            aSN1EncodableVector48.add(new DEROctetString(gMSSRootCalcArr[i29].getStatByte()[0]));
            int i32 = 0;
            while (i32 < i30) {
                i32++;
                aSN1EncodableVector48.add(new DEROctetString(gMSSRootCalcArr[i29].getStatByte()[i32]));
            }
            for (int i33 = 0; i33 < i31; i33++) {
                aSN1EncodableVector48.add(new DEROctetString(gMSSRootCalcArr[i29].getStatByte()[i30 + 1 + i33]));
            }
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector48));
            ASN1EncodableVector aSN1EncodableVector52 = new ASN1EncodableVector();
            aSN1EncodableVector49.add(new ASN1Integer(i30));
            aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[1]));
            aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[2]));
            aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[3]));
            aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[4]));
            aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[5]));
            aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[6]));
            aSN1EncodableVector49.add(new ASN1Integer(i31));
            for (int i34 = 0; i34 < i30; i34++) {
                aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[i34 + 8]));
            }
            for (int i35 = 0; i35 < i31; i35++) {
                aSN1EncodableVector49.add(new ASN1Integer(gMSSRootCalcArr[i29].getStatInt()[i30 + 8 + i35]));
            }
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector49));
            ASN1EncodableVector aSN1EncodableVector53 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector54 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector55 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector56 = new ASN1EncodableVector();
            if (gMSSRootCalcArr[i29].getTreehash() != null) {
                int i36 = 0;
                while (i36 < gMSSRootCalcArr[i29].getTreehash().length) {
                    aSN1EncodableVector54.add(new DERSequence(algorithmIdentifierArr[0]));
                    int i37 = gMSSRootCalcArr[i29].getTreehash()[i36].getStatInt()[1];
                    ASN1EncodableVector aSN1EncodableVector57 = aSN1EncodableVector52;
                    aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr[i29].getTreehash()[i36].getStatByte()[0]));
                    aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr[i29].getTreehash()[i36].getStatByte()[1]));
                    aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr[i29].getTreehash()[i36].getStatByte()[2]));
                    int i38 = 0;
                    while (i38 < i37) {
                        aSN1EncodableVector55.add(new DEROctetString(gMSSRootCalcArr[i29].getTreehash()[i36].getStatByte()[i38 + 3]));
                        i38++;
                        aSN1EncodableVector53 = aSN1EncodableVector53;
                    }
                    ASN1EncodableVector aSN1EncodableVector58 = aSN1EncodableVector53;
                    aSN1EncodableVector54.add(new DERSequence(aSN1EncodableVector55));
                    aSN1EncodableVector55 = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector59 = aSN1EncodableVector43;
                    aSN1EncodableVector56.add(new ASN1Integer(gMSSRootCalcArr[i29].getTreehash()[i36].getStatInt()[0]));
                    aSN1EncodableVector56.add(new ASN1Integer(i37));
                    aSN1EncodableVector56.add(new ASN1Integer(gMSSRootCalcArr[i29].getTreehash()[i36].getStatInt()[2]));
                    aSN1EncodableVector56.add(new ASN1Integer(gMSSRootCalcArr[i29].getTreehash()[i36].getStatInt()[3]));
                    aSN1EncodableVector56.add(new ASN1Integer(gMSSRootCalcArr[i29].getTreehash()[i36].getStatInt()[4]));
                    aSN1EncodableVector56.add(new ASN1Integer(gMSSRootCalcArr[i29].getTreehash()[i36].getStatInt()[5]));
                    int i39 = 0;
                    while (i39 < i37) {
                        aSN1EncodableVector56.add(new ASN1Integer(gMSSRootCalcArr[i29].getTreehash()[i36].getStatInt()[i39 + 6]));
                        i39++;
                        i37 = i37;
                        aSN1EncodableVector59 = aSN1EncodableVector59;
                    }
                    aSN1EncodableVector54.add(new DERSequence(aSN1EncodableVector56));
                    aSN1EncodableVector56 = new ASN1EncodableVector();
                    aSN1EncodableVector50.add(new DERSequence(aSN1EncodableVector54));
                    aSN1EncodableVector54 = new ASN1EncodableVector();
                    i36++;
                    aSN1EncodableVector52 = aSN1EncodableVector57;
                    aSN1EncodableVector53 = aSN1EncodableVector58;
                    aSN1EncodableVector43 = aSN1EncodableVector59;
                }
            }
            ASN1EncodableVector aSN1EncodableVector60 = aSN1EncodableVector52;
            ASN1EncodableVector aSN1EncodableVector61 = aSN1EncodableVector53;
            ASN1EncodableVector aSN1EncodableVector62 = aSN1EncodableVector43;
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector50));
            aSN1EncodableVector50 = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector63 = new ASN1EncodableVector();
            if (gMSSRootCalcArr[i29].getRetain() != null) {
                for (int i40 = 0; i40 < gMSSRootCalcArr[i29].getRetain().length; i40++) {
                    for (int i41 = 0; i41 < gMSSRootCalcArr[i29].getRetain()[i40].size(); i41++) {
                        aSN1EncodableVector63.add(new DEROctetString((byte[]) gMSSRootCalcArr[i29].getRetain()[i40].elementAt(i41)));
                    }
                    aSN1EncodableVector51.add(new DERSequence(aSN1EncodableVector63));
                    aSN1EncodableVector63 = new ASN1EncodableVector();
                }
            }
            aSN1EncodableVector47.add(new DERSequence(aSN1EncodableVector51));
            aSN1EncodableVector51 = new ASN1EncodableVector();
            aSN1EncodableVector46.add(new DERSequence(aSN1EncodableVector47));
            aSN1EncodableVector47 = new ASN1EncodableVector();
            i29++;
            aSN1EncodableVector48 = aSN1EncodableVector60;
            aSN1EncodableVector49 = aSN1EncodableVector61;
            aSN1EncodableVector43 = aSN1EncodableVector62;
        }
        ASN1EncodableVector aSN1EncodableVector64 = aSN1EncodableVector43;
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector46));
        ASN1EncodableVector aSN1EncodableVector65 = new ASN1EncodableVector();
        for (byte[] bArr14 : bArr7) {
            aSN1EncodableVector65.add(new DEROctetString(bArr14));
        }
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector65));
        ASN1EncodableVector aSN1EncodableVector66 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector67 = new ASN1EncodableVector();
        new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector68 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector69 = new ASN1EncodableVector();
        for (int i42 = 0; i42 < gMSSRootSigArr.length; i42++) {
            aSN1EncodableVector67.add(new DERSequence(algorithmIdentifierArr[0]));
            new ASN1EncodableVector();
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr[i42].getStatByte()[0]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr[i42].getStatByte()[1]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr[i42].getStatByte()[2]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr[i42].getStatByte()[3]));
            aSN1EncodableVector68.add(new DEROctetString(gMSSRootSigArr[i42].getStatByte()[4]));
            aSN1EncodableVector67.add(new DERSequence(aSN1EncodableVector68));
            aSN1EncodableVector68 = new ASN1EncodableVector();
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[0]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[1]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[2]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[3]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[4]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[5]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[6]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[7]));
            aSN1EncodableVector69.add(new ASN1Integer(gMSSRootSigArr[i42].getStatInt()[8]));
            aSN1EncodableVector67.add(new DERSequence(aSN1EncodableVector69));
            aSN1EncodableVector69 = new ASN1EncodableVector();
            aSN1EncodableVector66.add(new DERSequence(aSN1EncodableVector67));
            aSN1EncodableVector67 = new ASN1EncodableVector();
        }
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector66));
        ASN1EncodableVector aSN1EncodableVector70 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector71 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector72 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector73 = new ASN1EncodableVector();
        for (int i43 = 0; i43 < gMSSParameters.getHeightOfTrees().length; i43++) {
            aSN1EncodableVector71.add(new ASN1Integer(gMSSParameters.getHeightOfTrees()[i43]));
            aSN1EncodableVector72.add(new ASN1Integer(gMSSParameters.getWinternitzParameter()[i43]));
            aSN1EncodableVector73.add(new ASN1Integer(gMSSParameters.getK()[i43]));
        }
        aSN1EncodableVector70.add(new ASN1Integer(gMSSParameters.getNumOfLayers()));
        aSN1EncodableVector70.add(new DERSequence(aSN1EncodableVector71));
        aSN1EncodableVector70.add(new DERSequence(aSN1EncodableVector72));
        aSN1EncodableVector70.add(new DERSequence(aSN1EncodableVector73));
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector70));
        ASN1EncodableVector aSN1EncodableVector74 = new ASN1EncodableVector();
        for (AlgorithmIdentifier algorithmIdentifier : algorithmIdentifierArr) {
            aSN1EncodableVector74.add(algorithmIdentifier);
        }
        aSN1EncodableVector64.add(new DERSequence(aSN1EncodableVector74));
        return new DERSequence(aSN1EncodableVector64);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.primitive;
    }
}
