package com.appdynamics.repacked.gson;

/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.appdynamics.repacked.gson.LongSerializationPolicy.1
        @Override // com.appdynamics.repacked.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l);
        }
    },
    STRING { // from class: com.appdynamics.repacked.gson.LongSerializationPolicy.2
        @Override // com.appdynamics.repacked.gson.LongSerializationPolicy
        public JsonElement serialize(Long l) {
            if (l == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l.toString());
        }
    };

    public abstract JsonElement serialize(Long l);
}
