package to.tuc.tp.tema1.Logic;

import to.tuc.tp.tema1.Models.Monom;
import to.tuc.tp.tema1.Models.Polinom;

public class PolinomOP {

    public static Polinom add(Polinom p1, Polinom p2) {
        Polinom rezultat = new Polinom();

        int gradMaxim = 0;
        if(p1.getGradMaxim() > p2.getGradMaxim())
            gradMaxim = p1.getGradMaxim();
        else
            gradMaxim = p2.getGradMaxim();

        for(int i = gradMaxim; i >= 0; i--) {
            Monom m = new Monom(0, i);

            for(Monom aux : p1.getPolinomList()) {
                if(aux.getGrad() == i)  {
                    m.setCoeficient(m.getCoeficient().doubleValue() + aux.getCoeficient().doubleValue());
                }
            }
            for(Monom aux2 : p2.getPolinomList()) {
                if(aux2.getGrad() == i)  {
                    m.setCoeficient(m.getCoeficient().doubleValue() + aux2.getCoeficient().doubleValue());
                }
            }
            rezultat.addMonom(m);
        }
        return rezultat;
    }

    public static Polinom sub(Polinom p1, Polinom p2) {
        Polinom rezultat = new Polinom();

        int gradMaxim = 0;
        if(p1.getGradMaxim() > p2.getGradMaxim())
            gradMaxim = p1.getGradMaxim();
        else
            gradMaxim = p2.getGradMaxim();

        for(int i = gradMaxim; i >= 0; i--) {
            Monom m = new Monom(0, i);
            for(Monom aux : p1.getPolinomList()) {
                if(aux.getGrad() == i)  {
                    m.setCoeficient(m.getCoeficient().doubleValue() + aux.getCoeficient().doubleValue());
                }
            }
            for(Monom aux2 : p2.getPolinomList()) {
                if(aux2.getGrad() == i)  {
                    m.setCoeficient(m.getCoeficient().doubleValue() - aux2.getCoeficient().doubleValue());
                }
            }
            rezultat.addMonom(m);
        }
        return rezultat;
    }

    public static Polinom deriv(Polinom p) {
        Polinom rezultat = new Polinom();
        for(Monom m : p.getPolinomList()) {
            if(m.getGrad() != 0)
                rezultat.addMonom(new Monom(m.getCoeficient().intValue() * m.getGrad(), m.getGrad() - 1));
        }
        return rezultat;
    }

    public static Polinom integral(Polinom p) {
        Polinom rezultat = new Polinom();
        for(Monom m : p.getPolinomList()) {
            rezultat.addMonom(new Monom(m.getCoeficient().doubleValue() / (m.getGrad() + 1), m.getGrad() + 1));
        }
        return rezultat;
    }

    public static Polinom mul(Polinom p1, Polinom p2) {
        Polinom rezultat = new Polinom();

        int gradMaxim = 0;
        if(p1.getGradMaxim() > p2.getGradMaxim())
            gradMaxim = p1.getGradMaxim() * 2;
        else
            gradMaxim = p2.getGradMaxim() * 2;

        Monom[] ceva = new Monom[gradMaxim + 1];
        for(int i = 0; i <= gradMaxim; i++)
            ceva[i] = new Monom(0, i);

        for(Monom m1 : p1.getPolinomList()) {
            for(Monom m2 : p2.getPolinomList()) {
                Monom m = MonomOP.mul(m1, m2);
                ceva[m1.getGrad()+m2.getGrad()] = MonomOP.add(ceva[m1.getGrad()+m2.getGrad()], m);
            }
        }
        for(int i = gradMaxim; i >= 0; i--)
            rezultat.addMonom(ceva[i]);

        return rezultat;
    }
}

