package to.tuc.tp.tema1.Logic;

import to.tuc.tp.tema1.Models.Monom;

public class MonomOP {
    public static Monom add(Monom m1, Monom m2) {
        return new Monom(m1.getCoeficient().doubleValue() + m2.getCoeficient().doubleValue(), m1.getGrad());
    }

    public static Monom sub(Monom m1, Monom m2) {
        return new Monom(m1.getCoeficient().doubleValue() - m2.getCoeficient().doubleValue(), m1.getGrad());
    }

    public static Monom mul(Monom m1, Monom m2) {
        return new Monom(m1.getCoeficient().doubleValue() * m2.getCoeficient().doubleValue(), m1.getGrad() + m2.getGrad());
    }

    public static Monom div(Monom m1, Monom m2) {
        return new Monom(m1.getCoeficient().doubleValue() / m2.getCoeficient().doubleValue(), m1.getGrad() - m2.getGrad());
    }
}
