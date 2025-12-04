package io.cucumber.core.options;

import com.facebook.react.modules.appstate.AppStateModule;
import com.urbanairship.json.JsonPredicate;
import cucumber.api.SnippetType;
import cucumber.runtime.CucumberException;
import cucumber.runtime.order.PickleOrder;
import cucumber.runtime.order.StandardPickleOrders;
import cucumber.util.FixJava;
import cucumber.util.Mapper;
import gherkin.GherkinDialect;
import gherkin.GherkinDialectProvider;
import gherkin.GherkinLanguageConstants;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.core.model.FeaturePath;
import io.cucumber.core.model.FeatureWithLines;
import io.cucumber.core.model.GluePath;
import io.cucumber.core.model.RerunLoader;
import io.cucumber.datatable.DataTable;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
final class RuntimeOptionsParser {
    static String usageText;
    private final RerunLoader rerunLoader;
    private static final Logger log = LoggerFactory.getLogger(RuntimeOptionsParser.class);
    static final String VERSION = ResourceBundle.getBundle("cucumber.version").getString("cucumber-jvm.version");
    private static final Pattern RANDOM_AND_SEED_PATTERN = Pattern.compile("random(?::(\\d+))?");
    private static final Mapper QUOTE_MAPPER = new Mapper() { // from class: io.cucumber.core.options.RuntimeOptionsParser.1
        @Override // cucumber.util.Mapper
        public String map(String str) {
            return '\"' + str + '\"';
        }
    };
    private static final Mapper CODE_KEYWORD_MAPPER = new Mapper() { // from class: io.cucumber.core.options.RuntimeOptionsParser.2
        @Override // cucumber.util.Mapper
        public String map(String str) {
            return str.replaceAll("[\\s',!]", "");
        }
    };

    RuntimeOptionsParser(RerunLoader rerunLoader) {
        this.rerunLoader = rerunLoader;
    }

    RuntimeOptionsBuilder parse(List list) throws NumberFormatException {
        ArrayList arrayList = new ArrayList(list);
        RuntimeOptionsBuilder runtimeOptionsBuilder = new RuntimeOptionsBuilder();
        while (!arrayList.isEmpty()) {
            String strTrim = ((String) arrayList.remove(0)).trim();
            if (strTrim.equals("--help") || strTrim.equals("-h")) {
                printUsage();
                System.exit(0);
            } else if (strTrim.equals("--version") || strTrim.equals("-v")) {
                System.out.println(VERSION);
                System.exit(0);
            } else if (strTrim.equals("--i18n")) {
                System.exit(printI18n((String) arrayList.remove(0)));
            } else if (strTrim.equals("--threads")) {
                int i = Integer.parseInt((String) arrayList.remove(0));
                if (i < 1) {
                    throw new CucumberException("--threads must be > 0");
                }
                runtimeOptionsBuilder.setThreads(i);
            } else if (strTrim.equals("--glue") || strTrim.equals("-g")) {
                runtimeOptionsBuilder.addGlue(GluePath.parse((String) arrayList.remove(0)));
            } else if (strTrim.equals("--tags") || strTrim.equals("-t")) {
                runtimeOptionsBuilder.addTagFilter((String) arrayList.remove(0));
            } else if (strTrim.equals("--plugin") || strTrim.equals("--add-plugin") || strTrim.equals("-p")) {
                runtimeOptionsBuilder.addPluginName((String) arrayList.remove(0), strTrim.equals("--add-plugin"));
            } else if (strTrim.equals("--no-dry-run") || strTrim.equals("--dry-run") || strTrim.equals("-d")) {
                runtimeOptionsBuilder.setDryRun(!strTrim.startsWith("--no-"));
            } else if (strTrim.equals("--no-strict") || strTrim.equals("--strict") || strTrim.equals("-s")) {
                runtimeOptionsBuilder.setStrict(!strTrim.startsWith("--no-"));
            } else if (strTrim.equals("--no-monochrome") || strTrim.equals("--monochrome") || strTrim.equals("-m")) {
                runtimeOptionsBuilder.setMonochrome(!strTrim.startsWith("--no-"));
            } else if (strTrim.equals("--snippets")) {
                String str = (String) arrayList.remove(0);
                if ("underscore".equals(str)) {
                    runtimeOptionsBuilder.setSnippetType(SnippetType.UNDERSCORE);
                } else if ("camelcase".equals(str)) {
                    runtimeOptionsBuilder.setSnippetType(SnippetType.CAMELCASE);
                } else {
                    throw new CucumberException("Unrecognized SnippetType " + str);
                }
            } else if (strTrim.equals("--name") || strTrim.equals("-n")) {
                runtimeOptionsBuilder.addNameFilter(Pattern.compile((String) arrayList.remove(0)));
            } else if (strTrim.startsWith("--junit,")) {
                for (String str2 : strTrim.substring(8).split(",")) {
                    runtimeOptionsBuilder.addJunitOption(str2);
                }
            } else if (strTrim.equals("--wip") || strTrim.equals("-w")) {
                runtimeOptionsBuilder.setWip(true);
            } else if (strTrim.equals("--order")) {
                runtimeOptionsBuilder.setPickleOrder(parsePickleOrder((String) arrayList.remove(0)));
            } else if (strTrim.equals("--count")) {
                int i2 = Integer.parseInt((String) arrayList.remove(0));
                if (i2 < 1) {
                    throw new CucumberException("--count must be > 0");
                }
                runtimeOptionsBuilder.setCount(i2);
            } else {
                if (strTrim.startsWith("-")) {
                    printUsage();
                    throw new CucumberException("Unknown option: " + strTrim);
                }
                if (strTrim.startsWith(GherkinLanguageConstants.TAG_PREFIX)) {
                    runtimeOptionsBuilder.addRerun(this.rerunLoader.load(FeaturePath.parse(strTrim.substring(1))));
                } else if (!strTrim.isEmpty()) {
                    runtimeOptionsBuilder.addFeature(FeatureWithLines.parse(strTrim));
                }
            }
        }
        return runtimeOptionsBuilder;
    }

