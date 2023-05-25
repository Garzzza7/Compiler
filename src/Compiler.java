import java.util.HashMap;
import java.util.Map;
@SuppressWarnings("CheckReturnValue")
public class Compiler extends TestBaseVisitor<Object> {
   Map<String, Double> memory = new HashMap<String, Double>();
   Map<String, String> nodes = new HashMap<String, String>();
   @Override public Object visitProgram(TestParser.ProgramContext ctx) {
      System.out.println("import cv2");
      System.out.println("import numpy as np");
      System.out.println("canvas = np.ones((height, width, 3), dtype=np.uint8) * 255");
      System.out.println("class Node:\n" +
              "    state = ' '\n" +
              "    positionx = 0\n" +
              "    positiony = 0\n" +
              "    is_initial = 0\n" +
              "    is_accepting = 0\n" +
              "    def __init__(self,state):\n" +
              "        self.state = state\n" +
              "    def __init__(self, state, positionx, positiony, is_initial, is_accepting):\n" +
              "        self.state = state\n" +
              "        self.positionx = positionx\n" +
              "        self.positiony = positiony\n" +
              "        self.is_initial = is_initial\n" +
              "        self.is_accepting = is_accepting\n" +
              "\n" +
              "    def set_accepting(self):\n" +
              "        is_accepting = self\n" +
              "\n" +
              "    def set_initial(self):\n" +
              "        is_accepting = self\n" +
              "\n" +
              "    def set_positionx(self):\n" +
              "        positionx = self\n" +
              "\n" +
              "    def set_positiony(self):\n" +
              "        positiony = self\n" +
              "\n" +
              "    def show_state(self):\n" +
              "        start_point = (self.positionx - 100, self.positiony)\n" +
              "        end_point = (self.positionx - node_radius, self.positiony)\n" +
              "        if self.is_accepting:\n" +
              "            end_point = (self.positionx - node_radius, self.positiony)\n" +
              "            cv2.circle(canvas, (self.positionx, self.positiony), node_radius + 10, node_color, node_thickness)\n" +
              "        if self.is_initial:\n" +
              "            cv2.arrowedLine(canvas, start_point, end_point, line_color, line_thickness, tipLength=0.5)\n" +
              "        cv2.putText(canvas, self.state, (self.positionx - 14, self.positiony + 14), text_font, text_scale, text_color,\n" +
              "                    text_thickness, cv2.LINE_AA)\n" +
              "        cv2.circle(canvas, (self.positionx, self.positiony), node_radius, node_color, node_thickness)\n");
      return visitChildren(ctx);
   }

