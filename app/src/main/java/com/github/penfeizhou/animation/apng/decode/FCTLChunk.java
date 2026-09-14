package com.github.penfeizhou.animation.apng.decode;

import com.github.penfeizhou.animation.apng.p029io.APNGReader;

/* JADX INFO: loaded from: classes3.dex */
class FCTLChunk extends Chunk {

    /* JADX INFO: renamed from: ID */
    static final int f3433ID = Chunk.fourCCToInt("fcTL");
    byte blend_op;
    short delay_den;
    short delay_num;
    byte dispose_op;
    int height;
    int sequence_number;
    int width;
    int x_offset;
    int y_offset;

    FCTLChunk() {
    }

    @Override // com.github.penfeizhou.animation.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) {
        this.sequence_number = aPNGReader.readInt();
        this.width = aPNGReader.readInt();
        this.height = aPNGReader.readInt();
        this.x_offset = aPNGReader.readInt();
        this.y_offset = aPNGReader.readInt();
        this.delay_num = aPNGReader.readShort();
        this.delay_den = aPNGReader.readShort();
        this.dispose_op = aPNGReader.peek();
        this.blend_op = aPNGReader.peek();
    }
}
