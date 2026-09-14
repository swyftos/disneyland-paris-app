package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.p031io.GifReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class DataSubBlock implements Block {
    public static final DataSubBlock sBlockTerminal = new DataSubBlock(0);
    private final int blockSize;
    private int offset;

    public DataSubBlock(int i) {
        this.blockSize = i;
    }

    public static DataSubBlock retrieve(GifReader gifReader) throws IOException {
        int iPeek = gifReader.peek() & 255;
        if (iPeek == 0) {
            return sBlockTerminal;
        }
        DataSubBlock dataSubBlock = new DataSubBlock(iPeek);
        dataSubBlock.offset = gifReader.position();
        dataSubBlock.receive(gifReader);
        return dataSubBlock;
    }

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public void receive(GifReader gifReader) throws IOException {
        gifReader.skip(this.blockSize);
    }

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public int size() {
        return this.blockSize + 1;
    }

    public boolean isTerminal() {
        return this == sBlockTerminal;
    }
}
