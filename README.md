### Descripción
Esta libreria provee una manera sencilla de realizar diversas validaciones sobre atributos, y generar un listado de mensajes de validación a partir del resultado de las mismas.
### Instalación
Para usar esta libreria basta con agregar la dependencia en tu pom.xml .
```sh
 <dependency>
    <groupId>com.github.angelowolf</groupId>
    <artifactId>validacion</artifactId>
    <version>1.0.0</version>
</dependency>
```
### Como se usa
Existen dos tipos de validaciones, las que se hacen sobre un campo y las que no.
##### Validación sobre campo
Los resultados de estas validaciones se agregan a la lista **listaValidaciones**.

Para realizar una / muchas validaciones se debe  importar la clase Validacion y proceder de la siguiente mandera:
1. Llamar al metodo check()
2. Llamar al metodo add(propiedad, validador, nombreCampo, mensajeValidacion), donde:
    1. **propiedad** es el atributo a validar.
    2. **validador** es el objeto del validador a utilizar.
    3. **nombrecampo** es el nombre del campo al que asociará el mensaje de validación en caso de que esta no sea correcta.
    4. **mensajeValidacion** es el mensaje que se asociará al mensaje de validación en caso de que esta no sea correcta.

    Para agregar mas validaciones solo basta con seguir llamando al metodo add().
3. Llamar al metodo doValidate().

##### Validación general
Hay validaciones que no se pueden relacionar con campos especificos, por ejemplo en el caso de querer eliminar un cliente y este no pueda ser eliminado por determinada razon de la logica del negocio. Estas validaciones se agregan a la lista **listaErrores**.
```sh
    errores.agregarMensajeError("El cliente no puedo ser eliminado.");
    errores.agregarMensajeError("Por favor revise los campos del formulario.");
```
##### Ejemplo
```sh
 ListaMensaje errores = Validacion.check()
                .add(u.getNombre(), new ValidacionRequeridoNoVacio(), "nombre", "Ingrese un nombre")
                .add(u.getApellido(), new ValidacionRequeridoNoVacio(), "apellido", "Ingrese un apellido")
                .add(u.getNumeroMatricula(), new ValidacionMaximo(99999999), "matricula", "Ingrese una matricula valida")
                .doValidate();
```
### Crear tu propia validación
Para crear una nueva validación se debe crear una clase que implemente la interface **IValidable<T>**. En el método **validate(T propiedad)** se debe realizar la validación deseada, este método debe devolver un **false** en caso de que la validación sea **correcta** y un **true** si la propiedad **no** supera la validación.
##### Ejemplo
```sh
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

```

### Ejemplo de uso 
Se podría utilizar en conjunto con alguna libreria / plugin que serialize objetos en json para obtener el listado de las validaciones realizadas en dicho formato.
##### Ejemplo en JSON
```sh
{
  "listaErrores": [
    {
      "mensajeError": "El cliente no puedo ser eliminado."
    },
    {
      "mensajeError": "Por favor revise los campos del formulario."
    }
  ],
  "listaValidaciones": [
    {
      "campo": "nombre",
      "mensajeError": "Ingrese un nombre"
    },
    {
      "campo": "apellido",
      "mensajeError": "Ingrese un apellido"
    },
    {
      "campo": "matricula",
      "mensajeError": "Ingrese una matricula valida"
    }
  ]
}
```


