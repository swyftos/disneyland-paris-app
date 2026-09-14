package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.p031io.GifReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class GraphicControlExtension extends ExtensionBlock {
    private int blockSize;
    public int delayTime;
    private byte packedFields;
    public int transparentColorIndex;

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public void receive(GifReader gifReader) throws IOException {
        this.blockSize = gifReader.peek() & 255;
        this.packedFields = gifReader.peek();
        this.delayTime = gifReader.readUInt16();
        this.transparentColorIndex = gifReader.peek() & 255;
        if (gifReader.peek() != 0) {
            throw new GifParser.FormatException();
        }
    }

    public int disposalMethod() {
        return (this.packedFields >> 2) & 7;
    }

    public boolean userInputFlag() {
        return (this.packedFields & 2) == 2;
    }

    public boolean transparencyFlag() {
        return (this.packedFields & 1) == 1;
    }

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public int size() {
        return this.blockSize + 1;
    }
}
