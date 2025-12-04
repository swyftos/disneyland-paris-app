package gherkin;

import gherkin.Parser;
import gherkin.ParserException;
import gherkin.StringUtils;
import gherkin.ast.Background;
import gherkin.ast.Comment;
import gherkin.ast.DataTable;
import gherkin.ast.DocString;
import gherkin.ast.Examples;
import gherkin.ast.Feature;
import gherkin.ast.GherkinDocument;
import gherkin.ast.Location;
import gherkin.ast.Node;
import gherkin.ast.Scenario;
import gherkin.ast.ScenarioOutline;
import gherkin.ast.Step;
import gherkin.ast.TableCell;
import gherkin.ast.TableRow;
import gherkin.ast.Tag;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class AstBuilder implements Parser.Builder<GherkinDocument> {
    private List comments;
    private Deque stack;

    public AstBuilder() {
        reset();
    }

    @Override // gherkin.Parser.Builder
    public void reset() {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.stack = arrayDeque;
        arrayDeque.push(new AstNode(Parser.RuleType.None));
        this.comments = new ArrayList();
    }

    private AstNode currentNode() {
        return (AstNode) this.stack.peek();
    }

    @Override // gherkin.Parser.Builder
    public void build(Token token) {
        Parser.RuleType ruleTypeCast = Parser.RuleType.cast(token.matchedType);
        if (token.matchedType == Parser.TokenType.Comment) {
            this.comments.add(new Comment(getLocation(token, 0), token.matchedText));
        } else {
            currentNode().add(ruleTypeCast, token);
        }
    }

    @Override // gherkin.Parser.Builder
    public void startRule(Parser.RuleType ruleType) {
        this.stack.push(new AstNode(ruleType));
    }

    @Override // gherkin.Parser.Builder
    public void endRule(Parser.RuleType ruleType) {
        AstNode astNode = (AstNode) this.stack.pop();
        currentNode().add(astNode.ruleType, getTransformedNode(astNode));
    }

    /* renamed from: gherkin.AstBuilder$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$gherkin$Parser$RuleType;

        static {
            int[] iArr = new int[Parser.RuleType.values().length];
            $SwitchMap$gherkin$Parser$RuleType = iArr;
            try {
                iArr[Parser.RuleType.Step.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.DocString.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.DataTable.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.Background.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.Scenario_Definition.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.Examples_Definition.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.Examples_Table.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.Description.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.Feature.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$gherkin$Parser$RuleType[Parser.RuleType.GherkinDocument.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object getTransformedNode(AstNode astNode) {
        listSubList = null;
        List listSubList = null;
        switch (AnonymousClass2.$SwitchMap$gherkin$Parser$RuleType[astNode.ruleType.ordinal()]) {
            case 1:
                Token token = astNode.getToken(Parser.TokenType.StepLine);
                Node node = (Node) astNode.getSingle(Parser.RuleType.DataTable, null);
                if (node == null) {
                    node = (Node) astNode.getSingle(Parser.RuleType.DocString, null);
                }
                return new Step(getLocation(token, 0), token.matchedKeyword, token.matchedText, node);
            case 2:
                Token token2 = astNode.getTokens(Parser.TokenType.DocStringSeparator).get(0);
                String str = token2.matchedText.length() > 0 ? token2.matchedText : null;
                List<Token> tokens = astNode.getTokens(Parser.TokenType.Other);
                StringBuilder sb = new StringBuilder();
                byte b = false;
                for (Token token3 : tokens) {
                    if (b != false) {
                        sb.append("\n");
                    }
                    sb.append(token3.matchedText);
                    b = true;
                }
                return new DocString(getLocation(token2, 0), str, sb.toString());
            case 3:
                return new DataTable(getTableRows(astNode));
            case 4:
                Token token4 = astNode.getToken(Parser.TokenType.BackgroundLine);
                return new Background(getLocation(token4, 0), token4.matchedKeyword, token4.matchedText, getDescription(astNode), getSteps(astNode));
            case 5:
                List tags = getTags(astNode);
                AstNode astNode2 = (AstNode) astNode.getSingle(Parser.RuleType.Scenario, null);
                if (astNode2 != null) {
                    Token token5 = astNode2.getToken(Parser.TokenType.ScenarioLine);
                    return new Scenario(tags, getLocation(token5, 0), token5.matchedKeyword, token5.matchedText, getDescription(astNode2), getSteps(astNode2));
                }
                AstNode astNode3 = (AstNode) astNode.getSingle(Parser.RuleType.ScenarioOutline, null);
                if (astNode3 == null) {
                    throw new RuntimeException("Internal grammar error");
                }
                Token token6 = astNode3.getToken(Parser.TokenType.ScenarioOutlineLine);
                return new ScenarioOutline(tags, getLocation(token6, 0), token6.matchedKeyword, token6.matchedText, getDescription(astNode3), getSteps(astNode3), astNode3.getItems(Parser.RuleType.Examples_Definition));
            case 6:
                List tags2 = getTags(astNode);
                AstNode astNode4 = (AstNode) astNode.getSingle(Parser.RuleType.Examples, null);
                Token token7 = astNode4.getToken(Parser.TokenType.ExamplesLine);
                String description = getDescription(astNode4);
                List list = (List) astNode4.getSingle(Parser.RuleType.Examples_Table, null);
                TableRow tableRow = (list == null || list.isEmpty()) ? null : (TableRow) list.get(0);
                if (list != null && !list.isEmpty()) {
                    listSubList = list.subList(1, list.size());
                }
                return new Examples(getLocation(token7, 0), tags2, token7.matchedKeyword, token7.matchedText, description, tableRow, listSubList);
            case 7:
                return getTableRows(astNode);
            case 8:
                List<Token> tokens2 = astNode.getTokens(Parser.TokenType.Other);
                int size = tokens2.size();
                while (size > 0 && tokens2.get(size - 1).matchedText.matches("\\s*")) {
                    size--;
                }
                return StringUtils.join(new StringUtils.ToString() { // from class: gherkin.AstBuilder.1
                    @Override // gherkin.StringUtils.ToString
                    public String toString(Token token8) {
                        return token8.matchedText;
                    }
                }, "\n", tokens2.subList(0, size));
            case 9:
                Parser.RuleType ruleType = Parser.RuleType.Feature_Header;
                AstNode astNode5 = (AstNode) astNode.getSingle(ruleType, new AstNode(ruleType));
                if (astNode5 == null) {
                    return null;
                }
                List tags3 = getTags(astNode5);
                Token token8 = astNode5.getToken(Parser.TokenType.FeatureLine);
                if (token8 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Background background = (Background) astNode.getSingle(Parser.RuleType.Background, null);
                if (background != null) {
                    arrayList.add(background);
                }
                arrayList.addAll(astNode.getItems(Parser.RuleType.Scenario_Definition));
                String description2 = getDescription(astNode5);
                GherkinDialect gherkinDialect = token8.matchedGherkinDialect;
                if (gherkinDialect == null) {
                    return null;
                }
                return new Feature(tags3, getLocation(token8, 0), gherkinDialect.getLanguage(), token8.matchedKeyword, token8.matchedText, description2, arrayList);
            case 10:
                return new GherkinDocument((Feature) astNode.getSingle(Parser.RuleType.Feature, null), this.comments);
            default:
                return astNode;
        }
    }

    private List getTableRows(AstNode astNode) {
        ArrayList arrayList = new ArrayList();
        for (Token token : astNode.getTokens(Parser.TokenType.TableRow)) {
            arrayList.add(new TableRow(getLocation(token, 0), getCells(token)));
        }
        ensureCellCount(arrayList);
        return arrayList;
    }

    private void ensureCellCount(List list) {
        if (list.isEmpty()) {
            return;
        }
        int size = ((TableRow) list.get(0)).getCells().size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            TableRow tableRow = (TableRow) it.next();
            if (tableRow.getCells().size() != size) {
                throw new ParserException.AstBuilderException("inconsistent cell count within the table", tableRow.getLocation());
            }
        }
    }

    private List getCells(Token token) {
        ArrayList arrayList = new ArrayList();
        for (GherkinLineSpan gherkinLineSpan : token.mathcedItems) {
            arrayList.add(new TableCell(getLocation(token, gherkinLineSpan.column), gherkinLineSpan.text));
        }
        return arrayList;
    }

    private List getSteps(AstNode astNode) {
        return astNode.getItems(Parser.RuleType.Step);
    }

    private Location getLocation(Token token, int i) {
        return i == 0 ? token.location : new Location(token.location.getLine(), i);
    }

    private String getDescription(AstNode astNode) {
        return (String) astNode.getSingle(Parser.RuleType.Description, null);
    }

    private List getTags(AstNode astNode) {
        AstNode astNode2 = (AstNode) astNode.getSingle(Parser.RuleType.Tags, new AstNode(Parser.RuleType.None));
        if (astNode2 == null) {
            return new ArrayList();
        }
        List<Token> tokens = astNode2.getTokens(Parser.TokenType.TagLine);
        ArrayList arrayList = new ArrayList();
        for (Token token : tokens) {
            for (GherkinLineSpan gherkinLineSpan : token.mathcedItems) {
                arrayList.add(new Tag(getLocation(token, gherkinLineSpan.column), gherkinLineSpan.text));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // gherkin.Parser.Builder
    public GherkinDocument getResult() {
        return (GherkinDocument) currentNode().getSingle(Parser.RuleType.GherkinDocument, null);
    }
}