   @Override public Object visitSector(TestParser.SectorContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitAlphabet(TestParser.AlphabetContext ctx) {
      Object res = null;
      double inf = Double.POSITIVE_INFINITY;
      try{
         System.out.print("alphabet = [");
         if(ctx.SYMBOL(1).getText()==null){

         }
         else {
            System.out.print("\'"+ctx.SYMBOL(0).getText()+"\'");
            for(int i = 1 ; i < inf;i++){
               if(ctx.SYMBOL(i).getText()==null){break;}
               System.out.print(","+"\'"+ctx.SYMBOL(i).getText()+"\'");
            }
         }
      }catch (Exception e){}
      System.out.print("]\n");
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitAutomaton(TestParser.AutomatonContext ctx) {
      Object res = null;
      System.out.println(visit(ctx.automatonType())+" "+ctx.ID().getText());
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitAutomatonStatement(TestParser.AutomatonStatementContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitStateCreation(TestParser.StateCreationContext ctx) {
      Object res = null;
      double inf = Double.POSITIVE_INFINITY;
      int counter = 0;
      try{
         while(ctx.ID(counter).getText()!=null){
            System.out.println("node"+counter+" = Node("+"\'"+ctx.ID(counter).getText()+"\'"+")");
            nodes.put(ctx.ID(counter).getText(),"node"+counter);
            counter++;
         }
      }catch (Exception e){}

//      try{
//         System.out.print("state = [");
//         if(ctx.ID(1).getText()==null){
//
//         }
//         else {
//            System.out.print("\'"+ctx.ID(0).getText()+"\'");
//            for(int i = 1 ; i < inf;i++){
//               if(ctx.ID(i).getText()==null){break;}
//               System.out.print(","+"\'"+ctx.ID(i).getText()+"\'");
//            }
//         }
//      }catch (Exception e){}
//      System.out.print("]\n");
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitStateAssignment(TestParser.StateAssignmentContext ctx) {

      String role = new String(ctx.role.getText());
      String value = new String(ctx.value.getText());
//      System.out.println(s+"  "+"initial");
//      System.out.println(s=="initial");
//      System.out.println(s.equals("initial"));
      if(role.equals("initial")){
         if(value.equals("false")){
            System.out.println(nodes.get(ctx.ID().getText())+".is_initial=0");
         }else if(value.equals("true")){
            System.out.println(nodes.get(ctx.ID().getText())+".is_initial=1");
         }
      }else if(role.equals("accepting")){
         if(value.equals("false")){
            System.out.println(nodes.get(ctx.ID().getText())+".is_accepting=0");
         }else if(value.equals("true")){
            System.out.println(nodes.get(ctx.ID().getText())+".is_accepting=1");
         }
      }
//      System.out.println("VALUE = "+ctx.value.getText());
//      System.out.println("ROLE = "+ctx.role.getText());
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitTransition(TestParser.TransitionContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitTransitionStatement(TestParser.TransitionStatementContext ctx) {
      double inf = Double.POSITIVE_INFINITY;
         int iteratorSYMBOL = 1;
            System.out.println("\n");
            System.out.print("connect_nodes("+nodes.get(ctx.ID(0).getText())+", "+nodes.get(ctx.ID(1).getText())+", ");
         try{
            System.out.print("[");
            System.out.print("\'"+ctx.SYMBOL(0).getText()+"\'");
            if(ctx.SYMBOL(1).getText()==null){}
            else {
               for(int i = 1 ; i < inf;i++){
                  if(ctx.SYMBOL(i).getText()==null){

                     break;
                  }
                  System.out.print(","+"\'"+ctx.SYMBOL(i).getText()+"\'");
               }

            }
         }catch (Exception e){}
      System.out.print("])\n");
      return visitChildren(ctx);
   }

   @Override public Object visitAutomatonType(TestParser.AutomatonTypeContext ctx) {
      Object res = null;
      return ctx.AUTOMATONNAME().getText();
      //return res;
   }

   @Override public Object visitView(TestParser.ViewContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitPlaceView(TestParser.PlaceViewContext ctx) {

      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitPointView(TestParser.PointViewContext ctx) {
      Object res = null;
      double inf = Double.POSITIVE_INFINITY;
      int counter = 0;
      try{
         while(ctx.ID(counter).getText()!=null){
            System.out.println("point"+counter+" = Point("+"\'"+ctx.ID(counter).getText()+"\'"+")");
            //nodes.put(ctx.ID(counter).getText(),"node"+counter);
            counter++;
         }
      }catch (Exception e){}
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitValueView(TestParser.ValueViewContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitExpressionView(TestParser.ExpressionViewContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitPointModificationView1(TestParser.PointModificationView1Context ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitPointModificationView2(TestParser.PointModificationView2Context ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitPointModificationView3(TestParser.PointModificationView3Context ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitGridView(TestParser.GridViewContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitAlign(TestParser.AlignContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitStepValue(TestParser.StepValueContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitMarginValue(TestParser.MarginValueContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitColorValue(TestParser.ColorValueContext ctx) {
      String s = (String)visit(ctx.color());
      return s;
      //return res;
   }

   @Override public Object visitLineValue(TestParser.LineValueContext ctx) {
      String s = (String)visit(ctx.line());
      return s;
      //return res;
   }

   @Override public Object visitColor(TestParser.ColorContext ctx) {
      String s = ctx.COLOR().getText();
      //System.out.println("COLOR = "+s);
      return s;
      //return res;
   }

   @Override public Object visitLine(TestParser.LineContext ctx) {
      String s = ctx.LINE().getText();
      // System.out.println("LINE = "+s);
      return s;
      //return res;
   }

   @Override public Object visitPlaceAssignment(TestParser.PlaceAssignmentContext ctx) {
      double v1 = (Double)visit(ctx.expression(0));
      double v2 = (Double)visit(ctx.expression(1));
      System.out.println(nodes.get(ctx.ID().getText())+".positionx="+v1);
      System.out.println(nodes.get(ctx.ID().getText())+".positiony="+v2);
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitPointAssignment(TestParser.PointAssignmentContext ctx) {
      Object res = null;
      System.out.println("POINT ASSIGNMENT");
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitColonExpression(TestParser.ColonExpressionContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitParenthesisExpression(TestParser.ParenthesisExpressionContext ctx) {
      //object inside_res = (Object)visit(ctx.expression());
      return visit(ctx.expression());
   }

   @Override public Object visitIDExpression(TestParser.IDExpressionContext ctx) {
      String s = ctx.ID().getText();
      return s;
      //return res;
   }

   @Override public Object visitAdditionAndSubtractionExpression(TestParser.AdditionAndSubtractionExpressionContext ctx) {
      String s1 = (String)visit(ctx.expression(0));
      String s2 = (String)visit(ctx.expression(1));
      System.out.println("v1 = "+s1);
      System.out.println("v2 = "+s2);
//      double v1 = (Double)visit(ctx.expression(0));
//      double v2 = (Double)visit(ctx.expression(1));
//      String op = ctx.op.getText();
//      double result=0;
//      switch (op){
//         case "-":
//            result=v1-v2;
//            break;
//         case "+":
//            result=v1+v2;
//            break;
//      }
      return 1;
   }

   @Override public Object visitFloatExpression(TestParser.FloatExpressionContext ctx) {
//      Double f =  (Double)ctx.FLOAT().getText();
      double f =  Double.parseDouble(ctx.FLOAT().getText());
      return f;
      //return res;
   }

   @Override public Object visitIntegerExpression(TestParser.IntegerExpressionContext ctx) {
      //Double f =  (Double)ctx.INTEGER().getText();
      double f =  Double.parseDouble(ctx.INTEGER().getText());
      return f;
      //return res;
   }

   @Override public Object visitComaExpression(TestParser.ComaExpressionContext ctx) {
      Object res = null;
      System.out.println("TESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTEST");
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitSemicolonExpression(TestParser.SemicolonExpressionContext ctx) {
      Object res = null;
      System.out.println("TESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTESTTEST");
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitDivisionAndMultiplicationExpression(TestParser.DivisionAndMultiplicationExpressionContext ctx) {
      String s1 = (String)visit(ctx.expression(0));
      String s2 = (String)visit(ctx.expression(1));
      System.out.println("v1 = "+s1);
      System.out.println("v2 = "+s2);
//      double v1 = (Double)visit(ctx.expression(0));
//      double v2 = (Double)visit(ctx.expression(1));
//      String op = ctx.op.getText();
//      double result=0.0;
//      switch (op){
//         case "/":
//            result=v1/v2;
//            break;
//         case "*":
//            result=v1*v2;
//            break;
//      }
      return 1;
   }

   @Override public Object visitNegativeExpression(TestParser.NegativeExpressionContext ctx) {
      double num = (Double)visit(ctx.expression());
      return num*(-1);
   }

   @Override public Object visitAnimation(TestParser.AnimationContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitAnimationStatement(TestParser.AnimationStatementContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitViewport(TestParser.ViewportContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitOn(TestParser.OnContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitOnStatement(TestParser.OnStatementContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitForeach(TestParser.ForeachContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitForeachStatement(TestParser.ForeachStatementContext ctx) {
      Object res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Object visitPlay(TestParser.PlayContext ctx) {
      Object res = null;
      System.out.println("cv2.destroyAllWindows()");
      return visitChildren(ctx);
      //return res;
   }
}
