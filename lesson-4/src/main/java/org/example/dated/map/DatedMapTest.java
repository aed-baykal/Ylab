package org.example.dated.map;

public class DatedMapTest {
    public static void main(String[] args) {
        DatedMap map = new DatedMapImpl();
        map.put("1", "ОДИН");
        map.put("2", "ДВА");
        map.put("3", "ОДИН");
        map.put("4", "ДВА");
        map.put("5", "ТРИ");
        for (String key : map.keySet()) {
            System.out.println("Ключ " + key + " значение " + map.get(key) +
                    " Последняя дата добавления " + map.getKeyLastInsertionDate(key));
        }
        System.out.println("Содержится ли значение по ключу 3? " + map.containsKey("3") +
                " значение " + map.get("3"));
        map.remove("3");
        System.out.println("Содержится ли значение по ключу 3 после удаления? " + map.containsKey("3") +
                " значение " + map.get("3"));
        System.out.println("Список ключей " + map.keySet());
    }
}
