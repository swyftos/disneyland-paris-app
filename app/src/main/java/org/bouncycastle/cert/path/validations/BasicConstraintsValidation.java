package org.bouncycastle.cert.path.validations;

import java.math.BigInteger;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidation;
import org.bouncycastle.cert.path.CertPathValidationContext;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes6.dex */
public class BasicConstraintsValidation implements CertPathValidation {

    /* JADX INFO: renamed from: bc */
    private BasicConstraints f4119bc;
    private boolean isMandatory;
    private BigInteger maxPathLength;
    private int pathLengthRemaining;

    public BasicConstraintsValidation() {
        this(true);
    }

    public BasicConstraintsValidation(boolean z) {
        this.isMandatory = z;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        BasicConstraintsValidation basicConstraintsValidation = new BasicConstraintsValidation(this.isMandatory);
        basicConstraintsValidation.f4119bc = this.f4119bc;
        basicConstraintsValidation.pathLengthRemaining = this.pathLengthRemaining;
        return basicConstraintsValidation;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        BasicConstraintsValidation basicConstraintsValidation = (BasicConstraintsValidation) memoable;
        this.isMandatory = basicConstraintsValidation.isMandatory;
        this.f4119bc = basicConstraintsValidation.f4119bc;
        this.pathLengthRemaining = basicConstraintsValidation.pathLengthRemaining;
    }

    @Override // org.bouncycastle.cert.path.CertPathValidation
    public void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        int iIntValue;
        BigInteger pathLenConstraint;
        int iIntValue2;
        if (this.maxPathLength != null && this.pathLengthRemaining < 0) {
            throw new CertPathValidationException("BasicConstraints path length exceeded");
        }
        certPathValidationContext.addHandledExtension(Extension.basicConstraints);
        BasicConstraints basicConstraintsFromExtensions = BasicConstraints.fromExtensions(x509CertificateHolder.getExtensions());
        if (basicConstraintsFromExtensions != null) {
            if (this.f4119bc == null) {
                this.f4119bc = basicConstraintsFromExtensions;
                if (basicConstraintsFromExtensions.isCA()) {
                    BigInteger pathLenConstraint2 = basicConstraintsFromExtensions.getPathLenConstraint();
                    this.maxPathLength = pathLenConstraint2;
                    if (pathLenConstraint2 != null) {
                        iIntValue = pathLenConstraint2.intValue();
                        this.pathLengthRemaining = iIntValue;
                    }
                }
            } else if (basicConstraintsFromExtensions.isCA() && (pathLenConstraint = basicConstraintsFromExtensions.getPathLenConstraint()) != null && (iIntValue2 = pathLenConstraint.intValue()) < this.pathLengthRemaining) {
                this.pathLengthRemaining = iIntValue2;
                this.f4119bc = basicConstraintsFromExtensions;
            }
        } else if (this.f4119bc != null) {
            iIntValue = this.pathLengthRemaining - 1;
            this.pathLengthRemaining = iIntValue;
        }
        if (this.isMandatory && this.f4119bc == null) {
            throw new CertPathValidationException("BasicConstraints not present in path");
        }
    }
}
