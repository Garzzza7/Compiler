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
     | foreach
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
    | 'point' ID (', ' ID)* ';'
    | ID '=' '(' ID ')' ';'
    | 'point'? ID '=' expression ';'
    | pointAssignment
    | expression
    | '<' ID ',' ID '>' 'as' ID ('--' ID)* ';'
    | 'place' '<' ID ',' ID '>' '#label' '[''align' '=' align ']' 'at' ID';'
    | '<' ID ',' ID '>' '#label' '[''align' '=' align ']' ';'
    | 'grid' expression '(' expression ',' expression')' '[' (gridStatement ', ')* gridStatement']' ';'
    ;
align:
    'below'
    | 'above'
    | 'below left'
    | 'below right'
    | 'right'
    | 'left'
;
gridStatement:
    'step' '=' expression
    | 'margin' '=' expression
    | 'color' '=' color
    | 'line' '=' line
;
color:
    'gray'
    | 'red'
    | 'green'
    | 'blue'
;
line:
    'solid'
;
placeAssignment:
    ID 'at' '(' expression ',' expression')'
    ;

pointAssignment:
    expression '=' '(' ID ')' ';'
    | 'point' expression '=' expression ';'
    ;

expression:
      '(' expression ':' expression ')' #ColonExpression
    | '(' expression ',' expression ')' #ComaExpression
    | '(' expression ';' expression ')' #SemicolonExpression
    | '-' expression #NegativeExpression
    | '('expression')' #ParenthesisExpression
    | expression op=('/' | '*') expression #DivisionAndMultiplicationExpression
    | expression op=('+' | '-') expression #AdditionAndSubtractionExpression
    | INTEGER #IntegerExpression
    | FLOAT #FloatExpression
    | ID #IDExpression
    ;

animation:
    'animation' ID '<<<'  animationStatement  '>>>'
    ;

animationStatement:
    viewport
    on
    ;

viewport:
    'viewport' ID 'for' ID 'at' '(' expression ',' expression ')' '--' '++' '(' expression ',' expression ')' ';'
    ;

on:
    'on' ID '<<<' onStatement* '>>>'
    ;

onStatement:
    'show' (((ID)|('<' ID ',' ID '>') | (ID '[' ('initial'|'accepting') '=' ('false'|'true')) ']')) (', '(((ID)|('<' ID ',' ID '>') | (ID '[' ('initial'|'accepting') '=' ('false'|'true')) ']')))* ';'
    | 'pause' ';'
    //| ('show' '<' ID ',' ID '>') ';'
    | foreach
    ;
foreach:
    'for' ID 'in' '{{'expression (', 'expression)* '}}'  foreachStatement
     |'for' ID 'in' '{{'expression (', 'expression)* '}}' '<<<' foreachStatement+ '>>>'
    ;

foreachStatement:
    'show' ID '[' ('initial'|'accepting') '=' ('false'|'true') ']' ';'
    | ID '[' ('initial'|'accepting') '=' ('false'|'true') ']' ';'
 ;
play:
    'play' ID ';'
    ;

/* -- LEXER -- */

INTEGER:[0-9]+;

FLOAT:[0-9]+'.'[0-9]*;
ID: ([a-zA-Z]|[0-9]|'_')+;
WS: [ \n\r\t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT2: '/*' .*? '*/' -> skip;
ERROR: .;
