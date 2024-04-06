grammar SimpleScript; 

script : statement+ EOF; 


// SIMPLE STATEMENTS, OPERATIONS 

// statements
statement: variableDeclaration 
           | variableAssignment SEMICOLON
           | variableDefinition 
           | conditionalStatement 
           | iterationStatement 
           | functionDeclaration 
           | functionInvocation SEMICOLON
           | arrayDefinition
           | arrayDeclaration
           | arrayAssignment
           | printStatement
           | expr SEMICOLON
           ; 

// variables
variableDeclaration : TYPE NAME (COMMA NAME)* SEMICOLON; 

variableDefinition: TYPE NAME '=' expr (COMMA NAME '=' expr)* SEMICOLON; 

variableAssignment : NAME (ASSIGNMENT | ASSIGN)  expr; 


// functions
returnStatement : RETURN LBRACE expr RBRACE SEMICOLON;

functionDeclaration : (TYPE | arrayType) NAME LPAREN parameters? RPAREN LBRACE statement* returnStatement? RBRACE SEMICOLON; 

functionInvocation: NAME LPAREN arguments? RPAREN; 

parameter: TYPE NAME; 

parameters: parameter (COMMA parameter)*; 

arguments: expr (COMMA expr)*; 

// arrays
arrayType: TYPE LBRACK RBRACK;

arrayDefinition: arrayType NAME ASSIGN LBRACK arguments? RBRACK SEMICOLON; 

arrayDeclaration: arrayType NAME SEMICOLON; 

arrayAssignment: NAME ASSIGN LBRACK arguments? RBRACK SEMICOLON; 

// printing   
printStatement: PRINT LPAREN expr RPAREN SEMICOLON;
 
// expresions
// expr: expr ARITHMETIC_OP expr 
//       | expr CONDITION_OP expr 
//       | singleValueOperation 
//       | value 
//       | functionInvocation 
//       | stringOperation
//       ; 

expr: arithmeticOperation
      | conditionalOperation
      | singleValueOperation 
      | value 
      | functionInvocation 
      | stringOperation
      ; 

// basic operations
arithmeticOperation: value ARITHMETIC_OP expr; 

conditionalOperation: value CONDITION_OP expr; 

singleValueOperation: NAME SINGLE_VAL_OP; 

// String operations
stringOperation: concatenationOperation 
                 | findOperation
                 ;

concatenationOperation: (STRING | NAME) CONCAT (STRING | NAME);

findOperation: FIND LPAREN (STRING | NAME) IN (STRING | NAME) RPAREN;

// Array operations
arrayOperation: reverseOperation 
                | addOperation
                ;

reverseOperation: REVERSE LPAREN NAME RPAREN;

addOperation: ADD LPAREN NAME COMMA expr RPAREN;


// COMPLEX STATEMENTS

block : LBRACE statement* RBRACE;

// loops
iterationStatement: whileLoop 
                    | forLoop 
                    | forLoopArray 
                    ; 

//while
whileLoop : WHILE LPAREN conditionalOperation RPAREN block; 

// for
forLoop : FOR LPAREN variableDefinition conditionalOperation SEMICOLON (singleValueOperation | variableAssignment) RPAREN block; 

forLoopArray : FOR LPAREN parameter IN NAME RPAREN block; 

// conditional statements
conditionalStatement:  ifCondition  
                       | switchCondition 
                       ; 

// if
ifCondition : IF LPAREN conditionalOperation RPAREN block (ELIF LPAREN conditionalOperation RPAREN block)* (ELSE block)?; 

// TODO: switch
//switch
switchCondition : SWITCH LPAREN NAME RPAREN LBRACE (CASE value COLON statement* (BREAK SEMICOLON)? )* (DEFAULT COLON statement* (BREAK SEMICOLON)? )? RBRACE;


// OPERATORS, VARIABLES 

value: NAME 
       | NUMBER 
       | BOOLEAN 
       | STRING	 
       ; 


ASSIGNMENT:  '+=' | '-=' | '/=' | '*='; 

ASSIGN: '=';

ARITHMETIC_OP :  '+' | '-' | '*' | '/' | '%' ; 

CONDITION_OP : '>' | '>=' | '<' | '<=' | '==' | '!='  | 'and' | 'or' | 'not'; 

SINGLE_VAL_OP : '++' | '--'; 

IS_NULL : 'is null'; 

IN : 'in'; 

IF : 'if'; 

ELIF : 'elif'; 

ELSE : 'else'; 

FOR : 'for'; 

WHILE : 'while'; 

SWITCH : 'switch'; 

CASE : 'case'; 

DEFAULT : 'default'; 

BREAK : 'break'; 

TYPE : 'int' | 'string' | 'char' | 'bool' | 'float' | 'void'; 

RETURN : 'return';

STRING : '"' (~["])* '"'; 

CONCAT : '+'; 

BOOLEAN : 'true' | 'false'; 

SEMICOLON : ';';

COMMA : ','; 

COLON : ':'; 

LPAREN: '('; 

RPAREN: ')'; 

LBRACE: '{';

RBRACE: '}';

LBRACK : '['; 

RBRACK : ']'; 

FUNCTION : 'function'; 

PRINT: 'print';

FIND: 'find';

REVERSE: 'reverse';

ADD: 'add';

COMMENT: '//' ~[\r\n]* -> skip; 

WS: [ \t\r\n]+ -> skip;

NAME : [a-zA-Z]+[a-zA-Z0-9_]* ;  

NUMBER : [0-9]+('.'[0-9]+)?; 