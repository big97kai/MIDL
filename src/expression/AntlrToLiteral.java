package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.literal.Char;
import bean.literal.FloatingPoint;
import bean.literal.Literal;
import bean.literal.String;
import org.antlr.v4.runtime.Token;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static app.MIDLapp.CURRENTTYPE;
import static app.MIDLapp.CURRENTTYPENAME;
import static app.VariableType.BASETYPE;

public class AntlrToLiteral extends MIDLBaseVisitor<Literal> {

    private List<java.lang.String> semanticErrors;
    private SymbolTable symbolTable;
    private int  indentationTimes;
    private ExpOneOutPut expOneOutPut;
    public AntlrToLiteral(List<java.lang.String> semanticErrors, int indentationTimes, ExpOneOutPut expOneOutPut, SymbolTable symbolTable) {

        this.expOneOutPut = expOneOutPut;
        this.semanticErrors = semanticErrors;
        this.indentationTimes = indentationTimes;
        this.symbolTable = symbolTable;
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
    public Literal visitLiteralToInteger(MIDLParser.LiteralToIntegerContext ctx) {

        Token idToken = ctx.INTEGER().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;
        java.lang.String str = ctx.getChild(0).getText();

        if(Character.isDigit(str.charAt(str.length()-1))){

        }else {

            str = str.substring(0, str.length()-1);

        }
        BigInteger value = new BigInteger(str);

        if(CURRENTTYPE == BASETYPE){

            if(CURRENTTYPENAME.equals("Int8")){

                int lower = value.compareTo(new BigInteger("-128"));
                int upper = value.compareTo(new BigInteger("127"));

                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if (CURRENTTYPENAME.equals("Int16")) {

                int lower = value.compareTo(new BigInteger("-32768"));
                int upper = value.compareTo(new BigInteger("32767"));

                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if (CURRENTTYPENAME.equals("Int32")) {

                int lower = value.compareTo(new BigInteger("-2147483648"));
                int upper = value.compareTo(new BigInteger("2147483647"));
                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if (CURRENTTYPENAME.equals("Int64")) {

                int lower = value.compareTo(new BigInteger("-9223372036854775808"));
                int upper = value.compareTo(new BigInteger("9223372036854775807"));
                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if(CURRENTTYPENAME.equals("Uint8")){

                int lower = value.compareTo(BigInteger.ZERO);
                int upper = value.compareTo(new BigInteger("255"));

                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if (CURRENTTYPENAME.equals("Uint16")) {

                int lower = value.compareTo(BigInteger.ZERO);
                int upper = value.compareTo(new BigInteger("65535"));

                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if (CURRENTTYPENAME.equals("Uint32")) {

                int lower = value.compareTo(BigInteger.ZERO);
                int upper = value.compareTo(new BigInteger("4294967295"));

                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if (CURRENTTYPENAME.equals("Uint64")) {

                int lower = value.compareTo(BigInteger.ZERO);
                int upper = value.compareTo(new BigInteger("18446744073709551615"));

                if(!(lower >= 0 && upper <= 0)){

                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else {

                semanticErrors.add("Error: Wrong type and value." + "(" + line + ", " + column + ")");
            }
        }else{

            semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
        }
        expOneOutPut.addOneName("Integer", indentationTimes);

        return new bean.literal.Integer(value);
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
    public Literal visitLiteralToFloatingPoint(MIDLParser.LiteralToFloatingPointContext ctx) {

        java.lang.String str = ctx.getChild(0).getText();
        if(str.charAt(str.length()-1) == 'f' || str.charAt(str.length()-1) == 'F' || str.charAt(str.length()-1) == 'd' || str.charAt(str.length()-1) == 'D'){

            str = str.substring(0, str.length()-1);
        }

        Token idToken = ctx.FLOATING_PT().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;

        BigDecimal value = new BigDecimal(str);

        if(CURRENTTYPE == BASETYPE){

            if(CURRENTTYPENAME.equals("Float")){

                try {
                    float floatValue = Float.parseFloat(str);
                } catch (NumberFormatException e) {
                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else if (CURRENTTYPENAME.equals("Double")) {

                try {
                    double doubleValue = Double.parseDouble(str);
                } catch (NumberFormatException e) {
                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }

            } else if (CURRENTTYPENAME.equals("LongDouble")) {

                try {
                    BigDecimal bigDecimalValue = new BigDecimal(str);

                } catch (NumberFormatException e) {
                    semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
                }
            } else {

                semanticErrors.add("Error: Wrong type and value." + "(" + line + ", " + column + ")");
            }
        }else{

            semanticErrors.add("Error: Out of range in " + "(" + line + ", " + column + ")");
        }

        expOneOutPut.addOneName("Float", indentationTimes);

        Literal literal = new FloatingPoint(value);
        return literal;
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
    public Literal visitLiteralToChar(MIDLParser.LiteralToCharContext ctx) {

        Token idToken = ctx.CHAR().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;

        expOneOutPut.addOneName("Char", indentationTimes);
        java.lang.String value = ctx.getChild(0).getText();

        if(CURRENTTYPE == BASETYPE && CURRENTTYPENAME.equals("Char") && value.length() == 3){

        }else {
            semanticErrors.add("Error: Wrong type and value." + "(" + line + ", " + column + ")");
        }
        Literal literal = new Char(value.charAt(0));
        return literal;
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
    public Literal visitLiteralToString(MIDLParser.LiteralToStringContext ctx) {

        expOneOutPut.addOneName("String", indentationTimes);
        Token idToken = ctx.STRING().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;
        if(CURRENTTYPE == BASETYPE && CURRENTTYPENAME.equals("String")){

        }else {
            semanticErrors.add("Error: Wrong type and value." + "(" + line + ", " + column + ")");
        }
        java.lang.String value = ctx.getChild(0).getText();

        Literal literal = new String(value);
        return literal;
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
    public Literal visitLiteralToBoolean(MIDLParser.LiteralToBooleanContext ctx) {

        Token idToken = ctx.BOOLEAN().getSymbol();
        int line = idToken.getLine();
        int column = idToken.getCharPositionInLine() + 1;
        expOneOutPut.addOneName("Boolean", indentationTimes);
        java.lang.String value = ctx.getChild(0).getText();

        if(CURRENTTYPE == BASETYPE && CURRENTTYPENAME.equals("Boolean") && (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false"))){

        }else {
            semanticErrors.add("Error: Wrong type and value." + "(" + line + ", " + column + ")");
        }
        Literal literal;
        if (value.equals("TRUE") || value.equals("true")) {

            literal = new bean.literal.Boolean(true);
        } else {

            literal = new bean.literal.Boolean(false);
        }
        return literal;
    }
}
