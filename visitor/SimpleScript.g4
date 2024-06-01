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
returnStatement : RETURN LPAREN expr RPAREN SEMICOLON;

functionDeclaration : (TYPE | arrayType) NAME LPAREN ((TYPE | arrayType) NAME ((COMMA (TYPE | arrayType) NAME)*))? RPAREN block SEMICOLON;

functionInvocation: NAME LPAREN (RPAREN | expr RPAREN | expr (COMMA expr)+ RPAREN);

parameter: TYPE NAME; 

parameters: parameter (COMMA parameter)*; 

arguments: expr (COMMA expr)*; 

// arrays
arrayType: TYPE LBRACK RBRACK;

arrayDefinition: arrayType NAME ASSIGN LBRACK arguments? RBRACK SEMICOLON; 

arrayDeclaration: arrayType NAME SEMICOLON; 

arrayAssignment: NAME ASSIGN LBRACK arguments? RBRACK SEMICOLON; 

arrayAccess: NAME LBRACK expr RBRACK;

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

expr: value 
      | functionInvocation 
      | arithmeticOperation
      | conditionalOperation
      | singleValueOperation 
      | stringOperation
      | returnStatement
      | arrayAccess
      | arrayOperation
      ; 

// basic operations
arithmeticOperation: term
    | arithmeticOperation CONCAT term
    | arithmeticOperation SUB term
    ;

term: factor
    | term MUL factor
    | term DIV factor
    ;

factor: value
      | functionInvocation
      | '(' expr ')'
      ;

conditionalOperation: logicalTerm
            | conditionalOperation CONDITION_OP logicalTerm;

logicalTerm: logicalFactor
            | logicalTerm OR logicalFactor
            ;

logicalFactor: logicalPrimary
             | logicalFactor AND logicalPrimary
             ;

logicalPrimary: value
              | functionInvocation
              | '(' conditionalOperation ')'
              | NOT logicalPrimary
              ;

singleValueOperation: NAME SINGLE_VAL_OP; 

// String operations
stringOperation: concatenationOperation 
                 | findOperation
                 ;

concatenationOperation: str CONCATSTR str;

findOperation: FIND LPAREN str IN str RPAREN;

// Array operations
arrayOperation: reverseOperation 
                | addOperation
                ;

reverseOperation: REVERSE LPAREN NAME RPAREN;

addOperation: ADD LPAREN NAME COMMA expr RPAREN;


// COMPLEX STATEMENTS

block : LBRACE statement* returnStatement? RBRACE;

// loops
iterationStatement: whileLoop 
                    | forLoop 
                    | forLoopArray 
                    ; 

//while
whileLoop : WHILE LPAREN conditionalOperation RPAREN block; 

// for
forLoop : FOR LPAREN (variableDefinition | variableAssignment SEMICOLON) conditionalOperation SEMICOLON (singleValueOperation | variableAssignment) RPAREN block;

forLoopArray : FOR LPAREN parameter IN NAME RPAREN block; 

// conditional statements
conditionalStatement:  ifCondition  
                       | switchCondition 
                       ; 

// if
ifCondition : IF LPAREN conditionalOperation RPAREN block (ELIF LPAREN conditionalOperation RPAREN block)* (ELSE block)?; 

//switch
switchCondition : SWITCH LPAREN NAME RPAREN LBRACE caseClause* defaultClause? RBRACE;

caseClause: CASE value COLON statement* (BREAK SEMICOLON)?;

defaultClause: DEFAULT COLON statement* (BREAK SEMICOLON)?;

// OPERATORS, VARIABLES 

value: NAME 
       | NUMBER 
       | BOOLEAN 
       | STRING	 
       ; 

str: STRING 
     | NAME
     ;

CONCAT: '+';

CONCATSTR: 'concat';

SUB: '-';

MUL: '*';

DIV: '/';

ASSIGNMENT:  '+=' | '-=' | '/=' | '*='; 

ASSIGN: '=';

// ARITHMETIC_OP :  '+' | '-' | '*' | '/' | '%' ; 

CONDITION_OP : '>' | '>=' | '<' | '<=' | '==' | '!=';

AND: 'and';

OR: 'or';

NOT: 'not';

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
