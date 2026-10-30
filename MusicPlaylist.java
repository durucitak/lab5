/**
 * MusicPlaylist.java
 *
 * Represents the doubly linked list for the music playlist.
 */
public class MusicPlaylist {

    // private instances of the doubly linked list:
    private SongNode head;
    private SongNode tail;
    private SongNode current;

    // constructor
    public MusicPlaylist() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    // Add a song to the end of the playlist
    public void addSong(String title) {
        SongNode newNode = new SongNode(title);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove a song from the playlist
    public void removeSong(String title) {
        SongNode temp = head;

        // Search for the song
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }

        System.out.println("Removed: " + temp.title);

        // Handle removing the current song
        if (temp == current) {
            if (current.next != null) {
                current = current.next;
            } else {
                current = current.prev;
            }
        }

        // Handle removing head
        if (temp == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List becomes empty
            }
        }
        // Handle removing tail
        else if (temp == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        }
        // Handle removing a node in the middle
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Move to the next song
    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the last song of the playlist.");
        }
    }

    // Move to the previous song
    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }

    // Display the current song
    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        } else {
            System.out.println("Playlist is empty.");
        }
    }

    // Display all songs
    public void displayPlaylist() {
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}