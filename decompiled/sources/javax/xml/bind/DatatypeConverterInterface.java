package javax.xml.bind;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

/* loaded from: classes5.dex */
public interface DatatypeConverterInterface {
    String parseAnySimpleType(String str);

    byte[] parseBase64Binary(String str);

    boolean parseBoolean(String str);

    byte parseByte(String str);

    Calendar parseDate(String str);

    Calendar parseDateTime(String str);

    BigDecimal parseDecimal(String str);

    double parseDouble(String str);

    float parseFloat(String str);

    byte[] parseHexBinary(String str);

    int parseInt(String str);

    BigInteger parseInteger(String str);

    long parseLong(String str);

    QName parseQName(String str, NamespaceContext namespaceContext);

    short parseShort(String str);

    String parseString(String str);

    Calendar parseTime(String str);

    long parseUnsignedInt(String str);

    int parseUnsignedShort(String str);

    String printAnySimpleType(String str);

    String printBase64Binary(byte[] bArr);

    String printBoolean(boolean z);

    String printByte(byte b);

    String printDate(Calendar calendar);

    String printDateTime(Calendar calendar);

    String printDecimal(BigDecimal bigDecimal);

    String printDouble(double d);

    String printFloat(float f);

    String printHexBinary(byte[] bArr);

    String printInt(int i);

    String printInteger(BigInteger bigInteger);

    String printLong(long j);

    String printQName(QName qName, NamespaceContext namespaceContext);

    String printShort(short s);

    String printString(String str);

    String printTime(Calendar calendar);

    String printUnsignedInt(long j);

    String printUnsignedShort(int i);
}
