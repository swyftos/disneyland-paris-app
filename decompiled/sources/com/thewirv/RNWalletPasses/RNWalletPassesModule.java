package com.thewirv.RNWalletPasses;

import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class RNWalletPassesModule extends ReactContextBaseJavaModule {
    public RNWalletPassesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "RNWalletPasses";
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map.put("BLACK", 0);
        map.put("BLACK_OUTLINE", 1);
        map2.put("ADD_PASS_BUTTON_STYLE", map);
        map2.put("ADD_PASS_BUTTON_WIDTH", 0);
        map2.put("ADD_PASS_BUTTON_HEIGHT", 0);
        return map2;
    }

    private Intent intentWithContentUri(Uri uri) {
        return new Intent("android.intent.action.VIEW").setDataAndType(uri, "application/vnd.apple.pkpass").addFlags(268435456).addFlags(1);
    }

    @ReactMethod
    public void canAddPasses(Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(intentWithContentUri(Uri.parse(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT)).resolveActivity(getReactApplicationContext().getPackageManager()) != null));
        } catch (Exception e) {
            promise.reject(new JSApplicationCausedNativeException(e.getMessage()));
        }
    }

    @ReactMethod
    public void addPass(String str, String str2, Promise promise) throws IOException {
        try {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            File file = new File(reactApplicationContext.getCacheDir(), UUID.randomUUID().toString() + ".pkpass");
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(Base64.decode(str, 0));
            fileOutputStream.flush();
            fileOutputStream.close();
            reactApplicationContext.startActivity(intentWithContentUri(FileProvider.getUriForFile(reactApplicationContext, str2, file)));
            promise.resolve(null);
        } catch (Exception e) {
            promise.reject(new JSApplicationCausedNativeException(e.getMessage()));
        }
    }
}
