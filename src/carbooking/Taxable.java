 
package carbooking;
 
public interface Taxable {
    
    //count the price with tax in ksa:
    public static final double TAX = 0.15; 
    public abstract double totalPriceCalculation();
}
