import java.util.ArrayList;
import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
@SuppressWarnings("CheckReturnValue")
public class TestSemanticCheck extends TestBaseVisitor<Boolean> {
   ArrayList<String> alphabet = new ArrayList<String>();
   ArrayList<String> states = new ArrayList<String>();

   @Override public Boolean visitProgram(TestParser.ProgramContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitSectorList(TestParser.SectorListContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitSector(TestParser.SectorContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitAlphabet(TestParser.AlphabetContext ctx) {
      Boolean res = true;
      for(TerminalNode t: ctx.SYMBOL())
      {
         alphabet.add(t.getText());
      }
      return res;
   }

   @Override public Boolean visitAutomaton(TestParser.AutomatonContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitAutomatonStatement(TestParser.AutomatonStatementContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStateCreation(TestParser.StateCreationContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Boolean visitStateCreationID(TestParser.StateCreationIDContext ctx) {
      Boolean res = true;
      states.add(ctx.ID().getText());
      //return visitChildren(ctx);
      return res;
   }

   @Override public Boolean visitStateAssignment(TestParser.StateAssignmentContext ctx) {
      Boolean res = true;
      if(states.contains(ctx.ID().getText())){

      }else{
         System.out.println("State "+ctx.ID().getText()+" does not exists!!!");
         res = false;
      }
      return res;
   }

   @Override public Boolean visitTransition(TestParser.TransitionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitTransitionStatement(TestParser.TransitionStatementContext ctx) {
      Boolean res = true;
      //return visitChildren(ctx);
      for(TerminalNode t: ctx.SYMBOL())
      {
         if(alphabet.contains(t.getText())){

         }else{
            System.out.println("Character "+t.getText()+" does not belong in the alphabet!");
            res = false;
         }

      }
      if(!states.contains(ctx.ID(0).getText())){
         System.out.println("State "+ctx.ID(0).getText()+" does not belong in the states!");
         res=false;
      }
      if(!states.contains(ctx.ID(1).getText())){
         System.out.println("State "+ctx.ID(1).getText()+" does not belong in the states!");
         res=false;
      }
      return res;
   }

   @Override public Boolean visitAutomatonType(TestParser.AutomatonTypeContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitView(TestParser.ViewContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPlaceView(TestParser.PlaceViewContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPointView(TestParser.PointViewContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitExpressionView(TestParser.ExpressionViewContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPointAmnt(TestParser.PointAmntContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPointModificationView1(TestParser.PointModificationView1Context ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPointModificationView2(TestParser.PointModificationView2Context ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPointModificationView3(TestParser.PointModificationView3Context ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitGridView(TestParser.GridViewContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPointID(TestParser.PointIDContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitAlign(TestParser.AlignContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitStepValue(TestParser.StepValueContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitMarginValue(TestParser.MarginValueContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitColorValue(TestParser.ColorValueContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitLineValue(TestParser.LineValueContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitColor(TestParser.ColorContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitLine(TestParser.LineContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPlaceAssignment(TestParser.PlaceAssignmentContext ctx) {
      Boolean res = true;
      if(!states.contains(ctx.ID().getText())){
         System.out.println("State "+ctx.ID().getText()+" does not exists!!!");
         res=false;
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Boolean visitPointAssignment(TestParser.PointAssignmentContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitColonExpression(TestParser.ColonExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitParenthesisExpression(TestParser.ParenthesisExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIDExpression(TestParser.IDExpressionContext ctx) {
      Boolean res = true;
      if(!states.contains(ctx.ID().getText()) && ctx.ID().getText().length()==1){
         System.out.println("State "+ctx.ID().getText()+" does not exists!!!");
         res=false;
      }
      //return visitChildren(ctx);
      return res;
   }

   @Override public Boolean visitAdditionAndSubtractionExpression(TestParser.AdditionAndSubtractionExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitFloatExpression(TestParser.FloatExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitIntegerExpression(TestParser.IntegerExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitComaExpression(TestParser.ComaExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitSemicolonExpression(TestParser.SemicolonExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitDivisionAndMultiplicationExpression(TestParser.DivisionAndMultiplicationExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitNegativeExpression(TestParser.NegativeExpressionContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitAnimation(TestParser.AnimationContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitAnimationStatement(TestParser.AnimationStatementContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitViewport(TestParser.ViewportContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitOn(TestParser.OnContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitOnStatement(TestParser.OnStatementContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitOnStatementShow(TestParser.OnStatementShowContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitOnStatementShowGrid(TestParser.OnStatementShowGridContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitOnStatementShowID(TestParser.OnStatementShowIDContext ctx) {
      Boolean res = true;
      if(!states.contains(ctx.ID().getText()) && ctx.ID().getText().length()==1){
         System.out.println("State "+ctx.ID().getText()+" does not belong in the states!");
         res=false;
      }
      return res;
   }

   @Override public Boolean visitOnStatementShowTransitions(TestParser.OnStatementShowTransitionsContext ctx) {
      Boolean res = true;
      if(!states.contains(ctx.ID(0).getText()) && ctx.ID(0).getText().length()==1){
         System.out.println("State "+ctx.ID(0).getText()+" does not belong in the states!");
         res=false;
      }
      if(!states.contains(ctx.ID(1).getText()) && ctx.ID(1).getText().length()==1){
         System.out.println("State "+ctx.ID(1).getText()+" does not belong in the states!");
         res=false;
      }
      return res;
   }

   @Override public Boolean visitOnStatementShowIDwithChange(TestParser.OnStatementShowIDwithChangeContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitOnStatementPause(TestParser.OnStatementPauseContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitForeach(TestParser.ForeachContext ctx) {
//      Boolean res = true;
//      for(TestParser.ExpressionContext  sc: ctx.expression()){
//         if(states.contains(visit(ctx.expression()).render().trim())){
//
//         }else{
//            System.out.println("State "+visit(ctx.expression()).render().trim()+" does not exists!!!");
//            res = false;
//         }
//      }
//      return res;
      return visitChildren(ctx);
   }

   @Override public Boolean visitForeachStatement(TestParser.ForeachStatementContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Boolean visitPlay(TestParser.PlayContext ctx) {
      Boolean res = null;
      return visitChildren(ctx);
      //return res;
   }
}
