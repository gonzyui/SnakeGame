package fr.gonzyui.snake;

public class Food extends GameObject {

    public Food(char symbol) {
        setSymbol(symbol);
    }

    public void addRandomFood(GameScreen screen, Food food) {
        screen.setObjectOnLocation(food, (int) (Math.random() * (screen.getScreenWidth() - 1)),
                (int) (Math.random() * (screen.getScreenHeight() - 1)));
    }
}
