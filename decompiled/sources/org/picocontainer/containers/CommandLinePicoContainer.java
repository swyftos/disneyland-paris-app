package org.picocontainer.containers;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.List;
import org.picocontainer.Characteristics;
import org.picocontainer.ComponentAdapter;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.PicoContainer;

/* loaded from: classes6.dex */
public class CommandLinePicoContainer extends AbstractDelegatingPicoContainer {
    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
    public <T> T getComponent(Class<T> cls) {
        return null;
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
    public <T> List<ComponentAdapter<T>> getComponentAdapters(Class<T> cls) {
        return null;
    }

    public CommandLinePicoContainer(String str, String[] strArr) {
        this(str, strArr, (PicoContainer) null);
    }

    public CommandLinePicoContainer(String str, String[] strArr, PicoContainer picoContainer) {
        super(new DefaultPicoContainer(picoContainer));
        for (String str2 : strArr) {
            processArgument(str2, str);
        }
    }

    public CommandLinePicoContainer(String str, StringReader stringReader) throws IOException {
        this(str, stringReader, new String[0]);
    }

    public CommandLinePicoContainer(String str, StringReader stringReader, String[] strArr) throws IOException {
        this(str, stringReader, strArr, null);
    }

    public CommandLinePicoContainer(String str, StringReader stringReader, String[] strArr, PicoContainer picoContainer) throws IOException {
        super(new DefaultPicoContainer(picoContainer));
        LineNumberReader lineNumberReader = new LineNumberReader(stringReader);
        for (String line = lineNumberReader.readLine(); line != null; line = lineNumberReader.readLine()) {
            processArgument(line, str);
        }
        for (String str2 : strArr) {
            processArgument(str2, str);
        }
    }

    public CommandLinePicoContainer(String[] strArr) {
        this("=", strArr);
    }

    public CommandLinePicoContainer(String[] strArr, PicoContainer picoContainer) {
        this("=", strArr, picoContainer);
    }

    private void addConfig(String str, Object obj) {
        if (getDelegate().getComponent(str) != null) {
            getDelegate().removeComponent(str);
        }
        getDelegate().addConfig(str, obj);
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer, org.picocontainer.PicoContainer
    public PicoContainer getParent() {
        return new EmptyPicoContainer();
    }

    private void processArgument(String str, String str2) {
        String[] strArrSplit = str.split(str2);
        if (strArrSplit.length == 2) {
            addConfig(strArrSplit[0], strArrSplit[1]);
            return;
        }
        if (strArrSplit.length == 1) {
            addConfig(strArrSplit[0], Characteristics.TRUE);
            return;
        }
        if (strArrSplit.length <= 2) {
            return;
        }
        throw new PicoCompositionException("Argument name'" + str2 + "'value pair '" + str + "' has too many '" + str2 + "' characters");
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer
    public MutablePicoContainer getDelegate() {
        return (MutablePicoContainer) super.getDelegate();
    }

    public void setName(String str) {
        getDelegate().setName(str);
    }

    @Override // org.picocontainer.containers.AbstractDelegatingPicoContainer
    public String toString() {
        return "[CommandLine]:" + super.getDelegate().toString();
    }
}
