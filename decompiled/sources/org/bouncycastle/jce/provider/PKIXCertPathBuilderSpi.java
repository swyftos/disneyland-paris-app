package org.bouncycastle.jce.provider;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import org.bouncycastle.jcajce.PKIXCertStore;
import org.bouncycastle.jcajce.PKIXExtendedBuilderParameters;
import org.bouncycastle.jcajce.PKIXExtendedParameters;
import org.bouncycastle.x509.ExtendedPKIXBuilderParameters;
import org.bouncycastle.x509.ExtendedPKIXParameters;

/* loaded from: classes6.dex */
public class PKIXCertPathBuilderSpi extends CertPathBuilderSpi {
    private Exception certPathException;
    private final boolean isForCRLCheck;

    public PKIXCertPathBuilderSpi() {
        this(false);
    }

    PKIXCertPathBuilderSpi(boolean z) {
        this.isForCRLCheck = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.security.cert.CertPathBuilderResult build(java.security.cert.X509Certificate r6, org.bouncycastle.jcajce.PKIXExtendedBuilderParameters r7, java.util.List r8) throws org.bouncycastle.jce.provider.AnnotatedException {
        /*
            r5 = this;
            boolean r0 = r8.contains(r6)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.Set r0 = r7.getExcludedCerts()
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L13
            return r1
        L13:
            int r0 = r7.getMaxPathLength()
            r2 = -1
            if (r0 == r2) goto L27
            int r0 = r8.size()
            int r0 = r0 + (-1)
            int r2 = r7.getMaxPathLength()
            if (r0 <= r2) goto L27
            return r1
        L27:
            r8.add(r6)
            org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory r0 = new org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory     // Catch: java.lang.Exception -> Lf9
            r0.<init>()     // Catch: java.lang.Exception -> Lf9
            org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi r2 = new org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi     // Catch: java.lang.Exception -> Lf9
            boolean r3 = r5.isForCRLCheck     // Catch: java.lang.Exception -> Lf9
            r2.<init>(r3)     // Catch: java.lang.Exception -> Lf9
            org.bouncycastle.jcajce.PKIXExtendedParameters r3 = r7.getBaseParameters()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.util.Set r3 = r3.getTrustAnchors()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            org.bouncycastle.jcajce.PKIXExtendedParameters r4 = r7.getBaseParameters()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.lang.String r4 = r4.getSigProvider()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            boolean r3 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.isIssuerTrustAnchor(r6, r3, r4)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            if (r3 == 0) goto L7d
            java.security.cert.CertPath r0 = r0.engineGenerateCertPath(r8)     // Catch: java.lang.Exception -> L74
            java.security.cert.CertPathValidatorResult r7 = r2.engineValidate(r0, r7)     // Catch: java.lang.Exception -> L6b
            java.security.cert.PKIXCertPathValidatorResult r7 = (java.security.cert.PKIXCertPathValidatorResult) r7     // Catch: java.lang.Exception -> L6b
            java.security.cert.PKIXCertPathBuilderResult r2 = new java.security.cert.PKIXCertPathBuilderResult     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.security.cert.TrustAnchor r3 = r7.getTrustAnchor()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.security.cert.PolicyNode r4 = r7.getPolicyTree()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.security.PublicKey r7 = r7.getPublicKey()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            r2.<init>(r0, r3, r4, r7)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            return r2
        L68:
            r7 = move-exception
            goto Lf1
        L6b:
            r7 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.lang.String r2 = "Certification path could not be validated."
            r0.<init>(r2, r7)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            throw r0     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
        L74:
            r7 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.lang.String r2 = "Certification path could not be constructed from certificate list."
            r0.<init>(r2, r7)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            throw r0     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
        L7d:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            r0.<init>()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            org.bouncycastle.jcajce.PKIXExtendedParameters r2 = r7.getBaseParameters()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.util.List r2 = r2.getCertificateStores()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            r0.addAll(r2)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.x509.Extension.issuerAlternativeName     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68 java.security.cert.CertificateParsingException -> Le8
            java.lang.String r2 = r2.getId()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68 java.security.cert.CertificateParsingException -> Le8
            byte[] r2 = r6.getExtensionValue(r2)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68 java.security.cert.CertificateParsingException -> Le8
            org.bouncycastle.jcajce.PKIXExtendedParameters r3 = r7.getBaseParameters()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68 java.security.cert.CertificateParsingException -> Le8
            java.util.Map r3 = r3.getNamedCertificateStoreMap()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68 java.security.cert.CertificateParsingException -> Le8
            java.util.List r2 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.getAdditionalStoresFromAltNames(r2, r3)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68 java.security.cert.CertificateParsingException -> Le8
            r0.addAll(r2)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68 java.security.cert.CertificateParsingException -> Le8
            java.util.HashSet r2 = new java.util.HashSet     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            r2.<init>()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            org.bouncycastle.jcajce.PKIXExtendedParameters r3 = r7.getBaseParameters()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> Ldf
            java.util.List r3 = r3.getCertStores()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> Ldf
            java.util.Collection r0 = org.bouncycastle.jce.provider.CertPathValidatorUtilities.findIssuerCerts(r6, r3, r0)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> Ldf
            r2.addAll(r0)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> Ldf
            boolean r0 = r2.isEmpty()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            if (r0 != 0) goto Ld7
            java.util.Iterator r0 = r2.iterator()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
        Lc4:
            boolean r2 = r0.hasNext()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            if (r2 == 0) goto Lf3
            if (r1 != 0) goto Lf3
            java.lang.Object r2 = r0.next()     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.security.cert.CertPathBuilderResult r1 = r5.build(r2, r7, r8)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            goto Lc4
        Ld7:
            org.bouncycastle.jce.provider.AnnotatedException r7 = new org.bouncycastle.jce.provider.AnnotatedException     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.lang.String r0 = "No issuer certificate for certificate in certification path found."
            r7.<init>(r0)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            throw r7     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
        Ldf:
            r7 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.lang.String r2 = "Cannot find issuer certificate for certificate in certification path."
            r0.<init>(r2, r7)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            throw r0     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
        Le8:
            r7 = move-exception
            org.bouncycastle.jce.provider.AnnotatedException r0 = new org.bouncycastle.jce.provider.AnnotatedException     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            java.lang.String r2 = "No additional X.509 stores can be added from certificate locations."
            r0.<init>(r2, r7)     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
            throw r0     // Catch: org.bouncycastle.jce.provider.AnnotatedException -> L68
        Lf1:
            r5.certPathException = r7
        Lf3:
            if (r1 != 0) goto Lf8
            r8.remove(r6)
        Lf8:
            return r1
        Lf9:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r6 = "Exception creating support classes."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi.build(java.security.cert.X509Certificate, org.bouncycastle.jcajce.PKIXExtendedBuilderParameters, java.util.List):java.security.cert.CertPathBuilderResult");
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, AnnotatedException, InvalidAlgorithmParameterException {
        PKIXExtendedBuilderParameters pKIXExtendedBuilderParametersBuild;
        Exception exc;
        PKIXExtendedBuilderParameters.Builder builder;
        if (certPathParameters instanceof PKIXBuilderParameters) {
            PKIXBuilderParameters pKIXBuilderParameters = (PKIXBuilderParameters) certPathParameters;
            PKIXExtendedParameters.Builder builder2 = new PKIXExtendedParameters.Builder(pKIXBuilderParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                Iterator it = extendedPKIXBuilderParameters.getAdditionalStores().iterator();
                while (it.hasNext()) {
                    builder2.addCertificateStore((PKIXCertStore) it.next());
                }
                builder = new PKIXExtendedBuilderParameters.Builder(builder2.build());
                builder.addExcludedCerts(extendedPKIXBuilderParameters.getExcludedCerts());
                builder.setMaxPathLength(extendedPKIXBuilderParameters.getMaxPathLength());
            } else {
                builder = new PKIXExtendedBuilderParameters.Builder(pKIXBuilderParameters);
            }
            pKIXExtendedBuilderParametersBuild = builder.build();
        } else {
            if (!(certPathParameters instanceof PKIXExtendedBuilderParameters)) {
                throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + PKIXExtendedBuilderParameters.class.getName() + InstructionFileId.DOT);
            }
            pKIXExtendedBuilderParametersBuild = (PKIXExtendedBuilderParameters) certPathParameters;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = CertPathValidatorUtilities.findTargets(pKIXExtendedBuilderParametersBuild).iterator();
        CertPathBuilderResult certPathBuilderResultBuild = null;
        while (it2.hasNext() && certPathBuilderResultBuild == null) {
            certPathBuilderResultBuild = build((X509Certificate) it2.next(), pKIXExtendedBuilderParametersBuild, arrayList);
        }
        if (certPathBuilderResultBuild == null && (exc = this.certPathException) != null) {
            if (exc instanceof AnnotatedException) {
                throw new CertPathBuilderException(this.certPathException.getMessage(), this.certPathException.getCause());
            }
            throw new CertPathBuilderException("Possible certificate chain could not be validated.", this.certPathException);
        }
        if (certPathBuilderResultBuild == null && this.certPathException == null) {
            throw new CertPathBuilderException("Unable to find certificate chain.");
        }
        return certPathBuilderResultBuild;
    }
}
