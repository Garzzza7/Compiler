import copy
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

    @staticmethod
    def from_polar(angle, normal):
        angle = angle * math.pi / 180
        return Point(math.cos(angle) * normal, math.sin(angle) * normal)

    def round_to_int(self):
        return int(round(self.x)), int(round(self.y))

    def norm(self):
        return math.sqrt(self.x ** 2 + self.y ** 2)


class Align(Enum):
    CENTERED = 0
    LEFT = 1
    RIGHT = 2
    ABOVE = 3
    BELOW = 4


class Showable:
    def __init__(self):
        self.position = Point(0, 0)
        self.stroke_color = (0, 0, 0)
        self.stroke_thickness = 2

    def draw(self, mat):
        pass


class Transition(Showable):
    def __init__(self, name, symbols):
        super().__init__()
        self.name = name
        self.symbols = symbols
        self.labelReferencePoint = Point(0, 0)
        self.labelAlignment = Align.CENTERED
        self.arrowPoints = []

    def draw(self, mat):
        points = []
        for p in self.arrowPoints:
            p1 = p * SCALE
            points.append(p1.round_to_int())

        for i, p in enumerate(points[:-2]):
            cv.line(mat, p, points[i + 1], self.stroke_color, self.stroke_thickness)
        cv.arrowedLine(mat, points[-2], points[-1], self.stroke_color, self.stroke_thickness)

        # draw label
        sym = copy.deepcopy(self.symbols)
        text_to_write = sym.pop(0)
        for s in sym:
            text_to_write += ", "
            text_to_write += s

        c = self.labelReferencePoint * SCALE
        sz, _ = cv.getTextSize(text_to_write, cv.FONT_HERSHEY_SIMPLEX, 0.4, self.stroke_thickness)

        match self.labelAlignment:
            case Align.CENTERED:
                c = Point(-sz[0] / 2, sz[1] / 2) + c
            case Align.LEFT:
                c = c
            case Align.RIGHT:
                c = c + Point(-sz[0], 0)
            case Align.BELOW:
                c = c + Point(0, sz[1])
            case Align.ABOVE:
                c = c + Point(0, -sz[1])

        center = c.round_to_int()
        cv.putText(mat, text_to_write, center, cv.FONT_HERSHEY_SIMPLEX, 0.4, self.stroke_thickness)


class LineTransition(Transition):
    def __init__(self, start_state, end_state, symbols):
        super().__init__('<' + start_state.name + ',' + end_state.name + '>', symbols)
        self.start_state = start_state
        self.end_state = end_state

    def draw(self, mat):
        p1 = self.start_state.get_position()
        p2 = self.end_state.get_position()

        p21 = p2 - p1
        d = p21 / p21.norm() * 0.7
        pa = p1 + d
        self.arrowPoints.append(pa)
        pb = p2 - d
        self.arrowPoints.append(pb)

        p = Point(0, -0.2) + (pa + pb) / 2
        self.labelReferencePoint = p
        self.labelAlignment = Align.CENTERED

        super().draw(mat)


class LoopTransition(Transition):
    def __init__(self, start_state, symbols):
        super().__init__('<' + start_state.name + ',' + start_state.name + '>', symbols)

        self.start_state = start_state

    def draw(self, mat):
        p = self.start_state.get_position()

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

        super().draw(mat)


class CustomTransition(Transition):
    def __init__(self, name, arrow_positions, symbols):
        super().__init__(name, symbols)
        self.positions = arrow_positions

        if len(arrow_positions) % 2 != 0:
            position = arrow_positions[(len(arrow_positions) / 2).__floor__()]
        else:
            position = arrow_positions[(len(arrow_positions) / 2).__floor__()] \
                       + arrow_positions[(len(arrow_positions) / 2).__floor__() + 1]

        position += Point(0, -0.2)
        self.labelReferencePoint = position

    def draw(self, mat):

        for pos in self.positions:
            self.arrowPoints.append(pos)

        super().draw(mat)


class StateType(Enum):
    NORMAL = 0,
    INITIAL = 1,
    ACCEPTING = 2,


