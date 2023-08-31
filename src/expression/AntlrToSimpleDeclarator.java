package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.*;
import bean.Genration.Struct;
import bean.Genration.Variable;
import bean.declarator.SimpleDeclarator;
import org.antlr.v4.runtime.Token;

import java.util.List;

import static app.MIDLapp.CURRENTTYPE;
import static app.VariableType.BASETYPE;
import static app.VariableType.SCOPE;

public class AntlrToSimpleDeclarator extends MIDLBaseVisitor<SimpleDeclarator> {

    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    private Struct struct;
    public AntlrToSimpleDeclarator(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable, Struct struct) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
        this.struct = struct;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    @Override
    public SimpleDeclarator visitSimple_declarator(MIDLParser.Simple_declaratorContext ctx) {

        String id = ctx.getChild(0).getText();

        expOneOutPut.addOneName("ID", indentationTimes);
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;

        if (CURRENTTYPE == BASETYPE){

            Variable variable = new Variable(id, MIDLapp.CURRENTTYPENAME);
            if (ctx.getChildCount() > 1) {

                variable.setIsSimple(false);
                variable.setValue(ctx.getChild(2).getText());
            } else {

                variable.setIsSimple(true);
            }
            if (MIDLapp.CURRENTTYPENAME.equals("String")) {

                variable.setString(true);
            } else {

                variable.setString(false);
            }
            struct.addViriable(variable);

        } else if (CURRENTTYPE == SCOPE) {

            Variable variable = new Variable(id, MIDLapp.CURRENTTYPENAME);

            variable.setIsSimple(true);

            variable.setString(false);

            struct.addViriable(variable);
        }

        if(CURRENTTYPE == BASETYPE){

            Symbol symbol = new Symbol(id, MIDLapp.CURRENTTYPENAME);

            if(symbolTable.currentScope().getSymbolMap().containsKey(id)){

                semanticErrors.add("Error: variable " + id + " double defined (" + line + ", " + column + ")");
            }else {

                symbolTable.currentScope().define(symbol);
            }
        }
        SimpleDeclarator simpleDeclarator = new SimpleDeclarator(id);
        if (ctx.getChildCount() > 1) {

            expOneOutPut.addOneName("OrNode", indentationTimes);
            AntlrToExpressionNode expressionNodeVisitor = new AntlrToExpressionNode(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable);
            simpleDeclarator.setExpression(expressionNodeVisitor.visit(ctx.getChild(2)));
        }

        return simpleDeclarator;
    }
}
