package ConnFour;

public class Disc {
    boolean _player = false;
    boolean _playerSet = false;
    Disc[] adjacentDiscs = new Disc[5];

    Disc() {
    }

    Disc(Disc l, Disc r, Disc d, Disc ld, Disc rd) {
        adjacentDiscs[0] = l;
        adjacentDiscs[1] = ld;
        adjacentDiscs[2] = d;
        adjacentDiscs[4] = rd;
        adjacentDiscs[3] = r;

    }

    Disc(boolean player) {
        _player = player;
        _playerSet = true;
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

    public int checkAllAdjacentDiscs(int start) {
        for (int i = start; i < adjacentDiscs.length; i++) {
            if (adjacentDiscs[i] != null && adjacentDiscs[i].getPlayer() == _player && adjacentDiscs[i].isPlayerSet())
                return i;
        }
        return -1;
    }

    public Disc checkAdjacentDisc(int i) {
        if (adjacentDiscs[i] != null && adjacentDiscs[i].getPlayer() == _player && adjacentDiscs[i].isPlayerSet())
            return adjacentDiscs[i];
        else
            return null;
    }
}
