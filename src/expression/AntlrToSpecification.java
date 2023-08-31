package expression;

import antlr4.MIDLBaseVisitor;
import antlr4.MIDLParser;
import app.ExpOneOutPut;
import app.SymbolTable;
import bean.Genration.Structs;
import bean.struct.Specification;
import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.List;

public class AntlrToSpecification extends MIDLBaseVisitor<Specification> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     *
     * @param ctx
     */
    private List<String> semanticErrors;
    private int indentationTimes = 1;
    private SymbolTable symbolTable;

    private ExpOneOutPut expOneOutPut;
    public ExpOneOutPut getExpOneOutPut() {
        return expOneOutPut;
    }

    private ST st;
    public List<String> getSemanticErrors() {
        return semanticErrors;
    }

    public AntlrToSpecification(ST st){

        this.symbolTable = new SymbolTable();
        this.semanticErrors = new ArrayList<>();
        this.expOneOutPut = new ExpOneOutPut();
        expOneOutPut.addOneName("Specification", 0);
        this.st = st;
    }
    @Override
    public Specification visitSpecification(MIDLParser.SpecificationContext ctx) {
        Specification specification = new Specification();
        Structs structs = new Structs();


        AntlrToDefinition definitionVisitor = new AntlrToDefinition(semanticErrors, indentationTimes+1, expOneOutPut, symbolTable, structs);

        for (int i = 0; i < ctx.getChildCount(); i++) {

            if (i == ctx.getChildCount() - 1) {

            } else {
                System.out.println(ctx.getChild(i).getText());
                expOneOutPut.addOneName("Definition", indentationTimes);
                specification.addDefinition(definitionVisitor.visit(ctx.getChild(i)));
            }
        }
        st.add("structs", structs);

        return specification;
    }
}
