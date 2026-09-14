package com.github.penfeizhou.animation.webp.decode;

import com.github.penfeizhou.animation.webp.p033io.WebPReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ANMFChunk extends BaseChunk {

    /* JADX INFO: renamed from: ID */
    static final int f3441ID = BaseChunk.fourCCToInt("ANMF");
    ALPHChunk alphChunk;
    byte flags;
    int frameDuration;
    int frameHeight;
    int frameWidth;
    int frameX;
    int frameY;
    VP8Chunk vp8Chunk;
    VP8LChunk vp8LChunk;

    @Override // com.github.penfeizhou.animation.webp.decode.BaseChunk
    void innerParse(WebPReader webPReader) throws IOException {
        int iAvailable = webPReader.available();
        this.frameX = webPReader.getUInt24();
        this.frameY = webPReader.getUInt24();
        this.frameWidth = webPReader.get1Based();
        this.frameHeight = webPReader.get1Based();
        this.frameDuration = webPReader.getUInt24();
        this.flags = webPReader.peek();
        long j = iAvailable - this.payloadSize;
        while (webPReader.available() > j) {
            BaseChunk chunk = WebPParser.parseChunk(webPReader);
            if (chunk instanceof ALPHChunk) {
                this.alphChunk = (ALPHChunk) chunk;
            } else if (chunk instanceof VP8Chunk) {
                this.vp8Chunk = (VP8Chunk) chunk;
            } else if (chunk instanceof VP8LChunk) {
                this.vp8LChunk = (VP8LChunk) chunk;
            }
        }
    }

    boolean blendingMethod() {
        return (this.flags & 2) == 2;
    }

    boolean disposalMethod() {
        return (this.flags & 1) == 1;
    }
}
