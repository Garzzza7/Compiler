# Importing the framework from main
from main import *

# noinspection DuplicatedCode
a3 = Automaton()

# state A, B, C, D, E;
a3.set_state(State('A'))
a3.set_state(State('B'))
a3.set_state(State('C'))
a3.set_state(State('D'))
a3.set_state(State('E'))

# for s in {{ A, B, D }}
# s [accepting = true];
a3.figures['A'].set_type(StateType.ACCEPTING)
a3.figures['B'].set_type(StateType.ACCEPTING)
a3.figures['D'].set_type(StateType.ACCEPTING)

# transition
#     A -> 'a' -> B,
#     B -> 'b' -> C,
#     C -> 'c' -> D,
#     C -> 'a','b' -> E,
#     E -> 'a','b','c' -> E,
#     B -> 'a' -> B,
#     B -> 'c' -> A,
#     A -> 'c' -> A,
#     D -> 'c' -> D,
#     D -> 'a' -> B,
#     D -> 'b' -> E,
#     A -> 'b' -> E;
a3.set_transition(LineTransition(a3.figures['A'], a3.figures['B'], ['a']))
a3.set_transition(LineTransition(a3.figures['B'], a3.figures['C'], ['b']))
a3.set_transition(LineTransition(a3.figures['C'], a3.figures['D'], ['c']))
a3.set_transition(LineTransition(a3.figures['C'], a3.figures['E'], ['a', 'b']))
a3.set_transition(LoopTransition(a3.figures['E'], ['a', 'b', 'c']))
a3.set_transition(LoopTransition(a3.figures['B'], ['a']))
a3.set_transition(LineTransition(a3.figures['B'], a3.figures['A'], ['c']))
a3.set_transition(LoopTransition(a3.figures['A'], ['c']))
a3.set_transition(LoopTransition(a3.figures['D'], ['c']))
a3.set_transition(LineTransition(a3.figures['D'], a3.figures['B'], ['a']))
a3.set_transition(LineTransition(a3.figures['D'], a3.figures['E'], ['b']))
a3.set_transition(LineTransition(a3.figures['A'], a3.figures['E'], ['b']))

# grid g3 (21,10) [  // width = 21; height = 10
#     step = 0.5,        // cell size
#     margin = 0.25,     // external margin (must be lower than step)
#     color = gray,      // stroke color
#     line = solid       // may also be dotted or dashed
# ];
g3 = Grid(21, 10)
g3.set_step(0.5)
g3.set_margin(0.25)
g3.set_color((128, 128, 128))
g3.set_line(LineType.SOLID)

# place A at (2,1), B at (5,1), C at (7,1), D at (10,1);
# place E at (4.5,4);
a3.figures['A'].set_position(Point(2, 1))
a3.figures['B'].set_position(Point(5, 1))
a3.figures['C'].set_position(Point(7, 1))
a3.figures['D'].set_position(Point(10, 1))
a3.figures['E'].set_position(Point(4.5, 4))

# point p1, p2, pm;
# p1 = (B) + (200:0.7);
# p2 = (A) + (20:0.7);
# pm = ((A) + (B)) / 2 + (0,0.5);
p1 = a3.figures['B'].get_position() + Point.from_polar(200, 0.7)
p2 = a3.figures['A'].get_position() + Point.from_polar(20, 0.7)
pm = (a3.figures['A'].get_position() + a3.figures['B'].get_position()) / 2 + Point(0, 0.5)

# <B,A> as p1 -- pm -- p2;
# place <B,A>#label [align=above] at pm;
a3.set_transition(CustomTransition('<B,A>', [p1, pm, p2], a3.figures['<B,A>'].symbols))
a3.figures['<B,A>'].labelAlignment = Align.ABOVE
a3.figures['<B,A>'].labelReferencePoint = pm

# p1 = (D) + (200:0.7);
# p2 = (B) + (20:0.7);
# pm = ((D) + (B)) / 2 + (0,1.0);
p1 = a3.figures['D'].get_position() + Point.from_polar(200, 0.7)
p2 = a3.figures['B'].get_position() + Point.from_polar(20, 0.7)
pm = (a3.figures['D'].get_position() + a3.figures['B'].get_position()) / 2 + Point(0, 1)

# <D,B> as p1 -- pm -- p2;
# place <D,B>#label [align=above] at pm;
a3.set_transition(CustomTransition('<D,B>', [p1, pm, p2], a3.figures['<D,B>'].symbols))
a3.figures['<D,B>'].labelAlignment = Align.ABOVE
a3.figures['<D,B>'].labelReferencePoint = pm

# <A,E>#label [align=below left];
# <D,E>#label [align=below right];
# <C,E>#label [align=right];
# <E,E>#label [align=left];
a3.figures['<A,E>'].labelAlignment = Align.LEFT
a3.figures['<D,E>'].labelAlignment = Align.RIGHT
a3.figures['<C,E>'].labelAlignment = Align.RIGHT
a3.figures['<E,E>'].labelAlignment = Align.LEFT

# ---------- HERE STARTS ANIMATION DECLARATION -----------

# create the main window (animation support)
window = np.zeros((510, 1310, 3), dtype="uint8")
window.fill(100)

# create a viewport (vp2)
vp3 = np.zeros((500, 1300, 3), dtype="uint8")
vp3.fill(255)

# show g3;
# pause;
frame1 = Animation()
frame1.add_to_show(g3)

# for i in {{ A, B, D }} <<<
#     show i [accepting = false];
# >>>
# show C, <A,B>, <B,C>, <C,D>;
# pause;
frame2 = Animation()
for i in {'A', 'B', 'D'}:
    frame2.add_to_show(a3.figures[i].set_type(StateType.NORMAL))
frame2.add_to_show(a3.figures['C'])
frame2.add_to_show(a3.figures['<A,B>'])
frame2.add_to_show(a3.figures['<B,C>'])
frame2.add_to_show(a3.figures['<C,D>'])

# show E, <C,E>, <E,E>;
# pause;
frame3 = Animation()
frame3.add_to_show(a3.figures['E'])
frame3.add_to_show(a3.figures['<C,E>'])
frame3.add_to_show(a3.figures['<E,E>'])

# show <B,B>, <B,A>;
# pause;
frame4 = Animation()
frame4.add_to_show(a3.figures['<B,B>'])
frame4.add_to_show(a3.figures['<B,A>'])

# show <A,A>, <A,E>, <D,D>, <D,E>, <D,B>;
# pause;
frame5 = Animation()
frame5.add_to_show(a3.figures['<A,A>'])
frame5.add_to_show(a3.figures['<A,E>'])
frame5.add_to_show(a3.figures['<D,D>'])
frame5.add_to_show(a3.figures['<D,E>'])
frame5.add_to_show(a3.figures['<D,B>'])

# for i in {{ A, B, D }} <<<
#     show i [accepting = true];
# >>>
# pause;
frame6 = Animation()
for i in {'A', 'B', 'D'}:
    frame6.add_to_show(a3.figures[i].set_type(StateType.ACCEPTING))

# And finally sequence:
sequence = Sequence(vp3, window)
sequence.add(frame1)
sequence.add(frame2)
sequence.add(frame3)
sequence.add(frame4)
sequence.add(frame5)
sequence.add(frame6)

sequence.next_step()
sequence.next_step()
sequence.next_step()
sequence.next_step()
sequence.next_step()
sequence.next_step()
