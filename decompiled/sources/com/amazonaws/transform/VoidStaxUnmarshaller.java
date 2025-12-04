package com.amazonaws.transform;

/* loaded from: classes2.dex */
public class VoidStaxUnmarshaller<T> implements Unmarshaller<T, StaxUnmarshallerContext> {
    @Override // com.amazonaws.transform.Unmarshaller
    public T unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        while (staxUnmarshallerContext.nextEvent() != 1) {
        }
        return null;
    }
}
