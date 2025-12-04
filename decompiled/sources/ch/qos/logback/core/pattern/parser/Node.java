package ch.qos.logback.core.pattern.parser;

/* loaded from: classes2.dex */
public class Node {
    Node next;
    final int type;
    final Object value;

    Node(int i, Object obj) {
        this.type = i;
        this.value = obj;
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node node = (Node) obj;
        if (this.type == node.type && ((obj2 = this.value) == null ? node.value == null : obj2.equals(node.value))) {
            Node node2 = this.next;
            if (node2 != null) {
                if (node2.equals(node.next)) {
                    return true;
                }
            } else if (node.next == null) {
                return true;
            }
        }
        return false;
    }

    public Node getNext() {
        return this.next;
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int i = this.type * 31;
        Object obj = this.value;
        return i + (obj != null ? obj.hashCode() : 0);
    }

    String printNext() {
        if (this.next == null) {
            return "";
        }
        return " -> " + this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public String toString() {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.type != 0) {
            string = super.toString();
        } else {
            string = "LITERAL(" + this.value + ")";
        }
        stringBuffer.append(string);
        stringBuffer.append(printNext());
        return stringBuffer.toString();
    }
}
