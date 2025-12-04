package com.squareup.javawriter;

import com.amazonaws.services.s3.model.InstructionFileId;
import gherkin.GherkinLanguageConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Modifier;

/* loaded from: classes4.dex */
public final class JavaWriter implements Closeable {
    private static final Pattern TYPE_PATTERN = Pattern.compile("(?:[\\w$]+\\.)*([\\w\\.*$]+)");
    private final Writer out;
    private String packagePrefix;
    private final Map importedTypes = new LinkedHashMap();
    private final List scopes = new ArrayList();

    private enum Scope {
        TYPE_DECLARATION,
        ABSTRACT_METHOD,
        NON_ABSTRACT_METHOD,
        CONTROL_FLOW,
        ANNOTATION_ATTRIBUTE,
        ANNOTATION_ARRAY_VALUE,
        INITIALIZER
    }

    public JavaWriter(Writer writer) {
        this.out = writer;
    }

    public JavaWriter emitPackage(String str) throws IOException {
        if (this.packagePrefix != null) {
            throw new IllegalStateException();
        }
        if (str.isEmpty()) {
            this.packagePrefix = "";
        } else {
            this.out.write("package ");
            this.out.write(str);
            this.out.write(";\n\n");
            this.packagePrefix = str + InstructionFileId.DOT;
        }
        return this;
    }

    public JavaWriter emitImports(String... strArr) throws IOException {
        return emitImports(Arrays.asList(strArr));
    }

