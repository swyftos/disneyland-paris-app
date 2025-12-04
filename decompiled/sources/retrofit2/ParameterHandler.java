package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: classes6.dex */
abstract class ParameterHandler {
    abstract void apply(RequestBuilder requestBuilder, Object obj);

    ParameterHandler() {
    }

    final ParameterHandler iterable() {
        return new ParameterHandler() { // from class: retrofit2.ParameterHandler.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, Iterable iterable) {
                if (iterable == null) {
                    return;
                }
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    ParameterHandler.this.apply(requestBuilder, it.next());
                }
            }
        };
    }

    final ParameterHandler array() {
        return new ParameterHandler() { // from class: retrofit2.ParameterHandler.2
            @Override // retrofit2.ParameterHandler
            void apply(RequestBuilder requestBuilder, Object obj) {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
                }
            }
        };
    }

    static final class RelativeUrl extends ParameterHandler {
        private final Method method;
        private final int p;

        RelativeUrl(Method method, int i) {
            this.method = method;
            this.p = i;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
            }
            requestBuilder.setRelativeUrl(obj);
        }
    }

    static final class Header extends ParameterHandler {
        private final String name;
        private final Converter valueConverter;

        Header(String str, Converter converter) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            String str;
            if (obj == null || (str = (String) this.valueConverter.convert(obj)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, str);
        }
    }

    static final class Path extends ParameterHandler {
        private final boolean encoded;
        private final Method method;
        private final String name;
        private final int p;
        private final Converter valueConverter;

        Path(Method method, int i, String str, Converter converter, boolean z) {
            this.method = method;
            this.p = i;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
            }
            requestBuilder.addPathParam(this.name, (String) this.valueConverter.convert(obj), this.encoded);
        }
    }

    static final class Query extends ParameterHandler {
        private final boolean encoded;
        private final String name;
        private final Converter valueConverter;

        Query(String str, Converter converter, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            String str;
            if (obj == null || (str = (String) this.valueConverter.convert(obj)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, str, this.encoded);
        }
    }

    static final class QueryName extends ParameterHandler {
        private final boolean encoded;
        private final Converter nameConverter;

        QueryName(Converter converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            requestBuilder.addQueryParam((String) this.nameConverter.convert(obj), null, this.encoded);
        }
    }

    static final class QueryMap extends ParameterHandler {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter valueConverter;

        QueryMap(Method method, int i, Converter converter, boolean z) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.valueConverter.convert(value);
                if (str2 == null) {
                    throw Utils.parameterError(this.method, this.p, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.addQueryParam(str, str2, this.encoded);
            }
        }
    }

    static final class HeaderMap extends ParameterHandler {
        private final Method method;
        private final int p;
        private final Converter valueConverter;

        HeaderMap(Method method, int i, Converter converter) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Header map contained null value for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.addHeader(str, (String) this.valueConverter.convert(value));
            }
        }
    }

    static final class Headers extends ParameterHandler {
        private final Method method;
        private final int p;

        Headers(Method method, int i) {
            this.method = method;
            this.p = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, okhttp3.Headers headers) {
            if (headers == null) {
                throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
            }
            requestBuilder.addHeaders(headers);
        }
    }

    static final class Field extends ParameterHandler {
        private final boolean encoded;
        private final String name;
        private final Converter valueConverter;

        Field(String str, Converter converter, boolean z) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            String str;
            if (obj == null || (str = (String) this.valueConverter.convert(obj)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, str, this.encoded);
        }
    }

    static final class FieldMap extends ParameterHandler {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter valueConverter;

        FieldMap(Method method, int i, Converter converter, boolean z) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map contained null value for key '" + str + "'.", new Object[0]);
                }
                String str2 = (String) this.valueConverter.convert(value);
                if (str2 == null) {
                    throw Utils.parameterError(this.method, this.p, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.addFormField(str, str2, this.encoded);
            }
        }
    }

    static final class Part extends ParameterHandler {
        private final Converter converter;
        private final okhttp3.Headers headers;
        private final Method method;
        private final int p;

        Part(Method method, int i, okhttp3.Headers headers, Converter converter) {
            this.method = method;
            this.p = i;
            this.headers = headers;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, (RequestBody) this.converter.convert(obj));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, this.p, "Unable to convert " + obj + " to RequestBody", e);
            }
        }
    }

    static final class RawPart extends ParameterHandler {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    static final class PartMap extends ParameterHandler {
        private final Method method;
        private final int p;
        private final String transferEncoding;
        private final Converter valueConverter;

        PartMap(Method method, int i, Converter converter, String str) {
            this.method = method;
            this.p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map map) {
            if (map == null) {
                throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.p, "Part map contained null value for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.addPart(okhttp3.Headers.of("Content-Disposition", "form-data; name=\"" + str + "\"", "Content-Transfer-Encoding", this.transferEncoding), (RequestBody) this.valueConverter.convert(value));
            }
        }
    }

    static final class Body extends ParameterHandler {
        private final Converter converter;
        private final Method method;
        private final int p;

        Body(Method method, int i, Converter converter) {
            this.method = method;
            this.p = i;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.setBody((RequestBody) this.converter.convert(obj));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, e, this.p, "Unable to convert " + obj + " to RequestBody", new Object[0]);
            }
        }
    }

    static final class Tag extends ParameterHandler {
        final Class cls;

        Tag(Class cls) {
            this.cls = cls;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            requestBuilder.addTag(this.cls, obj);
        }
    }
}
