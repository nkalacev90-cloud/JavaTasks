package JavaTask;

public class Player {
    public String name;
    public int level;
    public int score;
    public int lives;
    public boolean isVip;

    public void showInfo() {
        System.out.println("Игрок: " + this.name + " Уровень: " + this.level + " Здоровье: " + this.lives);
    }

    public void takeDamage(int damag){
        this.lives -= damag;
    }

    public void levelUp(){
        this.level += 1;
    }


}


