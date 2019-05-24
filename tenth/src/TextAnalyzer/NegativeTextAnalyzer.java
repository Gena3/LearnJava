package TextAnalyzer;

public class NegativeTextAnalyzer
extends KeywordAnalyzer{
    private String[] keywords;

    public NegativeTextAnalyzer(){
        keywords = new String[3];
        keywords[0] = ":(";
        keywords[1] = "=(";
        keywords[2] = ":|";
    }

    @Override
    protected final Label getLabel(){
        return Label.NEGATIVE_TEXT;
    }

    @Override
    protected final String[] getKeywords(){
        return keywords;
    }
}
