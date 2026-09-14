package io.legere.pdfiumandroid;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1836d2 = {"Lio/legere/pdfiumandroid/FindFlags;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MatchCase", "MatchWholeWord", "Consecutive", "pdfiumandroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public enum FindFlags {
    MatchCase(1),
    MatchWholeWord(2),
    Consecutive(4);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int value;

    @NotNull
    public static EnumEntries<FindFlags> getEntries() {
        return $ENTRIES;
    }

    FindFlags(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
