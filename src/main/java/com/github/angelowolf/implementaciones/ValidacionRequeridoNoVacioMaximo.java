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
import org.apache.commons.lang3.StringUtils;

/**
 * Verifica si el objeto es nulo o vacio o si supera la cantidad maxima
 * indicada.
 *
 * ValidacionRequeridoVacio.isBlank(null)    = true
 * ValidacionRequeridoVacio.isBlank("")      = true
 * ValidacionRequeridoVacio.isBlank(" ")     = true
 * ValidacionRequeridoVacio.isBlank("bob")   = false
 * ValidacionRequeridoVacio.isBlank(" bob ") = false
 * ValidacionRequeridoVacio.isBlank("bob")   = true (maximo = 2)
 *
 * @author Angelo Wolf angelowolf21@gmail.com
 */
public class ValidacionRequeridoNoVacioMaximo implements IValidable<String> {

    private final int maximoCaracteres;

    public ValidacionRequeridoNoVacioMaximo(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }

    @Override
    public boolean validate(String propiedadAEvaluar) {
        if (StringUtils.isBlank(propiedadAEvaluar)) {
            return true;
        } else {
            if (propiedadAEvaluar.length() > this.maximoCaracteres) {
                return true;
            }
        }
        return false;
    }

}
