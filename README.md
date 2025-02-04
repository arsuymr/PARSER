# LL(1) Parser for EXP Language

## Introduction
This project implements an LL(1) parser for recognizing the EXP language. It includes grammar design, parse table generation, and syntax tree construction using JavaCC.

## Lexical Units
The EXP language consists of:  
- **Identifiers (id):** Start with an uppercase letter and end with `_`.  
- **Operators ($):** `+`, `*`, `/`.  
- **Relational Operators (=):** `>`, `<`.  
- **Delimiters (@):** `(`, `)`.  
- **Block Delimiters (&):** `{`, `}`.

## Grammar

The grammar **G** is defined as follows:  
G = ⟨ N, T, S, P ⟩ with **P**: 
S → A @ B | B & A | ε
A → B $ | S = S 
B → A id | id S

## Grammar Design
The grammar is transformed to:  
- Eliminate **ε-transitions**  
- Remove **left recursion**  
- Apply **left factoring**  
These modifications ensure LL(1) compatibility.

## LL(1) Parsing Table
A parsing table is constructed. However, conflicts arise, making the grammar non-LL(1). To resolve conflicts, **priority rules** are applied.

## Implementation with JavaCC
- **Token definitions** are specified for lexical analysis.  
- The parser processes input from **the terminal** or **a file (`pgmsrc.exp`)**.  
- The **syntax tree** is generated and saved in `test_ast_output.txt`.  

## Usage
```bash
# Clone the repository
git clone https://github.com/arsuymr/PARSER
cd PARSER

# Compile and run with JavaCC
javacc ExpParser.jj
javac *.java
java ParserTest
