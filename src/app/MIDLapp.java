package app;

import antlr4.MIDLLexer;
import antlr4.MIDLParser;
import bean.struct.Specification;
import expression.AntlrToSpecification;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import org.stringtemplate.v4.ST;

import java.io.*;
import java.util.List;

import java.io.IOException;

public class MIDLapp {

    public static VariableType CURRENTTYPE;

    public static String CURRENTTYPENAME = "";
    public static void main(String[] args) {


        if (args.length != 1) {

            System.err.println("Usage: file name");
        } else {

            String fileName = args[0];

            STGroup cTemplate = new STGroupFile("E:\\Out-Nwpu\\MIDLCompiler\\MIDLCompiler\\src\\app\\StTranslate.stg");

            ST st = cTemplate.getInstanceOf("genAll");

            File file = new File(fileName);
            st.add("filename", file.getName().substring(0, file.getName().length()-4));

            MIDLParser parser = getParser(fileName);

            ParseTree antlrAST = parser.specification();
            AntlrToSpecification specificationVisitor = new AntlrToSpecification(st);
            Specification specification = specificationVisitor.visit(antlrAST);

            if (specificationVisitor.getSemanticErrors().isEmpty()) {

                //输出实验一内容
                List<Integer> indentationList = specificationVisitor.getExpOneOutPut().getIndentationList();
                List<String> nameList = specificationVisitor.getExpOneOutPut().getNameList();
                writeExperiment1(indentationList, nameList);

                String result = st.render();
                writeExperiment2(result);
            } else {

                for (String err : specificationVisitor.getSemanticErrors()) {

                    System.err.println(err);
                }
            }
        }
    }
    public static void writeExperiment2(String result) {

        String filePath = "E:\\Out-Nwpu\\MIDLCompiler\\MIDLCompiler\\src\\app\\Experiment2.hxx";  // Replace with your file path

        try {
            // Clean the file by overwriting it
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write("");  // Write an empty string to clear the content
            fileWriter.close();

            // Write something to the file
            String content = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write(result);
            bufferedWriter.close();

            System.out.println("Experiment2 written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeExperiment1(List<Integer> indentationList, List<String> nameList){

        String filePath = "E:\\Out-Nwpu\\MIDLCompiler\\MIDLCompiler\\src\\app\\SyntaxOut.txt";  // Replace with your file path

        try {
            // Clean the file by overwriting it
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write("");  // Write an empty string to clear the content
            fileWriter.close();

            // Write something to the file
            String content = "";
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            int size = indentationList.size();
            for (int i=0; i<size; i++){

                for(int j=0; j < indentationList.get(i); j++){

                    content += "    ";
                }
                content += nameList.get(i);
                bufferedWriter.write(content);
                bufferedWriter.newLine();  // Write a new line if needed
                content = "";
            }
            bufferedWriter.close();

            System.out.println("Content written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static MIDLParser getParser(String fileName) {

        MIDLParser parser = null;

        try {
            CharStream input = CharStreams.fromFileName(fileName);
            MIDLLexer lexer = new MIDLLexer(input);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new MIDLParser(tokenStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parser;
    }
}
