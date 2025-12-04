package org.picocontainer.paranamer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.microsoft.appcenter.ingestion.models.properties.DoubleTypedProperty;
import com.microsoft.appcenter.ingestion.models.properties.LongTypedProperty;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okio.Utf8;
import org.bouncycastle.asn1.eac.EACTags;

/* loaded from: classes6.dex */
public class BytecodeReadingParanamer implements Paranamer {
    public static final String __PARANAMER_DATA = "lookupParameterNames java.lang.reflect.AccessibleObject methodOrConstructor \nlookupParameterNames java.lang.reflect.AccessibleObject,boolean methodOrCtor,throwExceptionIfMissing \n";
    private static final Map primitives = new HashMap() { // from class: org.picocontainer.paranamer.BytecodeReadingParanamer.1
        {
            put("int", "I");
            put("boolean", "Z");
            put("char", "C");
            put("short", ExifInterface.LATITUDE_SOUTH);
            put(TypedValues.Custom.S_FLOAT, "F");
            put(LongTypedProperty.TYPE, "J");
            put(DoubleTypedProperty.TYPE, "D");
        }
    };

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject) {
        return lookupParameterNames(accessibleObject, true);
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject, boolean z) throws IOException {
        Class<?>[] parameterTypes;
        Class<?> declaringClass;
        String name;
        if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            parameterTypes = method.getParameterTypes();
            name = method.getName();
            declaringClass = method.getDeclaringClass();
        } else {
            Constructor constructor = (Constructor) accessibleObject;
            parameterTypes = constructor.getParameterTypes();
            declaringClass = constructor.getDeclaringClass();
            name = "<init>";
        }
        if (parameterTypes.length == 0) {
            return Paranamer.EMPTY_NAMES;
        }
        InputStream classAsStream = getClassAsStream(declaringClass);
        if (classAsStream == null) {
            if (z) {
                throw new ParameterNamesNotFoundException("Unable to get class bytes");
            }
            return Paranamer.EMPTY_NAMES;
        }
        try {
            ClassReader classReader = new ClassReader(classAsStream);
            TypeCollector typeCollector = new TypeCollector(name, parameterTypes, z);
            classReader.accept(typeCollector);
            String[] parameterNamesForMethod = typeCollector.getParameterNamesForMethod();
            try {
                classAsStream.close();
            } catch (IOException unused) {
            }
            return parameterNamesForMethod;
        } catch (IOException e) {
            if (z) {
                throw new ParameterNamesNotFoundException("IoException while reading class bytes", e);
            }
            return Paranamer.EMPTY_NAMES;
        }
    }

    private InputStream getClassAsStream(Class cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return getClassAsStream(classLoader, cls.getName());
    }

    private InputStream getClassAsStream(ClassLoader classLoader, String str) {
        String str2 = str.replace('.', '/') + ".class";
        InputStream resourceAsStream = classLoader.getResourceAsStream(str2);
        return resourceAsStream == null ? BytecodeReadingParanamer.class.getResourceAsStream(str2) : resourceAsStream;
    }

    private static class TypeCollector {
        private MethodCollector collector;
        private final String methodName;
        private final Class[] parameterTypes;
        private final boolean throwExceptionIfMissing;

        private TypeCollector(String str, Class[] clsArr, boolean z) {
            this.methodName = str;
            this.parameterTypes = clsArr;
            this.throwExceptionIfMissing = z;
            this.collector = null;
        }

        public MethodCollector visitMethod(int i, String str, String str2) {
            if (this.collector != null || !str.equals(this.methodName)) {
                return null;
            }
            Type[] argumentTypes = Type.getArgumentTypes(str2);
            int i2 = 0;
            for (Type type : argumentTypes) {
                if (type.getClassName().equals(LongTypedProperty.TYPE) || type.getClassName().equals(DoubleTypedProperty.TYPE)) {
                    i2++;
                }
            }
            if (argumentTypes.length != this.parameterTypes.length) {
                return null;
            }
            for (int i3 = 0; i3 < argumentTypes.length; i3++) {
                if (!correctTypeName(argumentTypes, i3).equals(this.parameterTypes[i3].getName())) {
                    return null;
                }
            }
            MethodCollector methodCollector = new MethodCollector(!Modifier.isStatic(i) ? 1 : 0, argumentTypes.length + i2);
            this.collector = methodCollector;
            return methodCollector;
        }

        private String correctTypeName(Type[] typeArr, int i) {
            String className = typeArr[i].getClassName();
            String str = "";
            while (className.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                str = str + "[";
                className = className.substring(0, className.length() - 2);
            }
            if (str.equals("")) {
                return className;
            }
            if (BytecodeReadingParanamer.primitives.containsKey(className)) {
                return str + ((String) BytecodeReadingParanamer.primitives.get(className));
            }
            return str + "L" + className + ";";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String[] getParameterNamesForMethod() {
            MethodCollector methodCollector = this.collector;
            if (methodCollector == null) {
                return Paranamer.EMPTY_NAMES;
            }
            if (!methodCollector.isDebugInfoPresent()) {
                if (this.throwExceptionIfMissing) {
                    throw new ParameterNamesNotFoundException("Parameter names not found for " + this.methodName);
                }
                return Paranamer.EMPTY_NAMES;
            }
            return this.collector.getResult().split(",");
        }
    }

    private static class MethodCollector {
        private int currentParameter;
        private boolean debugInfoPresent;
        private final int ignoreCount;
        private final int paramCount;
        private final StringBuffer result;

        private MethodCollector(int i, int i2) {
            this.ignoreCount = i;
            this.paramCount = i2;
            this.result = new StringBuffer();
            this.currentParameter = 0;
            this.debugInfoPresent = i2 == 0;
        }

        public void visitLocalVariable(String str, int i) {
            int i2 = this.ignoreCount;
            if (i < i2 || i >= i2 + this.paramCount) {
                return;
            }
            if (!str.equals("arg" + this.currentParameter)) {
                this.debugInfoPresent = true;
            }
            this.result.append(',');
            this.result.append(str);
            this.currentParameter++;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getResult() {
            return this.result.length() != 0 ? this.result.substring(1) : "";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isDebugInfoPresent() {
            return this.debugInfoPresent;
        }
    }

    private static class ClassReader {
        public final byte[] b;
        public final int header;
        private final int[] items;
        private final int maxStringLength;
        private final String[] strings;

        private ClassReader(byte[] bArr) {
            this(bArr, 0);
        }

        private ClassReader(byte[] bArr, int i) {
            this.b = bArr;
            int[] iArr = new int[readUnsignedShort(i + 8)];
            this.items = iArr;
            int length = iArr.length;
            this.strings = new String[length];
            int i2 = i + 10;
            int i3 = 0;
            int i4 = 1;
            while (i4 < length) {
                int i5 = i2 + 1;
                this.items[i4] = i5;
                int unsignedShort = 3;
                switch (bArr[i2]) {
                    case 1:
                        unsignedShort = 3 + readUnsignedShort(i5);
                        if (unsignedShort <= i3) {
                            break;
                        } else {
                            i3 = unsignedShort;
                            break;
                        }
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        unsignedShort = 5;
                        break;
                    case 5:
                    case 6:
                        i4++;
                        unsignedShort = 9;
                        break;
                }
                i2 += unsignedShort;
                i4++;
            }
            this.maxStringLength = i3;
            this.header = i2;
        }

        private ClassReader(InputStream inputStream) {
            this(readClass(inputStream));
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        
            if (r2 >= r0.length) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        
            r3 = new byte[r2];
            java.lang.System.arraycopy(r0, 0, r3, 0, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        
            r0 = r3;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static byte[] readClass(java.io.InputStream r5) throws java.io.IOException {
            /*
                if (r5 == 0) goto L45
                int r0 = r5.available()     // Catch: java.lang.Throwable -> L1d
                byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L1d
                r1 = 0
                r2 = r1
            La:
                int r3 = r0.length     // Catch: java.lang.Throwable -> L1d
                int r3 = r3 - r2
                int r3 = r5.read(r0, r2, r3)     // Catch: java.lang.Throwable -> L1d
                r4 = -1
                if (r3 != r4) goto L23
                int r3 = r0.length     // Catch: java.lang.Throwable -> L1d
                if (r2 >= r3) goto L1f
                byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L1d
                java.lang.System.arraycopy(r0, r1, r3, r1, r2)     // Catch: java.lang.Throwable -> L1d
                r0 = r3
                goto L1f
            L1d:
                r0 = move-exception
                goto L41
            L1f:
                r5.close()     // Catch: java.io.IOException -> L22
            L22:
                return r0
            L23:
                int r2 = r2 + r3
                int r3 = r0.length     // Catch: java.lang.Throwable -> L1d
                if (r2 != r3) goto La
                int r3 = r5.read()     // Catch: java.lang.Throwable -> L1d
                if (r3 >= 0) goto L31
                r5.close()     // Catch: java.io.IOException -> L30
            L30:
                return r0
            L31:
                int r4 = r0.length     // Catch: java.lang.Throwable -> L1d
                int r4 = r4 + 1000
                byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L1d
                java.lang.System.arraycopy(r0, r1, r4, r1, r2)     // Catch: java.lang.Throwable -> L1d
                int r0 = r2 + 1
                byte r3 = (byte) r3     // Catch: java.lang.Throwable -> L1d
                r4[r2] = r3     // Catch: java.lang.Throwable -> L1d
                r2 = r0
                r0 = r4
                goto La
            L41:
                r5.close()     // Catch: java.io.IOException -> L44
            L44:
                throw r0
            L45:
                java.io.IOException r5 = new java.io.IOException
                java.lang.String r0 = "Class not found"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.picocontainer.paranamer.BytecodeReadingParanamer.ClassReader.readClass(java.io.InputStream):byte[]");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void accept(TypeCollector typeCollector) {
            char[] cArr = new char[this.maxStringLength];
            int i = this.header;
            int i2 = this.items[readUnsignedShort(i + 4)];
            int unsignedShort = readUnsignedShort(i + 6);
            int i3 = i + 8;
            for (int i4 = 0; i4 < unsignedShort; i4++) {
                i3 += 2;
            }
            int i5 = i3 + 2;
            int i6 = i5;
            for (int unsignedShort2 = readUnsignedShort(i3); unsignedShort2 > 0; unsignedShort2--) {
                i6 += 8;
                for (int unsignedShort3 = readUnsignedShort(i6 + 6); unsignedShort3 > 0; unsignedShort3--) {
                    i6 += readInt(i6 + 2) + 6;
                }
            }
            int i7 = i6 + 2;
            for (int unsignedShort4 = readUnsignedShort(i6); unsignedShort4 > 0; unsignedShort4--) {
                i7 += 8;
                for (int unsignedShort5 = readUnsignedShort(i7 + 6); unsignedShort5 > 0; unsignedShort5--) {
                    i7 += readInt(i7 + 2) + 6;
                }
            }
            int i8 = i7 + 2;
            for (int unsignedShort6 = readUnsignedShort(i7); unsignedShort6 > 0; unsignedShort6--) {
                i8 += readInt(i8 + 2) + 6;
            }
            for (int unsignedShort7 = readUnsignedShort(i3); unsignedShort7 > 0; unsignedShort7--) {
                i5 += 8;
                for (int unsignedShort8 = readUnsignedShort(i5 + 6); unsignedShort8 > 0; unsignedShort8--) {
                    i5 += readInt(i5 + 2) + 6;
                }
            }
            int method = i5 + 2;
            for (int unsignedShort9 = readUnsignedShort(i5); unsignedShort9 > 0; unsignedShort9--) {
                method = readMethod(typeCollector, cArr, method);
            }
        }

        private int readMethod(TypeCollector typeCollector, char[] cArr, int i) {
            int unsignedShort = readUnsignedShort(i);
            String utf8 = readUTF8(i + 2, cArr);
            String utf82 = readUTF8(i + 4, cArr);
            int i2 = i + 8;
            int i3 = 0;
            int i4 = 0;
            for (int unsignedShort2 = readUnsignedShort(i + 6); unsignedShort2 > 0; unsignedShort2--) {
                String utf83 = readUTF8(i2, cArr);
                int i5 = readInt(i2 + 2);
                int i6 = i2 + 6;
                if (utf83.equals("Code")) {
                    i4 = i6;
                }
                i2 = i6 + i5;
            }
            MethodCollector methodCollectorVisitMethod = typeCollector.visitMethod(unsignedShort, utf8, utf82);
            if (methodCollectorVisitMethod != null && i4 != 0) {
                int i7 = i4 + 8 + readInt(i4 + 4);
                int i8 = i7 + 2;
                for (int unsignedShort3 = readUnsignedShort(i7); unsignedShort3 > 0; unsignedShort3--) {
                    i8 += 8;
                }
                int i9 = i8 + 2;
                int i10 = 0;
                for (int unsignedShort4 = readUnsignedShort(i8); unsignedShort4 > 0; unsignedShort4--) {
                    String utf84 = readUTF8(i9, cArr);
                    if (utf84.equals("LocalVariableTable")) {
                        i3 = i9 + 6;
                    } else if (utf84.equals("LocalVariableTypeTable")) {
                        i10 = i9 + 6;
                    }
                    i9 += readInt(i9 + 2) + 6;
                }
                if (i3 != 0) {
                    if (i10 != 0) {
                        int unsignedShort5 = readUnsignedShort(i10) * 3;
                        int i11 = i10 + 2;
                        int[] iArr = new int[unsignedShort5];
                        while (unsignedShort5 > 0) {
                            iArr[unsignedShort5 - 1] = i11 + 6;
                            iArr[unsignedShort5 - 2] = readUnsignedShort(i11 + 8);
                            unsignedShort5 -= 3;
                            iArr[unsignedShort5] = readUnsignedShort(i11);
                            i11 += 10;
                        }
                    }
                    int i12 = i3 + 2;
                    for (int unsignedShort6 = readUnsignedShort(i3); unsignedShort6 > 0; unsignedShort6--) {
                        methodCollectorVisitMethod.visitLocalVariable(readUTF8(i12 + 4, cArr), readUnsignedShort(i12 + 8));
                        i12 += 10;
                    }
                }
            }
            return i2;
        }

        private int readUnsignedShort(int i) {
            byte[] bArr = this.b;
            return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
        }

        private int readInt(int i) {
            byte[] bArr = this.b;
            return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
        }

        private String readUTF8(int i, char[] cArr) {
            int unsignedShort = readUnsignedShort(i);
            String[] strArr = this.strings;
            String str = strArr[unsignedShort];
            if (str != null) {
                return str;
            }
            int i2 = this.items[unsignedShort];
            String utf = readUTF(i2 + 2, readUnsignedShort(i2), cArr);
            strArr[unsignedShort] = utf;
            return utf;
        }

        private String readUTF(int i, int i2, char[] cArr) {
            int i3;
            int i4 = i2 + i;
            byte[] bArr = this.b;
            int i5 = 0;
            char c = 0;
            char c2 = 0;
            while (i < i4) {
                int i6 = i + 1;
                byte b = bArr[i];
                if (c == 0) {
                    int i7 = b & 255;
                    if (i7 < 128) {
                        cArr[i5] = (char) i7;
                        i5++;
                    } else if (i7 >= 224 || i7 <= 191) {
                        c2 = (char) (b & Ascii.SI);
                        c = 2;
                    } else {
                        i3 = b & Ascii.US;
                        c2 = (char) i3;
                        c = 1;
                    }
                } else if (c == 1) {
                    cArr[i5] = (char) ((b & Utf8.REPLACEMENT_BYTE) | (c2 << 6));
                    i5++;
                    c = 0;
                } else if (c == 2) {
                    i3 = (b & Utf8.REPLACEMENT_BYTE) | (c2 << 6);
                    c2 = (char) i3;
                    c = 1;
                }
                i = i6;
            }
            return new String(cArr, 0, i5);
        }
    }

    private static class Type {
        private char[] buf;
        private final int len;
        private int off;
        private final int sort;
        private static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
        private static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
        private static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
        private static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
        private static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
        private static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
        private static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
        private static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
        private static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);

        private Type(int i, char[] cArr, int i2, int i3) {
            this.sort = i;
            this.buf = cArr;
            this.off = i2;
            this.len = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Type[] getArgumentTypes(String str) {
            char[] charArray = str.toCharArray();
            int i = 1;
            int i2 = 1;
            int i3 = 0;
            while (true) {
                int i4 = i2 + 1;
                char c = charArray[i2];
                if (c == ')') {
                    break;
                }
                if (c == 'L') {
                    while (true) {
                        i2 = i4 + 1;
                        if (charArray[i4] == ';') {
                            break;
                        }
                        i4 = i2;
                    }
                    i3++;
                } else {
                    if (c != '[') {
                        i3++;
                    }
                    i2 = i4;
                }
            }
            Type[] typeArr = new Type[i3];
            int i5 = 0;
            while (charArray[i] != ')') {
                Type type = getType(charArray, i);
                typeArr[i5] = type;
                i += type.len + (type.sort == 10 ? 2 : 0);
                i5++;
            }
            return typeArr;
        }

        private static Type getType(char[] cArr, int i) {
            char c;
            char c2 = cArr[i];
            if (c2 == 'F') {
                return FLOAT_TYPE;
            }
            if (c2 == 'S') {
                return SHORT_TYPE;
            }
            if (c2 == 'V') {
                return VOID_TYPE;
            }
            if (c2 == 'I') {
                return INT_TYPE;
            }
            if (c2 == 'J') {
                return LONG_TYPE;
            }
            if (c2 == 'Z') {
                return BOOLEAN_TYPE;
            }
            if (c2 != '[') {
                switch (c2) {
                    case EACTags.ADDRESS /* 66 */:
                        return BYTE_TYPE;
                    case 'C':
                        return CHAR_TYPE;
                    case 'D':
                        return DOUBLE_TYPE;
                    default:
                        int i2 = 1;
                        while (cArr[i + i2] != ';') {
                            i2++;
                        }
                        return new Type(10, cArr, i + 1, i2 - 1);
                }
            }
            int i3 = 1;
            while (true) {
                c = cArr[i + i3];
                if (c != '[') {
                    break;
                }
                i3++;
            }
            if (c == 'L') {
                do {
                    i3++;
                } while (cArr[i + i3] != ';');
            }
            return new Type(9, cArr, i, i3 + 1);
        }

        private int getDimensions() {
            int i = 1;
            while (this.buf[this.off + i] == '[') {
                i++;
            }
            return i;
        }

        private Type getElementType() {
            return getType(this.buf, this.off + getDimensions());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getClassName() {
            switch (this.sort) {
                case 0:
                    return "void";
                case 1:
                    return "boolean";
                case 2:
                    return "char";
                case 3:
                    return "byte";
                case 4:
                    return "short";
                case 5:
                    return "int";
                case 6:
                    return TypedValues.Custom.S_FLOAT;
                case 7:
                    return LongTypedProperty.TYPE;
                case 8:
                    return DoubleTypedProperty.TYPE;
                case 9:
                    StringBuffer stringBuffer = new StringBuffer(getElementType().getClassName());
                    for (int dimensions = getDimensions(); dimensions > 0; dimensions--) {
                        stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    }
                    return stringBuffer.toString();
                default:
                    return new String(this.buf, this.off, this.len).replace('/', '.');
            }
        }
    }
}
