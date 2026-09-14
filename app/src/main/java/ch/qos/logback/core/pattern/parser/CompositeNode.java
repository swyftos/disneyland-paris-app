package ch.qos.logback.core.pattern.parser;

/* JADX INFO: loaded from: classes2.dex */
public class CompositeNode extends SimpleKeywordNode {
    Node childNode;

    CompositeNode(String str) {
        super(2, str);
    }

    @Override // ch.qos.logback.core.pattern.parser.SimpleKeywordNode, ch.qos.logback.core.pattern.parser.FormattingNode, ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof CompositeNode)) {
            return false;
        }
        CompositeNode compositeNode = (CompositeNode) obj;
        Node node = this.childNode;
        if (node != null) {
            return node.equals(compositeNode.childNode);
        }
        return compositeNode.childNode == null;
    }

    public Node getChildNode() {
        return this.childNode;
    }

    @Override // ch.qos.logback.core.pattern.parser.SimpleKeywordNode, ch.qos.logback.core.pattern.parser.FormattingNode, ch.qos.logback.core.pattern.parser.Node
    public int hashCode() {
        return super.hashCode();
    }

    public void setChildNode(Node node) {
        this.childNode = node;
    }

    @Override // ch.qos.logback.core.pattern.parser.SimpleKeywordNode, ch.qos.logback.core.pattern.parser.Node
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.childNode != null) {
            str = "CompositeNode(" + this.childNode + ")";
        } else {
            str = "CompositeNode(no child)";
        }
        sb.append(str);
        sb.append(printNext());
        return sb.toString();
    }
}
