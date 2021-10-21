package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        String[] subwords = new String[searchWord.length()];

        for(int i = 0; i < subwords.length; i++){
            subwords[i] = searchWord.substring(0, i+1);
        }

        List<List<String>> suggestions = new ArrayList<>(subwords.length);

        for(int i=0; i<subwords.length; i++){
            suggestions.add(new ArrayList<>());

            for(String product : products){
                if(Pattern.matches("^" + subwords[i] + ".*", product)){
                    suggestions.get(i).add(product);
                }
            }

            suggestions.get(i).sort(String.CASE_INSENSITIVE_ORDER);
            if(suggestions.get(i).size() > 3){
                suggestions.set(i, suggestions.get(i).subList(0, 3));
            }
        }

        return suggestions;
    }

}
