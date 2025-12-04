package com.reactlibrary.sqlcipher;

import android.app.Activity;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes4.dex */
public class SqlcipherPluginPackage implements ReactPackage {
    public SqlcipherPluginPackage(Activity activity) {
        this();
    }

    public SqlcipherPluginPackage() {
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        SQLiteDatabase.loadLibs(reactApplicationContext);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SqlcipherPlugin(reactApplicationContext));
        return arrayList;
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
