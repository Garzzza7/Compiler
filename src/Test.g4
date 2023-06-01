grammar Test;

@parser::header {
import java.util.Map;
import java.util.HashMap;
}

@parser::members {
static protected Map<String,Symbol> symbolTable = new HashMap<>();
}

program:
    sectorList EOF
    ;
sectorList:
    alphabet sector*
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
    'state' stateCreationID(', 'stateCreationID)*';'
;
stateCreationID:
    ID
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
    | 'point' pointID (', ' pointID)* ';'                                                               #pointView
    //| ID '=' '(' ID ')' ';'                                                                             #valueView
    | /*'point'?*/ ID '=' expression ';'                                                                #expressionView
    | pointAssignment                                                                                   #pointView
    //| expression
    | '<' ID ',' ID '>' 'as' ID ('--' ID)* ';'                                                          #pointModificationView1
    | 'place' '<' ID ',' ID '>' '#label' '[''align' '=' align ']' 'at' ID';'                            #pointModificationView2
    | '<' ID ',' ID '>' '#label' '[''align' '=' align ']' ';'                                           #pointModificationView3
    | 'grid' e1=expression '(' e2=expression ',' e3=expression')' '[' (gridStatement ', ')* gridStatement']' ';' #gridView
    ;
pointID:
    ID
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
    ID 'at' '(' e1=expression ',' e2=expression')'
    ;

pointAssignment:
    e1=expression '=' e2=expression ';'
    | 'point' e1=expression '=' e2=expression ';'
    ;

expression returns[Type eType,String varName]:
      '(' e1=expression ':' e2=expression ')'     #ColonExpression
    | '(' e1=expression ',' e2=expression ')'     #ComaExpression
    | '(' e1=expression ';' e2=expression ')'     #SemicolonExpression
    | '-' e=expression                        #NegativeExpression
    | '('e=expression')'                      #ParenthesisExpression
    | e1=expression op=('/' | '*') e2=expression  #DivisionAndMultiplicationExpression
    | e1=expression op=('+' | '-') e2=expression  #AdditionAndSubtractionExpression
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
    'viewport' ID 'for' ID 'at' '(' e1=expression ',' e2=expression ')' '--' '++' '(' e3=expression ',' e4=expression ')' ';'
    ;

on:
    'on' ID '<<<' onStatement* '>>>'
    ;

onStatement:
    'show' onStatementShow (', 'onStatementShow)* ';'
    | onStatementPause
    //| ('show' '<' ID ',' ID '>') ';'
    | foreach
    ;
onStatementShow:
//     (((ID)|('<' ID ',' ID '>') | (ID '[' role=('initial'|'accepting') '=' value=('false'|'true')) ']')) (', '(((ID)|('<' ID ',' ID '>') | (ID '[' role=('initial'|'accepting') '=' value=('false'|'true')) ']')))* ';'
    onStatementShowID
    | onStatementShowTransitions
    | onStatementShowIDwithChange
;
onStatementShowID:
       ID
;
onStatementShowTransitions:
    '<' ID ',' ID '>'
;
onStatementShowIDwithChange:
    ID '[' role=('initial'|'accepting') '=' value=('false'|'true') ']'
;
onStatementPause:
    'pause' ';'
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