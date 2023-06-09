import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
@SuppressWarnings("CheckReturnValue")
public class Compiler2 extends TestBaseVisitor<ST> {
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
      String role = ctx.role.getText();
      String value = ctx.value.getText();
      String val = "";
      if(value.equals("true") && role.equals("initial")){
         val="INITIAL";
      }else if(value.equals("true") && role.equals("accepting")){
         val="ACCEPTING";
      }else{
         val="NORMAL";
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
      ST res1 = stg.getInstanceOf("expressionView");
      res1.add("var",ctx.ID().getText());
      //for(TestParser.ExpressionContext sc : ctx.expression()){
      res1.add("value", visit(ctx.expression()).render().trim());
      //}
      //res1.add("value",visit(ctx.expression()).render());
      ST res = stg.getInstanceOf("stats");
      res.add("stat",res1);
      return res;
      //return res;
   }

   @Override public ST visitPointAmnt(TestParser.PointAmntContext ctx) {
      ST res = stg.getInstanceOf("stats");
     // for(TestParser.PointAssignmentContext sc: ctx.pointAssignment()){
         //res.add("stat", visit(ctx.pointAssignment()));
      //}
      return visit(ctx.pointAssignment());
   }

   @Override public ST visitPointModificationView1(TestParser.PointModificationView1Context ctx) {
      ST res = stg.getInstanceOf("pointModificationView1");
      res.add("symbol1",ctx.ID(0).getText());
      res.add("symbol2",ctx.ID(1).getText());
      double inf = Double.POSITIVE_INFINITY;
      int i = 0;
      for(TerminalNode sc : ctx.ID()){
         if(i>=2){
            res.add("point",sc.getText());
         }
         i++;
      }
//      for(int i = 2 ; i < inf;i++){
//         try{
//            if(ctx.ID(i).getText().equals(" ")){
//               break;
//            }
//            res.add("point",ctx.ID(i).getText());
//         }catch (Exception e){
//
//         }
//      }
      return res;
      //return res;
   }

   @Override public ST visitPointModificationView2(TestParser.PointModificationView2Context ctx) {
      ST res = stg.getInstanceOf("pointModificationView2");
      res.add("symbol1",ctx.ID(0).getText());
      res.add("symbol2",ctx.ID(1).getText());
      res.add("align", visit(ctx.align()).render().toUpperCase());
      res.add("point", ctx.ID(2).getText());
      return res;
      //return res;
   }

   @Override public ST visitPointModificationView3(TestParser.PointModificationView3Context ctx) {
      ST res = stg.getInstanceOf("pointModificationView3");
      res.add("symbol1",ctx.ID(0).getText());
      res.add("symbol2",ctx.ID(1).getText());
      String s1 = visit(ctx.align()).render().toUpperCase();
      s1=s1.trim();
      if(s1.equals("RIGHT") || s1.equals("BELOW RIGHT")){
         res.add("align", "RIGHT");
      }else if(s1.equals("LEFT") || s1.equals("BELOW LEFT")){
         res.add("align", "LEFT");
      }else{
         res.add("align", visit(ctx.align()).render().toUpperCase());
      }
      return res;
   }

   @Override public ST visitGridView(TestParser.GridViewContext ctx) {
      ST res = stg.getInstanceOf("grid");
      res.add("name",visit(ctx.e1).render().trim());
      res.add("val1",visit(ctx.e2).render().trim());
      res.add("val2",visit(ctx.e3).render().trim());
      res.add("val3",visit(ctx.gridStatement(0)).render().trim());
      res.add("val4",visit(ctx.gridStatement(1)).render().trim());
      res.add("r","128");
      res.add("g","128");
      res.add("b","128");
      if(visit(ctx.gridStatement(2)).render().equals("red")){
         res.add("r","255");
         res.add("g","0");
         res.add("b","0");
      }
      else if(visit(ctx.gridStatement(2)).render().equals("green")){
         res.add("r","0");
         res.add("g","255");
         res.add("b","0");
      }
      else if(visit(ctx.gridStatement(2)).render().equals("blue")){
         res.add("r","0");
         res.add("g","0");
         res.add("b","255");
      }else if(visit(ctx.gridStatement(2)).render().equals("black")){
         res.add("r","255");
         res.add("g","255");
         res.add("b","255");
      }
      res.add("type",visit(ctx.gridStatement(3)).render().trim());
      return res;
      //return res;
   }

