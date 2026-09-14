package retrofit2.converter.scalars;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes7.dex */
final class ScalarResponseBodyConverters$StringResponseBodyConverter implements Converter {
    static final ScalarResponseBodyConverters$StringResponseBodyConverter INSTANCE = new ScalarResponseBodyConverters$StringResponseBodyConverter();

    ScalarResponseBodyConverters$StringResponseBodyConverter() {
    }

    @Override // retrofit2.Converter
    public String convert(ResponseBody responseBody) {
        return responseBody.string();
    }
}
