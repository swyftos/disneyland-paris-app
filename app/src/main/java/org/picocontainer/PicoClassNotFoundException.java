package org.picocontainer;

/* JADX INFO: loaded from: classes5.dex */
public class PicoClassNotFoundException extends PicoException {
    public PicoClassNotFoundException(String str, ClassNotFoundException classNotFoundException) {
        super("Class '" + str + "' not found", classNotFoundException);
    }
}
