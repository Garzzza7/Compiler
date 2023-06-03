# Importing the framework from main
from main import *

# noinspection DuplicatedCode
a1 = Automaton()

# state A, B;
a1.set_state(State('A'))
a1.set_state(State('B'))

# A [initial = true];
# B [accepting = true];
a1.states['A'].set_type(StateType.INITIAL)
a1.states['B'].set_type(StateType.ACCEPTING)

# A -> 'a','b' -> B,
# A -> 'a','b','c' -> A;
a1.set_transition(LineTransition(a1.states['A'], a1.states['B'], {'a', 'b'}))
a1.set_transition(LoopTransition(a1.states['A'], {'a', 'b', 'c'}))

# I skipped the declaration of a view completely in hope that it will be enough to just define the positions of figures.

# place A at (2,1), B at (5,1);
a1.states['A'].set_position(Point(2, 1))
a1.states['B'].set_position(Point(5, 1))

# create the main window (animation support)
window = np.zeros((510, 510, 3), dtype="uint8")
window.fill(100)

# create a viewport (vp1)
vp1 = np.zeros((500, 500, 3), dtype="uint8")
vp1.fill(255)

# ---------- HERE STARTS ANIMATION DECLARATION -----------

# show A, B [accepting = false];
# pause;
frame1 = Animation()
frame1.add_to_show(a1.states['A'].set_type(StateType.NORMAL))
frame1.add_to_show(a1.states['B'].set_type(StateType.NORMAL))

# show <A,B>;
# pause;
frame2 = Animation()
frame2.add_to_show(a1.transitions['<A,B>'])

# show <A,A>;
# pause;
frame3 = Animation()
frame3.add_to_show(a1.transitions['<A,A>'])

# show B [accepting = true];
# pause;
frame4 = Animation()
frame4.add_to_show(a1.states['B'].set_type(StateType.ACCEPTING))

# Then all the animations are arranged in a sequence:

sequence = Sequence(vp1, window)
sequence.add(frame1)
sequence.add(frame2)
sequence.add(frame3)
sequence.add(frame4)

# And then shown:

sequence.next_step()
sequence.next_step()
sequence.next_step()
sequence.next_step()