    private static PickleOrder parsePickleOrder(String str) throws NumberFormatException {
        if ("reverse".equals(str)) {
            return StandardPickleOrders.reverseLexicalUriOrder();
        }
        Matcher matcher = RANDOM_AND_SEED_PATTERN.matcher(str);
        if (matcher.matches()) {
            long jAbs = Math.abs(new Random().nextLong());
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                jAbs = Long.parseLong(strGroup);
            } else {
                log.info("Using random scenario order. Seed: " + jAbs);
            }
            return StandardPickleOrders.random(jAbs);
        }
        throw new CucumberException("Invalid order. Must be either reverse, random or random:<long>");
    }

    private static void printUsage() {
        loadUsageTextIfNeeded();
        System.out.println(usageText);
    }

    static void loadUsageTextIfNeeded() {
        if (usageText == null) {
            try {
                usageText = FixJava.readReader(new InputStreamReader(FixJava.class.getResourceAsStream("/io/cucumber/core/options/USAGE.txt"), "UTF-8"));
            } catch (Exception e) {
                usageText = "Could not load usage text: " + e.toString();
            }
        }
    }

    private static int printI18n(String str) {
        GherkinDialectProvider gherkinDialectProvider = new GherkinDialectProvider();
        List<String> languages = gherkinDialectProvider.getLanguages();
        if (str.equalsIgnoreCase("help")) {
            Iterator<String> it = languages.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            return 0;
        }
        if (languages.contains(str)) {
            return printKeywordsFor(gherkinDialectProvider.getDialect(str, null));
        }
        System.err.println("Unrecognised ISO language code");
        return 1;
    }

    private static int printKeywordsFor(GherkinDialect gherkinDialect) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        addKeywordRow(arrayList, "feature", gherkinDialect.getFeatureKeywords());
        addKeywordRow(arrayList, AppStateModule.APP_STATE_BACKGROUND, gherkinDialect.getBackgroundKeywords());
        addKeywordRow(arrayList, "scenario", gherkinDialect.getScenarioKeywords());
        addKeywordRow(arrayList, "scenario outline", gherkinDialect.getScenarioOutlineKeywords());
        addKeywordRow(arrayList, "examples", gherkinDialect.getExamplesKeywords());
        addKeywordRow(arrayList, "given", gherkinDialect.getGivenKeywords());
        addKeywordRow(arrayList, "when", gherkinDialect.getWhenKeywords());
        addKeywordRow(arrayList, "then", gherkinDialect.getThenKeywords());
        addKeywordRow(arrayList, JsonPredicate.AND_PREDICATE_TYPE, gherkinDialect.getAndKeywords());
        addKeywordRow(arrayList, "but", gherkinDialect.getButKeywords());
        addCodeKeywordRow(arrayList, "given", gherkinDialect.getGivenKeywords());
        addCodeKeywordRow(arrayList, "when", gherkinDialect.getWhenKeywords());
        addCodeKeywordRow(arrayList, "then", gherkinDialect.getThenKeywords());
        addCodeKeywordRow(arrayList, JsonPredicate.AND_PREDICATE_TYPE, gherkinDialect.getAndKeywords());
        addCodeKeywordRow(arrayList, "but", gherkinDialect.getButKeywords());
        DataTable.create(arrayList).print(sb);
        System.out.println(sb.toString());
        return 0;
    }

    private static void addCodeKeywordRow(List list, String str, List list2) {
        ArrayList arrayList = new ArrayList(list2);
        arrayList.remove("* ");
        addKeywordRow(list, str + " (code)", FixJava.map(arrayList, CODE_KEYWORD_MAPPER));
    }

    private static void addKeywordRow(List list, String str, List list2) {
        list.add(Arrays.asList(str, FixJava.join(FixJava.map(list2, QUOTE_MAPPER), ", ")));
    }
}
