package org.example.transliterator;

import java.util.HashMap;
import java.util.Map;

public class TransliteratorImpl implements Transliterator {

    private final Map<Character, String> transliteratorRules = new HashMap<>();
    private final String[] translit = {"A", "B", "V", "G", "D", "E", "ZH", "Z",
            "I", "I", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "KH",
            "TS", "CH", "SH", "SHCH", "IE", "Y", "", "E", "IU", "IA"};

    @Override
    public String transliterate(String source) {
        transliteratorRulesInitializer();
        StringBuilder output = new StringBuilder();
        for (char letter : source.toCharArray()) {
            if (transliteratorRules.containsKey(letter)) {
                output.append(transliteratorRules.get(letter));
            } else {
                output.append(letter);
            }
        }
        return output.toString();
    }

    private void transliteratorRulesInitializer() {
        int i = 0;
        for (char letter = 'А'; letter <= 'Я'; letter++) {
            transliteratorRules.put(letter, translit[i]);
            i++;
        }
        transliteratorRules.put('Ё', translit[5]);
    }
}
