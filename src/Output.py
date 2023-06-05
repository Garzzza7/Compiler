from main import *

automatonName = "complete DFA"
a1 = Automaton()
 
a1.set_state(State('A'))
a1.set_state(State('B'))
a1.set_state(State('C'))
a1.set_state(State('D'))
a1.set_state(State('E')) 
a1.figures['A'].set_type(StateType.INITIAL)
for s in ["A","B","D"]:
    a1.figures[s].set_type(StateType.ACCEPTING)
a1.set_transition(LineTransition(a1.figures['A'], a1.figures['B'], ['a']))
a1.set_transition(LineTransition(a1.figures['B'], a1.figures['C'], ['b']))
a1.set_transition(LineTransition(a1.figures['C'], a1.figures['D'], ['c']))
a1.set_transition(LineTransition(a1.figures['C'], a1.figures['E'], ['a', 'b']))
a1.set_transition(LoopTransition(a1.figures['E'], ['a', 'b', 'c']))
a1.set_transition(LoopTransition(a1.figures['B'], ['a']))
a1.set_transition(LineTransition(a1.figures['B'], a1.figures['A'], ['c']))
a1.set_transition(LoopTransition(a1.figures['A'], ['c']))
a1.set_transition(LoopTransition(a1.figures['D'], ['c']))
a1.set_transition(LineTransition(a1.figures['D'], a1.figures['B'], ['a']))
a1.set_transition(LineTransition(a1.figures['D'], a1.figures['E'], ['b']))
a1.set_transition(LineTransition(a1.figures['A'], a1.figures['E'], ['b']))  
g3=Grid(21, 10)
g3.set_step(0.5)
g3.set_margin(0.25)
g3.set_color((128, 128, 128))
g3.set_line(LineType.SOLID)
a1.figures['A'].set_position(Point(2, 1))
a1.figures['B'].set_position(Point(5, 1))
a1.figures['C'].set_position(Point(7, 1))
a1.figures['D'].set_position(Point(10, 1)) 
a1.figures['E'].set_position(Point(4.5, 4)) 
 
p1 = a1.figures['B'].get_position()+Point.from_polar(200 ,0.7 )  
p2 = a1.figures['A'].get_position()+Point.from_polar(20 ,0.7 )  
pm = (a1.figures['A'].get_position()+a1.figures['B'].get_position()) /2 +Point(0 ,0.5 )  
a1.set_transition(CustomTransition('<B,A>', [p1,pm,p2], a1.figures['<B,A>'].symbols))
a1.figures['<B,A>'].labelAlignment = Align.ABOVE 
a1.figures['<B,A>'].labelReferencePoint = pm
p1 = a1.figures['D'].get_position()+Point.from_polar(200 ,0.7 )  
p2 = a1.figures['B'].get_position()+Point.from_polar(20 ,0.7 )  
pm = (a1.figures['D'].get_position()+a1.figures['B'].get_position()) /2 +Point(0 ,1.0 )  
a1.set_transition(CustomTransition('<D,B>', [p1,pm,p2], a1.figures['<D,B>'].symbols))
a1.figures['<D,B>'].labelAlignment = Align.ABOVE 
a1.figures['<D,B>'].labelReferencePoint = pm
a1.figures['<A,E>'].labelAlignment = Align.LEFT
a1.figures['<D,E>'].labelAlignment = Align.RIGHT
a1.figures['<C,E>'].labelAlignment = Align.RIGHT
a1.figures['<E,E>'].labelAlignment = Align.LEFT 
window = np.zeros((500 +10, 300 +10, 3), dtype="uint8")
window.fill(100)
vp1 = np.zeros((500 , 300 , 3), dtype="uint8")
vp1.fill(255)
frame1 = Animation()
frame1.add_to_show(g3) 
 
frame2 = Animation()
frame2.add_to_show(a1.figures['A'].set_type(StateType.NORMAL))
frame2.add_to_show(a1.figures['B'].set_type(StateType.NORMAL))
frame2.add_to_show(a1.figures['D'].set_type(StateType.NORMAL)) 
for i in ["A","B","D"]:
    frame2.add_to_show(a1.figures[i].set_type(StateType.NORMAL)) 
frame2.add_to_show(a1.figures['C'].set_type(StateType.NORMAL))
frame2.add_to_show(a1.figures['<A,B>'])
frame2.add_to_show(a1.figures['<B,C>'])
frame2.add_to_show(a1.figures['<C,D>']) 
 
frame3 = Animation()
frame3.add_to_show(a1.figures['E'].set_type(StateType.NORMAL))
frame3.add_to_show(a1.figures['<C,E>'])
frame3.add_to_show(a1.figures['<E,E>']) 
 
frame4 = Animation()
frame4.add_to_show(a1.figures['<B,B>'])
frame4.add_to_show(a1.figures['<B,A>']) 
 
frame5 = Animation()
frame5.add_to_show(a1.figures['<A,A>'])
frame5.add_to_show(a1.figures['<A,E>'])
frame5.add_to_show(a1.figures['<D,D>'])
frame5.add_to_show(a1.figures['<D,E>'])
frame5.add_to_show(a1.figures['<D,B>']) 
 
frame6 = Animation()
frame6.add_to_show(a1.figures['A'].set_type(StateType.NORMAL))
frame6.add_to_show(a1.figures['B'].set_type(StateType.NORMAL))
frame6.add_to_show(a1.figures['C'].set_type(StateType.NORMAL)) 
for i in ["A","B","D"]:
    frame6.add_to_show(a1.figures[i].set_type(StateType.ACCEPTING)) 
    
sequence = Sequence(vp1, window)
sequence.add(frame1)
sequence.add(frame2)
sequence.add(frame3)
sequence.add(frame4)
sequence.add(frame5)
sequence.next_step()
sequence.next_step()
sequence.next_step()
sequence.next_step()
sequence.next_step()
  