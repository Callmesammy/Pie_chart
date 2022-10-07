
package Model;


public class Model_chart {

    /**
     * @return the MonthNo
     */
    public int getMonthNo() {
        return MonthNo;
    }

    /**
     * @param MonthNo the MonthNo to set
     */
    public void setMonthNo(int MonthNo) {
        this.MonthNo = MonthNo;
    }

    /**
     * @return the MonthText
     */
    public String getMonthText() {
        return MonthText;
    }

    /**
     * @param MonthText the MonthText to set
     */
    public void setMonthText(String MonthText) {
        this.MonthText = MonthText;
    }
    
    private int MonthNo;
    private String MonthText;

    public Model_chart(int MonthNo, String MonthText) {
        this.MonthNo = MonthNo;
        this.MonthText = MonthText;
    }

    public Model_chart() {
    }

    @Override
    public String toString() {
        return MonthText;
    }
    
    
}
