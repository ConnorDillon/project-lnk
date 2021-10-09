grammar Link;		

prog: ((defn | expr | pipe) (';' | EOF))* ;

defn: 'def' ID+ '=' (expr | pipe) ;

pipe: expr ('|' expr)* ;

expr: expr op=('*' | '/') expr # MulDiv
    | expr op=('+' | '-') expr # AddSub
    | expr op=('>' | '<' | '>=' | '<=' | '==') expr # Compare
    | 'not' expr # Not
    | expr op='and' expr # And
    | expr op='or' expr # Or
    | 'do' expr (';' expr)* # Do
    | 'if' expr 'then' expr 'else' expr # If
    | DOT # Dot
    | FIELD # Field
    | ID '=' expr # Assign
    | ID # Id
    | ID expr+ # Call
    | '\\' ID+ '->' expr # Lambda
    | INT # Int
    | FLOAT # Float
    | STRING # String
    | '{' (pair | ID) (',' (pair | ID))* '}' # Object
    | '{' '}' # EmptyObject
    | '[' expr (',' expr)* ']' # Array
    | '[' ']' # EmptyArray
    | '(' expr ',' (expr ',')* expr?')' # Stream
    | '(' ')' # EmptyStream
    | '(' expr ')' # ExprGroup
    | '(' pipe ')' # PipeGroup
    | '(' expr+ ')' # CallGroup
    ;

pair: (ID | STRING) ':' expr;

ID: [a-zA-Z] [a-zA-Z\-_0-9]* ;

DOT: '.' ;

FIELD: ((ID ACCESS) | (DOT BRACKET_ACCESS)) ACCESS* ;

fragment BRACKET_ACCESS: '[' (STRING | INT) ']';

fragment ACCESS: BRACKET_ACCESS | ('.' ID);

STRING: '"' (ESC | ~["\\])* '"' ;

fragment ESC: '\\' (["\\/bfnrt]) ;

FLOAT: INT '.' [0-9]+ ;

INT: '-'? ('0' | [1-9] [0-9]*) ;

COMMENT: ('#' .*? ('\n' | EOF)) -> skip ;

WS: [ \r\n\t]+ -> skip ;