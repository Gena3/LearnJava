package TextAnalyzer;

import java.util.Arrays;

public class SpamAnalyzer
extends KeywordAnalyzer
implements TextAnalyzer{
    private final String[] _keywords;

    public SpamAnalyzer(String[] keywords){
        _keywords = Arrays.copyOf(keywords, keywords.length);
    }

    public final String[] getKeywords(){
        return _keywords;
    }

    public final Label getLabel(){
        return Label.OK;
    }

    public final Label processText(String text){

        return Label.OK;
    }
}
