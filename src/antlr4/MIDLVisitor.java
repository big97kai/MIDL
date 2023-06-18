// Generated from MIDL.g4 by ANTLR 4.9.3

	package antlr4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MIDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MIDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MIDLParser#specification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecification(MIDLParser.SpecificationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinitionToTypeDecl}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionToTypeDecl(MIDLParser.DefinitionToTypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinitionToModule}
	 * labeled alternative in {@link MIDLParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitionToModule(MIDLParser.DefinitionToModuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModule(MIDLParser.ModuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDeclToStructType}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclToStructType(MIDLParser.TypeDeclToStructTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDeclToStructId}
	 * labeled alternative in {@link MIDLParser#type_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclToStructId(MIDLParser.TypeDeclToStructIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#struct_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_type(MIDLParser.Struct_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#member_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_list(MIDLParser.Member_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeSpecToScopedName}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecToScopedName(MIDLParser.TypeSpecToScopedNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeSpecToBaseTypeSpec}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecToBaseTypeSpec(MIDLParser.TypeSpecToBaseTypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeSpecToStructType}
	 * labeled alternative in {@link MIDLParser#type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecToStructType(MIDLParser.TypeSpecToStructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#scoped_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScoped_name(MIDLParser.Scoped_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseTypeSpecToFloatingPtType}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeSpecToFloatingPtType(MIDLParser.BaseTypeSpecToFloatingPtTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseTypeSpecToIntegerType}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeSpecToIntegerType(MIDLParser.BaseTypeSpecToIntegerTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseTypeSpecToChar}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeSpecToChar(MIDLParser.BaseTypeSpecToCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseTypeSpecToString}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeSpecToString(MIDLParser.BaseTypeSpecToStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseTypeSpecToBoolean}
	 * labeled alternative in {@link MIDLParser#base_type_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeSpecToBoolean(MIDLParser.BaseTypeSpecToBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatToFloat}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatToFloat(MIDLParser.FloatToFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatToDouble}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatToDouble(MIDLParser.FloatToDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatToLongDouble}
	 * labeled alternative in {@link MIDLParser#floating_pt_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatToLongDouble(MIDLParser.FloatToLongDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerTypeToSignedInt}
	 * labeled alternative in {@link MIDLParser#integer_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerTypeToSignedInt(MIDLParser.IntegerTypeToSignedIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerTypeToUnSignedInt}
	 * labeled alternative in {@link MIDLParser#integer_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerTypeToUnSignedInt(MIDLParser.IntegerTypeToUnSignedIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SignedIntToInt16}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedIntToInt16(MIDLParser.SignedIntToInt16Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SignedIntToInt32}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedIntToInt32(MIDLParser.SignedIntToInt32Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SignedIntToInt64}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedIntToInt64(MIDLParser.SignedIntToInt64Context ctx);
	/**
	 * Visit a parse tree produced by the {@code SignedIntToIn8}
	 * labeled alternative in {@link MIDLParser#signed_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedIntToIn8(MIDLParser.SignedIntToIn8Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnSignedIntToUint16}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnSignedIntToUint16(MIDLParser.UnSignedIntToUint16Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnSignedIntToUint32}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnSignedIntToUint32(MIDLParser.UnSignedIntToUint32Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnSignedIntToUint64}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnSignedIntToUint64(MIDLParser.UnSignedIntToUint64Context ctx);
	/**
	 * Visit a parse tree produced by the {@code UnSignedIntToUint8}
	 * labeled alternative in {@link MIDLParser#unsigned_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnSignedIntToUint8(MIDLParser.UnSignedIntToUint8Context ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#declarators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarators(MIDLParser.DeclaratorsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclaratorToSimpleDeclarator}
	 * labeled alternative in {@link MIDLParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaratorToSimpleDeclarator(MIDLParser.DeclaratorToSimpleDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclaratorToArrayDeclarator}
	 * labeled alternative in {@link MIDLParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaratorToArrayDeclarator(MIDLParser.DeclaratorToArrayDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#simple_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_declarator(MIDLParser.Simple_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#array_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_declarator(MIDLParser.Array_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#exp_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_list(MIDLParser.Exp_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expr(MIDLParser.Or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#xor_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor_expr(MIDLParser.Xor_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(MIDLParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expr(MIDLParser.Shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#add_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_expr(MIDLParser.Add_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#mult_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult_expr(MIDLParser.Mult_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MIDLParser#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(MIDLParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralToInteger}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralToInteger(MIDLParser.LiteralToIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralToFloatingPoint}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralToFloatingPoint(MIDLParser.LiteralToFloatingPointContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralToChar}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralToChar(MIDLParser.LiteralToCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralToString}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralToString(MIDLParser.LiteralToStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralToBoolean}
	 * labeled alternative in {@link MIDLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralToBoolean(MIDLParser.LiteralToBooleanContext ctx);
}