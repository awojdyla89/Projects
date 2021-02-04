/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg02 - MazeSolver class
 * Your name(s): Adam C Wojdyla
 */

import jdk.jshell.execution.LoaderDelegate;

class MazeSolver {

    private Maze maze;
    private MazeGUI gui;

    MazeSolver(int size) {
        this.maze = new Maze(size);
        this.gui = new MazeGUI(maze);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MazeSolver mazeSolver = new MazeSolver(50);
        Path path = mazeSolver.solve();
        if (path != null)
            System.out.println("Found a solution!");
        else
            System.out.println("A solution does not exist!");
    }

    void repaint(Path path) {
        gui.setPath(path);
        gui.repaint();
        try {
            Thread.sleep(50);
        } catch (Exception ex) {

        }
    }

    // TODOd: implement the exhaustive search algorithm to find a solution to the maze puzzle
    private Path solve() throws CloneNotSupportedException {
        Stack stack = new Stack();
        Path path = new Path(maze);
        path.append(new Location());
        stack.push(path);
        Location goal = new Location(maze.getSize() - 1, maze.getSize() - 1);

        while (!stack.isEmpty()) {
            Path currentPath = stack.pop();
            repaint(currentPath);
            if (currentPath.getLast().equals(goal)) {
                return path;
            } else {

                Boolean[] bool = {currentPath.canMoveLeft(), currentPath.canMoveUp(),
                        currentPath.canMoveRight(), currentPath.canMoveDown()};
                Location[] local = {new Location(currentPath.getLast().getX() - 1, currentPath.getLast().getY()),
                        new Location(currentPath.getLast().getX(), currentPath.getLast().getY() - 1),
                        new Location(currentPath.getLast().getX() + 1, currentPath.getLast().getY()),
                        new Location(currentPath.getLast().getX(), currentPath.getLast().getY() + 1)};


                for (int i = 0; i < local.length ; i++) {
                    if (bool[i]) {
                        Path clonedPath = (Path) currentPath.clone();
                        clonedPath.append(local[i]);
                        if(!currentPath.contains(local[i])) {
                            stack.push(clonedPath);
                        }
                    }

                }
            }
        }
        return path;
    }
}