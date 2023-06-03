# Importing the framework from main
from main import *

# noinspection DuplicatedCode
a2 = Automaton()

# state A, B;
a2.set_state(State('A'))
a2.set_state(State('B'))

# A [initial = true];
# B [accepting = true];
a2.figures['A'].set_type(StateType.INITIAL)
a2.figures['B'].set_type(StateType.ACCEPTING)

# A -> 'a','b' -> B,
# A -> 'c' -> A,
# B -> 'c' -> A,
# B -> 'a','b' -> B;
a2.set_transition(LineTransition(a2.figures['A'], a2.figures['B'], ['a', 'b']))
a2.set_transition(LoopTransition(a2.figures['A'], ['c']))
a2.set_transition(LineTransition(a2.figures['B'], a2.figures['A'], ['c']))
a2.set_transition(LoopTransition(a2.figures['B'], ['a', 'b']))

# place A at (2,1), B at (5,1);
a2.figures['A'].set_position(Point(2, 1))
a2.figures['B'].set_position(Point(5, 1))

# point p1;
# p1 = (B);
p1 = a2.figures['B'].get_position()

# point x1 = (200:0.6);
x1 = Point.from_polar(200, 0.6)

# p1 = p1 + x1;
p1 = p1 + x1

# point p2 = (A) + (-20:0.6);
# point pm = (p1+p2)/2 + (0,0.2);
p2 = a2.figures['A'].get_position() + Point.from_polar(-20, 0.6)
pm = (p1+p2)/2 + Point.from_polar(0, 0.2)

# <B,A> as p1 -- pm -- p2;
a2.set_transition(CustomTransition('<B,A>', [p1, pm, p2], a2.figures['<B,A>'].symbols))
a2.figures['<B,A>'].labelAlignment = Align.BELOW
a2.figures['<B,A>'].labelReferencePoint = pm

# ---------- HERE STARTS ANIMATION DECLARATION -----------

# create the main window (animation support)
window = np.zeros((510, 310, 3), dtype="uint8")
window.fill(100)

# create a viewport (vp2)
vp2 = np.zeros((500, 300, 3), dtype="uint8")
vp2.fill(255)

# show A;
# pause;
frame1 = Animation()
frame1.add_to_show(a2.figures['A'])

# show <A,A>;
# pause;
frame2 = Animation()
frame2.add_to_show(a2.figures['<A,A>'])

# show B;
# show <A,B>;
# pause;
frame3 = Animation()
frame3.add_to_show(a2.figures['B'])
frame3.add_to_show(a2.figures['<A,B>'])

# show <B,B>;
# pause;
frame4 = Animation()
frame4.add_to_show(a2.figures['<B,B>'])

# show <B,A>;
# pause;
frame5 = Animation()
frame5.add_to_show(a2.figures['<B,A>'])

# Now the sequence
sequence = Sequence(vp2, window)
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
