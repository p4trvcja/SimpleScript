# Nazwa Języka: SimpleScript
## 1. Zmienne:

- Deklaracja zmiennych (jawna): typ <nazwa_zmiennej>;
- Przypisanie wartości: <nazwa_zmiennej> = <wartość>;

## 2. Operacje arytmetyczne:

- Dodawanie, odejmowanie, mnożenie, dzielenie: +, -, *, /, ++, +=
- Nawiasowanie: ( )

## 3. Typ logiczny:

- Stałe logiczne: true, false
- Operacje logiczne: and, or, not
- Porównywanie zmiennych numerycznych: <, >, ==, !=
- Sprawdzenie czy zmienna nie ma wartości null -> is null

## 4. Instrukcje warunkowe:

```java
if (warunek) {
    // instrukcje
} else {
    // instrukcje
}


switch (c)
{
 case 'A':
    // instrukcje
 case 'a':
    // instrukcje
    break;
 default:
    // instrukcje
}
```
## 5. Pętle/iteracje:

```java
while (warunek) {
    // instrukcje
}

for (inicjalizacja; warunek; inkrementacja) {
    // instrukcje
}

for (typ x in array){
    // instrukcje
}
```
## 6. Funkcje:

```java
typ_zwracany nazwa_funkcji(typ arg1, typ arg2, ...) {
    // instrukcje
}

nazwa_funkcji(arg1, arg2, ...);
```

## 7. Operacje na ciągach znaków/Operacje na tablicach

1. Na ciągach
    - Wyszukiwanie podciągów znaków
    - Konkatenacja (łączenie ciągów znaków)
2. Na tablicach
    - reverse()
    - add()
