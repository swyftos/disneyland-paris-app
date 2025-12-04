package com.disney.id.android.version;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.disney.id.android.version.SemanticVersion;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\bJ\u0016\u0010\u0015\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\bJ1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\rH\u0016R\u001c\u0010\u0002\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\bR\u001c\u0010\u0005\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Lcom/disney/id/android/version/LibraryVersion;", "Lcom/disney/id/android/version/SemanticVersion;", "major", "Lkotlin/UInt;", "minor", "patch", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMajor-pVg5ArA", "()I", "I", "getMinor-pVg5ArA", "getPatch-pVg5ArA", "<set-?>", "", "rawVersion", "getRawVersion", "()Ljava/lang/String;", "component1", "component1-pVg5ArA", "component2", "component2-pVg5ArA", "component3", "component3-pVg5ArA", "copy", "copy-zly0blg", "(III)Lcom/disney/id/android/version/LibraryVersion;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LibraryVersion implements SemanticVersion {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int major;
    private final int minor;
    private final int patch;
    private String rawVersion;

    public /* synthetic */ LibraryVersion(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    /* renamed from: copy-zly0blg$default, reason: not valid java name */
    public static /* synthetic */ LibraryVersion m1841copyzly0blg$default(LibraryVersion libraryVersion, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = libraryVersion.major;
        }
        if ((i4 & 2) != 0) {
            i2 = libraryVersion.minor;
        }
        if ((i4 & 4) != 0) {
            i3 = libraryVersion.patch;
        }
        return libraryVersion.m1845copyzly0blg(i, i2, i3);
    }

    /* renamed from: component1-pVg5ArA, reason: not valid java name and from getter */
    public final int getMajor() {
        return this.major;
    }

    /* renamed from: component2-pVg5ArA, reason: not valid java name and from getter */
    public final int getMinor() {
        return this.minor;
    }

    /* renamed from: component3-pVg5ArA, reason: not valid java name and from getter */
    public final int getPatch() {
        return this.patch;
    }

    @NotNull
    /* renamed from: copy-zly0blg, reason: not valid java name */
    public final LibraryVersion m1845copyzly0blg(int major, int minor, int patch) {
        return new LibraryVersion(major, minor, patch, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) other;
        return this.major == libraryVersion.major && this.minor == libraryVersion.minor && this.patch == libraryVersion.patch;
    }

    public int hashCode() {
        return (((UInt.m3006hashCodeimpl(this.major) * 31) + UInt.m3006hashCodeimpl(this.minor)) * 31) + UInt.m3006hashCodeimpl(this.patch);
    }

    private LibraryVersion(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.patch = i3;
    }

    public /* synthetic */ LibraryVersion(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(@NotNull SemanticVersion semanticVersion) {
        return SemanticVersion.DefaultImpls.compareTo(this, semanticVersion);
    }

    @Override // com.disney.id.android.version.SemanticVersion
    @NotNull
    public String getDescription() {
        return SemanticVersion.DefaultImpls.getDescription(this);
    }

    @Override // com.disney.id.android.version.SemanticVersion
    /* renamed from: getMajor-pVg5ArA, reason: not valid java name */
    public int mo1846getMajorpVg5ArA() {
        return this.major;
    }

    @Override // com.disney.id.android.version.SemanticVersion
    /* renamed from: getMinor-pVg5ArA, reason: not valid java name */
    public int mo1847getMinorpVg5ArA() {
        return this.minor;
    }

    @Override // com.disney.id.android.version.SemanticVersion
    /* renamed from: getPatch-pVg5ArA, reason: not valid java name */
    public int mo1848getPatchpVg5ArA() {
        return this.patch;
    }

    @Nullable
    public final String getRawVersion() {
        return this.rawVersion;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/version/LibraryVersion$Companion;", "", "()V", "versionFromString", "Lcom/disney/id/android/version/LibraryVersion;", "stringVersion", "", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLibraryVersion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LibraryVersion.kt\ncom/disney/id/android/version/LibraryVersion$Companion\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,56:1\n429#2:57\n502#2,5:58\n*S KotlinDebug\n*F\n+ 1 LibraryVersion.kt\ncom/disney/id/android/version/LibraryVersion$Companion\n*L\n23#1:57\n23#1:58,5\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final LibraryVersion versionFromString(@NotNull String stringVersion) throws IOException {
            Intrinsics.checkNotNullParameter(stringVersion, "stringVersion");
            StringBuilder sb = new StringBuilder();
            int length = stringVersion.length();
            int uInt = 0;
            for (int i = 0; i < length; i++) {
                char cCharAt = stringVersion.charAt(i);
                if (Character.isDigit(cCharAt) || cCharAt == '.') {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (string.length() == 0) {
                return null;
            }
            List listSplit$default = StringsKt.split$default((CharSequence) string, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
            if (listSplit$default.isEmpty() || ((CharSequence) listSplit$default.get(0)).length() == 0) {
                return null;
            }
            int uInt2 = UStringsKt.toUInt((String) listSplit$default.get(0));
            int uInt3 = (listSplit$default.size() <= 1 || ((CharSequence) listSplit$default.get(1)).length() <= 0) ? 0 : UStringsKt.toUInt((String) listSplit$default.get(1));
            if (listSplit$default.size() > 2 && ((CharSequence) listSplit$default.get(2)).length() > 0) {
                uInt = UStringsKt.toUInt((String) listSplit$default.get(2));
            }
            LibraryVersion libraryVersion = new LibraryVersion(uInt2, uInt3, uInt, defaultConstructorMarker);
            libraryVersion.rawVersion = stringVersion;
            return libraryVersion;
        }
    }

    @NotNull
    public String toString() {
        return getDescription();
    }
}
