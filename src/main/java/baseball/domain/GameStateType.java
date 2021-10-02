package baseball.domain;

public enum GameStateType {
	PLAY("1"),
	END("2");

	private String type;

	GameStateType(String type) {
		this.type = type;
	}

	public static GameStateType of(String gameState) {
		if (PLAY.getType().equals(gameState)) {
			return PLAY;
		}
		return END;
	}

	public static boolean isValidType(String gameState) {
		return PLAY.getType().equals(gameState) || END.getType().equals(gameState);
	}

	public boolean isPlay() {
		return this.equals(PLAY);
	}

	public boolean isEnd() {
		return this.equals(END);
	}

	public String getType() {
		return this.type;
	}
}
