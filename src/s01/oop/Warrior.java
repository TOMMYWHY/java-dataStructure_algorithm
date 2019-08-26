package s01.oop;

public class Warrior extends Hero {

	private int neering;
	
	

	public Warrior() {
//		super();
		System.out.println("children~!");
		// TODO Auto-generated constructor stub
	}

	public Warrior(String nickname, int level, int maxHp) {
//		super(nickname, level, maxHp);
		// TODO Auto-generated constructor stub
	}
	

	
	public Warrior(String nickname) {
		setNickname(nickname);
	}

	/*override*/
//	public void move(){
//		System.out.println(getNickname()+" : moving fast....");
//	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println(getNickname()+" : moving fast.fastfastfast...");
	}

	public int getNeering() {
		return neering;
	}

	public void setNeering(int neering) {
		this.neering = neering;
	}
}
