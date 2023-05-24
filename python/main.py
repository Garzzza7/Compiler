import cv2
import numpy as np

alphabet = ['a', 'b', 'c', 'd']
states = ['A', 'B']

# GLOBAL STUFF
# Screen parameters and creation
# Create a blank canvas
width, height = 1000, 1000
canvas = np.ones((height, width, 3), dtype=np.uint8) * 255
node_radius = 40
node_color = (0, 0, 0)
node_thickness = 2
line_color = (0, 0, 255)
line_thickness = 2

text_font = cv2.FONT_HERSHEY_SIMPLEX
text_scale = 1.5
text_thickness = 2
text_color = (0, 0, 0)


class Node:
    state = 'A'
    positionx = 0
    positiony = 0
    is_initial = 0
    is_accepting = 0

    def __init__(self, state, positionx, positiony, is_initial, is_accepting):
        self.state = state
        self.positionx = positionx
        self.positiony = positiony
        self.is_initial = is_initial
        self.is_accepting = is_accepting

    def set_accepting(self):
        is_accepting = self

    def set_initial(self):
        is_accepting = self

    def set_positionx(self):
        positionx = self

    def set_positiony(self):
        positiony = self

# if the node is accepting, it draws a larger circle around it and if the node is initial, it draws an arrow pointing to that node
    def show_state(self):
        start_point = (self.positionx - 100, self.positiony)
        end_point = (self.positionx - node_radius, self.positiony)
        if self.is_accepting:
            end_point = (self.positionx - node_radius, self.positiony)
            cv2.circle(canvas, (self.positionx, self.positiony), node_radius + 10, node_color, node_thickness)
        if self.is_initial:
            cv2.arrowedLine(canvas, start_point, end_point, line_color, line_thickness, tipLength=0.5)
        cv2.putText(canvas, self.state, (self.positionx - 14, self.positiony + 14), text_font, text_scale, text_color,
                    text_thickness, cv2.LINE_AA)
        cv2.circle(canvas, (self.positionx, self.positiony), node_radius, node_color, node_thickness)

