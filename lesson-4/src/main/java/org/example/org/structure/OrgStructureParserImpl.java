package org.example.org.structure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class OrgStructureParserImpl implements OrgStructureParser {

    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        List<Employee> finalEmployeeList = fillInEmployeesFieldsSubordinateAndBoss(parseCsvFile(csvFile));
        for (Employee employee : finalEmployeeList) {
            if (employee.getBossId() == null) {
                return employee;
            }
        }
        return null;
    }

    private List<Employee> parseCsvFile(File csvFile) throws IOException {
        List<Employee> initialEmployeeList = new ArrayList<>();
        List<String> fileLines = Files.readAllLines(csvFile.toPath());
        for (String fileLine : fileLines) {
            String[] splitedText = fileLine.split(";");
            Employee employee = new Employee();
            if (!splitedText[0].equals("id")) {
                if (!splitedText[1].isEmpty()) {
                    employee.setBossId(Long.parseLong(splitedText[1]));
                }
                employee.setId(Long.parseLong(splitedText[0]));
                employee.setName(splitedText[2]);
                employee.setPosition(splitedText[3]);
                initialEmployeeList.add(employee);
            }
        }
        return initialEmployeeList;
    }

    private List<Employee> fillInEmployeesFieldsSubordinateAndBoss(List<Employee> employeeList) { // На входе начальный список сотрудников
        for (Employee boss : employeeList) {
            for (Employee subordinate : employeeList) {
                // Добавка подчиненных в Employee.subordinate
                if (boss.getId().equals(subordinate.getBossId())) {
                    boss.getSubordinate().add(subordinate);
                }
                // Добавка босса в Employee.boss
                if (boss.getBossId() != null && boss.getBossId().equals(subordinate.getId())) {
                    boss.setBoss(subordinate);
                } else if (boss.getBossId() != null && subordinate.getBossId() == null) {
                    boss.setBoss(subordinate);
                }
            }
//            System.out.println(boss); // Для печати развернутого списка сотрудников
        }
        return employeeList;
    }
}
