import java.util.ArrayList;
import java.util.List;

/**
 * Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников - каждый
 * сотрудник должен иметь следующие атрибуты:
 * Табельный номер
 * Номер телефона
 * Имя
 * Стаж
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавление нового сотрудника в справочник сотрудников
 */

public class EmployeeDirectory {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    public String findPhoneNumberByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee.getPhoneNumber();
            }
        }
        return null; // Если сотрудник с таким именем не найден
    }

    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null; // Если сотрудник с таким табельным номером не найден
    }

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        Employee employee1 = new Employee(1, "123-456-7890", "Иван", 5);
        Employee employee2 = new Employee(2, "987-654-3210", "Мария", 3);

        directory.addEmployee(employee1);
        directory.addEmployee(employee2);

        List<Employee> experiencedEmployees = directory.findEmployeesByExperience(5);
        if (!experiencedEmployees.isEmpty()) {
            System.out.println("Сотрудники со стажем 5 лет:");
            for (Employee employee : experiencedEmployees) {
                System.out.println(employee.getName());
            }
        } else {
            System.out.println("Сотрудники со стажем 5 лет не найдены.");
        }

        String phoneNumber = directory.findPhoneNumberByName("Мария");
        if (phoneNumber != null) {
            System.out.println("Номер телефона: " + phoneNumber);
        } else {
            System.out.println("Сотрудник не найден.");
        }

        Employee employee = directory.findEmployeeByEmployeeId(2);
        if (employee != null) {
            System.out.println("Сотрудник найден: " + employee.getName());
        } else {
            System.out.println("Сотрудник не найден.");
        }
    }
}



