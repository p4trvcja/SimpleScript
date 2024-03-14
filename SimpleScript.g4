grammar SimpleScript; 

script : statement+ EOF; 


// SIMPLE STATEMENTS, OPERATIONS 

// statements
statement: variableDeclaration 
           | variableAssignment 
           | variableDefinition 
           | conditionalStatement 
           | iterationStatement 
           | functionDeclaration 
           ; 

// variables
variableDeclaration : TYPE NAME SEMICOLON; 

variableDefinition: TYPE NAME ‘=’ expr SEMICOLON; 

variableAssignment : NAME ASSIGN expr SEMICOLON; 

// functions
functionDeclaration : TYPE NAME LPAREN parameters? RPAREN LBRACE statement* RBRACE SEMICOLON; 

functionInvocation: NAME LPAREN arguments? RPAREN SEMICOLON; 

parameter: TYPE NAME; 

parameters: parameter (COMMA parameter)*; 

arguments: expr (COMMA expr)*; 

// arrays
arrayDefinition: TYPE LBRACE RBRACE NAME ‘=’ LBRACE arguments? RBRACE SEMICOLON; 

arrayDeclaration: TYPE LBRACE RBRACE NAME SEMICOLON; 

arrayAssignment: NAME ‘=’ LBRACE arguments? RBRACE SEMICOLON; 
 
// expresions
expr: arithmeticOperation 
      | conditionalOperation 
      | singleValueOperation 
      | value 
      | functionInvocation 
      | stringOperation
      ; 

// basic operations
arithmeticOperation: expr ARITHMETIC_OP expr; 

conditionalOperation: expr CONDITIONAL_OP expr; 

singleValueOperation: value (SINGLE_VAL_OP)?; 

// String operations
stringOperation: concatenationOperation 
                 | findOperation
                 ;

concatenationOperation: (STRING | NAME) CONCAT (STRING | NAME);

findOperation: FIND LPAREN (STRING | NAME) IN (STRING | NAME) RPAREN;


// COMPLEX STATEMENTS, OPERATIONS 

// loops
iterationStatement: whileLoop 
                    | forLoop 
                    | forLoopArray 
                    ; 

//while
whileLoop : WHILE LPAREN expr RPAREN LBRACE statement* RBRACE; 

// for
forLoop : FOR LPAREN variableDefinition SEMICOLON conditionalOperation SEMICOLON (singleValueOperation  | variableAssignment) RPAREN LBRACE statement* RBRACE; 

forLoopArray : FOR LPAREN parameter IN NAME RPAREN LBRACE statement* RBRACE; 

// conditional statements
conditionalStatement:	ifCondition  
                      | switchCondition 
                      ; 

// if
ifCondition : IF LPAREN conditionalOperation RPAREN LBRACE statement* RBRACE (ELIF LPAREN conditionalOperation RPAREN LBRACE statement* RBRACE)* (ELSE LBRACE statement* RBRACE)? SEMICOLON; 

//switch
switchCondition : SWITCH LPAREN NAME RPAREN LBRACE (CASE NAME ‘:’ statement* (BREAK SEMICOLON)? )* (DEFAULT ‘:’ statement* (BREAK SEMICOLON)? )? RBRACE 


// OPERATORS, VARIABLES 

value: NAME 
       | NUMBER 
       | BOOLEAN 
       | STRING	 
       ; 

ARITHMETIC_OP :  ‘+’ | ‘-’ | ‘*’ | ‘/’ | ‘%’ ; 

CONDITION_OP : ‘>’ | ‘>=’ | ‘<’ | ‘<=’ | ‘==’ | ‘!=’  | ‘and’ | ‘or’ | ‘not’; 

SINGLE_VAL_OP : ‘++’ | ‘--’; 

ASSIGN :  ‘=’ | ‘+=’ | ‘-=’ | ‘/=’ | ‘*=’; 

IS_NULL : ‘is null’; 

IN : ‘in’; 

IF : ‘if’; 

ELIF : ‘elif’; 

ELSE : ‘else’; 

FOR : ‘for’; 

WHILE : ‘while’; 

SWITCH : ‘switch’; 

CASE : ‘case’; 

DEFAULT : ‘default’; 

BREAK : ‘break’; 

TYPE : ‘int’ | ‘string’ | ‘char’ | ‘bool’ | ‘float’; 

STRING : ‘”’ (~[“])* ‘”’; 

CONCAT : ‘+’; 

NAME : [a-zA-Z0-9_]+ ;  

NUMBER : [0-9]+ ; 

BOOLEAN : ‘true’ | ‘false’; 

SEMICOLON : ‘;’; 

COMMA : ‘,’; 

LPAREN: ‘(‘; 

RPAREN: ‘)’; 

LBRACE: ‘{‘;

RBRACE: ‘}‘;

LBRACK : ‘[‘; 

RBRACK : ‘]’; 

COMMENT: '//' ~[\r\n]* -> skip; 

FUNCTION: ‘function’; 
