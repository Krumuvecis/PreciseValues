# Precise Values

[![](https://jitpack.io/v/Krumuvecis/PreciseValues.svg)](https://jitpack.io/#Krumuvecis/PreciseValues)

by [Krumuvecis](https://github.com/Krumuvecis)

Free to use and modify for whatever purposes. No copyrights apply.


## Abstract

This is mainly a library for a new data type `PreciseNumber`, but also has other functionality.


### PreciseNumber

A new data type representing value +/- error [like this](https://www2.southeastern.edu/Academics/Faculty/rallain/plab194/error.html).

`PreciseNumber` consists of 2 parts:
* `BigDecimal` value part;
* `NumberError` error part, which further consists of 2 parts:
  * `BigDecimal` value of the error;
  * `ErrorType` type of the error (enum).


### Other functionality

A list of functions:
* *something*
* *somethingsomething*
* *somethingsomethingmore*
* ...


## Requirements

* JDK: 18
* Maven compiler: 18
* Maven Surefire: 3.0.0-M7
* jetbrains annotations: 23.0.0


## Notes

*Under construction, expect changes...*
