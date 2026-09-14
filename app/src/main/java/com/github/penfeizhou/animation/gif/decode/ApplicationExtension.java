package com.github.penfeizhou.animation.gif.decode;

import com.github.penfeizhou.animation.gif.p031io.GifReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ApplicationExtension extends ExtensionBlock {
    public String identifier;
    public int loopCount = -1;

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public int size() {
        return 0;
    }

    @Override // com.github.penfeizhou.animation.gif.decode.Block
    public void receive(GifReader gifReader) throws IOException {
        byte bPeek = gifReader.peek();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bPeek; i++) {
            sb.append((char) gifReader.peek());
        }
        String string = sb.toString();
        this.identifier = string;
        if ("NETSCAPE2.0".equals(string)) {
            if ((gifReader.peek() & 255) == 3 && (gifReader.peek() & 255) == 1) {
                this.loopCount = gifReader.readUInt16();
            }
            while (!DataSubBlock.retrieve(gifReader).isTerminal()) {
            }
            return;
        }
        while (!DataSubBlock.retrieve(gifReader).isTerminal()) {
        }
    }
}
