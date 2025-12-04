package ch.qos.logback.core.subst;

import java.io.PrintStream;

/* loaded from: classes2.dex */
public class Node {
    Object defaultPart;
    Node next;
    Object payload;
    Type type;

    /* renamed from: ch.qos.logback.core.subst.Node$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$subst$Node$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$ch$qos$logback$core$subst$Node$Type = iArr;
            try {
                iArr[Type.LITERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$subst$Node$Type[Type.VARIABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    enum Type {
        LITERAL,
        VARIABLE
    }

    public Node(Type type, Object obj) {
        this.type = type;
        this.payload = obj;
    }

    public Node(Type type, Object obj, Object obj2) {
        this.type = type;
        this.payload = obj;
        this.defaultPart = obj2;
    }

    void append(Node node) {
        if (node == null) {
            return;
        }
        while (true) {
            Node node2 = this.next;
            if (node2 == null) {
                this.next = node;
                return;
            }
            this = node2;
        }
    }

    public void dump() {
        PrintStream printStream = System.out;
        printStream.print(toString());
        printStream.print(" -> ");
        Node node = this.next;
        if (node != null) {
            node.dump();
        } else {
            printStream.print(" null");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node node = (Node) obj;
        if (this.type != node.type) {
            return false;
        }
        Object obj2 = this.payload;
        if (obj2 == null ? node.payload != null : !obj2.equals(node.payload)) {
            return false;
        }
        Object obj3 = this.defaultPart;
        if (obj3 == null ? node.defaultPart != null : !obj3.equals(node.defaultPart)) {
            return false;
        }
        Node node2 = this.next;
        return node2 == null ? node.next == null : node2.equals(node.next);
    }

    public int hashCode() {
        Type type = this.type;
        int iHashCode = (type != null ? type.hashCode() : 0) * 31;
        Object obj = this.payload;
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.defaultPart;
        int iHashCode3 = (iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Node node = this.next;
        return iHashCode3 + (node != null ? node.hashCode() : 0);
    }

    void recursive(Node node, StringBuilder sb) {
        while (node != null) {
            sb.append(node.toString());
            sb.append(" --> ");
            node = node.next;
        }
        sb.append("null ");
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public String toString() {
        int i = AnonymousClass1.$SwitchMap$ch$qos$logback$core$subst$Node$Type[this.type.ordinal()];
        if (i == 1) {
            return "Node{type=" + this.type + ", payload='" + this.payload + "'}";
        }
        if (i != 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Object obj = this.defaultPart;
        if (obj != null) {
            recursive((Node) obj, sb2);
        }
        recursive((Node) this.payload, sb);
        String str = "Node{type=" + this.type + ", payload='" + sb.toString() + "'";
        if (this.defaultPart != null) {
            str = str + ", defaultPart=" + sb2.toString();
        }
        return str + '}';
    }
}
