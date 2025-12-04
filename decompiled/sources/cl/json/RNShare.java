package cl.json;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class RNShare extends NativeRNShareSpec {
    private final RNShareImpl delegate;

    public RNShare(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.delegate = new RNShareImpl(reactApplicationContext);
    }

    @Override // cl.json.NativeRNShareSpec, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "RNShare";
    }

    @Override // cl.json.NativeRNShareSpec
    public Map<String, Object> getTypedExportedConstants() {
        return this.delegate.getConstants();
    }

    @Override // cl.json.NativeRNShareSpec
    public void open(ReadableMap readableMap, Promise promise) {
        this.delegate.open(readableMap, promise);
    }

    @Override // cl.json.NativeRNShareSpec
    public void shareSingle(ReadableMap readableMap, Promise promise) {
        this.delegate.shareSingle(readableMap, promise);
    }

    @Override // cl.json.NativeRNShareSpec
    public void isPackageInstalled(String str, Promise promise) {
        this.delegate.isPackageInstalled(str, promise);
    }

    @Override // cl.json.NativeRNShareSpec
    public void isBase64File(String str, Promise promise) {
        this.delegate.isBase64File(str, promise);
    }
}
