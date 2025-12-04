package com.mrousavy.camera.core.types;

import com.mrousavy.camera.core.CodeTypeNotSupportedError;
import com.mrousavy.camera.core.InvalidTypeScriptUnionError;
import com.mrousavy.camera.core.types.JSUnionValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u001a"}, d2 = {"Lcom/mrousavy/camera/core/types/CodeType;", "Lcom/mrousavy/camera/core/types/JSUnionValue;", "", "unionValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUnionValue", "()Ljava/lang/String;", "CODE_128", "CODE_39", "CODE_93", "CODABAR", "EAN_13", "EAN_8", "ITF", "UPC_E", "UPC_A", "QR", "PDF_417", "AZTEC", "DATA_MATRIX", "UNKNOWN", "toBarcodeType", "", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CodeType implements JSUnionValue {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CodeType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private final String unionValue;
    public static final CodeType CODE_128 = new CodeType("CODE_128", 0, "code-128");
    public static final CodeType CODE_39 = new CodeType("CODE_39", 1, "code-39");
    public static final CodeType CODE_93 = new CodeType("CODE_93", 2, "code-93");
    public static final CodeType CODABAR = new CodeType("CODABAR", 3, "codabar");
    public static final CodeType EAN_13 = new CodeType("EAN_13", 4, "ean-13");
    public static final CodeType EAN_8 = new CodeType("EAN_8", 5, "ean-8");
    public static final CodeType ITF = new CodeType("ITF", 6, "itf");
    public static final CodeType UPC_E = new CodeType("UPC_E", 7, "upc-e");
    public static final CodeType UPC_A = new CodeType("UPC_A", 8, "upc-a");
    public static final CodeType QR = new CodeType("QR", 9, "qr");
    public static final CodeType PDF_417 = new CodeType("PDF_417", 10, "pdf-417");
    public static final CodeType AZTEC = new CodeType("AZTEC", 11, "aztec");
    public static final CodeType DATA_MATRIX = new CodeType("DATA_MATRIX", 12, "data-matrix");
    public static final CodeType UNKNOWN = new CodeType("UNKNOWN", 13, "unknown");

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CodeType.values().length];
            try {
                iArr[CodeType.CODE_128.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CodeType.CODE_39.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CodeType.CODE_93.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CodeType.CODABAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CodeType.EAN_13.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CodeType.EAN_8.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CodeType.ITF.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CodeType.UPC_E.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CodeType.UPC_A.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[CodeType.QR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[CodeType.PDF_417.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[CodeType.AZTEC.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[CodeType.DATA_MATRIX.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[CodeType.UNKNOWN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ CodeType[] $values() {
        return new CodeType[]{CODE_128, CODE_39, CODE_93, CODABAR, EAN_13, EAN_8, ITF, UPC_E, UPC_A, QR, PDF_417, AZTEC, DATA_MATRIX, UNKNOWN};
    }

    @NotNull
    public static EnumEntries<CodeType> getEntries() {
        return $ENTRIES;
    }

    private CodeType(String str, int i, String str2) {
        this.unionValue = str2;
    }

    @Override // com.mrousavy.camera.core.types.JSUnionValue
    @NotNull
    public String getUnionValue() {
        return this.unionValue;
    }

    static {
        CodeType[] codeTypeArr$values = $values();
        $VALUES = codeTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(codeTypeArr$values);
        INSTANCE = new Companion(null);
    }

    public final int toBarcodeType() throws CodeTypeNotSupportedError {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 1024;
            case 9:
                return 512;
            case 10:
                return 256;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 16;
            case 14:
                throw new CodeTypeNotSupportedError(getUnionValue());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/mrousavy/camera/core/types/CodeType$Companion;", "Lcom/mrousavy/camera/core/types/JSUnionValue$Companion;", "Lcom/mrousavy/camera/core/types/CodeType;", "<init>", "()V", "fromBarcodeType", "barcodeType", "", "fromUnionValue", "unionValue", "", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements JSUnionValue.Companion<CodeType> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CodeType fromBarcodeType(int barcodeType) {
            if (barcodeType == 1) {
                return CodeType.CODE_128;
            }
            if (barcodeType == 2) {
                return CodeType.CODE_39;
            }
            switch (barcodeType) {
                case 4:
                    return CodeType.CODE_93;
                case 8:
                    return CodeType.CODABAR;
                case 16:
                    return CodeType.DATA_MATRIX;
                case 32:
                    return CodeType.EAN_13;
                case 64:
                    return CodeType.EAN_8;
                case 128:
                    return CodeType.ITF;
                case 256:
                    return CodeType.QR;
                case 512:
                    return CodeType.UPC_A;
                case 1024:
                    return CodeType.UPC_E;
                case 2048:
                    return CodeType.PDF_417;
                case 4096:
                    return CodeType.AZTEC;
                default:
                    return CodeType.UNKNOWN;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.mrousavy.camera.core.types.JSUnionValue.Companion
        @NotNull
        public CodeType fromUnionValue(@Nullable String unionValue) throws InvalidTypeScriptUnionError {
            if (unionValue != null) {
                switch (unionValue.hashCode()) {
                    case -1310519683:
                        if (unionValue.equals("ean-13")) {
                            return CodeType.EAN_13;
                        }
                        break;
                    case -869195177:
                        if (unionValue.equals("code-128")) {
                            return CodeType.CODE_128;
                        }
                        break;
                    case -720296449:
                        if (unionValue.equals("pdf-417")) {
                            return CodeType.PDF_417;
                        }
                        break;
                    case 3617:
                        if (unionValue.equals("qr")) {
                            return CodeType.QR;
                        }
                        break;
                    case 104603:
                        if (unionValue.equals("itf")) {
                            return CodeType.ITF;
                        }
                        break;
                    case 93330745:
                        if (unionValue.equals("aztec")) {
                            return CodeType.AZTEC;
                        }
                        break;
                    case 96272509:
                        if (unionValue.equals("ean-8")) {
                            return CodeType.EAN_8;
                        }
                        break;
                    case 111485180:
                        if (unionValue.equals("upc-a")) {
                            return CodeType.UPC_A;
                        }
                        break;
                    case 111485184:
                        if (unionValue.equals("upc-e")) {
                            return CodeType.UPC_E;
                        }
                        break;
                    case 941726090:
                        if (unionValue.equals("codabar")) {
                            return CodeType.CODABAR;
                        }
                        break;
                    case 941792838:
                        if (unionValue.equals("code-39")) {
                            return CodeType.CODE_39;
                        }
                        break;
                    case 941793018:
                        if (unionValue.equals("code-93")) {
                            return CodeType.CODE_93;
                        }
                        break;
                    case 1350827844:
                        if (unionValue.equals("data-matrix")) {
                            return CodeType.DATA_MATRIX;
                        }
                        break;
                }
            }
            if (unionValue == null) {
                unionValue = "(null)";
            }
            throw new InvalidTypeScriptUnionError("codeType", unionValue);
        }
    }

    public static CodeType valueOf(String str) {
        return (CodeType) Enum.valueOf(CodeType.class, str);
    }

    public static CodeType[] values() {
        return (CodeType[]) $VALUES.clone();
    }
}
