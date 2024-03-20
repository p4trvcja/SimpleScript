grammar SimpleScript; 

script : statement+ EOF; 


// SIMPLE STATEMENTS, OPERATIONS 

// statements
statement: expr SEMICOLON
           | variableDeclaration 
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
           ; 

// variables
variableDeclaration : TYPE NAME (COMMA NAME)* SEMICOLON; 

variableDefinition: TYPE NAME '=' expr (COMMA NAME '=' expr)* SEMICOLON; 

variableAssignment : NAME ASSIGN expr SEMICOLON; 

// functions
functionDeclaration : TYPE NAME LPAREN parameters? RPAREN LBRACE statement* RBRACE SEMICOLON; 

functionInvocation: NAME LPAREN arguments? RPAREN SEMICOLON; 

parameter: TYPE NAME; 

parameters: parameter (COMMA parameter)*; 

arguments: expr (COMMA expr)*; 

// arrays
arrayDefinition: TYPE LBRACE RBRACE NAME '=' LBRACE arguments? RBRACE SEMICOLON; 

arrayDeclaration: TYPE LBRACE RBRACE NAME SEMICOLON; 

arrayAssignment: NAME '=' LBRACE arguments? RBRACE SEMICOLON; 

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

singleValueOperation: ('int' | 'float') (SINGLE_VAL_OP)?; 

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

// loops
iterationStatement: whileLoop 
                    | forLoop 
                    | forLoopArray 
                    ; 

//while
whileLoop : WHILE LPAREN expr RPAREN LBRACE statement* RBRACE; 

// for
forLoop : FOR LPAREN variableDefinition SEMICOLON expr CONDITION_OP expr  SEMICOLON (singleValueOperation  | variableAssignment) RPAREN LBRACE statement* RBRACE; 

forLoopArray : FOR LPAREN parameter IN NAME RPAREN LBRACE statement* RBRACE; 

// conditional statements
conditionalStatement:  ifCondition  
                       | switchCondition 
                       ; 

// if
ifCondition : IF LPAREN expr CONDITION_OP expr  RPAREN LBRACE statement* RBRACE (ELIF LPAREN expr CONDITION_OP expr RPAREN LBRACE statement* RBRACE)* (ELSE LBRACE statement* RBRACE)? SEMICOLON; 

//switch
switchCondition : SWITCH LPAREN NAME RPAREN LBRACE (CASE NAME COLON statement* (BREAK SEMICOLON)? )* (DEFAULT COLON statement* (BREAK SEMICOLON)? )? RBRACE;


// OPERATORS, VARIABLES 

value: NAME 
       | NUMBER 
       | BOOLEAN 
       | STRING	 
       ; 



ARITHMETIC_OP :  '+' | '-' | '*' | '/' | '%' ; 

CONDITION_OP : '>' | '>=' | '<' | '<=' | '==' | '!='  | 'and' | 'or' | 'not'; 

SINGLE_VAL_OP : '++' | '--'; 

ASSIGN :  '=' | '+=' | '-=' | '/=' | '*='; 

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

TYPE : 'int' | 'string' | 'char' | 'bool' | 'float'; 

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

NAME : [a-zA-Z0-9_]+ ;  

NUMBER : [0-9]+ ; 