// Generated from Test.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TestParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TestParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#sector}.
	 * @param ctx the parse tree
	 */
	void enterSector(TestParser.SectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#sector}.
	 * @param ctx the parse tree
	 */
	void exitSector(TestParser.SectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#alphabet}.
	 * @param ctx the parse tree
	 */
	void enterAlphabet(TestParser.AlphabetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#alphabet}.
	 * @param ctx the parse tree
	 */
	void exitAlphabet(TestParser.AlphabetContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#automaton}.
	 * @param ctx the parse tree
	 */
	void enterAutomaton(TestParser.AutomatonContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#automaton}.
	 * @param ctx the parse tree
	 */
	void exitAutomaton(TestParser.AutomatonContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#automatonStatement}.
	 * @param ctx the parse tree
	 */
	void enterAutomatonStatement(TestParser.AutomatonStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#automatonStatement}.
	 * @param ctx the parse tree
	 */
	void exitAutomatonStatement(TestParser.AutomatonStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#foreach}.
	 * @param ctx the parse tree
	 */
	void enterForeach(TestParser.ForeachContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#foreach}.
	 * @param ctx the parse tree
	 */
	void exitForeach(TestParser.ForeachContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForeachStatement(TestParser.ForeachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#foreachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForeachStatement(TestParser.ForeachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(TestParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(TestParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#automatonType}.
	 * @param ctx the parse tree
	 */
	void enterAutomatonType(TestParser.AutomatonTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#automatonType}.
	 * @param ctx the parse tree
	 */
	void exitAutomatonType(TestParser.AutomatonTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#view}.
	 * @param ctx the parse tree
	 */
	void enterView(TestParser.ViewContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#view}.
	 * @param ctx the parse tree
	 */
	void exitView(TestParser.ViewContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#viewStatement}.
	 * @param ctx the parse tree
	 */
	void enterViewStatement(TestParser.ViewStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#viewStatement}.
	 * @param ctx the parse tree
	 */
	void exitViewStatement(TestParser.ViewStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#placeAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPlaceAssignment(TestParser.PlaceAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#placeAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPlaceAssignment(TestParser.PlaceAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#pointAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPointAssignment(TestParser.PointAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#pointAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPointAssignment(TestParser.PointAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TestParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TestParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#animation}.
	 * @param ctx the parse tree
	 */
	void enterAnimation(TestParser.AnimationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#animation}.
	 * @param ctx the parse tree
	 */
	void exitAnimation(TestParser.AnimationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#animationStatement}.
	 * @param ctx the parse tree
	 */
	void enterAnimationStatement(TestParser.AnimationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#animationStatement}.
	 * @param ctx the parse tree
	 */
	void exitAnimationStatement(TestParser.AnimationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#viewport}.
	 * @param ctx the parse tree
	 */
	void enterViewport(TestParser.ViewportContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#viewport}.
	 * @param ctx the parse tree
	 */
	void exitViewport(TestParser.ViewportContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#on}.
	 * @param ctx the parse tree
	 */
	void enterOn(TestParser.OnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#on}.
	 * @param ctx the parse tree
	 */
	void exitOn(TestParser.OnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#onStatement}.
	 * @param ctx the parse tree
	 */
	void enterOnStatement(TestParser.OnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#onStatement}.
	 * @param ctx the parse tree
	 */
	void exitOnStatement(TestParser.OnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#play}.
	 * @param ctx the parse tree
	 */
	void enterPlay(TestParser.PlayContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#play}.
	 * @param ctx the parse tree
	 */
	void exitPlay(TestParser.PlayContext ctx);
}