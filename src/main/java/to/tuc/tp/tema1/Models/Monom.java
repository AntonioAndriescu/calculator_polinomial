package to.tuc.tp.tema1.Models;

import java.text.DecimalFormat;

public class Monom {
    private Number coeficient;
    private final Integer grad;

    public Monom(Number coeficient, Integer grad) {
        this.coeficient = coeficient;
        this.grad = grad;
    }

    public void setCoeficient(Number coeficient) {
        this.coeficient = coeficient;
    }

    public Number getCoeficient() {
        return this.coeficient;
    }

    public Integer getGrad() {
        return this.grad;
    }

    public String convertToString() {
        String afisare = "";
        DecimalFormat df = new DecimalFormat("0.00");

        if(coeficient.doubleValue() == 0) {
            afisare = "";
        } else if(coeficient.intValue() == 1 || coeficient.intValue() == -1) {
            if (grad == 0)
                afisare = "" + 1;
            else
                afisare = "x^" + grad;
        } else if(grad == 0) {
            afisare = "" + df.format(Math.abs(coeficient.doubleValue()));
        } else if(grad == 1) {
            afisare = "" + df.format(Math.abs(coeficient.doubleValue())) + "x";
        } else
            afisare = df.format(Math.abs(coeficient.doubleValue())) + "x^" + grad;

        return afisare;
    }
}
