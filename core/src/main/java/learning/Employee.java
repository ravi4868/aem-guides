package learning;

import java.util.List;

class Employee {

    String name;
    String email;
    List<String> ph;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPh() {
        return ph;
    }

    public void setPh(List<String> ph) {
        this.ph = ph;
    }

    public Employee(String name, String email, List<String> ph) {
        this.name = name;
        this.email = email;
        this.ph = ph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (ph != null ? !ph.equals(employee.ph) : employee.ph != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (ph != null ? ph.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", ph=" + ph +
                '}';
    }
}