class State(Showable):
    def __init__(self, name):
        super().__init__()
        self.name = name
        self.type = StateType.NORMAL
        self.radius = 0.5

    def set_type(self, state_type):
        self.type = state_type
        return self

    def set_position(self, point):
        self.position = point
        return self

    def get_position(self):
        return self.position

    def draw(self, mat):

        # determine center and radius in image coordinates
        c = self.position * SCALE
        center = c.round_to_int()
        r = int(round(self.radius * SCALE))

        # draw state shape
        cv.circle(mat, center, r, self.stroke_color, self.stroke_thickness)
        if self.type == StateType.ACCEPTING:
            r2 = int(round(0.8 * self.radius * SCALE))
            cv.circle(mat, center, r2, self.stroke_color, self.stroke_thickness)
        if self.type == StateType.INITIAL:
            pass  # TODO Add drawing features for initial states.

        # draw label
        sz, _ = cv.getTextSize(self.name, cv.FONT_HERSHEY_SIMPLEX, 0.8, self.stroke_thickness)
        c = Point(-sz[0] / 2, sz[1] / 2) + c
        center = c.round_to_int()
        cv.putText(mat, self.name, center, cv.FONT_HERSHEY_SIMPLEX, 0.8, self.stroke_thickness)


class Automaton:
    def __init__(self):
        self.name = ""
        self.figures = {}

    def set_state(self, state):
        self.figures[state.name] = state

    def set_transition(self, transition):
        self.figures[transition.name] = transition

    def draw(self):
        for f in self.figures:
            f.draw()


class LineType(Enum):
    SOLID = 0,
    DOTTED = 1,
    DASHED = 2


class Grid(Showable):
    def __init__(self, width, height):
        super().__init__()
        self.width = width
        self.height = height
        self.step = 0.5
        self.margin = 0.33
        self.line = LineType.SOLID

    def set_step(self, step):
        self.step = step

    def set_margin(self, margin):
        self.margin = margin

    def set_color(self, color):
        self.stroke_color = color

    def set_line(self, line):
        self.line = line

    def draw(self, mat):
        width = int(self.width * SCALE)
        height = int(self.height * SCALE)
        step = int(self.step * SCALE)
        margin = int(self.margin * SCALE)

        current_width = margin
        current_height = margin

        while current_width <= width + margin:

            if self.line == LineType.SOLID:
                cv.line(mat,
                        (current_width, margin),
                        (current_width, height + margin),
                        self.stroke_color,
                        self.stroke_thickness)

            if self.line == LineType.DOTTED:
                for i in range(margin, height + margin):
                    if i % (self.stroke_thickness * 2) == 0:
                        cv.line(mat,
                                (current_width, i),
                                (current_width, i),
                                self.stroke_color,
                                self.stroke_thickness)

            if self.line == LineType.DASHED:
                for i in range(margin, height + margin):
                    if i % (self.stroke_thickness * 5) <= 4:
                        cv.line(mat,
                                (current_width, i),
                                (current_width, i),
                                self.stroke_color,
                                self.stroke_thickness)

            current_width += step

        while current_height <= height + margin:

            if self.line == LineType.SOLID:
                cv.line(mat,
                        (margin, current_height),
                        (width + margin, current_height),
                        self.stroke_color,
                        self.stroke_thickness)

            if self.line == LineType.DOTTED:
                for i in range(margin, width + margin):
                    if i % (self.stroke_thickness * 2) == 0:
                        cv.line(mat,
                                (i, current_height),
                                (i, current_height),
                                self.stroke_color,
                                self.stroke_thickness)

            if self.line == LineType.DASHED:
                for i in range(margin, width + margin):
                    if i % (self.stroke_thickness * 5) <= 4:
                        cv.line(mat,
                                (i, current_height),
                                (i, current_height),
                                self.stroke_color,
                                self.stroke_thickness)

            current_height += step


# Animation code


class Animation:
    def __init__(self):
        self.to_show = []

    def add_to_show(self, showable):
        self.to_show.append(copy.deepcopy(showable))

    def show(self, mat):
        for showable in self.to_show:
            showable.draw(mat)


class Sequence:
    def __init__(self, mat, win):
        self.animations = []
        self.mat = mat
        self.window = win

    def add(self, animation):
        self.animations.append(animation)

    def next_step(self):
        self.animations.pop(0).show(self.mat)
        np.copyto(self.window[10:, 10:, :], self.mat)
        cv.imshow('Sequence', self.window)
        cv.waitKey(0)
