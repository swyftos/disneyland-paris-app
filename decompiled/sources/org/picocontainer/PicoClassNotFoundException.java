package org.picocontainer;

/* loaded from: classes6.dex */
public class PicoClassNotFoundException extends PicoException {
    public PicoClassNotFoundException(String str, ClassNotFoundException classNotFoundException) {
        super("Class '" + str + "' not found", classNotFoundException);
    }
}
