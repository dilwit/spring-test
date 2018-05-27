package net.dilwit.test.service;

public class Move implements IMove {
	
	private MoveSideWays sideWays;
	private MoveUpAndDown upAndDown;
	
	public Move(MoveSideWays sideWays, MoveUpAndDown upAndDown) {
		this.sideWays = sideWays;
		this.upAndDown = upAndDown;
	}
	
	@Override
	public void makeMove() {
		
	}
}
