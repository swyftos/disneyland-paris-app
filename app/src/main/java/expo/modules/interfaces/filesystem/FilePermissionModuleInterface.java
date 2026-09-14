package expo.modules.interfaces.filesystem;

import android.content.Context;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes5.dex */
public interface FilePermissionModuleInterface {
    EnumSet<Permission> getPathPermissions(Context context, String str);
}
