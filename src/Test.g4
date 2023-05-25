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
     stateCreation
     | stateAssignment
     | transition
     | foreach
     ;

stateCreation:
    'state' ID(', 'ID)*';'
;
stateAssignment:
    ID '[' role=('initial'|'accepting') '=' value=('false'|'true') ']' ';'
;

transition:
      'transition'
        (transitionStatement',' )*
         transitionStatement';'
         ;
transitionStatement:
       ID '->' '\'' SYMBOL '\'' (',' '\'' SYMBOL '\'')* '->' ID
;
automatonType:
     AUTOMATONNAME
    ;

view:
    'view' ID 'of' ID '<<<'  viewStatement*  '>>>'
    ;

viewStatement:
    'place'  placeAssignment(', ' placeAssignment)* ';'                                                 #placeView
    | 'point' ID (', ' ID)* ';'                                                                         #pointView
    //| ID '=' '(' ID ')' ';'                                                                             #valueView
    | /*'point'?*/ ID '=' expression ';'                                                                #expressionView
    | pointAssignment                                                                                   #pointView
    //| expression
    | '<' ID ',' ID '>' 'as' ID ('--' ID)* ';'                                                          #pointModificationView1
    | 'place' '<' ID ',' ID '>' '#label' '[''align' '=' align ']' 'at' ID';'                            #pointModificationView2
    | '<' ID ',' ID '>' '#label' '[''align' '=' align ']' ';'                                           #pointModificationView3
    | 'grid' expression '(' expression ',' expression')' '[' (gridStatement ', ')* gridStatement']' ';' #gridView
    ;
align:
    ALIGN
;
gridStatement:
    'step' '=' expression       #stepValue
    | 'margin' '=' expression   #marginValue
    | 'color' '=' color         #colorValue
    | 'line' '=' line           #lineValue
;
color:
    COLOR
;
line:
    LINE
;
placeAssignment:
    ID 'at' '(' expression ',' expression')'
    ;

pointAssignment:
    expression '=' expression ';'
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
    'show' SYMBOL '[' role=('initial'|'accepting') '=' value=('false'|'true') ']' ';'
    | SYMBOL '[' role=('initial'|'accepting') '=' value=('false'|'true') ']' ';'
 ;
play:
    'play' ID ';'
    ;

/* -- LEXER -- */
ALIGN:'below'|'above'|'below left'|'below right'|'right'|'left';
LINE:'solid'|'dotted'| 'dashed';
COLOR:'gray'|'red'|'green'|'blue';
AUTOMATONNAME:'NFA'|'DFA'|'complete DFA';
INTEGER:[0-9]+;
SYMBOL:[a-z];
FLOAT:[0-9]+'.'[0-9]*;
ID: ([a-zA-Z]|[0-9]|'_')+;
WS: [ \n\r\t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT2: '/*' .*? '*/' -> skip;
ERROR: .;