grammar Test;
program:
    alphabet sector* EOF
    ;
sector:
     automaton //NEWLINE
    | view //NEWLINE
    | animation //NEWLINE
    | play //NEWLINE
    ;
alphabet:
    //ALPHABET  '{' APOSTROPHE SingleLetter APOSTROPHE(', ' APOSTROPHE SingleLetter APOSTROPHE)* '}'
    'alphabet'  '{' '\''ID'\''(', ' '\''ID'\'')* '}'

   // ALPHABET  OpeningCurlyBracket SingleLetter(COMMA_WITHOUT_SPACE SingleLetter)* ClosingCurlyBracket
    ;
automaton:
   // automatonType FunctionName OpeningBracket  automatonStatement*  ClosingBracket
    automatonType ID '<<<' //NEWLINE
    automatonStatement* //NEWLINE
    '>>>'

;
automatonStatement:
//     STATE StateName(', 'StateName)*SEMICOLON
//     | StateName OpeningSquareBracket (INITIAL|ACCEPTING) EqualsSign (FALSE|TRUE) ClosingSquareBracket SEMICOLON
//     | TRANSITION NEWLINE
//        (StateName ARROW APOSTROPHE SingleLetter APOSTROPHE (COMMA APOSTROPHE SingleLetter APOSTROPHE)* ARROW StateName COMMA)*
//        StateName ARROW APOSTROPHE SingleLetter APOSTROPHE (COMMA APOSTROPHE SingleLetter APOSTROPHE)* ARROW StateName SEMICOLON
//     | NEWLINE
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
    'view' ID 'of' ID '<<<' /*NEWLINE*/ viewStatement* /*NEWLINE*/ '>>>'
;
viewStatement:
    'place'  placeAssignment(', ' placeAssignment)* ';'
//    | 'point' ID ';'
//    | ID '=' '(' ID ')' ';'
//    | 'point' ID '=' '(' (INTEGER|FLOAT) ':' (INTEGER|FLOAT) ')' ';'
//    | pointAssignment
//    | expression
//    | '<' ID ',' ID '>' 'as' ID ('--' ID)* ';'
;
placeAssignment:
    ID 'at' '('INTEGER ', ' INTEGER')'
;
pointAssignment:
//        'point' expression ';'
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
    'animation' ID '<<<' /*NEWLINE*/ animationStatement* /*NEWLINE*/ '>>>'
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
   // (ID) | (ID '[' ('initial'|'accepting') '=' ('false'|'true')) ']')
    'show' (((ID) | (ID '[' ('initial'|'accepting') '=' ('false'|'true')) ']')) (', '(((ID) | (ID '[' ('initial'|'accepting') '=' ('false'|'true')) ']')))* ';'
//    'show' ID ('[' ('initial'|'accepting') '=' ('false'|'true') ']') ';'
    | 'pause' ';'
    | 'show' '<' ID ',' ID '>' ';'
;
play:
    'play' ID ';'
;
ID: ([a-zA-Z]|[0-9]|'_')+;
FLOAT:[0-9]+'.'[0-9]*;
//PlusSign:'+';
//MinusSign:'-';
//DivSign:'/';
//MultSign:'*';
//AS:'as';
//COLON:':';
//POINT:'point';
//OpeningAngleBracket:'<';
//ClosingAngleBracket:'>';
//SHOW:'show';
//PAUSE:'pause';
//ON:'on';
//MINUSMINUS:'--';
//PLUSPLUS:'++';
//FOR:'for';
//VIEWPORT:'viewport';
//ANIMATION:'animation';
//PLAY:'play';
//OpeningParenthesis:'(';
//ClosingParenthesis:')';
INTEGER:[0-9]+;
//AT:'at';
//PLACE:'place';
//VIEW:'view';
//OF:'of';
//NEWLINE:'\r'? '\n';
//COMMA:(','|', ');
//SingleLetter:[a-z];
//APOSTROPHE:('\''|'’');
//ARROW:'->';
//TRANSITION:'transition';
//TRUE:'true';
//FALSE:'false';
//EqualsSign:'=';
//INITIAL:'initial';
//ACCEPTING:'accepting';
//STATE:'state';q

//FunctionName:[a-z]+[1-9];
//StateName:[A-Z];
//SEMICOLON:';';
//ALPHABET:'alphabet';
//OpeningCurlyBracket:'{';
//OPENING_CURLY_BRACKET:'{';
//ClosingCurlyBracket:'}';
//OpeningSquareBracket:'[';
//ClosingSquareBracket:']';
//OpeningBracket:'<<<';
//ClosingBracket:'>>>';
//DFA:'DFA';
//NFA:'NFA';
//CDFA:'complete DFA';
WS: [ \n\r\t]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
COMMENT2: '/*' .*? '*/' -> skip;
ERROR: .;
