package org.bouncycastle.asn1.cmc;

import androidx.exifinterface.media.ExifInterface;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

/* loaded from: classes6.dex */
public interface CMCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_cct;
    public static final ASN1ObjectIdentifier id_cct_PKIData;
    public static final ASN1ObjectIdentifier id_cct_PKIResponse;
    public static final ASN1ObjectIdentifier id_cmc;
    public static final ASN1ObjectIdentifier id_cmc_addExtensions;
    public static final ASN1ObjectIdentifier id_cmc_authData;
    public static final ASN1ObjectIdentifier id_cmc_batchRequests;
    public static final ASN1ObjectIdentifier id_cmc_batchResponses;
    public static final ASN1ObjectIdentifier id_cmc_confirmCertAcceptance;
    public static final ASN1ObjectIdentifier id_cmc_controlProcessed;
    public static final ASN1ObjectIdentifier id_cmc_dataReturn;
    public static final ASN1ObjectIdentifier id_cmc_decryptedPOP;
    public static final ASN1ObjectIdentifier id_cmc_encryptedPOP;
    public static final ASN1ObjectIdentifier id_cmc_getCRL;
    public static final ASN1ObjectIdentifier id_cmc_getCert;
    public static final ASN1ObjectIdentifier id_cmc_identification;
    public static final ASN1ObjectIdentifier id_cmc_identityProof;
    public static final ASN1ObjectIdentifier id_cmc_identityProofV2;
    public static final ASN1ObjectIdentifier id_cmc_lraPOPWitness;
    public static final ASN1ObjectIdentifier id_cmc_modCertTemplate;
    public static final ASN1ObjectIdentifier id_cmc_popLinkRandom;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitness;
    public static final ASN1ObjectIdentifier id_cmc_popLinkWitnessV2;
    public static final ASN1ObjectIdentifier id_cmc_publishCert;
    public static final ASN1ObjectIdentifier id_cmc_queryPending;
    public static final ASN1ObjectIdentifier id_cmc_recipientNonce;
    public static final ASN1ObjectIdentifier id_cmc_regInfo;
    public static final ASN1ObjectIdentifier id_cmc_responseInfo;
    public static final ASN1ObjectIdentifier id_cmc_revokeRequest;
    public static final ASN1ObjectIdentifier id_cmc_senderNonce;
    public static final ASN1ObjectIdentifier id_cmc_statusInfo;
    public static final ASN1ObjectIdentifier id_cmc_statusInfoV2;
    public static final ASN1ObjectIdentifier id_cmc_transactionId;
    public static final ASN1ObjectIdentifier id_cmc_trustedAnchors;
    public static final ASN1ObjectIdentifier id_pkix;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch = aSN1ObjectIdentifier.branch("7");
        id_cmc = aSN1ObjectIdentifierBranch;
        ASN1ObjectIdentifier aSN1ObjectIdentifierBranch2 = aSN1ObjectIdentifier.branch("12");
        id_cct = aSN1ObjectIdentifierBranch2;
        id_cmc_identityProof = aSN1ObjectIdentifierBranch.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_cmc_dataReturn = aSN1ObjectIdentifierBranch.branch("4");
        id_cmc_regInfo = aSN1ObjectIdentifierBranch.branch("18");
        id_cmc_responseInfo = aSN1ObjectIdentifierBranch.branch("19");
        id_cmc_queryPending = aSN1ObjectIdentifierBranch.branch("21");
        id_cmc_popLinkRandom = aSN1ObjectIdentifierBranch.branch("22");
        id_cmc_popLinkWitness = aSN1ObjectIdentifierBranch.branch("23");
        id_cmc_identification = aSN1ObjectIdentifierBranch.branch(ExifInterface.GPS_MEASUREMENT_2D);
        id_cmc_transactionId = aSN1ObjectIdentifierBranch.branch("5");
        id_cmc_senderNonce = aSN1ObjectIdentifierBranch.branch("6");
        id_cmc_recipientNonce = aSN1ObjectIdentifierBranch.branch("7");
        id_cct_PKIData = aSN1ObjectIdentifierBranch2.branch(ExifInterface.GPS_MEASUREMENT_2D);
        id_cct_PKIResponse = aSN1ObjectIdentifierBranch2.branch(ExifInterface.GPS_MEASUREMENT_3D);
        id_cmc_statusInfo = aSN1ObjectIdentifierBranch.branch("1");
        id_cmc_addExtensions = aSN1ObjectIdentifierBranch.branch("8");
        id_cmc_encryptedPOP = aSN1ObjectIdentifierBranch.branch("9");
        id_cmc_decryptedPOP = aSN1ObjectIdentifierBranch.branch("10");
        id_cmc_lraPOPWitness = aSN1ObjectIdentifierBranch.branch("11");
        id_cmc_getCert = aSN1ObjectIdentifierBranch.branch("15");
        id_cmc_getCRL = aSN1ObjectIdentifierBranch.branch("16");
        id_cmc_revokeRequest = aSN1ObjectIdentifierBranch.branch("17");
        id_cmc_confirmCertAcceptance = aSN1ObjectIdentifierBranch.branch("24");
        id_cmc_statusInfoV2 = aSN1ObjectIdentifierBranch.branch("25");
        id_cmc_trustedAnchors = aSN1ObjectIdentifierBranch.branch("26");
        id_cmc_authData = aSN1ObjectIdentifierBranch.branch("27");
        id_cmc_batchRequests = aSN1ObjectIdentifierBranch.branch("28");
        id_cmc_batchResponses = aSN1ObjectIdentifierBranch.branch("29");
        id_cmc_publishCert = aSN1ObjectIdentifierBranch.branch("30");
        id_cmc_modCertTemplate = aSN1ObjectIdentifierBranch.branch("31");
        id_cmc_controlProcessed = aSN1ObjectIdentifierBranch.branch("32");
        id_cmc_identityProofV2 = aSN1ObjectIdentifierBranch.branch("34");
        id_cmc_popLinkWitnessV2 = aSN1ObjectIdentifierBranch.branch("33");
    }
}
