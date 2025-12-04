package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;

/* loaded from: classes3.dex */
final class TransportImpl implements Transport {
    private final String name;
    private final Encoding payloadEncoding;
    private final Transformer transformer;
    private final TransportContext transportContext;
    private final TransportInternal transportInternal;

    static /* synthetic */ void lambda$send$0(Exception exc) {
    }

    TransportImpl(TransportContext transportContext, String str, Encoding encoding, Transformer transformer, TransportInternal transportInternal) {
        this.transportContext = transportContext;
        this.name = str;
        this.payloadEncoding = encoding;
        this.transformer = transformer;
        this.transportInternal = transportInternal;
    }

    @Override // com.google.android.datatransport.Transport
    public void send(Event event) {
        schedule(event, TransportImpl$$Lambda$1.instance);
    }

    @Override // com.google.android.datatransport.Transport
    public void schedule(Event event, TransportScheduleCallback transportScheduleCallback) {
        this.transportInternal.send(SendRequest.builder().setTransportContext(this.transportContext).setEvent(event).setTransportName(this.name).setTransformer(this.transformer).setEncoding(this.payloadEncoding).build(), transportScheduleCallback);
    }
}
