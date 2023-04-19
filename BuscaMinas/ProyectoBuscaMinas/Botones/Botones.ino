// Definir los pines de los botones
const int boton1 = 12;
const int boton2 = 11;
const int boton3 = 10;
const int boton4 = 9;


void setup() {
  // Configurar los pines como entradas
  pinMode(boton1, INPUT_PULLUP);
  pinMode(boton2, INPUT_PULLUP);
  pinMode(boton3, INPUT_PULLUP);
  pinMode(boton4, INPUT_PULLUP);
  
  // Iniciar la comunicación serial
  Serial.begin(9600);
}

void loop() {
  // Leer el estado de los botones
  int estadoBoton1 = digitalRead(boton1);
  int estadoBoton2 = digitalRead(boton2);
  int estadoBoton3 = digitalRead(boton3);
  int estadoBoton4 = digitalRead(boton4);
  
  // Si el botón 1 se ha presionado, enviar una señal
  if (estadoBoton1 == LOW) {
    Serial.println("Izquierda");
  }
  
  // Si el botón 2 se ha presionado, enviar una señal
  if (estadoBoton2 == LOW) {
    Serial.println("Derecha");
  }
  
  // Si el botón 3 se ha presionado, enviar una señal
  if (estadoBoton3 == LOW) {
    Serial.println("Arriba");
  }
  
  // Si el botón 4 se ha presionado, enviar una señal
  if (estadoBoton4 == LOW) {
    Serial.println("Abajo");
  }
  
  // Esperar un corto periodo de tiempo antes de volver a leer los botones
  delay(100);
}
