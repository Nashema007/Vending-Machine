package models;


public class Cash{

    /**
     * Penny = $0.01, Dime = $0.10, Quarter = $0.25
     */
    private int penny;
    private int dime;
    private int quarter;
    private int dollar;
    private int fiveDollar;
    private double wallet;

    public Cash() {

    }

    public double getWallet() {
        return wallet;
    }  

    /**
     * 
     * @return 5 * notes inserted
     */
    public double getFiveDollar() {
        return fiveDollar * 5;
    }

    /**
     * 
     * @return 0.01 * pennies inserted
     */
    public double getPenny() {
        return penny * 0.01;
    }

    /**
     * @return 0.1 * dimes inserted
     */
    public double getDime() {
        return dime * 0.1;
    }

/**
 * 
 * @return 0.25 * quarters inserted
 */
    public double getQuarter() {
        return quarter * 0.25;
    }
    
    /**
     * 
     * @return 1 * notes inserted
     */
    public double getDollar() {
        return dollar;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }  
    public void setDime(int dime) {
        this.dime = dime;
    }  
    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }  
    public void setDollar(int dollar) {
        this.dollar = dollar;
    }
    public void setFiveDollar(int fiveDollar) {
        this.fiveDollar = fiveDollar;
    }

    public void insertCash(String amounts){
        String[] amountList = amounts.split(",");  
             
        setDime(Math.abs(Integer.parseInt(amountList[1])));
        setPenny(Math.abs(Integer.parseInt(amountList[0])));
        setDollar(Math.abs(Integer.parseInt(amountList[3])));
        setFiveDollar(Math.abs(Integer.parseInt(amountList[4])));
        setQuarter(Math.abs(Integer.parseInt(amountList[2])));
      
    }

    /**
     * set value for wallet
     */
public void totalCash (){
    setWallet(getDime()+getDollar()+getFiveDollar()+getPenny()+getQuarter());
}


@Override
public String toString(){

    return "Dime:" + getDime() +
            " Penny: " + getPenny() +
            " Quarrter: " + getQuarter() +
            " 1 Dollar: " + getDollar() +
            " 5 Dollars: " + getFiveDollar();

}


public static void main(String[] args) {
    Cash cash = new Cash();
    cash.toString();
}
}