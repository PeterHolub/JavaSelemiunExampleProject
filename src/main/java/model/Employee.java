package model;

public class Employee {
    private int id;
    private int departmentId;
    private int chiefId;
    private String name;
    private int salary;

    public Employee() {
    }

    public Employee(int id, int departmentId, int chiefId, String name, int salary) {
        this.id = id;
        this.departmentId = departmentId;
        this.chiefId = chiefId;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getChiefId() {
        return chiefId;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setChiefId(int chiefId) {
        this.chiefId = chiefId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + " (id: " + id
                + ", department_id: " + departmentId
                + ", chief_id: " + chiefId
                + ", name: " + name
                + ", salary: " + salary
                + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (departmentId != employee.departmentId) return false;
        if (chiefId != employee.chiefId) return false;
        if (salary != employee.salary) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + departmentId;
        result = 31 * result + chiefId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }
}
