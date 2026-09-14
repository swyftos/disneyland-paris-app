package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.p029io.APNGReader;

/* JADX INFO: loaded from: classes3.dex */
class FDATChunk extends Chunk {

    /* JADX INFO: renamed from: ID */
    static final int f3434ID = Chunk.fourCCToInt("fdAT");
    int sequence_number;

    FDATChunk() {
    }

    @Override // com.github.penfeizhou.animation.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) {
        this.sequence_number = aPNGReader.readInt();
    }
}
