grammar MIDL;

@header{
	package antlr4;
}

// Start Variable

specification: definition+ EOF
	;
definition: type_decl ';'       #DefinitionToTypeDecl
    | module ';'        #DefinitionToModule
	;
module: MODULE ID '{' definition+ '}'
	;
type_decl: struct_type      #TypeDeclToStructType
        | STRUCT ID      #TypeDeclToStructId
	;
struct_type: STRUCT ID '{' member_list '}'
	;
member_list: ( type_spec declarators ';' )*
    ;
type_spec: scoped_name      #TypeSpecToScopedName
        | base_type_spec      #TypeSpecToBaseTypeSpec
        | struct_type      #TypeSpecToStructType
	;
scoped_name: ('::')? ID ('::' ID )*
	;
base_type_spec: floating_pt_type        #BaseTypeSpecToFloatingPtType
    | integer_type      #BaseTypeSpecToIntegerType
    | CHARTYPE      #BaseTypeSpecToChar
    | STRINGTYPE      #BaseTypeSpecToString
    | BOOLEANTYPE      #BaseTypeSpecToBoolean
	;
floating_pt_type: FLOAT        #FloatToFloat
        | DOUBLE        #FloatToDouble
        | LONG DOUBLE        #FloatToLongDouble
	;
integer_type: signed_int        #IntegerTypeToSignedInt
        | unsigned_int      #IntegerTypeToUnSignedInt
	;
signed_int:(SHORT|INT16)    #SignedIntToInt16
        |(LONG|INT32)    #SignedIntToInt32
        |(LONG LONG|INT64)    #SignedIntToInt64
        |INT8    #SignedIntToIn8
    ;
unsigned_int: (UNSIGNED SHORT| UINT16)    #UnSignedIntToUint16
        | (UNSIGNED LONG| UINT32)    #UnSignedIntToUint32
        | (UNSIGNED LONG LONG | UINT64)    #UnSignedIntToUint64
        | UINT8    #UnSignedIntToUint8
    ;
declarators: declarator (',' declarator )*
    ;
declarator: simple_declarator       #DeclaratorToSimpleDeclarator
        | array_declarator      #DeclaratorToArrayDeclarator
    ;
simple_declarator: ID ('=' or_expr)?
    ;
array_declarator: ID '[' or_expr ']' ('=' exp_list )?
    ;
exp_list: '[' or_expr ( ','or_expr )* ']'
    ;
or_expr: xor_expr ('|' xor_expr )*
    ;
xor_expr: and_expr ('^' and_expr )*
    ;
and_expr: shift_expr ('&' shift_expr )*
    ;
shift_expr: add_expr (('>>' | '<<') add_expr )*
    ;
add_expr: mult_expr (('+' | '-') mult_expr )*
    ;
mult_expr: unary_expr (('*' |'/'|'%') unary_expr)*
    ;
unary_expr: ('-'| '+' | '~')? literal
    ;
literal: INTEGER        #LiteralToInteger
    | FLOATING_PT       #LiteralToFloatingPoint
    | CHAR      #LiteralToChar
    | STRING        #LiteralToString
    | BOOLEAN       #LiteralToBoolean
    ;


MODULE:'module';
STRUCT:'struct';
BOOLEANTYPE:'boolean';
SHORT:'short';
LONG:'long';
UNSIGNED:'unsigned';
INT8:'int8';
INT16:'int16';
INT32:'int32';
INT64:'int64';
UINT8:'uint8';
UINT16:'uint16';
UINT32:'uint32';
UINT64:'uint64';
CHARTYPE:'char';
STRINGTYPE:'string';
FLOAT:'float';
DOUBLE:'double';

fragment LETTER:[a-z] | [A-Z];
fragment UNDERLINE: '_';
fragment DIGIT:[0-9];
INTEGER: ('0' | [1-9] [0-9]*) INTEGER_TYPE_SUFFIX?;

fragment EXPONENT: ( 'e' | 'E') ( '+' | '-' )? [0-9]+;
fragment FLOAT_TYPE_SUFFIX:  'f' | 'F' | 'd' | 'D';
fragment INTEGER_TYPE_SUFFIX:   'l' | 'L';

FLOATING_PT:  [0-9]+ '.' [0-9]*  EXPONENT?  FLOAT_TYPE_SUFFIX?
   				|  '.' [0-9]+  EXPONENT?  FLOAT_TYPE_SUFFIX?
   				|  [0-9]+  EXPONENT  FLOAT_TYPE_SUFFIX?
   				|  [0-9]+  EXPONENT?  FLOAT_TYPE_SUFFIX;

fragment ESCAPE_SEQUENCE:  '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\' );

BOOLEAN:  'TRUE' | 'true' | 'FALSE' | 'false';
CHAR: '\''(ESCAPE_SEQUENCE |  (~'\\' | ~'\'') )'\'';
STRING: '"' (ESCAPE_SEQUENCE |  (~'\\' | ~'"') )* '"';

ID: LETTER (UNDERLINE? (LETTER | DIGIT))*;
WS: [ \t\r\n]+ -> skip;



