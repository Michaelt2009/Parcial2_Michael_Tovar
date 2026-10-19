# Comprensión del diseño — Enunciado B
**Nombre:** Michael David Tovar Parada
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Modelo` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _Tu respuesta:_
Modelo es abstracta porque no tiene sentido crear un 
> "modelo" genérico en el aire; cada tipo entrena de forma 
> diferente. Obliga a que todos tengan el método entrenar(Dataset d). 
> La ventaja es que el experimento puede mandar a entrenar cualquier modelo sin importar si es CNN, 
> RNN o Regresión, tratando a todos por igual.
---

### 2. Composición vs. agregación
Explica la diferencia entre `Experimento ◆— Modelo` (composición) y
`Plataforma ◇— Experimento` (agregación). ¿Qué pasaría con el modelo si se
elimina el experimento? ¿Y con los experimentos si se elimina la plataforma?

> _Tu respuesta:_
La diferencia está en la dependencia de vida entre los objetos. En la composición, el modelo nace dentro del experimento; 
> si borramos el experimento, el modelo muere con él. En la agregación, los experimentos se crean por fuera y solo se anotan 
> en la plataforma; 
> si se elimina la plataforma, 
> los experimentos siguen existiendo sin problema.
---

### 3. Asociación
En `Investigador — Experimento`, ¿quién es dueño de quién? ¿Por qué se modela
como N:M y no como composición?

> _Tu respuesta:_
Ninguno es dueño de nadie; son independientes que trabajan juntos. Se usa N:M porque un investigador 
> puede participar en varios experimentos y un experimento puede tener varios investigadores al tiempo. 
> No es composición porque si un investigador renuncia o se borra, 
> el experimento sigue vivo (y al revés también).
---

### 4. Dependencia
¿Por qué `Modelo` **depende** de `MetricaEvaluacion` en lugar de **tenerlo**
como atributo? ¿Qué ventaja tiene pasar el servicio como parámetro?

> _Tu respuesta:_
Porque el modelo solo necesita la métrica un segundo para hacer el cálculo y no la vuelve a usar. Pasarla como parámetro evita dejar guardado un objeto innecesario dentro del modelo, gastando menos memoria y haciendo que el código sea más flexible si queremos cambiar de métrica.
---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] lossPorEpoca` en `Modelo`
- `ArrayList<Experimento>` en `Plataforma`

Explica por qué en cada caso se eligió esa estructura y no la otra.

> _Tu respuesta:_ En Modelo se usa int[] porque el número máximo de épocas se conoce desde el inicio y es un tamaño fijo. En cambio, en Plataforma se usa ArrayList porque no sabemos cuántos experimentos va a agregar el usuario, así que la lista tiene que poder agrandarse sobre la marcha.