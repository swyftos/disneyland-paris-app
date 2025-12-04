package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.spi.NoAutoStartUtil;
import ch.qos.logback.core.joran.util.PropertySetter;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.util.AggregationType;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.OptionHelper;
import java.lang.reflect.InvocationTargetException;
import java.util.Stack;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public class NestedComplexPropertyIA extends ImplicitAction {
    Stack actionDataStack = new Stack();

    /* renamed from: ch.qos.logback.core.joran.action.NestedComplexPropertyIA$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$util$AggregationType;

        static {
            int[] iArr = new int[AggregationType.values().length];
            $SwitchMap$ch$qos$logback$core$util$AggregationType = iArr;
            try {
                iArr[AggregationType.NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$util$AggregationType[AggregationType.AS_BASIC_PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$util$AggregationType[AggregationType.AS_BASIC_PROPERTY_COLLECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$util$AggregationType[AggregationType.AS_COMPLEX_PROPERTY_COLLECTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$util$AggregationType[AggregationType.AS_COMPLEX_PROPERTY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext interpretationContext, String str, Attributes attributes) {
        IADataForComplexProperty iADataForComplexProperty = (IADataForComplexProperty) this.actionDataStack.peek();
        String strSubst = interpretationContext.subst(attributes.getValue("class"));
        try {
            Class<?> clsLoadClass = !OptionHelper.isEmpty(strSubst) ? Loader.loadClass(strSubst, this.context) : iADataForComplexProperty.parentBean.getClassNameViaImplicitRules(iADataForComplexProperty.getComplexPropertyName(), iADataForComplexProperty.getAggregationType(), interpretationContext.getDefaultNestedComponentRegistry());
            if (clsLoadClass == null) {
                iADataForComplexProperty.inError = true;
                addError("Could not find an appropriate class for property [" + str + "]");
                return;
            }
            if (OptionHelper.isEmpty(strSubst)) {
                addInfo("Assuming default type [" + clsLoadClass.getName() + "] for [" + str + "] property");
            }
            iADataForComplexProperty.setNestedComplexProperty(clsLoadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            if (iADataForComplexProperty.getNestedComplexProperty() instanceof ContextAware) {
                ((ContextAware) iADataForComplexProperty.getNestedComplexProperty()).setContext(this.context);
            }
            interpretationContext.pushObject(iADataForComplexProperty.getNestedComplexProperty());
        } catch (Exception e) {
            iADataForComplexProperty.inError = true;
            addError("Could not create component [" + str + "] of type [" + strSubst + "]", e);
        }
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext interpretationContext, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str2;
        IADataForComplexProperty iADataForComplexProperty = (IADataForComplexProperty) this.actionDataStack.pop();
        if (iADataForComplexProperty.inError) {
            return;
        }
        PropertySetter propertySetter = new PropertySetter(iADataForComplexProperty.getNestedComplexProperty());
        propertySetter.setContext(this.context);
        if (propertySetter.computeAggregationType("parent") == AggregationType.AS_COMPLEX_PROPERTY) {
            propertySetter.setComplexProperty("parent", iADataForComplexProperty.parentBean.getObj());
        }
        Object nestedComplexProperty = iADataForComplexProperty.getNestedComplexProperty();
        if ((nestedComplexProperty instanceof LifeCycle) && NoAutoStartUtil.notMarkedWithNoAutoStart(nestedComplexProperty)) {
            ((LifeCycle) nestedComplexProperty).start();
        }
        if (interpretationContext.peekObject() != iADataForComplexProperty.getNestedComplexProperty()) {
            str2 = "The object on the top the of the stack is not the component pushed earlier.";
        } else {
            interpretationContext.popObject();
            int i = AnonymousClass1.$SwitchMap$ch$qos$logback$core$util$AggregationType[iADataForComplexProperty.aggregationType.ordinal()];
            if (i == 4) {
                iADataForComplexProperty.parentBean.addComplexProperty(str, iADataForComplexProperty.getNestedComplexProperty());
                return;
            } else {
                if (i == 5) {
                    iADataForComplexProperty.parentBean.setComplexProperty(str, iADataForComplexProperty.getNestedComplexProperty());
                    return;
                }
                str2 = "Unexpected aggregationType " + iADataForComplexProperty.aggregationType;
            }
        }
        addError(str2);
    }

    @Override // ch.qos.logback.core.joran.action.ImplicitAction
    public boolean isApplicable(ElementPath elementPath, Attributes attributes, InterpretationContext interpretationContext) {
        String strPeekLast = elementPath.peekLast();
        if (interpretationContext.isEmpty()) {
            return false;
        }
        PropertySetter propertySetter = new PropertySetter(interpretationContext.peekObject());
        propertySetter.setContext(this.context);
        AggregationType aggregationTypeComputeAggregationType = propertySetter.computeAggregationType(strPeekLast);
        int i = AnonymousClass1.$SwitchMap$ch$qos$logback$core$util$AggregationType[aggregationTypeComputeAggregationType.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            this.actionDataStack.push(new IADataForComplexProperty(propertySetter, aggregationTypeComputeAggregationType, strPeekLast));
            return true;
        }
        addError("PropertySetter.computeAggregationType returned " + aggregationTypeComputeAggregationType);
        return false;
    }
}
