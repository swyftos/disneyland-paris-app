package ch.qos.logback.core.filter;

import ch.qos.logback.core.boolex.EvaluationException;
import ch.qos.logback.core.boolex.EventEvaluator;
import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes2.dex */
public class EvaluatorFilter<E> extends AbstractMatcherFilter<E> {
    EventEvaluator evaluator;

    @Override // ch.qos.logback.core.filter.Filter
    public FilterReply decide(E e) {
        if (!isStarted() || !this.evaluator.isStarted()) {
            return FilterReply.NEUTRAL;
        }
        try {
            return this.evaluator.evaluate(e) ? this.onMatch : this.onMismatch;
        } catch (EvaluationException e2) {
            addError("Evaluator " + this.evaluator.getName() + " threw an exception", e2);
            return FilterReply.NEUTRAL;
        }
    }

    public EventEvaluator<E> getEvaluator() {
        return this.evaluator;
    }

    public void setEvaluator(EventEvaluator<E> eventEvaluator) {
        this.evaluator = eventEvaluator;
    }

    @Override // ch.qos.logback.core.filter.Filter, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.evaluator != null) {
            super.start();
            return;
        }
        addError("No evaluator set for filter " + getName());
    }
}
