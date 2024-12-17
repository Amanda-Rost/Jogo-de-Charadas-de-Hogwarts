/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caracteristicas;

import java.util.Comparator;

/**
 *
 * @author Amanda Rost
 */
public class OrdenaPorPontos implements Comparator {

    @Override

    public int compare(Object t, Object t1) {
        Casa c1 = (Casa) t;
        Casa c2 = (Casa) t1;

        return c2.getPontTotal().compareTo(c1.getPontTotal());
    }
}
