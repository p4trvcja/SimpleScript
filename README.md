# Nazwa Języka: SimpleScript

## 0. Uruchamianie:

### Instalacja narzędzi:

https://github.com/antlr/antlr4/blob/master/doc/getting-started.md

### Tworzenie parsera i leksera

```bash
cd TKK
antlr4 SimpleScript.g4
javac SimpleScript*.java
```

### Testowanie

```bash
grun SimpleScript statement -tree
```

lub graficznie

```bash
grun SimpleScript statement -gui
```

## 1. Zmienne:

- Deklaracja zmiennych (jawna): typ <nazwa_zmiennej>;
- Przypisanie wartości: <nazwa_zmiennej> = <wartość>;

## 2. Operacje arytmetyczne:

- Dodawanie, odejmowanie, mnożenie, dzielenie: +, -, *, /, ++, +=

## 3. Typ logiczny:

- Stałe logiczne: true, false
- Operacje logiczne: and, or, not
- Porównywanie zmiennych numerycznych: <, >, ==, !=
- Sprawdzenie czy zmienna nie ma wartości null -> is null

## 4. Instrukcje warunkowe:

```java
if (warunek) {
    // instrukcje
} elif {
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

for (typ x in zbior){
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
```java
string ciag = "abcd";
print(find("ab" in ciag));
string d_ciag = ciag + "abcd";
```
2. Na tablicach
    - reverse()
    - add()
```java
int[] array = [1, 2, 3, 4, 5];
print(array.reverse());
array.add(2);
```

# Co działa?

- deklaracja zmiennych
- definicja zmiennych
