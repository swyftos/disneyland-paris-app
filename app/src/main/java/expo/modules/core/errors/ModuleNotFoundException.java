package expo.modules.core.errors;

import expo.modules.core.interfaces.CodedThrowable;

/* JADX INFO: loaded from: classes5.dex */
public class ModuleNotFoundException extends CodedException implements CodedThrowable {
    public ModuleNotFoundException(String str) {
        super("Module '" + str + "' not found. Are you sure all modules are linked correctly?");
    }

    @Override // expo.modules.core.errors.CodedException, expo.modules.core.interfaces.CodedThrowable
    public String getCode() {
        return "E_MODULE_NOT_FOUND";
    }
}
