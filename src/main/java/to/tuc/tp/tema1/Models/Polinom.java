package to.tuc.tp.tema1.Models;

import java.util.LinkedList;
import java.util.List;

public class Polinom {
    private Integer gradMaxim;
    private List<Monom> polinom;

    public Polinom() {
        gradMaxim = 0;
        polinom = new LinkedList<>();
    }

    public void setPolinom(Polinom polinom) {
        this.gradMaxim = polinom.gradMaxim;
        this.polinom = polinom.polinom;
    }

    public List<Monom> getPolinomList() {
        return polinom;
    }

    public Integer getGradMaxim() {
        return this.gradMaxim;
    }

    public void addMonom(Monom monom) {
        if(monom.getCoeficient().doubleValue() != 0) {
            polinom.add(monom);
            if(monom.getGrad().intValue() > gradMaxim) {
                gradMaxim = monom.getGrad();
            }
        }
    }

    public String polinomToString() {
        StringBuilder afisare = new StringBuilder();
        for(Monom monom : polinom) {
            if(monom.getCoeficient().doubleValue() < 0)
                afisare.append("-");
            else if (monom.getGrad() != gradMaxim)
                afisare.append("+");
            afisare.append(monom.convertToString());
        }
        return afisare.toString();
    }
}
