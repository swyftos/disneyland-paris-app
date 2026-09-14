package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.p031io.GifReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PlaintTextExtension extends ExtensionBlock {
    private List plainTextData = new ArrayList();

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public int size() {
        return 0;
    }

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public void receive(GifReader gifReader) throws IOException {
        gifReader.peek();
        gifReader.readUInt16();
        gifReader.readUInt16();
        gifReader.readUInt16();
        gifReader.readUInt16();
        gifReader.peek();
        gifReader.peek();
        gifReader.peek();
        gifReader.peek();
        while (true) {
            DataSubBlock dataSubBlockRetrieve = DataSubBlock.retrieve(gifReader);
            if (dataSubBlockRetrieve.isTerminal()) {
                return;
            } else {
                this.plainTextData.add(dataSubBlockRetrieve);
            }
        }
    }
}
