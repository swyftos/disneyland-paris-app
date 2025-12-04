package javax.xml.bind.annotation.adapters;

import javax.xml.bind.DatatypeConverter;

/* loaded from: classes5.dex */
public final class HexBinaryAdapter extends XmlAdapter<String, byte[]> {
    @Override // javax.xml.bind.annotation.adapters.XmlAdapter
    public byte[] unmarshal(String str) {
        if (str == null) {
            return null;
        }
        return DatatypeConverter.parseHexBinary(str);
    }

    @Override // javax.xml.bind.annotation.adapters.XmlAdapter
    public String marshal(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return DatatypeConverter.printHexBinary(bArr);
    }
}
