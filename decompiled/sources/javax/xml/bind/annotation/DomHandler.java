package javax.xml.bind.annotation;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

/* loaded from: classes5.dex */
public interface DomHandler<ElementT, ResultT extends Result> {
    ResultT createUnmarshaller(ValidationEventHandler validationEventHandler);

    ElementT getElement(ResultT resultt);

    Source marshal(ElementT elementt, ValidationEventHandler validationEventHandler);
}
