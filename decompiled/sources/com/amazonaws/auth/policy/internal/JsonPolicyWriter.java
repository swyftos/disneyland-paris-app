package com.amazonaws.auth.policy.internal;

import com.amazonaws.auth.policy.Action;
import com.amazonaws.auth.policy.Condition;
import com.amazonaws.auth.policy.Policy;
import com.amazonaws.auth.policy.Principal;
import com.amazonaws.auth.policy.Resource;
import com.amazonaws.auth.policy.Statement;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class JsonPolicyWriter {
    private static final Log log = LogFactory.getLog("com.amazonaws.auth.policy");
    private AwsJsonWriter jsonWriter;
    private final Writer writer;

    private boolean isNotNull(Object obj) {
        return obj != null;
    }

    public JsonPolicyWriter() {
        this.jsonWriter = null;
        StringWriter stringWriter = new StringWriter();
        this.writer = stringWriter;
        this.jsonWriter = JsonUtils.getJsonWriter(stringWriter);
    }

    public String writePolicyToString(Policy policy) throws IOException {
        try {
            if (!isNotNull(policy)) {
                throw new IllegalArgumentException("Policy cannot be null");
            }
            try {
                return jsonStringOf(policy);
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to serialize policy to JSON string: " + e.getMessage(), e);
            }
        } finally {
            try {
                this.writer.close();
            } catch (Exception unused) {
            }
        }
    }

    private String jsonStringOf(Policy policy) throws IOException {
        this.jsonWriter.beginObject();
        writeJsonKeyValue("Version", policy.getVersion());
        if (isNotNull(policy.getId())) {
            writeJsonKeyValue(JsonDocumentFields.POLICY_ID, policy.getId());
        }
        writeJsonArrayStart(JsonDocumentFields.STATEMENT);
        for (Statement statement : policy.getStatements()) {
            this.jsonWriter.beginObject();
            if (isNotNull(statement.getId())) {
                writeJsonKeyValue(JsonDocumentFields.STATEMENT_ID, statement.getId());
            }
            writeJsonKeyValue(JsonDocumentFields.STATEMENT_EFFECT, statement.getEffect().toString());
            List principals = statement.getPrincipals();
            if (isNotNull(principals) && !principals.isEmpty()) {
                writePrincipals(principals);
            }
            List actions = statement.getActions();
            if (isNotNull(actions) && !actions.isEmpty()) {
                writeActions(actions);
            }
            List resources = statement.getResources();
            if (isNotNull(resources) && !resources.isEmpty()) {
                writeResources(resources);
            }
            List conditions = statement.getConditions();
            if (isNotNull(conditions) && !conditions.isEmpty()) {
                writeConditions(conditions);
            }
            this.jsonWriter.endObject();
        }
        writeJsonArrayEnd();
        this.jsonWriter.endObject();
        this.jsonWriter.flush();
        return this.writer.toString();
    }

    private void writeConditions(List list) throws IOException {
        Map mapGroupConditionsByTypeAndKey = groupConditionsByTypeAndKey(list);
        writeJsonObjectStart(JsonDocumentFields.CONDITION);
        for (Map.Entry entry : mapGroupConditionsByTypeAndKey.entrySet()) {
            ConditionsByKey conditionsByKey = (ConditionsByKey) mapGroupConditionsByTypeAndKey.get(entry.getKey());
            writeJsonObjectStart((String) entry.getKey());
            for (String str : conditionsByKey.keySet()) {
                writeJsonArray(str, conditionsByKey.getConditionsByKey(str));
            }
            writeJsonObjectEnd();
        }
        writeJsonObjectEnd();
    }

    private void writeResources(List list) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Resource) it.next()).getId());
        }
        writeJsonArray(JsonDocumentFields.RESOURCE, arrayList);
    }

    private void writeActions(List list) throws IOException {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Action) it.next()).getActionName());
        }
        writeJsonArray(JsonDocumentFields.ACTION, arrayList);
    }

    private void writePrincipals(List list) throws IOException {
        if (list.size() == 1) {
            Principal principal = (Principal) list.get(0);
            Principal principal2 = Principal.All;
            if (principal.equals(principal2)) {
                writeJsonKeyValue(JsonDocumentFields.PRINCIPAL, principal2.getId());
                return;
            }
        }
        writeJsonObjectStart(JsonDocumentFields.PRINCIPAL);
        Map mapGroupPrincipalByScheme = groupPrincipalByScheme(list);
        for (Map.Entry entry : mapGroupPrincipalByScheme.entrySet()) {
            List list2 = (List) mapGroupPrincipalByScheme.get(entry.getKey());
            if (list2.size() == 1) {
                writeJsonKeyValue((String) entry.getKey(), (String) list2.get(0));
            } else {
                writeJsonArray((String) entry.getKey(), list2);
            }
        }
        writeJsonObjectEnd();
    }

    private Map groupPrincipalByScheme(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Principal principal = (Principal) it.next();
            String provider = principal.getProvider();
            if (!map.containsKey(provider)) {
                map.put(provider, new ArrayList());
            }
            ((List) map.get(provider)).add(principal.getId());
        }
        return map;
    }

    static class ConditionsByKey {
        private Map conditionsByKey = new HashMap();

        public List getConditionsByKey(String str) {
            return (List) this.conditionsByKey.get(str);
        }

        public Set keySet() {
            return this.conditionsByKey.keySet();
        }

        public void addValuesToKey(String str, List list) {
            List conditionsByKey = getConditionsByKey(str);
            if (conditionsByKey == null) {
                this.conditionsByKey.put(str, new ArrayList(list));
            } else {
                conditionsByKey.addAll(list);
            }
        }
    }

    private Map groupConditionsByTypeAndKey(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Condition condition = (Condition) it.next();
            String type = condition.getType();
            String conditionKey = condition.getConditionKey();
            if (!map.containsKey(type)) {
                map.put(type, new ConditionsByKey());
            }
            ((ConditionsByKey) map.get(type)).addValuesToKey(conditionKey, condition.getValues());
        }
        return map;
    }

    private void writeJsonArray(String str, List list) throws IOException {
        writeJsonArrayStart(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.jsonWriter.value((String) it.next());
        }
        writeJsonArrayEnd();
    }

    private void writeJsonObjectStart(String str) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.beginObject();
    }

    private void writeJsonObjectEnd() throws IOException {
        this.jsonWriter.endObject();
    }

    private void writeJsonArrayStart(String str) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.beginArray();
    }

    private void writeJsonArrayEnd() throws IOException {
        this.jsonWriter.endArray();
    }

    private void writeJsonKeyValue(String str, String str2) throws IOException {
        this.jsonWriter.name(str);
        this.jsonWriter.value(str2);
    }
}
