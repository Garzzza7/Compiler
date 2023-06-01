import cv2 as cv
import numpy as np
import math
from enum import Enum

# --------------------------------------------------------


SCALE = 50.0


# --------------------------------------------------------


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __add__(self, other):
        return Point(self.x + other.x, self.y + other.y)

    def __sub__(self, other):
        return Point(self.x - other.x, self.y - other.y)

    def __mul__(self, scalar):
        return Point(self.x * scalar, self.y * scalar)

    def __truediv__(self, scalar):
        return Point(self.x / scalar, self.y / scalar)

    def __floordiv__(self, scalar):
        return Point(self.x // scalar, self.y // scalar)

    def __str__(self):
        return '(' + str(self.x) + ',' + str(self.y) + ')'

    def round_to_int(self):
        return int(round(self.x)), int(round(self.y))

    def norm(self):
        return math.sqrt(self.x ** 2 + self.y ** 2)


# --------------------------------------------------------

class Align(Enum):
    CENTERED = 0
    LEFT = 1
    RIGHT = 2
    ABOVE = 3
    BELOW = 4


# --------------------------------------------------------


class Showable:
    def __init__(self):
        self.position = Point(0, 0)
        self.visible = False
        self.strokeColor = (0, 0, 0)
        self.strokeThickness = 2

    def draw(self, mat):
        pass


# --------------------------------------------------------


class StateType(Enum):
    NORMAL = 0,
    INITIAL = 1,
    ACCEPTING = 2,


# --------------------------------------------------------


class Transition(Showable):
    def __init__(self, symbols):
        self.symbols = symbols
        self.labelAlignment = Align.CENTERED
        self.arrowPoints = []

    def draw(self, mat):
        points = []
        for p in self.arrowPoints:
            p1 = p * SCALE
            points.append(p1.roundToInt())

        for i, p in enumerate(points[:-2]):
            cv.line(mat, p, points[i + 1], self.strokeColor, self.strokeThickness)
        cv.arrowedLine(mat, points[-2], points[-1], self.strokeColor, self.strokeThickness)


# --------------------------------------------------------


class LineTransition(Transition):
    def __init__(self, start_state, end_state, symbols):
        super().__init__(symbols)

        self.start_state = start_state
        self.end_state = end_state

        p1 = start_state.get_position()
        p2 = end_state.get_position()

        p21 = p2 - p1
        d = p21 / p21.norm() * 0.7
        pa = p1 + d
        self.arrowPoints.append(pa)
        pb = p2 - d
        self.arrowPoints.append(pb)

        p = (pa + pb) / 2 + Point(0, -0.2)
        self.labelReferencePoint = p
        self.labelAlignment = Align.CENTERED


# --------------------------------------------------------


class LoopTransition(Transition):
    def __init__(self, start_state, symbols):
        super().__init__(symbols)

        self.start_state = start_state

        p = start_state.get_position()

        p1 = p + Point(-0.2, -0.6)
        self.arrowPoints.append(p1)
        p1 = p1 + Point(-0.2, -0.3)
        self.arrowPoints.append(p1)
        p1 = p1 + Point(0.8, 0.0)
        self.arrowPoints.append(p1)
        p1 = p1 + Point(-0.2, 0.3)
        self.arrowPoints.append(p1)

        p1 = p1 + Point(0.2, -0.2)
        self.labelReferencePoint = p1
        self.labelAlignment = Align.LEFT

# --------------------------------------------------------


class State(Showable):
    def __init__(self, name):
        super().__init__()
        self.name = name
        self.type = StateType.NORMAL
        self.radius = 0.5

    def set_type(self, state_type):
        self.type = state_type

    def set_position(self, point):
        self.position = point

    def get_position(self):
        return self.position

    def draw(self, mat):
        # if not visible do nothing
        if not self.visible:
            return

        print('  Drawing state ' + self.name)

        # determine center and radius in image coordinates
        c = self.position * SCALE
        center = c.roundToInt()
        r = int(round(self.radius * SCALE))

        # draw state shape
        cv.circle(mat, center, r, self.strokeColor, self.strokeThickness)
        if self.type == StateType.ACCEPTING:
            r2 = int(round(0.8 * self.radius * SCALE))
            cv.circle(mat, center, r2, self.strokeColor, self.strokeThickness)
        if self.type == StateType.INITIAL:
            pass  # TODO Add drawing features for initial states.

        # draw label
        sz, _ = cv.getTextSize(self.name, cv.FONT_HERSHEY_SIMPLEX, 0.8, self.strokeThickness)
        c = c + Point(-sz[0] / 2, sz[1] / 2)
        center = c.roundToInt()
        cv.putText(mat, self.name, center, cv.FONT_HERSHEY_SIMPLEX, 0.8, self.strokeThickness)


# --------------------------------------------------------


class Automaton:
    def __init__(self):
        self.name = ""
        self.states = []
        self.transitions = []

    def add_state(self, state):
        self.states.append(state)

    def add_transition(self, transition):
        self.transitions.append(transition)


# Animation code

class Animation:
    def __init__(self):
        self.to_show = []

    def add_to_show(self, showable):
        self.to_show.append(showable)

    def show(self):
        for showable in self.to_show:
            showable.show()


# --------------------------------------------------------


class Sequence:
    def __init__(self):
        self.animations = []

    def add(self, animation):
        self.animations.append(animation)

    def next_step(self):
        self.animations.pop(0).show()

# --------------------------------------------------------