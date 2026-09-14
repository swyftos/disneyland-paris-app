package expo.modules.kotlin.devtools.cdp;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m1836d2 = {"Lexpo/modules/kotlin/devtools/cdp/JsonSerializable;", "", "toJSONObject", "Lorg/json/JSONObject;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface JsonSerializable {
    @NotNull
    JSONObject toJSONObject();
}
