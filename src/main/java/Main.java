import baseballgame.BaseBallGame;

public class Main {
	public static void main(String[] args) {
		BaseBallGame baseBallGame = new BaseBallGame();
		baseBallGame.createProblemNumbers();

		while (baseBallGame.isPlaying()) {
			baseBallGame.receiveAnswerNumbers();
			baseBallGame.countStrikesAndBalls();
			baseBallGame.printCountResults();
			baseBallGame.confirmCorrectAnswer();
		}
	}
}
