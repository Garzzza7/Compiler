import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
@SuppressWarnings("CheckReturnValue")
public class Compiler1 extends TestBaseVisitor<ST> {
   public boolean validTarget(String target) {
      File f = new File(target+".stg");

      return ("py".equalsIgnoreCase(target) || "cpp".equalsIgnoreCase(target) || "test".equalsIgnoreCase(target)) &&
              f.exists() && f.isFile() && f.canRead();
   }

   public void setTarget(String target) {
      assert validTarget(target);
      this.target = target;
   }
   @Override public ST visitProgram(TestParser.ProgramContext ctx) {
      assert validTarget(target);

      stg = new STGroupFile(target+".stg");
      ST res = stg.getInstanceOf("module");
      res.add("stat", visit(ctx.sectorList()));
      return res;
   }

   @Override public ST visitSectorList(TestParser.SectorListContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.SectorContext sc: ctx.sector()){
         //System.out.println(visit(sc).render());
         res.add("stat", visit(sc));
      }

      return res;
   }

   @Override public ST visitSector(TestParser.SectorContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitAlphabet(TestParser.AlphabetContext ctx) {
      ST res = stg.getInstanceOf("alphabet");
      String name = "alphabet";
      res.add("name",name);
      for(TerminalNode t: ctx.SYMBOL())
      {
         res.add("value",t.getText());
      }
      // res.add("value",ctx.SYMBOL(0).getText());
      return res;
      //return res;
   }

   @Override public ST visitAutomaton(TestParser.AutomatonContext ctx) {
      ST automaton = stg.getInstanceOf("automaton");
      automaton.add("name",ctx.ID().getText());
      System.out.println(ctx.ID().getText());
//      ST automatonName = stg.getInstanceOf("automatonType");
//      automatonName.add("name",visit(ctx.automatonType()).render());

      ST res = stg.getInstanceOf("stats");
      res.add("stat", visit(ctx.automatonType()));
      res.add("stat", automaton);
      for(TestParser.AutomatonStatementContext  sc: ctx.automatonStatement()){
         res.add("stat", visit(sc));
      }

      return res;
   }

   @Override public ST visitAutomatonStatement(TestParser.AutomatonStatementContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitStateCreation(TestParser.StateCreationContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.StateCreationIDContext  sc: ctx.stateCreationID()){
         res.add("stat", visit(sc));
      }
      return res;
   }
   @Override public ST visitStateCreationID(TestParser.StateCreationIDContext ctx) {
      ST res = stg.getInstanceOf("stateCreation");
      res.add("name",ctx.ID().getText());
      //return visitChildren(ctx);
      return res;
   }

   @Override public ST visitStateAssignment(TestParser.StateAssignmentContext ctx) {
      ST res = stg.getInstanceOf("stateAssignment");
      //  TestParser.AutomatonContext aut;
      String op = ctx.role.getText();
      System.out.println(op);
      String s1 = ctx.value.getText();
      String val = " ";
      if(s1.equals("true")){
         val="True";
      }else if(s1.equals("false")){
         val="False";
      }
      res.add("automata","av");
      res.add("name",ctx.ID().getText());
      res.add("state",ctx.role.getText());
      res.add("value",val);
      return res;
      //return res;
   }

   @Override public ST visitTransition(TestParser.TransitionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.TransitionStatementContext  sc: ctx.transitionStatement())
         res.add("stat", visit(sc));
      return res;
   }

   @Override public ST visitTransitionStatement(TestParser.TransitionStatementContext ctx) {
      ST res = null;
      String s1 = ctx.ID(0).getText();
      String s2 = ctx.ID(1).getText();
      if(s1.equals(s2)){
          res = stg.getInstanceOf("transitionStatementDiff");
      }else{
          res = stg.getInstanceOf("transitionStatement");
      }
      res.add("name1", ctx.ID(0).getText());
      res.add("name2", ctx.ID(1).getText());
      for(TerminalNode t: ctx.SYMBOL())
      {
         res.add("symbol",t.getText());
      }
      return res;
      //return res;
   }

   @Override public ST visitAutomatonType(TestParser.AutomatonTypeContext ctx) {
      ST res = stg.getInstanceOf("automatonType");
      System.out.println("tutaj");
      res.add("name", ctx.AUTOMATONNAME().getText());
      return res;
      //return res;
   }

   @Override public ST visitView(TestParser.ViewContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.ViewStatementContext sc: ctx.viewStatement()){
         res.add("stat", visit(sc));
      }
      return res;
   }

   @Override public ST visitPlaceView(TestParser.PlaceViewContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.PlaceAssignmentContext sc: ctx.placeAssignment()){
         res.add("stat", visit(sc));
      }
      return res;
   }

   @Override public ST visitPointView(TestParser.PointViewContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.PointIDContext sc: ctx.pointID()){
         res.add("stat", visit(sc));
      }
      return res;
   }

   @Override public ST visitExpressionView(TestParser.ExpressionViewContext ctx) {
      ST res = stg.getInstanceOf("expressionView");
      res.add("var",ctx.ID().getText());
      res.add("value",ctx.expression().getText());
      return res;
      //return res;
   }

   @Override public ST visitPointModificationView1(TestParser.PointModificationView1Context ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitPointModificationView2(TestParser.PointModificationView2Context ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitPointModificationView3(TestParser.PointModificationView3Context ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitGridView(TestParser.GridViewContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }
   @Override public ST visitPointID(TestParser.PointIDContext ctx) {
      ST res = stg.getInstanceOf("pointView");
      res.add("name",ctx.ID().getText());
      return res;
      //return res;
   }

   @Override public ST visitAlign(TestParser.AlignContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitStepValue(TestParser.StepValueContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitMarginValue(TestParser.MarginValueContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitColorValue(TestParser.ColorValueContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitLineValue(TestParser.LineValueContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitColor(TestParser.ColorContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitLine(TestParser.LineContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitPlaceAssignment(TestParser.PlaceAssignmentContext ctx) {
      ST res = stg.getInstanceOf("placeAssignment");
      res.add("name",ctx.ID().getText());
      res.add("expr1", visit(ctx.e1).render());
      res.add("expr2", visit(ctx.e2).render());
      return res;
      //return res;
   }

   @Override public ST visitPointAssignment(TestParser.PointAssignmentContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitColonExpression(TestParser.ColonExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat", visit(ctx.e1).render());
      res.add("stat", visit(ctx.e2).render());
      return res;
   }

   @Override public ST visitParenthesisExpression(TestParser.ParenthesisExpressionContext ctx) {
      ST res = visit(ctx.e);
     // ctx.varName = ctx.expression().varName;
      return res;
   }

   @Override public ST visitIDExpression(TestParser.IDExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",ctx.ID().getText());
      return res;
   }

   @Override public ST visitAdditionAndSubtractionExpression(TestParser.AdditionAndSubtractionExpressionContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitFloatExpression(TestParser.FloatExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      ctx.varName = newVarName();
      //res.add("var", ctx.varName);
      res.add("stat", ctx.FLOAT().getText());
      return res;
   }

   @Override public ST visitIntegerExpression(TestParser.IntegerExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      ctx.varName = newVarName();
      //res.add("var", ctx.varName);
      res.add("stat", ctx.INTEGER().getText());
      return res;
      //return res;
   }

   @Override public ST visitComaExpression(TestParser.ComaExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat", visit(ctx.e1).render());
      res.add("stat", visit(ctx.e2).render());
      return res;
   }

   @Override public ST visitSemicolonExpression(TestParser.SemicolonExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat", visit(ctx.e1).render());
      res.add("stat", visit(ctx.e2).render());
      return res;
   }

   @Override public ST visitDivisionAndMultiplicationExpression(TestParser.DivisionAndMultiplicationExpressionContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitNegativeExpression(TestParser.NegativeExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat","-"+ctx.e.getText());
      return res;
      //return res;
   }

   @Override public ST visitAnimation(TestParser.AnimationContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",visit(ctx.animationStatement()));
      return res;
   }

   @Override public ST visitAnimationStatement(TestParser.AnimationStatementContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",visit(ctx.viewport()));
      res.add("stat",visit(ctx.on()));
      return res;
   }

   @Override public ST visitViewport(TestParser.ViewportContext ctx) {
      ST res = stg.getInstanceOf("viewport");
      System.out.println("TUTAJ");
      //System.out.println(visit(ctx.expression(0)).render());
      String s1 = "string1";
      String s2 = "string2";
      String s3 = "string3";
      res.add("value1",visit(ctx.e3));
      res.add("value2",visit(ctx.e4));
      return res;
      //return res;
   }

   @Override public ST visitOn(TestParser.OnContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.OnStatementContext  sc: ctx.onStatement()){
         res.add("stat", visit(sc));
      }
      return res;
   }

   @Override public ST visitOnStatement(TestParser.OnStatementContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(TestParser.OnStatementShowContext  sc: ctx.onStatementShow()){
         res.add("stat", visit(sc));
      }
//      for(TestParser.OnStatementPauseContext  sc: ctx.onStatementPause()){
//         res.add("stat", visit(sc));
//      }
//      for(TestParser.OnStatementShowIDwithChangeContext  sc: ctx.foreach()){
//         res.add("stat", visit(sc));
//      }
      res.add("stat", visitChildren(ctx));
      //res.add("stat", visit(ctx.foreach()));
      return res;
   }

   @Override public ST visitOnStatementShow(TestParser.OnStatementShowContext ctx) {

      return visitChildren(ctx);
   }

   @Override public ST visitOnStatementShowID(TestParser.OnStatementShowIDContext ctx) {
      ST res = stg.getInstanceOf("OnStatementShowID");
      System.out.println(ctx.ID().getText());
      res.add("symbol",ctx.ID().getText());
      return res;
      //return res;
   }

   @Override public ST visitOnStatementShowTransitions(TestParser.OnStatementShowTransitionsContext ctx) {
      ST res = stg.getInstanceOf("OnStatementShowTransitions");
      for(TerminalNode t: ctx.ID())
      {
         res.add("symbol",t.getText());
      }
      return res;
      //return res;
   }

   @Override public ST visitOnStatementShowIDwithChange(TestParser.OnStatementShowIDwithChangeContext ctx) {
      ST res = stg.getInstanceOf("OnStatementShowIDwithChange");
      String s1 = ctx.value.getText();
      String val = " ";
      if(s1.equals("true")){
         val="True";
      }else if(s1.equals("false")){
         val="False";
      }
      res.add("symbol",ctx.ID().getText());
      res.add("role",ctx.role.getText());
      res.add("value",val);
      return res;
      //return res;
   }
   @Override public ST visitOnStatementPause(TestParser.OnStatementPauseContext ctx) {
      ST res = stg.getInstanceOf("onPause");
      return res;
   }
   @Override public ST visitForeach(TestParser.ForeachContext ctx) {
      ST res = stg.getInstanceOf("foreach");
      res.add("symbol",ctx.SYMBOL().getText());
      for(TestParser.ExpressionContext  sc: ctx.expression()){
         res.add("expr", visit(sc));
      }
      for(TestParser.ForeachStatementContext  sc: ctx.foreachStatement()){
         res.add("statement", visit(sc));
      }
      return res;
   }

   @Override public ST visitForeachStatement(TestParser.ForeachStatementContext ctx) {
      ST res = stg.getInstanceOf("foreachStatement");
      String s1 = ctx.value.getText();
      String val = " ";
      if(s1.equals("true")){
         val="True";
      }else if(s1.equals("false")){
         val="False";
      }
      res.add("symbol",ctx.SYMBOL().getText());
      res.add("role",ctx.role.getText());
      res.add("value",val);
      return res;
      //return res;
   }

   @Override public ST visitPlay(TestParser.PlayContext ctx) {
      ST res = stg.getInstanceOf("play");
      return res;
      //return res;
   }
   //   protected ST binaryExpression(ParserRuleContext ctx, String e1Stats, String e2Stats, String type, String var, String e1Var, String op, String e2Var) {
//      ST res = stg.getInstanceOf("binaryExpression");
//      res.add("stat", e1Stats);
//      res.add("stat", e2Stats);
//      res.add("type", type);
//      res.add("var", var);
//      res.add("e1", e1Var);
//      res.add("op", translateOp(op));
//      res.add("e2", e2Var);
//      return res;
//   }
   protected String newVarName() {
      varCount++;
      return "v"+varCount;
   }
   protected int varCount = 0;
   protected String target = "py"; // default
   protected STGroup stg = null;
}
