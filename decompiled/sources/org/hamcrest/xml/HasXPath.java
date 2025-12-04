package org.hamcrest.xml;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.hamcrest.Condition;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.hamcrest.core.IsAnything;
import org.w3c.dom.Node;

/* loaded from: classes6.dex */
public class HasXPath extends TypeSafeDiagnosingMatcher<Node> {
    public static final NamespaceContext NO_NAMESPACE_CONTEXT = null;
    private final XPathExpression compiledXPath;
    private final QName evaluationMode;
    private final Matcher valueMatcher;
    private final String xpathString;
    private static final IsAnything WITH_ANY_CONTENT = new IsAnything("");
    private static final Condition.Step NODE_EXISTS = nodeExists();

    public HasXPath(String str, Matcher<String> matcher) {
        this(str, NO_NAMESPACE_CONTEXT, matcher);
    }

    public HasXPath(String str, NamespaceContext namespaceContext, Matcher<String> matcher) {
        this(str, namespaceContext, matcher, XPathConstants.STRING);
    }

    private HasXPath(String str, NamespaceContext namespaceContext, Matcher matcher, QName qName) {
        this.compiledXPath = compiledXPath(str, namespaceContext);
        this.xpathString = str;
        this.valueMatcher = matcher;
        this.evaluationMode = qName;
    }

    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(Node node, Description description) {
        return evaluated(node, description).and(NODE_EXISTS).matching(this.valueMatcher);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an XML document with XPath ").appendText(this.xpathString);
        if (this.valueMatcher != null) {
            description.appendText(" ").appendDescriptionOf(this.valueMatcher);
        }
    }

    private Condition evaluated(Node node, Description description) {
        try {
            return Condition.matched(this.compiledXPath.evaluate(node, this.evaluationMode), description);
        } catch (XPathExpressionException e) {
            description.appendText(e.getMessage());
            return Condition.notMatched();
        }
    }

    private static Condition.Step nodeExists() {
        return new Condition.Step() { // from class: org.hamcrest.xml.HasXPath.1
            @Override // org.hamcrest.Condition.Step
            public Condition apply(Object obj, Description description) {
                if (obj == null) {
                    description.appendText("xpath returned no results.");
                    return Condition.notMatched();
                }
                return Condition.matched(String.valueOf(obj), description);
            }
        };
    }

    private static XPathExpression compiledXPath(String str, NamespaceContext namespaceContext) {
        try {
            XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
            if (namespaceContext != null) {
                xPathNewXPath.setNamespaceContext(namespaceContext);
            }
            return xPathNewXPath.compile(str);
        } catch (XPathExpressionException e) {
            throw new IllegalArgumentException("Invalid XPath : " + str, e);
        }
    }

    @Factory
    public static Matcher<Node> hasXPath(String str, Matcher<String> matcher) {
        return hasXPath(str, NO_NAMESPACE_CONTEXT, matcher);
    }

    @Factory
    public static Matcher<Node> hasXPath(String str, NamespaceContext namespaceContext, Matcher<String> matcher) {
        return new HasXPath(str, namespaceContext, matcher, XPathConstants.STRING);
    }

    @Factory
    public static Matcher<Node> hasXPath(String str) {
        return hasXPath(str, NO_NAMESPACE_CONTEXT);
    }

    @Factory
    public static Matcher<Node> hasXPath(String str, NamespaceContext namespaceContext) {
        return new HasXPath(str, namespaceContext, WITH_ANY_CONTENT, XPathConstants.NODE);
    }
}
