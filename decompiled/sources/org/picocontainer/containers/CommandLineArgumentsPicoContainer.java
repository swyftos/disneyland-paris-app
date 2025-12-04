package org.picocontainer.containers;

import java.io.IOException;
import java.io.StringReader;
import org.picocontainer.PicoContainer;

@Deprecated
/* loaded from: classes6.dex */
public final class CommandLineArgumentsPicoContainer extends CommandLinePicoContainer {
    public CommandLineArgumentsPicoContainer(String str, String[] strArr) {
        super(str, strArr);
    }

    public CommandLineArgumentsPicoContainer(String str, String[] strArr, PicoContainer picoContainer) {
        super(str, strArr, picoContainer);
    }

    public CommandLineArgumentsPicoContainer(String str, StringReader stringReader) throws IOException {
        super(str, stringReader);
    }

    public CommandLineArgumentsPicoContainer(String str, StringReader stringReader, String[] strArr) throws IOException {
        super(str, stringReader, strArr);
    }

    public CommandLineArgumentsPicoContainer(String str, StringReader stringReader, String[] strArr, PicoContainer picoContainer) throws IOException {
        super(str, stringReader, strArr, picoContainer);
    }

    public CommandLineArgumentsPicoContainer(String[] strArr) {
        super(strArr);
    }

    public CommandLineArgumentsPicoContainer(String[] strArr, PicoContainer picoContainer) {
        super(strArr, picoContainer);
    }
}