    public JavaWriter emitImports(Collection<String> collection) throws IOException {
        Iterator it = new TreeSet(collection).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Matcher matcher = TYPE_PATTERN.matcher(str);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(str);
            }
            if (this.importedTypes.put(str, matcher.group(1)) != null) {
                throw new IllegalArgumentException(str);
            }
            this.out.write("import ");
            this.out.write(str);
            this.out.write(";\n");
        }
        return this;
    }

    public JavaWriter emitStaticImports(String... strArr) throws IOException {
        return emitStaticImports(Arrays.asList(strArr));
    }

    public JavaWriter emitStaticImports(Collection<String> collection) throws IOException {
        Iterator it = new TreeSet(collection).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Matcher matcher = TYPE_PATTERN.matcher(str);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(str);
            }
            if (this.importedTypes.put(str, matcher.group(1)) != null) {
                throw new IllegalArgumentException(str);
            }
            this.out.write("import static ");
            this.out.write(str);
            this.out.write(";\n");
        }
        return this;
    }

    private JavaWriter emitType(String str) throws IOException {
        this.out.write(compressType(str));
        return this;
    }

    public String compressType(String str) {
        StringBuilder sb = new StringBuilder();
        if (this.packagePrefix == null) {
            throw new IllegalStateException();
        }
        Matcher matcher = TYPE_PATTERN.matcher(str);
        int iEnd = 0;
        while (true) {
            boolean zFind = matcher.find(iEnd);
            sb.append((CharSequence) str, iEnd, zFind ? matcher.start() : str.length());
            if (zFind) {
                String strGroup = matcher.group(0);
                String str2 = (String) this.importedTypes.get(strGroup);
                if (str2 != null) {
                    sb.append(str2);
                } else if (isClassInPackage(strGroup)) {
                    String strSubstring = strGroup.substring(this.packagePrefix.length());
                    if (isAmbiguous(strSubstring)) {
                        sb.append(strGroup);
                    } else {
                        sb.append(strSubstring);
                    }
                } else if (strGroup.startsWith("java.lang.")) {
                    sb.append(strGroup.substring(10));
                } else {
                    sb.append(strGroup);
                }
                iEnd = matcher.end();
            } else {
                return sb.toString();
            }
        }
    }

    private boolean isClassInPackage(String str) {
        if (!str.startsWith(this.packagePrefix)) {
            return false;
        }
        if (str.indexOf(46, this.packagePrefix.length()) == -1) {
            return true;
        }
        int iIndexOf = str.indexOf(46);
        return str.substring(iIndexOf + 1, iIndexOf + 2).matches("[A-Z]");
    }

    private boolean isAmbiguous(String str) {
        return this.importedTypes.values().contains(str);
    }

    public JavaWriter beginInitializer(boolean z) throws IOException {
        indent();
        if (z) {
            this.out.write("static");
            this.out.write(" {\n");
        } else {
            this.out.write("{\n");
        }
        pushScope(Scope.INITIALIZER);
        return this;
    }

    public JavaWriter endInitializer() throws IOException {
        popScope(Scope.INITIALIZER);
        indent();
        this.out.write("}\n");
        return this;
    }

    public JavaWriter beginType(String str, String str2) throws IOException {
        return beginType(str, str2, EnumSet.noneOf(Modifier.class), (String) null, new String[0]);
    }

    @Deprecated
    public JavaWriter beginType(String str, String str2, int i) throws IOException {
        return beginType(str, str2, modifiersAsSet(i), (String) null, new String[0]);
    }

    public JavaWriter beginType(String str, String str2, Set<Modifier> set) throws IOException {
        return beginType(str, str2, set, (String) null, new String[0]);
    }

    @Deprecated
    public JavaWriter beginType(String str, String str2, int i, String str3, String... strArr) throws IOException {
        return beginType(str, str2, modifiersAsSet(i), str3, strArr);
    }

    public JavaWriter beginType(String str, String str2, Set<Modifier> set, String str3, String... strArr) throws IOException {
        indent();
        emitModifiers(set);
        this.out.write(str2);
        this.out.write(" ");
        emitType(str);
        if (str3 != null) {
            this.out.write(" extends ");
            emitType(str3);
        }
        if (strArr.length > 0) {
            this.out.write("\n");
            indent();
            this.out.write("    implements ");
            for (int i = 0; i < strArr.length; i++) {
                if (i != 0) {
                    this.out.write(", ");
                }
                emitType(strArr[i]);
            }
        }
        this.out.write(" {\n");
        pushScope(Scope.TYPE_DECLARATION);
        return this;
    }

    public JavaWriter endType() throws IOException {
        popScope(Scope.TYPE_DECLARATION);
        indent();
        this.out.write("}\n");
        return this;
    }

    public JavaWriter emitField(String str, String str2) throws IOException {
        return emitField(str, str2, EnumSet.noneOf(Modifier.class), (String) null);
    }

    @Deprecated
    public JavaWriter emitField(String str, String str2, int i) throws IOException {
        return emitField(str, str2, modifiersAsSet(i), (String) null);
    }

    public JavaWriter emitField(String str, String str2, Set<Modifier> set) throws IOException {
        return emitField(str, str2, set, (String) null);
    }

    @Deprecated
    public JavaWriter emitField(String str, String str2, int i, String str3) throws IOException {
        return emitField(str, str2, modifiersAsSet(i), str3);
    }

    public JavaWriter emitField(String str, String str2, Set<Modifier> set, String str3) throws IOException {
        indent();
        emitModifiers(set);
        emitType(str);
        this.out.write(" ");
        this.out.write(str2);
        if (str3 != null) {
            this.out.write(" = ");
            this.out.write(str3);
        }
        this.out.write(";\n");
        return this;
    }

    @Deprecated
    public JavaWriter beginMethod(String str, String str2, int i, String... strArr) throws IOException {
        return beginMethod(str, str2, modifiersAsSet(i), Arrays.asList(strArr), (List<String>) null);
    }

    public JavaWriter beginMethod(String str, String str2, Set<Modifier> set, String... strArr) throws IOException {
        return beginMethod(str, str2, set, Arrays.asList(strArr), (List<String>) null);
    }

    @Deprecated
    public JavaWriter beginMethod(String str, String str2, int i, List<String> list, List<String> list2) throws IOException {
        return beginMethod(str, str2, modifiersAsSet(i), list, list2);
    }

    public JavaWriter beginMethod(String str, String str2, Set<Modifier> set, List<String> list, List<String> list2) throws IOException {
        indent();
        emitModifiers(set);
        if (str != null) {
            emitType(str);
            this.out.write(" ");
            this.out.write(str2);
        } else {
            emitType(str2);
        }
        this.out.write("(");
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                if (i != 0) {
                    this.out.write(", ");
                }
                int i2 = i + 1;
                emitType(list.get(i));
                this.out.write(" ");
                i += 2;
                emitType(list.get(i2));
            }
        }
        this.out.write(")");
        if (list2 != null && list2.size() > 0) {
            this.out.write("\n");
            indent();
            this.out.write("    throws ");
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (i3 != 0) {
                    this.out.write(", ");
                }
                emitType(list2.get(i3));
            }
        }
        if (set.contains(Modifier.ABSTRACT)) {
            this.out.write(";\n");
            pushScope(Scope.ABSTRACT_METHOD);
        } else {
            this.out.write(" {\n");
            pushScope(Scope.NON_ABSTRACT_METHOD);
        }
        return this;
    }

    public JavaWriter emitJavadoc(String str, Object... objArr) throws IOException {
        String str2 = String.format(str, objArr);
        indent();
        this.out.write("/**\n");
        for (String str3 : str2.split("\n")) {
            indent();
            this.out.write(" * ");
            this.out.write(str3);
            this.out.write("\n");
        }
        indent();
        this.out.write(" */\n");
        return this;
    }

    public JavaWriter emitSingleLineComment(String str, Object... objArr) throws IOException {
        indent();
        this.out.write("// ");
        this.out.write(String.format(str, objArr));
        this.out.write("\n");
        return this;
    }

    public JavaWriter emitEmptyLine() throws IOException {
        this.out.write("\n");
        return this;
    }

    public JavaWriter emitEnumValue(String str) throws IOException {
        indent();
        this.out.write(str);
        this.out.write(",\n");
        return this;
    }

    public JavaWriter emitAnnotation(String str) throws IOException {
        return emitAnnotation(str, Collections.emptyMap());
    }

    public JavaWriter emitAnnotation(Class<? extends Annotation> cls) throws IOException {
        return emitAnnotation(type(cls, new String[0]), Collections.emptyMap());
    }

    public JavaWriter emitAnnotation(Class<? extends Annotation> cls, Object obj) throws IOException {
        return emitAnnotation(type(cls, new String[0]), obj);
    }

    public JavaWriter emitAnnotation(String str, Object obj) throws IOException {
        indent();
        this.out.write(GherkinLanguageConstants.TAG_PREFIX);
        emitType(str);
        this.out.write("(");
        emitAnnotationValue(obj);
        this.out.write(")");
        this.out.write("\n");
        return this;
    }

    public JavaWriter emitAnnotation(Class<? extends Annotation> cls, Map<String, ?> map) throws IOException {
        return emitAnnotation(type(cls, new String[0]), map);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.squareup.javawriter.JavaWriter emitAnnotation(java.lang.String r7, java.util.Map<java.lang.String, ?> r8) throws java.io.IOException {
        /*
            r6 = this;
            r6.indent()
            java.io.Writer r0 = r6.out
            java.lang.String r1 = "@"
            r0.write(r1)
            r6.emitType(r7)
            int r7 = r8.size()
            java.lang.String r0 = "\n"
            if (r7 == 0) goto La7
            java.lang.String r1 = ")"
            java.lang.String r2 = "("
            r3 = 1
            if (r7 == r3) goto L1d
            goto L49
        L1d:
            java.util.Set r7 = r8.entrySet()
            java.util.Iterator r7 = r7.iterator()
            java.lang.Object r7 = r7.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r4 = r7.getKey()
            java.lang.String r5 = "value"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L49
            java.io.Writer r8 = r6.out
            r8.write(r2)
            java.lang.Object r7 = r7.getValue()
            r6.emitAnnotationValue(r7)
            java.io.Writer r7 = r6.out
            r7.write(r1)
            goto La7
        L49:
            java.io.Writer r7 = r6.out
            r7.write(r2)
            com.squareup.javawriter.JavaWriter$Scope r7 = com.squareup.javawriter.JavaWriter.Scope.ANNOTATION_ATTRIBUTE
            r6.pushScope(r7)
            java.util.Set r7 = r8.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L5b:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L95
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            if (r3 == 0) goto L71
            java.io.Writer r2 = r6.out
            r2.write(r0)
            r2 = 0
            r3 = r2
            goto L78
        L71:
            java.io.Writer r2 = r6.out
            java.lang.String r4 = ",\n"
            r2.write(r4)
        L78:
            r6.indent()
            java.io.Writer r2 = r6.out
            java.lang.Object r4 = r8.getKey()
            java.lang.String r4 = (java.lang.String) r4
            r2.write(r4)
            java.io.Writer r2 = r6.out
            java.lang.String r4 = " = "
            r2.write(r4)
            java.lang.Object r8 = r8.getValue()
            r6.emitAnnotationValue(r8)
            goto L5b
        L95:
            com.squareup.javawriter.JavaWriter$Scope r7 = com.squareup.javawriter.JavaWriter.Scope.ANNOTATION_ATTRIBUTE
            r6.popScope(r7)
            java.io.Writer r7 = r6.out
            r7.write(r0)
            r6.indent()
            java.io.Writer r7 = r6.out
            r7.write(r1)
        La7:
            java.io.Writer r7 = r6.out
            r7.write(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.javawriter.JavaWriter.emitAnnotation(java.lang.String, java.util.Map):com.squareup.javawriter.JavaWriter");
    }

    private JavaWriter emitAnnotationValue(Object obj) throws IOException {
        if (obj instanceof Object[]) {
            this.out.write("{");
            pushScope(Scope.ANNOTATION_ARRAY_VALUE);
            boolean z = true;
            for (Object obj2 : (Object[]) obj) {
                if (z) {
                    this.out.write("\n");
                    z = false;
                } else {
                    this.out.write(",\n");
                }
                indent();
                this.out.write(obj2.toString());
            }
            popScope(Scope.ANNOTATION_ARRAY_VALUE);
            this.out.write("\n");
            indent();
            this.out.write("}");
        } else {
            this.out.write(obj.toString());
        }
        return this;
    }

    public JavaWriter emitStatement(String str, Object... objArr) throws IOException {
        checkInMethod();
        String[] strArrSplit = String.format(str, objArr).split("\n", -1);
        indent();
        this.out.write(strArrSplit[0]);
        for (int i = 1; i < strArrSplit.length; i++) {
            this.out.write("\n");
            hangingIndent();
            this.out.write(strArrSplit[i]);
        }
        this.out.write(";\n");
        return this;
    }

    public JavaWriter beginControlFlow(String str) throws IOException {
        checkInMethod();
        indent();
        this.out.write(str);
        this.out.write(" {\n");
        pushScope(Scope.CONTROL_FLOW);
        return this;
    }

    public JavaWriter nextControlFlow(String str) throws IOException {
        Scope scope = Scope.CONTROL_FLOW;
        popScope(scope);
        indent();
        pushScope(scope);
        this.out.write("} ");
        this.out.write(str);
        this.out.write(" {\n");
        return this;
    }

    public JavaWriter endControlFlow() throws IOException {
        return endControlFlow(null);
    }

    public JavaWriter endControlFlow(String str) throws IOException {
        popScope(Scope.CONTROL_FLOW);
        indent();
        if (str != null) {
            this.out.write("} ");
            this.out.write(str);
            this.out.write(";\n");
        } else {
            this.out.write("}\n");
        }
        return this;
    }

    public JavaWriter endMethod() throws IOException {
        Scope scopePopScope = popScope();
        if (scopePopScope == Scope.NON_ABSTRACT_METHOD) {
            indent();
            this.out.write("}\n");
        } else if (scopePopScope != Scope.ABSTRACT_METHOD) {
            throw new IllegalStateException();
        }
        return this;
    }

    public static String stringLiteral(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\f') {
                if (cCharAt != '\r') {
                    if (cCharAt != '\"') {
                        if (cCharAt == '\\') {
                            sb.append("\\\\");
                        } else {
                            switch (cCharAt) {
                                case '\b':
                                    sb.append("\\b");
                                    break;
                                case '\t':
                                    sb.append("\\t");
                                    break;
                                case '\n':
                                    sb.append("\\n");
                                    break;
                                default:
                                    if (Character.isISOControl(cCharAt)) {
                                        sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                                        break;
                                    } else {
                                        sb.append(cCharAt);
                                        break;
                                    }
                            }
                        }
                    } else {
                        sb.append("\\\"");
                    }
                } else {
                    sb.append("\\r");
                }
            } else {
                sb.append("\\f");
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String type(Class<?> cls, String... strArr) {
        if (strArr.length == 0) {
            return cls.getCanonicalName();
        }
        if (cls.getTypeParameters().length != strArr.length) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getCanonicalName());
        sb.append("<");
        sb.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(", ");
            sb.append(strArr[i]);
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    private void emitModifiers(Set set) throws IOException {
        if (!(set instanceof EnumSet)) {
            set = EnumSet.copyOf((Collection) set);
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.out.append((CharSequence) ((Modifier) it.next()).toString()).append(' ');
        }
    }

    private static EnumSet modifiersAsSet(int i) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(Modifier.class);
        if ((i & 1) != 0) {
            enumSetNoneOf.add(Modifier.PUBLIC);
        }
        if ((i & 2) != 0) {
            enumSetNoneOf.add(Modifier.PRIVATE);
        }
        if ((i & 4) != 0) {
            enumSetNoneOf.add(Modifier.PROTECTED);
        }
        if ((i & 8) != 0) {
            enumSetNoneOf.add(Modifier.STATIC);
        }
        if ((i & 16) != 0) {
            enumSetNoneOf.add(Modifier.FINAL);
        }
        if ((i & 1024) != 0) {
            enumSetNoneOf.add(Modifier.ABSTRACT);
        }
        if ((i & 32) != 0) {
            enumSetNoneOf.add(Modifier.SYNCHRONIZED);
        }
        if ((i & 128) != 0) {
            enumSetNoneOf.add(Modifier.TRANSIENT);
        }
        if ((i & 64) != 0) {
            enumSetNoneOf.add(Modifier.VOLATILE);
        }
        return enumSetNoneOf;
    }

    private void indent() throws IOException {
        int size = this.scopes.size();
        for (int i = 0; i < size; i++) {
            this.out.write("  ");
        }
    }

    private void hangingIndent() throws IOException {
        int size = this.scopes.size() + 2;
        for (int i = 0; i < size; i++) {
            this.out.write("  ");
        }
    }

    private void checkInMethod() {
        Scope scopePeekScope = peekScope();
        if (scopePeekScope != Scope.NON_ABSTRACT_METHOD && scopePeekScope != Scope.CONTROL_FLOW && scopePeekScope != Scope.INITIALIZER) {
            throw new IllegalArgumentException();
        }
    }

    private void pushScope(Scope scope) {
        this.scopes.add(scope);
    }

    private Scope peekScope() {
        return (Scope) this.scopes.get(r1.size() - 1);
    }

    private Scope popScope() {
        return (Scope) this.scopes.remove(r1.size() - 1);
    }

    private void popScope(Scope scope) {
        if (this.scopes.remove(r1.size() - 1) != scope) {
            throw new IllegalStateException();
        }
    }
}