   @Override public ST visitPointID(TestParser.PointIDContext ctx) {
//      ST res = stg.getInstanceOf("pointView");
//      res.add("name",ctx.ID().getText());
//      return res;
      return visitChildren(ctx);
   }

   @Override public ST visitAlign(TestParser.AlignContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",ctx.ALIGN().getText());
      return res;
      //return res;
   }

   @Override public ST visitStepValue(TestParser.StepValueContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",visit(ctx.expression()).render());
      return res;
      //return res;
   }

   @Override public ST visitMarginValue(TestParser.MarginValueContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",visit(ctx.expression()).render());
      return res;
   }

   @Override public ST visitColorValue(TestParser.ColorValueContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",visit(ctx.color()).render());
      return res;
   }

   @Override public ST visitLineValue(TestParser.LineValueContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",visit(ctx.line()).render());
      return res;
   }

   @Override public ST visitColor(TestParser.ColorContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",ctx.COLOR().getText());
      return res;
   }

   @Override public ST visitLine(TestParser.LineContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",ctx.LINE().getText().toUpperCase());
      return res;
   }

   @Override public ST visitPlaceAssignment(TestParser.PlaceAssignmentContext ctx) {
      ST res = stg.getInstanceOf("placeAssignment");
      res.add("name",ctx.ID().getText());
      res.add("expr1", ctx.e1.getText());
      res.add("expr2", ctx.e2.getText());
//      res.add("expr1", visit(ctx.e1).render());
//      res.add("expr2", visit(ctx.e2).render());
      return res;
      //return res;
   }

   @Override public ST visitPointAssignment(TestParser.PointAssignmentContext ctx) {
      ST res = stg.getInstanceOf("pointAssignment");
      res.add("ID",ctx.ID().getText());
      res.add("value",visit(ctx.expression()).render().trim());

      ST res1 = stg.getInstanceOf("stats");
      res1.add("stat",res);
      return res1;
//      return visitChildren(ctx);
   }

   @Override public ST visitColonExpression(TestParser.ColonExpressionContext ctx) {
      ST res1 = stg.getInstanceOf("ColonExpression");
      res1.add("angle", visit(ctx.e1).render());
      res1.add("r", visit(ctx.e2).render());
//      ST res = stg.getInstanceOf("stats");
//      res.add("stat",res1);
      return res1;
   }

   @Override public ST visitParenthesisExpression(TestParser.ParenthesisExpressionContext ctx) {
      ST res1=null;
      if(visit(ctx.e).render().length()<=2){
         res1 = stg.getInstanceOf("ParenthesisExpression");
         res1.add("symbol",visit(ctx.e).render().trim());
      }else{
         res1 = stg.getInstanceOf("stats");
         res1.add("stat","("+visit(ctx.e).render().trim()+")");
      }
//      ST res = stg.getInstanceOf("stats");
//      res.add("stat",res1);
      // ctx.varName = ctx.expression().varName;
      return res1;
   }

   @Override public ST visitIDExpression(TestParser.IDExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      ctx.varName=ctx.ID().getText();
      res.add("stat",ctx.ID().getText().trim());
      return res;
   }

   @Override public ST visitAdditionAndSubtractionExpression(TestParser.AdditionAndSubtractionExpressionContext ctx) {
//      ST res = stg.getInstanceOf("stats");
//      for(TestParser.ExpressionContext sc: ctx.expression()){
//         res.add("stat", visit(sc));
//      }
////      for(TestParser.AdditionAndSubtractionExpressionContext sc: ctx.e2()){
////         res.add("stat", visit(sc));
////      }
//      return res;
      ST res = stg.getInstanceOf("binaryExpression");
//      res.add("stat", visit(ctx.e1).render());
//      res.add("stat", visit(ctx.e2).render());
      res.add("var", ctx.varName);
      res.add("e1", visit(ctx.e1).render());
      res.add("op", ctx.op.getText());
      res.add("e2", visit(ctx.e2).render());
      return res;
      //return visitChildren(ctx);
   }

