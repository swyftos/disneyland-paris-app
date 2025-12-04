package javax.xml.bind.annotation;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class W3CDomHandler implements DomHandler<Element, DOMResult> {
    private DocumentBuilder builder;

    public W3CDomHandler() {
        this.builder = null;
    }

    public W3CDomHandler(DocumentBuilder documentBuilder) {
        if (documentBuilder == null) {
            throw new IllegalArgumentException();
        }
        this.builder = documentBuilder;
    }

    public DocumentBuilder getBuilder() {
        return this.builder;
    }

    public void setBuilder(DocumentBuilder documentBuilder) {
        this.builder = documentBuilder;
    }

    @Override // javax.xml.bind.annotation.DomHandler
    public DOMResult createUnmarshaller(ValidationEventHandler validationEventHandler) {
        if (this.builder == null) {
            return new DOMResult();
        }
        return new DOMResult(this.builder.newDocument());
    }

    @Override // javax.xml.bind.annotation.DomHandler
    public Element getElement(DOMResult dOMResult) {
        Node node = dOMResult.getNode();
        if (node instanceof Document) {
            return ((Document) node).getDocumentElement();
        }
        if (node instanceof Element) {
            return (Element) node;
        }
        if (node instanceof DocumentFragment) {
            return (Element) node.getChildNodes().item(0);
        }
        throw new IllegalStateException(node.toString());
    }

    @Override // javax.xml.bind.annotation.DomHandler
    public Source marshal(Element element, ValidationEventHandler validationEventHandler) {
        return new DOMSource(element);
    }
}
