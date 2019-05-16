package hello.utilities;

public class Channel {
    String hyperlink;
    int ID;

    public Channel(String hyperlink, int ID) {
        this.hyperlink = hyperlink;
        this.ID = ID;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public int getID() {
        return ID;
    }
}
