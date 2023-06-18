// Generated from MIDL.g4 by ANTLR 4.9.3

	package antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MIDLParser}.
 */
public interface MIDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MIDLParser#specification}.
	 * @param ctx the parse tree
	 */
	void enterSpecification(MIDLParser.SpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#specification}.
	 * @param ctx the parse tree
	 */
	void exitSpecification(MIDLParser.SpecificationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinitionToTypeDecl}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionToTypeDecl(MIDLParser.DefinitionToTypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinitionToTypeDecl}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionToTypeDecl(MIDLParser.DefinitionToTypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinitionToModule}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinitionToModule(MIDLParser.DefinitionToModuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinitionToModule}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinitionToModule(MIDLParser.DefinitionToModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(MIDLParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(MIDLParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDeclToStructType}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclToStructType(MIDLParser.TypeDeclToStructTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDeclToStructType}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclToStructType(MIDLParser.TypeDeclToStructTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDeclToStructId}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclToStructId(MIDLParser.TypeDeclToStructIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDeclToStructId}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclToStructId(MIDLParser.TypeDeclToStructIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#struct_type}.
	 * @param ctx the parse tree
	 */
	void enterStruct_type(MIDLParser.Struct_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#struct_type}.
	 * @param ctx the parse tree
	 */
	void exitStruct_type(MIDLParser.Struct_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#member_list}.
	 * @param ctx the parse tree
	 */
	void enterMember_list(MIDLParser.Member_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#member_list}.
	 * @param ctx the parse tree
	 */
	void exitMember_list(MIDLParser.Member_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeSpecToScopedName}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecToScopedName(MIDLParser.TypeSpecToScopedNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeSpecToScopedName}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecToScopedName(MIDLParser.TypeSpecToScopedNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeSpecToBaseTypeSpec}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecToBaseTypeSpec(MIDLParser.TypeSpecToBaseTypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeSpecToBaseTypeSpec}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecToBaseTypeSpec(MIDLParser.TypeSpecToBaseTypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeSpecToStructType}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecToStructType(MIDLParser.TypeSpecToStructTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeSpecToStructType}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecToStructType(MIDLParser.TypeSpecToStructTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#scoped_name}.
	 * @param ctx the parse tree
	 */
	void enterScoped_name(MIDLParser.Scoped_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#scoped_name}.
	 * @param ctx the parse tree
	 */
	void exitScoped_name(MIDLParser.Scoped_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTypeSpecToFloatingPtType}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecToFloatingPtType(MIDLParser.BaseTypeSpecToFloatingPtTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTypeSpecToFloatingPtType}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecToFloatingPtType(MIDLParser.BaseTypeSpecToFloatingPtTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTypeSpecToIntegerType}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecToIntegerType(MIDLParser.BaseTypeSpecToIntegerTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTypeSpecToIntegerType}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecToIntegerType(MIDLParser.BaseTypeSpecToIntegerTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTypeSpecToChar}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecToChar(MIDLParser.BaseTypeSpecToCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTypeSpecToChar}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecToChar(MIDLParser.BaseTypeSpecToCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTypeSpecToString}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecToString(MIDLParser.BaseTypeSpecToStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTypeSpecToString}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecToString(MIDLParser.BaseTypeSpecToStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTypeSpecToBoolean}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecToBoolean(MIDLParser.BaseTypeSpecToBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTypeSpecToBoolean}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecToBoolean(MIDLParser.BaseTypeSpecToBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatToFloat}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void enterFloatToFloat(MIDLParser.FloatToFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatToFloat}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void exitFloatToFloat(MIDLParser.FloatToFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatToDouble}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void enterFloatToDouble(MIDLParser.FloatToDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatToDouble}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void exitFloatToDouble(MIDLParser.FloatToDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatToLongDouble}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void enterFloatToLongDouble(MIDLParser.FloatToLongDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatToLongDouble}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 */
	void exitFloatToLongDouble(MIDLParser.FloatToLongDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerTypeToSignedInt}
	 * labeled alternative in {@link MIDLParser#integer_type}.
	 * @param ctx the parse tree
	 */
	void enterIntegerTypeToSignedInt(MIDLParser.IntegerTypeToSignedIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerTypeToSignedInt}
	 * labeled alternative in {@link MIDLParser#integer_type}.
	 * @param ctx the parse tree
	 */
	void exitIntegerTypeToSignedInt(MIDLParser.IntegerTypeToSignedIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerTypeToUnSignedInt}
	 * labeled alternative in {@link MIDLParser#integer_type}.
	 * @param ctx the parse tree
	 */
	void enterIntegerTypeToUnSignedInt(MIDLParser.IntegerTypeToUnSignedIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerTypeToUnSignedInt}
	 * labeled alternative in {@link MIDLParser#integer_type}.
	 * @param ctx the parse tree
	 */
	void exitIntegerTypeToUnSignedInt(MIDLParser.IntegerTypeToUnSignedIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SignedIntToInt16}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void enterSignedIntToInt16(MIDLParser.SignedIntToInt16Context ctx);
	/**
	 * Exit a parse tree produced by the {@code SignedIntToInt16}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void exitSignedIntToInt16(MIDLParser.SignedIntToInt16Context ctx);
	/**
	 * Enter a parse tree produced by the {@code SignedIntToInt32}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void enterSignedIntToInt32(MIDLParser.SignedIntToInt32Context ctx);
	/**
	 * Exit a parse tree produced by the {@code SignedIntToInt32}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void exitSignedIntToInt32(MIDLParser.SignedIntToInt32Context ctx);
	/**
	 * Enter a parse tree produced by the {@code SignedIntToInt64}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void enterSignedIntToInt64(MIDLParser.SignedIntToInt64Context ctx);
	/**
	 * Exit a parse tree produced by the {@code SignedIntToInt64}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void exitSignedIntToInt64(MIDLParser.SignedIntToInt64Context ctx);
	/**
	 * Enter a parse tree produced by the {@code SignedIntToIn8}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void enterSignedIntToIn8(MIDLParser.SignedIntToIn8Context ctx);
	/**
	 * Exit a parse tree produced by the {@code SignedIntToIn8}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 */
	void exitSignedIntToIn8(MIDLParser.SignedIntToIn8Context ctx);
	/**
	 * Enter a parse tree produced by the {@code UnSignedIntToUint16}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnSignedIntToUint16(MIDLParser.UnSignedIntToUint16Context ctx);
	/**
	 * Exit a parse tree produced by the {@code UnSignedIntToUint16}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnSignedIntToUint16(MIDLParser.UnSignedIntToUint16Context ctx);
	/**
	 * Enter a parse tree produced by the {@code UnSignedIntToUint32}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnSignedIntToUint32(MIDLParser.UnSignedIntToUint32Context ctx);
	/**
	 * Exit a parse tree produced by the {@code UnSignedIntToUint32}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnSignedIntToUint32(MIDLParser.UnSignedIntToUint32Context ctx);
	/**
	 * Enter a parse tree produced by the {@code UnSignedIntToUint64}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnSignedIntToUint64(MIDLParser.UnSignedIntToUint64Context ctx);
	/**
	 * Exit a parse tree produced by the {@code UnSignedIntToUint64}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnSignedIntToUint64(MIDLParser.UnSignedIntToUint64Context ctx);
	/**
	 * Enter a parse tree produced by the {@code UnSignedIntToUint8}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void enterUnSignedIntToUint8(MIDLParser.UnSignedIntToUint8Context ctx);
	/**
	 * Exit a parse tree produced by the {@code UnSignedIntToUint8}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 */
	void exitUnSignedIntToUint8(MIDLParser.UnSignedIntToUint8Context ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#declarators}.
	 * @param ctx the parse tree
	 */
	void enterDeclarators(MIDLParser.DeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#declarators}.
	 * @param ctx the parse tree
	 */
	void exitDeclarators(MIDLParser.DeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaratorToSimpleDeclarator}
	 * labeled alternative in {@link MIDLParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclaratorToSimpleDeclarator(MIDLParser.DeclaratorToSimpleDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaratorToSimpleDeclarator}
	 * labeled alternative in {@link MIDLParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclaratorToSimpleDeclarator(MIDLParser.DeclaratorToSimpleDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclaratorToArrayDeclarator}
	 * labeled alternative in {@link MIDLParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclaratorToArrayDeclarator(MIDLParser.DeclaratorToArrayDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclaratorToArrayDeclarator}
	 * labeled alternative in {@link MIDLParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclaratorToArrayDeclarator(MIDLParser.DeclaratorToArrayDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#simple_declarator}.
	 * @param ctx the parse tree
	 */
	void enterSimple_declarator(MIDLParser.Simple_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#simple_declarator}.
	 * @param ctx the parse tree
	 */
	void exitSimple_declarator(MIDLParser.Simple_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#array_declarator}.
	 * @param ctx the parse tree
	 */
	void enterArray_declarator(MIDLParser.Array_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#array_declarator}.
	 * @param ctx the parse tree
	 */
	void exitArray_declarator(MIDLParser.Array_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#exp_list}.
	 * @param ctx the parse tree
	 */
	void enterExp_list(MIDLParser.Exp_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#exp_list}.
	 * @param ctx the parse tree
	 */
	void exitExp_list(MIDLParser.Exp_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void enterOr_expr(MIDLParser.Or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#or_expr}.
	 * @param ctx the parse tree
	 */
	void exitOr_expr(MIDLParser.Or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#xor_expr}.
	 * @param ctx the parse tree
	 */
	void enterXor_expr(MIDLParser.Xor_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#xor_expr}.
	 * @param ctx the parse tree
	 */
	void exitXor_expr(MIDLParser.Xor_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(MIDLParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(MIDLParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#shift_expr}.
	 * @param ctx the parse tree
	 */
	void enterShift_expr(MIDLParser.Shift_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#shift_expr}.
	 * @param ctx the parse tree
	 */
	void exitShift_expr(MIDLParser.Shift_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#add_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdd_expr(MIDLParser.Add_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#add_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdd_expr(MIDLParser.Add_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#mult_expr}.
	 * @param ctx the parse tree
	 */
	void enterMult_expr(MIDLParser.Mult_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#mult_expr}.
	 * @param ctx the parse tree
	 */
	void exitMult_expr(MIDLParser.Mult_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MIDLParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(MIDLParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MIDLParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(MIDLParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralToInteger}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralToInteger(MIDLParser.LiteralToIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralToInteger}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralToInteger(MIDLParser.LiteralToIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralToFloatingPoint}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralToFloatingPoint(MIDLParser.LiteralToFloatingPointContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralToFloatingPoint}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralToFloatingPoint(MIDLParser.LiteralToFloatingPointContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralToChar}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralToChar(MIDLParser.LiteralToCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralToChar}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralToChar(MIDLParser.LiteralToCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralToString}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralToString(MIDLParser.LiteralToStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralToString}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralToString(MIDLParser.LiteralToStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralToBoolean}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteralToBoolean(MIDLParser.LiteralToBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralToBoolean}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteralToBoolean(MIDLParser.LiteralToBooleanContext ctx);
}