package TextAnalyzer;

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

interface TextAnalyzer {
    Label processText(String text);
}

public abstract class KeywordAnalyzer
implements TextAnalyzer {

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text){
        Label retLabel = Label.OK;
        for (String test : getKeywords()){
            if (text.contains(test)){
                retLabel = getLabel();
                break;
            }
        }
        return retLabel;
    }
}
