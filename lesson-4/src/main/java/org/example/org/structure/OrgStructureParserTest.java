package org.example.org.structure;

import java.io.File;
import java.io.IOException;

public class OrgStructureParserTest {
    public static void main(String[] args) throws IOException {
        OrgStructureParser parser = new OrgStructureParserImpl();
        String path = new File("").getAbsoluteFile() + "/lesson-4/src/main/resources/csvFile";
        Employee employee = parser.parseStructure(new File(path));
        System.out.println(employee);
    }

//   Для печати всего списка сотрудников нужно сильно перепахивать весь OrgStructureParserImpl или
//   добавлять геттер списка в интерфейс OrgStructureParser. Чтобы этого не делать (только ради проверки всего списка)
//   я в OrgStructureParserImpl в методе fillInEmployeesFieldsSubordinateAndBoss() закоментил строку System.out.println(boss);
//   Если ее разкоментить, то во время инициализации списка попутно в консоль выведется развернутый список сотрудников.

}
