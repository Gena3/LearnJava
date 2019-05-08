package TextAnalyzer;

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}

public abstract class KeywordAnalyzer {

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();
}
