package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import ch.qos.logback.core.pattern.parser.Parser;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n+ 2 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 3 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder\n*L\n1#1,315:1\n255#1:317\n13#2:316\n261#3:318\n261#3:319\n261#3:320\n261#3:321\n261#3:322\n261#3:323\n261#3:324\n261#3:325\n261#3:326\n261#3:327\n261#3:328\n261#3:329\n261#3:330\n261#3:331\n261#3:332\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/PredefinedEnhancementInfoKt\n*L\n67#1:317\n56#1:316\n68#1:318\n73#1:319\n78#1:320\n93#1:321\n117#1:322\n134#1:323\n182#1:324\n202#1:325\n208#1:326\n214#1:327\n221#1:328\n226#1:329\n232#1:330\n238#1:331\n245#1:332\n*E\n"})
public final class PredefinedEnhancementInfoKt {
    private static final JavaTypeQualifiers NOT_NULLABLE;
    private static final JavaTypeQualifiers NOT_PLATFORM;
    private static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, null, false, false, 8, null);
    private static final Map PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;

    static {
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        NOT_PLATFORM = new JavaTypeQualifiers(nullabilityQualifier, null, false, false, 8, null);
        NOT_NULLABLE = new JavaTypeQualifiers(nullabilityQualifier, null, true, false, 8, null);
        final SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        final String strJavaLang = signatureBuildingComponents.javaLang("Object");
        final String strJavaFunction = signatureBuildingComponents.javaFunction("Predicate");
        final String strJavaFunction2 = signatureBuildingComponents.javaFunction("Function");
        final String strJavaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        final String strJavaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        final String strJavaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        final String strJavaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        final String strJavaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        final String strJavaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator")), "forEachRemaining", null, new Function1(strJavaFunction3) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$0
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction3;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1858x6fb0e4ea(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("Iterable")), "spliterator", null, new Function1(signatureBuildingComponents) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$1
            private final SignatureBuildingComponents arg$0;

            {
                this.arg$0 = signatureBuildingComponents;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1877x5843c72a(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Collection"));
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder, "removeIf", null, new Function1(strJavaFunction) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$2
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1891x29698ba8(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder, "stream", null, new Function1(strJavaUtil) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$3
            private final String arg$0;

            {
                this.arg$0 = strJavaUtil;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1892x29698ba9(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder, "parallelStream", null, new Function1(strJavaUtil) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$4
            private final String arg$0;

            {
                this.arg$0 = strJavaUtil;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1893x29698baa(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("List"));
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder2, "replaceAll", null, new Function1(strJavaFunction6) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$5
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction6;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1862x3207a819(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        classEnhancementBuilder2.function("addFirst", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$6
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1863x3207a81a(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("addLast", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$7
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1859xeed5a5e(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("removeFirst", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$8
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1860xeed5a5f(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder2.function("removeLast", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$9
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1861xeed5a60(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("LinkedList"));
        classEnhancementBuilder3.function("addFirst", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$10
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1864xf764d827(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("addLast", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$11
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1865xf764d828(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("removeFirst", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$12
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1866xf764d829(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        classEnhancementBuilder3.function("removeLast", "2.1", new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$13
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1867xf764d82a(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        });
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder4 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Map"));
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, "forEach", null, new Function1(strJavaFunction5) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$14
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction5;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1868xff167d8b(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, "putIfAbsent", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$15
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1869xff167da1(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, Parser.REPLACE_CONVERTER_WORD, null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$16
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1870xff167da2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, Parser.REPLACE_CONVERTER_WORD, null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$17
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1871xff167da3(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, "replaceAll", null, new Function1(strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$18
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1872xff167da4(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, "compute", null, new Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$19
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1873xff167da5(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, "computeIfAbsent", null, new Function1(strJavaLang, strJavaFunction2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$20
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1874xff167da6(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, "computeIfPresent", null, new Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$21
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1875xff167da7(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder4, "merge", null, new Function1(strJavaLang, strJavaFunction4) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$22
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaFunction4;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1876xff167da8(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder5 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaUtil2);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "empty", null, new Function1(strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$23
            private final String arg$0;

            {
                this.arg$0 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1878xb3355805(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "of", null, new Function1(strJavaLang, strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$24
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1879xb335581b(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "ofNullable", null, new Function1(strJavaLang, strJavaUtil2) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$25
            private final String arg$0;
            private final String arg$1;

            {
                this.arg$0 = strJavaLang;
                this.arg$1 = strJavaUtil2;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1880xb335581c(this.arg$0, this.arg$1, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "get", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$26
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1881xb335581d(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(classEnhancementBuilder5, "ifPresent", null, new Function1(strJavaFunction3) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$27
            private final String arg$0;

            {
                this.arg$0 = strJavaFunction3;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1882xb335581e(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaLang("ref/Reference")), "get", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$28
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1883xdcfebda2(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction), InstrumentationResultPrinter.REPORT_KEY_NAME_TEST, null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$29
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1884x6c82326(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("BiPredicate")), InstrumentationResultPrinter.REPORT_KEY_NAME_TEST, null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$30
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1885x6754327f(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction3), "accept", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$31
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1886x911d9818(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction5), "accept", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$32
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1887xbae6fd9c(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction2), "apply", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$33
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1888xe4b06320(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, strJavaFunction4), "apply", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$34
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1889xe79c8a4(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        SignatureEnhancementBuilder.ClassEnhancementBuilder.function$default(new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaFunction("Supplier")), "get", null, new Function1(strJavaLang) { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.PredefinedEnhancementInfoKt$$Lambda$35
            private final String arg$0;

            {
                this.arg$0 = strJavaLang;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                return PredefinedEnhancementInfoKt.m1890x6f05d7fd(this.arg$0, (SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder) obj);
            }
        }, 2, null);
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder.build();
    }

    @NotNull
    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$1$lambda$0 */
    public static final Unit m1858x6fb0e4ea(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$3$lambda$2 */
    public static final Unit m1877x5843c72a(SignatureBuildingComponents signatureBuildingComponents, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        String strJavaUtil = signatureBuildingComponents.javaUtil("Spliterator");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(strJavaUtil, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$7$lambda$4 */
    public static final Unit m1891x29698ba8(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$7$lambda$5 */
    public static final Unit m1892x29698ba9(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(str, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$7$lambda$6 */
    public static final Unit m1893x29698baa(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.returns(str, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$13$lambda$8 */
    public static final Unit m1862x3207a819(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$13$lambda$9 */
    public static final Unit m1863x3207a81a(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$13$lambda$10 */
    public static final Unit m1859xeed5a5e(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$13$lambda$11 */
    public static final Unit m1860xeed5a5f(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$13$lambda$12 */
    public static final Unit m1861xeed5a60(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$18$lambda$14 */
    public static final Unit m1864xf764d827(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$18$lambda$15 */
    public static final Unit m1865xf764d828(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$18$lambda$16 */
    public static final Unit m1866xf764d829(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$18$lambda$17 */
    public static final Unit m1867xf764d82a(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$19 */
    public static final Unit m1868xff167d8b(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$20 */
    public static final Unit m1869xff167da1(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$21 */
    public static final Unit m1870xff167da2(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$22 */
    public static final Unit m1871xff167da3(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$23 */
    public static final Unit m1872xff167da4(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$24 */
    public static final Unit m1873xff167da5(String str, String str2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        JavaTypeQualifiers javaTypeQualifiers2 = NULLABLE;
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers2);
        function.returns(str, javaTypeQualifiers2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$25 */
    public static final Unit m1874xff167da6(String str, String str2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers);
        function.returns(str, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$26 */
    public static final Unit m1875xff167da7(String str, String str2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        JavaTypeQualifiers javaTypeQualifiers2 = NOT_NULLABLE;
        JavaTypeQualifiers javaTypeQualifiers3 = NULLABLE;
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers3);
        function.returns(str, javaTypeQualifiers3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$28$lambda$27 */
    public static final Unit m1876xff167da8(String str, String str2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        JavaTypeQualifiers javaTypeQualifiers2 = NOT_NULLABLE;
        function.parameter(str, javaTypeQualifiers2);
        JavaTypeQualifiers javaTypeQualifiers3 = NULLABLE;
        function.parameter(str2, javaTypeQualifiers, javaTypeQualifiers2, javaTypeQualifiers2, javaTypeQualifiers3);
        function.returns(str, javaTypeQualifiers3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$34$lambda$29 */
    public static final Unit m1878xb3355805(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$34$lambda$30 */
    public static final Unit m1879xb335581b(String str, String str2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_NULLABLE;
        function.parameter(str, javaTypeQualifiers);
        function.returns(str2, NOT_PLATFORM, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$34$lambda$31 */
    public static final Unit m1880xb335581c(String str, String str2, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NULLABLE);
        function.returns(str2, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$34$lambda$32 */
    public static final Unit m1881xb335581d(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$34$lambda$33 */
    public static final Unit m1882xb335581e(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM, NOT_NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$36$lambda$35 */
    public static final Unit m1883xdcfebda2(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NULLABLE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$38$lambda$37 */
    public static final Unit m1884x6c82326(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$40$lambda$39 */
    public static final Unit m1885x6754327f(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(JvmPrimitiveType.BOOLEAN);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$42$lambda$41 */
    public static final Unit m1886x911d9818(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.parameter(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$44$lambda$43 */
    public static final Unit m1887xbae6fd9c(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$46$lambda$45 */
    public static final Unit m1888xe4b06320(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$48$lambda$47 */
    public static final Unit m1889xe79c8a4(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        JavaTypeQualifiers javaTypeQualifiers = NOT_PLATFORM;
        function.parameter(str, javaTypeQualifiers);
        function.parameter(str, javaTypeQualifiers);
        function.returns(str, javaTypeQualifiers);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$lambda$52$lambda$51$lambda$50$lambda$49 */
    public static final Unit m1890x6f05d7fd(String str, SignatureEnhancementBuilder.ClassEnhancementBuilder.FunctionEnhancementBuilder function) {
        Intrinsics.checkNotNullParameter(function, "$this$function");
        function.returns(str, NOT_PLATFORM);
        return Unit.INSTANCE;
    }
}
