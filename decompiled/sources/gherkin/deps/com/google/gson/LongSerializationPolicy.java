package gherkin.deps.com.google.gson;

/* loaded from: classes5.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: gherkin.deps.com.google.gson.LongSerializationPolicy.1
        @Override // gherkin.deps.com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive((Number) l);
        }
    },
    STRING { // from class: gherkin.deps.com.google.gson.LongSerializationPolicy.2
        @Override // gherkin.deps.com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive(String.valueOf(l));
        }
    };

    public abstract JsonElement serialize(Long l);
}
