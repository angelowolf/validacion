package com.github.angelowolf.implementaciones;

import com.github.angelowolf.validacion.IValidable;

/**
 * Verifica si el objeto es nulo o supera el maximo.
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class ValidacionMaximo implements IValidable<Comparable> {

    private final Comparable maximo;

    public ValidacionMaximo(Comparable maximo) {
        this.maximo = maximo;
    }

    @Override
    public boolean validate(Comparable propiedadAEvaluar) {
        if (propiedadAEvaluar == null) {
            return true;
        }
        return maximo.compareTo(propiedadAEvaluar) > 0;
    }

}
