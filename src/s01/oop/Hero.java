package s01.oop;

public class Hero {

	private String nickname;
	private int level;
	private int maxHp;

	
	
	public Hero() {
//		super();
		System.out.println("father~!");
		// TODO Auto-generated constructor stub
	}


	public Hero(String nickname, int level, int maxHp) {
		super();
		this.nickname = nickname;
		this.level = level;
		this.maxHp = maxHp;
	}
	
	
	public void move(){
		System.out.println("moving....");
	}
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
 
}
