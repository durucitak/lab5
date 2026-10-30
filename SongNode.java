/**
 * SongNode.java
 * Duru ÇITAK 250444015
 *
 * Represents a song of a playlist.
 */
public class SongNode {

    String title;
    SongNode prev;
    SongNode next;

    public SongNode(String title) {
        this.title = title;
        this.prev = null;
        this.next = null;
    }
}