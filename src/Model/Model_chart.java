
package Model;


public class Model_chart {

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    private int salary;
    private String last_name;

    public Model_chart(int salary, String last_name) {
        this.salary = salary;
        this.last_name = last_name;
    }

    public Model_chart() {
    }
    
}
