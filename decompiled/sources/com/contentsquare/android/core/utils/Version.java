package com.contentsquare.android.core.utils;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/contentsquare/android/core/utils/Version;", "", "()V", "components", "", "Lcom/contentsquare/android/core/utils/NumberWithPattern;", "modifier", "compareTo", "", "version", "operator", "Lcom/contentsquare/android/core/utils/RangeOperator;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "init", "", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class Version {

    @NotNull
    private List<NumberWithPattern> components = CollectionsKt.emptyList();

    @Nullable
    private NumberWithPattern modifier;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static NumberWithPattern zeroNumber = NumberWithPattern.INSTANCE.obtain("0");

    @NotNull
    private static Recycler<Version> recycler = new Recycler<>();

    @NotNull
    private static final InstanceCreator<Version> versionInstanceCreator = new InstanceCreator() { // from class: com.contentsquare.android.core.utils.Version$$ExternalSyntheticLambda0
        @Override // com.contentsquare.android.core.utils.InstanceCreator
        public final Object create() {
            return Version.versionInstanceCreator$lambda$0();
        }
    };

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/contentsquare/android/core/utils/Version$Companion;", "", "()V", "recycler", "Lcom/contentsquare/android/core/utils/Recycler;", "Lcom/contentsquare/android/core/utils/Version;", "versionInstanceCreator", "Lcom/contentsquare/android/core/utils/InstanceCreator;", "zeroNumber", "Lcom/contentsquare/android/core/utils/NumberWithPattern;", "from", "version", "", "obtain", "recycle", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nVersionMatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionMatcher.kt\ncom/contentsquare/android/core/utils/Version$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,251:1\n1#2:252\n1549#3:253\n1620#3,3:254\n1855#3,2:257\n*S KotlinDebug\n*F\n+ 1 VersionMatcher.kt\ncom/contentsquare/android/core/utils/Version$Companion\n*L\n144#1:253\n144#1:254,3\n156#1:257,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Version from(String version) {
            Intrinsics.checkNotNullParameter(version, "version");
            List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.trim(version).toString(), new String[]{"-"}, false, 2, 2, (Object) null);
            String str = (String) CollectionsKt.getOrNull(listSplit$default, 1);
            NumberWithPattern numberWithPatternObtain = str != null ? NumberWithPattern.INSTANCE.obtain(str) : null;
            List listSplit$default2 = StringsKt.split$default((CharSequence) listSplit$default.get(0), new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
            Iterator it = listSplit$default2.iterator();
            while (it.hasNext()) {
                arrayList.add(NumberWithPattern.INSTANCE.obtain((String) it.next()));
            }
            Version versionObtain = obtain();
            versionObtain.init(arrayList, numberWithPatternObtain);
            return versionObtain;
        }

        @NotNull
        public final Version obtain() {
            return (Version) Version.recycler.obtain(Version.versionInstanceCreator);
        }

        public final void recycle(Version version) {
            Intrinsics.checkNotNullParameter(version, "version");
            Iterator it = version.components.iterator();
            while (it.hasNext()) {
                NumberWithPattern.INSTANCE.recycle((NumberWithPattern) it.next());
            }
            NumberWithPattern numberWithPattern = version.modifier;
            if (numberWithPattern != null) {
                NumberWithPattern.INSTANCE.recycle(numberWithPattern);
            }
            Version.recycler.recycle(version);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Version() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Version versionInstanceCreator$lambda$0() {
        return new Version();
    }

    public final int compareTo(Version version, RangeOperator operator) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(operator, "operator");
        int iMax = Math.max(this.components.size(), version.components.size());
        for (int i = 0; i < iMax; i++) {
            NumberWithPattern numberWithPattern = (NumberWithPattern) CollectionsKt.getOrNull(this.components, i);
            if (numberWithPattern == null) {
                numberWithPattern = zeroNumber;
            }
            NumberWithPattern numberWithPattern2 = (NumberWithPattern) CollectionsKt.getOrNull(version.components, i);
            if (numberWithPattern2 == null) {
                numberWithPattern2 = zeroNumber;
            }
            if (!Intrinsics.areEqual(numberWithPattern, numberWithPattern2)) {
                return numberWithPattern.compareTo(numberWithPattern2, operator);
            }
        }
        NumberWithPattern numberWithPattern3 = this.modifier;
        if (numberWithPattern3 == null) {
            numberWithPattern3 = zeroNumber;
        }
        NumberWithPattern numberWithPattern4 = version.modifier;
        if (numberWithPattern4 == null) {
            numberWithPattern4 = zeroNumber;
        }
        return numberWithPattern3.compareTo(numberWithPattern4, operator);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Version)) {
            return super.equals(other);
        }
        Version version = (Version) other;
        return Intrinsics.areEqual(version.components, this.components) && Intrinsics.areEqual(version.modifier, this.modifier);
    }

    public int hashCode() {
        int iHashCode = this.components.hashCode() * 31;
        NumberWithPattern numberWithPattern = this.modifier;
        return iHashCode + (numberWithPattern != null ? numberWithPattern.hashCode() : 0);
    }

    public final void init(List<NumberWithPattern> components, NumberWithPattern modifier) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
        this.modifier = modifier;
    }
}
