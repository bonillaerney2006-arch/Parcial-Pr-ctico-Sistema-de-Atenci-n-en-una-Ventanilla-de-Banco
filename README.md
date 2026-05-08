# 🏦 Sistema de Cola del Banco — FIFO

Sistema de gestión de turnos bancarios en Java. Los clientes son atendidos en **estricto orden de llegada** (FIFO: First In, First Out).

---

## 📋 Descripción

Simula la fila de atención de una sucursal bancaria. Cada cliente toma un turno al llegar y es atendido en orden. El sistema se maneja desde un menú interactivo en consola.

---

## 🚀 Instrucciones de compilación y ejecución

### Requisitos
- Java JDK 11 o superior

### Compilar
```bash
javac Cliente.java Main.java
```

### Ejecutar
```bash
java Main
```

### Ejecutar pruebas
```bash
javac Cliente.java ColaTest.java
java ColaTest
```

---

## 🖥️ Capturas de pantalla

### Menú principal
```
=== SISTEMA DE COLA DEL BANCO ===
1. Agregar cliente (tomar turno)
2. Atender siguiente cliente
3. Ver próximo cliente en espera
4. Mostrar todos los clientes en cola
5. Consultar cantidad de clientes en espera
6. Vaciar la cola
7. Salir
Seleccione una opción:
```

### Agregar un cliente
```
Seleccione una opción: 1
Ingrese nombre: Ana Pérez
Ingrese identificación: 12345678
Tipo de transacción (Depósito/Retiro/Consulta/Pago): Depósito
Hora de llegada (HH:MM): 10:30
Cliente agregado a la cola.
```

### Atender cliente
```
Seleccione una opción: 2
Atendiendo a: Cliente{nombre='Ana Pérez', id=12345678, transacción=Depósito, hora=10:30}
```

### Cola vacía
```
Seleccione una opción: 2
Error: No hay clientes en espera.
```

### Resultados de pruebas
```
✔  Cola nueva está vacía
✔  Tamaño es 2 tras encolar dos clientes
✔  Sale Ana primero (FIFO)
✔  Tamaño es 1 tras atender
✔  peek no elimina (tamaño sigue en 1)
✔  Cola vacía tras clear()

── Resultado: 6/6 pruebas exitosas ──
```

---

## ⚙️ ¿Cómo se implementó la FIFO?

**FIFO** significa *First In, First Out*: el primero en llegar es el primero en ser atendido, igual que una fila real.

En Java se implementó usando `LinkedList` como `Queue`:

```java
Queue<Cliente> cola = new LinkedList<>();

// Agregar al final
cola.offer(new Cliente(...));   // Ana entra → [Ana]
cola.offer(new Cliente(...));   // Luis entra → [Ana, Luis]

// Atender al primero
cola.poll();  // Sale Ana → [Luis]
```

- `offer()` → agrega al **final** de la cola
- `poll()` → elimina y retorna el **primero**
- `peek()` → consulta el primero **sin eliminarlo**

---

## 📐 Diagrama de clases (UML)

```
┌─────────────────────────────┐
│           Cliente           │
├─────────────────────────────┤
│ - nombre: String            │
│ - identificacion: String    │
│ - tipoTransaccion: String   │
│ - horaLlegada: LocalTime    │
├─────────────────────────────┤
│ + getNombre(): String       │
│ + getIdentificacion():String│
│ + getTipoTransaccion():String│
│ + getHoraLlegada():LocalTime│
│ + toString(): String        │
└─────────────────────────────┘
              △
              │ usa
┌─────────────────────────────┐
│            Main             │
├─────────────────────────────┤
│ - cola: Queue<Cliente>      │
│ - sc: Scanner               │
├─────────────────────────────┤
│ + main(args): void          │
│ + agregarCliente(): void    │
│ + atenderCliente(): void    │
│ + verProximo(): void        │
│ + mostrarTodos(): void      │
└─────────────────────────────┘
```

---

## 👨‍💻 Autor

**bonillaerney2006-arch**  
Proyecto académico — Estructuras de Datos
