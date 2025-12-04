package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* loaded from: classes4.dex */
public class Event<T> {
    private final Object payload;
    private final Class type;

    public Event(Class<T> cls, T t) {
        this.type = (Class) Preconditions.checkNotNull(cls);
        this.payload = Preconditions.checkNotNull(t);
    }

    public Class<T> getType() {
        return this.type;
    }

    public T getPayload() {
        return (T) this.payload;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.type, this.payload);
    }
}
