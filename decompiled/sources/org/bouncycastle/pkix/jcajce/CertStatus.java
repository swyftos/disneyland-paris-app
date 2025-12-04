package org.bouncycastle.pkix.jcajce;

import java.util.Date;

/* loaded from: classes6.dex */
class CertStatus {
    int certStatus = 11;
    Date revocationDate = null;

    CertStatus() {
    }

    public int getCertStatus() {
        return this.certStatus;
    }

    public Date getRevocationDate() {
        return this.revocationDate;
    }

    public void setCertStatus(int i) {
        this.certStatus = i;
    }

    public void setRevocationDate(Date date) {
        this.revocationDate = date;
    }
}
