package TextAnalyzer;

import java.util.Arrays;

public class SpamAnalyzer
extends KeywordAnalyzer{
    private String[] keywords;

    public SpamAnalyzer(String[] keywordsIn){
        keywords = Arrays.copyOf(keywordsIn, keywordsIn.length);
    }

    @Override
    protected final Label getLabel(){
        return Label.SPAM;
    }

    @Override
    protected final String[] getKeywords(){
        return keywords;
    }
}
