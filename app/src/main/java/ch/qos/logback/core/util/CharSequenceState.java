package ch.qos.logback.core.util;

/* JADX INFO: loaded from: classes2.dex */
class CharSequenceState {

    /* JADX INFO: renamed from: c */
    final char f200c;
    int occurrences = 1;

    public CharSequenceState(char c) {
        this.f200c = c;
    }

    void incrementOccurrences() {
        this.occurrences++;
    }
}
