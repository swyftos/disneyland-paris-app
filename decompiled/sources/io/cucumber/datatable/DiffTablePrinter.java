package io.cucumber.datatable;

import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
class DiffTablePrinter extends TablePrinter {
    private final List diffTypes;

    DiffTablePrinter(List list) {
        this.diffTypes = list;
    }

    /* renamed from: io.cucumber.datatable.DiffTablePrinter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$cucumber$datatable$DiffType;

        static {
            int[] iArr = new int[DiffType.values().length];
            $SwitchMap$io$cucumber$datatable$DiffType = iArr;
            try {
                iArr[DiffType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$cucumber$datatable$DiffType[DiffType.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$cucumber$datatable$DiffType[DiffType.INSERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // io.cucumber.datatable.TablePrinter
    protected void printStartIndent(Appendable appendable, int i) throws IOException {
        int i2 = AnonymousClass1.$SwitchMap$io$cucumber$datatable$DiffType[((DiffType) this.diffTypes.get(i)).ordinal()];
        if (i2 == 1) {
            appendable.append("      ");
        } else if (i2 == 2) {
            appendable.append("    - ");
        } else {
            if (i2 != 3) {
                return;
            }
            appendable.append("    + ");
        }
    }
}
