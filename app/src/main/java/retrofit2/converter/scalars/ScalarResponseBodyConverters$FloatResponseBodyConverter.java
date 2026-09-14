package retrofit2.converter.scalars;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes7.dex */
final class ScalarResponseBodyConverters$FloatResponseBodyConverter implements Converter {
    static final ScalarResponseBodyConverters$FloatResponseBodyConverter INSTANCE = new ScalarResponseBodyConverters$FloatResponseBodyConverter();

    ScalarResponseBodyConverters$FloatResponseBodyConverter() {
    }

    @Override // retrofit2.Converter
    public Float convert(ResponseBody responseBody) {
        return Float.valueOf(responseBody.string());
    }
}
