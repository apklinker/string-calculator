# String Calculator
The goal of this project is to create two functions: `Converter.toUnsignedInt()` and `Calculator.sum()`. The development for these two functions will be done with TDD.

## `toUnsignedInt()`
This function will take in a string that contains only not letters or special characters. Assume the frontend will limit the available input through a standard number input keyboard seen on the right in the below image.

![Keyboard types](https://i.stack.imgur.com/2S84K.png)

###### Business Requirements
1. Input will limited on the front-end to contain **only** the following characters: `0`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `_`, `-`, `,`
1. A **unique exception** should be thrown when the input contains a decimal (`.`)
1. A **unique exception** should be thrown when the input contains a dash (`-`)
1. A **unique exception** should be thrown when the input contains a underscore (`_`)
1. A **unique exception** should be thrown when the input contains a comma (`,`)
1. A **unique exception** should be thrown when the input is longer than 3 digits

## `sum()`
Should compute the sum of an array of numbers, each represented in a string.

###### Business Requirements
1. When there are no inputs, **return `0`**
    - `sum([]) = 0`
1. When there are one inputs, **return that number**
    - `sum(["2"]) = 2`
    - `sum(["17"]) = 17`
1. When there are two or more inputs, **return the sum**
    - `sum(["1", "5"]) = 6`
    - `sum(["20", "3", "8"]) = 31`
1. If any exception occurs, **throw a `CalculationException`**
    - `sum(["-1", "3", "8"]) = !!CalculationException`
    - `sum(["4", ".25", "9"]) = !!CalculationException`
    - `sum(["_", "7"]) = !!CalculationException`
    - `sum([","]) = !!CalculationException`
    - `sum(["20", "3", "918"]) = !!CalculationException`
