import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.io.File;
import org.stringtemplate.v4.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;
public class TestMain {
   public static void main(String[] args) {
      boolean compile = true;
      int i;
      for(i = 0; i < args.length && args[i].startsWith("-"); i++)
      {
         switch(args[i].toLowerCase())
         {
            case "-compiler":
               compile = true;
               break;
            default:
               err.println("ERROR: invalid program argument \""+args[i]+"\"");
               exit(1);
               break;
         }
      }

      if (i+1 != args.length)
      {
         out.println("Usage: antlr4-java -ea TestMain [-compiler] <source-file>");
         exit(0);
      }
         runCompiler(args[i]);
   }
   public static void runCompiler(String sourceFile)
   {
      assert sourceFile != null && !sourceFile.isEmpty();

      try
      {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(new FileInputStream(sourceFile));
         // create a lexer that feeds off of input CharStream:
         TestLexer lexer = new TestLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         TestParser parser = new TestParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at main rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            /*
            TODO: ADD SEMANTIC ANALYSIS
             */
            //CalcSemanticCheck semanticCheck = new CalcSemanticCheck();
             Compiler1 compiler = new Compiler1();
            //semanticCheck.visit(tree);
//            if (!ErrorHandling.error())
//            {
               String[] targets = {"py"};
               for(String target: targets)
               {
                  if (!compiler.validTarget(target))
                  {
                     err.println("ERROR: template group file for target "+target+" not found!");
                     exit(2);
                  }
                  compiler.setTarget(target);
                  ST code = compiler.visit(tree);
                  String filename = "Output." + target;
                    try
                  {
                     code.add("name", "Output");
                     PrintWriter pw = new PrintWriter(new File(filename));
                     pw.print(code.render());
                     pw.close();
                  }
                  catch(IOException e)
                  {
                     err.println("ERROR: unable to write in file "+filename);
                     exit(3);
                  }
               }
           // }
         }
      }
      catch(IOException e)
      {
         err.println("ERROR: unable to read from file "+sourceFile);
         exit(4);
      }
   }

}
