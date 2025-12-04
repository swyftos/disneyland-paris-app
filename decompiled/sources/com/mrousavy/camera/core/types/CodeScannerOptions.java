package com.mrousavy.camera.core.types;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.types.CodeType;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "", "codeTypes", "", "Lcom/mrousavy/camera/core/types/CodeType;", "<init>", "(Ljava/util/List;)V", "getCodeTypes", "()Ljava/util/List;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CodeScannerOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final List codeTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CodeScannerOptions copy$default(CodeScannerOptions codeScannerOptions, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = codeScannerOptions.codeTypes;
        }
        return codeScannerOptions.copy(list);
    }

    @NotNull
    public final List<CodeType> component1() {
        return this.codeTypes;
    }

    @NotNull
    public final CodeScannerOptions copy(@NotNull List<? extends CodeType> codeTypes) {
        Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
        return new CodeScannerOptions(codeTypes);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CodeScannerOptions) && Intrinsics.areEqual(this.codeTypes, ((CodeScannerOptions) other).codeTypes);
    }

    public int hashCode() {
        return this.codeTypes.hashCode();
    }

    @NotNull
    public String toString() {
        return "CodeScannerOptions(codeTypes=" + this.codeTypes + ")";
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/types/CodeScannerOptions$Companion;", "", "<init>", "()V", "fromJSValue", "Lcom/mrousavy/camera/core/types/CodeScannerOptions;", "value", "Lcom/facebook/react/bridge/ReadableMap;", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCodeScannerOptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CodeScannerOptions.kt\ncom/mrousavy/camera/core/types/CodeScannerOptions$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,15:1\n1557#2:16\n1628#2,3:17\n*S KotlinDebug\n*F\n+ 1 CodeScannerOptions.kt\ncom/mrousavy/camera/core/types/CodeScannerOptions$Companion\n*L\n10#1:16\n10#1:17,3\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CodeScannerOptions fromJSValue(@NotNull ReadableMap value) throws InvalidTypeScriptUnionError {
            Intrinsics.checkNotNullParameter(value, "value");
            ReadableArray array = value.getArray("codeTypes");
            if (array == null) {
                throw new InvalidTypeScriptUnionError("codeScanner", value.toString());
            }
            ArrayList<Object> arrayList = array.toArrayList();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (Object obj : arrayList) {
                CodeType.Companion companion = CodeType.INSTANCE;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList2.add(companion.fromUnionValue((String) obj));
            }
            return new CodeScannerOptions(arrayList2);
        }
    }

    public CodeScannerOptions(@NotNull List<? extends CodeType> codeTypes) {
        Intrinsics.checkNotNullParameter(codeTypes, "codeTypes");
        this.codeTypes = codeTypes;
    }

    @NotNull
    public final List<CodeType> getCodeTypes() {
        return this.codeTypes;
    }
}
