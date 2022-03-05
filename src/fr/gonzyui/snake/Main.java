package fr.gonzyui.snake;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int SCREEN_WIDTH = 20;
        final int SCREEN_HEIGHT = 10;
        final int SNAKE_STARTING_X = SCREEN_WIDTH / 2;
        final int SNAKE_STARTING_Y = SCREEN_HEIGHT / 2;

        GameScreen screen = new GameScreen(SCREEN_WIDTH, SCREEN_HEIGHT);
        screen.InitScreen();

        Wall wall = new Wall('#');
        wall.addWallsRow(screen, wall, 0);
        wall.addWallsRow(screen, wall, screen.getScreenHeight() - 1);
        wall.addWallsColumn(screen, wall, 0);
        wall.addWallsColumn(screen, wall, screen.getScreenWidth() - 1);

        Snake snake = new Snake('@', SNAKE_STARTING_X, SNAKE_STARTING_Y);
        screen.setObjectOnLocation(snake, snake.getX(), snake.getY());

        Food food = new Food('*');
        food.addRandomFood(screen, food);

        Scanner scanner = new Scanner(System.in);
        char input;

        boolean isRunning = true;

        while (isRunning) {
            screen.PrintScreen();
            switch (input = scanner.nextLine().charAt(0)) {
                case 'a':
                    snake.moveLeft(screen, snake);
                    break;
                case 'd':
                    snake.moveRight(screen, snake);
                    break;
                case 'w':
                    snake.moveUp(screen, snake);
                    break;
                case 's':
                    snake.moveDown(screen, snake);
                    break;
            }
        }
    }
}
