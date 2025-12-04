package ch.qos.logback.classic.boolex;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluatorBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

/* loaded from: classes2.dex */
public class OnMarkerEvaluator extends EventEvaluatorBase<ILoggingEvent> {
    List markerList = new ArrayList();

    public void addMarker(String str) {
        this.markerList.add(str);
    }

    @Override // ch.qos.logback.core.boolex.EventEvaluator
    public boolean evaluate(ILoggingEvent iLoggingEvent) throws NullPointerException, EvaluationException {
        Marker marker = iLoggingEvent.getMarker();
        if (marker == null) {
            return false;
        }
        Iterator it = this.markerList.iterator();
        while (it.hasNext()) {
            if (marker.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }
}
