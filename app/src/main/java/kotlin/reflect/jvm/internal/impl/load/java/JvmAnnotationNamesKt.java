package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class JvmAnnotationNamesKt {
    private static final Set BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS;
    private static final Set FORCE_FLEXIBILITY_ANNOTATIONS;
    private static final FqName JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_NONNULL_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_NULLABLE_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME;
    private static final FqName JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME;
    private static final FqName JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME;
    private static final Set MUTABLE_ANNOTATIONS;
    private static final Set NOT_NULL_ANNOTATIONS;
    private static final Set NULLABILITY_ANNOTATIONS;
    private static final Set NULLABLE_ANNOTATIONS;
    private static final Set READ_ONLY_ANNOTATIONS;
    private static final FqName UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    private static final Map javaToKotlinNameMap;

    static {
        FqName fqName = new FqName("org.jspecify.nullness.Nullable");
        JSPECIFY_OLD_NULLABLE_ANNOTATION_FQ_NAME = fqName;
        FqName fqName2 = new FqName("org.jspecify.nullness.NullMarked");
        JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME = fqName2;
        FqName fqName3 = new FqName("org.jspecify.nullness.NullnessUnspecified");
        JSPECIFY_OLD_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = fqName3;
        FqName fqName4 = new FqName("org.jspecify.annotations.NonNull");
        JSPECIFY_NON_NULL_ANNOTATION_FQ_NAME = fqName4;
        FqName fqName5 = new FqName("org.jspecify.annotations.Nullable");
        JSPECIFY_NULLABLE_ANNOTATION_FQ_NAME = fqName5;
        FqName fqName6 = new FqName("org.jspecify.annotations.NullMarked");
        JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME = fqName6;
        FqName fqName7 = new FqName("org.jspecify.annotations.NullnessUnspecified");
        JSPECIFY_NULLNESS_UNSPECIFIED_ANNOTATION_FQ_NAME = fqName7;
        FqName fqName8 = new FqName("org.jspecify.annotations.NullUnmarked");
        JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME = fqName8;
        JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifier");
        JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifierNickname");
        JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.meta.TypeQualifierDefault");
        FqName fqName9 = new FqName("javax.annotation.Nonnull");
        JAVAX_NONNULL_ANNOTATION_FQ_NAME = fqName9;
        FqName fqName10 = new FqName("javax.annotation.Nullable");
        JAVAX_NULLABLE_ANNOTATION_FQ_NAME = fqName10;
        FqName fqName11 = new FqName("javax.annotation.CheckForNull");
        JAVAX_CHECK_FOR_NULL_ANNOTATION_FQ_NAME = fqName11;
        JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.ParametersAreNonnullByDefault");
        JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME = new FqName("javax.annotation.ParametersAreNullableByDefault");
        BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{fqName9, fqName11});
        Set of = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, fqName4, new FqName("android.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.RecentlyNonNull"), new FqName("androidx.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("io.reactivex.annotations.NonNull"), new FqName("io.reactivex.rxjava3.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("lombok.NonNull")});
        NOT_NULL_ANNOTATIONS = of;
        Set of2 = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, fqName, fqName5, fqName10, fqName11, new FqName("android.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.RecentlyNullable"), new FqName("androidx.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("io.reactivex.annotations.Nullable"), new FqName("io.reactivex.rxjava3.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable")});
        NULLABLE_ANNOTATIONS = of2;
        FORCE_FLEXIBILITY_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{fqName3, fqName7});
        NULLABILITY_ANNOTATIONS = SetsKt.plus((Set<? extends FqName>) SetsKt.plus((Set<? extends FqName>) SetsKt.plus((Set<? extends FqName>) SetsKt.plus((Set<? extends FqName>) SetsKt.plus(SetsKt.plus((Set) new LinkedHashSet(), (Iterable) of), (Iterable) of2), fqName9), fqName2), fqName6), fqName8);
        READ_ONLY_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION, JvmAnnotationNames.READONLY_ANNOTATION});
        MUTABLE_ANNOTATIONS = SetsKt.setOf((Object[]) new FqName[]{JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION, JvmAnnotationNames.MUTABLE_ANNOTATION});
        javaToKotlinNameMap = MapsKt.mapOf(TuplesKt.m1842to(JvmAnnotationNames.TARGET_ANNOTATION, StandardNames.FqNames.target), TuplesKt.m1842to(JvmAnnotationNames.RETENTION_ANNOTATION, StandardNames.FqNames.retention), TuplesKt.m1842to(JvmAnnotationNames.DEPRECATED_ANNOTATION, StandardNames.FqNames.deprecated), TuplesKt.m1842to(JvmAnnotationNames.DOCUMENTED_ANNOTATION, StandardNames.FqNames.mustBeDocumented));
        UNDER_MIGRATION_ANNOTATION_FQ_NAME = new FqName("kotlin.annotations.jvm.UnderMigration");
    }

    @NotNull
    public static final FqName getJSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_OLD_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_MARKED_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME() {
        return JSPECIFY_NULL_UNMARKED_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_NICKNAME_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_TYPE_QUALIFIER_DEFAULT_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJAVAX_NONNULL_ANNOTATION_FQ_NAME() {
        return JAVAX_NONNULL_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NONNULL_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final FqName getJAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME() {
        return JAVAX_PARAMETERS_ARE_NULLABLE_BY_DEFAULT_ANNOTATION_FQ_NAME;
    }

    @NotNull
    public static final Set<FqName> getBUILT_IN_TYPE_QUALIFIER_ANNOTATIONS() {
        return BUILT_IN_TYPE_QUALIFIER_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getNOT_NULL_ANNOTATIONS() {
        return NOT_NULL_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getNULLABLE_ANNOTATIONS() {
        return NULLABLE_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getFORCE_FLEXIBILITY_ANNOTATIONS() {
        return FORCE_FLEXIBILITY_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getREAD_ONLY_ANNOTATIONS() {
        return READ_ONLY_ANNOTATIONS;
    }

    @NotNull
    public static final Set<FqName> getMUTABLE_ANNOTATIONS() {
        return MUTABLE_ANNOTATIONS;
    }

    @NotNull
    public static final FqName getUNDER_MIGRATION_ANNOTATION_FQ_NAME() {
        return UNDER_MIGRATION_ANNOTATION_FQ_NAME;
    }
}
