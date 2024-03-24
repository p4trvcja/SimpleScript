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
           | functionInvocation
           | arrayDefinition
           | arrayDeclaration
           | arrayAssignment
           | printStatement
           | expr SEMICOLON
           ; 

// variables
variableDeclaration : TYPE NAME (COMMA NAME)* SEMICOLON; 

variableDefinition: TYPE NAME '=' expr (COMMA NAME '=' expr)* SEMICOLON; 

variableAssignment : NAME (ASSIGNMENT | ASSIGN)  expr SEMICOLON; 


// functions
returnStatement : RETURN LBRACE expr RBRACE SEMICOLON;

functionDeclaration : TYPE NAME LPAREN parameters? RPAREN LBRACE statement* returnStatement? RBRACE SEMICOLON; 

functionInvocation: NAME LPAREN arguments? RPAREN SEMICOLON; 

parameter: TYPE NAME; 

parameters: parameter (COMMA parameter)*; 

arguments: expr (COMMA expr)*; 

// arrays
arrayDefinition: TYPE LBRACK RBRACK NAME ASSIGN LBRACK arguments? RBRACK SEMICOLON; 

arrayDeclaration: TYPE LBRACK RBRACK NAME SEMICOLON; 

arrayAssignment: NAME ASSIGN LBRACK arguments? RBRACK SEMICOLON; 

// printing   
printStatement: PRINT LPAREN expr RPAREN SEMICOLON;
 
// expresions
expr: expr ARITHMETIC_OP expr 
      | expr CONDITION_OP expr 
      | singleValueOperation 
      | value 
      | functionInvocation 
      | stringOperation
      ; 

// basic operations
// arithmeticOperation: value ARITHMETIC_OP value; 

// conditionalOperation: value CONDITIONAL_OP value; 

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
whileLoop : WHILE LPAREN expr RPAREN block; 

// for
forLoop : FOR LPAREN variableDefinition expr CONDITION_OP expr SEMICOLON singleValueOperation RPAREN LBRACE statement* RBRACE; 

forLoopArray : FOR LPAREN parameter IN NAME RPAREN LBRACE statement* RBRACE; 

// conditional statements
conditionalStatement:  ifCondition  
                       | switchCondition 
                       ; 

// if
ifCondition : IF LPAREN expr RPAREN block (ELIF LPAREN expr RPAREN block)* (ELSE block)?; 

//switch
switchCondition : SWITCH LPAREN NAME RPAREN LBRACE (CASE NAME COLON statement* (BREAK SEMICOLON)? )* (DEFAULT COLON statement* (BREAK SEMICOLON)? )? RBRACE;


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
