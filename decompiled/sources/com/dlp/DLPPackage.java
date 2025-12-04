package com.dlp;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class DLPPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HeadingManager(reactApplicationContext));
        arrayList.add(new Version(reactApplicationContext));
        arrayList.add(new TCWrapper(reactApplicationContext));
        arrayList.add(new FlagSecure(reactApplicationContext));
        arrayList.add(new BluetoothManager(reactApplicationContext));
        arrayList.add(new DLPModule(reactApplicationContext));
        arrayList.add(new OpenSettings(reactApplicationContext));
        return arrayList;
    }
}
