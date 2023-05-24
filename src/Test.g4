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
    'alphabet'  '{' '\''SYMBOL'\''(', ' '\''SYMBOL'\'')* '}'
    ;

automaton:
    automatonType ID '<<<'
    automatonStatement*
    '>>>'
    ;

automatonStatement:
     'state' ID(', 'ID)*';'
     | ID '[' role=('initial'|'accepting') '=' value=('false'|'true') ']' ';'
     | transition
     | foreach
     ;



transition:
      'transition'
        (ID '->' '\'' SYMBOL '\'' (',' '\'' SYMBOL '\'')* '->' ID ',' )*
         ID '->' '\'' SYMBOL '\'' (',' '\'' SYMBOL '\'')* '->' ID ';'
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
    | /*'point'?*/ ID '=' expression ';'
    | pointAssignment
    //| expression
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
      '(' expression ':' expression ')'     #ColonExpression
    | '(' expression ',' expression ')'     #ComaExpression
    | '(' expression ';' expression ')'     #SemicolonExpression
    | '-' expression                        #NegativeExpression
    | '('expression')'                      #ParenthesisExpression
    | expression op=('/' | '*') expression  #DivisionAndMultiplicationExpression
    | expression op=('+' | '-') expression  #AdditionAndSubtractionExpression
    | INTEGER                               #IntegerExpression
    | FLOAT                                 #FloatExpression
    | ID                                    #IDExpression
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
    'for' SYMBOL 'in' '{{'expression (', 'expression)* '}}'  foreachStatement
     |'for' SYMBOL 'in' '{{'expression (', 'expression)* '}}' '<<<' foreachStatement+ '>>>'
    ;

foreachStatement:
    'show' SYMBOL '[' ('initial'|'accepting') '=' ('false'|'true') ']' ';'
    | SYMBOL '[' ('initial'|'accepting') '=' ('false'|'true') ']' ';'
 ;
play:
    'play' ID ';'
    ;

/* -- LEXER -- */

INTEGER:[0-9]+;
SYMBOL:[a-z];
FLOAT:[0-9]+'.'[0-9]*;
ID: ([a-zA-Z]|[0-9]|'_')+;
WS: [ \n\r\t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT2: '/*' .*? '*/' -> skip;
ERROR: .;