   @Override public ST visitFloatExpression(TestParser.FloatExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
     // ctx.varName = newVarName();
      //res.add("var", ctx.varName);
      res.add("stat", ctx.FLOAT().getText());
      return res;
   }

   @Override public ST visitIntegerExpression(TestParser.IntegerExpressionContext ctx) {
      ST res = stg.getInstanceOf("stats");
      //ctx.varName = newVarName();
      //res.add("var", ctx.varName);
      res.add("stat", ctx.INTEGER().getText());
      return res;
      //return res;
   }

   @Override public ST visitComaExpression(TestParser.ComaExpressionContext ctx) {
      ST res = stg.getInstanceOf("point");
      res.add("val1", visit(ctx.e1).render());
      res.add("val2", visit(ctx.e2).render());
      return res;
   }

   @Override public ST visitSemicolonExpression(TestParser.SemicolonExpressionContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public ST visitDivisionAndMultiplicationExpression(TestParser.DivisionAndMultiplicationExpressionContext ctx) {
//     ST res = stg.getInstanceOf("stats");
//      res.add("stat",ctx.e1.getText());
//      res.add("stat",ctx.op.getText());
//      res.add("stat",ctx.e2.getText());
//      ST res1 = stg.getInstanceOf("stats");
//      res1.add("stat",res);

//      ST res = stg.getInstanceOf("binaryExpression");
//      res.add("stat", visit(ctx.e1).render());
//      res.add("stat", visit(ctx.e2).render());
//      res.add("var", "HEHEHEHE");
//      res.add("e1", ctx.e1.getText());
//      res.add("op", ctx.op.getText());
//      res.add("e2", ctx.e2.getText());
      //return res;
      ST res = stg.getInstanceOf("binaryExpression");
//      res.add("stat", visit(ctx.e1).render());
//      res.add("stat", visit(ctx.e2).render());
      res.add("var", ctx.varName);
      res.add("e1", visit(ctx.e1).render());
      res.add("op", ctx.op.getText());
      res.add("e2", visit(ctx.e2).render());
      return res;
//      ST res = stg.getInstanceOf("binaryExpression");
//      res.add("stat", visit(ctx.e1).render());
//      res.add("stat", visit(ctx.e2).render());
//      res.add("var", ctx.varName);
//      res.add("e1", visit(ctx.e1));
//      res.add("op", ctx.op.getText());
//      res.add("e2", visit(ctx.e2));
//      return res;
    //  return binaryExpression(ctx,visit(ctx.e1).render(),visit(ctx.e2).render(), ctx.varName, ctx.e1.getText(), ctx.op.getText(), ctx.e2.getText());

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
      String s1 = "string1";
      String s2 = "string2";
      String s3 = "string3";
      //counter++;
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
      ST res1 = stg.getInstanceOf("animationDeclaration");
      res1.add("counter",counter);
      ST res = stg.getInstanceOf("stats");

      for(TestParser.OnStatementShowContext  sc: ctx.onStatementShow()){
         if(limiter==0){
            res.add("stat", res1);
         }

         res.add("stat", visit(sc));
         limiter++;
      }

//      for(TestParser.OnStatementPauseContext  sc: ctx.onStatementPause()){
//         res.add("stat", visit(sc));
//      }
//      for(TestParser.OnStatementShowIDwithChangeContext  sc: ctx.foreach()){
//         res.add("stat", visit(sc));
//      }

      res.add("stat", visitChildren(ctx));
      // limiter=0;
      //res.add("stat", visit(ctx.foreach()));
      return res;
   }

   @Override public ST visitOnStatementShow(TestParser.OnStatementShowContext ctx) {
      ST res = null;
      return visitChildren(ctx);
      //return res;
   }
   @Override public ST visitOnStatementShowGrid(TestParser.OnStatementShowGridContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitOnStatementShowID(TestParser.OnStatementShowIDContext ctx) {
      ST res = null;

      if(ctx.ID().getText().length()==1){
         res = stg.getInstanceOf("OnStatementShowID");
      }else{
         res = stg.getInstanceOf("showGrid");
         modifier++;
      }
      res.add("symbol",ctx.ID().getText());
      res.add("counter",counter);

      return res;
      //return res;
   }

   @Override public ST visitOnStatementShowTransitions(TestParser.OnStatementShowTransitionsContext ctx) {
      ST res = stg.getInstanceOf("OnStatementShowTransitions");
      res.add("counter",counter);
      for(TerminalNode t: ctx.ID())
      {
         res.add("symbol",t.getText());
      }
      return res;
      //return res;
   }

   @Override public ST visitOnStatementShowIDwithChange(TestParser.OnStatementShowIDwithChangeContext ctx) {
      ST res = stg.getInstanceOf("OnStatementShowIDwithChange");
      res.add("counter",counter);

      String s1 = ctx.value.getText();
      String s2 = ctx.role.getText();
      String val = "NORMAL";
      if(s1.equals("true")){
         val=s2.toUpperCase();
      }
//      else if(s1.equals("false")){
//         val="False";
//      }
      res.add("symbol",ctx.ID().getText());
      res.add("role",ctx.role.getText());
      res.add("value",val);
      return res;
      //return res;
   }

   @Override public ST visitOnStatementPause(TestParser.OnStatementPauseContext ctx) {
      ST res = stg.getInstanceOf("onPause");
      limiter=0;
      counter++;
      return res;
   }

   @Override public ST visitForeach(TestParser.ForeachContext ctx) {
      ST res = stg.getInstanceOf("foreach");
      res.add("symbol",ctx.SYMBOL().getText().trim());
      for(TestParser.ExpressionContext  sc: ctx.expression()){
         res.add("expr", visit(sc).render().trim());
      }
      for(TestParser.ForeachStatementContext  sc: ctx.foreachStatement()){
         res.add("statement", visit(sc));
      }
      return res;
   }

   @Override public ST visitForeachStatement(TestParser.ForeachStatementContext ctx) {
      ST res = null;
      if(counter==1){
         res = stg.getInstanceOf("foreachStatement");
         String role = ctx.role.getText();
         String value = ctx.value.getText();
         String val = "";
         if(value.equals("true") && role.equals("initial")){
            val="INITIAL";
         }else if(value.equals("true") && role.equals("accepting")){
            val="ACCEPTING";
         }else{
            val="NORMAL";
         }
         res.add("symbol",ctx.SYMBOL().getText());
         res.add("role",ctx.role.getText());
         res.add("value",val);

      }else{
         res = stg.getInstanceOf("foreachStatement1");
         String role = ctx.role.getText();
         String value = ctx.value.getText();
         String val = "";
         if(value.equals("true") && role.equals("initial")){
            val="INITIAL";
         }else if(value.equals("true") && role.equals("accepting")){
            val="ACCEPTING";
         }else{
            val="NORMAL";
         }
         res.add("symbol",ctx.SYMBOL().getText());
         res.add("role",ctx.role.getText());
         res.add("value",val);
         res.add("counter",counter);
      }

      return res;
      //return res;
   }

   @Override public ST visitPlay(TestParser.PlayContext ctx) {
      ST res = stg.getInstanceOf("play");
      if(modifier==0){
         counter--;
      }else{
         counter=counter-modifier;
      }
      for(int i = 1 ;  i<= counter ; i++){
         res.add("statement", "sequence.add(frame"+i+")\n");
      }
      for(int i = 1 ;  i<= counter ; i++){
         res.add("statement", "sequence.next_step()\n");
      }

      return res;
      //return res;
   }
   protected ST binaryExpression(ParserRuleContext ctx, String e1Stats, String e2Stats, String var, String e1Var, String op, String e2Var) {
      ST res = stg.getInstanceOf("binaryExpression");
      res.add("stat", e1Stats);
      res.add("stat", e2Stats);
      res.add("var", var);
      res.add("e1", e1Var);
      res.add("op", op);
      res.add("e2", e2Var);
      return res;
   }
   protected String newVarName() {
      varCount++;
      return "v"+varCount;
   }
   protected int modifier = 0;
   protected int limiter = 0;
   protected int counter=1;
   protected int varCount = 0;
   protected String target = "py"; // default
   protected STGroup stg = null;
}
