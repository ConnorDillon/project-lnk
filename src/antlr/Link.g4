grammar Link;		

prog: (assign (';' | EOF))* pipe? EOF ;

expr: INT # Int
    | FLOAT # Float
    | STRING # String
    | RAW_STRING # RawString
    | expr '.' expr # Dot
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
    | oper op='::' oper # Cons
    ;

pipe: oper # OperPipe
    | pipe op='|' pipe # PipeOper
    ;

assign: ID+ '=' pipe ;

pair: (ID | STRING) ':' pipe;

ID: [a-zA-Z] [a-zA-Z\-_0-9]* ;

FLOAT: INT '.' [0-9]+ ;

INT: '-'? ('0' | [1-9] [0-9]*) ;

RAW_STRING: '\'' ( '\'\'' | ~['] )* '\'' ;

STRING: '"' (ESC | ~["\\])* '"' ;

fragment ESC: '\\' (["\\/bfnrt]) ;

WS: [ \r\n\t]+ -> skip ;

COMMENT: ('#' .*? ('\n' | EOF)) -> skip ;
