package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.p031io.GifReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class LogicalScreenDescriptor implements Block {
    public byte bgColorIndex;
    byte flag;
    byte radio;
    public int screenHeight;
    public int screenWidth;

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public int size() {
        return 7;
    }

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public void receive(GifReader gifReader) throws IOException {
        this.screenWidth = gifReader.readUInt16();
        this.screenHeight = gifReader.readUInt16();
        this.flag = gifReader.peek();
        this.bgColorIndex = gifReader.peek();
        this.radio = gifReader.peek();
    }

    public boolean gColorTableFlag() {
        return (this.flag & 128) == 128;
    }

    public int colorResolution() {
        return ((this.flag & 112) >> 4) + 1;
    }

    public boolean sortFlag() {
        return (this.flag & 8) == 8;
    }

    public int gColorTableSize() {
        return 2 << (this.flag & 7);
    }
}
