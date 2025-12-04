package retrofit2.converter.scalars;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: classes.dex */
final class ScalarRequestBodyConverter implements Converter {
    static final ScalarRequestBodyConverter INSTANCE = new ScalarRequestBodyConverter();
    private static final MediaType MEDIA_TYPE = MediaType.get("text/plain; charset=UTF-8");

    private ScalarRequestBodyConverter() {
    }

    @Override // retrofit2.Converter
    public RequestBody convert(Object obj) {
        return RequestBody.create(MEDIA_TYPE, String.valueOf(obj));
    }
}
