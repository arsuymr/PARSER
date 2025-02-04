LL(1) Parser for EXP Language
Introduction
This project implements an LL(1) parser for recognizing the EXP language. It includes grammar design, parse table generation, and syntax tree construction using JavaCC.

Lexical Units
The EXP language consists of:

Identifiers (id): Start with an uppercase letter and end with _.
Operators ($): +, *, /.
Relational Operators (=): >, <.
Delimiters (@): (, ).
Block Delimiters (&): {, }.
Grammar Design
The grammar is transformed to eliminate ε-transitions, left recursion, and left factoring to make it LL(1).

LL(1) Parsing Table
A parsing table is constructed, but conflicts arise, making the grammar non-LL(1). To resolve conflicts, priority rules are applied.

Implementation with JavaCC
Token definitions are specified for lexical analysis.
The parser processes input from the terminal or a file (pgmsrc.exp).
The syntax tree is generated and saved in test_ast_output.txt.