# it is used to connect two nodes on the canvas and display the transition between them
def connect_nodes(node1: Node, node2: Node, arr):
    # text_size, _ = cv2.getTextSize(arr, text_font, text_scale, text_thickness)
    string = " "
    for i in arr:
        string += i
        string += " "

    angle = 90
    if len(string) <= 3:
        text_position = (
            (node1.positionx + node2.positionx - 80) // 2,
            (node1.positiony + node2.positiony) // 2 - 20)
    elif 3 < len(string) < 6:
        text_position = (
            (node1.positionx + node2.positionx - 100) // 2,
            (node1.positiony + node2.positiony) // 2 - 20)
    else:
        text_position = (
            (node1.positionx + node2.positionx - 100) // 2,
            (node1.positiony + node2.positiony) // 2 - 20)

    cv2.putText(canvas, string, text_position, text_font, text_scale - 0.5, text_color, text_thickness)

    M = cv2.getRotationMatrix2D(text_position, angle, 1)
    cv2.warpAffine(canvas, M, (canvas.shape[1], canvas.shape[0]))

    # M = cv2.getRotationMatrix2D(text_position, angle, 1)
    # cv2.warpAffine(canvas, M, (canvas.shape[1], canvas.shape[0]))

    cv2.line(canvas, (node1.positionx, node1.positiony), (node2.positionx, node2.positiony), line_color, line_thickness)

    #    cv2.line(canvas, (node1.positionx+node_radius,node1.positiony+node_radius), (node2.positionx-(node_radius//2),node2.positiony-(node_radius//2)), line_color, line_thickness)


'''def dashed_line_drawer(canvas, initial_x, initial_y, width, height, step, margin, color=(0, 255, 0)):
    new_width = initial_x
    new_height = initial_y
    while new_width <= width + initial_x:
        for i in range(initial_x, width + initial_x):
            if i % 5 != 0:
                cv2.line(canvas, (new_width, i), (new_width, i), color=color, thickness=margin)
        new_width += step
    while new_height <= height + initial_y:
        for i in range(initial_y, height + initial_y):
            if i % 5 != 0:
                cv2.line(canvas, (i, new_height), (i, new_height), color=color, thickness=margin)
        new_height += step'''

def dashed_line_drawer(canvas, initial_x, initial_y, width, height, step, margin, color=(0, 255, 0)):
    for x in range(initial_x, width + initial_x, step):
        for y in range(initial_y, height + initial_y, step):
            if x % 5 != 0:
                cv2.line(canvas, (x, y), (x, y), color=color, thickness=margin)
            if y % 5 != 0:
                cv2.line(canvas, (x, y), (x, y), color=color, thickness=margin)


'''def dotted_line_drawer(canvas, initial_x, initial_y, width, height, step, margin, color=(0, 255, 0)):
    new_width = initial_x
    new_height = initial_y
    while new_width <= width + initial_x:
        for i in range(initial_x, width + initial_x):
            if i % 2 == 0:
                cv2.line(canvas, (new_width, i), (new_width, i), color=color, thickness=margin)
        new_width += step
    while new_height <= height + initial_y:
        for i in range(initial_y, height + initial_y):
            if i % 2 == 0:
                cv2.line(canvas, (i, new_height), (i, new_height), color=color, thickness=margin)
        new_height += step'''
def dotted_line_drawer(canvas, initial_x, initial_y, width, height, step, margin, color=(0, 255, 0)):
    for x in range(initial_x, width + initial_x, step):
        if x % 2 == 0:
            for y in range(initial_y, height + initial_y, step):
                if y % 2 == 0:
                    cv2.line(canvas, (x, y), (x, y), color=color, thickness=margin)

'''def line_drawer(canvas, initial_x, initial_y, width, height, step, margin, color=(0, 255, 0)):
    new_width = initial_x
    new_height = initial_y
    while new_width <= width + initial_x:
        cv2.line(canvas, (new_width, initial_x), (new_width, width + + initial_x), color=color, thickness=margin)
        new_width += step
    while new_height <= height + initial_y:
        cv2.line(canvas, (initial_y, new_height), (height + initial_y, new_height), color=color, thickness=margin)
        new_height += step'''

def line_drawer(canvas, initial_x, initial_y, width, height, step, margin, color=(0, 255, 0)):
    for x in range(initial_x, width + initial_x, step):
        cv2.line(canvas, (x, initial_y), (x, initial_y + height), color=color, thickness=margin)

    for y in range(initial_y, height + initial_y, step):
        cv2.line(canvas, (initial_x, y), (initial_x + width, y), color=color, thickness=margin)


def self_connect(node: Node, arr):
    string = " "
    for i in arr:
        string += i
        string += " "
    loop_center = (node.positionx, node.positiony - node_radius)
    loop_radius = node_radius - 10
    loop_start_angle = 160
    loop_end_angle = 380
    # text_position = (node.positionx - node_radius - 20, node.positiony - node_radius - 40)
    if len(string) <= 3:
        text_position = (node.positionx - node_radius + 10, node.positiony - node_radius - 40)
    elif 3 < len(string) < 6:
        text_position = (node.positionx - node_radius - 5, node.positiony - node_radius - 40)
    else:
        text_position = (node.positionx - node_radius - 40, node.positiony - node_radius - 40)

    cv2.putText(canvas, string, text_position, text_font,
                text_scale - 0.5, text_color, text_thickness)
    cv2.ellipse(canvas, loop_center, (loop_radius, loop_radius), 0, loop_start_angle, loop_end_angle, line_color,
                line_thickness)


node1 = Node('A', 100, 200, 1, 1)
node2 = Node('B', 300, 300, 1, 0)
node3 = Node('C', 500, 200, 0, 1)
node4 = Node('D', 600, 600, 0, 0)
# node1.show_state()
# node2.show_state()
# node3.show_state()
# node4.show_state()
# self_connect(node2, alphabet)
# connect_nodes(node1, node4, alphabet)

arr = np.array([node1, node4, node3, node2])
arr1 = np.array([node3, node2])

arr2 = np.array([arr, arr1])


def show(arr):
    for i in [arr]:
        i.show_state()
        # for j in [i]:
        #     j.show_state()


# def show_initial():
#     # Define the arrow parameters
#     arrow_start = (100, 200)
#     arrow_end = (180, 200)
#     arrow_tip_size = 10


# Define the positions of the nodes
node1_center = (100, 200)
node2_center = (300, 300)

# cv2.circle(canvas, node1_center, node_radius, node_color, node_thickness)
# cv2.circle(canvas, node2_center, node_radius, node_color, node_thickness)

#
# cv2.line(canvas, node1_center, node2_center, line_color, line_thickness)
#
# # Add the letter 'a' above the line
# text = 'a'
# text_font = cv2.FONT_HERSHEY_SIMPLEX
# text_scale = 1.5
# text_thickness = 2
# text_color = (0, 0, 0)  # Black color in BGR format
# text_size, _ = cv2.getTextSize(text, text_font, text_scale, text_thickness)
# text_position = (
#     (node1_center[0] + node2_center[0] - text_size[0]) // 2,
#     (node1_center[1] + node2_center[1] - text_size[1]) // 2 - 20)
# cv2.putText(canvas, text, text_position, text_font, text_scale, text_color, text_thickness)
#
# loop_center = (node1_center[0] - node_radius, node1_center[1])
# loop_radius = node_radius - 10
# loop_start_angle = 40
# loop_end_angle = 320
# cv2.ellipse(canvas, loop_center, (loop_radius, loop_radius), 0, loop_start_angle, loop_end_angle, line_color,
#             line_thickness)
while True:
    key = cv2.waitKey(0)
    canvas = np.ones((height, width, 3), dtype=np.uint8) * 255
    # draw_grid(canvas, (width, height))
    line_drawer(canvas, 100, 100, 200, 200, 20, 1, (255, 0, 0))
    dotted_line_drawer(canvas, 300, 300, 200, 200, 20, 1, (0, 255, 0))
    dashed_line_drawer(canvas, 600, 600, 200, 200, 20, 1, (0, 0, 255))
    node1.show_state()
    node2.show_state()
    self_connect(node1, alphabet)
    connect_nodes(node1, node2, alphabet)
    cv2.imshow("DFA", canvas)
    if key == 27:
        break
    if cv2.waitKey(0) == ord('a'):
        continue
    canvas = np.ones((height, width, 3), dtype=np.uint8) * 255
    node1.show_state()
    node2.show_state()
    node3.show_state()
    node4.show_state()
    self_connect(node2, alphabet)
    connect_nodes(node1, node4, alphabet)
    cv2.imshow("DFA", canvas)
    if key == 27:
        break
    if cv2.waitKey(0) == ord('a'):
        continue
    canvas = np.ones((height, width, 3), dtype=np.uint8) * 255
    node3.show_state()
    node4.show_state()
    self_connect(node3, alphabet)
    connect_nodes(node3, node4, alphabet)
    cv2.imshow("DFA", canvas)
    # key = cv2.waitKey(0)
    # node1.show_state()
    # node2.show_state()
    # self_connect(node1, alphabet)
    # connect_nodes(node1, node2, alphabet)
    # cv2.imshow("DFA", canvas)
    # if key == 27:
    #     break
    # if cv2.waitKey(0) == ord('a'):
    #     canvas = np.ones((height, width, 3), dtype=np.uint8) * 255
    #     node1.show_state()
    #     node2.show_state()
    #     node3.show_state()
    #     node4.show_state()
    #     self_connect(node2, alphabet)
    #     connect_nodes(node1, node4, alphabet)
    #     cv2.imshow("DFA", canvas)
    # if cv2.waitKey(0) == ord('s'):
    #     show(arr[interator])
    #
    #
    # interator += 1

cv2.destroyAllWindows()
