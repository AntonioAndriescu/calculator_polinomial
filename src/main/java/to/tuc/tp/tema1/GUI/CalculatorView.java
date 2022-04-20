package to.tuc.tp.tema1.GUI;

import to.tuc.tp.tema1.Logic.PolinomOP;
import to.tuc.tp.tema1.Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorView {

    private JFrame frame = new JFrame();
    private Container x = new Container();
    private JLabel p1 = new JLabel("Polinom 1:");
    private JLabel p2 = new JLabel("Polinom 2:");
    private JLabel pr = new JLabel("Rezultat:");
    private JTextField t1 = new JTextField("4x^5-3x^4+x^2-8x+1");
    private JTextField t2 = new JTextField("3x^4-x^3+x^2+2x-1");
    private JTextField tr = new JTextField();
    private JButton b1 = new JButton("Adunare");
    private JButton b2 = new JButton("Scadere");
    private JButton b3 = new JButton("Inmultire");
    private JButton b4 = new JButton("Impartire");
    private JButton b5 = new JButton("Derivare");
    private JButton b6 = new JButton("Integrare");

    public CalculatorView() {

        frame.setTitle("Calculator polinomial");
        frame.setBounds(300, 90, 1050, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        x = frame.getContentPane();
        x.setLayout(null);

        p1.setFont(new Font("Arial", Font.PLAIN, 16));
        p1.setSize(100, 12);
        p1.setLocation(50, 20);
        x.add(p1);

        t1.setFont(new Font("Arial", Font.PLAIN, 20));
        t1.setSize(420, 30);
        t1.setLocation(50, 40);
        x.add(t1);

        p2.setFont(new Font("Arial", Font.PLAIN, 16));
        p2.setSize(100, 12);
        p2.setLocation(50, 80);
        x.add(p2);

        t2.setFont(new Font("Arial", Font.PLAIN, 20));
        t2.setSize(420, 30);
        t2.setLocation(50, 100);
        x.add(t2);

        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.setSize(135, 30);
        b1.setLocation(100, 150);
        x.add(b1);

        b2.setFont(new Font("Arial", Font.PLAIN, 20));
        b2.setSize(135, 30);
        b2.setLocation(285, 150);
        x.add(b2);

        b3.setFont(new Font("Arial", Font.PLAIN, 20));
        b3.setSize(135, 30);
        b3.setLocation(100, 200);
        x.add(b3);

        b4.setFont(new Font("Arial", Font.PLAIN, 20));
        b4.setSize(135, 30);
        b4.setLocation(285, 200);
        x.add(b4);

        b5.setFont(new Font("Arial", Font.PLAIN, 20));
        b5.setSize(135, 30);
        b5.setLocation(100, 250);
        x.add(b5);

        b6.setFont(new Font("Arial", Font.PLAIN, 20));
        b6.setSize(135, 30);
        b6.setLocation(285, 250);
        x.add(b6);

        pr.setFont(new Font("Arial", Font.PLAIN, 16));
        pr.setSize(100, 12);
        pr.setLocation(50, 300);
        x.add(pr);

        tr.setFont(new Font("Arial", Font.PLAIN, 20));
        tr.setSize(950, 30);
        tr.setLocation(50, 320);
        tr.setEditable(false);
        tr.setBackground(Color.white);
        x.add(tr);

        frame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sp1 = t1.getText();
                String sp2 = t2.getText();
                Polinom pr1 = new Polinom();
                Polinom pr2 = new Polinom();
                Pattern pattern  = Pattern.compile("(-?\\b\\d+|-)?[xX]\\^(-?\\d+\\b)|(-?\\b\\d+|-)?[xX]|(-?\\b\\d+)");
                Matcher matcher1 = pattern.matcher(sp1);
                Matcher matcher2 = pattern.matcher(sp2);
                while (matcher1.find()) {
                    pr1.addMonom(createMonomFromMatcher(matcher1));
                }
                while (matcher2.find()) {
                    pr2.addMonom(createMonomFromMatcher(matcher2));
                }
                Polinom rezultat = PolinomOP.add(pr1, pr2);
                tr.setText("" + rezultat.polinomToString());
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sp1 = t1.getText();
                String sp2 = t2.getText();
                Polinom pr1 = new Polinom();
                Polinom pr2 = new Polinom();
                Pattern pattern  = Pattern.compile("(-?\\b\\d+|-)?[xX]\\^(-?\\d+\\b)|(-?\\b\\d+|-)?[xX]|(-?\\b\\d+)");
                Matcher matcher1 = pattern.matcher(sp1);
                Matcher matcher2 = pattern.matcher(sp2);
                while (matcher1.find()) {
                    pr1.addMonom(createMonomFromMatcher(matcher1));
                }
                while (matcher2.find()) {
                    pr2.addMonom(createMonomFromMatcher(matcher2));
                }
                Polinom rezultat = PolinomOP.sub(pr1, pr2);
                tr.setText("" + rezultat.polinomToString());
            }
        });

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sp1 = t1.getText();
                String sp2 = t2.getText();
                Polinom pr1 = new Polinom();
                Polinom pr2 = new Polinom();
                Pattern pattern  = Pattern.compile("(-?\\b\\d+|-)?[xX]\\^(-?\\d+\\b)|(-?\\b\\d+|-)?[xX]|(-?\\b\\d+)");
                Matcher matcher1 = pattern.matcher(sp1);
                Matcher matcher2 = pattern.matcher(sp2);
                while (matcher1.find()) {
                    pr1.addMonom(createMonomFromMatcher(matcher1));
                }
                while (matcher2.find()) {
                    pr2.addMonom(createMonomFromMatcher(matcher2));
                }
                Polinom rezultat = PolinomOP.mul(pr1, pr2);
                tr.setText("" + rezultat.polinomToString());
            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sp1 = t1.getText();
                Polinom pr1 = new Polinom();
                Pattern pattern  = Pattern.compile("(-?\\b\\d+|-)?[xX]\\^(-?\\d+\\b)|(-?\\b\\d+|-)?[xX]|(-?\\b\\d+)");
                Matcher matcher1 = pattern.matcher(sp1);
                while (matcher1.find()) {
                    pr1.addMonom(createMonomFromMatcher(matcher1));
                }
                Polinom rezultat = PolinomOP.deriv(pr1);
                tr.setText("" + rezultat.polinomToString());
            }
        });

        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String sp1 = t1.getText();
                Polinom pr1 = new Polinom();
                Pattern pattern  = Pattern.compile("(-?\\b\\d+|-)?[xX]\\^(-?\\d+\\b)|(-?\\b\\d+|-)?[xX]|(-?\\b\\d+)");
                Matcher matcher1 = pattern.matcher(sp1);
                while (matcher1.find()) {
                    pr1.addMonom(createMonomFromMatcher(matcher1));
                }
                Polinom rezultat = PolinomOP.integral(pr1);
                tr.setText("" + rezultat.polinomToString());
            }
        });
    }

    private Monom createMonomFromMatcher(Matcher matcher) {
        Number c = 0;
        int g = 0;

        if(matcher.group(1) != null && matcher.group(2) != null) {
            if (matcher.group(1).equals("-")) {
                c = -1;
                g = Integer.parseInt(matcher.group(2));
            }
            else {
                c = Integer.parseInt(matcher.group(1));
                g = Integer.parseInt(matcher.group(2));
            }
        }
        else if(matcher.group(1) == null && matcher.group(2) != null) {
            c = 1;
            g = Integer.parseInt(matcher.group(2));
        }
        else if(matcher.group(3) != null && matcher.group(4) == null) {
            if(matcher.group(3).equals("-")) {
                c = -1;
                g = 1;
            }
            else {
                c = Integer.parseInt(matcher.group(3));
                g = 1;
            }
        }
        else if(matcher.group(1) == null && matcher.group(2) == null && matcher.group(3) == null && matcher.group(4) == null) {
            c = 1;
            g = 1;
        }
        else if(matcher.group(3) == null && matcher.group(4) != null) {
            c = Integer.parseInt(matcher.group(4));
            g = 0;
        }

        return new Monom(c, g);
    }
}