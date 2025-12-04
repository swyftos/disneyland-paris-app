package javax.xml.bind;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

/* loaded from: classes5.dex */
public final class DatatypeConverter {
    private static final JAXBPermission SET_DATATYPE_CONVERTER_PERMISSION = new JAXBPermission("setDatatypeConverter");
    private static volatile DatatypeConverterInterface theConverter;

    public static void setDatatypeConverter(DatatypeConverterInterface datatypeConverterInterface) {
        if (datatypeConverterInterface == null) {
            throw new IllegalArgumentException(Messages.format("DatatypeConverter.ConverterMustNotBeNull"));
        }
        if (theConverter == null) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(SET_DATATYPE_CONVERTER_PERMISSION);
            }
            theConverter = datatypeConverterInterface;
        }
    }

    private static synchronized void initConverter() {
        theConverter = new DatatypeConverterImpl();
    }

    public static String parseString(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseString(str);
    }

    public static BigInteger parseInteger(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseInteger(str);
    }

    public static int parseInt(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseInt(str);
    }

    public static long parseLong(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseLong(str);
    }

    public static short parseShort(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseShort(str);
    }

    public static BigDecimal parseDecimal(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseDecimal(str);
    }

    public static float parseFloat(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseFloat(str);
    }

    public static double parseDouble(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseDouble(str);
    }

    public static boolean parseBoolean(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseBoolean(str);
    }

    public static byte parseByte(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseByte(str);
    }

    public static QName parseQName(String str, NamespaceContext namespaceContext) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseQName(str, namespaceContext);
    }

    public static Calendar parseDateTime(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseDateTime(str);
    }

    public static byte[] parseBase64Binary(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseBase64Binary(str);
    }

    public static byte[] parseHexBinary(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseHexBinary(str);
    }

    public static long parseUnsignedInt(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseUnsignedInt(str);
    }

    public static int parseUnsignedShort(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseUnsignedShort(str);
    }

    public static Calendar parseTime(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseTime(str);
    }

    public static Calendar parseDate(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseDate(str);
    }

    public static String parseAnySimpleType(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.parseAnySimpleType(str);
    }

    public static String printString(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printString(str);
    }

    public static String printInteger(BigInteger bigInteger) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printInteger(bigInteger);
    }

    public static String printInt(int i) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printInt(i);
    }

    public static String printLong(long j) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printLong(j);
    }

    public static String printShort(short s) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printShort(s);
    }

    public static String printDecimal(BigDecimal bigDecimal) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printDecimal(bigDecimal);
    }

    public static String printFloat(float f) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printFloat(f);
    }

    public static String printDouble(double d) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printDouble(d);
    }

    public static String printBoolean(boolean z) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printBoolean(z);
    }

    public static String printByte(byte b) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printByte(b);
    }

    public static String printQName(QName qName, NamespaceContext namespaceContext) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printQName(qName, namespaceContext);
    }

    public static String printDateTime(Calendar calendar) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printDateTime(calendar);
    }

    public static String printBase64Binary(byte[] bArr) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printBase64Binary(bArr);
    }

    public static String printHexBinary(byte[] bArr) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printHexBinary(bArr);
    }

    public static String printUnsignedInt(long j) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printUnsignedInt(j);
    }

    public static String printUnsignedShort(int i) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printUnsignedShort(i);
    }

    public static String printTime(Calendar calendar) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printTime(calendar);
    }

    public static String printDate(Calendar calendar) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printDate(calendar);
    }

    public static String printAnySimpleType(String str) {
        if (theConverter == null) {
            initConverter();
        }
        return theConverter.printAnySimpleType(str);
    }
}
