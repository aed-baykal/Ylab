package org.example.dated.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatedMapImpl implements DatedMap {

    private final Map<String, DatedMapElement> storedMap = new HashMap<>();

    @Override
    public void put(String key, String value) {
        DatedMapElement element = new DatedMapElement(new Date(), value);
        storedMap.put(key, element);
    }

    @Override
    public String get(String key) {
        if (storedMap.containsKey(key)) {
            return storedMap.get(key).getValue();
        } else {
            return null;
        }
    }

    @Override
    public boolean containsKey(String key) {
        return storedMap.containsKey(key);
    }

    @Override
    public void remove(String key) {
        storedMap.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return storedMap.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        if (storedMap.containsKey(key)) {
            return storedMap.get(key).getDate();
        } else {
            return null;
        }
    }
}
