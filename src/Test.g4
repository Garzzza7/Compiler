grammar Test;
program:
    alphabet sector* EOF
    ;

sector:
    automaton
    | view
    | animation
    | play
    ;

alphabet:
    'alphabet'  '{' '\''ID'\''(', ' '\''ID'\'')* '}'
    ;

automaton:
    automatonType ID '<<<'
    automatonStatement*
    '>>>'
    ;

automatonStatement:
     'state' ID(', 'ID)*';'
     | ID '[' ('initial'|'accepting') '=' ('false'|'true') ']' ';'
     | transition
     ;

foreach:
    'for' ID 'in' '{{'ID (', 'ID)* '}}' '<<<' foreachStatement '>>>'
    ;

foreachStatement:

    ;

transition:
      'transition'
        (ID '->' '\'' ID '\'' (',' '\'' ID '\'')* '->' ID ',' )*
         ID '->' '\'' ID '\'' (',' '\'' ID '\'')* '->' ID ';'
         ;

automatonType:
        'NFA'
    |   'DFA'
    |   'complete DFA'
    ;

view:
    'view' ID 'of' ID '<<<'  viewStatement*  '>>>'
    ;

viewStatement:
    'place'  placeAssignment(', ' placeAssignment)* ';'
    | 'point' ID ';'
    | ID '=' '(' ID ')' ';'
    | 'point'? ID '=' expression ';'
    | pointAssignment
    | expression
    | '<' ID ',' ID '>' 'as' ID ('--' ID)* ';'
    | 'place' '<' ID ',' ID '>' '#label' '[''align' '=' 'below'']' 'at' ID';'
    ;

placeAssignment:
    ID 'at' '(' expression ',' expression')'
    ;

pointAssignment:
    expression '=' '(' ID ')' ';'
    | 'point' expression '=' expression ';'
    ;

expression:
    ID
    | '(' expression ':' expression ')'
    | '(' expression ',' expression ')'
    | '(' expression ';' expression ')'
    | INTEGER
    | FLOAT
    | '-' expression
    | '('expression')'
    | expression op=('+' | '-' | '/' | '*' | '=') expression
    ;

animation:
    'animation' ID '<<<'  animationStatement*  '>>>'
    ;

animationStatement:
    viewport on
    ;

viewport:
    'viewport' ID 'for' ID 'at' '(' expression ',' expression ')' '--' '++' '(' expression ',' expression ')' ';'
    ;

on:
    'on' ID '<<<' onStatement* '>>>'
    ;

onStatement:
    'show' (((ID) | (ID '[' ('initial'|'accepting') '=' ('false'|'true')) ']')) (', '(((ID) | (ID '[' ('initial'|'accepting') '=' ('false'|'true')) ']')))* ';'
    | 'pause' ';'
    | 'show' '<' ID ',' ID '>' ';'
    ;

play:
    'play' ID ';'
    ;

/* -- LEXER -- */

INTEGER:[0-9]+;
ID: ([a-zA-Z]|[0-9]|'_')+;
FLOAT:[0-9]+'.'[0-9]*;

WS: [ \n\r\t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT2: '/*' .*? '*/' -> skip;
ERROR: .;
