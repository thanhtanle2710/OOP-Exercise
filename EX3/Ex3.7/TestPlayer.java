


	public class TestPlayer {
	    public static void main(String[] args) {       
	        Player player = new Player(7, 0, 0);
	        Ball ball = new Ball(5, 5, 0);
	        System.out.println("Player gần bóng? " + player.near(ball)); 
	        player.move(3, 4);
	        System.out.println("Player sau khi di chuyển: " +player );
	        player.kick(ball);
	        System.out.println("Bóng sau khi bị đá: " + ball);
	    }
	}

