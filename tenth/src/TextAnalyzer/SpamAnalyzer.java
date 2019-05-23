package TextAnalyzer;

import java.util.Arrays;

public class SpamAnalyzer
extends KeywordAnalyzer{
    private final String[] _keywords;

    public SpamAnalyzer(String[] keywords){
        _keywords = Arrays.copyOf(keywords, keywords.length);
    }

    @Override
    public final String[] getKeywords(){
        return _keywords;
    }

    @Override
    public final Label getLabel(){
        return Label.OK;
    }

    @Override
    public final Label processText(String text){
        return Label.OK;
    }
}
