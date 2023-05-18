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
transition:
      'transition' //NEWLINE
        (ID '->' '\'' ID '\'' (',' '\'' ID '\'')* '->' ID ',' /*NEWLINE*/)*
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
;
placeAssignment:
    ID 'at' '('INTEGER ', ' INTEGER')'
;
pointAssignment:
         expression '=' '(' ID ')' ';'
        | 'point' expression '=' expression ';'
;
expression:
     ID
    | '(' expression ':' expression ')'
    | INTEGER
    | FLOAT
    | '-' expression
    | expression op=('+' | '-' | '/' | '*' | '=') expression

;
animation:
    'animation' ID '<<<' animationStatement* '>>>'
;
animationStatement:
    viewport on
;
viewport:
    'viewport' ID 'for' ID 'at' '(' INTEGER ',' INTEGER ')' '--' '++' '(' INTEGER ',' INTEGER ')' ';'
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
ID: ([a-zA-Z]|[0-9]|'_')+;
FLOAT:[0-9]+'.'[0-9]*;

INTEGER:[0-9]+;

WS: [ \n\r\t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT2: '/*' .*? '*/' -> skip;
ERROR: .;
