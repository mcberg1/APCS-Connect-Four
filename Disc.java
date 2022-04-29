package ConnFour;

public class Disc {
    boolean _player = false;
    boolean _playerSet = false;
    Disc() {
    }

    public void setPlayer(boolean player) {
        _player = player;
        _playerSet = true;
    }
    public boolean getPlayer() {
        return _player;
    }

    public boolean isPlayerSet() {
        return _playerSet;
    }
}
