/**
 * MIT License
 *
 * Copyright (c) 2017 Wolf Angelo
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.angelowolf.validacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class Validacion {

    private final List<ObjetoValidacion> validaciones = new ArrayList<>();
    private final ListaMensaje errores = new ListaMensaje();

    /**
     * Crea el objeto validacion.
     *
     * @return Validacion.
     */
    public static Validacion check() {
        return new Validacion();
    }

    /**
     * Agrega una nueva validacion para ser probada.
     *
     * @param <T>
     * @param propiedadAEvaluar La propiedad a evaliar.
     * @param validadorImplementacion El validador a usar.
     * @param nombreCampo nombre del campo.
     * @param mensajeError el mensaje a mostrar.
     * @return Validacion.
     */
    public <T> Validacion add(T propiedadAEvaluar, IValidable<T> validadorImplementacion, String nombreCampo, String mensajeError) {
        this.validarNoNulo(validadorImplementacion, "El Validador no puede ser nulo");
        validaciones.add(new ObjetoValidacion(propiedadAEvaluar, validadorImplementacion, new MensajeValidacion(nombreCampo, mensajeError)));
        return this;
    }

    /**
     * Realiza todas las validaciones existentes. Se devolvera el objeto con
     * errores o vacio segun el caso.
     *
     * @return ListaMensaje.
     */
    public ListaMensaje doValidate() {
        if (validaciones.isEmpty()) {
            return errores;
        }

        for (ObjetoValidacion oValidacion : validaciones) {
            if (oValidacion.getValidacion().validate(oValidacion.getT())) {
                errores.agregarMensajeValidacion(oValidacion.getMensaje());
            }
        }

        return errores;
    }

    /**
     * Verifica que si la instancia del validador usado es nulo o no.
     *
     * @param <T>
     * @param reference Validador a probar.
     * @param errorMessage Mensaje a mostrar en la excepcion generada.
     * @return La instancia del validaor.f
     */
    private <T> T validarNoNulo(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
        return reference;
    }

}
