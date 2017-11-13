grammar Hplusplus;
prog  : classDef* expr;


name :ID;
type : ID;

classDef : '@' name OPEN_BLOCK memberDefs CLOSE_BLOCK;

memberDefs: memberDef*;

memberDef
: fieldDef
| methodDef
;

fieldDef : varDef END;
methodDef : name '(' params? ')' ':' type block;

params : param (',' param)*;
args : expr (',' expr)*;
block : blockStmt;

param : varDef;

varDef : name ':' type;

stmt
: exprStmt
| varDefStmt
| ifStmt
| forStmt
| returnStmt
| blockStmt
| assignStmt
| printStmt
| observeStmt
;

varDefStmt : varDef END;
exprStmt   : expr END;
ifStmt     : 'if' '(' expr ')' stmt ('else' stmt)?;
forStmt    : 'for' '(' expr ')' stmt;
returnStmt : RETURN expr END;
blockStmt  : OPEN_BLOCK stmt* CLOSE_BLOCK;
assignStmt : (self)? name '<<' expr END;
printStmt  : PRINT expr (',' expr)* END;
observeStmt: expr OBSERVE name OF expr END;

expr
: numberLiteral
| stringLiteral
| booleanLiteral
| invocation
| name
| memberSelection
| assocExpr
| self
| it
| uniOp
| binOp
| instantiation
;

numberLiteral: NUMBER;
stringLiteral: STRING;
booleanLiteral: BOOL;

uniOp : OP expr;
binOp :'(' expr OP expr ')';
instantiation: NEW name;

invocation : 'do' expr ('with' args)?;
memberSelection: name OF expr | self name;
assocExpr: '(' expr ')';
self:SELF;
it: IT;

OBSERVE : '~>';

SELF : 'my' | 'me';
IT : 'it';

OF : 'of';

PRINT: 'show';

NEW : 'new';

OP : 'not' | '==' | '!=' | 'and' | 'or' | '<'| '>'| '<=' | '>=' | '+' | '-' | '*' | '/';

BOOL : 'yes' | 'no';

NUMBER : [0-9]+;

ID : [a-zA-Z]+ ;             // match letters as identifiers



OPEN_SEQ : '(';
CLOSE_SEQ: ')' ;
OPEN_BLOCK : '(:';
CLOSE_BLOCK : ':)' ;
RETURN : '>>';
END : '.';


STRING : '"' ( '\\' [\\"] | ~[\\"\r\n] )* '"';
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines