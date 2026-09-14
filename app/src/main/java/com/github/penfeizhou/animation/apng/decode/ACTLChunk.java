package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.p029io.APNGReader;

/* JADX INFO: loaded from: classes3.dex */
class ACTLChunk extends Chunk {

    /* JADX INFO: renamed from: ID */
    static final int f3432ID = Chunk.fourCCToInt("acTL");
    int num_frames;
    int num_plays;

    ACTLChunk() {
    }

    @Override // com.github.penfeizhou.animation.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) {
        this.num_frames = aPNGReader.readInt();
        this.num_plays = aPNGReader.readInt();
    }
}
