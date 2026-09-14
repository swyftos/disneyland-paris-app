package org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.cms.SignerInfo;

/* JADX INFO: loaded from: classes6.dex */
public class CMSSignedDataGenerator extends CMSSignedGenerator {
    private List signerInfs = new ArrayList();

    public CMSSignedData generate(CMSTypedData cMSTypedData) throws CMSException {
        return generate(cMSTypedData, false);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x008a  */
    public CMSSignedData generate(CMSTypedData cMSTypedData, boolean z) throws CMSException {
        BEROctetString bEROctetString;
        if (!this.signerInfs.isEmpty()) {
            throw new IllegalStateException("this method can only be used with SignerInfoGenerator");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        this.digests.clear();
        for (SignerInformation signerInformation : this._signers) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
            aSN1EncodableVector2.add(signerInformation.toASN1Structure());
        }
        ASN1ObjectIdentifier contentType = cMSTypedData.getContentType();
        if (cMSTypedData.getContent() == null) {
            bEROctetString = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = z ? new ByteArrayOutputStream() : null;
            OutputStream safeOutputStream = CMSUtils.getSafeOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, byteArrayOutputStream));
            try {
                cMSTypedData.write(safeOutputStream);
                safeOutputStream.close();
                if (z) {
                    bEROctetString = new BEROctetString(byteArrayOutputStream.toByteArray());
                } else {
                    bEROctetString = null;
                }
            } catch (IOException e) {
                throw new CMSException("data processing exception: " + e.getMessage(), e);
            }
        }
        for (SignerInfoGenerator signerInfoGenerator : this.signerGens) {
            SignerInfo signerInfoGenerate = signerInfoGenerator.generate(contentType);
            aSN1EncodableVector.add(signerInfoGenerate.getDigestAlgorithm());
            aSN1EncodableVector2.add(signerInfoGenerate);
            byte[] calculatedDigest = signerInfoGenerator.getCalculatedDigest();
            if (calculatedDigest != null) {
                this.digests.put(signerInfoGenerate.getDigestAlgorithm().getAlgorithm().getId(), calculatedDigest);
            }
        }
        return new CMSSignedData(cMSTypedData, new ContentInfo(CMSObjectIdentifiers.signedData, new SignedData(new DERSet(aSN1EncodableVector), new ContentInfo(contentType, bEROctetString), this.certs.size() != 0 ? CMSUtils.createBerSetFromList(this.certs) : null, this.crls.size() != 0 ? CMSUtils.createBerSetFromList(this.crls) : null, new DERSet(aSN1EncodableVector2))));
    }

    public SignerInformationStore generateCounterSigners(SignerInformation signerInformation) throws CMSException {
        return generate(new CMSProcessableByteArray(null, signerInformation.getSignature()), false).getSignerInfos();
    }
}
