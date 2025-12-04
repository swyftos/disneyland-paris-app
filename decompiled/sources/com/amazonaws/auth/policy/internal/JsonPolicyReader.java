package com.amazonaws.auth.policy.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.policy.Action;
import com.amazonaws.auth.policy.Condition;
import com.amazonaws.auth.policy.Policy;
import com.amazonaws.auth.policy.Principal;
import com.amazonaws.auth.policy.Resource;
import com.amazonaws.auth.policy.Statement;
import com.amazonaws.util.json.AwsJsonReader;
import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class JsonPolicyReader {
    private AwsJsonReader reader;

    public Policy createPolicyFromJsonString(String str) {
        if (str == null) {
            throw new IllegalArgumentException("JSON string cannot be null");
        }
        this.reader = JsonUtils.getJsonReader(new StringReader(str));
        Policy policy = new Policy();
        LinkedList linkedList = new LinkedList();
        try {
            try {
                this.reader.beginObject();
                while (this.reader.hasNext()) {
                    String strNextName = this.reader.nextName();
                    if (JsonDocumentFields.POLICY_ID.equals(strNextName)) {
                        policy.setId(this.reader.nextString());
                    } else if (JsonDocumentFields.STATEMENT.equals(strNextName)) {
                        this.reader.beginArray();
                        while (this.reader.hasNext()) {
                            linkedList.add(statementOf(this.reader));
                        }
                        this.reader.endArray();
                    } else {
                        this.reader.skipValue();
                    }
                }
                this.reader.endObject();
                try {
                    this.reader.close();
                } catch (IOException unused) {
                }
                policy.setStatements(linkedList);
                return policy;
            } catch (Throwable th) {
                try {
                    this.reader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to generate policy object fron JSON string " + e.getMessage(), e);
        }
    }

    private Statement statementOf(AwsJsonReader awsJsonReader) throws IOException {
        Statement statement = new Statement(null);
        awsJsonReader.beginObject();
        while (awsJsonReader.hasNext()) {
            String strNextName = awsJsonReader.nextName();
            if (JsonDocumentFields.STATEMENT_EFFECT.equals(strNextName)) {
                statement.setEffect(Statement.Effect.valueOf(awsJsonReader.nextString()));
            } else if (JsonDocumentFields.STATEMENT_ID.equals(strNextName)) {
                statement.setId(awsJsonReader.nextString());
            } else if (JsonDocumentFields.ACTION.equals(strNextName)) {
                statement.setActions(actionsOf(awsJsonReader));
            } else if (JsonDocumentFields.RESOURCE.equals(strNextName)) {
                statement.setResources(resourcesOf(awsJsonReader));
            } else if (JsonDocumentFields.PRINCIPAL.equals(strNextName)) {
                statement.setPrincipals(principalOf(awsJsonReader));
            } else if (JsonDocumentFields.CONDITION.equals(strNextName)) {
                statement.setConditions(conditionsOf(awsJsonReader));
            } else {
                awsJsonReader.skipValue();
            }
        }
        awsJsonReader.endObject();
        if (statement.getEffect() == null) {
            return null;
        }
        return statement;
    }

    private List actionsOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        if (awsJsonReader.isContainer()) {
            awsJsonReader.beginArray();
            while (awsJsonReader.hasNext()) {
                linkedList.add(new NamedAction(awsJsonReader.nextString()));
            }
            awsJsonReader.endArray();
        } else {
            linkedList.add(new NamedAction(awsJsonReader.nextString()));
        }
        return linkedList;
    }

    private List resourcesOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        if (awsJsonReader.isContainer()) {
            awsJsonReader.beginArray();
            while (awsJsonReader.hasNext()) {
                linkedList.add(new Resource(awsJsonReader.nextString()));
            }
            awsJsonReader.endArray();
        } else {
            linkedList.add(new Resource(awsJsonReader.nextString()));
        }
        return linkedList;
    }

    private List principalOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        if (awsJsonReader.isContainer()) {
            awsJsonReader.beginObject();
            while (awsJsonReader.hasNext()) {
                String strNextName = awsJsonReader.nextName();
                if (awsJsonReader.isContainer()) {
                    awsJsonReader.beginArray();
                    while (awsJsonReader.hasNext()) {
                        linkedList.add(createPrincipal(strNextName, awsJsonReader.nextString()));
                    }
                    awsJsonReader.endArray();
                } else {
                    linkedList.add(createPrincipal(strNextName, awsJsonReader.nextString()));
                }
            }
            awsJsonReader.endObject();
        } else {
            String strNextString = awsJsonReader.nextString();
            if ("*".equals(strNextString)) {
                linkedList.add(Principal.All);
            } else {
                throw new IllegalArgumentException("Invalid principals: " + strNextString);
            }
        }
        return linkedList;
    }

    private Principal createPrincipal(String str, String str2) {
        if (str.equalsIgnoreCase("AWS")) {
            return new Principal(str2);
        }
        if (str.equalsIgnoreCase("Service")) {
            return new Principal(str, str2);
        }
        if (str.equalsIgnoreCase("Federated")) {
            if (Principal.WebIdentityProviders.fromString(str2) != null) {
                return new Principal(Principal.WebIdentityProviders.fromString(str2));
            }
            return new Principal("Federated", str2);
        }
        throw new AmazonClientException("Schema " + str + " is not a valid value for the principal.");
    }

    private List conditionsOf(AwsJsonReader awsJsonReader) throws IOException {
        LinkedList linkedList = new LinkedList();
        awsJsonReader.beginObject();
        while (awsJsonReader.hasNext()) {
            convertConditionRecord(linkedList, awsJsonReader.nextName(), awsJsonReader);
        }
        awsJsonReader.endObject();
        return linkedList;
    }

    private void convertConditionRecord(List list, String str, AwsJsonReader awsJsonReader) throws IOException {
        awsJsonReader.beginObject();
        while (awsJsonReader.hasNext()) {
            String strNextName = awsJsonReader.nextName();
            LinkedList linkedList = new LinkedList();
            if (awsJsonReader.isContainer()) {
                awsJsonReader.beginArray();
                while (awsJsonReader.hasNext()) {
                    linkedList.add(awsJsonReader.nextString());
                }
                awsJsonReader.endArray();
            } else {
                linkedList.add(awsJsonReader.nextString());
            }
            list.add(new Condition().withType(str).withConditionKey(strNextName).withValues(linkedList));
        }
        awsJsonReader.endObject();
    }

    private static class NamedAction implements Action {
        private final String actionName;

        public NamedAction(String str) {
            this.actionName = str;
        }

        @Override // com.amazonaws.auth.policy.Action
        public String getActionName() {
            return this.actionName;
        }
    }
}
