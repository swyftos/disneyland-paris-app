package com.disney.p026id.android.version;

import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\f\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\r\u0010\t\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, m1836d2 = {"Lcom/disney/id/android/version/SemanticVersion;", "", "description", "", "getDescription", "()Ljava/lang/String;", "major", "Lkotlin/UInt;", "getMajor-pVg5ArA", "()I", "minor", "getMinor-pVg5ArA", "patch", "getPatch-pVg5ArA", "compareTo", "", ETCPaymentMethod.OTHER, "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface SemanticVersion extends Comparable<SemanticVersion> {
    int compareTo(@NotNull SemanticVersion other);

    @NotNull
    String getDescription();

    /* JADX INFO: renamed from: getMajor-pVg5ArA */
    int mo4084getMajorpVg5ArA();

    /* JADX INFO: renamed from: getMinor-pVg5ArA */
    int mo4085getMinorpVg5ArA();

    /* JADX INFO: renamed from: getPatch-pVg5ArA */
    int mo4086getPatchpVg5ArA();

    @Metadata(m1837k = 3, m1838mv = {1, 9, 0}, m1840xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static String getDescription(@NotNull SemanticVersion semanticVersion) {
            return UInt.m5316toStringimpl(semanticVersion.mo4084getMajorpVg5ArA()) + InstructionFileId.DOT + UInt.m5316toStringimpl(semanticVersion.mo4085getMinorpVg5ArA()) + InstructionFileId.DOT + UInt.m5316toStringimpl(semanticVersion.mo4086getPatchpVg5ArA());
        }

        public static int compareTo(@NotNull SemanticVersion semanticVersion, @NotNull SemanticVersion other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (semanticVersion.mo4084getMajorpVg5ArA() != other.mo4084getMajorpVg5ArA()) {
                return Integer.compareUnsigned(semanticVersion.mo4084getMajorpVg5ArA(), other.mo4084getMajorpVg5ArA()) > 0 ? 1 : -1;
            }
            if (semanticVersion.mo4085getMinorpVg5ArA() != other.mo4085getMinorpVg5ArA()) {
                return Integer.compareUnsigned(semanticVersion.mo4085getMinorpVg5ArA(), other.mo4085getMinorpVg5ArA()) > 0 ? 1 : -1;
            }
            if (semanticVersion.mo4086getPatchpVg5ArA() != other.mo4086getPatchpVg5ArA()) {
                return Integer.compareUnsigned(semanticVersion.mo4086getPatchpVg5ArA(), other.mo4086getPatchpVg5ArA()) > 0 ? 1 : -1;
            }
            return 0;
        }
    }
}
