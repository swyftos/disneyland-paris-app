package org.bouncycastle.openpgp;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.bcpg.UserAttributeSubpacket;
import org.bouncycastle.bcpg.attr.ImageAttribute;

/* loaded from: classes6.dex */
public class PGPUserAttributeSubpacketVectorGenerator {
    private List list = new ArrayList();

    public PGPUserAttributeSubpacketVector generate() {
        List list = this.list;
        return new PGPUserAttributeSubpacketVector((UserAttributeSubpacket[]) list.toArray(new UserAttributeSubpacket[list.size()]));
    }

    public void setImageAttribute(int i, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("attempt to set null image");
        }
        this.list.add(new ImageAttribute(i, bArr));
    }
}
