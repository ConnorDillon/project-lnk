grammar Link;		

prog: (assign (';' | EOF))* pipe? EOF ;

expr: INT # Int
    | FLOAT # Float
    | STRING # String
    | FIELD # Field
    | ID # Id
    | ID expr+ # Apply
    | '(' pipe ')' # SubExpr
    | '(' pipe ')' expr+ # ApplyExpr
    | '{' pair (',' pair)* '}' # Object
    | '{' '}' # EmptyObject
    | '[' pipe (',' pipe)* ']' # Array
    | '[' ']' # EmptyArray
    | '(' ((pipe ',') | (pipe (',' pipe)+)) ')' # Stream
    | '(' ')' # EmptyStream
    | 'if' oper 'then' oper 'else' oper # If
    | 'let' assign (';' assign)* 'in' oper # Let
    | '\\' ID+ '.' oper # Lambda
    ;

oper: expr # ExprOper
    | oper op=('*' | '/') oper # MulDiv
    | oper op=('+' | '-') oper # AddSub
    | oper op=('>' | '<' | '>=' | '<=' | '!=' | '==') oper # Compare
    | oper op='and' oper # And
    | oper op='or' oper # Or
    | oper op=':' oper # Cons
    ;

pipe: oper # OperPipe
    | pipe op='|' pipe # PipeOper
    ;

assign: ID+ '=' pipe ;

pair: (ID | STRING) ':' pipe;

ID: [a-zA-Z] [a-zA-Z\-_0-9]* ;

FIELD: ID (('[' (STRING | INT) ']') | ('.' ID))+ ;

STRING: '"' (ESC | ~["\\])* '"' ;

fragment ESC: '\\' (["\\/bfnrt]) ;

FLOAT: INT '.' [0-9]+ ;

INT: '-'? ('0' | [1-9] [0-9]*) ;

COMMENT: ('#' .*? ('\n' | EOF)) -> skip ;

WS: [ \r\n\t]+ -> skip ;
