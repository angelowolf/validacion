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
package com.github.angelowolf.implementaciones;

import com.github.angelowolf.validacion.IValidable;

/**
 *
 * Valida si la propiedadAEvaluar se encuentra en el rango indicado.
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class ValidacionRango implements IValidable<Comparable> {

    private final Comparable minimo;
    private final Comparable maximo;

    public ValidacionRango(Comparable minimo, Comparable maximo) {
        this.minimo = minimo;
        this.maximo = maximo;
    }

    @Override
    public boolean validate(Comparable propiedadAEvaluar) {
        if (propiedadAEvaluar == null) {
            return true;
        }
        if (propiedadAEvaluar.compareTo(maximo) > 0) {
            return true;
        }
        return propiedadAEvaluar.compareTo(minimo) < 0;
    }
}
